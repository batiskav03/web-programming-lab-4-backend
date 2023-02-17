package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import web.model.Dot;
import web.service.DotsService;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DotsController {



    private DotsService service;

    @Autowired
    public DotsController(DotsService service) {
        this.service = service;
    }

    //todo: удалить бред с count
    @GetMapping("/getDots")
    public List<Dot> getDots(
            @RequestParam("leftLimit") int leftLimit,
            @RequestParam("rightLimit") int rightLimit

    ){
        List<Dot> result = service.getDots(leftLimit, rightLimit);
        return result;

    }

    @PostMapping("/saveDot")
    @ResponseBody
    public Dot saveDot(@RequestBody Dot dot, Principal principal) {
        dot.setUser(principal.getName());
        return service.saveDot(dot);
    }

    @PostMapping("/getOwnDots")
    public List<Dot> getOwnDots() {
        return service.getOwnDots();
    }


}
