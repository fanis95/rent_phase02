//biniakou theofanis icsd13126 , afalwniaths straths icsd13018, omadiki askisi 2h fash

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class hotel extends JFrame{
    protected String name;
    protected String location;
    protected String stars;
    protected double vasiki_timi_dwmatiou;
    protected List<reservation> krathseis = new ArrayList<>();
    protected Collection<rented> enoik = new ArrayList<>();
    protected JPanel panel2 = new JPanel();
    
    
    public hotel(String name, String location, String stars, double vasiki_timi_dwmatiou)
    {
        this.name = name;
        this.location = location;
        this.stars = stars;
        this.vasiki_timi_dwmatiou = vasiki_timi_dwmatiou;
    }
    
    public void priint()
    {
        System.out.println(name+" "+location+" "+stars+" "+vasiki_timi_dwmatiou);
    }
    
    void add_rented()
    {
        rented r; // dhmiourgw ena antikeimeno tupou rented
        
        // vazw sthn sullogh me ta enoikiazomena kapoia koina dwmatia
        r = new simple_room("sr1","3",true,vasiki_timi_dwmatiou);
        enoik.add(r);
        r = new simple_room("sr2","1",true,vasiki_timi_dwmatiou);
        enoik.add(r);
        r = new simple_room("sr3","2",false,vasiki_timi_dwmatiou);
        enoik.add(r);
        
        // vazw sthn sullogh me ta enoikiazomena kapoia poluteles dwmatia
        r = new luxury_room("lr1","2",true,vasiki_timi_dwmatiou,true);
        enoik.add(r);
        r = new luxury_room("lr2","2",true,vasiki_timi_dwmatiou,false);
        enoik.add(r);
        r = new luxury_room("lr3","2",true,vasiki_timi_dwmatiou,true);
        enoik.add(r);
        
        // vazw sthn sullogh me ta enoikiazomena kapoia autokinhta
        r = new car("car1");
        enoik.add(r);
        r = new car("car2");
        enoik.add(r);
        
        // vazw sthn sullogh me ta enoikiazomena kapoies gourounes
        r = new atv("atv1");
        enoik.add(r);
        r = new atv("atv2");
        enoik.add(r);
        
        // vazw sthn sullogh me ta enoikiazomena kapoia scooter
        r = new scooter("scooter1");
        enoik.add(r);
        r = new scooter("scooter2");
        enoik.add(r);
        
        // vazw sthn sullogh me ta enoikiazomena thn aithousa ekdhlwsewn
        r = new lecture_hall("lecture hall 22");
        enoik.add(r);
        
        panel2.removeAll();
        
        setSize(700, 300);
        
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        // dhmiourgia koubiwn pou tha xreiastw gia to geniko menu
        JButton srB,lrB,carB,atvB,scooterB,lecture_hallB;
        
        //arxikopoiw ta koubia dinontas tous onoma kai sintentagmenes pou tha exoun panw sto panel
        srB = new JButton("insert simple room");
        srB.setBounds(20, 20, 280, 30);
        
        lrB = new JButton("insert luxury room");
        lrB.setBounds(360, 20, 280, 30);
        
        carB = new JButton("insert car");
        carB.setBounds(20, 70, 280, 30);
        
        atvB = new JButton("insert atv");
        atvB.setBounds(360, 70, 280, 30);
        
        scooterB = new JButton("insert scooter");
        scooterB.setBounds(20, 120, 280, 30);
        
        lecture_hallB = new JButton("insert lecture hall");
        lecture_hallB.setBounds(360, 120, 280, 30);
        
        
        Container pane = getContentPane();
        
        pane.setLayout(null);
        
        // prosthetw ola ta koubia sto panel gia na emfanistoun sthn othoni
        pane.add(srB);
        pane.add(lrB);
        pane.add(carB);
        pane.add(atvB);
        pane.add(scooterB);
        pane.add(lecture_hallB);
        
        setContentPane(pane);
        
        // otan o xristis pathsei afto to koubi, gia na kanei dhladh eisagwgh enos koinou dwmatiou
        srB.addActionListener((ActionEvent e) -> {
            // krivw to prohgoumeno panel
            setVisible(false);
            // afairw ola ta stoixeia apo to prohgoumeno panel
            pane.removeAll();
            
            JPanel row1, row2, row3, row4, row5;
            JLabel id_label,beds_label,view_label,money_label;
            JTextField srB_id,mB;
            JButton okB;
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            
            // kai prosthetw se kathe grammi afta pou xreiazomai
            
            // sthn 1h grammh, exw ena label kai ena textfield pou o xristis tha vazei ton kwdiko tou dwmatiou
            row1 = new JPanel();
            id_label = new JLabel("Enter new room's id: ", JLabel.RIGHT);
            srB_id = new JTextField(30);
            
            // sthn 2h grammh bazw ena label kai ena jcombolist gia na epileksei o xristis timh gia to posa
            // krevatia exei to dwmatio
            row2 = new JPanel();
            beds_label = new JLabel("Number of beds in room: ", JLabel.RIGHT);
            String[] choises = { "1", "2", "3"};
            JComboBox bedsList = new JComboBox(choises);
            bedsList.setSelectedIndex(0);
            
            // sthn 3h grammh kanw oti kai sthn 2h alla gia to an exei thea to dwmatio
            row3 = new JPanel();
            view_label = new JLabel("Has the room view?: ", JLabel.RIGHT);
            String[] choises2 = { "yes", "no"};
            JComboBox viewList = new JComboBox(choises2);
            viewList.setSelectedIndex(0);
            
            // sthn 4h grammh zhtaw thn vasiki xrewsh
            row5 = new JPanel();
            money_label = new JLabel("Enter room's basic charge: ", JLabel.RIGHT);
            mB= new JTextField(30);
            
            // sthn 4h grammh prosthetw to koubi OK 
            row4 = new JPanel();
            okB = new JButton("OK");
            
            
            GridLayout layout=new GridLayout(5,1);
            panel2.setLayout(layout);
            FlowLayout flowlayout = new FlowLayout();
            
            //parakatw prosthetw oles tis grammes pou dhmiourghsa parapanw sto kainourio panel
            row1.setLayout(flowlayout);
            row1.add(id_label);
            row1.add(srB_id);
            panel2.add(row1);
            
            row2.setLayout(flowlayout);
            row2.add(beds_label);
            row2.add(bedsList);
            panel2.add(row2);
            
            row3.setLayout(flowlayout);
            row3.add(view_label);
            row3.add(viewList);
            panel2.add(row3);
            
            row5.setLayout(flowlayout);
            row5.add(money_label);
            row5.add(mB);
            panel2.add(row5);
            
            row4.setLayout(flowlayout);
            row4.add(okB);
            panel2.add(row4);
            
            setContentPane(panel2);
            pack();
            
            // otan o xrhsths valei tis times kai pathsei ok, tha ginei h eisagwgh tou dwmatiou sthn lista
            // me ta enoikiazomena
            okB.addActionListener((ActionEvent e2) -> {
                setVisible(false);
                // pernw ton kwdiko tou dwmatiou apo to jtextfield pou shmblhrwse o xrhsths
                String r_id = srB_id.getText();
                // pernw ton arithmo twn krevatiwn apo to jcombobox
                String beds = (String)bedsList.getSelectedItem();
                // an exei thea to dwmatio apo to jcombobox
                boolean view;
                String views = (String)viewList.getSelectedItem();
                view = views.equals("yes");
                // pernw thn vasiki timi apo to jtextfield pou shmblhrwse o xrhsths
                double b_c = Double.parseDouble(mB.getText());
                rented r1 = new simple_room(r_id,beds,view,b_c); // dimiourgw to koino dwmatio
                enoik.add(r1);
                // emfanizw mhnuma oti o xrhsths ekane epitixws thn eisagwgh
                JFrame frame = new JFrame("insert");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JOptionPane.showMessageDialog(frame, "You inserted successfully a simple room");
                frame.pack();
                frame.setVisible(true);
                setVisible(false);
                
                frame.setVisible(false);
            });
        });
        
        // h logikh se kathe koubi einai akrivws h idia me to parapanw
        
        lrB.addActionListener((ActionEvent e) -> {
            setVisible(false);
            
            pane.removeAll();
            
            
            JPanel row1, row3, row4, row2;
            JLabel id_label,hydromassage_label,money_label;
            JTextField srB_id,mB;
            JButton okB;
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            
            row1 = new JPanel();
            id_label = new JLabel("Enter new room's id: ", JLabel.RIGHT);
            srB_id = new JTextField(30);
            
            row3 = new JPanel();
            hydromassage_label = new JLabel("Has the room hydromassage? ", JLabel.RIGHT);
            String[] choises2 = { "yes", "no"};
            JComboBox viewList = new JComboBox(choises2);
            viewList.setSelectedIndex(0);
            
            row2 = new JPanel();
            money_label = new JLabel("Enter room's basic charge: ", JLabel.RIGHT);
            mB= new JTextField(30);
            
            row4 = new JPanel();
            okB = new JButton("OK");
            
            GridLayout layout=new GridLayout(4,1);
            panel2.setLayout(layout);
            FlowLayout flowlayout = new FlowLayout();
            
            
            row1.setLayout(flowlayout);
            row1.add(id_label);
            row1.add(srB_id);
            panel2.add(row1);
            
            row2.setLayout(flowlayout);
            row2.add(money_label);
            row2.add(mB);
            panel2.add(row2);
            
            row3.setLayout(flowlayout);
            row3.add(hydromassage_label);
            row3.add(viewList);
            panel2.add(row3);
            
            row4.setLayout(flowlayout);
            row4.add(okB);
            panel2.add(row4);
            
            setContentPane(panel2);
            pack();
            
            okB.addActionListener((ActionEvent e2) -> {
                setVisible(false);
                
                String r_id = srB_id.getText();
                
                boolean hydro;
                String viewS = (String)viewList.getSelectedItem();
                hydro = viewS.equals("yes");
                double b_c = Double.parseDouble(mB.getText());
                rented r1 = new luxury_room(r_id,"2",true,b_c,hydro); // dimiourgw to poluteles dwmatio
                enoik.add(r1);
                
                JFrame frame = new JFrame("insert");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JOptionPane.showMessageDialog(frame, "You inserted successfully a luxury room");
                frame.pack();
                frame.setVisible(true);
                setVisible(false);
                
                frame.setVisible(false);
            });
        });
        
        atvB.addActionListener((ActionEvent e) -> {
            setVisible(false);
            
            pane.removeAll();
            
            JPanel row1, row4;
            JLabel number_label;
            JTextField atvB_n;
            JButton okB;
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            row1 = new JPanel();
            number_label = new JLabel("Enter new atv's number: ", JLabel.RIGHT);
            atvB_n = new JTextField(30);
            
            row4 = new JPanel();
            okB = new JButton("OK");
            
            GridLayout layout=new GridLayout(4,1);
            pane.setLayout(layout);
            FlowLayout flowlayout = new FlowLayout();
            
            
            row1.setLayout(flowlayout);
            row1.add(number_label);
            row1.add(atvB_n);
            panel2.add(row1);
            
            row4.setLayout(flowlayout);
            row4.add(okB);
            panel2.add(row4);
            
            setContentPane(panel2);
            pack();
            
            okB.addActionListener((ActionEvent e2) -> {
                setVisible(false);
                
                String a_n = atvB_n.getText();
                
                rented r1 = new atv(a_n); // dimiourgw thn gourouna
                enoik.add(r1);
                
                JFrame frame = new JFrame("insert");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JOptionPane.showMessageDialog(frame, "You inserted successfully an atv");
                frame.pack();
                frame.setVisible(true);
                setVisible(false);
                
                frame.setVisible(false);
            });
        });
        
        carB.addActionListener((ActionEvent e) -> {
            setVisible(false);
            
            pane.removeAll();
            
            JPanel row1, row4;
            JLabel number_label;
            JTextField carB_n;
            JButton okB;
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            row1 = new JPanel();
            number_label = new JLabel("Enter new car's number: ", JLabel.RIGHT);
            carB_n = new JTextField(30);
            
            row4 = new JPanel();
            okB = new JButton("OK");
            
            GridLayout layout=new GridLayout(4,1);
            pane.setLayout(layout);
            FlowLayout flowlayout = new FlowLayout();
           
            
            row1.setLayout(flowlayout);
            row1.add(number_label);
            row1.add(carB_n);
            panel2.add(row1);
            
            row4.setLayout(flowlayout);
            row4.add(okB);
            panel2.add(row4);
            
            setContentPane(panel2);
            pack();
            
            okB.addActionListener((ActionEvent e2) -> {
                setVisible(false);
                
                String c_n = carB_n.getText();
                
                rented r1 = new car(c_n); // dimiourgw to autokinhto
                enoik.add(r1);
                
                JFrame frame = new JFrame("insert");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JOptionPane.showMessageDialog(frame, "You inserted successfully a car");
                frame.pack();
                frame.setVisible(true);
                setVisible(false);
                
                frame.setVisible(false);
            });
        });
        
        scooterB.addActionListener((ActionEvent e) -> {
            setVisible(false);
            
            pane.removeAll();
            
            JPanel row1, row4;
            JLabel number_label;
            JTextField sB_n;
            JButton okB;
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            row1 = new JPanel();
            number_label = new JLabel("Enter new scooter's number: ", JLabel.RIGHT);
            sB_n = new JTextField(30);
            
            row4 = new JPanel();
            okB = new JButton("OK");
            
            GridLayout layout=new GridLayout(4,1);
            pane.setLayout(layout);
            FlowLayout flowlayout = new FlowLayout();
            
            
            row1.setLayout(flowlayout);
            row1.add(number_label);
            row1.add(sB_n);
            panel2.add(row1);
            
            row4.setLayout(flowlayout);
            row4.add(okB);
            panel2.add(row4);
            
            setContentPane(panel2);
            pack();
            
            okB.addActionListener((ActionEvent e2) -> {
                setVisible(false);
                
                String s_n = sB_n.getText();
                
                rented r1 = new scooter(s_n); // dimiourgw to scooter
                enoik.add(r1);
                
                JFrame frame = new JFrame("insert");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JOptionPane.showMessageDialog(frame, "You inserted successfully a scooter");
                frame.pack();
                frame.setVisible(true);
                setVisible(false);
                
                frame.setVisible(false);
            });
        });
        
        lecture_hallB.addActionListener((ActionEvent e) -> {
            setVisible(false);
            
            pane.removeAll();
            
            JPanel row1, row4;
            JLabel number_label;
            JTextField lhB_n;
            JButton okB;
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            row1 = new JPanel();
            number_label = new JLabel("Enter new lecture hall's number: ", JLabel.RIGHT);
            lhB_n = new JTextField(30);
            
            row4 = new JPanel();
            okB = new JButton("OK");
            
            GridLayout layout=new GridLayout(4,1);
            pane.setLayout(layout);
            FlowLayout flowlayout = new FlowLayout();
            
            row1.setLayout(flowlayout);
            row1.add(number_label);
            row1.add(lhB_n);
            panel2.add(row1);
            
            row4.setLayout(flowlayout);
            row4.add(okB);
            panel2.add(row4);
            
            setContentPane(panel2);
            pack();
            
            okB.addActionListener((ActionEvent e2) -> {
                setVisible(false);
                
                String lh = lhB_n.getText();
                
                rented r1 = new lecture_hall(lh); // dimiourgw to scooter
                enoik.add(r1);
                
                JFrame frame = new JFrame("insert");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JOptionPane.showMessageDialog(frame, "You inserted successfully a lecture hall");
                frame.pack();
                frame.setVisible(true);
                setVisible(false);
                
                frame.setVisible(false);
            });
        });
    }
    
    void delete_rented() // h katarghsh enos enoikiazomenou
    {
        List<rented> pros_diagrafh = new ArrayList<>(); // se auth thn lista tha vazw ta enoikiazomena pros diagrafh
                                                            // apo to collection
        
        enoik.stream().filter((r) -> (r instanceof room)).forEach((rented r) -> {
            room m = (room) r;
            if (m.get_id().equals("sr2")) {
                pros_diagrafh.add(m);
            }
        });
        
        enoik.stream().filter((r) -> (r instanceof vehicle)).forEach((rented r) -> {
            vehicle v = (vehicle) r;
            if (v.get_n().equals("atv1")) {
                pros_diagrafh.add(v);
            }
        });
        
        enoik.removeAll(pros_diagrafh); // afairw apo thn collection me ta enoikiazomena, ta enoikiazomena pou thelei o 
                                            // xrhsths na diagrapsei
        
        System.out.println("\n\nmeta thn diagrafh: ");
        System.out.println("\nENOIKIAZOMENA: ");
        enoik.parallelStream()
        .forEach(e -> e.print());
        
        
        panel2.removeAll();
        
        setSize(650, 300);
        
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        JButton roomB,vehicleB,lec_hallB;
        
        roomB = new JButton("delete room");
        roomB.setBounds(20, 20, 280, 30);
        
        vehicleB = new JButton("delete vehicle");
        vehicleB.setBounds(20, 70, 280, 30);
        
        lec_hallB = new JButton("delete lecture hall");
        lec_hallB.setBounds(20, 120, 280, 30);
        
        
        
        Container pane = getContentPane();
        
        pane.setLayout(null);
        
        pane.add(roomB);
        pane.add(vehicleB);
        pane.add(lec_hallB);
        
        setContentPane(pane);
        
        
         roomB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                pane.removeAll();
                JPanel row1, row4 = null;
                JLabel rooms;
                JButton okB;
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
                // ftiaxnw enan pinaka me ola ta onomata twn dwmatiwn
                String[] allRooms = null;
                int k=0;
                // diasxizw olh thn lista me ta enoikiazomena kai pernw ta onomata twn dwmatiwn
                for(rented rt:enoik){
                    if (rt instanceof room)
                    {
                        room m;
                        m = (room) rt;
                        allRooms[k] = m.get_id();
                        k++;
                    }
                }  
                // prosthetw ena JComboBox me ola ta onomata twn dwmatiwn gia na epileksei o xrhsths
                row1 = new JPanel();
                rooms = new JLabel("choose room for delete: ", JLabel.RIGHT);
                JComboBox roomList = new JComboBox(allRooms);
                roomList.setSelectedIndex(0);
                
                okB = new JButton("OK");
                GridLayout layout=new GridLayout(4,1);
                panel2.setLayout(layout);
                FlowLayout flowlayout = new FlowLayout();
                
                row1.setLayout(flowlayout);
                row1.add(rooms);
                row1.add(roomList);
                panel2.add(row1);
                
                row4.setLayout(flowlayout);
                row4.add(okB);
                panel2.add(row4);
                
                setContentPane(panel2);
                pack();
                okB.addActionListener((ActionEvent e2) -> {
                    setVisible(false);
                    // o kwdikos tou dwmatiou gia diagrafh
                    String room_name = (String)roomList.getSelectedItem();
                    
                    enoik.stream().filter((r) -> (r instanceof room)).forEach((r) -> {
                        room m = (room) r;
                        if (m.get_id().equals(room_name))
                        {
                            pros_diagrafh.add(m);
                        }
                    });
                    
                    
                    setVisible(false);
                });
            }
        });
         
        // diagrafh oxhmatos
        vehicleB.addActionListener((ActionEvent e) -> {
            setVisible(false);
            
            pane.removeAll();
            
            JPanel row1, row4 = null;
            JLabel vehicles;
            JButton okB;
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            
            // ftiaxnw enan pinaka me ola ta onomata twn oxhmatwn
            String allVehicles[] = null;
            int k=0;
            // diasxizw olh thn lista me ta enoikiazomena kai pernw tous kwdikous twn oxhmatwn
            for(rented rt:enoik){
                if (rt instanceof vehicle)
                {
                    vehicle m;
                    m = (vehicle) rt;
                    allVehicles[k] = m.get_n();
                    k++;
                }
            }
            
            
            row1 = new JPanel();
            vehicles = new JLabel("choose vehicle for delete: ", JLabel.RIGHT);
            JComboBox vehiclesList = new JComboBox(allVehicles);
            vehiclesList.setSelectedIndex(0);
            
            okB = new JButton("OK");
            
            GridLayout layout=new GridLayout(4,1);
            panel2.setLayout(layout);
            FlowLayout flowlayout = new FlowLayout();
            
            row1.setLayout(flowlayout);
            row1.add(vehicles);
            row1.add(vehiclesList);
            panel2.add(row1);
            
            row4.setLayout(flowlayout);
            row4.add(okB);
            panel2.add(row4);
            
            setContentPane(panel2);
            pack();
            
            okB.addActionListener((ActionEvent e2) -> {
                setVisible(false);
            // o kwdikos tou oxhmatos gia diagrafh   
            String v_name = (String)vehiclesList.getSelectedItem();
                
            enoik.stream().filter((r) -> (r instanceof vehicle)).forEach((rented r) -> {
                            vehicle m = (vehicle) r;
                            if (m.get_n().equals(v_name))
                            {
                                pros_diagrafh.add(m);
                            }
                        });
                
                
                setVisible(false);
            });
        });
        
        // diagrafh aithousas ekdhlwsewn
        vehicleB.addActionListener((ActionEvent e) -> {
            setVisible(false);
            
            pane.removeAll();
            
            JPanel row1, row4 = null;
            JLabel lechalls;
            JButton okB;
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            
            // ftiaxnw enan pinaka me ola ta onomata twn aithouswn 
            String[] allLechall = null;
            int k=0;
            // diasxizw olh thn lista me ta enoikiazomena kai pernw tous kwdikous twn aithouswn
            for(rented rt:enoik){
                if (rt instanceof lecture_hall)
                {
                    lecture_hall m;
                    m = (lecture_hall) rt;
                    allLechall[k] = m.get_n();
                    k++;
                }
            }
            
            
            row1 = new JPanel();
            lechalls = new JLabel("choose lecture_hall for delete: ", JLabel.RIGHT);
            JComboBox lechallsList = new JComboBox(allLechall);
            lechallsList.setSelectedIndex(0);
            
            okB = new JButton("OK");
            
            GridLayout layout=new GridLayout(4,1);
            panel2.setLayout(layout);
            FlowLayout flowlayout = new FlowLayout();
            
            row1.setLayout(flowlayout);
            row1.add(lechalls);
            row1.add(lechallsList);
            panel2.add(row1);
            
            row4.setLayout(flowlayout);
            row4.add(okB);
            panel2.add(row4);
            
            setContentPane(panel2);
            pack();
            
            okB.addActionListener((ActionEvent e2) -> {
                setVisible(false);
            // o kwdikos tou oxhmatos gia diagrafh   
            String lh_name = (String)lechallsList.getSelectedItem();
                
            enoik.stream().filter((r) -> (r instanceof lecture_hall)).forEach((rented r) -> {
                            lecture_hall m = (lecture_hall) r;
                            if (m.get_n().equals(lh_name))
                            {
                                pros_diagrafh.add(m);
                            }
                        });
                
                
                setVisible(false);
            });
        });
            
                enoik.removeAll(pros_diagrafh); // afairw apo to collection to enoikiazomeno pou thelei na afairesei o xrhsths
            
            
        
        System.out.println("\nENOIKIAZOMENA: ");
        enoik.parallelStream()
        .forEach(e -> e.print());
       
    }
    
    void add_reservation() throws IOException   // dhmiourgeia krathshs
    {
        
        List<rented> enoikiazomena = new ArrayList<>();
        
           panel2.removeAll();
        
        setSize(700, 300);
        
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        // dhmiourgia koubiwn pou tha xreiastw gia to geniko menu
        JButton srB,lrB,carB,atvB,scooterB,lecture_hallB;
        
        //arxikopoiw ta koubia dinontas tous onoma kai sintentagmenes pou tha exoun panw sto panel
        srB = new JButton("reserve simple room");
        srB.setBounds(20, 20, 280, 30);
        
        lrB = new JButton("reserve luxury room");
        lrB.setBounds(360, 20, 280, 30);
        
        carB = new JButton("reserve car");
        carB.setBounds(20, 70, 280, 30);
        
        atvB = new JButton("reserve atv");
        atvB.setBounds(360, 70, 280, 30);
        
        scooterB = new JButton("reserve scooter");
        scooterB.setBounds(20, 120, 280, 30);
        
        lecture_hallB = new JButton("reserve lecture hall");
        lecture_hallB.setBounds(360, 120, 280, 30);
        
        
        Container pane = getContentPane();
        
        pane.setLayout(null);
        
        // prosthetw ola ta koubia sto panel gia na emfanistoun sthn othoni
        pane.add(srB);
        pane.add(lrB);
        pane.add(carB);
        pane.add(atvB);
        pane.add(scooterB);
        pane.add(lecture_hallB);
        
        setContentPane(pane);
        
        srB.addActionListener((ActionEvent e) -> {
            // krivw to prohgoumeno panel
            setVisible(false);
            // afairw ola ta stoixeia apo to prohgoumeno panel
            pane.removeAll();
            
            JPanel row1,row4;
            JLabel id_label;
            JTextField srB_id;
            JButton okB;
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            
            // kai prosthetw se kathe grammi afta pou xreiazomai
            
            // sthn 1h grammh, exw ena label kai ena textfield pou o xristis tha vazei ton kwdiko tou dwmatiou
            row1 = new JPanel();
            id_label = new JLabel("Enter simple room's id: ", JLabel.RIGHT);
            srB_id = new JTextField(30);
            
           
            // sthn 4h grammh prosthetw to koubi OK 
            row4 = new JPanel();
            okB = new JButton("OK");
            
            
            GridLayout layout=new GridLayout(5,1);
            panel2.setLayout(layout);
            FlowLayout flowlayout = new FlowLayout();
            
            //parakatw prosthetw oles tis grammes pou dhmiourghsa parapanw sto kainourio panel
            row1.setLayout(flowlayout);
            row1.add(id_label);
            row1.add(srB_id);
            panel2.add(row1);
            
           
            row4.setLayout(flowlayout);
            row4.add(okB);
            panel2.add(row4);
            
            setContentPane(panel2);
            pack();
            
            enoik.stream().filter((e1) -> (e1 instanceof simple_room) // an to antikeimeno einai tupou simple_room
                    ).forEachOrdered((e1) -> {
                        simple_room s = (simple_room) e1; // ftiaxnw antikeimeno kai to kanw cast ston tupo klashs pou
                        // xreiazomai
                        
                        if (s.get_id().equals(srB_id.getText())) {    // edw psaxnw na dw an einai to antikeimeno pou edwse o xristis
                            
                            enoikiazomena.add(e1);// kai an einai to enoikiazomeno pou psaxnei o xristis
                            // to krataw gia xrhsh parakatw
                        } else {
                        }
                    }); // psaxnw sthn lista me ta enoikiazomena
            
            
            okB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e2) {
                    setVisible(false);
                }
            });
        });
        
        lrB.addActionListener((ActionEvent e) -> {
            // krivw to prohgoumeno panel
            setVisible(false);
            // afairw ola ta stoixeia apo to prohgoumeno panel
            pane.removeAll();
            
            JPanel row1,row4;
            JLabel id_label;
            JTextField srB_id;
            JButton okB;
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            
            // kai prosthetw se kathe grammi afta pou xreiazomai
            
            // sthn 1h grammh, exw ena label kai ena textfield pou o xristis tha vazei ton kwdiko tou dwmatiou
            row1 = new JPanel();
            id_label = new JLabel("Enter luxury room's id: ", JLabel.RIGHT);
            srB_id = new JTextField(30);
            
           
            // sthn 4h grammh prosthetw to koubi OK 
            row4 = new JPanel();
            okB = new JButton("OK");
            
            
            GridLayout layout=new GridLayout(5,1);
            panel2.setLayout(layout);
            FlowLayout flowlayout = new FlowLayout();
            
            //parakatw prosthetw oles tis grammes pou dhmiourghsa parapanw sto kainourio panel
            row1.setLayout(flowlayout);
            row1.add(id_label);
            row1.add(srB_id);
            panel2.add(row1);
            
           
            row4.setLayout(flowlayout);
            row4.add(okB);
            panel2.add(row4);
            
            setContentPane(panel2);
            pack();
            
            enoik.stream().filter((e1) -> (e1 instanceof luxury_room) // an to antikeimeno einai tupou simple_room
                    ).forEachOrdered((e1) -> {
                        luxury_room s = (luxury_room) e1; // ftiaxnw antikeimeno kai to kanw cast ston tupo klashs pou
                        // xreiazomai
                        
                        if (s.get_id().equals(srB_id.getText())) {    // edw psaxnw na dw an einai to antikeimeno pou edwse o xristis
                            
                            enoikiazomena.add(e1);// kai an einai to enoikiazomeno pou psaxnei o xristis
                            // to krataw gia xrhsh parakatw
                        } else {
                        }
                    }); // psaxnw sthn lista me ta enoikiazomena
            
            
            okB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e2) {
                    setVisible(false);
                }
            });
        });
        
        
        
        carB.addActionListener((ActionEvent e) -> {
            // krivw to prohgoumeno panel
            setVisible(false);
            // afairw ola ta stoixeia apo to prohgoumeno panel
            pane.removeAll();
            
            JPanel row1, row4;
            JLabel id_label;
            JTextField v_id;
            JButton okB;
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            
            // kai prosthetw se kathe grammi afta pou xreiazomai
            
            // sthn 1h grammh, exw ena label kai ena textfield pou o xristis tha vazei ton kwdiko tou dwmatiou
            row1 = new JPanel();
            id_label = new JLabel("Enter car's id: ", JLabel.RIGHT);
            v_id = new JTextField(30);
            
            
            // sthn 4h grammh prosthetw to koubi OK 
            row4 = new JPanel();
            okB = new JButton("OK");
            
            
            GridLayout layout=new GridLayout(5,1);
            panel2.setLayout(layout);
            FlowLayout flowlayout = new FlowLayout();
            
            //parakatw prosthetw oles tis grammes pou dhmiourghsa parapanw sto kainourio panel
            row1.setLayout(flowlayout);
            row1.add(id_label);
            row1.add(v_id);
            panel2.add(row1);
            
            row4.setLayout(flowlayout);
            row4.add(okB);
            panel2.add(row4);
            
            setContentPane(panel2);
            pack();
            
            enoik.stream().filter((e1) -> (e1 instanceof car) // an to antikeimeno einai tupou simple_room
                    ).forEachOrdered((e1) -> {
                        car s = (car) e1; // ftiaxnw antikeimeno kai to kanw cast ston tupo klashs pou
                        // xreiazomai
                        
                        if (s.get_n().equals(v_id.getText())) {    // edw psaxnw na dw an einai to antikeimeno pou edwse o xristis
                            
                            enoikiazomena.add(e1);// kai an einai to enoikiazomeno pou psaxnei o xristis
                            // to krataw gia xrhsh parakatw
                        } else {
                        }
                    }); // psaxnw sthn lista me ta enoikiazomena
            
            okB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e2) {
                    setVisible(false);
                   
                }
            });
        });
        
        atvB.addActionListener((ActionEvent e) -> {
            // krivw to prohgoumeno panel
            setVisible(false);
            // afairw ola ta stoixeia apo to prohgoumeno panel
            pane.removeAll();
            
            JPanel row1, row4;
            JLabel id_label;
            JTextField v_id;
            JButton okB;
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            
            // kai prosthetw se kathe grammi afta pou xreiazomai
            
            // sthn 1h grammh, exw ena label kai ena textfield pou o xristis tha vazei ton kwdiko tou dwmatiou
            row1 = new JPanel();
            id_label = new JLabel("Enter atv's id: ", JLabel.RIGHT);
            v_id = new JTextField(30);
            
            
            // sthn 4h grammh prosthetw to koubi OK 
            row4 = new JPanel();
            okB = new JButton("OK");
            
            
            GridLayout layout=new GridLayout(5,1);
            panel2.setLayout(layout);
            FlowLayout flowlayout = new FlowLayout();
            
            //parakatw prosthetw oles tis grammes pou dhmiourghsa parapanw sto kainourio panel
            row1.setLayout(flowlayout);
            row1.add(id_label);
            row1.add(v_id);
            panel2.add(row1);
            
            row4.setLayout(flowlayout);
            row4.add(okB);
            panel2.add(row4);
            
            setContentPane(panel2);
            pack();
            
            enoik.stream().filter((e1) -> (e1 instanceof atv) // an to antikeimeno einai tupou simple_room
                    ).forEachOrdered((e1) -> {
                        atv s = (atv) e1; // ftiaxnw antikeimeno kai to kanw cast ston tupo klashs pou
                        // xreiazomai
                        
                        if (s.get_n().equals(v_id.getText())) {    // edw psaxnw na dw an einai to antikeimeno pou edwse o xristis
                            
                            enoikiazomena.add(e1);// kai an einai to enoikiazomeno pou psaxnei o xristis
                            // to krataw gia xrhsh parakatw
                        } else {
                        }
                    }); // psaxnw sthn lista me ta enoikiazomena
            
            okB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e2) {
                    setVisible(false);
                   
                }
            });
        });
        
        scooterB.addActionListener((ActionEvent e) -> {
            // krivw to prohgoumeno panel
            setVisible(false);
            // afairw ola ta stoixeia apo to prohgoumeno panel
            pane.removeAll();
            
            JPanel row1, row4;
            JLabel id_label;
            JTextField v_id;
            JButton okB;
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            
            // kai prosthetw se kathe grammi afta pou xreiazomai
            
            // sthn 1h grammh, exw ena label kai ena textfield pou o xristis tha vazei ton kwdiko tou dwmatiou
            row1 = new JPanel();
            id_label = new JLabel("Enter scooter's id: ", JLabel.RIGHT);
            v_id = new JTextField(30);
            
            
            // sthn 4h grammh prosthetw to koubi OK 
            row4 = new JPanel();
            okB = new JButton("OK");
            
            
            GridLayout layout=new GridLayout(5,1);
            panel2.setLayout(layout);
            FlowLayout flowlayout = new FlowLayout();
            
            //parakatw prosthetw oles tis grammes pou dhmiourghsa parapanw sto kainourio panel
            row1.setLayout(flowlayout);
            row1.add(id_label);
            row1.add(v_id);
            panel2.add(row1);
            
            row4.setLayout(flowlayout);
            row4.add(okB);
            panel2.add(row4);
            
            setContentPane(panel2);
            pack();
            
            enoik.stream().filter((e1) -> (e1 instanceof scooter) // an to antikeimeno einai tupou simple_room
                    ).forEachOrdered((e1) -> {
                        scooter s = (scooter) e1; // ftiaxnw antikeimeno kai to kanw cast ston tupo klashs pou
                        // xreiazomai
                        
                        if (s.get_n().equals(v_id.getText())) {    // edw psaxnw na dw an einai to antikeimeno pou edwse o xristis
                            
                            enoikiazomena.add(e1);// kai an einai to enoikiazomeno pou psaxnei o xristis
                            // to krataw gia xrhsh parakatw
                        } else {
                        }
                    }); // psaxnw sthn lista me ta enoikiazomena
            
            okB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e2) {
                    setVisible(false);
                   
                }
            });
        });
        
        lecture_hallB.addActionListener((ActionEvent e) -> {
            // krivw to prohgoumeno panel
            setVisible(false);
            // afairw ola ta stoixeia apo to prohgoumeno panel
            pane.removeAll();
            
            JPanel row1, row4;
            JLabel id_label;
            JTextField l_id;
            JButton okB;
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            
            // kai prosthetw se kathe grammi afta pou xreiazomai
            
            // sthn 1h grammh, exw ena label kai ena textfield pou o xristis tha vazei ton kwdiko tou dwmatiou
            row1 = new JPanel();
            id_label = new JLabel("Enter lecture's hall id: ", JLabel.RIGHT);
            l_id = new JTextField(30);
            
            
            // sthn 4h grammh prosthetw to koubi OK 
            row4 = new JPanel();
            okB = new JButton("OK");
            
            
            GridLayout layout=new GridLayout(2,1);
            panel2.setLayout(layout);
            FlowLayout flowlayout = new FlowLayout();
            
            //parakatw prosthetw oles tis grammes pou dhmiourghsa parapanw sto kainourio panel
            row1.setLayout(flowlayout);
            row1.add(id_label);
            row1.add(l_id);
            panel2.add(row1);
            
            row4.setLayout(flowlayout);
            row4.add(okB);
            panel2.add(row4);
            
            setContentPane(panel2);
            pack();
            
            enoik.stream().filter((e1) -> (e1 instanceof lecture_hall) // an to antikeimeno einai tupou simple_room
                    ).forEachOrdered((e1) -> {
                        lecture_hall s = (lecture_hall) e1; // ftiaxnw antikeimeno kai to kanw cast ston tupo klashs pou
                        // xreiazomai
                        
                        if (s.get_n().equals(l_id.getText())) {    // edw psaxnw na dw an einai to antikeimeno pou edwse o xristis
                            
                            enoikiazomena.add(e1);// kai an einai to enoikiazomeno pou psaxnei o xristis
                            // to krataw gia xrhsh parakatw
                            
                        } else {
                        }
                    }); // psaxnw sthn lista me ta enoikiazomena
            
            okB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e2) {
                    setVisible(false);
                }
            });
        });
        
        setVisible(false);
        //afairw ola ta stoixeia apo to prohgoumeno panel
        panel2.removeAll();
        
            JPanel panel3 = new JPanel();
            setSize(900, 500);
        
            setLocationRelativeTo(null);
        
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            
            JPanel row1, row2, row3, row4, row5, row6, row7, row8, row9;
            JLabel label1,label2,lyear1,lmonth1,lday1,lyear2,lmonth2,lday2;
            JTextField tyear1,tmonth1,tday1,tyear2,tmonth2,tday2;
            JButton okB;
            
            row1 = new JPanel();
            label1 = new JLabel("FROM ->", JLabel.RIGHT);
            
            row2 = new JPanel();
            lyear1 = new JLabel("year: ", JLabel.RIGHT);
            tyear1 = new JTextField(5);
            
            row3 = new JPanel();
            lmonth1 = new JLabel("month: ", JLabel.RIGHT);
            tmonth1 = new JTextField(5);
            
            row4 = new JPanel();
            lday1 = new JLabel("day: ", JLabel.RIGHT);
            tday1 = new JTextField(5);
            
            row5 = new JPanel();
            label2 = new JLabel("UNTIL ->", JLabel.RIGHT);
            
            row6 = new JPanel();
            lyear2 = new JLabel("year: ", JLabel.RIGHT);
            tyear2 = new JTextField(5);
            
            row7 = new JPanel();
            lmonth2 = new JLabel("month: ", JLabel.RIGHT);
            tmonth2 = new JTextField(5);
            
            row8 = new JPanel();
            lday2 = new JLabel("day: ", JLabel.RIGHT);
            tday2 = new JTextField(5);
            
            row9 = new JPanel();
            okB = new JButton("check");
            
            
            
            GridLayout layout=new GridLayout(8,1);
            panel3.setLayout(layout);
            FlowLayout flowlayout = new FlowLayout();
            
            row1.setLayout(flowlayout);
            row1.add(label1);
            panel3.add(row1);
            
            row2.setLayout(flowlayout);
            row2.add(lyear1);
            row2.add(tyear1);
            panel3.add(row2);
            
            row3.setLayout(flowlayout);
            row3.add(lmonth1);
            row3.add(tmonth1);
            panel3.add(row3);
            
            row4.setLayout(flowlayout);
            row4.add(lday1);
            row4.add(tday1);
            panel3.add(row4);
            
            row5.setLayout(flowlayout);
            row5.add(label2);
            panel3.add(row5);
            
            row6.setLayout(flowlayout);
            row6.add(lyear2);
            row6.add(tyear2);
            panel3.add(row6);
            
            row7.setLayout(flowlayout);
            row7.add(lmonth2);
            row7.add(tmonth2);
            panel3.add(row7);
            
            row8.setLayout(flowlayout);
            row8.add(lday2);
            row8.add(tday2);
            panel3.add(row8);
            
            row9.setLayout(flowlayout);
            row9.add(okB);
            panel3.add(row9);
            
            
            
            
            setContentPane(panel3);
            pack();
            
            LocalDate start,end;
            
            
            
            int year,month,day;
            
            // edw pernw apo poia hmeromhnia thelei o xristis to enoikiazomeno
            year = Integer.parseInt(tyear1.getText());
            month = Integer.parseInt(tmonth1.getText());
            day = Integer.parseInt(tday1.getText());
            
            start = LocalDate.of(year,month,day);
            
            // kai edw mexri poia hmeromhnia thelei o xristis to enoikiazomeno
            year = Integer.parseInt(tyear1.getText());
            month = Integer.parseInt(tmonth2.getText());
            day = Integer.parseInt(tday2.getText());
            
            
            end = LocalDate.of(year,month,day);
            
            
            // edw elegxw an to enoikiazomeno pou thelei o pelaths einai diathesimo
                // stis hmeromhnies pou edwse parapanw
                
            // h lista pou eftiaxa sthn arxh tha exei MONO 1 antikeimeno epeidh mia fora
            // mono prosthetw antikeimeno
            rented ren;
            ren = enoikiazomena.set(0, enoikiazomena.get(0));
            
            // otan o xrhsths pathsei tis hmeromhnies kai meta to ok tha ginei o elegxos diathesimothtas
            // kai parakatw ton rwtaw an thelei na pragmatopoihsei thn krathsh
            okB.addActionListener((ActionEvent e2) -> {
                setVisible(false);
                int flag_days = 0;
            
            for (LocalDate d = start; !d.isAfter(end); d = d.plusDays(1)) // apo thn hmeromhnia start 
                                                                            // mexri thn hmerominia end
                                                                                // ana mia hmera
            {
                if (ren instanceof room)
                {
                    room rm = (room) ren;
                    if (rm.available(d))
                    {
                        flag_days = 1; // dhladh h hmeromhnia pou endiaferetai o pelaths na enoikiasei to 
                                    //enoikiazomeno ren, einai piasmenh ara den prepei na ginei h krathsh
                        break;
                    }
                }
                else if (ren instanceof vehicle)
                {
                    vehicle v = (vehicle) ren;
                    if (v.available(d))
                    {
                        flag_days = 1; // dhladh h hmeromhnia pou endiaferetai o pelaths na enoikiasei to 
                                    //enoikiazomeno ren, einai piasmenh ara den prepei na ginei h krathsh
                        break;
                    }
                }
                else
                {
                    lecture_hall l = (lecture_hall) ren;
                    if (l.available(d))
                    {
                        flag_days = 1; // dhladh h hmeromhnia pou endiaferetai o pelaths na enoikiasei to 
                                    //enoikiazomeno ren, einai piasmenh ara den prepei na ginei h krathsh
                        break;
                    }
                }
            }
            // an dhladh to enoikiazomeno den einai diathesimo
            if (flag_days == 1)
            {
                setVisible(false);
                
                JFrame frame = new JFrame("!!!");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JOptionPane.showMessageDialog(frame, "the days you entered are already booked!");
                frame.pack();
                frame.setVisible(true);
                setVisible(false);
                    
                frame.setVisible(false);
            }
                
            else // an dhladh to flag_days == 0, tote prepei na ginei h krathsh afou oi hmeromhnies den einai kleistes
            {
                if (ren instanceof room)
                {
                    room rm = (room) ren;
                    for (LocalDate d = start; !d.isAfter(end); d = d.plusDays(1))
                    {
                        rm.add_date(d);
                    }
                
                }
                else if (ren instanceof vehicle)
                {
                    vehicle v = (vehicle) ren;
                    for (LocalDate d = start; !d.isAfter(end); d = d.plusDays(1))
                    {
                        v.add_date(d);
                    }
                
                }
                else
                {
                    lecture_hall l = (lecture_hall) ren;
                    for (LocalDate d = start; !d.isAfter(end); d = d.plusDays(1))
                    {
                        l.add_date(d);
                    }
                
                } 
            } 
                
                });
            
                
                //afairw ola ta stoixeia apo to prohgoumeno panel
            panel3.removeAll();
        
            JPanel panel4 = new JPanel();
            setSize(900, 500);
        
            setLocationRelativeTo(null);
        
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            
            JPanel r1,r2;
            JLabel l;
            JButton yesB,noB;
            
            r1 = new JPanel();
            l = new JLabel("Do you want to make the reservation?", JLabel.RIGHT);
            
            r2 = new JPanel();
            yesB = new JButton("YES");
            noB = new JButton("NO");
            
            // tha ginei h krathsh
            yesB.addActionListener((ActionEvent e2) -> {
                setVisible(false);
                
                panel4.removeAll();
        
                JPanel panel5 = new JPanel();
                setSize(500, 300);
        
                setLocationRelativeTo(null);
        
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
                
                
                JPanel o1,o2;
                JLabel lfname,llname;
                JTextField tfname,tlname;
                
                o1 = new JPanel();
                llname = new JLabel("last name: ", JLabel.RIGHT);
                tlname = new JTextField(30);
                
                o2 = new JPanel();
                lfname = new JLabel("firt name: ", JLabel.RIGHT);
                tfname = new JTextField(30);
                
                GridLayout layout1=new GridLayout(8,1);
                panel5.setLayout(layout1);
                FlowLayout flowlayout1 = new FlowLayout();
                
                o1.setLayout(flowlayout1);
                o1.add(llname);
                o1.add(tlname);
                panel5.add(o1);
                
                o2.setLayout(flowlayout1);
                o2.add(lfname);
                o2.add(tfname);
                panel5.add(o2);
            
                setContentPane(panel5);
                pack();
            
                reservation r = new reservation(tlname.getText(),tfname.getText(),start,end,ren);
                
                // emfanizw thn xrewsh ths krathshs
                setVisible(false);
                
                JFrame frame = new JFrame("charge of reservation");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JOptionPane.showMessageDialog(frame, "h krathsh me arithmo " + r.get_id() + " pragmatopoihthke, me sunoliko "
                            + "kostos: " +r.charge() + "E");
                frame.pack();
                frame.setVisible(true);
                setVisible(false);
                    
                frame.setVisible(false);
                // an to enoikiazomeno einai dwmatio
                if (r.get_rented() instanceof room)
                {
                    // ftiaxnw antikeimeno dwmatio gia na boresw na parw to onoma tou kai na to perasw sto arxeio
                    room m;
                    m = (room) r.get_rented();
                    try {
                        reservation_file rf = new reservation_file(r.get_id(),tfname.getText(),tlname.getText(),start,end,m.get_id());
                    } catch (IOException ex) {
                        Logger.getLogger(hotel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                // antistoixa an einai oxhma
                else if (r.get_rented() instanceof vehicle)
                {
                    vehicle v;
                    v = (vehicle) r.get_rented();
                    try {
                        reservation_file rf = new reservation_file(r.get_id(),tfname.getText(),tlname.getText(),start,end,v.get_n());
                    } catch (IOException ex) {
                        Logger.getLogger(hotel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                // kai telos an einai aithousa ekdhlwsewn
                else if (r.get_rented() instanceof lecture_hall)
                {
                    lecture_hall lh;
                    lh = (lecture_hall) r.get_rented();
                    try {
                        reservation_file rf = new reservation_file(r.get_id(),tfname.getText(),tlname.getText(),start,end,lh.get_n());
                    } catch (IOException ex) {
                        Logger.getLogger(hotel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                });
    }
    
    void search1() // anazhthsh me vash ton kwdiko ths krathshs
    {
            setVisible(false);
            
            panel2.removeAll();
            
            JPanel row1, row4;
            JLabel id_label;
            JTextField res_id;
            JButton searchB;
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            row1 = new JPanel();
            id_label = new JLabel("Enter reservation's id: ", JLabel.RIGHT);
            res_id = new JTextField(10);
            
            row4 = new JPanel();
            searchB = new JButton("search");
            
            GridLayout layout=new GridLayout(4,1);
            panel2.setLayout(layout);
            FlowLayout flowlayout = new FlowLayout();
            
            
            row1.setLayout(flowlayout);
            row1.add(id_label);
            row1.add(res_id);
            panel2.add(row1);
            
            row4.setLayout(flowlayout);
            row4.add(searchB);
            panel2.add(row4);
            
            setContentPane(panel2);
            pack();
            
            searchB.addActionListener((ActionEvent e2) -> {
                setVisible(false);
               
            // o kwdikos krathshs pou evale o xrhsths
            int id = Integer.parseInt(res_id.getText());
            boolean flag=false;
            krathseis.stream().filter((reservation r) -> r.get_id() == id).forEach((r) -> {
                
                JFrame frame = new JFrame("search by id");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JOptionPane.showMessageDialog(frame, r.toStringPrint());
                frame.pack();
                frame.setVisible(true);
                setVisible(false);
                
                frame.setVisible(false);
            });

                
                
            });
        
                    
    }
    
    void search2() // anazhthsh me vash to onoma tou pelath
    {
        setVisible(false);
            
            panel2.removeAll();
            
            JPanel row1, row2, row4;
            JLabel fn_label,ln_label;
            JTextField fn,ln;
            JButton searchB;
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            
            row1 = new JPanel();
            fn_label = new JLabel("Enter customer's first name: ", JLabel.RIGHT);
            fn = new JTextField(20);
            
            row2 = new JPanel();
            ln_label = new JLabel("Enter customer's last name: ", JLabel.RIGHT);
            ln = new JTextField(20);
            
            row4 = new JPanel();
            searchB = new JButton("search");
            
            GridLayout layout=new GridLayout(4,1);
            panel2.setLayout(layout);
            FlowLayout flowlayout = new FlowLayout();
            
            
            row1.setLayout(flowlayout);
            row1.add(fn_label);
            row1.add(fn);
            panel2.add(row1);
            
            row2.setLayout(flowlayout);
            row2.add(ln_label);
            row2.add(ln);
            panel2.add(row2);
            
            row4.setLayout(flowlayout);
            row4.add(searchB);
            panel2.add(row4);
            
            setContentPane(panel2);
            pack();
            
            searchB.addActionListener((ActionEvent e2) -> {
                setVisible(false);
               
            // ta onomata pou shmplhrwse o xrhsths    
            String firstname = fn.getText();
            String lastname = ln.getText();
            
            krathseis.stream().filter((reservation r) ->( (r.get_l_name().equals(lastname)) && 
                    (r.get_f_name().equals(firstname)))).forEach((r) -> {
                
                JFrame frame = new JFrame("search by name");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JOptionPane.showMessageDialog(frame, r.toStringPrint());
                frame.pack();
                frame.setVisible(true);
                setVisible(false);
                
                frame.setVisible(false);
            });

                
                
            });
    }
    
    void search3() // anazhthsh krathsewn pou antistoixoun se mia sugkekrhmenh hmeromhnia
    {
        
        setVisible(false);
        //afairw ola ta stoixeia apo to prohgoumeno panel
        panel2.removeAll();
        
            JPanel panel3 = new JPanel();
            setSize(900, 500);
        
            setLocationRelativeTo(null);
        
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            
            JPanel row1, row2, row3, row4, row9;
            JLabel label1,lyear1,lmonth1,lday1;
            JTextField tyear1,tmonth1,tday1,tyear2,tmonth2,tday2;
            JButton searchB;
            
            row1 = new JPanel();
            label1 = new JLabel("give date", JLabel.RIGHT);
            
            row2 = new JPanel();
            lyear1 = new JLabel("year: ", JLabel.RIGHT);
            tyear1 = new JTextField(5);
            
            row3 = new JPanel();
            lmonth1 = new JLabel("month: ", JLabel.RIGHT);
            tmonth1 = new JTextField(5);
            
            row4 = new JPanel();
            lday1 = new JLabel("day: ", JLabel.RIGHT);
            tday1 = new JTextField(5);
            
            row9 = new JPanel();
            searchB = new JButton("check");
            
            
            
            GridLayout layout=new GridLayout(8,1);
            panel3.setLayout(layout);
            FlowLayout flowlayout = new FlowLayout();
            
            row1.setLayout(flowlayout);
            row1.add(label1);
            panel3.add(row1);
            
            row2.setLayout(flowlayout);
            row2.add(lyear1);
            row2.add(tyear1);
            panel3.add(row2);
            
            row3.setLayout(flowlayout);
            row3.add(lmonth1);
            row3.add(tmonth1);
            panel3.add(row3);
            
            row4.setLayout(flowlayout);
            row4.add(lday1);
            row4.add(tday1);
            panel3.add(row4);
            
            row9.setLayout(flowlayout);
            row9.add(searchB);
            panel3.add(row9);
            
            setContentPane(panel3);
            pack();
            
            
            searchB.addActionListener((ActionEvent e2) -> {
            setVisible(false);
               
            LocalDate date;
            int year,month,day;
            
            // edw pernw thn hmeromhnia pou thelei o xristis na anazhthsei stis krathseis
            year = Integer.parseInt(tyear1.getText());
            month = Integer.parseInt(tmonth1.getText());
            day = Integer.parseInt(tday1.getText());
            
            date = LocalDate.of(year,month,day);
           
            // diasxish ths listas me tis krathseis 
            // vriskw poies krathseis uparxoun mia sigkekrimenh hmeromhnia
            // gia kathe krathsh dhladh, vlepw an h hmeromhnia pou edwse o xristis einai endiamesa apo tis hmeromhnies
                // ths krathshs
             krathseis.stream().filter((r) -> (date.isAfter(r.get_start()) && date.isBefore(r.get_end()))).forEach((r) ->  {
                
                JFrame frame = new JFrame("search by date");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JOptionPane.showMessageDialog(frame, r.toStringPrint());
                frame.pack();
                frame.setVisible(true);
                setVisible(false);
                
                frame.setVisible(false);
            });
   
        });
        
    }
    
    void delete_reservation() // diagrafh krathshs
    {
        setVisible(false);
        //afairw ola ta stoixeia apo to prohgoumeno panel
        panel2.removeAll();
        
            JPanel panel3 = new JPanel();
            setSize(900, 500);
        
            setLocationRelativeTo(null);
        
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            
            JPanel row1, row9;
            JLabel label_id;
            JTextField text_id;
            JButton searchB;
        
            row1 = new JPanel();
            label_id = new JLabel("reservetion's id to delete: ", JLabel.RIGHT);
            text_id = new JTextField(10);
            
            row9 = new JPanel();
            searchB = new JButton("delete");
            
            GridLayout layout=new GridLayout(8,1);
            panel3.setLayout(layout);
            FlowLayout flowlayout = new FlowLayout();
            
            
            row1.setLayout(flowlayout);
            row1.add(label_id);
            row1.add(text_id);
            panel3.add(row1);
            
            row9.setLayout(flowlayout);
            row9.add(searchB);
            panel3.add(row9);
            
            setContentPane(panel3);
            pack();
            
        searchB.addActionListener((ActionEvent e2) -> {
            
            setVisible(false);
            //o kwdikos krathshs pou shmplhrwse o xrhsths
            int id = Integer.parseInt(text_id.getText());
            
            List<reservation> pros_diagrafh = new ArrayList<>(); // se auth thn lista tha vazw ta enoikiazomena pros diagrafh
                                                            // apo to collection
        
        // anazhthsh sthn lista gia thn krathsh me ton kwdiko pou edwse o xristis
        krathseis.stream().filter((r) -> (r.get_id() == id)).forEach((reservation r) -> {
            
            // an vrethei krathsh kai ginei h diagrafh tote tha kanw to flag=true kai tha emfanisw
            // oti egine h diagrafh krathshs
            boolean flag = false;
            // tha afairesw tis hmeromhnies apo tis listes, pou krataw pote ena enoikiazomeno einai kathllhmeno
            if (r.get_rented() instanceof room)
            {
                reservation rs = (reservation) r;
                room rm = (room) rs.get_rented();
                for (LocalDate d = rs.get_start(); !d.isAfter(rs.get_end()); d = d.plusDays(1))
                {
                    rm.remove_date(d);
                    flag = true;
                }

            }
            else if (r.get_rented() instanceof vehicle)
            {
                reservation rs = (reservation) r;
                vehicle v = (vehicle) rs.get_rented();
                for (LocalDate d = rs.get_start(); !d.isAfter(rs.get_end()); d = d.plusDays(1))
                {
                    v.remove_date(d);
                    flag = true;
                }

            }
            else if (r.get_rented() instanceof lecture_hall)
            {
                reservation rs = (reservation) r;
                lecture_hall l = (lecture_hall) rs.get_rented();
                for (LocalDate d = rs.get_start(); !d.isAfter(rs.get_end()); d = d.plusDays(1))
                {
                    l.remove_date(d);
                    flag = true;
                }

            }
            
            if (flag == true)// an exei ginei dhladh diagrafh krathshs
            {
                JFrame frame = new JFrame("delete reservation");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JOptionPane.showMessageDialog(frame, "reservation with id: " + r.get_id() + ", has been deleted");
                frame.pack();
                frame.setVisible(true);
            }
            else // an den exei ginei diagrafh
            {
                JFrame frame = new JFrame("delete reservation");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JOptionPane.showMessageDialog(frame, "there was noreservation with id: " + r.get_id());
                frame.pack();
                frame.setVisible(true);
            }
            pros_diagrafh.add(r);
        }); 
        
        krathseis.removeAll(pros_diagrafh); // afairw apo thn lista me tis krathseis, tis krathseis pou thelei o 
                                            // xrhsths na diagrapsei
            
        });
            
    }
    
    void kathlhmena_dwmatia() // emfanizei ta dwmatia pou einai kathlhmena mia sugkekrimenh mera
    {
        
         setVisible(false);
        //afairw ola ta stoixeia apo to prohgoumeno panel
        panel2.removeAll();
        
            JPanel panel3 = new JPanel();
            setSize(900, 500);
        
            setLocationRelativeTo(null);
        
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            
            JPanel row1, row2, row3, row4, row9;
            JLabel label1,lyear1,lmonth1,lday1;
            JTextField tyear1,tmonth1,tday1,tyear2,tmonth2,tday2;
            JButton searchB;
            
            row1 = new JPanel();
            label1 = new JLabel("give date", JLabel.RIGHT);
            
            row2 = new JPanel();
            lyear1 = new JLabel("year: ", JLabel.RIGHT);
            tyear1 = new JTextField(5);
            
            row3 = new JPanel();
            lmonth1 = new JLabel("month: ", JLabel.RIGHT);
            tmonth1 = new JTextField(5);
            
            row4 = new JPanel();
            lday1 = new JLabel("day: ", JLabel.RIGHT);
            tday1 = new JTextField(5);
            
            row9 = new JPanel();
            searchB = new JButton("check");
            
            
            
            GridLayout layout=new GridLayout(8,1);
            panel3.setLayout(layout);
            FlowLayout flowlayout = new FlowLayout();
            
            row1.setLayout(flowlayout);
            row1.add(label1);
            panel3.add(row1);
            
            row2.setLayout(flowlayout);
            row2.add(lyear1);
            row2.add(tyear1);
            panel3.add(row2);
            
            row3.setLayout(flowlayout);
            row3.add(lmonth1);
            row3.add(tmonth1);
            panel3.add(row3);
            
            row4.setLayout(flowlayout);
            row4.add(lday1);
            row4.add(tday1);
            panel3.add(row4);
            
            row9.setLayout(flowlayout);
            row9.add(searchB);
            panel3.add(row9);
            
            setContentPane(panel3);
            pack();
            
            
            searchB.addActionListener((ActionEvent e2) -> {
            setVisible(false);
               
            LocalDate date;
            int year,month,day;
            
            // edw pernw thn hmeromhnia pou thelei o xristis na anazhthsei stis krathseis
            year = Integer.parseInt(tyear1.getText());
            month = Integer.parseInt(tmonth1.getText());
            day = Integer.parseInt(tday1.getText());
            
            date = LocalDate.of(year,month,day);
           enoik.stream().filter((r) -> (r instanceof rented)).forEach((rented r) -> {
            if (r instanceof room) {
                room d = (room) r;
                if (d.available(date)) // an einai kathllhmeno to dwmatio thn hmeromhnia d, tote h sunarthsh available()
                                    // tha epistrepsei true, kai tha emfanhsei ta stoixeia tou dwmatiou
                                // den uparxei thema mhpws emfanhstei kapoio enoikiazomeno parapanw apo mia fora
                                    // giati oi krathseis einai monadikes
                {    
                    JFrame frame = new JFrame("search rooms");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    JOptionPane.showMessageDialog(frame, d.get_id());
                    frame.pack();
                    frame.setVisible(true);
                    setVisible(false);
                
                    frame.setVisible(false);
                    
                }
            }
        });
           
    });
        
    }
    
    void kathlhmena_dwmatia_ana_kathgoria() // emfanizei kateilhmmena dwmatia ana kathgoria mia sugkekrimenh mera
    {
         // kanw 2 listes gia kathe kathgoria (koino kai poluteles dwmatio) gia na ta ektupwsw ana kathgoria
        ArrayList<simple_room> sr = new ArrayList<>();
        ArrayList<luxury_room> lr = new ArrayList<>();
        
         setVisible(false);
        //afairw ola ta stoixeia apo to prohgoumeno panel
        panel2.removeAll();
        
            JPanel panel3 = new JPanel();
            setSize(900, 500);
        
            setLocationRelativeTo(null);
        
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            
            JPanel row1, row2, row3, row4, row9;
            JLabel label1,lyear1,lmonth1,lday1;
            JTextField tyear1,tmonth1,tday1,tyear2,tmonth2,tday2;
            JButton searchB;
            
            row1 = new JPanel();
            label1 = new JLabel("give date", JLabel.RIGHT);
            
            row2 = new JPanel();
            lyear1 = new JLabel("year: ", JLabel.RIGHT);
            tyear1 = new JTextField(5);
            
            row3 = new JPanel();
            lmonth1 = new JLabel("month: ", JLabel.RIGHT);
            tmonth1 = new JTextField(5);
            
            row4 = new JPanel();
            lday1 = new JLabel("day: ", JLabel.RIGHT);
            tday1 = new JTextField(5);
            
            row9 = new JPanel();
            searchB = new JButton("check");
            
            
            
            GridLayout layout=new GridLayout(8,1);
            panel3.setLayout(layout);
            FlowLayout flowlayout = new FlowLayout();
            
            row1.setLayout(flowlayout);
            row1.add(label1);
            panel3.add(row1);
            
            row2.setLayout(flowlayout);
            row2.add(lyear1);
            row2.add(tyear1);
            panel3.add(row2);
            
            row3.setLayout(flowlayout);
            row3.add(lmonth1);
            row3.add(tmonth1);
            panel3.add(row3);
            
            row4.setLayout(flowlayout);
            row4.add(lday1);
            row4.add(tday1);
            panel3.add(row4);
            
            row9.setLayout(flowlayout);
            row9.add(searchB);
            panel3.add(row9);
            
            setContentPane(panel3);
            pack();
            
            
        searchB.addActionListener((ActionEvent e2) -> {
            setVisible(false);
               
            LocalDate d;
            int year,month,day;
            
            // edw pernw thn hmeromhnia pou thelei o xristis na anazhthsei stis krathseis
            year = Integer.parseInt(tyear1.getText());
            month = Integer.parseInt(tmonth1.getText());
            day = Integer.parseInt(tday1.getText());
            
            d = LocalDate.of(year,month,day);
            
           enoik.stream().filter((r) -> (r instanceof rented)).forEach((rented r) -> {
            if (r instanceof simple_room) {
                simple_room rd = (simple_room) r;
                if (rd.available(d)) // an einai kathllhmeno to dwmatio thn hmeromhnia d, tote h sunarthsh available()
                                    // tha epistrepsei true, kai tha emfanhsei ta stoixeia tou dwmatiou
                    sr.add(rd); // prosthetw to koino dwmatio sthn lista gia emfanish argotera
            }
            else if(r instanceof luxury_room)
            {
                luxury_room rd = (luxury_room) r;
                if (r.available(d)) // an einai kathllhmeno to dwmatio thn hmeromhnia d, tote h sunarthsh available()
                                    // tha epistrepsei true, kai tha emfanhsei ta stoixeia tou dwmatiou
                    lr.add(rd); // prosthetw to poluteles dwmatio sthn lista gia emfanish argotera
            }
        });
        
           
    });
        
        System.out.println("koina dwmatia: ");
        sr.stream().forEach(room::print);
        
        System.out.println("poluteles dwmatia: ");
        lr.stream().forEach(room::print);
        
    }
    
    void income() // upologismos esodwn tou ksenodoxeiou gia enan sugkekrimeno mhna
    {
        
            JPanel panel3 = new JPanel();
            setSize(900, 500);
        
            setLocationRelativeTo(null);
        
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            
            JPanel row1, row9;
            JLabel monthL;
            JTextField monthT;
            JButton searchB;
            
            row1 = new JPanel();
            monthL = new JLabel("month(1-12): ", JLabel.RIGHT);
            monthT = new JTextField(5);
            
            row9 = new JPanel();
            searchB = new JButton("check");
            
            GridLayout layout=new GridLayout(8,1);
            panel3.setLayout(layout);
            FlowLayout flowlayout = new FlowLayout();
            
            row1.setLayout(flowlayout);
            row1.add(monthL);
            row1.add(monthT);
            panel3.add(row1);
            
            row9.setLayout(flowlayout);
            row9.add(searchB);
            panel3.add(row9);
            
            setContentPane(panel3);
            pack();
            
            
    searchB.addActionListener((ActionEvent e2) -> {
            setVisible(false);
            int month = Integer.parseInt(monthT.getText());
            double esoda=0; // ta esoda tou ksenodoxeiou gia ton mhna pou edwse o xristis
            for (reservation r : krathseis) 
            {
                rented rd = r.get_rented(); // kai apo to antikeimeno reservation pernw to enoikiazomeno pou afora thn krathsh
            
             // an h krathsh einai oloklhrh ston mhna pou exei orisei o xrhsths, tote apla epistrefw thn xrewsh
                    // oloklhrhs ths krathshs
                // dhladh h krathsh arxizei kai teleiwnei ton idio mhna
                if (r.get_start().getMonthValue() == month && r.get_end().getMonthValue() == month)
                {
                esoda += r.charge();
                }
                // an omws h krathsh einai spasmenh se dio mhnes, tote vriskw poies meres anhkoun ston mhna pou theloume
                    // kai kalw thn sunarthsh pou upologizei thn xrewsh ana hmera gia to enoikiazomeno pou afora thn krathsh
                else if (r.get_start().getMonthValue() == month || r.get_end().getMonthValue() == month)
                {
                    for (LocalDate d = r.get_start(); !d.isAfter(r.get_end()); d = d.plusDays(1))
                        if (d.getMonthValue() == month)
                            esoda += rd.charge_per_day();
                }
            }
            
            JFrame frame = new JFrame("income ");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JOptionPane.showMessageDialog(frame,"income for " + month + "th month is: " + esoda);
            frame.pack();
            frame.setVisible(true);
            setVisible(false);
                
            frame.setVisible(false);
           
        });
    }
    
}
