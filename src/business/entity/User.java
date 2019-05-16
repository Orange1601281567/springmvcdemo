package business.entity;

/**
 * 用户基本信息
 * Created by wph-pc on 2018/10/28.
 */
public class User {
    //用户账号
    private String userid=null;
    //用户昵称
    private String name=null;
    //性别
    private String sex=null;
    //用户密码
    private String pwd="";
    //用户头像
    private  Object headportrait=null;
    //用户邮箱地址
    private String email=null;
    //用户状态
    private String status=null;
    //用户电话
    private  String phone = null;
    //用户类型
    private String type = null;

    public Object getHeadportrait() {
        return headportrait;
    }

    public void setHeadportrait(Object headportrait) {
        this.headportrait = headportrait;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String emailaddress) {
        this.email = emailaddress;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", pwd='" + pwd + '\'' +
                ", headportrait=" + headportrait +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", phone='" + phone + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
