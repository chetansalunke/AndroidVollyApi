package com.example.apivolly;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserHolder> {

    private List<UserModel> allUserList;

    public UserAdapter(List<UserModel> allUserList) {
        this.allUserList = allUserList;
    }
    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new UserHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        holder.textViewTitle.setText(allUserList.get(position).getTitle());
        holder.textViewDescription.setText(allUserList.get(position).getThumbnailUrl());
    }

    @Override
    public int getItemCount() {
        return allUserList.size();
    }
}
