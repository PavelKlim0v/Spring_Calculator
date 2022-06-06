package by.tms.spring.dao;

import by.tms.spring.entity.Operation;
import javax.sql.DataSource;
import java.util.List;

public interface IOperationDao {

    void setDataSource(DataSource dataSource); // Установка связи с данныими

    void insert(Operation operation); // Вставка новой записи

    List<Operation> selectAll(); // Получение всех записей

    void deleteAll(); // Удаление всех запией

}
