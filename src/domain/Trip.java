package domain;

import javax.sound.midi.Sequence;
import javax.xml.soap.Detail;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Trip implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;//主键
	private int num;//
	private String title; //产品标题
	private String s_title; //
	private String traffic;
	private String hotel;
	private Integer time; //天数
	private float good_rate;
	private float place_score;
	private float hotel_score;
	private float service_score;
	private float traffic_score;
	private float min_price;
	private Boolean is_ok;
	private String main_picname;
	private Detail detail;

	/*private City start;
	private Position position;
	private Sequence type;
	private Schedule schedule;

	private List<Price> price_list;
	private List<ThemeOnTrip> themeontrip_list;
	private List<PlaceOnTrip> placeontrip_list;
	private List<String> date_list = new ArrayList<>();*/

	@Override
	public String toString() {
		return "Trip{" +
				"id=" + id +
				", num=" + num +
				", title='" + title + '\'' +
				", s_title='" + s_title + '\'' +
				", traffic='" + traffic + '\'' +
				", hotel='" + hotel + '\'' +
				", time=" + time +
				", good_rate=" + good_rate +
				", place_score=" + place_score +
				", hotel_score=" + hotel_score +
				", service_score=" + service_score +
				", traffic_score=" + traffic_score +
				", min_price=" + min_price +
				", is_ok=" + is_ok +
				", main_picname='" + main_picname + '\'' +
				", detail=" + detail +
				'}';
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getS_title() {
		return s_title;
	}

	public void setS_title(String s_title) {
		this.s_title = s_title;
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

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public float getGood_rate() {
		return good_rate;
	}

	public void setGood_rate(float good_rate) {
		this.good_rate = good_rate;
	}

	public float getPlace_score() {
		return place_score;
	}

	public void setPlace_score(float place_score) {
		this.place_score = place_score;
	}

	public float getHotel_score() {
		return hotel_score;
	}

	public void setHotel_score(float hotel_score) {
		this.hotel_score = hotel_score;
	}

	public float getService_score() {
		return service_score;
	}

	public void setService_score(float service_score) {
		this.service_score = service_score;
	}

	public float getTraffic_score() {
		return traffic_score;
	}

	public void setTraffic_score(float traffic_score) {
		this.traffic_score = traffic_score;
	}

	public float getMin_price() {
		return min_price;
	}

	public void setMin_price(float min_price) {
		this.min_price = min_price;
	}

	public Boolean getIs_ok() {
		return is_ok;
	}

	public void setIs_ok(Boolean is_ok) {
		this.is_ok = is_ok;
	}

	public String getMain_picname() {
		return main_picname;
	}

	public void setMain_picname(String main_picname) {
		this.main_picname = main_picname;
	}

	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}
}
