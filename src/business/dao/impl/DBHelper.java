package business.dao.impl;



import org.apache.commons.dbcp.BasicDataSource;

import java.sql.*;
import java.util.*;

/**
 * 数据库访问类，通过连接池技术实现对数据库连接自动管理，
 * 实现了数据库的CRUD操作
 * Created by wph-pc on 2018/11/28.
 */
public class DBHelper {
    //静态DBHelper对象变量
    private static DBHelper sql=null;
    //定义缓冲池数据源
    private BasicDataSource dataSource=null;
    /*
    * 构造方法私有化，DBHelper单例模式的前提条件
    * */
    private DBHelper(){}
    /*
    * 类方法，实现DBHelper对象单例实例化
    * @return 返回DBHelper对象
    * */
    public static DBHelper getInstance(){
        if (sql==null)
            sql=new DBHelper();
        return sql;
    }


    /*连接数据库数据源初始化，需要common-pool和dbcp中间件支持*/
    private void init(){
        //创建属性读取对象
        Properties dbprops=new Properties();
        //取配置文件可以根据实际的不同修改
        try {
            dbprops.load(DBHelper.class.getClassLoader().getResourceAsStream("db.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            /*读取属性文件中JDBC数据库连接参数配置信息*/
            String driverClassName=dbprops.getProperty("jdbc.driver");
            String url=dbprops.getProperty("jdbc.url");
            String username=dbprops.getProperty("jdbc.user");
            String password=dbprops.getProperty("jdbc.password");
            /*读取属性文件中连接池配置信息*/
            String initialSize=dbprops.getProperty("dataSource.initialSize");
            String minIdle=dbprops.getProperty("dataSource.minIdle");
            String maxIdle=dbprops.getProperty("dataSource.maxIdle");
            String maxWait=dbprops.getProperty("dataSource.maxWait");
            String maxActive=dbprops.getProperty("dataSource.maxActive");

            //数据源对象实例化
            dataSource =new BasicDataSource();
            /*配置数据源相关参数信息*/
            dataSource.setDriverClassName(driverClassName);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            //配置初始化连接数
            if(initialSize!=null){
                dataSource.setInitialSize(Integer.parseInt(initialSize));
            }
            //配置最小空闲连接
            if(minIdle!=null){
                dataSource.setMinIdle(Integer.parseInt(minIdle));
            }
            //配置最大空闲连接
            if(maxIdle!=null){
                dataSource.setMaxIdle(Integer.parseInt(maxIdle));
            }
            //配置超时回收时间（以毫秒为单位）
            if(maxWait!=null){
                dataSource.setMaxWait(Long.parseLong(maxWait));
            }
            //配置最大连接数
            if(maxActive!=null){
                if(!maxActive.trim().equals("0")){
                    dataSource.setMaxActive(Integer.parseInt(maxActive));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    * 数据库的增删改操作
    * @param sql:增删改数据库字符串指令
    * @return 返回操作影响行行数
    * */
    public int command(String sql){
        //判断数据源是否为空
        if (dataSource==null)
            init();
        if (dataSource==null) return -1;
        //定义连接对象变量
        Connection conn=null;
        //获取数据源中的连接对象
        try {
            //获取连接对象
            conn=dataSource.getConnection();
            //获取指令对象
            Statement state=conn.createStatement();
            //执行SQL指令
            return state.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }finally {
            if (conn!=null)
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
    /*
    * 实现将结果集rs转成List结果
    * @param rs 结果集
    * @return 如果转成成功，返回List结果，否则返回null
    * */
    private List<Map<String, Object>> convertList(ResultSet rs) throws Exception {
        //判断参数rs有效性
        if(rs == null) {
            return null;
        }
        //获取rs参数数据元结构
        ResultSetMetaData rsMetaData = rs.getMetaData();
        //获取数据源rs中列数
        int columnCount = rsMetaData.getColumnCount();
         //创建List对象
        List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
        /*遍历rs结果集，并将遍历到结果转成List*/
        while (rs.next()) {
            //定义存放当前行中所有列数据集合
            Map<String, Object> dataMap = new HashMap<String, Object>();
            //处理当前遍历行所在的所有列数据，列索引从1开始
            for (int i = 0; i < columnCount; i++) {
                dataMap.put(rsMetaData.getColumnName(i+1), rs.getObject(i+1));
            }
            //将遍历到当前行做所有数据放入dataList中
            dataList.add(dataMap);
        }
        return dataList;
    }
    /*
    * 根据参数sql查询从数据库中查询，并以List结构返回
    * @param sql:数据库查询指令
    * @return 返回查询结果，如果存在，
    *         以List返回，否则返回null
    * */
    public List<Map<String,Object>> find(String sql){
        //判断数据源是否为空
        if (dataSource==null)
            init();
        if (dataSource==null) return null;
        //定义连接对象变量
        Connection conn=null;
        //获取数据源中的连接对象
        try {
            //获取连接对象
            conn=dataSource.getConnection();
            //获取指令对象
            Statement state=conn.createStatement();
            //执行SQL指令
            ResultSet rs=state.executeQuery(sql);
            if (rs!=null)
            try {
                List<Map<String,Object>> result=convertList(rs);
                rs.close();
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            if (conn!=null)
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}
