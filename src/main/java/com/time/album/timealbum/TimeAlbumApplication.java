package com.time.album.timealbum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.time.album.timealbum.Mapper")
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.time.album","com.time.album.timealbum.config","com.time.album.timealbum.interceptor"})
public class TimeAlbumApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimeAlbumApplication.class, args);
    }

}
