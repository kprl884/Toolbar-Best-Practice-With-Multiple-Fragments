package com.example.lastversion.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProjectsModel implements Parcelable {


    @SerializedName("s.no")
    @Expose
    private Integer sNo;
    @SerializedName("amt.pledged")
    @Expose
    private Integer amtPledged;
    @SerializedName("blurb")
    @Expose
    private String blurb;
    @SerializedName("by")
    @Expose
    private String by;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("end.time")
    @Expose
    private String endTime;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("percentage.funded")
    @Expose
    private Integer percentageFunded;
    @SerializedName("num.backers")
    @Expose
    private String numBackers;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("url")
    @Expose
    private String url;



    public ProjectsModel (String name, int amtPledged, String numBackers, int sNo) {
        this.numBackers = numBackers;
        this.sNo = sNo;
        this.amtPledged = amtPledged;
        this.title = name;
    }

    public ProjectsModel(String name, int amtPledged, String numBackers, int sNo, String blurb
            , String by, String currency, String country, String endTime, String location
            , int percentageFunded , String state, String type, String url
    ){
        this.numBackers = numBackers;
        this.sNo = sNo;
        this.amtPledged = amtPledged;
        this.title = name;
        this.blurb = blurb;
        this.by = by;
        this.currency = currency;
        this.country = country;
        this.endTime = endTime;
        this.location = location;
        this.percentageFunded = percentageFunded;
        this.state = state;
        this.type = type;
        this.url = url;
    }


    public Integer getSNo() {
        return sNo;
    }

    public void setSNo(Integer sNo) {
        this.sNo = sNo;
    }

    public Integer getAmtPledged() {
        return amtPledged;
    }

    public void setAmtPledged(Integer amtPledged) {
        this.amtPledged = amtPledged;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getPercentageFunded() {
        return percentageFunded;
    }

    public void setPercentageFunded(Integer percentageFunded) {
        this.percentageFunded = percentageFunded;
    }

    public String getNumBackers() {
        return numBackers;
    }

    public void setNumBackers(String numBackers) {
        this.numBackers = numBackers;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String toString() {
        return "Project Name : " + getTitle() + "\n " + getAmtPledged() + "$ pledged \n" +"number of backers " + getNumBackers()
                + "\n Blurb : " + getBlurb() + "Currency : " + getCurrency() +  "By : " + getBy() + "Country : " +getCountry() + "State : " +getState()
                + " End time : " + getEndTime() +  "location : " + getLocation() + "Type : " + getType() + " Percentage funden : " +getPercentageFunded()
                + "No of Days to Go : " + getSNo();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.sNo);
        dest.writeValue(this.amtPledged);
        dest.writeString(this.blurb);
        dest.writeString(this.by);
        dest.writeString(this.country);
        dest.writeString(this.currency);
        dest.writeString(this.endTime);
        dest.writeString(this.location);
        dest.writeValue(this.percentageFunded);
        dest.writeString(this.numBackers);
        dest.writeString(this.state);
        dest.writeString(this.title);
        dest.writeString(this.type);
        dest.writeString(this.url);
    }

    protected ProjectsModel(Parcel in) {
        this.sNo = (Integer) in.readValue(Integer.class.getClassLoader());
        this.amtPledged = (Integer) in.readValue(Integer.class.getClassLoader());
        this.blurb = in.readString();
        this.by = in.readString();
        this.country = in.readString();
        this.currency = in.readString();
        this.endTime = in.readString();
        this.location = in.readString();
        this.percentageFunded = (Integer) in.readValue(Integer.class.getClassLoader());
        this.numBackers = in.readString();
        this.state = in.readString();
        this.title = in.readString();
        this.type = in.readString();
        this.url = in.readString();
    }

    public static final Parcelable.Creator<ProjectsModel> CREATOR = new Parcelable.Creator<ProjectsModel>() {
        @Override
        public ProjectsModel createFromParcel(Parcel source) {
            return new ProjectsModel(source);
        }

        @Override
        public ProjectsModel[] newArray(int size) {
            return new ProjectsModel[size];
        }
    };



}
