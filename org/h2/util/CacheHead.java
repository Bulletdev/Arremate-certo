/*    */ package org.h2.util;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CacheHead
/*    */   extends CacheObject
/*    */ {
/*    */   public boolean canRemove() {
/* 15 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getMemory() {
/* 20 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\CacheHead.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */