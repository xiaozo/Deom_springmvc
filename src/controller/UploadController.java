package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UploadController {
    @RequestMapping("/upload")
    public void upload(@RequestParam("testImg") MultipartFile picture, HttpServletRequest request, HttpSession session) throws Exception {
                if(!picture.isEmpty()) {
                    // 文件存放路径
                    String path = request.getServletContext().getRealPath("/");
            // 文件名称
            System.out.println(path);
        }
        System.out.println(picture.getOriginalFilename());
    }

    @RequestMapping("/test2")
    public ModelAndView upload() {
        return new ModelAndView("upload");
    }

}
