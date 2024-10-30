/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
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
/*     */ final class cr<C extends Comparable>
/*     */   extends R<C>
/*     */ {
/*     */   private final cn<C> c;
/*     */   private static final long serialVersionUID = 0L;
/*     */   
/*     */   cr(cn<C> paramcn, Y<C> paramY) {
/*  39 */     super(paramY);
/*  40 */     this.c = paramcn;
/*     */   }
/*     */   
/*     */   private R<C> a(cn<C> paramcn) {
/*  44 */     return this.c.c(paramcn) ? 
/*  45 */       R.<C>a(this.c.a(paramcn), this.a) : 
/*  46 */       new Z<>(this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   R<C> c(C paramC, boolean paramBoolean) {
/*  51 */     return a((cn)cn.a((Comparable<?>)paramC, x.a(paramBoolean)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   R<C> b(C paramC1, boolean paramBoolean1, C paramC2, boolean paramBoolean2) {
/*  57 */     if (paramC1.compareTo(paramC2) == 0 && !paramBoolean1 && !paramBoolean2)
/*     */     {
/*  59 */       return new Z<>(this.a);
/*     */     }
/*  61 */     return a(
/*  62 */         (cn)cn.a((Comparable<?>)paramC1, 
/*  63 */           x.a(paramBoolean1), (Comparable<?>)paramC2, 
/*  64 */           x.a(paramBoolean2)));
/*     */   }
/*     */ 
/*     */   
/*     */   R<C> d(C paramC, boolean paramBoolean) {
/*  69 */     return a((cn)cn.b((Comparable<?>)paramC, x.a(paramBoolean)));
/*     */   }
/*     */ 
/*     */   
/*     */   @c
/*     */   int indexOf(Object paramObject) {
/*  75 */     return contains(paramObject) ? (int)this.a.a(d(), (C)paramObject) : -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public dj<C> b() {
/*  80 */     return new l<C>(this, (Comparable)d()) {
/*  81 */         final C c = this.a.e();
/*     */ 
/*     */         
/*     */         protected C c(C param1C) {
/*  85 */           return cr.b((Comparable)param1C, (Comparable)this.c) ? null : this.a.a.a(param1C);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   @c
/*     */   public dj<C> c() {
/*  93 */     return new l<C>(this, (Comparable)e()) {
/*  94 */         final C d = this.a.d();
/*     */ 
/*     */         
/*     */         protected C c(C param1C) {
/*  98 */           return cr.b((Comparable)param1C, (Comparable)this.d) ? null : this.a.a.b(param1C);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private static boolean a(Comparable<?> paramComparable1, Comparable<?> paramComparable2) {
/* 104 */     return (paramComparable2 != null && cn.a(paramComparable1, paramComparable2) == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   boolean cO() {
/* 109 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public C d() {
/* 114 */     return this.c.a.a(this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public C e() {
/* 119 */     return this.c.b.b(this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   bh<C> h() {
/* 124 */     if (this.a.aD) {
/* 125 */       return new aZ<C>(this)
/*     */         {
/*     */           bA<C> d() {
/* 128 */             return this.a;
/*     */           }
/*     */ 
/*     */           
/*     */           public C a(int param1Int) {
/* 133 */             D.b(param1Int, size());
/* 134 */             return this.a.a.a(this.a.d(), param1Int);
/*     */           }
/*     */         };
/*     */     }
/* 138 */     return super.h();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 144 */     long l = this.a.a(d(), e());
/* 145 */     return (l >= 2147483647L) ? Integer.MAX_VALUE : ((int)l + 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Object paramObject) {
/* 150 */     if (paramObject == null) {
/* 151 */       return false;
/*     */     }
/*     */     try {
/* 154 */       return this.c.a((C)paramObject);
/* 155 */     } catch (ClassCastException classCastException) {
/* 156 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsAll(Collection<?> paramCollection) {
/* 162 */     return E.a(this, paramCollection);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 167 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public R<C> a(R<C> paramR) {
/* 172 */     D.checkNotNull(paramR);
/* 173 */     D.checkArgument(this.a.equals(paramR.a));
/* 174 */     if (paramR.isEmpty()) {
/* 175 */       return paramR;
/*     */     }
/* 177 */     Comparable<Comparable> comparable1 = (Comparable)cj.<Comparable>e().j(d(), (Comparable)paramR.first());
/* 178 */     Comparable<Comparable> comparable2 = (Comparable)cj.<Comparable>e().i(e(), (Comparable)paramR.last());
/* 179 */     return (comparable1.compareTo(comparable2) <= 0) ? 
/* 180 */       R.<C>a((cn)cn.b(comparable1, comparable2), this.a) : 
/* 181 */       new Z<>(this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public cn<C> a() {
/* 187 */     return a(x.b, x.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public cn<C> a(x paramx1, x paramx2) {
/* 192 */     return (cn)cn.a(this.c.a
/* 193 */         .a(paramx1, this.a), this.c.b
/* 194 */         .b(paramx2, this.a));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 199 */     if (paramObject == this)
/* 200 */       return true; 
/* 201 */     if (paramObject instanceof cr) {
/* 202 */       cr cr1 = (cr)paramObject;
/* 203 */       if (this.a.equals(cr1.a)) {
/* 204 */         return (d().equals(cr1.d()) && e().equals(cr1.e()));
/*     */       }
/*     */     } 
/* 207 */     return super.equals(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 213 */     return cG.a(this);
/*     */   }
/*     */   
/*     */   @c
/*     */   private static final class a<C extends Comparable> implements Serializable {
/*     */     final cn<C> c;
/*     */     final Y<C> a;
/*     */     
/*     */     private a(cn<C> param1cn, Y<C> param1Y) {
/* 222 */       this.c = param1cn;
/* 223 */       this.a = param1Y;
/*     */     }
/*     */     
/*     */     private Object readResolve() {
/* 227 */       return new cr<>(this.c, this.a);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @c
/*     */   Object writeReplace() {
/* 234 */     return new a<>(this.c, this.a);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\cr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */