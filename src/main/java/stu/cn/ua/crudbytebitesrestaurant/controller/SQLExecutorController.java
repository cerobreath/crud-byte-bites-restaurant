package stu.cn.ua.crudbytebitesrestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sql")
//public class SQLExecutorController {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @PostMapping("/execute")
//    public List<Object> executeMultipleQueries(@RequestBody Map<String, Object> requestBody) {
//        String query = (String) requestBody.get("query");
//
//        System.out.println("Received query: " + query); // Логування запиту
//
//        if (query == null || query.trim().isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Query cannot be empty");
//        }
//
//        // Розділяємо запити по крапці з комою
//        String[] queries = query.split(";");
//        List<Object> results = new ArrayList<>();
//
//        for (String singleQuery : queries) {
//            singleQuery = singleQuery.trim();
//            if (singleQuery.isEmpty()) {
//                continue;
//            }
//
//            // Перевірка заборонених запитів
//            validateQuery(singleQuery);
//
//            try {
//                if (singleQuery.toLowerCase().startsWith("select")) {
//                    // Виконання SELECT запитів
//                    List<Map<String, Object>> resultList = jdbcTemplate.queryForList(singleQuery);
//                    results.add(resultList.isEmpty() ? "No data found." : resultList);
//                } else {
//                    // Виконання змінювальних запитів (INSERT, UPDATE, DELETE тощо)
//                    int rowsAffected = jdbcTemplate.update(singleQuery);
//                    results.add(Map.of("query", singleQuery, "message", rowsAffected + " rows affected"));
//                }
//            } catch (DataAccessException e) {
//                System.err.println("Error executing query: " + singleQuery);
//                System.err.println("Database error: " + e.getMessage());
//                results.add(Map.of("query", singleQuery, "error", e.getMessage()));
//            }
//        }
//
//        return results;
//    }
//
//    private void validateQuery(String query) {
//        String lowerQuery = query.toLowerCase();
//
//        // Забороняємо DELETE без WHERE
//        if (lowerQuery.startsWith("delete") && !lowerQuery.contains("where")) {
//            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "DELETE without WHERE is not allowed.");
//        }
//
//        // Забороняємо TRUNCATE
//        if (lowerQuery.startsWith("truncate")) {
//            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "TRUNCATE is not allowed.");
//        }
//
//        // Забороняємо DROP
//        if (lowerQuery.startsWith("drop")) {
//            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "DROP operations are not allowed.");
//        }
//    }
//}

public class SQLExecutorController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/execute")
    public List<Object> executeMultipleQueries(@RequestBody Map<String, Object> requestBody) {
        // Отримуємо SQL-запит з тіла запиту
        String query = (String) requestBody.get("query");

        System.out.println("Received query: " + query); // Логування запиту

        if (query == null || query.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Query cannot be empty");
        }

        // Розділяємо запити по крапці з комою
        String[] queries = query.split(";");
        List<Object> results = new ArrayList<>();

        for (String singleQuery : queries) {
            singleQuery = singleQuery.trim();
            if (singleQuery.isEmpty()) {
                continue;
            }

            try {
                // Перевіряємо, чи це SELECT-запит
                if (singleQuery.toLowerCase().startsWith("select")) {
                    // Виконуємо SELECT-запит
                    List<Map<String, Object>> resultList = jdbcTemplate.queryForList(singleQuery);
                    System.out.println("Query results: " + resultList); // Логування результатів
                    results.add(resultList.isEmpty() ? "No data found." : resultList);
                } else {
                    // Виконуємо інші запити (INSERT, UPDATE, DELETE тощо)
                    int rowsAffected = jdbcTemplate.update(singleQuery);
                    System.out.println("Rows affected: " + rowsAffected); // Логування кількості змінених рядків
                    results.add(Map.of("query", singleQuery, "message", rowsAffected + " rows affected"));
                }
            } catch (DataAccessException e) {
                System.err.println("Error executing query: " + singleQuery);
                System.err.println("Database error: " + e.getMessage());
                results.add(Map.of("query", singleQuery, "error", e.getMessage()));
            }
        }

        return results;
    }
}