/*     */ package br.com.arremate.n;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.m.j;
/*     */ import br.com.arremate.m.y;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseMotionAdapter;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.sql.CallableStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.HashMap;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JSeparator;
/*     */ import javax.swing.KeyStroke;
/*     */ import javax.swing.LayoutStyle;
/*     */ 
/*     */ public class i extends JDialog {
/*  27 */   private static final Logger LOG = LoggerFactory.getLogger(i.class); private final Color c; private final Color d; private final Color e; private final j a; private final boolean ap; private JLabel ap; private JLabel aq; private JCheckBox d; private JLabel y; private JLabel ar; private JLabel as;
/*     */   private JLabel at;
/*     */   private JLabel au;
/*     */   private JLabel av;
/*     */   private JLabel aw;
/*     */   private JLabel ax;
/*     */   private JLabel ay;
/*     */   private JLabel az;
/*     */   private JLabel aA;
/*     */   private JLabel n;
/*     */   private JLabel aB;
/*     */   private JLabel aC;
/*     */   
/*     */   public i(j paramj) {
/*  41 */     this(paramj, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JLabel aD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JLabel Y;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JLabel aE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JLabel b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JLabel aF;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JLabel aG;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JLabel aH;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JLabel aI;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JSeparator a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final JLabel aJ;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JLabel aK;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JLabel aL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JLabel aM;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JLabel aN;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JLabel aO;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JLabel aP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JLabel aQ;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JPanel C;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JPanel D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JPanel E;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JLabel aR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JLabel aS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JLabel aT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public i(j paramj, boolean paramBoolean) {
/* 713 */     this.aJ = new JLabel();
/*     */     this.c = y.e();
/*     */     this.d = (JCheckBox)new Color(255, 112, 2);
/*     */     this.e = y.f();
/*     */     this.a = (JSeparator)paramj;
/*     */     this.ap = paramBoolean;
/*     */     k();
/*     */     dy();
/*     */     Y(paramBoolean);
/*     */     dw();
/*     */   }
/*     */   
/*     */   private void dw() {
/*     */     KeyStroke keyStroke = KeyStroke.getKeyStroke(27, 0);
/*     */     byte b = 2;
/*     */     getRootPane().registerKeyboardAction(paramActionEvent -> dispose(), keyStroke, b);
/*     */     pack();
/*     */     setLocationRelativeTo(null);
/*     */   }
/*     */   
/*     */   private void Y(boolean paramBoolean) {
/*     */     this.aM.setIcon(new ImageIcon(getClass().getResource("/img/loading-blue.gif")));
/*     */     this.aP.setText(String.join("", new CharSequence[] { this.a.getOperatingSystem(), ";" }));
/*     */     this.aO.setText(String.join("", new CharSequence[] { this.a.ct(), ";" }));
/*     */     this.aN.setText(String.join("", new CharSequence[] { this.a.cu(), ";" }));
/*     */     this.aL.setText(String.join("", new CharSequence[] { this.a.cv(), ";" }));
/*     */     if (this.a.bE()) {
/*     */       this.ap.setForeground(this.c);
/*     */       this.aP.setForeground(this.c);
/*     */     } else if (this.a.bD()) {
/*     */       this.ap.setForeground((Color)this.d);
/*     */       this.aP.setForeground((Color)this.d);
/*     */     } else {
/*     */       this.ap.setForeground(this.e);
/*     */       this.aP.setForeground(this.e);
/*     */     } 
/*     */     if (this.a.bG()) {
/*     */       this.aO.setForeground(this.c);
/*     */       this.aR.setForeground(this.c);
/*     */     } else if (this.a.bF()) {
/*     */       this.aO.setForeground((Color)this.d);
/*     */       this.aR.setForeground((Color)this.d);
/*     */     } else {
/*     */       this.aO.setForeground(this.e);
/*     */       this.aR.setForeground(this.e);
/*     */     } 
/*     */     if (this.a.bH()) {
/*     */       this.aN.setForeground(this.c);
/*     */       this.aQ.setForeground(this.c);
/*     */     } else if (this.a.bI()) {
/*     */       this.aN.setForeground((Color)this.d);
/*     */       this.aQ.setForeground((Color)this.d);
/*     */     } else {
/*     */       this.aN.setForeground(this.e);
/*     */       this.aQ.setForeground(this.e);
/*     */     } 
/*     */     if (this.a.bJ()) {
/*     */       this.aT.setForeground(this.c);
/*     */       this.aL.setForeground(this.c);
/*     */     } else if (this.a.bK()) {
/*     */       this.aT.setForeground((Color)this.d);
/*     */       this.aL.setForeground((Color)this.d);
/*     */     } else {
/*     */       this.aT.setForeground(this.e);
/*     */       this.aL.setForeground(this.e);
/*     */     } 
/*     */     if (!paramBoolean) {
/*     */       dz();
/*     */     } else {
/*     */       dx();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void dx() {
/*     */     (new Thread(() -> {
/*     */           boolean bool;
/*     */           this.aJ.setEnabled(false);
/*     */           this.aK.setText("Carregando");
/*     */           this.aM.setVisible(true);
/*     */           try {
/*     */             bool = !this.a.b(()) ? true : false;
/*     */           } catch (Exception exception) {
/*     */             bool = true;
/*     */             LOG.warn("Falha ao realizar teste de velocidade da internet", exception);
/*     */           } 
/*     */           if (bool) {
/*     */             JOptionPane.showMessageDialog(null, "Erro ao executar teste de velocidade", "Erro", 0);
/*     */             this.aK.setText("Falha ao realizar teste de velocidade da internet");
/*     */           } 
/*     */           this.aJ.setEnabled(true);
/*     */         })).start();
/*     */   }
/*     */   
/*     */   private void dy() {
/*     */     try(Statement null = a.a().createStatement(); ResultSet null = statement.executeQuery("SELECT carnaomostarinformacoeshardware FROM tbconfiguracaoarremate")) {
/*     */       if (resultSet.next())
/*     */         this.d.setSelected(resultSet.getBoolean(1)); 
/*     */     } catch (SQLException sQLException) {
/*     */       LOG.warn("Erro ao executar SELECT", sQLException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void dz() {
/*     */     this.aK.setText(String.join("", new CharSequence[] { this.a.cw(), "." }));
/*     */     this.aM.setVisible(false);
/*     */     if (this.a.bL()) {
/*     */       this.aK.setForeground(this.c);
/*     */       this.aq.setForeground(this.c);
/*     */     } else if (this.a.bM()) {
/*     */       this.aK.setForeground((Color)this.d);
/*     */       this.aq.setForeground((Color)this.d);
/*     */     } else {
/*     */       this.aK.setForeground(this.e);
/*     */       this.aq.setForeground(this.e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void k() {
/*     */     this.E = new JPanel();
/*     */     this.aI = new JLabel();
/*     */     this.Y = new JLabel();
/*     */     this.aE = new JLabel();
/*     */     this.n = new JLabel();
/*     */     this.at = new JLabel();
/*     */     this.au = new JLabel();
/*     */     this.av = new JLabel();
/*     */     this.aw = new JLabel();
/*     */     this.y = new JLabel();
/*     */     this.b = new JLabel();
/*     */     this.aA = new JLabel();
/*     */     this.aB = new JLabel();
/*     */     this.D = new JPanel();
/*     */     this.aF = new JLabel();
/*     */     this.aG = new JLabel();
/*     */     this.aH = new JLabel();
/*     */     this.ax = new JLabel();
/*     */     this.ay = new JLabel();
/*     */     this.az = new JLabel();
/*     */     this.as = new JLabel();
/*     */     this.ar = new JLabel();
/*     */     this.aC = new JLabel();
/*     */     this.aD = new JLabel();
/*     */     this.C = new JPanel();
/*     */     this.aR = new JLabel();
/*     */     this.aQ = new JLabel();
/*     */     this.aq = new JLabel();
/*     */     this.aO = new JLabel();
/*     */     this.aN = new JLabel();
/*     */     this.aK = new JLabel();
/*     */     this.ap = new JLabel();
/*     */     this.aP = new JLabel();
/*     */     this.aT = new JLabel();
/*     */     this.aL = new JLabel();
/*     */     this.aM = new JLabel();
/*     */     this.aS = new JLabel();
/*     */     this.a = new JSeparator();
/*     */     this.d = new JCheckBox();
/*     */     setDefaultCloseOperation(2);
/*     */     setTitle("Effecti - Disputar");
/*     */     setIconImage((new ImageIcon(getClass().getResource("/img/icone.jpg"))).getImage());
/*     */     setModal(true);
/*     */     setResizable(false);
/*     */     addWindowListener(new WindowAdapter(this) {
/*     */           public void windowClosing(WindowEvent param1WindowEvent) {
/*     */             i.a(this.a, param1WindowEvent);
/*     */           }
/*     */         });
/*     */     this.E.setBorder(BorderFactory.createTitledBorder(null, "Configuração ideal para este sistema", 0, 0, new Font("Tahoma", 1, 20), new Color(0, 102, 0)));
/*     */     this.aI.setFont(new Font("Tahoma", 1, 17));
/*     */     this.aI.setForeground(this.c);
/*     */     this.aI.setText("Memória:");
/*     */     this.Y.setFont(new Font("Tahoma", 1, 17));
/*     */     this.Y.setForeground(this.c);
/*     */     this.Y.setText("Internet:");
/*     */     this.aE.setFont(new Font("Tahoma", 1, 17));
/*     */     this.aE.setForeground(this.c);
/*     */     this.aE.setText("HD:");
/*     */     this.n.setFont(new Font("Tahoma", 1, 17));
/*     */     this.n.setForeground(this.c);
/*     */     this.n.setText("Processador:");
/*     */     this.at.setFont(new Font("Tahoma", 0, 17));
/*     */     this.at.setForeground(this.c);
/*     */     this.at.setText("Intel i5 (sétima geração) ou superior;");
/*     */     this.au.setFont(new Font("Tahoma", 0, 17));
/*     */     this.au.setForeground(this.c);
/*     */     this.au.setText("8GiB;");
/*     */     this.av.setFont(new Font("Tahoma", 0, 17));
/*     */     this.av.setForeground(this.c);
/*     */     this.av.setText(" Fibra óptica 10mb;");
/*     */     this.aw.setFont(new Font("Tahoma", 0, 17));
/*     */     this.aw.setForeground(this.c);
/*     */     this.aw.setText(" SSD.");
/*     */     this.y.setFont(new Font("Tahoma", 1, 17));
/*     */     this.y.setForeground(this.c);
/*     */     this.y.setText("Sistema Operacional:");
/*     */     this.b.setFont(new Font("Tahoma", 0, 17));
/*     */     this.b.setForeground(this.c);
/*     */     this.b.setText("Windows 10 ou MacOS;");
/*     */     this.aA.setFont(new Font("Tahoma", 1, 17));
/*     */     this.aA.setForeground(this.c);
/*     */     this.aA.setText("Versão do Java:");
/*     */     this.aB.setFont(new Font("Tahoma", 0, 17));
/*     */     this.aB.setForeground(this.c);
/*     */     this.aB.setText("1.8.0_212;");
/*     */     GroupLayout groupLayout1 = new GroupLayout(this.E);
/*     */     this.E.setLayout(groupLayout1);
/*     */     groupLayout1.setHorizontalGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout1.createSequentialGroup().addContainerGap().addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout1.createSequentialGroup().addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout1.createSequentialGroup().addComponent(this.Y).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.av)).addGroup(groupLayout1.createSequentialGroup().addComponent(this.y).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.b))).addContainerGap(-1, 32767)).addGroup(groupLayout1.createSequentialGroup().addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout1.createSequentialGroup().addComponent(this.n).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.at)).addGroup(groupLayout1.createSequentialGroup().addComponent(this.aI).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.au)).addGroup(groupLayout1.createSequentialGroup().addComponent(this.aA).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.aB)).addGroup(groupLayout1.createSequentialGroup().addComponent(this.aE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.aw))).addGap(0, 0, 32767)))));
/*     */     groupLayout1.setVerticalGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout1.createSequentialGroup().addContainerGap().addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.y).addComponent(this.b)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.at).addComponent(this.n)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.aI).addComponent(this.au)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.aA).addComponent(this.aB)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Y).addComponent(this.av)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.aE).addComponent(this.aw))));
/*     */     this.D.setBorder(BorderFactory.createTitledBorder(null, "Configuração mínima para este sistema", 0, 0, new Font("Tahoma", 1, 20), new Color(255, 78, 1)));
/*     */     this.aF.setFont(new Font("Tahoma", 1, 17));
/*     */     this.aF.setForeground((Color)this.d);
/*     */     this.aF.setText("Processador:");
/*     */     this.aG.setFont(new Font("Tahoma", 1, 17));
/*     */     this.aG.setForeground((Color)this.d);
/*     */     this.aG.setText("Memória:");
/*     */     this.aH.setFont(new Font("Tahoma", 1, 17));
/*     */     this.aH.setForeground((Color)this.d);
/*     */     this.aH.setText("Internet:");
/*     */     this.ax.setFont(new Font("Tahoma", 0, 17));
/*     */     this.ax.setForeground((Color)this.d);
/*     */     this.ax.setText("Intel i5 (quinta ou sexta geração);");
/*     */     this.ay.setFont(new Font("Tahoma", 0, 17));
/*     */     this.ay.setForeground((Color)this.d);
/*     */     this.ay.setText("4GiB;");
/*     */     this.az.setFont(new Font("Tahoma", 0, 17));
/*     */     this.az.setForeground((Color)this.d);
/*     */     this.az.setText(" Fibra óptica 5mb.");
/*     */     this.as.setFont(new Font("Tahoma", 0, 17));
/*     */     this.as.setForeground((Color)this.d);
/*     */     this.as.setText("Windows 8 ou MacOSx;");
/*     */     this.ar.setFont(new Font("Tahoma", 1, 17));
/*     */     this.ar.setForeground((Color)this.d);
/*     */     this.ar.setText("Sistema Operacional:");
/*     */     this.aC.setFont(new Font("Tahoma", 1, 17));
/*     */     this.aC.setForeground((Color)this.d);
/*     */     this.aC.setText("Versão do Java:");
/*     */     this.aD.setFont(new Font("Tahoma", 0, 17));
/*     */     this.aD.setForeground((Color)this.d);
/*     */     this.aD.setText("1.8;");
/*     */     GroupLayout groupLayout2 = new GroupLayout(this.D);
/*     */     this.D.setLayout(groupLayout2);
/*     */     groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addContainerGap().addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addComponent(this.ar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.as)).addGroup(groupLayout2.createSequentialGroup().addComponent(this.aF).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.ax)).addGroup(groupLayout2.createSequentialGroup().addComponent(this.aG).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.ay)).addGroup(groupLayout2.createSequentialGroup().addComponent(this.aH).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.az)).addGroup(groupLayout2.createSequentialGroup().addComponent(this.aC).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.aD))).addContainerGap(24, 32767)));
/*     */     groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addContainerGap().addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.ar).addComponent(this.as)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.aF).addComponent(this.ax)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.aG).addComponent(this.ay)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.aC).addComponent(this.aD)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.aH).addComponent(this.az))));
/*     */     this.C.setBorder(BorderFactory.createTitledBorder(null, "Suas Configurações", 0, 0, new Font("Tahoma", 1, 20), new Color(0, 0, 255)));
/*     */     this.C.setMaximumSize(new Dimension(0, 0));
/*     */     this.aR.setFont(new Font("Tahoma", 1, 17));
/*     */     this.aR.setText("Processador:");
/*     */     this.aQ.setFont(new Font("Tahoma", 1, 17));
/*     */     this.aQ.setText("Memória:");
/*     */     this.aq.setFont(new Font("Tahoma", 1, 17));
/*     */     this.aq.setText("Internet:");
/*     */     this.aO.setFont(new Font("Tahoma", 0, 17));
/*     */     this.aO.setText("Não encontrado");
/*     */     this.aN.setFont(new Font("Tahoma", 0, 17));
/*     */     this.aN.setText("Não encontrado");
/*     */     this.aK.setFont(new Font("Tahoma", 0, 17));
/*     */     this.aK.setText("Não encontrado");
/*     */     this.ap.setFont(new Font("Tahoma", 1, 17));
/*     */     this.ap.setText("Sistema Operacional:");
/*     */     this.aP.setFont(new Font("Tahoma", 0, 17));
/*     */     this.aP.setText("Não encontrado");
/*     */     this.aT.setFont(new Font("Tahoma", 1, 17));
/*     */     this.aT.setText("Versão do Java:");
/*     */     this.aL.setFont(new Font("Tahoma", 0, 17));
/*     */     this.aL.setText("Não encontrado");
/*     */     this.aJ.setFont(new Font("Tahoma", 0, 17));
/*     */     this.aJ.setIcon(new ImageIcon(getClass().getResource("/img/arrow_circle.png")));
/*     */     this.aJ.setText("Executar o teste novamente");
/*     */     this.aJ.addMouseMotionListener(new MouseMotionAdapter(this) {
/*     */           public void mouseMoved(MouseEvent param1MouseEvent) {
/*     */             i.a(this.a, param1MouseEvent);
/*     */           }
/*     */         });
/*     */     this.aJ.addMouseListener(new MouseAdapter(this) {
/*     */           public void mouseClicked(MouseEvent param1MouseEvent) {
/*     */             i.b(this.a, param1MouseEvent);
/*     */           }
/*     */           
/*     */           public void mouseExited(MouseEvent param1MouseEvent) {
/*     */             i.c(this.a, param1MouseEvent);
/*     */           }
/*     */         });
/*     */     GroupLayout groupLayout3 = new GroupLayout(this.C);
/*     */     this.C.setLayout(groupLayout3);
/*     */     groupLayout3.setHorizontalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addContainerGap().addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addComponent(this.aq).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.aK).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.aM, -2, 15, -2)).addGroup(groupLayout3.createSequentialGroup().addComponent(this.ap).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.aP)).addGroup(groupLayout3.createSequentialGroup().addComponent(this.aR).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.aO)).addGroup(groupLayout3.createSequentialGroup().addComponent(this.aQ).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.aN)).addGroup(groupLayout3.createSequentialGroup().addComponent(this.aT).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.aL)).addComponent(this.aJ)).addContainerGap()));
/*     */     groupLayout3.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addContainerGap().addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.ap).addComponent(this.aP)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.aR).addComponent(this.aO)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.aQ).addComponent(this.aN)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.aL).addComponent(this.aT)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.aq).addComponent(this.aK)).addComponent(this.aM, -2, 21, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.aJ)));
/*     */     this.aS.setFont(new Font("Tahoma", 1, 22));
/*     */     this.aS.setHorizontalAlignment(0);
/*     */     this.aS.setText("Sugestões Computacionais para Melhor Desempenho do Disputar");
/*     */     this.d.setFont(new Font("Tahoma", 0, 12));
/*     */     this.d.setText("Não executar ao iniciar o Disputar");
/*     */     this.d.setFocusPainted(false);
/*     */     GroupLayout groupLayout4 = new GroupLayout(getContentPane());
/*     */     getContentPane().setLayout(groupLayout4);
/*     */     groupLayout4.setHorizontalGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.a, GroupLayout.Alignment.TRAILING).addGroup(groupLayout4.createSequentialGroup().addContainerGap().addGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.aS, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(groupLayout4.createSequentialGroup().addComponent(this.E, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.C, -2, -1, -2).addGap(0, 0, 32767)).addGroup(groupLayout4.createSequentialGroup().addComponent(this.D, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.d).addContainerGap()))));
/*     */     groupLayout4.setVerticalGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout4.createSequentialGroup().addContainerGap().addComponent(this.aS).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.a, -2, 10, -2).addGap(18, 18, 18).addGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.E, -1, -1, 32767).addComponent(this.C, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.D, -2, -1, -2).addComponent(this.d)).addContainerGap(-1, 32767)));
/*     */     pack();
/*     */   }
/*     */   
/*     */   private void c(WindowEvent paramWindowEvent) {
/*     */     try(Statement null = a.a().createStatement(); ResultSet null = statement.executeQuery("SELECT carnaomostarinformacoeshardware FROM tbconfiguracaoarremate")) {
/*     */       if (resultSet.next()) {
/*     */         if (resultSet.getBoolean(1) != this.d.isSelected()) {
/*     */           String str = "UPDATE tbconfiguracaoarremate SET carnaomostarinformacoeshardware = ?";
/*     */           try (CallableStatement null = a.a().prepareCall(str)) {
/*     */             callableStatement.setBoolean(1, this.d.isSelected());
/*     */             callableStatement.executeUpdate();
/*     */           } 
/*     */         } 
/*     */       } else {
/*     */         String str = "INSERT INTO tbconfiguracaoarremate(carnaomostarinformacoeshardware) VALUES (?)";
/*     */         try (CallableStatement null = a.a().prepareCall(str)) {
/*     */           callableStatement.setBoolean(1, this.d.isSelected());
/*     */           callableStatement.execute();
/*     */         } 
/*     */       } 
/*     */     } catch (SQLException sQLException) {
/*     */       LOG.warn("Erro ao manipular a base", sQLException);
/*     */     } finally {
/*     */       if (this.ap != null)
/*     */         j.a().a((j)this.a, true); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void g(MouseEvent paramMouseEvent) {
/*     */     setCursor(new Cursor(12));
/*     */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     hashMap.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
/*     */     Font font = this.aJ.getFont().deriveFont((Map)hashMap);
/*     */     this.aJ.setFont(font);
/*     */   }
/*     */   
/*     */   private void h(MouseEvent paramMouseEvent) {
/*     */     setCursor(new Cursor(0));
/*     */     Font font = new Font(this.aJ.getFont().getName(), 0, this.aJ.getFont().getSize());
/*     */     this.aJ.setFont(font);
/*     */   }
/*     */   
/*     */   private void i(MouseEvent paramMouseEvent) {
/*     */     synchronized (this.aJ) {
/*     */       if (!this.aJ.isEnabled())
/*     */         return; 
/*     */     } 
/*     */     dx();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\n\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */