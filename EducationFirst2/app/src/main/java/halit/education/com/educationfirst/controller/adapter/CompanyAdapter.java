package halit.education.com.educationfirst.controller.adapter;


import android.app.Activity;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import java.util.ArrayList;
import halit.education.com.educationfirst.R;
import halit.education.com.educationfirst.model.AdapterItem;

/**
 * Created by macintoshhd on 16/02/15.
 */
public class CompanyAdapter extends ArrayAdapter<AdapterItem> {

    private Activity context;
    ArrayList<AdapterItem> companyList = new ArrayList<AdapterItem>();
    SharedPreferences sharedPreferences;

    public CompanyAdapter(Activity context, ArrayList<AdapterItem> catalogItemList) {
        super(context, R.layout.activity_main, catalogItemList);
        this.context = context;
        this.companyList = catalogItemList;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final AdapterItem reviews = companyList.get(position);
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_top_spam,
                null, false);

        TextView txtName = (TextView) view.findViewById(R.id.compannNameTxt);
        TextView ciro = (TextView) view.findViewById(R.id.textView3);

        txtName.setText(reviews.name);
        ciro.setText(reviews.totalCount);

        return view;
    }


    @Override
    public int getCount() {

        return super.getCount();

    }


}
