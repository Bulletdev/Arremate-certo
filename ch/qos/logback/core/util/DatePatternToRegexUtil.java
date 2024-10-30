/*    */ package ch.qos.logback.core.util;
/*    */ 
/*    */ import java.util.ArrayList;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DatePatternToRegexUtil
/*    */ {
/*    */   final String datePattern;
/*    */   final int datePatternLength;
/* 30 */   final b regexMapper = new b();
/*    */   
/*    */   public DatePatternToRegexUtil(String paramString) {
/* 33 */     this.datePattern = paramString;
/* 34 */     this.datePatternLength = paramString.length();
/*    */   }
/*    */   
/*    */   public String toRegex() {
/* 38 */     List<a> list = tokenize();
/* 39 */     StringBuilder stringBuilder = new StringBuilder();
/* 40 */     for (a a : list) {
/* 41 */       stringBuilder.append(this.regexMapper.a(a));
/*    */     }
/* 43 */     return stringBuilder.toString();
/*    */   }
/*    */   
/*    */   private List<a> tokenize() {
/* 47 */     ArrayList<a> arrayList = new ArrayList();
/*    */     
/* 49 */     a a = null;
/*    */     
/* 51 */     for (byte b1 = 0; b1 < this.datePatternLength; b1++) {
/* 52 */       char c = this.datePattern.charAt(b1);
/* 53 */       if (a == null || a.a != c) {
/* 54 */         a = new a(c);
/* 55 */         arrayList.add(a);
/*    */       } else {
/* 57 */         a.ew();
/*    */       } 
/*    */     } 
/* 60 */     return arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\cor\\util\DatePatternToRegexUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */