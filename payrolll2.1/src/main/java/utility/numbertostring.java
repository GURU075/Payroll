package utility;

import java.util.Scanner;

public class numbertostring {
 
    // Strings at index 0 is not used, it is to make array
    // indexing simple
    static String one[] = { "", "one ", "two ", "three ", "four ",
                            "five ", "six ", "seven ", "eight ",
                            "nine ", "ten ", "eleven ", "twelve ",
                            "thirteen ", "fourteen ", "fifteen ",
                            "sixteen ", "seventeen ", "eighteen ",
                            "nineteen " };
 
    // Strings at index 0 and 1 are not used, they are to
    // make array indexing simple
    static String ten[] = { "", "", "twenty ", "thirty ", "forty ",
                            "fifty ", "sixty ", "seventy ", "eighty ",
                            "ninety " };
 
    // n is 1- or 2-digit number
    static String numToWords(int n, String s)
    {
        String str = "";
        // if n is more than 19, divide it
        if (n > 19) {
            str += ten[n / 10] + one[n % 10];
        }
        else {
            str += one[n];
        }
 
        // if n is non-zero
        if (n != 0) {
            str += s;
        }
 
        return str;
    }
 
    // Function to print a given number in words
    String convertToWords(long n)
    {
        // stores word representation of given number n
        String out = "";
 
        // handles digits at ten millions and hundred
        // millions places (if any)
        out += numToWords((int)(n / 10000000), "crore ");
 
        // handles digits at hundred thousands and one
        // millions places (if any)
        out += numToWords((int)((n / 100000) % 100), "lakh ");
 
        // handles digits at thousands and tens thousands
        // places (if any)
        out += numToWords((int)((n / 1000) % 100), "thousand ");
 
        // handles digit at hundreds places (if any)
        out += numToWords((int)((n / 100) % 10), "hundred ");
 
        if (n > 100 && n % 100 > 0) {
            out += "and ";
        }
 
        // handles digits at ones and tens places (if any)
        out += numToWords((int)(n % 100), "");
 
        return out;
    }
 
    // Driver code
    public static void main(String[] args)
    {
    	 numbertostring ns= new numbertostring();
        // long handles upto 9 digit no
        // change to unsigned long long int to
        // handle more digit number
    	Scanner sn= new Scanner(System.in);
    	System.out.print("Enter Number :");
        long n = sn.nextLong();
       
        // convert given number in words
        System.out.printf(ns.convertToWords(n));
        sn.close();
    }
}