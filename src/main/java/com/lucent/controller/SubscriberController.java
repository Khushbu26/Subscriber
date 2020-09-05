package com.lucent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lucent.model.Products;
import com.lucent.model.User;
import com.lucent.service.ProductsService;
import com.lucent.service.SubscriberService;

@Controller
public class SubscriberController {

  @Autowired
  private SubscriberService service;

  @Autowired
  private ProductsService productService;

  @RequestMapping("/")
  public String viewHomePage(Model model) {
    List<User> listOfSubscriber = service.getAllSubscriber();
    model.addAttribute("user", new User());
    model.addAttribute("listuser", listOfSubscriber);
    return "index";
  }

  @RequestMapping("/getall")
  public List<User> getEmployee(Model model) {
    List<User> listProducts = service.getAllSubscriber();
    model.addAttribute("listProducts", listProducts);

    return listProducts;
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public ModelAndView saveEmployee(@ModelAttribute("user") User user) {
    service.save(user);
    return new ModelAndView("redirect:/");
  }

  @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
  public String getUserById(@PathVariable("id") Long id, Model model) {
    List<User> listUser = service.getAllSubscriber();
    User emp = service.get(id);
    model.addAttribute("user", emp);
    model.addAttribute("listuser", listUser);
    return "index";

  }

  @RequestMapping(value = "/delete/{id}")
  public ModelAndView deleteById(@PathVariable("id") Long id) {
    System.out.println("id:---------- " + id);
    service.delete(id);
    return new ModelAndView("redirect:/");
  }

  @RequestMapping("/getAllProducts")
  public String listOfProducts(Model model) {
    List<Products> listOfProducts = productService.getAllProduct();
    model.addAttribute("product", new Products());
    model.addAttribute("listproduct", listOfProducts);
    return "product";
  }

}
