package com.time.album.timealbum.controller;

import com.alibaba.fastjson.JSONObject;
import com.time.album.timealbum.dto.req.AlbumReqDto;
import com.time.album.timealbum.dto.req.UserReqDto;
import com.time.album.timealbum.dto.resp.AlbumRespDto;
import com.time.album.timealbum.dto.resp.PhotoRespDto;
import com.time.album.timealbum.dto.resp.UserRespDto;
import com.time.album.timealbum.dto.resp.VideoRespDto;
import com.time.album.timealbum.model.ApiResponse;
import com.time.album.timealbum.service.AlbumService;
import com.time.album.timealbum.service.PhotoService;
import com.time.album.timealbum.service.UserService;
import com.time.album.timealbum.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author 何巧莹
 * @ClassName AlbumController
 * @Description
 * @since 2022/5/9
 */
@RestController
@RequestMapping("/album")
public class AlbumController extends BaseController{
    @Autowired
    private AlbumService albumService;
    @Autowired
    private PhotoService photoService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private UserService userService;

    @GetMapping("/albumList")
    public ModelAndView albumList(Integer userId){
        //根据UserID来返回相册列表
        List<AlbumRespDto> albumList = albumService.listAlbum(userId);
        //创建视图
        ModelAndView view = new ModelAndView("/albumList");
        view.addObject("albumList",albumList);
        return view;
    }

    @GetMapping("/albumListOfMember")
    public ModelAndView albumListOfMember(Integer userId){
        List<AlbumRespDto> albumList = albumService.listAlbum(userId);
        ModelAndView view = new ModelAndView("/albumListOfMember");
        view.addObject("albumList",albumList);
        return view;
    }

    @GetMapping("/albumInfo")
    public ModelAndView albumInfo(Integer albumId){
        List<PhotoRespDto> photoList = photoService.listPhotoByAlbumId(albumId);
        List<VideoRespDto> videoList = videoService.listVideoByAlbumId(albumId);
        ModelAndView view = new ModelAndView("/albumInfo");
        view.addObject("photoList",photoList);
        view.addObject("videoList",videoList);
        view.addObject("albumId",albumId);
        return view;
    }

    @GetMapping("/addPhoto")
    public ModelAndView addPhoto(Integer albumId){
        ModelAndView view = new ModelAndView("/addPhoto");
        view.addObject("albumId",albumId);
        return view;
    }

    @GetMapping("/addVideo")
    public ModelAndView addVideo(Integer albumId){
        ModelAndView view = new ModelAndView("/addVideo");
        view.addObject("albumId",albumId);
        return view;
    }

    @GetMapping("/albumMember")
    public ModelAndView albumMember(Integer albumId){
        List<UserRespDto> userList = albumService.listUserByAlbumId(albumId);
        //根据相册Id获取相册对象
        AlbumRespDto album = albumService.getAlbumByAlbumId(albumId);
        //创建新的视图
        ModelAndView view = new ModelAndView("/albumMember");
        view.addObject("userList",userList);
        //给视图添加对象
        view.addObject("album",album);
        return view;
    }

    @GetMapping("/addMember")
    public ModelAndView addMember(Integer albumId){
        ModelAndView view = new ModelAndView("/addMember");
        view.addObject("albumId",albumId);
        return view;
    }

    @PostMapping("/addMemberDo")
    public ApiResponse addMemberDo(UserReqDto userReqDto){
        boolean result = userService.addMember(userReqDto);
        return ApiResponse.success(result);
    }

    @PostMapping("/removeMember")
    public ApiResponse removeMember(AlbumReqDto albumReqDto){
        //根据相册ID和用户Id的列表批量移除成员
        boolean result = albumService.removeMember(albumReqDto.getAlbumId(), albumReqDto.getUserIdList());
        return ApiResponse.success(result);
    }

    @RequestMapping("/savePhoto")
    @ResponseBody
    public String savePhoto(@RequestParam(value = "file", required = false)MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        JSONObject obj = new JSONObject();
        File targetFile = null;
        String url = "";// 返回存储路径
        String fileName = file.getOriginalFilename();// 获取文件名加后缀
        if (fileName != null && fileName != "") {
            //文件存储位置
            ServletContext scontext = request.getSession().getServletContext();
            // 获取绝对路径
            String path = "E:\\毕业设计\\时光相册\\timeAlbum\\src\\main\\resources\\static\\img";
            String lastname = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
            fileName = new Date().getTime() + "_" + new Random().nextInt(1000) + lastname;//当前时间+随机数=新的文件名
            // 如果文件夹不存在则创建
            File pathfile = new File(path);
            if (!pathfile.exists()) {
                pathfile.mkdirs();
            }
            // 将图片存入文件夹
            targetFile = new File(path, fileName);
            try {
                // 将上传的文件写到服务器上指定的文件。
                file.transferTo(targetFile);
                obj.put("success", true);
                url = fileName;//保存路径，便于后续存入数据库
            } catch (Exception e) {
                e.printStackTrace();
                obj.put("success", false);
                obj.put("errorMsg", e.getMessage());
            }
        }
        obj.put("imgurl", url);
        return obj.toString();
    }

    @RequestMapping("/saveVideo")
    @ResponseBody
    public String saveVideo(@RequestParam(value = "file", required = false)MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        JSONObject obj = new JSONObject();
        File targetFile = null;
        String url = "";// 返回存储路径
        String fileName = file.getOriginalFilename();// 获取文件名加后缀
        if (fileName != null && fileName != "") {
            //文件存储位置
            ServletContext scontext = request.getSession().getServletContext();
            // 获取绝对路径
            String path = "E:\\毕业设计\\时光相册\\timeAlbum\\src\\main\\resources\\static\\video";
            String lastname = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
            fileName = new Date().getTime() + "_" + new Random().nextInt(1000) + lastname;//当前时间+随机数=新的文件名
            // 如果文件夹不存在则创建
            File pathfile = new File(path);
            if (!pathfile.exists()) {
                pathfile.mkdirs();
            }
            // 将图片存入文件夹
            targetFile = new File(path, fileName);
            try {
                // 将上传的文件写到服务器上指定的文件。
                file.transferTo(targetFile);
                obj.put("success", true);
                url = fileName;//保存路径，便于后续存入数据库
            } catch (Exception e) {
                e.printStackTrace();
                obj.put("success", false);
                obj.put("errorMsg", e.getMessage());
            }
        }
        obj.put("videourl", url);
        return obj.toString();
    }
}
