

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class OuputFormatFilter implements javax.servlet.Filter{
	
	String dispatchURL="/index.jsp";
	
	public void doFilter(final ServletRequest request,final ServletResponse response, FilterChain chain)throws IOException, ServletException {

		HttpServletRequest httpRequest = ((HttpServletRequest) request);
		HttpServletResponse httpResponse = ((HttpServletResponse) response);		
		String Incoming_Url = httpRequest.getRequestURI().trim();					
		if (Incoming_Url.matches("/.*/")) {
			RequestDispatcher request_Dispatcher = request.getRequestDispatcher(dispatchURL);
			request_Dispatcher.forward(request, response);			
		}
		else if(Incoming_Url.equals("/EasySmartCare") || Incoming_Url.equals("/InternationalMedicalPassport") ||Incoming_Url.equals("/Integration")||Incoming_Url.equals("/InternalDocumentation"))
		{				
			httpResponse.sendRedirect(httpRequest.getContextPath()+"/");					
		}
		else {
			chain.doFilter(request, response);
		}
	}
	
	public void destroy() {
			
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	
		
	}

}	