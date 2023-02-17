package web.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class StaticService {

    public String getLoginPage() {
        return "index";
    }
}
