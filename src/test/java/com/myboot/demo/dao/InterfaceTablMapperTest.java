package com.myboot.demo.dao;

import com.alibaba.fastjson.JSON;
import com.myboot.demo.entity.InterfaceTabl;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;




@RunWith(SpringRunner.class)
@SpringBootTest
public class InterfaceTablMapperTest extends TestCase {

    //通过spring容器注入Dao的实现类
//    @Autowire
    @Autowired
    private  InterfaceTablMapper interfaceTablMapper;

    public void testDeleteByPrimaryKey() throws Exception {

    }


    @Test
    public void testInsert() throws Exception {
        InterfaceTabl one=new InterfaceTabl();
        one.setContent("Mr>sam达");
        one.setCreatedAt(new Date());
        one.setName("第一个springboot的内容的测试值");
        one.setUpdatedAt(new Date());
        interfaceTablMapper.insert(one);
        System.out.print(one.getInterfaceId());
        System.out.println(JSON.toJSONString(one));
    }

    public void testSelectByPrimaryKey() throws Exception {

    }


    @Test
    public void testSelectAll() throws Exception {
        List<InterfaceTabl> list=interfaceTablMapper.selectAll();
        System.out.print(JSON.toJSONString(list));
    }



    public void testUpdateByPrimaryKey() throws Exception {

    }
}