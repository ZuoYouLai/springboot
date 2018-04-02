package com.myboot.demo.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StrController {


    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "This is spring boot test...devToools is test....";
    }




}
