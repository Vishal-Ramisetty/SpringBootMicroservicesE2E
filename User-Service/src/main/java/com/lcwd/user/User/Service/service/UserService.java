package com.lcwd.user.User.Service.service;


import com.lcwd.user.User.Service.entity.Users;

import java.util.List;

public interface UserService {

    Users saveUser(Users user);

    List<Users> findAllUsers();

    Users findUserById(String id);

    Users updateUser(String id, Users user);

    void deleteUser(String id);

}
