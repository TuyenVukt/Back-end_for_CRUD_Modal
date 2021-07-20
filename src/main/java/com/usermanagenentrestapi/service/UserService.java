package com.usermanagenentrestapi.service;

import com.usermanagenentrestapi.entity.User;
import com.usermanagenentrestapi.model.dto.UserDto;
import com.usermanagenentrestapi.model.request.CreateUserReq;
import com.usermanagenentrestapi.model.request.UpdateUserReq;

import java.util.List;

public interface UserService {
    List<UserDto> getListUser();

    List<User> getListFullUser();

    UserDto getUserById(int id);

    List<UserDto> searchByName(String name);

    UserDto createUser(CreateUserReq user);

    UserDto updateUser(UpdateUserReq req, Long id);

    Integer delete(Long id);

    UserDto getUserByEmailAndPassword(String email, String password);

}
