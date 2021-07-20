package com.usermanagenentrestapi.controller;

import com.usermanagenentrestapi.entity.User;
import com.usermanagenentrestapi.exception.NotFoundException;
import com.usermanagenentrestapi.model.dto.UserDto;
import com.usermanagenentrestapi.model.request.CreateUserReq;
import com.usermanagenentrestapi.model.request.LoginForm;
import com.usermanagenentrestapi.model.request.UpdateUserReq;
import com.usermanagenentrestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/user")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping(value = "/list")
    public ResponseEntity<?> getListUser(){
        List<UserDto> listUser= userService.getListUser();
        return ResponseEntity.ok(listUser);
    }

    @GetMapping(value = "list-full")
    public ResponseEntity<?> getListFullUser(){
        List<User> users = userService.getListFullUser();
        return  ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id){
        UserDto result = userService.getUserById(id);
        if(result!=null)return ResponseEntity.ok(result);
        throw  new NotFoundException("Không tồn tại User này!!!");
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchByName(@RequestParam(required = false, defaultValue = "") String name){
        List<UserDto> result = userService.searchByName(name);
        if(result!=null) return ResponseEntity.ok(result);
        return null;
    }

    @PostMapping("")
    public  ResponseEntity<?> createUser(@Valid @RequestBody CreateUserReq req){
        UserDto result = userService.createUser(req);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UpdateUserReq req, @PathVariable Long id){
        UserDto result = userService.updateUser(req, id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        Integer check = userService.delete(id);
        if(check==1){
            return ResponseEntity.ok(check);
        }else{
            throw  new NotFoundException("Không tồn tại User này!!!");
        }

    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginForm form){
        UserDto userDto = userService.getUserByEmailAndPassword(form.getEmail(), form.getPassword());
        if(userDto!=null) return  ResponseEntity.ok(userDto);
        throw new NotFoundException("User not found!!");
    }


}
