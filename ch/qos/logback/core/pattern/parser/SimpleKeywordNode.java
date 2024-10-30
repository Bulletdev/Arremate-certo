/*    */ package ch.qos.logback.core.pattern.parser;
/*    */ 
/*    */ import java.util.List;
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
/*    */ public class SimpleKeywordNode
/*    */   extends FormattingNode
/*    */ {
/*    */   List<String> optionList;
/*    */   
/*    */   SimpleKeywordNode(Object paramObject) {
/* 23 */     super(1, paramObject);
/*    */   }
/*    */   
/*    */   protected SimpleKeywordNode(int paramInt, Object paramObject) {
/* 27 */     super(paramInt, paramObject);
/*    */   }
/*    */   
/*    */   public List<String> getOptions() {
/* 31 */     return this.optionList;
/*    */   }
/*    */   
/*    */   public void setOptions(List<String> paramList) {
/* 35 */     this.optionList = paramList;
/*    */   }
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 39 */     if (!super.equals(paramObject)) {
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     if (!(paramObject instanceof SimpleKeywordNode)) {
/* 44 */       return false;
/*    */     }
/* 46 */     SimpleKeywordNode simpleKeywordNode = (SimpleKeywordNode)paramObject;
/*    */     
/* 48 */     return (this.optionList != null) ? this.optionList.equals(simpleKeywordNode.optionList) : ((simpleKeywordNode.optionList == null));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 53 */     return super.hashCode();
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder stringBuilder = new StringBuilder();
/* 58 */     if (this.optionList == null) {
/* 59 */       stringBuilder.append("KeyWord(" + this.value + "," + this.formatInfo + ")");
/*    */     } else {
/* 61 */       stringBuilder.append("KeyWord(" + this.value + ", " + this.formatInfo + "," + this.optionList + ")");
/*    */     } 
/* 63 */     stringBuilder.append(printNext());
/* 64 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\pattern\parser\SimpleKeywordNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */