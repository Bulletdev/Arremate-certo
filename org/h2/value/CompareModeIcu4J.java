/*    */ package org.h2.value;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ import java.util.Comparator;
/*    */ import java.util.Locale;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.util.JdbcUtils;
/*    */ import org.h2.util.StringUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CompareModeIcu4J
/*    */   extends CompareMode
/*    */ {
/*    */   private final Comparator<String> collator;
/*    */   
/*    */   protected CompareModeIcu4J(String paramString, int paramInt, boolean paramBoolean) {
/* 24 */     super(paramString, paramInt, paramBoolean);
/* 25 */     this.collator = getIcu4jCollator(paramString, paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareString(String paramString1, String paramString2, boolean paramBoolean) {
/* 30 */     if (paramBoolean) {
/* 31 */       paramString1 = paramString1.toUpperCase();
/* 32 */       paramString2 = paramString2.toUpperCase();
/*    */     } 
/* 34 */     return this.collator.compare(paramString1, paramString2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equalsChars(String paramString1, int paramInt1, String paramString2, int paramInt2, boolean paramBoolean) {
/* 40 */     return (compareString(paramString1.substring(paramInt1, paramInt1 + 1), paramString2.substring(paramInt2, paramInt2 + 1), paramBoolean) == 0);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static Comparator<String> getIcu4jCollator(String paramString, int paramInt) {
/*    */     try {
/* 47 */       Comparator<String> comparator = null;
/* 48 */       Class clazz = JdbcUtils.loadUserClass("com.ibm.icu.text.Collator");
/*    */       
/* 50 */       Method method = clazz.getMethod("getInstance", new Class[] { Locale.class });
/*    */       
/* 52 */       if (paramString.length() == 2) {
/* 53 */         Locale locale = new Locale(StringUtils.toLowerEnglish(paramString), "");
/* 54 */         if (compareLocaleNames(locale, paramString)) {
/* 55 */           comparator = (Comparator)method.invoke(null, new Object[] { locale });
/*    */         }
/* 57 */       } else if (paramString.length() == 5) {
/*    */         
/* 59 */         int i = paramString.indexOf('_');
/* 60 */         if (i >= 0) {
/* 61 */           String str1 = StringUtils.toLowerEnglish(paramString.substring(0, i));
/* 62 */           String str2 = paramString.substring(i + 1);
/* 63 */           Locale locale = new Locale(str1, str2);
/* 64 */           if (compareLocaleNames(locale, paramString)) {
/* 65 */             comparator = (Comparator)method.invoke(null, new Object[] { locale });
/*    */           }
/*    */         } 
/*    */       } 
/* 69 */       if (comparator == null) {
/* 70 */         for (Locale locale : (Locale[])clazz.getMethod("getAvailableLocales", new Class[0]).invoke(null, new Object[0])) {
/*    */           
/* 72 */           if (compareLocaleNames(locale, paramString)) {
/* 73 */             comparator = (Comparator)method.invoke(null, new Object[] { locale });
/*    */             break;
/*    */           } 
/*    */         } 
/*    */       }
/* 78 */       if (comparator == null) {
/* 79 */         throw DbException.getInvalidValueException("collator", paramString);
/*    */       }
/* 81 */       clazz.getMethod("setStrength", new Class[] { int.class }).invoke(comparator, new Object[] { Integer.valueOf(paramInt) });
/* 82 */       return comparator;
/* 83 */     } catch (Exception exception) {
/* 84 */       throw DbException.convert(exception);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\CompareModeIcu4J.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */