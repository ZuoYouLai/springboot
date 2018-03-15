package com.myboot.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/2/26.
 */
@RestController
public class TestController {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "This is spring boot test...devToools is test....";
    }




    // localhost:8080/demo/view   试图传参
    //参数直接传到页面上
    @RequestMapping(value = "/view",method = RequestMethod.GET)
    public String modelTest(Model model){
        model.addAttribute("name", "Mr.Lai");
        int k=99;
        System.out.println("------------->99992211");
        System.out.println("mmmmm");
        return  "demo/test";
    }



    @RequestMapping(value = "/redirect",method = RequestMethod.GET)
    public String redirect(){
        int k=0;
        return "redirect7777777";
    }
}
