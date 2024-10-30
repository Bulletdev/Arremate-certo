/*    */ package ch.qos.logback.core.pattern;
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
/*    */ public final class LiteralConverter<E>
/*    */   extends Converter<E>
/*    */ {
/*    */   String literal;
/*    */   
/*    */   public LiteralConverter(String paramString) {
/* 21 */     this.literal = paramString;
/*    */   }
/*    */   
/*    */   public String convert(E paramE) {
/* 25 */     return this.literal;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\pattern\LiteralConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */