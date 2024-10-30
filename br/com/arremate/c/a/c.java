/*     */ package br.com.arremate.c.a;
/*     */ import br.com.arremate.m.y;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.math.BigDecimal;
/*     */ import java.text.DecimalFormat;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFormattedTextField;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.text.DefaultFormatterFactory;
/*     */ import javax.swing.text.NumberFormatter;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ 
/*     */ public class c extends JPanel implements Serializable {
/*     */   private DecimalFormat df;
/*     */   private JComboBox<String> a;
/*     */   private JFormattedTextField a;
/*     */   
/*     */   public c() {
/*  24 */     k();
/*  25 */     i(0);
/*  26 */     setName("PanelConfiguracaoVariacao");
/*     */   }
/*     */   private JFormattedTextField b; private JLabel b; private JLabel c; private JLabel d;
/*     */   private DecimalFormat a(int paramInt) {
/*  30 */     byte b = 4;
/*  31 */     String str = "0";
/*     */     
/*  33 */     if (paramInt < b) {
/*  34 */       paramInt = Math.abs(paramInt - b);
/*  35 */       str = String.join("", new CharSequence[] { "0.", StringUtils.leftPad("0", paramInt, "0") });
/*     */     } 
/*     */     
/*  38 */     str = "###,###,##" + str;
/*  39 */     return y.a(str);
/*     */   }
/*     */   private void a(int paramInt, DecimalFormat paramDecimalFormat) {
/*     */     String str;
/*  43 */     byte b = 4;
/*     */ 
/*     */     
/*  46 */     if (paramInt < b) {
/*  47 */       paramInt = Math.abs(paramInt - b);
/*  48 */       str = String.join("", new CharSequence[] { "0.", StringUtils.leftPad("1", paramInt, "0") });
/*     */     } else {
/*  50 */       paramInt = paramInt - b + 1;
/*  51 */       str = StringUtils.rightPad("1", paramInt, "0");
/*     */     } 
/*     */     
/*  54 */     BigDecimal bigDecimal = new BigDecimal(str);
/*     */     
/*  56 */     this.b.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(paramDecimalFormat)));
/*  57 */     this.a.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(paramDecimalFormat)));
/*     */     
/*  59 */     this.b.setValue(bigDecimal);
/*  60 */     this.a.setValue(bigDecimal);
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal a() {
/*  65 */     String str = (this.b.getText().length() > 0) ? this.b.getText() : "0,00";
/*     */     
/*  67 */     str = str.replace(".", "").replace(",", ".");
/*  68 */     return new BigDecimal(str);
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal b() {
/*  73 */     String str = (this.a.getText().length() > 0) ? this.a.getText() : "0,00";
/*     */     
/*  75 */     str = str.replace(".", "").replace(",", ".");
/*  76 */     return new BigDecimal(str);
/*     */   }
/*     */   
/*     */   public int i() {
/*  80 */     return this.a.getSelectedIndex();
/*     */   }
/*     */   
/*     */   public void k(int paramInt) {
/*  84 */     this.a.setSelectedIndex(paramInt);
/*     */   }
/*     */   
/*     */   public void a(BigDecimal paramBigDecimal) {
/*  88 */     this.b.setText(this.df.format(paramBigDecimal));
/*     */   }
/*     */   
/*     */   public void b(BigDecimal paramBigDecimal) {
/*  92 */     this.a.setText(this.df.format(paramBigDecimal));
/*     */   }
/*     */   
/*     */   public final void i(int paramInt) {
/*  96 */     this.df = a(paramInt);
/*  97 */     a(paramInt, this.df);
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
/* 108 */     this.c = new JLabel();
/* 109 */     this.a = (JFormattedTextField)new JComboBox();
/* 110 */     this.d = new JLabel();
/* 111 */     this.b = (JLabel)new JFormattedTextField();
/* 112 */     this.a = new JFormattedTextField();
/* 113 */     this.b = new JLabel();
/*     */     
/* 115 */     this.c.setText("Tipo redução:");
/*     */     
/* 117 */     this.a.setModel(new DefaultComboBoxModel<>(new String[] { "Valor", "Percentual" }));
/*     */     
/* 119 */     this.d.setText("Variação:");
/*     */     
/* 121 */     this.b.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###,###,##0.00"))));
/* 122 */     this.b.setHorizontalAlignment(4);
/* 123 */     this.b.setText("0,01");
/* 124 */     this.b.addFocusListener(new FocusAdapter(this) {
/*     */           public void focusGained(FocusEvent param1FocusEvent) {
/* 126 */             c.a(this.a, param1FocusEvent);
/*     */           }
/*     */           public void focusLost(FocusEvent param1FocusEvent) {
/* 129 */             c.b(this.a, param1FocusEvent);
/*     */           }
/*     */         });
/*     */     
/* 133 */     this.a.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###,###,##0.00"))));
/* 134 */     this.a.setHorizontalAlignment(4);
/* 135 */     this.a.setText("0,01");
/* 136 */     this.a.addFocusListener(new FocusAdapter(this) {
/*     */           public void focusGained(FocusEvent param1FocusEvent) {
/* 138 */             c.c(this.a, param1FocusEvent);
/*     */           }
/*     */           public void focusLost(FocusEvent param1FocusEvent) {
/* 141 */             c.d(this.a, param1FocusEvent);
/*     */           }
/*     */         });
/*     */     
/* 145 */     this.b.setText("até");
/*     */     
/* 147 */     GroupLayout groupLayout = new GroupLayout(this);
/* 148 */     setLayout(groupLayout);
/* 149 */     groupLayout.setHorizontalGroup(groupLayout
/* 150 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 151 */         .addGroup(groupLayout.createSequentialGroup()
/* 152 */           .addComponent(this.c)
/* 153 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 154 */           .addComponent(this.a, -2, -1, -2)
/* 155 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 156 */           .addComponent(this.d)
/* 157 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 158 */           .addComponent(this.b, -2, 90, -2)
/* 159 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 160 */           .addComponent(this.b)
/* 161 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 162 */           .addComponent(this.a, -2, 90, -2)));
/*     */     
/* 164 */     groupLayout.setVerticalGroup(groupLayout
/* 165 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 166 */         .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 167 */           .addComponent(this.a, -2, -1, -2)
/* 168 */           .addComponent(this.c)
/* 169 */           .addComponent(this.d)
/* 170 */           .addComponent(this.b, -2, -1, -2)
/* 171 */           .addComponent(this.b)
/* 172 */           .addComponent(this.a, -2, -1, -2)));
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(FocusEvent paramFocusEvent) {
/* 177 */     this.b.selectAll();
/*     */   }
/*     */   
/*     */   private void b(FocusEvent paramFocusEvent) {
/* 181 */     if (!this.a.getText().isEmpty() && this.b.getText().isEmpty()) {
/* 182 */       this.b.setText(this.a.getText());
/*     */     }
/*     */   }
/*     */   
/*     */   private void c(FocusEvent paramFocusEvent) {
/* 187 */     this.a.selectAll();
/*     */   }
/*     */   
/*     */   private void d(FocusEvent paramFocusEvent) {
/* 191 */     if (!this.b.getText().isEmpty() && this.a.getText().isEmpty())
/* 192 */       this.a.setText(this.b.getText()); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\c\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */