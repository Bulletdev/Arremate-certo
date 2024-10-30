/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.d.cG;
/*     */ import com.google.c.a.f;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
/*     */ import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
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
/*     */ @b(cl = true)
/*     */ @f(a = f.a.FULL)
/*     */ abstract class j<OutputT>
/*     */   extends c.i<OutputT>
/*     */ {
/*     */   static {
/*     */     c c;
/*     */   }
/*     */   
/*  43 */   private volatile Set<Throwable> D = null;
/*     */   
/*     */   private volatile int remaining;
/*     */   
/*     */   private static final a a;
/*     */   
/*  49 */   private static final Logger a = Logger.getLogger(j.class.getName());
/*     */ 
/*     */   
/*     */   static {
/*  53 */     Throwable throwable = null;
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  58 */       b b = new b(AtomicReferenceFieldUpdater.newUpdater(j.class, Set.class, "D"), AtomicIntegerFieldUpdater.newUpdater(j.class, "remaining"));
/*  59 */     } catch (Throwable throwable1) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  64 */       throwable = throwable1;
/*  65 */       c = new c();
/*     */     } 
/*  67 */     a = (Logger)c;
/*     */ 
/*     */     
/*  70 */     if (throwable != null) {
/*  71 */       a.log(Level.SEVERE, "SafeAtomicHelper is broken!", throwable);
/*     */     }
/*     */   }
/*     */   
/*     */   j(int paramInt) {
/*  76 */     this.remaining = paramInt;
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
/*     */   final Set<Throwable> H() {
/*  96 */     Set<Throwable> set = this.D;
/*  97 */     if (set == null) {
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
/* 113 */       set = cG.t();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 119 */       b(set);
/*     */       
/* 121 */       a.a(this, null, set);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 128 */       set = this.D;
/*     */     } 
/* 130 */     return set;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final int ax() {
/* 137 */     return a.b(this);
/*     */   }
/*     */   
/*     */   final void fR() {
/* 141 */     this.D = null;
/*     */   }
/*     */   
/*     */   abstract void b(Set<Throwable> paramSet);
/*     */   
/*     */   private static abstract class a
/*     */   {
/*     */     private a() {}
/*     */     
/*     */     abstract void a(j param1j, Set<Throwable> param1Set1, Set<Throwable> param1Set2);
/*     */     
/*     */     abstract int b(j param1j);
/*     */   }
/*     */   
/*     */   private static final class b
/*     */     extends a {
/*     */     final AtomicReferenceFieldUpdater<j, Set<Throwable>> f;
/*     */     final AtomicIntegerFieldUpdater<j> a;
/*     */     
/*     */     b(AtomicReferenceFieldUpdater<j, Set<Throwable>> param1AtomicReferenceFieldUpdater, AtomicIntegerFieldUpdater<j> param1AtomicIntegerFieldUpdater) {
/* 161 */       this.f = param1AtomicReferenceFieldUpdater;
/* 162 */       this.a = param1AtomicIntegerFieldUpdater;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void a(j param1j, Set<Throwable> param1Set1, Set<Throwable> param1Set2) {
/* 168 */       this.f.compareAndSet(param1j, param1Set1, param1Set2);
/*     */     }
/*     */ 
/*     */     
/*     */     int b(j param1j) {
/* 173 */       return this.a.decrementAndGet(param1j);
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class c extends a {
/*     */     private c() {}
/*     */     
/*     */     void a(j param1j, Set<Throwable> param1Set1, Set<Throwable> param1Set2) {
/* 181 */       synchronized (param1j) {
/* 182 */         if (j.a(param1j) == param1Set1) {
/* 183 */           j.a(param1j, param1Set2);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     int b(j param1j) {
/* 190 */       synchronized (param1j) {
/* 191 */         return j.a(param1j);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */