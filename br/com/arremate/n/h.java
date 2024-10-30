/*     */ package br.com.arremate.n;
/*     */ import br.com.arremate.k.a.p;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.f;
/*     */ import br.com.arremate.m.y;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.text.DecimalFormat;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.KeyStroke;
/*     */ import javax.swing.LayoutStyle;
/*     */ 
/*     */ public class h extends JDialog {
/*     */   private final p a;
/*     */   private JButton q;
/*     */   
/*     */   public h(p paramp) {
/*  31 */     k();
/*  32 */     l();
/*     */     
/*  34 */     this.a = paramp;
/*  35 */     this.a.a(this);
/*     */ 
/*     */     
/*  38 */     du();
/*     */   }
/*     */   private f b; private JLabel y; private JLabel an; private JLabel N; private JLabel ao;
/*     */   private JPanel B;
/*     */   private JTextField j;
/*     */   
/*     */   private void du() {
/*  45 */     e e = this.a.a();
/*     */     
/*  47 */     if (e != null) {
/*  48 */       b().setText(e.bo());
/*  49 */       b().setEditable(false);
/*  50 */       b().setFocusable(false);
/*  51 */       this.b.aq(a(e));
/*     */       
/*  53 */       dv();
/*     */     } else {
/*  55 */       b().setEditable(true);
/*  56 */       b().requestFocus();
/*     */     } 
/*     */     
/*  59 */     this.y.setVisible(false);
/*     */     
/*  61 */     if (ch()) {
/*  62 */       this.y.setVisible(true);
/*  63 */       this.y.setText("Valor do Lance: R$");
/*  64 */       this.ao.setText("Valor Lance Equalizado: ");
/*     */     } 
/*     */     
/*  67 */     dg();
/*     */   }
/*     */   
/*     */   private int a(e parame) {
/*  71 */     int i = parame.b().E();
/*  72 */     if (i > 4) {
/*  73 */       i = 4;
/*     */     }
/*     */     
/*  76 */     return 4 - i;
/*     */   }
/*     */   
/*     */   private void l() {
/*  80 */     KeyStroke keyStroke = KeyStroke.getKeyStroke(27, 0);
/*  81 */     byte b = 2;
/*  82 */     getRootPane().registerKeyboardAction(paramActionEvent -> dispose(), keyStroke, b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void dg() {
/*  89 */     pack();
/*  90 */     setLocationRelativeTo(null);
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
/* 101 */     this.B = new JPanel();
/* 102 */     this.ao = new JLabel();
/* 103 */     this.b = new f();
/* 104 */     this.q = new JButton();
/* 105 */     this.an = new JLabel();
/* 106 */     this.j = new JTextField();
/* 107 */     this.N = new JLabel();
/* 108 */     this.y = new JLabel();
/*     */     
/* 110 */     setDefaultCloseOperation(2);
/* 111 */     setTitle("Effecti - Envio de lance manual");
/* 112 */     setIconImage((new ImageIcon(getClass().getResource("/img/icone.jpg"))).getImage());
/* 113 */     setModal(true);
/*     */     
/* 115 */     this.B.setBorder(BorderFactory.createEtchedBorder());
/*     */     
/* 117 */     this.ao.setText("Valor Lance:");
/*     */     
/* 119 */     this.b.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###,###,###,##0.0000"))));
/* 120 */     this.b.setHorizontalAlignment(4);
/* 121 */     this.b.setText("0,0000");
/* 122 */     this.b.addFocusListener(new FocusAdapter(this) {
/*     */           public void focusGained(FocusEvent param1FocusEvent) {
/* 124 */             h.a(this.b, param1FocusEvent);
/*     */           }
/*     */         });
/* 127 */     this.b.addKeyListener(new KeyAdapter(this) {
/*     */           public void keyReleased(KeyEvent param1KeyEvent) {
/* 129 */             h.a(this.b, param1KeyEvent);
/*     */           }
/*     */         });
/*     */     
/* 133 */     this.q.setIcon(new ImageIcon(getClass().getResource("/img/hammer.png")));
/* 134 */     this.q.setText("Enviar");
/* 135 */     this.q.addActionListener(new ActionListener(this) {
/*     */           public void actionPerformed(ActionEvent param1ActionEvent) {
/* 137 */             h.a(this.b, param1ActionEvent);
/*     */           }
/*     */         });
/*     */     
/* 141 */     this.an.setText("Item:");
/*     */     
/* 143 */     this.j.setHorizontalAlignment(0);
/* 144 */     this.j.addFocusListener(new FocusAdapter(this) {
/*     */           public void focusGained(FocusEvent param1FocusEvent) {
/* 146 */             h.b(this.b, param1FocusEvent);
/*     */           }
/*     */           public void focusLost(FocusEvent param1FocusEvent) {
/* 149 */             h.c(this.b, param1FocusEvent);
/*     */           }
/*     */         });
/*     */     
/* 153 */     this.N.setForeground(new Color(0, 0, 255));
/*     */     
/* 155 */     GroupLayout groupLayout1 = new GroupLayout(this.B);
/* 156 */     this.B.setLayout(groupLayout1);
/* 157 */     groupLayout1.setHorizontalGroup(groupLayout1
/* 158 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 159 */         .addGroup(groupLayout1.createSequentialGroup()
/* 160 */           .addContainerGap()
/* 161 */           .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 162 */             .addComponent(this.y)
/* 163 */             .addGroup(groupLayout1.createSequentialGroup()
/* 164 */               .addComponent(this.an)
/* 165 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 166 */               .addComponent(this.j, -2, 35, -2)
/* 167 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 168 */               .addComponent(this.ao)
/* 169 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 170 */               .addComponent((Component)this.b, -2, 150, -2)
/* 171 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 172 */               .addComponent(this.q)
/* 173 */               .addGap(1, 1, 1)
/* 174 */               .addComponent(this.N)))
/* 175 */           .addContainerGap(-1, 32767)));
/*     */     
/* 177 */     groupLayout1.setVerticalGroup(groupLayout1
/* 178 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 179 */         .addGroup(groupLayout1.createSequentialGroup()
/* 180 */           .addContainerGap(19, 32767)
/* 181 */           .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 182 */             .addComponent(this.N)
/* 183 */             .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 184 */               .addComponent(this.ao)
/* 185 */               .addComponent((Component)this.b, -2, -1, -2)
/* 186 */               .addComponent(this.q)
/* 187 */               .addComponent(this.j, -2, -1, -2)
/* 188 */               .addComponent(this.an)))
/* 189 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 190 */           .addComponent(this.y, -2, 14, -2)
/* 191 */           .addGap(8, 8, 8)));
/*     */ 
/*     */     
/* 194 */     GroupLayout groupLayout2 = new GroupLayout(getContentPane());
/* 195 */     getContentPane().setLayout(groupLayout2);
/* 196 */     groupLayout2.setHorizontalGroup(groupLayout2
/* 197 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 198 */         .addGroup(groupLayout2.createSequentialGroup()
/* 199 */           .addContainerGap()
/* 200 */           .addComponent(this.B, -2, -1, -2)
/* 201 */           .addContainerGap(-1, 32767)));
/*     */     
/* 203 */     groupLayout2.setVerticalGroup(groupLayout2
/* 204 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 205 */         .addGroup(groupLayout2.createSequentialGroup()
/* 206 */           .addContainerGap()
/* 207 */           .addComponent(this.B, -2, -1, -2)
/* 208 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 211 */     pack();
/*     */   }
/*     */   
/*     */   private void l(FocusEvent paramFocusEvent) {
/* 215 */     this.b.selectAll();
/*     */   }
/*     */   
/*     */   private void v(ActionEvent paramActionEvent) {
/* 219 */     e e = this.a.a();
/*     */     
/* 221 */     if (e != null) {
/* 222 */       aM("Processando...");
/*     */       
/* 224 */       double d = Double.parseDouble(y.Q(this.b.getText()));
/* 225 */       this.a.d(d);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m(FocusEvent paramFocusEvent) {
/* 230 */     String str = this.j.getText().trim();
/*     */     
/* 232 */     if (str.isEmpty()) {
/*     */       return;
/*     */     }
/*     */     
/* 236 */     if (!StringUtils.isNumeric(str)) {
/* 237 */       JOptionPane.showMessageDialog(this, "Para envio de lance manual, favor informar um item válido", "Erro", 0);
/*     */       
/* 239 */       this.j.requestFocus();
/* 240 */       this.j.selectAll();
/*     */       
/*     */       return;
/*     */     } 
/* 244 */     if (this.a.f(Integer.parseInt(str))) {
/* 245 */       dv();
/*     */     } else {
/* 247 */       JOptionPane.showMessageDialog(this, String.join("", new CharSequence[] { "O item ", str, " não está em disputa" }), "Erro", 0);
/*     */       
/* 249 */       this.j.requestFocus();
/* 250 */       this.j.selectAll();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void e(KeyEvent paramKeyEvent) {
/* 255 */     if (paramKeyEvent.getKeyCode() == 10) {
/* 256 */       this.q.doClick();
/*     */     }
/*     */     
/* 259 */     if (ch()) {
/*     */       try {
/* 261 */         double d = Double.parseDouble(y.Q(this.b.getText()));
/* 262 */         d /= this.a.a().a().a();
/* 263 */         DecimalFormat decimalFormat = y.a("###,###,##0.0000");
/* 264 */         this.y.setText("Valor do Lance: R$ " + decimalFormat.format(d));
/* 265 */         this.ao.setText("Valor Lance Equalizado: ");
/* 266 */       } catch (NumberFormatException numberFormatException) {
/* 267 */         this.y.setText("Valor do Lance: R$ ");
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private void n(FocusEvent paramFocusEvent) {
/* 273 */     a().setEditable(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void aM(String paramString) {
/* 282 */     this.q.setVisible(false);
/*     */     
/* 284 */     this.N.setText(paramString);
/* 285 */     this.N.setIcon(new ImageIcon(getClass().getResource("/img/loading-blue.gif")));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cX() {
/* 292 */     this.q.setVisible(true);
/*     */     
/* 294 */     this.N.setText("");
/* 295 */     this.N.setIcon((Icon)null);
/*     */   }
/*     */   
/*     */   private void dv() {
/* 299 */     a().setEditable(true);
/* 300 */     a().requestFocus();
/*     */   }
/*     */   
/*     */   public JLabel b() {
/* 304 */     return this.an;
/*     */   }
/*     */   
/*     */   public JTextField b() {
/* 308 */     return this.j;
/*     */   }
/*     */   
/*     */   public f a() {
/* 312 */     return this.b;
/*     */   }
/*     */   
/*     */   private boolean ch() {
/* 316 */     return this.a.a().a().k();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\n\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */