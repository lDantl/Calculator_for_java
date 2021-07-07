import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class calculatorForJM {
    public static void main(String[] args) throws IOException {
        Calculator calculator = new Calculator();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        calculator.Calc(string);
    }

    public static class Calculator {
        public void Calc(String string) {
            int number1;
            int number2;
            int result;
            int flag = 0;
            String[] array = string.split(" ");
            try {
                number1 = Integer.parseInt(array[0]);
                number2 = Integer.parseInt(array[2]);
            } catch (NumberFormatException e) {
                number1 = convertToDecimal(array[0]);
                number2 = convertToDecimal(array[2]);
                flag = 1;
            }
            if ((number1 >= 1 && number1 <= 10) && (number2 >= 1 && number2 <= 10)) {
                if (array[1].equals("+"))
                    result = number1 + number2;
                else if (array[1].equals("-"))
                    result = number1 - number2;
                else if (array[1].equals("*"))
                    result = number1 * number2;
                else if (array[1].equals("/"))
                    result = number1 / number2;
                else
                    throw new ArithmeticException("Недопустимый оператор");
            } else
                throw new IllegalArgumentException("Недопустимый операнд");
            if (flag != 0)
                System.out.println(convertToRome(result));
            else
                System.out.println(result);

        }

        public String convertToRome(int result) {
            int[] digitOfArabian = {100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] digitOfRome = {"M", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            String res = "";

            for (int i = 0; i < digitOfArabian.length; i++) {
                while (result >= digitOfArabian[i]) {
                    res = res + digitOfRome[i];
                    result = result - digitOfArabian[i];

                }
            }
            return res;
        }

        public int convertToDecimal(String string) {
            int digit;
            switch (string) {
                case "I":
                    digit = 1;
                    break;
                case "II":
                    digit = 2;
                    break;
                case "III":
                    digit = 3;
                    break;
                case "IV":
                    digit = 4;
                    break;
                case "V":
                    digit = 5;
                    break;
                case "VI":
                    digit = 6;
                    break;
                case "VII":
                    digit = 7;
                    break;
                case "VIII":
                    digit = 8;
                    break;
                case "IX":
                    digit = 9;
                    break;
                case "X":
                    digit = 10;
                    break;
                default:
                    throw new IllegalArgumentException("Недопустимый операнд");
            }
            return digit;
        }

    }
}
