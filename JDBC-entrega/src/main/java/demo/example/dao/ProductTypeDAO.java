package demo.example.dao;

import java.sql.Connection;
import java.util.List;

import demo.example.model.ProductType;

@SuppressWarnings("unused")
public class ProductTypeDAO extends GenericDaoImpl<ProductType> implements GenericDAO<ProductType> {

    private final String TABLE_NAME = "product_type";

    public ProductTypeDAO(Connection connection) {
        super(ProductType::new, connection);
        super.tableName = TABLE_NAME;
        super.columns = List.of("description");
    }
}