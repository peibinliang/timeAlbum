package com.time.album.timealbum.utils;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 何巧莹
 * @ClassName Utils
 * @Description 工具类
 * @since 2022/5/8
 */
public class Utils {
    /**
     * 照片编码生成
     *
     * @return
     */
    public static String generatePhotoNo() {
        String photoNo = "PN";//新建编号前缀
        Date now = new Date();//获取时间戳
        photoNo += Integer.toOctalString((int) now.getTime());//将时间戳转成八进制加上前缀
        return photoNo;//返回照片编号
    }

    /**
     * 视频编码生成
     *
     * @return
     */
    public static String generateVideoNo() {
        String videoNo = "VN";
        Date now = new Date();
        videoNo += Integer.toOctalString((int) now.getTime());
        return videoNo;
    }

    public static void main(String[] args) {
        System.out.println(CorrectPhoneNumber("13059381566"));
    }

    /**
     * 校正手机号
     *
     * @param phoneNumber 手机号
     * @return boolean 手机号格式是否正确
     */
    public static boolean CorrectPhoneNumber(String phoneNumber) {
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        if (phoneNumber.length() != 11) {
            System.out.println("手机号应为11位数");
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phoneNumber);
            boolean isMatch = m.matches();
            if (isMatch) {
                System.out.println("您的手机号格式正确");
                return true;
            } else {
                System.out.println("您的手机号格式不正确");
                return false;
            }
        }
    }
}
