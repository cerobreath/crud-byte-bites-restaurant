package stu.cn.ua.crudbytebitesrestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sql")
public class SQLExecutorController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/execute")
    public Object executePreparedQuery(@RequestBody Map<String, Object> requestBody) {
        String query = (String) requestBody.get("query");
        List<Object> params = (List<Object>) requestBody.get("params");

        System.out.println("Received query: " + query); // Логування запиту
        if (params != null) {
            System.out.println("With parameters: " + params); // Логування параметрів
        }

        try {
            if (query == null || query.trim().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Query cannot be empty");
            }

            String lowerQuery = query.trim().toLowerCase();

            if (params != null && !params.isEmpty()) {
                List<Map<String, Object>> results = jdbcTemplate.query(query, params.toArray(), (rs, rowNum) -> {
                    Map<String, Object> row = new HashMap<>();
                    int columnCount = rs.getMetaData().getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        row.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
                    }
                    return row;
                });
                System.out.println("Query results: " + results); // Логування результатів
                return results.isEmpty() ? List.of("No data found.") : results;
            } else {
                if (lowerQuery.startsWith("select")) {
                    List<Map<String, Object>> resultList = jdbcTemplate.queryForList(query);
                    System.out.println("Query results: " + resultList); // Логування результатів
                    return resultList.isEmpty() ? List.of("No data found.") : resultList;
                } else if (lowerQuery.startsWith("insert") || lowerQuery.startsWith("update") || lowerQuery.startsWith("delete")) {
                    int rowsAffected = jdbcTemplate.update(query);
                    System.out.println("Rows affected: " + rowsAffected); // Логування кількості змінених рядків
                    return Map.of("message", rowsAffected + " rows affected");
                } else {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unsupported SQL operation");
                }
            }
        } catch (DataAccessException e) {
            System.err.println("Database error: " + e.getMessage()); // Логування помилок
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Database error: " + e.getMessage(), e);
        }
    }
}

//public class SQLExecutorController {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @PostMapping("/execute")
//    public Object executeMultipleQueries(@RequestBody Map<String, Object> requestBody) {
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
//            String lowerQuery = singleQuery.toLowerCase();
//            try {
//                if (lowerQuery.startsWith("select")) {
//                    // Виконуємо SELECT запит
//                    List<Map<String, Object>> resultList = jdbcTemplate.queryForList(singleQuery);
//                    System.out.println("Query results: " + resultList); // Логування результатів
//                    results.add(resultList.isEmpty() ? "No data found." : resultList);
//                } else {
//                    // Виконуємо інші запити (INSERT, UPDATE, DELETE, CREATE, DROP тощо)
//                    int rowsAffected = jdbcTemplate.update(singleQuery);
//                    System.out.println("Rows affected: " + rowsAffected); // Логування кількості змінених рядків
//                    results.add(Map.of("query", singleQuery, "message", rowsAffected + " rows affected"));
//                }
//            } catch (DataAccessException e) {
//                System.err.println("Database error: " + e.getMessage()); // Логування помилок
//                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Database error: " + e.getMessage(), e);
//            }
//        }
//
//        return results;
//    }
//}