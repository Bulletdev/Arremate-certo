/*    */ package org.apache.poi.xwpf.usermodel;
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
/*    */ 
/*    */ 
/*    */ public enum BreakType
/*    */ {
/* 37 */   PAGE(1),
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
/* 49 */   COLUMN(2),
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 57 */   TEXT_WRAPPING(3);
/*    */   static {
/* 59 */     imap = new HashMap<Integer, BreakType>();
/*    */ 
/*    */     
/* 62 */     for (BreakType breakType : values())
/* 63 */       imap.put(Integer.valueOf(breakType.getValue()), breakType); 
/*    */   }
/*    */   
/*    */   private static Map<Integer, BreakType> imap;
/*    */   private final int value;
/*    */   
/*    */   BreakType(int paramInt1) {
/* 70 */     this.value = paramInt1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getValue() {
/* 82 */     return this.value;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\BreakType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */