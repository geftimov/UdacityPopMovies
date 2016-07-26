package com.eftimoff.udacitypopmovies.moviedetails.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eftimoff.udacitypopmovies.R;
import com.eftimoff.udacitypopmovies.app.models.Video;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.PostersViewHolder> {

    private VideoAdapterListener videoAdapterListener;
    private List<Video> videos = new ArrayList<>();

    public VideoAdapter(final VideoAdapterListener videoAdapterListener) {
        this.videoAdapterListener = videoAdapterListener;
    }

    @Override
    public PostersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        final PostersViewHolder postersViewHolder = new PostersViewHolder(view);
        setListeners(postersViewHolder);
        return postersViewHolder;
    }

    private void setListeners(final PostersViewHolder postersViewHolder) {
        postersViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int position = postersViewHolder.getAdapterPosition();
                final Video video = videos.get(position);
                videoAdapterListener.onVideoClick(video);
            }
        });
    }

    @Override
    public void onBindViewHolder(final PostersViewHolder holder, int position) {
        final Video video = videos.get(position);
        holder.videoText.setText(video.getName());
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public List<Video> getVideos() {
        return videos;
    }

    public static class PostersViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.videoText)
        TextView videoText;

        public PostersViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
