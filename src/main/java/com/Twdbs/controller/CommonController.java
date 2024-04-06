package com.Twdbs.controller;

import com.Twdbs.accountdb.entity.Account;
import com.Twdbs.accountdb.repository.AccountRepository;
import com.Twdbs.usercdb.entity.User;
import com.Twdbs.usercdb.repository.UserRepository;
import org.apache.catalina.LifecycleState;
import org.hibernate.property.access.internal.PropertyAccessCompositeUserTypeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommonController {


    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;



    //account
    @PostMapping("/saveAcc")
    public Account saveAccount(@RequestBody Account account){
        return  accountRepository.save(account);
    }


    @GetMapping("/getAcc")
    public List<Account> accounts(){
        return accountRepository.findAll();
    }



    ///user

    @PostMapping("/saveuser")
    public User saveUser(@RequestBody User user){
        return  userRepository.save(user);
    }


    @GetMapping("/getuser")
    public List<User> users(){
        return userRepository.findAll();
    }

}
