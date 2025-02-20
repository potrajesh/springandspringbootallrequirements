package com.cts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class FIleUploadController {


    @GetMapping("/index")
    public String upload() {
        return "upload";
    }

    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file ) {
        String fileName = file.getOriginalFilename();

        try {
            file.transferTo( new File("D:\\upload\\" + fileName));
        } catch (Exception e) {
            System.out.println("unable to upload file");
        }
        return ResponseEntity.ok("File uploaded successfully.");

    }

}
