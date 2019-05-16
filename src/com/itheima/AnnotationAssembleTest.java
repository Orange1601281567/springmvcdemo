package com.itheima;

import com.itheima.config.beanFactory;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    public  void findAccountById(){
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext( beanFactory.class);
        //2.通过容器获取UserService实例
        IAccountService as =
                (IAccountService) applicationContext.getBean("accountService");
        Account accounts=as.findAccountById( 2 );

        System.out.print("asdasdasd");
            System.out.println( accounts );

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
}


