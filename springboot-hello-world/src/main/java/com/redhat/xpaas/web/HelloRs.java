package com.redhat.xpaas.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
@Controller
public class HelloRs {
    @GetMapping("/")
    @ResponseBody
    public String helloWorld() {
        return "Hello world!";
    }
}
