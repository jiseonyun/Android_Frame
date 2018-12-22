package com.example.jiseo.idolBTS;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiseo.retrofit.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class RecyclerViewHolder extends RecyclerView.ViewHolder
{
    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
    }


}
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void OnItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }





    //data Pair
    private ArrayList<DataPair> mList;
    private Context context;
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView tv_title;
        protected ImageView tv_image;
        protected Button tv_likeButton;

        public CustomViewHolder(View view, final OnItemClickListener listener) {
            super(view);
            this.tv_likeButton= (Button) view.findViewById(R.id.LikeButton);
            this.tv_image = (ImageView) view.findViewById(R.id.tv_item_image);
            this.tv_title = (TextView) view.findViewById(R.id.tv_item_title);
            tv_likeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null)
                    {
                        int position = getAdapterPosition();
                        if(position!= RecyclerView.NO_POSITION){
                            listener.OnItemClick(position);
                        }
                    }
                }
            });
            /*
            *        itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null)
                    {
                        int position = getAdapterPosition();
                        if(position!= RecyclerView.NO_POSITION){
                            listener.OnItemClick(position);
                        }
                    }
                }
            });
            *
            * */
        }

    }
    public CustomAdapter(ArrayList<DataPair> list, Context context) {
        this.mList = list;
        this.context = context;
    }
    // RecyclerView에 새로운 데이터를 보여주기 위해 필요한 ViewHolder를 생성해야 할 때 호출됩니다.
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, null);
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list, viewGroup, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view,mListener);
        return viewHolder;
    }
    // Adapter의 특정 위치(position)에 있는 데이터를 보여줘야 할때 호출됩니다.
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, final int position) {
        viewholder.tv_title.setText(mList.get(position).getTitle());
        Picasso.with(context).load(mList.get(position).getImage()).into(viewholder.tv_image);
    }
    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }
}

/*
* private void postItemClick(RecyclerView.ViewHolder holder)
    {
        if(mOnItemClickListener!= null)
            mOnItemClickListener.onItemClick(holder.itemView, holder.getAdapterPosition());
    }
    @Override
    public void onClick(View v) {
        postItemClick(this);
    }
*
*
* */
