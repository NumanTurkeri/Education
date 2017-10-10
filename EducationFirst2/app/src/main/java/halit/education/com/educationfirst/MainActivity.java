package halit.education.com.educationfirst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//TODO buraya bak guncellendımı
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO Bunnları ben yapdım sımdı
        ArrayList<String> benimListem=benimListemiGetir();
    }





    public ArrayList<String> benimListemiGetir(){
        ArrayList<String> dataList=new ArrayList<>();
        return dataList;
    }
}
