package business.dao;

import business.entity.Case;

import java.util.List;
import java.util.Map;

public interface ICaseDao {
    //添加菜品信息
    int addCase(Case cases);
    //删除菜品信息
    int deleteCase(Case cases);
    //修改菜品信息
    int updateCase(Case cases);
    //查找对象，以对象集合返回
    List<Map<String,Object>> findResult(Case condition);

}
