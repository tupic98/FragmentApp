package com.example.rafaj.fragmentapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Planet implements Parcelable{

    private String nombre, description, mindescription;
    private int image;

    public Planet(String nombre, String description, String mindescription, int image) {
        this.mindescription = mindescription;
        this.nombre = nombre;
        this.description = description;
        this.image = image;
    }

    protected Planet(Parcel in) {
        nombre = in.readString();
        description = in.readString();
        mindescription = in.readString();
        image = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(description);
        dest.writeString(mindescription);
        dest.writeInt(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Planet> CREATOR = new Creator<Planet>() {
        @Override
        public Planet createFromParcel(Parcel in) {
            return new Planet(in);
        }

        @Override
        public Planet[] newArray(int size) {
            return new Planet[size];
        }
    };

//    Getters
    public String getNombre() {
        return nombre;
    }

    public int getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getMindescription() {
        return mindescription;
    }
}
