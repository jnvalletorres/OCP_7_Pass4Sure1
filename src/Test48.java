
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ingvalle
 */
public class Test48 {

    public static void main(String[] args) {
        FileSystem fs = FileSystems.getDefault();
        Path basePath = Paths.get("./resources").toAbsolutePath().normalize();
        Path sourcePath = basePath.resolve("source");
        Path targetPath = basePath.resolve("target");
        Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rwx------");
        FileAttribute<Set<PosixFilePermission>> attributes = PosixFilePermissions.asFileAttribute(permissions);

        try {
            System.out.println("pathBase: " + basePath);
            sourcePath = createDirectory(sourcePath,attributes);
            targetPath = createDirectory(targetPath,attributes);

            if (!Files.exists(sourcePath.resolve("tmp.txt"))) {
                Files.createFile(sourcePath.resolve("tmp.txt"), attributes);
            }
            System.out.println("move file, from: " + sourcePath.resolve("tmp.txt") + ", to: " + targetPath.resolve("tmp."));
            Files.move(sourcePath.resolve("tmp.txt"), targetPath.resolve("tmp.txt"), StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
        } catch (IOException ex) {
            Logger.getLogger(Test48.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Path createDirectory(Path dir, FileAttribute<Set<PosixFilePermission>> attributes) throws IOException {
        System.out.println("getParent: " + dir.getParent());
        System.out.println("dir: " + dir);
        System.out.println("isDirectory: " + Files.isDirectory(dir));
        System.out.println("isAbsolute: " + dir.isAbsolute());
        //if (Files.isDirectory(dir)) {
        if (!Files.exists(dir)) {
            Files.createDirectory(dir,attributes);
            System.out.println("createDirectory: " + dir);
        }

        //} else {
        //System.out.println(String.format("The directory %s, it could not be create...", dir.toString()));
        //}
        return dir;
    }

}
