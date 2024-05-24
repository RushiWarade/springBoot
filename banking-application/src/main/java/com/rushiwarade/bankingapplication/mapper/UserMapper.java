package com.rushiwarade.bankingapplication.mapper;

import com.rushiwarade.bankingapplication.dto.UserDto;
import com.rushiwarade.bankingapplication.model.User;

public class UserMapper {

    public static User mapToUser(UserDto userDto) {
       User user=new User(
               userDto.getId(),
               userDto.getFname(),
               userDto.getLname(),
               userDto.getMobile(),
               userDto.getEmail(),
               userDto.getAddress(),
               userDto.getAccountType(),
               userDto.getAccountNumber(),
               userDto.getBalance(),
               userDto.getPassword()
       );
     return  user ;
    }
    public static UserDto mapToUserDto(User user) {
       UserDto userDto= new UserDto(
               user.getId(),
               user.getFname(),
               user.getLname(),
               user.getMobile(),
               user.getEmail(),
               user.getAddress(),
               user.getAccountType(),
               user.getAccountNumber(),
               user.getBalance(),
               user.getPassword()
       );
     return  userDto ;
    }

}
