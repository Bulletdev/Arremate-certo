/*      */ package br.com.arremate.n;
/*      */ 
/*      */ import br.com.arremate.a.k;
/*      */ import br.com.arremate.b.a.h;
/*      */ import br.com.arremate.b.a.i;
/*      */ import br.com.arremate.b.a.j;
/*      */ import br.com.arremate.b.a.k;
/*      */ import br.com.arremate.b.a.m;
/*      */ import br.com.arremate.b.a.n;
/*      */ import br.com.arremate.b.a.o;
/*      */ import br.com.arremate.b.a.p;
/*      */ import br.com.arremate.b.a.q;
/*      */ import br.com.arremate.b.a.r;
/*      */ import br.com.arremate.f.j;
/*      */ import br.com.arremate.f.k;
/*      */ import br.com.arremate.f.l;
/*      */ import br.com.arremate.f.m;
/*      */ import br.com.arremate.f.o;
/*      */ import br.com.arremate.f.y;
/*      */ import br.com.arremate.j.h;
/*      */ import br.com.arremate.j.i;
/*      */ import br.com.arremate.j.j;
/*      */ import br.com.arremate.l.j;
/*      */ import br.com.arremate.l.n;
/*      */ import br.com.arremate.l.p.j;
/*      */ import br.com.arremate.m.k;
/*      */ import br.com.arremate.m.l;
/*      */ import br.com.arremate.m.r;
/*      */ import br.com.arremate.m.s;
/*      */ import br.com.arremate.m.t;
/*      */ import br.com.arremate.m.y;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Font;
/*      */ import java.awt.Insets;
/*      */ import java.awt.Point;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.ItemEvent;
/*      */ import java.awt.event.ItemListener;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.event.WindowAdapter;
/*      */ import java.awt.event.WindowEvent;
/*      */ import java.net.URL;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.Statement;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import java.util.ListIterator;
/*      */ import java.util.concurrent.Future;
/*      */ import java.util.concurrent.atomic.AtomicBoolean;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.Icon;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JCheckBox;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.KeyStroke;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.event.ListSelectionEvent;
/*      */ import javax.swing.table.TableCellRenderer;
/*      */ import javax.swing.table.TableColumn;
/*      */ import javax.swing.table.TableColumnModel;
/*      */ import javax.swing.table.TableModel;
/*      */ import org.apache.commons.lang3.SystemUtils;
/*      */ import org.e.i;
/*      */ import org.slf4j.Logger;
/*      */ import org.slf4j.LoggerFactory;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class a
/*      */   extends JDialog
/*      */ {
/*  108 */   private static final Logger LOG = LoggerFactory.getLogger(a.class);
/*      */   
/*      */   public static final int cN = 0;
/*      */   public static final int cO = 1;
/*      */   public static final int bL = 2;
/*      */   public static final int cP = 3;
/*      */   public static final int cQ = 4;
/*      */   public static final int cR = 5;
/*      */   public static final int cS = 6;
/*      */   public static final int cT = 7;
/*      */   public static final int cU = 8;
/*      */   public static final int cV = 9;
/*      */   public static final int cW = 10;
/*  121 */   private final List<j> F = new ArrayList<>();
/*      */   
/*      */   private ItemListener a;
/*      */   private i a;
/*  125 */   private List<j> G = new ArrayList<>(); private b a; private a a; private boolean an = false; private boolean ao = false; private JCheckBox e; private br.com.arremate.c.a c;
/*      */   private JCheckBox f;
/*      */   private JButton e;
/*      */   private JButton f;
/*      */   private JButton g;
/*      */   private JButton h;
/*      */   private JComboBox j;
/*      */   private JLabel L;
/*      */   private JLabel M;
/*      */   
/*      */   public a() {
/*  136 */     k();
/*      */     
/*  138 */     this.N.setText("");
/*  139 */     cS();
/*  140 */     cR();
/*  141 */     T(false);
/*  142 */     U(false);
/*      */     
/*  144 */     X(false);
/*      */     
/*  146 */     cU();
/*  147 */     l();
/*  148 */     W(false);
/*      */     
/*  150 */     this.e.setSelectionBackground((Color)null);
/*      */     
/*  152 */     setLocationRelativeTo(null);
/*      */   }
/*      */   private JLabel N; private JLabel O; private JLabel P; private JLabel Q; private JScrollPane f; private JTable e; private JTextField d; private JTextField e; private JLabel R; private JLabel S; private JLabel T; private JLabel U; private JTextField f; private JTextField g; private JCheckBox g;
/*      */   private void l() {
/*  156 */     this.e.getSelectionModel().addListSelectionListener(paramListSelectionEvent -> {
/*      */           if (paramListSelectionEvent.getValueIsAdjusting()) {
/*      */             int j = this.e.getSelectedRow();
/*      */             
/*      */             if (j != -1) {
/*      */               boolean bool = ((Boolean)this.e.getModel().getValueAt(j, 0)).booleanValue();
/*      */               
/*      */               this.e.getModel().setValueAt(Boolean.valueOf(!bool), j, 0);
/*      */             } 
/*      */           } 
/*      */         });
/*  167 */     KeyAdapter keyAdapter1 = new KeyAdapter(this)
/*      */       {
/*      */         public void keyReleased(KeyEvent param1KeyEvent) {
/*  170 */           String str = a.a(this.a).getText();
/*      */           
/*  172 */           if (!a.a(this.a) && !str.trim().isEmpty()) {
/*  173 */             a.a(this.a, true);
/*      */           }
/*      */           
/*  176 */           a.a(this.a, str, a.b(this.a).getText());
/*      */         }
/*      */       };
/*      */     
/*  180 */     KeyAdapter keyAdapter2 = new KeyAdapter(this)
/*      */       {
/*      */         public void keyReleased(KeyEvent param1KeyEvent) {
/*  183 */           String str = a.b(this.a).getText();
/*      */           
/*  185 */           if (!a.b(this.a) && !str.trim().isEmpty()) {
/*  186 */             a.b(this.a, true);
/*      */           }
/*      */           
/*  189 */           a.a(this.a, a.a(this.a).getText(), str);
/*      */         }
/*      */       };
/*      */     
/*  193 */     this.f.addKeyListener(keyAdapter1);
/*  194 */     this.g.addKeyListener(keyAdapter2);
/*      */     
/*  196 */     KeyStroke keyStroke = KeyStroke.getKeyStroke(27, 0);
/*  197 */     byte b1 = 2;
/*  198 */     getRootPane().registerKeyboardAction(paramActionEvent -> dispose(), keyStroke, b1);
/*      */   }
/*      */   
/*      */   private void e(String paramString1, String paramString2) {
/*  202 */     if (this.a != null && this.a.isRunning()) {
/*  203 */       this.a.setRunning(false);
/*      */     }
/*  205 */     this.a = (a)new b(this, paramString1, paramString2);
/*  206 */     (new Thread(this.a)).start();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void cR() {
/*  213 */     this.c.addActionListener((ActionListener)new br.com.arremate.m.a.b(this, this.c)
/*      */         {
/*      */           public void cQ() {
/*  216 */             a.a(this.a);
/*  217 */             a.b(this.a);
/*      */             
/*  219 */             a.c(this.a);
/*  220 */             o o = a.a(this.a).a().a();
/*  221 */             boolean bool1 = (o != o.h) ? true : false;
/*      */             
/*  223 */             a.a(this.a).setSelected(true);
/*  224 */             a.b(this.a).setSelected(true);
/*  225 */             a.c(this.a).setSelected(false);
/*      */             
/*  227 */             a.a(this.a).setVisible(bool1);
/*  228 */             if (o == o.k || o == o.f) {
/*  229 */               a.a(this.a).setVisible(false);
/*  230 */               a.a(this.a).setSelected(false);
/*      */             } 
/*      */             
/*  233 */             a.b(this.a).setVisible(bool1);
/*  234 */             a.c(this.a).setVisible((bool1 && o != o.f));
/*      */             
/*  236 */             a.a(this.a).setVisible(bool1);
/*  237 */             a.a(this.a).setVisible(bool1);
/*  238 */             boolean bool2 = (o == o.p || o == o.f || o == o.i || o == o.o || o == o.n || o == o.j || o == o.r) ? true : false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  246 */             if (bool2) {
/*  247 */               a.b(this.a).setText("Informe o número da Licitação:");
/*  248 */             } else if (o == o.d) {
/*  249 */               a.b(this.a).setText("Informe o código ou número da Licitação:");
/*      */             } else {
/*  251 */               a.b(this.a).setText("Informe o código da Licitação:");
/*      */             } 
/*      */             
/*  254 */             boolean bool3 = (o != o.a && o != o.g && o != o.k && o != o.q && o != o.m && o != o.o && o != o.s && o != o.c) ? true : false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  264 */             a.a(this.a, bool3);
/*      */             
/*  266 */             boolean bool4 = (o == o.j || o == o.r) ? true : false;
/*  267 */             a.b(this.a, bool4);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   private void T(boolean paramBoolean) {
/*  273 */     this.L.setVisible(paramBoolean);
/*  274 */     this.d.setVisible(paramBoolean);
/*  275 */     this.h.setVisible(paramBoolean);
/*      */   }
/*      */   
/*      */   private void U(boolean paramBoolean) {
/*  279 */     this.P.setVisible(paramBoolean);
/*  280 */     this.e.setVisible(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void cS() {
/*  287 */     this.a = (a)(paramItemEvent -> {
/*      */         if (paramItemEvent.getStateChange() != 1) {
/*      */           return;
/*      */         }
/*      */         X(false);
/*      */         if (this.a != null) {
/*      */           this.a.df();
/*      */         }
/*      */         cT();
/*      */         cW();
/*      */       });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void cT() {
/*  304 */     V(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void V(boolean paramBoolean) {
/*  312 */     if (this.e.getRowCount() > 0) {
/*  313 */       ((br.com.arremate.l.q.a)this.e.getModel()).clear();
/*      */     }
/*      */     
/*  316 */     if (paramBoolean) {
/*  317 */       W(false);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void cK() {
/*  325 */     byte b1 = 0;
/*  326 */     n n = this.c.a();
/*  327 */     this.j.removeItemListener((ItemListener)this.a);
/*  328 */     this.j.removeAllItems();
/*      */ 
/*      */     
/*  331 */     if (n.a() == o.k) {
/*  332 */       n = l.a().a(o.a);
/*      */     }
/*      */     
/*  335 */     try (Statement null = br.com.arremate.e.a.a().createStatement()) {
/*      */ 
/*      */       
/*  338 */       String str = "SELECT tbempresa.empcnpj, tbempresa.empnome, tbempresa.empativo FROM tbempresa WHERE tbempresa.porcodigo = " + n.v() + " ORDER BY tbempresa.empcnpj";
/*      */       
/*  340 */       ResultSet resultSet = statement.executeQuery(str);
/*      */ 
/*      */       
/*  343 */       while (resultSet.next()) {
/*  344 */         long l = resultSet.getLong("empcnpj");
/*  345 */         String str1 = y.k("##.###.###/####-##", Long.toString(l));
/*  346 */         String str2 = resultSet.getString("empnome");
/*  347 */         String str3 = str1 + " - " + str2;
/*  348 */         br.com.arremate.m.b b2 = new br.com.arremate.m.b(l, str3);
/*      */         
/*  350 */         if (!resultSet.getBoolean("empativo")) {
/*  351 */           b2.a(y.f());
/*      */         }
/*  353 */         this.j.addItem(b2);
/*  354 */         b1++;
/*      */       } 
/*  356 */     } catch (Exception exception) {
/*  357 */       exception.printStackTrace();
/*      */     } 
/*      */ 
/*      */     
/*  361 */     if (l.a().Z() == 1 && b1 == 0) {
/*  362 */       JOptionPane.showMessageDialog(this, "Nenhum acesso cadastrado.\nPara adicionar pregões é necessário cadastrar o acesso da empresa no portal " + n.K(), "Mensagem", 2);
/*  363 */       db();
/*      */     } else {
/*  365 */       this.j.addItemListener((ItemListener)this.a);
/*      */       
/*  367 */       if (b1 == 0) {
/*      */         
/*  369 */         br.com.arremate.m.b b2 = new br.com.arremate.m.b(0L, "Nenhum acesso cadastrado para o portal " + n.K());
/*  370 */         this.j.insertItemAt(b2, 0);
/*  371 */       } else if (b1 > 1) {
/*      */         
/*  373 */         br.com.arremate.m.b b2 = new br.com.arremate.m.b(0L, "Selecione a empresa desejada");
/*  374 */         this.j.insertItemAt(b2, 0);
/*      */       } 
/*      */ 
/*      */       
/*  378 */       this.j.setSelectedIndex(-1);
/*  379 */       this.j.setSelectedIndex(0);
/*  380 */       this.j.repaint();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void cU() {
/*  388 */     TableColumnModel tableColumnModel = this.e.getColumnModel();
/*  389 */     TableColumn tableColumn = tableColumnModel.getColumn(0);
/*  390 */     tableColumn.setCellRenderer((TableCellRenderer)new t(getClass().getSimpleName()));
/*  391 */     tableColumn.setPreferredWidth(20);
/*      */     
/*  393 */     tableColumn = tableColumnModel.getColumn(1);
/*  394 */     tableColumn.setCellRenderer((TableCellRenderer)new g(this));
/*  395 */     tableColumn.setPreferredWidth(130);
/*      */     
/*  397 */     tableColumn = tableColumnModel.getColumn(2);
/*  398 */     tableColumn.setCellRenderer((TableCellRenderer)new s(0));
/*  399 */     tableColumn.setPreferredWidth(130);
/*      */     
/*  401 */     tableColumn = tableColumnModel.getColumn(3);
/*  402 */     tableColumn.setCellRenderer((TableCellRenderer)new s(0));
/*  403 */     tableColumn.setPreferredWidth(60);
/*      */     
/*  405 */     tableColumn = tableColumnModel.getColumn(4);
/*  406 */     tableColumn.setCellRenderer((TableCellRenderer)new s(2));
/*  407 */     tableColumn.setPreferredWidth(350);
/*      */     
/*  409 */     tableColumn = tableColumnModel.getColumn(5);
/*  410 */     tableColumn.setCellRenderer((TableCellRenderer)new f(this));
/*  411 */     tableColumn.setPreferredWidth(130);
/*      */     
/*  413 */     tableColumn = tableColumnModel.getColumn(6);
/*  414 */     tableColumn.setCellRenderer((TableCellRenderer)new d(this));
/*  415 */     tableColumn.setPreferredWidth(120);
/*      */     
/*  417 */     tableColumn = tableColumnModel.getColumn(7);
/*  418 */     tableColumn.setCellRenderer((TableCellRenderer)new e(this));
/*  419 */     tableColumn.setPreferredWidth(100);
/*      */     
/*  421 */     br.com.arremate.i.b b1 = (paramObject, paramInt1, paramInt2, paramTableModel) -> ((Boolean)paramObject).booleanValue() ? "Sim" : "Não";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  429 */     tableColumn = tableColumnModel.getColumn(8);
/*  430 */     tableColumn.setCellRenderer((TableCellRenderer)new r(0));
/*  431 */     ((r)tableColumn.getCellRenderer()).a(b1);
/*  432 */     tableColumn.setPreferredWidth(40);
/*      */     
/*  434 */     tableColumn = tableColumnModel.getColumn(9);
/*  435 */     tableColumn.setCellRenderer((TableCellRenderer)new r(0));
/*  436 */     ((r)tableColumn.getCellRenderer()).a(b1);
/*  437 */     tableColumn.setPreferredWidth(40);
/*      */     
/*  439 */     tableColumn = tableColumnModel.getColumn(10);
/*  440 */     tableColumn.setCellRenderer((TableCellRenderer)new s(0));
/*  441 */     tableColumn.setPreferredWidth(185);
/*      */     
/*  443 */     if (SystemUtils.IS_OS_MAC) {
/*  444 */       Font font = this.e.getFont();
/*  445 */       font = new Font(font.getName(), font.getStyle(), font.getSize() - 1);
/*  446 */       this.e.setFont(font);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void cV() {
/*  451 */     if (!this.F.isEmpty()) {
/*  452 */       n(this.F);
/*  453 */     } else if (this.f.getText().isEmpty() && this.g.getText().isEmpty()) {
/*  454 */       n(this.G);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void n(List<j> paramList) {
/*  460 */     br.com.arremate.l.q.a a1 = a();
/*      */     
/*      */     try {
/*  463 */       paramList.sort((paramj1, paramj2) -> {
/*      */             if (paramj1 != null && paramj2 != null) {
/*      */               Integer integer1 = Integer.valueOf(((j)paramj1.a()[1]).getOrder());
/*      */ 
/*      */               
/*      */               Integer integer2 = Integer.valueOf(((j)paramj2.a()[1]).getOrder());
/*      */ 
/*      */               
/*      */               int k = integer1.compareTo(integer2);
/*      */               
/*  473 */               return (k != 0) ? k : ((paramj2.h() != null && paramj1.h() != null) ? paramj2.h().compareTo(paramj1.h()) : 1);
/*      */             } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             return -1;
/*      */           });
/*  483 */     } catch (Exception exception) {
/*  484 */       LOG.warn("Error sorting");
/*      */     } 
/*      */     
/*  487 */     paramList.forEach(paramj -> parama.q(paramj));
/*      */ 
/*      */ 
/*      */     
/*  491 */     a1.fireTableDataChanged();
/*      */   }
/*      */   
/*      */   private void cW() {
/*  495 */     this.f.setText("");
/*  496 */     this.g.setText("");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void aK(String paramString) {
/*  505 */     this.e.setVisible(false);
/*  506 */     this.N.setVisible(true);
/*  507 */     this.N.setText(paramString);
/*  508 */     this.N.setIcon(new ImageIcon(getClass().getResource("/img/loading-blue.gif")));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void cX() {
/*  515 */     cY();
/*  516 */     this.e.setVisible(true);
/*  517 */     this.d.setText("");
/*  518 */     this.e.setText("");
/*  519 */     this.N.setText("");
/*  520 */     this.N.setVisible(false);
/*  521 */     this.N.setIcon((Icon)null);
/*      */   }
/*      */   
/*      */   private void cY() {
/*  525 */     this.f.setEnabled(true);
/*  526 */     this.h.setEnabled(true);
/*  527 */     this.d.setEnabled(true);
/*  528 */     this.e.setEnabled(true);
/*      */   }
/*      */   
/*      */   private void cZ() {
/*  532 */     this.h.setEnabled(false);
/*  533 */     this.f.setEnabled(false);
/*  534 */     this.d.setEnabled(false);
/*  535 */     this.e.setEnabled(false);
/*      */   }
/*      */ 
/*      */   
/*      */   private void W(boolean paramBoolean) {
/*  540 */     this.R.setVisible(paramBoolean);
/*  541 */     this.S.setVisible(paramBoolean);
/*  542 */     this.T.setVisible(paramBoolean);
/*  543 */     this.f.setVisible(paramBoolean);
/*  544 */     this.g.setVisible(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void X(boolean paramBoolean) {
/*  555 */     this.Q.setVisible(paramBoolean);
/*      */   }
/*      */   
/*      */   private void da() {
/*  559 */     y.l(y.j.getUrl());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void k() {
/*  569 */     this.f = (JTextField)new JScrollPane();
/*  570 */     this.e = (JTextField)new JTable();
/*  571 */     this.M = new JLabel();
/*  572 */     this.j = new JComboBox();
/*  573 */     this.g = (JCheckBox)new JButton();
/*  574 */     this.e = (JTextField)new JButton();
/*  575 */     this.N = new JLabel();
/*  576 */     this.O = new JLabel();
/*  577 */     this.c = new br.com.arremate.c.a();
/*  578 */     this.L = new JLabel();
/*  579 */     this.h = new JButton();
/*  580 */     this.S = new JLabel();
/*  581 */     this.T = new JLabel();
/*  582 */     this.g = (JCheckBox)new JTextField();
/*  583 */     this.f = new JTextField();
/*  584 */     this.U = new JLabel();
/*  585 */     this.g = new JCheckBox();
/*  586 */     this.f = (JTextField)new JCheckBox();
/*  587 */     this.e = (JTextField)new JCheckBox();
/*  588 */     this.R = new JLabel();
/*  589 */     this.f = (JTextField)new JButton();
/*  590 */     this.d = new JTextField(this)
/*      */       {
/*      */         public String getText() {
/*  593 */           return super.getText().trim();
/*      */         }
/*      */       };
/*  596 */     this.e = new JTextField(this)
/*      */       {
/*      */         public String getText() {
/*  599 */           return super.getText().trim();
/*      */         }
/*      */       };
/*  602 */     this.P = new JLabel();
/*  603 */     this.Q = new JLabel();
/*      */     
/*  605 */     setDefaultCloseOperation(2);
/*  606 */     setTitle("Effecti - Disputar");
/*  607 */     setIconImage((new ImageIcon(getClass().getResource("/img/icone.jpg"))).getImage());
/*  608 */     setLocation(new Point(0, 0));
/*  609 */     setModal(true);
/*  610 */     setResizable(false);
/*  611 */     addWindowListener(new WindowAdapter(this) {
/*      */           public void windowOpened(WindowEvent param1WindowEvent) {
/*  613 */             a.a(this.a, param1WindowEvent);
/*      */           }
/*      */           public void windowClosed(WindowEvent param1WindowEvent) {
/*  616 */             a.b(this.a, param1WindowEvent);
/*      */           }
/*      */         });
/*      */     
/*  620 */     this.f.setHorizontalScrollBarPolicy(31);
/*  621 */     this.f.setVerticalScrollBarPolicy(22);
/*  622 */     this.f.setPreferredSize(new Dimension(452, 400));
/*      */     
/*  624 */     this.e.setModel((TableModel)new br.com.arremate.l.q.a());
/*  625 */     this.e.setAutoResizeMode(0);
/*  626 */     this.e.setFillsViewportHeight(true);
/*  627 */     this.e.getTableHeader().setReorderingAllowed(false);
/*  628 */     this.f.setViewportView(this.e);
/*      */     
/*  630 */     this.M.setText("Empresa:");
/*      */     
/*  632 */     this.j.setAutoscrolls(true);
/*      */     
/*  634 */     this.g.setIcon(new ImageIcon(getClass().getResource("/img/config.png")));
/*  635 */     this.g.setText("Configurações de Acesso");
/*  636 */     this.g.addActionListener(new ActionListener(this) {
/*      */           public void actionPerformed(ActionEvent param1ActionEvent) {
/*  638 */             a.a(this.a, param1ActionEvent);
/*      */           }
/*      */         });
/*      */     
/*  642 */     this.e.setIcon(new ImageIcon(getClass().getResource("/img/add.png")));
/*  643 */     this.e.setText("Adicionar Selecionados");
/*  644 */     this.e.setEnabled(false);
/*  645 */     this.e.addActionListener(new ActionListener(this) {
/*      */           public void actionPerformed(ActionEvent param1ActionEvent) {
/*  647 */             a.b(this.a, param1ActionEvent);
/*      */           }
/*      */         });
/*      */     
/*  651 */     this.N.setFont(this.N.getFont().deriveFont(this.N.getFont().getSize() + 1.0F));
/*  652 */     this.N.setForeground(new Color(0, 0, 255));
/*  653 */     this.N.setText("jLabelLoading");
/*      */     
/*  655 */     this.O.setText("Portal:");
/*      */     
/*  657 */     this.L.setText("Informe o código da Licitação:");
/*      */     
/*  659 */     this.h.setIcon(new ImageIcon(getClass().getResource("/img/arrow_down.png")));
/*  660 */     this.h.setText("Importar Licitação");
/*  661 */     this.h.setMargin(new Insets(2, 10, 2, 10));
/*  662 */     this.h.addActionListener(new ActionListener(this) {
/*      */           public void actionPerformed(ActionEvent param1ActionEvent) {
/*  664 */             a.c(this.a, param1ActionEvent);
/*      */           }
/*      */         });
/*      */     
/*  668 */     this.S.setText("Número");
/*      */     
/*  670 */     this.T.setText("UASG");
/*      */     
/*  672 */     this.U.setText("Carregar as Licitações (dos últimos 6 meses) com as situações:");
/*      */     
/*  674 */     this.g.setSelected(true);
/*  675 */     this.g.setText("Agendado/Aguardando abertura");
/*      */     
/*  677 */     this.f.setSelected(true);
/*  678 */     this.f.setText("Em disputa");
/*      */     
/*  680 */     this.e.setText("Encerrado");
/*      */     
/*  682 */     this.R.setFont(this.R.getFont().deriveFont(this.R.getFont().getSize() + 1.0F));
/*  683 */     this.R.setText("Filtrar por:");
/*      */     
/*  685 */     this.f.setIcon(new ImageIcon(getClass().getResource("/img/arrow_down.png")));
/*  686 */     this.f.setText("Carregar Licitações");
/*  687 */     this.f.setMargin(new Insets(2, 10, 2, 10));
/*  688 */     this.f.addActionListener(new ActionListener(this) {
/*      */           public void actionPerformed(ActionEvent param1ActionEvent) {
/*  690 */             a.d(this.a, param1ActionEvent);
/*      */           }
/*      */         });
/*      */     
/*  694 */     this.d.addKeyListener(new KeyAdapter(this) {
/*      */           public void keyTyped(KeyEvent param1KeyEvent) {
/*  696 */             a.a(this.a, param1KeyEvent);
/*      */           }
/*      */         });
/*      */     
/*  700 */     this.P.setText("Informe o nome do Órgão:");
/*      */     
/*  702 */     this.Q.setForeground(new Color(0, 0, 255));
/*  703 */     this.Q.setText("Melhore sua conexão com o Portal ComprasNet ao configurar seu acesso usando um certificado digital.");
/*  704 */     this.Q.setCursor(new Cursor(12));
/*  705 */     this.Q.addMouseListener(new MouseAdapter(this) {
/*      */           public void mouseClicked(MouseEvent param1MouseEvent) {
/*  707 */             a.a(this.a, param1MouseEvent);
/*      */           }
/*      */         });
/*      */     
/*  711 */     GroupLayout groupLayout = new GroupLayout(getContentPane());
/*  712 */     getContentPane().setLayout(groupLayout);
/*  713 */     groupLayout.setHorizontalGroup(groupLayout
/*  714 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  715 */         .addGroup(groupLayout.createSequentialGroup()
/*  716 */           .addContainerGap()
/*  717 */           .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  718 */             .addGroup(groupLayout.createSequentialGroup()
/*  719 */               .addComponent(this.Q)
/*  720 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  721 */               .addComponent(this.N)
/*  722 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  723 */               .addComponent(this.e))
/*  724 */             .addComponent(this.f, GroupLayout.Alignment.LEADING, -2, 1323, -2)
/*  725 */             .addGroup(groupLayout.createSequentialGroup()
/*  726 */               .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  727 */                 .addGroup(groupLayout.createSequentialGroup()
/*  728 */                   .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  729 */                     .addGroup(groupLayout.createSequentialGroup()
/*  730 */                       .addComponent(this.O)
/*  731 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  732 */                       .addComponent((Component)this.c, -2, 225, -2)
/*  733 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  734 */                       .addComponent(this.M)
/*  735 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  736 */                       .addComponent(this.j, -2, 754, -2)
/*  737 */                       .addGap(0, 0, 32767))
/*  738 */                     .addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup()
/*  739 */                       .addComponent(this.R)
/*  740 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  741 */                       .addComponent(this.S)
/*  742 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  743 */                       .addComponent(this.f, -2, 100, -2)
/*  744 */                       .addGap(18, 18, 18)
/*  745 */                       .addComponent(this.T)
/*  746 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  747 */                       .addComponent(this.g, -2, 100, -2)
/*  748 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  749 */                       .addComponent(this.P)
/*  750 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  751 */                       .addComponent(this.e, -2, 120, -2)
/*  752 */                       .addGap(18, 18, 18)
/*  753 */                       .addComponent(this.L)
/*  754 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  755 */                       .addComponent(this.d, -2, 98, -2)))
/*  756 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
/*  757 */                 .addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup()
/*  758 */                   .addGap(0, 0, 32767)
/*  759 */                   .addComponent(this.U)
/*  760 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  761 */                   .addComponent(this.g)
/*  762 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  763 */                   .addComponent(this.f)
/*  764 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  765 */                   .addComponent(this.e)
/*  766 */                   .addGap(6, 6, 6)))
/*  767 */               .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  768 */                 .addComponent(this.f, -1, -1, 32767)
/*  769 */                 .addComponent(this.g, -1, -1, 32767)
/*  770 */                 .addComponent(this.h, -1, -1, 32767))))
/*  771 */           .addContainerGap(-1, 32767)));
/*      */     
/*  773 */     groupLayout.setVerticalGroup(groupLayout
/*  774 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  775 */         .addGroup(groupLayout.createSequentialGroup()
/*  776 */           .addContainerGap()
/*  777 */           .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  778 */             .addComponent(this.M)
/*  779 */             .addComponent(this.j, -2, -1, -2)
/*  780 */             .addComponent(this.g)
/*  781 */             .addComponent(this.O)
/*  782 */             .addComponent((Component)this.c, -2, -1, -2))
/*  783 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  784 */           .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  785 */             .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  786 */               .addComponent(this.U)
/*  787 */               .addComponent(this.g)
/*  788 */               .addComponent(this.f)
/*  789 */               .addComponent(this.e))
/*  790 */             .addComponent(this.f))
/*  791 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, 32767)
/*  792 */           .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  793 */             .addComponent(this.h)
/*  794 */             .addComponent(this.L)
/*  795 */             .addComponent(this.S)
/*  796 */             .addComponent(this.T)
/*  797 */             .addComponent(this.g, -2, -1, -2)
/*  798 */             .addComponent(this.f, -2, -1, -2)
/*  799 */             .addComponent(this.R)
/*  800 */             .addComponent(this.d, -2, -1, -2)
/*  801 */             .addComponent(this.e, -2, -1, -2)
/*  802 */             .addComponent(this.P))
/*  803 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  804 */           .addComponent(this.f, -1, 516, 32767)
/*  805 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  806 */           .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  807 */             .addComponent(this.e)
/*  808 */             .addComponent(this.N)
/*  809 */             .addComponent(this.Q))
/*  810 */           .addContainerGap()));
/*      */ 
/*      */     
/*  813 */     pack();
/*      */   }
/*      */   
/*      */   private void e(ActionEvent paramActionEvent) {
/*  817 */     cZ();
/*  818 */     aK("Carregando pregões selecionados...");
/*  819 */     (new c(this, this)).start();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void db() {
/*  826 */     (new Thread(() -> {
/*      */           d d = new d(this);
/*      */           d.setVisible(true);
/*      */           cK();
/*  830 */         })).start();
/*      */   }
/*      */   
/*      */   private void a(WindowEvent paramWindowEvent) {
/*  834 */     cK();
/*      */   }
/*      */   
/*      */   private void f(ActionEvent paramActionEvent) {
/*  838 */     db();
/*      */   }
/*      */   
/*      */   private void g(ActionEvent paramActionEvent) {
/*  842 */     cZ();
/*      */     
/*  844 */     if (!this.g.isSelected() && !this.f.isSelected() && !this.e.isSelected()) {
/*  845 */       JOptionPane.showMessageDialog(this, "É necessário selecionar pelo menos uma situação para carregar os pregões!", "Erro", 0);
/*  846 */       cY();
/*      */       
/*      */       return;
/*      */     } 
/*  850 */     this.d.setText("");
/*  851 */     this.e.setText("");
/*  852 */     a(k.a);
/*      */   }
/*      */   
/*      */   private void a(k paramk) {
/*  856 */     br.com.arremate.m.b b1 = (br.com.arremate.m.b)this.j.getSelectedItem();
/*  857 */     if (b1.getValue() <= 0L) {
/*  858 */       JOptionPane.showMessageDialog(this, "É necessário selecionar uma empresa!", "Erro", 0);
/*  859 */       cY();
/*      */       
/*      */       return;
/*      */     } 
/*  863 */     if (this.a != null) {
/*  864 */       this.a.df();
/*      */     }
/*      */     
/*  867 */     this.a = new a(this, this, this.c.a(), paramk);
/*      */     
/*  869 */     if (this.c.a().a() == o.c) {
/*  870 */       JOptionPane.showMessageDialog(this, "Estamos em fase de adaptação ao novo portal do Licitações-e, caso aconteça alguma inconsistência, por favor dispute diretamente pelo portal.", "Alerta", 2);
/*      */     }
/*      */     
/*  873 */     this.a.start();
/*      */   }
/*      */   
/*      */   private void a(KeyEvent paramKeyEvent) {
/*  877 */     o o = this.c.a().a();
/*  878 */     boolean bool = (o != o.p && o != o.f && o != o.i && o != o.o && o != o.n && o != o.d && o != o.j && o != o.r) ? true : false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  886 */     if (bool && !"0987654321".contains(paramKeyEvent.getKeyChar() + "")) {
/*  887 */       paramKeyEvent.consume();
/*      */     }
/*      */   }
/*      */   
/*      */   private void b(WindowEvent paramWindowEvent) {
/*  892 */     dc();
/*      */   }
/*      */   
/*      */   private void h(ActionEvent paramActionEvent) {
/*  896 */     cZ();
/*      */     
/*  898 */     k k = k.b;
/*  899 */     o o = this.c.a().a();
/*  900 */     if (o == o.r || o == o.j) {
/*  901 */       k = k.c;
/*      */       
/*  903 */       String str1 = this.e.getText();
/*  904 */       if (str1 == null || str1.isEmpty()) {
/*  905 */         JOptionPane.showMessageDialog(this, "É necessário informar o nome do órgão!", "Erro", 0);
/*  906 */         cY();
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/*  911 */     String str = this.d.getText();
/*  912 */     if (str == null || str.isEmpty()) {
/*  913 */       JOptionPane.showMessageDialog(this, "É necessário informar o código da licitação!", "Erro", 0);
/*  914 */       cY();
/*      */       
/*      */       return;
/*      */     } 
/*  918 */     a(k);
/*      */   }
/*      */   
/*      */   private void d(MouseEvent paramMouseEvent) {
/*  922 */     da();
/*      */   }
/*      */   
/*      */   private br.com.arremate.l.q.a a() {
/*  926 */     return (br.com.arremate.l.q.a)this.e.getModel();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private class a
/*      */     extends Thread
/*      */   {
/*      */     private final n a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final JDialog a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final k d;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private AtomicBoolean a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public a(a this$0, JDialog param1JDialog, n param1n, k param1k) {
/*  969 */       this.a = (a)param1n;
/*  970 */       this.a = (a)param1JDialog;
/*  971 */       this.d = param1k;
/*      */     }
/*      */ 
/*      */     
/*      */     public void run() {
/*  976 */       a.b(this.a).setEnabled(false);
/*  977 */       a.d(this.a);
/*  978 */       a.a(this.a);
/*  979 */       a.b(this.a);
/*      */       
/*  981 */       br.com.arremate.l.d d = b();
/*  982 */       if (d != null) {
/*  983 */         String str = Long.toString(d.x());
/*  984 */         boolean bool = d.aO();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  991 */         if (d.b().a() == o.q || 
/*  992 */           k.n(br.com.arremate.a.g.a().e(str))) {
/*  993 */           if (!bool) {
/*  994 */             JOptionPane.showMessageDialog(this.a, "A empresa selecionada está inativa, favor configurar os novos dados de acesso!", "Erro", 0);
/*      */             
/*  996 */             a.e(this.a);
/*      */           } else {
/*  998 */             if (this.d != k.a && br.com.arremate.b.a.a.a(String.valueOf(d.x()), d.b(), a.c(this.a).getText())) {
/*  999 */               JOptionPane.showMessageDialog(this.a, "Esta licitação já está cadastrada no sistema para a empresa selecionada!", "Erro", 0);
/* 1000 */               a.c(this.a).requestFocus();
/* 1001 */               a.f(this.a);
/*      */               
/*      */               return;
/*      */             } 
/* 1005 */             a.a(this.a, "Realizando login no portal " + this.a.K());
/*      */             
/* 1007 */             if (g(d)) {
/* 1008 */               a.a(this.a, "Carregando lista de Licitações do portal " + this.a.K());
/* 1009 */               de();
/*      */             } else {
/* 1011 */               a.e(this.a);
/*      */             } 
/*      */           } 
/*      */ 
/*      */           
/* 1016 */           a.g(this.a);
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/*      */     private void de() {
/* 1022 */       a.d().info("Entra no método carregarPregoes");
/* 1023 */       String str = "";
/* 1024 */       boolean bool = false;
/*      */       
/* 1026 */       if (a.a(this.a) == null || !a.a(this.a).isRunning()) {
/* 1027 */         a.d().info("carregarPregoes com login inválido, login.isNull={}", Boolean.valueOf((a.a(this.a) == null)));
/* 1028 */         if (a.a(this.a) != null && a.a(this.a).getMessage() != null && !a.a(this.a).getMessage().isEmpty()) {
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
/* 1039 */           str = a.a(this.a).getMessage();
/*      */         } else {
/* 1041 */           str = "Não foi possível realizar login no portal, favor verificar se os dados de acesso estão corretos.";
/*      */         } 
/*      */         
/* 1044 */         if (!bool) {
/* 1045 */           JOptionPane.showMessageDialog(this.a, str, "Erro", 0);
/*      */         }
/*      */         return;
/*      */       } 
/* 1049 */       int i = 0;
/*      */       
/* 1051 */       br.com.arremate.b.a.a a1 = a();
/*      */       
/* 1053 */       if (this.a.get()) {
/* 1054 */         a.d().info("Definido para parar de carregar pregões depois de instanciar classe de captura");
/*      */         
/*      */         return;
/*      */       } 
/* 1058 */       if (a1 != null) {
/* 1059 */         ArrayList<j> arrayList; String str1, str2, str3; a.a(this.a).clear();
/* 1060 */         a.b(this.a);
/*      */         
/* 1062 */         switch (a.null.n[this.d.ordinal()]) {
/*      */           case 1:
/* 1064 */             arrayList = new ArrayList();
/* 1065 */             if (a.a(this.a).isSelected()) {
/* 1066 */               arrayList.add(j.d);
/*      */             }
/*      */             
/* 1069 */             if (a.b(this.a).isSelected()) {
/* 1070 */               arrayList.add(j.a);
/*      */             }
/*      */             
/* 1073 */             if (a.c(this.a).isSelected()) {
/* 1074 */               arrayList.add(j.g);
/*      */             }
/*      */             
/* 1077 */             a.a(this.a, a1.a(arrayList, (AtomicBoolean)this.a));
/*      */             break;
/*      */           case 2:
/* 1080 */             str1 = a.c(this.a).getText();
/* 1081 */             a.a(this.a, a1.a((AtomicBoolean)this.a, str1));
/* 1082 */             a.c(this.a).setText("");
/*      */             break;
/*      */           case 3:
/* 1085 */             str2 = a.c(this.a).getText();
/* 1086 */             str3 = a.d(this.a).getText();
/* 1087 */             a.a(this.a, a1.a(str2, str3));
/* 1088 */             a.c(this.a).setText("");
/* 1089 */             a.d(this.a).setText("");
/*      */             break;
/*      */         } 
/*      */         
/* 1093 */         if (this.a.get()) {
/*      */           return;
/*      */         }
/*      */         
/* 1097 */         if (a.b(this.a) != null) {
/*      */           
/* 1099 */           a.a(this.a);
/* 1100 */           a.h(this.a);
/*      */           
/* 1102 */           if (a.a(this.a).getModel().getRowCount() == 0) {
/* 1103 */             str = "Não foram encontrados novos pregões que possam ser configurados no momento";
/* 1104 */             i = 1;
/* 1105 */             a.d(this.a);
/*      */           } else {
/* 1107 */             a.d().info("Lista de pregões carregada com sucesso!");
/* 1108 */             a.b(this.a).setEnabled(true);
/* 1109 */             a.c(this.a, true);
/*      */             
/* 1111 */             str = a1.j();
/* 1112 */             if (!str.isEmpty()) {
/* 1113 */               i = a1.c();
/*      */             }
/*      */           } 
/*      */         } else {
/* 1117 */           str = a1.j();
/* 1118 */           i = a1.c();
/* 1119 */           a.d(this.a);
/*      */         } 
/*      */       } 
/*      */       
/* 1123 */       if (str == null) {
/* 1124 */         a.d().warn("Falha ao instanciar CarregaPregoes.class");
/* 1125 */         str = "Erro ao carregar lista de pregões";
/*      */       } 
/*      */       
/* 1128 */       if (!str.isEmpty()) {
/* 1129 */         a.d().info("Mensagem final do processo de carregar pregões = {}", str);
/* 1130 */         JOptionPane.showMessageDialog(this.a, str, "Mensagem", i);
/*      */       }  } private br.com.arremate.b.a.a a() { br.com.arremate.b.a.a.c c1; j j; br.com.arremate.b.a.b b1; br.com.arremate.b.a.a.b b; r r; q q; o o; i i; br.com.arremate.b.a.g g; n n1; br.com.arremate.b.a.f f; br.com.arremate.b.a.c c; m m; br.com.arremate.b.a.e e; br.com.arremate.b.a.d d;
/*      */       h h;
/*      */       k k1;
/*      */       p p;
/* 1135 */       br.com.arremate.b.a.a.a a1 = null;
/*      */       
/* 1137 */       switch (a.null.g[this.a.a().ordinal()]) {
/*      */         case 1:
/* 1139 */           a1 = new br.com.arremate.b.a.a.a((br.com.arremate.j.c.c)a.a(this.a));
/*      */           break;
/*      */         case 2:
/* 1142 */           c1 = new br.com.arremate.b.a.a.c((br.com.arremate.j.l.a.d)a.a(this.a));
/*      */           break;
/*      */         case 3:
/* 1145 */           j = new j(a.a(this.a));
/*      */           break;
/*      */         case 4:
/* 1148 */           b1 = new br.com.arremate.b.a.b((br.com.arremate.j.d.b)a.a(this.a));
/*      */           break;
/*      */         case 5:
/* 1151 */           b = new br.com.arremate.b.a.a.b(a.a(this.a));
/*      */           break;
/*      */         case 6:
/* 1154 */           r = new r((h)a.a(this.a));
/*      */           break;
/*      */         case 7:
/* 1157 */           q = new q((br.com.arremate.j.b.a)a.a(this.a));
/*      */           break;
/*      */         case 8:
/* 1160 */           o = new o((br.com.arremate.j.g.a)a.a(this.a));
/*      */           break;
/*      */         case 9:
/* 1163 */           i = new i(a.a(this.a));
/*      */           break;
/*      */         case 10:
/* 1166 */           g = new br.com.arremate.b.a.g((br.com.arremate.j.h.a)a.a(this.a));
/*      */           break;
/*      */         case 11:
/* 1169 */           n1 = new n(a.a(this.a));
/*      */           break;
/*      */         case 12:
/* 1172 */           f = new br.com.arremate.b.a.f((j)a.a(this.a));
/*      */           break;
/*      */         case 13:
/* 1175 */           c = new br.com.arremate.b.a.c((br.com.arremate.j.a.a)a.a(this.a));
/*      */           break;
/*      */         case 14:
/* 1178 */           m = new m((br.com.arremate.j.e)a.a(this.a));
/*      */           break;
/*      */         case 15:
/* 1181 */           e = new br.com.arremate.b.a.e(a.a(this.a));
/*      */           break;
/*      */         case 16:
/* 1184 */           d = new br.com.arremate.b.a.d(a.a(this.a));
/*      */           break;
/*      */         case 17:
/* 1187 */           h = new h(a.a(this.a));
/*      */           break;
/*      */         case 18:
/* 1190 */           k1 = new k((br.com.arremate.j.j.a)a.a(this.a));
/*      */           break;
/*      */         case 19:
/* 1193 */           p = new p((br.com.arremate.j.k.a)a.a(this.a));
/*      */           break;
/*      */       } 
/*      */ 
/*      */       
/* 1198 */       return (br.com.arremate.b.a.a)p; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean g(br.com.arremate.l.d param1d) {
/*      */       try {
/* 1209 */         Future<i> future = br.com.arremate.k.c.c.a(param1d);
/* 1210 */         a.a(this.a, future.get());
/*      */         
/* 1212 */         if (a.a(this.a) != null && !a.a(this.a).a().aO()) {
/* 1213 */           String str = "Não foi possível realizar login no portal, favor verificar se os dados de acesso estão corretos.";
/* 1214 */           JOptionPane.showMessageDialog(this.a, str, "Erro", 0);
/* 1215 */           return false;
/*      */         } 
/* 1217 */       } catch (Exception exception) {
/* 1218 */         a.d().error("Failed to validate active company", exception);
/*      */       } 
/*      */       
/* 1221 */       return true;
/*      */     }
/*      */     
/*      */     private br.com.arremate.l.d b() {
/* 1225 */       if (a.a(this.a).getSelectedIndex() < 0) {
/* 1226 */         return null;
/*      */       }
/*      */       
/* 1229 */       br.com.arremate.m.b b = (br.com.arremate.m.b)a.a(this.a).getSelectedItem();
/*      */       
/* 1231 */       if (b.getValue() <= 0L) {
/* 1232 */         return null;
/*      */       }
/* 1234 */       long l = b.getValue();
/* 1235 */       return br.com.arremate.m.g.a((n)this.a, l);
/*      */     }
/*      */ 
/*      */     
/*      */     public void df() {
/* 1240 */       this.a.set(true);
/*      */     }
/*      */   }
/*      */   
/*      */   private void dc() {
/* 1245 */     br.com.arremate.k.c.c.b((i)this.a);
/* 1246 */     this.a = null;
/*      */   }
/*      */ 
/*      */   
/*      */   private class c
/*      */     extends Thread
/*      */   {
/*      */     private final JDialog a;
/*      */ 
/*      */     
/*      */     public c(a this$0, JDialog param1JDialog) {
/* 1257 */       this.a = (a)param1JDialog;
/*      */     }
/*      */ 
/*      */     
/*      */     public void run() {
/* 1262 */       boolean bool1 = true;
/* 1263 */       byte b = 0;
/* 1264 */       br.com.arremate.l.q.a a1 = a.a(this.a);
/* 1265 */       boolean bool2 = (o.h == a.a(this.a).a().a()) ? true : false;
/*      */       
/* 1267 */       ListIterator<j> listIterator = a1.getListIterator();
/* 1268 */       while (listIterator.hasNext()) {
/* 1269 */         j j = listIterator.next();
/* 1270 */         if (j.ac || bool2) {
/* 1271 */           b++;
/*      */           
/* 1273 */           if (!a(j, !bool2)) {
/* 1274 */             bool1 = false;
/*      */             break;
/*      */           } 
/* 1277 */           listIterator.remove();
/*      */         } 
/*      */       } 
/*      */       
/* 1281 */       if (b == 0) {
/* 1282 */         a.g(this.a);
/* 1283 */         JOptionPane.showMessageDialog(this.a, "Marque ao menos um registro para realizar a gravação", "Mensagem", 2);
/*      */         
/*      */         return;
/*      */       } 
/* 1287 */       a.g(this.a);
/*      */       
/* 1289 */       if (bool1) {
/* 1290 */         this.a.dispose();
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     private boolean a(j param1j, boolean param1Boolean) {
/*      */       try {
/* 1297 */         if (a(param1j)) {
/* 1298 */           return false;
/*      */         }
/*      */         
/* 1301 */         if (param1j instanceof br.com.arremate.i.a) {
/* 1302 */           List list = ((br.com.arremate.i.a)param1j).a(a.a(this.a));
/*      */ 
/*      */           
/* 1305 */           if (a(param1j)) {
/* 1306 */             return false;
/*      */           }
/*      */           
/* 1309 */           if (!list.isEmpty()) {
/* 1310 */             i i = br.com.arremate.a.g.a().a(param1j);
/* 1311 */             if (i != null) {
/* 1312 */               String str1 = i.bl("message").trim();
/* 1313 */               if (!str1.isEmpty()) {
/* 1314 */                 JOptionPane.showMessageDialog(this.a, str1
/* 1315 */                     .replace("[###]", param1j.bX())
/* 1316 */                     .replace("\\n", System.lineSeparator()), "Falha ao adicionar licitação", 0);
/*      */ 
/*      */                 
/* 1319 */                 return false;
/*      */               } 
/*      */             } else {
/* 1322 */               k.cM();
/* 1323 */               return false;
/*      */             } 
/*      */ 
/*      */             
/* 1327 */             param1j.ao();
/*      */             
/* 1329 */             list.stream().forEach(param1g -> param1g.ao());
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1334 */             n.a().r(param1j);
/*      */             
/* 1336 */             o o = param1j.b().a();
/* 1337 */             if (o == o.m || o == o.o || o == o.n || o == o.i || o == o.h || o == o.f || o == o.g || o == o.p || o == o.s)
/*      */             {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1346 */               if (k.b()) {
/*      */                 
/* 1348 */                 StringBuilder stringBuilder = new StringBuilder();
/* 1349 */                 stringBuilder.append("Portal: ").append(param1j.b().K()).append("<br>");
/* 1350 */                 stringBuilder.append("Código: ").append(param1j.v()).append("<br>");
/* 1351 */                 stringBuilder.append("UASG: ").append(param1j.K()).append("<br>");
/* 1352 */                 stringBuilder.append("UASG nome: ").append(param1j.bT()).append("<br>");
/* 1353 */                 stringBuilder.append("Número: ").append(param1j.bo()).append("<br>");
/* 1354 */                 stringBuilder.append("Data abertura: ").append(param1j.bS()).append("<br>");
/* 1355 */                 stringBuilder.append("Empresa: ").append(param1j.a().bv()).append("<br>");
/* 1356 */                 stringBuilder.append("CNPJ login: ").append(a.a(this.a).a().x()).append("<br>");
/* 1357 */                 stringBuilder.append("Usuário: ").append(param1j.a().getUser()).append("<br>");
/* 1358 */                 stringBuilder.append("Senha: ").append(param1j.a().getPassword());
/*      */                 
/* 1360 */                 br.com.arremate.a.g.a().d(stringBuilder.toString());
/*      */               } 
/*      */             }
/* 1363 */             j.a().b(param1j, list.size() - 1);
/* 1364 */             j.a().a(a.a(this.a), a.b(this.a));
/* 1365 */             return true;
/*      */           } 
/* 1367 */           String str = param1j.bo() + " UASG: " + param1j.K();
/*      */           
/* 1369 */           if (param1Boolean) {
/* 1370 */             a.a(this.a, "Falha ao adicionar itens da licitação " + str + ". Tentando novamente...");
/* 1371 */             return a(param1j, false);
/*      */           } 
/* 1373 */           JOptionPane.showMessageDialog(this.a, "Falha ao adicionar licitação " + str + ". Não foi possível capturar os itens da licitação.\nVerifique se a proposta desta licitação está cadastrada.");
/*      */         }
/*      */       
/*      */       }
/* 1377 */       catch (Exception exception) {
/* 1378 */         exception.printStackTrace();
/* 1379 */         JOptionPane.showMessageDialog(this.a, "Erro ao gravar pregões selecionados", "Mensagem", 0);
/*      */       } 
/* 1381 */       return false;
/*      */     }
/*      */     
/*      */     private boolean a(j param1j) {
/* 1385 */       String str = param1j.bg();
/* 1386 */       if (!str.isEmpty()) {
/* 1387 */         if (str.equals("noOpeningDateCN")) {
/* 1388 */           JOptionPane.showMessageDialog(null, "(Licitação " + param1j
/*      */               
/* 1390 */               .bo() + ") Não é possível adicionar uma licitação do Portal Comprasnet sem uma data de abertura prevista para a etapa de disputa!", "Licitação sem data de abertura prevista", 1);
/*      */ 
/*      */ 
/*      */           
/* 1394 */           return true;
/* 1395 */         }  if (str.equals("notAddSomeGroupsCN")) {
/* 1396 */           JOptionPane.showMessageDialog(null, "A licitação " + param1j
/*      */               
/* 1398 */               .bo() + " teve alguns de seus Grupos não adicionados.\nMotivo: Grupos com apuração por maior percentual de desconto.", "Grupos não adicionados", 1);
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1403 */           return false;
/* 1404 */         }  if (str.equals("notAddSomeDispenseCN")) {
/* 1405 */           JOptionPane.showMessageDialog(null, "A licitação " + param1j
/*      */               
/* 1407 */               .bo() + " teve alguns de seus Itens não adicionados.\nMotivo: Itens com apuração por maior percentual de desconto.", "Itens não adicionados", 1);
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1412 */           return false;
/* 1413 */         }  if (str.equals("notAddSomeItems")) {
/* 1414 */           JOptionPane.showMessageDialog(null, "A licitação " + param1j
/*      */               
/* 1416 */               .bo() + " teve alguns de seus Itens não adicionados.\nMotivo: Itens com apuração por maior percentual de desconto.", "Itens não adicionados", 1);
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1421 */           return false;
/*      */         } 
/* 1423 */         JOptionPane.showMessageDialog(null, "A licitação " + param1j
/*      */             
/* 1425 */             .bo() + " faz o envio de lances pelo/pela " + str + ".\nEste tipo de disputa ainda não é suportada para este portal, portanto não foi possível adicioná-la.", "Pregão não suportado", 1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1432 */         j.a().a(param1j, str);
/* 1433 */         return true;
/*      */       } 
/*      */ 
/*      */       
/* 1437 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   private class b
/*      */     implements Runnable {
/*      */     private boolean running;
/*      */     private final String dJ;
/*      */     private final String fH;
/*      */     
/*      */     public b(a this$0, String param1String1, String param1String2) {
/* 1448 */       this.dJ = param1String1;
/* 1449 */       this.fH = param1String2;
/* 1450 */       this.running = true;
/*      */     }
/*      */ 
/*      */     
/*      */     public void run() {
/* 1455 */       a.a(this.a, "Buscando por número (" + this.dJ + ") e uasg (" + this.fH + ")...");
/*      */       
/* 1457 */       ArrayList<j> arrayList = new ArrayList();
/* 1458 */       for (j j : a.b(this.a)) {
/* 1459 */         Object[] arrayOfObject = j.a();
/* 1460 */         String str1 = String.valueOf(arrayOfObject[2]).toUpperCase();
/* 1461 */         String str2 = str1.replaceAll("\\D", "");
/* 1462 */         String str3 = String.valueOf(arrayOfObject[3]);
/* 1463 */         String str4 = String.valueOf(arrayOfObject[4]).toUpperCase();
/*      */         
/* 1465 */         if (!this.dJ.isEmpty() && !this.fH.isEmpty()) {
/* 1466 */           if (str1.contains(this.dJ) && (str3
/* 1467 */             .contains(this.fH) || str4.contains(this.fH.toUpperCase()))) {
/* 1468 */             arrayList.add(j);
/*      */           }
/* 1470 */         } else if (!this.dJ.isEmpty()) {
/* 1471 */           if (str1.contains(this.dJ.toUpperCase()) || str2
/* 1472 */             .contains(this.dJ.replaceAll("\\D", ""))) {
/* 1473 */             arrayList.add(j);
/*      */           }
/* 1475 */         } else if (!this.fH.isEmpty() && (
/* 1476 */           str3.contains(this.fH) || str4.contains(this.fH.toUpperCase()))) {
/* 1477 */           arrayList.add(j);
/*      */         } 
/*      */ 
/*      */         
/* 1481 */         if (!isRunning()) {
/*      */           break;
/*      */         }
/*      */       } 
/*      */       
/* 1486 */       synchronized (this.a) {
/* 1487 */         if (isRunning()) {
/* 1488 */           a.a(this.a).clear();
/* 1489 */           a.a(this.a).addAll(arrayList);
/* 1490 */           a.d(this.a, false);
/* 1491 */           a.h(this.a);
/* 1492 */           a.g(this.a);
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/*      */     public boolean isRunning() {
/* 1498 */       return this.running;
/*      */     }
/*      */     
/*      */     public void setRunning(boolean param1Boolean) {
/* 1502 */       this.running = param1Boolean;
/*      */     }
/*      */   }
/*      */   
/*      */   private class g
/*      */     extends r {
/*      */     public g(a this$0) {
/* 1509 */       super(2);
/*      */     }
/*      */ 
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable param1JTable, Object param1Object, boolean param1Boolean1, boolean param1Boolean2, int param1Int1, int param1Int2) {
/* 1514 */       JLabel jLabel = (JLabel)super.getTableCellRendererComponent(param1JTable, param1Object, param1Boolean1, param1Boolean2, param1Int1, param1Int2);
/* 1515 */       if (param1Object != null) {
/* 1516 */         String str; j j = (j)param1Object;
/*      */ 
/*      */         
/* 1519 */         switch (a.null.b[j.ordinal()]) {
/*      */           case 1:
/* 1521 */             str = "/img/hammer.png";
/*      */             break;
/*      */           case 2:
/* 1524 */             str = "/img/hammer_closed.png";
/*      */             break;
/*      */           default:
/* 1527 */             str = "/img/date.png";
/*      */             break;
/*      */         } 
/*      */         
/* 1531 */         if (!str.isEmpty()) {
/* 1532 */           URL uRL = getClass().getResource(str);
/* 1533 */           if (uRL != null) {
/* 1534 */             jLabel.setIcon(new ImageIcon(uRL));
/*      */           }
/*      */         } 
/*      */         
/* 1538 */         jLabel.setText(j.K());
/*      */       } 
/*      */       
/* 1541 */       return jLabel;
/*      */     }
/*      */   }
/*      */   
/*      */   private class f
/*      */     extends r {
/*      */     public f(a this$0) {
/* 1548 */       super(0);
/*      */     }
/*      */ 
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable param1JTable, Object param1Object, boolean param1Boolean1, boolean param1Boolean2, int param1Int1, int param1Int2) {
/* 1553 */       JLabel jLabel = (JLabel)super.getTableCellRendererComponent(param1JTable, param1Object, param1Boolean1, param1Boolean2, param1Int1, param1Int2);
/* 1554 */       if (param1Object == null || param1Object.toString().trim().isEmpty()) {
/* 1555 */         jLabel.setText("Sem data prevista");
/*      */       }
/*      */       
/* 1558 */       return jLabel;
/*      */     }
/*      */   }
/*      */   
/*      */   private class d
/*      */     extends r {
/*      */     public d(a this$0) {
/* 1565 */       super(0);
/*      */     }
/*      */ 
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable param1JTable, Object param1Object, boolean param1Boolean1, boolean param1Boolean2, int param1Int1, int param1Int2) {
/* 1570 */       JLabel jLabel = (JLabel)super.getTableCellRendererComponent(param1JTable, param1Object, param1Boolean1, param1Boolean2, param1Int1, param1Int2);
/* 1571 */       if (param1Object != null) {
/* 1572 */         l l = (l)param1Object;
/* 1573 */         jLabel.setText(l.getDescription());
/*      */       } 
/*      */       
/* 1576 */       return jLabel;
/*      */     }
/*      */   }
/*      */   
/*      */   private class e
/*      */     extends r {
/*      */     public e(a this$0) {
/* 1583 */       super(0);
/*      */     }
/*      */ 
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable param1JTable, Object param1Object, boolean param1Boolean1, boolean param1Boolean2, int param1Int1, int param1Int2) {
/* 1588 */       JLabel jLabel = (JLabel)super.getTableCellRendererComponent(param1JTable, param1Object, param1Boolean1, param1Boolean2, param1Int1, param1Int2);
/* 1589 */       if (param1Object != null) {
/* 1590 */         m m = (m)param1Object;
/* 1591 */         jLabel.setText(m.getDescription());
/*      */       } 
/*      */       
/* 1594 */       return jLabel;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\n\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */