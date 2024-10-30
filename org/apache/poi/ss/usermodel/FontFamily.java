/*    */ package org.apache.poi.ss.usermodel;
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
/*    */ public enum FontFamily
/*    */ {
/* 29 */   NOT_APPLICABLE(0),
/* 30 */   ROMAN(1),
/* 31 */   SWISS(2),
/* 32 */   MODERN(3),
/* 33 */   SCRIPT(4),
/* 34 */   DECORATIVE(5);
/*    */   private int family;
/*    */   private static FontFamily[] _table;
/*    */   
/*    */   FontFamily(int paramInt1) {
/* 39 */     this.family = paramInt1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getValue() {
/* 48 */     return this.family;
/*    */   }
/*    */   static {
/* 51 */     _table = new FontFamily[6];
/*    */ 
/*    */     
/* 54 */     for (FontFamily fontFamily : values())
/* 55 */       _table[fontFamily.getValue()] = fontFamily; 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\FontFamily.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */