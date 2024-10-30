/*    */ package org.apache.poi.util;
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
/*    */ public class NullLogger
/*    */   extends POILogger
/*    */ {
/*    */   public void initialize(String paramString) {}
/*    */   
/*    */   public void log(int paramInt, Object paramObject) {}
/*    */   
/*    */   public void log(int paramInt, Object paramObject, Throwable paramThrowable) {}
/*    */   
/*    */   public boolean check(int paramInt) {
/* 64 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\NullLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */