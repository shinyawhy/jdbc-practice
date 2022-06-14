package practice.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import practice.pojo.Account;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Druid数据库连接池演示
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        //4.获取连接对象
        Properties prop = new Properties();
        prop.load(new FileInputStream("C:\\Users\\50506\\IdeaProjects\\jdbc\\jdbc-demo\\src\\druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库链接
        Connection conn = dataSource.getConnection();
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


        System.out.println(conn);


    }
}
