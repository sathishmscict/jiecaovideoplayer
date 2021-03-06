package fm.jiecao.jiecaovideoplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.nostra13.universalimageloader.core.ImageLoader;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCFullScreenActivity;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerSimple;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import fm.jiecao.jiecaovideoplayer.View.JCVideoPlayerStandardWithShareButton;

/**
 * Created by Nathen
 * On 2016/04/15 11:25
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    JCVideoPlayerSimple jcVideoPlayerSimple;
    JCVideoPlayerStandard jcVideoPlayerStandard;
    JCVideoPlayerStandardWithShareButton jcVideoPlayerStandardWithShareButton;
    Button btnToFullscreen_simple, btnToFullscreen_standard,
            btnToListActivity, btnToListViewPagerActivity, btnToImageLoadActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToFullscreen_simple = (Button) findViewById(R.id.to_fullscreen_simple);
        btnToFullscreen_standard = (Button) findViewById(R.id.to_fullscreen_standard);
        btnToListActivity = (Button) findViewById(R.id.to_list_activity);
        btnToListViewPagerActivity = (Button) findViewById(R.id.to_list_viewpager_activity);
        btnToImageLoadActivity = (Button) findViewById(R.id.to_loadimage_activity);
        btnToFullscreen_simple.setOnClickListener(this);
        btnToFullscreen_standard.setOnClickListener(this);
        btnToListActivity.setOnClickListener(this);
        btnToListViewPagerActivity.setOnClickListener(this);
        btnToImageLoadActivity.setOnClickListener(this);

        jcVideoPlayerSimple = (JCVideoPlayerSimple) findViewById(R.id.custom_videoplayer);
        jcVideoPlayerSimple.setUp("http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4");

        jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.custom_videoplayer_standard);
        jcVideoPlayerStandard.setUp("http://2449.vod.myqcloud.com/2449_bfbbfa3cea8f11e5aac3db03cda99974.f20.mp4"
                , "嫂子想我没");
        ImageLoader.getInstance().displayImage("http://p.qpic.cn/videoyun/0/2449_bfbbfa3cea8f11e5aac3db03cda99974_1/640",
                jcVideoPlayerStandard.ivThumb);

        jcVideoPlayerStandardWithShareButton = (JCVideoPlayerStandardWithShareButton) findViewById(R.id.custom_videoplayer_standard_with_share_button);
        jcVideoPlayerStandardWithShareButton.setUp("http://gslb.miaopai.com/stream/ed5HCfnhovu3tyIQAiv60Q__.mp4"
                , "嫂子闭眼睛");
        ImageLoader.getInstance().displayImage("http://img4.jiecaojingxuan.com/2016/3/14/2204a578-609b-440e-8af7-a0ee17ff3aee.jpg",
                jcVideoPlayerStandardWithShareButton.ivThumb);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.to_fullscreen_simple:
                JCFullScreenActivity.toActivity(this,
                        "http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4",
                        JCVideoPlayerSimple.class, "嫂子真浪");
                break;
            case R.id.to_fullscreen_standard:
                JCFullScreenActivity.toActivity(this,
                        "http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4",
                        JCVideoPlayerStandard.class, "嫂子真牛逼");
                break;
            case R.id.to_list_activity:
                startActivity(new Intent(MainActivity.this, ListActivity.class));
                break;
            case R.id.to_list_viewpager_activity:
                startActivity(new Intent(MainActivity.this, ListViewpagerActivity.class));
                break;
            case R.id.to_loadimage_activity:
                startActivity(new Intent(MainActivity.this, LoadImageActivity.class));
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
