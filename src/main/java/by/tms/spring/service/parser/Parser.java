package by.tms.spring.service.parser;

import by.tms.spring.service.scanner.ItsMyScanner;
import static by.tms.spring.constants.calculate.ConstantsCalculator.MIN_VALUE_DOUBLE;
import static by.tms.spring.constants.calculate.ConstantsCalculator.MIN_VALUE_INTEGER;

public class Parser {

    public static Integer getInputDigit() {
        String input = ItsMyScanner.getInput();
        return isDigit(input) ? Integer.parseInt(input) : MIN_VALUE_INTEGER;
    }

    public static boolean isDigit(String text) {
        return text.matches("[0-9]+");
    }

    public static double getInputNumber() {
        String input = ItsMyScanner.getInput();
        return isNumber(input) ? Double.parseDouble(input) : MIN_VALUE_DOUBLE;
    }

    public static boolean isNumber(String text) {
        return text.matches("[0-9]+([.][0-9]+)?");
    }

}
