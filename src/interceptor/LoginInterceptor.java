package interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import other.ChangeRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    /**
     * preHandle方法
     * 1、preHandle方法将在处理用户请求之前进行调用
     * 2、在一个请求中可以同时存在多个Interceptor ，每个Interceptor 的调用会依据它的声明顺序依次执行，而且最先执行的都是Interceptor 中的preHandle 方法。
     * 3、由于2的特性，故可以在preHandle方法中进行一些前置初始化操作或者是对当前请求的一个预处理，也可以在这个方法中进行一些判断来决定请求是否要继续进行下去。
     * 4、preHandle方法的返回值是Boolean类型的，当它返回为false 时，表示请求结束，后续的Interceptor 和Controller 都不会再执行；
     * 当返回值为true 时就会继续调用下一个Interceptor 的preHandle 方法，如果已经是最后一个Interceptor 的时候就会是调用当前请求的Controller 方法。
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (request instanceof ChangeRequestWrapper) {
            System.out.println("me is ChangeRequestWrapper.class");
        }
        System.out.println("preHandle在处理请求之前被执行了");
        return true;
//        return false;//改成false才能实现拦截请求
    }

    /**
     * postHandle方法
     * 1、 postHandle方法，只能是在当前所属的Interceptor 的preHandle 方法的返回值为true 时才能被调用。
     * 2、postHandle 方法，顾名思义就是在当前请求进行处理之后，也就是Controller 方法调用之后执行，但是它会在DispatcherServlet 进行视图返回渲染之前被调用。
     * 3、可以在postHandle方法中对Controller 处理之后的ModelAndView 对象进行操作。
     * 4、postHandle 方法被调用的方向跟preHandle 是相反的，也就是说先声明的Interceptor 的postHandle 方法反而会后执行。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        System.out.println("postHandle是在Controller 方法调用之后，在DispatcherServlet 进行视图返回渲染之前被执行");
        super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * afterCompletion方法
     * 1、afterCompletion方法也是需要当前对应的Interceptor 的preHandle 方法的返回值为true 时才会执行。
     * 2、afterCompletion方法将在整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图之后执行。
     * 3、afterCompletion方法的主要作用是用于进行资源清理工作的。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

        System.out.println("afterCompletion在请求结束后被执行");
        super.afterCompletion(request, response, handler, ex);
    }


}
