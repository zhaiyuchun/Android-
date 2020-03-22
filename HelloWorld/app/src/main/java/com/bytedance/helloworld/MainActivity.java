package com.bytedance.helloworld;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.net.Uri;
import android.os.Environment;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity{
    private MediaPlayer mp = new MediaPlayer();
    private VideoView videoView1;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        videoView1=(VideoView)findViewById(R.id.videoView);
        //videoView.setMediaController(new MediaController(this));
        //videoView.setVideoURI(Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/sound.mp3"));
        //videoView.start();
        Button btn1=findViewById(R.id.btn1);

        final MediaPlayer mp= MediaPlayer.create(this,R.raw.test);
        mp.start();
        final TextView tv1=findViewById(R.id.tv1);
        btn1.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            tv1.setText("欢迎来到王者荣耀!");
            mp.stop();
            //videoView.start();
            play_mp4();
            tv1.setText("其实是我崩坏哒!");
        }
    });
}
    private void play_mp4(){
        MediaController localMediaController =new MediaController(this);
        videoView1.setMediaController(localMediaController);
        String uri =("android.resource://"+getPackageName()+"/"+R.raw.bh3);
        videoView1.setVideoURI(Uri.parse(uri));
        videoView1.start();
    }

}

