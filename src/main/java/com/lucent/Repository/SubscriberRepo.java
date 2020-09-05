package com.lucent.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucent.model.User;

public interface SubscriberRepo extends JpaRepository<User, Long>{

}
