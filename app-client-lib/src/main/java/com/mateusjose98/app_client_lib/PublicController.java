package com.mateusjose98.app_client_lib;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/public")
public class PublicController {

    @GetMapping
    public String hello() {
        return "isto é público!";
    }
}
