package com.taotao.fastdfs;

import com.taotao.utils.FastDFSClient;
import org.csource.fastdfs.*;
import org.junit.Test;

/**
 * Created by Administrator on 2017/9/8.
 */
public class FastdfsTest {
    @Test
    public void  testUpload ()  throws Exception

    {



        ClientGlobal.init("F:\\taotao_shop\\taotaoshop\\taotao_manager\\taotao_manager_web\\src\\main\\resources\\properties\\client.conf");

        TrackerClient trackerClient = new TrackerClient();
        // 4、创建一个TrackerServer对象。
        TrackerServer trackerServer = trackerClient.getConnection();
        // 5、声明一个StorageServer对象，null。
        StorageServer storageServer = null;
        // 6、获得StorageClient对象。
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        // 7、直接调用StorageClient对象方法上传文件即可。
        String[] strings = storageClient.upload_file("F:\\BaiduYunDownload\\fastdfs\\4.jpg", "jpeg", null);
        for (String string : strings) {
            System.out.println(string);

        }
    }
    @Test
    public void testFastDfsClient() throws Exception {
        FastDFSClient client = new FastDFSClient("F:\\taotao_shop\\taotaoshop\\taotao_manager\\taotao_manager_web\\src\\main\\resources\\properties\\client.conf");
        String uploadFile = client.uploadFile("F:\\BaiduYunDownload\\fastdfs\\66.jpg", "jpg");
        System.out.println(uploadFile);
    }


}
