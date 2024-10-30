/*     */ package com.google.a.f;
/*     */ 
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.d.cm;
/*     */ import java.util.Iterator;
/*     */ import java.util.Queue;
/*     */ import java.util.concurrent.ConcurrentLinkedQueue;
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
/*     */ 
/*     */ abstract class d
/*     */ {
/*     */   static d a() {
/*  47 */     return new c();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static d b() {
/*  57 */     return new b();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static d c() {
/*  66 */     return a.a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   abstract void a(Object paramObject, Iterator<g> paramIterator);
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class c
/*     */     extends d
/*     */   {
/*  78 */     private final ThreadLocal<Queue<a>> c = new ThreadLocal<Queue<a>>(this)
/*     */       {
/*     */         protected Queue<d.c.a> c()
/*     */         {
/*  82 */           return cm.a();
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  87 */     private final ThreadLocal<Boolean> d = new ThreadLocal<Boolean>(this)
/*     */       {
/*     */         protected Boolean initialValue()
/*     */         {
/*  91 */           return Boolean.valueOf(false);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*     */     void a(Object param1Object, Iterator<g> param1Iterator) {
/*  97 */       D.checkNotNull(param1Object);
/*  98 */       D.checkNotNull(param1Iterator);
/*  99 */       Queue<a> queue = this.c.get();
/* 100 */       queue.offer(new a(param1Object, param1Iterator));
/*     */       
/* 102 */       if (!((Boolean)this.d.get()).booleanValue()) {
/* 103 */         this.d.set(Boolean.valueOf(true));
/*     */         try {
/*     */           a a;
/* 106 */           while ((a = queue.poll()) != null) {
/* 107 */             while (a.a(a).hasNext()) {
/* 108 */               ((g)a.a(a).next()).r(a.a(a));
/*     */             }
/*     */           } 
/*     */         } finally {
/* 112 */           this.d.remove();
/* 113 */           this.c.remove();
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     private c() {}
/*     */     
/*     */     private static final class a
/*     */     {
/*     */       private a(Object param2Object, Iterator<g> param2Iterator) {
/* 123 */         this.aa = param2Object;
/* 124 */         this.J = param2Iterator;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final Object aa;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final Iterator<g> J;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class b
/*     */     extends d
/*     */   {
/* 152 */     private final ConcurrentLinkedQueue<a> a = cm.a();
/*     */ 
/*     */     
/*     */     void a(Object param1Object, Iterator<g> param1Iterator) {
/* 156 */       D.checkNotNull(param1Object);
/* 157 */       while (param1Iterator.hasNext()) {
/* 158 */         this.a.add(new a(param1Object, param1Iterator.next()));
/*     */       }
/*     */       
/*     */       a a;
/* 162 */       while ((a = this.a.poll()) != null)
/* 163 */         a.a(a).r(a.a(a)); 
/*     */     }
/*     */     
/*     */     private b() {}
/*     */     
/*     */     private static final class a {
/*     */       private final Object aa;
/*     */       
/*     */       private a(Object param2Object, g param2g) {
/* 172 */         this.aa = param2Object;
/* 173 */         this.a = param2g;
/*     */       }
/*     */       
/*     */       private final g a; }
/*     */   }
/*     */   
/*     */   private static final class a extends d {
/* 180 */     private static final a a = new a();
/*     */ 
/*     */     
/*     */     void a(Object param1Object, Iterator<g> param1Iterator) {
/* 184 */       D.checkNotNull(param1Object);
/* 185 */       while (param1Iterator.hasNext())
/* 186 */         ((g)param1Iterator.next()).r(param1Object); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\f\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */