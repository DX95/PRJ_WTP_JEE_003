package until;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBuntil {

   private static DataSource ds;

    static {
        //加载配置文件

        try {
            Properties pro = new Properties();
            InputStream in = DBuntil.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(in);

            //获取连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取连接池方法
     *
     * @return
     */
    public static DataSource getDataSource() {
        return ds;
    }

    /**
     * 获取连接
     *
     * @return
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 释放资源
     *
     * @param stmt
     * @param con
     */
    public static void CloseJDBC(Statement stmt, Connection con) {

        CloseJDBC(null, stmt, con);
    }

    public static void CloseJDBC(ResultSet res, Statement stmt, Connection con) {

        if (res != null) {
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
