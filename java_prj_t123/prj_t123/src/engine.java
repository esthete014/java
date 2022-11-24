public class engine {
/*
Необходимо реализовать систему классов описания магазина часов.

Количество часов в магазине не ограничено.

Предполагается, что каждые часы содержат информацию о стоимости и названии марки часов.

При реализации необходимо описать два типа часов.

В первом типе часов две стрелки – часовая и минутная, а во втором типе часов добавляется секундная стрелка.

Классы часы должен позволять получать стоимость, название марки часов, устанавливать начальное время,
а также переводить время вперед.

При переводе времени необходимо контролировать корректность введенных данных.

При некорректном задании времени должна возникать исключительная ситуация.
*/
    void test_clock(){
        System.out.println("================CLOCK================");
        System.out.println(java.time.LocalDateTime.now().getHour());
        clock my_clock = new clock();
        my_clock.PrintDisplay();
        System.out.println("--------------------------------------");
        clock second_clock = new clock("", 1300);
        second_clock.PrintDisplay();
        System.out.println("--------------------------------------");
        clock three_clock = new clock("Other clocks", 11111, 11, 32);
        three_clock.PrintDisplay();
        System.out.println("--------------------------------------");
        three_clock.plusTime(10, 10);
        three_clock.PrintDisplay();
        System.out.println(three_clock);
        System.out.println("--------------------------------------");
        three_clock.plusTime(-5, 0);
        System.out.println(three_clock);
        System.out.println("--------------------------------------");
    }
    void test_clock_seconds(){
        System.out.println("|=========CLOCK with SECONDS==========|");
        clock_seconds my_clocks = new clock_seconds();
        System.out.println(my_clocks);
        my_clocks.plusTime(41,122, 414);
        System.out.println(my_clocks);
        System.out.println("--------------------------------------");
        clock_seconds clocks2 = new clock_seconds("New clock", 2500);
        clocks2.plusTime(1, 14, 213);
        System.out.println(clocks2);
        System.out.println("--------------------------------------");
        clock_seconds clocks3 = new clock_seconds("Samsung new", 21999, 2,32, 14);
        System.out.println(clocks3);
        System.out.println("--------------------------------------");
        clocks3.set_time(clock_interface.types_arrow.H, 5);
        System.out.println(clocks3);
    }

/*
Магазин должен позволять:

Получать описания самых дорогих часов.
Устанавливать заданное время на всех часах.
Получать название наиболее часто встречающейся марки часов в магазине.
Выводить марки часов без повторения в упорядоченном виде.
*/
    void test_shop(){
        System.out.println("|================SHOP================|");
        shop my_shop = new shop();
        System.out.println(my_shop);
        System.out.println("Max price: " + my_shop.getMaxPrice());
        System.out.println("Max count name: " + my_shop.getMaxCountName());
        System.out.println("|------------SortList----------------|");
        my_shop.printAllMarksOneCount();
    }
}
