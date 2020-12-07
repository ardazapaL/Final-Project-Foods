package com.example.videofoods;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder>{

    private List<VideoItem> videoItems;

    public VideoAdapter(List<VideoItem> videoItems) {

        this.videoItems = videoItems;
    }


    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_video,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.setVideoData(videoItems.get(position));
    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    static class VideoViewHolder extends RecyclerView.ViewHolder {

        VideoView videoView;
        TextView foodTitle, foodDesc;
        ProgressBar progressBar;

        public VideoViewHolder(@NonNull View itemView) {

            super(itemView);
            videoView = itemView.findViewById(R.id.video_view);
            foodTitle = itemView.findViewById(R.id.text_name_food);
            foodDesc = itemView.findViewById(R.id.text_desc_food);
            progressBar = itemView.findViewById(R.id.progress_bar);
        }

        void setVideoData (VideoItem videoItem) {

            foodTitle.setText(videoItem.videoTitle);
            foodDesc.setText(videoItem.videoDesc);
            videoView.setVideoPath(videoItem.videoURL);
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {

                    progressBar.setVisibility(View.GONE);
                    mp.start();

                    /*float videoRatio = mp.getVideoWidth() / mp.getVideoHeight();
                    float screenRatio = videoView.getWidth() / videoView.getHeight();

                    float scale = videoRatio / screenRatio;
                    if (scale >= 1f) {

                        videoView.setScaleX(scale);
                    } else {

                        videoView.setScaleY(1f / scale);
                    }*/
                }
            });

            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {

                    mp.start();
                }
            });
        }
    }
}
