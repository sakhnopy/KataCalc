import java.io.IOException;
import java.util.Scanner;

class Calc {
    static Scanner input = new Scanner(System.in);
    static String resultant;


    public static class Main {
        public static String calc(String input) {
            int chislo1 = 0;
            int chislo2 = 0;
            char opera;
            int results = 0;

            String results2;
            String[] str = input.split(" ");
            String stroka1 = str[0];
            String stroka2 = str[1];
            String stroka3 = str[2];
            String stro1 = stroka1.trim();
            String stro2 = stroka2.trim();
            String stro3 = stroka3.trim();

            try {
                chislo1 = Integer.parseInt(stro1);
                chislo2 = Integer.parseInt(stro3);
            } catch (NumberFormatException e) {
                System.err.println("trows Exception // т.к. по тз два числа от 1 до 10, не более");

            }
            if (chislo1 > 10 | chislo2 > 10) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.err.println("trows Exception // т.к. по тз два числа от 1 до 10, не более");

                }
            }
            opera = stro2.charAt(0);
            if (opera == '+') {
                results = chislo1 + chislo2;
            } else if (opera == '-') {
                results = chislo1 - chislo2;
            } else if (opera == '*') {
                results = chislo1 * chislo2;
            } else if (opera == '/') {
                results = chislo1 / chislo2;
            }
            results2 = String.valueOf(results);
            return results2;

        }

        public static void main(String[] args) {
            Convert convert = new Convert();

            String[] roman1 = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            String[] arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

            String inputUser = input.nextLine();
            String[] roman = inputUser.split(" ");

            if (roman.length != 3) {
                try {
                    throw new IOException();
                } catch (Exception e) {
                    System.err.println("trows Exception // т.к. формат строки не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    return;
                }
            }
            String m1;
            String m2;
            try {
                m1 = roman[0];
                m2 = roman[2];
            } catch (ArrayIndexOutOfBoundsException e) {
                return;
            }
            boolean r1 = false;
            boolean r2 = false;
            boolean a1 = false;
            boolean a2 = false;


            for (int i = 0; i < roman1.length; i++) {
                if (roman[0].contains(roman1[i])) {
                    r1 = true;
                }

                if (roman[2].contains(roman1[i])) {
                    r2 = true;
                }

                if (roman[0].contains(arab[i])) {
                    a1 = true;                         // проверка входящих символов
                }

                if (roman[2].contains(arab[i])) {
                    a2 = true;
                }

            }
            if (r1 & a2) {
                try {
                    throw new IOException();
                } catch (Exception e) {
                    System.err.println("throws Exception //т.к. используются одновременно разные системы счисления");
                }
            }
            if (r2 & a1) {
                try {
                    throw new IOException();
                } catch (Exception e) {
                    System.err.println("throws Exception //т.к. используются одновременно разные системы счисления");
                }
            }


            if (r1 & r2) {
                String strn1 = convert.romaToNumber(m1);
                String strn2 = convert.romaToNumber(m2);
                String inputromes = strn1 + " " + roman[1] + " " + strn2;
                resultant = calc(inputromes);
                int resultRome = Integer.parseInt(resultant);

                if (resultRome > 0) {
                    System.out.println(convert.numToRoma(resultRome));
                } else {
                    try {
                        throw new IOException();
                    } catch (Exception e) {
                        System.err.println("throws Exception //т.к.в римской системе нет чисел меньше единицы");
                    }
                }


            }


            if (a1 & a2) {
                resultant = calc(inputUser);


                System.out.println(resultant);
            }
        }
    }
}