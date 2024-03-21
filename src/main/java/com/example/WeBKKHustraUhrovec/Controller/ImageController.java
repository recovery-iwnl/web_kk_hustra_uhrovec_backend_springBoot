package com.example.WeBKKHustraUhrovec.Controller;

import com.example.WeBKKHustraUhrovec.Entity.Image;
import com.example.WeBKKHustraUhrovec.Service.ImageService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<Image> uploadImage(@RequestParam("file") MultipartFile file) {
        Image savedImage = imageService.addImage(file);
        return ResponseEntity.ok(savedImage);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Image>> getAllImages() {
        List<Image> allImages = imageService.getAllImages();
        return ResponseEntity.ok(allImages);
    }

    @GetMapping("/getImageByName")
    public ResponseEntity<Image> getImageByName(@RequestParam String name) {
        Image image = imageService.getImageByName(name);
        return ResponseEntity.ok(image);
    }

    @GetMapping("/{imageName:.+}")
    public ResponseEntity<ByteArrayResource> serveImage(@PathVariable String imageName) throws IOException {
        byte[] imageBytes = imageService.getImage(imageName);

        if (imageBytes == null) {
            return ResponseEntity.notFound().build();
        }

        ByteArrayResource resource = new ByteArrayResource(imageBytes);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .contentLength(imageBytes.length)
                .body(resource);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
        return ResponseEntity.ok("Image deleted successfully");
    }
}
