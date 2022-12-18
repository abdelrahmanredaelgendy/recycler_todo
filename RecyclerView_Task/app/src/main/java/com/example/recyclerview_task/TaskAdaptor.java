package com.example.recyclerview_task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdaptor extends RecyclerView.Adapter<TaskAdaptor.MyViewHolder> {
     Context context;
    ArrayList<String> list_task = new ArrayList<>();
    public TaskAdaptor(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<String> task_arr){
        this.list_task=task_arr;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TaskAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_card,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdaptor.MyViewHolder holder, int position) {
        holder.taskTV.setText(list_task.get(position));
    }

    @Override
    public int getItemCount() {
        return list_task.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView taskTV;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            taskTV = itemView.findViewById(R.id.taskTV);

        }
    }
}
