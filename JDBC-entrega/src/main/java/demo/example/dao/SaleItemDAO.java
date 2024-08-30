package demo.example.dao;

import java.sql.Connection;
import java.util.List;

import demo.example.model.SaleItem;

@SuppressWarnings("unused")
public class SaleItemDAO extends GenericDaoImpl<SaleItem> implements GenericDAO<SaleItem>{

    public SaleItemDAO(Connection connection) {
        super(SaleItem::new, connection);
        super.tableName = "sale_item";
        super.columns = List.of("quantity", "percentual_discount");
    }
}
