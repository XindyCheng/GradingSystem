package com.example.demo.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CMGradingDao;
import com.example.demo.dao.DMGradingDao;
import com.example.demo.dao.PMEntryDao;

/**
 * 此Service用于更新三张表之间的关系
 **/

@Service
public class RelationshipService {

    @Autowired
    @Resource
    private PMEntryDao entryDao;

    @Autowired
    @Resource
    private CMGradingDao cmDao;

    @Autowired
    @Resource
    private DMGradingDao dmDao;

    public int renewCM(Integer pm_id, Integer cm_id, Double cm_total) {
        return entryDao.updateCM(pm_id, cm_id, cm_total);
    }

    public int renewDM(Integer pm_id, Integer dm_id, Double dm_total) {
        return entryDao.updateDM(pm_id, dm_id, dm_total);
    }

}
