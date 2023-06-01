package com.example.non_suicidal_app;

import android.app.Application;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;

public class viewholder extends RecyclerView.ViewHolder {
    SimpleExoPlayerView simpleExoPlayerView;
    SimpleExoPlayer simpleExoPlayer;
    public viewholder(@NonNull View itemView) {
        super(itemView);

    }
     void setExoplayer(Application application,String name,String url){
         TextView video_name=itemView.findViewById(R.id.video_name);
         simpleExoPlayerView=itemView.findViewById(R.id.exoplayer);
         video_name.setText(name);
try {
    BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
    TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
    simpleExoPlayer = (SimpleExoPlayer) ExoPlayerFactory.newSimpleInstance(application, trackSelector);

    Uri videoURI = Uri.parse(url);

    DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("exoplayer_video");
    ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
    MediaSource mediaSource = new ExtractorMediaSource(videoURI, dataSourceFactory, extractorsFactory, null, null);

    simpleExoPlayerView.setPlayer(simpleExoPlayer);
    simpleExoPlayer.prepare(mediaSource);
    simpleExoPlayer.setPlayWhenReady(false);
}catch (Exception e){
    Log.d("Exoplayer crashed",e.getMessage().toString());
}
    }
}
