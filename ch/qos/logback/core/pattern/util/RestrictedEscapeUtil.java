/*    */ package ch.qos.logback.core.pattern.util;
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
/*    */ public class RestrictedEscapeUtil
/*    */   implements IEscapeUtil
/*    */ {
/*    */   public void escape(String paramString, StringBuffer paramStringBuffer, char paramChar, int paramInt) {
/* 24 */     if (paramString.indexOf(paramChar) >= 0) {
/* 25 */       paramStringBuffer.append(paramChar);
/*    */     }
/*    */     else {
/*    */       
/* 29 */       paramStringBuffer.append("\\");
/*    */       
/* 31 */       paramStringBuffer.append(paramChar);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\patter\\util\RestrictedEscapeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */