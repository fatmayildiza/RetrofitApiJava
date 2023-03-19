package com.fyildiza.retrofitlearnjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Gson gson = new GsonBuilder().setLenient().create();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Cons.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.Listview);

        GetPost();
    }

    public void initPosts(ArrayList<PostsModel>postsModels){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        PostsAdapter postsAdapter = new PostsAdapter(postsModels,getApplicationContext());
        recyclerView.setAdapter(postsAdapter);

    }



    public void GetPost(){
        PostsApi postsApi = retrofit.create(PostsApi.class);

        Call<List<PostsModel>> call =postsApi.GetPosts();
        call.enqueue(new Callback<List<PostsModel>>() {
            @Override
            public void onResponse(Call<List<PostsModel>> call, Response<List<PostsModel>> response) {
                ArrayList<PostsModel>listem=new ArrayList<>();
                listem=(ArrayList<PostsModel>)response.body();
                initPosts(listem);


            }

            @Override
            public void onFailure(Call<List<PostsModel>> call, Throwable t) {


            }
        });

    }
}