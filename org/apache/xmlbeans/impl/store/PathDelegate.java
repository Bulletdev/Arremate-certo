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
/*    */ 
/*    */ 
/*    */ public final class PathDelegate
/*    */ {
/* 26 */   private static HashMap _constructors = new HashMap();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static synchronized void init(String paramString) {
/* 34 */     if (paramString == null)
/* 35 */       paramString = "org.apache.xmlbeans.impl.xpath.saxon.XBeansXPath"; 
/* 36 */     Class clazz = null;
/* 37 */     boolean bool = true;
/*    */     
/*    */     try {
/* 40 */       clazz = Class.forName(paramString);
/*    */     }
/* 42 */     catch (ClassNotFoundException classNotFoundException) {
/*    */       
/* 44 */       bool = false;
/*    */     }
/* 46 */     catch (NoClassDefFoundError noClassDefFoundError) {
/*    */       
/* 48 */       bool = false;
/*    */     } 
/*    */     
/* 51 */     if (bool) {
/*    */       
/*    */       try {
/*    */         
/* 55 */         Constructor constructor = clazz.getConstructor(new Class[] { String.class, String.class, Map.class, String.class });
/*    */         
/* 57 */         _constructors.put(paramString, constructor);
/*    */       }
/* 59 */       catch (Exception exception) {
/*    */         
/* 61 */         throw new RuntimeException(exception);
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static synchronized SelectPathInterface createInstance(String paramString1, String paramString2, String paramString3, Map paramMap) {
/* 69 */     if (_constructors.get(paramString1) == null) {
/* 70 */       init(paramString1);
/*    */     }
/* 72 */     if (_constructors.get(paramString1) == null) {
/* 73 */       return null;
/*    */     }
/* 75 */     Constructor constructor = (Constructor)_constructors.get(paramString1);
/*    */     
/*    */     try {
/* 78 */       Object object = paramMap.get("$xmlbeans!default_uri");
/* 79 */       if (object != null)
/* 80 */         paramMap.remove("$xmlbeans!default_uri"); 
/* 81 */       return constructor.newInstance(new Object[] { paramString2, paramString3, paramMap, object });
/*    */     
/*    */     }
/* 84 */     catch (Exception exception) {
/*    */       
/* 86 */       throw new RuntimeException(exception);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static interface SelectPathInterface {
/*    */     List selectPath(Object param1Object);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\store\PathDelegate.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */