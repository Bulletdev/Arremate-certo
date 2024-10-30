/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.LastErrorException;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
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
/*     */ public class Win32Exception
/*     */   extends LastErrorException
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private WinNT.HRESULT _hr;
/*     */   
/*     */   public WinNT.HRESULT getHR() {
/*  48 */     return this._hr;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Win32Exception(int paramInt) {
/*  56 */     this(paramInt, W32Errors.HRESULT_FROM_WIN32(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Win32Exception(WinNT.HRESULT paramHRESULT) {
/*  65 */     this(W32Errors.HRESULT_CODE(paramHRESULT.intValue()), paramHRESULT);
/*     */   }
/*     */   
/*     */   protected Win32Exception(int paramInt, WinNT.HRESULT paramHRESULT) {
/*  69 */     this(paramInt, paramHRESULT, Kernel32Util.formatMessage(paramHRESULT));
/*     */   }
/*     */   
/*     */   protected Win32Exception(int paramInt, WinNT.HRESULT paramHRESULT, String paramString) {
/*  73 */     super(paramInt, paramString);
/*  74 */     this._hr = paramHRESULT;
/*     */   }
/*     */   
/*  77 */   private static Method addSuppressedMethod = null;
/*     */   static {
/*     */     try {
/*  80 */       addSuppressedMethod = Throwable.class.getMethod("addSuppressed", new Class[] { Throwable.class });
/*  81 */     } catch (NoSuchMethodException noSuchMethodException) {
/*     */     
/*  83 */     } catch (SecurityException securityException) {
/*  84 */       Logger.getLogger(Win32Exception.class.getName()).log(Level.SEVERE, "Failed to initialize 'addSuppressed' method", securityException);
/*     */     } 
/*     */   }
/*     */   
/*     */   void addSuppressedReflected(Throwable paramThrowable) {
/*  89 */     if (addSuppressedMethod == null) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/*  94 */       addSuppressedMethod.invoke(this, new Object[] { paramThrowable });
/*  95 */     } catch (IllegalAccessException illegalAccessException) {
/*  96 */       throw new RuntimeException("Failed to call addSuppressedMethod", illegalAccessException);
/*  97 */     } catch (IllegalArgumentException illegalArgumentException) {
/*  98 */       throw new RuntimeException("Failed to call addSuppressedMethod", illegalArgumentException);
/*  99 */     } catch (InvocationTargetException invocationTargetException) {
/* 100 */       throw new RuntimeException("Failed to call addSuppressedMethod", invocationTargetException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Win32Exception.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */