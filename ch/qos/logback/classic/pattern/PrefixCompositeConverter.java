/*    */ package ch.qos.logback.classic.pattern;
/*    */ 
/*    */ import ch.qos.logback.classic.PatternLayout;
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*    */ import ch.qos.logback.core.pattern.CompositeConverter;
/*    */ import ch.qos.logback.core.pattern.Converter;
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
/*    */ public class PrefixCompositeConverter
/*    */   extends CompositeConverter<ILoggingEvent>
/*    */ {
/*    */   public String convert(ILoggingEvent paramILoggingEvent) {
/* 24 */     StringBuilder stringBuilder = new StringBuilder();
/* 25 */     Converter converter1 = getChildConverter();
/*    */     
/* 27 */     for (Converter converter2 = converter1; converter2 != null; converter2 = converter2.getNext()) {
/* 28 */       if (converter2 instanceof MDCConverter) {
/* 29 */         MDCConverter mDCConverter = (MDCConverter)converter2;
/*    */         
/* 31 */         String str = mDCConverter.getKey();
/* 32 */         if (str != null) {
/* 33 */           stringBuilder.append(str).append("=");
/*    */         }
/* 35 */       } else if (converter2 instanceof PropertyConverter) {
/* 36 */         PropertyConverter propertyConverter = (PropertyConverter)converter2;
/* 37 */         String str = propertyConverter.getKey();
/* 38 */         if (str != null) {
/* 39 */           stringBuilder.append(str).append("=");
/*    */         }
/*    */       } else {
/* 42 */         String str1 = converter2.getClass().getName();
/*    */         
/* 44 */         String str2 = (String)PatternLayout.CONVERTER_CLASS_TO_KEY_MAP.get(str1);
/* 45 */         if (str2 != null)
/* 46 */           stringBuilder.append(str2).append("="); 
/*    */       } 
/* 48 */       stringBuilder.append(converter2.convert(paramILoggingEvent));
/*    */     } 
/* 50 */     return stringBuilder.toString();
/*    */   }
/*    */   
/*    */   protected String transform(ILoggingEvent paramILoggingEvent, String paramString) {
/* 54 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\pattern\PrefixCompositeConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */