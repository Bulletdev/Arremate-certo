/*     */ package com.sun.jna.platform.unix;
/*     */ 
/*     */ import com.sun.jna.Function;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.NativeLibrary;
/*     */ import com.sun.jna.Pointer;
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
/*     */ public class LibCUtil
/*     */ {
/*  39 */   private static final NativeLibrary LIBC = NativeLibrary.getInstance("c");
/*     */   
/*  41 */   private static Function mmap = null;
/*     */   private static boolean mmap64 = false;
/*  43 */   private static Function ftruncate = null;
/*     */   
/*     */   static {
/*     */     try {
/*  47 */       mmap = LIBC.getFunction("mmap64", 64);
/*  48 */       mmap64 = true;
/*  49 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  50 */       mmap = LIBC.getFunction("mmap", 64);
/*     */     } 
/*     */     try {
/*  53 */       ftruncate = LIBC.getFunction("ftruncate64", 64);
/*  54 */       ftruncate64 = true;
/*  55 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  56 */       ftruncate = LIBC.getFunction("ftruncate", 64);
/*     */     } 
/*     */   }
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
/*     */   private static boolean ftruncate64 = false;
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
/*     */   public static Pointer mmap(Pointer paramPointer, long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2) {
/* 109 */     Object[] arrayOfObject = new Object[6];
/* 110 */     arrayOfObject[0] = paramPointer;
/* 111 */     if (Native.SIZE_T_SIZE == 4) {
/* 112 */       require32Bit(paramLong1, "length");
/* 113 */       arrayOfObject[1] = Integer.valueOf((int)paramLong1);
/*     */     } else {
/* 115 */       arrayOfObject[1] = Long.valueOf(paramLong1);
/*     */     } 
/* 117 */     arrayOfObject[2] = Integer.valueOf(paramInt1);
/* 118 */     arrayOfObject[3] = Integer.valueOf(paramInt2);
/* 119 */     arrayOfObject[4] = Integer.valueOf(paramInt3);
/* 120 */     if (mmap64 || Native.LONG_SIZE > 4) {
/* 121 */       arrayOfObject[5] = Long.valueOf(paramLong2);
/*     */     } else {
/* 123 */       require32Bit(paramLong2, "offset");
/* 124 */       arrayOfObject[5] = Integer.valueOf((int)paramLong2);
/*     */     } 
/* 126 */     return mmap.invokePointer(arrayOfObject);
/*     */   }
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
/*     */   public static int ftruncate(int paramInt, long paramLong) {
/* 147 */     Object[] arrayOfObject = new Object[2];
/* 148 */     arrayOfObject[0] = Integer.valueOf(paramInt);
/* 149 */     if (ftruncate64 || Native.LONG_SIZE > 4) {
/* 150 */       arrayOfObject[1] = Long.valueOf(paramLong);
/*     */     } else {
/* 152 */       require32Bit(paramLong, "length");
/* 153 */       arrayOfObject[1] = Integer.valueOf((int)paramLong);
/*     */     } 
/* 155 */     return ftruncate.invokeInt(arrayOfObject);
/*     */   }
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
/*     */   public static void require32Bit(long paramLong, String paramString) {
/* 170 */     if (paramLong > 2147483647L)
/* 171 */       throw new IllegalArgumentException(paramString + " exceeds 32bit"); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platfor\\unix\LibCUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */