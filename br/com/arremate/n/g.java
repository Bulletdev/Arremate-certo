/*      */ package br.com.arremate.n;
/*      */ import br.com.arremate.c.a.i;
/*      */ import br.com.arremate.d.b;
/*      */ import br.com.arremate.e.a;
/*      */ import br.com.arremate.f.h;
/*      */ import br.com.arremate.f.i;
/*      */ import br.com.arremate.f.l;
/*      */ import br.com.arremate.f.m;
/*      */ import br.com.arremate.f.o;
/*      */ import br.com.arremate.f.v;
/*      */ import br.com.arremate.f.w;
/*      */ import br.com.arremate.f.z;
/*      */ import br.com.arremate.l.b;
/*      */ import br.com.arremate.l.d;
/*      */ import br.com.arremate.l.e;
/*      */ import br.com.arremate.l.j;
/*      */ import br.com.arremate.l.n;
/*      */ import br.com.arremate.l.p.j;
/*      */ import br.com.arremate.l.q.b.e;
/*      */ import br.com.arremate.l.q.b.f;
/*      */ import br.com.arremate.m.b;
/*      */ import br.com.arremate.m.n;
/*      */ import br.com.arremate.m.y;
/*      */ import java.awt.Component;
/*      */ import java.awt.Font;
/*      */ import java.awt.Insets;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.event.WindowAdapter;
/*      */ import java.awt.event.WindowEvent;
/*      */ import java.math.BigDecimal;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.text.DecimalFormat;
/*      */ import java.util.StringJoiner;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JCheckBox;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JFormattedTextField;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JToggleButton;
/*      */ import javax.swing.KeyStroke;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.text.DefaultFormatterFactory;
/*      */ import javax.swing.text.NumberFormatter;
/*      */ import org.apache.commons.lang3.StringUtils;
/*      */ 
/*      */ public final class g extends JDialog {
/*   57 */   private static final Logger a = LoggerFactory.getLogger(g.class); private final e c; private final i b; private final b c; private String fJ; private JCheckBox h; private JCheckBox i; private JPanel p; private JButton o; private JToggleButton a; private JButton p; private JCheckBox j; private JCheckBox k; private JCheckBox c; private JCheckBox m;
/*      */   private JCheckBox n;
/*      */   private JComboBox<String> i;
/*      */   private JComboBox l;
/*      */   private JComboBox<String> a;
/*      */   private JFormattedTextField c;
/*      */   private JFormattedTextField f;
/*      */   private JFormattedTextField g;
/*      */   private JLabel y;
/*      */   private JLabel l;
/*      */   private JLabel al;
/*      */   private JLabel ai;
/*      */   
/*      */   public g(e parame, b paramb) {
/*   71 */     this.c = (i)parame;
/*   72 */     this.b = (i)paramb.a();
/*   73 */     this.c = (i)paramb;
/*      */     
/*   75 */     k();
/*   76 */     l();
/*      */ 
/*      */     
/*   79 */     if (this.c.a().b().a() == o.h)
/*   80 */       this.l.setEnabled(false); 
/*      */   }
/*      */   private JLabel am; private JLabel aj; private JPanel q; private JPanel r; private b b; private JPanel s; private JPanel t; private e a; private f c; private JPanel u; private br.com.arremate.c.a.g b; private br.com.arremate.c.a.g c; private br.com.arremate.c.a.g d; private br.com.arremate.c.a.g e; private JPanel v; private JPanel w; private h a; private JPanel x; private JPanel y; private JPanel z; private JPanel A; private i a; private i b; private i c; private JLabel ak;
/*      */   
/*      */   private void l() {
/*   85 */     KeyStroke keyStroke = KeyStroke.getKeyStroke(27, 0);
/*   86 */     byte b1 = 2;
/*   87 */     getRootPane().registerKeyboardAction(paramActionEvent -> dispose(), keyStroke, b1);
/*      */     
/*   89 */     this.b.a(paramChangeEvent -> {
/*      */           DecimalFormat decimalFormat = a();
/*      */           BigDecimal bigDecimal = z();
/*      */           a(bigDecimal, bigDecimal, decimalFormat);
/*      */         });
/*      */   }
/*      */   
/*      */   private void a(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, DecimalFormat paramDecimalFormat) {
/*   97 */     this.g.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(paramDecimalFormat)));
/*   98 */     this.f.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(paramDecimalFormat)));
/*      */     
/*  100 */     this.g.setValue(paramBigDecimal1);
/*  101 */     this.f.setValue(paramBigDecimal2);
/*      */   }
/*      */   
/*      */   private DecimalFormat a() {
/*  105 */     int j = this.b.h();
/*  106 */     byte b1 = 4;
/*  107 */     String str = "0";
/*      */     
/*  109 */     if (j < b1) {
/*  110 */       j = Math.abs(j - b1);
/*  111 */       str = String.join("", new CharSequence[] { "0.", StringUtils.leftPad("0", j, "0") });
/*      */     } 
/*      */     
/*  114 */     str = "###,###,##" + str;
/*  115 */     return y.a(str);
/*      */   }
/*      */   private BigDecimal z() {
/*      */     String str;
/*  119 */     int j = this.b.h();
/*  120 */     byte b1 = 4;
/*      */ 
/*      */     
/*  123 */     if (j < b1) {
/*  124 */       j = Math.abs(j - b1);
/*  125 */       str = String.join("", new CharSequence[] { "0.", StringUtils.leftPad("1", j, "0") });
/*      */     } else {
/*  127 */       j = j - b1 + 1;
/*  128 */       str = StringUtils.rightPad("1", j, "0");
/*      */     } 
/*      */     
/*  131 */     return new BigDecimal(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void dr() {
/*  138 */     setLocationRelativeTo((Component)null);
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
/*  149 */     this.p = (JButton)new JPanel();
/*  150 */     this.aj = new JLabel();
/*  151 */     this.g = new JFormattedTextField();
/*  152 */     this.y = (JPanel)new JLabel();
/*  153 */     this.f = new JFormattedTextField();
/*  154 */     this.ai = new JLabel();
/*  155 */     this.a = (i)new JComboBox();
/*  156 */     this.al = new JLabel();
/*  157 */     this.l = (JLabel)new JComboBox();
/*  158 */     this.am = new JLabel();
/*  159 */     this.l = new JLabel();
/*  160 */     this.i = new JComboBox<>();
/*  161 */     this.h = new JCheckBox();
/*  162 */     this.k = new JCheckBox();
/*  163 */     this.c = (i)new JCheckBox();
/*  164 */     this.A = new JPanel();
/*  165 */     this.c = (i)new f();
/*  166 */     this.c = (i)new JFormattedTextField();
/*  167 */     this.r = new JPanel();
/*  168 */     this.b = (i)new b();
/*  169 */     this.ak = new JLabel();
/*  170 */     this.d = new br.com.arremate.c.a.g();
/*  171 */     this.t = new JPanel();
/*  172 */     this.m = new JCheckBox();
/*  173 */     this.j = new JCheckBox();
/*  174 */     this.x = new JPanel();
/*  175 */     this.a = new i(TimeUnit.MINUTES.toMillis(1L));
/*  176 */     this.i = (JComboBox<String>)new JCheckBox();
/*  177 */     this.e = new br.com.arremate.c.a.g();
/*  178 */     this.w = new JPanel();
/*  179 */     this.y = new JPanel();
/*  180 */     this.b = new i();
/*  181 */     this.b = (i)new br.com.arremate.c.a.g();
/*  182 */     this.v = new JPanel();
/*  183 */     this.s = new JPanel();
/*  184 */     this.n = new JCheckBox();
/*  185 */     this.a = (i)new h();
/*  186 */     this.q = new JPanel();
/*  187 */     this.a = (i)new e();
/*  188 */     this.z = new JPanel();
/*  189 */     this.c = new i(TimeUnit.MINUTES.toMillis(1L));
/*  190 */     this.c = (i)new br.com.arremate.c.a.g();
/*  191 */     this.u = new JPanel();
/*  192 */     this.a = (i)new JToggleButton();
/*  193 */     this.p = new JButton();
/*  194 */     this.o = new JButton();
/*      */     
/*  196 */     setDefaultCloseOperation(2);
/*  197 */     setTitle("Effecti - Configurações gerais do " + cD());
/*  198 */     setIconImage((new ImageIcon(getClass().getResource("/img/icone.jpg"))).getImage());
/*  199 */     setModal(true);
/*  200 */     addWindowListener(new WindowAdapter(this) {
/*      */           public void windowOpened(WindowEvent param1WindowEvent) {
/*  202 */             g.a(this.a, param1WindowEvent);
/*      */           }
/*      */         });
/*      */     
/*  206 */     this.p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Configurações Gerais"));
/*      */     
/*  208 */     this.aj.setText("Variação:");
/*      */     
/*  210 */     this.g.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###,###,##0.00"))));
/*  211 */     this.g.setHorizontalAlignment(4);
/*  212 */     this.g.addFocusListener(new FocusAdapter(this) {
/*      */           public void focusGained(FocusEvent param1FocusEvent) {
/*  214 */             g.a(this.a, param1FocusEvent);
/*      */           }
/*      */           public void focusLost(FocusEvent param1FocusEvent) {
/*  217 */             g.b(this.a, param1FocusEvent);
/*      */           }
/*      */         });
/*      */     
/*  221 */     this.y.setText("até");
/*      */     
/*  223 */     this.f.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###,###,##0.00"))));
/*  224 */     this.f.setHorizontalAlignment(4);
/*  225 */     this.f.addFocusListener(new FocusAdapter(this) {
/*      */           public void focusGained(FocusEvent param1FocusEvent) {
/*  227 */             g.c(this.a, param1FocusEvent);
/*      */           }
/*      */           public void focusLost(FocusEvent param1FocusEvent) {
/*  230 */             g.d(this.a, param1FocusEvent);
/*      */           }
/*      */         });
/*      */     
/*  234 */     this.ai.setText("Tipo redução:");
/*      */     
/*  236 */     this.a.setModel(new DefaultComboBoxModel<>(new String[] { "Valor", "Percentual" }));
/*  237 */     this.a.setSelectedIndex(-1);
/*      */     
/*  239 */     this.al.setText("Posição de disputa:");
/*      */     
/*  241 */     this.l.setAutoscrolls(true);
/*      */     
/*  243 */     this.am.setFont(new Font("Dialog", 1, 10));
/*  244 */     this.am.setForeground(y.d());
/*  245 */     this.am.setText("jLabel2");
/*      */     
/*  247 */     this.l.setText("Iniciar lances a partir de:");
/*      */     
/*  249 */     this.i.addActionListener(new ActionListener(this) {
/*      */           public void actionPerformed(ActionEvent param1ActionEvent) {
/*  251 */             g.a(this.a, param1ActionEvent);
/*      */           }
/*      */         });
/*      */     
/*  255 */     this.h.setText("Realizar lance do valor limite quando não for mais possível disputar o 1º lugar?");
/*  256 */     this.h.setToolTipText("");
/*  257 */     this.h.setActionCommand("checkBox_EnviarLanceVlrMinimo");
/*  258 */     this.h.setMargin(new Insets(2, 0, 2, 2));
/*      */     
/*  260 */     this.k.setText("Disputar contra ME/EPP utilizando o percentual (%):");
/*  261 */     this.k.setMargin(new Insets(2, 0, 2, 2));
/*      */     
/*  263 */     this.c.setText("Disputar a melhor posição possível");
/*  264 */     this.c.setMargin(new Insets(2, 0, 2, 2));
/*      */     
/*  266 */     this.A.setBorder(BorderFactory.createTitledBorder("Tempo entre próprio lance"));
/*      */     
/*  268 */     GroupLayout groupLayout1 = new GroupLayout(this.A);
/*  269 */     this.A.setLayout(groupLayout1);
/*  270 */     groupLayout1.setHorizontalGroup(groupLayout1
/*  271 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  272 */         .addGroup(groupLayout1.createSequentialGroup()
/*  273 */           .addContainerGap()
/*  274 */           .addComponent((Component)this.c, -2, -1, -2)
/*  275 */           .addContainerGap(48, 32767)));
/*      */     
/*  277 */     groupLayout1.setVerticalGroup(groupLayout1
/*  278 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  279 */         .addGroup(groupLayout1.createSequentialGroup()
/*  280 */           .addContainerGap()
/*  281 */           .addComponent((Component)this.c, -2, -1, -2)
/*  282 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  285 */     this.c.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###,###,##0.00"))));
/*  286 */     this.c.setHorizontalAlignment(4);
/*  287 */     this.c.setPreferredSize(new Dimension(50, 20));
/*      */     
/*  289 */     this.r.setBorder(BorderFactory.createTitledBorder("Arredondar lance"));
/*      */     
/*  291 */     this.ak.setFont(new Font("Dialog", 1, 10));
/*  292 */     this.ak.setForeground(y.d());
/*  293 */     this.ak.setText("<html>Esta licitação possui o <br> limite de x casas decimais</html>");
/*      */     
/*  295 */     GroupLayout groupLayout2 = new GroupLayout(this.r);
/*  296 */     this.r.setLayout(groupLayout2);
/*  297 */     groupLayout2.setHorizontalGroup(groupLayout2
/*  298 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  299 */         .addGroup(groupLayout2.createSequentialGroup()
/*  300 */           .addContainerGap()
/*  301 */           .addComponent((Component)this.b, -2, -1, -2)
/*  302 */           .addGap(18, 18, 18)
/*  303 */           .addComponent(this.ak, -2, -1, -2)
/*  304 */           .addContainerGap(-1, 32767)));
/*      */     
/*  306 */     groupLayout2.setVerticalGroup(groupLayout2
/*  307 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  308 */         .addGroup(groupLayout2.createSequentialGroup()
/*  309 */           .addContainerGap()
/*  310 */           .addComponent((Component)this.b, -2, -1, -2)
/*  311 */           .addContainerGap(-1, 32767))
/*  312 */         .addGroup(groupLayout2.createSequentialGroup()
/*  313 */           .addComponent(this.ak, -2, -1, -2)
/*  314 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/*  317 */     GroupLayout groupLayout3 = new GroupLayout(this.p);
/*  318 */     this.p.setLayout(groupLayout3);
/*  319 */     groupLayout3.setHorizontalGroup(groupLayout3
/*  320 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  321 */         .addGroup(groupLayout3.createSequentialGroup()
/*  322 */           .addContainerGap()
/*  323 */           .addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  324 */             .addGroup(groupLayout3.createSequentialGroup()
/*  325 */               .addComponent(this.r, -2, -1, -2)
/*  326 */               .addContainerGap(-1, 32767))
/*  327 */             .addGroup(groupLayout3.createSequentialGroup()
/*  328 */               .addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  329 */                 .addGroup(groupLayout3.createSequentialGroup()
/*  330 */                   .addComponent(this.ai)
/*  331 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  332 */                   .addComponent((Component)this.a, -2, -1, -2)
/*  333 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  334 */                   .addComponent(this.aj)
/*  335 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  336 */                   .addComponent(this.g, -2, 90, -2)
/*  337 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  338 */                   .addComponent(this.y)
/*  339 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  340 */                   .addComponent(this.f, -2, 90, -2)
/*  341 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  342 */                   .addComponent((Component)this.d, -2, -1, -2))
/*  343 */                 .addGroup(groupLayout3.createSequentialGroup()
/*  344 */                   .addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  345 */                     .addGroup(groupLayout3.createSequentialGroup()
/*  346 */                       .addComponent(this.al)
/*  347 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  348 */                       .addComponent(this.l, -2, 76, -2))
/*  349 */                     .addGroup(groupLayout3.createSequentialGroup()
/*  350 */                       .addComponent(this.l)
/*  351 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  352 */                       .addComponent(this.i, -2, 175, -2))
/*  353 */                     .addGroup(groupLayout3.createSequentialGroup()
/*  354 */                       .addComponent(this.k)
/*  355 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  356 */                       .addComponent((Component)this.c, -2, -1, -2))
/*  357 */                     .addComponent(this.A, -2, -1, -2)
/*  358 */                     .addComponent((Component)this.c)
/*  359 */                     .addComponent(this.h)
/*  360 */                     .addComponent(this.am))
/*  361 */                   .addGap(0, 0, 32767)))
/*  362 */               .addGap(6, 6, 6)))));
/*      */     
/*  364 */     groupLayout3.setVerticalGroup(groupLayout3
/*  365 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  366 */         .addGroup(groupLayout3.createSequentialGroup()
/*  367 */           .addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  368 */             .addGroup(groupLayout3.createSequentialGroup()
/*  369 */               .addContainerGap()
/*  370 */               .addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  371 */                 .addComponent((Component)this.a, -2, -1, -2)
/*  372 */                 .addComponent(this.ai)
/*  373 */                 .addComponent(this.aj)
/*  374 */                 .addComponent(this.g, -2, -1, -2)
/*  375 */                 .addComponent(this.y)
/*  376 */                 .addComponent(this.f, -2, -1, -2)))
/*  377 */             .addComponent((Component)this.d, -2, -1, -2))
/*  378 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  379 */           .addComponent(this.am)
/*  380 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  381 */           .addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  382 */             .addComponent(this.l, -2, -1, -2)
/*  383 */             .addComponent(this.al))
/*  384 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  385 */           .addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  386 */             .addComponent(this.i, -2, -1, -2)
/*  387 */             .addComponent(this.l))
/*  388 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  389 */           .addComponent(this.r, -2, -1, -2)
/*  390 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  391 */           .addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  392 */             .addComponent(this.k)
/*  393 */             .addComponent((Component)this.c, -2, -1, -2))
/*  394 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  395 */           .addComponent((Component)this.c)
/*  396 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  397 */           .addComponent(this.h)
/*  398 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  399 */           .addComponent(this.A, -2, -1, -2)
/*  400 */           .addContainerGap()));
/*      */ 
/*      */     
/*  403 */     this.t.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Configuraçãoes da Cotação - Comprasnet"));
/*      */     
/*  405 */     this.m.setText("Enviar lances somente na virada do minuto");
/*  406 */     this.m.setMargin(new Insets(2, 0, 2, 2));
/*      */     
/*  408 */     this.j.setText("Cobrir o próprio lance na virada do minuto");
/*  409 */     this.j.setMargin(new Insets(2, 0, 2, 2));
/*      */     
/*  411 */     this.x.setBorder(BorderFactory.createTitledBorder(""));
/*      */     
/*  413 */     this.i.setText("Iniciar o envio de lances restando:");
/*      */     
/*  415 */     GroupLayout groupLayout4 = new GroupLayout(this.x);
/*  416 */     this.x.setLayout(groupLayout4);
/*  417 */     groupLayout4.setHorizontalGroup(groupLayout4
/*  418 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  419 */         .addGroup(groupLayout4.createSequentialGroup()
/*  420 */           .addGap(10, 10, 10)
/*  421 */           .addGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  422 */             .addGroup(groupLayout4.createSequentialGroup()
/*  423 */               .addGap(4, 4, 4)
/*  424 */               .addComponent((Component)this.a, -2, 135, -2))
/*  425 */             .addComponent(this.i))
/*  426 */           .addContainerGap(-1, 32767)));
/*      */     
/*  428 */     groupLayout4.setVerticalGroup(groupLayout4
/*  429 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  430 */         .addGroup(GroupLayout.Alignment.TRAILING, groupLayout4.createSequentialGroup()
/*  431 */           .addGap(11, 11, 11)
/*  432 */           .addComponent(this.i, -2, 20, -2)
/*  433 */           .addGap(3, 3, 3)
/*  434 */           .addComponent((Component)this.a, -2, -1, -2)
/*  435 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  438 */     GroupLayout groupLayout5 = new GroupLayout(this.t);
/*  439 */     this.t.setLayout(groupLayout5);
/*  440 */     groupLayout5.setHorizontalGroup(groupLayout5
/*  441 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  442 */         .addGroup(groupLayout5.createSequentialGroup()
/*  443 */           .addContainerGap()
/*  444 */           .addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  445 */             .addGroup(groupLayout5.createSequentialGroup()
/*  446 */               .addComponent(this.m)
/*  447 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  448 */               .addComponent((Component)this.e, -2, -1, -2))
/*  449 */             .addGroup(groupLayout5.createSequentialGroup()
/*  450 */               .addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  451 */                 .addComponent(this.j)
/*  452 */                 .addComponent(this.x, -2, -1, -2))
/*  453 */               .addGap(0, 0, 32767)))
/*  454 */           .addGap(6, 6, 6)));
/*      */     
/*  456 */     groupLayout5.setVerticalGroup(groupLayout5
/*  457 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  458 */         .addGroup(groupLayout5.createSequentialGroup()
/*  459 */           .addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  460 */             .addGroup(groupLayout5.createSequentialGroup()
/*  461 */               .addGap(11, 11, 11)
/*  462 */               .addComponent(this.m))
/*  463 */             .addComponent((Component)this.e, -2, -1, -2))
/*  464 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  465 */           .addComponent(this.j)
/*  466 */           .addGap(11, 11, 11)
/*  467 */           .addComponent(this.x, -2, -1, -2)
/*  468 */           .addContainerGap()));
/*      */ 
/*      */     
/*  471 */     this.w.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Configurações do Modo Aberto")));
/*      */     
/*  473 */     this.y.setBorder(BorderFactory.createTitledBorder("Enviar lance restando"));
/*      */     
/*  475 */     GroupLayout groupLayout6 = new GroupLayout(this.y);
/*  476 */     this.y.setLayout(groupLayout6);
/*  477 */     groupLayout6.setHorizontalGroup(groupLayout6
/*  478 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  479 */         .addGroup(groupLayout6.createSequentialGroup()
/*  480 */           .addContainerGap()
/*  481 */           .addComponent((Component)this.b, -2, 135, -2)
/*  482 */           .addContainerGap(-1, 32767)));
/*      */     
/*  484 */     groupLayout6.setVerticalGroup(groupLayout6
/*  485 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  486 */         .addGroup(groupLayout6.createSequentialGroup()
/*  487 */           .addContainerGap()
/*  488 */           .addComponent((Component)this.b, -2, -1, -2)
/*  489 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  492 */     GroupLayout groupLayout7 = new GroupLayout(this.w);
/*  493 */     this.w.setLayout(groupLayout7);
/*  494 */     groupLayout7.setHorizontalGroup(groupLayout7
/*  495 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  496 */         .addGroup(groupLayout7.createSequentialGroup()
/*  497 */           .addContainerGap()
/*  498 */           .addComponent(this.y, -2, -1, -2)
/*  499 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  500 */           .addComponent((Component)this.b, -2, -1, -2)
/*  501 */           .addGap(6, 6, 6)));
/*      */     
/*  503 */     groupLayout7.setVerticalGroup(groupLayout7
/*  504 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  505 */         .addGroup(groupLayout7.createSequentialGroup()
/*  506 */           .addGroup(groupLayout7.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  507 */             .addGroup(groupLayout7.createSequentialGroup()
/*  508 */               .addContainerGap()
/*  509 */               .addComponent(this.y, -2, -1, -2))
/*  510 */             .addComponent((Component)this.b, -2, -1, -2))
/*  511 */           .addContainerGap()));
/*      */ 
/*      */     
/*  514 */     this.v.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Configurações do Modo Aberto/Fechado"));
/*      */     
/*  516 */     this.s.setBorder(BorderFactory.createTitledBorder("Conservador"));
/*      */     
/*  518 */     this.n.setText("Top 3 (Ficar entre os três primeiros)");
/*  519 */     this.n.addMouseListener(new MouseAdapter(this) {
/*      */           public void mouseClicked(MouseEvent param1MouseEvent) {
/*  521 */             g.a(this.a, param1MouseEvent);
/*      */           }
/*      */         });
/*      */     
/*  525 */     GroupLayout groupLayout8 = new GroupLayout(this.s);
/*  526 */     this.s.setLayout(groupLayout8);
/*  527 */     groupLayout8.setHorizontalGroup(groupLayout8
/*  528 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  529 */         .addGroup(groupLayout8.createSequentialGroup()
/*  530 */           .addContainerGap()
/*  531 */           .addGroup(groupLayout8.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  532 */             .addComponent(this.n)
/*  533 */             .addComponent((Component)this.a, -2, -1, -2))
/*  534 */           .addContainerGap(-1, 32767)));
/*      */     
/*  536 */     groupLayout8.setVerticalGroup(groupLayout8
/*  537 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  538 */         .addGroup(groupLayout8.createSequentialGroup()
/*  539 */           .addGap(11, 11, 11)
/*  540 */           .addComponent(this.n)
/*  541 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  542 */           .addComponent((Component)this.a, -2, -1, -2)
/*  543 */           .addContainerGap()));
/*      */ 
/*      */     
/*  546 */     this.q.setBorder(BorderFactory.createTitledBorder("Agressivo"));
/*      */     
/*  548 */     GroupLayout groupLayout9 = new GroupLayout(this.q);
/*  549 */     this.q.setLayout(groupLayout9);
/*  550 */     groupLayout9.setHorizontalGroup(groupLayout9
/*  551 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  552 */         .addGroup(groupLayout9.createSequentialGroup()
/*  553 */           .addGap(10, 10, 10)
/*  554 */           .addComponent((Component)this.a, -2, -1, -2)
/*  555 */           .addContainerGap(-1, 32767)));
/*      */     
/*  557 */     groupLayout9.setVerticalGroup(groupLayout9
/*  558 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  559 */         .addGroup(groupLayout9.createSequentialGroup()
/*  560 */           .addGap(11, 11, 11)
/*  561 */           .addComponent((Component)this.a, -2, -1, -2)
/*  562 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  565 */     this.z.setBorder(BorderFactory.createTitledBorder("Enviar lance fechado restando"));
/*      */     
/*  567 */     GroupLayout groupLayout10 = new GroupLayout(this.z);
/*  568 */     this.z.setLayout(groupLayout10);
/*  569 */     groupLayout10.setHorizontalGroup(groupLayout10
/*  570 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  571 */         .addGroup(groupLayout10.createSequentialGroup()
/*  572 */           .addContainerGap()
/*  573 */           .addComponent((Component)this.c, -2, 135, -2)
/*  574 */           .addContainerGap(33, 32767)));
/*      */     
/*  576 */     groupLayout10.setVerticalGroup(groupLayout10
/*  577 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  578 */         .addGroup(GroupLayout.Alignment.TRAILING, groupLayout10.createSequentialGroup()
/*  579 */           .addContainerGap(-1, 32767)
/*  580 */           .addComponent((Component)this.c, -2, -1, -2)
/*  581 */           .addContainerGap()));
/*      */ 
/*      */     
/*  584 */     GroupLayout groupLayout11 = new GroupLayout(this.v);
/*  585 */     this.v.setLayout(groupLayout11);
/*  586 */     groupLayout11.setHorizontalGroup(groupLayout11
/*  587 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  588 */         .addGroup(groupLayout11.createSequentialGroup()
/*  589 */           .addContainerGap()
/*  590 */           .addGroup(groupLayout11.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  591 */             .addGroup(groupLayout11.createSequentialGroup()
/*  592 */               .addComponent(this.s, -2, -1, -2)
/*  593 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  594 */               .addComponent((Component)this.c, -2, -1, -2))
/*  595 */             .addGroup(groupLayout11.createSequentialGroup()
/*  596 */               .addGroup(groupLayout11.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  597 */                 .addComponent(this.q, -2, -1, -2)
/*  598 */                 .addComponent(this.z, -2, -1, -2))
/*  599 */               .addGap(0, 0, 32767)))
/*  600 */           .addGap(6, 6, 6)));
/*      */     
/*  602 */     groupLayout11.setVerticalGroup(groupLayout11
/*  603 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  604 */         .addGroup(groupLayout11.createSequentialGroup()
/*  605 */           .addGroup(groupLayout11.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  606 */             .addGroup(groupLayout11.createSequentialGroup()
/*  607 */               .addContainerGap()
/*  608 */               .addComponent(this.s, -1, -1, 32767))
/*  609 */             .addGroup(groupLayout11.createSequentialGroup()
/*  610 */               .addComponent((Component)this.c, -2, -1, -2)
/*  611 */               .addGap(0, 0, 32767)))
/*  612 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  613 */           .addComponent(this.q, -2, -1, -2)
/*  614 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  615 */           .addComponent(this.z, -2, -1, -2)
/*  616 */           .addContainerGap()));
/*      */ 
/*      */     
/*  619 */     this.u.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/*  621 */     this.a.setIcon(new ImageIcon(getClass().getResource("/img/delete.png")));
/*  622 */     this.a.setText("Fechar");
/*  623 */     this.a.addActionListener(new ActionListener(this) {
/*      */           public void actionPerformed(ActionEvent param1ActionEvent) {
/*  625 */             g.b(this.a, param1ActionEvent);
/*      */           }
/*      */         });
/*      */     
/*  629 */     this.p.setIcon(new ImageIcon(getClass().getResource("/img/accept.png")));
/*  630 */     this.p.setText("Gravar");
/*  631 */     this.p.addActionListener(new ActionListener(this) {
/*      */           public void actionPerformed(ActionEvent param1ActionEvent) {
/*  633 */             g.c(this.a, param1ActionEvent);
/*      */           }
/*      */         });
/*      */     
/*  637 */     this.o.setIcon(new ImageIcon(getClass().getResource("/img/arrow_circle.png")));
/*  638 */     this.o.setText("Default");
/*  639 */     this.o.setToolTipText("Utilizar configurações da licitação");
/*  640 */     this.o.addActionListener(new ActionListener(this) {
/*      */           public void actionPerformed(ActionEvent param1ActionEvent) {
/*  642 */             g.d(this.a, param1ActionEvent);
/*      */           }
/*      */         });
/*      */     
/*  646 */     GroupLayout groupLayout12 = new GroupLayout(this.u);
/*  647 */     this.u.setLayout(groupLayout12);
/*  648 */     groupLayout12.setHorizontalGroup(groupLayout12
/*  649 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  650 */         .addGroup(GroupLayout.Alignment.TRAILING, groupLayout12.createSequentialGroup()
/*  651 */           .addContainerGap(-1, 32767)
/*  652 */           .addComponent(this.o)
/*  653 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  654 */           .addComponent(this.p)
/*  655 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  656 */           .addComponent((Component)this.a)
/*  657 */           .addContainerGap()));
/*      */     
/*  659 */     groupLayout12.setVerticalGroup(groupLayout12
/*  660 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  661 */         .addGroup(groupLayout12.createSequentialGroup()
/*  662 */           .addContainerGap()
/*  663 */           .addGroup(groupLayout12.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  664 */             .addComponent((Component)this.a)
/*  665 */             .addComponent(this.p)
/*  666 */             .addComponent(this.o))
/*  667 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  670 */     GroupLayout groupLayout13 = new GroupLayout(getContentPane());
/*  671 */     getContentPane().setLayout(groupLayout13);
/*  672 */     groupLayout13.setHorizontalGroup(groupLayout13
/*  673 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  674 */         .addGroup(groupLayout13.createSequentialGroup()
/*  675 */           .addContainerGap()
/*  676 */           .addGroup(groupLayout13.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  677 */             .addComponent(this.v, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  678 */             .addComponent(this.w, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  679 */             .addComponent(this.t, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  680 */             .addComponent(this.p, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  681 */             .addComponent(this.u, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/*  682 */           .addContainerGap(-1, 32767)));
/*      */     
/*  684 */     groupLayout13.setVerticalGroup(groupLayout13
/*  685 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  686 */         .addGroup(groupLayout13.createSequentialGroup()
/*  687 */           .addContainerGap()
/*  688 */           .addComponent(this.p, -2, -1, -2)
/*  689 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  690 */           .addComponent(this.t, -2, -1, -2)
/*  691 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  692 */           .addComponent(this.w, -2, -1, -2)
/*  693 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  694 */           .addComponent(this.v, -2, -1, -2)
/*  695 */           .addGap(11, 11, 11)
/*  696 */           .addComponent(this.u, -2, -1, -2)
/*  697 */           .addContainerGap()));
/*      */ 
/*      */     
/*  700 */     pack();
/*      */   }
/*      */   
/*      */   private void h(FocusEvent paramFocusEvent) {
/*  704 */     this.g.selectAll();
/*      */   }
/*      */   
/*      */   private void i(FocusEvent paramFocusEvent) {
/*  708 */     if (((!this.g.getText().isEmpty() ? 1 : 0) & this.f.getText().isEmpty()) != 0) {
/*  709 */       this.f.setText(this.g.getText());
/*      */     }
/*      */   }
/*      */   
/*      */   private void j(FocusEvent paramFocusEvent) {
/*  714 */     this.f.selectAll();
/*      */   }
/*      */   
/*      */   private void k(FocusEvent paramFocusEvent) {
/*  718 */     if (((!this.f.getText().isEmpty() ? 1 : 0) & this.g.getText().isEmpty()) != 0) {
/*  719 */       this.g.setText(this.f.getText());
/*      */     }
/*      */   }
/*      */   
/*      */   private void r(ActionEvent paramActionEvent) {
/*  724 */     if (!cg()) {
/*      */       return;
/*      */     }
/*      */     
/*  728 */     int j = this.a.getSelectedIndex();
/*  729 */     b b1 = (b)this.l.getSelectedItem();
/*  730 */     int k = (int)b1.getValue();
/*  731 */     boolean bool1 = this.k.isSelected();
/*  732 */     boolean bool2 = this.h.isSelected();
/*  733 */     int m = this.i.getSelectedIndex();
/*  734 */     boolean bool3 = this.m.isSelected();
/*  735 */     boolean bool4 = this.j.isSelected();
/*      */     
/*  737 */     boolean bool5 = this.i.isSelected();
/*  738 */     long l1 = this.a.getTime();
/*      */     
/*  740 */     boolean bool6 = this.c.isSelected();
/*  741 */     long l2 = this.c.a();
/*  742 */     int n = this.b.h();
/*  743 */     BigDecimal bigDecimal1 = c();
/*  744 */     long l3 = this.b.getTime();
/*  745 */     long l4 = this.c.getTime();
/*  746 */     boolean bool7 = this.n.isSelected();
/*  747 */     boolean bool8 = this.a.isSelected();
/*  748 */     BigDecimal bigDecimal2 = this.a.d();
/*  749 */     boolean bool9 = this.a.isSelected();
/*  750 */     int i1 = this.a.j();
/*      */     
/*  752 */     a(
/*  753 */         a(), 
/*  754 */         b(), j, k, bool1, bool2, m, bool3, bool4, bool5, l1, bool6, l2, n, bigDecimal1, l3, l4, bool7, bool8, bigDecimal2, bool9, i1);
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
/*  777 */     this.b.fireTableDataChanged();
/*  778 */     dispose();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, long paramLong1, boolean paramBoolean6, long paramLong2, int paramInt4, BigDecimal paramBigDecimal3, long paramLong3, long paramLong4, boolean paramBoolean7, boolean paramBoolean8, BigDecimal paramBigDecimal4, boolean paramBoolean9, int paramInt5) {
/*  787 */     StringBuilder stringBuilder = new StringBuilder("UPDATE tbitemlicitacao SET");
/*  788 */     stringBuilder.append(" itevalorreducaoini = ?,");
/*  789 */     stringBuilder.append(" itevalorreducaofim = ?,");
/*  790 */     stringBuilder.append(" itetiporeducao = ?,");
/*  791 */     stringBuilder.append(" iteposicao = ?,");
/*  792 */     stringBuilder.append(" itedisputameepp = ?,");
/*  793 */     stringBuilder.append(" iteenviarlancevlrminimo = ?,");
/*  794 */     stringBuilder.append(" itequatrocasas = ?,");
/*  795 */     stringBuilder.append(" iteinicioenviolances = ?,");
/*  796 */     stringBuilder.append(" iteenviarlanceviradaminuto = ?,");
/*  797 */     stringBuilder.append(" itecobrirlanceviradaminuto = ?,");
/*  798 */     stringBuilder.append(" itelancesdispensarestando = ?,");
/*  799 */     stringBuilder.append(" itemomentoenviarlancedispensa = ?,");
/*  800 */     stringBuilder.append(" itedisputasegundoquinto = ?,");
/*  801 */     stringBuilder.append(" itetempoextraentrelances = ?,");
/*  802 */     stringBuilder.append(" itearredondarcasasdecimais = ?,");
/*  803 */     stringBuilder.append(" itepercentualdisputameepp = ?,");
/*  804 */     stringBuilder.append(" itemomentoenviarlanceaberto = ?,");
/*  805 */     stringBuilder.append(" itemomentoenviarlancefechado = ?,");
/*  806 */     stringBuilder.append(" itetoptres = ?,");
/*  807 */     stringBuilder.append(" itemanterdezporcentoprimeirolugar = ?,");
/*  808 */     stringBuilder.append(" itepercentualprimeirolugar = ?,");
/*  809 */     stringBuilder.append(" iteexcluircompetidor = ?,");
/*  810 */     stringBuilder.append(" iteposicaoexcluircompetidor = ?");
/*  811 */     stringBuilder.append(" WHERE empcnpj = ?");
/*  812 */     stringBuilder.append(" AND liccodigo = ?");
/*  813 */     stringBuilder.append(" AND porcodigo = ?");
/*      */     
/*  815 */     boolean bool = this.c instanceof f;
/*      */     
/*  817 */     if (bool) {
/*  818 */       stringBuilder.append(" AND itecodigogrupo = ?");
/*      */     } else {
/*  820 */       stringBuilder.append(" AND itecodigo = ?");
/*      */     } 
/*      */     
/*  823 */     try (PreparedStatement null = a.a().prepareStatement(stringBuilder.toString())) {
/*  824 */       byte b1 = 1;
/*  825 */       preparedStatement.setBigDecimal(b1++, paramBigDecimal1);
/*  826 */       preparedStatement.setBigDecimal(b1++, paramBigDecimal2);
/*  827 */       preparedStatement.setInt(b1++, paramInt1);
/*  828 */       preparedStatement.setInt(b1++, paramInt2);
/*  829 */       preparedStatement.setBoolean(b1++, paramBoolean1);
/*  830 */       preparedStatement.setBoolean(b1++, paramBoolean2);
/*  831 */       preparedStatement.setBoolean(b1++, false);
/*  832 */       preparedStatement.setInt(b1++, paramInt3);
/*  833 */       preparedStatement.setBoolean(b1++, paramBoolean3);
/*  834 */       preparedStatement.setBoolean(b1++, paramBoolean4);
/*  835 */       preparedStatement.setBoolean(b1++, paramBoolean5);
/*  836 */       preparedStatement.setLong(b1++, paramLong1);
/*  837 */       preparedStatement.setBoolean(b1++, paramBoolean6);
/*  838 */       preparedStatement.setLong(b1++, paramLong2);
/*  839 */       preparedStatement.setInt(b1++, paramInt4);
/*  840 */       preparedStatement.setBigDecimal(b1++, paramBigDecimal3);
/*  841 */       preparedStatement.setLong(b1++, paramLong3);
/*  842 */       preparedStatement.setLong(b1++, paramLong4);
/*  843 */       preparedStatement.setBoolean(b1++, paramBoolean7);
/*  844 */       preparedStatement.setBoolean(b1++, paramBoolean8);
/*  845 */       preparedStatement.setBigDecimal(b1++, paramBigDecimal4);
/*  846 */       preparedStatement.setBoolean(b1++, paramBoolean9);
/*  847 */       preparedStatement.setInt(b1++, paramInt5);
/*  848 */       preparedStatement.setLong(b1++, this.c.a().C());
/*  849 */       preparedStatement.setInt(b1++, this.c.a().v());
/*  850 */       preparedStatement.setInt(b1++, this.c.a().b().v());
/*  851 */       preparedStatement.setInt(b1++, this.c.v());
/*  852 */       preparedStatement.execute();
/*      */       
/*  854 */       this.c.l(paramInt2);
/*      */       
/*  856 */       if (bool) {
/*  857 */         e e1 = ((f)this.c).a();
/*  858 */         e1.a(b.a(e1));
/*  859 */         j.a().a(e1);
/*      */         
/*  861 */         if (paramLong2 > 0L) {
/*  862 */           j.a().a(e1, paramLong2);
/*      */         }
/*      */       } else {
/*  865 */         br.com.arremate.l.g g1 = this.c.a();
/*  866 */         g1.a(b.a(g1));
/*  867 */         j.a().g(g1);
/*      */         
/*  869 */         if (paramLong2 > 0L) {
/*  870 */           j.a().a(g1, paramLong2);
/*      */         }
/*      */       } 
/*      */       
/*  874 */       this.c.a(cC(), false);
/*  875 */     } catch (Exception exception) {
/*  876 */       a.warn("Failed to save item configurations", exception);
/*      */     } 
/*      */   }
/*      */   private String cC() {
/*      */     b b1;
/*  881 */     j j = this.c.a();
/*      */     
/*  883 */     StringJoiner stringJoiner = new StringJoiner(" | ");
/*  884 */     DecimalFormat decimalFormat1 = y.a("###,###,##0.00");
/*      */     
/*  886 */     if (this.c.ay()) {
/*  887 */       stringJoiner.add(String.join(" ", new CharSequence[] { "Alterada configuração do grupo", this.c.bo() }));
/*  888 */       b1 = ((f)this.c).a().b();
/*      */     } else {
/*  890 */       stringJoiner.add(String.join(" ", new CharSequence[] { "Alterada configuração do item", this.c.bo() }));
/*  891 */       b1 = this.c.a().b();
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  896 */     BigDecimal bigDecimal1 = (b1.a() == w.b) ? b1.f().multiply(BigDecimal.valueOf(100L)) : b1.f();
/*      */ 
/*      */     
/*  899 */     BigDecimal bigDecimal2 = (b1.a() == w.b) ? b1.g().multiply(BigDecimal.valueOf(100L)) : b1.g();
/*      */     
/*  901 */     DecimalFormat decimalFormat2 = y.a("###,###,##0.0000");
/*  902 */     String str1 = decimalFormat2.format(bigDecimal1);
/*  903 */     String str2 = decimalFormat2.format(bigDecimal2);
/*      */     
/*  905 */     stringJoiner.add(String.join(" ", new CharSequence[] { "Variação inicial e final:", str1, "até", str2 }));
/*  906 */     stringJoiner.add(String.join(" ", new CharSequence[] { "Tipo de redução:", b1.a().K() }));
/*  907 */     stringJoiner.add(String.join(" ", new CharSequence[] { "Posição de disputa:", h.a(this.c.j()).K() }));
/*  908 */     stringJoiner.add(String.join(" ", new CharSequence[] { "Iniciar lances em:", b1.a(j).K() }));
/*  909 */     stringJoiner.add(String.join(" ", new CharSequence[] { "Arredondar casas decimais:", Integer.toString(b1.E()) }));
/*      */     
/*  911 */     o o = j.b().a();
/*  912 */     boolean bool = o.equals(o.k);
/*      */     
/*  914 */     l l = j.a();
/*  915 */     boolean bool1 = (o.equals(o.a) && l.equals(l.c)) ? true : false;
/*      */     
/*  917 */     if (bool) {
/*  918 */       stringJoiner.add(String.join(" ", new CharSequence[] { "Enviar lance na virada do minuto:", b1.aG() ? "sim" : "não" }));
/*  919 */       stringJoiner.add(String.join(" ", new CharSequence[] { "Cobrir lance na virada do minuto:", b1.aH() ? "sim" : "não" }));
/*  920 */     } else if (bool1) {
/*  921 */       stringJoiner.add(String.join(" ", new CharSequence[] { "Cobrir lance nos segundos finais da disputa:", b1.aH() ? "sim" : "não" }));
/*  922 */     } else if (l.equals(l.g)) {
/*  923 */       stringJoiner.add(String.join(" ", new CharSequence[] { "Cobrir lance nos segundos finais da disputa:", b1.aH() ? "sim" : "não" }));
/*  924 */       stringJoiner.add(String.join("", new CharSequence[] { "Disputar a melhor posição possível: ", b1.aE() ? "sim" : "não" }));
/*      */     } else {
/*  926 */       stringJoiner.add(String.join(" ", new CharSequence[] { "Disputar contra ME/EPP:", 
/*  927 */               b1.a(j.b(), j.a(), j.a()) ? "sim" : "não", "e Percentual:", decimalFormat1
/*  928 */               .format(b1.h()), "%" }));
/*  929 */       stringJoiner.add(String.join("", new CharSequence[] { "Disputar a melhor posição possível: ", b1.aE() ? "sim" : "não" }));
/*      */     } 
/*      */     
/*  932 */     stringJoiner.add(String.join(" ", new CharSequence[] { "Enviar lance derradeiro:", b1.aD() ? "sim" : "não" }));
/*  933 */     stringJoiner.add(String.join(" ", new CharSequence[] { "Tempo entre o próprio lance:", Long.toString(TimeUnit.MILLISECONDS.toSeconds(b1.t())), "segundos" }));
/*      */     
/*  935 */     if (j.a() == m.a && j.b().a() == o.a) {
/*  936 */       stringJoiner.add(String.join(" ", new CharSequence[] { "Enviar lance no inicio da disputa:", b1.aF() ? "sim" : "não" }));
/*      */     }
/*      */     
/*  939 */     if (j.a() == m.b || j.a() == m.f) {
/*  940 */       int k = (int)TimeUnit.MILLISECONDS.toMinutes(b1.u());
/*  941 */       int m = (int)TimeUnit.MILLISECONDS.toSeconds(b1.u());
/*  942 */       m -= k * 60;
/*      */       
/*  944 */       stringJoiner.add(String.join(" ", new CharSequence[] { "Enviar lance restando:", Integer.toString(k), "minuto(s) e", Integer.toString(m), "segundos" }));
/*      */     } 
/*      */     
/*  947 */     if (j.a() == m.c) {
/*  948 */       int k = (int)TimeUnit.MILLISECONDS.toMinutes(b1.w());
/*  949 */       int m = (int)TimeUnit.MILLISECONDS.toSeconds(b1.w());
/*  950 */       m -= k * 60;
/*      */       
/*  952 */       stringJoiner.add(String.join(" ", new CharSequence[] { "Enviar lance fechado restando:", Integer.toString(k), "minuto(s) e", Integer.toString(m), "segundos" }));
/*      */     } 
/*      */     
/*  955 */     if (j.a() == m.c) {
/*  956 */       stringJoiner.add(String.join(" ", new CharSequence[] { "Top 3:", b1.aJ() ? "sim" : "não" }));
/*  957 */       stringJoiner.add(String.join(" ", new CharSequence[] { "10% do primeiro colocado:", b1.aK() ? "sim" : "não", "e Percentual:", decimalFormat1
/*  958 */               .format(b1.i()), "%" }));
/*  959 */       stringJoiner.add(String.join("", new CharSequence[] { "Excluir competidor: ", b1.aL() ? "sim" : "não", " e Posição: ", 
/*  960 */               Integer.toString(b1.F()) }));
/*      */     } 
/*      */     
/*  963 */     return stringJoiner.toString();
/*      */   }
/*      */   
/*      */   private void q(ActionEvent paramActionEvent) {
/*  967 */     dispose();
/*      */   }
/*      */   
/*      */   private void a(WindowEvent paramWindowEvent) {
/*      */     try {
/*  972 */       b b1 = this.c.b();
/*  973 */       j j = this.c.a();
/*  974 */       n n = j.b();
/*  975 */       o o = n.a();
/*  976 */       m m = this.c.a().a();
/*      */       
/*  978 */       if (j.N() > 0) {
/*  979 */         this.b.j(4 - j.N());
/*  980 */         this.ak.setText("<html>Esta licitação possui o <br> limite de " + j.N() + " casas decimais</html>");
/*      */       } else {
/*  982 */         this.ak.setVisible(false);
/*      */       } 
/*      */       
/*  985 */       this.b.i(b1.E());
/*      */       
/*  987 */       if (this.fJ != null && !this.fJ.isEmpty()) {
/*  988 */         this.am.setText(this.fJ);
/*  989 */         this.am.setVisible(true);
/*      */       } else {
/*  991 */         this.am.setVisible(false);
/*      */       } 
/*      */       
/*  994 */       this.l.addItem(new b(h.i));
/*      */       
/*  996 */       if (!n.bS()) {
/*  997 */         this.l.setVisible(false);
/*  998 */         this.al.setVisible(false);
/*      */       } else {
/* 1000 */         this.l.removeAllItems();
/* 1001 */         this.l.addItem(new b(h.i));
/* 1002 */         this.l.addItem(new b(h.b));
/* 1003 */         this.l.addItem(new b(h.c));
/* 1004 */         this.l.addItem(new b(h.d));
/* 1005 */         this.l.addItem(new b(h.e));
/*      */       } 
/*      */       
/* 1008 */       this.m.setVisible(false);
/* 1009 */       this.j.setVisible(false);
/* 1010 */       this.t.setVisible(false);
/* 1011 */       this.x.setVisible(false);
/* 1012 */       this.a.m(30);
/*      */       
/* 1014 */       l l = j.a();
/* 1015 */       boolean bool1 = (o.equals(o.a) && l.equals(l.c)) ? true : false;
/* 1016 */       boolean bool2 = o.equals(o.k);
/*      */       
/* 1018 */       this.c.setVisible((n.aE() && !bool1 && !bool2));
/* 1019 */       if (this.c.isVisible()) {
/* 1020 */         this.c.addItemListener(paramItemEvent -> {
/*      */               if (this.c.isSelected() && this.c.isEnabled()) {
/*      */                 this.h.setEnabled(false);
/*      */                 
/*      */                 this.h.setSelected(false);
/*      */               } else {
/*      */                 this.h.setEnabled(true);
/*      */                 this.h.setSelected(paramb.aD());
/*      */               } 
/*      */             });
/* 1030 */         this.c.setSelected(b1.aE());
/*      */       } 
/*      */       
/* 1033 */       boolean bool3 = (l.equals(l.c) || l.equals(l.g)) ? true : false;
/* 1034 */       bool1 = (o.equals(o.a) && bool3) ? true : false;
/*      */       
/* 1036 */       if ((bool1 || bool2) && 
/* 1037 */         n.bT()) {
/* 1038 */         this.t.setVisible(true);
/*      */         
/* 1040 */         if (bool2) {
/* 1041 */           this.m.setVisible(true);
/* 1042 */           this.j.setVisible(true);
/* 1043 */         } else if (bool1) {
/* 1044 */           this.j.setVisible(true);
/* 1045 */           this.j.setText("Cobrir o próprio lance nos segundos finais da disputa");
/* 1046 */           ((TitledBorder)this.t.getBorder()).setTitle("Configuraçãoes da Dispensa - Comprasnet");
/* 1047 */           this.x.setVisible(true);
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1053 */       this.d.setUrl(z.b.getUrl());
/* 1054 */       this.b.setUrl(z.c.getUrl());
/* 1055 */       this.c.setUrl(z.d.getUrl());
/* 1056 */       if (bool1) {
/* 1057 */         this.e.setUrl(z.e.getUrl());
/* 1058 */       } else if (bool2) {
/* 1059 */         this.e.setUrl(z.f.getUrl());
/*      */       } 
/*      */ 
/*      */       
/* 1063 */       if (m == m.b || m == m.f) {
/* 1064 */         this.b.m(this.c.a().D());
/*      */       } else {
/* 1066 */         this.w.setVisible(false);
/*      */       } 
/*      */       
/* 1069 */       boolean bool4 = false;
/* 1070 */       if (m == m.c) {
/* 1071 */         this.c.m(5);
/*      */         
/* 1073 */         bool4 = true;
/*      */         
/* 1075 */         boolean bool = (this.c.w() != v.b.v()) ? true : false;
/* 1076 */         this.s.setVisible(bool);
/* 1077 */         this.q.setVisible(bool);
/*      */       } else {
/* 1079 */         this.v.setVisible(false);
/*      */       } 
/*      */       
/* 1082 */       boolean bool5 = n.bk();
/* 1083 */       boolean bool6 = (this.c.a().a().a() != p.b) ? true : false;
/* 1084 */       boolean bool7 = (bool5 && !bool4 && bool6 && !bool1 && !bool2) ? true : false;
/* 1085 */       this.k.setVisible(bool7);
/* 1086 */       this.k.setEnabled(bool7);
/* 1087 */       this.c.setVisible(bool7);
/* 1088 */       this.c.setEnabled(bool7);
/*      */       
/* 1090 */       this.h.setSelected(b1.aD());
/*      */       
/* 1092 */       this.l.addActionListener(paramActionEvent -> {
/*      */             if (this.l.getSelectedIndex() != 0) {
/*      */               this.c.setEnabled(false);
/*      */               
/*      */               this.c.setSelected(true);
/*      */               this.h.setEnabled(false);
/*      */               this.h.setSelected(false);
/*      */             } else if (!this.c.isEnabled()) {
/*      */               this.h.setEnabled(false);
/*      */               this.h.setSelected(false);
/*      */               this.c.setEnabled(true);
/*      */               this.c.setSelected(true);
/*      */             } 
/*      */           });
/* 1106 */       DecimalFormat decimalFormat1 = y.a("###,###,##0.00");
/* 1107 */       this.c.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(decimalFormat1)));
/* 1108 */       this.c.setText(decimalFormat1.format(b1.h()));
/*      */ 
/*      */       
/* 1111 */       DecimalFormat decimalFormat2 = a();
/*      */ 
/*      */       
/* 1114 */       BigDecimal bigDecimal1 = (b1.a() == w.b) ? b1.f().multiply(BigDecimal.valueOf(100L)) : b1.f();
/*      */ 
/*      */       
/* 1117 */       BigDecimal bigDecimal2 = (b1.a() == w.b) ? b1.g().multiply(BigDecimal.valueOf(100L)) : b1.g();
/*      */       
/* 1119 */       a(bigDecimal1, bigDecimal2, decimalFormat2);
/*      */ 
/*      */       
/* 1122 */       this.a.setSelectedIndex(b1.a().y());
/*      */       
/* 1124 */       for (byte b2 = 0; b2 < this.l.getItemCount(); b2++) {
/* 1125 */         b b3 = this.l.getItemAt(b2);
/*      */         
/* 1127 */         if (b3.getValue() == this.c.j()) {
/* 1128 */           this.l.setSelectedIndex(b2);
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/* 1133 */       i i1 = i.a(0, this.c.a());
/* 1134 */       this.i.addItem(i1.K());
/*      */       
/* 1136 */       if (!bool1) {
/* 1137 */         i i2 = i.a(1, this.c.a());
/* 1138 */         this.i.addItem(i2.K());
/*      */         
/* 1140 */         i i3 = i.a(2, this.c.a());
/* 1141 */         if (i2 != i3) {
/* 1142 */           this.i.addItem(i3.K());
/*      */         }
/*      */       } 
/*      */       
/* 1146 */       if (o == o.a && this.c.w() == v.b.v()) {
/* 1147 */         this.a.setModel(new DefaultComboBoxModel<>(new String[] { "Acréscimo de x%" }));
/*      */       }
/*      */       
/* 1150 */       int k = b1.a(this.c.a()).v();
/*      */       
/* 1152 */       if (k >= this.i.getItemCount()) {
/* 1153 */         k = this.i.getItemCount() - 1;
/*      */       }
/*      */       
/* 1156 */       d d = this.c.a().a();
/* 1157 */       this.k.setSelected(b1.a(n, d, m));
/*      */       
/* 1159 */       this.i.setSelectedIndex(k);
/*      */       
/* 1161 */       this.m.setSelected(b1.aG());
/* 1162 */       this.j.setSelected(b1.aH());
/* 1163 */       this.i.setSelected(b1.aI());
/* 1164 */       this.a.c(b1.v());
/*      */       
/* 1166 */       this.c.b(b1.t());
/* 1167 */       this.b.c(b1.u());
/* 1168 */       this.c.c(b1.w());
/* 1169 */       this.n.setSelected(b1.aJ());
/* 1170 */       this.a.setSelected(b1.aK());
/* 1171 */       this.a.c(b1.i());
/* 1172 */       this.a.setSelected(b1.aL());
/* 1173 */       this.a.l(b1.F());
/* 1174 */     } catch (Exception exception) {
/* 1175 */       a.warn("Failed to load item configurations", exception);
/*      */     } 
/*      */     
/* 1178 */     validate();
/* 1179 */     repaint();
/* 1180 */     pack();
/* 1181 */     dr();
/*      */   }
/*      */   
/*      */   private void s(ActionEvent paramActionEvent) {
/* 1185 */     String str1 = "Restaurar default";
/* 1186 */     String str2 = "Deseja restaurar as configurações deste item de acordo com as configurações da disputa?";
/* 1187 */     int j = JOptionPane.showConfirmDialog(this, str2, str1, 0);
/*      */     
/* 1189 */     if (j == 0) {
/* 1190 */       dt();
/* 1191 */       dispose();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void t(ActionEvent paramActionEvent) {
/* 1196 */     if (this.c.a().a() == m.b || this.c.a().a() == m.f) {
/* 1197 */       this.y.setEnabled((this.i.getSelectedIndex() == 1));
/* 1198 */       this.b.setEnabled((this.i.getSelectedIndex() == 1));
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void e(MouseEvent paramMouseEvent) {}
/*      */ 
/*      */   
/*      */   private boolean cg() {
/* 1207 */     StringJoiner stringJoiner = new StringJoiner("\n");
/* 1208 */     String str1 = this.g.getText();
/* 1209 */     String str2 = this.f.getText();
/*      */     
/* 1211 */     if (str1 != null && !str1.isEmpty() && str2 != null && !str2.isEmpty()) {
/* 1212 */       BigDecimal bigDecimal1 = a();
/* 1213 */       BigDecimal bigDecimal2 = b();
/*      */       
/* 1215 */       if (bigDecimal1.compareTo(BigDecimal.ZERO) != 1) {
/* 1216 */         stringJoiner.add("Variação inicial deve ser maior que 0,00");
/*      */       }
/*      */       
/* 1219 */       if (bigDecimal2.compareTo(bigDecimal1) == -1) {
/* 1220 */         stringJoiner.add("Variação final deve ser maior ou igual a variação inicial");
/*      */       }
/*      */       
/* 1223 */       BigDecimal bigDecimal3 = z();
/* 1224 */       if (bigDecimal1.compareTo(bigDecimal3) == -1 || bigDecimal2.compareTo(bigDecimal3) == -1) {
/* 1225 */         DecimalFormat decimalFormat = y.a("###,###,##0.0000");
/* 1226 */         stringJoiner.add(String.join("", new CharSequence[] { "O valor mínimo da variação inicial e final deve ser de: ", decimalFormat.format(bigDecimal3) }));
/*      */       } 
/*      */     } else {
/* 1229 */       if (str1 == null || str1.isEmpty()) {
/* 1230 */         stringJoiner.add("Variação inicial não informada");
/*      */       }
/*      */       
/* 1233 */       if (str2 == null || str2.isEmpty()) {
/* 1234 */         stringJoiner.add("Variação final não informada");
/*      */       }
/*      */     } 
/*      */     
/* 1238 */     if (this.c.isVisible()) {
/* 1239 */       String str = this.c.getText();
/* 1240 */       if (str != null && !"".equals(str)) {
/* 1241 */         BigDecimal bigDecimal = c();
/* 1242 */         if (bigDecimal.compareTo(BigDecimal.valueOf(5.01D)) == -1) {
/* 1243 */           stringJoiner.add("O percentual de desconto usado para disputas contra MEEPP deve ser no mínimo de 5,01%");
/* 1244 */         } else if (bigDecimal.compareTo(BigDecimal.valueOf(20L)) == 1) {
/* 1245 */           stringJoiner.add("O percentual de desconto usado para disputas contra MEEPP deve ser no máximo de 20,00%");
/*      */         } 
/*      */       } else {
/* 1248 */         stringJoiner.add("Percentual de desconto usado para disputas contra MEEPP não informado");
/*      */       } 
/*      */     } 
/*      */     
/* 1252 */     if (stringJoiner.length() > 0) {
/* 1253 */       String str = String.join("\n\n", new CharSequence[] { "Para iniciar a disputa é necessário ajustar as situações abaixo:", stringJoiner.toString() });
/* 1254 */       JOptionPane.showMessageDialog(this, str, "Mensagem", 0);
/*      */     } 
/*      */     
/* 1257 */     return (stringJoiner.length() == 0);
/*      */   }
/*      */   
/*      */   public void dt() {
/* 1261 */     boolean bool = this.c instanceof f;
/* 1262 */     StringBuilder stringBuilder = new StringBuilder("UPDATE tbitemlicitacao SET");
/* 1263 */     stringBuilder.append(" itevalorreducaoini = NULL,");
/* 1264 */     stringBuilder.append(" itevalorreducaofim = NULL,");
/* 1265 */     stringBuilder.append(" itetiporeducao = NULL,");
/* 1266 */     stringBuilder.append(" iteposicao = NULL,");
/* 1267 */     stringBuilder.append(" itedisputameepp = NULL,");
/* 1268 */     stringBuilder.append(" iteenviarlancevlrminimo = NULL,");
/* 1269 */     stringBuilder.append(" itequatrocasas = NULL,");
/* 1270 */     stringBuilder.append(" iteinicioenviolances = NULL,");
/* 1271 */     stringBuilder.append(" iteenviarlanceviradaminuto = NULL,");
/* 1272 */     stringBuilder.append(" itecobrirlanceviradaminuto = NULL,");
/* 1273 */     stringBuilder.append(" itelancesdispensarestando = NULL,");
/* 1274 */     stringBuilder.append(" itemomentoenviarlancedispensa = NULL,");
/* 1275 */     stringBuilder.append(" itedisputasegundoquinto = NULL,");
/* 1276 */     stringBuilder.append(" itepercentualdisputameepp = NULL,");
/* 1277 */     stringBuilder.append(" itemomentoenviarlanceaberto = NULL,");
/* 1278 */     stringBuilder.append(" itemomentoenviarlancefechado = NULL,");
/* 1279 */     stringBuilder.append(" itetoptres = NULL,");
/* 1280 */     stringBuilder.append(" itemanterdezporcentoprimeirolugar = NULL,");
/* 1281 */     stringBuilder.append(" iteexcluircompetidor = NULL");
/* 1282 */     stringBuilder.append(" WHERE empcnpj = ?");
/* 1283 */     stringBuilder.append(" AND liccodigo = ?");
/* 1284 */     stringBuilder.append(" AND porcodigo = ?");
/*      */     
/* 1286 */     if (bool) {
/* 1287 */       stringBuilder.append(" AND itecodigogrupo = ?");
/*      */     } else {
/* 1289 */       stringBuilder.append(" AND itecodigo = ?");
/*      */     } 
/*      */     
/* 1292 */     try (PreparedStatement null = a.a().prepareStatement(stringBuilder.toString())) {
/* 1293 */       byte b1 = 1;
/* 1294 */       preparedStatement.setLong(b1++, this.c.a().C());
/* 1295 */       preparedStatement.setInt(b1++, this.c.a().v());
/* 1296 */       preparedStatement.setInt(b1++, this.c.a().b().v());
/* 1297 */       preparedStatement.setInt(b1++, this.c.v());
/* 1298 */       preparedStatement.execute();
/*      */       
/* 1300 */       if (bool) {
/* 1301 */         ((f)this.c).a().a(null);
/*      */       } else {
/* 1303 */         this.c.a().a(null);
/*      */       } 
/* 1305 */     } catch (Exception exception) {
/* 1306 */       a.info("Não foi possível restaurar as configurações do item!", exception);
/* 1307 */       JOptionPane.showMessageDialog(null, "Não foi possível restaurar as configurações do item!", "Erro", 0);
/*      */     } 
/*      */   }
/*      */   
/*      */   private String cD() {
/* 1312 */     String str = "item " + this.c.v();
/*      */     
/* 1314 */     if (this.c instanceof f) {
/* 1315 */       str = "grupo " + this.c.bo();
/* 1316 */     } else if (this.c.a() instanceof br.com.arremate.l.e.a || this.c
/* 1317 */       .a() instanceof br.com.arremate.l.b.a) {
/* 1318 */       str = "item " + this.c.bo();
/* 1319 */     } else if (this.c.a() instanceof br.com.arremate.l.k.a || this.c
/* 1320 */       .a() instanceof br.com.arremate.l.a.a) {
/* 1321 */       str = "lote " + this.c.bo();
/*      */     } 
/*      */     
/* 1324 */     return str;
/*      */   }
/*      */   
/*      */   public void aL(String paramString) {
/* 1328 */     this.fJ = paramString;
/*      */   }
/*      */ 
/*      */   
/*      */   private BigDecimal a() {
/* 1333 */     String str = (this.g.getText().length() > 0) ? this.g.getText() : "0,00";
/*      */     
/* 1335 */     str = str.replace(".", "").replace(",", ".");
/* 1336 */     return new BigDecimal(str);
/*      */   }
/*      */ 
/*      */   
/*      */   private BigDecimal b() {
/* 1341 */     String str = (this.f.getText().length() > 0) ? this.f.getText() : "0,00";
/*      */     
/* 1343 */     str = str.replace(".", "").replace(",", ".");
/* 1344 */     return new BigDecimal(str);
/*      */   }
/*      */ 
/*      */   
/*      */   private BigDecimal c() {
/* 1349 */     String str = (this.c.getText().length() > 0) ? this.c.getText() : "5,01";
/*      */     
/* 1351 */     str = y.Q(str);
/* 1352 */     return new BigDecimal(str);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\n\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */