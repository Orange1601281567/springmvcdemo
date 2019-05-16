package business;

import business.config.beanFactory;
import business.domain.Account;
import business.entity.Order;
import business.entity.User;
import business.service.IAccountService;
import business.service.IOrderService;
import business.service.IUserService;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.support.CustomSQLExceptionTranslatorRegistry;

import javax.xml.crypto.Data;
import java.io.InputStream;
import java.util.Date;
import java.util.List;



public class AnnotationAssembleTest {
    @Test
    public  void testFindAll(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext( "applicationContext.xml" );
        //2.通过容器获取UserService实例
        IAccountService as =
                (IAccountService) applicationContext.getBean("accountService");
        List<Account> accounts=as.findAllAccount();
        for(Account account:accounts){
            System.out.println( account );

        }    }

    @Test
    public void testUserFindAll() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过容器获取UserService实例
        IUserService as = (IUserService) applicationContext.getBean("userService");
        List<User> users = as.findAllUser();
        for (User user:users){
                switch (user.getType()){
                    case "1":
                        System.out.println("欢迎光临:"+user.getName());
                        break;
                    default:
                        System.out.println(".."+user);
                        break;
                }
        }
    }

    @Test
    public void testfindAllOrder() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过容器获取OrderService实例
        IOrderService as = (IOrderService)applicationContext.getBean("orderService");
        List<Order> orders = as.findAllOrder();
        for (Order order:orders){
            System.out.println(order);
        }

    }

    @Test
    public void testsaveOrder() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过容器获取OrderService实例
        IOrderService as = (IOrderService)applicationContext.getBean("orderService");
        Order order = new Order();
        order.setYuid("din5");
        order.setUserid("xitab123");
        order.setPeople("6");
        order.setTableid("5");
        order.setYutime(new Date());
        order.setSumprice("1999");
        order.setCasename("九九归一");
        order.setOrdertime(new Date());
        as.saveOrder(order);
        // 通过返回结果判断更新操作是否执行成功
        System.out.println("您成功修改了");



    }

    @Test
    public  void findAccountById(){
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext( beanFactory.class);
        //2.通过容器获取UserService实例
        IAccountService as =
                (IAccountService) applicationContext.getBean("accountService");
        Account accounts=as.findAccountById( 2 );

            System.out.println( accounts );

        }

    @Test
    public void testfindOrderByyuid() {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(beanFactory.class);
        //通过容器获取OrderService实例
        IOrderService as =
                (IOrderService) applicationContext.getBean("orderService");
        Order order = as.findOrderByYuId("din1");
        System.out.println(order);
    }

    @Test
    public void testfindOrderByuserid() {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(beanFactory.class);
        //通过容器获取OrderService实例
        IOrderService as =
                (IOrderService)applicationContext.getBean("orderService");
        Order order = as.findOrderByUserId("xjtab123");
        System.out.println(order);
    }

    @Test
    public  void testconnent(){
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext( beanFactory.class);
        //2.通过容器获取UserService实例
        QueryRunner runner1=applicationContext.getBean( "runner",QueryRunner.class );
        QueryRunner runner2=applicationContext.getBean( "runner",QueryRunner.class );
        System.out.println( runner1==runner2 );
    }

    //mybatis测试

    @Test
    public void testfindAllByUserid() throws Exception{
        //1.读取配置文件
        String resource = "business/config/mybatis/Mybatisconfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2.根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.SqlSession执行映射文件中定义的SQL,并返回映射结果
        String userid = "xjtab123";
       Order order = sqlSession.selectOne("business.mapper.OrderMapper" + ".OrderMapper.findAllByUserid",userid);
       System.out.println(order.toString());
       //5.关闭链接
        sqlSession.close();

    }
}


