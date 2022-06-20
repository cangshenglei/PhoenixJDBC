import java.sql.*;

public class TestThickClient {

    public static void main(String[] args) throws SQLException {
        //添加连接
        String url ="jdbc:phoenix:hadoop102,hadoop103,hadoop104:2181";
        //获取连接
        Connection connection = DriverManager.getConnection(url);
        //SQL语句
        PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
        //执行语句
        ResultSet resultSet = preparedStatement.executeQuery();
        //输出语句
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1)+":"+ resultSet.getString(2)+":"+resultSet.getString(3));

        }
        //关闭资源
        connection.close();

    }
}
