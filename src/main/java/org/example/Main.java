package org.example;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        int[] temp = new int[7];
        temp = GetTemperature();
//        double avg = AVGWeekTemperature(temp);
//        int aboveAvg = DaysAboveAVG(temp, avg);

//        System.out.println("Dias com temperatura acima da média: " + aboveAvg);
    }

    public static int[] GetTemperature() {
        int[] temp = new int[7];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite as temperaturas da semana separadas por espaço:");
        for (int i = 0; i < 7; i++) {
            if (scanner.hasNextInt()) {
                temp[i] = scanner.nextInt();
            } else {
                System.out.println("Erro");
                throw new IllegalArgumentException("O array contém um elemento que não é do tipo inteiro.");
            }
        }

        return temp;
    }