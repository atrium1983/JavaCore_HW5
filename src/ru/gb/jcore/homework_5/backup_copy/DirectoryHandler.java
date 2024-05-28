package ru.gb.jcore.homework_5.backup_copy;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class DirectoryHandler {
    private final String dir = "./src/ru/gb/jcore/homework_5/backup_copy/backup/";
    private final Path backupDir = Path.of(dir);
    public void makeBackup (String source) {
        Path sourceDir = Path.of(source);

        try(DirectoryStream<Path> stream = Files.newDirectoryStream(sourceDir)){
            if(!Files.exists(backupDir)){
                Files.createDirectory(backupDir);
            }

            for (Path file : stream){
                if(!Files.isDirectory(file)){
                    Files.copy(file, Path.of(dir + file.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        } catch (IOException e){
            System.out.println("Ошибка в процессе резервного копирования");
            e.printStackTrace();
        }
    }
}
