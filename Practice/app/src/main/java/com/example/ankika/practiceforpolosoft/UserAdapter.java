package com.example.ankika.practiceforpolosoft;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ankika on 11/16/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    List<UserModelForOne> forOneList;

    public UserAdapter(List<UserModelForOne> forOneList) {
        this.forOneList = forOneList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, email;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name_text);
            email = view.findViewById(R.id.email_text);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_element, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        UserModelForOne modelForOne = forOneList.get(position);
        holder.name.setText(modelForOne.getName());
        holder.email.setText(modelForOne.getEmail());
    }

    @Override
    public int getItemCount() {
        return forOneList.size();
    }
}
