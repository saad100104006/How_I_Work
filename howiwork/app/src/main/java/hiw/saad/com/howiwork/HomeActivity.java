package hiw.saad.com.howiwork;


import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.aphidmobile.flip.FlipViewController;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

/**
 * Created by saad on 9/12/16.
 */
public class HomeActivity extends Activity {

    private int[] imageResources;
    private String[] imageResourcename;
    SliderLayout imageSliderLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setImagesAndString();
        setImageSlider();


    }

    private void setImagesAndString() {
        TypedArray typedArray = getResources().obtainTypedArray(R.array.imagestring);
        if (typedArray != null && typedArray.length() > 0) {
            imageResources = new int[typedArray.length()];
            for (int i = 0; i < typedArray.length(); i++) {
                imageResources[i] = typedArray.getResourceId(i, 0);
                //  imageResourcename[i] = typedArray.getStringArray(i, 0);
                imageResourcename = getResources().getStringArray(R.array.imagesname);

            }
            typedArray.recycle();
        }

    }

    private void setImageSlider() {
        imageSliderLayout =
                (SliderLayout) findViewById(R.id.image_slider);
        for (int i = 0; i < imageResources.length; i++) {
            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView
                    .description(imageResourcename[i])
                    .image(imageResources[i])
                    .setScaleType(BaseSliderView.ScaleType.Fit).setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView baseSliderView) {


                    Toast.makeText(HomeActivity.this, "MY POSTION IS: "+  imageSliderLayout.getCurrentPosition(),
                            Toast.LENGTH_LONG).show();


                }
            })

            ;

            imageSliderLayout.addSlider(textSliderView);
        }
        imageSliderLayout.setPresetTransformer(SliderLayout.Transformer.Default);
        imageSliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Top);
        imageSliderLayout.setCustomAnimation(new DescriptionAnimation());
        imageSliderLayout.setDuration(5000);
    }


}
