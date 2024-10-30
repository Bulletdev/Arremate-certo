/*      */ package br.com.arremate.d;
/*      */ import br.com.arremate.a.a;
/*      */ import br.com.arremate.c.a.j;
/*      */ import br.com.arremate.f.f;
/*      */ import br.com.arremate.f.h;
/*      */ import br.com.arremate.f.l;
/*      */ import br.com.arremate.f.m;
/*      */ import br.com.arremate.f.o;
/*      */ import br.com.arremate.f.r;
/*      */ import br.com.arremate.f.v;
/*      */ import br.com.arremate.i.a.c;
/*      */ import br.com.arremate.i.a.d;
/*      */ import br.com.arremate.k.a.g;
/*      */ import br.com.arremate.k.a.p;
/*      */ import br.com.arremate.l.d;
/*      */ import br.com.arremate.l.g;
/*      */ import br.com.arremate.l.h;
/*      */ import br.com.arremate.l.m;
/*      */ import br.com.arremate.l.p.e;
/*      */ import br.com.arremate.l.p.g;
/*      */ import br.com.arremate.l.p.h;
/*      */ import br.com.arremate.l.p.i;
/*      */ import br.com.arremate.l.p.j;
/*      */ import br.com.arremate.l.q.a.a;
/*      */ import br.com.arremate.l.q.a.c;
/*      */ import br.com.arremate.l.q.b.a;
/*      */ import br.com.arremate.l.q.b.e;
/*      */ import br.com.arremate.l.q.b.f;
/*      */ import br.com.arremate.l.q.b.h;
/*      */ import br.com.arremate.l.q.b.i;
/*      */ import br.com.arremate.l.q.c;
/*      */ import br.com.arremate.l.q.c.e;
/*      */ import br.com.arremate.l.q.c.f;
/*      */ import br.com.arremate.l.q.c.k;
/*      */ import br.com.arremate.l.q.c.n;
/*      */ import br.com.arremate.l.q.d;
/*      */ import br.com.arremate.m.r;
/*      */ import br.com.arremate.m.y;
/*      */ import br.com.arremate.m.z;
/*      */ import br.com.arremate.n.d;
/*      */ import br.com.arremate.n.f;
/*      */ import br.com.arremate.n.g;
/*      */ import br.com.arremate.n.h;
/*      */ import br.com.arremate.n.l;
/*      */ import br.com.arremate.n.n;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Font;
/*      */ import java.awt.Insets;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.math.BigDecimal;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.sql.Statement;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Timer;
/*      */ import java.util.TimerTask;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.Icon;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTabbedPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.SwingWorker;
/*      */ import javax.swing.border.EmptyBorder;
/*      */ import javax.swing.event.ChangeEvent;
/*      */ import javax.swing.event.ChangeListener;
/*      */ import javax.swing.event.TableModelEvent;
/*      */ import javax.swing.table.TableCellRenderer;
/*      */ import javax.swing.table.TableModel;
/*      */ import org.e.f;
/*      */ import org.e.i;
/*      */ import org.slf4j.Logger;
/*      */ 
/*      */ public class b extends JPanel {
/*   90 */   private static final Logger a = LoggerFactory.getLogger(b.class); private final g a; private final g a; private final l a; private final ImageIcon a; private final ImageIcon b; private final SimpleDateFormat dateFormat; private Timer b; private f a; private e a; private Timer c; private boolean i;
/*      */   private boolean j;
/*      */   private JTable a;
/*      */   private JButton b;
/*      */   private JButton c;
/*      */   private JLabel t;
/*      */   private JLabel u;
/*      */   private h a;
/*      */   private JLabel v;
/*      */   private JLabel w;
/*      */   private JLabel x;
/*      */   private JTable b;
/*      */   private JLabel y;
/*      */   private JLabel n;
/*      */   private JLabel z;
/*      */   private JLabel A;
/*      */   private JPanel d;
/*      */   
/*      */   public b(g paramg) {
/*  109 */     this.a = (JTabbedPane)paramg;
/*  110 */     this.a = (JTabbedPane)new g();
/*  111 */     this.a = (JTabbedPane)new l(paramg.a());
/*      */     
/*  113 */     this.a = (JTabbedPane)new ImageIcon(getClass().getResource("/img/play.png"));
/*  114 */     this.b = (j)new ImageIcon(getClass().getResource("/img/stop.png"));
/*      */     
/*  116 */     this.dateFormat = new SimpleDateFormat("HH:mm:ss");
/*      */     
/*  118 */     this.i = false;
/*  119 */     this.j = false;
/*      */     
/*  121 */     k();
/*  122 */     B();
/*  123 */     n();
/*      */     
/*  125 */     this.b.setVisible(false);
/*      */     
/*  127 */     v();
/*  128 */     x();
/*  129 */     y();
/*  130 */     z();
/*  131 */     A();
/*      */   }
/*      */   private JPanel e; private JPanel f; private JScrollPane a; private JScrollPane b; private JScrollPane c; private JScrollPane d; private JScrollPane e;
/*      */   private JTabbedPane a;
/*      */   private JTextField c;
/*      */   private JLabel B;
/*      */   private JLabel C;
/*      */   private JLabel D;
/*      */   private JLabel E;
/*      */   
/*      */   private void k() {
/*  142 */     this.f = new JPanel();
/*  143 */     this.I = new JLabel();
/*  144 */     this.x = new JLabel();
/*  145 */     this.w = new JLabel();
/*  146 */     this.u = new JLabel();
/*  147 */     this.d = new JButton();
/*  148 */     this.b = (j)new JButton();
/*  149 */     this.H = new JLabel();
/*  150 */     this.v = new JLabel();
/*  151 */     this.t = new JLabel();
/*  152 */     this.c = (JTable)new JButton();
/*  153 */     this.C = new JLabel();
/*  154 */     this.b = new j();
/*  155 */     this.F = new JLabel();
/*  156 */     this.J = new JLabel();
/*  157 */     this.B = new JLabel();
/*  158 */     this.d = (JButton)new JPanel();
/*  159 */     this.a = (JTabbedPane)new JScrollPane();
/*  160 */     this.a = (JTabbedPane)new h();
/*  161 */     this.a = new JTabbedPane(this) {
/*      */         private Dimension a() {
/*  163 */           int i = (int)(this.a.getHeight() - this.a.getPreferredSize().getHeight());
/*  164 */           if (i > 0) {
/*  165 */             i = (int)(i * 0.3D);
/*  166 */             i = (int)(i + getMinimumSize().getHeight());
/*      */           } else {
/*  168 */             i = (int)getMinimumSize().getHeight();
/*      */           } 
/*      */           
/*  171 */           return new Dimension(getWidth(), i);
/*      */         }
/*      */ 
/*      */         
/*      */         public Dimension getSize() {
/*  176 */           return a();
/*      */         }
/*      */ 
/*      */         
/*      */         public Dimension getPreferredSize() {
/*  181 */           return a();
/*      */         }
/*      */       };
/*  184 */     this.g = new JPanel();
/*  185 */     this.d = (JButton)new JScrollPane();
/*  186 */     this.a = (JTabbedPane)new br.com.arremate.l.q.a.b();
/*  187 */     this.k = new JPanel();
/*  188 */     this.c = (JTable)new JScrollPane();
/*  189 */     this.d = (JButton)new JTable();
/*  190 */     this.h = new JPanel();
/*  191 */     this.z = new JLabel();
/*  192 */     this.c = (JTable)new JTextField();
/*  193 */     this.A = new JLabel();
/*  194 */     this.i = new JPanel();
/*  195 */     this.b = (j)new JScrollPane();
/*  196 */     this.b = (j)e.a(this.a.a().b());
/*  197 */     this.j = new JPanel();
/*  198 */     this.e = new JScrollPane();
/*  199 */     this.c = new JTable();
/*  200 */     this.e = (JScrollPane)new JPanel();
/*  201 */     this.G = new JLabel();
/*  202 */     this.y = new JLabel();
/*  203 */     this.D = new JLabel();
/*  204 */     this.n = new JLabel();
/*  205 */     this.E = new JLabel();
/*      */     
/*  207 */     setAlignmentX(0.0F);
/*  208 */     setAlignmentY(0.0F);
/*  209 */     setMinimumSize(new Dimension(0, 0));
/*  210 */     setPreferredSize(new Dimension(1245, 595));
/*      */     
/*  212 */     this.f.setAlignmentX(0.0F);
/*  213 */     this.f.setAlignmentY(0.0F);
/*  214 */     this.f.setPreferredSize(new Dimension(940, 65));
/*      */     
/*  216 */     this.I.setText("UASG:");
/*      */     
/*  218 */     this.x.setForeground(y.c());
/*  219 */     this.x.setText("ICMS");
/*  220 */     this.x.setToolTipText("Disputa com Equalização de ICMS");
/*  221 */     this.x.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(), new EmptyBorder(0, 3, 1, 3)));
/*  222 */     this.x.setMaximumSize(new Dimension(40, 20));
/*  223 */     this.x.setMinimumSize(new Dimension(39, 20));
/*  224 */     this.x.setPreferredSize(new Dimension(39, 20));
/*      */     
/*  226 */     this.w.setText("Empresa:");
/*      */     
/*  228 */     this.u.setText("Data Abertura:");
/*      */     
/*  230 */     this.d.setIcon(new ImageIcon(getClass().getResource("/img/play.png")));
/*  231 */     this.d.setToolTipText("Iniciar disputa (CTRL + I)");
/*  232 */     this.d.setMargin(new Insets(2, 8, 2, 8));
/*  233 */     this.d.setMaximumSize(new Dimension(79, 25));
/*  234 */     this.d.setMinimumSize(new Dimension(79, 25));
/*  235 */     this.d.setPreferredSize(new Dimension(79, 25));
/*  236 */     this.d.addActionListener(new ActionListener(this) {
/*      */           public void actionPerformed(ActionEvent param1ActionEvent) {
/*  238 */             b.a(this.a, param1ActionEvent);
/*      */           }
/*      */         });
/*      */     
/*  242 */     this.b.setIcon(new ImageIcon(getClass().getResource("/img/config.png")));
/*  243 */     this.b.setToolTipText("Configurações da Disputa (CTRL + SHIFT + C)");
/*  244 */     this.b.setMargin(new Insets(2, 8, 2, 8));
/*  245 */     this.b.setMaximumSize(new Dimension(79, 25));
/*  246 */     this.b.setMinimumSize(new Dimension(79, 25));
/*  247 */     this.b.setPreferredSize(new Dimension(79, 25));
/*  248 */     this.b.addActionListener(new ActionListener(this) {
/*      */           public void actionPerformed(ActionEvent param1ActionEvent) {
/*  250 */             b.b(this.a, param1ActionEvent);
/*      */           }
/*      */         });
/*      */     
/*  254 */     this.H.setFont(new Font("Dialog", 0, 12));
/*  255 */     this.H.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
/*      */     
/*  257 */     this.v.setFont(new Font("Dialog", 0, 12));
/*  258 */     this.v.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
/*      */     
/*  260 */     this.t.setFont(new Font("Dialog", 0, 12));
/*  261 */     this.t.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
/*  262 */     this.t.setName("numeroLabel");
/*      */     
/*  264 */     this.c.setIcon(new ImageIcon(getClass().getResource("/img/information.png")));
/*  265 */     this.c.setToolTipText("Detalhes (CTRL + D)");
/*  266 */     this.c.setMargin(new Insets(2, 8, 2, 8));
/*  267 */     this.c.setMaximumSize(new Dimension(79, 25));
/*  268 */     this.c.setMinimumSize(new Dimension(79, 25));
/*  269 */     this.c.setPreferredSize(new Dimension(79, 25));
/*  270 */     this.c.addActionListener(new ActionListener(this) {
/*      */           public void actionPerformed(ActionEvent param1ActionEvent) {
/*  272 */             b.c(this.a, param1ActionEvent);
/*      */           }
/*      */         });
/*      */     
/*  276 */     this.C.setForeground(new Color(255, 0, 0));
/*  277 */     this.C.setText("Envio de lance na abertura dos itens");
/*  278 */     this.C.setToolTipText("Configuração de lances na abertura ativada");
/*  279 */     this.C.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(), new EmptyBorder(0, 3, 1, 3)));
/*      */     
/*  281 */     this.F.setForeground(y.c());
/*  282 */     this.F.setText("Aleatório");
/*  283 */     this.F.setToolTipText("Modo de disputa");
/*  284 */     this.F.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(), new EmptyBorder(0, 3, 1, 3)));
/*      */     
/*  286 */     this.J.setForeground(y.c());
/*  287 */     this.J.setText("Unitário");
/*  288 */     this.J.setToolTipText("Os lances serão por valor unitário");
/*  289 */     this.J.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(), new EmptyBorder(0, 3, 1, 3)));
/*  290 */     this.J.setMinimumSize(new Dimension(48, 20));
/*      */     
/*  292 */     this.B.setForeground(y.c());
/*  293 */     this.B.setText("Modalidade");
/*  294 */     this.B.setToolTipText("Modalidade da licitação");
/*  295 */     this.B.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(), new EmptyBorder(0, 3, 1, 3)));
/*      */     
/*  297 */     GroupLayout groupLayout1 = new GroupLayout(this.f);
/*  298 */     this.f.setLayout(groupLayout1);
/*  299 */     groupLayout1.setHorizontalGroup(groupLayout1
/*  300 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  301 */         .addGroup(groupLayout1.createSequentialGroup()
/*  302 */           .addContainerGap()
/*  303 */           .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  304 */             .addComponent(this.w)
/*  305 */             .addComponent(this.I))
/*  306 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  307 */           .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  308 */             .addComponent(this.H, -2, 350, -2)
/*  309 */             .addComponent(this.v, -2, 350, -2))
/*  310 */           .addGap(18, 18, 18)
/*  311 */           .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  312 */             .addGroup(groupLayout1.createSequentialGroup()
/*  313 */               .addComponent(this.u)
/*  314 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  315 */               .addComponent(this.t, -2, 150, -2))
/*  316 */             .addGroup(groupLayout1.createSequentialGroup()
/*  317 */               .addComponent(this.B)
/*  318 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  319 */               .addComponent(this.F)
/*  320 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  321 */               .addComponent(this.J, -2, -1, -2)
/*  322 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  323 */               .addComponent(this.x, -2, -1, -2)
/*  324 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  325 */               .addComponent(this.C)))
/*  326 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  327 */           .addComponent((Component)this.b, -2, -1, -2)
/*  328 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  329 */           .addComponent(this.d, -2, 40, -2)
/*  330 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  331 */           .addComponent((Component)this.b, -2, 40, -2)
/*  332 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  333 */           .addComponent(this.c, -2, 40, -2)
/*  334 */           .addContainerGap()));
/*      */     
/*  336 */     groupLayout1.setVerticalGroup(groupLayout1
/*  337 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  338 */         .addGroup(groupLayout1.createSequentialGroup()
/*  339 */           .addContainerGap()
/*  340 */           .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  341 */             .addComponent(this.c, -2, 40, -2)
/*  342 */             .addComponent((Component)this.b, -2, 40, -2)
/*  343 */             .addGroup(groupLayout1.createSequentialGroup()
/*  344 */               .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  345 */                 .addComponent(this.u)
/*  346 */                 .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  347 */                   .addComponent(this.H, -2, 20, -2)
/*  348 */                   .addComponent(this.t, -2, 20, -2)
/*  349 */                   .addComponent(this.I, GroupLayout.Alignment.TRAILING)))
/*  350 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  351 */               .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  352 */                 .addComponent(this.w)
/*  353 */                 .addComponent(this.v, -2, 20, -2)
/*  354 */                 .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  355 */                   .addComponent(this.x, -2, -1, -2)
/*  356 */                   .addComponent(this.C)
/*  357 */                   .addComponent(this.F)
/*  358 */                   .addComponent(this.J, -2, -1, -2)
/*  359 */                   .addComponent(this.B))))
/*  360 */             .addComponent((Component)this.b, -2, -1, -2)
/*  361 */             .addComponent(this.d, -2, 40, -2))
/*  362 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  365 */     this.d.setAlignmentX(0.0F);
/*  366 */     this.d.setAlignmentY(0.0F);
/*  367 */     this.d.setPreferredSize(new Dimension(1250, 470));
/*      */     
/*  369 */     this.a.setHorizontalScrollBarPolicy(31);
/*  370 */     this.a.setVerticalScrollBarPolicy(22);
/*      */     
/*  372 */     this.a.setMinimumSize(new Dimension(1227, 0));
/*  373 */     this.a.setViewportView(this.a);
/*      */     
/*  375 */     GroupLayout groupLayout2 = new GroupLayout(this.d);
/*  376 */     this.d.setLayout(groupLayout2);
/*  377 */     groupLayout2.setHorizontalGroup(groupLayout2
/*  378 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  379 */         .addComponent(this.a, GroupLayout.Alignment.TRAILING));
/*      */     
/*  381 */     groupLayout2.setVerticalGroup(groupLayout2
/*  382 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  383 */         .addComponent(this.a, -1, 296, 32767));
/*      */ 
/*      */     
/*  386 */     this.a.setMinimumSize(new Dimension(1245, 193));
/*  387 */     this.a.setPreferredSize(new Dimension(1245, 193));
/*  388 */     this.a.addChangeListener(new ChangeListener(this) {
/*      */           public void stateChanged(ChangeEvent param1ChangeEvent) {
/*  390 */             b.a(this.a, param1ChangeEvent);
/*      */           }
/*      */         });
/*      */     
/*  394 */     this.d.setHorizontalScrollBarPolicy(31);
/*  395 */     this.d.setVerticalScrollBarPolicy(22);
/*      */     
/*  397 */     this.a.getTableHeader().setReorderingAllowed(false);
/*  398 */     this.d.setViewportView(this.a);
/*  399 */     if (this.a.getColumnModel().getColumnCount() > 0) {
/*  400 */       this.a.getColumnModel().getColumn(0).setResizable(false);
/*  401 */       this.a.getColumnModel().getColumn(1).setResizable(false);
/*  402 */       this.a.getColumnModel().getColumn(2).setResizable(false);
/*  403 */       this.a.getColumnModel().getColumn(3).setResizable(false);
/*      */     } 
/*      */     
/*  406 */     GroupLayout groupLayout3 = new GroupLayout(this.g);
/*  407 */     this.g.setLayout(groupLayout3);
/*  408 */     groupLayout3.setHorizontalGroup(groupLayout3
/*  409 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  410 */         .addComponent(this.d, -1, 1240, 32767));
/*      */     
/*  412 */     groupLayout3.setVerticalGroup(groupLayout3
/*  413 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  414 */         .addComponent(this.d, -1, 167, 32767));
/*      */ 
/*      */     
/*  417 */     this.a.addTab("Mensagens do Chat", this.g);
/*      */     
/*  419 */     this.d.setModel((TableModel)new d());
/*  420 */     this.d.getTableHeader().setReorderingAllowed(false);
/*  421 */     this.c.setViewportView(this.d);
/*      */     
/*  423 */     this.z.setText("Item:");
/*      */     
/*  425 */     this.c.setEditable(false);
/*  426 */     this.c.setHorizontalAlignment(0);
/*      */     
/*  428 */     this.A.setForeground(y.d());
/*      */     
/*  430 */     GroupLayout groupLayout4 = new GroupLayout(this.h);
/*  431 */     this.h.setLayout(groupLayout4);
/*  432 */     groupLayout4.setHorizontalGroup(groupLayout4
/*  433 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  434 */         .addGroup(groupLayout4.createSequentialGroup()
/*  435 */           .addContainerGap()
/*  436 */           .addComponent(this.z)
/*  437 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  438 */           .addComponent(this.c, -2, 77, -2)
/*  439 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  440 */           .addComponent(this.A)
/*  441 */           .addContainerGap()));
/*      */     
/*  443 */     groupLayout4.setVerticalGroup(groupLayout4
/*  444 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  445 */         .addGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  446 */           .addComponent(this.z, -1, -1, 32767)
/*  447 */           .addComponent(this.c, -2, -1, -2)
/*  448 */           .addComponent(this.A)));
/*      */ 
/*      */     
/*  451 */     GroupLayout groupLayout5 = new GroupLayout(this.k);
/*  452 */     this.k.setLayout(groupLayout5);
/*  453 */     groupLayout5.setHorizontalGroup(groupLayout5
/*  454 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  455 */         .addComponent(this.c, -1, 1240, 32767)
/*  456 */         .addComponent(this.h, -1, -1, 32767));
/*      */     
/*  458 */     groupLayout5.setVerticalGroup(groupLayout5
/*  459 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  460 */         .addGroup(GroupLayout.Alignment.TRAILING, groupLayout5.createSequentialGroup()
/*  461 */           .addGap(6, 6, 6)
/*  462 */           .addComponent(this.h, -2, -1, -2)
/*  463 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  464 */           .addComponent(this.c, -1, 133, 32767)));
/*      */ 
/*      */     
/*  467 */     this.a.addTab("Melhores Lances", this.k);
/*      */     
/*  469 */     this.b.setVerticalScrollBarPolicy(22);
/*      */     
/*  471 */     this.b.setMinimumSize(new Dimension(1222, 0));
/*  472 */     this.b.getTableHeader().setReorderingAllowed(false);
/*  473 */     this.b.setViewportView((Component)this.b);
/*  474 */     if (this.b.getColumnModel().getColumnCount() > 0) {
/*  475 */       this.b.getColumnModel().getColumn(0).setResizable(false);
/*  476 */       this.b.getColumnModel().getColumn(1).setResizable(false);
/*  477 */       this.b.getColumnModel().getColumn(2).setResizable(false);
/*  478 */       this.b.getColumnModel().getColumn(3).setResizable(false);
/*  479 */       this.b.getColumnModel().getColumn(4).setResizable(false);
/*  480 */       this.b.getColumnModel().getColumn(5).setResizable(false);
/*  481 */       this.b.getColumnModel().getColumn(6).setResizable(false);
/*      */     } 
/*      */     
/*  484 */     GroupLayout groupLayout6 = new GroupLayout(this.i);
/*  485 */     this.i.setLayout(groupLayout6);
/*  486 */     groupLayout6.setHorizontalGroup(groupLayout6
/*  487 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  488 */         .addComponent((Component)this.b, -1, 1240, 32767));
/*      */     
/*  490 */     groupLayout6.setVerticalGroup(groupLayout6
/*  491 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  492 */         .addComponent((Component)this.b, GroupLayout.Alignment.TRAILING, -1, 167, 32767));
/*      */ 
/*      */     
/*  495 */     this.a.addTab("Itens Encerrados", this.i);
/*      */     
/*  497 */     this.e.setVerticalScrollBarPolicy(22);
/*      */     
/*  499 */     this.c.setModel((TableModel)new br.com.arremate.l.q.b(a()));
/*  500 */     this.c.getTableHeader().setReorderingAllowed(false);
/*  501 */     this.e.setViewportView(this.c);
/*      */     
/*  503 */     GroupLayout groupLayout7 = new GroupLayout(this.j);
/*  504 */     this.j.setLayout(groupLayout7);
/*  505 */     groupLayout7.setHorizontalGroup(groupLayout7
/*  506 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  507 */         .addComponent(this.e, -1, 1240, 32767));
/*      */     
/*  509 */     groupLayout7.setVerticalGroup(groupLayout7
/*  510 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  511 */         .addComponent(this.e, -1, 167, 32767));
/*      */ 
/*      */     
/*  514 */     this.a.addTab("Operações Realizadas", this.j);
/*      */     
/*  516 */     this.G.setIcon(new ImageIcon(getClass().getResource("/img/disputa_parada.png")));
/*  517 */     this.G.setText("Disputa parada ");
/*      */     
/*  519 */     this.y.setText("Tempo de resposta do portal:");
/*  520 */     this.y.setToolTipText("");
/*      */     
/*  522 */     this.D.setHorizontalAlignment(4);
/*  523 */     this.D.setText("0s");
/*  524 */     this.D.setToolTipText("Indica o tempo (em segundos) que o portal demorou para enviar as informações da disputa");
/*  525 */     this.D.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/*  527 */     this.n.setText("Última Atualização:");
/*      */     
/*  529 */     this.E.setText("00:00:00");
/*  530 */     this.E.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/*  532 */     GroupLayout groupLayout8 = new GroupLayout(this.e);
/*  533 */     this.e.setLayout(groupLayout8);
/*  534 */     groupLayout8.setHorizontalGroup(groupLayout8
/*  535 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  536 */         .addGroup(GroupLayout.Alignment.TRAILING, groupLayout8.createSequentialGroup()
/*  537 */           .addContainerGap()
/*  538 */           .addComponent(this.n)
/*  539 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  540 */           .addComponent(this.E)
/*  541 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  542 */           .addComponent(this.y)
/*  543 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  544 */           .addComponent(this.D, -2, 60, -2)
/*  545 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  546 */           .addComponent(this.G)
/*  547 */           .addContainerGap()));
/*      */     
/*  549 */     groupLayout8.setVerticalGroup(groupLayout8
/*  550 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  551 */         .addGroup(GroupLayout.Alignment.TRAILING, groupLayout8.createSequentialGroup()
/*  552 */           .addGap(0, 0, 32767)
/*  553 */           .addGroup(groupLayout8.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  554 */             .addComponent(this.G)
/*  555 */             .addComponent(this.y)
/*  556 */             .addComponent(this.D)
/*  557 */             .addComponent(this.n)
/*  558 */             .addComponent(this.E))));
/*      */ 
/*      */     
/*  561 */     GroupLayout groupLayout9 = new GroupLayout(this);
/*  562 */     setLayout(groupLayout9);
/*  563 */     groupLayout9.setHorizontalGroup(groupLayout9
/*  564 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  565 */         .addComponent(this.f, -1, 1245, 32767)
/*  566 */         .addComponent(this.d, -1, 1245, 32767)
/*  567 */         .addComponent(this.e, -1, -1, 32767)
/*  568 */         .addComponent(this.a, -1, -1, 32767));
/*      */     
/*  570 */     groupLayout9.setVerticalGroup(groupLayout9
/*  571 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  572 */         .addGroup(groupLayout9.createSequentialGroup()
/*  573 */           .addComponent(this.f, -2, -1, -2)
/*  574 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  575 */           .addComponent(this.d, -1, 296, 32767)
/*  576 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  577 */           .addComponent(this.e, -2, -1, -2)
/*  578 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  579 */           .addComponent(this.a, -2, -1, -2)
/*  580 */           .addGap(0, 0, 0)));
/*      */   }
/*      */   private JTable c; private JTable d; private JLabel F; private JPanel g; private JPanel h; private JPanel i;
/*      */   private JPanel j;
/*      */   
/*      */   private void n() {
/*  586 */     String str1 = this.a.aV();
/*      */     
/*  588 */     String str2 = a().a().bv();
/*  589 */     String str3 = a().bS();
/*  590 */     String str4 = this.a.a().bs();
/*      */ 
/*      */     
/*  593 */     if (str4 != null && !str4.isEmpty()) {
/*  594 */       this.u.setText("Data Encerramento");
/*  595 */       str3 = str4;
/*      */     } 
/*      */     
/*  598 */     this.n.setVisible(false);
/*  599 */     this.E.setVisible(false);
/*      */     
/*  601 */     this.H.setText(str1);
/*  602 */     this.H.setToolTipText(str1);
/*  603 */     this.v.setText(str2);
/*  604 */     this.v.setToolTipText(str2);
/*  605 */     this.t.setText(str3);
/*      */     
/*  607 */     this.x.setVisible(false);
/*      */     
/*  609 */     if (a().k()) {
/*  610 */       this.x.setVisible(true);
/*      */     }
/*      */     
/*  613 */     o o = a().b().a();
/*      */     
/*  615 */     if (o.equals(o.j) || o.equals(o.r)) {
/*  616 */       List list = a().L();
/*  617 */       long l2 = list.stream().filter(parame -> parame.a().aZ()).count();
/*  618 */       if (l2 <= 0L) {
/*  619 */         this.J.setText("Global");
/*  620 */         this.J.setToolTipText("Os lances serão por valor global");
/*  621 */       } else if (l2 > 0L && l2 < list.size()) {
/*  622 */         this.J.setText("Global e Unitário");
/*  623 */         this.J.setToolTipText("A licitação possui itens que terão os seus lances tanto por valor global quanto por valor unitário");
/*      */       } 
/*  625 */     } else if (!a().aZ()) {
/*  626 */       this.J.setText("Global");
/*  627 */       this.J.setToolTipText("Os lances serão por valor global");
/*      */     } 
/*      */     
/*  630 */     l l1 = a().a();
/*  631 */     boolean bool = (l1.equals(l.c) || l1.equals(l.g)) ? true : false;
/*  632 */     if (!o.equals(o.a) || !bool) {
/*  633 */       String str = "Aleatório";
/*  634 */       m m = a().a();
/*      */       
/*  636 */       if (null != m && !m.equals(m.e)) {
/*  637 */         str = m.getDescription();
/*      */       }
/*      */       
/*  640 */       this.F.setText(str);
/*      */     } else {
/*  642 */       this.F.setVisible(false);
/*      */     } 
/*      */     
/*  645 */     this.B.setText(l1.getDescription());
/*  646 */     this.C.setVisible(a().b().aF());
/*      */   }
/*      */   private JPanel k; private JButton d; private JLabel G; private j b; private JLabel H;
/*      */   private JLabel I;
/*      */   private JLabel J;
/*      */   
/*      */   public void o() {
/*  653 */     if (q()) {
/*      */       return;
/*      */     }
/*      */     
/*  657 */     (new Thread(new Runnable(this)
/*      */         {
/*      */           public void run() {
/*  660 */             b.a(this.a, false);
/*      */             
/*      */             try {
/*  663 */               if (!r()) {
/*  664 */                 this.a.a(f.b);
/*  665 */                 b.a(this.a).setIcon(b.a(this.a));
/*      */               } 
/*  667 */             } catch (Exception exception) {
/*  668 */               b.a().warn("Failed start proccess", exception);
/*      */             } 
/*      */             
/*  671 */             b.a(this.a, true);
/*      */           }
/*      */           
/*      */           private boolean r() {
/*  675 */             b.a().info("iniciando disputa: " + this.a.a().v());
/*  676 */             d d = this.a.a().a();
/*  677 */             String str1 = Long.toString(d.x());
/*  678 */             boolean bool = k.n(g.a().e(str1));
/*      */             
/*  680 */             if (d.b().a() != o.q && !bool) {
/*  681 */               this.a.a("Empresa com CNPJ inválido na API", false);
/*  682 */               return false;
/*      */             } 
/*      */ 
/*      */             
/*  686 */             if (!this.a.a().b().aC()) {
/*  687 */               this.a.a("Configurações inválidas ao iniciar disputa", false);
/*  688 */               return false;
/*      */             } 
/*      */             
/*  691 */             if (this.a.a().a() != m.a) {
/*  692 */               if (this.a.a().b().a() == o.f || this.a
/*  693 */                 .a().b().a() == o.g || this.a
/*  694 */                 .a().b().a() == o.k || this.a
/*  695 */                 .a().b().a() == o.o || this.a
/*  696 */                 .a().b().a() == o.p) {
/*  697 */                 JOptionPane.showMessageDialog((Component)n.a(), "A disputa dos modos Aberto e Aberto/Fechado ainda não está disponível para este portal.");
/*  698 */                 return false;
/*      */               } 
/*      */               
/*  701 */               if (!this.a.a().G().isEmpty()) {
/*  702 */                 if (this.a.a().L().stream().filter(param1e -> param1e instanceof br.com.arremate.l.q.b.g).anyMatch(param1e -> (param1e.w() == v.b.v()))) {
/*  703 */                   JOptionPane.showMessageDialog((Component)n.a(), "A disputa de Grupo por maior desconto para os modos Aberto e Aberto/Fechado ainda não está disponível.");
/*  704 */                   return false;
/*      */                 } 
/*      */                 
/*  707 */                 if (this.a.a().k()) {
/*  708 */                   JOptionPane.showMessageDialog((Component)n.a(), "A disputa de Grupo por equalização de ICMS para os modos Aberto e Aberto/Fechado ainda não está disponível.");
/*  709 */                   return false;
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */             
/*  714 */             if (this.a.a().b().a() == o.b) {
/*  715 */               i i = a.a().a(this.a.a().v());
/*  716 */               List<?> list = b.a(this.a, i);
/*  717 */               if (!list.isEmpty()) {
/*  718 */                 List<?> list1 = b.a(this.a);
/*  719 */                 ArrayList arrayList = new ArrayList(list);
/*  720 */                 arrayList.removeAll(list1);
/*  721 */                 if (!arrayList.isEmpty()) {
/*  722 */                   int j = JOptionPane.showConfirmDialog((Component)n.a(), "Recomendados que não existam mais de um Disputar aberto com essa mesma disputa iniciada.\nIgnorar essa sugestão pode causar problemas no envio dos lances.\nDeseja continuar?", "Aviso", 0, 2);
/*      */ 
/*      */ 
/*      */                   
/*  726 */                   if (j == 1) {
/*  727 */                     return false;
/*      */                   }
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */             
/*  733 */             this.a.a(f.i);
/*      */             
/*  735 */             this.a.t();
/*  736 */             this.a.a().clear();
/*      */             
/*  738 */             if (!d.aO()) {
/*  739 */               this.a.a("Falha ao logar: acesso inativo", false);
/*      */               
/*  741 */               String str = "Seu acesso está inválido, antes de iniciar a disputa é necessário atualizar os dados de login da empresa " + d.bv().toUpperCase() + " na tela de configurações gerais.";
/*      */ 
/*      */               
/*  744 */               JOptionPane.showMessageDialog(null, str);
/*  745 */               d d1 = new d();
/*  746 */               d1.setVisible(true);
/*  747 */               return false;
/*      */             } 
/*      */             
/*  750 */             if (b.a(this.a).a(this.a)) {
/*      */               try {
/*  752 */                 this.a.a().clear();
/*  753 */                 this.a.a().clear();
/*  754 */                 this.a.a("Disputa Iniciada", false);
/*      */                 
/*  756 */                 b.b(this.a, true);
/*  757 */                 b.a(this.a).setIcon(b.b(this.a));
/*  758 */                 b.a(this.a).setToolTipText("Parar disputa (CTRL + P)");
/*  759 */               } catch (Exception exception) {
/*  760 */                 b.a().warn("Conseguiu dar o start, mas falhou ao preparar o painel de disputa", exception);
/*  761 */                 this.a.c(false);
/*  762 */                 return false;
/*      */               } 
/*      */               
/*  765 */               j.a().a(this.a.a(), this.a.a());
/*  766 */               return true;
/*      */             } 
/*  768 */             this.a.a("Falha ao realizar login", false);
/*  769 */             String str2 = "Falha ao realizar o login no portal";
/*  770 */             if (b.a(this.a).aY() != null && !b.a(this.a).aY().isEmpty()) {
/*  771 */               str2 = b.a(this.a).aY();
/*      */             }
/*      */             
/*  774 */             JOptionPane.showMessageDialog(null, str2, "Erro", 0);
/*      */ 
/*      */             
/*  777 */             return false;
/*      */           }
/*  779 */         })).start();
/*      */   }
/*      */ 
/*      */   
/*      */   private List<String> c() {
/*      */     try {
/*  785 */       Statement statement = a.a().createStatement();
/*  786 */       ResultSet resultSet = statement.executeQuery("SELECT sessionid FROM TBSESSIONID WHERE sessioniddate > CURRENT_DATE()");
/*  787 */       ArrayList<String> arrayList = new ArrayList();
/*  788 */       while (resultSet.next()) {
/*  789 */         arrayList.add(resultSet.getString("sessionid"));
/*      */       }
/*  791 */       return arrayList;
/*  792 */     } catch (SQLException sQLException) {
/*  793 */       a.error("Erro ao carregar session ids", sQLException);
/*  794 */       return null;
/*      */     } 
/*      */   }
/*      */   
/*      */   private List<String> a(i parami) {
/*  799 */     ArrayList<String> arrayList = new ArrayList();
/*  800 */     if (parami != null && !parami.isNull("data")) {
/*  801 */       f f1 = parami.c("data");
/*  802 */       for (byte b1 = 0; b1 < f1.length(); b1++) {
/*  803 */         arrayList.add(f1.getString(b1));
/*      */       }
/*      */       
/*  806 */       return arrayList;
/*      */     } 
/*      */     
/*  809 */     return arrayList;
/*      */   }
/*      */   
/*      */   private void b(boolean paramBoolean) {
/*  813 */     r r = paramBoolean ? r.a : r.b;
/*  814 */     a().L().parallelStream().forEach(parame -> parame.a(paramr));
/*      */ 
/*      */ 
/*      */     
/*  818 */     a((a)new br.com.arremate.l.q.b.b());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void c(boolean paramBoolean) {
/*      */     try {
/*  826 */       if (!q()) {
/*      */         return;
/*      */       }
/*      */       
/*  830 */       a("Parar disputa", false);
/*  831 */       d(false);
/*  832 */       if (this.c != null) {
/*  833 */         this.c.cancel();
/*      */       }
/*      */       
/*  836 */       if (this.a.al()) {
/*  837 */         b(false);
/*      */         
/*      */         try {
/*  840 */           n.a().a(a(), Color.BLACK);
/*  841 */           this.b.stop();
/*  842 */           j.a().a(a(), paramBoolean);
/*  843 */         } catch (Exception exception) {}
/*      */       }
/*      */     
/*  846 */     } catch (Exception exception) {
/*  847 */       a.error("Falha ao pausar a disputa", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void b(ActionEvent paramActionEvent) {
/*  857 */     this.b.setFocusable(false);
/*      */     
/*  859 */     p();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void p() {
/*  867 */     a("Tela Configurações da Disputa aberta", false);
/*      */     
/*  869 */     f f1 = new f(a(), this);
/*  870 */     f1.setVisible(true);
/*  871 */     a().fireTableDataChanged();
/*  872 */     this.C.setVisible(a().b().aF());
/*      */   }
/*      */   
/*      */   private void c(ActionEvent paramActionEvent) {
/*  876 */     q();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void d(ActionEvent paramActionEvent) {
/*  885 */     if (q()) {
/*  886 */       this.i = true;
/*  887 */       c(true);
/*      */       
/*  889 */       (new Thread(() -> {
/*      */             try {
/*      */               Thread.sleep(this.a.q());
/*  892 */             } catch (InterruptedException interruptedException) {}
/*      */             
/*      */             if (this.i != null) {
/*      */               StringBuilder stringBuilder = new StringBuilder();
/*      */               
/*      */               stringBuilder.append("<html>");
/*      */               
/*      */               stringBuilder.append("<font size=\"4\">Notamos que está demorando para carregar as informações. Deseja interromper este processo?</font>");
/*      */               
/*      */               stringBuilder.append("<br>");
/*      */               
/*      */               stringBuilder.append("Isto pode fazer com que as informações dos itens não terminem de ser carregadas.");
/*      */               
/*      */               stringBuilder.append("</html>");
/*      */               
/*      */               int i = JOptionPane.showConfirmDialog(null, stringBuilder.toString(), "Mensagem", 0, 2);
/*      */               
/*      */               if (i == 0) {
/*      */                 this.a.interrupt();
/*      */               }
/*      */               
/*      */               this.i = false;
/*      */             } 
/*  915 */           })).start();
/*      */     } else {
/*  917 */       o();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void d(ChangeEvent paramChangeEvent) {
/*  922 */     if (this.a.getSelectedIndex() != 3) {
/*  923 */       this.j = false;
/*      */     }
/*      */     
/*  926 */     if (this.a.getSelectedIndex() == 2) {
/*  927 */       j.a().g(a());
/*  928 */     } else if (this.a.getSelectedIndex() == 3) {
/*  929 */       this.j = true;
/*      */       
/*  931 */       (new Thread(() -> {
/*      */             try {
/*      */               Thread.sleep(15000L);
/*  934 */             } catch (InterruptedException interruptedException) {}
/*      */             
/*      */             if (this.j != null) {
/*      */               j.a().i(a());
/*      */               
/*      */               this.j = false;
/*      */             } 
/*  941 */           })).start();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void q() {
/*  946 */     this.a.setVisible(true);
/*  947 */     j.a().h(a());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void d(boolean paramBoolean) {
/*  958 */     this.d.setEnabled(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void r() {
/*  965 */     d(true);
/*  966 */     this.d.setIcon((Icon)this.a);
/*  967 */     this.d.setToolTipText("Iniciar disputa (CTRL + I)");
/*  968 */     this.i = false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void s() {
/*  975 */     this.a.a(this, (k)this.b);
/*  976 */     j.a().k(a());
/*      */   }
/*      */   
/*      */   public void g(String paramString) {
/*  980 */     this.a.a(this, (k)this.b, paramString);
/*  981 */     j.a().k(a());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void t() {
/*      */     try {
/*  989 */       this.a.a(a(), a());
/*  990 */     } catch (Exception exception) {
/*  991 */       a("#007 - Falha ao gerar o log da licitação");
/*  992 */       a.warn("#007 - Falha ao gerar o log da licitação", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void u() {
/*      */     try {
/* 1001 */       this.a.b(a(), a());
/* 1002 */     } catch (Exception exception) {
/* 1003 */       a("#007 - Falha ao enviar log para API");
/* 1004 */       a.warn("#007 - Falha ao enviar log para API", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(h paramh) {
/* 1014 */     synchronized ("addMelhorLance") {
/* 1015 */       d d = (d)this.d.getModel();
/*      */       
/* 1017 */       if (paramh != null) {
/* 1018 */         c c = new c(paramh);
/* 1019 */         d.a(c);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void a(m paramm) {
/* 1025 */     a a = new a(paramm);
/* 1026 */     c c = (c)this.a.getModel();
/* 1027 */     c.a(a);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void v() {
/* 1034 */     this.a.addMouseListener(new MouseAdapter(this)
/*      */         {
/*      */           public void mouseClicked(MouseEvent param1MouseEvent) {
/* 1037 */             int i = b.a(this.a).rowAtPoint(param1MouseEvent.getPoint());
/* 1038 */             int j = b.a(this.a).columnAtPoint(param1MouseEvent.getPoint());
/*      */             
/* 1040 */             if (i < 0) {
/*      */               return;
/*      */             }
/*      */             
/* 1044 */             if (param1MouseEvent.getClickCount() == 2 && j == 10) {
/* 1045 */               b.a(this.a, i);
/*      */               
/*      */               return;
/*      */             } 
/* 1049 */             switch (j) {
/*      */               case 0:
/* 1051 */                 b.a(this.a, i);
/*      */                 break;
/*      */               case 1:
/* 1054 */                 b.b(this.a, i);
/*      */                 break;
/*      */               case 2:
/* 1057 */                 b.c(this.a, i);
/*      */                 break;
/*      */               case 3:
/* 1060 */                 b.d(this.a, i);
/*      */                 break;
/*      */               case 4:
/* 1063 */                 b.e(this.a, i);
/*      */                 break;
/*      */               case 13:
/* 1066 */                 b.f(this.a, i);
/*      */                 break;
/*      */             } 
/*      */ 
/*      */           
/*      */           }
/*      */         });
/* 1073 */     a().addTableModelListener(paramTableModelEvent -> {
/*      */           int i = paramTableModelEvent.getFirstRow();
/*      */           
/*      */           int k = paramTableModelEvent.getColumn();
/*      */           
/*      */           if (k == 10) {
/*      */             e e1 = a().b(i);
/*      */             c(e1);
/*      */           } else if (k == 11 && a().a() == m.c) {
/*      */             e e1 = a().b(i);
/*      */             d(e1);
/*      */           } 
/*      */         });
/* 1086 */     Map<Integer, Integer> map = this.a.m();
/* 1087 */     this.a.aj(((Integer)map.get(Integer.valueOf(7))).intValue());
/* 1088 */     this.a.ak(((Integer)map.get(Integer.valueOf(8))).intValue());
/* 1089 */     this.a.al(((Integer)map.get(Integer.valueOf(9))).intValue());
/* 1090 */     this.a.am(((Integer)map.get(Integer.valueOf(10))).intValue());
/* 1091 */     this.a.an(((Integer)map.get(Integer.valueOf(11))).intValue());
/* 1092 */     this.a.ao(((Integer)map.get(Integer.valueOf(12))).intValue());
/* 1093 */     this.a.ap(((Integer)map.get(Integer.valueOf(13))).intValue());
/*      */     
/* 1095 */     a((JTable)this.a, map);
/* 1096 */     a((a)new br.com.arremate.l.q.b.b());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void p(int paramInt) {
/* 1107 */     int i = this.a.convertRowIndexToModel(paramInt);
/* 1108 */     e e1 = a().b(i);
/*      */     
/* 1110 */     if (!(e1 instanceof f)) {
/*      */       return;
/*      */     }
/* 1113 */     f f1 = (f)e1;
/*      */     
/* 1115 */     a().setValueAt(f1.cq(), i, 0);
/* 1116 */     a a = (a)(q() ? new c() : new br.com.arremate.l.q.b.b());
/*      */ 
/*      */     
/* 1119 */     a(a);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void q(int paramInt) {
/* 1129 */     int i = this.a.convertRowIndexToModel(paramInt);
/* 1130 */     e e1 = a().b(i);
/*      */     
/* 1132 */     if (e1 == null || e1 instanceof br.com.arremate.l.q.b.g) {
/*      */       return;
/*      */     }
/*      */     
/* 1136 */     g g1 = new g(e1, this);
/*      */     
/* 1138 */     if (!(e1 instanceof f)) {
/* 1139 */       a(e1.a(), g1);
/*      */     }
/*      */     
/* 1142 */     g1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void a(g paramg, g paramg1) {
/* 1146 */     BigDecimal bigDecimal1 = paramg.r();
/* 1147 */     BigDecimal bigDecimal2 = paramg.s();
/* 1148 */     d d = new d();
/* 1149 */     String str = "";
/*      */     
/* 1151 */     if (bigDecimal1.compareTo(BigDecimal.ZERO) == 1) {
/* 1152 */       Object object = d.transformValue(Double.valueOf(bigDecimal1.doubleValue()), 0, 0, null);
/* 1153 */       str = "Valor mínimo de redução definido pelo portal: R$ " + object;
/* 1154 */     } else if (bigDecimal2.compareTo(BigDecimal.ZERO) == 1) {
/* 1155 */       Object object = d.transformValue(Double.valueOf(bigDecimal2.doubleValue()), 0, 0, null);
/*      */       
/* 1157 */       if (paramg instanceof br.com.arremate.l.a.a) {
/* 1158 */         str = "<html>Percentual mínimo de redução definido pelo portal*: " + object + "%<br>* Diferença entre os valores da melhor e da segunda melhor propostas aplicado o percentual.</html>";
/*      */       } else {
/*      */         
/* 1161 */         str = "Percentual mínimo de redução estabelecido pelo portal: " + object + "%";
/*      */       } 
/*      */     } 
/*      */     
/* 1165 */     if (!str.isEmpty()) {
/* 1166 */       paramg1.aL(str);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void r(int paramInt) {
/* 1176 */     int i = this.a.convertRowIndexToModel(paramInt);
/* 1177 */     e e1 = a().b(i);
/*      */     
/* 1179 */     if (e1 instanceof f) {
/*      */       return;
/*      */     }
/*      */     
/* 1183 */     a(e1);
/*      */   }
/*      */   
/*      */   public void w() {
/* 1187 */     a((e)null);
/*      */   }
/*      */   
/*      */   public void a(e parame) {
/* 1191 */     if (!q()) {
/* 1192 */       String str = "Certifique-se que a disputa está ativa para enviar um lance manual";
/* 1193 */       JOptionPane.showMessageDialog(null, str, "Erro", 0);
/*      */       return;
/*      */     } 
/* 1196 */     a("Tela de lance manual aberta", false);
/* 1197 */     p p = new p(this, parame);
/* 1198 */     h h1 = new h(p);
/* 1199 */     h1.setVisible(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void s(int paramInt) {
/* 1208 */     int i = this.a.convertRowIndexToModel(paramInt);
/* 1209 */     e e1 = a().b(i);
/*      */     
/* 1211 */     if (e1 instanceof br.com.arremate.l.q.b.g) {
/*      */       return;
/*      */     }
/*      */     
/* 1215 */     if (!q()) {
/* 1216 */       String str = "Para executar a ação certifique-se que a disputa está ativa";
/* 1217 */       JOptionPane.showMessageDialog(null, str, "Erro", 0);
/*      */       
/*      */       return;
/*      */     } 
/* 1221 */     if (e1.a() == r.b) {
/* 1222 */       this.a.setValueAt(r.a, paramInt, 3);
/* 1223 */       a("Botão Play pressionado para o item: " + e1.bo(), false);
/*      */     } else {
/* 1225 */       this.a.setValueAt(r.b, paramInt, 3);
/* 1226 */       a("Botão Pause pressionado para o item: " + e1.bo(), false);
/*      */     } 
/*      */     
/* 1229 */     j.a().E(e1);
/*      */   }
/*      */   
/*      */   private void t(int paramInt) {
/* 1233 */     if (a().b().bk()) {
/* 1234 */       int i = this.a.convertRowIndexToModel(paramInt);
/* 1235 */       e e1 = a().b(i);
/* 1236 */       this.a.y(e1);
/*      */       
/* 1238 */       a().fireTableCellUpdated(paramInt, 4);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void u(int paramInt) {
/* 1248 */     if (!n.aE()) {
/*      */       return;
/*      */     }
/*      */     
/* 1252 */     int i = this.a.convertRowIndexToModel(paramInt);
/* 1253 */     e e1 = a().b(i);
/*      */     
/* 1255 */     if (e1 instanceof br.com.arremate.l.q.b.g) {
/*      */       return;
/*      */     }
/*      */     
/* 1259 */     this.a.setSelectedComponent(this.k);
/* 1260 */     String str = "logMelhoresLances_" + String.valueOf(e1.v());
/*      */     
/* 1262 */     (new Thread(() -> {
/*      */           if (!a().am()) {
/*      */             return;
/*      */           }
/*      */           
/*      */           if (this.a != null && this.a.v() != parame.v() && this.c != null) {
/*      */             this.c.cancel();
/*      */             
/*      */             this.c = null;
/*      */           } 
/*      */           
/*      */           try {
/*      */             this.A.setText("Carregando os melhores lances, aguarde um momento... ");
/*      */             
/*      */             this.A.setIcon(new ImageIcon(getClass().getResource("/img/loading-blue.gif")));
/*      */             
/*      */             a().clear();
/*      */             
/*      */             String str = (parame instanceof f) ? "Grupo: " : "Item: ";
/*      */             
/*      */             this.z.setText(str);
/*      */             
/*      */             this.c.setText(parame.bo());
/*      */             List list = a().b(parame);
/*      */             if (list == null || list.isEmpty()) {
/*      */               JOptionPane.showMessageDialog(null, a().aX(), "Mensagem", 0);
/*      */             } else {
/*      */               list.forEach(());
/*      */               j.a().b(parame, list);
/*      */               if (q()) {
/*      */                 b(parame);
/*      */               }
/*      */             } 
/* 1295 */           } catch (Exception exception) {
/*      */             JOptionPane.showMessageDialog(null, "Não foi possível capturar os melhores lances do portal no momento", "Mensagem", 0);
/*      */           } finally {
/*      */             a().ck();
/*      */             this.A.setText("");
/*      */             this.A.setIcon((Icon)null);
/*      */           } 
/* 1302 */         }str)).start();
/*      */   }
/*      */   
/*      */   private void b(e parame) {
/* 1306 */     if (this.a != null && this.a.v() == parame.v()) {
/*      */       return;
/*      */     }
/*      */     
/* 1310 */     this.a = (JTabbedPane)parame;
/* 1311 */     long l1 = TimeUnit.SECONDS.toMillis(20L);
/* 1312 */     this.c = (JTable)new Timer();
/* 1313 */     this.c.schedule(new TimerTask(this, parame) {
/* 1314 */           private final int F = this.b.v();
/*      */ 
/*      */           
/*      */           public void run() {
/* 1318 */             b.a().debug("Running timer of item {}", Integer.valueOf(this.F));
/* 1319 */             e e1 = b.a(this.a);
/* 1320 */             if (!b.a(this.a).getTitleAt(b.a(this.a).getSelectedIndex()).equals("Melhores Lances")) {
/*      */               return;
/*      */             }
/*      */             
/* 1324 */             if (!this.a.a().am()) {
/* 1325 */               b.a().debug("Return timer of item {}", Integer.valueOf(this.F));
/*      */               
/*      */               return;
/*      */             } 
/*      */             try {
/* 1330 */               b.a(this.a).setText("Carregando os melhores lances, aguarde um momento... ");
/* 1331 */               b.a(this.a).setIcon(new ImageIcon(getClass().getResource("/img/loading-blue.gif")));
/*      */               
/* 1333 */               b.a().debug("Getting best bids at timer of item {}", Integer.valueOf(this.F));
/* 1334 */               List list = this.a.a().b(e1);
/*      */               
/* 1336 */               if (list != null && !list.isEmpty()) {
/* 1337 */                 b.a().debug("Updating best bids at timer of item {}", Integer.valueOf(this.F));
/* 1338 */                 this.a.a().clear();
/*      */                 
/* 1340 */                 list.forEach(param1h -> this.a.a(param1h));
/*      */               }
/*      */             
/*      */             }
/* 1344 */             catch (Exception exception) {
/* 1345 */               b.a().info("Exception while reloading best bids", exception);
/*      */             } finally {
/* 1347 */               this.a.a().ck();
/* 1348 */               b.a(this.a).setText("");
/* 1349 */               b.a(this.a).setIcon((Icon)null);
/* 1350 */               b.a().debug("Finish timer of item {}", Integer.valueOf(this.F));
/*      */             } 
/*      */           }
/*      */         }l1, l1);
/*      */   }
/*      */   
/*      */   private void c(e parame) {
/* 1357 */     if (parame == null) {
/*      */       return;
/*      */     }
/*      */     
/*      */     try {
/* 1362 */       this.a.z(parame);
/*      */       
/* 1364 */       String str1 = "R$ " + a(parame.l());
/*      */       
/* 1366 */       if (parame.w() == v.b.v()) {
/* 1367 */         str1 = parame.l() + "%";
/*      */       }
/*      */       
/* 1370 */       String str2 = "Valor limite do item " + parame.bo() + " alterado para " + str1;
/* 1371 */       a(str2, false);
/* 1372 */       a.info(str2);
/*      */       
/* 1374 */       if (!(parame instanceof f)) {
/* 1375 */         j.a().C(parame);
/*      */       }
/* 1377 */     } catch (Exception exception) {
/* 1378 */       a.info("Falha ao atualizar valor limite", exception);
/* 1379 */       JOptionPane.showMessageDialog(null, "Erro atualizar valor mínimo para o item", "Mensagem", 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void d(e parame) {
/* 1385 */     if (parame == null) {
/*      */       return;
/*      */     }
/*      */     
/*      */     try {
/* 1390 */       this.a.A(parame);
/*      */       
/* 1392 */       String str1 = "R$ " + a(parame.y().doubleValue());
/*      */       
/* 1394 */       if (parame.w() == v.b.v()) {
/* 1395 */         str1 = parame.y().doubleValue() + "%";
/*      */       }
/*      */       
/* 1398 */       String str2 = "Valor lance fechado do item " + parame.bo() + " alterado para " + str1;
/* 1399 */       a(str2, false);
/* 1400 */       a.info(str2);
/*      */       
/* 1402 */       if (!(parame instanceof f)) {
/* 1403 */         j.a().D(parame);
/*      */       }
/* 1405 */     } catch (Exception exception) {
/* 1406 */       a.info("Falha ao atualizar valor lance fechado", exception);
/* 1407 */       JOptionPane.showMessageDialog(null, "Erro atualizar valor lance fechado para o item", "Mensagem", 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(JTable paramJTable, Map<Integer, Integer> paramMap) {
/* 1413 */     paramMap.keySet().forEach(paramInteger -> y.a(paramJTable, paramInteger.intValue(), ((Integer)paramMap.get(paramInteger)).intValue()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void x() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void y() {
/* 1428 */     if (!n.aE()) {
/*      */       
/* 1430 */       this.a.remove(this.k);
/*      */       
/*      */       return;
/*      */     } 
/* 1434 */     this.d.setName("melhoresLancesTable");
/*      */     
/* 1436 */     br.com.arremate.i.b b1 = new br.com.arremate.i.b(this)
/*      */       {
/*      */         public Object transformValue(Object param1Object, int param1Int1, int param1Int2, TableModel param1TableModel) {
/* 1439 */           if (param1Object == null || !(param1Object instanceof Integer)) {
/* 1440 */             return "";
/*      */           }
/* 1442 */           int i = ((Integer)param1Object).intValue();
/* 1443 */           return (i == h.i.v()) ? "" : (i + "º Lugar");
/*      */         }
/*      */       };
/*      */ 
/*      */ 
/*      */     
/* 1449 */     r r1 = new r(0);
/* 1450 */     r1.a(b1);
/* 1451 */     this.d.getColumnModel().getColumn(0)
/* 1452 */       .setCellRenderer((TableCellRenderer)r1);
/*      */     
/* 1454 */     r r2 = new r(0);
/* 1455 */     r2.a((br.com.arremate.i.b)new c());
/* 1456 */     this.d.getColumnModel().getColumn(1)
/* 1457 */       .setCellRenderer((TableCellRenderer)r2);
/*      */     
/* 1459 */     r r3 = new r(0);
/* 1460 */     r3.a((br.com.arremate.i.b)new d());
/* 1461 */     this.d.getColumnModel().getColumn(2)
/* 1462 */       .setCellRenderer((TableCellRenderer)r3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void z() {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void A() {
/* 1475 */     this.c.setName("logOperacoesTable");
/*      */     
/* 1477 */     r r = new r(0);
/* 1478 */     r.a((br.com.arremate.i.b)new c());
/*      */     
/* 1480 */     this.c.getColumnModel().getColumn(z.c.a.getIndex()).setCellRenderer((TableCellRenderer)r);
/* 1481 */     this.c.getColumnModel().getColumn(z.c.b.getIndex()).setCellRenderer((TableCellRenderer)new r(2));
/*      */     
/* 1483 */     this.c.getColumnModel().getColumn(z.c.a.getIndex()).setWidth(z.c.a.aa());
/* 1484 */     this.c.getColumnModel().getColumn(z.c.a.getIndex()).setMaxWidth(z.c.a.aa());
/* 1485 */     this.c.getColumnModel().getColumn(z.c.a.getIndex()).setMinWidth(z.c.a.aa());
/* 1486 */     this.c.getColumnModel().getColumn(z.c.a.getIndex()).setPreferredWidth(z.c.a.aa());
/*      */     
/* 1488 */     this.c.getColumnModel().getColumn(z.c.c.getIndex()).setWidth(z.c.c.aa());
/* 1489 */     this.c.getColumnModel().getColumn(z.c.c.getIndex()).setMaxWidth(z.c.c.aa());
/* 1490 */     this.c.getColumnModel().getColumn(z.c.c.getIndex()).setMinWidth(z.c.c.aa());
/* 1491 */     this.c.getColumnModel().getColumn(z.c.c.getIndex()).setPreferredWidth(z.c.c.aa());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void B() {
/* 1498 */     a().clear();
/* 1499 */     List list = this.a.x();
/*      */     
/* 1501 */     list.forEach(parame -> {
/*      */           a().F(parame);
/*      */           
/*      */           if (parame.br()) {
/*      */             a(parame, (g)this.a);
/*      */           }
/*      */         });
/* 1508 */     a((a)new br.com.arremate.l.q.b.b());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void C() {
/* 1515 */     List list = this.a.x();
/* 1516 */     i i = a();
/*      */     
/* 1518 */     list.stream().forEach(parame -> {
/*      */           e e1 = parami.a(parame.v());
/*      */           
/*      */           g g1 = e1.a();
/*      */           
/*      */           if (g1 != null) {
/*      */             BigDecimal bigDecimal1 = BigDecimal.valueOf(e1.l());
/*      */             
/*      */             g1.a(parame.b());
/*      */             
/*      */             g1.o(parame.l());
/*      */             
/*      */             BigDecimal bigDecimal2 = BigDecimal.valueOf(e1.l());
/*      */             
/*      */             if (bigDecimal1.compareTo(bigDecimal2) != 0) {
/*      */               String str1 = "R$ " + a(e1.l());
/*      */               
/*      */               if (e1.w() == v.b.v()) {
/*      */                 str1 = e1.l() + "%";
/*      */               }
/*      */               
/*      */               String str2 = "Valor limite do item " + e1.bo() + " alterado para " + str1;
/*      */               
/*      */               a(str2, false);
/*      */               a.info(str2);
/*      */             } 
/*      */             if (a().a() == m.c && parame.y().compareTo(e1.y()) != 0) {
/*      */               g1.g(parame.y());
/*      */               String str1 = "R$ " + a(e1.y().doubleValue());
/*      */               if (e1.w() == v.b.v()) {
/*      */                 str1 = e1.y().doubleValue() + "%";
/*      */               }
/*      */               String str2 = "Valor lance fechado do item " + e1.bo() + " alterado para " + str1;
/*      */               a(str2, false);
/*      */               a.info(str2);
/*      */             } 
/*      */           } 
/*      */         });
/* 1556 */     i.fireTableDataChanged();
/*      */   }
/*      */   
/*      */   private String a(double paramDouble) {
/* 1560 */     DecimalFormat decimalFormat = y.a("###,###,##0.0000");
/* 1561 */     return decimalFormat.format(paramDouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public f a(e parame, g paramg) {
/* 1572 */     return a(parame, paramg, false);
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
/*      */   public f a(e parame, g paramg, boolean paramBoolean) {
/* 1584 */     n n = a();
/* 1585 */     f f1 = e.b(parame, paramg, paramBoolean);
/*      */     
/* 1587 */     n.a(f1);
/*      */     
/* 1589 */     return f1;
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
/*      */   
/*      */   public i a(String paramString) {
/* 1603 */     i i = new i();
/* 1604 */     i.f(paramString);
/* 1605 */     a((h)i);
/* 1606 */     return i;
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
/*      */ 
/*      */ 
/*      */   
/*      */   public e a(String paramString) {
/* 1622 */     return a(paramString, true, true);
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
/*      */   
/*      */   public e b(String paramString) {
/* 1636 */     return a(paramString, true);
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
/*      */   public e a(String paramString, boolean paramBoolean) {
/* 1649 */     return a(paramString, paramBoolean, false);
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
/*      */ 
/*      */   
/*      */   public e a(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/* 1664 */     e e1 = new e(paramBoolean1);
/* 1665 */     e1.f(paramString);
/* 1666 */     e1.N(paramBoolean2);
/* 1667 */     a((h)e1);
/* 1668 */     return e1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(h paramh) {
/* 1678 */     SwingWorker<Void, Void> swingWorker = new SwingWorker<Void, Void>(this, paramh)
/*      */       {
/*      */         protected Void a() throws Exception {
/* 1681 */           br.com.arremate.l.q.b b1 = (br.com.arremate.l.q.b)b.a(this.a).getModel();
/* 1682 */           b1.e((h)this.a);
/* 1683 */           return null;
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         protected void done() {
/*      */           try {
/* 1690 */             get();
/* 1691 */           } catch (Exception exception) {
/* 1692 */             b.a().info("Log that was adding when fail: {} - {}", this.a.ci(), this.a.j());
/* 1693 */             b.a().warn("Failed to refresh LogTableModel", exception);
/*      */           } 
/*      */         }
/*      */       };
/* 1697 */     swingWorker.execute();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void D() {
/* 1704 */     if (this.a.e(a().bf(), this.H.getText())) {
/*      */       
/* 1706 */       getParent().remove(this);
/* 1707 */       j.a().f(a());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void E() {
/* 1716 */     StringBuilder stringBuilder = new StringBuilder("Este procedimento irá mover o pregão ");
/* 1717 */     stringBuilder.append(a().bf());
/* 1718 */     stringBuilder.append(" do órgão ");
/* 1719 */     stringBuilder.append(this.H.getText());
/* 1720 */     stringBuilder.append("\npara a lista de pregões ocultos");
/* 1721 */     stringBuilder.append("\n\nEmpresa: ");
/* 1722 */     stringBuilder.append(this.v.getText());
/* 1723 */     stringBuilder.append("\n\nDeseja realmente realizar a operação?");
/*      */     
/* 1725 */     int i = JOptionPane.showConfirmDialog(null, stringBuilder
/*      */         
/* 1727 */         .toString(), "Mensagem", 0, 2);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1732 */     if (i == 0) {
/* 1733 */       if (a().bd()) {
/*      */         
/* 1735 */         getParent().remove(this);
/*      */         
/* 1737 */         n.a().s(a());
/*      */       } else {
/* 1739 */         String str = "Erro ao ocultar pregão, tente novamente";
/* 1740 */         JOptionPane.showMessageDialog(null, str, "Mensagem", 0);
/*      */       } 
/*      */       
/* 1743 */       j.a().o(a());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void F() {
/* 1751 */     this.a.a((h)this.a);
/* 1752 */     j.a().j(a());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void G() {
/* 1759 */     this.a.b((h)this.a);
/* 1760 */     j.a().l(a());
/*      */     
/* 1762 */     C();
/* 1763 */     u();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(f paramf) {
/* 1772 */     if (this.a != paramf) {
/* 1773 */       this.G.setText(paramf.L());
/* 1774 */       this.G.setForeground(paramf.a());
/* 1775 */       this.G.setIcon(new ImageIcon(getClass().getResource(paramf.M())));
/* 1776 */       this.a = (JTabbedPane)paramf;
/*      */       
/* 1778 */       n.a().a(a(), paramf.a());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void H() {
/* 1786 */     synchronized (this) {
/* 1787 */       if (this.b == null) {
/* 1788 */         this.b = (j)new Timer();
/* 1789 */         this.b.schedule(new TimerTask(this)
/*      */             {
/*      */               public void run() {
/*      */                 try {
/* 1793 */                   this.a.u();
/* 1794 */                 } catch (Exception exception) {
/* 1795 */                   b.a().warn("Failed to send log in DisputaController timer");
/*      */                 } 
/*      */               }
/* 1798 */             },  0L, TimeUnit.MINUTES.toMillis(5L));
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void I() {
/* 1807 */     if (this.b != null) {
/* 1808 */       this.b.cancel();
/* 1809 */       this.b = null;
/*      */     } 
/*      */   }
/*      */   public void a(a parama) {
/*      */     br.com.arremate.l.q.b.b b1;
/* 1814 */     if (parama == null) {
/* 1815 */       b1 = new br.com.arremate.l.q.b.b();
/*      */     }
/*      */     
/* 1818 */     if (q() && b1 instanceof br.com.arremate.l.q.b.b) {
/*      */       return;
/*      */     }
/* 1821 */     this.a.a((RowFilter)b1);
/*      */   }
/*      */   
/*      */   public g a() {
/* 1825 */     return (g)this.a;
/*      */   }
/*      */   
/*      */   public j a() {
/* 1829 */     return this.a.a();
/*      */   }
/*      */   
/*      */   private g a() {
/* 1833 */     return (g)this.a;
/*      */   }
/*      */   
/*      */   public boolean p() {
/* 1837 */     return (a().E().size() > 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public i a() {
/* 1846 */     return (i)this.a.getModel();
/*      */   }
/*      */   
/*      */   public h a() {
/* 1850 */     return (h)this.a;
/*      */   }
/*      */   
/*      */   public n a() {
/* 1854 */     return (n)this.b.getModel();
/*      */   }
/*      */   
/*      */   public d a() {
/* 1858 */     return (d)this.d.getModel();
/*      */   }
/*      */   
/*      */   public br.com.arremate.l.q.b a() {
/* 1862 */     return (br.com.arremate.l.q.b)this.c.getModel();
/*      */   }
/*      */   
/*      */   public c a() {
/* 1866 */     return (c)this.a.getModel();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JLabel a() {
/* 1875 */     return this.G;
/*      */   }
/*      */   
/*      */   public boolean q() {
/* 1879 */     return this.a.q();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void e(long paramLong) {
/*      */     Color color;
/* 1888 */     double d = paramLong / 1000.0D;
/* 1889 */     String str = Double.toString(d).replace(".", ",") + "s";
/* 1890 */     this.D.setText(str);
/*      */ 
/*      */ 
/*      */     
/* 1894 */     if (paramLong <= TimeUnit.SECONDS.toMillis(2L)) {
/* 1895 */       color = y.e();
/* 1896 */     } else if (paramLong <= TimeUnit.SECONDS.toMillis(5L)) {
/* 1897 */       color = y.g();
/*      */     } else {
/* 1899 */       color = y.f();
/*      */     } 
/*      */     
/* 1902 */     this.D.setBackground(color);
/* 1903 */     this.D.setForeground(color);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void f(long paramLong) {
/* 1912 */     this.E.setText(this.dateFormat.format(Long.valueOf(paramLong)));
/*      */   }
/*      */   
/*      */   public void J() {
/* 1916 */     this.n.setVisible(true);
/* 1917 */     this.E.setVisible(true);
/*      */   }
/*      */   
/*      */   public void g(long paramLong) {
/* 1921 */     this.b.d(paramLong);
/*      */   }
/*      */   
/*      */   public void K() {
/* 1925 */     this.b.start();
/*      */   }
/*      */   
/*      */   public void L() {
/* 1929 */     this.b.stop();
/*      */   }
/*      */   
/*      */   public f a() {
/* 1933 */     return (f)this.a;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */