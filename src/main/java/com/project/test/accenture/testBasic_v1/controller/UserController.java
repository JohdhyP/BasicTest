package com.project.test.accenture.testBasic_v1.controller;


import com.project.test.accenture.testBasic_v1.exception.BarsException;
import com.project.test.accenture.testBasic_v1.model.User;
import com.project.test.accenture.testBasic_v1.payload.request.UserRequest;
import com.project.test.accenture.testBasic_v1.payload.response.UserResponse;
import com.project.test.accenture.testBasic_v1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
    public ResponseEntity<User> FilterDataForChangeRoomAdmin(@PathVariable("id") Long id) {
        try {
            User user = userService.getUserById(id);
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
    public ResponseEntity<User> CreateUser(@RequestBody UserRequest request)
        throws BarsException {
        try {
            throw new BarsException("test");
//            User user = userService.CreateDataUser(request);
//            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (BarsException ex) {
            String msg = ex.getMessage();
//            logger.error(msg, ex);
            throw new BarsException(msg, ex);
        }
    }
//        try{
//            User user = userService.CreateDataUser(request);
//
//            if (request.getSsn() == null) {
//                throw new IllegalArgumentException();
//            }
//
//            return new ResponseEntity<>(user, HttpStatus.CREATED);
//        }catch(Exception e){
//            e.printStackTrace();
//            return new ResponseEntity(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
//        }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> UpdateUser(@RequestBody UserRequest request, @PathVariable("id") Long id){
        try{
            User user = userService.getUserById(id);
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
            if (user == null) {
                return ResponseEntity.notFound().build();
            }
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/users/{id}/refresh")
    public ResponseEntity<User> UpdateUserRefresh(@PathVariable("id") Long id){
        try{
            User user = userService.putUserRefresh(id);
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
