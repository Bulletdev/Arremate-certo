/*    */ package org.apache.poi.xssf.util;
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
/*    */ public class NumericRanges
/*    */ {
/*    */   public static final int NO_OVERLAPS = -1;
/*    */   public static final int OVERLAPS_1_MINOR = 0;
/*    */   public static final int OVERLAPS_2_MINOR = 1;
/*    */   public static final int OVERLAPS_1_WRAPS = 2;
/*    */   public static final int OVERLAPS_2_WRAPS = 3;
/*    */   
/*    */   public static long[] getOverlappingRange(long[] paramArrayOflong1, long[] paramArrayOflong2) {
/* 29 */     int i = getOverlappingType(paramArrayOflong1, paramArrayOflong2);
/* 30 */     if (i == 0) {
/* 31 */       return new long[] { paramArrayOflong2[0], paramArrayOflong1[1] };
/*    */     }
/* 33 */     if (i == 1) {
/* 34 */       return new long[] { paramArrayOflong1[0], paramArrayOflong2[1] };
/*    */     }
/* 36 */     if (i == 3) {
/* 37 */       return paramArrayOflong1;
/*    */     }
/* 39 */     if (i == 2) {
/* 40 */       return paramArrayOflong2;
/*    */     }
/* 42 */     return new long[] { -1L, -1L };
/*    */   }
/*    */   
/*    */   public static int getOverlappingType(long[] paramArrayOflong1, long[] paramArrayOflong2) {
/* 46 */     long l1 = paramArrayOflong1[0];
/* 47 */     long l2 = paramArrayOflong1[1];
/* 48 */     long l3 = paramArrayOflong2[0];
/* 49 */     long l4 = paramArrayOflong2[1];
/* 50 */     if (l1 >= l3 && l2 <= l4) {
/* 51 */       return 3;
/*    */     }
/* 53 */     if (l3 >= l1 && l4 <= l2) {
/* 54 */       return 2;
/*    */     }
/* 56 */     if (l3 >= l1 && l3 <= l2 && l4 >= l2) {
/* 57 */       return 0;
/*    */     }
/* 59 */     if (l1 >= l3 && l1 <= l4 && l2 >= l4) {
/* 60 */       return 1;
/*    */     }
/* 62 */     return -1;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\util\NumericRanges.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */