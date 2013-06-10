package digby.xacml;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServlet;

import com.sun.xacml.PDP;
import com.sun.xacml.PDPConfig;
import com.sun.xacml.ctx.RequestCtx;
import com.sun.xacml.ctx.ResponseCtx;
import com.sun.xacml.ctx.Result;
import com.sun.xacml.finder.AttributeFinder;
import com.sun.xacml.finder.PolicyFinder;
import com.sun.xacml.finder.impl.CurrentEnvModule;
import com.sun.xacml.finder.impl.FilePolicyModule;
import digby.logger.Log4jInit;
import org.apache.log4j.Logger;

public class XacmlImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Logger log=Logger.getLogger(Log4jInit.class);
	public void addModule(String policy,String subjectInput,String resourceInput, String actionInput, String environmentInput) {
		FilePolicyModule policyModule = new FilePolicyModule();
		String policyname=Log4jInit.prefix+"/"+policy;
		System.out.println(policy);
		policyModule
				.addPolicy(policyname);

		CurrentEnvModule envModule = new CurrentEnvModule();

		PolicyFinder policyFinder = new PolicyFinder();
		Set<FilePolicyModule> policyModules = new HashSet<FilePolicyModule>();
		policyModules.add(policyModule);
		policyFinder.setModules(policyModules);

		AttributeFinder attrFinder = new AttributeFinder();
		ArrayList<CurrentEnvModule> attrModules = new ArrayList<CurrentEnvModule>();
		attrModules.add(envModule);
		attrFinder.setModules(attrModules);

		PDP pdp = new PDP(new PDPConfig(attrFinder, policyFinder, null));

	
		try {
			
			try {
			RequestCtx req=	new RequestCtx(SetupAttributes.setupSubjects(subjectInput), SetupAttributes.setupResource(resourceInput), SetupAttributes.setupAction(actionInput), SetupAttributes.setupEnvironment(environmentInput));
			ResponseCtx response = pdp.evaluate(req);
			
			System.out.println("");
			response.encode(System.out);
			//ResponseCtx response = response.
			Iterator<Result> it=response.getResults().iterator();
			//response.getInstance(input);
			Map<String, Result> resultMap=new HashMap<String, Result>();
			while(it.hasNext()){
				Result res=it.next();
				
				resultMap.put(res.getResource(), res);
				if(res.getDecision()==0)
					log.info("Decision: DECISION_PERMIT");
				else if(res.getDecision()==1)
					log.info("Decision: DECISION_DENY");
				else if(res.getDecision()==2)
					log.info("Decision: DECISION_INDETERMINATE");
				else if(res.getDecision()==3)															
					log.info("Decision: DECISION_NOT_APPLICABLE");
				
				log.info("Status: "+res.getStatus().getCode());
			}
			
			
			
			
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
