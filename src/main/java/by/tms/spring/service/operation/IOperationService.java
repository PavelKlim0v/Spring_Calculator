package by.tms.spring.service.operation;

public interface IOperationService {

    void start();  // Общий запуск меню калькулятора

    void end();  // Закрытие потоков (при завершении программы)

    int optionMainMenu();  // Вывод сообщений с последующим выбором (калькулятор, истори, закрытие программы)

    void optionCalculator();  // Вывод сообщений с последующим выбором манипуляций с калькулятором

    void optionHistory();  // Вывод сообщений с последующим выбором манипуляций с историей

    String checkOnTransformOperand(String operand);  // Проверка операнда

}
