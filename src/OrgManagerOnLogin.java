import services.DBPersistence;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrgManagerOnLogin extends JFrame {
    private JPanel mainPanel;
    private JTextPane queryInputTextPane;
    private JTextPane queryOutputTextPane;
    private JButton buttonSolveQuery;
    private JButton buttonSaveQuery;

    public OrgManagerOnLogin() {
        queryOutputTextPane.setEditable(false);
        buttonSolveQuery.addActionListener(e -> {
            String input = queryInputTextPane.getText();
            ResultSet rs = DBPersistence.getInstance().passQuery(input);
            try {
                ResultSetMetaData md = rs.getMetaData();
                int columnsNumber = md.getColumnCount();
                String sep = ",  ";
                List<String> rowValues = new ArrayList<>();
                String row = "";
                while (rs.next()) {
                    row = "";
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) row += sep;
                        String columnValue = rs.getString(i);
                        row += (columnValue + " " + md.getColumnName(i));
                    }
                    row += "\n";
                    rowValues.add(row);
                }
                row = "";
                for (int i = 0; i < rowValues.size(); i++) {
                    row += rowValues.get(i);
                }
                queryOutputTextPane.setText(row);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        buttonSaveQuery.addActionListener(e -> {
            JFrame parentFrame = new JFrame();
            parentFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save to ...");
            int userSelection = fileChooser.showSaveDialog(parentFrame);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                try {
                    FileWriter fw = new FileWriter(fileToSave.getAbsolutePath());
                    fw.write(queryOutputTextPane.getText());
                    fw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("OrgManagerOnLogin");
        frame.setContentPane(new OrgManagerOnLogin().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 3, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.setBorder(BorderFactory.createTitledBorder(null, "OrgManagerQuerySolver", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JLabel label1 = new JLabel();
        label1.setText("Input SQL Query");
        mainPanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 3, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Query Result");
        mainPanel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        queryInputTextPane = new JTextPane();
        queryInputTextPane.setBackground(new Color(-1049089));
        mainPanel.add(queryInputTextPane, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        queryOutputTextPane = new JTextPane();
        queryOutputTextPane.setBackground(new Color(-1312769));
        mainPanel.add(queryOutputTextPane, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 3, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        mainPanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 6, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        buttonSolveQuery = new JButton();
        buttonSolveQuery.setText("Solve Query");
        mainPanel.add(buttonSolveQuery, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonSaveQuery = new JButton();
        buttonSaveQuery.setText("Save Query");
        mainPanel.add(buttonSaveQuery, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}