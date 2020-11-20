package com.firecode.app.controller.util;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

import org.springframework.web.multipart.MultipartFile;

public class UploadMultipartFileUtil {

    @Getter
    @Setter
    private MultipartFile[] fileDatas;

    @Getter
    @Setter
    private List<MultipartFile> listDatas;

}
