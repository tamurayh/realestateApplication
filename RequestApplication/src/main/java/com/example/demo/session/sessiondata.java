package com.example.demo.session;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@Component
@SessionScope
@Data
public class sessiondata implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	

}
