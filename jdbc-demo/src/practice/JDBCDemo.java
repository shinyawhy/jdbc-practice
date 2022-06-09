package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC快速入门
 */
public class JDBCDemo {


    public static void main(String[] args) throws Exception{
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取链接
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url,username,password);
        // 定义sql
        String sql = "UPDATE db1 SET money = 2000 WHERE id = 1";
        // 获取执行sql对象
        Statement stmt = conn.createStatement();
        try {
            // 开启事务
            conn.setAutoCommit(false);
            // 执行sql
            int count = stmt.executeUpdate(sql);

            System.out.println(count);
            // 提交事务
            conn.commit();
        } catch (Exception e) {
            // 回滚事务
            conn.rollback();
            throw new RuntimeException(e);
        }

        stmt.close();
        conn.close();
    }
}
