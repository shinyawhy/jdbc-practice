package practice.jdbc;

import practice.pojo.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC快速入门
 */
public class JDBCDemo_UserLogin {


    public static void main(String[] args) throws Exception{
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取链接
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url,username,password);

        String name = "zhangsan";
        String pwd = "123";

        String sql = "select * from tb_user where username = '"+name+"'and password = '"+pwd+"'";

        // 获取stmt对象
        Statement stmt =conn.createStatement();

        // 执行
        ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()) {
            System.out.println("成功");
        }
        else {
            System.out.println("失败");
        }

    // 释放资源
        rs.close();
        stmt.close();
        conn.close();

//        try {
//            // 开启事务
//            conn.setAutoCommit(false);
//            // 执行sql
//            int count = stmt.executeUpdate(sql);
//
//            System.out.println(count);
//            // 提交事务
//            conn.commit();
//        } catch (Exception e) {
//            // 回滚事务
//            conn.rollback();
//            throw new RuntimeException(e);
//        }

//        stmt.close();
//        conn.close();
    }
}
