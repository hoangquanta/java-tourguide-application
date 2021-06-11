package funix.prm391.tourguidever3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import funix.prm391.tourguidever3.*;
import funix.prm391.tourguidever3.objectmodel.Option;

public class OptionsAdapter extends BaseAdapter {
    private ArrayList<Option> mOptionArrayList;
    private Context mContent;
    private LayoutInflater mInflater;

    public OptionsAdapter(Context mContent ,ArrayList<Option> mOptionArrayList){
        this.mContent = mContent;
        this.mOptionArrayList = mOptionArrayList;
        mInflater = LayoutInflater.from(mContent);
    }

    @Override
    public int getCount() {
        return mOptionArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.item_grid_options,null);

        ImageView optionImage = convertView.findViewById(R.id.option_image);
        TextView optionTitle = convertView.findViewById(R.id.option_title);

        optionImage.setImageResource(mOptionArrayList.get(position).getmIconID());
        optionTitle.setText(mOptionArrayList.get(position).getmOptionName());
        return convertView;
    }
}
