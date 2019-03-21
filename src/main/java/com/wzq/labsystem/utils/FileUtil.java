package com.wzq.labsystem.utils;


import com.wzq.labsystem.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 文件上传
 * 2019-03-13
 */
@Component
public class FileUtil {

    //获取配置文件的路径
    @Value("${fileUpload.location.path}")
    private String resourceDir;

    //获取返回的IP
    @Value("${localip}")
    private String localIp;


    /**
     * 单文件上传
     * @param file
     * @return
     */
    public String fileUpload(MultipartFile file) {
        if(null == file) throw new ServiceException(501, "上传的文件为空！");
        // 获取原文件名
        String originalFilename = file.getOriginalFilename();
        // 获取上传文件的后缀
        String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        // 设置上传文件路径
        String uploadPath = resourceDir + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "/" + fileSuffix + "/";
        // 上传文件名
        String fileName = System.currentTimeMillis()  + new Random().nextInt(1000) + "-" + originalFilename;
        File savefile = new File(System.getProperty("user.dir").replace("\\","/") + uploadPath + "/" + fileName);
        if (!savefile.getParentFile().exists()) {
            savefile.getParentFile().mkdirs();
        }

        try {
            file.transferTo(savefile);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            throw new ServiceException(501, "文件上传错误！");
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServiceException(501, "文件上传错误，读写异常！");
        }
        return localIp + uploadPath + fileName;
    }

    /**
     * 批量上传
     * @param files
     * @return
     */
    public List<String> bacthFileUpload(MultipartFile[] files) {
        if((null == files) || (0 == files.length)) throw new ServiceException(501, "上传的文件为空！");
        List<String> list = new ArrayList<>();
        for (MultipartFile multipartFile : files) {
            String fileUrl = fileUpload(multipartFile);
            list.add(fileUrl);
        }
        return list;
    }

    /**
     * 删除文件
     * @param path
     * @return
     */
    public String delFile(String path) {
        String resultInfo = null;
//        int lastIndexOf = path.lastIndexOf("/");
//        String sb = path.substring(lastIndexOf + 1, path.length());
//        sb = "f:/image/" + sb;
        File file = new File(path);
        if (file.exists()) {
            if (file.delete()) {
                resultInfo =  "1-删除成功";
            } else {
                resultInfo =  "0-删除失败";
            }
        } else {
            resultInfo = "文件不存在！";
        }

        return resultInfo;
    }


    /**
     * 文件下载
     * @param request
     * @param response
     * @return
     */
    public String downloadFile(String fileName,HttpServletRequest request, HttpServletResponse response) {
        if (fileName != null) {
            //设置文件路径
            String realPath = "D://aim//";
            File file = new File(realPath , fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }




}
