/*    */ package ch.qos.logback.core.pattern.color;
/*    */ 
/*    */ import ch.qos.logback.core.pattern.CompositeConverter;
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
/*    */ public abstract class ForegroundCompositeConverterBase<E>
/*    */   extends CompositeConverter<E>
/*    */ {
/*    */   private static final String SET_DEFAULT_COLOR = "\033[0;39m";
/*    */   
/*    */   protected String transform(E paramE, String paramString) {
/* 31 */     StringBuilder stringBuilder = new StringBuilder();
/* 32 */     stringBuilder.append("\033[");
/* 33 */     stringBuilder.append(getForegroundColorCode(paramE));
/* 34 */     stringBuilder.append("m");
/* 35 */     stringBuilder.append(paramString);
/* 36 */     stringBuilder.append("\033[0;39m");
/* 37 */     return stringBuilder.toString();
/*    */   }
/*    */   
/*    */   protected abstract String getForegroundColorCode(E paramE);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\pattern\color\ForegroundCompositeConverterBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */