package com.eftimoff.udacitypopmovies.app.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class VideoHelper {

    private Context context;

    public VideoHelper(Context context) {
        this.context = context;
    }

    public void watchYoutubeVideo(final String key) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + key));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.youtube.com/watch?v=" + key));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
