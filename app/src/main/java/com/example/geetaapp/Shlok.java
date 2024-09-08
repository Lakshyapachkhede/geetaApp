package com.example.geetaapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Shlok implements Parcelable {
    private String text ;
    private String meaning;
    private int chapter;
    private String shlokNo;
    private int number;


    public Shlok(String text, int number, String shlokNo, int chapter, String meaning) {
        this.text = text;
        this.number = number;
        this.shlokNo = shlokNo;
        this.chapter = chapter;
        this.meaning = meaning;
    }

    protected Shlok(Parcel in) {
        text = in.readString();
        meaning = in.readString();
        chapter = in.readInt();
        shlokNo = in.readString();
        number = in.readInt();

    }

    public static final Creator<Shlok> CREATOR = new Creator<Shlok>() {
        @Override
        public Shlok createFromParcel(Parcel source) {
            return new Shlok(source);
        }

        @Override
        public Shlok[] newArray(int size) {
            return new Shlok[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(text);
        dest.writeString(meaning);
        dest.writeInt(chapter);
        dest.writeString(shlokNo);
        dest.writeInt(number);
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getShlokNo() {
        return shlokNo;
    }

    public void setShlokNo(String shlokNo) {
        this.shlokNo = shlokNo;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
