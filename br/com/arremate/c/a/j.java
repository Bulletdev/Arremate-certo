/*     */ package br.com.arremate.c.a;
/*     */ 
/*     */ import br.com.arremate.m.y;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class j extends JPanel {
/*     */   private final SimpleDateFormat sdf;
/*     */   private long b;
/*     */   private Timer a;
/*     */   private JLabel r;
/*     */   private JLabel s;
/*     */   
/*     */   public j() {
/*  23 */     k();
/*  24 */     this.sdf = new SimpleDateFormat("mm:ss");
/*  25 */     this.b = 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void k() {
/*  32 */     this.s = new JLabel();
/*  33 */     this.r = new JLabel();
/*     */     
/*  35 */     this.s.setFont(new Font("Tahoma", 0, 22));
/*  36 */     this.s.setText("00:00");
/*  37 */     this.s.setMaximumSize(new Dimension(95, 30));
/*  38 */     this.s.setMinimumSize(new Dimension(95, 30));
/*  39 */     this.s.setPreferredSize(new Dimension(95, 30));
/*     */     
/*  41 */     this.r.setFont(new Font("Dialog", 1, 10));
/*  42 */     this.r.setText("Envio de lance em:");
/*     */     
/*  44 */     GroupLayout groupLayout = new GroupLayout(this);
/*  45 */     setLayout(groupLayout);
/*  46 */     groupLayout.setHorizontalGroup(groupLayout
/*  47 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  48 */         .addGroup(groupLayout.createSequentialGroup()
/*  49 */           .addGap(0, 0, 32767)
/*  50 */           .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  51 */             .addComponent(this.s, GroupLayout.Alignment.TRAILING, -2, 57, -2)
/*  52 */             .addComponent(this.r, GroupLayout.Alignment.TRAILING))));
/*     */     
/*  54 */     groupLayout.setVerticalGroup(groupLayout
/*  55 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  56 */         .addGroup(groupLayout.createSequentialGroup()
/*  57 */           .addComponent(this.r)
/*  58 */           .addGap(0, 0, 0)
/*  59 */           .addComponent(this.s, -2, -1, -2)));
/*     */   }
/*     */ 
/*     */   
/*     */   public void start() {
/*  64 */     if (!isVisible()) {
/*  65 */       setVisible(true);
/*     */     }
/*     */     
/*  68 */     if (this.a != null) {
/*  69 */       this.a.cancel();
/*  70 */       this.a = null;
/*     */     } 
/*     */     
/*  73 */     this.a = new Timer();
/*  74 */     this.a.schedule(a(), 1000L, 1000L);
/*     */   }
/*     */   
/*     */   private TimerTask a() {
/*  78 */     return new TimerTask(this)
/*     */       {
/*     */         public void run() {
/*  81 */           if (j.a(this.a) <= 0L) {
/*     */             return;
/*     */           }
/*     */           
/*  85 */           j j1 = this.a; j.a(j1, j.a(j1) - 1000L);
/*     */           
/*  87 */           if (j.a(this.a) < 0L) {
/*  88 */             j.a(this.a, 0L);
/*     */           }
/*     */           
/*  91 */           boolean bool = (j.a(this.a) < 30000L) ? true : false;
/*     */           
/*  93 */           if (bool && 
/*  94 */             j.a(this.a).getForeground() != y.f()) {
/*  95 */             j.a(this.a).setForeground(y.f());
/*  96 */             j.b(this.a).setForeground(y.f());
/*  97 */           } else if (!bool && 
/*  98 */             j.a(this.a).getForeground() == y.f()) {
/*  99 */             j.a(this.a).setForeground(new Color(51, 51, 51));
/* 100 */             j.b(this.a).setForeground(new Color(51, 51, 51));
/*     */           } 
/*     */           
/* 103 */           j.a(this.a);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public void stop() {
/* 109 */     if (this.a != null) {
/* 110 */       this.a.cancel();
/*     */     }
/*     */     
/* 113 */     if (isVisible()) {
/* 114 */       setVisible(false);
/*     */     }
/*     */     
/* 117 */     d(0L);
/*     */   }
/*     */   
/*     */   public synchronized void d(long paramLong) {
/* 121 */     if (paramLong < 0L) {
/* 122 */       paramLong = 0L;
/*     */     }
/*     */     
/* 125 */     this.b = paramLong;
/* 126 */     m();
/*     */   }
/*     */   
/*     */   private void m() {
/* 130 */     this.s.setText(this.sdf.format(new Date(this.b)));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\c\a\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */