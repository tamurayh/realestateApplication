package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@Table(name="condition1")

public class condition1 {
	
	 /**
	   * No
	   */
	  @Id
	  @Column(name="No")
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private Long No;
	  
	  /**
	   * 第一希望 都道府県
	   */
	  @Column(name="Forst_Choice_Pretecture")
	  private String Forst_Choice_Pretecture;
	  
	  /**
	   * 第一希望 市町村
	   */
	  @Column(name="Forst_Choice_Ctiy")
	  private String Forst_Choice_Ctiy;
	  
	  /**
	   * 第二希望 都道府県
	   */
	  @Column(name="Second_Choice_Pretecture")
	  private String Second_Choice_Pretecture;
	  
	  /**
	   * 第二希望 市町村
	   */
	  @Column(name="Second_Choice_Ctiy")
	  private String Second_Choice_Ctiy;

	  /**
	   * 第三希望 都道府県
	   */
	  @Column(name="Third_Choice_Pretecture")
	  private String Third_Choice_Pretecture;

	  /**
	   * 第三希望 市町村
	   */
	  @Column(name="Third_Choice_Ctiy")
	  private String Third_Choice_Ctiy;
	  
	  /**
	   * 最小価格
	   */
	  @Column(name="Asking_price_min")
	  private String Asking_price_min;
	  /**
	   * 最大価格
	   */
	  @Column(name="Asking_price_max")
	  private String Asking_price_max;
	  /**
	   * 間取り数
	   */
	  @Column(name="Floop_Plon_num")
	  private String Floop_Plon_num;
	  /**
	   * 間取り
	   */
	  @Column(name="Floop_Plon")
	  private String Floop_Plon;	  
	  /**
	   * 諸条件1
	   */
	  @Column(name="Terms_and_Conditions1")
	  private String Terms_and_Conditions1;
	  
	  /**
	   * 諸条件2
	   */
	  @Column(name="Terms_and_Conditions2")
	  private String Terms_and_Conditions2;

	  /**
	   * 諸条件3
	   */

	  @Column(name="Terms_and_Conditions3")
	  private String Terms_and_Conditions3;

	  /**
	   * 諸条件4
	   */
	  @Column(name="Terms_and_Conditions4")
	  private String Terms_and_Conditions4;
	  
	  /**
	   * 諸条件5
	   */
	  @Column(name="Terms_and_Conditions5")
	  private String Terms_and_Conditions5;
	  
	  @Column(name="userid")
	  private Long userid;


}
