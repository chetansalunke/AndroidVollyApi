package com.example.apivolly;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserHolder extends RecyclerView.ViewHolder {
    TextView textViewTitle;
    TextView textViewDescription;
    public UserHolder(@NonNull View itemView) {
        super(itemView);
        textViewTitle= itemView.findViewById(R.id.textViewTitle);
        textViewDescription= itemView.findViewById(R.id.textViewDescription);
    }
}
