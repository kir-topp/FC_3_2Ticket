package com.example.fc_3_2;

import android.os.Parcel;

import android.os.Parcelable;

public class Ticket implements Parcelable {
    private int userId;
    private String departure;
    private String arrival;
    private double cost;

    public Ticket(int userId, String departure, String arrival, double cost) {
        this.userId = userId;
        this.departure = departure;
        this.arrival = arrival;
        this.cost = cost;
    }

    public int getUserId() {
        return userId;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public double getCost() {
        return cost;
    }
    @Override
    public int describeContents() {
        return 0;

}
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userId);
        dest.writeString(departure);
        dest.writeString(arrival);
        dest.writeDouble(cost);
    }

    public static final Creator<Ticket> CREATOR = new Creator<Ticket>() {
        @Override
        public Ticket createFromParcel(Parcel in) {
            return new Ticket(in);
        }

        @Override
        public Ticket[] newArray(int size) {
            return new Ticket[size];
        }
    };

    protected Ticket(Parcel in) {
        userId = in.readInt();
        departure = in.readString();
        arrival = in.readString();
        cost = in.readDouble();
    }
}
