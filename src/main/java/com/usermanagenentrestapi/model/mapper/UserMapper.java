package com.usermanagenentrestapi.model.mapper;

import com.usermanagenentrestapi.entity.User;
import com.usermanagenentrestapi.model.dto.UserDto;
import com.usermanagenentrestapi.model.request.CreateUserReq;
import org.mindrot.jbcrypt.BCrypt;

public class UserMapper {
    public static UserDto toUserDto(User user){
        UserDto tmp = UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .avatar(user.getAvatar())
                .status(user.getStatus())
                .build();
        return tmp;

    }
    public static User toUser(CreateUserReq req) {
        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPhone(req.getPhone());
        // Hash password using BCrypt
        String hash = BCrypt.hashpw(req.getPassword(), BCrypt.gensalt(12));

        user.setPassword(hash);
        user.setStatus(1);

        return user;
    }
}
