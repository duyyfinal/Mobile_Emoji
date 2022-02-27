package com.example.emoji;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.vanniktech.emoji.EmojiPopup;
import com.vanniktech.emoji.EmojiTextView;

public class MainActivity extends AppCompatActivity {
    ImageView btEmoji, btSend;
    EditText etEmoji;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btEmoji = findViewById(R.id.bt_emoji);
        btSend = findViewById(R.id.bt_send);
        etEmoji = findViewById(R.id.et_emoji);
        linearLayout = findViewById(R.id.linear_layout);

        EmojiPopup popup = EmojiPopup.Builder.fromRootView(findViewById(R.id.root_view)).build(etEmoji);
        btEmoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup.toggle();
            }
        });
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EmojiTextView emojiTextView = (EmojiTextView) LayoutInflater.from(view.getContext())
                        .inflate(R.layout.emoji_text_view, linearLayout,false);
                emojiTextView.setText((etEmoji.getText().toString()));
                linearLayout.addView(emojiTextView);
                etEmoji.getText().clear();
            }
        });
    }
}