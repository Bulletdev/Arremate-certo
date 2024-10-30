/*     */ package ch.qos.logback.classic.spi;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Arrays;
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
/*     */ public class ThrowableProxyVO
/*     */   implements IThrowableProxy, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -773438177285807139L;
/*     */   private String className;
/*     */   private String message;
/*     */   private int commonFramesCount;
/*     */   private StackTraceElementProxy[] stackTraceElementProxyArray;
/*     */   private IThrowableProxy cause;
/*     */   private IThrowableProxy[] suppressed;
/*     */   
/*     */   public String getMessage() {
/*  31 */     return this.message;
/*     */   }
/*     */   
/*     */   public String getClassName() {
/*  35 */     return this.className;
/*     */   }
/*     */   
/*     */   public int getCommonFrames() {
/*  39 */     return this.commonFramesCount;
/*     */   }
/*     */   
/*     */   public IThrowableProxy getCause() {
/*  43 */     return this.cause;
/*     */   }
/*     */   
/*     */   public StackTraceElementProxy[] getStackTraceElementProxyArray() {
/*  47 */     return this.stackTraceElementProxyArray;
/*     */   }
/*     */   
/*     */   public IThrowableProxy[] getSuppressed() {
/*  51 */     return this.suppressed;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  56 */     byte b = 31;
/*  57 */     int i = 1;
/*  58 */     i = 31 * i + ((this.className == null) ? 0 : this.className.hashCode());
/*  59 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  64 */     if (this == paramObject)
/*  65 */       return true; 
/*  66 */     if (paramObject == null)
/*  67 */       return false; 
/*  68 */     if (getClass() != paramObject.getClass())
/*  69 */       return false; 
/*  70 */     ThrowableProxyVO throwableProxyVO = (ThrowableProxyVO)paramObject;
/*     */     
/*  72 */     if (this.className == null) {
/*  73 */       if (throwableProxyVO.className != null)
/*  74 */         return false; 
/*  75 */     } else if (!this.className.equals(throwableProxyVO.className)) {
/*  76 */       return false;
/*     */     } 
/*  78 */     if (!Arrays.equals((Object[])this.stackTraceElementProxyArray, (Object[])throwableProxyVO.stackTraceElementProxyArray)) {
/*  79 */       return false;
/*     */     }
/*  81 */     if (!Arrays.equals((Object[])this.suppressed, (Object[])throwableProxyVO.suppressed)) {
/*  82 */       return false;
/*     */     }
/*  84 */     if (this.cause == null) {
/*  85 */       if (throwableProxyVO.cause != null)
/*  86 */         return false; 
/*  87 */     } else if (!this.cause.equals(throwableProxyVO.cause)) {
/*  88 */       return false;
/*     */     } 
/*  90 */     return true;
/*     */   }
/*     */   
/*     */   public static ThrowableProxyVO build(IThrowableProxy paramIThrowableProxy) {
/*  94 */     if (paramIThrowableProxy == null) {
/*  95 */       return null;
/*     */     }
/*  97 */     ThrowableProxyVO throwableProxyVO = new ThrowableProxyVO();
/*  98 */     throwableProxyVO.className = paramIThrowableProxy.getClassName();
/*  99 */     throwableProxyVO.message = paramIThrowableProxy.getMessage();
/* 100 */     throwableProxyVO.commonFramesCount = paramIThrowableProxy.getCommonFrames();
/* 101 */     throwableProxyVO.stackTraceElementProxyArray = paramIThrowableProxy.getStackTraceElementProxyArray();
/* 102 */     IThrowableProxy iThrowableProxy = paramIThrowableProxy.getCause();
/* 103 */     if (iThrowableProxy != null) {
/* 104 */       throwableProxyVO.cause = build(iThrowableProxy);
/*     */     }
/* 106 */     IThrowableProxy[] arrayOfIThrowableProxy = paramIThrowableProxy.getSuppressed();
/* 107 */     if (arrayOfIThrowableProxy != null) {
/* 108 */       throwableProxyVO.suppressed = new IThrowableProxy[arrayOfIThrowableProxy.length];
/* 109 */       for (byte b = 0; b < arrayOfIThrowableProxy.length; b++) {
/* 110 */         throwableProxyVO.suppressed[b] = build(arrayOfIThrowableProxy[b]);
/*     */       }
/*     */     } 
/* 113 */     return throwableProxyVO;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\spi\ThrowableProxyVO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */