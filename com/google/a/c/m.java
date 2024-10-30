/*    */ package com.google.a.c;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import com.google.a.b.M;
/*    */ import java.util.concurrent.atomic.AtomicLong;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @b(cl = true)
/*    */ final class m
/*    */ {
/*    */   private static final M<l> g;
/*    */   
/*    */   static {
/*    */     M<l> m1;
/*    */     try {
/* 33 */       new n();
/* 34 */       m1 = new M<l>()
/*    */         {
/*    */           public l b()
/*    */           {
/* 38 */             return new n();
/*    */           }
/*    */         };
/* 41 */     } catch (Throwable throwable) {
/* 42 */       m1 = new M<l>()
/*    */         {
/*    */           public l b()
/*    */           {
/* 46 */             return new m.a();
/*    */           }
/*    */         };
/*    */     } 
/* 50 */     g = m1;
/*    */   }
/*    */   
/*    */   public static l a() {
/* 54 */     return (l)g.get();
/*    */   }
/*    */   
/*    */   private static final class a
/*    */     extends AtomicLong implements l {
/*    */     public void increment() {
/* 60 */       getAndIncrement();
/*    */     }
/*    */     private a() {}
/*    */     
/*    */     public void add(long param1Long) {
/* 65 */       getAndAdd(param1Long);
/*    */     }
/*    */ 
/*    */     
/*    */     public long X() {
/* 70 */       return get();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\c\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */