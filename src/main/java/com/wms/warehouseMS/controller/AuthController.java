package com.wms.warehouseMS.controller;

import com.wms.warehouseMS.entity.User;
import com.wms.warehouseMS.security.JwtsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtsUtil jwtsUtil;

    public String login(@RequestBody User user){
        return jwtsUtil.generateToken(user.getUsername());
    }
}
