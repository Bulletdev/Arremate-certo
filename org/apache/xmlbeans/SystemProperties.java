/*    */ package org.apache.xmlbeans;
/*    */ 
/*    */ import java.util.Hashtable;
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
/*    */ public class SystemProperties
/*    */ {
/*    */   protected static Hashtable propertyH;
/*    */   
/*    */   public static String getProperty(String paramString) {
/* 27 */     if (propertyH == null) {
/*    */       try {
/* 29 */         propertyH = System.getProperties();
/* 30 */       } catch (SecurityException securityException) {
/* 31 */         propertyH = new Hashtable();
/* 32 */         return null;
/*    */       } 
/*    */     }
/* 35 */     return (String)propertyH.get(paramString);
/*    */   }
/*    */   
/*    */   public static String getProperty(String paramString1, String paramString2) {
/* 39 */     String str = getProperty(paramString1);
/* 40 */     if (str == null)
/* 41 */       return paramString2; 
/* 42 */     return str;
/*    */   }
/*    */   
/*    */   public static void setPropertyH(Hashtable paramHashtable) {
/* 46 */     propertyH = paramHashtable;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\SystemProperties.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */