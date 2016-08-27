package org.jghill.timelinevisualizer.properties;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.util.Collection;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.jghill.timelinevisualizerentities.ManMadeObject;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.openide.util.Utilities;

/**
 * A viewer for displaying properties of the currently selected Entity.
 */
@ConvertAsProperties(
        dtd = "-//org.jghill.timelinevisualizer.properties//Properties//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "PropertiesTopComponent",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "properties", openAtStartup = true)
@ActionID(category = "Window", id = "org.jghill.timelinevisualizer.properties.PropertiesTopComponent")
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_PropertiesAction",
        preferredID = "PropertiesTopComponent"
)
@Messages({
    "CTL_PropertiesAction=Properties",
    "CTL_PropertiesTopComponent=Properties",
    "HINT_PropertiesTopComponent=This is a Properties window"
})
public final class PropertiesTopComponent extends TopComponent implements LookupListener {

    public PropertiesTopComponent() {
        initComponents();
        setName(Bundle.CTL_PropertiesTopComponent());
        setToolTipText(Bundle.HINT_PropertiesTopComponent());
        
        putClientProperty(TopComponent.PROP_CLOSING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_DRAGGING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_MAXIMIZATION_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_UNDOCKING_DISABLED, Boolean.TRUE);
        
        setup();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PropertiesScrollPane = new javax.swing.JScrollPane();
        PropertiesPanel = new javax.swing.JPanel();
        CommentaryLabel = new javax.swing.JLabel();
        CommentaryScrollPane = new javax.swing.JScrollPane();
        CommentaryTextArea = new javax.swing.JTextArea();
        ImagePanel = new javax.swing.JPanel();
        CreationYearTextField = new javax.swing.JTextField();
        CreationYearLabel = new javax.swing.JLabel();
        DepictsLabel = new javax.swing.JLabel();
        DepictsTextField = new javax.swing.JTextField();
        ConsistsTextField = new javax.swing.JTextField();
        ConsistsLabel = new javax.swing.JLabel();
        TypeLabel = new javax.swing.JLabel();
        TypeTextField = new javax.swing.JTextField();
        TechniqueLabel = new javax.swing.JLabel();
        TechniqueTextField = new javax.swing.JTextField();
        IdentifierLabel = new javax.swing.JLabel();
        NameLabel = new javax.swing.JLabel();
        SourceLabel = new javax.swing.JLabel();
        QueryLabel = new javax.swing.JLabel();
        IdentifierTextField = new javax.swing.JTextField();
        SourceTextField = new javax.swing.JTextField();
        QueryTextField = new javax.swing.JTextField();
        DescriptionLabel = new javax.swing.JLabel();
        DescriptionScrollPane = new javax.swing.JScrollPane();
        DescriptionTextArea = new javax.swing.JTextArea();
        NameTextField = new javax.swing.JTextField();
        CreatorLabel = new javax.swing.JLabel();
        CreatorTextField = new javax.swing.JTextField();
        DetailsLabel = new javax.swing.JLabel();
        DetailsTextField = new javax.swing.JTextField();

        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(320, 850));

        PropertiesScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        PropertiesScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        PropertiesScrollPane.setHorizontalScrollBar(null);
        PropertiesScrollPane.setMinimumSize(new java.awt.Dimension(0, 0));
        PropertiesScrollPane.setPreferredSize(new java.awt.Dimension(320, 850));

        PropertiesPanel.setMaximumSize(new java.awt.Dimension(320, 850));
        PropertiesPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        PropertiesPanel.setPreferredSize(new java.awt.Dimension(320, 850));

        org.openide.awt.Mnemonics.setLocalizedText(CommentaryLabel, org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.CommentaryLabel.text")); // NOI18N

        CommentaryScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        CommentaryTextArea.setEditable(false);
        CommentaryTextArea.setColumns(20);
        CommentaryTextArea.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        CommentaryTextArea.setLineWrap(true);
        CommentaryTextArea.setRows(6);
        CommentaryTextArea.setWrapStyleWord(true);
        CommentaryScrollPane.setViewportView(CommentaryTextArea);

        ImagePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ImagePanel.setMaximumSize(new java.awt.Dimension(1000, 280));
        ImagePanel.setMinimumSize(new java.awt.Dimension(280, 280));
        ImagePanel.setPreferredSize(new java.awt.Dimension(280, 280));

        javax.swing.GroupLayout ImagePanelLayout = new javax.swing.GroupLayout(ImagePanel);
        ImagePanel.setLayout(ImagePanelLayout);
        ImagePanelLayout.setHorizontalGroup(
            ImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );
        ImagePanelLayout.setVerticalGroup(
            ImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        CreationYearTextField.setEditable(false);
        CreationYearTextField.setBackground(new java.awt.Color(255, 255, 255));
        CreationYearTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        CreationYearTextField.setText(org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.CreationYearTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(CreationYearLabel, org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.CreationYearLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(DepictsLabel, org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.DepictsLabel.text")); // NOI18N

        DepictsTextField.setEditable(false);
        DepictsTextField.setBackground(new java.awt.Color(255, 255, 255));
        DepictsTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        DepictsTextField.setText(org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.DepictsTextField.text")); // NOI18N
        DepictsTextField.setMaximumSize(new java.awt.Dimension(196, 20));
        DepictsTextField.setMinimumSize(new java.awt.Dimension(196, 20));
        DepictsTextField.setPreferredSize(new java.awt.Dimension(196, 20));

        ConsistsTextField.setEditable(false);
        ConsistsTextField.setBackground(new java.awt.Color(255, 255, 255));
        ConsistsTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ConsistsTextField.setText(org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.ConsistsTextField.text")); // NOI18N
        ConsistsTextField.setMaximumSize(new java.awt.Dimension(196, 20));
        ConsistsTextField.setMinimumSize(new java.awt.Dimension(196, 20));
        ConsistsTextField.setPreferredSize(new java.awt.Dimension(196, 20));

        org.openide.awt.Mnemonics.setLocalizedText(ConsistsLabel, org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.ConsistsLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(TypeLabel, org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.TypeLabel.text")); // NOI18N

        TypeTextField.setEditable(false);
        TypeTextField.setBackground(new java.awt.Color(255, 255, 255));
        TypeTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TypeTextField.setText(org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.TypeTextField.text")); // NOI18N
        TypeTextField.setMaximumSize(new java.awt.Dimension(196, 20));
        TypeTextField.setMinimumSize(new java.awt.Dimension(196, 20));
        TypeTextField.setPreferredSize(new java.awt.Dimension(196, 20));

        org.openide.awt.Mnemonics.setLocalizedText(TechniqueLabel, org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.TechniqueLabel.text")); // NOI18N

        TechniqueTextField.setEditable(false);
        TechniqueTextField.setBackground(new java.awt.Color(255, 255, 255));
        TechniqueTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TechniqueTextField.setText(org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.TechniqueTextField.text")); // NOI18N
        TechniqueTextField.setMaximumSize(new java.awt.Dimension(196, 20));
        TechniqueTextField.setMinimumSize(new java.awt.Dimension(196, 20));
        TechniqueTextField.setPreferredSize(new java.awt.Dimension(196, 20));

        org.openide.awt.Mnemonics.setLocalizedText(IdentifierLabel, org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.IdentifierLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(NameLabel, org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.NameLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(SourceLabel, org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.SourceLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(QueryLabel, org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.QueryLabel.text")); // NOI18N

        IdentifierTextField.setEditable(false);
        IdentifierTextField.setBackground(new java.awt.Color(255, 255, 255));
        IdentifierTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        IdentifierTextField.setText(org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.IdentifierTextField.text")); // NOI18N
        IdentifierTextField.setMaximumSize(new java.awt.Dimension(196, 20));
        IdentifierTextField.setMinimumSize(new java.awt.Dimension(196, 20));
        IdentifierTextField.setPreferredSize(new java.awt.Dimension(196, 20));

        SourceTextField.setEditable(false);
        SourceTextField.setBackground(new java.awt.Color(255, 255, 255));
        SourceTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        SourceTextField.setText(org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.SourceTextField.text")); // NOI18N
        SourceTextField.setMaximumSize(new java.awt.Dimension(196, 20));
        SourceTextField.setMinimumSize(new java.awt.Dimension(196, 20));
        SourceTextField.setPreferredSize(new java.awt.Dimension(196, 20));

        QueryTextField.setEditable(false);
        QueryTextField.setBackground(new java.awt.Color(255, 255, 255));
        QueryTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        QueryTextField.setText(org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.QueryTextField.text")); // NOI18N
        QueryTextField.setMaximumSize(new java.awt.Dimension(196, 20));
        QueryTextField.setMinimumSize(new java.awt.Dimension(196, 20));
        QueryTextField.setPreferredSize(new java.awt.Dimension(196, 20));

        org.openide.awt.Mnemonics.setLocalizedText(DescriptionLabel, org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.DescriptionLabel.text")); // NOI18N

        DescriptionScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        DescriptionTextArea.setEditable(false);
        DescriptionTextArea.setColumns(20);
        DescriptionTextArea.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        DescriptionTextArea.setLineWrap(true);
        DescriptionTextArea.setRows(6);
        DescriptionTextArea.setWrapStyleWord(true);
        DescriptionScrollPane.setViewportView(DescriptionTextArea);

        NameTextField.setEditable(false);
        NameTextField.setBackground(new java.awt.Color(255, 255, 255));
        NameTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        NameTextField.setText(org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.NameTextField.text")); // NOI18N
        NameTextField.setMaximumSize(new java.awt.Dimension(196, 20));
        NameTextField.setMinimumSize(new java.awt.Dimension(196, 20));
        NameTextField.setPreferredSize(new java.awt.Dimension(196, 20));

        org.openide.awt.Mnemonics.setLocalizedText(CreatorLabel, org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.CreatorLabel.text")); // NOI18N

        CreatorTextField.setEditable(false);
        CreatorTextField.setBackground(new java.awt.Color(255, 255, 255));
        CreatorTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        CreatorTextField.setText(org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.CreatorTextField.text_1")); // NOI18N
        CreatorTextField.setMaximumSize(new java.awt.Dimension(196, 20));
        CreatorTextField.setMinimumSize(new java.awt.Dimension(196, 20));
        CreatorTextField.setPreferredSize(new java.awt.Dimension(196, 20));

        org.openide.awt.Mnemonics.setLocalizedText(DetailsLabel, org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.DetailsLabel.text")); // NOI18N

        DetailsTextField.setEditable(false);
        DetailsTextField.setBackground(new java.awt.Color(255, 255, 255));
        DetailsTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        DetailsTextField.setText(org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.DetailsTextField.text")); // NOI18N
        DetailsTextField.setMaximumSize(new java.awt.Dimension(196, 20));
        DetailsTextField.setMinimumSize(new java.awt.Dimension(196, 20));
        DetailsTextField.setPreferredSize(new java.awt.Dimension(196, 20));

        javax.swing.GroupLayout PropertiesPanelLayout = new javax.swing.GroupLayout(PropertiesPanel);
        PropertiesPanel.setLayout(PropertiesPanelLayout);
        PropertiesPanelLayout.setHorizontalGroup(
            PropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PropertiesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PropertiesPanelLayout.createSequentialGroup()
                        .addGroup(PropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IdentifierLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SourceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(QueryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CreationYearLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DepictsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ConsistsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TechniqueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DescriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CommentaryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CreatorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DetailsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(DescriptionScrollPane, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TypeTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ConsistsTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DepictsTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(QueryTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SourceTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CreationYearTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TechniqueTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CommentaryScrollPane)
                            .addComponent(IdentifierTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CreatorTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DetailsTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PropertiesPanelLayout.setVerticalGroup(
            PropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PropertiesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreationYearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreationYearTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdentifierLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdentifierTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SourceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SourceTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QueryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QueryTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DepictsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DepictsTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConsistsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConsistsTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TypeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TechniqueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TechniqueTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreatorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreatorTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DetailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DetailsTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PropertiesPanelLayout.createSequentialGroup()
                        .addComponent(DescriptionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(PropertiesPanelLayout.createSequentialGroup()
                        .addComponent(DescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)))
                .addGroup(PropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CommentaryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CommentaryScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        PropertiesScrollPane.setViewportView(PropertiesPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PropertiesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PropertiesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CommentaryLabel;
    private javax.swing.JScrollPane CommentaryScrollPane;
    private javax.swing.JTextArea CommentaryTextArea;
    private javax.swing.JLabel ConsistsLabel;
    private javax.swing.JTextField ConsistsTextField;
    private javax.swing.JLabel CreationYearLabel;
    private javax.swing.JTextField CreationYearTextField;
    private javax.swing.JLabel CreatorLabel;
    private javax.swing.JTextField CreatorTextField;
    private javax.swing.JLabel DepictsLabel;
    private javax.swing.JTextField DepictsTextField;
    private javax.swing.JLabel DescriptionLabel;
    private javax.swing.JScrollPane DescriptionScrollPane;
    private javax.swing.JTextArea DescriptionTextArea;
    private javax.swing.JLabel DetailsLabel;
    private javax.swing.JTextField DetailsTextField;
    private javax.swing.JLabel IdentifierLabel;
    private javax.swing.JTextField IdentifierTextField;
    private javax.swing.JPanel ImagePanel;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JPanel PropertiesPanel;
    private javax.swing.JScrollPane PropertiesScrollPane;
    private javax.swing.JLabel QueryLabel;
    private javax.swing.JTextField QueryTextField;
    private javax.swing.JLabel SourceLabel;
    private javax.swing.JTextField SourceTextField;
    private javax.swing.JLabel TechniqueLabel;
    private javax.swing.JTextField TechniqueTextField;
    private javax.swing.JLabel TypeLabel;
    private javax.swing.JTextField TypeTextField;
    // End of variables declaration//GEN-END:variables
    
    private static final int IMAGE_SIZE = 280;
    
    private Lookup.Result<ManMadeObject> objectResult = null;
    
    /**
     * Called by the constructor.
     */
    private void setup() {
        objectResult = Utilities.actionsGlobalContext().lookupResult(ManMadeObject.class);
        objectResult.addLookupListener(this);
        ImagePanel.setLayout(new BorderLayout());
    }
    
    @Override
    public void componentOpened() {}

    @Override
    public void componentClosed() {
        objectResult.removeLookupListener(this);
    }
    
    @Override
    public void resultChanged(LookupEvent lookupEvent) {
        Collection<? extends ManMadeObject> allEntities = objectResult.allInstances();
        if (allEntities.size() == 1) {
            
            ManMadeObject entity = allEntities.iterator().next();
            
            CreationYearTextField.setText(entity.getTimeSpan().toString());
            IdentifierTextField.setText(entity.getIdentifier());
            NameTextField.setText(entity.getName());
            SourceTextField.setText(entity.getSourceName());
            QueryTextField.setText(entity.getQueryName());
            DepictsTextField.setText(entity.getDepicts());
            ConsistsTextField.setText(entity.getConsists());
            TypeTextField.setText(entity.getType());
            TechniqueTextField.setText(entity.getTechnique());
            CreatorTextField.setText(entity.getCreator());
            DetailsTextField.setText(entity.getObject());
            
            DescriptionTextArea.setText(entity.getDescription());
            DescriptionTextArea.setCaretPosition(0);
            
            CommentaryTextArea.setText(entity.getCuratorial());
            CommentaryTextArea.setCaretPosition(0);
            
            ImagePanel.removeAll();
            BufferedImage thumb = entity.getThumb(IMAGE_SIZE);
            if (thumb != null) {
                JLabel image = new JLabel(new ImageIcon(thumb));
                ImagePanel.add(image, BorderLayout.CENTER);
            }
            ImagePanel.revalidate();
            ImagePanel.repaint();
            
        }
    }
    
    void writeProperties(java.util.Properties p) {
        p.setProperty("version", "1.0");
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
    }
    
}