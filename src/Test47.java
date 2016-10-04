
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
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
public class Test47 {

    public static void main(String[] args) {
        String pattern = "*???_*1?.{txt}";
        Finder finder = new Finder(pattern);
        Path path = Paths.get("./resources/").toAbsolutePath().normalize();
        try {
            Files.walkFileTree(path, finder);
            finder.showFiles();
        } catch (IOException ex) {
            Logger.getLogger(Test47.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

class Finder extends SimpleFileVisitor<Path> {

    final private PathMatcher matcher;
    final private List<Path> files;

    Finder(String pattern) {
        matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
        files = new ArrayList<>();
    }

    private void find(Path file) {
        //Path name = file.getFileName();
        Path name = file.getFileName();
        //System.out.println("name: " + name.getFileName());
        if (name != null && matcher.matches(name)) {

            files.add(file);
        }
    }

    void showFiles() {
        for (Path p : files) {
            System.out.println("getParent: " + p.getParent());
            System.out.println("getFileName: " + p.getFileName());
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        find(file);
        return FileVisitResult.CONTINUE;
    }

}

// * >=0 caracter
// + >=1 caracter
// ? <=1 caracter
// . cualquier caracter 
// \\d digito del 1-9
// \\w cualquier caracter
// \\s cualquier espacio en blanco(\r\t\n\f) 
