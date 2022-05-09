package com.time.album.timealbum.controller;

import com.time.album.timealbum.dto.req.VideoReqDto;
import com.time.album.timealbum.dto.resp.VideoRespDto;
import com.time.album.timealbum.enums.LabelEnum;
import com.time.album.timealbum.model.ApiResponse;
import com.time.album.timealbum.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @author 何巧莹
 * @ClassName VideoController
 * @Description
 * @since 2022/5/9
 */
@RestController
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @PostMapping("/saveVideo")
    public ApiResponse saveVideo(VideoReqDto videoReqDto){
        boolean result = videoService.saveVideo(videoReqDto);
        return ApiResponse.success(result);
    }

    @GetMapping("/videoInfo")
    public ModelAndView videoInfo(Integer videoId){
        VideoRespDto video = videoService.getVideoByVideoId(videoId);
        video.setLabelName(LabelEnum.getTypeNameByTypeId(video.getVideoLabel()));
        ModelAndView view = new ModelAndView("/videoInfo");
        view.addObject("video",video);
        return view;
    }

    @GetMapping("/modifyVideo")
    public ModelAndView modifyVideo(Integer videoId){
        VideoRespDto video = videoService.getVideoByVideoId(videoId);
        ModelAndView view = new ModelAndView("/modifyVideo");
        view.addObject("video",video);
        return view;
    }

    @PostMapping("/modifyVidoDo")
    public ApiResponse modifyVideoDo(VideoReqDto videoReqDto){
        videoReqDto.setGmtModify(new Date());
        videoService.modifyVideo(videoReqDto);
        return ApiResponse.success();
    }

    @PostMapping("/removeVideo")
    public ApiResponse removeVideo(Integer videoId){
        videoService.removeVideo(videoId);
        return ApiResponse.success();
    }
}
