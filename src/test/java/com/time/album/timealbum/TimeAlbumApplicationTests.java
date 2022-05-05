package com.time.album.timealbum;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {TimeAlbumApplication.class})
@RunWith(SpringRunner.class)
@Slf4j
@DisplayName("启动测试")
class TimeAlbumApplicationTests {

    @Test
    void contextLoads() {
    }

}
