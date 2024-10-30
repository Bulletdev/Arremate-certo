/*    */ package org.c.a.b.r;
/*    */ 
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import java.util.GregorianCalendar;
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
/*    */ public class e
/*    */ {
/*    */   public static String a(Date paramDate) {
/* 41 */     if (paramDate == null) {
/* 42 */       return "";
/*    */     }
/* 44 */     return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(paramDate);
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
/*    */   public static Date a(int paramInt1, int paramInt2, int paramInt3) {
/* 56 */     return (new GregorianCalendar(paramInt1, paramInt2 - 1, paramInt3)).getTime();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String b(Date paramDate) {
/* 66 */     GregorianCalendar gregorianCalendar = new GregorianCalendar();
/* 67 */     gregorianCalendar.setTime(paramDate);
/* 68 */     String str1 = "" + gregorianCalendar.get(1);
/* 69 */     String str2 = n.d("" + (gregorianCalendar.get(2) + 1), 2, '0');
/* 70 */     String str3 = n.d("" + gregorianCalendar.get(5), 2, '0');
/* 71 */     return str1 + "-" + str2 + "-" + str3;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\r\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */