package exception;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ExceptionHandlerResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView view  = new ModelAndView();
        FastJsonJsonView view1 =  new FastJsonJsonView();
        Map<String, Object> attributes = new HashMap<String, Object>();
// 判断是否是自己创建的异常
        if (ex instanceof BaseException) {
            BaseException businessException = (BaseException) ex;
            attributes.put("errorCode",businessException.getErrorCode());
            attributes.put("errorMsg",businessException.getErrorMsg());
        } else {
//不是自己创建的异常就简单处理下
            attributes.put("errorCode",3002);
            attributes.put("errorMsg",ex.getMessage());
        }
        view1.setAttributesMap(attributes);
        view.setView(view1);
        jsonp(request,response);
        return view;

    }
    protected void jsonp(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String origin = httpServletRequest.getHeader("Origin");
        httpServletResponse.setHeader("Access-Control-Allow-Origin", origin);
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACES");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
//        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
//        httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with");
    }


}
