
package com.example.weather.model;

import javax.annotation.Generated;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Sys implements Parcelable
{

    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("sunrise")
    @Expose
    private Integer sunrise;
    @SerializedName("sunset")
    @Expose
    private Integer sunset;
    public final static Creator<Sys> CREATOR = new Creator<Sys>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Sys createFromParcel(android.os.Parcel in) {
            return new Sys(in);
        }

        public Sys[] newArray(int size) {
            return (new Sys[size]);
        }

    }
    ;

    protected Sys(android.os.Parcel in) {
        this.type = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.sunrise = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sunset = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Sys() {
    }

    /**
     * 
     * @param country
     * @param sunrise
     * @param sunset
     * @param id
     * @param type
     */
    public Sys(Integer type, Integer id, String country, Integer sunrise, Integer sunset) {
        super();
        this.type = type;
        this.id = id;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getSunrise() {
        return sunrise;
    }

    public void setSunrise(Integer sunrise) {
        this.sunrise = sunrise;
    }

    public Integer getSunset() {
        return sunset;
    }

    public void setSunset(Integer sunset) {
        this.sunset = sunset;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Sys.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("country");
        sb.append('=');
        sb.append(((this.country == null)?"<null>":this.country));
        sb.append(',');
        sb.append("sunrise");
        sb.append('=');
        sb.append(((this.sunrise == null)?"<null>":this.sunrise));
        sb.append(',');
        sb.append("sunset");
        sb.append('=');
        sb.append(((this.sunset == null)?"<null>":this.sunset));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(id);
        dest.writeValue(country);
        dest.writeValue(sunrise);
        dest.writeValue(sunset);
    }

    public int describeContents() {
        return  0;
    }

}
