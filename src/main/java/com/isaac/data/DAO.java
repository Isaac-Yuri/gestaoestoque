package com.isaac.data;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    public final String urlDatabase = "jdbc:sqlite:database/estoque.db";

    public List<T> getAll() throws SQLException;

    public void add(T entidade) throws SQLException;

    public void update(T entidade) throws SQLException;

    public void delete(int id) throws SQLException;
}
