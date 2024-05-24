package com.rushiwarade.attedancetrackerspringboot.controller;

import com.rushiwarade.attedancetrackerspringboot.dao.UploadDao;
import com.rushiwarade.attedancetrackerspringboot.model.Student;
import com.rushiwarade.attedancetrackerspringboot.service.UploadService;
import com.rushiwarade.attedancetrackerspringboot.utils.FileUtils;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Controller
//@RequestMapping(name = "/student")
public class StudentController {
    @Autowired
    FileUtils fileUtils;

    @Autowired
    UploadDao uploadDao;

    private static final String UPLOAD_DIR = "/src/main/resources/static/upload/";


    @GetMapping("/")
    public String home(Model model) {
        List<Student> files = (List<Student>) uploadDao.findAll();
        model.addAttribute("files", files);
        return "home";
    }


    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, HttpSession session) throws IOException {

        if (!file.isEmpty()) {

//            check file extension
            String contentType = file.getContentType();
            if ("image/png".equals(contentType) || "image/jpg".equals(contentType) || "image/jpeg".equals(contentType)) {


                // Check if the file size is at least 3MB
                long fileSizeInBytes = file.getSize();
                double fileSizeInMB = (double) fileSizeInBytes / (1024 * 1024);
                if (fileSizeInMB < 3) {

                    String uniqueFileName = UUID.randomUUID().toString();
                    String fileExtension = fileUtils.getFileExtension(file.getOriginalFilename());
                    String newFileName = uniqueFileName + "." + fileExtension;

                    Student student = new Student();
                    student.setFile(newFileName);

                    Student UploadFile = uploadDao.save(student);

                    Path uploadDir = Paths.get(System.getProperty("user.dir"), UPLOAD_DIR);
                    if (!Files.exists(uploadDir)) {
                        Files.createDirectories(uploadDir);
                    }
                    if (UploadFile != null) {
                        Path filePath = Paths.get(uploadDir.toString(), newFileName);
                        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                        session.setAttribute("msg", "image Uploaded Successfully");
                    }
                    return "redirect:/";
                } else {
                    session.setAttribute("msg", "File size should be at least 3MB.");
                    return "redirect:/";
                }
            } else {
                session.setAttribute("msg", "Only JPG and PNG images are allowed.");
                return "redirect:/";
            }

        } else {
            session.setAttribute("msg", "please select file for upload");
            return "redirect:/";
        }

    }


    @GetMapping("/delete/{id}")
    public String deleteImage(@PathVariable("id") Integer id, HttpSession session) throws IOException {
        // Retrieve the student record from the database
        Student student = uploadDao.findById(id).orElse(null);

        if (student != null) {
            String fileName = student.getFile();

            // Delete the record from the database
            uploadDao.deleteById(id);

            // Delete the file from the folder
            Path filePath = Paths.get(System.getProperty("user.dir"), UPLOAD_DIR, fileName);
            try {
                Files.deleteIfExists(filePath);
                session.setAttribute("msg", "Image deleted successfully");
            } catch (IOException e) {
                e.printStackTrace();
                session.setAttribute("msg", "Failed to delete the image file");
            }
        } else {
            session.setAttribute("msg", "Image with ID " + id + " not found");
        }

        return "redirect:/";
    }


}
