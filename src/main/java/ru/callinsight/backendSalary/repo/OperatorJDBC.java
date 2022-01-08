package ru.callinsight.backendSalary.repo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.callinsight.backendSalary.model.Operator;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

// Класс не используется
@Repository
public class OperatorJDBC {
//    private static final Logger LOGGER = LoggerFactory.getLogger(OperatorJDBC.class);
//    private final JdbcTemplate jdbc;
//    private static final String url = "jdbc:mysql://localhost:3306/operators_report_card";
//    private static final String user = "root";
//    private static final String password = "bestuser";
//    List<Operator> operators;
//
//    public OperatorJDBC(JdbcTemplate jdbc) {
//        this.jdbc = jdbc;
//    }
//
//
//    public List<Operator> findTotalHoursForOperators(int year, int month) {
//        month = Calendar.MONTH;
//        year = Calendar.YEAR;
//        try (Connection conn = DriverManager.getConnection(url, user, password)) {
//            PreparedStatement preparedStatement = conn.prepareStatement(
//                    "SELECT * FROM `salary` where year(date) = ? " +
//                            "and month(date) = ?");
//            preparedStatement.setInt(1, year);
//            preparedStatement.setInt(2, month);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                operators.add(new Operator(
//                        resultSet.getInt("id"),
//                        resultSet.getString("full_name")));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return operators;
//    }
}