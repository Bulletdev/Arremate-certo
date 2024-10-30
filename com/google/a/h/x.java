/*    */ package com.google.a.h;
/*    */ 
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
/*    */ final class x
/*    */ {
/*    */   private static final M<w> g;
/*    */   
/*    */   static {
/*    */     M<w> m;
/*    */     try {
/* 31 */       new y();
/* 32 */       m = new M<w>()
/*    */         {
/*    */           public w b()
/*    */           {
/* 36 */             return new y();
/*    */           }
/*    */         };
/* 39 */     } catch (Throwable throwable) {
/* 40 */       m = new M<w>()
/*    */         {
/*    */           public w b()
/*    */           {
/* 44 */             return new x.a();
/*    */           }
/*    */         };
/*    */     } 
/* 48 */     g = m;
/*    */   }
/*    */   
/*    */   public static w a() {
/* 52 */     return (w)g.get();
/*    */   }
/*    */   
/*    */   private static final class a
/*    */     extends AtomicLong implements w {
/*    */     public void increment() {
/* 58 */       getAndIncrement();
/*    */     }
/*    */     private a() {}
/*    */     
/*    */     public void add(long param1Long) {
/* 63 */       getAndAdd(param1Long);
/*    */     }
/*    */ 
/*    */     
/*    */     public long X() {
/* 68 */       return get();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\h\x.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */