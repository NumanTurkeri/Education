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
        //TODO Simdi umararim olur :)
        ArrayList<AdapterItem> benimListem=benimListemiGetir();
    }

<<<<<<< HEAD
=======



>>>>>>> f8f0365decceda1ff68777273b9b299baf43ca3c
    public ArrayList<AdapterItem> benimListemiGetir(){
        ArrayList<AdapterItem> dataList=new ArrayList<>();
        return dataList;
    }
}
