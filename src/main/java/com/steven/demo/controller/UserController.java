package com.steven.demo.controller;

import com.steven.demo.dao.mapper.BookMapper;
import com.steven.demo.service.ChangeDataService;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.steven.demo.dao.model.Book;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class UserController {
    @Autowired
    BookMapper userDao;

    @Autowired
    ChangeDataService services;

    @RequestMapping("/findAll/{page}/{size}")
    List<Book> selectWithPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        List<Book> books = services.selectWithPage(page, size);
        return books;
    }

    @GetMapping("/findById/{id}")
    public Optional<Book> findById(@PathVariable("id") Integer id){
        Optional<Book> user = services.selectByPrimaryKey(id);
        return user;
    }

    //delete user by Id
    @DeleteMapping("/deleteById/{id}")
    public void deleteUserId(@PathVariable("id") Integer id) {
        services.deleteByUserId(id);
        System.out.println("The user id: "+ id +"has been deleted");
    }
    //save user
    @PostMapping("/save")
    public int save(@RequestBody Book book){
        int user = services.insert(book);
        return user;
    }

    //update user
    @PutMapping("/update")
    public int update(@RequestBody Book book){
        int user = services.updateUserNameById(book);
        System.out.println(user);
        return user;
    }

//************************** demo***********************//
    //
//    //select(query) user by Id
//    @RequestMapping("/seleteUserById")
//    Optional<Book> seleteUserById() {
//        Optional<Book> user = services.selectUserById(1);
//        return user;
//    }
//
//
//    //insert user by User object
//    @RequestMapping ("/insert")
//    int insert(Book record){
//        int user = services.insert(record);
//        return user;
//    }
//
//    //update user by User object  return 1 success; 0 null
//    @RequestMapping ("/update")
//    String updateUserNameById(Book record){
//        int user = services.updateUserNameById(record);
//        String result;
//        if(user ==1){
//           result="Success update target data."+ "\ncurrent id: " + record.getId()+
//           "\nwp_name is: "+ record.getName();
//            System.out.println(result);
//        }
//        else{
//            result ="error";
//        }
//        return result;
//    }
    //************ test ***********************//
    @RequestMapping("/test")
    String showWelcomeMsg() {
    	return "Hello World";
    }

    @RequestMapping("/queryUserById/{id}")
    public Optional<Book> selectUserById(@PathVariable("id") Integer id) {
        System.out.println("id:" + id);
        Optional<Book> user = userDao.selectByPrimaryKey(id);
        System.out.println(user.toString());
        return user;
    }

    @RequestMapping("/findAll")
    public List<Book> selectAll(){
        List<Book> book = userDao.select(SelectDSLCompleter.allRows());
        return book;

    }



    //************ test ***********************//



}