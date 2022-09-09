package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.PMEntry;

public interface PMEntryService {
    public int insertEntry(PMEntry entry);

    public PMEntry getById(int id);

    public List<PMEntry> getAll();

}
