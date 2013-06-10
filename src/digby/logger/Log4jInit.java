package digby.logger;

import org.apache.log4j.PropertyConfigurator;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Log4jInit extends HttpServlet {
	public static  String prefix;
	public void init() {
		prefix = getServletContext().getRealPath("/");
		String file = getInitParameter("log4j-init-file");

		if (file != null) {
			PropertyConfigurator.configure(prefix + file);
		}
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res){
		
	}
}
