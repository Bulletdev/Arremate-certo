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
/*    */ public enum VerticalAlignment
/*    */ {
/* 31 */   TOP,
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 36 */   CENTER,
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 41 */   BOTTOM,
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
/* 56 */   JUSTIFY,
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
/* 71 */   DISTRIBUTED;
/*    */   
/*    */   public short getCode() {
/* 74 */     return (short)ordinal();
/*    */   }
/*    */   public static VerticalAlignment forInt(int paramInt) {
/* 77 */     if (paramInt < 0 || paramInt >= (values()).length) {
/* 78 */       throw new IllegalArgumentException("Invalid VerticalAlignment code: " + paramInt);
/*    */     }
/* 80 */     return values()[paramInt];
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\VerticalAlignment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */