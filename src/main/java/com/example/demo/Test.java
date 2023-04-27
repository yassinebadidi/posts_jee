package com.example.demo;

public class Test {
    public static void main(String[] args) {
        System.out.println("SELECT p.id, p.title, p.author, p.content, p.picture_url, p.created_at, c.id AS category_id, c.name AS category_name " +
                "FROM posts p " +
                "INNER JOIN categories c ON p.category_fk = c.id " +
                "WHERE p.id = ?");
        System.out.println("SELECT p.id, p.title, p.author, p.content, p.picture_url, p.created_at, c.id AS category_id, c.name AS category_name" +
                "FROM posts p" +
                "INNER JOIN categories c ON p.category_fk = c.id " +
                "WHERE p.id = ?");
    }
}
