/*    */ package org.d.a;
/*    */ import java.util.ArrayList;
/*    */ import org.d.g;
/*    */ import org.d.i;
/*    */ import org.d.k;
/*    */ import org.d.m;
/*    */ import org.d.o;
/*    */ 
/*    */ public class c<T> extends o<T> {
/*    */   public c(k<? super T> paramk) {
/* 11 */     this.b = paramk;
/*    */   }
/*    */   private final k<? super T> b;
/*    */   
/*    */   protected boolean b(T paramT, g paramg) {
/* 16 */     if (!this.b.E(paramT)) {
/* 17 */       this.b.a(paramT, paramg);
/* 18 */       return false;
/*    */     } 
/* 20 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(g paramg) {
/* 25 */     paramg.a((m)this.b);
/*    */   }
/*    */   
/*    */   public c<T> a(k<? super T> paramk) {
/* 29 */     return new c((k<? super T>)new a<T>(a(paramk)));
/*    */   }
/*    */   
/*    */   public c<T> b(k<? super T> paramk) {
/* 33 */     return new c((k<? super T>)new b<T>(a(paramk)));
/*    */   }
/*    */   
/*    */   private ArrayList<k<? super T>> a(k<? super T> paramk) {
/* 37 */     ArrayList<k<? super T>> arrayList = new ArrayList();
/* 38 */     arrayList.add(this.b);
/* 39 */     arrayList.add(paramk);
/* 40 */     return arrayList;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @i
/*    */   public static <LHS> a<LHS> a(k<? super LHS> paramk) {
/* 51 */     return new a<LHS>(paramk);
/*    */   }
/*    */   
/*    */   public static final class a<X> { private final k<? super X> c;
/*    */     
/*    */     public a(k<? super X> param1k) {
/* 57 */       this.c = param1k;
/*    */     }
/*    */     public c<X> a(k<? super X> param1k) {
/* 60 */       return (new c<X>(this.c)).a(param1k);
/*    */     } }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @i
/*    */   public static <LHS> b<LHS> a(k<? super LHS> paramk) {
/* 72 */     return new b<LHS>(paramk);
/*    */   }
/*    */   
/*    */   public static final class b<X> { private final k<? super X> c;
/*    */     
/*    */     public b(k<? super X> param1k) {
/* 78 */       this.c = param1k;
/*    */     }
/*    */     public c<X> b(k<? super X> param1k) {
/* 81 */       return (new c<X>(this.c)).b(param1k);
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\a\c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */