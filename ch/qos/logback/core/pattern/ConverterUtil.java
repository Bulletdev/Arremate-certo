/*    */ package ch.qos.logback.core.pattern;
/*    */ 
/*    */ import ch.qos.logback.core.Context;
/*    */ import ch.qos.logback.core.spi.ContextAware;
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
/*    */ public class ConverterUtil
/*    */ {
/*    */   public static <E> void startConverters(Converter<E> paramConverter) {
/* 27 */     Converter<E> converter = paramConverter;
/* 28 */     while (converter != null) {
/*    */       
/* 30 */       if (converter instanceof CompositeConverter) {
/* 31 */         CompositeConverter compositeConverter = (CompositeConverter)converter;
/* 32 */         Converter<?> converter1 = compositeConverter.childConverter;
/* 33 */         startConverters(converter1);
/* 34 */         compositeConverter.start();
/* 35 */       } else if (converter instanceof DynamicConverter) {
/* 36 */         DynamicConverter dynamicConverter = (DynamicConverter)converter;
/* 37 */         dynamicConverter.start();
/*    */       } 
/* 39 */       converter = converter.getNext();
/*    */     } 
/*    */   }
/*    */   
/*    */   public static <E> Converter<E> findTail(Converter<E> paramConverter) {
/* 44 */     Converter<E> converter = paramConverter;
/* 45 */     while (converter != null) {
/* 46 */       Converter<E> converter1 = converter.getNext();
/* 47 */       if (converter1 == null) {
/*    */         break;
/*    */       }
/* 50 */       converter = converter1;
/*    */     } 
/*    */     
/* 53 */     return converter;
/*    */   }
/*    */   
/*    */   public static <E> void setContextForConverters(Context paramContext, Converter<E> paramConverter) {
/* 57 */     Converter<E> converter = paramConverter;
/* 58 */     while (converter != null) {
/* 59 */       if (converter instanceof ContextAware) {
/* 60 */         ((ContextAware)converter).setContext(paramContext);
/*    */       }
/* 62 */       converter = converter.getNext();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\pattern\ConverterUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */