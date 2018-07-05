package com.myboot.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by Administrator on 2018/2/26.
 */
@Controller
public class TestController {




    // localhost:8080/demo/view   试图传参
    //参数直接传到页面上
    @RequestMapping(value = "/view")
    public String modelTest(ModelMap model){
        model.addAttribute("name", "Mr.Lai");
        model.addAttribute("date",new Date());
        int k=99;
        System.out.println("------------->1111");
        System.out.println("mmmmmkkk");
        return  "demo/test";
    }

    //由接口的调用直接跳到相应的页面需要传参的操作
    @RequestMapping("redirect")
    public String redirect(){
        System.out.println("-->跳转页面内容   ");
        return "redirect:/redir";
    }


    @RequestMapping(value = "/redir")
    public String redir(){
        return  "redir";
    }

}
