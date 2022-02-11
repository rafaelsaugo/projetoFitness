package co.tiagoaguiar.codelab.myapplication;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoAbdcJoelhoMiniband extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_abd_remador);

        VideoView videoView = findViewById(R.id.vvFull);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.abducao_elevacao_joelho_c_miniband);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}