package by.tms.spring.runner;

import by.tms.spring.dao.OperationDao;
import by.tms.spring.service.operation.OperationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *    Калькулятор такой же как и на java SE, но со спрингом.
 *    Взаимодействие через консоль.
 *    Подумать что выводить в компоненты, какой у кого скоуп.
 *    И сохранять и показывать историю операций, конечно же с временем добавления.
 */
public class App {

    public static OperationDao operationDao;

    public static void main(String[] args) {
        try {
            ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
            operationDao = (OperationDao) appContext.getBean("operationDao");
            OperationService operationService = new OperationService();

            operationService.start();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" WARNING!!!");
        }
    }

}
