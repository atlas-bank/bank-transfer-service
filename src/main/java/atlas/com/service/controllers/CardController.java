package atlas.com.service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {
    @GetMapping("/check-status")
    public String checkStatus(){
        return "OK";
    }
}
