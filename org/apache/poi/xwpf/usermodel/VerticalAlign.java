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
/*    */ public enum VerticalAlign
/*    */ {
/* 36 */   BASELINE(1),
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 42 */   SUPERSCRIPT(2),
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 48 */   SUBSCRIPT(3);
/*    */   static {
/* 50 */     imap = new HashMap<Integer, VerticalAlign>();
/*    */ 
/*    */     
/* 53 */     for (VerticalAlign verticalAlign : values())
/* 54 */       imap.put(Integer.valueOf(verticalAlign.getValue()), verticalAlign); 
/*    */   }
/*    */   
/*    */   private static Map<Integer, VerticalAlign> imap;
/*    */   private final int value;
/*    */   
/*    */   VerticalAlign(int paramInt1) {
/* 61 */     this.value = paramInt1;
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
/* 73 */     return this.value;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\VerticalAlign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */