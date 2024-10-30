/*     */ package br.com.arremate.c.a;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JSpinner;
/*     */ import javax.swing.SpinnerNumberModel;
/*     */ 
/*     */ public class i extends JPanel {
/*     */   private final long a;
/*     */   private int z;
/*     */   private JLabel p;
/*     */   private JLabel q;
/*     */   private JSpinner e;
/*     */   private JSpinner f;
/*     */   
/*     */   public i() {
/*  20 */     this.a = TimeUnit.SECONDS.toMillis(30L);
/*     */     
/*  22 */     k();
/*  23 */     this.e.setModel(new SpinnerNumberModel(0, 0, 2, 1));
/*  24 */     this.f.setModel(new SpinnerNumberModel(0, 0, 59, 1));
/*     */   }
/*     */   
/*     */   public i(long paramLong) {
/*  28 */     this.a = paramLong;
/*  29 */     k();
/*  30 */     this.e.setModel(new SpinnerNumberModel(0, 0, 2, 1));
/*  31 */     this.f.setModel(new SpinnerNumberModel(0, 0, 59, 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void k() {
/*  37 */     this.e = new JSpinner();
/*  38 */     this.p = new JLabel();
/*  39 */     this.f = new JSpinner();
/*  40 */     this.q = new JLabel();
/*     */     
/*  42 */     setMaximumSize(new Dimension(87, 20));
/*  43 */     setPreferredSize(new Dimension(87, 20));
/*     */     
/*  45 */     this.e.setEditor(new JSpinner.NumberEditor(this.e, ""));
/*  46 */     this.e.setMaximumSize(new Dimension(29, 20));
/*     */     
/*  48 */     this.p.setHorizontalAlignment(2);
/*  49 */     this.p.setText("Min");
/*  50 */     this.p.setToolTipText("");
/*     */     
/*  52 */     this.f.setEditor(new JSpinner.NumberEditor(this.f, ""));
/*  53 */     this.f.setMaximumSize(new Dimension(33, 20));
/*  54 */     this.f.setMinimumSize(new Dimension(33, 20));
/*  55 */     this.f.setPreferredSize(new Dimension(33, 20));
/*     */     
/*  57 */     this.q.setHorizontalAlignment(2);
/*  58 */     this.q.setText("Seg");
/*  59 */     this.q.setToolTipText("");
/*     */     
/*  61 */     GroupLayout groupLayout = new GroupLayout(this);
/*  62 */     setLayout(groupLayout);
/*  63 */     groupLayout.setHorizontalGroup(groupLayout
/*  64 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  65 */         .addGroup(groupLayout.createSequentialGroup()
/*  66 */           .addComponent(this.e, -2, 42, -2)
/*  67 */           .addGap(4, 4, 4)
/*  68 */           .addComponent(this.p)
/*  69 */           .addGap(3, 3, 3)
/*  70 */           .addComponent(this.f, -2, 42, -2)
/*  71 */           .addGap(2, 2, 2)
/*  72 */           .addComponent(this.q)
/*  73 */           .addContainerGap(-1, 32767)));
/*     */     
/*  75 */     groupLayout.setVerticalGroup(groupLayout
/*  76 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  77 */         .addGroup(groupLayout.createSequentialGroup()
/*  78 */           .addGap(0, 0, 32767)
/*  79 */           .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  80 */             .addComponent(this.e, -2, -1, -2)
/*  81 */             .addComponent(this.p)
/*  82 */             .addComponent(this.f, -1, -1, 32767)
/*  83 */             .addComponent(this.q))));
/*     */   }
/*     */ 
/*     */   
/*     */   public void m(int paramInt) {
/*  88 */     this.z = paramInt;
/*  89 */     int j = ((Integer)this.e.getValue()).intValue();
/*  90 */     this.e.setModel(new SpinnerNumberModel(j, 0, paramInt, 1));
/*  91 */     this.e.setValue(Integer.valueOf(j));
/*     */   }
/*     */   
/*     */   private void n(int paramInt) {
/*  95 */     if (paramInt >= 0 && paramInt <= this.z) {
/*  96 */       this.e.setValue(Integer.valueOf(paramInt));
/*     */     }
/*     */   }
/*     */   
/*     */   private void o(int paramInt) {
/* 101 */     if (paramInt >= 0 && paramInt <= 59) {
/* 102 */       this.f.setValue(Integer.valueOf(paramInt));
/*     */     }
/*     */   }
/*     */   
/*     */   public void c(long paramLong) {
/* 107 */     if (paramLong < this.a) {
/* 108 */       paramLong = this.a;
/*     */     }
/*     */     
/* 111 */     int j = (int)TimeUnit.MILLISECONDS.toMinutes(paramLong);
/* 112 */     int k = (int)TimeUnit.MILLISECONDS.toSeconds(paramLong);
/* 113 */     k -= j * 60;
/*     */     
/* 115 */     n(j);
/* 116 */     o(k);
/*     */   }
/*     */   
/*     */   public long getTime() {
/* 120 */     long l1 = TimeUnit.MINUTES.toMillis(Integer.toUnsignedLong(((Integer)this.e.getValue()).intValue()));
/* 121 */     long l2 = TimeUnit.SECONDS.toMillis(Integer.toUnsignedLong(((Integer)this.f.getValue()).intValue()));
/* 122 */     long l3 = l1 + l2;
/* 123 */     long l4 = TimeUnit.MINUTES.toMillis(this.z);
/*     */     
/* 125 */     if (l3 > l4)
/* 126 */       return l4; 
/* 127 */     if (l3 < this.a) {
/* 128 */       return this.a;
/*     */     }
/*     */     
/* 131 */     return l3;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEnabled(boolean paramBoolean) {
/* 136 */     super.setEnabled(paramBoolean);
/* 137 */     this.e.setEnabled(paramBoolean);
/* 138 */     this.f.setEnabled(paramBoolean);
/* 139 */     this.p.setEnabled(paramBoolean);
/* 140 */     this.q.setEnabled(paramBoolean);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\c\a\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */