/*    */ package org.apache.xmlbeans.impl.jam.internal.javadoc;
/*    */ 
/*    */ import com.sun.javadoc.RootDoc;
/*    */ import java.lang.reflect.Method;
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
/*    */ public class JavadocResults
/*    */ {
/* 37 */   private static final JavadocResults INSTANCE = new JavadocResults();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 42 */   private ThreadLocal mRootsPerThread = new ThreadLocal();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void prepare() {
/* 48 */     Thread.currentThread().setContextClassLoader(JavadocResults.class.getClassLoader());
/*    */   }
/*    */ 
/*    */   
/*    */   public static void setRoot(RootDoc paramRootDoc) {
/*    */     try {
/* 54 */       Object object = getHolder();
/* 55 */       Method method = object.getClass().getMethod("_setRoot", new Class[] { RootDoc.class });
/*    */       
/* 57 */       method.invoke(object, new Object[] { paramRootDoc });
/* 58 */     } catch (Exception exception) {
/* 59 */       exception.printStackTrace();
/* 60 */       throw new IllegalStateException();
/*    */     } 
/*    */   }
/*    */   
/*    */   public static RootDoc getRoot() {
/*    */     try {
/* 66 */       Object object = getHolder();
/* 67 */       Method method = object.getClass().getMethod("_getRoot", new Class[0]);
/* 68 */       return (RootDoc)method.invoke(object, (Object[])null);
/* 69 */     } catch (Exception exception) {
/* 70 */       exception.printStackTrace();
/* 71 */       throw new IllegalStateException();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void _setRoot(RootDoc paramRootDoc) {
/* 78 */     this.mRootsPerThread.set(paramRootDoc);
/*    */   } public RootDoc _getRoot() {
/* 80 */     return this.mRootsPerThread.get();
/*    */   } public static JavadocResults getInstance() {
/* 82 */     return INSTANCE;
/*    */   }
/*    */   private static Object getHolder() throws Exception {
/* 85 */     ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
/* 86 */     Class clazz = classLoader.loadClass(JavadocResults.class.getName());
/* 87 */     Method method = clazz.getMethod("getInstance", new Class[0]);
/* 88 */     return method.invoke(null, new Object[0]);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\javadoc\JavadocResults.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */