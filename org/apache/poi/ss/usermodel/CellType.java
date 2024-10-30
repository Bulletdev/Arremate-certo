/*    */ package org.apache.poi.ss.usermodel;
/*    */ 
/*    */ import org.apache.poi.util.Internal;
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
/*    */ public enum CellType
/*    */ {
/* 32 */   _NONE(-1),
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 38 */   NUMERIC(0),
/*    */ 
/*    */   
/* 41 */   STRING(1),
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 47 */   FORMULA(2),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 52 */   BLANK(3),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 57 */   BOOLEAN(4),
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 63 */   ERROR(5);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final int code;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   CellType(int paramInt1) {
/* 76 */     this.code = paramInt1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static CellType forInt(int paramInt) {
/* 84 */     for (CellType cellType : values()) {
/* 85 */       if (cellType.code == paramInt) {
/* 86 */         return cellType;
/*    */       }
/*    */     } 
/* 89 */     throw new IllegalArgumentException("Invalid CellType code: " + paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getCode() {
/* 97 */     return this.code;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\CellType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */