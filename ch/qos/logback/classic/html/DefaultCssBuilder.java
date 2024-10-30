/*    */ package ch.qos.logback.classic.html;
/*    */ 
/*    */ import ch.qos.logback.core.CoreConstants;
/*    */ import ch.qos.logback.core.html.CssBuilder;
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
/*    */ public class DefaultCssBuilder
/*    */   implements CssBuilder
/*    */ {
/*    */   public void addCss(StringBuilder paramStringBuilder) {
/* 30 */     paramStringBuilder.append("<style  type=\"text/css\">");
/* 31 */     paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/* 32 */     paramStringBuilder.append("table { margin-left: 2em; margin-right: 2em; border-left: 2px solid #AAA; }");
/* 33 */     paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*    */     
/* 35 */     paramStringBuilder.append("TR.even { background: #FFFFFF; }");
/* 36 */     paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*    */     
/* 38 */     paramStringBuilder.append("TR.odd { background: #EAEAEA; }");
/* 39 */     paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*    */     
/* 41 */     paramStringBuilder.append("TR.warn TD.Level, TR.error TD.Level, TR.fatal TD.Level {font-weight: bold; color: #FF4040 }");
/* 42 */     paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*    */     
/* 44 */     paramStringBuilder.append("TD { padding-right: 1ex; padding-left: 1ex; border-right: 2px solid #AAA; }");
/* 45 */     paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*    */     
/* 47 */     paramStringBuilder.append("TD.Time, TD.Date { text-align: right; font-family: courier, monospace; font-size: smaller; }");
/* 48 */     paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*    */     
/* 50 */     paramStringBuilder.append("TD.Thread { text-align: left; }");
/* 51 */     paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*    */     
/* 53 */     paramStringBuilder.append("TD.Level { text-align: right; }");
/* 54 */     paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*    */     
/* 56 */     paramStringBuilder.append("TD.Logger { text-align: left; }");
/* 57 */     paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*    */     
/* 59 */     paramStringBuilder.append("TR.header { background: #596ED5; color: #FFF; font-weight: bold; font-size: larger; }");
/* 60 */     paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*    */     
/* 62 */     paramStringBuilder.append("TD.Exception { background: #A2AEE8; font-family: courier, monospace;}");
/* 63 */     paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*    */     
/* 65 */     paramStringBuilder.append("</style>");
/* 66 */     paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\html\DefaultCssBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */