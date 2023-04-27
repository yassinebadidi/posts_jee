package com.example.demo.ressource;

import com.example.demo.dao.PostJdbcDao;
import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import com.sun.research.ws.wadl.Response;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("posts")
public class PostResource {
    PostJdbcDao postJdbcDao = new PostJdbcDao();
    PostService postService = new PostService();
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Post> findAll(){

        return postService.fetchAllPosts();
    }
    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Post getPostById(@PathParam("id") long id){
        return postService.findById(id);
    }
    /*@POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response creatPost(Post post){
        postJdbcDao.create(post);
        return Response
                .status(Response.Status.CREATED)
                .entity(post)
                .build();
    }
    @DELETE
    @Path("/delete/{id}")
    public void delete(@PathParam("id") int id) {
        Post postToDelete = postJdbcDao.findById(id);
        postJdbcDao.delete(postToDelete);
    }
    @PUT
    @Path("/edit/{id}")
    public Post update(@PathParam("id") int id,Post newPost) {
        Post postToUpdate = postJdbcDao.findById(id);
        newPost.setId(postToUpdate.getId());
        postJdbcDao.update(newPost);
        return newPost;
    }*/
}
