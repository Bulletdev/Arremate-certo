/*    */ package org.e;
/*    */ 
/*    */ import java.util.Enumeration;
/*    */ import java.util.Properties;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class r
/*    */ {
/*    */   public static i a(Properties paramProperties) throws g {
/* 45 */     i i = new i();
/* 46 */     if (paramProperties != null && !paramProperties.isEmpty()) {
/* 47 */       Enumeration<?> enumeration = paramProperties.propertyNames();
/* 48 */       while (enumeration.hasMoreElements()) {
/* 49 */         String str = (String)enumeration.nextElement();
/* 50 */         i.c(str, paramProperties.getProperty(str));
/*    */       } 
/*    */     } 
/* 53 */     return i;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Properties a(i parami) throws g {
/* 63 */     Properties properties = new Properties();
/* 64 */     if (parami != null)
/*    */     {
/* 66 */       for (String str : parami.keySet()) {
/* 67 */         Object object = parami.d(str);
/* 68 */         if (!i.NULL.equals(object)) {
/* 69 */           properties.put(str, object.toString());
/*    */         }
/*    */       } 
/*    */     }
/* 73 */     return properties;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\e\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */