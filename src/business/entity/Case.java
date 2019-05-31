package business.entity;

public class Case {
    /**
     * 菜品id
     */
    private String caseid;
    /**
     * 菜品名
     */
    private String casename;
    /**
     *菜品价格
     */
    private float caseprice;

    public String getCaseid() {
        return caseid;
    }

    public void setCaseid(String caseid) {
        this.caseid = caseid;
    }

    public String getCasename() {
        return casename;
    }

    public void setCasename(String casename) {
        this.casename = casename;
    }

    public float getCaseprice() {
        return caseprice;
    }

    public void setCaseprice(float caseprice) {
        this.caseprice = caseprice;
    }

    @Override
    public String toString() {
        return "Case{" +
                "caseid='" + caseid + '\'' +
                ", casename='" + casename + '\'' +
                ", caseprice=" + caseprice +
                '}';
    }
}
