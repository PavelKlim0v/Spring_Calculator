package by.tms.spring.service.calculator;

import by.tms.spring.entity.*;

public interface ICalculator {

    Operation calculate(double num1, double num2, String operand);  // Подсчет значений исходя из "operand"

    void selectCalculateOption(int option);  // Выбор действия (сложить, разделить и тд.)

    void history(int option);  // Выбор действия (вывести в консоль все действия, очистить историю, вернуться назад)

}
