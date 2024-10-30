/*     */ package com.google.a.g;
/*     */ 
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.d.bt;
/*     */ import com.google.a.d.c;
/*     */ import com.google.a.d.cG;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
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
/*     */ abstract class o<N>
/*     */   extends c<n<N>>
/*     */ {
/*     */   private final h<N> a;
/*     */   private final Iterator<N> N;
/*  36 */   protected N ah = null;
/*  37 */   protected Iterator<N> O = (Iterator<N>)bt.n().b();
/*     */   
/*     */   static <N> o<N> a(h<N> paramh) {
/*  40 */     return paramh.cX() ? new a<>(paramh) : new b<>(paramh);
/*     */   }
/*     */   
/*     */   private o(h<N> paramh) {
/*  44 */     this.a = paramh;
/*  45 */     this.N = paramh.A().iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final boolean da() {
/*  53 */     D.ab(!this.O.hasNext());
/*  54 */     if (!this.N.hasNext()) {
/*  55 */       return false;
/*     */     }
/*  57 */     this.ah = this.N.next();
/*  58 */     this.O = this.a.f(this.ah).iterator();
/*  59 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class a<N>
/*     */     extends o<N>
/*     */   {
/*     */     private a(h<N> param1h) {
/*  68 */       super(param1h);
/*     */     }
/*     */ 
/*     */     
/*     */     protected n<N> a() {
/*     */       while (true) {
/*  74 */         if (this.O.hasNext()) {
/*  75 */           return n.a(this.ah, this.O.next());
/*     */         }
/*  77 */         if (!da()) {
/*  78 */           return (n<N>)c();
/*     */         }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class b<N>
/*     */     extends o<N>
/*     */   {
/*     */     private Set<N> y;
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
/*     */     private b(h<N> param1h) {
/* 114 */       super(param1h);
/* 115 */       this.y = cG.a(param1h.A().size());
/*     */     }
/*     */ 
/*     */     
/*     */     protected n<N> a() {
/*     */       while (true) {
/* 121 */         while (this.O.hasNext()) {
/* 122 */           N n = this.O.next();
/* 123 */           if (!this.y.contains(n)) {
/* 124 */             return n.b(this.ah, n);
/*     */           }
/*     */         } 
/*     */         
/* 128 */         this.y.add(this.ah);
/* 129 */         if (!da()) {
/* 130 */           this.y = null;
/* 131 */           return (n<N>)c();
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\g\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */