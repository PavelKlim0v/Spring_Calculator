package by.tms.spring.service.calculator;

import by.tms.spring.entity.*;
import by.tms.spring.service.operation.OperationService;
import by.tms.spring.service.parser.Parser;
import static by.tms.spring.constants.calculate.ConstantsCalculator.*;
import static by.tms.spring.runner.App.operationDao;

public class Calculator implements ICalculator {

    private static Operation operation;
    private static OperationService operationService;

    @Override
    public Operation calculate(double firstValue, double secondValue, String operand) {
        operation = new Operation();
        operation.setFirstValue(firstValue);
        operation.setSecondValue(secondValue);
        operation.setOperand(operand);
        switch (operand) {
            case PLUS:
                operation.setResult(firstValue + secondValue);
                break;
            case MINUS:
                operation.setResult(firstValue - secondValue);
                break;
            case MULTIPLY:
                operation.setResult(firstValue * secondValue);
                break;
            case DIVIDE:
                operation.setResult(firstValue / secondValue);
                break;
            default:
                operation.setResult(ZERO_VALUE_DOUBLE);
        }
        return operation;
    }

    @Override
    public void selectCalculateOption(int option) {
        String operand;
        switch (option) {
            case FIRST_VALUE_INTEGER:
                operand = PLUS;
                break;
            case SECOND_VALUE_INTEGER:
                operand = MINUS;
                break;
            case THIRD_VALUE_INTEGER:
                operand = MULTIPLY;
                break;
            case FOURTH_VALUE_INTEGER:
                operand = DIVIDE;
                break;
            default:
                System.out.println(PRINT_INCORRECT_OPTION);
                return;
        }
        if (!operationService.checkOnTransformOperand(operand).equals(INVALID_OPERAND)) {
            System.out.print(PRINT_TAB_FOUR + PRINT_SPACE_THREE + PRINT_ENTER_FIRST_VALUE);
            double firstValue = Parser.getInputNumber();
            System.out.print(PRINT_TAB_FOUR + PRINT_SPACE_THREE + PRINT_ENTER_SECOND_VALUE);
            double secondValue = Parser.getInputNumber();

            operation = calculate(firstValue, secondValue, operand);

            operationDao.insert(operation);  //   <--- db
            int countId = 0;
            do {
                ++countId;
            } while (countId != operationDao.selectAll().size());  //   <--- get "id"
            operation.setId(countId);
            System.out.println(" " + PRINT_TAB_FOUR + operation);
            return;
        }
        System.out.println(PRINT_INCORRECT_OPTION);
        return;
    }

    @Override
    public void history(int option) {
        switch (option) {
            case FIRST_VALUE_INTEGER:
                for (Operation item : operationDao.selectAll()) {  //   <--- db
                    System.out.println(PRINT_TAB_FOUR + item);
                }
                if (operationDao.selectAll().size() == ZERO_VALUE_DOUBLE) {
                    System.out.println(PRINT_TAB_FOUR + PRINT_SPACE_THREE + PRINT_SPACE_THREE + PRINT_EMPTY);
                }
                break;
            case SECOND_VALUE_INTEGER:
                operationDao.deleteAll();  //   <--- db
                System.out.println(PRINT_TAB_FOUR + PRINT_SPACE_THREE + PRINT_SPACE_THREE + PRINT_DELETED);
                break;
        }
    }

}
