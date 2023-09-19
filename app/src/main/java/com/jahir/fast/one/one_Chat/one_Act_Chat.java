package com.jahir.fast.one.one_Chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jahir.fast.one.MykeepClass.Model_Chat;
import com.jahir.fast.one.MykeepClass.Req_Chat;
import com.jahir.fast.one.R;
import com.sdk.ads.ads.IntertitialAdsEvent;

import java.util.ArrayList;

public class one_Act_Chat extends AppCompatActivity {
    private ArrayList<Model_Chat> pojoChatGPTMessages;
    private RecyclerView recyclerView;
    private one_Adp_Chat adapter;
    private ImageButton sendButton;
    private EditText msgInput;
    private TextView txtHii;
    private Req_Chat request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two__chat);

        IntertitialAdsEvent.CallInterstitial(this);
        IntertitialAdsEvent.ShowInterstitialAdsOnCreate(this);
        request = new Req_Chat(this);

        recyclerView = findViewById(R.id.recyclerView);
        txtHii = findViewById(R.id.txtHii);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        pojoChatGPTMessages = new ArrayList<>();
        adapter = new one_Adp_Chat(pojoChatGPTMessages);
        recyclerView.setAdapter(adapter);

        sendButton = (ImageButton) findViewById(R.id.msgButton);
        msgInput = (EditText) findViewById(R.id.msgInput);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = msgInput.getText().toString();
                if (message.length() != 0) {
                    txtHii.setVisibility(View.GONE);
                    pojoChatGPTMessages.add(new Model_Chat(true, message));
                    int newPosition = pojoChatGPTMessages.size() - 1;
                    adapter.notifyItemInserted(newPosition);
                    recyclerView.scrollToPosition(newPosition);
                    msgInput.setText("");
                    getReply(message);
                }
            }
        });


    }

    private void getReply(String message) {
        request.getResponse(one_Act_Chat.this, message, new Req_Chat.VolleyResponseListener() {
            @Override
            public void onError(String message) {
            }

            @Override
            public void onResponse(String reply) {
                pojoChatGPTMessages.add(new Model_Chat(false, reply));
                int newPosition = pojoChatGPTMessages.size() - 1;
                adapter.notifyItemInserted(newPosition);
                recyclerView.scrollToPosition(newPosition);
            }
        });

    }

    @Override
    public void onBackPressed() {
        IntertitialAdsEvent.ShowInterstitialAdsOnBack(this);
    }
}