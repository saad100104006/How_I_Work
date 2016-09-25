package hiw.saad.com.howiwork;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.diegocarloslima.fgelv.lib.FloatingGroupExpandableListView;
import com.diegocarloslima.fgelv.lib.WrapperExpandableListAdapter;

import hiw.saad.com.howiwork.Adapters.DetailsAdapter;

public class DetailsActivity extends AppCompatActivity {
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_details);


		final Toolbar toolbar = (Toolbar) findViewById(R.id.tabanim_toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		final FloatingGroupExpandableListView list = (FloatingGroupExpandableListView) findViewById(R.id.sample_activity_list);

        final LayoutInflater inflater = getLayoutInflater();

        final View header = inflater.inflate(R.layout.details_activity_list_header, list, false);
		list.addHeaderView(header);

        final View footer = inflater.inflate(R.layout.details_activity_list_footer, list, false);
		list.addFooterView(footer);
		
		// Even though the child divider has already been set on the layout file, we have to set it again here
		// This prevents a bug where the background turns to the color of the child divider when the list is expanded
		list.setChildDivider(new ColorDrawable(Color.BLACK));
		
		final DetailsAdapter adapter = new DetailsAdapter(this);
		final WrapperExpandableListAdapter wrapperAdapter = new WrapperExpandableListAdapter(adapter);
		list.setAdapter(wrapperAdapter);
		
		for(int i = 0; i < wrapperAdapter.getGroupCount(); i++) {
			list.expandGroup(i);
		}
		
		list.setOnScrollFloatingGroupListener(new FloatingGroupExpandableListView.OnScrollFloatingGroupListener() {
			
			@Override
			public void onScrollFloatingGroupListener(View floatingGroupView, int scrollY) {
				float interpolation = - scrollY / (float) floatingGroupView.getHeight();
				
				// Changing from RGB(10,50,72) to RGB(255,255,255)
				final int greenToWhiteRed = (int) (10 + 245 * interpolation);
				final int greenToWhiteGreen = (int) (50 + 205 * interpolation);
				final int greenToWhiteBlue = (int) (72 + 183 * interpolation);
				final int greenToWhiteColor = Color.argb(255, greenToWhiteRed, greenToWhiteGreen, greenToWhiteBlue);
				
				// Changing from RGB(255,255,255) to RGB(0,0,0)
				final int whiteToBlackRed = (int) (255 - 255 * interpolation);
				final int whiteToBlackGreen = (int) (255 - 255 * interpolation);
				final int whiteToBlackBlue = (int) (255 - 255 * interpolation);
				final int whiteToBlackColor = Color.argb(255, whiteToBlackRed, whiteToBlackGreen, whiteToBlackBlue);
				
				//final ImageView image = (ImageView) floatingGroupView.findViewById(R.id.sample_activity_list_group_item_image);
				//image.setBackgroundColor(greenToWhiteColor);
				
				//final Drawable imageDrawable = image.getDrawable().mutate();
				//imageDrawable.setColorFilter(whiteToBlackColor, PorterDuff.Mode.SRC_ATOP);
				
				final View background = floatingGroupView.findViewById(R.id.sample_activity_list_group_item_background);
				background.setBackgroundColor(greenToWhiteColor);
				
				final TextView text = (TextView) floatingGroupView.findViewById(R.id.sample_activity_list_group_item_text);
				text.setTextColor(whiteToBlackColor);
				
				//final ImageView expanded = (ImageView) floatingGroupView.findViewById(R.id.sample_activity_list_group_expanded_image);
				//final Drawable expandedDrawable = expanded.getDrawable().mutate();
				//expandedDrawable.setColorFilter(whiteToBlackColor, PorterDuff.Mode.SRC_ATOP);
			}
		});
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_main, menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.main:
				//NavUtils.navigateUpFromSameTask(this);

				finish();
				return false;
			default:
				finish();
				return false;
				//return super.onOptionsItemSelected(item);
		}
	}
}
