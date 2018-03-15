package com.myboot.demo.service.impl;

import com.myboot.demo.dao.InterfaceTablMapper;
import com.myboot.demo.entity.InterfaceTabl;
import com.myboot.demo.service.InterfaceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class InterfaceServiceImpl implements InterfaceService{

    @Autowired
    private InterfaceTablMapper interfaceTablMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long interfaceId) {
        return interfaceTablMapper.deleteByPrimaryKey(interfaceId);
    }

    @Transactional
    @Override
    public int insert(InterfaceTabl record) {
        int size=0;
        // 空值判断，主要是判断areaName不为空
        if(!StringUtils.isEmpty(record.getName()) && !StringUtils.isEmpty(record.getContent())){
            record.setCreatedAt(new Date());
            record.setUpdatedAt(new Date());
            size=interfaceTablMapper.insert(record);
        }else{
            throw new RuntimeException("接口信息不能为空");
        }
        return size;
    }

    @Override
    public InterfaceTabl selectByPrimaryKey(Long interfaceId) {
        return interfaceTablMapper.selectByPrimaryKey(interfaceId);
    }

    @Override
    public List<InterfaceTabl> selectAll() {
        return interfaceTablMapper.selectAll();
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(InterfaceTabl record) {
        return 0;
    }
}
