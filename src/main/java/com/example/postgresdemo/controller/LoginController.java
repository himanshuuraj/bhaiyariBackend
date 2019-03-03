package com.example.postgresdemo.controller;

import DtoRepository.UploadFileInS3;
import com.example.postgresdemo.entity.Address;
import com.example.postgresdemo.entity.UserInfo;
import com.example.postgresdemo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.UUIDClass;
import javax.xml.bind.DatatypeConverter;
import java.io.*;

@RestController
public class LoginController {

    Integer i = 0;

    @Autowired
    AddressRepository addressRepository;

    @PostMapping("/abc")
    public String done(){
        String base64String = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAK0lEQVRIx2NgGAWjABmUlpb+B+FRC0YtIN4gUvHgsWA0kkctoJ0Fo2BoAgCw7XsZlkfDAwAAAABJRU5ErkJggg==jh";
        String[] strings = base64String.split(",");
        String extension;
        switch (strings[0]) {//check image's extension
            case "data:image/jpeg;base64":
                extension = "jpeg";
                break;
            case "data:image/png;base64":
                extension = "png";
                break;
            default://should write cases for more images types
                extension = "jpg";
                break;
        }
        i++;
        File dir = new File("./abc");
        if (!dir.exists()) dir.mkdir();
        //convert base64 string to binary data
        byte[] data = DatatypeConverter.parseBase64Binary(strings[1]);
        String path = "./test_image" + i.toString() + "." + extension;
        File file = new File(path);
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            outputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "text";
    }

    @RequestMapping("/")
    public String getData(){
        UploadFileInS3 uploadFileInS3 = new UploadFileInS3();
        String data = uploadFileInS3.uploadFile("", "");
        data += UUIDClass.getUUID("AR");
        return data;
    }

    @RequestMapping("/insert")
    public String insertIntoDatabase(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("1");
        userInfo.setName("name");

        Address address = new Address();
        address.getAddressId();
        address.setLine1("line1");

        //AddressAndUserInfo addressAndUserInfo = new AddressAndUserInfo();
        //addressAndUserInfo.setAddress(address);
        //addressAndUserInfo.setUserInfo(userInfo);
        //addressAndUserInfo.setAddressAndUserInfoId("1");
        //userAndAddressInfoRepository.save(addressAndUserInfo);
        return "success";
    }

    @RequestMapping("/hello")
    public String insertIntoAddress(){
        Address address = new Address();
        address.getAddressId();
        address.setLine1("line2");
        addressRepository.save(address);
        return "success";
    }

    @RequestMapping("/post")
    public String insertPost(){
        return "success";
    }

}
