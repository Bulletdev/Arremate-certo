/*     */ package com.sun.jna.platform.mac;
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
/*     */ 
/*     */ 
/*     */ public class IOReturnException
/*     */   extends RuntimeException
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private int ioReturn;
/*     */   
/*     */   public IOReturnException(int paramInt) {
/*  47 */     this(paramInt, formatMessage(paramInt));
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
/*     */   protected IOReturnException(int paramInt, String paramString) {
/*  59 */     super(paramString);
/*  60 */     this.ioReturn = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getIOReturnCode() {
/*  67 */     return this.ioReturn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getSystem(int paramInt) {
/*  78 */     return paramInt >> 26 & 0x3F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getSubSystem(int paramInt) {
/*  89 */     return paramInt >> 14 & 0xFFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getCode(int paramInt) {
/* 100 */     return paramInt & 0x3FFF;
/*     */   }
/*     */   
/*     */   private static String formatMessage(int paramInt) {
/* 104 */     return "IOReturn error code: " + paramInt + " (system=" + getSystem(paramInt) + ", subSystem=" + getSubSystem(paramInt) + ", code=" + 
/* 105 */       getCode(paramInt) + ")";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\mac\IOReturnException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */