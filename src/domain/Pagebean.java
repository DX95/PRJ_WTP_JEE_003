package domain;

import java.util.List;

public class Pagebean {
    private Integer Totalpage;
    private Integer Currentpage ;
    private Integer rows;
    private Integer Totalcount;
    private List<Trip> list;

    @Override
    public String toString() {
        return "Pagebean{" +
                "Totalpage=" + Totalpage +
                ", Currentpage=" + Currentpage +
                ", rows=" + rows +
                ", Totalcount=" + Totalcount +
                ", list=" + list +
                '}';
    }

    public Integer getTotalpage() {
        return Totalpage;
    }

    public void setTotalpage(Integer totalpage) {
        Totalpage = totalpage;
    }

    public Integer getCurrentpage() {
        return Currentpage;
    }

    public void setCurrentpage(Integer currentpage) {
        Currentpage = currentpage;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getTotalcount() {
        return Totalcount;
    }

    public void setTotalcount(Integer totalcount) {
        Totalcount = totalcount;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
