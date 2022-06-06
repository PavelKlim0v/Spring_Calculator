package by.tms.spring.constants.database;

public class ConstantsDataBase {

    public static final String MYSQL_NAME_TABLE_VALUE = "spring_calc";

    public static final String MYSQL_NAME_COLUM_FIRST_VALUE = "id";
    public static final String MYSQL_NAME_COLUM_SECOND_VALUE = "firstValue";
    public static final String MYSQL_NAME_COLUM_THIRD_VALUE = "secondValue";
    public static final String MYSQL_NAME_COLUM_FOURTH_VALUE = "result";
    public static final String MYSQL_NAME_COLUM_FIVE_VALUE = "operand";

    public static final String MYSQL_SELECT_ALL = "SELECT * FROM " + MYSQL_NAME_TABLE_VALUE;

    public static final String MYSQL_DELETE_ALL = "DELETE FROM " + MYSQL_NAME_TABLE_VALUE;

    public static final String MYSQL_ALTER_TABLE = "ALTER TABLE " + MYSQL_NAME_TABLE_VALUE + " AUTO_INCREMENT = 1";

    public static final String MYSQL_INSERT = "INSERT INTO " + MYSQL_NAME_TABLE_VALUE +
            " (" + MYSQL_NAME_COLUM_SECOND_VALUE + ", " + MYSQL_NAME_COLUM_THIRD_VALUE +
            ", " + MYSQL_NAME_COLUM_FOURTH_VALUE + ", " + MYSQL_NAME_COLUM_FIVE_VALUE + ") VALUES(?,?,?,?)";


}
