package web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import web.service.StaticService;

@org.springframework.stereotype.Controller
public class Controller {

    private final StaticService service;

    public Controller(StaticService service) {
        this.service = service;
    }
    //todo:настроить реакт

    @GetMapping("/graph")
    public String getIndex() {
        return "index.html";
    }


    @GetMapping("/login")
    public String view() {
        return service.getLoginPage();
    }





}
