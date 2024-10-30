/*    */ package ch.qos.logback.classic.html;
/*    */ 
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
/*    */ public class UrlCssBuilder
/*    */   implements CssBuilder
/*    */ {
/* 27 */   String url = "http://logback.qos.ch/css/classic.css";
/*    */   
/*    */   public String getUrl() {
/* 30 */     return this.url;
/*    */   }
/*    */   
/*    */   public void setUrl(String paramString) {
/* 34 */     this.url = paramString;
/*    */   }
/*    */   
/*    */   public void addCss(StringBuilder paramStringBuilder) {
/* 38 */     paramStringBuilder.append("<link REL=StyleSheet HREF=\"");
/* 39 */     paramStringBuilder.append(this.url);
/* 40 */     paramStringBuilder.append("\" TITLE=\"Basic\" />");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\html\UrlCssBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */