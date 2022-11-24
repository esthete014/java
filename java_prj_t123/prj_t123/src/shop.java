import java.util.*;

public class shop {
    ArrayList<clock> list = new ArrayList<clock>();
    HashMap<String, Integer> hm = new HashMap<String, Integer>();
    SortedSet<String> ss = new TreeSet<String>();

    public shop() {
        Collections.addAll(list,
                new clock(),
                new clock("Samsung Gear S3", 1500),
                new clock("Rolex GMT-MASTER II", 1365000, 10, 25),
                new clock_seconds(),
                new clock_seconds("Samsung Gear S2", 2300),
                new clock_seconds("Apple watch 3", 10000, 10,5, 21)
        );
    }

    public void addElem(clock newclock) {
        list.add(newclock);
    }

    public int getMaxPrice() {
        Comparator<clock> comp = new Comparator<clock>() {
            @Override
            public int compare(clock o1, clock o2) {
                if(o1.getPrice() > o2.getPrice()) return 1;
                if(o1.getPrice() < o2.getPrice()) return -1;
                return 0;
            }
        };

        return Collections.max(list,comp).getPrice();
    }

    public void setTimeAllclocks(clock_interface.types_arrow type, int value) {
        for (clock o: list) {
            o.set_time(type, value);
        }
    }

    public String getMaxCountName() {
        for (clock obj: list) {
            if (hm.containsKey(obj.getName())) {
                int count = hm.get(obj.getName());
                hm.put(obj.getName(), ++count);
            }
            else {
                hm.put(obj.getName(), 1);
            }
        }
        int maxcount = 0;
        for (clock o: list) {
            int objc = hm.get(o.getName());
            if (objc > maxcount) {
                maxcount = objc;
            }
        }
        String answer = "None";
        for (clock o: list) {
            if (hm.get(o.getName()) == maxcount) {
                answer = o.getName();
            }
        }
        return answer;
    }

    public void printAllMarksOneCount() {
        for (clock one : list) {
            ss.add(one.getName());
        }
        for (String elem : ss) {
            System.out.println(elem);
        }
    }


    @Override
    public String toString() {
        return "shop{" + "list=" + list + "}";
    }
}
