package com.t4e1.minihub.command.aws;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class S3ServiceImpl implements S3Service{

    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucketName}")
    private String bucketName;

    @Autowired
    public S3ServiceImpl(AmazonS3Client amazonS3Client) {
        this.amazonS3Client = amazonS3Client;
    }

    @Override
    public List<String> s3Upload(List<MultipartFile> imgFiles) {

        List<String> result = new ArrayList<>();

        imgFiles.forEach(
                file -> {
                    Map<String, Object> uploadData = getMetadata(file);

                    try {
                        amazonS3Client.putObject(
                                new PutObjectRequest(bucketName, (String)uploadData.get("name"),
                                        file.getInputStream(), (ObjectMetadata) uploadData.get("metadata"))
                                        .withCannedAcl(CannedAccessControlList.PublicRead));

                        String imagePath = amazonS3Client.getUrl(bucketName, (String)uploadData.get("name")).toString();
                        result.add(imagePath);

                    } catch (AmazonServiceException e) {
                        System.err.println(e.getErrorMessage());
                    } catch (AmazonClientException e) {
                        System.err.println(e.getMessage());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );

        return result;
    }

    private Map<String, Object> getMetadata(MultipartFile file) {

        Map<String, Object> result = new HashMap<>();

        String originName = file.getOriginalFilename();
        String extension = originName.substring(originName.lastIndexOf("."));
        String newName = UUID.randomUUID().toString() + extension;

        long size = file.getSize();

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(file.getContentType());
        objectMetadata.setContentLength(size);

        result.put("name", newName);
        result.put("metadata", objectMetadata);

        return result;
    }

}
