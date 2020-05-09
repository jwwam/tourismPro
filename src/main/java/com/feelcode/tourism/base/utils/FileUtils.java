package com.feelcode.tourism.base.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/** 
 * @auther: 朱利尔
 * @Description: 
 * @date: 15:11 2020/5/8
 * @param: 
 * @return: 
 */
public class FileUtils {

    public static File getFileFromMultipartFile(MultipartFile file) throws Exception{
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件后缀
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        File rfile = null;
        rfile = File.createTempFile(UUIDUtils.getUuid(), prefix);
        file.transferTo(rfile);
        //程序结束时，删除临时文件
        //deleteFile(rfile);
        return rfile;
    }

    /**
     * 删除
     *
     * @param files
     */
    public static void deleteFile(File... files) {
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
        }
    }

}