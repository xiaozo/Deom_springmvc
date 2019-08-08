package controller;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.sun.net.httpserver.Authenticator;
import exception.BaseException;
import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping(value = "",produces = "application/json; charset=utf-8")
public class HelloController {

    @RequestMapping("/hello")
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("hello");
        mav.addObject("message", "Hello Spring MVC");
        return mav;
    }

    @RequestMapping("/form")
    public ModelAndView form(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("form");
        return mav;
    }

//    @RequestMapping("/param")
//    public ModelAndView getParam(HttpServletRequest request,
//                                 HttpServletResponse response) {
//
//        String userName = request.getParameter("userName");
//        String password = request.getParameter("password");
//
//        System.out.println(userName);
//        System.out.println(password);
//        return null;
//    }

    @ResponseBody
    @RequestMapping(value="/param")
    public String getParam(@Validated User user, BindingResult result) {

        if (result.hasErrors()) {
            List <ObjectError> allErros = result.getAllErrors();
            for (ObjectError objectError : allErros) {
                System.out.println(objectError.getDefaultMessage());
                throw new BaseException("-1",objectError.getDefaultMessage());
            }
        }
        String jsonString = JSON.toJSONString(user);
        return jsonString;



    }

    @RequestMapping(value="/exception" ,method = RequestMethod.GET)
    public ModelAndView exception() {

//        ModelAndView mv = new ModelAndView();
//        /*  使用FastJson提供的FastJsonJsonView视图返回，不需要捕获异常   */
//        FastJsonJsonView view = new FastJsonJsonView();
//        Map<String, Object> attributes = new HashMap<String, Object>();
//        attributes.put("code", "1000001");
//        attributes.put("msg", "msg");
//        view.setAttributesMap(attributes);
//        mv.setView(view);
//        return mv;
        BaseException exception = new BaseException("-1","测试异常");
        throw exception;
//        return null;


    }

}
