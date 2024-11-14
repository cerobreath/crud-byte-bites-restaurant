package stu.cn.ua.crudbytebitesrestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sql")
public class SQLExecutorController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/execute")
    public List<Map<String, Object>> executeQuery(@RequestBody Map<String, String> request) {
        String query = request.get("query");
        return jdbcTemplate.queryForList(query);
    }
}
