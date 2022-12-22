//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class read {
    public read() {
    }

    public static ArrayList<clock> read_object(boolean flag) {
        ArrayList<clock> list = new ArrayList();

        try {
            FileInputStream fis = new FileInputStream("Clocks.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            int size = ois.readInt();

            for(int i = 0; i < size; ++i) {
                list.add((clock)ois.readObject());
            }

            if (flag) {
                System.out.println("-----------------Read Object --------------");
                Iterator var10 = list.iterator();

                while(var10.hasNext()) {
                    clock obj = (clock)var10.next();
                    System.out.println(obj);
                }
            }

            ois.close();
        } catch (FileNotFoundException var7) {
            var7.printStackTrace();
        } catch (IOException var8) {
            var8.printStackTrace();
        } catch (ClassNotFoundException var9) {
            var9.printStackTrace();
        }

        return list;
    }
}
