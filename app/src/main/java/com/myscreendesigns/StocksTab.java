package com.myscreendesigns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tasol on 24/2/17.
 */

public class StocksTab extends Fragment {
    private RecyclerView rv_stocks;
    List<String> userNames= new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    StocksAdapter stocksAdapter;
    Button btnBtn;
    public int RESULT=2;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.stocks_tab_layout,container,false);
        rv_stocks=(RecyclerView)view.findViewById(R.id.rv_stocks);
        linearLayoutManager =new LinearLayoutManager(getActivity());
        rv_stocks.setLayoutManager(linearLayoutManager);
        stocksAdapter = new StocksAdapter();
        btnBtn=(Button)view.findViewById(R.id.btnBtn);

        userNames.add(null);
        userNames.add("pratik");
        userNames.add("dharmesh");
        userNames.add("neeraj");
        userNames.add("jamal");
        userNames.add("arvind");
        userNames.add("mrugen");
        rv_stocks.setAdapter(stocksAdapter);

        btnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),AddNewActivity.class);
                startActivityForResult(intent,RESULT);
            }
        });
        return view;
    }

    private class StocksAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        private static final int TYPE_HEADER=0;
        private static final int TYPE_FOOTER=1;

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            if(viewType==TYPE_HEADER){
                View parentView=LayoutInflater.from(parent.getContext()).inflate(R.layout.stocks_item_header,parent,false);
                RecyclerView.ViewHolder holder=new HeaderViewHolder(parentView);
                return holder;
            }else if(viewType==TYPE_FOOTER){
                View parentView=LayoutInflater.from(parent.getContext()).inflate(R.layout.stocks_item_footer,parent,false);
                RecyclerView.ViewHolder holder=new FooterViewHolder(parentView);
                return holder;
            }

            return null;
        }

        @Override
        public int getItemViewType(int position) {
            if(position==0){
                return TYPE_HEADER;
            }else{
                return TYPE_FOOTER;
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if(holder instanceof FooterViewHolder){
                final FooterViewHolder holderFooter =(FooterViewHolder)holder;
//                holderFooter.user_name.setText(userNames.get(position));
            }
        }

        @Override
        public int getItemCount() {
            return userNames.size();
        }

        public class HeaderViewHolder extends RecyclerView.ViewHolder{

            public HeaderViewHolder(View itemView) {
                super(itemView);
            }
        }

        public class FooterViewHolder extends RecyclerView.ViewHolder{
//            public TextView user_name;

            public FooterViewHolder(View itemView) {
                super(itemView);
//                user_name=(TextView)itemView.findViewById(R.id.user_name);
            }
        }
    }

}
