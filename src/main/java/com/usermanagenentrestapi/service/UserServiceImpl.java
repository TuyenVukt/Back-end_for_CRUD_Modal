package com.usermanagenentrestapi.service;

import com.usermanagenentrestapi.entity.User;
import com.usermanagenentrestapi.exception.DuplicateRecordException;
import com.usermanagenentrestapi.exception.NotFoundException;
import com.usermanagenentrestapi.model.dto.UserDto;
import com.usermanagenentrestapi.model.mapper.UserMapper;
import com.usermanagenentrestapi.model.request.CreateUserReq;
import com.usermanagenentrestapi.model.request.UpdateUserReq;
import com.usermanagenentrestapi.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDto> getListUser() {
        List<UserDto> result = new ArrayList<>();
        List<User> users = userRepository.getListUser();
        for(User user: users) result.add(UserMapper.toUserDto(user));
        return result;
    }

    @Override
    public List<User> getListFullUser() {
        List<User> users = userRepository.getListUser();
        return users;
    }

    @Override
    public UserDto getUserById(int id) {
        User user = userRepository.getUserById(id);
        if(user!=null){
            return UserMapper.toUserDto(user);
        }
        return null;
    }

    @Override
    public List<UserDto> searchByName(String name) {
        List<User> users= userRepository.findByNameIsLike(name);
        List<UserDto> result = new ArrayList<>();
        for(User user : users) result.add(UserMapper.toUserDto(user));
        return result;
    }

    @Override
    public UserDto createUser(CreateUserReq req) {
        List<User> users = userRepository.getListUser();
        for(User user: users){
            if (user.getEmail().equals(req.getEmail())) {
                throw new DuplicateRecordException("Email already exists in the system");
            }
        }
        User user = UserMapper.toUser(req);
        userRepository.save(user);///

        return UserMapper.toUserDto(user);

    }

    @Override
    public UserDto updateUser(UpdateUserReq req, Long id) {
        List<User> users = userRepository.getListUser();
        for (User user : users) {
            if (user.getId() == id) {
                if (!user.getEmail().equals(req.getEmail())) {
                    // Check new email exist
                    for (User tmp : users) {
                        if (tmp.getEmail().equals(req.getEmail())) {
                            throw new DuplicateRecordException("New email already exists in the system");
                        }
                    }
                    user.setEmail(req.getEmail());
                }
                user.setName(req.getName());
                user.setPhone(req.getPhone());
                user.setAvatar(req.getAvatar());
                user.setPassword(BCrypt.hashpw(req.getPassword(), BCrypt.gensalt(12)));
                userRepository.save(user);
                return UserMapper.toUserDto(user);
            }
        }
        throw new NotFoundException("No user found");

    }

    @Override
    public Integer delete(Long id) {
        return userRepository.deleteUser(id);
    }

    @Override
    public UserDto getUserByEmailAndPassword(String email, String password) {

        User user = userRepository.findByEmail(email);
        if(user!=null&&user.getStatus()!=0){
            if(BCrypt.checkpw(password,user.getPassword())) return UserMapper.toUserDto(user);
        }
        return null;

    }

}
