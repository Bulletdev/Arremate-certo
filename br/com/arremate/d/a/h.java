/*     */ package br.com.arremate.d.a;
/*     */ 
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.j;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
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
/*     */ public class h
/*     */   extends Thread
/*     */ {
/*  35 */   private static final Logger a = LoggerFactory.getLogger(h.class);
/*     */   
/*     */   private static final float a = 1.5F;
/*     */   private static final int I = 3;
/*     */   private static final int J = 15;
/*     */   private final List<j> i;
/*     */   private final d a;
/*     */   private final AtomicInteger a;
/*     */   private final AtomicBoolean b;
/*     */   
/*     */   public h(j paramj) {
/*  46 */     this.i = Collections.synchronizedList(new ArrayList<>());
/*  47 */     this.a = (AtomicInteger)paramj.a();
/*  48 */     this.b = new AtomicBoolean(true);
/*  49 */     this.a = new AtomicInteger(3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/*  55 */     while (this.b.get()) {
/*     */       
/*     */       try {
/*  58 */         this.i.removeIf(paramj -> paramj.I());
/*     */ 
/*     */ 
/*     */         
/*  62 */         int i = this.i.size();
/*  63 */         int j = this.a.get() - i;
/*  64 */         if (j > 0) {
/*  65 */           for (byte b = 0; b < j; b++) {
/*     */             
/*  67 */             j j1 = new j((d)this.a);
/*  68 */             j1.aq();
/*  69 */             this.i.add(j1);
/*     */           } 
/*     */         }
/*     */         
/*  73 */         sleep(5000L);
/*  74 */       } catch (Exception exception) {
/*  75 */         a.warn("Failed to refresh login pool", exception);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j a() {
/*  87 */     this.i.sort((paramj1, paramj2) -> (paramj1.p() > paramj2.p()) ? 1 : ((paramj1.p() < paramj2.p()) ? -1 : 0));
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
/*  99 */     synchronized (this.i) {
/* 100 */       for (j j : this.i) {
/*     */         
/* 102 */         if (j.G()) {
/*     */           
/* 104 */           j.as();
/* 105 */           return j;
/*     */         } 
/*     */       } 
/*     */       
/* 109 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void x(int paramInt) {
/* 119 */     paramInt = Math.round(paramInt * 1.5F);
/* 120 */     if (paramInt < 3) {
/* 121 */       paramInt = 3;
/*     */     }
/*     */     
/* 124 */     if (paramInt <= this.a.get()) {
/*     */       return;
/*     */     }
/*     */     
/* 128 */     if (paramInt > 15) {
/* 129 */       paramInt = 15;
/*     */     }
/*     */     
/* 132 */     this.a.set(paramInt);
/*     */   }
/*     */   
/*     */   void am() {
/* 136 */     this.b.set(false);
/*     */     
/* 138 */     synchronized (this.i) {
/* 139 */       this.i.forEach(paramj -> paramj.b());
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
/*     */   int m() {
/* 151 */     synchronized (this.i) {
/* 152 */       return 
/*     */         
/* 154 */         (int)this.i.stream().filter(paramj -> paramj.F()).count();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int n() {
/* 164 */     synchronized (this.i) {
/* 165 */       return 
/*     */         
/* 167 */         (int)this.i.stream().filter(paramj -> paramj.G()).count();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int o() {
/* 177 */     synchronized (this.i) {
/* 178 */       return 
/*     */         
/* 180 */         (int)this.i.stream().filter(paramj -> paramj.H()).count();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\a\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */