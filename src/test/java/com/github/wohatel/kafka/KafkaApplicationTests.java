package com.github.wohatel.kafka;


import com.github.wohatel.kafka.entity.User;
import com.github.wohatel.kafka.mapper.CaseMapper;
import com.github.wohatel.kafka.mapper.DictMapper;
import com.github.wohatel.kafka.mapper.RwMapper;
import com.github.wohatel.kafka.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {KafkaApplication.class})
public class KafkaApplicationTests {


    @Autowired
    CaseMapper caseMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    DictMapper dictMapper;

    @Autowired
    RwMapper rwMapper;

    @Test
    public void insert() {
        Random random = new Random();
        for (long i = 0; i < 20; i++) {
            caseMapper.insert("小明", (long) random.nextInt(1000000));
        }
    }

    @Test
    public void select() {
        List<Long> userids = new ArrayList<>();
        userids.add(457514235606335488L);
        userids.add(457514235887353850L);
        List<User> users = caseMapper.findUsers(userids);
        users.forEach(u -> System.out.println(u.getName()));
    }

    @Test
    public void insertUser() {
        Random random = new Random();
        for (long i = 0; i < 10; i++) {
            userMapper.insert("慕容", (long) random.nextInt(1000000));
        }
    }


    @Test
    public void selectUsers() {
        List<Long> userids = new ArrayList<>();
        userids.add(457519304846344192L);
        userids.add(457519305454518272L);
        List<User> users = userMapper.findUsers(userids);
        users.forEach(u -> System.out.println(u.getName()));
    }


    @Test
    public void insertDict() {
        Random random = new Random();
        for (long i = 0; i < 10; i++) {
            dictMapper.insert("慕容", (long) random.nextInt(1000000));
        }
    }


    @Test
    public void selectDict() {
        List<Long> userids = new ArrayList<>();
        userids.add(457523147424399361L);
        userids.add(457523147755749376L);
        List<User> users = dictMapper.findUsers(userids);
        users.forEach(u -> System.out.println(u.getName()));
    }


    @Test
    public void insertRW() {
        Random random = new Random();
        for (long i = 0; i < 10; i++) {
            rwMapper.insert("master", (long) random.nextInt(1000000));
        }
    }


    @Test
    public void selectRW() {
        List<Long> userids = new ArrayList<>();
        userids.add(457523147424399361L);
        userids.add(457523147755749376L);
        List<User> users = rwMapper.findUsers(userids);
        users.forEach(u -> System.out.println(u.getName()));
    }
}
