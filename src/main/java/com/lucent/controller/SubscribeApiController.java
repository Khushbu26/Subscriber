package com.lucent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucent.model.User;
import com.lucent.service.SubscriberService;


@RestController
public class SubscribeApiController {

  @Autowired
  private SubscriberService service;



  @RequestMapping(value = {"/allSubscriber"}, method = RequestMethod.GET)
  public List<User> getAllUserList() {
    List<User> listProducts = service.getAllSubscriber();
    return listProducts;
  }

  @RequestMapping(value = {"/registerCustomer"}, method = RequestMethod.POST)
  public String registerCustomer(@Nullable @RequestBody User user) {
    service.save(user);
    return "Successfully Registered";

  }

  @RequestMapping(value = "/editApi/{id}", method = RequestMethod.GET)
  public User getUserById(@PathVariable("id") Long id) {
    User emp = service.get(id);
    return emp;

  }

  @RequestMapping(value = "/deleteApi/{id}")
  public String deleteById(@PathVariable("id") Long id) {
    service.delete(id);
    return "Successfully Deleted user";
  }

}
