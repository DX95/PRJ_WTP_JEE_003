package domain;

import java.io.Serializable;

public class traffic implements Serializable {
    //t2.go_point,t2.go_time,t2.return_point,t2.return_time
    private int id;
    private String go_point;
    private String go_time;
    private String return_point;
    private String return_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGo_point() {
        return go_point;
    }

    public void setGo_point(String go_point) {
        this.go_point = go_point;
    }

    public String getGo_time() {
        return go_time;
    }

    public void setGo_time(String go_time) {
        this.go_time = go_time;
    }

    public String getReturn_point() {
        return return_point;
    }

    public void setReturn_point(String return_point) {
        this.return_point = return_point;
    }

    public String getReturn_time() {
        return return_time;
    }

    public void setReturn_time(String return_time) {
        this.return_time = return_time;
    }

    @Override
    public String toString() {
        return "traffic{" +
                "id=" + id +
                ", go_point='" + go_point + '\'' +
                ", go_time='" + go_time + '\'' +
                ", return_point='" + return_point + '\'' +
                ", return_time='" + return_time + '\'' +
                '}';
    }
}
