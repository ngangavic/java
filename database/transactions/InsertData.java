package database.transactions;

import database.connection.DbConnection;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {

    public static final String USER_TABLE_QUERY = "INSERT INTO user (email,password)VALUES(?,?)";
    public static final String DETAILS_TABLE_QUERY = "INSERT INTO details (email,name,age,location)VALUES(?,?,?,?)";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getConnection();
        try {
            connection.setAutoCommit(false);
            InsertData insertData = new InsertData();
            insertData.insertUserTable(connection, "ngangavictor10@gmail.com", insertData.generatePassword());
            insertData.insertDetailsTable(connection, "ngangavictor10@gmail.com", "Victor Nganga", "30", "Kenya");
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            System.out.println("Transaction rolled back successfully");
        }
    }

    public void insertUserTable(Connection connection, String email, String password) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = connection.prepareStatement(USER_TABLE_QUERY);
        statement.setString(1, email);
        statement.setString(2, password);
        statement.executeUpdate();
        System.out.println("Users table inserted");
        statement.close();
    }

    void insertDetailsTable(Connection connection, String email, String name, String age, String location) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = connection.prepareStatement(DETAILS_TABLE_QUERY);
        statement.setString(1, email);
        statement.setString(2, name);
        statement.setString(3, age);
        statement.setString(4, location);
        statement.executeUpdate();
        System.out.println("Details table inserted");
        statement.close();
    }

    public String generatePassword() {

        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789./?!,";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }
}
