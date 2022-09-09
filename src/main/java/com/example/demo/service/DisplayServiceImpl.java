package com.example.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DisplayDao;
import com.example.demo.entity.Display;

@Service
public class DisplayServiceImpl implements DisplayService {

    @Autowired
    @Resource
    private DisplayDao displayDao;

    public List<Display> getAll() {
        return displayDao.selectAll();
    }

    public int addDisplay(Display display) {
        Integer code = displayDao.insert(display);
        return code;
    }

    public Display getById(int id) {
        return displayDao.selectById(id);
    }

}
