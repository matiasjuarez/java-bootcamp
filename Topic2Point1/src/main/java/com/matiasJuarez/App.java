package com.matiasJuarez;

import java.util.Scanner;
import com.matiasJuarez.Dog;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        
        Dog dog = new Dog();
        
        System.out.println("What's your name, human?");
        
        String name = scanner.nextLine();
        
        System.out.println("Greetings, " + name);
        
        dog.bark();
        dog.bark();
        
        scanner.close();
        
    }
}
