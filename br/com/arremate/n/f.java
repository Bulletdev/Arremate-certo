/*      */ package br.com.arremate.n;
/*      */ import br.com.arremate.c.a.g;
/*      */ import br.com.arremate.c.a.i;
/*      */ import br.com.arremate.f.i;
/*      */ import br.com.arremate.f.l;
/*      */ import br.com.arremate.f.m;
/*      */ import br.com.arremate.f.o;
/*      */ import br.com.arremate.l.b;
/*      */ import br.com.arremate.l.g;
/*      */ import br.com.arremate.l.j;
/*      */ import br.com.arremate.m.y;
/*      */ import java.awt.Component;
/*      */ import java.awt.Insets;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.math.BigDecimal;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.text.DecimalFormat;
/*      */ import java.util.List;
/*      */ import java.util.StringJoiner;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.JCheckBox;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JFormattedTextField;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.text.DefaultFormatterFactory;
/*      */ 
/*      */ public class f extends JDialog {
/*      */   private final j a;
/*      */   private final i b;
/*      */   private final b c;
/*      */   private JCheckBox h;
/*      */   private JCheckBox i;
/*      */   private JPanel p;
/*      */   private JButton o;
/*      */   private JToggleButton a;
/*      */   private JToggleButton b;
/*      */   private JCheckBox j;
/*      */   private JCheckBox k;
/*      */   private JCheckBox c;
/*      */   private JCheckBox l;
/*      */   private JCheckBox m;
/*      */   private JCheckBoxMenuItem a;
/*      */   private JCheckBox n;
/*      */   private JComboBox<String> i;
/*      */   private JComboBox<String> a;
/*      */   private JFormattedTextField c;
/*      */   private JFormattedTextField f;
/*      */   private JFormattedTextField g;
/*      */   private JLabel y;
/*      */   private JLabel l;
/*      */   private JLabel ai;
/*      */   
/*      */   public f(j paramj, b paramb) {
/*   63 */     this.a = (i)paramj;
/*   64 */     this.b = (i)paramb.a();
/*   65 */     this.c = (i)paramb;
/*      */     
/*   67 */     k();
/*   68 */     dq();
/*   69 */     l();
/*      */     
/*   71 */     dr();
/*   72 */     ds();
/*      */   }
/*      */   private JLabel aj; private JPanel q; private JPanel r; private b b; private JPanel s; private JPanel t; private e a; private br.com.arremate.c.a.f c; private JPanel u; private g b; private g c; private g d; private g e; private JPanel v; private JPanel w; private h a; private JPanel x; private JPanel y; private JPanel z; private JPanel A; private i a; private i b; private i c; private JLabel ak;
/*      */   private void dq() {
/*   76 */     DecimalFormat decimalFormat = y.a("###,###,##0.00");
/*   77 */     this.c.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(decimalFormat)));
/*      */   }
/*      */   
/*      */   private void l() {
/*   81 */     KeyStroke keyStroke = KeyStroke.getKeyStroke(27, 0);
/*   82 */     byte b1 = 2;
/*   83 */     getRootPane().registerKeyboardAction(paramActionEvent -> dispose(), keyStroke, b1);
/*      */     
/*   85 */     this.b.a(paramChangeEvent -> {
/*      */           DecimalFormat decimalFormat = a();
/*      */           BigDecimal bigDecimal = z();
/*      */           a(bigDecimal, bigDecimal, decimalFormat);
/*      */         });
/*      */   }
/*      */   
/*      */   private void a(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, DecimalFormat paramDecimalFormat) {
/*   93 */     this.g.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(paramDecimalFormat)));
/*   94 */     this.f.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(paramDecimalFormat)));
/*      */     
/*   96 */     this.g.setValue(paramBigDecimal1);
/*   97 */     this.f.setValue(paramBigDecimal2);
/*      */   }
/*      */   
/*      */   private DecimalFormat a() {
/*  101 */     int k = this.b.h();
/*  102 */     byte b1 = 4;
/*  103 */     String str = "0";
/*      */     
/*  105 */     if (k < b1) {
/*  106 */       k = Math.abs(k - b1);
/*  107 */       str = String.join("", new CharSequence[] { "0.", StringUtils.leftPad("0", k, "0") });
/*      */     } 
/*      */     
/*  110 */     str = "###,###,##" + str;
/*  111 */     return y.a(str);
/*      */   }
/*      */   private BigDecimal z() {
/*      */     String str;
/*  115 */     int k = this.b.h();
/*  116 */     byte b1 = 4;
/*      */ 
/*      */     
/*  119 */     if (k < b1) {
/*  120 */       k = Math.abs(k - b1);
/*  121 */       str = String.join("", new CharSequence[] { "0.", StringUtils.leftPad("1", k, "0") });
/*      */     } else {
/*  123 */       k = k - b1 + 1;
/*  124 */       str = StringUtils.rightPad("1", k, "0");
/*      */     } 
/*      */     
/*  127 */     return new BigDecimal(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void dr() {
/*  134 */     n n = this.a.b();
/*  135 */     o o = n.a();
/*  136 */     boolean bool1 = n.bk();
/*  137 */     m m = this.a.a();
/*      */     
/*  139 */     if (this.a.N() > 0) {
/*  140 */       this.b.j(4 - this.a.N());
/*  141 */       this.ak.setText("<html>Esta licitação possui o <br> limite de " + this.a.N() + " casas decimais</html>");
/*      */     } else {
/*  143 */       this.ak.setVisible(false);
/*      */     } 
/*      */     
/*  146 */     if (o != o.a || !n.aF() || m == m.c) {
/*      */       
/*  148 */       this.l.setVisible(false);
/*  149 */       this.l.setSelected(false);
/*      */     } 
/*      */     
/*  152 */     a().removeAllItems();
/*  153 */     this.c.setVisible(false);
/*      */     
/*  155 */     l l = this.a.a();
/*  156 */     boolean bool2 = (o.equals(o.a) && l.equals(l.c)) ? true : false;
/*  157 */     boolean bool3 = o.equals(o.k);
/*  158 */     if (n.aE() && !bool2 && !bool3) {
/*  159 */       this.c.addItemListener(paramItemEvent -> {
/*      */             if (this.c.isSelected()) {
/*      */               this.h.setEnabled(false);
/*      */               
/*      */               this.h.setSelected(false);
/*      */             } else {
/*      */               this.h.setEnabled(true);
/*      */               this.h.setSelected(this.a.b().aD());
/*      */             } 
/*      */           });
/*  169 */       this.c.setVisible(true);
/*      */     } 
/*      */     
/*  172 */     boolean bool4 = (l.equals(l.c) || l.equals(l.g)) ? true : false;
/*  173 */     bool2 = (o.equals(o.a) && bool4) ? true : false;
/*      */ 
/*      */     
/*  176 */     this.d.setUrl(z.b.getUrl());
/*  177 */     this.b.setUrl(z.c.getUrl());
/*  178 */     this.c.setUrl(z.d.getUrl());
/*  179 */     if (bool2) {
/*  180 */       this.e.setUrl(z.e.getUrl());
/*  181 */     } else if (bool3) {
/*  182 */       this.e.setUrl(z.f.getUrl());
/*      */     } 
/*      */ 
/*      */     
/*  186 */     i i1 = i.a(0, (j)this.a);
/*  187 */     a().addItem(i1.K());
/*      */     
/*  189 */     if (!bool2) {
/*  190 */       i i2 = i.a(1, (j)this.a);
/*  191 */       a().addItem(i2.K());
/*      */       
/*  193 */       i i3 = i.a(2, (j)this.a);
/*  194 */       if (i2 != i3) {
/*  195 */         a().addItem(i3.K());
/*      */       }
/*      */     } 
/*      */     
/*  199 */     this.m.setVisible(false);
/*  200 */     this.j.setVisible(false);
/*  201 */     this.t.setVisible(false);
/*  202 */     this.x.setVisible(false);
/*  203 */     this.a.m(30);
/*      */     
/*  205 */     if ((bool2 || bool3) && 
/*  206 */       n.bT()) {
/*  207 */       this.t.setVisible(true);
/*      */       
/*  209 */       if (bool3) {
/*  210 */         this.m.setVisible(true);
/*  211 */         this.j.setVisible(true);
/*  212 */       } else if (bool2) {
/*  213 */         this.j.setVisible(true);
/*  214 */         this.j.setText("Cobrir o próprio lance nos segundos finais da disputa");
/*  215 */         ((TitledBorder)this.t.getBorder()).setTitle("Configuraçãoes da Dispensa - Comprasnet");
/*  216 */         this.x.setVisible(true);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  221 */     if (this.a.a() == m.b || this.a.a() == m.f) {
/*  222 */       this.b.m(this.a.D());
/*      */     } else {
/*  224 */       this.w.setVisible(false);
/*      */     } 
/*      */     
/*  227 */     boolean bool5 = false;
/*  228 */     if (this.a.a() == m.c) {
/*  229 */       this.c.m(5);
/*      */       
/*  231 */       bool5 = true;
/*      */       
/*  233 */       boolean bool = !cd() ? true : false;
/*  234 */       this.s.setVisible(bool);
/*  235 */       this.q.setVisible(bool);
/*      */     } else {
/*  237 */       this.v.setVisible(false);
/*      */     } 
/*      */     
/*  240 */     boolean bool6 = (this.a.a().a() != p.b) ? true : false;
/*  241 */     boolean bool7 = (bool1 && !bool5 && bool6 && !bool2 && !bool3) ? true : false;
/*  242 */     this.k.setVisible(bool7);
/*  243 */     this.k.setEnabled(bool7);
/*  244 */     this.c.setVisible(bool7);
/*  245 */     this.c.setEnabled(bool7);
/*      */     
/*  247 */     validate();
/*  248 */     repaint();
/*  249 */     pack();
/*  250 */     setLocationRelativeTo((Component)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void ds() {
/*  257 */     b b1 = this.a.b();
/*  258 */     this.b.i(b1.E());
/*      */ 
/*      */     
/*  261 */     DecimalFormat decimalFormat = a();
/*      */ 
/*      */     
/*  264 */     BigDecimal bigDecimal1 = (b1.a() == w.b) ? b1.f().multiply(BigDecimal.valueOf(100L)) : b1.f();
/*      */ 
/*      */     
/*  267 */     BigDecimal bigDecimal2 = (b1.a() == w.b) ? b1.g().multiply(BigDecimal.valueOf(100L)) : b1.g();
/*      */     
/*  269 */     a(bigDecimal1, bigDecimal2, decimalFormat);
/*      */ 
/*      */     
/*  272 */     int k = b1.a((j)this.a).v();
/*      */     
/*  274 */     if (k >= a().getItemCount()) {
/*  275 */       k = a().getItemCount() - 1;
/*      */     }
/*      */     
/*  278 */     a().setSelectedIndex(k);
/*  279 */     b().setSelectedIndex(b1.a().y());
/*  280 */     a().setSelected(this.a.aU());
/*  281 */     this.c.setText(a(b1.h()));
/*  282 */     this.h.setSelected(b1.aD());
/*  283 */     this.c.setSelected(b1.aE());
/*      */     
/*  285 */     this.m.setSelected(b1.aG());
/*  286 */     this.j.setSelected(b1.aH());
/*  287 */     this.l.setSelected(b1.aF());
/*  288 */     this.i.setSelected(b1.aI());
/*  289 */     this.a.c(b1.v());
/*  290 */     this.c.b(b1.t());
/*  291 */     this.b.c(b1.u());
/*  292 */     this.c.c(b1.w());
/*  293 */     this.n.setSelected(b1.aJ());
/*  294 */     this.a.setSelected(b1.aK());
/*  295 */     this.a.c(b1.i());
/*  296 */     this.a.setSelected(b1.aL());
/*  297 */     this.a.l(b1.F());
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
/*  308 */     this.a = (i)new JCheckBoxMenuItem();
/*  309 */     this.p = new JPanel();
/*  310 */     this.aj = new JLabel();
/*  311 */     this.g = new JFormattedTextField();
/*  312 */     this.y = (JPanel)new JLabel();
/*  313 */     this.f = new JFormattedTextField();
/*  314 */     this.a = (i)new JComboBox();
/*  315 */     this.ai = new JLabel();
/*  316 */     this.l = new JLabel();
/*  317 */     this.i = new JComboBox<>();
/*  318 */     this.k = new JCheckBox();
/*  319 */     this.h = new JCheckBox();
/*  320 */     this.l = (JLabel)new JCheckBox();
/*  321 */     this.c = (i)new JCheckBox();
/*  322 */     this.A = new JPanel();
/*  323 */     this.c = (i)new br.com.arremate.c.a.f();
/*  324 */     this.c = (i)new JFormattedTextField();
/*  325 */     this.r = new JPanel();
/*  326 */     this.b = (i)new b();
/*  327 */     this.ak = new JLabel();
/*  328 */     this.d = new g();
/*  329 */     this.t = new JPanel();
/*  330 */     this.m = new JCheckBox();
/*  331 */     this.j = new JCheckBox();
/*  332 */     this.x = new JPanel();
/*  333 */     this.a = new i(TimeUnit.MINUTES.toMillis(1L));
/*  334 */     this.i = (JComboBox<String>)new JCheckBox();
/*  335 */     this.e = new g();
/*  336 */     this.w = new JPanel();
/*  337 */     this.y = new JPanel();
/*  338 */     this.b = new i();
/*  339 */     this.b = (i)new g();
/*  340 */     this.v = new JPanel();
/*  341 */     this.s = new JPanel();
/*  342 */     this.n = new JCheckBox();
/*  343 */     this.a = (i)new h();
/*  344 */     this.q = new JPanel();
/*  345 */     this.a = (i)new e();
/*  346 */     this.z = new JPanel();
/*  347 */     this.c = new i(TimeUnit.MINUTES.toMillis(1L));
/*  348 */     this.c = (i)new g();
/*  349 */     this.u = new JPanel();
/*  350 */     this.a = (i)new JToggleButton();
/*  351 */     this.b = (i)new JToggleButton();
/*  352 */     this.o = new JButton();
/*      */     
/*  354 */     this.a.setSelected(true);
/*  355 */     this.a.setText("jCheckBoxMenuItem1");
/*      */     
/*  357 */     setDefaultCloseOperation(2);
/*  358 */     setTitle("Effecti - Configurações gerais da disputa");
/*  359 */     setIconImage((new ImageIcon(getClass().getResource("/img/icone.jpg"))).getImage());
/*  360 */     setModal(true);
/*      */     
/*  362 */     this.p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Configurações Gerais"));
/*      */     
/*  364 */     this.aj.setText("Variação:");
/*      */     
/*  366 */     this.g.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###,###,##0.00"))));
/*  367 */     this.g.setHorizontalAlignment(4);
/*  368 */     this.g.addFocusListener(new FocusAdapter(this) {
/*      */           public void focusGained(FocusEvent param1FocusEvent) {
/*  370 */             f.a(this.a, param1FocusEvent);
/*      */           }
/*      */           public void focusLost(FocusEvent param1FocusEvent) {
/*  373 */             f.b(this.a, param1FocusEvent);
/*      */           }
/*      */         });
/*      */     
/*  377 */     this.y.setText("até");
/*      */     
/*  379 */     this.f.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###,###,##0.00"))));
/*  380 */     this.f.setHorizontalAlignment(4);
/*  381 */     this.f.addFocusListener(new FocusAdapter(this) {
/*      */           public void focusGained(FocusEvent param1FocusEvent) {
/*  383 */             f.c(this.a, param1FocusEvent);
/*      */           }
/*      */           public void focusLost(FocusEvent param1FocusEvent) {
/*  386 */             f.d(this.a, param1FocusEvent);
/*      */           }
/*      */         });
/*      */     
/*  390 */     this.a.setModel(new DefaultComboBoxModel<>(new String[] { "Valor", "Percentual" }));
/*  391 */     this.a.setSelectedIndex(-1);
/*      */     
/*  393 */     this.ai.setText("Tipo redução:");
/*      */     
/*  395 */     this.l.setText("Iniciar lances a partir de:");
/*      */     
/*  397 */     this.i.addActionListener(new ActionListener(this) {
/*      */           public void actionPerformed(ActionEvent param1ActionEvent) {
/*  399 */             f.a(this.a, param1ActionEvent);
/*      */           }
/*      */         });
/*      */     
/*  403 */     this.k.setText("Disputar contra ME/EPP utilizando o percentual (%):");
/*  404 */     this.k.setMargin(new Insets(2, 0, 2, 2));
/*      */     
/*  406 */     this.h.setText("Realizar lance do valor limite quando não for mais possível disputar o 1º lugar?");
/*  407 */     this.h.setToolTipText("");
/*  408 */     this.h.setActionCommand("checkBox_EnviarLanceVlrMinimo");
/*  409 */     this.h.setMargin(new Insets(2, 0, 2, 2));
/*      */     
/*  411 */     this.l.setText("Enviar lance do valor limite assim que os itens entrarem em disputa");
/*  412 */     this.l.setMargin(new Insets(2, 0, 2, 2));
/*      */     
/*  414 */     this.c.setText("Disputar a melhor posição possível");
/*  415 */     this.c.setMargin(new Insets(2, 0, 2, 2));
/*      */     
/*  417 */     this.A.setBorder(BorderFactory.createTitledBorder("Tempo entre próprio lance"));
/*      */     
/*  419 */     GroupLayout groupLayout1 = new GroupLayout(this.A);
/*  420 */     this.A.setLayout(groupLayout1);
/*  421 */     groupLayout1.setHorizontalGroup(groupLayout1
/*  422 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  423 */         .addGroup(groupLayout1.createSequentialGroup()
/*  424 */           .addContainerGap()
/*  425 */           .addComponent((Component)this.c, -2, -1, -2)
/*  426 */           .addContainerGap(63, 32767)));
/*      */     
/*  428 */     groupLayout1.setVerticalGroup(groupLayout1
/*  429 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  430 */         .addGroup(groupLayout1.createSequentialGroup()
/*  431 */           .addContainerGap()
/*  432 */           .addComponent((Component)this.c, -2, -1, -2)
/*  433 */           .addContainerGap()));
/*      */ 
/*      */     
/*  436 */     this.c.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###,###,##0.00"))));
/*  437 */     this.c.setHorizontalAlignment(4);
/*  438 */     this.c.setPreferredSize(new Dimension(50, 20));
/*  439 */     this.c.addFocusListener(new FocusAdapter(this) {
/*      */           public void focusGained(FocusEvent param1FocusEvent) {
/*  441 */             f.e(this.a, param1FocusEvent);
/*      */           }
/*      */         });
/*      */     
/*  445 */     this.r.setBorder(BorderFactory.createTitledBorder("Arredondar lance"));
/*      */     
/*  447 */     this.ak.setFont(new Font("Dialog", 1, 10));
/*  448 */     this.ak.setForeground(y.d());
/*  449 */     this.ak.setText("<html>Esta licitação possui o <br> limite de x casas decimais</html>");
/*      */     
/*  451 */     GroupLayout groupLayout2 = new GroupLayout(this.r);
/*  452 */     this.r.setLayout(groupLayout2);
/*  453 */     groupLayout2.setHorizontalGroup(groupLayout2
/*  454 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  455 */         .addGroup(groupLayout2.createSequentialGroup()
/*  456 */           .addContainerGap()
/*  457 */           .addComponent((Component)this.b, -2, -1, -2)
/*  458 */           .addGap(18, 18, 18)
/*  459 */           .addComponent(this.ak, -2, -1, -2)
/*  460 */           .addContainerGap(-1, 32767)));
/*      */     
/*  462 */     groupLayout2.setVerticalGroup(groupLayout2
/*  463 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  464 */         .addGroup(groupLayout2.createSequentialGroup()
/*  465 */           .addContainerGap()
/*  466 */           .addComponent((Component)this.b, -2, -1, -2)
/*  467 */           .addContainerGap(-1, 32767))
/*  468 */         .addGroup(groupLayout2.createSequentialGroup()
/*  469 */           .addComponent(this.ak, -2, -1, -2)
/*  470 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/*  473 */     GroupLayout groupLayout3 = new GroupLayout(this.p);
/*  474 */     this.p.setLayout(groupLayout3);
/*  475 */     groupLayout3.setHorizontalGroup(groupLayout3
/*  476 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  477 */         .addGroup(groupLayout3.createSequentialGroup()
/*  478 */           .addContainerGap()
/*  479 */           .addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  480 */             .addGroup(groupLayout3.createSequentialGroup()
/*  481 */               .addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  482 */                 .addComponent(this.l, -1, -1, 32767)
/*  483 */                 .addGroup(groupLayout3.createSequentialGroup()
/*  484 */                   .addComponent(this.ai)
/*  485 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  486 */                   .addComponent((Component)this.a, -2, -1, -2)
/*  487 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  488 */                   .addComponent(this.aj)
/*  489 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  490 */                   .addComponent(this.g, -2, 90, -2)
/*  491 */                   .addGap(3, 3, 3)
/*  492 */                   .addComponent(this.y)
/*  493 */                   .addGap(3, 3, 3)
/*  494 */                   .addComponent(this.f, -2, 90, -2)
/*  495 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  496 */                   .addComponent((Component)this.d, -2, -1, -2))
/*  497 */                 .addGroup(groupLayout3.createSequentialGroup()
/*  498 */                   .addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  499 */                     .addGroup(groupLayout3.createSequentialGroup()
/*  500 */                       .addComponent(this.l)
/*  501 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  502 */                       .addComponent(this.i, -2, 175, -2))
/*  503 */                     .addGroup(groupLayout3.createSequentialGroup()
/*  504 */                       .addComponent(this.k)
/*  505 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  506 */                       .addComponent((Component)this.c, -2, -1, -2))
/*  507 */                     .addComponent((Component)this.c)
/*  508 */                     .addComponent(this.h)
/*  509 */                     .addComponent(this.r, -2, -1, -2))
/*  510 */                   .addGap(0, 0, 32767)))
/*  511 */               .addGap(6, 6, 6))
/*  512 */             .addGroup(groupLayout3.createSequentialGroup()
/*  513 */               .addComponent(this.A, -2, -1, -2)
/*  514 */               .addContainerGap(-1, 32767)))));
/*      */     
/*  516 */     groupLayout3.setVerticalGroup(groupLayout3
/*  517 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  518 */         .addGroup(groupLayout3.createSequentialGroup()
/*  519 */           .addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  520 */             .addGroup(groupLayout3.createSequentialGroup()
/*  521 */               .addGap(11, 11, 11)
/*  522 */               .addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  523 */                 .addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  524 */                   .addComponent(this.aj)
/*  525 */                   .addComponent(this.g, -2, -1, -2)
/*  526 */                   .addComponent(this.y)
/*  527 */                   .addComponent(this.f, -2, -1, -2))
/*  528 */                 .addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  529 */                   .addComponent((Component)this.a, -2, -1, -2)
/*  530 */                   .addComponent(this.ai))))
/*  531 */             .addComponent((Component)this.d, -2, -1, -2))
/*  532 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  533 */           .addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  534 */             .addComponent(this.i, -2, -1, -2)
/*  535 */             .addComponent(this.l))
/*  536 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  537 */           .addComponent(this.r, -2, -1, -2)
/*  538 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  539 */           .addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  540 */             .addComponent(this.k)
/*  541 */             .addComponent((Component)this.c, -2, -1, -2))
/*  542 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  543 */           .addComponent((Component)this.c)
/*  544 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  545 */           .addComponent(this.h)
/*  546 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  547 */           .addComponent(this.l)
/*  548 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  549 */           .addComponent(this.A, -2, -1, -2)
/*  550 */           .addContainerGap()));
/*      */ 
/*      */     
/*  553 */     this.t.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Configuraçãoes da Cotação - Comprasnet"));
/*      */     
/*  555 */     this.m.setText("Enviar lances somente na virada do minuto");
/*  556 */     this.m.setMargin(new Insets(2, 0, 2, 2));
/*      */     
/*  558 */     this.j.setText("Cobrir o próprio lance na virada do minuto");
/*  559 */     this.j.setMargin(new Insets(2, 0, 2, 2));
/*      */     
/*  561 */     this.x.setBorder(BorderFactory.createTitledBorder(""));
/*      */     
/*  563 */     this.i.setText("Iniciar o envio de lances restando:");
/*      */     
/*  565 */     GroupLayout groupLayout4 = new GroupLayout(this.x);
/*  566 */     this.x.setLayout(groupLayout4);
/*  567 */     groupLayout4.setHorizontalGroup(groupLayout4
/*  568 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  569 */         .addGroup(groupLayout4.createSequentialGroup()
/*  570 */           .addGap(10, 10, 10)
/*  571 */           .addGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  572 */             .addGroup(groupLayout4.createSequentialGroup()
/*  573 */               .addGap(4, 4, 4)
/*  574 */               .addComponent((Component)this.a, -2, 135, -2))
/*  575 */             .addComponent(this.i))
/*  576 */           .addContainerGap(-1, 32767)));
/*      */     
/*  578 */     groupLayout4.setVerticalGroup(groupLayout4
/*  579 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  580 */         .addGroup(GroupLayout.Alignment.TRAILING, groupLayout4.createSequentialGroup()
/*  581 */           .addGap(11, 11, 11)
/*  582 */           .addComponent(this.i, -2, 20, -2)
/*  583 */           .addGap(3, 3, 3)
/*  584 */           .addComponent((Component)this.a, -2, -1, -2)
/*  585 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  588 */     GroupLayout groupLayout5 = new GroupLayout(this.t);
/*  589 */     this.t.setLayout(groupLayout5);
/*  590 */     groupLayout5.setHorizontalGroup(groupLayout5
/*  591 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  592 */         .addGroup(groupLayout5.createSequentialGroup()
/*  593 */           .addContainerGap()
/*  594 */           .addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  595 */             .addGroup(groupLayout5.createSequentialGroup()
/*  596 */               .addComponent(this.m)
/*  597 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  598 */               .addComponent((Component)this.e, -2, -1, -2))
/*  599 */             .addGroup(groupLayout5.createSequentialGroup()
/*  600 */               .addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  601 */                 .addComponent(this.j)
/*  602 */                 .addComponent(this.x, -2, -1, -2))
/*  603 */               .addGap(0, 0, 32767)))
/*  604 */           .addGap(6, 6, 6)));
/*      */     
/*  606 */     groupLayout5.setVerticalGroup(groupLayout5
/*  607 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  608 */         .addGroup(groupLayout5.createSequentialGroup()
/*  609 */           .addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  610 */             .addGroup(groupLayout5.createSequentialGroup()
/*  611 */               .addGap(11, 11, 11)
/*  612 */               .addComponent(this.m))
/*  613 */             .addComponent((Component)this.e, -2, -1, -2))
/*  614 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  615 */           .addComponent(this.j)
/*  616 */           .addGap(11, 11, 11)
/*  617 */           .addComponent(this.x, -2, -1, -2)
/*  618 */           .addContainerGap()));
/*      */ 
/*      */     
/*  621 */     this.w.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Configurações do Modo Aberto"));
/*      */     
/*  623 */     this.y.setBorder(BorderFactory.createTitledBorder("Enviar lance restando"));
/*      */     
/*  625 */     GroupLayout groupLayout6 = new GroupLayout(this.y);
/*  626 */     this.y.setLayout(groupLayout6);
/*  627 */     groupLayout6.setHorizontalGroup(groupLayout6
/*  628 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  629 */         .addGroup(groupLayout6.createSequentialGroup()
/*  630 */           .addContainerGap()
/*  631 */           .addComponent((Component)this.b, -2, 135, -2)
/*  632 */           .addContainerGap(-1, 32767)));
/*      */     
/*  634 */     groupLayout6.setVerticalGroup(groupLayout6
/*  635 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  636 */         .addGroup(GroupLayout.Alignment.TRAILING, groupLayout6.createSequentialGroup()
/*  637 */           .addContainerGap()
/*  638 */           .addComponent((Component)this.b, -2, -1, -2)
/*  639 */           .addContainerGap()));
/*      */ 
/*      */     
/*  642 */     GroupLayout groupLayout7 = new GroupLayout(this.w);
/*  643 */     this.w.setLayout(groupLayout7);
/*  644 */     groupLayout7.setHorizontalGroup(groupLayout7
/*  645 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  646 */         .addGroup(groupLayout7.createSequentialGroup()
/*  647 */           .addContainerGap()
/*  648 */           .addComponent(this.y, -2, -1, -2)
/*  649 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  650 */           .addComponent((Component)this.b, -2, -1, -2)
/*  651 */           .addGap(6, 6, 6)));
/*      */     
/*  653 */     groupLayout7.setVerticalGroup(groupLayout7
/*  654 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  655 */         .addGroup(groupLayout7.createSequentialGroup()
/*  656 */           .addGroup(groupLayout7.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  657 */             .addGroup(groupLayout7.createSequentialGroup()
/*  658 */               .addGap(11, 11, 11)
/*  659 */               .addComponent(this.y, -2, -1, -2))
/*  660 */             .addComponent((Component)this.b, -2, -1, -2))
/*  661 */           .addGap(11, 11, 11)));
/*      */ 
/*      */     
/*  664 */     this.v.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Configurações do Modo Aberto/Fechado"));
/*      */     
/*  666 */     this.s.setBorder(BorderFactory.createTitledBorder("Conservador"));
/*      */     
/*  668 */     this.n.setText("Top 3 (Ficar entre os três primeiros)");
/*  669 */     this.n.addMouseListener(new MouseAdapter(this) {
/*      */           public void mouseClicked(MouseEvent param1MouseEvent) {
/*  671 */             f.a(this.a, param1MouseEvent);
/*      */           }
/*      */         });
/*      */     
/*  675 */     this.a.addMouseListener(new MouseAdapter(this) {
/*      */           public void mouseClicked(MouseEvent param1MouseEvent) {
/*  677 */             f.b(this.a, param1MouseEvent);
/*      */           }
/*      */         });
/*      */     
/*  681 */     GroupLayout groupLayout8 = new GroupLayout(this.s);
/*  682 */     this.s.setLayout(groupLayout8);
/*  683 */     groupLayout8.setHorizontalGroup(groupLayout8
/*  684 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  685 */         .addGroup(groupLayout8.createSequentialGroup()
/*  686 */           .addContainerGap()
/*  687 */           .addGroup(groupLayout8.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  688 */             .addComponent(this.n)
/*  689 */             .addComponent((Component)this.a, -2, -1, -2))
/*  690 */           .addContainerGap(-1, 32767)));
/*      */     
/*  692 */     groupLayout8.setVerticalGroup(groupLayout8
/*  693 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  694 */         .addGroup(groupLayout8.createSequentialGroup()
/*  695 */           .addGap(11, 11, 11)
/*  696 */           .addComponent(this.n)
/*  697 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  698 */           .addComponent((Component)this.a, -2, -1, -2)
/*  699 */           .addContainerGap()));
/*      */ 
/*      */     
/*  702 */     this.q.setBorder(BorderFactory.createTitledBorder("Agressivo"));
/*      */     
/*  704 */     GroupLayout groupLayout9 = new GroupLayout(this.q);
/*  705 */     this.q.setLayout(groupLayout9);
/*  706 */     groupLayout9.setHorizontalGroup(groupLayout9
/*  707 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  708 */         .addGroup(groupLayout9.createSequentialGroup()
/*  709 */           .addGap(10, 10, 10)
/*  710 */           .addComponent((Component)this.a, -2, -1, -2)
/*  711 */           .addContainerGap(-1, 32767)));
/*      */     
/*  713 */     groupLayout9.setVerticalGroup(groupLayout9
/*  714 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  715 */         .addGroup(groupLayout9.createSequentialGroup()
/*  716 */           .addGap(11, 11, 11)
/*  717 */           .addComponent((Component)this.a, -2, -1, -2)
/*  718 */           .addContainerGap()));
/*      */ 
/*      */     
/*  721 */     this.z.setBorder(BorderFactory.createTitledBorder("Enviar lance fechado restando"));
/*      */     
/*  723 */     GroupLayout groupLayout10 = new GroupLayout(this.z);
/*  724 */     this.z.setLayout(groupLayout10);
/*  725 */     groupLayout10.setHorizontalGroup(groupLayout10
/*  726 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  727 */         .addGroup(groupLayout10.createSequentialGroup()
/*  728 */           .addContainerGap()
/*  729 */           .addComponent((Component)this.c, -2, 135, -2)
/*  730 */           .addContainerGap(33, 32767)));
/*      */     
/*  732 */     groupLayout10.setVerticalGroup(groupLayout10
/*  733 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  734 */         .addGroup(GroupLayout.Alignment.TRAILING, groupLayout10.createSequentialGroup()
/*  735 */           .addContainerGap()
/*  736 */           .addComponent((Component)this.c, -2, -1, -2)
/*  737 */           .addContainerGap()));
/*      */ 
/*      */     
/*  740 */     GroupLayout groupLayout11 = new GroupLayout(this.v);
/*  741 */     this.v.setLayout(groupLayout11);
/*  742 */     groupLayout11.setHorizontalGroup(groupLayout11
/*  743 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  744 */         .addGroup(groupLayout11.createSequentialGroup()
/*  745 */           .addContainerGap()
/*  746 */           .addGroup(groupLayout11.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  747 */             .addGroup(groupLayout11.createSequentialGroup()
/*  748 */               .addComponent(this.s, -2, -1, -2)
/*  749 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  750 */               .addComponent((Component)this.c, -2, -1, -2))
/*  751 */             .addGroup(groupLayout11.createSequentialGroup()
/*  752 */               .addGroup(groupLayout11.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  753 */                 .addComponent(this.q, -2, -1, -2)
/*  754 */                 .addComponent(this.z, -2, -1, -2))
/*  755 */               .addGap(0, 0, 32767)))
/*  756 */           .addGap(6, 6, 6)));
/*      */     
/*  758 */     groupLayout11.setVerticalGroup(groupLayout11
/*  759 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  760 */         .addGroup(groupLayout11.createSequentialGroup()
/*  761 */           .addGroup(groupLayout11.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  762 */             .addGroup(groupLayout11.createSequentialGroup()
/*  763 */               .addContainerGap()
/*  764 */               .addComponent(this.s, -2, -1, -2))
/*  765 */             .addComponent((Component)this.c, -2, -1, -2))
/*  766 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  767 */           .addComponent(this.q, -2, -1, -2)
/*  768 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  769 */           .addComponent(this.z, -2, -1, -2)
/*  770 */           .addContainerGap()));
/*      */ 
/*      */     
/*  773 */     this.u.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/*  775 */     this.a.setIcon(new ImageIcon(getClass().getResource("/img/delete.png")));
/*  776 */     this.a.setText("Fechar");
/*  777 */     this.a.addActionListener(new ActionListener(this) {
/*      */           public void actionPerformed(ActionEvent param1ActionEvent) {
/*  779 */             f.b(this.a, param1ActionEvent);
/*      */           }
/*      */         });
/*      */     
/*  783 */     this.b.setIcon(new ImageIcon(getClass().getResource("/img/accept.png")));
/*  784 */     this.b.setText("Gravar");
/*  785 */     this.b.addActionListener(new ActionListener(this) {
/*      */           public void actionPerformed(ActionEvent param1ActionEvent) {
/*  787 */             f.c(this.a, param1ActionEvent);
/*      */           }
/*      */         });
/*      */     
/*  791 */     this.o.setIcon(new ImageIcon(getClass().getResource("/img/arrow_circle.png")));
/*  792 */     this.o.setText("Default");
/*  793 */     this.o.setToolTipText("Utilizar configurações do portal");
/*  794 */     this.o.addActionListener(new ActionListener(this) {
/*      */           public void actionPerformed(ActionEvent param1ActionEvent) {
/*  796 */             f.d(this.a, param1ActionEvent);
/*      */           }
/*      */         });
/*      */     
/*  800 */     GroupLayout groupLayout12 = new GroupLayout(this.u);
/*  801 */     this.u.setLayout(groupLayout12);
/*  802 */     groupLayout12.setHorizontalGroup(groupLayout12
/*  803 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  804 */         .addGroup(GroupLayout.Alignment.TRAILING, groupLayout12.createSequentialGroup()
/*  805 */           .addContainerGap(-1, 32767)
/*  806 */           .addComponent(this.o)
/*  807 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  808 */           .addComponent((Component)this.b)
/*  809 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  810 */           .addComponent((Component)this.a)
/*  811 */           .addContainerGap()));
/*      */     
/*  813 */     groupLayout12.setVerticalGroup(groupLayout12
/*  814 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  815 */         .addGroup(groupLayout12.createSequentialGroup()
/*  816 */           .addContainerGap()
/*  817 */           .addGroup(groupLayout12.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  818 */             .addComponent((Component)this.a)
/*  819 */             .addComponent((Component)this.b)
/*  820 */             .addComponent(this.o))
/*  821 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  824 */     GroupLayout groupLayout13 = new GroupLayout(getContentPane());
/*  825 */     getContentPane().setLayout(groupLayout13);
/*  826 */     groupLayout13.setHorizontalGroup(groupLayout13
/*  827 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  828 */         .addGroup(groupLayout13.createSequentialGroup()
/*  829 */           .addContainerGap()
/*  830 */           .addGroup(groupLayout13.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  831 */             .addComponent(this.u, -1, -1, 32767)
/*  832 */             .addComponent(this.v, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  833 */             .addComponent(this.w, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  834 */             .addComponent(this.t, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  835 */             .addComponent(this.p, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/*  836 */           .addContainerGap(-1, 32767)));
/*      */     
/*  838 */     groupLayout13.setVerticalGroup(groupLayout13
/*  839 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  840 */         .addGroup(groupLayout13.createSequentialGroup()
/*  841 */           .addContainerGap()
/*  842 */           .addComponent(this.p, -2, -1, -2)
/*  843 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  844 */           .addComponent(this.t, -2, -1, -2)
/*  845 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  846 */           .addComponent(this.w, -2, -1, -2)
/*  847 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  848 */           .addComponent(this.v, -2, -1, -2)
/*  849 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  850 */           .addComponent(this.u, -2, -1, -2)
/*  851 */           .addContainerGap()));
/*      */ 
/*      */     
/*  854 */     pack();
/*      */   }
/*      */   
/*      */   private void h(FocusEvent paramFocusEvent) {
/*  858 */     this.g.selectAll();
/*      */   }
/*      */   
/*      */   private void i(FocusEvent paramFocusEvent) {
/*  862 */     if (((!this.g.getText().isEmpty() ? 1 : 0) & this.f.getText().isEmpty()) != 0) {
/*  863 */       this.f.setText(this.g.getText());
/*      */     }
/*      */   }
/*      */   
/*      */   private void j(FocusEvent paramFocusEvent) {
/*  868 */     this.f.selectAll();
/*      */   }
/*      */   
/*      */   private void k(FocusEvent paramFocusEvent) {
/*  872 */     if (((!this.f.getText().isEmpty() ? 1 : 0) & this.g.getText().isEmpty()) != 0) {
/*  873 */       this.g.setText(this.f.getText());
/*      */     }
/*      */   }
/*      */   
/*      */   private void q(ActionEvent paramActionEvent) {
/*  878 */     dispose();
/*      */   }
/*      */   
/*      */   private void r(ActionEvent paramActionEvent) {
/*  882 */     if (!aC()) {
/*      */       return;
/*      */     }
/*      */     
/*  886 */     if (cf()) {
/*  887 */       boolean bool = false;
/*      */       
/*  889 */       if (cc()) {
/*  890 */         int k = JOptionPane.showConfirmDialog(this, "Configurações da disputa atualizadas com sucesso.\nDeseja replicar as configurações a TODOS os itens da licitação também?", "Mensagem", 0, 1);
/*      */         
/*  892 */         if (k == 0) {
/*  893 */           if (!ce()) {
/*  894 */             JOptionPane.showMessageDialog(this, "Erro ao atualizar configurações dos itens da licitação " + this.a.bo() + ",\nmas as configurações da disputa foram atualizadas com sucesso", "Mensagem", 0);
/*      */           } else {
/*  896 */             bool = true;
/*      */           } 
/*      */         }
/*      */       } else {
/*  900 */         JOptionPane.showMessageDialog(this, "Configurações da disputa atualizadas com sucesso", "Mensagem", 1);
/*      */       } 
/*      */       
/*  903 */       j.a().e((j)this.a);
/*  904 */       this.c.a(a(bool), false);
/*  905 */       dispose();
/*      */     } else {
/*  907 */       JOptionPane.showMessageDialog(this, "Erro ao atualizar configurações da disputa", "Mensagem", 0);
/*      */     } 
/*      */   }
/*      */   
/*      */   private String a(boolean paramBoolean) {
/*  912 */     b b1 = this.a.b();
/*  913 */     StringJoiner stringJoiner = new StringJoiner(" | ");
/*  914 */     DecimalFormat decimalFormat1 = y.a("###,###,##0.00");
/*      */ 
/*      */ 
/*      */     
/*  918 */     BigDecimal bigDecimal1 = (b1.a() == w.b) ? b1.f().multiply(BigDecimal.valueOf(100L)) : b1.f();
/*      */ 
/*      */     
/*  921 */     BigDecimal bigDecimal2 = (b1.a() == w.b) ? b1.g().multiply(BigDecimal.valueOf(100L)) : b1.g();
/*      */     
/*  923 */     DecimalFormat decimalFormat2 = y.a("###,###,##0.0000");
/*  924 */     String str1 = decimalFormat2.format(bigDecimal1);
/*  925 */     String str2 = decimalFormat2.format(bigDecimal2);
/*      */     
/*  927 */     stringJoiner.add("Alterada configuração geral");
/*  928 */     stringJoiner.add(String.join(" ", new CharSequence[] { "Variação inicial e final:", str1, "até", str2 }));
/*  929 */     stringJoiner.add(String.join(" ", new CharSequence[] { "Tipo de redução:", b1.a().K() }));
/*  930 */     stringJoiner.add(String.join(" ", new CharSequence[] { "Iniciar lances em:", b1.a((j)this.a).K() }));
/*  931 */     stringJoiner.add(String.join(" ", new CharSequence[] { "Arredondar casas decimais:", Integer.toString(b1.E()) }));
/*      */     
/*  933 */     o o = this.a.b().a();
/*  934 */     boolean bool = o.equals(o.k);
/*      */     
/*  936 */     l l = this.a.a();
/*  937 */     boolean bool1 = (o.equals(o.a) && l.equals(l.c)) ? true : false;
/*      */     
/*  939 */     if (bool) {
/*  940 */       stringJoiner.add(String.join(" ", new CharSequence[] { "Enviar lance na virada do minuto:", b1.aG() ? "sim" : "não" }));
/*  941 */       stringJoiner.add(String.join(" ", new CharSequence[] { "Cobrir lance na virada do minuto:", b1.aH() ? "sim" : "não" }));
/*  942 */     } else if (bool1) {
/*  943 */       stringJoiner.add(String.join(" ", new CharSequence[] { "Cobrir lance nos segundos finais da disputa:", b1.aH() ? "sim" : "não" }));
/*  944 */     } else if (l.equals(l.g)) {
/*  945 */       stringJoiner.add(String.join(" ", new CharSequence[] { "Cobrir lance nos segundos finais da disputa:", b1.aH() ? "sim" : "não" }));
/*  946 */       stringJoiner.add(String.join("", new CharSequence[] { "Disputar a melhor posição possível: ", b1.aE() ? "sim" : "não" }));
/*      */     } else {
/*  948 */       stringJoiner.add(String.join(" ", new CharSequence[] { "Disputar contra ME/EPP:", 
/*  949 */               b1.a(this.a.b(), this.a.a(), this.a.a()) ? "sim" : "não", "e Percentual:", decimalFormat1
/*  950 */               .format(b1.h()), "%" }));
/*  951 */       stringJoiner.add(String.join("", new CharSequence[] { "Disputar a melhor posição possível: ", b1.aE() ? "sim" : "não" }));
/*      */     } 
/*      */     
/*  954 */     stringJoiner.add(String.join(" ", new CharSequence[] { "Enviar lance derradeiro:", b1.aD() ? "sim" : "não" }));
/*  955 */     stringJoiner.add(String.join(" ", new CharSequence[] { "Tempo entre o próprio lance:", Long.toString(TimeUnit.MILLISECONDS.toSeconds(b1.t())), "segundos" }));
/*      */     
/*  957 */     if (this.a.a() == m.a && this.a.b().a() == o.a) {
/*  958 */       stringJoiner.add(String.join(" ", new CharSequence[] { "Enviar lance no inicio da disputa:", b1.aF() ? "sim" : "não" }));
/*      */     }
/*      */     
/*  961 */     if (this.a.a() == m.b || this.a.a() == m.f) {
/*  962 */       int k = (int)TimeUnit.MILLISECONDS.toMinutes(b1.u());
/*  963 */       int m = (int)TimeUnit.MILLISECONDS.toSeconds(b1.u());
/*  964 */       m -= k * 60;
/*      */       
/*  966 */       stringJoiner.add(String.join(" ", new CharSequence[] { "Enviar lance restando:", Integer.toString(k), "minuto(s) e", Integer.toString(m), "segundos" }));
/*      */     } 
/*      */     
/*  969 */     if (this.a.a() == m.c) {
/*  970 */       int k = (int)TimeUnit.MILLISECONDS.toMinutes(b1.w());
/*  971 */       int m = (int)TimeUnit.MILLISECONDS.toSeconds(b1.w());
/*  972 */       m -= k * 60;
/*      */       
/*  974 */       stringJoiner.add(String.join(" ", new CharSequence[] { "Enviar lance fechado restando:", Integer.toString(k), "minuto(s) e", Integer.toString(m), "segundos" }));
/*      */     } 
/*      */     
/*  977 */     if (this.a.a() == m.c) {
/*  978 */       stringJoiner.add(String.join(" ", new CharSequence[] { "Top 3:", b1.aJ() ? "sim" : "não" }));
/*  979 */       stringJoiner.add(String.join(" ", new CharSequence[] { "10% do primeiro colocado:", b1.aK() ? "sim" : "não", "e Percentual:", decimalFormat1
/*  980 */               .format(b1.i()), "%" }));
/*  981 */       stringJoiner.add(String.join("", new CharSequence[] { "Excluir competidor: ", b1.aL() ? "sim" : "não", " e Posição: ", 
/*  982 */               Integer.toString(b1.F()) }));
/*      */     } 
/*      */     
/*  985 */     stringJoiner.add(String.join(" ", new CharSequence[] { "Configuração replicada nos itens:", paramBoolean ? "sim" : "não" }));
/*      */     
/*  987 */     return stringJoiner.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   private void s(ActionEvent paramActionEvent) {
/*  992 */     String str1 = "Restaurar default";
/*  993 */     String str2 = "Deseja restaurar as configurações desta disputa de acordo com as configurações gerais?";
/*  994 */     int k = JOptionPane.showConfirmDialog(this, str2, str1, 0);
/*      */     
/*  996 */     if (k == 0) {
/*  997 */       dt();
/*  998 */       dispose();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void e(FocusEvent paramFocusEvent) {
/* 1003 */     this.c.selectAll();
/*      */   }
/*      */   
/*      */   private void t(ActionEvent paramActionEvent) {
/* 1007 */     if (this.a.a() == m.b || this.a.a() == m.f) {
/* 1008 */       this.y.setEnabled((ab() == 1));
/* 1009 */       this.b.setEnabled((ab() == 1));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void e(MouseEvent paramMouseEvent) {}
/*      */ 
/*      */   
/*      */   private void f(MouseEvent paramMouseEvent) {}
/*      */ 
/*      */   
/*      */   private String a(BigDecimal paramBigDecimal) {
/* 1022 */     DecimalFormat decimalFormat = y.a("###,###,##0.00");
/* 1023 */     return decimalFormat.format(paramBigDecimal);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean cc() {
/* 1032 */     List list = this.b.B();
/* 1033 */     return list.stream().anyMatch(paramg -> paramg.aQ());
/*      */   }
/*      */   
/*      */   private boolean cd() {
/* 1037 */     List list = this.b.B();
/* 1038 */     return list.stream().anyMatch(paramg -> (paramg.w() == v.b.v()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean ce() {
/* 1047 */     List list = this.b.B();
/* 1048 */     list.forEach(paramg -> paramg.a(null));
/*      */ 
/*      */ 
/*      */     
/* 1052 */     StringBuilder stringBuilder = new StringBuilder("UPDATE tbitemlicitacao SET");
/* 1053 */     stringBuilder.append(" itevalorreducaoini = ?,");
/* 1054 */     stringBuilder.append(" itevalorreducaofim = ?,");
/* 1055 */     stringBuilder.append(" itetiporeducao = ?,");
/* 1056 */     stringBuilder.append(" iteposicao = ?,");
/* 1057 */     stringBuilder.append(" itedisputameepp = ?,");
/* 1058 */     stringBuilder.append(" iteenviarlancevlrminimo = ?,");
/* 1059 */     stringBuilder.append(" itequatrocasas = ?,");
/* 1060 */     stringBuilder.append(" iteinicioenviolances = ?,");
/* 1061 */     stringBuilder.append(" iteenviarlanceviradaminuto = ?,");
/* 1062 */     stringBuilder.append(" itecobrirlanceviradaminuto = ?,");
/* 1063 */     stringBuilder.append(" itelancesdispensarestando = ?,");
/* 1064 */     stringBuilder.append(" itemomentoenviarlancedispensa = ?,");
/* 1065 */     stringBuilder.append(" itedisputasegundoquinto = ?,");
/* 1066 */     stringBuilder.append(" itepercentualdisputameepp = ?,");
/* 1067 */     stringBuilder.append(" itemomentoenviarlanceaberto = ?,");
/* 1068 */     stringBuilder.append(" itetoptres = ?,");
/* 1069 */     stringBuilder.append(" itemanterdezporcentoprimeirolugar = ?,");
/* 1070 */     stringBuilder.append(" iteexcluircompetidor = ?");
/* 1071 */     stringBuilder.append(" WHERE empcnpj = ?");
/* 1072 */     stringBuilder.append(" AND liccodigo = ?");
/* 1073 */     stringBuilder.append(" AND porcodigo = ?");
/*      */     
/* 1075 */     try (PreparedStatement null = a.a().prepareStatement(stringBuilder.toString())) {
/* 1076 */       byte b1 = 1;
/*      */       
/* 1078 */       preparedStatement.setNull(b1++, 6);
/* 1079 */       preparedStatement.setNull(b1++, 6);
/* 1080 */       preparedStatement.setNull(b1++, 4);
/* 1081 */       preparedStatement.setInt(b1++, h.i.v());
/* 1082 */       preparedStatement.setNull(b1++, 16);
/* 1083 */       preparedStatement.setNull(b1++, 16);
/* 1084 */       preparedStatement.setNull(b1++, 16);
/* 1085 */       preparedStatement.setNull(b1++, 4);
/* 1086 */       preparedStatement.setNull(b1++, 16);
/* 1087 */       preparedStatement.setNull(b1++, 16);
/* 1088 */       preparedStatement.setNull(b1++, 16);
/* 1089 */       preparedStatement.setNull(b1++, -5);
/* 1090 */       preparedStatement.setNull(b1++, 16);
/* 1091 */       preparedStatement.setNull(b1++, 6);
/* 1092 */       preparedStatement.setNull(b1++, -5);
/* 1093 */       preparedStatement.setNull(b1++, 16);
/* 1094 */       preparedStatement.setNull(b1++, 16);
/* 1095 */       preparedStatement.setNull(b1++, 16);
/* 1096 */       preparedStatement.setLong(b1++, this.a.C());
/* 1097 */       preparedStatement.setInt(b1++, this.a.v());
/* 1098 */       preparedStatement.setInt(b1++, this.a.b().v());
/* 1099 */       preparedStatement.execute();
/*      */       
/*      */       try {
/* 1102 */         this.b.fireTableDataChanged();
/* 1103 */       } catch (Exception exception) {
/* 1104 */         exception.printStackTrace();
/*      */       } 
/* 1106 */       return true;
/* 1107 */     } catch (Exception exception) {
/* 1108 */       exception.printStackTrace();
/*      */ 
/*      */       
/* 1111 */       return false;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean aC() {
/* 1120 */     StringJoiner stringJoiner = new StringJoiner("\n");
/* 1121 */     String str1 = this.g.getText();
/* 1122 */     String str2 = this.f.getText();
/*      */     
/* 1124 */     if (str1 != null && !str1.isEmpty() && str2 != null && !str2.isEmpty()) {
/* 1125 */       BigDecimal bigDecimal1 = a();
/* 1126 */       BigDecimal bigDecimal2 = b();
/*      */       
/* 1128 */       if (bigDecimal1.compareTo(BigDecimal.ZERO) != 1) {
/* 1129 */         stringJoiner.add("Variação inicial deve ser maior que 0,00");
/*      */       }
/* 1131 */       if (bigDecimal2.compareTo(bigDecimal1) == -1) {
/* 1132 */         stringJoiner.add("Variação final deve ser maior ou igual a variação inicial");
/*      */       }
/*      */       
/* 1135 */       BigDecimal bigDecimal3 = z();
/* 1136 */       if (bigDecimal1.compareTo(bigDecimal3) == -1 || bigDecimal2.compareTo(bigDecimal3) == -1) {
/* 1137 */         DecimalFormat decimalFormat = y.a("###,###,##0.0000");
/* 1138 */         stringJoiner.add(String.join("", new CharSequence[] { "O valor mínimo da variação inicial e final deve ser de: ", decimalFormat.format(bigDecimal3) }));
/*      */       } 
/*      */     } else {
/* 1141 */       if (str1 == null || str1.isEmpty()) {
/* 1142 */         stringJoiner.add("Variação inicial não informada");
/*      */       }
/* 1144 */       if (str2 == null || str2.isEmpty()) {
/* 1145 */         stringJoiner.add("Variação final não informada");
/*      */       }
/*      */     } 
/*      */     
/* 1149 */     if (this.c.isVisible()) {
/* 1150 */       String str = this.c.getText();
/* 1151 */       if (str != null && !"".equals(str)) {
/* 1152 */         BigDecimal bigDecimal = c();
/* 1153 */         if (bigDecimal.compareTo(BigDecimal.valueOf(5.01D)) == -1) {
/* 1154 */           stringJoiner.add("O percentual de desconto usado para disputas contra MEEPP deve ser no mínimo de 5,01%");
/* 1155 */         } else if (bigDecimal.compareTo(BigDecimal.valueOf(20L)) == 1) {
/* 1156 */           stringJoiner.add("O percentual de desconto usado para disputas contra MEEPP deve ser no máximo de 20,00%");
/*      */         } 
/*      */       } else {
/* 1159 */         stringJoiner.add("Percentual de desconto usado para disputas contra MEEPP não informado");
/*      */       } 
/*      */     } 
/*      */     
/* 1163 */     if (stringJoiner.length() > 0) {
/* 1164 */       String str = String.join("\n\n", new CharSequence[] { "Para iniciar a disputa é necessário ajustar as situações abaixo:", stringJoiner.toString() });
/* 1165 */       JOptionPane.showMessageDialog(this, str, "Mensagem", 0);
/*      */     } 
/*      */     
/* 1168 */     return (stringJoiner.length() == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean cf() {
/* 1175 */     StringBuilder stringBuilder = new StringBuilder("UPDATE tblicitacao ");
/* 1176 */     stringBuilder.append("SET licvalorreducaoini = ?, ");
/* 1177 */     stringBuilder.append("licvalorreducaofim = ?, ");
/* 1178 */     stringBuilder.append("licinicioenviolances = ?, ");
/* 1179 */     stringBuilder.append("lictiporeducao = ?, ");
/* 1180 */     stringBuilder.append("licdisputameepp = ?, ");
/* 1181 */     stringBuilder.append("licenviarlancevlrminimo = ?, ");
/* 1182 */     stringBuilder.append("licenviarlanceviradaminuto = ?, ");
/* 1183 */     stringBuilder.append("liccobrirlanceviradaminuto = ?, ");
/* 1184 */     stringBuilder.append("liclancesdispensarestando = ?, ");
/* 1185 */     stringBuilder.append("licmomentoenviarlancedispensa = ?, ");
/* 1186 */     stringBuilder.append("licdisputasegundoquinto = ?, ");
/* 1187 */     stringBuilder.append("licenvialanceiniciodisputa = ?, ");
/* 1188 */     stringBuilder.append("lictempoextraentrelances = ?, ");
/* 1189 */     stringBuilder.append("licarredondarcasasdecimais = ?, ");
/* 1190 */     stringBuilder.append("licpercentualdisputameepp = ?, ");
/* 1191 */     stringBuilder.append("licmomentoenviarlanceaberto = ?,");
/* 1192 */     stringBuilder.append("licmomentoenviarlancefechado = ?,");
/* 1193 */     stringBuilder.append("lictoptres = ?,");
/* 1194 */     stringBuilder.append("licmanterdezporcentoprimeirolugar = ?,");
/* 1195 */     stringBuilder.append("licpercentualprimeirolugar = ?,");
/* 1196 */     stringBuilder.append("licexcluircompetidor = ?,");
/* 1197 */     stringBuilder.append("licposicaoexcluircompetidor = ?");
/* 1198 */     stringBuilder.append(" WHERE empcnpj = ?");
/* 1199 */     stringBuilder.append(" AND liccodigo = ?");
/* 1200 */     stringBuilder.append(" AND porcodigo = ?");
/*      */     
/* 1202 */     long l = this.c.a();
/*      */     
/* 1204 */     try (PreparedStatement null = a.a().prepareStatement(stringBuilder.toString())) {
/* 1205 */       byte b1 = 1;
/* 1206 */       preparedStatement.setBigDecimal(b1++, a());
/* 1207 */       preparedStatement.setBigDecimal(b1++, b());
/* 1208 */       preparedStatement.setInt(b1++, ab());
/* 1209 */       preparedStatement.setInt(b1++, b().getSelectedIndex());
/* 1210 */       preparedStatement.setBoolean(b1++, a().isSelected());
/* 1211 */       preparedStatement.setBoolean(b1++, b().isSelected());
/* 1212 */       preparedStatement.setBoolean(b1++, this.m.isSelected());
/* 1213 */       preparedStatement.setBoolean(b1++, this.j.isSelected());
/* 1214 */       preparedStatement.setBoolean(b1++, this.i.isSelected());
/* 1215 */       preparedStatement.setLong(b1++, this.a.getTime());
/* 1216 */       preparedStatement.setBoolean(b1++, this.c.isSelected());
/* 1217 */       preparedStatement.setBoolean(b1++, this.l.isSelected());
/* 1218 */       preparedStatement.setLong(b1++, l);
/* 1219 */       preparedStatement.setInt(b1++, this.b.h());
/* 1220 */       preparedStatement.setBigDecimal(b1++, c());
/* 1221 */       preparedStatement.setLong(b1++, this.b.getTime());
/* 1222 */       preparedStatement.setLong(b1++, this.c.getTime());
/* 1223 */       preparedStatement.setBoolean(b1++, this.n.isSelected());
/* 1224 */       preparedStatement.setBoolean(b1++, this.a.isSelected());
/* 1225 */       preparedStatement.setBigDecimal(b1++, this.a.d());
/* 1226 */       preparedStatement.setBoolean(b1++, this.a.isSelected());
/* 1227 */       preparedStatement.setInt(b1++, this.a.j());
/* 1228 */       preparedStatement.setLong(b1++, this.a.C());
/* 1229 */       preparedStatement.setInt(b1++, this.a.v());
/* 1230 */       preparedStatement.setInt(b1++, this.a.b().v());
/*      */       
/* 1232 */       preparedStatement.executeUpdate();
/*      */ 
/*      */       
/* 1235 */       this.a.a(b.b((j)this.a));
/* 1236 */     } catch (Exception exception) {
/* 1237 */       exception.printStackTrace();
/* 1238 */       return false;
/*      */     } 
/*      */     
/*      */     try {
/* 1242 */       if (this.l.isSelected()) {
/* 1243 */         StringBuilder stringBuilder1 = new StringBuilder();
/* 1244 */         stringBuilder1.append("Disputa com envio de lances no início <br>");
/* 1245 */         stringBuilder1.append("Portal: ").append(this.a.b().K()).append("<br>");
/* 1246 */         stringBuilder1.append("Código: ").append(this.a.v()).append("<br>");
/* 1247 */         stringBuilder1.append("UASG: ").append(this.a.K()).append("<br>");
/* 1248 */         stringBuilder1.append("UASG nome: ").append(this.a.bT()).append("<br>");
/* 1249 */         stringBuilder1.append("Número: ").append(this.a.bo()).append("<br>");
/* 1250 */         stringBuilder1.append("Data abertura: ").append(this.a.bS()).append("<br>");
/* 1251 */         stringBuilder1.append("Empresa: ").append(this.a.a().bv()).append("<br>");
/* 1252 */         stringBuilder1.append("CNPJ licitação: ").append(this.a.a().x()).append("<br>");
/* 1253 */         stringBuilder1.append("Usuário: ").append(this.a.a().getUser()).append("<br>");
/* 1254 */         stringBuilder1.append("Senha: ").append(this.a.a().getPassword());
/* 1255 */         g.a().d(stringBuilder1.toString());
/*      */       } 
/* 1257 */     } catch (Exception exception) {}
/*      */ 
/*      */     
/* 1260 */     if (l > 0L) {
/* 1261 */       j.a().a((j)this.a, l);
/*      */     }
/*      */     
/* 1264 */     return true;
/*      */   }
/*      */   
/*      */   private void dt() {
/* 1268 */     String str = "UPDATE tblicitacao SET licinicioenviolances = NULL WHERE empcnpj = ? AND liccodigo = ? AND porcodigo = ?";
/*      */ 
/*      */     
/* 1271 */     try (PreparedStatement null = a.a().prepareStatement(str)) {
/* 1272 */       byte b1 = 1;
/* 1273 */       preparedStatement.setLong(b1++, this.a.C());
/* 1274 */       preparedStatement.setInt(b1++, this.a.v());
/* 1275 */       preparedStatement.setInt(b1++, this.a.b().v());
/* 1276 */       preparedStatement.executeUpdate();
/*      */ 
/*      */       
/* 1279 */       this.a.a(null);
/* 1280 */     } catch (Exception exception) {
/* 1281 */       exception.printStackTrace();
/* 1282 */       JOptionPane.showMessageDialog(this, "Não foi possível restaurar as configurações da disputa!", "Erro", 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int ab() {
/* 1292 */     return this.i.getSelectedIndex();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float c() {
/* 1301 */     return Float.parseFloat(y.Q(this.g.getText()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float d() {
/* 1310 */     return Float.parseFloat(y.Q(this.f.getText()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int i() {
/* 1319 */     return this.a.getSelectedIndex();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JFormattedTextField a() {
/* 1328 */     return this.g;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JFormattedTextField b() {
/* 1337 */     return this.f;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JComboBox<String> a() {
/* 1346 */     return this.i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JComboBox b() {
/* 1355 */     return (JComboBox)this.a;
/*      */   }
/*      */   
/*      */   public JCheckBox a() {
/* 1359 */     return this.k;
/*      */   }
/*      */   
/*      */   public JCheckBox b() {
/* 1363 */     return this.h;
/*      */   }
/*      */ 
/*      */   
/*      */   private BigDecimal a() {
/* 1368 */     String str = (this.g.getText().length() > 0) ? this.g.getText() : "0,00";
/*      */     
/* 1370 */     str = y.Q(str);
/* 1371 */     return new BigDecimal(str);
/*      */   }
/*      */ 
/*      */   
/*      */   private BigDecimal b() {
/* 1376 */     String str = (this.f.getText().length() > 0) ? this.f.getText() : "0,00";
/*      */     
/* 1378 */     str = y.Q(str);
/* 1379 */     return new BigDecimal(str);
/*      */   }
/*      */ 
/*      */   
/*      */   private BigDecimal c() {
/* 1384 */     String str = (this.c.getText().length() > 0) ? this.c.getText() : "5,01";
/*      */     
/* 1386 */     str = y.Q(str);
/* 1387 */     return new BigDecimal(str);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\n\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */