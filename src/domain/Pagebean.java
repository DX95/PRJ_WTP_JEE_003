package domain;

import java.util.List;

public class Pagebean<T> {

    private int totalpage;
    private int currentpage ;
    private int rows;
    private int totalcount;
    private List<T> list;

    @Override
    public String toString() {
        return "Pagebean{" +
                "totalpage=" + totalpage +
                ", currentpage=" + currentpage +
                ", rows=" + rows +
                ", totalcount=" + totalcount +
                ", list=" + list +
                '}';
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public int getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(int currentpage) {
        this.currentpage = currentpage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
