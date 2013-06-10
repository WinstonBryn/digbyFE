package digby.status;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

import digby.logger.Log4jInit;
import digby.xacml.XacmlImpl;

import org.apache.log4j.Logger;

public class PIMonitor implements ContainerRequestFilter {

	static Logger log = Logger.getLogger(Log4jInit.class);

	@Override
	public ContainerRequest filter(ContainerRequest request) {
		// TODO Auto-generated method stub
		System.out.println("********");
		request.isUserInRole("admin");
		/*
		 * HashMap<String, Object> wrapper=new HashMap<String, Object>();
		 * wrapper=(HashMap<String, Object>) request.getProperties();
		 * System.out.println(wrapper);
		 */System.out.println(request.getRequestUri().toString());
		System.out.println(request.getAbsolutePath());
		System.out.println(request.getPath());
		log.info("**********");
		log.info("Request start");
		log.info("IpAddress: " + request.getHeaderValue("Ip-Addr"));
		log.info("User Role: " + request.getHeaderValue("User-Role"));
		log.info("Resource: " + request.getHeaderValue("Req-Resource"));
		log.info("Request URI: " + request.getRequestUri());
		log.info("Request Method: " + request.getMethod());

		System.out.println("Base URI" + request.getBaseUri().toString());
		System.out.println(request.getQueryParameters().toString());
		System.out.println(request.getPathSegments().toString());

		// Policy Call

		XacmlImpl imp = new XacmlImpl();

		if (request.getMethod().equalsIgnoreCase("PUT") && ("contacts_all").equalsIgnoreCase(request.getHeaderValue("Req-Resource")))
			imp.addModule("policy_put.xml", request.getHeaderValue("User-Role"),
					request.getHeaderValue("Req-Resource"),
					request.getMethod(), request.getPath());

		else if (request.getMethod().equalsIgnoreCase("GET")&& ("contacts_all").equalsIgnoreCase(request.getHeaderValue("Req-Resource")))
			imp.addModule("policy_get.xml",
					request.getHeaderValue("User-Role"),
					request.getHeaderValue("Req-Resource"),
					request.getMethod(), "v1/user/fe/adduser/admin/get/");

		log.info("Request end");
		return request;
	}

}
