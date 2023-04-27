package com.example.demo.dao;

import com.example.demo.model.Category;
import com.example.demo.model.Post;

import javax.management.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PostJdbcDao implements PostDao {

    @Override
    public List<Post> findAll() {
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT p.id, p.title, p.author, p.content, p.picture_url, p.created_at, c.id AS 'category_id', c.name AS 'category_name' " +
                "FROM posts p " +
                "INNER JOIN categories c ON p.category_fk = c.id";
        List<Post> postList = new ArrayList<>();

        try (Statement pst = connection.createStatement()) {
            ResultSet result = pst.executeQuery(query);

            while (result.next()) {
                Post p = new Post(
                        result.getLong("id"),
                        result.getString("title"),
                        result.getString("author"),
                        result.getString("content"),
                        result.getString("picture_url"),
                        result.getTimestamp("created_at").toLocalDateTime(),
                        new Category( result.getLong("category_id"),result.getString("category_name"))
                );
                postList.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }


    @Override
    public Post create(Post createdPost) {
        Connection connection = ConnectionManager.getInstance();
        String query = "INSERT INTO posts (title, author, content, picture_url, created_at, category_id) VALUES (?,?,?,?,?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,createdPost.getTitle());
            preparedStatement.setString(2,createdPost.getAuthor());
            preparedStatement.setString(3,createdPost.getContent());
            preparedStatement.setString(4,createdPost.getPictureUrl());
            preparedStatement.setTimestamp(5,Timestamp.valueOf(createdPost.getCreatedAt()));
            preparedStatement.setLong(6,createdPost.getCategory().getId());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    createdPost.setId(generatedKeys.getLong(1));
                    return createdPost;
                }
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return createdPost;
    }


    @Override
    public Post findById(Long id) {
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT p.id, p.title, p.author, p.content, p.picture_url, p.created_at, c.id AS category_id, c.name AS category_name FROM posts p INNER JOIN categories c ON p.category_fk = c.id WHERE p.id =?";

        Post postFound = new Post();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            ResultSet result = preparedStatement.executeQuery();
            if(result.next()){
                Category category = new Category(result.getLong("category_id"));

                postFound.setId(result.getLong("id"));
                postFound.setTitle(result.getString("title"));
                postFound.setAuthor(result.getString("author"));
                postFound.setContent(result.getString("content"));
                postFound.setPictureUrl(result.getString("picture_url"));
                postFound.setCreatedAt(result.getTimestamp("created_at").toLocalDateTime());
                postFound.setCategory(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postFound;
    }

    @Override
    public void update(Post entity) {

    }

    @Override
    public void delete(Post entity) {

    }
}
