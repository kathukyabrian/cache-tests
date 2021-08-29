package com.example.demo.service;

import com.example.demo.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private  final Map<String, User> userMap;

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public User addUser(User user){

        userMap.put(user.getName(),user);

        logger.debug("Map count : {}",userMap.size());

        return user;
    }

    public User retrieveUser(String name){

        User user = userMap.get(name);

        return user;
    }

    public List<User> getAll(){

        List<User> userList = new ArrayList<>();

        for(Map.Entry<String, User> entry : userMap.entrySet()){
            userList.add(entry.getValue());
        }

        return userList;
    }
}
