package business.controller.impl;

import business.dao.impl.DBHelper;
import business.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/Orange")

public class Orange extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response,@RequestParam("img") MultipartFile file) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //设置响应编码格式
        response.setContentType("text/html;charset=utf-8");
        //设置请求编码格式
        User user=new User();
        InputStream as=request.getInputStream();

            ApplicationContext applicationContext =
                    new ClassPathXmlApplicationContext("applicationContext.xml");
            User a1=new User();
            String cmd="insert into test values("+a1.getHeadportrait()+")";;
            //创建数据库访问对象
            DBHelper command= DBHelper.getInstance();
            //执行用户注册
            System.out.println( command.command( cmd ) );


        request.setCharacterEncoding("utf-8");
        String a;
        a=request.getParameter( "user" );
                System.out.println( a );
        request.getRequestDispatcher("zc.jsp").forward(request, response);
    }


}
