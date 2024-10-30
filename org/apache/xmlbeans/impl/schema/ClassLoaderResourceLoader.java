/*    */ package org.apache.xmlbeans.impl.schema;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ import org.apache.xmlbeans.ResourceLoader;
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
/*    */ public class ClassLoaderResourceLoader
/*    */   implements ResourceLoader
/*    */ {
/*    */   ClassLoader _classLoader;
/*    */   
/*    */   public ClassLoaderResourceLoader(ClassLoader paramClassLoader) {
/* 28 */     this._classLoader = paramClassLoader;
/*    */   }
/*    */ 
/*    */   
/*    */   public InputStream getResourceAsStream(String paramString) {
/* 33 */     return this._classLoader.getResourceAsStream(paramString);
/*    */   }
/*    */   
/*    */   public void close() {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\ClassLoaderResourceLoader.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */