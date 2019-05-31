package business.service.impl;

import business.dao.ICaseDao;
import business.entity.Case;
import business.entity.OrangeReturn;
import business.service.ICaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("icaseService")
public class ICaseServiceImpl implements ICaseService {
    @Resource(name = "icaseDao")
    private ICaseDao icaseDao;
    /*数据访问层和实体对象条件检测*/
    private OrangeReturn checkCondition(){
        OrangeReturn back=new OrangeReturn();
        if (icaseDao==null){
            back.setCode("0");
            back.setMessage("数据访问层对象或数据模型都不能为空！");
            back.setObj(null);
        }else{
            back.setCode("1");
            back.setMessage("数据访问层对象和数据模型满足操作要求！");
            back.setObj(1);
        }
        return back;
    }
    @Override
    public OrangeReturn addCase(Case cases) {
        OrangeReturn back=checkCondition();
        if(back.getObj()==null) return back;
        try {
            int result=icaseDao.addCase( cases );
            if (result<=0)
            {
                back.setCode("0");
                back.setMessage("抱歉，您的数据保存失败！");
            }
            else
            {
                back.setCode("1");
                back.setMessage("您的数据已经成功提交！");
            }
            back.setObj(result);
        } catch (Exception e) {
            e.printStackTrace();
            back.setCode("-1");
            back.setMessage("数据保存出现异常，异常信息："+e.getMessage());
            back.setObj(-1);
        }
        return back;
    }

    @Override
    public OrangeReturn deleteCase(Case cases) {

        OrangeReturn back=checkCondition();
        if(back.getObj()==null) return back;
        try {
            int result=icaseDao.deleteCase( cases );
            if (result<=0)
            {
                back.setCode("0");
                back.setMessage("抱歉，您的数据保存失败！");
            }
            else
            {
                back.setCode("1");
                back.setMessage("您的数据已经成功提交！");
            }
            back.setObj(result);
        } catch (Exception e) {
            e.printStackTrace();
            back.setCode("-1");
            back.setMessage("数据保存出现异常，异常信息："+e.getMessage());
            back.setObj(-1);
        }
        return back;
    }

    @Override
    public OrangeReturn updateCase(Case cases) {

        OrangeReturn back=checkCondition();
        if(back.getObj()==null) return back;
        try {
            int result=icaseDao.updateCase( cases );
            if (result<=0)
            {
                back.setCode("0");
                back.setMessage("抱歉，您的数据保存失败！");
            }
            else
            {
                back.setCode("1");
                back.setMessage("您的数据已经成功提交！");
            }
            back.setObj(result);
        } catch (Exception e) {
            e.printStackTrace();
            back.setCode("-1");
            back.setMessage("数据保存出现异常，异常信息："+e.getMessage());
            back.setObj(-1);
        }
        return back;
    }

    /*检测查询的条件*/
    private OrangeReturn checkFindCondition(Map condition){
        OrangeReturn back=new OrangeReturn();
        if (icaseDao==null || condition==null){
            back.setCode("0");
            back.setMessage("数据访问层对象或查找都不能为空！");
            back.setObj(null);
        }else{
            back.setCode("1");
            back.setMessage("数据访问层对象和查找条件满足操作要求！");
            back.setObj(1);
        }
        return back;
    }
    /*判断查询条件param是否有效，返回KesunReturn结果*/
    private OrangeReturn getFindResult(List param){
        OrangeReturn back=new OrangeReturn();
        if (param==null || param.size()==0)
        {
            back.setCode("0");
            back.setMessage("抱歉，系统没有查询到符合条件的数据！");
        }
        else
        {
            back.setCode("1");
            back.setMessage("系统已经查询到符合条件的数据！");
        }
        back.setObj(param);
        return back;
    }

    @Override
    public OrangeReturn findResult(Case condition) {
        OrangeReturn back=new OrangeReturn();
        try {
            List<Map<String, Object>> temp=icaseDao.findResult( condition );
            //转换查询结果
            back=getFindResult(temp);
        } catch (Exception e) {
            back.setCode("-1");
            back.setMessage("系统处理查询的过程中出现异常，异常信息："+e.getMessage());
            back.setObj(null);
            e.printStackTrace();
        }
        return back;
    }
}
