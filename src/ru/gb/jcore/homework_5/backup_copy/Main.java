package ru.gb.jcore.homework_5.backup_copy;

public class Main {
    // Задание 1. Написать функцию, создающую резервную копию всех файлов в директории
    //(без поддиректорий) во вновь созданную папку ./backup

    public static void main(String[] args) {
        String sourceDir = "./src/ru/gb/jcore/homework_5/backup_copy/files";
        DirectoryHandler handler = new DirectoryHandler();
        handler.makeBackup(sourceDir);
    }
}
