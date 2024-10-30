/*     */ package junit.b;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Enumeration;
/*     */ import java.util.List;
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
/*     */ public class m
/*     */ {
/*  25 */   protected List<k> ac = new ArrayList<k>();
/*  26 */   protected List<k> ad = new ArrayList<k>();
/*  27 */   protected List<l> ae = new ArrayList<l>();
/*  28 */   protected int hS = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean ca = false;
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void a(i parami, Throwable paramThrowable) {
/*  37 */     this.ad.add(new k(parami, paramThrowable));
/*  38 */     for (l l : af()) {
/*  39 */       l.a(parami, paramThrowable);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void a(i parami, b paramb) {
/*  48 */     this.ac.add(new k(parami, paramb));
/*  49 */     for (l l : af()) {
/*  50 */       l.a(parami, paramb);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void a(l paraml) {
/*  58 */     this.ae.add(paraml);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void b(l paraml) {
/*  65 */     this.ae.remove(paraml);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private synchronized List<l> af() {
/*  72 */     ArrayList<l> arrayList = new ArrayList();
/*  73 */     arrayList.addAll(this.ae);
/*  74 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(i parami) {
/*  81 */     for (l l : af()) {
/*  82 */       l.a(parami);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized int bd() {
/*  90 */     return this.ad.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized Enumeration<k> a() {
/*  97 */     return Collections.enumeration(this.ad);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized int be() {
/* 105 */     return this.ac.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized Enumeration<k> b() {
/* 112 */     return Collections.enumeration(this.ac);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(j paramj) {
/* 119 */     b(paramj);
/* 120 */     h h = new h(this, paramj) {
/*     */         public void hb() throws Throwable {
/* 122 */           this.a.hf();
/*     */         }
/*     */       };
/* 125 */     a(paramj, h);
/*     */     
/* 127 */     a(paramj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized int bf() {
/* 134 */     return this.hS;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(i parami, h paramh) {
/*     */     try {
/* 142 */       paramh.hb();
/* 143 */     } catch (b b) {
/* 144 */       a(parami, b);
/* 145 */     } catch (ThreadDeath threadDeath) {
/* 146 */       throw threadDeath;
/* 147 */     } catch (Throwable throwable) {
/* 148 */       a(parami, throwable);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized boolean eq() {
/* 156 */     return this.ca;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void b(i parami) {
/* 163 */     int j = parami.bc();
/* 164 */     synchronized (this) {
/* 165 */       this.hS += j;
/*     */     } 
/* 167 */     for (l l : af()) {
/* 168 */       l.b(parami);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void stop() {
/* 176 */     this.ca = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized boolean er() {
/* 183 */     return (be() == 0 && bd() == 0);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\junit\b\m.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */