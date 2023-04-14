package com.project.test.accenture.testBasic_v1.controller;


import com.project.test.accenture.testBasic_v1.exception.BarsException;
import com.project.test.accenture.testBasic_v1.model.User;
import com.project.test.accenture.testBasic_v1.payload.request.UserRequest;
import com.project.test.accenture.testBasic_v1.payload.response.UserPostResponse;
import com.project.test.accenture.testBasic_v1.payload.response.UserResponse;
import com.project.test.accenture.testBasic_v1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public ResponseEntity<UserResponse> all(@RequestParam(defaultValue = "5") int max_records, @RequestParam(defaultValue = "0") int offset) {
        try {
            return new ResponseEntity<>(userService.getAll(max_records, offset), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserPostResponse> getDataById(@PathVariable("id") Long id) {
        try {
            UserPostResponse user = userService.getUserById(id);
            if (user == null) {
                return ResponseEntity.notFound().build();
            }
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<UserPostResponse> CreateUser(@RequestBody UserRequest request)
        throws BarsException {
        try {
            if (request.getSsn() == null ) {
                throw new BarsException("Invalid value for field ssn, rejected value: null" + request.getSsn());
            }
            if (request.getFirts_name() == null  ) {
                throw new BarsException("Invalid value for first_name, rejected value: null" + request.getSsn());
            }
            if (request.getLast_name() == null ) {
                throw new BarsException("Invalid value for field family_name, rejected value:" + request.getSsn());
            }
            UserPostResponse user = userService.CreateDataUser(request);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (BarsException ex) {
            String msg = ex.getMessage();
//            logger.error(msg, ex);
            throw new BarsException(msg, ex);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserPostResponse> UpdateUser(@RequestBody UserRequest request, @PathVariable("id") Long id){
        try{
            UserPostResponse user = userService.putUser(request, id);
            if (user == null) {
                return ResponseEntity.notFound().build();
            }
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/users/{id}/setting")
    public ResponseEntity<UserPostResponse> UpdateUser(@PathVariable("id") Long id, @RequestBody List<Map<String,String>> data){
        try{
            UserPostResponse user = userService.putUserSetting(data, id);
            if (user == null) {
                return ResponseEntity.notFound().build();
            }
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> DeleteUser(@PathVariable("id") Long id){
        try{
            User user = userService.deleteUser( id);
//            if (user == null) {
//                return ResponseEntity.notFound().build();
//            }
                if( null == user ){
                    return new ResponseEntity<>(user, HttpStatus.NO_CONTENT);
            }
                return new ResponseEntity<>(user, HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/users/{id}/refresh")
    public ResponseEntity<UserPostResponse> UpdateUserRefresh(@PathVariable("id") Long id){
        try{
            UserPostResponse user = userService.putUserRefresh(id);
            if (user == null) {
                return ResponseEntity.notFound().build();
            }
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

}
