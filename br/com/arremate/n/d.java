/*      */ package br.com.arremate.n;
/*      */ import br.com.arremate.a.g;
/*      */ import br.com.arremate.f.o;
/*      */ import br.com.arremate.f.p;
/*      */ import br.com.arremate.j.i;
/*      */ import br.com.arremate.l.n;
/*      */ import br.com.arremate.l.p.j;
/*      */ import br.com.arremate.m.g;
/*      */ import br.com.arremate.m.k;
/*      */ import br.com.arremate.m.l;
/*      */ import br.com.arremate.m.u;
/*      */ import br.com.arremate.m.y;
/*      */ import java.awt.Component;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.ItemEvent;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.Statement;
/*      */ import java.util.ArrayList;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JFormattedTextField;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JPasswordField;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.KeyStroke;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.RowSorter;
/*      */ import javax.swing.SortOrder;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.table.TableCellRenderer;
/*      */ import javax.swing.table.TableModel;
/*      */ import javax.swing.table.TableRowSorter;
/*      */ import javax.swing.text.DefaultFormatterFactory;
/*      */ import javax.swing.text.MaskFormatter;
/*      */ import org.apache.commons.lang3.StringUtils;
/*      */ 
/*      */ public class d extends JDialog {
/*   50 */   private static final Logger a = LoggerFactory.getLogger(d.class); public static final int cX = 0; public static final int cB = 1; public static final int ce = 2; public static final int cD = 3; public static final int cY = 4; public static final int cZ = 5; public static final int da = 6;
/*      */   public static final int db = 7;
/*      */   private JDialog a;
/*      */   private a a;
/*      */   private br.com.arremate.l.d c;
/*      */   private JLabel X;
/*      */   private br.com.arremate.c.a c;
/*      */   private JComboBox<String> k;
/*      */   private JButton j;
/*      */   private JButton k;
/*      */   private JButton l;
/*   61 */   private JPasswordField a = null; private JCheckBox d; private JFormattedTextField e; private JLabel n; private JLabel Y; private JLabel Z; private JLabel aa; private JLabel O; private JLabel ab; private JLabel ac; private JLabel Q; private JPanel l; private JPanel m; private JPanel n; private JScrollPane a;
/*      */   private JTabbedPane b;
/*      */   private JTable f;
/*      */   private JTextField h;
/*      */   private JLabel ad;
/*      */   private br.com.arremate.c.a.d b;
/*      */   private JLabel ae;
/*      */   private JTextField i;
/*      */   
/*      */   public d(JDialog paramJDialog) {
/*   71 */     super(paramJDialog);
/*   72 */     this.a = (JPasswordField)paramJDialog;
/*   73 */     initialize();
/*   74 */     this.i.setSize(this.e.getSize());
/*   75 */     this.i.setPreferredSize(this.e.getSize());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public d() {
/*   83 */     initialize();
/*   84 */     this.i.setSize(this.e.getSize());
/*   85 */     this.i.setPreferredSize(this.e.getSize());
/*      */   }
/*      */   
/*      */   private void initialize() {
/*   89 */     k();
/*   90 */     l();
/*   91 */     dj();
/*   92 */     dk();
/*      */     
/*   94 */     dl();
/*   95 */     do();
/*   96 */     di();
/*   97 */     setLocationRelativeTo(this.a);
/*      */   }
/*      */   
/*      */   private void l() {
/*  101 */     KeyStroke keyStroke = KeyStroke.getKeyStroke(27, 0);
/*  102 */     byte b = 2;
/*  103 */     getRootPane().registerKeyboardAction(paramActionEvent -> dispose(), keyStroke, b);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void k() {
/*  114 */     this.d = new JCheckBox();
/*  115 */     this.b = (br.com.arremate.c.a.d)new JTabbedPane();
/*  116 */     this.l = new JPanel();
/*  117 */     this.ad = new JLabel();
/*  118 */     this.aa = new JLabel();
/*  119 */     this.h = new JTextField();
/*  120 */     this.a = new JPasswordField();
/*  121 */     this.ab = new JLabel();
/*  122 */     this.l = (JPanel)new JButton();
/*  123 */     this.a = (JPasswordField)new JScrollPane();
/*  124 */     this.f = new JTable();
/*  125 */     this.O = new JLabel();
/*  126 */     this.c = new br.com.arremate.c.a();
/*  127 */     this.n = (JPanel)new JLabel();
/*  128 */     this.k = (JButton)new JComboBox();
/*  129 */     this.Z = new JLabel();
/*  130 */     this.ac = new JLabel();
/*  131 */     this.e = new JFormattedTextField();
/*  132 */     this.k = new JButton();
/*  133 */     this.Y = new JLabel();
/*  134 */     this.ae = new JLabel();
/*  135 */     this.i = new JTextField();
/*  136 */     this.X = new JLabel();
/*  137 */     this.Q = new JLabel();
/*  138 */     this.m = new JPanel();
/*  139 */     this.b = new br.com.arremate.c.a.d();
/*  140 */     this.n = new JPanel();
/*  141 */     this.j = new JButton();
/*      */     
/*  143 */     this.d.setText("jCheckBox1");
/*      */     
/*  145 */     setDefaultCloseOperation(2);
/*  146 */     setTitle("Effecti - Disputar");
/*  147 */     setIconImage((new ImageIcon(getClass().getResource("/img/icone.jpg"))).getImage());
/*  148 */     setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
/*  149 */     setResizable(false);
/*      */     
/*  151 */     this.ad.setText("Informe aqui os dados de acesso da empresa no portal ComprasNet");
/*      */     
/*  153 */     this.aa.setText("Login:");
/*      */     
/*  155 */     this.h.setPreferredSize(new Dimension(6, 25));
/*      */     
/*  157 */     this.a.setPreferredSize(new Dimension(6, 25));
/*  158 */     this.a.addKeyListener(new KeyAdapter(this) {
/*      */           public void keyPressed(KeyEvent param1KeyEvent) {
/*  160 */             d.a(this.a, param1KeyEvent);
/*      */           }
/*      */         });
/*      */     
/*  164 */     this.ab.setText("Senha:");
/*      */     
/*  166 */     this.l.setIcon(new ImageIcon(getClass().getResource("/img/add.png")));
/*  167 */     this.l.setText("Salvar");
/*  168 */     this.l.setMargin(new Insets(2, 10, 2, 10));
/*  169 */     this.l.addActionListener(new ActionListener(this) {
/*      */           public void actionPerformed(ActionEvent param1ActionEvent) {
/*  171 */             d.a(this.a, param1ActionEvent);
/*      */           }
/*      */         });
/*      */     
/*  175 */     this.a.setHorizontalScrollBarPolicy(31);
/*  176 */     this.a.setVerticalScrollBarPolicy(22);
/*      */     
/*  178 */     this.f.setModel(new DefaultTableModel(this, new Object[0][], (Object[])new String[] { "Portal", "CNPJ", "Nome", "Porte", "", "", "porcodigo", "ativo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  186 */           Class[] c = new Class[] { String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Boolean.class };
/*      */ 
/*      */           
/*      */           boolean[] a;
/*      */ 
/*      */ 
/*      */           
/*      */           public Class getColumnClass(int param1Int) {
/*  194 */             return this.c[param1Int];
/*      */           }
/*      */           
/*      */           public boolean isCellEditable(int param1Int1, int param1Int2) {
/*  198 */             return this.a[param1Int2];
/*      */           }
/*      */         });
/*  201 */     this.f.setName("jTableAcesso");
/*  202 */     this.f.getTableHeader().setReorderingAllowed(false);
/*  203 */     this.a.setViewportView(this.f);
/*  204 */     if (this.f.getColumnModel().getColumnCount() > 0) {
/*  205 */       this.f.getColumnModel().getColumn(0).setResizable(false);
/*  206 */       this.f.getColumnModel().getColumn(1).setResizable(false);
/*  207 */       this.f.getColumnModel().getColumn(2).setResizable(false);
/*  208 */       this.f.getColumnModel().getColumn(3).setResizable(false);
/*  209 */       this.f.getColumnModel().getColumn(4).setResizable(false);
/*  210 */       this.f.getColumnModel().getColumn(5).setResizable(false);
/*  211 */       this.f.getColumnModel().getColumn(6).setResizable(false);
/*  212 */       this.f.getColumnModel().getColumn(7).setResizable(false);
/*      */     } 
/*      */     
/*  215 */     this.O.setText("Portal:");
/*      */     
/*  217 */     this.c.addItemListener(new ItemListener(this) {
/*      */           public void itemStateChanged(ItemEvent param1ItemEvent) {
/*  219 */             d.a(this.a, param1ItemEvent);
/*      */           }
/*      */         });
/*      */     
/*  223 */     this.n.setFont(new Font("Dialog", 1, 10));
/*  224 */     this.n.setForeground(new Color(255, 0, 0));
/*  225 */     this.n.setText(" * As linhas em vermelho indicam acessos não validados");
/*      */     
/*  227 */     this.Z.setText("CNPJ:");
/*      */     
/*  229 */     this.ac.setText("Porte:");
/*      */     
/*      */     try {
/*  232 */       this.e.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##.###.###/####-##")));
/*  233 */     } catch (ParseException parseException) {
/*  234 */       parseException.printStackTrace();
/*      */     } 
/*  236 */     this.e.setMinimumSize(new Dimension(6, 25));
/*  237 */     this.e.addFocusListener(new FocusAdapter(this) {
/*      */           public void focusGained(FocusEvent param1FocusEvent) {
/*  239 */             d.a(this.a, param1FocusEvent);
/*      */           }
/*      */         });
/*      */     
/*  243 */     this.k.setIcon(new ImageIcon(getClass().getResource("/img/add_file.png")));
/*  244 */     this.k.setText("Importar Certificado");
/*  245 */     this.k.setMargin(new Insets(2, 10, 2, 10));
/*  246 */     this.k.addActionListener(new ActionListener(this) {
/*      */           public void actionPerformed(ActionEvent param1ActionEvent) {
/*  248 */             d.b(this.a, param1ActionEvent);
/*      */           }
/*      */         });
/*      */     
/*  252 */     this.Y.setFont(new Font("Dialog", 1, 10));
/*  253 */     this.Y.setForeground(y.e());
/*  254 */     this.Y.setText(" * As linhas em verde indicam acessos que utilizam certificado digital");
/*      */     
/*  256 */     this.ae.setText("Perfil:");
/*      */     
/*  258 */     this.i.setPreferredSize(new Dimension(6, 25));
/*      */     
/*  260 */     this.X.setForeground(y.e());
/*  261 */     this.X.setText("(Login com Certificado)");
/*  262 */     this.X.setPreferredSize(new Dimension(29, 14));
/*      */     
/*  264 */     this.Q.setForeground(new Color(0, 0, 255));
/*  265 */     this.Q.setText("Melhore sua conexão com o Portal ComprasNet ao configurar seu acesso usando um certificado digital.");
/*  266 */     this.Q.setCursor(new Cursor(12));
/*  267 */     this.Q.addMouseListener(new MouseAdapter(this) {
/*      */           public void mouseClicked(MouseEvent param1MouseEvent) {
/*  269 */             d.a(this.a, param1MouseEvent);
/*      */           }
/*      */         });
/*      */     
/*  273 */     GroupLayout groupLayout1 = new GroupLayout(this.l);
/*  274 */     this.l.setLayout(groupLayout1);
/*  275 */     groupLayout1.setHorizontalGroup(groupLayout1
/*  276 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  277 */         .addGroup(groupLayout1.createSequentialGroup()
/*  278 */           .addComponent(this.a, -2, 715, -2)
/*  279 */           .addGap(0, 0, 32767))
/*  280 */         .addGroup(groupLayout1.createSequentialGroup()
/*  281 */           .addContainerGap()
/*  282 */           .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  283 */             .addGroup(groupLayout1.createSequentialGroup()
/*  284 */               .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  285 */                 .addComponent(this.i, -1, 64, 32767)
/*  286 */                 .addComponent(this.ae))
/*  287 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  288 */               .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  289 */                 .addComponent(this.Z)
/*  290 */                 .addComponent(this.e, -2, 130, -2))
/*  291 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  292 */               .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  293 */                 .addComponent(this.aa)
/*  294 */                 .addComponent(this.h, -2, 150, -2))
/*  295 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  296 */               .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  297 */                 .addComponent(this.ab)
/*  298 */                 .addComponent(this.a, -2, 150, -2))
/*  299 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  300 */               .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  301 */                 .addComponent(this.ac)
/*  302 */                 .addGroup(groupLayout1.createSequentialGroup()
/*  303 */                   .addComponent(this.k, -2, 100, -2)
/*  304 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  305 */                   .addComponent(this.l))))
/*  306 */             .addGroup(groupLayout1.createSequentialGroup()
/*  307 */               .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  308 */                 .addComponent(this.Y)
/*  309 */                 .addComponent(this.n)
/*  310 */                 .addGroup(groupLayout1.createSequentialGroup()
/*  311 */                   .addComponent(this.O)
/*  312 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  313 */                   .addComponent((Component)this.c, -2, 220, -2)
/*  314 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  315 */                   .addComponent(this.k))
/*  316 */                 .addGroup(groupLayout1.createSequentialGroup()
/*  317 */                   .addComponent(this.ad)
/*  318 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  319 */                   .addComponent(this.X, -2, 137, -2))
/*  320 */                 .addComponent(this.Q))
/*  321 */               .addGap(0, 0, 32767)))
/*  322 */           .addContainerGap()));
/*      */     
/*  324 */     groupLayout1.setVerticalGroup(groupLayout1
/*  325 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  326 */         .addGroup(groupLayout1.createSequentialGroup()
/*  327 */           .addContainerGap()
/*  328 */           .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  329 */             .addComponent(this.O)
/*  330 */             .addComponent((Component)this.c, -2, 23, -2)
/*  331 */             .addComponent(this.k, -2, 25, -2))
/*  332 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  333 */           .addComponent(this.Q)
/*  334 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  335 */           .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  336 */             .addComponent(this.ad)
/*  337 */             .addComponent(this.X, -2, -1, -2))
/*  338 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  339 */           .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  340 */             .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  341 */               .addGroup(groupLayout1.createSequentialGroup()
/*  342 */                 .addComponent(this.Z)
/*  343 */                 .addGap(1, 1, 1)
/*  344 */                 .addComponent(this.e, -2, 25, -2))
/*  345 */               .addGroup(groupLayout1.createSequentialGroup()
/*  346 */                 .addComponent(this.ab)
/*  347 */                 .addGap(1, 1, 1)
/*  348 */                 .addComponent(this.a, -2, 25, -2))
/*  349 */               .addGroup(groupLayout1.createSequentialGroup()
/*  350 */                 .addComponent(this.aa)
/*  351 */                 .addGap(1, 1, 1)
/*  352 */                 .addComponent(this.h, -2, 25, -2))
/*  353 */               .addGroup(groupLayout1.createSequentialGroup()
/*  354 */                 .addComponent(this.ac)
/*  355 */                 .addGap(1, 1, 1)
/*  356 */                 .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  357 */                   .addComponent(this.k, -2, 25, -2)
/*  358 */                   .addComponent(this.l))))
/*  359 */             .addGroup(groupLayout1.createSequentialGroup()
/*  360 */               .addComponent(this.ae)
/*  361 */               .addGap(1, 1, 1)
/*  362 */               .addComponent(this.i, -1, -1, -2)))
/*  363 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  364 */           .addComponent(this.a, -2, 467, -2)
/*  365 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  366 */           .addComponent(this.n)
/*  367 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  368 */           .addComponent(this.Y)
/*  369 */           .addGap(15, 15, 15)));
/*      */ 
/*      */     
/*  372 */     this.b.addTab("Cadastro de Logins de Acesso aos Portais", this.l);
/*      */     
/*  374 */     this.n.setBorder(BorderFactory.createTitledBorder(""));
/*  375 */     this.n.setPreferredSize(new Dimension(720, 51));
/*      */     
/*  377 */     this.j.setIcon(new ImageIcon(getClass().getResource("/img/save.png")));
/*  378 */     this.j.setText("Gravar");
/*  379 */     this.j.addActionListener(new ActionListener(this) {
/*      */           public void actionPerformed(ActionEvent param1ActionEvent) {
/*  381 */             d.c(this.a, param1ActionEvent);
/*      */           }
/*      */         });
/*      */     
/*  385 */     GroupLayout groupLayout2 = new GroupLayout(this.n);
/*  386 */     this.n.setLayout(groupLayout2);
/*  387 */     groupLayout2.setHorizontalGroup(groupLayout2
/*  388 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  389 */         .addGroup(GroupLayout.Alignment.TRAILING, groupLayout2.createSequentialGroup()
/*  390 */           .addContainerGap(-1, 32767)
/*  391 */           .addComponent(this.j)
/*  392 */           .addContainerGap()));
/*      */     
/*  394 */     groupLayout2.setVerticalGroup(groupLayout2
/*  395 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  396 */         .addGroup(GroupLayout.Alignment.TRAILING, groupLayout2.createSequentialGroup()
/*  397 */           .addContainerGap(19, 32767)
/*  398 */           .addComponent(this.j)
/*  399 */           .addContainerGap()));
/*      */ 
/*      */     
/*  402 */     GroupLayout groupLayout3 = new GroupLayout(this.m);
/*  403 */     this.m.setLayout(groupLayout3);
/*  404 */     groupLayout3.setHorizontalGroup(groupLayout3
/*  405 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  406 */         .addGroup(groupLayout3.createSequentialGroup()
/*  407 */           .addContainerGap()
/*  408 */           .addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  409 */             .addGroup(groupLayout3.createSequentialGroup()
/*  410 */               .addComponent((Component)this.b, -2, -1, -2)
/*  411 */               .addContainerGap(-1, 32767))
/*  412 */             .addGroup(groupLayout3.createSequentialGroup()
/*  413 */               .addComponent(this.n, -1, 708, 32767)
/*  414 */               .addContainerGap()))));
/*      */     
/*  416 */     groupLayout3.setVerticalGroup(groupLayout3
/*  417 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  418 */         .addGroup(groupLayout3.createSequentialGroup()
/*  419 */           .addContainerGap()
/*  420 */           .addComponent((Component)this.b, -2, -1, -2)
/*  421 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, 32767)
/*  422 */           .addComponent(this.n, -2, -1, -2)
/*  423 */           .addContainerGap()));
/*      */ 
/*      */     
/*  426 */     this.b.addTab("Configurações Gerais das Disputas", this.m);
/*      */     
/*  428 */     GroupLayout groupLayout4 = new GroupLayout(getContentPane());
/*  429 */     getContentPane().setLayout(groupLayout4);
/*  430 */     groupLayout4.setHorizontalGroup(groupLayout4
/*  431 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  432 */         .addGroup(groupLayout4.createSequentialGroup()
/*  433 */           .addContainerGap()
/*  434 */           .addComponent((Component)this.b, -2, 720, -2)
/*  435 */           .addContainerGap()));
/*      */     
/*  437 */     groupLayout4.setVerticalGroup(groupLayout4
/*  438 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  439 */         .addGroup(groupLayout4.createSequentialGroup()
/*  440 */           .addContainerGap()
/*  441 */           .addComponent((Component)this.b)
/*  442 */           .addContainerGap()));
/*      */ 
/*      */     
/*  445 */     pack();
/*      */   }
/*      */   
/*      */   private void l(ActionEvent paramActionEvent) {
/*  449 */     dm();
/*      */   }
/*      */   
/*      */   private void c(ItemEvent paramItemEvent) {
/*  453 */     di();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void m(ActionEvent paramActionEvent) {
/*  462 */     n n = this.c.a();
/*      */     
/*  464 */     if (n.a() == o.l) {
/*  465 */       this.a.setText("null");
/*  466 */       this.h.setText("null");
/*      */     } 
/*      */     
/*  469 */     if ((!this.h.getText().isEmpty() && (this.a.getPassword()).length > 0) || this.a != null) {
/*  470 */       br.com.arremate.l.d d1 = new br.com.arremate.l.d(n);
/*  471 */       d1.setUser(this.h.getText());
/*  472 */       d1.setPassword(String.valueOf(this.a.getPassword()));
/*  473 */       if (this.a != null) {
/*  474 */         d1.ab(((a)this.a).fI);
/*  475 */         d1.ac(((a)this.a).password);
/*      */       } 
/*      */       
/*  478 */       i i = c.a(d1, true);
/*  479 */       i.j(true);
/*      */       
/*  481 */       if (!a(i)) {
/*  482 */         i.b();
/*      */         
/*      */         return;
/*      */       } 
/*  486 */       int j = this.k.getSelectedIndex();
/*  487 */       d1.a(p.a(j));
/*  488 */       d1.t(true);
/*      */ 
/*      */       
/*  491 */       br.com.arremate.l.d d2 = g.a(n, d1.x());
/*  492 */       if (d2 != null) {
/*  493 */         if (g.c(d1)) {
/*  494 */           dk();
/*  495 */           j.a().a(d1, n.v(), bY());
/*  496 */           JOptionPane.showMessageDialog(this, "Dados de acesso da empresa " + d1.bv().toUpperCase() + " atualizados com sucesso", "Mensagem", 1);
/*      */         } else {
/*  498 */           JOptionPane.showMessageDialog(this, "Falha ao atualizar dados de acesso para a empresa " + d1.bv().toUpperCase(), "Erro", 0);
/*      */         } 
/*  500 */       } else if (g.a(d1)) {
/*  501 */         dk();
/*  502 */         j.a().a(d1, n.v(), bY());
/*      */       } else {
/*  504 */         JOptionPane.showMessageDialog(this, "Falha ao gravar dados de acesso para a empresa " + d1.bv().toUpperCase(), "Erro", 0);
/*      */       } 
/*      */       
/*  507 */       clearFields();
/*  508 */       dp();
/*      */       
/*  510 */       i.b();
/*      */     }
/*  512 */     else if (this.c != null && !"".equals(this.c.bw()) && this.h
/*  513 */       .getText().isEmpty() && (this.a.getPassword()).length == 0) {
/*  514 */       int i = this.k.getSelectedIndex();
/*  515 */       this.c.a(p.a(i));
/*      */       
/*  517 */       if (g.c((br.com.arremate.l.d)this.c)) {
/*  518 */         dk();
/*  519 */         j.a().a((br.com.arremate.l.d)this.c, n.v(), bY());
/*  520 */         JOptionPane.showMessageDialog(this, "Dados de acesso da empresa " + this.c.bv().toUpperCase() + " atualizados com sucesso", "Mensagem", 1);
/*      */       } else {
/*  522 */         JOptionPane.showMessageDialog(this, "Falha ao atualizar o porte da empresa " + this.c.bv().toUpperCase(), "Erro", 0);
/*      */       } 
/*      */     } else {
/*  525 */       JOptionPane.showMessageDialog(this, "Para cadastrar um acesso é necessário informar seu login e senha no portal " + this.c.a().K(), "Erro", 0);
/*      */     } 
/*      */   }
/*      */   
/*      */   private boolean bY() {
/*  530 */     return (this.a != null);
/*      */   }
/*      */   
/*      */   private void clearFields() {
/*  534 */     this.e.setText("");
/*  535 */     this.h.setText("");
/*  536 */     this.a.setText("");
/*  537 */     this.i.setText("");
/*      */   }
/*      */   
/*      */   private void c(KeyEvent paramKeyEvent) {
/*  541 */     if (paramKeyEvent.getKeyCode() == 10) {
/*  542 */       m((ActionEvent)null);
/*      */     }
/*      */   }
/*      */   
/*      */   private void g(FocusEvent paramFocusEvent) {
/*  547 */     if (this.e.getText().length() <= 4) {
/*  548 */       this.e.setCaretPosition(0);
/*      */     }
/*      */   }
/*      */   
/*      */   private void n(ActionEvent paramActionEvent) {
/*  553 */     if (this.a == null) {
/*  554 */       e e = new e(this);
/*  555 */       e.setVisible(true);
/*      */     } else {
/*  557 */       dp();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void d(MouseEvent paramMouseEvent) {
/*  562 */     y.l(y.j.getUrl()); } private boolean a(i parami) {
/*      */     String str1;
/*      */     int j;
/*      */     String str2;
/*  566 */     n n = parami.a().b();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  571 */     switch (null.g[n.a().ordinal()]) {
/*      */       case 1:
/*  573 */         str2 = y.V(this.e.getText());
/*      */         
/*  575 */         if (str2.length() != 11) {
/*  576 */           JOptionPane.showMessageDialog(null, "Para cadastrar um acesso é necessário informar um CPF válido", "Erro", 0);
/*  577 */           return false;
/*      */         } 
/*  579 */         parami.a().w(Long.parseLong(str2));
/*  580 */         str2 = null;
/*      */       case 2:
/*      */       case 3:
/*      */       case 4:
/*  584 */         parami.a().ae(this.i.getText());
/*      */       case 5:
/*      */       case 6:
/*      */       case 7:
/*      */       case 8:
/*      */       case 9:
/*      */       case 10:
/*      */       case 11:
/*  592 */         j = parami.z();
/*      */         
/*  594 */         if (j != 1) {
/*      */           String str;
/*  596 */           if (parami.getMessage() != null && !parami.getMessage().isEmpty()) {
/*  597 */             str = parami.getMessage();
/*      */           } else {
/*  599 */             str = a(j, n);
/*      */           } 
/*      */           
/*  602 */           JOptionPane.showMessageDialog(this, str, "Erro", 0);
/*  603 */           return false;
/*      */         } 
/*      */         
/*  606 */         return k.n(g.a().e(parami.av()));
/*      */       case 12:
/*      */       case 13:
/*  609 */         str1 = y.V(this.e.getText());
/*  610 */         if (str1.length() != 14) {
/*  611 */           JOptionPane.showMessageDialog(this, "Para cadastrar um acesso é necessário informar um CNPJ válido", "Erro", 0);
/*  612 */           return false;
/*      */         } 
/*      */         
/*  615 */         parami.a().setUser(parami.getUser().toUpperCase());
/*  616 */         j = parami.z();
/*      */         
/*  618 */         if (j != 1 || parami.ay().isEmpty()) {
/*  619 */           String str = a(j, n);
/*  620 */           JOptionPane.showMessageDialog(this, str, "Erro", 0);
/*  621 */           return false;
/*      */         } 
/*      */ 
/*      */         
/*  625 */         if (k.n(g.a().c(str1, parami.ay()))) {
/*  626 */           parami.D(str1);
/*  627 */           return true;
/*      */         } 
/*  629 */         return false;
/*      */       case 14:
/*  631 */         parami.a().u(true);
/*      */       case 15:
/*      */       case 16:
/*      */       case 17:
/*      */       case 18:
/*  636 */         return b(parami);
/*      */       case 19:
/*  638 */         parami.z();
/*  639 */         return true;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  644 */     return false;
/*      */   }
/*      */   
/*      */   private String a(int paramInt, n paramn) {
/*  648 */     if (paramInt == 2) {
/*  649 */       return String.format("Dados de acesso incorretos para acessar o Portal %s", new Object[] { paramn.K() });
/*      */     }
/*      */     
/*  652 */     return String.format("Falha ao realizar o login no Portal %s", new Object[] { paramn.K() });
/*      */   }
/*      */   
/*      */   private boolean b(i parami) {
/*  656 */     String str1 = y.V(this.e.getText());
/*  657 */     if (str1.length() != 14) {
/*  658 */       JOptionPane.showMessageDialog(this, "Para cadastrar um acesso é necessário informar um CNPJ válido", "Erro", 0);
/*  659 */       return false;
/*      */     } 
/*      */ 
/*      */     
/*  663 */     if (!k.n(g.a().e(str1))) {
/*  664 */       return false;
/*      */     }
/*      */     
/*  667 */     parami.D(str1);
/*  668 */     int j = parami.z();
/*  669 */     if (j == 1) {
/*  670 */       return true;
/*      */     }
/*      */     
/*  673 */     String str2 = parami.getMessage();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  683 */     JOptionPane.showMessageDialog(this, str2, "Erro", 0);
/*  684 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void di() {
/*  697 */     n n = this.c.a();
/*  698 */     this.ad.setText("Informe aqui os dados de acesso da empresa no portal " + n.K());
/*      */     
/*  700 */     boolean bool1 = bZ();
/*  701 */     boolean bool2 = ca();
/*      */ 
/*      */     
/*  704 */     boolean bool = (n.a() == o.a || n.a() == o.k) ? true : false;
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/*  709 */       if (bool1) {
/*  710 */         this.e.setValue((Object)null);
/*      */         
/*  712 */         if (n.a() == o.e) {
/*  713 */           this.Z.setText("CPF:");
/*  714 */           this.e.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
/*      */         } else {
/*  716 */           this.Z.setText("CNPJ:");
/*  717 */           this.e.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##.###.###/####-##")));
/*      */         } 
/*      */       } 
/*  720 */     } catch (Exception exception) {}
/*      */ 
/*      */     
/*  723 */     this.e.setText("");
/*  724 */     this.e.setVisible(bool1);
/*  725 */     this.Z.setVisible(bool1);
/*  726 */     this.k.setVisible(bool);
/*  727 */     this.Q.setVisible(false);
/*      */     
/*  729 */     this.ae.setVisible(bool2);
/*  730 */     this.i.setVisible(bool2);
/*      */     
/*  732 */     if (bool1) {
/*  733 */       this.e.requestFocus();
/*  734 */     } else if (bool2) {
/*  735 */       this.i.requestFocus();
/*      */     } else {
/*  737 */       this.h.requestFocus();
/*      */     } 
/*      */     
/*  740 */     this.ab.setVisible(cb());
/*  741 */     this.a.setVisible(cb());
/*  742 */     this.aa.setVisible(cb());
/*  743 */     this.h.setVisible(cb());
/*  744 */     this.ae.setText(cB());
/*      */     
/*  746 */     dp();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean bZ() {
/*  755 */     n n = this.c.a();
/*      */     
/*  757 */     return (n
/*  758 */       .a() == o.a || n
/*  759 */       .a() == o.k || n
/*  760 */       .a() == o.b || n
/*  761 */       .a() == o.c || n
/*  762 */       .a() == o.e || n
/*  763 */       .a() == o.g || n
/*  764 */       .a() == o.m || n
/*  765 */       .a() == o.h);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean ca() {
/*  771 */     n n = this.c.a();
/*  772 */     return (n.a() == o.j || n.a() == o.r || n
/*  773 */       .a() == o.l);
/*      */   }
/*      */   
/*      */   private boolean cb() {
/*  777 */     return (this.c.a().a() != o.l);
/*      */   }
/*      */   
/*      */   private String cB() {
/*  781 */     if (this.c.a().a() != o.l) {
/*  782 */       return "Perfil:";
/*      */     }
/*  784 */     return "Chave de Integração:";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void dj() {
/*  792 */     for (p p : p.values()) {
/*  793 */       this.k.addItem(p.K());
/*      */     }
/*      */ 
/*      */     
/*  797 */     this.f.getColumnModel().getColumn(0).setCellRenderer((TableCellRenderer)new u(0));
/*  798 */     this.f.getColumnModel().getColumn(1).setCellRenderer((TableCellRenderer)new u(0));
/*  799 */     this.f.getColumnModel().getColumn(2).setCellRenderer((TableCellRenderer)new u(2));
/*  800 */     this.f.getColumnModel().getColumn(3).setCellRenderer((TableCellRenderer)new u(0));
/*  801 */     this.f.getColumnModel().getColumn(4).setCellRenderer((TableCellRenderer)new v("Alterar acesso"));
/*  802 */     this.f.getColumnModel().getColumn(5).setCellRenderer((TableCellRenderer)new v("Remover acesso"));
/*      */     
/*  804 */     b(0, 100);
/*  805 */     b(1, 130);
/*  806 */     b(2, 360);
/*  807 */     b(3, 70);
/*  808 */     b(4, 20);
/*  809 */     b(5, 20);
/*  810 */     b(6, 0);
/*  811 */     b(7, 0);
/*      */     
/*  813 */     d d1 = this;
/*      */     
/*  815 */     this.f.addMouseListener(new MouseAdapter(this, d1)
/*      */         {
/*      */           public void mouseClicked(MouseEvent param1MouseEvent) {
/*  818 */             int i = d.a(this.a).columnAtPoint(param1MouseEvent.getPoint());
/*  819 */             int j = d.a(this.a).rowAtPoint(param1MouseEvent.getPoint());
/*  820 */             int k = d.a(this.a).convertRowIndexToModel(j);
/*      */             
/*  822 */             DefaultTableModel defaultTableModel = (DefaultTableModel)d.a(this.a).getModel();
/*  823 */             String str = String.valueOf(defaultTableModel.getValueAt(k, 1)).replaceAll("[^0-9]*", "");
/*  824 */             int m = ((Integer)defaultTableModel.getValueAt(k, 6)).intValue();
/*  825 */             br.com.arremate.l.d d1 = g.a(l.a().a(m), Long.parseLong(str));
/*      */             
/*  827 */             if (i == 5) {
/*  828 */               if (JOptionPane.showConfirmDialog(this.b, "Ao remover o acesso da empresa " + d1.bv().toUpperCase() + " todas as licitações vinculadas serão removidas. Deseja remover?", "Mensagem", 0, 2) == 0) {
/*      */                 try {
/*      */                   String str1;
/*      */ 
/*      */                   
/*  833 */                   if (o.a == d1.b().a() || o.k == d1.b().a()) {
/*      */                     
/*  835 */                     str1 = " AND (porcodigo = " + d1.b().v() + " OR porcodigo = " + l.a().a(o.k).v() + ")";
/*      */                   } else {
/*  837 */                     str1 = " AND porcodigo = " + d1.b().v();
/*      */                   } 
/*      */                   
/*  840 */                   String str2 = "SELECT liccodigo FROM tblicitacao WHERE empcnpj = " + str + str1;
/*  841 */                   Statement statement = br.com.arremate.e.a.a().createStatement();
/*  842 */                   ResultSet resultSet = statement.executeQuery(str2);
/*  843 */                   ArrayList<Integer> arrayList = new ArrayList();
/*      */                   
/*  845 */                   while (resultSet.next()) {
/*  846 */                     arrayList.add(Integer.valueOf(resultSet.getInt("liccodigo")));
/*      */                   }
/*      */                   
/*  849 */                   if (!arrayList.isEmpty()) {
/*  850 */                     n.a().a(Long.valueOf(Long.parseLong(str)), d1.b().a(), arrayList);
/*      */                   }
/*  852 */                 } catch (Exception exception) {
/*  853 */                   exception.printStackTrace();
/*      */                 } 
/*      */                 
/*  856 */                 if (g.e(d1)) {
/*  857 */                   d.a(this.a, d1);
/*      */                   
/*  859 */                   if (d1.b().a() == o.a) {
/*  860 */                     d1 = new br.com.arremate.l.d(l.a().a(o.k), d1.x());
/*  861 */                     d.a(this.a, d1);
/*  862 */                   } else if (d1.b().a() == o.k) {
/*  863 */                     d1 = new br.com.arremate.l.d(l.a().a(o.a), d1.x());
/*  864 */                     d.a(this.a, d1);
/*  865 */                   } else if (d1.b().a() == o.b) {
/*  866 */                     d1 = new br.com.arremate.l.d(l.a().a(o.c), d1.x());
/*  867 */                     d.a(this.a, d1);
/*  868 */                   } else if (d1.b().a() == o.c) {
/*  869 */                     d1 = new br.com.arremate.l.d(l.a().a(o.b), d1.x());
/*  870 */                     d.a(this.a, d1);
/*      */                   } 
/*      */                 } else {
/*  873 */                   JOptionPane.showMessageDialog(this.b, "Erro ao remover acesso selecionado", "Mensagem", 0);
/*      */                 } 
/*      */               } 
/*  876 */             } else if (i == 4) {
/*  877 */               d.a(this.a, d1);
/*  878 */               d.a(this.a).b(m);
/*  879 */               d.a(this.a).setSelectedIndex(d1.a().getIndex());
/*  880 */               d.a(this.a).setText(d1.getUser());
/*  881 */               d.a(this.a).setText("");
/*  882 */               d.a(this.a).requestFocus();
/*      */               
/*  884 */               if (d.a(this.a)) {
/*  885 */                 if (d.a(this.a).a().a() == o.e) {
/*  886 */                   d.a(this.a).setText(StringUtils.leftPad(Long.toString(d1.y()), 11, "0"));
/*      */                 } else {
/*  888 */                   d.a(this.a).setText(StringUtils.leftPad(Long.toString(d1.x()), 14, "0"));
/*      */                 } 
/*  890 */               } else if (d.b(this.a)) {
/*  891 */                 d.b(this.a).setText(d1.bz());
/*      */               } 
/*      */             } 
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void b(int paramInt1, int paramInt2) {
/*  905 */     this.f.getColumnModel().getColumn(paramInt1).setWidth(paramInt2);
/*  906 */     this.f.getColumnModel().getColumn(paramInt1).setMaxWidth(paramInt2);
/*  907 */     this.f.getColumnModel().getColumn(paramInt1).setMinWidth(paramInt2);
/*  908 */     this.f.getColumnModel().getColumn(paramInt1).setPreferredWidth(paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void dk() {
/*  916 */     DefaultTableModel defaultTableModel = (DefaultTableModel)this.f.getModel();
/*  917 */     defaultTableModel.setRowCount(0);
/*      */     
/*  919 */     g.N().stream().filter(paramd -> (paramd.b().getStatus() != n.aW)).forEach(paramd -> c(paramd));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  924 */     dn();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void dl() {
/*  931 */     this.b.m();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void dm() {
/*      */     try {
/*  939 */       String str = this.b.k();
/*      */       
/*  941 */       if (str.isEmpty()) {
/*  942 */         this.b.n();
/*  943 */         JOptionPane.showMessageDialog(this, "Configurações gerais gravadas com sucesso", "Sucesso", 1);
/*  944 */         dispose();
/*      */       } else {
/*  946 */         JOptionPane.showMessageDialog(this, "Erro ao gravar configurações gerais:" + str, "Erro", 0);
/*      */       } 
/*  948 */     } catch (Exception exception) {
/*  949 */       a.info("Failed to update confs", exception);
/*  950 */       JOptionPane.showMessageDialog(this, "Erro ao gravar configurações gerais: " + exception.getMessage(), "Erro", 0);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void c(br.com.arremate.l.d paramd) {
/*  955 */     String str = y.k("##.###.###/####-##", String.valueOf(paramd.x()));
/*      */     
/*  957 */     DefaultTableModel defaultTableModel = (DefaultTableModel)this.f.getModel();
/*  958 */     defaultTableModel.addRow(new Object[] { paramd
/*  959 */           .b().K(), str, paramd
/*      */           
/*  961 */           .bv(), paramd
/*  962 */           .a().K(), "/img/pencil.png", "/img/delete.png", 
/*      */ 
/*      */           
/*  965 */           Integer.valueOf(paramd.b().v()), 
/*  966 */           Boolean.valueOf(paramd.aO()) });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void dn() {
/*  974 */     DefaultTableModel defaultTableModel = (DefaultTableModel)this.f.getModel();
/*      */     
/*  976 */     TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(defaultTableModel);
/*      */     
/*  978 */     SwingUtilities.invokeLater(() -> {
/*      */           ArrayList<RowSorter.SortKey> arrayList = new ArrayList();
/*      */           arrayList.add(new RowSorter.SortKey(6, SortOrder.ASCENDING));
/*      */           arrayList.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
/*      */           paramTableRowSorter.setSortKeys(arrayList);
/*      */           paramTableRowSorter.setSortable(0, false);
/*      */           paramTableRowSorter.setSortable(1, false);
/*      */           paramTableRowSorter.setSortable(2, false);
/*      */           paramTableRowSorter.setSortable(4, false);
/*      */           paramTableRowSorter.setSortable(0, false);
/*      */           paramTableRowSorter.setSortable(6, false);
/*      */           paramTableRowSorter.setSortable(3, false);
/*      */           paramTableRowSorter.setSortable(5, false);
/*      */           this.f.setRowSorter(paramTableRowSorter);
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void d(br.com.arremate.l.d paramd) {
/*  998 */     String str = y.k("##.###.###/####-##", String.valueOf(paramd.x()));
/*  999 */     DefaultTableModel defaultTableModel = (DefaultTableModel)this.f.getModel();
/*      */     
/* 1001 */     for (byte b = 0; b < defaultTableModel.getRowCount(); b++) {
/* 1002 */       int i = ((Integer)defaultTableModel.getValueAt(b, 6)).intValue();
/*      */       
/* 1004 */       if (String.valueOf(defaultTableModel.getValueAt(b, 1)).equals(str) && i == paramd.b().v()) {
/* 1005 */         defaultTableModel.removeRow(b);
/*      */         break;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void do() {
/* 1015 */     this.Z.setVisible((this.c.a().a() == o.h));
/* 1016 */     this.e.setVisible((this.c.a().a() == o.h));
/*      */   }
/*      */   
/*      */   void a(String paramString1, String paramString2, String paramString3) {
/* 1020 */     this.a = (JPasswordField)new a(paramString1, paramString2, paramString3);
/* 1021 */     this.X.setToolTipText(((a)this.a).path);
/* 1022 */     this.X.setVisible(true);
/*      */     
/* 1024 */     this.h.setVisible(false);
/* 1025 */     this.aa.setVisible(false);
/*      */     
/* 1027 */     this.a.setVisible(false);
/* 1028 */     this.ab.setVisible(false);
/*      */     
/* 1030 */     this.h.setText("");
/* 1031 */     this.a.setText("");
/*      */     
/* 1033 */     this.k.setIcon(new ImageIcon(getClass().getResource("/img/remove_file.png")));
/* 1034 */     this.k.setText("Remover Certificado");
/*      */   }
/*      */   
/*      */   private void dp() {
/* 1038 */     this.a = null;
/* 1039 */     this.X.setToolTipText("");
/* 1040 */     this.X.setVisible(false);
/*      */     
/* 1042 */     this.h.setVisible(cb());
/* 1043 */     this.aa.setVisible(cb());
/*      */     
/* 1045 */     this.a.setVisible(cb());
/* 1046 */     this.ab.setVisible(cb());
/*      */     
/* 1048 */     this.k.setIcon(new ImageIcon(getClass().getResource("/img/add_file.png")));
/* 1049 */     this.k.setText("Importar Certificado");
/*      */   }
/*      */   
/*      */   private static final class a
/*      */   {
/*      */     final String fI;
/*      */     final String password;
/*      */     final String path;
/*      */     
/*      */     public a(String param1String1, String param1String2, String param1String3) {
/* 1059 */       this.fI = param1String1;
/* 1060 */       this.password = param1String2;
/* 1061 */       this.path = param1String3;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\n\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */