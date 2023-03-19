package com.fyildiza.retrofitlearnjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {
    ArrayList<PostsModel> postsModels;
    Context context;

    public PostsAdapter(ArrayList<PostsModel> postlar,Context contextim){
        this.postsModels= postlar;
        this.context=contextim;
    }

    @NonNull
    @Override
    public PostsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.posts_row,parent,false);
         return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapter.ViewHolder holder, int position) {
        holder.textViewID.setText(String.valueOf(postsModels.get(position).getId()));
        holder.textViewTitle.setText(postsModels.get(position).getTitle());
        holder.textViewBody.setText(postsModels.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postsModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewID;
        TextView textViewTitle;
        TextView textViewBody;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewID= itemView.findViewById(R.id.TextViewId);
            textViewTitle= itemView.findViewById(R.id.TextViewTitle);
            textViewBody= itemView.findViewById(R.id.TextViewBody);
        }
    }
}
