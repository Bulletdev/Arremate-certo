/*     */ package br.com.arremate.c.a;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.o;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.l.n;
/*     */ import br.com.arremate.m.y;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Insets;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.StringJoiner;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle;
/*     */ 
/*     */ public class d extends JPanel implements e {
/*  31 */   private static final Logger a = LoggerFactory.getLogger(d.class); private b a; private JCheckBox a; private JCheckBox b; private JButton a; private JCheckBox c; private JComboBox<String> b; private JComboBox<String> c; private JComboBox<String> d; private JComboBox<String> e; private JComboBox<String> f;
/*     */   private JComboBox<String> g;
/*     */   private JComboBox<String> h;
/*     */   private JComboBox<String> i;
/*     */   private JFormattedTextField c;
/*     */   private JLabel e;
/*     */   
/*     */   public d() {
/*  39 */     k();
/*  40 */     l();
/*  41 */     this.a = (f)b.a();
/*     */   }
/*     */   private JLabel f; private JLabel g; private JLabel h; private JLabel i; private JLabel j; private JLabel k; private JLabel l; private JLabel m; private JPanel a; private JPanel b; private JPanel c; private JTextField b; private b b; private c b; private f a;
/*     */   
/*     */   public boolean m() {
/*  46 */     boolean bool = false;
/*  47 */     this.a = (f)b.a();
/*     */     
/*  49 */     try (Statement null = a.a().createStatement()) {
/*     */ 
/*     */       
/*  52 */       BigDecimal bigDecimal1 = (this.a.a() == w.b) ? this.a.f().multiply(BigDecimal.valueOf(100L)) : this.a.f();
/*     */ 
/*     */       
/*  55 */       BigDecimal bigDecimal2 = (this.a.a() == w.b) ? this.a.g().multiply(BigDecimal.valueOf(100L)) : this.a.g();
/*  56 */       boolean bool1 = false;
/*     */       
/*  58 */       DecimalFormat decimalFormat = y.a("###,###,##0.00");
/*  59 */       this.c.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(decimalFormat)));
/*     */ 
/*     */       
/*  62 */       for (o o : o.values()) {
/*  63 */         n n = l.a().a(o);
/*  64 */         if (n != null && n.bk()) {
/*  65 */           bool1 = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*  70 */       this.a.setVisible(bool1);
/*  71 */       this.c.setVisible(bool1);
/*     */       
/*  73 */       String str = "SELECT tbconfiguracao.coninicioenviolances, tbconfiguracao.condisputameepp, tbconfiguracao.concolunasequencia, tbconfiguracao.concolunadescricao, tbconfiguracao.concolunavalorminimo, tbconfiguracao.concolunavariacaoini, tbconfiguracao.concolunavariacaofim, tbconfiguracao.concolunatiporeducao, tbconfiguracao.concolunavalorlancefechado, tbconfiguracao.conpercentualdisputameepp, tbconfiguracao.caminhoexportacao FROM tbconfiguracao WHERE concodigo = 1";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  87 */       try (ResultSet null = statement.executeQuery(str)) {
/*  88 */         if (resultSet.next()) {
/*  89 */           this.b.i(this.a.E());
/*     */           
/*  91 */           this.d.setSelectedIndex(resultSet.getInt("concolunasequencia"));
/*  92 */           this.b.setSelectedIndex(resultSet.getInt("concolunadescricao"));
/*  93 */           this.e.setSelectedIndex(resultSet.getInt("concolunatiporeducao"));
/*  94 */           this.f.setSelectedIndex(resultSet.getInt("concolunavalorminimo"));
/*  95 */           this.h.setSelectedIndex(resultSet.getInt("concolunavariacaoini"));
/*  96 */           this.g.setSelectedIndex(resultSet.getInt("concolunavariacaofim"));
/*  97 */           this.c.setSelectedIndex(resultSet.getInt("concolunavalorlancefechado"));
/*  98 */           this.b.a(bigDecimal1);
/*  99 */           this.b.b(bigDecimal2);
/* 100 */           this.b.k(this.a.a().y());
/* 101 */           this.i.setSelectedIndex(resultSet.getInt("coninicioenviolances"));
/* 102 */           this.b.setSelected(this.a.aD());
/* 103 */           this.c.setSelected(this.a.aE());
/* 104 */           this.c.setVisible(n.aE());
/* 105 */           this.a.setSelected(resultSet.getBoolean("condisputameepp"));
/* 106 */           this.a.b(this.a.t());
/* 107 */           this.c.setText(decimalFormat.format(resultSet.getBigDecimal("conpercentualdisputameepp")));
/* 108 */           this.b.setText(resultSet.getString("caminhoexportacao"));
/*     */           
/* 110 */           bool = true;
/*     */         } 
/*     */       } 
/* 113 */     } catch (Exception exception) {
/* 114 */       a.warn("Failed to load confs", exception);
/*     */     } 
/* 116 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean n() {
/* 121 */     n n = l.a().a(o.a);
/* 122 */     boolean bool = true;
/*     */     
/* 124 */     String str = "UPDATE tbconfiguracao SET  condisputarmelhorposicaopossivel = ?, conenviarlancevlrminimo = ?, concolunasequencia = ?, concolunadescricao = ?, concolunavalorminimo = ?, concolunatiporeducao = ?, concolunavariacaoini = ?, concolunavariacaofim = ?, concolunavalorlancefechado = ?, convalorreducaoini = ?, convalorreducaofim = ?, coninicioenviolances = ?, contiporeducao = ?, condisputameepp = ?, contempoextraentrelances = ?, conarredondarcasasdecimais = ?, conpercentualdisputameepp = ?, caminhoexportacao = ? WHERE concodigo = ?";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 145 */     byte b1 = 1;
/*     */     
/* 147 */     try (PreparedStatement null = a.a().prepareStatement(str)) {
/* 148 */       preparedStatement.setBoolean(b1++, this.c.isSelected());
/* 149 */       preparedStatement.setBoolean(b1++, this.b.isSelected());
/* 150 */       preparedStatement.setInt(b1++, this.d.getSelectedIndex());
/* 151 */       preparedStatement.setInt(b1++, this.b.getSelectedIndex());
/* 152 */       preparedStatement.setInt(b1++, this.f.getSelectedIndex());
/* 153 */       preparedStatement.setInt(b1++, this.e.getSelectedIndex());
/* 154 */       preparedStatement.setInt(b1++, this.h.getSelectedIndex());
/* 155 */       preparedStatement.setInt(b1++, this.g.getSelectedIndex());
/* 156 */       preparedStatement.setInt(b1++, this.c.getSelectedIndex());
/* 157 */       preparedStatement.setBigDecimal(b1++, this.b.a());
/* 158 */       preparedStatement.setBigDecimal(b1++, this.b.b());
/* 159 */       preparedStatement.setInt(b1++, this.i.getSelectedIndex());
/* 160 */       preparedStatement.setInt(b1++, this.b.i());
/* 161 */       preparedStatement.setBoolean(b1++, this.a.isSelected());
/* 162 */       preparedStatement.setLong(b1++, this.a.a());
/* 163 */       preparedStatement.setInt(b1++, this.b.h());
/* 164 */       preparedStatement.setBigDecimal(b1++, c());
/* 165 */       preparedStatement.setString(b1++, this.b.getText());
/* 166 */       preparedStatement.setInt(b1++, n.v());
/* 167 */       preparedStatement.executeUpdate();
/*     */ 
/*     */       
/* 170 */       b.cn();
/* 171 */     } catch (Exception exception) {
/* 172 */       a.warn("Failed to save general confs", exception);
/* 173 */       bool = false;
/*     */     } 
/* 175 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public String k() {
/* 180 */     StringJoiner stringJoiner = new StringJoiner("\n");
/*     */     
/* 182 */     BigDecimal bigDecimal1 = this.b.a();
/* 183 */     BigDecimal bigDecimal2 = this.b.b();
/*     */     
/* 185 */     if (bigDecimal1.compareTo(BigDecimal.ZERO) != 1) {
/* 186 */       stringJoiner.add("Variação inicial deve ser maior que 0,00");
/*     */     }
/* 188 */     if (bigDecimal2.compareTo(BigDecimal.ZERO) != 1) {
/* 189 */       stringJoiner.add("Variação final deve ser maior que 0,00");
/*     */     }
/* 191 */     if (bigDecimal2.compareTo(bigDecimal1) == -1) {
/* 192 */       stringJoiner.add("Variação final deve ser maior ou igual a variação inicial");
/*     */     }
/*     */     
/* 195 */     if (this.c.isVisible()) {
/* 196 */       String str1 = this.c.getText();
/* 197 */       if (str1 != null && !"".equals(str1)) {
/* 198 */         BigDecimal bigDecimal = c();
/* 199 */         if (bigDecimal.compareTo(BigDecimal.valueOf(5.01D)) == -1) {
/* 200 */           stringJoiner.add("O percentual de desconto usado para disputas contra MEEPP deve ser no mínimo de 5,01%");
/* 201 */         } else if (bigDecimal.compareTo(BigDecimal.valueOf(20L)) == 1) {
/* 202 */           stringJoiner.add("O percentual de desconto usado para disputas contra MEEPP deve ser no máximo de 20,00%");
/*     */         } 
/*     */       } else {
/* 205 */         stringJoiner.add("Percentual de desconto usado para disputas contra MEEPP não informado");
/*     */       } 
/*     */     } 
/*     */     
/* 209 */     String str = "";
/* 210 */     if (stringJoiner.length() > 0) {
/* 211 */       str = String.join("", new CharSequence[] { "\n\n", stringJoiner.toString() });
/*     */     }
/*     */     
/* 214 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   private BigDecimal c() {
/* 219 */     String str = (this.c.getText().length() > 0) ? this.c.getText() : "5,01";
/*     */     
/* 221 */     str = y.Q(str);
/* 222 */     return new BigDecimal(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void k() {
/* 233 */     this.l = new JLabel();
/* 234 */     this.i = (JLabel)new JComboBox();
/* 235 */     this.b = (c)new JCheckBox();
/* 236 */     this.b = new c();
/* 237 */     this.a = (f)new JCheckBox();
/* 238 */     this.c = (JPanel)new JCheckBox();
/* 239 */     this.a = (f)new JPanel();
/* 240 */     this.f = new JLabel();
/* 241 */     this.e = new JLabel();
/* 242 */     this.i = new JLabel();
/* 243 */     this.k = new JLabel();
/* 244 */     this.j = new JLabel();
/* 245 */     this.g = new JLabel();
/* 246 */     this.g = (JLabel)new JComboBox();
/* 247 */     this.h = (JLabel)new JComboBox();
/* 248 */     this.f = (JLabel)new JComboBox();
/* 249 */     this.b = (c)new JComboBox();
/* 250 */     this.d = new JComboBox<>();
/* 251 */     this.e = (JLabel)new JComboBox();
/* 252 */     this.h = new JLabel();
/* 253 */     this.c = (JPanel)new JComboBox();
/* 254 */     this.b = (c)new JPanel();
/* 255 */     this.a = new f();
/* 256 */     this.c = (JPanel)new JFormattedTextField();
/* 257 */     this.c = new JPanel();
/* 258 */     this.b = (c)new b();
/* 259 */     this.a = (f)new JButton();
/* 260 */     this.m = new JLabel();
/* 261 */     this.b = (c)new JTextField();
/*     */     
/* 263 */     this.l.setText("Iniciar lances a partir de:");
/*     */     
/* 265 */     this.i.setModel(new DefaultComboBoxModel<>(new String[] { "Aberto", "Iminência", "Aleatório" }));
/*     */     
/* 267 */     this.b.setText("Realizar lance do valor limite quando não for mais possível disputar o 1º lugar?");
/* 268 */     this.b.setToolTipText("");
/* 269 */     this.b.setActionCommand("checkBox_EnviarLanceVlrMinimo");
/* 270 */     this.b.setMargin(new Insets(2, 0, 2, 2));
/*     */     
/* 272 */     this.a.setText("Disputar contra ME/EPP utilizando o percentual (%):");
/* 273 */     this.a.setToolTipText("");
/* 274 */     this.a.setActionCommand("checkBox_EnviarLanceVlrMinimo");
/* 275 */     this.a.setMargin(new Insets(2, 0, 2, 2));
/*     */     
/* 277 */     this.c.setText("Disputar a melhor posição possível");
/* 278 */     this.c.setMargin(new Insets(2, 0, 2, 2));
/*     */     
/* 280 */     this.a.setBorder(BorderFactory.createTitledBorder("Colunas para exportação e importação"));
/*     */     
/* 282 */     this.f.setText("Item:");
/*     */     
/* 284 */     this.e.setText("Descrição:");
/*     */     
/* 286 */     this.i.setText("Valor Limite:");
/*     */     
/* 288 */     this.k.setText("Variação Inicial:");
/*     */     
/* 290 */     this.j.setText("Variação Final:");
/*     */     
/* 292 */     this.g.setText("Tipo Redução:");
/*     */     
/* 294 */     this.g.setModel(new DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" }));
/*     */     
/* 296 */     this.h.setModel(new DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" }));
/*     */     
/* 298 */     this.f.setModel(new DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" }));
/*     */     
/* 300 */     this.b.setModel(new DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" }));
/*     */     
/* 302 */     this.d.setModel(new DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" }));
/* 303 */     this.d.setAutoscrolls(true);
/* 304 */     this.d.setPreferredSize(new Dimension(50, 25));
/*     */     
/* 306 */     this.e.setModel(new DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" }));
/*     */     
/* 308 */     this.h.setText("Lance Fechado:");
/*     */     
/* 310 */     this.c.setModel(new DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" }));
/*     */     
/* 312 */     GroupLayout groupLayout1 = new GroupLayout(this.a);
/* 313 */     this.a.setLayout(groupLayout1);
/* 314 */     groupLayout1.setHorizontalGroup(groupLayout1
/* 315 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 316 */         .addGroup(groupLayout1.createSequentialGroup()
/* 317 */           .addContainerGap()
/* 318 */           .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 319 */             .addGroup(groupLayout1.createSequentialGroup()
/* 320 */               .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 321 */                 .addComponent(this.i)
/* 322 */                 .addComponent(this.e)
/* 323 */                 .addComponent(this.f))
/* 324 */               .addGap(30, 30, 30)
/* 325 */               .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 326 */                 .addComponent(this.d, 0, -1, 32767)
/* 327 */                 .addComponent(this.f, GroupLayout.Alignment.TRAILING, 0, -1, 32767)
/* 328 */                 .addComponent(this.b, GroupLayout.Alignment.TRAILING, -2, 51, -2)))
/* 329 */             .addGroup(groupLayout1.createSequentialGroup()
/* 330 */               .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 331 */                 .addComponent(this.k)
/* 332 */                 .addComponent(this.j)
/* 333 */                 .addComponent(this.g)
/* 334 */                 .addComponent(this.h))
/* 335 */               .addGap(18, 18, 18)
/* 336 */               .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 337 */                 .addComponent(this.c, -2, 51, -2)
/* 338 */                 .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 339 */                   .addComponent(this.g, 0, -1, 32767)
/* 340 */                   .addComponent(this.h, GroupLayout.Alignment.TRAILING, 0, -1, 32767)
/* 341 */                   .addComponent(this.e, -2, 51, -2)))))
/* 342 */           .addContainerGap(146, 32767)));
/*     */     
/* 344 */     groupLayout1.setVerticalGroup(groupLayout1
/* 345 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 346 */         .addGroup(groupLayout1.createSequentialGroup()
/* 347 */           .addContainerGap()
/* 348 */           .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 349 */             .addComponent(this.d, -2, 20, -2)
/* 350 */             .addComponent(this.f))
/* 351 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 352 */           .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 353 */             .addComponent(this.e)
/* 354 */             .addComponent(this.b, -2, -1, -2))
/* 355 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 356 */           .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 357 */             .addComponent(this.f, -2, -1, -2)
/* 358 */             .addComponent(this.i))
/* 359 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 360 */           .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 361 */             .addComponent(this.k)
/* 362 */             .addComponent(this.h, -2, -1, -2))
/* 363 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 364 */           .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 365 */             .addComponent(this.j)
/* 366 */             .addComponent(this.g, -2, -1, -2))
/* 367 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 368 */           .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 369 */             .addComponent(this.e, -2, -1, -2)
/* 370 */             .addComponent(this.g))
/* 371 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 372 */           .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 373 */             .addComponent(this.c, -2, -1, -2)
/* 374 */             .addComponent(this.h))
/* 375 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 378 */     this.b.setBorder(BorderFactory.createTitledBorder("Tempo entre próprio lance"));
/*     */     
/* 380 */     GroupLayout groupLayout2 = new GroupLayout(this.b);
/* 381 */     this.b.setLayout(groupLayout2);
/* 382 */     groupLayout2.setHorizontalGroup(groupLayout2
/* 383 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 384 */         .addGroup(groupLayout2.createSequentialGroup()
/* 385 */           .addContainerGap()
/* 386 */           .addComponent(this.a, -2, -1, -2)
/* 387 */           .addContainerGap(81, 32767)));
/*     */     
/* 389 */     groupLayout2.setVerticalGroup(groupLayout2
/* 390 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 391 */         .addGroup(groupLayout2.createSequentialGroup()
/* 392 */           .addContainerGap()
/* 393 */           .addComponent(this.a, -2, -1, -2)
/* 394 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 397 */     this.c.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###,###,##0.00"))));
/* 398 */     this.c.setHorizontalAlignment(4);
/* 399 */     this.c.setPreferredSize(new Dimension(50, 20));
/* 400 */     this.c.addFocusListener(new FocusAdapter(this) {
/*     */           public void focusGained(FocusEvent param1FocusEvent) {
/* 402 */             d.a(this.a, param1FocusEvent);
/*     */           }
/*     */         });
/*     */     
/* 406 */     this.c.setBorder(BorderFactory.createTitledBorder("Arredondar lance"));
/*     */     
/* 408 */     GroupLayout groupLayout3 = new GroupLayout(this.c);
/* 409 */     this.c.setLayout(groupLayout3);
/* 410 */     groupLayout3.setHorizontalGroup(groupLayout3
/* 411 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 412 */         .addGroup(groupLayout3.createSequentialGroup()
/* 413 */           .addContainerGap()
/* 414 */           .addComponent(this.b, -2, -1, -2)
/* 415 */           .addContainerGap(-1, 32767)));
/*     */     
/* 417 */     groupLayout3.setVerticalGroup(groupLayout3
/* 418 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 419 */         .addGroup(groupLayout3.createSequentialGroup()
/* 420 */           .addContainerGap()
/* 421 */           .addComponent(this.b, -2, -1, -2)
/* 422 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 425 */     this.a.setText("Selecionar");
/* 426 */     this.a.addActionListener(new ActionListener(this) {
/*     */           public void actionPerformed(ActionEvent param1ActionEvent) {
/* 428 */             d.a(this.a, param1ActionEvent);
/*     */           }
/*     */         });
/*     */     
/* 432 */     this.m.setText("Salvar exportação em:");
/*     */     
/* 434 */     GroupLayout groupLayout4 = new GroupLayout(this);
/* 435 */     setLayout(groupLayout4);
/* 436 */     groupLayout4.setHorizontalGroup(groupLayout4
/* 437 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 438 */         .addGroup(GroupLayout.Alignment.TRAILING, groupLayout4.createSequentialGroup()
/* 439 */           .addContainerGap()
/* 440 */           .addComponent(this.m)
/* 441 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 442 */           .addComponent(this.a)
/* 443 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 444 */           .addComponent(this.b)
/* 445 */           .addContainerGap())
/* 446 */         .addGroup(groupLayout4.createSequentialGroup()
/* 447 */           .addGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 448 */             .addComponent(this.b, -2, -1, -2)
/* 449 */             .addComponent(this.c)
/* 450 */             .addComponent(this.b)
/* 451 */             .addGroup(groupLayout4.createSequentialGroup()
/* 452 */               .addComponent(this.a)
/* 453 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 454 */               .addComponent(this.c, -2, -1, -2))
/* 455 */             .addComponent(this.b, -2, -1, -2)
/* 456 */             .addComponent(this.a, -2, -1, -2)
/* 457 */             .addGroup(groupLayout4.createSequentialGroup()
/* 458 */               .addComponent(this.l)
/* 459 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 460 */               .addComponent(this.i, -2, 141, -2))
/* 461 */             .addComponent(this.c, -2, -1, -2))
/* 462 */           .addGap(0, 0, 32767)));
/*     */     
/* 464 */     groupLayout4.setVerticalGroup(groupLayout4
/* 465 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 466 */         .addGroup(groupLayout4.createSequentialGroup()
/* 467 */           .addComponent(this.b, -2, -1, -2)
/* 468 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 469 */           .addGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 470 */             .addComponent(this.i, -2, -1, -2)
/* 471 */             .addComponent(this.l))
/* 472 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 473 */           .addComponent(this.c, -2, -1, -2)
/* 474 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 475 */           .addGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 476 */             .addComponent(this.a)
/* 477 */             .addComponent(this.c, -2, -1, -2))
/* 478 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 479 */           .addComponent(this.c)
/* 480 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 481 */           .addComponent(this.b)
/* 482 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 483 */           .addComponent(this.b, -2, -1, -2)
/* 484 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 485 */           .addComponent(this.a, -2, -1, -2)
/* 486 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 487 */           .addGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 488 */             .addComponent(this.m, -1, -1, 32767)
/* 489 */             .addComponent(this.b, -2, -1, -2)
/* 490 */             .addComponent(this.a))));
/*     */   }
/*     */ 
/*     */   
/*     */   private void e(FocusEvent paramFocusEvent) {
/* 495 */     this.c.selectAll();
/*     */   }
/*     */   
/*     */   private void a(ActionEvent paramActionEvent) {
/* 499 */     JFileChooser jFileChooser = new JFileChooser();
/* 500 */     jFileChooser.setDialogTitle("Escolha um caminho para salvar o arquivo:");
/* 501 */     jFileChooser.setFileSelectionMode(1);
/*     */     
/* 503 */     jFileChooser.setFileSelectionMode(1);
/*     */     
/* 505 */     int i = jFileChooser.showSaveDialog(null);
/* 506 */     if (i == 0 && 
/* 507 */       jFileChooser.getSelectedFile().isDirectory()) {
/* 508 */       this.b.setText(jFileChooser.getSelectedFile().toString());
/*     */     }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void l() {
/* 547 */     this.c.addItemListener(paramItemEvent -> {
/*     */           if (this.c.isSelected()) {
/*     */             this.b.setEnabled(false);
/*     */             
/*     */             this.b.setSelected(false);
/*     */           } else {
/*     */             this.b.setEnabled(true);
/*     */             this.b.setSelected(this.a.aD());
/*     */           } 
/*     */         });
/* 557 */     this.b.a(paramChangeEvent -> this.b.i(this.b.h()));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\c\a\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */