package hiw.saad.com.howiwork;

import android.annotation.SuppressLint;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

@SuppressLint("NewApi")
@SuppressWarnings("deprecation")
public class EventTab extends TabActivity {
    static TabHost tabHost = null;
    public static MenuItem item;
    public static Menu menu = null;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);


//set all the tabs

        Resources ressources = getResources();
        tabHost = getTabHost();

        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
            tabHost.getTabWidget().getChildAt(i).setPadding(0, 0, 0, 0);
        }
        tabHost.getTabWidget().setStripEnabled(false);
        tabHost.setPadding(0, 0, 0, 0);
        tabHost.getTabWidget().setDividerDrawable(null);


        //set home tab
        Intent intentHome = new Intent().setClass(this,
                HomeActivity.class);
        TabHost.TabSpec tabSpecHome = tabHost
                .newTabSpec("Home")
                .setIndicator("",
                        this.getDrawable(R.drawable.home_selection))
                .setContent(intentHome);

//set developer tab
        Intent intentDeveloper = new Intent().setClass(this, HomeActivity.class);
        TabHost.TabSpec tabSpecDeveloper = tabHost
                .newTabSpec("developer")
                .setIndicator("developer")
                .setIndicator("",
                        ressources.getDrawable(R.drawable.developer_selection))

                .setContent(intentDeveloper);


        //	set designer tab
        Intent intentDesigner = new Intent().setClass(this, HomeActivity.class);
        TabHost.TabSpec tabSpecDesigner = tabHost
                .newTabSpec("designer")
                .setIndicator("designer")
                .setIndicator("",
                        ressources.getDrawable(R.drawable.designer_selecion))

                .setContent(intentDesigner);


        //set enterprenur tab

        Intent intentEnterprenur = new Intent().setClass(this,
                HomeActivity.class);
        TabHost.TabSpec tabSpecEnterprenur = tabHost
                .newTabSpec("enterprenur")
                .setIndicator("enterprenur")
                .setIndicator("",
                        ressources.getDrawable(R.drawable.enterprenur_selection))
                .setContent(intentEnterprenur);


//		set bussiness tab

        Intent intentBussiness = new Intent().setClass(this, HomeActivity.class);
        TabHost.TabSpec tabSpecBussiness = tabHost
                .newTabSpec("bussiness")
                .setIndicator("bussiness")
                .setIndicator("",
                        ressources.getDrawable(R.drawable.bussiness_selection))
                .setContent(intentBussiness);


        // add all tabs
        tabHost.addTab(tabSpecHome);
        tabHost.addTab(tabSpecDeveloper);
        tabHost.addTab(tabSpecDesigner);
        tabHost.addTab(tabSpecEnterprenur);
        tabHost.addTab(tabSpecBussiness);

        // set Windows tab as default (zero based)
        tabHost.setCurrentTab(0);

        //tabHost.setOnTabChangedListener(this);

    }

    public TabHost getMyTabHost() {
        return tabHost;
    }

	/*@Override
    public void onTabChanged(String a) {
		// TODO Auto-generated method stub

		if (a == "Album") {
			Log.e("ha", "Hahaha");

			//menu.findItem(R.id.take_photo).setVisible(true);

		//menu.findItem(R.id.Log_Out).setVisible(false);

		}


	}*/

}
