package com.rushiwarade.registrationfile_uploadspringboot.controller;

import com.rushiwarade.registrationfile_uploadspringboot.model.Register;
import com.rushiwarade.registrationfile_uploadspringboot.service.UploadService;
import com.rushiwarade.registrationfile_uploadspringboot.utils.FileUtils;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
@RequestMapping("/register")
public class uploadController {
    @Autowired
    UploadService uploadService;

    @Autowired
    FileUtils fileUtils;

    private static final String UPLOAD_DIR = "/src/main/resources/static/upload/";


    @GetMapping
    public String home() {

        return "home";
    }

    @PostMapping
    public String register(@ModelAttribute Register register, @RequestParam("file") MultipartFile file, HttpSession session, Model model) throws IOException {
        if (!file.isEmpty() && register != null) {
            try {

//            check file extension
                String contentType = file.getContentType();
                if ("image/png".equals(contentType) || "image/jpg".equals(contentType) || "image/jpeg".equals(contentType)) {

                    // Check if the file size is at least 3MB
                    long fileSizeInBytes = file.getSize();
                    double fileSizeInMB = (double) fileSizeInBytes / (1024 * 1024);
                    if (fileSizeInMB > 3) {
                        session.setAttribute("danger", "File size should be at least 2MB.");
                        return "redirect:/register";
                    }

//                    set unique file name
                    String uniqueFileName = UUID.randomUUID().toString();
                    String fileExtension = fileUtils.getFileExtension(file.getOriginalFilename());
                    String newFileName = uniqueFileName + "." + fileExtension;


//                    check if dir not exist create them.
                    Path uploadDir = Paths.get(System.getProperty("user.dir"), UPLOAD_DIR);
                    if (!Files.exists(uploadDir)) {
                        Files.createDirectories(uploadDir);
                    }

//                        set the new file name
                    register.setFileName(newFileName);
//                        get email to validate already exists
                    String email = register.getEmail();

                    boolean b = uploadService.validateEmail(email);
                    if (b) {
                        session.setAttribute("danger", "This email already exists!...");
                        return "redirect:/register";
                    }

//                        Execute the method
                    Register uploadData = uploadService.register(register);
                    if (uploadData != null) {

//                    move to upload dir
                        Path filePath = Paths.get(uploadDir.toString(), newFileName);
                        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                        session.setAttribute("success", "Image & Data Uploaded Successfully!...");
                        return "redirect:/register";
                    }

                } else {
                    session.setAttribute("danger", "Only JPG and PNG images are allowed.");
                    return "redirect:/register";
                }
            } catch (IOException e) {
                session.setAttribute("danger", "Error processing the registration." + e.getMessage());
                return "redirect:/register";
            }

        } else {
            session.setAttribute("danger", "Please Fill all the filds");
            return "redirect:/register";
        }

        return "redirect:/register";
    }

    @GetMapping("/profile")
    public String login() {

        return "login";
    }

    @PostMapping("/profile")
    public String viewProfile(@RequestParam("email") String email, @RequestParam("password") String pass, HttpSession session, Model model) {
        System.out.println(email);
        System.out.println(pass);

        Register register = uploadService.validateUser(email, pass);

        if (register != null) {
            model.addAttribute("profile", register);
            session.setAttribute("userData", register);
            return "viewProfile";
        } else {
            session.setAttribute("danger", "Invalid Email or Password");
            return "redirect:/register/profile";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.removeAttribute("data");
        return "redirect:/register";
    }


}
