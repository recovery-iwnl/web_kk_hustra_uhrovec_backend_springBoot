package com.example.WeBKKHustraUhrovec.Service;


import com.example.WeBKKHustraUhrovec.Entity.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface ImageService {

    Image addImage(MultipartFile file);

    Image getImageByName(String imageName);

    List<Image> getAllImages();

    byte[] getImage(String imageName);

    void deleteImage(Long id);

}
