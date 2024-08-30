package demo.example.dao;

import java.sql.Connection;
import java.util.List;

import demo.example.model.Sale;

@SuppressWarnings("unused")
public class SaleDAO extends GenericDaoImpl<Sale> implements GenericDAO<Sale> {

    public SaleDAO(Connection connection) {
        super(Sale::new, connection);
        super.tableName = "sale";
        super.columns = List.of("insert_at");
    }
}
