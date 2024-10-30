/*    */ package org.c.a.b.r;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
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
/*    */ public class m
/*    */ {
/*    */   private long start;
/*    */   private long bR;
/*    */   
/*    */   public void start() {
/* 38 */     this.start = System.nanoTime();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void stop() {
/* 45 */     this.bR = System.nanoTime();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public long al() {
/* 52 */     return TimeUnit.NANOSECONDS.toMillis(this.bR - this.start);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\r\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */