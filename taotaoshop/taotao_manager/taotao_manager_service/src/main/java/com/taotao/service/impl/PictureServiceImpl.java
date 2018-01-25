package com.taotao.service.impl;


import com.taotao.common.pojo.PictureResult;
import com.taotao.service.PictureService;
import com.taotao.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2017/9/11.
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Value("${IMAGE_SERVER_BASE_URL}")
    private String IMAGE_SERVER_BASE_URL;

    @Override
    public PictureResult uploadPic(MultipartFile picFile)  {

        PictureResult result = new PictureResult();
        if (picFile.isEmpty())
        {
            result.setError(1);
            result.setMessage("图片为空");
            return result;
        }
        try {
            //取图片扩展名
            String originalFilename = picFile.getOriginalFilename();
            //取扩展名不要“.”
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            FastDFSClient client = new FastDFSClient("F:\\taotao_shop\\taotaoshop\\taotao_manager\\taotao_manager_web\\src\\main\\resources\\properties\\client.conf");
            String url_pic = client.uploadFile(picFile.getBytes(), extName);
            String url_pic_server = IMAGE_SERVER_BASE_URL;
            String url= url_pic_server+url_pic;
            System.out.println(url);
            //把url响应给客户端
            result.setError(0);
            result.setUrl(url);
        } catch (Exception e) {
            e.printStackTrace();
            result.setError(1);
            result.setMessage("图片上传失败");
        }
        return result;
    }

    }
