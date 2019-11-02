package com.xxd.dao;

import java.sql.SQLException;

public interface SqlSession {
    int save(String sql) throws SQLException;
}
