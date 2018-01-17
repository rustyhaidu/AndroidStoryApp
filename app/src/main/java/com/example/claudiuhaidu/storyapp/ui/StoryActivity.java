package com.example.claudiuhaidu.storyapp.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.claudiuhaidu.storyapp.R;
import com.example.claudiuhaidu.storyapp.model.Choice;
import com.example.claudiuhaidu.storyapp.model.Page;
import com.example.claudiuhaidu.storyapp.model.Story;

import java.util.Stack;

public class StoryActivity extends AppCompatActivity {
    public static final String TAG = StoryActivity.class.getSimpleName();

    private String name;
    private Story story;
    private ImageView storyImageView;
    private TextView storyTextView;
    private Button choice1Button;
    private Button choice2Button;

    private Stack<Integer> pageStack = new Stack<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        storyImageView = findViewById(R.id.storyImageView);
        storyTextView = findViewById(R.id.storyTextView);
        choice1Button = findViewById(R.id.choice1Button);
        choice2Button = findViewById(R.id.choice2Button);

        Intent intent = getIntent();
        name = intent.getStringExtra(getString(R.string.key_name));
        if (name == null || name.isEmpty()) {
            name = "Friend";
        }
        Log.d(TAG, name);

        story = new Story();
        loadPage(0);

    }

    private void loadPage(int pageNumber) {
        pageStack.push(pageNumber);
        final Page page = story.getPage(pageNumber);

        Drawable image = ContextCompat.getDrawable(this, page.getImageId());
        storyImageView.setImageDrawable(image);

        String pageText = getString(page.getTextId());
        pageText = String.format(pageText, name);
        storyTextView.setText(pageText);

        if (page.isFinalPage()) {
            choice1Button.setVisibility(View.INVISIBLE);
            choice2Button.setText(R.string.play_again_button_text);

            choice2Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //finish();
                    pageStack.clear();
                    loadPage(0);
                }
            });
        } else {
            loadButtons(page);
        }
    }

    private void loadButtons(final Page page) {
        choice1Button.setVisibility(View.VISIBLE);
        choice2Button.setVisibility(View.VISIBLE);

        Choice choice1 = page.getChoice1();
        Choice choice2 = page.getChoice2();
        int button1TextId = choice1.getTextId();
        int button2TextId = choice2.getTextId();

        choice1Button.setText(button1TextId);
        choice2Button.setText(button2TextId);

        //choice2Button.setText(String.valueOf(button1TextId));

        choice1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextPage = page.getChoice1().getNextPage();
                loadPage(nextPage);
            }
        });

        choice2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextPage = page.getChoice2().getNextPage();
                loadPage(nextPage);
            }
        });
    }

    @Override
    public void onBackPressed() {
        pageStack.pop();
        if (pageStack.isEmpty()) {
            super.onBackPressed();
        } else {
            loadPage(pageStack.pop());
        }

        // page 1
        // page 0 - is pushed again
    }
}
