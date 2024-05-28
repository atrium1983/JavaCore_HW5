package ru.gb.jcore.homework_5.three_byte_value;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    // Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3], и представляют собой,
    // например, состояния ячеек поля для игры в крестикинолики, где 0 – это пустое поле, 1 – это поле с крестиком,
    // 2 – это поле с ноликом, 3 – резервное значение. Такое предположение позволит хранить в одном числе
    // типа int всё поле 3х3. Записать в файл 9 значений так, чтобы они заняли три байта.

    public static void main(String[] args) {
        byte[] values = {2, 0, 3, 1, 0, 2, 1, 1, 0};
        String path = "./src/ru/gb/jcore/homework_5/three_byte_value/values.txt";

        System.out.println(Arrays.toString(values));

        ValuesHandler handler = new ValuesHandler(values, path);
        handler.writeByteArray(); //записать 9 чисел массива, использую только 3 байта, в файл;
        handler.readByteArray(); //прочитать 9 чисел из файла, сохраненных в 3 байтах, в из исходном виде;
    }
}
