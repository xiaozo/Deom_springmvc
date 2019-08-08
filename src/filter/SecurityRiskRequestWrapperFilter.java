package filter;

import other.ChangeRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityRiskRequestWrapperFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest)request;
        HttpServletResponse response1 =  (HttpServletResponse)response;
        ChangeRequestWrapper requestWrapper = new ChangeRequestWrapper( request1 );
        String [] sexs = new String[]{"sex"};
        requestWrapper.addParameter("sex",sexs);
        chain.doFilter(requestWrapper, response);

//        String URI =  request1.getRequestURI();
//        if (URI.equals("/api")) {
//
//            request.getRequestDispatcher("/param").forward(requestWrapper,response);
//        } else {
//            response1.sendError(300,"非法请求");
//        }


    }

    @Override
    public void destroy() {
    }

}
