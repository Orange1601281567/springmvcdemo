package business.service;

import business.entity.Case;
import business.entity.OrangeReturn;

import java.util.List;
import java.util.Map;

public interface ICaseService {
    //添加菜品信息
    OrangeReturn addCase(Case cases);
    //删除菜品信息
    OrangeReturn deleteCase(Case cases);
    //修改菜品信息
    OrangeReturn updateCase(Case cases);
    //查找对象，以对象集合返回
    OrangeReturn findResult(Case condition);

}
