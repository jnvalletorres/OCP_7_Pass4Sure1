
import java.io.IOException;
import java.nio.file.FileSystem;
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
        //PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        String pattern = "*???_*?";
        Finder finder = new Finder(pattern);
        Path path = Paths.get("./resources/").toAbsolutePath().normalize();
        try {
            //System.out.println("path: " + path);
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
        System.out.println("file: " + file);
        if (file != null && matcher.matches(file)) {
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
