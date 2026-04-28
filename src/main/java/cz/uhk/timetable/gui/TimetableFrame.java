package cz.uhk.timetable.gui;

import cz.uhk.timetable.model.LocationTimetable;
import cz.uhk.timetable.utils.TimetableProvider;
import cz.uhk.timetable.utils.impl.MockTimetableProvider;
import cz.uhk.timetable.utils.impl.StagTimetableProvider;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class TimetableFrame extends JFrame {
    private LocationTimetable timetable;
    private TimetableProvider provider = new StagTimetableProvider();
    private JTable tabTimetable;
    private JComboBox<String> cmbBuilding;
    private JComboBox<String> cmbRoom;
    private JLabel lblBuilding, lblRoom;
    private JPanel controlPanel;

    private String[] buildingNames = {"A","B","C","E","F","H","J","P","R","S"};
    private String[] roomNames = {"AULA", "A102", "A205", "F3", "F2", "B1", "B10", "J3", "J22"};

    private String selectedBuilding, selectedRoom;
    private JButton btnLoad;

    public TimetableFrame(){
        super("FIM Rozvrhy");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initGui();
        initListeners();
    }

    private void initGui() {
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        lblBuilding = new JLabel("Budova:");
        controlPanel.add(lblBuilding);

        cmbBuilding = new JComboBox<>(buildingNames);
        controlPanel.add(cmbBuilding);

        lblRoom = new JLabel("Místnost:");
        controlPanel.add(lblRoom);

        cmbRoom = new JComboBox<>(roomNames);
        controlPanel.add(cmbRoom);

        btnLoad = new JButton("Načíst");
        controlPanel.add(btnLoad);

        // Načtení výchozích hodnot
        selectedBuilding = String.valueOf(cmbBuilding.getSelectedItem());
        selectedRoom = String.valueOf(cmbRoom.getSelectedItem());

        timetable = provider.read("J", "J22");

        tabTimetable = new JTable(new TimetableModel());
        tabTimetable.setAutoCreateRowSorter(true);

        add(controlPanel, BorderLayout.NORTH);
        add(new JScrollPane(tabTimetable), BorderLayout.CENTER);

        pack();
    }

    private void initListeners() {
        btnLoad.addActionListener(e -> {
            selectedBuilding = String.valueOf(cmbBuilding.getSelectedItem());
            selectedRoom = String.valueOf(cmbRoom.getSelectedItem());
            timetable = provider.read(selectedBuilding, selectedRoom);
            ((TimetableModel)tabTimetable.getModel()).fireTableDataChanged();
        });
    }

    class TimetableModel extends AbstractTableModel {

        @Override
        public String getColumnName(int column) {
            switch (column){
                case 0: return "Zkratka";
                case 1: return "Název";
                case 2: return "Den";
                case 3: return "Začátek";
                case 4: return "Konec";
                case 5: return "Učitel";
            }
            return "";
        }

        @Override
        public int getRowCount() {
            return timetable.getActivities().size();
        }

        @Override
        public int getColumnCount() {
            return 6;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var act = timetable.getActivities().get(rowIndex);
            switch (columnIndex){
                case 0: return act.getCode();
                case 1: return act.getName();
                case 2: return act.getDay();
                case 3: return act.getStartTime();
                case 4: return act.getEndTime();
                case 5: return act.getTeacher();
            }
            return null;
        }
    }
}