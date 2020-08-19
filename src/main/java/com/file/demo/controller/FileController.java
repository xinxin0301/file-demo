package com.file.demo.controller;

import com.file.demo.config.FileConfig;
import com.file.demo.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;

/**
 * @ClassName FileController
 * @Description TODO
 * @Author zxx
 * @Date DATE{TIME}
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/file")
public class FileController {

    @Autowired
    private FileConfig fileConfig;

    /**
     * @Description //TODO  文件下載
     * @Date 15:49 2020/8/19
     * @Param
     * @param newFileName           新文件名
     * @param originalFileName      旧文件名
     * @param response
     * @return void
     **/
    @GetMapping(value = "/download/file/{new_file_name:.+}/{original_file_name:.+}")
    public void download(@PathVariable(value = "new_file_name") String newFileName, @PathVariable(value = "original_file_name") String originalFileName, HttpServletResponse response) {
        //文件储存地址
        String filePath = fileConfig.getFilePath();
        filePath = "C:/uploadPath";
        FileUtil.downFile(response, newFileName, originalFileName, filePath);
    }

    /**
     * @param response
     * @return void
     * @Description //TODO 下载Zip包
     **/
    @GetMapping(value = "/download/zip")
    public void downloadZip(HttpServletResponse response) {
        //文件储存地址
        String filePath = fileConfig.getFilePath();
        filePath = "C:/uploadPath";

        List<File> fileList = new ArrayList<>();
        fileList.add(new File(filePath + File.separator + "1597043823024.docx"));
        fileList.add(new File(filePath + File.separator + "自查工作总结.docx"));
        //生成ZIP地址
        String zipPath = filePath + "/" + "结果包.zip";
        //生成ZIP包
        FileUtil.zipFile(fileList, zipPath);
        //下载ZIP包
        FileUtil.downFile(response, "结果包.zip", "新结果结果包名称.zip", filePath);
        //删除文件
        FileUtil.deleteFile(zipPath);
    }


    /**
     * @param request
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * form-data 传参方式 fileName
     * @Param 文件上传
     **/
    @RequestMapping(value = "/multifileUpload", method = RequestMethod.POST)
    public List<Map<String, Object>> multifileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("fileName");
        //文件儲存地址
        String filePath = fileConfig.getFilePath();
        filePath = "C:/uploadPath";
        return FileUtil.FileUpload(files, filePath);
    }


}
