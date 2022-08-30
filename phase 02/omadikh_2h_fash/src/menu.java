//biniakou theofanis icsd13126 , afalwniaths straths icsd13018, omadiki askisi 2h fash
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;


public class menu extends JFrame{
    protected JButton insert_ren,delete_ren,add_res;
    protected JButton search1,search2,search3,delete_res,search4,search5,income;
        
    public menu()
    {
        
        super("MENU");
        
        hotel h = new hotel("new hotel","samos","4",150);
        
        setSize(700, 300);
        
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
        
        insert_ren = new JButton("insert rented");
        insert_ren.setBounds(20, 20, 280, 30);
        
        delete_ren = new JButton("delete rented");
        delete_ren.setBounds(360, 20, 280, 30);
        
        add_res = new JButton("add reservation");
        add_res.setBounds(20, 70, 280, 30);
        
        delete_res = new JButton("delete reservasion");
        delete_res.setBounds(360, 70, 280, 30);
        
        search1 = new JButton("find reservation by id");
        search1.setBounds(20, 120, 280, 30);
        
        search2 = new JButton("find reservation by name");
        search2.setBounds(360, 120, 280, 30);
        
        search3 = new JButton("find reservation by date");
        search3.setBounds(20, 170, 280, 30);
        
        search4 = new JButton("booked rooms by date");
        search4.setBounds(360, 170, 280, 30);
        
        search5 = new JButton("booked rooms by type and date");
        search5.setBounds(20, 220, 280, 30);
        
        income = new JButton("income");
        income.setBounds(360, 220, 280, 30);
        
        
        
        Container pane = getContentPane();
        
        pane.setLayout(null);
        
        pane.add(insert_ren);
        pane.add(delete_ren);
        pane.add(add_res);
        pane.add(delete_res);
        pane.add(search1);
        pane.add(search2);
        pane.add(search3);
        pane.add(search4);
        pane.add(search5);
        pane.add(income);
        
        setContentPane(pane);
        
        // prosthetei enoikiazomena
        insert_ren.addActionListener((ActionEvent e) -> {
           // setVisible(false);
            h.add_rented();
        });
        
        // diagrafei enoikiazomena
        delete_ren.addActionListener((ActionEvent e) -> {
            // setVisible(false);
            h.delete_rented();
        });
        
        // prosthetei krathsh
        add_res.addActionListener((ActionEvent e) -> {
            try {
                // setVisible(false);
                h.add_reservation();
            } catch (IOException ex) {
                Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        // afairei krathsh
        delete_res.addActionListener((ActionEvent e) -> {
            // setVisible(false);
            h.delete_reservation();
        });
        
        // anazhthsh me vash ton kwdiko ths krathshs
        search1.addActionListener((ActionEvent e) -> {
            // setVisible(false);
            h.search1();
        });
        
        // anazhthsh me vash to onoma tou pelath
        search2.addActionListener((ActionEvent e) -> {
            // setVisible(false);
            h.search2();
        });
        
        // anazhthsh krathsewn pou antistoixoun se mia sugkekrhmenh hmeromhnia
        search3.addActionListener((ActionEvent e) -> {
            // setVisible(false);
            h.search3();
        });
        
        // emfanizei ta dwmatia pou einai kathlhmena mia sugkekrimenh mera
        search4.addActionListener((ActionEvent e) -> {
            // setVisible(false);
            h.kathlhmena_dwmatia();
        });
        
        // emfanizei kateilhmmena dwmatia ana kathgoria mia sugkekrimenh mera
        search4.addActionListener((ActionEvent e) -> {
            // setVisible(false);
            h.kathlhmena_dwmatia_ana_kathgoria();
        });
        
        // upologismos esodwn tou ksenodoxeiou gia enan sugkekrimeno mhna
        income.addActionListener((ActionEvent e) -> {
            setVisible(false);
            h.income();
        });
    }
        
}
