import com.sun.tools.jconsole.JConsoleContext;

import java.util.Scanner;

public class Exercises {

    public static void zad1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj text: ");
        String text = sc.nextLine();
        char character = text.charAt(text.length()-1);
        int charCount = 0;
        for(char c: text.toCharArray()) {
            if(c == character) charCount++;
        }
        System.out.println(charCount);
    }
    public static void zad2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj text: ");
        String text = sc.nextLine();
        String text2 = "";
        for(int i = text.length()-1; i >= 0; i--) {
            text2 += text.charAt(i);
        }
        System.out.println(text2);

    }
    public static void zad3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj text: ");
        String text = sc.nextLine();
        String text2 = "";
        for(int i = text.length()-1; i >= 0; i--) {
            text2 += text.charAt(i);
        }
        if(text.equals(text2)) System.out.println("Palindrom"); else System.out.println("Non-Palindrom");

    }
    public static void zad4() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj text: ");
        String text = sc.nextLine();
        int suma = 0;
        for(int i = text.length()-1; i >= 0; i--) {
            try {
                suma += Integer.parseInt(String.valueOf(text.charAt(i)));
            } catch (NumberFormatException e) {
                continue;
            }
        }
        System.out.println(suma);
    }
    public static void zad5() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj dzialanie: ");
        String text = sc.nextLine();
        int openingCount = 0, closingCount = 0;
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '(') openingCount++;
            else if (text.charAt(i) == ')') closingCount++;
            else continue;
            if(closingCount > openingCount){
                System.out.println("Blad");
                break;
            }
        }
        if(openingCount == closingCount) System.out.println("Prawidlowe dzialania");
        else System.out.println("Nieprawidlowe dzialania");
    }
    public static void zad6() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj text: ");
        String text = sc.nextLine();
        System.out.print("Podaj n: ");
        char[] charText = text.toCharArray();
        int n = sc.nextInt();
        for(int i = 0; i < text.length(); i++) {
            if(n < -25 || n > 25) {System.out.println("Alfabet ma 25 liczb debilu"); break;}
            else if(Character.toChars((int) text.charAt(i) + n)[0]<97){
                charText[i] = Character.toChars((int) text.charAt(i) + n + 26)[0];

                System.out.print(charText[i]);
            }
            else if(Character.toChars((int) text.charAt(i) + n)[0]>122){
                charText[i] = Character.toChars((int) text.charAt(i) + n - 26)[0];

                System.out.print(charText[i]);
            }else{
                charText[i] = Character.toChars((int) text.charAt(i) + n)[0];

                System.out.print(charText[i]);
            }
        }
    }
    public static void zad7() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj liczbe:  ");
        int a = sc.nextInt();
        int silnia = 1;
        for(int i = a; i > 0; i--) {
            silnia *= i;
        }
        System.out.println("Silnia iteracyjnie: " + silnia);
        System.out.println("Silnia rekurencyjnie: " + Silnia(a));
    }
    public static void zad8() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj liczbe:  ");
        int a = sc.nextInt();
        System.out.print("Ciag fibonacciego rekurencyjnie dla: " + a + " = " + Fibonacci(a));
        int fib = 1;
        for(int i = 0; i <= a; i++) {
            fib += fib;
            i++;
        }
        System.out.print("Ciag fibonacciego rekurencyjnie dla: " + a + " = " + fib);
    }
    public static int Silnia(int n){
        if(n<=1){return 1;}else{return n * Silnia(n - 1);}
    }
    public static int Fibonacci(int n){
        if(n==0){return 0;}
        else if(n==1){return 1;}
        else if(n > 1){return Fibonacci(n-2) + Fibonacci(n-1);}
        return 0;

    }
    public static int strpos(String text, char z){
        for(int i = 0;i < text.length(); i++){
            if(text.charAt(i) == z){
                return i;
            }
        }
        return -1;
    }
    public static String flipCase(String text){
        if(Character.isUpperCase(text.charAt(0))){
            return text.toLowerCase();
        }

        return text ;
    }
}
