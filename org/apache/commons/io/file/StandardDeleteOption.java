/*    */ package org.apache.commons.io.file;
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
/*    */ public enum StandardDeleteOption
/*    */   implements DeleteOption
/*    */ {
/* 30 */   OVERRIDE_READ_ONLY;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean overrideReadOnly(DeleteOption[] paramArrayOfDeleteOption) {
/* 41 */     if (paramArrayOfDeleteOption == null || paramArrayOfDeleteOption.length == 0) {
/* 42 */       return false;
/*    */     }
/* 44 */     for (DeleteOption deleteOption : paramArrayOfDeleteOption) {
/* 45 */       if (deleteOption == OVERRIDE_READ_ONLY) {
/* 46 */         return true;
/*    */       }
/*    */     } 
/* 49 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\file\StandardDeleteOption.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */