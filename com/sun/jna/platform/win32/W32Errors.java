/*     */ package com.sun.jna.platform.win32;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class W32Errors
/*     */   implements WinError
/*     */ {
/*     */   public static final boolean SUCCEEDED(int paramInt) {
/*  42 */     return (paramInt >= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final boolean FAILED(int paramInt) {
/*  53 */     return (paramInt < 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final boolean SUCCEEDED(WinNT.HRESULT paramHRESULT) {
/*  64 */     return (paramHRESULT == null || SUCCEEDED(paramHRESULT.intValue()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final boolean FAILED(WinNT.HRESULT paramHRESULT) {
/*  75 */     return (paramHRESULT != null && FAILED(paramHRESULT.intValue()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int HRESULT_CODE(int paramInt) {
/*  86 */     return paramInt & 0xFFFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int SCODE_CODE(int paramInt) {
/*  97 */     return paramInt & 0xFFFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int HRESULT_FACILITY(int paramInt) {
/* 108 */     return (paramInt >>= 16) & 0x1FFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int SCODE_FACILITY(short paramShort) {
/* 119 */     return (paramShort = (short)(paramShort >> 16)) & 0x1FFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static short HRESULT_SEVERITY(int paramInt) {
/* 130 */     return (short)((paramInt >>= 31) & 0x1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static short SCODE_SEVERITY(short paramShort) {
/* 141 */     return (short)((paramShort = (short)(paramShort >> 31)) & 0x1);
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
/*     */   public static int MAKE_HRESULT(short paramShort1, short paramShort2, short paramShort3) {
/* 154 */     return paramShort1 << 31 | paramShort2 << 16 | paramShort3;
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
/*     */   public static final int MAKE_SCODE(short paramShort1, short paramShort2, short paramShort3) {
/* 167 */     return paramShort1 << 31 | paramShort2 << 16 | paramShort3;
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
/*     */   public static final WinNT.HRESULT HRESULT_FROM_WIN32(int paramInt) {
/* 179 */     int i = 7;
/* 180 */     return new WinNT.HRESULT((paramInt <= 0) ? paramInt : (paramInt & 0xFFFF | (i <<= 16) | Integer.MIN_VALUE));
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
/*     */   public static final int FILTER_HRESULT_FROM_FLT_NTSTATUS(int paramInt) {
/* 194 */     int i = 31;
/* 195 */     return paramInt & 0x8000FFFF | (i <<= 16);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\W32Errors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */