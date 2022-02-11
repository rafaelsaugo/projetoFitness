package co.tiagoaguiar.codelab.myapplication;

import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoAfundoTeste extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_abd_remador);

        videoView = videoView.findViewById(R.id.vvFull);
        videoView.setVideoPath("https://filedropper.com/d/s/KUZMHK9yMmCVWKjrnt4a8u9ZRIeW7T");
        videoView.start();
    }
}