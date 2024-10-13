import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        int fib1 = 0;
        int fib2 = 1 ;
        for(int i= 2; i <= a; i++) {
            fib = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib;
        }
        System.out.print("Ciag fibonacciego iteracyjnie dla: " + a + " = " + fib);
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
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isUpperCase(c)) {
                result += Character.toLowerCase(c);
            }
            else if (Character.isLowerCase(c)) {
                result += Character.toUpperCase(c);
            }
            else {
                result += c;
            }
        }
        return result;
    }
    public static boolean startsWith(String str1, String str2) {
        if (str2.length() > str1.length()) {
            return false;
        }
        for (int i = 0; i < str2.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public static int strToInt(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int result = 0;
        int sign = 1;//znak (na poczatku "+")
        int i = 0;
        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        boolean foundDigits = false;
        while (i < str.length()) {
            char c = str.charAt(i);
            if (Character.isDigit(c) || c == ';') {
                foundDigits = true;
                result = result * 10 + (c - '0');
            }
            else if (c == 'e' || c == 'E') {
                i++;
                if (i < str.length() && Character.isDigit(str.charAt(i))) {
                    int e = 0;
                    while (i < str.length() && Character.isDigit(str.charAt(i))) {
                        e = e * 10 + (str.charAt(i) - '0');
                        i++;
                    }
                    return result * sign * (int)Math.pow(10, e);
                }
                break;
            }
            else {
                break;
            }
            i++;
        }
        if (!foundDigits) {
            return 0;
        }
        return result * sign;
    }
    public static int strfind(String g, String c) {
        if (c.isEmpty()) {
            return 0;
        }
        for (int i = 0; i <= g.length() - c.length(); i++) {
            int j;
            for (j = 0; j < c.length(); j++) {
                if (g.charAt(i + j) != c.charAt(j)) {
                    break;
                }
            }
            if (j == c.length()) {
                return i;
            }
        }
        return -1;
    }
    public static int wordCount(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        int wordCount = 0;
        boolean isWord = false;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isWhitespace(c)) {
                isWord = false;
            } else {
                if (!isWord) {
                    wordCount++;
                    isWord = true;
                }
            }
        }
        return wordCount;
    }
    public static String[] podzielNaSlowa(String tekst) {
        if (tekst == null || tekst.trim().isEmpty()) {
            return new String[0];
        }
        String[] slowa = tekst.split("\\s");
        return slowa;
    }
    public static int strFindAndCount(String g, String c) {
        int textInCount = 0;
        int index = 0;

        while (index != -1) {
            index = strfind(g, c);
            if (index != -1) {
                textInCount++;
                index += c.length();
                g = g.substring(index);
            }
        }
        return textInCount;
    }
    public static String strcut(String str, int start, int ile) {
        if (str == null || start < 0 || ile < 0 || start >= str.length()) {
            return str;
        }
        int end = start + ile;
        String before = str.substring(0, start);
        String after = str.substring(end);
        return before + after;
    }
    public static String poprzestawiaj(String tekst, int[] kolejnosc) {
        if (tekst == null || kolejnosc == null) {
            return null;
        }
        char[] wynik = new char[tekst.length()];
        for (int i = 0; i < kolejnosc.length; i++) {
            wynik[i] = tekst.charAt(kolejnosc[i]);
        }
        return new String(wynik);
    }
    public static boolean czyAnagram(String t1, String t2) {
        String filtered1 = t1.toLowerCase();
        String filtered2 = t2.toLowerCase();
        filtered1 = filtered1.replaceAll("\\s+", "");
        filtered2 = filtered2.replaceAll("\\s+", "");
        if (filtered1.length() != filtered2.length()) {
            return false;
        }
        char[] charArrayT1 = filtered1.toCharArray();
        char[] charArrayT2 = filtered2.toCharArray();
        Arrays.sort(charArrayT1);
        Arrays.sort(charArrayT2);
        return Arrays.equals(charArrayT1, charArrayT2);
    }
    public static int[] hexToRgb(String hex) {
        Pattern pattern = Pattern.compile("^#?([a-f\\d]{2})([a-f\\d]{2})([a-f\\d]{2})$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hex);
        if (matcher.matches()) {
            return new int[] {
                    Integer.parseInt(matcher.group(1), 16),
                    Integer.parseInt(matcher.group(2), 16),
                    Integer.parseInt(matcher.group(3), 16)
            };
        }
        return null;
    }
}
