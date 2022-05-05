package com.time.album.timealbum.service;

import com.alibaba.fastjson.JSON;
import com.time.album.timealbum.TimeAlbumApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {TimeAlbumApplication.class})
@RunWith(SpringRunner.class)
@Slf4j
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void getUserByUserId(){
        log.info(JSON.toJSONString(userService.getUserByUserId(1)));
    }

}