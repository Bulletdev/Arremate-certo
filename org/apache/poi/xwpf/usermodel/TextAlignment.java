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
/*    */ public enum TextAlignment
/*    */ {
/* 33 */   TOP(1),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 38 */   CENTER(2),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 43 */   BASELINE(3),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 48 */   BOTTOM(4),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 53 */   AUTO(5);
/*    */   static {
/* 55 */     imap = new HashMap<Integer, TextAlignment>();
/*    */ 
/*    */     
/* 58 */     for (TextAlignment textAlignment : values())
/* 59 */       imap.put(Integer.valueOf(textAlignment.getValue()), textAlignment); 
/*    */   }
/*    */   
/*    */   private static Map<Integer, TextAlignment> imap;
/*    */   private final int value;
/*    */   
/*    */   TextAlignment(int paramInt1) {
/* 66 */     this.value = paramInt1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getValue() {
/* 76 */     return this.value;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\TextAlignment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */