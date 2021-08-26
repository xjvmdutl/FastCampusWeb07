package com.example.FastCampusWeb07.wishlist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pages")
public class PageController {
    @RequestMapping("/main")
    public ModelAndView main(){//화면을 연결해주는 ModelAndView
        return new ModelAndView("aaaa/main");//tmplates하위 경로
    }
}
