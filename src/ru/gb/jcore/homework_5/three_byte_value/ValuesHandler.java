package ru.gb.jcore.homework_5.three_byte_value;

import java.io.*;
import java.util.Arrays;

public class ValuesHandler {
    private final byte[] values;
    private final String path;

    public ValuesHandler(byte[] values, String path) {
        this.values = values;
        this.path = path;
    }

    public void getSizeInByte() {
        File file = new File(path);
        System.out.println((double) file.length() + " bytes");
    }

    public void writeByteArray() {
        File file = new File(path);
        byte[] toWrite = new byte[3];
        byte buf = 0;
        byte num = 0;
        int index = 0;
        try {
            FileOutputStream out = new FileOutputStream(file);
            for (byte value : values) {
                num += (byte) (value << (buf * 2));
                buf++;
                if (buf == 3) {
                    toWrite[index] = num;
                    buf = 0;
                    num = 0;
                    index++;
                }
            }
            System.out.println(Arrays.toString(toWrite));
            out.write(toWrite);
            out.close();
            getSizeInByte();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readByteArray() {
        int[] values = new int[9];
        int toRead;
        try (FileInputStream in = new FileInputStream(path)){
            for (int i = 0; i < values.length; i += 3) {
                toRead = in.read();
                System.out.println(Integer.toBinaryString(toRead));
                values[i] = (byte) (toRead << 30 >>> 30);
                values[i + 1] = (byte) (toRead << 28 >>> 30);
                values[i + 2] = toRead << 26 >>> 30;
            }
            System.out.println(Arrays.toString(values));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
