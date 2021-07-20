package com.usermanagenentrestapi.model.dto;

import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private int id;

    private String name;

    private String email;

    private String phone;

    private String avatar;

    private int status;
}
