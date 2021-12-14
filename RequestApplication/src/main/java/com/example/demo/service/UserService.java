package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.Condition_Request;
import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.condition1;
import com.example.demo.entity.user;
import com.example.demo.repository.ConditionRepository;
import com.example.demo.repository.UserRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
  /**
   * ユーザー情報 Repository
   */
  @Autowired
  private UserRepository userRepository;
  /**
   * 条件情報 conditionRepository
   */
  @Autowired
  private ConditionRepository conditionRepository;
 /**
  * ユーザー情報 全検索
  * @return 検索結果
  */
  public List<user> searchAll() {
    return userRepository.findAll();
  }
  /**
   * ユーザー情報 主キー検索
   * @return 検索結果
   */
  public user findById(Long id) {
    return userRepository.findById(id).get();
  }
  
  /**
   * ユーザー情報 新規登録
   * @param user ユーザー情報
   */
  public void create(UserRequest userRequest) {
    Date now = new Date();
    user user = new user();
    user.setName(userRequest.getName());
    user.setAddress(userRequest.getAddress());
    user.setPhone(userRequest.getPhone());
    user.setCreateDate(now);
    user.setUpdateDate(now);
    userRepository.save(user);
  }
  
  /**
   * 希望条件 新規登録
 * @param id 
   * @param condition1 条件情報
   */
  public void conditioncreate(Condition_Request condition_Request, Long id) {
	  condition1 condition1 = new condition1();
	  condition1.setForst_Choice_Pretecture(condition_Request.getForst_Choice_Pretecture());
	  condition1.setForst_Choice_Ctiy(condition_Request.getForst_Choice_Ctiy());
	  condition1.setSecond_Choice_Pretecture(condition_Request.getSecond_Choice_Pretecture());
	  condition1.setSecond_Choice_Ctiy(condition_Request.getSecond_Choice_Ctiy());
	  condition1.setThird_Choice_Pretecture(condition_Request.getThird_Choice_Pretecture());
	  condition1.setThird_Choice_Ctiy(condition_Request.getThird_Choice_Ctiy());
	  condition1.setAsking_price_min(condition_Request.getAsking_price_min());
	  condition1.setAsking_price_max(condition_Request.getAsking_price_max());
	  condition1.setFloop_Plon_num(condition_Request.getFloop_Plon_num());
	  condition1.setFloop_Plon(condition_Request.getFloop_Plon());
	  condition1.setTerms_and_Conditions1(condition_Request.getTerms_and_Conditions1());
	  condition1.setTerms_and_Conditions2(condition_Request.getTerms_and_Conditions2());
	  condition1.setTerms_and_Conditions3(condition_Request.getTerms_and_Conditions3());
	  condition1.setTerms_and_Conditions4(condition_Request.getTerms_and_Conditions4());
	  condition1.setTerms_and_Conditions5(condition_Request.getTerms_and_Conditions5());
	  condition1.setUserid(id);
	  conditionRepository.save(condition1);	  
  }
  
  /**
   * ユーザー情報 更新
   * @param user ユーザー情報
   */
  public void update(UserUpdateRequest userUpdateRequest) {
    user user = findById(userUpdateRequest.getId());
    user.setAddress(userUpdateRequest.getAddress());
    user.setName(userUpdateRequest.getName());
    user.setPhone(userUpdateRequest.getPhone());
    user.setUpdateDate(new Date());
    userRepository.save(user);
  }
  
  /**
   * ユーザー情報 物理削除
   * @param id ユーザーID
   */
  public void delete(Long id) {
    user user = findById(id);
    userRepository.delete(user);
  }
  
}
