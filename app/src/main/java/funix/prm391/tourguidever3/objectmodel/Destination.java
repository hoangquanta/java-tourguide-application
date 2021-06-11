package funix.prm391.tourguidever3.objectmodel;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;

public class Destination implements Parcelable {

    private String mDestinationName;
    private String mAddress;
    private LatLng mLocation;

    public Destination(String mDestinationName, String mAddress, double x, double y){
        this.mDestinationName = mDestinationName;
        this.mAddress = mAddress;
        this.mLocation = new LatLng(x, y);
    }

    public String getmDestinationName() {
        return mDestinationName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public LatLng getmLocation() {
        return mLocation;
    }




    //Implement Parcelable Creator and methods
    protected Destination(Parcel in) {
    }

    public static final Creator<Destination> CREATOR = new Creator<Destination>() {
        @Override
        public Destination createFromParcel(Parcel in) {
            return new Destination(in);
        }

        @Override
        public Destination[] newArray(int size) {
            return new Destination[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
