package com.chimu.utils.tools;

import com.chimu.utils.Constant;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileGlobal {
    public static String AddFile(MultipartFile file) throws Exception {
        if(file != null && !file.isEmpty()){
            Date date = new Date();
            String remote = Constant.Host;
            String local = Constant.SaveImagesLocalPath;

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHMMssSSS");

            String fileName = file.getOriginalFilename();
            String prefix = fileName.substring(fileName.lastIndexOf("."));

            File localFile = new File(local + "/" + sdf.format(date) + prefix);
            file.transferTo(localFile);

            return remote + sdf.format(date) + prefix;
        }
        return null;
    }

    public static boolean RemoveFile(String path) throws Exception {
        File file = new File(path);
        return file.exists() && file.delete();
    }
}
