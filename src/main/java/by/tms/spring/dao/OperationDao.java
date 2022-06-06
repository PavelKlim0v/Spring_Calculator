package by.tms.spring.dao;

import by.tms.spring.entity.Operation;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.util.List;
import static by.tms.spring.constants.database.ConstantsDataBase.*;

public class OperationDao implements IOperationDao {

    private DataSource dataSource;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Operation operation) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(MYSQL_INSERT, operation.getFirstValue(), operation.getSecondValue(), operation.getResult(), operation.getOperand());
    }

    @Override
    public List<Operation> selectAll() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.query(MYSQL_SELECT_ALL, new OperationRowMapper());
    }

    @Override
    public void deleteAll() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(MYSQL_DELETE_ALL);
        jdbcTemplate.update(MYSQL_ALTER_TABLE);
    }

}
