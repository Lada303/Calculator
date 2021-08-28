package com.company;

import java.util.Scanner;

public class Main {

   public static void main(String[] args) {

        HelloInstruction ();

        Scanner input = new Scanner(System.in);
        String InputString;
        while ( true ) {
            System.out.print("Input: ");
            InputString = input.nextLine();
            if (InputString.equalsIgnoreCase("Exit")) {break;}
            InputString = InputString.replaceAll(" ","");
            if (InputString.isEmpty()) {System.out.println("Строка пустая"); continue;}

            // Определяем кол-во, место в строке и тип арифметического, отрабатываем исключение
            char[] ArrOperand = {'+', '-', '*', '/'};
            int IndexSymbol = 0, countSymbol = 0;
            for (int i =0; i < InputString.length(); i++ ) {
                for (char a:ArrOperand) {
                    if (InputString.charAt(i) == a) {
                        countSymbol++;
                        if (countSymbol > 1) break;
                        IndexSymbol = i;
                    }
                }
            }
            if (countSymbol > 1) {System.out.println("Введено более 1 арифметического символа");continue;}
            if (countSymbol == 0) {System.out.println("Нет подходящего арифметического символа");continue;}
            if (IndexSymbol == 0 || IndexSymbol == InputString.length()-1)
               {System.out.println("Введено только 1 число до или после арифметического символа");continue;}

            int Num1, Num2;
            int countLength=1;
            // Ищем арабские цифры
            char[] ArrArab = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
            for (int i =0; i < InputString.length(); i++ ) {
                   for (char a:ArrArab) {
                        if (InputString.charAt(i) == a) countLength++;
                   }
            }
            if (countLength >1  & countLength != InputString.length()) {
                System.out.println("Используются одновременно разные системы или введены лишние символы");
                continue;
            }
            if (countLength >1) {
                Num1 = Integer.parseInt(InputString.substring(0, IndexSymbol));
                Num2 = Integer.parseInt(InputString.substring(IndexSymbol + 1));
                if (Num1 > 10 || Num2 > 10) {
                    System.out.println("Введено арабское число более 10");
                    continue;
                }
                if (Num1 == 0 || Num2 == 0) {
                    System.out.println("Операции с нулем не производятся");
                    continue;
                }
                // Производим арифметические действия
                ArithmeticOperation Operation = new ArithmeticOperation( InputString.charAt(IndexSymbol), Num1, Num2);
                System.out.println(Operation.result());
            }
            else {
                // Проверяем на наличие Римских цифр
                Num1 = ConvertingRomNum.RecognizeRom(InputString.substring(0, IndexSymbol));
                Num2 = ConvertingRomNum.RecognizeRom(InputString.substring(IndexSymbol+1));
                if (Num1 > 10 || Num2 > 10) {
                    System.out.println("Введено римское число более 10");
                    continue;
                }
                if (Num1 == 0 || Num2 == 0) {
                    System.out.println("Ошибка при введении римских чисел");
                    continue;
                }
                // Производим арифметические действия и переводим в римские
                ArithmeticOperation Operation = new ArithmeticOperation( InputString.charAt(IndexSymbol), Num1, Num2);
                if (Operation.result() <= 0) System.out.println("Результат меньше или равен нулю");
                else System.out.println(ConvertingRomNum.ConvArabRom(Operation.result()));
            }
        }
    }

 static void HelloInstruction () {
     System.out.println("Приветствую!");
     System.out.println("Работаю с Арабскими ИЛИ Римскими цифрами от 1 до 10");
     System.out.println("Арифметические операции: + (плюс), - (минус), * (умножить) , / (разделить)");
     System.out.println("Примеры: 1+1, 9/3, I+II, IV*X, X-VI");
     System.out.println("Для завершения работы введи Exit.");
     System.out.println("Приступайте!");
 }


}




