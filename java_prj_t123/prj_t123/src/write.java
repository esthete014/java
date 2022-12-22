//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class write {
    public write() {
    }

    public static void write_object(ArrayList<clock> lst, boolean flag) {
        ArrayList<clock> list = lst;

        try {
            FileOutputStream fos = new FileOutputStream("Clocks.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeInt(list.size());
            Iterator var5 = list.iterator();

            clock obj;
            while(var5.hasNext()) {
                obj = (clock)var5.next();
                oos.writeObject(obj);
            }

            if (flag) {
                System.out.println("-----------------Write Object --------------");
                var5 = list.iterator();

                while(var5.hasNext()) {
                    obj = (clock)var5.next();
                    System.out.println(obj);
                }
            }

            oos.close();
        } catch (FileNotFoundException var7) {
            var7.printStackTrace();
        } catch (IOException var8) {
            var8.printStackTrace();
        }

    }
}
