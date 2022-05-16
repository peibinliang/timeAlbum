package com.time.album.timealbum.controller;

import com.time.album.timealbum.dto.req.PhotoReqDto;
import com.time.album.timealbum.dto.resp.PhotoRespDto;
import com.time.album.timealbum.enums.LabelEnum;
import com.time.album.timealbum.model.ApiResponse;
import com.time.album.timealbum.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 何巧莹
 * @ClassName PhotoController
 * @Description
 * @since 2022/5/9
 */
@RestController
@RequestMapping("/photo")
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @PostMapping("/savePhoto")
    public ApiResponse savePhoto(PhotoReqDto photoReqDto){
        boolean result = photoService.savePhoto(photoReqDto);
        return ApiResponse.success(result);
    }

    @GetMapping("/photoInfo")
    public ModelAndView photoInfo(Integer photoId){
        ModelAndView view = new ModelAndView("/photoInfo");
        PhotoRespDto photo = photoService.getPhotoByPhotoId(photoId);
        photo.setLabelName(LabelEnum.getTypeNameByTypeId(photo.getPhotoLabel()));
        view.addObject("photo",photo);
        return view;
    }

    @GetMapping("/modifyPhoto")
    public ModelAndView modifyPhoto(Integer photoId){
        ModelAndView view = new ModelAndView("/modifyPhoto");
        PhotoRespDto photo = photoService.getPhotoByPhotoId(photoId);
        photo.setLabelName(LabelEnum.getTypeNameByTypeId(photo.getPhotoLabel()));
        view.addObject("photo",photo);
        return view;
    }

    @PostMapping("/modifyPhotoDo")
    public ApiResponse modifyPhotoDo(PhotoReqDto photoReqDto){
        photoService.modifyPhoto(photoReqDto);
        return ApiResponse.success();
    }

    @PostMapping("/removePhoto")
    public ApiResponse<Boolean> removePhoto(Integer photoId){
        boolean result = photoService.removePhoto(photoId);
        return ApiResponse.success(result);
    }
}
