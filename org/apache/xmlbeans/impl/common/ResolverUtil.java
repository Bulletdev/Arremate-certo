/*    */ package org.apache.xmlbeans.impl.common;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.lang.reflect.Method;
/*    */ import org.apache.xmlbeans.SystemProperties;
/*    */ import org.xml.sax.EntityResolver;
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
/*    */ public class ResolverUtil
/*    */ {
/* 30 */   private static EntityResolver _entityResolver = null;
/*    */ 
/*    */ 
/*    */   
/*    */   static {
/*    */     try {
/* 36 */       String str = SystemProperties.getProperty("xmlbean.entityResolver");
/* 37 */       if (str != null) {
/* 38 */         Object object = Class.forName(str).newInstance();
/* 39 */         _entityResolver = (EntityResolver)object;
/*    */       }
/*    */     
/* 42 */     } catch (Exception exception) {
/*    */       
/* 44 */       _entityResolver = null;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static EntityResolver getGlobalEntityResolver() {
/* 50 */     return _entityResolver;
/*    */   }
/*    */ 
/*    */   
/*    */   public static EntityResolver resolverForCatalog(String paramString) {
/* 55 */     if (paramString == null) {
/* 56 */       return null;
/*    */     }
/*    */     
/*    */     try {
/* 60 */       Class clazz1 = Class.forName("org.apache.xml.resolver.CatalogManager");
/* 61 */       Constructor constructor1 = clazz1.getConstructor(new Class[0]);
/* 62 */       Object object1 = constructor1.newInstance(new Object[0]);
/* 63 */       Method method = clazz1.getMethod("setCatalogFiles", new Class[] { String.class });
/* 64 */       method.invoke(object1, (Object[])new String[] { paramString });
/*    */       
/* 66 */       Class clazz2 = Class.forName("org.apache.xml.resolver.tools.CatalogResolver");
/* 67 */       Constructor constructor2 = clazz2.getConstructor(new Class[] { clazz1 });
/* 68 */       Object object2 = constructor2.newInstance(new Object[] { object1 });
/*    */       
/* 70 */       return (EntityResolver)object2;
/*    */     }
/* 72 */     catch (Exception exception) {
/*    */       
/* 74 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\ResolverUtil.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */