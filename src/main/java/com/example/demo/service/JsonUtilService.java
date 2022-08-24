package com.example.demo.service;

import java.io.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

/**
 * 读取json文件
 * 主要用于把单位列表导入数据库
 */
@Service
public class JsonUtilService {
 
    @Value("classpath:static/departments.json")
    public Resource resource;
 
    private String jsonRead(File file) throws IOException{
        BufferedReader reader = null;
        StringBuilder buffer = new StringBuilder();
        reader = new BufferedReader(new FileReader(file));
        String line = "";
        while ((line = reader.readLine()) != null){
            buffer.append(line);
        }
        reader.close();
        return buffer.toString();
    }
    
    /**
     * 对外接口
     */
    public String getData(){
        try {
            File file = resource.getFile();
            String jsonData = this.jsonRead(file);
            return jsonData;
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * 由于上述方式打成jar包很有可能读取不到数据
     * 因此修改 Json 文件的读取方式
     */
    public static String getFileJson() throws IOException {
    	 
        ClassPathResource classPathResource = new ClassPathResource("static/departments.json");
        byte[]  bytes= FileCopyUtils.copyToByteArray(classPathResource.getInputStream());
        return new String(bytes);
    }
}