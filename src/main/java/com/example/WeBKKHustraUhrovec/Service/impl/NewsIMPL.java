package com.example.WeBKKHustraUhrovec.Service.impl;

import com.example.WeBKKHustraUhrovec.Entity.News;
import com.example.WeBKKHustraUhrovec.Repo.ImageRepo;
import com.example.WeBKKHustraUhrovec.Repo.NewsRepo;
import com.example.WeBKKHustraUhrovec.Service.ImageService;
import com.example.WeBKKHustraUhrovec.Service.NewsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsIMPL implements NewsService {


    @Autowired
    private NewsRepo newsRepo;

    @Autowired
    private ImageService imageService;

    @Override
    public News addNews(News news) {
        return newsRepo.save(news);
    }

    @Override
    public String deleteNews(String id) {
        News news = newsRepo.findById(Integer.valueOf(id)).orElse(null);
        if (news == null) {
            return "News with this id doesn't exist.";
        } else {
            newsRepo.deleteById(Integer.valueOf(id));
            imageService.deleteImage(news.getImage().getId());
            return "News deleted successfully.";
        }

    }

    @Override
    public List<News> getAllNews() {
        return newsRepo.findAllByOrderByDateDesc();
    }

    @Override
    public News getNews(String id) {
        return newsRepo.findById(Integer.valueOf(id)).orElse(null);
    }

}
