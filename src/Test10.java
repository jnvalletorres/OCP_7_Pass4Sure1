
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vallje02
 */
public class Test10 {

    private static double id;

    public static void main(String[] args) {
        int id = 0;
        Path dir = Paths.get("C:\\Users\\vallje02\\Documents\\NetBeansProjects\\Pass4Sure1\\src");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.{java,html,jar}")) {
            for (Path path : stream) {
                System.out.println("path: " + path);
            }
            System.out.println("id: " + id);
            load();
        } catch (IOException ex) {
            Logger.getLogger(Test10.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void load() {
        id = id + 1;
        System.out.println("id: " + id);
    }

}
