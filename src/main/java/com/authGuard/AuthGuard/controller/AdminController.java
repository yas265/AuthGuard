package com.authGuard.AuthGuard.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/")
    @ResponseBody
    public String test()
    {
        return "admin portal";
    }


    @PutMapping("/rolechange/{id}/{role}")
    public String changeRole()
    {
        return "Role has been changed";
    }



}
