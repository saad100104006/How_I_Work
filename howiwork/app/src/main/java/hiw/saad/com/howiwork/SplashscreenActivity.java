package hiw.saad.com.howiwork;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SplashscreenActivity extends Activity implements Animation.AnimationListener {


    ImageView settingView;
    TextView appVersion;
    RelativeLayout relativeLayout;
    Animation animFadein,rotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initializer();
        loadAndSetAnimation();

   //the version number should be shown from the app version
        String versionName = BuildConfig.VERSION_NAME;
        appVersion.setText("v" + versionName);


    }

    @Override
    public void onAnimationEnd(Animation animation) {
        // Take any action after completing the animation

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // TODO Auto-generated method stub

        relativeLayout.startAnimation(animFadein);

    }

    @Override
    public void onAnimationStart(Animation animation) {
        // TODO Auto-generated method stub

    }

    void initializer() {


        relativeLayout = (RelativeLayout) findViewById(R.id.relative_layout);
        settingView = (ImageView) findViewById(R.id.settings);


        appVersion = (TextView) findViewById(R.id.app_version);

    }

    void loadAndSetAnimation() {
        // load the animation
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slideup);

        rotate = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rotate);

        // set animation listener
        animFadein.setAnimationListener(this);
        rotate.setAnimationListener(this);
        relativeLayout.setVisibility(View.VISIBLE);
        settingView.startAnimation(rotate);
        relativeLayout.startAnimation(animFadein);

    }

}