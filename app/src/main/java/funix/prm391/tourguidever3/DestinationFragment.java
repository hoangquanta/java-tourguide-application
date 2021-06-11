package funix.prm391.tourguidever3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import funix.prm391.tourguidever3.adapter.DestinationAdapter;
import funix.prm391.tourguidever3.objectmodel.Destination;
import funix.prm391.tourguidever3.objectmodel.Option;

public class DestinationFragment extends Fragment {
    Option option;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Get the parcelable Option
        //Set adapter for destination list view using data from the Option
        //Set onClickListener for the list:
        //- Pass the selected Destination to MapsFragment
        //- Switch to MapsFragment

        Bundle bundle = this.getArguments();
        option = bundle.getParcelable("OPTION");

        View root = inflater.inflate(R.layout.fragment_destination,container,false);
        //
        ListView destList = root.findViewById(R.id.destination_listView);
        DestinationAdapter adapter = new DestinationAdapter(getActivity(), option);
        destList.setAdapter(adapter);
        //
        destList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //
                Destination clickedDestination = option.getmDestArrayList().get(position);
                Bundle bundle = new Bundle();
                bundle.putParcelable("DESTINATION",clickedDestination);
                Fragment fragment = new MapsFragment();
                fragment.setArguments(bundle);
                //
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_switcher,fragment).addToBackStack(null).commit();

            }
        });
        return root;
    }
}
