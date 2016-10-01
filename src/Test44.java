
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vallje02
 */
public class Test44 {

    public static void main(String[] args) {
        showExample((short) 7);
    }

    private static void showExample(short id) {

        String str = "";
        String pattern = "";

        switch (id) {
            case 1:
                str = "Java 7, Java 6";
                pattern = "Java.+\\d";
                break;
            case 2:
                str = "agosto";
                pattern = "ago.{3}";
                break;
            case 3:
                str = "Hello how are you";
                pattern = "how";
                break;
            case 4:
                str = "Hello how are you";
                pattern = "\\w\\s+";
                break;
            case 5:
                str = "LSDKSLDK AGO, IN A GALAXY FAR ago FAR, far, farAWAY";
                pattern = "(ago|AGO).?(far|FAR)";
                break;
            case 6:
                str = "sdsdsdd tdmes, tdmes";
                pattern = "t.mes";
                break;
            case 7:
                str = "java.txt";
                pattern = ".*[.]{1}txt";
                break;
        }

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        while (m.find()) {
            System.out.println(m.group());
        }

    }
}

/**
 * Quantifiers: *: cero o mas veces +: una o mas veces ?: una o ninguna {n}: n
 * veces {n,m}: desde n a m veces {n,}; dede n veces a infinito (xx){n}: el
 * grupo de caracteres se repiten n veces
 */
