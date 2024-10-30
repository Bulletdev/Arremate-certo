/*    */ package ch.qos.logback.core.rolling.helper;
/*    */ 
/*    */ import ch.qos.logback.core.rolling.RolloverFailure;
/*    */ import java.io.File;
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
/*    */ public class FileStoreUtil
/*    */ {
/*    */   static final String PATH_CLASS_STR = "java.nio.file.Path";
/*    */   static final String FILES_CLASS_STR = "java.nio.file.Files";
/*    */   
/*    */   public static boolean areOnSameFileStore(File paramFile1, File paramFile2) throws RolloverFailure {
/* 41 */     if (!paramFile1.exists()) {
/* 42 */       throw new IllegalArgumentException("File [" + paramFile1 + "] does not exist.");
/*    */     }
/* 44 */     if (!paramFile2.exists()) {
/* 45 */       throw new IllegalArgumentException("File [" + paramFile2 + "] does not exist.");
/*    */     }
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
/*    */     try {
/* 58 */       Class<?> clazz1 = Class.forName("java.nio.file.Path");
/* 59 */       Class<?> clazz2 = Class.forName("java.nio.file.Files");
/*    */       
/* 61 */       Method method1 = File.class.getMethod("toPath", new Class[0]);
/* 62 */       Method method2 = clazz2.getMethod("getFileStore", new Class[] { clazz1 });
/*    */       
/* 64 */       Object object1 = method1.invoke(paramFile1, new Object[0]);
/* 65 */       Object object2 = method1.invoke(paramFile2, new Object[0]);
/*    */       
/* 67 */       Object object3 = method2.invoke(null, new Object[] { object1 });
/* 68 */       Object object4 = method2.invoke(null, new Object[] { object2 });
/* 69 */       return object3.equals(object4);
/* 70 */     } catch (Exception exception) {
/* 71 */       throw new RolloverFailure("Failed to check file store equality for [" + paramFile1 + "] and [" + paramFile2 + "]", exception);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\rolling\helper\FileStoreUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */