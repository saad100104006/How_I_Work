/*
Copyright 2012 Aphid Mobile

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
 
   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package hiw.saad.com.howiwork;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aphidmobile.flip.FlipViewController;

import hiw.saad.com.howiwork.Adapters.FlipAdapter;

public class FlipActivity extends Activity  {

  private FlipViewController flipView;
  private TextView textView;
  private int[] imageResources;
    LinearLayout lnr;


  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setTitle(R.string.activity_title);

    flipView = new FlipViewController(this);

     // lnr=(LinearLayout)findViewById(R.id.saad);
    //Use RGB_565 can reduce peak memory usage on large screen device, but it's up to you to choose the best bitmap format

      flipView.setAnimationBitmapFormat(Bitmap.Config.RGB_565);
      flipView.setAdapter(new FlipAdapter(this));
      setContentView(flipView);
      System.out.println("saad   " + flipView.getSelectedItemPosition());



  }


  @Override
  protected void onResume() {
    super.onResume();
      flipView.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
    flipView.onPause();
  }




  }


