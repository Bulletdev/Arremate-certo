/*    */ package org.apache.poi.ss.util;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public class SheetReferences
/*    */ {
/* 35 */   Map<Integer, String> map = new HashMap<Integer, String>(5);
/*    */ 
/*    */   
/*    */   public void addSheetReference(String paramString, int paramInt) {
/* 39 */     this.map.put(Integer.valueOf(paramInt), paramString);
/*    */   }
/*    */   
/*    */   public String getSheetName(int paramInt) {
/* 43 */     return this.map.get(Integer.valueOf(paramInt));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\util\SheetReferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */