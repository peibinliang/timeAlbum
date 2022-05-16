package com.time.album.timealbum.controller;

import com.time.album.timealbum.dto.req.UserReqDto;
import com.time.album.timealbum.dto.resp.PhotoRespDto;
import com.time.album.timealbum.dto.resp.UserRespDto;
import com.time.album.timealbum.dto.resp.VideoRespDto;
import com.time.album.timealbum.enums.LabelEnum;
import com.time.album.timealbum.exception.BusinessException;
import com.time.album.timealbum.model.ApiResponse;
import com.time.album.timealbum.service.PhotoService;
import com.time.album.timealbum.service.UserService;
import com.time.album.timealbum.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 何巧莹
 * @ClassName UserController
 * @Description 用户接口类
 * @since 2022/5/5 10:24
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;
    @Autowired
    private PhotoService photoService;
    @Autowired
    private VideoService videoService;

    @GetMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("/index");
    }

    @GetMapping("/saveUser")
    @ResponseBody
    public ApiResponse saveUser(){
        return ApiResponse.success("hello");
    }

    @PostMapping("/userLogin")
    @ResponseBody
    public ApiResponse userLogin(UserReqDto userReqDto, HttpServletRequest request) throws BusinessException {
        UserRespDto userRespDto = userService.userLogin(userReqDto);
        request.getSession().setAttribute("user",userRespDto);
        return ApiResponse.success(userRespDto);
    }

    @GetMapping("/main")
    public ModelAndView main(HttpServletRequest request){
        UserRespDto user = (UserRespDto) request.getSession().getAttribute("user");
        List<PhotoRespDto> photoList = photoService.listPhotoByUserId(user.getUserId());
        for (PhotoRespDto photo : photoList){
            photo.setLabelName(LabelEnum.getTypeNameByTypeId(photo.getPhotoLabel()));
        }
        List<VideoRespDto> videoList = videoService.listVideoByUserId(user.getUserId());
        for (VideoRespDto video : videoList){
            video.setLabelName(LabelEnum.getTypeNameByTypeId(video.getVideoLabel()));
        }
        ModelAndView view = new ModelAndView("/main");
        view.addObject("photoList",photoList);
        view.addObject("videoList",videoList);
        view.addObject("search","");
        return view;
    }

    @GetMapping("/search")
    public ModelAndView search(String search,HttpServletRequest request){
        UserRespDto user = (UserRespDto) request.getSession().getAttribute("user");
        List<PhotoRespDto> photoList = photoService.searchPhotoListByUserId(user.getUserId(),search);
        for (PhotoRespDto photo : photoList){
            photo.setLabelName(LabelEnum.getTypeNameByTypeId(photo.getPhotoLabel()));
        }
        List<VideoRespDto> videoList = videoService.searchVideoListByUserId(user.getUserId(),search);
        for (VideoRespDto video : videoList){
            video.setLabelName(LabelEnum.getTypeNameByTypeId(video.getVideoLabel()));
        }
        ModelAndView view = new ModelAndView("/main");
        view.addObject("photoList",photoList);
        view.addObject("videoList",videoList);
        view.addObject("search",search);
        return view;
    }

    @GetMapping("/forgetPassword")
    public ModelAndView forgetPassword(){
        return new ModelAndView("/forgetPassword");
    }

    @PostMapping("/forgetPasswordDo")
    public ApiResponse forgetPassword(UserReqDto userReqDto) throws BusinessException {
        boolean result = userService.forgetPassword(userReqDto);
        return ApiResponse.success(result);
    }

    @GetMapping("/userRegister")
    public ModelAndView userRegister(){
        return new ModelAndView("/userRegister");
    }

    @PostMapping("/userRegisterDo")
    public ApiResponse userRegister(UserReqDto userReqDto) throws BusinessException {
        boolean result = userService.saveUser(userReqDto);
        return ApiResponse.success(result);
    }

    @GetMapping("/modifyPassword")
    public ModelAndView modifyPassword(){
        return new ModelAndView("/modifyPassword");
    }

    @PostMapping("/modifyPasswordDo")
    public ApiResponse modifyPasswordDo(UserReqDto userReqDto){
        return ApiResponse.success(userService.modifyUser(userReqDto));
    }

    @GetMapping("/userInfo")
    public ModelAndView userInfo(Integer userId){
        ModelAndView view = new ModelAndView("/userInfo");
        UserRespDto user = userService.getUserByUserId(userId);
        view.addObject("userInfo",user);
        return view;
    }

    @GetMapping("/modifyUser")
    public ModelAndView modifyUser(Integer userId){
        ModelAndView view = new ModelAndView("/modifyUser");
        UserRespDto user = userService.getUserByUserId(userId);
        view.addObject("userInfo",user);
        return view;
    }

    @PostMapping("/modifyUserDo")
    @ResponseBody
    public ApiResponse modifyUserDo(UserReqDto userReqDto){
        boolean result = userService.modifyUser(userReqDto);
        return ApiResponse.success(result);
    }
}
