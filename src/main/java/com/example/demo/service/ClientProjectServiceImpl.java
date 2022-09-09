package com.example.demo.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClientProjectDao;
import com.example.demo.entity.ClientProject;

@Service
public class ClientProjectServiceImpl implements ClientProjectService {
    @Autowired
    @Resource
    private ClientProjectDao projectDao;

    public int add(ClientProject project) {
        Date date = new Date();
        project.setTime(date);
        Integer insert_code = 0;
        final Log log = LogFactory.getLog(PMEntryServiceImpl.class);
        log.info(project);
        insert_code = projectDao.insert(project);
        return insert_code;
    }

    public List<ClientProject> getAll() {
        return projectDao.selectAll();
    }
}
