package com.syed.accountexample.controller;

import com.syed.accountexample.domain.repository.*;
import com.syed.accountexample.domain.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/account")
@CrossOrigin(origins = "http://localhost:8080")
public class AccountDBController {

    private final AccountDBRepository accountDBRepository;

    @Autowired
    public AccountDBController(AccountDBRepository accountDBRepository) {
        this.accountDBRepository = accountDBRepository;
    }

    @RequestMapping(value = "/create-account", method = RequestMethod.POST)
    public AccountDB createAccount(@RequestBody AccountDB accountDB){
        return accountDBRepository.save(accountDB);
    }

    @RequestMapping(value = "/find-all", method = RequestMethod.GET)
    public List<AccountDB> findAll(){
        return accountDBRepository.findAll();
    }

    @RequestMapping(value = "/delete-all", method = RequestMethod.DELETE)
    public void deleteAll(){
        accountDBRepository.deleteAll();
    }

    @RequestMapping(value = "/find-by-id/{id}", method = RequestMethod.GET)
    public AccountDB findById(@PathVariable Long id){
        return accountDBRepository.findById(id).get();
    }

    @RequestMapping(value = "/find-by-name/{name}", method = RequestMethod.GET)
    public List<AccountDB> findByName(@PathVariable String name){
        return accountDBRepository.findByName(name);
    }

    @RequestMapping(value = "/delete-account/{id}", method = RequestMethod.DELETE)
    public List<AccountDB> deleteAccount(@PathVariable Long id){
        if(accountDBRepository.findById(id).isPresent()){
            accountDBRepository.deleteById(id);
            return accountDBRepository.findAll();
        }else{
            return accountDBRepository.findAll();
        }
    }

    @RequestMapping(value = "/update-account/{id}", method = RequestMethod.PUT)
    public List<AccountDB> updateAccount(@PathVariable Long id, @RequestBody AccountDB newAccount){
        if(accountDBRepository.findById(id).isPresent()){
            AccountDB existingAccount = accountDBRepository.findById(id).get();
            BeanUtils.copyProperties(newAccount, existingAccount);
            accountDBRepository.saveAndFlush(existingAccount);
            return accountDBRepository.findAll();
        }else{
            return accountDBRepository.findAll();
        }
    }


}
