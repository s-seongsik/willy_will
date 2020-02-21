/**
 * Last Modified: 2020-02-21
 * Last Modified By: Shin Minyong
 * Created: 2020-02-19
 * Created By: Shin Minyong
 */
package com.willy.will.common.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Group implements Parcelable {

    private int id = -1;
    private String name = null;

    // temp
    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }
    // ~temp

    protected Group(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        dest.writeInt(this.id);
        dest.writeString(this.name);
    }

    public static final Creator<Group> CREATOR = new Creator<Group>() {
        @Override
        public Group createFromParcel(Parcel in) {
            return new Group(in);
        }

        @Override
        public Group[] newArray(int size) {
            return new Group[size];
        }
    };

}
