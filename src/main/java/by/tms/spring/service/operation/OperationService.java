package by.tms.spring.service.operation;

import by.tms.spring.service.calculator.Calculator;
import by.tms.spring.service.scanner.ItsMyScanner;
import by.tms.spring.service.parser.Parser;
import static by.tms.spring.constants.calculate.ConstantsCalculator.*;

public class OperationService implements IOperationService {

    private static final Calculator calculator = new Calculator();
    private static int option;

    @Override
    public void start() {
        System.out.println("\n" + PRINT_SPACE_THREE + PRINT_SPACE_THREE + PRINT_CALCULATOR_IS_RUNNING);
        int option;
        while (true) {
            option = optionMainMenu();
            switch (option) {
                case FIRST_VALUE_INTEGER:
                    optionCalculator();
                    break;
                case SECOND_VALUE_INTEGER:
                    optionHistory();
                    break;
                case THIRD_VALUE_INTEGER:
                    end();
                    return;
                default:
                    System.out.println(PRINT_INCORRECT_OPTION);
                    break;
            }
        }
    }

    @Override
    public void end() {
        System.out.println("\n" + PRINT_SPACE_THREE + PRINT_SPACE_THREE + PRINT_CALCULATOR_IS_CLOSED);
        ItsMyScanner.close();
    }

    @Override
    public String checkOnTransformOperand(String operand) {
        if (!operand.equals(PLUS) && !operand.equals(MINUS) && !operand.equals(MULTIPLY) && !operand.equals(DIVIDE)) {
            return INVALID_OPERAND;
        }
        return operand;
    }

    @Override
    public int optionMainMenu() {
        System.out.print(PRINT_SPACE_THREE + PRINT_DIVIDING_LINE + "\n" +
                PRINT_SPACE_THREE + PRINT_CALCULATOR + FIRST_VALUE_INTEGER + "\n" +
                PRINT_SPACE_THREE + PRINT_HISTORY + SECOND_VALUE_INTEGER + "\n" +
                PRINT_SPACE_THREE + PRINT_EXIT + THIRD_VALUE_INTEGER + "\n" +
                PRINT_SPACE_THREE + PRINT_DIVIDING_LINE + "\n" +
                " " + PRINT_SPACE_THREE);
        option = Parser.getInputDigit();
        return option;
    }

    @Override
    public void optionCalculator() {
        while (true) {
            System.out.print(PRINT_TAB_FOUR + PRINT_SPACE_THREE + PRINT_DIVIDING_LINE + "\n" +
                    PRINT_TAB_FOUR + PRINT_SPACE_THREE + PRINT_SUM + FIRST_VALUE_INTEGER + "\n" +
                    PRINT_TAB_FOUR + PRINT_SPACE_THREE + PRINT_SUB + SECOND_VALUE_INTEGER + "\n" +
                    PRINT_TAB_FOUR + PRINT_SPACE_THREE + PRINT_MULT + THIRD_VALUE_INTEGER + "\n" +
                    PRINT_TAB_FOUR + PRINT_SPACE_THREE + PRINT_DIV + FOURTH_VALUE_INTEGER + "\n" +
                    PRINT_TAB_FOUR + PRINT_SPACE_THREE + PRINT_EXIT + FIVE_VALUE_INTEGER + "\n" +
                    PRINT_TAB_FOUR + PRINT_SPACE_THREE + PRINT_DIVIDING_LINE + "\n" +
                    " " + PRINT_TAB_FOUR + PRINT_SPACE_THREE);
            option = Parser.getInputDigit();
            if (option == FIVE_VALUE_INTEGER) { break; }
            calculator.selectCalculateOption(option);
        }
    }

    @Override
    public void optionHistory() {
        while (true) {
            System.out.print(PRINT_TAB_FOUR + PRINT_SPACE_THREE + PRINT_DIVIDING_LINE + "\n" +
                    PRINT_TAB_FOUR + PRINT_SPACE_THREE + PRINT_SHOW + FIRST_VALUE_INTEGER + "\n" +
                    PRINT_TAB_FOUR + PRINT_SPACE_THREE + PRINT_CLEAR + SECOND_VALUE_INTEGER + "\n" +
                    PRINT_TAB_FOUR + PRINT_SPACE_THREE + PRINT_EXIT + THIRD_VALUE_INTEGER + "\n" +
                    PRINT_TAB_FOUR + PRINT_SPACE_THREE + PRINT_DIVIDING_LINE + "\n " +
                    " " + PRINT_TAB_FOUR + PRINT_SPACE_THREE);
            option = Parser.getInputDigit();
            if (option == THIRD_VALUE_INTEGER) { break; }
            calculator.history(option);
        }
    }

}
