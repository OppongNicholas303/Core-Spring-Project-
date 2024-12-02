package com.spring.lab;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseStatus(HttpStatus.ACCEPTED)
public class FirstController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, this is my first controller!";
    }

    @PostMapping("/order")
    public String myOrder(@RequestBody Order order) {
        System.out.println("Received Order: " + order);
        return order.toString();
    }

    @GetMapping("/order/{userName}")
    public String pathVariable(
       @PathVariable String userName
    ){
        return  userName;
    }

    @GetMapping("y")
    public  String y(){
        return "hell";
    }


    @GetMapping("/order")
    public String reqVar(
            @RequestParam("user-name") String userName,
            @RequestParam("first-name") String firstName
    ){
        return  userName + " " + firstName;
    }


}