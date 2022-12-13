import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Calculator {
    public static void main(String[] args) throws Exception {
        System.out.print("Введите любое из четырех возможных выражений вида: a + b, a - b, a * b, a / b:");
        System.out.println();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        if (input.charAt(0) == ' ') {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.print("Недопустимое выражение! Проверьте корректность ввода.");;
            }
        } else {
            String[] inputMass = input.split(" ");
            int count = 0;
            for (String word : inputMass) {
                count++;
            }
            if (count != 3) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.print("Недопустимое выражение! Проверьте корректность ввода.");;
                }
            } else {
                String[] numbersArabic = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
                String[] numbersRoman = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
                String[] symbols = new String[]{"+", "-", "*", "/"};

                if (Arrays.asList(numbersArabic).contains(inputMass[0]) && Arrays.asList(symbols).contains(inputMass[1]) && Arrays.asList(numbersArabic).contains(inputMass[2])) {
                    int numberOne = Integer.parseInt(inputMass[0]);
                    int numberTwo = Integer.parseInt(inputMass[2]);
                    if (inputMass[1].equals(symbols[0])){
                        System.out.println(AdditionArabic(numberOne, numberTwo));
                    }
                    else if (inputMass[1].equals(symbols[1])){
                        System.out.println(SubtractionArabic(numberOne, numberTwo));
                    }
                    else if (inputMass[1].equals(symbols[2])){
                        System.out.println(MultiplicationArabic(numberOne, numberTwo));
                    }
                    else if (inputMass[1].equals(symbols[3])){
                        System.out.println(DivisionArabic(numberOne, numberTwo));
                    }
                }
                else if (Arrays.asList(numbersRoman).contains(inputMass[0]) && Arrays.asList(symbols).contains(inputMass[1]) && Arrays.asList(numbersRoman).contains(inputMass[2])) {
                    int numberOne = 0;
                    int numberTwo = 0;
                    switch (inputMass[0]){
                        case "I" :
                            numberOne = 1;
                            break;
                        case "II" :
                            numberOne = 2;
                            break;
                        case "III" :
                            numberOne = 3;
                            break;
                        case "IV" :
                            numberOne = 4;
                            break;
                        case "V" :
                            numberOne = 5;
                            break;
                        case "VI" :
                            numberOne = 6;
                            break;
                        case "VII" :
                            numberOne = 7;
                            break;
                        case "VIII" :
                            numberOne = 8;
                            break;
                        case "IX" :
                            numberOne = 9;
                            break;
                        case "X" :
                            numberOne = 10;
                            break;
                    }
                    switch (inputMass[2]){
                        case "I" :
                            numberTwo = 1;
                            break;
                        case "II" :
                            numberTwo = 2;
                            break;
                        case "III" :
                            numberTwo = 3;
                            break;
                        case "IV" :
                            numberTwo = 4;
                            break;
                        case "V" :
                            numberTwo = 5;
                            break;
                        case "VI" :
                            numberTwo = 6;
                            break;
                        case "VII" :
                            numberTwo = 7;
                            break;
                        case "VIII" :
                            numberTwo = 8;
                            break;
                        case "IX" :
                            numberTwo = 9;
                            break;
                        case "X" :
                            numberTwo = 10;
                            break;
                    }
                    if (inputMass[1].equals(symbols[0])){
                        System.out.println(AdditionRoman(numberOne, numberTwo));
                    }
                    else if (inputMass[1].equals(symbols[1])){
                        System.out.println(SubtractionRoman(numberOne, numberTwo));
                    }
                    else if (inputMass[1].equals(symbols[2])){
                        System.out.println(MultiplicationRoman(numberOne, numberTwo));
                    }
                    else if (inputMass[1].equals(symbols[3])){
                        System.out.println(DivisionRoman(numberOne, numberTwo));
                    }
                }
                else if ((Arrays.asList(numbersArabic).contains(inputMass[0]) && Arrays.asList(symbols).contains(inputMass[1]) && Arrays.asList(numbersRoman).contains(inputMass[2])) || (Arrays.asList(numbersRoman).contains(inputMass[0]) && Arrays.asList(symbols).contains(inputMass[1]) && Arrays.asList(numbersArabic).contains(inputMass[2]))) {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.print("Недопустимое выражение, т.к. используются одновременно разные системы счисления.");
                    }
                } else {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.print("Недопустимое выражение! Проверьте корректность ввода.");;
                    }
                }
            }
        }
    }
    public static int AdditionArabic (int a, int b) {
        int result = a + b;
        return result;
    }
    public static int SubtractionArabic (int a, int b) {
        int result = a - b;
        return result;
    }
    public static int MultiplicationArabic (int a, int b) {
        int result = a * b;
        return result;
    }
    public static int DivisionArabic (int a, int b) {
        int result = a / b;
        return result;
    }
    public static String AdditionRoman (int a, int b) {
        int result = a + b;
        int checkOutOne = result / 10;
        int checkOutTwo = result % 10;
        String answerLineStart = null;
        String answerLineEnd = null;
        switch (checkOutOne){
            case 0 :
                answerLineStart = "";
                break;
            case 1 :
                answerLineStart = "X";
                break;
            case 2 :
                answerLineStart = "XX";
                break;
            case 3 :
                answerLineStart = "XXX";
                break;
            case 4 :
                answerLineStart = "XL";
                break;
            case 5 :
                answerLineStart = "L";
                break;
            case 6 :
                answerLineStart = "LX";
                break;
            case 7 :
                answerLineStart = "LXX";
                break;
            case 8 :
                answerLineStart = "LXXX";
                break;
            case 9 :
                answerLineStart = "XC";
                break;
            case 10 :
                answerLineStart = "C";
                break;
        }
        switch (checkOutTwo){
            case 0 :
                answerLineEnd = "";
                break;
            case 1 :
                answerLineEnd = "I";
                break;
            case 2 :
                answerLineEnd = "II";
                break;
            case 3 :
                answerLineEnd = "III";
                break;
            case 4 :
                answerLineEnd = "IV";
                break;
            case 5 :
                answerLineEnd = "V";
                break;
            case 6 :
                answerLineEnd = "VI";
                break;
            case 7 :
                answerLineEnd = "VII";
                break;
            case 8 :
                answerLineEnd = "VIII";
                break;
            case 9 :
                answerLineEnd = "IX";
                break;
            case 10 :
                answerLineEnd = "X";
                break;
        }
        String answer = answerLineStart + answerLineEnd;
        return answer;
    }
    public static String SubtractionRoman (int a, int b) {
        int result = a - b;
        if (result < 1) {
            try {
                throw new IOException();
            } catch (IOException e) {
                return "Недопустимое выражение, т.к. в римской системе нет отрицательных чисел.";
            }
        } else {
            int checkOutOne = result / 10;
            int checkOutTwo = result % 10;
            String answerLineStart = null;
            String answerLineEnd = null;
            switch (checkOutOne){
                case 0 :
                    answerLineStart = "";
                    break;
                case 1 :
                    answerLineStart = "X";
                    break;
                case 2 :
                    answerLineStart = "XX";
                    break;
                case 3 :
                    answerLineStart = "XXX";
                    break;
                case 4 :
                    answerLineStart = "XL";
                    break;
                case 5 :
                    answerLineStart = "L";
                    break;
                case 6 :
                    answerLineStart = "LX";
                    break;
                case 7 :
                    answerLineStart = "LXX";
                    break;
                case 8 :
                    answerLineStart = "LXXX";
                    break;
                case 9 :
                    answerLineStart = "XC";
                    break;
                case 10 :
                    answerLineStart = "C";
                    break;
            }
            switch (checkOutTwo){
                case 0 :
                    answerLineEnd = "";
                    break;
                case 1 :
                    answerLineEnd = "I";
                    break;
                case 2 :
                    answerLineEnd = "II";
                    break;
                case 3 :
                    answerLineEnd = "III";
                    break;
                case 4 :
                    answerLineEnd = "IV";
                    break;
                case 5 :
                    answerLineEnd = "V";
                    break;
                case 6 :
                    answerLineEnd = "VI";
                    break;
                case 7 :
                    answerLineEnd = "VII";
                    break;
                case 8 :
                    answerLineEnd = "VIII";
                    break;
                case 9 :
                    answerLineEnd = "IX";
                    break;
                case 10 :
                    answerLineEnd = "X";
                    break;
            }
            String answer = answerLineStart + answerLineEnd;
            return answer;
        }
    }
    public static String MultiplicationRoman (int a, int b) {
        int result = a * b;
        int checkOutOne = result / 10;
        int checkOutTwo = result % 10;
        String answerLineStart = null;
        String answerLineEnd = null;
        switch (checkOutOne){
            case 0 :
                answerLineStart = "";
                break;
            case 1 :
                answerLineStart = "X";
                break;
            case 2 :
                answerLineStart = "XX";
                break;
            case 3 :
                answerLineStart = "XXX";
                break;
            case 4 :
                answerLineStart = "XL";
                break;
            case 5 :
                answerLineStart = "L";
                break;
            case 6 :
                answerLineStart = "LX";
                break;
            case 7 :
                answerLineStart = "LXX";
                break;
            case 8 :
                answerLineStart = "LXXX";
                break;
            case 9 :
                answerLineStart = "XC";
                break;
            case 10 :
                answerLineStart = "C";
                break;
        }
        switch (checkOutTwo){
            case 0 :
                answerLineEnd = "";
                break;
            case 1 :
                answerLineEnd = "I";
                break;
            case 2 :
                answerLineEnd = "II";
                break;
            case 3 :
                answerLineEnd = "III";
                break;
            case 4 :
                answerLineEnd = "IV";
                break;
            case 5 :
                answerLineEnd = "V";
                break;
            case 6 :
                answerLineEnd = "VI";
                break;
            case 7 :
                answerLineEnd = "VII";
                break;
            case 8 :
                answerLineEnd = "VIII";
                break;
            case 9 :
                answerLineEnd = "IX";
                break;
            case 10 :
                answerLineEnd = "X";
                break;
        }
        String answer = answerLineStart + answerLineEnd;
        return answer;
    }
    public static String DivisionRoman (int a, int b) {
        int result = a / b;
        int checkOutOne = result / 10;
        int checkOutTwo = result % 10;
        String answerLineStart = null;
        String answerLineEnd = null;
        switch (checkOutOne){
            case 0 :
                answerLineStart = "";
                break;
            case 1 :
                answerLineStart = "X";
                break;
            case 2 :
                answerLineStart = "XX";
                break;
            case 3 :
                answerLineStart = "XXX";
                break;
            case 4 :
                answerLineStart = "XL";
                break;
            case 5 :
                answerLineStart = "L";
                break;
            case 6 :
                answerLineStart = "LX";
                break;
            case 7 :
                answerLineStart = "LXX";
                break;
            case 8 :
                answerLineStart = "LXXX";
                break;
            case 9 :
                answerLineStart = "XC";
                break;
            case 10 :
                answerLineStart = "C";
                break;
        }
        switch (checkOutTwo){
            case 0 :
                answerLineEnd = "";
                break;
            case 1 :
                answerLineEnd = "I";
                break;
            case 2 :
                answerLineEnd = "II";
                break;
            case 3 :
                answerLineEnd = "III";
                break;
            case 4 :
                answerLineEnd = "IV";
                break;
            case 5 :
                answerLineEnd = "V";
                break;
            case 6 :
                answerLineEnd = "VI";
                break;
            case 7 :
                answerLineEnd = "VII";
                break;
            case 8 :
                answerLineEnd = "VIII";
                break;
            case 9 :
                answerLineEnd = "IX";
                break;
            case 10 :
                answerLineEnd = "X";
                break;
        }
        String answer = answerLineStart + answerLineEnd;
        return answer;
    }
}