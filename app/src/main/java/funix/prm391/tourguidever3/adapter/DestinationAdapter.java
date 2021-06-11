package funix.prm391.tourguidever3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import funix.prm391.tourguidever3.R;
import funix.prm391.tourguidever3.objectmodel.Destination;
import funix.prm391.tourguidever3.objectmodel.Option;

public class DestinationAdapter extends BaseAdapter {
    private Option mOption;
    private Context mContent;
    private LayoutInflater mInflater;

    public DestinationAdapter(Context mContent, Option mOption){
        this.mContent = mContent;
        this.mOption = mOption;
        mInflater = LayoutInflater.from(mContent);
    }

    @Override
    public int getCount() {
        return mOption.getmDestArrayList().size();
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
        Destination dest = mOption.getmDestArrayList().get(position);
        convertView = mInflater.inflate(R.layout.item_list_destinations,null);

        ImageView icon = convertView.findViewById(R.id.destination_icon);
        TextView destName = convertView.findViewById(R.id.destination_name);
        TextView destAddress = convertView.findViewById(R.id.destination_address);

        icon.setImageResource(mOption.getmIconID());
        destName.setText(dest.getmDestinationName());
        destAddress.setText(dest.getmAddress());

        return convertView;
    }
}
