/*    */ package ch.qos.logback.classic.pattern;
/*    */ 
/*    */ import ch.qos.logback.classic.spi.IThrowableProxy;
/*    */ import ch.qos.logback.classic.spi.ThrowableProxyUtil;
/*    */ import ch.qos.logback.core.CoreConstants;
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
/*    */ public class RootCauseFirstThrowableProxyConverter
/*    */   extends ExtendedThrowableProxyConverter
/*    */ {
/*    */   protected String throwableProxyToString(IThrowableProxy paramIThrowableProxy) {
/* 28 */     StringBuilder stringBuilder = new StringBuilder(2048);
/* 29 */     recursiveAppendRootCauseFirst(stringBuilder, null, 1, paramIThrowableProxy);
/* 30 */     return stringBuilder.toString();
/*    */   }
/*    */   
/*    */   protected void recursiveAppendRootCauseFirst(StringBuilder paramStringBuilder, String paramString, int paramInt, IThrowableProxy paramIThrowableProxy) {
/* 34 */     if (paramIThrowableProxy.getCause() != null) {
/* 35 */       recursiveAppendRootCauseFirst(paramStringBuilder, paramString, paramInt, paramIThrowableProxy.getCause());
/* 36 */       paramString = null;
/*    */     } 
/* 38 */     ThrowableProxyUtil.indent(paramStringBuilder, paramInt - 1);
/* 39 */     if (paramString != null) {
/* 40 */       paramStringBuilder.append(paramString);
/*    */     }
/* 42 */     ThrowableProxyUtil.subjoinFirstLineRootCauseFirst(paramStringBuilder, paramIThrowableProxy);
/* 43 */     paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/* 44 */     subjoinSTEPArray(paramStringBuilder, paramInt, paramIThrowableProxy);
/* 45 */     IThrowableProxy[] arrayOfIThrowableProxy = paramIThrowableProxy.getSuppressed();
/* 46 */     if (arrayOfIThrowableProxy != null)
/* 47 */       for (IThrowableProxy iThrowableProxy : arrayOfIThrowableProxy)
/* 48 */         recursiveAppendRootCauseFirst(paramStringBuilder, "Suppressed: ", paramInt + 1, iThrowableProxy);  
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\pattern\RootCauseFirstThrowableProxyConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */