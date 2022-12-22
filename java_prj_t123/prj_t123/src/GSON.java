//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class GSON {
    Gson gson = (new GsonBuilder()).setPrettyPrinting().create();

    public GSON() {
    }

    public String writeJson(ArrayList<clock> list, boolean flag) {
        String obj = this.gson.toJson(list);
        if (flag) {
            System.out.println("-----------------------To JSON-------------------");
            System.out.println(obj);
        }

        return obj;
    }

    public ArrayList<clock> readJson(String obj, boolean flag) {
        ArrayList<clock> list = (ArrayList)this.gson.fromJson(obj, ArrayList.class);
        if (flag) {
            System.out.println("-----------------------From JSON-------------------");
            System.out.println(list.toString());
        }

        return list;
    }
}
