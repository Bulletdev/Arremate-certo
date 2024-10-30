/*     */ package br.com.arremate.n;
/*     */ import br.com.arremate.l.c;
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.KeyStroke;
/*     */ import javax.swing.LayoutStyle;
/*     */ 
/*     */ public class l extends JFrame {
/*     */   private JLabel aW;
/*     */   private JLabel aX;
/*     */   private JLabel aY;
/*     */   private JLabel aZ;
/*     */   private JLabel ba;
/*     */   private JLabel bb;
/*     */   private JLabel bc;
/*     */   private JLabel bd;
/*     */   private JLabel be;
/*     */   
/*     */   public l(c paramc) {
/*  22 */     k();
/*  23 */     a(paramc);
/*  24 */     l();
/*     */     
/*  26 */     setLocationRelativeTo(null);
/*     */   }
/*     */   private JTextField k; private JTextField l; private JTextField m; private JTextField n; private JTextField o; private JTextField p; private JTextField q; private JTextField r; private JTextField s;
/*     */   private void l() {
/*  30 */     KeyStroke keyStroke = KeyStroke.getKeyStroke(27, 0);
/*  31 */     byte b = 2;
/*  32 */     getRootPane().registerKeyboardAction(paramActionEvent -> dispose(), keyStroke, b);
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(c paramc) {
/*  37 */     a(this.bd, this.r, paramc.bm());
/*     */     
/*  39 */     a(this.bb, this.p, paramc.ay());
/*     */     
/*  41 */     a(this.aW, this.k, paramc.bn());
/*     */     
/*  43 */     a(this.bc, this.q, paramc.bo());
/*     */     
/*  45 */     a(this.aX, this.l, paramc.bp());
/*     */     
/*  47 */     a(this.ba, this.o, paramc.bq());
/*     */     
/*  49 */     a(this.aY, this.m, paramc.br());
/*     */     
/*  51 */     a(this.aZ, this.n, paramc.bs());
/*     */     
/*  53 */     a(this.be, this.s, paramc.bt());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(JLabel paramJLabel, JTextField paramJTextField, String paramString) {
/*  63 */     boolean bool = !paramString.isEmpty() ? true : false;
/*  64 */     paramJLabel.setVisible(bool);
/*  65 */     paramJTextField.setVisible(bool);
/*  66 */     paramJTextField.setText(paramString);
/*  67 */     paramJTextField.setToolTipText(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void k() {
/*  74 */     this.bd = new JLabel();
/*  75 */     this.r = new JTextField();
/*  76 */     this.bb = new JLabel();
/*  77 */     this.p = new JTextField();
/*  78 */     this.aW = new JLabel();
/*  79 */     this.k = new JTextField();
/*  80 */     this.bc = new JLabel();
/*  81 */     this.q = new JTextField();
/*  82 */     this.aX = new JLabel();
/*  83 */     this.l = new JTextField();
/*  84 */     this.ba = new JLabel();
/*  85 */     this.o = new JTextField();
/*  86 */     this.aY = new JLabel();
/*  87 */     this.m = new JTextField();
/*  88 */     this.aZ = new JLabel();
/*  89 */     this.n = new JTextField();
/*  90 */     this.be = new JLabel();
/*  91 */     this.s = new JTextField();
/*     */     
/*  93 */     setTitle("Detalhes da licitação");
/*  94 */     setIconImage((new ImageIcon(getClass().getResource("/img/icone.jpg"))).getImage());
/*  95 */     setResizable(false);
/*     */     
/*  97 */     this.bd.setText("Portal:");
/*     */     
/*  99 */     this.r.setEditable(false);
/*     */     
/* 101 */     this.bb.setText("Empresa:");
/*     */     
/* 103 */     this.p.setEditable(false);
/*     */     
/* 105 */     this.aW.setText("Código:");
/*     */     
/* 107 */     this.k.setEditable(false);
/*     */     
/* 109 */     this.bc.setText("Número:");
/*     */     
/* 111 */     this.q.setEditable(false);
/*     */     
/* 113 */     this.aX.setText("Código UASG:");
/*     */     
/* 115 */     this.l.setEditable(false);
/*     */     
/* 117 */     this.ba.setText("UASG:");
/*     */     
/* 119 */     this.o.setEditable(false);
/*     */     
/* 121 */     this.aY.setText("Data Abertura:");
/*     */     
/* 123 */     this.m.setEditable(false);
/*     */     
/* 125 */     this.aZ.setText("Data Encerramento:");
/*     */     
/* 127 */     this.n.setEditable(false);
/*     */     
/* 129 */     this.be.setText("SRP:");
/*     */     
/* 131 */     this.s.setEditable(false);
/*     */     
/* 133 */     GroupLayout groupLayout = new GroupLayout(getContentPane());
/* 134 */     getContentPane().setLayout(groupLayout);
/* 135 */     groupLayout.setHorizontalGroup(groupLayout
/* 136 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 137 */         .addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup()
/* 138 */           .addContainerGap()
/* 139 */           .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 140 */             .addComponent(this.s)
/* 141 */             .addComponent(this.k, GroupLayout.Alignment.LEADING)
/* 142 */             .addComponent(this.p, GroupLayout.Alignment.LEADING)
/* 143 */             .addComponent(this.r)
/* 144 */             .addComponent(this.q, GroupLayout.Alignment.LEADING)
/* 145 */             .addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup()
/* 146 */               .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 147 */                 .addComponent(this.bd)
/* 148 */                 .addComponent(this.bb)
/* 149 */                 .addComponent(this.aW)
/* 150 */                 .addComponent(this.bc)
/* 151 */                 .addComponent(this.aX)
/* 152 */                 .addComponent(this.ba)
/* 153 */                 .addComponent(this.aY)
/* 154 */                 .addComponent(this.aZ)
/* 155 */                 .addComponent(this.be))
/* 156 */               .addGap(0, 142, 32767))
/* 157 */             .addComponent(this.l, GroupLayout.Alignment.LEADING)
/* 158 */             .addComponent(this.o, GroupLayout.Alignment.LEADING)
/* 159 */             .addComponent(this.m, GroupLayout.Alignment.LEADING)
/* 160 */             .addComponent(this.n, GroupLayout.Alignment.LEADING))
/* 161 */           .addContainerGap()));
/*     */     
/* 163 */     groupLayout.setVerticalGroup(groupLayout
/* 164 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 165 */         .addGroup(groupLayout.createSequentialGroup()
/* 166 */           .addContainerGap()
/* 167 */           .addComponent(this.bd)
/* 168 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 169 */           .addComponent(this.r, -2, -1, -2)
/* 170 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 171 */           .addComponent(this.bb)
/* 172 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 173 */           .addComponent(this.p, -2, -1, -2)
/* 174 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 175 */           .addComponent(this.aW)
/* 176 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 177 */           .addComponent(this.k, -2, -1, -2)
/* 178 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 179 */           .addComponent(this.bc)
/* 180 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 181 */           .addComponent(this.q, -2, -1, -2)
/* 182 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 183 */           .addComponent(this.aX)
/* 184 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 185 */           .addComponent(this.l, -2, -1, -2)
/* 186 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 187 */           .addComponent(this.ba)
/* 188 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 189 */           .addComponent(this.o, -2, -1, -2)
/* 190 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 191 */           .addComponent(this.aY)
/* 192 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 193 */           .addComponent(this.m, -2, -1, -2)
/* 194 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 195 */           .addComponent(this.aZ)
/* 196 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 197 */           .addComponent(this.n, -2, -1, -2)
/* 198 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 199 */           .addComponent(this.be)
/* 200 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 201 */           .addComponent(this.s, -2, -1, -2)
/* 202 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 205 */     pack();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\n\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */