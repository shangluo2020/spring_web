package com.demo.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private MessageSource messageSource;

    @PostMapping("/upload")
    public String upload(HttpServletRequest request,Model model) {
        if (request instanceof MultipartRequest) {
            //获取服务器上指定目录的绝对路径
            File dir = new File(request.getServletContext().getRealPath("/attachment"));
            System.out.println("文件保存目录：" + dir.getPath());
            if (!dir.exists()) {
                dir.mkdirs();
            }
            MultipartRequest multipartRequest = (MultipartRequest) request;
            Iterator<String> iterator = multipartRequest.getFileNames();
            String paraName;
            MultipartFile multipartFile;
            InputStream is = null;
            while (iterator.hasNext()) {
                paraName = iterator.next();
                List<MultipartFile> files = multipartRequest.getFiles(paraName);
                for (int i = 0; i < files.size(); i++) {
                    multipartFile = files.get(i);
                    System.out.println(multipartFile.getOriginalFilename());
                    try {
                        is = multipartFile.getInputStream();

                        FileUtils.copyInputStreamToFile(is, new File(dir, multipartFile.getOriginalFilename()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (is != null) {
                            try {
                                is.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }
            }
        }

        String msg=this.messageSource.getMessage("label.file.upload.success",null,request.getLocale());
        model.addAttribute("msg",msg);
        return "file/upload";
    }

    @GetMapping("/list")
    public String list(Model model, HttpServletRequest request) {
        //获取attachment目录下的文件，将数据对象保存在Model对象中
        File dir = new File(request.getServletContext().getRealPath("/attachment"));
        model.addAttribute("files", dir.listFiles());

        return "file/list";
    }


    @GetMapping("/download")
    public ResponseEntity<byte[]> download(String fileName, HttpServletRequest request) {

        File dir = new File(request.getServletContext().getRealPath("/attachment"));
        File file = new File(dir, fileName);
        ResponseEntity<byte[]> responseEntity = null;
        if (file.exists()) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try {
                FileUtils.copyFile(file, outputStream);
                byte[] bytes = outputStream.toByteArray();
                HttpHeaders headers = new HttpHeaders();
                String encodingFileName = URLEncoder.encode(fileName, "utf-8");
                headers.setContentLength(file.length());
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                headers.put("Content-Disposition", Arrays.asList("attachment;fileName=" + encodingFileName + ";filename*=utf-8''" + encodingFileName));

                responseEntity = new ResponseEntity<>(bytes, headers, HttpStatus.OK);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return responseEntity;
    }

}
