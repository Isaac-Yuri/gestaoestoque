package com.isaac.data;

import java.sql.SQLException;
import java.util.List;

public abstract class DAO {
    protected final String urlDatabase = "jdbc:sqlite:database/estoque.db";

    @SuppressWarnings("rawtypes")
    public abstract List getAll() throws SQLException;
    public abstract void add() throws SQLException;
    public abstract void update() throws SQLException;
    public abstract void delete() throws SQLException;
}
