import com.sun.javafx.util.Logging;

import java.util.ArrayList;

public class ClassLoaders {

    public static void main(String... a) throws ClassNotFoundException {
        ClassLoaders cl = new ClassLoaders();
        cl.printclassloaders();
    }

    public void printclassloaders() throws ClassNotFoundException {
        System.out.println("Classloader of this class:"
                + ClassLoaders.class.getClassLoader());

        System.out.println("Classloader of Logging:"
                + Logging.class.getClassLoader());

        System.out.println("Classloader of ArrayList:"
                + ArrayList.class.getClassLoader());
    }
}
