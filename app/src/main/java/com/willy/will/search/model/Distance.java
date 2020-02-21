package com.willy.will.search.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Distance implements Parcelable {

    private String text = null;
    private boolean use = false;

    public Distance(String text, boolean use) {
        this.text = text;
        this.use = use;
    }

    protected Distance(Parcel in) {
        text = in.readString();
        use = in.readByte() != 0;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isUse() {
        return use;
    }

    public void setUse(boolean use) {
        this.use = use;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Last Modified: 2020-02-21
     * Last Modified By: Shin Minyong
     * Created: -
     * Created By: -
     * The writing order is important
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        int useInt = this.use ? 1 : 0;
        dest.writeString(this.text);
        dest.writeInt(useInt);
    }

    public static final Creator<Distance> CREATOR = new Creator<Distance>() {
        @Override
        public Distance createFromParcel(Parcel in) {
            return new Distance(in);
        }

        @Override
        public Distance[] newArray(int size) {
            return new Distance[size];
        }
    };
}
