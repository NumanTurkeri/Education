package halit.education.com.educationfirst.controller.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import halit.education.com.educationfirst.R;
import halit.education.com.educationfirst.model.AdapterItem;

public class DetailActivity extends AppCompatActivity {
    AdapterItem adapterItem = null;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView=(TextView)findViewById(R.id.textView);
        //TODO Yeni olan kisim burasi burda getntent methodu ile gelen intentin icinde datayi key ile alacagiz;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            //TODO nu ll kontrolu yapiyoruz cunku aktivity hem paramtrelei yani extras li hemde extrassizkullanilablr
            adapterItem = (AdapterItem) extras.getSerializable("myKey");
            textView.setText(adapterItem.name+" "+adapterItem.totalCount);
        }else {
            textView.setText("herhangi bir data gelmedi bombos su anda");
        }

    }

}
