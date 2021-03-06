package com.srv.rajaliv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @Autowired
    private StatusUpdateService statusUpdateService;

    @RequestMapping("/")
    ModelAndView home(ModelAndView modelAndView) {

        StatusUpdate statusUpdate = statusUpdateService.getLatest();

        modelAndView.getModel().put("statusUpdate", statusUpdate);

        modelAndView.setViewName("app.homepage");

        return modelAndView;
    }

    @RequestMapping("/about")
    String about() {
        return "app.about";
    }
}
