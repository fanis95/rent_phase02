//biniakou theofanis icsd13126 , afalwniaths straths icsd13018, omadiki askisi 2h fash
import java.time.LocalDate;
import java.util.ArrayList;


public class lecture_hall implements rented{

    protected String name;
    protected ArrayList<LocalDate> rent_hall_dates = new ArrayList<>();
    
    public lecture_hall(String name)
    {
        this.name = name;
    }
    
    public String get_n()
    {
        return name;
    }
    
    @Override
    public double charge_per_day() {
        return 500;
    }

    @Override
    public boolean available(LocalDate d) {
        return rent_hall_dates.contains(d);
    }

    @Override
    public void print() {
        System.out.println("aithousas ekdhlwsewn: " + name);
    }

    @Override
    public void add_date(LocalDate d) {
        rent_hall_dates.add(d);
    }

    @Override
    public void remove_date(LocalDate d) {
        rent_hall_dates.remove(d);
    }

}
