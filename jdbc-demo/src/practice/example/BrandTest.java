package practice.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import practice.pojo.Brand;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 品牌数据操作
 */
public class BrandTest {
    /**
     * 查询所有
     * 1。Sql: SELECT * FROM tb_brand
     * 2. 参数
     * 3.结果 :List<Brand>
     */
    @Test
    public void testSelectAll() throws Exception {
        // 1. 获取conn
        Properties prop = new Properties();
        prop.load(new FileInputStream("C:\\Users\\50506\\IdeaProjects\\jdbc\\jdbc-demo\\src\\druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库链接
        Connection conn = dataSource.getConnection();

        // 2. 定义sql
        String sql = "SELECT * FROM tb_brand";

        // 3. 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // 4. 设置参数

        // 5. 执行sql
        ResultSet rs = pstmt.executeQuery();

        // 6. 处理结果 List<Brand> 封装对象， 装载list集合
//        Brand brand = null;
        List<Brand> list = new ArrayList<>();
        while (rs.next()) {
            // 获取数据
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int b_status = rs.getInt("b_status");
            // 封装对象
            Brand brand = new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setB_status(b_status);
            // 装载集合
            System.out.println(brand);
            System.out.println("=================");
            list.add(brand);


        }
        System.out.println(list);

        // 释放资源

        rs.close();
        pstmt.close();
        conn.close();

    }
}
