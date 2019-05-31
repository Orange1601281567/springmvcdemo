package business.entity;
/**
 * 操作返回实体类
 * Created by wph-pc on 2018/10/30.
 */
public class OrangeReturn {
    //返回状态码
    private String code=null;
    //返回提示信息
    private String message=null;
    //返回操作结果
    private Object obj=null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
