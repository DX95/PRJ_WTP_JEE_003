package domain;

import java.io.Serializable;
import java.util.Date;

public class trip2 implements Serializable {
    //SELECT title,traffic,hotel,price,date FROM trip t, price p WHERE t.id=p.id and title LIKE '%上海%';
    private int id;
    private String title;
    private String traffic;
    private String hotel;
    private double price;
    private String time;
    private Date date;
    private String name;
    private String s_title;
    private double good_rate;
    private String city;

    @Override
    public String toString() {
        return "trip2{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", traffic='" + traffic + '\'' +
                ", hotel='" + hotel + '\'' +
                ", price=" + price +
                ", time='" + time + '\'' +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", s_title='" + s_title + '\'' +
                ", good_rate=" + good_rate +
                ", city='" + city + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getGood_rate() {
        return good_rate;
    }

    public void setGood_rate(double good_rate) {
        this.good_rate = good_rate;
    }

    public String getS_title() {
        return s_title;
    }

    public void setS_title(String s_title) {
        this.s_title = s_title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
