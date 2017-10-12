package halit.education.com.educationfirst;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

        Button mShowDialog = (Button) findViewById(R.id.btnShowDialog);

        mShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_login,null);
                final EditText mEmail = (EditText) mView.findViewById(R.id.Firma);
                final EditText mPassword = (EditText) mView.findViewById(R.id.Ciro);


                mBuilder.setPositiveButton("Kaydet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

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
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                            if (!mPassword.getText().toString().isEmpty()) {
                                Toast.makeText(MainActivity.this, R.string.success_login_msg, Toast.LENGTH_SHORT).show();

                                dialog.dismiss();
                            } else {
                                Toast.makeText(MainActivity.this, R.string.error_login_msg, Toast.LENGTH_SHORT).show();
                            }

                    }
                });


            }
        });

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
