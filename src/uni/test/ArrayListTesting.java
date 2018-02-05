package uni.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTesting {
    public static void main(String[] args) {
        ArrayList<String> array1 = new ArrayList<>();
        array1.add("Nasko");
        array1.add("Stefi");
        array1.add("Maria");
        array1.add("Vladi");

        printArray(array1);


        ArrayList<String> array2 = new ArrayList<>();

        copyArray(array1, array2);

        System.out.println("Array 1");
        printArray(array1);
        System.out.println("Array 2");
        printArray(array2);

        array1.add("Petar");

        array2.add("Nikolai");

        System.out.println("Array 1");
        printArray(array1);
        System.out.println("Array 2");
        printArray(array2);

    }

    private static void copyArray(ArrayList<String> srcArray, ArrayList<String> destArray) {
        destArray.addAll(srcArray);
    }

    private static void cpArray(ArrayList<String> srcArray, ArrayList<String> destArray) {
        int arraySize = srcArray.size();

        for (int i = 0; i < arraySize; i++) {
            String str = srcArray.get(i);
            destArray.add(str);
        }
    }

    private static void printArray(ArrayList<String> tempArray) {
        for (String s : tempArray) {
            System.out.println(s);
        }
        System.out.println("------------------------");
    }
}
