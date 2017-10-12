package halit.education.com.educationfirst;

import android.content.DialogInterface;
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

<<<<<<< HEAD
=======






>>>>>>> 2538cee42153d375a35155963a9f5122a2f28be1
import halit.education.com.educationfirst.controller.adapter.CompanyAdapter;
import halit.education.com.educationfirst.model.AdapterItem;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ListView listView;
    CompanyAdapter adapter;
<<<<<<< HEAD

    //TODO benim yeni yaptigim is bu


=======
//TODO ben numan bende yenı ıs olarka bunu yapdım 
>>>>>>> 2538cee42153d375a35155963a9f5122a2f28be1
    ArrayList<AdapterItem> adapterItems=new ArrayList<>();
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

        adapter = new CompanyAdapter(this, adapterItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int itemPosition, long l) {
                AdapterItem adapterItem = adapter.getItem(itemPosition);
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
                //TODO burda edittexten alinan data objeye set edildi.Bu objeleri bir array liste ekledik
                AdapterItem adapterItem=new AdapterItem();
                adapterItem.name=firmaAdi;
                adapterItem.totalCount=ciro;
                adapterItems.add(adapterItem);
                adapter.notifyDataSetChanged();
                checkSize();

            }
        });

        mBuilder.setNegativeButton("Kapat", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();

            }
        });

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();


    }
    public void checkSize(){
        if (adapter.getCount()>0){
            listView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);
            listView.setAdapter(adapter);
        }else {
            listView.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
        }
    }
}