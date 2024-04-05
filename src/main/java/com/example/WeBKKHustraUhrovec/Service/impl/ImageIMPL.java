package com.example.WeBKKHustraUhrovec.Service.impl;

import com.example.WeBKKHustraUhrovec.Entity.Image;
import com.example.WeBKKHustraUhrovec.Entity.News;
import com.example.WeBKKHustraUhrovec.Repo.ImageRepo;
import com.example.WeBKKHustraUhrovec.Repo.NewsRepo;
import com.example.WeBKKHustraUhrovec.Service.ImageService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;


@Service
public class ImageIMPL implements ImageService {

    @Autowired
    private ImageRepo imageRepo;

    @Value("${file.upload.path}")
    private String fileUploadPath;

    @Autowired
    private NewsRepo newsRepo;

    @Transactional
    @Override
    public Image addImage(MultipartFile file) {
        try {
            // Generate a unique filename
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

            Image imageEntity = new Image();

            Path filePath = Paths.get(fileUploadPath, fileName);

            imageEntity.setUrl(filePath.toString());

            imageEntity.setName(fileName);

            imageEntity = imageRepo.save(imageEntity);

            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            return imageEntity;
        } catch (IOException e) {
            throw new RuntimeException("Failed to save image", e);
        }
    }

    @Override
    public Image getImageByName(String imageName) {
        return imageRepo.findImageByName(imageName);
    }

    @Override
    public List<Image> getAllImages() {
        return imageRepo.findAll();
    }

    @Override
    public byte[] getImage(String imageName) {
        try {

            String filePath = fileUploadPath + "/" + imageName;


            Path imagePath = Paths.get(filePath);
            return Files.readAllBytes(imagePath);
        } catch (IOException e) {

            e.printStackTrace();

            throw new RuntimeException("Failed to load image", e);
        }
    }

    @Transactional
    @Override
    public void deleteImage(Long id) {

        Image image = imageRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found with id: " + id));

        List<News> newsList = newsRepo.findAllByImage(image);
        if (!newsList.isEmpty()) {
            throw new RuntimeException("Cannot delete image because it is associated with news.");
        }

        try {
            Files.delete(Paths.get(image.getUrl()));
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete image file", e);
        }


        imageRepo.deleteById(id);
    }
}
