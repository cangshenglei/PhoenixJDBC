import org.apache.phoenix.queryserver.client.ThinClientUtil;

import java.sql.*;

public class TestThinClient {
    public static void main(String[] args) throws SQLException {
        //从瘦客户端获取连接
        String hadoop102 = ThinClientUtil.getConnectionUrl("hadoop102", 8765);
        Connection connection = DriverManager.getConnection(hadoop102);
        //SQL语句
        PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
        //执行语句
        ResultSet resultSet = preparedStatement.executeQuery();
        //输出结果
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + ":" + resultSet.getString(2) + ":" + resultSet.getString(3));

        }
        connection.close();
    }
}
