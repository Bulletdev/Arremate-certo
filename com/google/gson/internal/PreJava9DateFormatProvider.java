/*    */ package com.google.gson.internal;
/*    */ 
/*    */ import java.text.DateFormat;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Locale;
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
/*    */ public class PreJava9DateFormatProvider
/*    */ {
/*    */   public static DateFormat getUSDateFormat(int paramInt) {
/* 31 */     return new SimpleDateFormat(getDateFormatPattern(paramInt), Locale.US);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static DateFormat getUSDateTimeFormat(int paramInt1, int paramInt2) {
/* 39 */     String str = getDatePartOfDateTimePattern(paramInt1) + " " + getTimePartOfDateTimePattern(paramInt2);
/* 40 */     return new SimpleDateFormat(str, Locale.US);
/*    */   }
/*    */   
/*    */   private static String getDateFormatPattern(int paramInt) {
/* 44 */     switch (paramInt) {
/*    */       case 3:
/* 46 */         return "M/d/yy";
/*    */       case 2:
/* 48 */         return "MMM d, y";
/*    */       case 1:
/* 50 */         return "MMMM d, y";
/*    */       case 0:
/* 52 */         return "EEEE, MMMM d, y";
/*    */     } 
/* 54 */     throw new IllegalArgumentException("Unknown DateFormat style: " + paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   private static String getDatePartOfDateTimePattern(int paramInt) {
/* 59 */     switch (paramInt) {
/*    */       case 3:
/* 61 */         return "M/d/yy";
/*    */       case 2:
/* 63 */         return "MMM d, yyyy";
/*    */       case 1:
/* 65 */         return "MMMM d, yyyy";
/*    */       case 0:
/* 67 */         return "EEEE, MMMM d, yyyy";
/*    */     } 
/* 69 */     throw new IllegalArgumentException("Unknown DateFormat style: " + paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   private static String getTimePartOfDateTimePattern(int paramInt) {
/* 74 */     switch (paramInt) {
/*    */       case 3:
/* 76 */         return "h:mm a";
/*    */       case 2:
/* 78 */         return "h:mm:ss a";
/*    */       case 0:
/*    */       case 1:
/* 81 */         return "h:mm:ss a z";
/*    */     } 
/* 83 */     throw new IllegalArgumentException("Unknown DateFormat style: " + paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\PreJava9DateFormatProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */