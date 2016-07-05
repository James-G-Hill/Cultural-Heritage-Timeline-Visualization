package org.jghill.timelinesvisualizercollectionsgui;

import org.jghill.timelinesvisualizercollections.CollectionInt;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//org.jghill.timelinesvisualizercollectionsgui//Collection//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "CollectionTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "org.jghill.timelinesvisualizercollectionsgui.CollectionTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_CollectionAction",
        preferredID = "CollectionTopComponent"
)
@Messages({
    "CTL_CollectionAction=Collection",
    "CTL_CollectionTopComponent=Collection Window",
    "HINT_CollectionTopComponent=This is a Collection window"
})
public final class CollectionTopComponent extends TopComponent {

    private CollectionInt coll;
    
    public CollectionTopComponent() {
        initComponents();
        setName(Bundle.CTL_CollectionTopComponent());
        setToolTipText(Bundle.HINT_CollectionTopComponent());
        putClientProperty(TopComponent.PROP_CLOSING_DISABLED, Boolean.FALSE);
        putClientProperty(TopComponent.PROP_DRAGGING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_MAXIMIZATION_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_UNDOCKING_DISABLED, Boolean.TRUE);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        Tab = new javax.swing.JTabbedPane();
        Information = new javax.swing.JPanel();
        TitleTextPanel = new javax.swing.JScrollPane();
        TitleTextBox = new javax.swing.JTextPane();
        NotesTextPanel = new javax.swing.JScrollPane();
        NotesTextBox = new javax.swing.JTextArea();
        NotesText = new javax.swing.JLabel();
        Queries = new javax.swing.JPanel();
        QueriesScrollPane = new javax.swing.JScrollPane();
        QueriesTable = new javax.swing.JTable();
        ExistingQueriesText = new javax.swing.JLabel();
        QuerySeparator = new javax.swing.JSeparator();
        QueryBuilderText = new javax.swing.JLabel();
        CreateButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        VerticalSeparator = new javax.swing.JSeparator();
        SourceTextLabel = new javax.swing.JLabel();
        SourceComboBox = new javax.swing.JComboBox<>();
        CreationDateCheckBox = new javax.swing.JCheckBox();
        AcquisitionDateCheckBox = new javax.swing.JCheckBox();
        LengthBetweenCheckBox = new javax.swing.JCheckBox();
        WidthBetweenCheckBox = new javax.swing.JCheckBox();
        ThicknessBetweenCheckBox = new javax.swing.JCheckBox();
        ConsistsOfCheckBox = new javax.swing.JCheckBox();
        HasImageCheckBox = new javax.swing.JCheckBox();
        OriginLocationCheckBox = new javax.swing.JCheckBox();
        DeleteButton = new javax.swing.JButton();
        FoundLocationCheckBox = new javax.swing.JCheckBox();
        CreationStartDatePicker = new org.jdesktop.swingx.JXDatePicker();
        CreationEndDatePicker = new org.jdesktop.swingx.JXDatePicker();
        AndText1 = new javax.swing.JLabel();
        AcquisitionStartDatePicker = new org.jdesktop.swingx.JXDatePicker();
        AcquisitionEndDatePicker = new org.jdesktop.swingx.JXDatePicker();
        AndText2 = new javax.swing.JLabel();
        AndText3 = new javax.swing.JLabel();
        LengthLowerTextField = new javax.swing.JTextField();
        LengthUpperTextField = new javax.swing.JTextField();
        WidthLowerTextField = new javax.swing.JTextField();
        AndText4 = new javax.swing.JLabel();
        WidthUpperTextField = new javax.swing.JTextField();
        ThicknessLowerTextField = new javax.swing.JTextField();
        AndText5 = new javax.swing.JLabel();
        ThicknessUpperTextField = new javax.swing.JTextField();
        ConsistsOfTextField = new javax.swing.JTextField();
        LocationFoundTextField = new javax.swing.JTextField();
        LocationOriginTextField = new javax.swing.JTextField();
        UnitLabel1 = new javax.swing.JLabel();
        UnitLabel2 = new javax.swing.JLabel();
        UnitLabel3 = new javax.swing.JLabel();
        LengthUnitComboBox = new javax.swing.JComboBox<>();
        WidthUnitComboBox = new javax.swing.JComboBox<>();
        ThicknessUnitComboBox = new javax.swing.JComboBox<>();
        Visualizer = new javax.swing.JPanel();

        TitleTextBox.setEditable(false);
        TitleTextBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TitleTextPanel.setViewportView(TitleTextBox);

        NotesTextBox.setColumns(20);
        NotesTextBox.setRows(5);
        NotesTextPanel.setViewportView(NotesTextBox);

        org.openide.awt.Mnemonics.setLocalizedText(NotesText, org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.NotesText.text")); // NOI18N

        javax.swing.GroupLayout InformationLayout = new javax.swing.GroupLayout(Information);
        Information.setLayout(InformationLayout);
        InformationLayout.setHorizontalGroup(
            InformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NotesTextPanel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TitleTextPanel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(InformationLayout.createSequentialGroup()
                        .addComponent(NotesText, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 761, Short.MAX_VALUE)))
                .addContainerGap())
        );
        InformationLayout.setVerticalGroup(
            InformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleTextPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NotesText)
                .addGap(18, 18, 18)
                .addComponent(NotesTextPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addContainerGap())
        );

        Tab.addTab(org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.Information.TabConstraints.tabTitle"), Information); // NOI18N

        QueriesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        QueriesScrollPane.setViewportView(QueriesTable);

        org.openide.awt.Mnemonics.setLocalizedText(ExistingQueriesText, org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.ExistingQueriesText.text")); // NOI18N
        ExistingQueriesText.setPreferredSize(new java.awt.Dimension(100, 14));

        QuerySeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        org.openide.awt.Mnemonics.setLocalizedText(QueryBuilderText, org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.QueryBuilderText.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(CreateButton, org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.CreateButton.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(ResetButton, org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.ResetButton.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(SourceTextLabel, org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.SourceTextLabel.text")); // NOI18N

        SourceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        SourceComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SourceComboBoxActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(CreationDateCheckBox, org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.CreationDateCheckBox.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(AcquisitionDateCheckBox, org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.AcquisitionDateCheckBox.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(LengthBetweenCheckBox, org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.LengthBetweenCheckBox.text")); // NOI18N
        LengthBetweenCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LengthBetweenCheckBoxActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(WidthBetweenCheckBox, org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.WidthBetweenCheckBox.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(ThicknessBetweenCheckBox, org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.ThicknessBetweenCheckBox.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(ConsistsOfCheckBox, org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.ConsistsOfCheckBox.text")); // NOI18N
        ConsistsOfCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsistsOfCheckBoxActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(HasImageCheckBox, org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.HasImageCheckBox.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(OriginLocationCheckBox, org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.OriginLocationCheckBox.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(DeleteButton, org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.DeleteButton.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(FoundLocationCheckBox, org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.FoundLocationCheckBox.text")); // NOI18N
        FoundLocationCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FoundLocationCheckBoxActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(AndText1, org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.AndText1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(AndText2, org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.AndText2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(AndText3, org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.AndText3.text")); // NOI18N

        LengthLowerTextField.setText(org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.LengthLowerTextField.text")); // NOI18N

        LengthUpperTextField.setText(org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.LengthUpperTextField.text")); // NOI18N

        WidthLowerTextField.setText(org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.WidthLowerTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(AndText4, org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.AndText4.text")); // NOI18N

        WidthUpperTextField.setText(org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.WidthUpperTextField.text")); // NOI18N

        ThicknessLowerTextField.setText(org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.ThicknessLowerTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(AndText5, org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.AndText5.text")); // NOI18N

        ThicknessUpperTextField.setText(org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.ThicknessUpperTextField.text")); // NOI18N

        ConsistsOfTextField.setText(org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.ConsistsOfTextField.text")); // NOI18N

        LocationFoundTextField.setText(org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.LocationFoundTextField.text")); // NOI18N

        LocationOriginTextField.setText(org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.LocationOriginTextField.text")); // NOI18N
        LocationOriginTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocationOriginTextFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(UnitLabel1, org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.UnitLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(UnitLabel2, org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.UnitLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(UnitLabel3, org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.UnitLabel3.text")); // NOI18N

        LengthUnitComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        WidthUnitComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        WidthUnitComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WidthUnitComboBoxActionPerformed(evt);
            }
        });

        ThicknessUnitComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout QueriesLayout = new javax.swing.GroupLayout(Queries);
        Queries.setLayout(QueriesLayout);
        QueriesLayout.setHorizontalGroup(
            QueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QueriesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(QueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ExistingQueriesText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QueriesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteButton))
                .addGap(18, 18, 18)
                .addComponent(QuerySeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(QueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QueriesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ResetButton)
                        .addGap(18, 18, 18)
                        .addComponent(CreateButton))
                    .addComponent(VerticalSeparator)
                    .addComponent(QueryBuilderText)
                    .addGroup(QueriesLayout.createSequentialGroup()
                        .addComponent(SourceTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SourceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(FoundLocationCheckBox)
                    .addComponent(OriginLocationCheckBox)
                    .addGroup(QueriesLayout.createSequentialGroup()
                        .addGroup(QueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(QueriesLayout.createSequentialGroup()
                                .addGroup(QueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CreationDateCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AcquisitionDateCheckBox))
                                .addGap(18, 18, 18)
                                .addGroup(QueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(QueriesLayout.createSequentialGroup()
                                        .addComponent(CreationStartDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(AndText1))
                                    .addGroup(QueriesLayout.createSequentialGroup()
                                        .addGroup(QueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(LocationOriginTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LocationFoundTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ConsistsOfTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ThicknessLowerTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(WidthLowerTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(AcquisitionStartDatePicker, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(LengthLowerTextField, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)
                                        .addGroup(QueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(AndText3)
                                            .addComponent(AndText2)
                                            .addComponent(AndText4)
                                            .addComponent(AndText5)))))
                            .addComponent(LengthBetweenCheckBox)
                            .addComponent(WidthBetweenCheckBox)
                            .addComponent(ThicknessBetweenCheckBox)
                            .addComponent(ConsistsOfCheckBox))
                        .addGap(18, 18, 18)
                        .addGroup(QueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AcquisitionEndDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CreationEndDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(WidthUpperTextField)
                            .addComponent(ThicknessUpperTextField)
                            .addComponent(HasImageCheckBox)
                            .addComponent(LengthUpperTextField))
                        .addGap(18, 18, 18)
                        .addGroup(QueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(QueriesLayout.createSequentialGroup()
                                .addComponent(UnitLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(LengthUnitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(QueriesLayout.createSequentialGroup()
                                .addGroup(QueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(UnitLabel3)
                                    .addComponent(UnitLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(QueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(WidthUnitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ThicknessUnitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(16, 16, 16)))
                .addContainerGap())
        );
        QueriesLayout.setVerticalGroup(
            QueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(QuerySeparator)
            .addGroup(QueriesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(QueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QueriesLayout.createSequentialGroup()
                        .addComponent(ExistingQueriesText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(QueriesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteButton))
                    .addGroup(QueriesLayout.createSequentialGroup()
                        .addComponent(QueryBuilderText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VerticalSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(QueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SourceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SourceTextLabel))
                        .addGap(18, 18, 18)
                        .addGroup(QueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CreationDateCheckBox)
                            .addComponent(CreationStartDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CreationEndDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AndText1))
                        .addGap(18, 18, 18)
                        .addGroup(QueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AcquisitionDateCheckBox)
                            .addComponent(AcquisitionStartDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AcquisitionEndDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AndText2))
                        .addGap(18, 18, 18)
                        .addGroup(QueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LengthBetweenCheckBox)
                            .addComponent(AndText3)
                            .addComponent(LengthLowerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LengthUpperTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UnitLabel1)
                            .addComponent(LengthUnitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(QueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(WidthBetweenCheckBox)
                            .addComponent(WidthLowerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AndText4)
                            .addComponent(WidthUpperTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UnitLabel3)
                            .addComponent(WidthUnitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(QueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ThicknessBetweenCheckBox)
                            .addComponent(ThicknessLowerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AndText5)
                            .addComponent(ThicknessUpperTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UnitLabel2)
                            .addComponent(ThicknessUnitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(QueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ConsistsOfCheckBox)
                            .addComponent(ConsistsOfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HasImageCheckBox))
                        .addGap(18, 18, 18)
                        .addGroup(QueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FoundLocationCheckBox)
                            .addComponent(LocationFoundTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(QueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(OriginLocationCheckBox)
                            .addComponent(LocationOriginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(QueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CreateButton)
                            .addComponent(ResetButton))))
                .addContainerGap())
        );

        Tab.addTab(org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.Queries.TabConstraints.tabTitle"), Queries); // NOI18N

        javax.swing.GroupLayout VisualizerLayout = new javax.swing.GroupLayout(Visualizer);
        Visualizer.setLayout(VisualizerLayout);
        VisualizerLayout.setHorizontalGroup(
            VisualizerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 981, Short.MAX_VALUE)
        );
        VisualizerLayout.setVerticalGroup(
            VisualizerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
        );

        Tab.addTab(org.openide.util.NbBundle.getMessage(CollectionTopComponent.class, "CollectionTopComponent.Visualizer.TabConstraints.tabTitle"), Visualizer); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tab)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tab)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SourceComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SourceComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SourceComboBoxActionPerformed

    private void LengthBetweenCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LengthBetweenCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LengthBetweenCheckBoxActionPerformed

    private void ConsistsOfCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsistsOfCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConsistsOfCheckBoxActionPerformed

    private void FoundLocationCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FoundLocationCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FoundLocationCheckBoxActionPerformed

    private void LocationOriginTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocationOriginTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LocationOriginTextFieldActionPerformed

    private void WidthUnitComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WidthUnitComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WidthUnitComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox AcquisitionDateCheckBox;
    private org.jdesktop.swingx.JXDatePicker AcquisitionEndDatePicker;
    private org.jdesktop.swingx.JXDatePicker AcquisitionStartDatePicker;
    private javax.swing.JLabel AndText1;
    private javax.swing.JLabel AndText2;
    private javax.swing.JLabel AndText3;
    private javax.swing.JLabel AndText4;
    private javax.swing.JLabel AndText5;
    private javax.swing.JCheckBox ConsistsOfCheckBox;
    private javax.swing.JTextField ConsistsOfTextField;
    private javax.swing.JButton CreateButton;
    private javax.swing.JCheckBox CreationDateCheckBox;
    private org.jdesktop.swingx.JXDatePicker CreationEndDatePicker;
    private org.jdesktop.swingx.JXDatePicker CreationStartDatePicker;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JLabel ExistingQueriesText;
    private javax.swing.JCheckBox FoundLocationCheckBox;
    private javax.swing.JCheckBox HasImageCheckBox;
    private javax.swing.JPanel Information;
    private javax.swing.JCheckBox LengthBetweenCheckBox;
    private javax.swing.JTextField LengthLowerTextField;
    private javax.swing.JComboBox<String> LengthUnitComboBox;
    private javax.swing.JTextField LengthUpperTextField;
    private javax.swing.JTextField LocationFoundTextField;
    private javax.swing.JTextField LocationOriginTextField;
    private javax.swing.JLabel NotesText;
    private javax.swing.JTextArea NotesTextBox;
    private javax.swing.JScrollPane NotesTextPanel;
    private javax.swing.JCheckBox OriginLocationCheckBox;
    private javax.swing.JPanel Queries;
    private javax.swing.JScrollPane QueriesScrollPane;
    private javax.swing.JTable QueriesTable;
    private javax.swing.JLabel QueryBuilderText;
    private javax.swing.JSeparator QuerySeparator;
    private javax.swing.JButton ResetButton;
    private javax.swing.JComboBox<String> SourceComboBox;
    private javax.swing.JLabel SourceTextLabel;
    private javax.swing.JTabbedPane Tab;
    private javax.swing.JCheckBox ThicknessBetweenCheckBox;
    private javax.swing.JTextField ThicknessLowerTextField;
    private javax.swing.JComboBox<String> ThicknessUnitComboBox;
    private javax.swing.JTextField ThicknessUpperTextField;
    private javax.swing.JTextPane TitleTextBox;
    private javax.swing.JScrollPane TitleTextPanel;
    private javax.swing.JLabel UnitLabel1;
    private javax.swing.JLabel UnitLabel2;
    private javax.swing.JLabel UnitLabel3;
    private javax.swing.JSeparator VerticalSeparator;
    private javax.swing.JPanel Visualizer;
    private javax.swing.JCheckBox WidthBetweenCheckBox;
    private javax.swing.JTextField WidthLowerTextField;
    private javax.swing.JComboBox<String> WidthUnitComboBox;
    private javax.swing.JTextField WidthUpperTextField;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
    
    /**
     * A setter for a project to be applied to this top component.
     * 
     * @param proj the project to be passed to this top component.
     */
    public void setProject(CollectionInt proj) {
        this.coll = proj;
    }

}