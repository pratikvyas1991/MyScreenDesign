package com.myscreendesigns;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tasol on 24/2/17.
 */

public class UserTab extends Fragment {
    private RecyclerView rv_user;
    List<String> userNames= new ArrayList<>();
    private UserAdapter userAdapter;
    LinearLayoutManager linearLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_tab_layout,container,false);
        rv_user=(RecyclerView)view.findViewById(R.id.rv_user);
        userNames.add("pratik");
        userNames.add("dharmesh");
        userNames.add("neeraj");
        linearLayoutManager = new LinearLayoutManager(getActivity());
        rv_user.setLayoutManager(linearLayoutManager);
        userAdapter = new UserAdapter();
        rv_user.setAdapter(userAdapter);
        return view;

    }

    private class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View parentView =LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item,parent,false);
            RecyclerView.ViewHolder holder = new ViewHolder(parentView);
            return holder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ViewHolder viewHolder= (ViewHolder)holder;
            viewHolder.user_name.setText(userNames.get(position));
        }

        @Override
        public int getItemCount() {
            return userNames.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            public TextView user_name;

            public ViewHolder(View itemView) {
                super(itemView);
                user_name=(TextView)itemView.findViewById(R.id.user_name);
            }
        }
    }
}
