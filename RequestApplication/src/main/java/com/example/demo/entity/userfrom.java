package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Id;

import lombok.Data;

/**
 * ユーザー情報 Entity
 */
@Data

public class userfrom implements Serializable{
	
	 /**
	   * ID
	   */
	  @Id
	  private Long id;
	
	

}
