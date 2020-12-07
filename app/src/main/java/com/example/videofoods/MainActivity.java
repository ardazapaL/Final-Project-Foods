package com.example.videofoods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String linkVideo = "https://firebasestorage.googleapis.com/v0/b/mayonai.appspot.com/o/video1.mp4?alt=media&token=f47e6ca1-72c0-46dd-b546-3eeeb98f28bc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final ViewPager2 viewPager2 = findViewById(R.id.viewpager);

        List<VideoItem> videoItems = new ArrayList<>();

        VideoItem videoItemCelebration = new VideoItem();
        videoItemCelebration.videoURL = linkVideo;
        videoItemCelebration.videoTitle = "Video Pertama";
        videoItemCelebration.videoDesc = "Ini Video Pertama";
        videoItems.add(videoItemCelebration);

        VideoItem videoItemParty = new VideoItem();
        videoItemParty.videoURL = linkVideo;
        videoItemParty.videoTitle = "Video Kedua";
        videoItemParty.videoDesc = "Ini Video Kedua";
        videoItems.add(videoItemParty);

        viewPager2.setAdapter(new VideoAdapter(videoItems));
    }
}