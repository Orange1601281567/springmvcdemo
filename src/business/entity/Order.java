package business.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    /**
     * 预约号
     */
    private String yuid;

    /**
     * 用户名
     */
    private String userid;

    private String people;

    private String tableid;

    private Date yutime;

    private String sumprice;

    private String casename;

    private Date ordertime;

    public String getYuid() {
        return yuid;
    }

    public void setYuid(String yuid) {
        this.yuid = yuid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getTableid() {
        return tableid;
    }

    public void setTableid(String tableid) {
        this.tableid = tableid;
    }

    public Date getYutime() {
        return yutime;
    }

    public void setYutime(Date yutime) {
        this.yutime = yutime;
    }

    public String getCasename() {
        return casename;
    }

    public void setCasename(String casename) {
        this.casename = casename;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public String getSumprice() {
        return sumprice;
    }

    public void setSumprice(String sumprice) {
        this.sumprice = sumprice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "yuid='" + yuid + '\'' +
                ", userid='" + userid + '\'' +
                ", people='" + people + '\'' +
                ", tableid='" + tableid + '\'' +
                ", yutime=" + yutime +
                ", sumprice=" + sumprice +
                ", casename='" + casename + '\'' +
                ", ordertime=" + ordertime +
                '}';
    }
}