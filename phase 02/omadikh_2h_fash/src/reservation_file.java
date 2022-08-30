//biniakou theofanis icsd13126 , afalwniaths straths icsd13018, omadiki askisi 2h fash
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;


public class reservation_file {
    
    protected File f = new File("reservations.txt");
    protected static boolean b = false;
    
    public reservation_file(int id, String fname, String lname, LocalDate start, LocalDate end, String rented_name) throws IOException
    {
        Writer output;
        output = new BufferedWriter(new FileWriter(f,true)); 
        // thn prwth fora pou tha kalesw ton konstraktora auton, tha prepei na diagrapsw to periexomeno tou arxeiou
        // gia na ksanagrapsw tis kainouries krathseis
        if (b == false)
        {
            f.delete();
            // ftiaxnw to arxeio
            f = new File("reservations.txt");
            // kai pernaw ta stoixeia ths krathshs sto arxeio
            output = new BufferedWriter(new FileWriter(f,true));
            output.write(id + "," + fname + " " + lname + "," + start + "," + end + "," + rented_name + "\n");
            output.close();
            b = true;
        }
        else
        {
            output.write(id + "," + fname + " " + lname + "," + start + "," + end + "," + rented_name + "\n");
            output.close();
        }
        
    }
}

