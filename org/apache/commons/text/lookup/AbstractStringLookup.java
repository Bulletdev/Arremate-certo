/*    */ package org.apache.commons.text.lookup;
/*    */ 
/*    */ import org.apache.commons.lang3.StringUtils;
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
/*    */ abstract class AbstractStringLookup
/*    */   implements StringLookup
/*    */ {
/*    */   protected static final char SPLIT_CH = ':';
/* 37 */   protected static final String SPLIT_STR = String.valueOf(':');
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static String toLookupKey(String paramString1, String paramString2) {
/* 43 */     return toLookupKey(paramString1, SPLIT_STR, paramString2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static String toLookupKey(String paramString1, String paramString2, String paramString3) {
/* 50 */     return paramString1 + paramString2 + paramString3;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   protected String substringAfter(String paramString, char paramChar) {
/* 63 */     return StringUtils.substringAfter(paramString, paramChar);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   protected String substringAfter(String paramString1, String paramString2) {
/* 76 */     return StringUtils.substringAfter(paramString1, paramString2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   protected String substringAfterLast(String paramString, char paramChar) {
/* 89 */     return StringUtils.substringAfterLast(paramString, paramChar);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\lookup\AbstractStringLookup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */