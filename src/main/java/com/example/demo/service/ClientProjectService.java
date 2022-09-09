package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ClientProject;

public interface ClientProjectService {
    public int add(ClientProject project);

    public List<ClientProject> getAll();

}
