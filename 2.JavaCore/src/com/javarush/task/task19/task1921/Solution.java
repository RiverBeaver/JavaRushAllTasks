package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        String fileName = args[0];
        List<String> linesFromTheFile = new ArrayList<>();
        try (BufferedReader file = new BufferedReader(new FileReader(fileName))){
            while (file.ready()){
                linesFromTheFile.add(file.readLine());
            }
        }
        for(String line : linesFromTheFile){
            addPerson(line);
        }
        for (Person person : PEOPLE)
        System.out.println(person.getName() + " " + person.getBirthDate());
    }

    private static void addPerson(String line) throws ParseException {
        String[] parts = line.split(" ");
        String dateStr = String.format("%s/%s/%s", parts[parts.length-3], parts[parts.length-2], parts[parts.length-1]);
        Date date = (new SimpleDateFormat("dd/MM/yyyy")).parse(dateStr);
        String name = "";
        for (int i = 0; i < parts.length-4; i++) {
            name += parts[i]+" ";
        }
        name += parts[parts.length-4];
        PEOPLE.add(new Person(name, date));
    }
}
