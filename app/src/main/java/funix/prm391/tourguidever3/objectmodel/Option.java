package funix.prm391.tourguidever3.objectmodel;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Option implements Parcelable {

    private int mIconID;
    private String mOptionName;
    private ArrayList<Destination> mDestArrayList;

    public Option(int mIconID, String mOptionName){
        this.mIconID = mIconID;
        this.mOptionName = mOptionName;
        mDestArrayList = new ArrayList<>();
    }

    public void addDestination(String mDestinationName, String mAddress, double x, double y){
        mDestArrayList.add(new Destination(mDestinationName, mAddress, x, y));
    }

    public int getmIconID() {
        return mIconID;
    }

    public String getmOptionName() {
        return mOptionName;
    }

    public ArrayList<Destination> getmDestArrayList() {
        return mDestArrayList;
    }






    //Implement Parcelable's Creator and methods
    protected Option(Parcel in) {
    }

    public static final Creator<Option> CREATOR = new Creator<Option>() {
        @Override
        public Option createFromParcel(Parcel in) {
            return new Option(in);
        }

        @Override
        public Option[] newArray(int size) {
            return new Option[size];
        }
    };
    //Implement Parcelable methods
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
