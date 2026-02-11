package com.vinayGahane.airBnbApp.dto;

import com.vinayGahane.airBnbApp.entity.User;
import com.vinayGahane.airBnbApp.entity.enums.Gender;
import lombok.Data;

@Data
public class GuestDto {
    private Long id;
    private User user;
    private String name;
    private Gender gender;
    private Integer age;
}
