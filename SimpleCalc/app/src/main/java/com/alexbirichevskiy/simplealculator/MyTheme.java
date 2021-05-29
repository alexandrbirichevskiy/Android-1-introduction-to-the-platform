package com.alexbirichevskiy.simplealculator;

import android.os.Parcel;
import android.os.Parcelable;

public class MyTheme implements Parcelable {

    private int myTheme;

    public MyTheme(){
    }

    public MyTheme(int age){
        setMyTheme(myTheme);
    }

    protected MyTheme(Parcel in) {
        myTheme = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(myTheme);
    }

    public static final Creator<MyTheme> CREATOR = new Creator<MyTheme>() {
        @Override
        public MyTheme createFromParcel(Parcel in) {
            return new MyTheme(in);
        }

        @Override
        public MyTheme[] newArray(int size) {
            return new MyTheme[0];
        }
    };

    public void setMyTheme(int myTheme) {
        this.myTheme = myTheme;
    }

    public int getMyTheme() {
        return myTheme;
    }
}
