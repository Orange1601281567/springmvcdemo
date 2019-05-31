package test;

import business.dao.ICaseDao;
import business.dao.impl.DBHelper;
import business.dao.IUserDao;
import business.entity.Case;
import business.entity.OrangeReturn;
import business.entity.User;
import business.service.ICaseService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class cesg {
    @Test
    //菜品添加测试
    public void dd(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        String cmd="select *from `case`";
        //创建数据库访问对象
        DBHelper command= DBHelper.getInstance();
        //执行用户注册
        System.out.println( command.find( cmd ) );

    }
    @Test
    //菜品添加测试
    public void add(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过容器获取ICaseService实例
        ICaseService as = (ICaseService)applicationContext.getBean("icaseService");
        Case cases=new Case();
        cases.setCaseid( "2887" );
        cases.setCasename( "辣椒1" );
        cases.setCaseprice( 100 );
       String insert = as.addCase(cases).getCode();
       System.out.println(insert);

    }
    @Test
    //菜品删除测试
    public void delete(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过容器获取ICaseService实例
        ICaseService as = (ICaseService)applicationContext.getBean("icaseService");
        Case cases=new Case();
        cases.setCasename( "辣椒1" );
        String delete = as.deleteCase(cases).getCode();
        System.out.println(delete);

    }

    @Test
    //菜品更改测试
    public void updateCase(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过容器获取ICaseService实例
        ICaseService as = (ICaseService)applicationContext.getBean("icaseService");
        Case cases=new Case();
        cases.setCasename( "辣椒1" );
        cases.setCaseprice( 620 );
        String update = as.updateCase(cases).getCode();
        System.out.println(update);

    }

    @Test
    //菜品更改测试
    public void find(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过容器获取ICaseService实例
        ICaseService as = (ICaseService)applicationContext.getBean("icaseService");
        Case cases=new Case();
        List<Case> find = (List<Case>) as.findResult(cases).getObj();
        System.out.println(find);

    }

    @Test
    //用户转帐
    public void change(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过容器获取ICaseService实例
        IUserDao as = (IUserDao)applicationContext.getBean("iuserDao");
        User user=new User();
         as.change( "情侣套餐1","情侣套餐2",10 );
    }

    @Test
    //用户登录
    public void login(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过容器获取ICaseService实例
        IUserDao as = (IUserDao)applicationContext.getBean("iuserDao");
        User user=new User();
        user.setUserid( "xjtab" );
        user.setName( "vfg" );
        User xxx=as.loginUser( user );
        System.out.println( xxx );
    }

}
