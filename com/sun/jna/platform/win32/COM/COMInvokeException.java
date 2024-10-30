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
/*     */ public class COMInvokeException
/*     */   extends COMException
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final Integer wCode;
/*     */   private final String source;
/*     */   private final String description;
/*     */   private final String helpFile;
/*     */   private final Integer helpContext;
/*     */   private final Integer scode;
/*     */   private final Integer errorArg;
/*     */   
/*     */   public COMInvokeException() {
/*  47 */     this("", (Throwable)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public COMInvokeException(String paramString) {
/*  57 */     this(paramString, (Throwable)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public COMInvokeException(Throwable paramThrowable) {
/*  68 */     this(null, paramThrowable);
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
/*     */   public COMInvokeException(String paramString, Throwable paramThrowable) {
/*  80 */     super(paramString, paramThrowable);
/*  81 */     this.description = null;
/*  82 */     this.errorArg = null;
/*  83 */     this.helpContext = null;
/*  84 */     this.helpFile = null;
/*  85 */     this.scode = null;
/*  86 */     this.source = null;
/*  87 */     this.wCode = null;
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
/*     */   public COMInvokeException(String paramString1, WinNT.HRESULT paramHRESULT, Integer paramInteger1, String paramString2, Integer paramInteger2, String paramString3, Integer paramInteger3, String paramString4, Integer paramInteger4) {
/* 114 */     super(formatMessage(paramHRESULT, paramString1, paramInteger1), paramHRESULT);
/* 115 */     this.description = paramString2;
/* 116 */     this.errorArg = paramInteger1;
/* 117 */     this.helpContext = paramInteger2;
/* 118 */     this.helpFile = paramString3;
/* 119 */     this.scode = paramInteger3;
/* 120 */     this.source = paramString4;
/* 121 */     this.wCode = paramInteger4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getErrorArg() {
/* 130 */     return this.errorArg;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getWCode() {
/* 139 */     return this.wCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSource() {
/* 148 */     return this.source;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 156 */     return this.description;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHelpFile() {
/* 164 */     return this.helpFile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getHelpContext() {
/* 171 */     return this.helpContext;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getScode() {
/* 180 */     return this.scode;
/*     */   }
/*     */   
/*     */   private static String formatMessage(WinNT.HRESULT paramHRESULT, String paramString, Integer paramInteger) {
/* 184 */     if (paramHRESULT.intValue() == -2147352571 || paramHRESULT
/* 185 */       .intValue() == -2147352572) {
/* 186 */       return paramString + " (puArgErr=" + paramInteger + ")";
/*     */     }
/* 188 */     return paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\COMInvokeException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */