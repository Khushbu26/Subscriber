package com.lucent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucent.Repository.SubscriberRepo;
import com.lucent.model.User;

@Service
@Transactional
public class SubscriberService {

  @Autowired
  private SubscriberRepo subscriberRepo;

  public List<User> getAllSubscriber() {
    return subscriberRepo.findAll();
  }

  public void save(User user) {
    subscriberRepo.save(user);
  }

  public User get(long id) {
    return subscriberRepo.findById(id).get();
  }

  public void delete(long id) {
    subscriberRepo.deleteById(id);
  }



}
