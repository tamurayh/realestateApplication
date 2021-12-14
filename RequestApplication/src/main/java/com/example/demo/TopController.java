package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class TopController {


    @RequestMapping("/top")
    public String top() {

    return "top";
    }
    
    @RequestMapping("/newregistration")
    public String newregistration() {
    	
    	return "newregistration";
    }
    
    
}