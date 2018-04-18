package com.example.rafaj.fragmentapp;

import android.os.Parcel;
import android.os.Parcelable;

public class PLanet implements Parcelable{

    private String nombre, description;
    private int id;

    public PLanet(String nombre, String description, int id) {
        this.nombre = nombre;
        this.description = description;
        this.id = id;
    }

    protected PLanet(Parcel in) {
        nombre = in.readString();
        description = in.readString();
        id = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(description);
        dest.writeInt(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PLanet> CREATOR = new Creator<PLanet>() {
        @Override
        public PLanet createFromParcel(Parcel in) {
            return new PLanet(in);
        }

        @Override
        public PLanet[] newArray(int size) {
            return new PLanet[size];
        }
    };

//    Getters
    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

}
