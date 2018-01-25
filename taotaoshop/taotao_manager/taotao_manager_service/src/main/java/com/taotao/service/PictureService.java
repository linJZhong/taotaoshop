package com.taotao.service;

import com.taotao.common.pojo.PictureResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2017/9/11.
 */
public interface PictureService {

    PictureResult uploadPic(MultipartFile picFile) ;

}
