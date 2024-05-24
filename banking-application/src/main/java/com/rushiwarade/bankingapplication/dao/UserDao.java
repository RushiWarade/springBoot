package com.rushiwarade.bankingapplication.dao;

import com.rushiwarade.bankingapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    User findAllByEmailAndPassword(String email , String pass);

}
