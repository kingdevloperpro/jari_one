package com.jahir.fast.one.one_Chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jahir.fast.one.MykeepClass.Model_Chat;
import com.jahir.fast.one.R;

import java.util.ArrayList;

public class one_Adp_Chat extends RecyclerView.Adapter<one_Adp_Chat.MessageViewHolder> {
    private ArrayList<Model_Chat> pojoChatGPTMessages;

    public one_Adp_Chat(ArrayList<Model_Chat> pojoChatGPTMessages){
        this.pojoChatGPTMessages = pojoChatGPTMessages;
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout sentLayout;
        private LinearLayout receivedLayout;
        private TextView sentText;
        private TextView receivedText;

        public MessageViewHolder(final View itemView) {
            super(itemView);
            sentLayout = itemView.findViewById(R.id.sentLayout);
            receivedLayout = itemView.findViewById(R.id.receivedLayout);
            sentText = itemView.findViewById(R.id.sentTextView);
            receivedText= itemView.findViewById(R.id.receivedTextView);
        }
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent, false);
        return new MessageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        String message = pojoChatGPTMessages.get(position).getMessage();
        boolean type = pojoChatGPTMessages.get(position).getType();

        if(type){
            holder.sentLayout.setVisibility(LinearLayout.VISIBLE);
            holder.sentText.setText(message);
            holder.receivedLayout.setVisibility(LinearLayout.GONE);
        }
        else{
            holder.receivedLayout.setVisibility(LinearLayout.VISIBLE);
            holder.receivedText.setText(message);
            holder.sentLayout.setVisibility(LinearLayout.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return pojoChatGPTMessages.size();
    }
}
