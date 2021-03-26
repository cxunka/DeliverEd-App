package com.example.delivered;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> implements ItemTouchHelperAdapter {
    private List<Message> msgList;
    private Context context;

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(msgList,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public void onItemDelete(int position) {
        msgList.remove(position);
        notifyItemRemoved(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView msgContent;
        TextView msgTime;

        public ViewHolder (View view)
        {
            super(view);
            msgContent = (TextView) view.findViewById(R.id.content);
            msgTime = (TextView) view.findViewById(R.id.time);
        }

    }

    public MessageAdapter (Context context, List <Message> msgList){
        this.context = context;
        this.msgList = msgList;
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        Message msg = msgList.get(position);
        holder.msgContent.setBackground(msg.getBackGroundDrawable());
        holder.msgContent.setCompoundDrawablesWithIntrinsicBounds(msg.getImageDrawable(),null,null,null);
        holder.msgContent.setText(msg.getContentId());
        holder.msgTime.setText(msg.getTime());
        holder.msgContent.setVisibility(msg.getVisibility());
        holder.msgTime.setVisibility(msg.getVisibility());
        final AssetManager mgr = context.getAssets();
        Typeface tf = Typeface.createFromAsset(mgr, "ahronbd.ttf");
        holder.msgContent.setTypeface(tf);
        holder.msgTime.setTypeface(tf);
    }

    @Override
    public int getItemCount(){
        return msgList.size();
    }
}
