package com.example.WeBKKHustraUhrovec.Service.impl;

import com.example.WeBKKHustraUhrovec.Entity.Image;
import com.example.WeBKKHustraUhrovec.Repo.ImageRepo;
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
    private ResourceLoader resourceLoader;

    @Transactional
    @Override
    public Image addImage(MultipartFile file) {
        try {
            // Generate a unique filename
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

            // Create an ImageEntity
            Image imageEntity = new Image();

            // Construct the file path using Paths.get() for better cross-platform compatibility
            Path filePath = Paths.get(fileUploadPath, fileName);
            imageEntity.setUrl(filePath.toString());

            imageEntity.setName(fileName);

            // Save the ImageEntity to the database
            imageEntity = imageRepo.save(imageEntity);

            // Save the file to the configured location
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            return imageEntity;
        } catch (IOException e) {
            throw new RuntimeException("Failed to save image", e);
        }
    }

    @Override
    public List<Image> getAllImages() {
        return imageRepo.findAll();
    }

    @Override
    public byte[] getImage(String imageName) {
        try {
            // Construct the full path of the image file
            String filePath = fileUploadPath + "/" + imageName;

            // Log the file path for debugging
            System.out.println("Image file path: " + filePath);

            // Read the image bytes from the file
            Path imagePath = Paths.get(filePath);
            return Files.readAllBytes(imagePath);
        } catch (IOException e) {
            // Log the exception for debugging
            e.printStackTrace();
            // Handle exception (e.g., log it or throw a custom exception)
            throw new RuntimeException("Failed to load image", e);
        }
    }

    @Transactional
    @Override
    public void deleteImage(Long id) {
        // Find the image by ID
        Image image = imageRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found with id: " + id));

        // Delete the image file
        try {
            Files.delete(Paths.get(image.getUrl()));
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete image file", e);
        }

        // Delete the image entity from the database
        imageRepo.deleteById(id);
    }
}
