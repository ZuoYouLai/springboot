package com.myboot.demo.Controller;

import com.myboot.demo.entity.InterfaceTabl;
import com.myboot.demo.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/sql")
public class SqlController {

    @Autowired
    private InterfaceService interfaceService;


    /**
     *   总结：

     1、@RequestBody需要把所有请求参数作为json解析，因此，不能包含key=value这样的写法在请求url中，所有的请求参数都是一个json

     2、直接通过浏览器输入url时，@RequestBody获取不到json对象，需要用java编程或者基于ajax的方法请求，将Content-Type设置为application/json
     * @param resultMap
     * @return
     */
    @RequestMapping(value = "/add1",method = RequestMethod.GET)
    public  String doMapper(@RequestBody Map<String,Object> resultMap){
        String content=resultMap.get("content").toString();
        String name=resultMap.get("name").toString();
        InterfaceTabl one=new InterfaceTabl();
        one.setContent(content);
        one.setName(name);
        int size=interfaceService.insert(one);
        return "已经插入数据条数---->"+size;
    }


    /**
     * 动态的传入参数内容
     * @param name
     * @param content
     * @return
     */
    @RequestMapping(value = "/add2",method = RequestMethod.GET)
    public  String doMapper2(
            @RequestParam(name = "name",defaultValue = "",required = true) String name,
            @RequestParam(name = "content",defaultValue = "",required = true) String content){
        InterfaceTabl one=new InterfaceTabl();
        one.setContent(content);
        one.setName(name);
        int size=interfaceService.insert(one);
        return "已经插入数据条数KKKKKKKKKKKKK"+size;
    }










}
