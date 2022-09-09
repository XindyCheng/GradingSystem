package com.example.demo.service;

import com.example.demo.entity.DMGrading;

public interface DMGradingService {
    public int add(DMGrading grading);

    public double getTotalById(int id);
}
