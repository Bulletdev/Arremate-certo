/*    */ package org.h2.value;
/*    */ 
/*    */ import org.h2.engine.SysProperties;
/*    */ import org.h2.util.StringUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ValueStringFixed
/*    */   extends ValueString
/*    */ {
/* 16 */   private static final ValueStringFixed EMPTY = new ValueStringFixed("");
/*    */   
/*    */   protected ValueStringFixed(String paramString) {
/* 19 */     super(paramString);
/*    */   }
/*    */   
/*    */   private static String trimRight(String paramString) {
/* 23 */     int i = paramString.length() - 1;
/* 24 */     int j = i;
/* 25 */     while (j >= 0 && paramString.charAt(j) == ' ') {
/* 26 */       j--;
/*    */     }
/* 28 */     paramString = (j == i) ? paramString : paramString.substring(0, j + 1);
/* 29 */     return paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 34 */     return 21;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ValueStringFixed get(String paramString) {
/* 45 */     paramString = trimRight(paramString);
/* 46 */     if (paramString.length() == 0) {
/* 47 */       return EMPTY;
/*    */     }
/* 49 */     ValueStringFixed valueStringFixed = new ValueStringFixed(StringUtils.cache(paramString));
/* 50 */     if (paramString.length() > SysProperties.OBJECT_CACHE_MAX_PER_ELEMENT_SIZE) {
/* 51 */       return valueStringFixed;
/*    */     }
/* 53 */     return (ValueStringFixed)Value.cache(valueStringFixed);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ValueString getNew(String paramString) {
/* 58 */     return get(paramString);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\ValueStringFixed.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */