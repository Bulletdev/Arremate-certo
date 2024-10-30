/*     */ package org.apache.poi.util;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArrayUtil
/*     */ {
/*     */   public static void arraycopy(byte[] paramArrayOfbyte1, int paramInt1, byte[] paramArrayOfbyte2, int paramInt2, int paramInt3) {
/*  35 */     if (paramInt1 < 0)
/*  36 */       throw new IllegalArgumentException("src_position was less than 0.  Actual value " + paramInt1); 
/*  37 */     if (paramInt1 >= paramArrayOfbyte1.length)
/*  38 */       throw new IllegalArgumentException("src_position was greater than src array size.  Tried to write starting at position " + paramInt1 + " but the array length is " + paramArrayOfbyte1.length); 
/*  39 */     if (paramInt1 + paramInt3 > paramArrayOfbyte1.length)
/*  40 */       throw new IllegalArgumentException("src_position + length would overrun the src array.  Expected end at " + (paramInt1 + paramInt3) + " actual end at " + paramArrayOfbyte1.length); 
/*  41 */     if (paramInt2 < 0)
/*  42 */       throw new IllegalArgumentException("dst_position was less than 0.  Actual value " + paramInt2); 
/*  43 */     if (paramInt2 >= paramArrayOfbyte2.length)
/*  44 */       throw new IllegalArgumentException("dst_position was greater than dst array size.  Tried to write starting at position " + paramInt2 + " but the array length is " + paramArrayOfbyte2.length); 
/*  45 */     if (paramInt2 + paramInt3 > paramArrayOfbyte2.length) {
/*  46 */       throw new IllegalArgumentException("dst_position + length would overrun the dst array.  Expected end at " + (paramInt2 + paramInt3) + " actual end at " + paramArrayOfbyte2.length);
/*     */     }
/*  48 */     System.arraycopy(paramArrayOfbyte1, paramInt1, paramArrayOfbyte2, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void arrayMoveWithin(Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3) {
/*     */     Object[] arrayOfObject2;
/*     */     int i;
/*  61 */     if (paramInt3 <= 0)
/*  62 */       return;  if (paramInt1 == paramInt2) {
/*     */       return;
/*     */     }
/*  65 */     if (paramInt1 < 0 || paramInt1 >= paramArrayOfObject.length) {
/*  66 */       throw new IllegalArgumentException("The moveFrom must be a valid array index");
/*     */     }
/*  68 */     if (paramInt2 < 0 || paramInt2 >= paramArrayOfObject.length) {
/*  69 */       throw new IllegalArgumentException("The moveTo must be a valid array index");
/*     */     }
/*  71 */     if (paramInt1 + paramInt3 > paramArrayOfObject.length) {
/*  72 */       throw new IllegalArgumentException("Asked to move more entries than the array has");
/*     */     }
/*  74 */     if (paramInt2 + paramInt3 > paramArrayOfObject.length) {
/*  75 */       throw new IllegalArgumentException("Asked to move to a position that doesn't have enough space");
/*     */     }
/*     */ 
/*     */     
/*  79 */     Object[] arrayOfObject1 = new Object[paramInt3];
/*  80 */     System.arraycopy(paramArrayOfObject, paramInt1, arrayOfObject1, 0, paramInt3);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  85 */     if (paramInt1 > paramInt2) {
/*     */ 
/*     */       
/*  88 */       arrayOfObject2 = new Object[paramInt1 - paramInt2];
/*  89 */       System.arraycopy(paramArrayOfObject, paramInt2, arrayOfObject2, 0, arrayOfObject2.length);
/*  90 */       i = paramInt2 + paramInt3;
/*     */     }
/*     */     else {
/*     */       
/*  94 */       arrayOfObject2 = new Object[paramInt2 - paramInt1];
/*  95 */       System.arraycopy(paramArrayOfObject, paramInt1 + paramInt3, arrayOfObject2, 0, arrayOfObject2.length);
/*  96 */       i = paramInt1;
/*     */     } 
/*     */ 
/*     */     
/* 100 */     System.arraycopy(arrayOfObject1, 0, paramArrayOfObject, paramInt2, arrayOfObject1.length);
/*     */ 
/*     */     
/* 103 */     System.arraycopy(arrayOfObject2, 0, paramArrayOfObject, i, arrayOfObject2.length);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\ArrayUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */