package by.tms.spring.dao;

import by.tms.spring.entity.Operation;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import static by.tms.spring.constants.database.ConstantsDataBase.*;

// Класс загрузки данных в объект Operation из считанной записи таблицы БД
public class OperationRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int line) throws SQLException {
        OperationResultSetExtractor extractor = new OperationResultSetExtractor();
        return extractor.extractData(rs);
    }

    // Класс загрузки данных в объект данных из считанной записи таблицы БД
    static class OperationResultSetExtractor implements ResultSetExtractor {

        @Override
        public Object extractData(ResultSet rs) throws SQLException {
            Operation operation = new Operation();
            operation.setId(rs.getInt(MYSQL_NAME_COLUM_FIRST_VALUE));
            operation.setFirstValue(rs.getDouble(MYSQL_NAME_COLUM_SECOND_VALUE));
            operation.setSecondValue(rs.getDouble(MYSQL_NAME_COLUM_THIRD_VALUE));
            operation.setResult(rs.getDouble(MYSQL_NAME_COLUM_FOURTH_VALUE));
            operation.setOperand(rs.getString(MYSQL_NAME_COLUM_FIVE_VALUE));
            return operation;
        }
    }

}
