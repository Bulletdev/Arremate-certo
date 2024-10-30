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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AsIsEscapeUtil
/*    */   implements IEscapeUtil
/*    */ {
/*    */   public void escape(String paramString, StringBuffer paramStringBuffer, char paramChar, int paramInt) {
/* 30 */     paramStringBuffer.append("\\");
/*    */     
/* 32 */     paramStringBuffer.append(paramChar);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\patter\\util\AsIsEscapeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */