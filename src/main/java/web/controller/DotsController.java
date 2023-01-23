package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import web.Dot;
import web.service.DotsService;

import java.util.List;

@RestController
public class DotsController {

    private DotsService service;

    @Autowired
    public DotsController(DotsService service) {
        this.service = service;
    }

    @PostMapping("/getDots")
    public List<Dot> getDots(
            @RequestBody int leftLimit,
            @RequestBody int rightLimit
    ){
        return service.getDots(leftLimit, rightLimit);
    }

    @PostMapping("/saveDot")
    public void saveDot(@RequestBody Dot dot) {
        service.saveDot(dot);
    }


    public boolean validateDot() {
        return true;
    }

}
