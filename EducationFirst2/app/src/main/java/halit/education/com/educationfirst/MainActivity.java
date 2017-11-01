package halit.education.com.educationfirst;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import halit.education.com.educationfirst.controller.activity.DetailActivity;
import halit.education.com.educationfirst.controller.adapter.CompanyAdapter;
import halit.education.com.educationfirst.controller.managers.CustomePrefManager;
import halit.education.com.educationfirst.model.AdapterItem;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ListView listView;
    CompanyAdapter adapter;
    ArrayList<AdapterItem> adapterItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });


        textView = (TextView) findViewById(R.id.descTxt);
        listView = (ListView) findViewById(R.id.listView);


        //TODO Buraya break point koy ve ne oldugunu iyi takip et lutfen.Simdi burdaki hikaye su biz uygulama acilrken once history yi alacgiz.
        // History bos ise gene bos gocukcek ama history dolu ise artik listemiz surekli olarak uygulamada silinmeden kaybolmadan gozukebielcek
     adapterItems=CustomePrefManager.getAllSavedData();
     if (adapterItems==null){
         //Todo burda null kontrolu ekledik cunku null olan bir field yada lsite ile islem yapilmaz.NUll degilse buraya girmeycek
         adapterItems=new ArrayList<>();
     }
        adapter = new CompanyAdapter(this, adapterItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int itemPosition, long l) {
                AdapterItem adapterItem = adapter.getItem(itemPosition);
                //TODO Burda item click alindi.
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("myKey", adapterItem);
                startActivity(intent);
            }
        });
        if (adapter.getCount() == 0) {

            textView.setVisibility(View.VISIBLE);
        } else {
            textView.setVisibility(View.GONE);
        }
    }

    public ArrayList<AdapterItem> benimListemiGetir() {
        ArrayList<AdapterItem> dataList = new ArrayList<>();
        return dataList;
    }

    public void openDialog() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_login, null);
        final EditText mEmail = (EditText) mView.findViewById(R.id.Firma);
        final EditText mPassword = (EditText) mView.findViewById(R.id.Ciro);


        mBuilder.setPositiveButton("Kaydet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String firmaAdi = mEmail.getText().toString();
                String ciro = mPassword.getText().toString();
                AdapterItem adapterItem = new AdapterItem();
                adapterItem.name = firmaAdi;
                adapterItem.totalCount = ciro;
                adapterItems.add(adapterItem);
                adapter.notifyDataSetChanged();
                checkSize();
                //TOdo burda zaten yukarida zaten olstrdgmz objeyi verdik.
                SharedPrefSAVE(adapterItem);


            }
        });

        mBuilder.setNegativeButton("Kapat", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                SharedPreferences SP = getApplicationContext().getSharedPreferences("NAME", 0);
                textView.setText(SP.getString("Name", null));

                dialogInterface.dismiss();

            }
        });

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();


    }

    public void checkSize() {
        if (adapter.getCount() > 0) {
            listView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);
            listView.setAdapter(adapter);
        } else {
            listView.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
        }

    }

    //TODO Artik burasi pbje paramtresi ile calisacak.Aldi objeyi arka tarda CustomPrefMNager klasi kaydedecek.Bu kod temizligi ve daginikligi sagl.
    //TODO asagidaki Custom pref manager shared preferences a kaydedilecek olan veya kayitlari alacak olan tum islemleri yapacak kalstir.
    public void SharedPrefSAVE(AdapterItem adapterItem) {
        CustomePrefManager.saveItem(adapterItem);
    }
}