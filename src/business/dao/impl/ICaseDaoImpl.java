package business.dao.impl;

import business.dao.ICaseDao;
import business.entity.Case;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("icaseDao")
public class ICaseDaoImpl implements ICaseDao {

    @Override
    public int addCase(Case cases) {
        String sql="insert into `case` (caseid,case_name,case_price) values ('"+cases.getCaseid()+"','"+cases.getCasename()+"',"+cases.getCaseprice()+")";
        //创建数据库访问对象
        DBHelper command= DBHelper.getInstance();
        //执行用户新增操作
        return command.command(sql);
    }

    @Override
    public int deleteCase(Case cases) {
        String sql="delete from `case` where case_name='"+cases.getCasename()+"'";
        //创建数据库访问对象
        DBHelper command= DBHelper.getInstance();
        //执行用户新增操作
        return command.command(sql);
    }

    @Override
    public int updateCase(Case cases) {
        String sql="update `case` set case_price='"+cases.getCaseprice()+"' where case_name='"+cases.getCasename()+"'";
        //创建数据库访问对象
        DBHelper command= DBHelper.getInstance();
        //执行用户新增操作
        return command.command(sql);
    }

    @Override
    public List<Map<String, Object>> findResult(Case condition) {
        String sql="select * from `case`";
        DBHelper dbHelper= DBHelper.getInstance();
        //数据库执行用户查询
        return dbHelper.find(sql);
    }

}
