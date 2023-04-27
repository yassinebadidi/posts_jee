package com.example.demo.dao;

import com.example.demo.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CategoryJdbcDao implements CategoryDao{
    @Override
    public Category create(Category entity) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Category findById(Long id) {
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT id, name FROM categories WHERE id=?";

        Category categoryFound = new Category(id);

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            ResultSet result = preparedStatement.executeQuery();
            if(result.next()){
                categoryFound.setName(result.getString("name"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return categoryFound;
    }

    @Override
    public void update(Category entity) {

    }

    @Override
    public void delete(Category entity) {

    }
}
