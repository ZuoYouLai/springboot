package com.myboot.demo.service;

import com.myboot.demo.entity.InterfaceTabl;

import java.util.List;

public interface InterfaceService {

    int deleteByPrimaryKey(Long interfaceId);

    int insert(InterfaceTabl record);

    InterfaceTabl selectByPrimaryKey(Long interfaceId);

    List<InterfaceTabl> selectAll();

    int updateByPrimaryKey(InterfaceTabl record);
}
