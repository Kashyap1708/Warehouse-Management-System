package com.wms.warehouseMS.controller;

import com.wms.warehouseMS.entity.User;
import com.wms.warehouseMS.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/auth")

public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return jwtUtil.generateToken(user.getUsername());
    }
}
