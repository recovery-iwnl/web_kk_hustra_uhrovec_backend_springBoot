package com.example.WeBKKHustraUhrovec.Controller;


import com.example.WeBKKHustraUhrovec.Entity.News;
import com.example.WeBKKHustraUhrovec.Service.NewsService;
import com.example.WeBKKHustraUhrovec.jwt.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private Validation validation;

    @PostMapping(path = "/save")
    public ResponseEntity<?> saveNews(@RequestBody News news,
                                        @RequestHeader(value = "Authorization", required = false) String token) {
        ResponseEntity<?> validationResponse = validation.validateTokenAndGetUser(token);
        if (validationResponse != null) {
            return validationResponse;
        }
        return ResponseEntity.ok(newsService.addNews(news));
    }

    @GetMapping(path = "/getAllNews")
    public ResponseEntity<?> getAllNews() {
        return ResponseEntity.ok(newsService.getAllNews());
    }

    @GetMapping(path = "/getNews")
    public ResponseEntity<?> getSingleNewsById(@RequestParam String id) {
        return ResponseEntity.ok(newsService.getNews(id));
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> updateNews(@RequestBody News news,
                                      @RequestHeader(value = "Authorization", required = false) String token) {
        ResponseEntity<?> validationResponse = validation.validateTokenAndGetUser(token);
        if (validationResponse != null) {
            return validationResponse;
        }
        return ResponseEntity.ok(newsService.updateNews(news));
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<?> deleteNews(@RequestParam String id,
                                      @RequestHeader(value = "Authorization", required = false) String token) {
        ResponseEntity<?> validationResponse = validation.validateTokenAndGetUser(token);
        if (validationResponse != null) {
            return validationResponse;
        }
        return ResponseEntity.ok(newsService.deleteNews(id));
    }
}
