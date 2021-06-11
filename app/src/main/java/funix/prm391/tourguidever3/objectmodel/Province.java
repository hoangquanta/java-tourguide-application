package funix.prm391.tourguidever3.objectmodel;

import java.util.ArrayList;

import funix.prm391.tourguidever3.objectmodel.Option;

public class Province {
    private int mNationIconID;
    private String mProvinceName;
    private ArrayList<Option> mOptionArrayList;

    public Province(int mNationIconID, String mProvinceName){
        this.mNationIconID = mNationIconID;
        this.mProvinceName = mProvinceName;
        mOptionArrayList = new ArrayList<>();
    }

    public void addOption(Option option){
        mOptionArrayList.add(option);
    }


    //Getters
    public int getmNationIconID() {
        return mNationIconID;
    }

    public String getmProvinceName() {
        return mProvinceName;
    }

    public ArrayList<Option> getmOptionArrayList() {
        return mOptionArrayList;
    }
}
