package com.baik.libraryapp.controller;

import com.baik.libraryapp.requestmodels.AddBookRequest;
import com.baik.libraryapp.service.AdminService;
import com.baik.libraryapp.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @PostMapping("/secure/add/book")
    public void postBook(@RequestHeader(value = "Authorization") String token,
                         @RequestBody AddBookRequest addBookRequest) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
//        if(userEmail == null || !userEmail.equals("admin")) {
//            throw new Exception("Administrator only");
//        }

        adminService.postBook(addBookRequest);

    }

}
