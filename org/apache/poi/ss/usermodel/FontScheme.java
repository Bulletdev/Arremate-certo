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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum FontScheme
/*    */ {
/* 33 */   NONE(1),
/* 34 */   MAJOR(2),
/* 35 */   MINOR(3);
/*    */   private int value;
/*    */   private static FontScheme[] _table;
/*    */   
/*    */   FontScheme(int paramInt1) {
/* 40 */     this.value = paramInt1;
/*    */   }
/*    */   
/*    */   public int getValue() {
/* 44 */     return this.value;
/*    */   }
/*    */   static {
/* 47 */     _table = new FontScheme[4];
/*    */     
/* 49 */     for (FontScheme fontScheme : values())
/* 50 */       _table[fontScheme.getValue()] = fontScheme; 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\FontScheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */