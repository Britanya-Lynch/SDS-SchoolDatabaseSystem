import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.regex.Pattern;

public class StudRecordsGUI extends JFrame implements ActionListener{

        private JTextField fname;
        private JLabel fnameLabel;
        private JTextField lname;
        private JLabel lnameLabel;
        private JTextField dob;
        private JLabel dobLabel;
        private JLabel genderLabel;
        private JComboBox <String> genderCB;
        private JLabel gradeLabel;
        private JComboBox <String> gradeCB;
        private JLabel extraCLabel;
        private JComboBox <String> extraCCB;
        private JButton Addbtn;
        private JComboBox <String> sortCB;
        private JButton sortbtn;
        private JLabel editLabel;
        private JTextField editField;
        private JButton editbtn;
        private JLabel deleteLabel;
        private JTextField deleteField;
        private JButton deletebtn;
        private JButton exitbtn;
        private JButton savebtn;
        private JButton loadbtn;
        private JLabel IDLabel;
        private JTextField IDField;
        private JLabel dobLabel1;
        private JTextArea sTextArea = new JTextArea();
        private JScrollPane scrollPane;

        int editindex;
        private LinkedList<Student> studentLinkedList = new LinkedList<Student>();
        private HashSet<String> idSet = new HashSet<>();

        public StudRecordsGUI(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setBounds(200,200,1000,700);
            this.setTitle(" Hampton Academy Student Records ");
            this.setLocationRelativeTo(null);
            this.setLayout(null);

            String genderCBItems[] = {" ", "Male", "Female"};
            String gradeCBItems[] = {" ", "7", "8","9","10","11","12"};
            String extraCCBItems[] = {" ", "Netball", "Tennis", "Badminton", "Football","Swimming", "Rugby", "Dancing"};
            String sortCBItems[] = {" ", "First Name","Last Name", "Gender", "Grade", " Extra Curricular"};

            sTextArea.setEditable(false);
            sTextArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
            scrollPane = new JScrollPane(sTextArea);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setBounds(50,50,900,200);

            IDLabel = new JLabel("ID #:");
            IDLabel.setBounds(60,270,130,30);
            IDField = new JTextField();
            IDField.setBounds(190,270,170,30);

            fnameLabel = new JLabel("First Name:");
            fnameLabel.setBounds(60,310,170,30);
            fname = new JTextField();
            fname.setBounds(190,310,170,30);

            lnameLabel = new JLabel("Last Name:");
            lnameLabel.setBounds(60,360,170,30);
            lname = new JTextField();
            lname.setBounds(190,360,170,30);

            dobLabel = new JLabel("D.O.B:");
            dobLabel.setBounds(60,410,100,30);
            dob = new JTextField();
            dob.setBounds(190,410,170,30);

            dobLabel1 = new JLabel("(MM/DD/YYYY)");
            dobLabel1.setBounds(221,440,100,9);

            genderLabel = new JLabel("Gender:");
            genderLabel.setBounds(60,460,130,30);
            genderCB = new JComboBox<>(genderCBItems);
            genderCB.setBounds(190,460,170,30);

            gradeLabel = new JLabel("Grade:");
            gradeLabel.setBounds(60,510,170,30);
            gradeCB = new JComboBox<>(gradeCBItems);
            gradeCB.setBounds(190,510,90,30);

            extraCLabel = new JLabel("Extracurricular:");
            extraCLabel.setBounds(60,560,170,30);
            extraCCB = new JComboBox<>(extraCCBItems);
            extraCCB.setBounds(190,560,170,30);

            Addbtn  = new JButton("Add");
            Addbtn.setBounds(170,610,80,35);
            Addbtn.addActionListener(event -> addStudent());
            Addbtn.setBackground(Color.cyan);

            sortCB = new JComboBox<>(sortCBItems);
            sortCB.setBounds(500,270,170,30);
            sortbtn = new JButton("Sort");
            sortbtn.setBounds(680,270,80,30);
            sortbtn.addActionListener(new sortButtonListener());

            editLabel = new JLabel("Enter ID to Edit:");
            editLabel.setBounds(500,320,170,30);
            editField = new JTextField();
            editField.setBounds(500,350,170,30);
            editbtn = new JButton("Edit");
            editbtn.setBounds(680,350,80,30);
            editbtn.addActionListener(event -> editStudent());

            deleteLabel = new JLabel("Enter ID to Delete:");
            deleteLabel.setBounds(500,400,170,30);
            deleteField = new JTextField();
            deleteField.setBounds(500,430,170,30);
            deletebtn = new JButton("Delete");
            deletebtn.setBounds(680,430,80,30);
            deletebtn.addActionListener(event -> deleteStudent());

            savebtn = new JButton("Save");
            savebtn.setBounds(275,610,80,35);
            savebtn.addActionListener(event -> editSaveStudent());
            savebtn.setBackground(Color.cyan);

            loadbtn = new JButton("Load");
            loadbtn.setBounds(500,480,80,30);
            loadbtn.addActionListener(event -> populateList());
            loadbtn.setBackground(Color.cyan);

            exitbtn = new JButton("Exit");
            exitbtn.setBounds(680,610,80,35);
            exitbtn.addActionListener(new exitButtonListener());
            exitbtn.setBackground(Color.cyan);

            this.add(IDLabel); this.add(IDField);
            this.add(fnameLabel); this.add(fname);
            this.add(lnameLabel); this.add(lname);
            this.add(dobLabel); this.add(dob);
            this.add(dobLabel1);
            this.add(scrollPane);
            this.add(genderLabel); this.add(genderCB);
            this.add(gradeLabel); this.add(gradeCB);
            this.add(extraCLabel); this.add(extraCCB);
            this.add(Addbtn);
            this.add(sortCB); this.add(sortbtn);
            this.add(editLabel); this.add(editField); this.add(editbtn);
            this.add(deleteLabel); this.add(deleteField); this.add(deletebtn);
            this.add(savebtn); this.add(loadbtn); this.add(exitbtn);

            this.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        }

        private class exitButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }

        private class sortButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }

        private void clearFields() {
            IDField.setText("");
            fname.setText("");
            lname.setText("");
            dob.setText("");
            deleteField.setText("");
            editField.setText("");
            genderCB.setSelectedItem(" ");
            gradeCB.setSelectedItem(" ");
            extraCCB.setSelectedItem(" ");
        }

        private void addStudent() {
            String ida = IDField.getText().trim();
            String fna = fname.getText().trim();
            String lna = lname.getText().trim();
            String doba = dob.getText().trim();
            String gena = (String)genderCB.getSelectedItem();
            String grada = (String)gradeCB.getSelectedItem();
            String eA = (String)extraCCB.getSelectedItem();

            if (ida.isEmpty() || fna.isEmpty() || lna.isEmpty() || doba.isEmpty() || gena.equals(" ") || grada.equals(" ") || eA.equals(" ")) {
                JOptionPane.showMessageDialog(this, "All fields must be filled out.");
                return;
            }

            if (!Pattern.matches("\\d{3}", ida)) {
                JOptionPane.showMessageDialog(this, "ID must be exactly 3 digits.");
                return;
            }
            if (idSet.contains(ida)) {
                JOptionPane.showMessageDialog(this, "ID number already exists. Please use a different ID.");
                return;
            }

            studentLinkedList.add(new Student(ida, fna, lna, doba, gena, grada, eA));
            idSet.add(ida);
            clearFields();
            displayAll();
        }

        private void editStudent() {
            if (studentLinkedList.size() == 0) return;
            editindex = -1;
            for (int s = 0; s < studentLinkedList.size(); s++) {
                if (studentLinkedList.get(s).getID().equals(editField.getText())) {
                    editindex = s;
                    break;
                }
            }
            if (editindex == -1) return;
            IDField.setText(editField.getText());
            editField.setText("");
            Addbtn.setEnabled(false);
            sortbtn.setEnabled(false);
            deletebtn.setEnabled(false);
            exitbtn.setEnabled(false);
            editbtn.setEnabled(false);
            loadbtn.setEnabled(false);
            savebtn.setEnabled(true);

            Student s = studentLinkedList.get(editindex);
            fname.setText(s.getFirstName());
            lname.setText(s.getLastName());
            dob.setText(s.getDateOfBirth());
            genderCB.setSelectedItem(s.getGender());
            gradeCB.setSelectedItem(s.getGrade());
            extraCCB.setSelectedItem(s.getExtraCurric());
        }

        private void editSaveStudent() {
            String newID = IDField.getText().trim();
            if (!Pattern.matches("\\d{3}", newID)) {
                JOptionPane.showMessageDialog(this, "ID must be exactly 3 digits.");
                return;
            }
            if (!newID.equals(studentLinkedList.get(editindex).getID()) && idSet.contains(newID)) {
                JOptionPane.showMessageDialog(this, "ID number already exists. Please use a different ID.");
                return;
            }
            idSet.remove(studentLinkedList.get(editindex).getID());
            idSet.add(newID);

            studentLinkedList.get(editindex).setID(newID);
            studentLinkedList.get(editindex).setFirstName(fname.getText());
            studentLinkedList.get(editindex).setLastName(lname.getText());
            studentLinkedList.get(editindex).setDateOfBirth(dob.getText());
            studentLinkedList.get(editindex).setGender((String)genderCB.getSelectedItem());
            studentLinkedList.get(editindex).setGrade((String)gradeCB.getSelectedItem());
            studentLinkedList.get(editindex).setExtraCurric((String)extraCCB.getSelectedItem());

            displayAll();
            clearFields();
            Addbtn.setEnabled(true);
            sortbtn.setEnabled(true);
            deletebtn.setEnabled(true);
            exitbtn.setEnabled(true);
            editbtn.setEnabled(true);
            loadbtn.setEnabled(true);
            savebtn.setEnabled(false);
        }

        private void deleteStudent() {
            for (int s = 0; s < studentLinkedList.size(); s++) {
                if (studentLinkedList.get(s).getID().equals(deleteField.getText())) {
                    idSet.remove(studentLinkedList.get(s).getID());
                    studentLinkedList.remove(s);
                    break;
                }
            }
            clearFields();
            displayAll();
        }

        private void displayAll() {
            sTextArea.setText(String.format("%-5s %-10s %-12s %-12s %-10s %-7s %-15s\n", "ID", "FirstName", "LastName", "DOB", "Gender", "Grade", "Extra Curr."));
            for (Student s : studentLinkedList) {
                sTextArea.append(String.format("%-5s %-10s %-12s %-12s %-10s %-7s %-15s\n",
                        s.getID(), s.getFirstName(), s.getLastName(), s.getDateOfBirth(),
                        s.getGender(), s.getGrade(), s.getExtraCurric()));
            }
        }

        public void populateList() {
            studentLinkedList.add(new Student("420", "Nicolette", "Lawrence", "07/28/2005", "Female", "12", "Tennis"));
            studentLinkedList.add(new Student("340", "Anica", "Musk", "07/11/2009", "Female", "8", "Netball"));
            studentLinkedList.add(new Student("982", "Nyssa", "Chambers", "02/28/2008", "Female", "9", "Badminton"));
            studentLinkedList.add(new Student("511", "Kemar", "Green", "05/15/2010", "Male", "7", "Football"));
            studentLinkedList.add(new Student("800", "Daniel", "Hoshito", "05/30/2009", "Male", "8", "Rugby"));
            studentLinkedList.add(new Student("551", "Shenelle", "Duffus", "06/13/2006", "Female", "11", "Swimming"));
            studentLinkedList.add(new Student("747", "Tyreese", "Ingrid", "01/09/2007", "Male", "10", "Dancing"));
            studentLinkedList.add(new Student("339", "Beezy", "Francis", "09/22/2005", "Female", "12", "Swimming"));
            for (Student s : studentLinkedList) {
                idSet.add(s.getID());
            }
            displayAll();
        }
    }
