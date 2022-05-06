package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution3 {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Solution3 sol = new Solution3();

        try {
            sol.joinData();
        } catch (CorruptedDataException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void joinData() throws CorruptedDataException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        BufferedReader file1 = new BufferedReader(new FileReader(fileName1));
        BufferedReader file2 = new BufferedReader(new FileReader(fileName2));
        while (file1.ready()) {
            allLines.add(file1.readLine());
        }
        file1.close();
        while (file2.ready()) {
            forRemoveLines.add(file2.readLine());
        }
        file2.close();
        blok:{
            for (String str : allLines){
                if (!forRemoveLines.contains(str)) {
                    allLines = null;
                    throw new CorruptedDataException();
                }
            }
            forRemoveLines.removeAll(allLines);
        }

    }
}
