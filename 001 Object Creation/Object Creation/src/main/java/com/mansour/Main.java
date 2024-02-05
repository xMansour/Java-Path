package com.mansour;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) {
        //TIP creating an object using the new keyword
        Person person1 = new Person("Mahmoud");
        System.out.println("person1 = " + person1);

        //TIP creating an object using Class.forName() method. Requires fully qualified class name and ClassNotFoundException handling. It only works with a no argument constructor
        try {
            Person person2 = (Person) Class.forName("com.mansour.Person").newInstance();
            System.out.println("person2 = " + person2);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        //TIP inorder to use Class.forName with a constructor that takes arguments
        try {
            Constructor personConstructor = Class.forName("com.mansour.Person").getConstructor(String.class);
            Person person3 = (Person) personConstructor.newInstance("Mansour");
            System.out.println("person3 = " + person3);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            e.printStackTrace();
        }
        //TIP creating an object using Object.clone method. Clone method is protected tho. Person should implement the clonable interface to avoid CloneNotSupportedException.
        try {
            Person person4 = (Person) person1.clone();
            System.out.println("person4 = " + person4);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        //TIP creating an object using serialization

        try (FileOutputStream fileOutputStream = new FileOutputStream("person.ser"); ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            Person person5 = new Person("Ahmed", "password");
            System.out.println("person5 = " + person5);
            objectOutputStream.writeObject(person5);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //TIP password is transient, so it will not be serialized and when deserialized it will be retrieved with the default value "null" since password is of type String.
        try (FileInputStream fileInputStream = new FileInputStream("person.ser"); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Person person6 = (Person) objectInputStream.readObject();
            System.out.println("person6 = " + person6);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}