package hiw.saad.com.howiwork;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.TabActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

@SuppressLint("NewApi")
@SuppressWarnings("deprecation")
public class EventTab extends TabActivity implements OnTabChangeListener {
	static TabHost tabHost = null;
	public static MenuInflater inflater = null;
	public static MenuItem item;
	//Intent intestTostartService;
	public static Menu menu = null;
	SharedPreferences pref;
	String log;
	ActionBar ab;


	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first);
//		getActionBar().setBackgroundDrawable((new ColorDrawable(Color.parseColor("#829929"))));
		Resources ressources = getResources();
		tabHost = getTabHost();

		for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
			tabHost.getTabWidget().getChildAt(i).setPadding(0, 0, 0, 0);
		}
		//tabHost.getTabWidget().setStripEnabled(false);




		//tabHost.setPadding(0, 0, 0, 0);

	//	tabHost.getTabWidget().setDividerDrawable(null);

		//tabHost.getTabWidget().setBackgroundColor(Color.BLUE);

		//tabHost.getTabWidget().setDividerDrawable(R.color.blue);

	//	tabHost.getTabWidget().setShowDividers(TabWidget.SHOW_DIVIDER_MIDDLE);


//		getActionBar().setHomeButtonEnabled(true);

		
		Intent intentAndroid = new Intent().setClass(this,
				HomeActivity.class);
		TabHost.TabSpec tabSpecAndroid = tabHost
				.newTabSpec("Home")
				.setIndicator("",
						this.getDrawable(R.drawable.home_action))
				.setContent(intentAndroid);


		//spec3.setIndicator("Tab 3", getResources().getDrawable(setBackgroundColor(Color.BLACK));

		Intent intentAnnounce = new Intent().setClass(this, HomeActivity.class);
		TabHost.TabSpec tabSpecAnnounce = tabHost
				.newTabSpec("সুসাস্থ্য")
				.setIndicator("সুসাস্থ্য")
				.setIndicator("",
						ressources.getDrawable(R.drawable.developer_selection))

				.setContent(intentAnnounce);

		
		Intent intentApple = new Intent().setClass(this, FlipComplexLayoutActivity.class);
		TabHost.TabSpec tabSpecApple = tabHost
				.newTabSpec("Tips")
				.setIndicator("Tips")
				.setIndicator("",
						ressources.getDrawable(R.drawable.designer_selecion))

				.setContent(intentApple);

		Intent intentAlbum = new Intent().setClass(this,
				HomeActivity.class);
		TabHost.TabSpec tabSpecAlbum = tabHost
				.newTabSpec("Album")
				.setIndicator("Album")
				.setIndicator("",
						ressources.getDrawable(R.drawable.enterprenur_selection))
				.setContent(intentAlbum);

		Intent intentRsvp = new Intent().setClass(this, HomeActivity.class);
		TabHost.TabSpec tabSpecRsvp = tabHost
				.newTabSpec("Info")
				.setIndicator("Info")
				.setIndicator("",
						ressources.getDrawable(R.drawable.bussiness_selection))
				.setContent(intentRsvp);


		
		// Windows tab

		// add all tabs
		tabHost.addTab(tabSpecAndroid);
		tabHost.addTab(tabSpecAnnounce);
		tabHost.addTab(tabSpecApple);
		tabHost.addTab(tabSpecAlbum);
		tabHost.addTab(tabSpecRsvp);

		// set Windows tab as default (zero based)
		tabHost.setCurrentTab(0);

		tabHost.setOnTabChangedListener(this);

	}

	public TabHost getMyTabHost() {
		return tabHost;
	}

/*	public boolean onCreateOptionsMenu(Menu menu) {
		inflater = getMenuInflater();
		inflater.inflate(R.menu.gallery_menu, menu);
		this.menu = menu;
		//menu.findItem(R.id.take_photo).setVisible(false);
	
		
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// respond to menu item selection
		switch (item.getItemId()) {
		case R.id.take_photo:
			//Intent inP = new Intent(this, PhotoActivity.class);
			//startActivity(inP);
		//	return true;
		
		case android.R.id.home:
			finish();
			Intent intent = new Intent(getApplicationContext(), EventTab.class);
			startActivity(intent);
			return true;

		

		default:
			return super.onOptionsItemSelected(item);
		}
	}*/



	@Override
	public void onTabChanged(String a) {
		// TODO Auto-generated method stub

		if (a == "Album") {
			Log.e("ha", "Hahaha");
		
			//menu.findItem(R.id.take_photo).setVisible(true);
		
		//menu.findItem(R.id.Log_Out).setVisible(false);

		}
		/*if (a == "Home") {
			Resources ressources = getResources();

			Intent intentAndroid = new Intent().setClass(this,
					MainActivity.class);

			TabSpec tabSpecAndroid = tabHost
					.newTabSpec("Home")
					.setIndicator("Home")
					.setIndicator("",
							ressources.getDrawable(R.drawable.tips))

					.setContent(intentAndroid);

			tabHost.addTab(tabSpecAndroid);
		//	menu.findItem(R.id.take_photo).setVisible(false);
			
			//menu.findItem(R.id.Log_Out).setVisible(false);
		}*/
		/*if (a == "Tariff") {

			menu.findItem(R.id.take_photo).setVisible(false);
		
			//menu.findItem(R.id.Log_Out).setVisible(false);
		}

		if (a == "Info") {
			menu.findItem(R.id.take_photo).setVisible(false);
			

			pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0
																				// -
																				// for
																				// private
																				// mode
			log = pref.getString("user_id", null); // getting String
			if (log != null) {
				//menu.findItem(R.id.Log_Out).setVisible(true);
			}

		}

		if (a == "Announce") {

			menu.findItem(R.id.take_photo).setVisible(false);
		
			//menu.findItem(R.id.Log_Out).setVisible(false);
		}

		if (a == "Album") {

			ab = getActionBar();
			ab.setTitle("HEALTH GUARD");
			ab.setDisplayShowTitleEnabled(true);
		}
		if (a == "Home") {

			ab = getActionBar();
			ab.setTitle("HEALTH GUARD");
			ab.setDisplayShowTitleEnabled(true);
		}
		if (a == "Tariff") {

			ab = getActionBar();
			ab.setTitle("Coffee Menu");
			ab.setDisplayShowTitleEnabled(true);
		}

		if (a == "Info") {

			ab = getActionBar();
			ab.setTitle("Info");
			ab.setDisplayShowTitleEnabled(true);
		}

		if (a == "Announce") {

			ab = getActionBar();
			ab.setTitle("Announcement");
			ab.setDisplayShowTitleEnabled(true);
		}*/

	}

}
