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
/*    */ public enum FillPatternType
/*    */ {
/* 27 */   NO_FILL(0),
/*    */ 
/*    */   
/* 30 */   SOLID_FOREGROUND(1),
/*    */ 
/*    */   
/* 33 */   FINE_DOTS(2),
/*    */ 
/*    */   
/* 36 */   ALT_BARS(3),
/*    */ 
/*    */   
/* 39 */   SPARSE_DOTS(4),
/*    */ 
/*    */   
/* 42 */   THICK_HORZ_BANDS(5),
/*    */ 
/*    */   
/* 45 */   THICK_VERT_BANDS(6),
/*    */ 
/*    */   
/* 48 */   THICK_BACKWARD_DIAG(7),
/*    */ 
/*    */   
/* 51 */   THICK_FORWARD_DIAG(8),
/*    */ 
/*    */   
/* 54 */   BIG_SPOTS(9),
/*    */ 
/*    */   
/* 57 */   BRICKS(10),
/*    */ 
/*    */   
/* 60 */   THIN_HORZ_BANDS(11),
/*    */ 
/*    */   
/* 63 */   THIN_VERT_BANDS(12),
/*    */ 
/*    */   
/* 66 */   THIN_BACKWARD_DIAG(13),
/*    */ 
/*    */   
/* 69 */   THIN_FORWARD_DIAG(14),
/*    */ 
/*    */   
/* 72 */   SQUARES(15),
/*    */ 
/*    */   
/* 75 */   DIAMONDS(16),
/*    */ 
/*    */   
/* 78 */   LESS_DOTS(17),
/*    */ 
/*    */   
/* 81 */   LEAST_DOTS(18);
/*    */   private final short code;
/*    */   private static final int length;
/*    */   
/*    */   FillPatternType(int paramInt1) {
/* 86 */     this.code = (short)paramInt1;
/*    */   }
/*    */   
/*    */   public short getCode() {
/* 90 */     return this.code;
/*    */   }
/*    */   static {
/* 93 */     length = (values()).length;
/*    */   } public static FillPatternType forInt(int paramInt) {
/* 95 */     if (paramInt < 0 || paramInt > length) {
/* 96 */       throw new IllegalArgumentException("Invalid FillPatternType code: " + paramInt);
/*    */     }
/* 98 */     return values()[paramInt];
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\FillPatternType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */