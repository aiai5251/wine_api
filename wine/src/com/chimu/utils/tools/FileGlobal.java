package com.chimu.utils.tools;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileGlobal {
    private static void CreateDirectory(File file) {
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
    }

    public static String AddFile(MultipartFile file) throws Exception {
        if(file != null && !file.isEmpty()){
            Date date = new Date();
            String remote =  "http://localhost:9090/image";
            String local = "/Users/didi/Desktop/wineProject/wine_api/wine/WebRoot/WEB-INF/image";
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHMMssSSS");

            SimpleDateFormat year = new SimpleDateFormat("yyyy");
            SimpleDateFormat month = new SimpleDateFormat("MM");
            SimpleDateFormat day = new SimpleDateFormat("dd");

            String path = year.format(date) + "/" + month.format(date) + "/" + day.format(date);
            CreateDirectory(new File(local + "/" + path));

            String fileName = file.getOriginalFilename();
            String prefix = fileName.substring(fileName.lastIndexOf("."));

            File localFile = new File(local + "/" + path + "/" + sdf.format(date) + prefix);

            file.transferTo(localFile);

            return remote + "/" + path + "/" + sdf.format(date) + prefix;
        }

        return null;
    }

}
