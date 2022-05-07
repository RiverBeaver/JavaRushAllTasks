package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    private String fileName;
    private transient FileOutputStream stream;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
       // out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
    //    in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution("D:\\test.txt");
        solution.writeObject("Привет");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\file.txt"));
        objectOutputStream.writeObject(solution);
        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\file.txt"));
        Solution solution1 = (Solution) objectInputStream.readObject();
        solution1.writeObject("Пока");
        objectInputStream.close();
        BufferedReader reader = new BufferedReader(new FileReader("D:\\test.txt"));
        while (reader.ready()) {
            System.out.println(reader.readLine());
        }

    }
}
