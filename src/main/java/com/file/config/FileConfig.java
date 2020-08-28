package com.file.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description //TODO 文件配置文件
 * @return
 **/
@ConfigurationProperties(prefix = "file")
@Component
public class FileConfig {

    //文件地址
    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
