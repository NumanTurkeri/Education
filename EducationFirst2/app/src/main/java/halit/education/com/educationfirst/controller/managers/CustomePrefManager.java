package halit.education.com.educationfirst.controller.managers;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import halit.education.com.educationfirst.Education;
import halit.education.com.educationfirst.controller.constant.RuntimeConstant;
import halit.education.com.educationfirst.model.AdapterItem;

/**
 * Created by numan_turkeri on 1.11.2017.
 */

public class CustomePrefManager {
    //TODO bu method daha once kayit edilmis itemlari verir
    public static ArrayList<AdapterItem> getAllSavedData() {
        ArrayList<AdapterItem> userArrayList = new ArrayList<>();

        String val = Education.shared.getString(RuntimeConstant.LIST_KEY, "");
        if (val.equals("")) {
            userArrayList = new ArrayList<>();
        } else {
            Type type = new TypeToken<ArrayList<AdapterItem>>() {
            }.getType();
            userArrayList = Education.gson.fromJson(val, type);
        }
        return userArrayList;
    }

    public static void saveItem(AdapterItem adapterItem) {
       //Todo burda oncelkle dha once kaydedilmis datalar var ise onlari aldik boylelkle eski datayi kaybetmicez
        ArrayList<AdapterItem> userArrayList = getAllSavedData();
        if (userArrayList == null) {
            //TODO ilk app acilirken henuz bos donecegi icin yukaridaki kaytli sonuclar methodu burda kontrol ekledik hata almamak icin.Cunku orda kayit yoksa sonuc nul doner null arrayla de hicbir islem yaplmaz.

            userArrayList = new ArrayList<>();
        }
        userArrayList.add(adapterItem);
        Type type = new TypeToken<ArrayList<AdapterItem>>() {
        }.getType();
        String val = Education.gson.toJson(userArrayList, type);


         //Todo simdi sira normal shared a kaydetmeye geldi.Buraya kadar daha once shared da kayitli datamiz var ise once onu aldik sonra onu array cevrik ve elimizdeki objeyi o arraya ekledik sonra uye sayisi bir artmis oldu.Ve yenilenen listeyi stringe cvrp tekrar shareda eklcezz
        //TODO ayrica RuntimeConstant.LIST_KEY su klasa gidilirse bir strin aalan gorlr burdaki amac kod temizligini sgalamktir.Dikkat edilirse field stictir ve publictir boylelkle her tarfdan ulasilabilir
        //Todo ve Education clasinin icinde ki editor ,shared bve gsonda statik ve publktir.Amac her yerde kullanilabilecek olan bir degiskeni hem daha fzla olstrp performans sikintisi olustrmadan kullanmak hemde kolay kullanmdr


        Education.editor.putString(RuntimeConstant.LIST_KEY, val);
        Education.editor.commit();
    }
}
