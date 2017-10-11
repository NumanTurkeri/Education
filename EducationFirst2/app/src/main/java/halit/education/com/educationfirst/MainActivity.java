package halit.education.com.educationfirst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import halit.education.com.educationfirst.controller.adapter.CompanyAdapter;
import halit.education.com.educationfirst.model.AdapterItem;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ListView listView;
    CompanyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = (TextView) findViewById(R.id.descTxt);
        listView = (ListView) findViewById(R.id.listView);

        ArrayList<AdapterItem> benimListem = benimListemiGetir();

        adapter = new CompanyAdapter(this, benimListem);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int itemPosition, long l) {
                AdapterItem adapterItem = adapter.getItem(itemPosition);
            }
        });

        //TODO adapter size ı yanı count methodu su an bizim listemiz bos oldugu ıcın bos donecek.Ole oldugu ıcınde asagıdakı kosullara gırecek
        if (adapter.getCount()==0){

            textView.setVisibility(View.VISIBLE);
        }else {
            textView.setVisibility(View.GONE);
        }
    }

    public ArrayList<AdapterItem> benimListemiGetir() {
        ArrayList<AdapterItem> dataList = new ArrayList<>();
        return dataList;
    }
}
