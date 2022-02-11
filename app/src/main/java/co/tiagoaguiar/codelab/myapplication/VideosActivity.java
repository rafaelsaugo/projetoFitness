package co.tiagoaguiar.codelab.myapplication;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.abd_perna_elevada_curto);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        VideoView videoView1 = findViewById(R.id.videoView1);
        videoView1.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.abd_russian_twist);
        MediaController mediaController1 = new MediaController(this);
        mediaController1.setAnchorView(videoView1);
        videoView1.setMediaController(mediaController1);

        VideoView videoView2 = findViewById(R.id.videoView2);
        videoView2.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.abdominal_remador_e);
        MediaController mediaController2 = new MediaController(this);
        mediaController2.setAnchorView(videoView2);
        videoView2.setMediaController(mediaController2);

        VideoView videoView3 = findViewById(R.id.videoView3);
        videoView3.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.afundo_agachamento_avanco);
        MediaController mediaController3 = new MediaController(this);
        mediaController3.setAnchorView(videoView3);
        videoView3.setMediaController(mediaController3);

        VideoView videoView4 = findViewById(R.id.videoView4);
        videoView4.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.afundo_alternado_remada_simultaneo);
        MediaController mediaController4 = new MediaController(this);
        mediaController4.setAnchorView(videoView4);
        videoView4.setMediaController(mediaController4);


    }
}