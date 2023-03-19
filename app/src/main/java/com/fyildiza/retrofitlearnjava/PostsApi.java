package com.fyildiza.retrofitlearnjava;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostsApi {
    //https://jsonplaceholder.typicode.com/posts
    @GET("posts")
    Call<List<PostsModel>>GetPosts();
}
