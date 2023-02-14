package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.model.Dot;
import web.service.DotsService;

import java.util.Date;
import java.util.List;

@RestController
public class DotsController {

    private DotsService service;

    @Autowired
    public DotsController(DotsService service) {
        this.service = service;
    }

    //todo: удалить бред с count
    @GetMapping("/getDots")
    @CrossOrigin(origins = { "http://localhost:3000" }, allowedHeaders = "*", allowCredentials = "true")
    public List<Dot> getDots(
            @RequestParam("leftLimit") int leftLimit,
            @RequestParam("rightLimit") int rightLimit,
            @RequestParam("count") int count
    ){
        List<Dot> result = service.getDots(leftLimit, rightLimit, count);
        return result;

    }

    @PostMapping("/saveDot")
    @ResponseBody
    @CrossOrigin(origins = { "http://localhost:3000" }, allowedHeaders = "*", allowCredentials = "true")
    public Dot saveDot(@RequestBody Dot dot) {
        return service.saveDot(dot);
    }



}
