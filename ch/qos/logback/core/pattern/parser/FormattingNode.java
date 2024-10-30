/*    */ package ch.qos.logback.core.pattern.parser;
/*    */ 
/*    */ import ch.qos.logback.core.pattern.FormatInfo;
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
/*    */ public class FormattingNode
/*    */   extends Node
/*    */ {
/*    */   FormatInfo formatInfo;
/*    */   
/*    */   FormattingNode(int paramInt) {
/* 23 */     super(paramInt);
/*    */   }
/*    */   
/*    */   FormattingNode(int paramInt, Object paramObject) {
/* 27 */     super(paramInt, paramObject);
/*    */   }
/*    */   
/*    */   public FormatInfo getFormatInfo() {
/* 31 */     return this.formatInfo;
/*    */   }
/*    */   
/*    */   public void setFormatInfo(FormatInfo paramFormatInfo) {
/* 35 */     this.formatInfo = paramFormatInfo;
/*    */   }
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 39 */     if (!super.equals(paramObject)) {
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     if (!(paramObject instanceof FormattingNode)) {
/* 44 */       return false;
/*    */     }
/* 46 */     FormattingNode formattingNode = (FormattingNode)paramObject;
/*    */     
/* 48 */     return (this.formatInfo != null) ? this.formatInfo.equals(formattingNode.formatInfo) : ((formattingNode.formatInfo == null));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 53 */     int i = super.hashCode();
/* 54 */     i = 31 * i + ((this.formatInfo != null) ? this.formatInfo.hashCode() : 0);
/* 55 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\pattern\parser\FormattingNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */