/*    */ package org.junit.f.a;
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
/*    */ public class n
/*    */   extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = 31935685163547539L;
/*    */   private final TimeUnit timeUnit;
/*    */   private final long timeout;
/*    */   
/*    */   public n(long paramLong, TimeUnit paramTimeUnit) {
/* 25 */     super(String.format("test timed out after %d %s", new Object[] { Long.valueOf(paramLong), paramTimeUnit.name().toLowerCase() }));
/*    */     
/* 27 */     this.timeUnit = paramTimeUnit;
/* 28 */     this.timeout = paramLong;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public long getTimeout() {
/* 35 */     return this.timeout;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TimeUnit a() {
/* 42 */     return this.timeUnit;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\f\a\n.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */