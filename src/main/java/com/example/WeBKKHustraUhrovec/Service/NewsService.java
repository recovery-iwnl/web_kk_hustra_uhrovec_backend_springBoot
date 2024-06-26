package com.example.WeBKKHustraUhrovec.Service;

import com.example.WeBKKHustraUhrovec.Entity.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService {
    News addNews(News news);

    String deleteNews(String id);

    String updateNews(News news);

    List<News> getAllNews();
    News getNews(String id);
}
