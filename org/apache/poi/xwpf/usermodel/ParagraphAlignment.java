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
/*    */ public enum ParagraphAlignment
/*    */ {
/* 32 */   LEFT(1),
/* 33 */   CENTER(2),
/* 34 */   RIGHT(3),
/* 35 */   BOTH(4),
/* 36 */   MEDIUM_KASHIDA(5),
/* 37 */   DISTRIBUTE(6),
/* 38 */   NUM_TAB(7),
/* 39 */   HIGH_KASHIDA(8),
/* 40 */   LOW_KASHIDA(9),
/* 41 */   THAI_DISTRIBUTE(10);
/*    */   static {
/* 43 */     imap = new HashMap<Integer, ParagraphAlignment>();
/*    */ 
/*    */     
/* 46 */     for (ParagraphAlignment paragraphAlignment : values())
/* 47 */       imap.put(Integer.valueOf(paragraphAlignment.getValue()), paragraphAlignment); 
/*    */   }
/*    */   
/*    */   private static Map<Integer, ParagraphAlignment> imap;
/*    */   private final int value;
/*    */   
/*    */   ParagraphAlignment(int paramInt1) {
/* 54 */     this.value = paramInt1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getValue() {
/* 64 */     return this.value;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\ParagraphAlignment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */