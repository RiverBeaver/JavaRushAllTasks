package com.javarush.task.task17.task1711;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution1 {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
   //     if (args.length!= 0)
            switch (args[0]){
                case "-c":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i += 3) {
                            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(args[2+i]);
                            if (args[1+i].equals("ж")) {
                                allPeople.add(Person.createFemale(args[i], date));
                                System.out.println(allPeople.size()-1);
                            } else {
                                allPeople.add(Person.createMale(args[i], date));
                                System.out.println(allPeople.size()-1);
                            }
                        }
                        break;
                    }
                case "-u":
                    synchronized (allPeople){
                        for (int i = 1; i < args.length; i += 4) {
                            int id = Integer.parseInt(args[i]);
                            allPeople.get(id).setName(args[1+i]);
                            allPeople.get(id).setBirthDate(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3+i]));
                            allPeople.get(id).setSex(args[2+i].equals("ж")? Sex.FEMALE: Sex.MALE);
                        }
                        break;
                    }
                case "-d":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i ++) {
                            int iD = Integer.parseInt(args[i]);
                            allPeople.get(iD).setSex(null);
                            allPeople.get(iD).setName(null);
                            allPeople.get(iD).setBirthDate(null);
                        }
                        break;
                    }
                case "-i":
                    synchronized (allPeople) {
                        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        for (int i = 1; i < args.length; i++) {
                            Person person = allPeople.get(Integer.parseInt(args[i]));
                            System.out.printf("%s %s %s", person.getName(), person.getSex() == com.javarush.task.task17.task1711.Sex.FEMALE ? "ж" : "м", format.format(person.getBirthDate()));
                            System.out.println();
                        }
                    }
            }
    }
}
