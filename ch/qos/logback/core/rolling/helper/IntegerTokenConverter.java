/*    */ package ch.qos.logback.core.rolling.helper;
/*    */ 
/*    */ import ch.qos.logback.core.pattern.DynamicConverter;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IntegerTokenConverter
/*    */   extends DynamicConverter<Object>
/*    */   implements MonoTypedConverter
/*    */ {
/*    */   public static final String CONVERTER_KEY = "i";
/*    */   
/*    */   public String convert(int paramInt) {
/* 30 */     String str = Integer.toString(paramInt);
/* 31 */     FormatInfo formatInfo = getFormattingInfo();
/* 32 */     if (formatInfo == null) {
/* 33 */       return str;
/*    */     }
/* 35 */     int i = formatInfo.getMin();
/* 36 */     StringBuilder stringBuilder = new StringBuilder();
/* 37 */     for (int j = str.length(); j < i; j++) {
/* 38 */       stringBuilder.append('0');
/*    */     }
/* 40 */     return stringBuilder.append(str).toString();
/*    */   }
/*    */   
/*    */   public String convert(Object paramObject) {
/* 44 */     if (paramObject == null) {
/* 45 */       throw new IllegalArgumentException("Null argument forbidden");
/*    */     }
/* 47 */     if (paramObject instanceof Integer) {
/* 48 */       Integer integer = (Integer)paramObject;
/* 49 */       return convert(integer.intValue());
/*    */     } 
/* 51 */     throw new IllegalArgumentException("Cannot convert " + paramObject + " of type" + paramObject.getClass().getName());
/*    */   }
/*    */   
/*    */   public boolean isApplicable(Object paramObject) {
/* 55 */     return paramObject instanceof Integer;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\rolling\helper\IntegerTokenConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */