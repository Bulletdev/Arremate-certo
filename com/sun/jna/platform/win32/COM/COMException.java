/*     */ package com.sun.jna.platform.win32.COM;
/*     */ 
/*     */ import com.sun.jna.platform.win32.WinNT;
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
/*     */ public class COMException
/*     */   extends RuntimeException
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final WinNT.HRESULT hresult;
/*     */   
/*     */   public COMException() {
/*  42 */     this("", (Throwable)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public COMException(String paramString) {
/*  52 */     this(paramString, (Throwable)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public COMException(Throwable paramThrowable) {
/*  63 */     this((String)null, paramThrowable);
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
/*     */   public COMException(String paramString, Throwable paramThrowable) {
/*  75 */     super(paramString, paramThrowable);
/*  76 */     this.hresult = null;
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
/*     */   public COMException(String paramString, WinNT.HRESULT paramHRESULT) {
/*  88 */     super(paramString);
/*  89 */     this.hresult = paramHRESULT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT getHresult() {
/*  96 */     return this.hresult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matchesErrorCode(int paramInt) {
/* 105 */     return (this.hresult != null && this.hresult.intValue() == paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\COMException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */