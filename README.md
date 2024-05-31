# RSA Encryption Example in Java

This project demonstrates a basic implementation of the RSA encryption algorithm in Java. The program takes two user-provided integers, calculates the next prime numbers, and uses these primes to generate RSA keys. The program then encrypts and decrypts a user-provided message.

## Prerequisites

- Java Development Kit (JDK) 8 or higher

## Setup Instructions

1. **Clone the Repository:**

   ```sh
   git clone https://github.com/Dada610/RSA-encryption-java.git
   cd rsa-encryption-java
Compile the Java Code:

sh
Copy code
javac Main.java
Run the Program:

sh
Copy code
java Main
Usage
The program will prompt you to enter two numbers. These numbers will be used to generate prime numbers 
𝑝
p and 
𝑞
q.

The RSA keys are generated using 
𝑝
p and 
𝑞
q:

Public Key: 
𝑒
e
Private Key: 
𝑑
d
Enter the plain text message you want to encrypt.

The program will display the encrypted message and then decrypt it back to the original message.

Code Overview
Main Class:

The entry point of the program. It handles user input, generates RSA keys, and manages the encryption and decryption process.

isPrime Method:

Checks if a number is prime.

nextPrime Method:

Finds the next prime number less than or equal to a given number.

Gcd Method:

Calculates the greatest common divisor (GCD) of two numbers.

encription Method:

Encrypts the given plain text message using the RSA public key.

decryption Method:

Decrypts the encrypted message using the RSA private key.

Example
yaml
Copy code
enter first  number:
17
enter the second  number:
19
Public key: 5
Private key: 29
Enter plain text
hello
pt: hello
After Encryption: ?
?A!!
Decrypted message: 
hello
