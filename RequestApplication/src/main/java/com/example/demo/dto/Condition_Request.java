package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.Size;

import lombok.Data;
	
	/**
	 * 条件情報 リクエストデータ
	 */
	@Data
	public class Condition_Request implements Serializable {
	  /**
	   * 第一希望 県
	   */
	  @Size(max = 5, message = "第一希望の都道府県を選択してください")
	  private String Forst_Choice_Pretecture;
	  /**
	   * 第一希望 市
	   */
	  @Size(max = 5, message = "第一希望の市町村を選択してください")
	  private String Forst_Choice_Ctiy;
	  /**
	   * 第二希望 県
	   */
	  @Size(max = 5,message = "第二希望の都道府県を選択してください")
	  private String Second_Choice_Pretecture;
	  /**
	   * 第二希望 市
	   */
	  @Size(max = 5,message = "第二希望の市町村を選択してください")
	  private String Second_Choice_Ctiy;
	  /**
	   * 第三希望 県
	   */
	  @Size(max = 5,message = "第三希望の都道府県を選択してください")
	  private String Third_Choice_Pretecture;
	  /**
	   * 第三希望 市
	   */
	  @Size(max = 5,message = "第三希望の市町村を選択してください")
	  private String Third_Choice_Ctiy;
	  /**
	   * 希望価格最小
	   */
	  @Size(max = 10,message = "希望最小価格を入力してください")
	  private String Asking_price_min;
	  /**
	   * 希望価格最大
	   */
	  @Size(max = 10,message = "希望最大価格を入力してください")
	  private String Asking_price_max;
	  /**
	   * 間取り数
	   */
	  @Size(max = 2,message = "間取り数を入力してください")
	  private String Floop_Plon_num;
	  /**
	   * 間取り
	   */
	  @Size(max = 3,message = "間取りを入力してください")
	  private String Floop_Plon;
	  /**
	   * 諸条件1
	   */
	  @Size(max = 10,message = "諸条件を入力してください")
	  private String Terms_and_Conditions1;
	  /**
	   * 諸条件2
	   */
	  @Size(max = 10,message = "諸条件を入力してください")
	  private String Terms_and_Conditions2;
	  /**
	   * 諸条件3
	   */
	  @Size(max = 10,message = "諸条件を入力してください")
	  private String Terms_and_Conditions3;
	  /**
	   * 諸条件4
	   */
	  @Size(max = 10,message = "諸条件を入力してください")
	  private String Terms_and_Conditions4;
	  /**
	   * 諸条件5
	   */
	  @Size(max = 10,message = "諸条件を入力してください")
	  private String Terms_and_Conditions5;
	  
	  private Long userid;
	 
	
	}

