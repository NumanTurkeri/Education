package halit.education.com.educationfirst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import halit.education.com.educationfirst.model.AdapterItem;

public class MainActivity extends AppCompatActivity {
//TODO buraya bak guncellendımı
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO Bunnları ben yapdım sımdı
        ArrayList<AdapterItem> benimListem=benimListemiGetir();
    }





    public ArrayList<AdapterItem> benimListemiGetir(){
        ArrayList<AdapterItem> dataList=new ArrayList<>();
        return dataList;
    }
}
