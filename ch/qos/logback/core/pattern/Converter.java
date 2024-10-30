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
/*    */ public abstract class Converter<E>
/*    */ {
/*    */   Converter<E> next;
/*    */   
/*    */   public abstract String convert(E paramE);
/*    */   
/*    */   public void write(StringBuilder paramStringBuilder, E paramE) {
/* 42 */     paramStringBuilder.append(convert(paramE));
/*    */   }
/*    */   
/*    */   public final void setNext(Converter<E> paramConverter) {
/* 46 */     if (this.next != null) {
/* 47 */       throw new IllegalStateException("Next converter has been already set");
/*    */     }
/* 49 */     this.next = paramConverter;
/*    */   }
/*    */   
/*    */   public final Converter<E> getNext() {
/* 53 */     return this.next;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\pattern\Converter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */