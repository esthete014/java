
import java.io.Serializable;
public interface clock_interface extends Serializable {
    enum types_arrow {H,M,S}
    int getPrice();
    String getName();
    void PrintDisplay();
    void set_time(types_arrow type, int value);
    void plusTime(types_arrow type, int value);
}
