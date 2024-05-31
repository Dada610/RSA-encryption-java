import java.math.BigInteger;
import java.util.Scanner;

import static java.lang.String.*;

public class Main {

    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        System.out.println("enter first  number:");
        int p = ob.nextInt();
        p = nextPrime(p);
        System.out.print("enter the second  number:");
        int q = ob.nextInt();
        q = nextPrime(q);
        int n = p * q;
        int m = (p - 1) * (q - 1);
        int e;

        for (e = 2; e < m; e++) {
            if (Gcd(m, e) == 1) {
                break;
            }
        }

        int d = 0;
        int r;
        for (int i = 0; i <= e; i++) {
            r = ((m * i) + 1);
            if (r % e == 0) {
                d = r / e;
            }
        }
        System.out.println("Public key: " + e);
        System.out.println("Private key: " + d);
        System.out.println("Enter plain text");
        ob.nextLine();
        String text = ob.nextLine();
        System.out.println("Message to encrypt: " + text);
        int[] secret = encription(text, e, n);
        BigInteger[] recovered = decryption(secret, d, n);
        System.out.println("Decrypted message: ");
        for (BigInteger bigInteger : recovered) {
            System.out.print((char) bigInteger.intValue());
        }
    }

    public static boolean isPrime(int n) {
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                counter++;
            }
        }
        return counter == 2;
    }

    public static int nextPrime(int x) {
        int found = 0;
        for (int i = x; ; i--) {
            if (isPrime(i)) {
                found = i;
                break;
            }
        }
        return found;
    }

    public static int Gcd(int x, int y) {
        int gcd = 1;
        for (int i = 1; i <= x && i <= y; i++) {
            if (x % i == 0 && y % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    private static int[] encription(String str, int e, int n) {
        int[] cipher = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            cipher[i] = (int) ((Math.pow((int) str.charAt(i), e)) % n);
        }
        System.out.print("After Encryption: ");
        for (int i : cipher) {
            System.out.print((char) i);
        }
        System.out.println();
        return cipher;
    }

    private static BigInteger[] decryption(int[] strenc, int d, int n) {
        BigInteger[] orignal = new BigInteger[strenc.length];
        for (int i = 0; i < strenc.length; i++) {
            orignal[i] = new BigInteger(valueOf(strenc[i])).modPow(BigInteger.valueOf(d), BigInteger.valueOf(n));
        }
        return orignal;
    }

    public static double power(int q, int n, int m) {
        double result = 1;
        while (n > 0) {
            if ((n & 1) != 0)
                result = result * q;

            // y must be even now
            n = n >> 1; // y = y/2
            q = q * q; // Change x to x^2
        }
        return result % m;
    }
}