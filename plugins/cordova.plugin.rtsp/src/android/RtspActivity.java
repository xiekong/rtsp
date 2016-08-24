package cordova.plugin.rtsp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;
import android.widget.ImageView;

/**
 * Created by XieKong on 2016-08-22.
 */
public class RtspActivity extends Activity {
    public final static String TAG = "RtspVideoActivity";
    public String rtspUrl;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtspvideo);

        //获取rtspUrl
        rtspUrl = this.getIntent().getStringExtra("rtspUrl");
        VideoView videoView = (VideoView)findViewById(R.id.rtdp_video);
        videoView.setVideoURI(Uri.parse(rtspUrl));
        videoView.requestFocus();
        videoView.start();

        ImageView videoBack = (ImageView) findViewById(R.id.video_back);
        videoBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String message = rtspUrl;
                Intent intent = new Intent();
                intent.putExtra("message", message);
                setResult(Activity.RESULT_OK, intent);
                //关闭该activity，把返回值传回到cordovaPlugin插件
                finish();
            }
        });
    }
}

