package com.example.demo.service;

import com.example.demo.dao.CategoryJdbcDao;
import com.example.demo.dao.PostDao;
import com.example.demo.dao.PostJdbcDao;
import com.example.demo.model.Category;
import com.example.demo.model.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

// CRUD
public class PostService {

    private PostDao postDao = new PostJdbcDao();

    public List<Post> fetchAllPosts() {
        return postDao.findAll();
    }
    public Post findById(Long id) {return postDao.findById(id);}

    public Post createPost(String title, String author, String content, String pictureUrl, Long category_id ) {
        LocalDateTime time = LocalDateTime.now();
        CategoryJdbcDao categoryJdbcDao = new CategoryJdbcDao();
        Category category = categoryJdbcDao.findById(category_id);
        Post p = new Post(title,author,content,pictureUrl,time,category);
        throw new RuntimeException();
    }


//    public Post createPost(String title, String author, String content) {
//        Post p = new Post(++idSequence, title, author, content, "https://picsum.photos/200/300?random=" + idSequence);
//        posts.add(p);
//        return p;
//    }


}
