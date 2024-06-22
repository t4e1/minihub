package com.t4e1.minihub.command.aws;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface S3Service {

    public List<String> s3Upload(List<MultipartFile> multipartFiles);

}
