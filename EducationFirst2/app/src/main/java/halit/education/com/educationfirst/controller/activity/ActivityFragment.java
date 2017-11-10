package halit.education.com.educationfirst.controller.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import halit.education.com.educationfirst.R;
import halit.education.com.educationfirst.controller.adapter.TabsPagerAdapter;

public class ActivityFragment extends AppCompatActivity {
    private ViewPager viewPager;
    TabsPagerAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        ViewPager vpPager = (ViewPager) findViewById(R.id.viewpager);
        myAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(myAdapter);
    }
}
