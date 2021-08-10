package Lesson8;

import java.sql.*;

public class SqliteExamples {
    public static void main(String[] args) {
        Connection connection= null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection= DriverManager.getConnection("jdbc:sqlite:geekbrains.db");
            Statement statement= connection.createStatement();

            statement.executeUpdate("update faculties set name = 'Тест1' where id=1");


            ResultSet resultSet= statement.executeQuery("select * from students");

            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id"));
                System.out.print("  ");
                System.out.print(resultSet.getString("name"));
                System.out.println();
            }

            PreparedStatement preparedStatement = connection.prepareStatement("insert into students(name," +
                    " score, fac_id) values ('?',?,?)");
            connection.setAutoCommit(false);
            preparedStatement.setString(1, "Олег");
            preparedStatement.setInt(2,10);
            preparedStatement.setInt(3,12);
            preparedStatement.addBatch();
            preparedStatement.setString(1, "Кирилл");
            preparedStatement.setInt(2,5);
            preparedStatement.setInt(3,2);
            preparedStatement.addBatch();
            preparedStatement.setString(1, "Андрей");
            preparedStatement.setInt(2,8);
            preparedStatement.setInt(3,20);
            preparedStatement.addBatch();
            preparedStatement.executeBatch();

//            Long time = System.currentTimeMillis();
//            for (int i = 0;  i < 10000; i++) {
//                statement.executeUpdate(String.format("insert into students(name, score, fac_id) values ('%s',1%d,%d)",
//                        "student"+i, i,i));
//            }
//            System.out.println("Время выполнения с автокоммитом: " + (System.currentTimeMillis()- time));
//
//            time =System.currentTimeMillis();
//            connection.setAutoCommit(false);
//            for (int i =10000;  i < 20000; i++) {
//                statement.executeUpdate(String.format("insert into students(name, score, fac_id) values ('%s',1%d,%d)",
//                        "student"+i, i,i));
//            }
//            connection.commit();
//            System.out.println("Время выполнения без автокоммитом: " + (System.currentTimeMillis()- time));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
