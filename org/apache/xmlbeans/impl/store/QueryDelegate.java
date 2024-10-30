/*    */ package org.apache.xmlbeans.impl.store;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
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
/*    */ public final class QueryDelegate
/*    */ {
/* 24 */   private static HashMap _constructors = new HashMap();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static synchronized void init(String paramString) {
/* 32 */     if (paramString == null)
/* 33 */       paramString = "org.apache.xmlbeans.impl.xquery.saxon.XBeansXQuery"; 
/* 34 */     Class clazz = null;
/* 35 */     boolean bool = true;
/*    */     
/*    */     try {
/* 38 */       clazz = Class.forName(paramString);
/*    */     }
/* 40 */     catch (ClassNotFoundException classNotFoundException) {
/*    */       
/* 42 */       bool = false;
/*    */     }
/* 44 */     catch (NoClassDefFoundError noClassDefFoundError) {
/*    */       
/* 46 */       bool = false;
/*    */     } 
/*    */     
/* 49 */     if (bool) {
/*    */       
/*    */       try {
/*    */         
/* 53 */         Constructor constructor = clazz.getConstructor(new Class[] { String.class, String.class, Integer.class });
/*    */         
/* 55 */         _constructors.put(paramString, constructor);
/*    */       }
/* 57 */       catch (Exception exception) {
/*    */         
/* 59 */         throw new RuntimeException(exception);
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static synchronized QueryInterface createInstance(String paramString1, String paramString2, String paramString3, int paramInt) {
/* 67 */     if (_constructors.get(paramString1) == null) {
/* 68 */       init(paramString1);
/*    */     }
/* 70 */     if (_constructors.get(paramString1) == null) {
/* 71 */       return null;
/*    */     }
/* 73 */     Constructor constructor = (Constructor)_constructors.get(paramString1);
/*    */     
/*    */     try {
/* 76 */       return constructor.newInstance(new Object[] { paramString2, paramString3, new Integer(paramInt) });
/*    */     
/*    */     }
/* 79 */     catch (Exception exception) {
/*    */       
/* 81 */       throw new RuntimeException(exception);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static interface QueryInterface {
/*    */     List execQuery(Object param1Object, Map param1Map);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\store\QueryDelegate.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */