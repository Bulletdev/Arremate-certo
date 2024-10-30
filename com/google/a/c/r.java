/*    */ package com.google.a.c;
/*    */ 
/*    */ import com.google.a.a.c;
/*    */ import com.google.a.b.D;
/*    */ import java.util.concurrent.Executor;
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
/*    */ @c
/*    */ public final class r
/*    */ {
/*    */   public static <K, V> q<K, V> a(q<K, V> paramq, Executor paramExecutor) {
/* 42 */     D.checkNotNull(paramq);
/* 43 */     D.checkNotNull(paramExecutor);
/* 44 */     return new q<K, V>(paramExecutor, paramq)
/*    */       {
/*    */         public void a(s<K, V> param1s) {
/* 47 */           this.a.execute(new Runnable(this, param1s)
/*    */               {
/*    */                 public void run()
/*    */                 {
/* 51 */                   this.a.b.a((s)this.a);
/*    */                 }
/*    */               });
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\c\r.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */