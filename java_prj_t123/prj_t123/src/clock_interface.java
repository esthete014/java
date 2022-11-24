public interface clock_interface {
    public enum types_arrow {H,M,S}
    public int getPrice();
    public String getName();
    public int getHours();
    public int getMinutes();
    public String toString();
    public void PrintDisplay();
    public void set_time(types_arrow type, int value);
}
