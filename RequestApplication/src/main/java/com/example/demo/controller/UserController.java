package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.dto.Condition_Request;
import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.user;
import com.example.demo.entity.userfrom;
import com.example.demo.service.UserService;
import com.example.demo.session.sessiondata;
/**
 * ユーザー情報 Controller
 */
@Controller
@SessionAttributes(types = userfrom.class)
public class UserController {
  /**
   * ユーザー情報 Service
   */
	
  @Autowired
  UserService userService;
  Condition_Request condition_Request;
  sessiondata sessiondata;
  
  /*
   * オブジェクトをHTTPセッションに追加する
   */
  @ModelAttribute("loginForm")
  public userfrom setUpLoginForm(){
      return new userfrom();
  }
 /**
  * ユーザー情報一覧画面を表示
  * @param model Model
  * @return ユーザー情報一覧画面
  */
  @GetMapping(value = "/user/list")
  public String displayList(Model model) {
    List<user> userlist = userService.searchAll();
    model.addAttribute("userlist", userlist);
    return "user/list";
  }
  /**
   * ユーザー新規登録画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @GetMapping(value = "/user/add")
  public String displayAdd(Model model) {
    model.addAttribute("userRequest", new UserRequest());
    return "user/add";
  }
  /**
   * 新規条件登録画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面
   */    
  @GetMapping(value = "/user/{id}/add_condition")
  public String displaycondition(HttpServletResponse response, @PathVariable Long id, Model model)throws Exception {
	  String str = String.valueOf(id);
	  Cookie cookie = new Cookie("id",str);// Cookieの作成
	  cookie.setMaxAge(265 * 24 * 60 * 60); // Cookieの残存期間（秒数）
	  cookie.setPath("/"); // Cookieの適用対象となるサーバ上のパス
	  response.addCookie(cookie);
	  model.addAttribute("Condition_Request",new Condition_Request());
	return "user/add_condition";
  }
  /**
   * ユーザー情報詳細画面を表示
   * @param id 表示するユーザーID
   * @param model Model
   * @return ユーザー情報詳細画面
   */
  @GetMapping("/user/{id}")
  public String displayView(@PathVariable Long id, Model model) {
    user user = userService.findById(id);
    model.addAttribute("userData", user);
    return "user/view";
  }
  
  /**
   * ユーザー編集画面を表示
   * @param id 表示するユーザーID
   * @param model Model
   * @return ユーザー編集画面
   */
  @GetMapping("/user/{id}/edit")
  public String displayEdit(@PathVariable Long id, Model model) {
    user user = userService.findById(id);
    UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
    userUpdateRequest.setId(user.getId());
    userUpdateRequest.setName(user.getName());
    userUpdateRequest.setPhone(user.getPhone());
    userUpdateRequest.setAddress(user.getAddress());
    model.addAttribute("userUpdateRequest", userUpdateRequest);
    return "user/edit";
  }
  /**
   * ユーザー更新
   * @param userRequest リクエストデータ
   * @param model Model
   * @return ユーザー情報詳細画面
   */
  @RequestMapping(value = "/user/update", method = RequestMethod.POST)
  public String update(@Validated @ModelAttribute UserUpdateRequest userUpdateRequest, BindingResult result, Model model) {
    if (result.hasErrors()) {
      List<String> errorList = new ArrayList<String>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      model.addAttribute("validationError", errorList);
      return "user/edit";
    }
    // ユーザー情報の更新
    userService.update(userUpdateRequest);
    return String.format("redirect:/user/%d", userUpdateRequest.getId());
  }

  /**
   * ユーザー情報削除
   * @param id 表示するユーザーID
   * @param model Model
   * @return ユーザー情報詳細画面
   */
  @GetMapping("/user/{id}/delete")
  public String delete(@PathVariable Long id, Model model) {
    // ユーザー情報の削除
    userService.delete(id);
    return "redirect:/user/list";
  }

  /**
   * ユーザー新規登録
   * @param userRequest リクエストデータ
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @RequestMapping(value = "/user/create", method = RequestMethod.POST)
  public String create(@Validated @ModelAttribute UserRequest userRequest, BindingResult result, Model model) {
    if (result.hasErrors()) {
      List<String> errorList = new ArrayList<String>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      model.addAttribute("validationError", errorList);
      return "user/add";
    }
    // ユーザー情報の登録
    userService.create(userRequest);
    return "redirect:/user/list";
  }
  
  /**
   * 新規条件登録
   * @param ondition_Request リクエストデータ
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @RequestMapping(value = "/user/conditioncreate", method = RequestMethod.POST)
  public String conditioncreate(@Validated @ModelAttribute  Condition_Request condition_Request,BindingResult result,Model model, @CookieValue(value="id", required=false ) String str) {
    if (result.hasErrors()) {
      List<String> errorList = new ArrayList<String>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      String URL = ("user/add_condition");
      model.addAttribute("validationError", errorList);
      
      return URL;
    }
    long id = Long.parseLong(str);
    
    // ユーザー情報の登録
    userService.conditioncreate(condition_Request, id);
    return "redirect:/user/list";
  }
}
