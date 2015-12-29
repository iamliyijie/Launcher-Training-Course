package com.example.training;

/**
 * Created by YiJie_Li on 2015/12/23.
 * 1.必須實作Parcelable.Creator不然取得Person資料時，會發生錯誤,如下：
 * android.os.BadParcelableException:
 * Parcelable protocol requires a Parcelable.Creator object called  CREATOR on class  com.example.training.PersonParcelable
 * 2.這個介面實現了從Percel容器讀取PersonParcelable資料，並回傳PersonParcelable給邏輯層使用
 * 3.實作Parcelable.Creator介面對象必須為CREATOR，如果不一樣會發生上面提到的錯誤
 * 4.在讀取Parcel容器裡的資料時，必須按照宣告變數的順序下去讀取資料，不然會出現取得數據錯誤
 * <p/>
 * ======================實作方式 ======================
 * 1. 覆寫describeContents，預設回傳0就可以
 * 2. 覆寫writeToParcel ，將類別(PersonParcelable)寫入到外部的提供的Parcel空間
 * 3. 建立對應的方法，如getName()、setName()
 * 4. Parcelable.Creator本身是一個靜態介面，介面內有兩個方法
 * createFromParcel(Parcel in)從Parcel中讀取欲傳遞的參數，封裝成Parcelable介面回到邏輯層
 * newArray(int size) return new T[size])
 */

import android.os.Parcel;
import android.os.Parcelable;

public class PersonParcelable implements Parcelable {

    private Integer tel;
    private String name;
    private String mail;

    public static final Parcelable.Creator<PersonParcelable> CREATOR = new Creator() {

        @Override
        public PersonParcelable createFromParcel(Parcel source) {
            // 讀取的順序必須與writeToParcel內寫入的順序一樣

            PersonParcelable p = new PersonParcelable();

            p.setName(source.readString());
            p.setTel(source.readInt());
            p.setMail(source.readString());
            return p;
        }

        @Override
        public PersonParcelable[] newArray(int size) {
            return new PersonParcelable[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // 1.寫入的順序必須與createFromParcel內讀取的順序一樣
        // 2.要序列化寫入的資料
        dest.writeString(name);
        dest.writeInt(tel);
        dest.writeString(mail);
    }
}
