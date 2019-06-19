/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeastBot;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 * configuration frame class
 *
 * @author Joe Ye
 */
public class ConfigurationFrame extends javax.swing.JFrame {

    /**
     * Creates new form ConfigurationFrame
     *
     */
    public ConfigurationFrame() {
        initComponents();
        keyDatas = null;
        FullscreenFrame.setVisible(false);
        ActionIndicatorLabel.setVisible(false);
    }

    /**
     *
     * @return an array of keyDatas the user configured
     */
    public KeyData[] getKeyDatas() {
        return keyDatas;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FullscreenFrame = new javax.swing.JFrame();
        ImportButton = new javax.swing.JButton();
        ExportButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        OKButton = new javax.swing.JButton();
        NumberOfKeysLable = new javax.swing.JLabel();
        NumberOfKeysSpinner = new javax.swing.JSpinner();
        KeysComboBox = new javax.swing.JComboBox<>();
        KeyCoordinatesLable = new javax.swing.JLabel();
        xCoordinateLable = new javax.swing.JLabel();
        xCoordinateSpinner = new javax.swing.JSpinner();
        CallibrateOnClickButton = new javax.swing.JButton();
        CoordinatesSectionSeparator = new javax.swing.JSeparator();
        yCoordinateLable = new javax.swing.JLabel();
        yCoordinateSpinner = new javax.swing.JSpinner();
        ActionIndicatorLabel = new javax.swing.JLabel();

        FullscreenFrame.setUndecorated(true);
        FullscreenFrame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateXYCoordinatesOnMouseClick(evt);
            }
        });

        javax.swing.GroupLayout FullscreenFrameLayout = new javax.swing.GroupLayout(FullscreenFrame.getContentPane());
        FullscreenFrame.getContentPane().setLayout(FullscreenFrameLayout);
        FullscreenFrameLayout.setHorizontalGroup(
            FullscreenFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        FullscreenFrameLayout.setVerticalGroup(
            FullscreenFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Configurations");
        setAlwaysOnTop(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                selecetDefaultNumberOfKeys(evt);
            }
        });

        ImportButton.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        ImportButton.setText("Import");
        ImportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportButtonActionPerformed(evt);
            }
        });

        ExportButton.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        ExportButton.setText("Export");
        ExportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportButtonActionPerformed(evt);
            }
        });

        CancelButton.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        OKButton.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        NumberOfKeysLable.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        NumberOfKeysLable.setText("Number of Keys");

        NumberOfKeysSpinner.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        NumberOfKeysSpinner.setModel(new javax.swing.SpinnerNumberModel(4, 1, 10, 1));
        NumberOfKeysSpinner.setToolTipText("");
        NumberOfKeysSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                updateNumberOfKeys(evt);
            }
        });

        KeysComboBox.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        KeysComboBox.setMaximumRowCount(10);
        KeysComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Key 1", "Key 2", "Key 3", "Key 4" }));
        KeysComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                keySelected(evt);
            }
        });
        KeysComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeysComboBoxActionPerformed(evt);
            }
        });

        KeyCoordinatesLable.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        KeyCoordinatesLable.setText("Key Coordinates");

        xCoordinateLable.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        xCoordinateLable.setText("x-coordinate");

        xCoordinateSpinner.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        xCoordinateSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        xCoordinateSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                updateXCoordinate(evt);
            }
        });

        CallibrateOnClickButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        CallibrateOnClickButton.setText("Callibrate on Click");
        CallibrateOnClickButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CallibrateOnClickButtonActionPerformed(evt);
            }
        });

        yCoordinateLable.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        yCoordinateLable.setText("y-coordinate");

        yCoordinateSpinner.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        yCoordinateSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        yCoordinateSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                updateYCoordinate(evt);
            }
        });

        ActionIndicatorLabel.setFont(new java.awt.Font("Dialog", 2, 10)); // NOI18N
        ActionIndicatorLabel.setText("Success");
        ActionIndicatorLabel.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CoordinatesSectionSeparator)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NumberOfKeysLable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NumberOfKeysSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(xCoordinateLable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(xCoordinateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ImportButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ExportButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                        .addComponent(OKButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CancelButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(yCoordinateLable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(yCoordinateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(KeyCoordinatesLable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(KeysComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CallibrateOnClickButton)
                            .addComponent(ActionIndicatorLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NumberOfKeysLable)
                    .addComponent(NumberOfKeysSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CoordinatesSectionSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KeyCoordinatesLable)
                    .addComponent(KeysComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CallibrateOnClickButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xCoordinateLable)
                    .addComponent(xCoordinateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yCoordinateLable)
                    .addComponent(yCoordinateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(ActionIndicatorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ImportButton)
                    .addComponent(ExportButton)
                    .addComponent(CancelButton)
                    .addComponent(OKButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ImportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportButtonActionPerformed
        int n = (int) NumberOfKeysSpinner.getModel().getValue();
        int readN = readConfig(n);
        if (readN != n) {
            ActionIndicatorLabel.setText("Overwrote number of keys to " + readN + " from the config file. Coordinates updated.");
            ActionIndicatorLabel.setVisible(true);
            NumberOfKeysSpinner.getModel().setValue(readN);
            readConfig(n);
        } else {
            ActionIndicatorLabel.setText("Seccussfully imported coordinates for " + readN + " keys.");
            ActionIndicatorLabel.setVisible(true);
        }

        KeysComboBoxModel keysComboBoxModel = new KeysComboBoxModel(readN);
        KeysComboBox.setModel(keysComboBoxModel);
        KeysComboBox.setSelectedItem("Key 1");
        KeysComboBox.setSelectedIndex(0);
        xCoordinateSpinner.setValue(keyDatas[0].coordinates.x);
        yCoordinateSpinner.setValue(keyDatas[0].coordinates.y);
    }//GEN-LAST:event_ImportButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        if (FullscreenFrame != null) {
            FullscreenFrame.dispose();
        }
        dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void KeysComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeysComboBoxActionPerformed

    }//GEN-LAST:event_KeysComboBoxActionPerformed

    private void updateNumberOfKeys(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_updateNumberOfKeys
        int n = (int) NumberOfKeysSpinner.getModel().getValue();

        keyDatas = new KeyData[n];
        for (int i = 0; i < keyDatas.length; i++) {
            keyDatas[i] = new KeyData();
        }
        KeysComboBoxModel keysComboBoxModel = new KeysComboBoxModel(n);
        KeysComboBox.setModel(keysComboBoxModel);
        KeysComboBox.setSelectedItem("Key 1");
        KeysComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_updateNumberOfKeys

    private void CallibrateOnClickButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CallibrateOnClickButtonActionPerformed
        FullscreenFrame.setSize(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height);
        FullscreenFrame.setLocation(0, 0);
        Color currentBackgroundColor = FullscreenFrame.getBackground();
        FullscreenFrame.setBackground(new Color(currentBackgroundColor.getRed(),
                currentBackgroundColor.getGreen(),
                currentBackgroundColor.getBlue(),
                (int) (255 * FULLSCREENFRAMETRANSPARENTCY)));
        FullscreenFrame.setVisible(true);
    }//GEN-LAST:event_CallibrateOnClickButtonActionPerformed

    private void keySelected(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_keySelected
        int i = KeysComboBox.getSelectedIndex();
        xCoordinateSpinner.setValue(keyDatas[i].coordinates.x);
        yCoordinateSpinner.setValue(keyDatas[i].coordinates.y);
    }//GEN-LAST:event_keySelected

    private void updateXCoordinate(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_updateXCoordinate
        int i = KeysComboBox.getSelectedIndex();
        keyDatas[i].coordinates.x = (int) xCoordinateSpinner.getValue();
    }//GEN-LAST:event_updateXCoordinate

    private void updateYCoordinate(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_updateYCoordinate
        int i = KeysComboBox.getSelectedIndex();
        keyDatas[i].coordinates.y = (int) yCoordinateSpinner.getValue();
    }//GEN-LAST:event_updateYCoordinate

    private void selecetDefaultNumberOfKeys(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_selecetDefaultNumberOfKeys
//        // if there is saved data
//        if (keyDatas != null) {
//            NumberOfKeysSpinner.getModel().setValue(keyDatas.length);
//            xCoordinateSpinner.setValue(keyDatas[0].coordinates.x);
//            yCoordinateSpinner.setValue(keyDatas[0].coordinates.y);
//        } else {
//            int n = (int) NumberOfKeysSpinner.getModel().getValue();
//            keyDatas = new KeyData[n];
//            for (int i = 0; i < keyDatas.length; i++) {
//                keyDatas[i] = new KeyData();
//            }
//        }
        int n = (int) NumberOfKeysSpinner.getModel().getValue();
        keyDatas = new KeyData[n];
        for (int i = 0; i < keyDatas.length; i++) {
            keyDatas[i] = new KeyData();
        }
    }//GEN-LAST:event_selecetDefaultNumberOfKeys

    private void updateXYCoordinatesOnMouseClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateXYCoordinatesOnMouseClick
        int i = KeysComboBox.getSelectedIndex();
        keyDatas[i].coordinates = FullscreenFrame.getMousePosition();
        keySelected(null);
        FullscreenFrame.setVisible(false);
    }//GEN-LAST:event_updateXYCoordinatesOnMouseClick

    private void ExportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportButtonActionPerformed
        writeConfig();
        int n = (int) NumberOfKeysSpinner.getModel().getValue();
        ActionIndicatorLabel.setText("Seccussfully exported coordinates for " + n + " keys.");
        ActionIndicatorLabel.setVisible(true);
    }//GEN-LAST:event_ExportButtonActionPerformed

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        if (FullscreenFrame != null) {
            FullscreenFrame.dispose();
        }
        dispose();
    }//GEN-LAST:event_OKButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ActionIndicatorLabel;
    private javax.swing.JButton CallibrateOnClickButton;
    private javax.swing.JButton CancelButton;
    private javax.swing.JSeparator CoordinatesSectionSeparator;
    private javax.swing.JButton ExportButton;
    private javax.swing.JFrame FullscreenFrame;
    private javax.swing.JButton ImportButton;
    private javax.swing.JLabel KeyCoordinatesLable;
    private javax.swing.JComboBox<String> KeysComboBox;
    private javax.swing.JLabel NumberOfKeysLable;
    private javax.swing.JSpinner NumberOfKeysSpinner;
    private javax.swing.JButton OKButton;
    private javax.swing.JLabel xCoordinateLable;
    private javax.swing.JSpinner xCoordinateSpinner;
    private javax.swing.JLabel yCoordinateLable;
    private javax.swing.JSpinner yCoordinateSpinner;
    // End of variables declaration//GEN-END:variables

    private static final String CONFIGFILENAME = "config.txt"; // The name of the file to write to
    private static final float FULLSCREENFRAMETRANSPARENTCY = (float) 0.4;

    private KeyData[] keyDatas;

    /**
     * reads configuration file
     *
     * @param expectedN expected number of coordinates pairs to be read
     * @return the number of coordinates pairs read
     */
    private int readConfig(int expectedN) {

        // creats a file for team names
        File config = new File(CONFIGFILENAME);

        // number of coordinates pairs
        int n = 0;
        // creates scanner for team names
        try (Scanner fin = new Scanner(config)) {
            // loops as long as theres lines to read in names file
            while (fin.hasNextLine()) {
                if (n < expectedN) {
                    keyDatas[n].coordinates.x = Integer.parseInt(fin.nextLine());
                    keyDatas[n].coordinates.y = Integer.parseInt(fin.nextLine());
                } else {
                    // there are extra cooridnate pairs written in the file
                    // dump the rest of the pairs
                    fin.nextLine();
                    fin.nextLine();
                }
                n++;
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(CONFIGFILENAME + " is not found.");
            System.out.println(fileNotFoundException.getMessage());
        }
        return n;
    }

    /**
     * Writes coordinates of keys to file
     *
     */
    private void writeConfig() {

        try {
            // Writes to the specified file path
            FileWriter fileWriter = new FileWriter(CONFIGFILENAME);

            // Creates a buffer for the file writeConfig
            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                // For every month in the months array add it to a new line in the text file
                for (KeyData keyData : keyDatas) {
                    bufferedWriter.write(Integer.toString(keyData.coordinates.x));
                    bufferedWriter.newLine();
                    bufferedWriter.write(Integer.toString(keyData.coordinates.y));
                    bufferedWriter.newLine();
                }
            }

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(CONFIGFILENAME + " not found.");
            System.out.println(fileNotFoundException.getMessage());
        } catch (IOException iOException) {
            System.out.println(iOException.getMessage());
        }

    }

    class KeysComboBoxModel implements ComboBoxModel<String> {

        /**
         *
         * @param n number of keys will be displayed in the combo box
         */
        public KeysComboBoxModel(int n) {
            keyNames = new String[n];
            for (int i = 0; i < keyNames.length; i++) {
                keyNames[i] = new StringBuffer().append("Key ").append(i + 1).toString();
            }
            selection = null;
            listDataListener = null;
        }

        @Override
        public void setSelectedItem(Object anItem) {
            selection = (String) anItem;
        }

        @Override
        public Object getSelectedItem() {
            return selection;
        }

        @Override
        public int getSize() {
            return keyNames.length;
        }

        @Override
        public String getElementAt(int index) {
            return keyNames[index];
        }

        @Override
        public void addListDataListener(ListDataListener l) {
            listDataListener = l;
        }

        @Override
        public void removeListDataListener(ListDataListener l) {
            listDataListener = null;
        }

        private String[] keyNames; // names of keys will be displayed in the combo box
        private String selection; // selected key name
        private ListDataListener listDataListener; // I do not know what it is
    }
}
