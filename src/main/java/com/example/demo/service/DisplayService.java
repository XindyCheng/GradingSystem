package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Display;

public interface DisplayService {
    public List<Display> getAll();

    public int addDisplay(Display display);

    public Display getById(int id);

}
