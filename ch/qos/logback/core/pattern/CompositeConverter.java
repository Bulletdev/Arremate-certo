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
/*    */ public abstract class CompositeConverter<E>
/*    */   extends DynamicConverter<E>
/*    */ {
/*    */   Converter<E> childConverter;
/*    */   
/*    */   public String convert(E paramE) {
/* 21 */     StringBuilder stringBuilder = new StringBuilder();
/*    */     
/* 23 */     for (Converter<E> converter = this.childConverter; converter != null; converter = converter.next) {
/* 24 */       converter.write(stringBuilder, paramE);
/*    */     }
/* 26 */     String str = stringBuilder.toString();
/* 27 */     return transform(paramE, str);
/*    */   }
/*    */   
/*    */   protected abstract String transform(E paramE, String paramString);
/*    */   
/*    */   public Converter<E> getChildConverter() {
/* 33 */     return this.childConverter;
/*    */   }
/*    */   
/*    */   public void setChildConverter(Converter<E> paramConverter) {
/* 37 */     this.childConverter = paramConverter;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 41 */     StringBuilder stringBuilder = new StringBuilder();
/* 42 */     stringBuilder.append("CompositeConverter<");
/*    */     
/* 44 */     if (this.formattingInfo != null) {
/* 45 */       stringBuilder.append(this.formattingInfo);
/*    */     }
/* 47 */     if (this.childConverter != null) {
/* 48 */       stringBuilder.append(", children: ").append(this.childConverter);
/*    */     }
/* 50 */     stringBuilder.append(">");
/* 51 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\pattern\CompositeConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */