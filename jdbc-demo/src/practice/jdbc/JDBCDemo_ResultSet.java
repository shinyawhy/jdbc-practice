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
public class JDBCDemo_ResultSet {


    public static void main(String[] args) throws Exception{
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取链接
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url,username,password);
        // 定义sql
        String sql = "select * from db1";
        // 获取执行sql对象
        Statement stmt = conn.createStatement();

        // 执行sql
        ResultSet rs = stmt.executeQuery(sql);

        // 创建集合
        List<Account> list = new ArrayList<>();

        // 处理结果
        while (rs.next()) {
            Account account = new Account();
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");

            // 赋值
            account.setId(id);
            account.setName(name);
            account.setMoney(money);

            // 存入集合
            list.add(account);

//            System.out.println(id);
//            System.out.println(name);
//            System.out.println(money);
//
//            System.out.println("=================");
        }
        System.out.println(list);
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
