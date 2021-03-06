package com.divide2.core.web.controller;

import com.divide2.core.data.FileVO;
import com.divide2.core.er.AliOssUploader;
import com.divide2.core.er.QiniuUploader;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author bvvy
 * @date 2018/7/17
 */
@RestController
@Api(tags = "基本")
public class SimpleController {

    private final AliOssUploader aliOssUploader;
    private final QiniuUploader qiniuUploader;

    public SimpleController(AliOssUploader aliOssUploader,
                            QiniuUploader qiniuUploader) {
        this.aliOssUploader = aliOssUploader;
        this.qiniuUploader = qiniuUploader;
    }

    @ApiOperation("图片上传")
    @PostMapping("/v1/upload/image")
    public ResponseEntity<FileVO> upload(@RequestPart MultipartFile file) {
        return ResponseEntity.ok(FileVO.of(qiniuUploader.imageUpload(file)));
    }

}
