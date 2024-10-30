/*     */ package org.apache.xmlbeans.impl.common;
/*     */ 
/*     */ import java.lang.ref.SoftReference;
/*     */ import org.apache.xmlbeans.SchemaTypeLoader;
/*     */ import org.apache.xmlbeans.SystemProperties;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SystemCache
/*     */ {
/*  37 */   private static SystemCache INSTANCE = new SystemCache();
/*     */ 
/*     */   
/*     */   static {
/*  41 */     String str = SystemProperties.getProperty("xmlbean.systemcacheimpl");
/*  42 */     Object object = null;
/*  43 */     if (str != null) {
/*     */       
/*     */       try {
/*     */         
/*  47 */         object = Class.forName(str).newInstance();
/*  48 */         if (!(object instanceof SystemCache)) {
/*  49 */           throw new ClassCastException("Value for system property \"xmlbean.systemcacheimpl\" points to a class (" + str + ") which does not derive from SystemCache");
/*     */         
/*     */         }
/*     */       }
/*  53 */       catch (ClassNotFoundException classNotFoundException) {
/*     */         
/*  55 */         throw new RuntimeException("Cache class " + str + " specified by \"xmlbean.systemcacheimpl\" was not found.", classNotFoundException);
/*     */ 
/*     */       
/*     */       }
/*  59 */       catch (InstantiationException instantiationException) {
/*     */         
/*  61 */         throw new RuntimeException("Could not instantiate class " + str + " as specified by \"xmlbean.systemcacheimpl\"." + " An empty constructor may be missing.", instantiationException);
/*     */ 
/*     */       
/*     */       }
/*  65 */       catch (IllegalAccessException illegalAccessException) {
/*     */         
/*  67 */         throw new RuntimeException("Could not instantiate class " + str + " as specified by \"xmlbean.systemcacheimpl\"." + " A public empty constructor may be missing.", illegalAccessException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*  72 */     if (object != null) {
/*  73 */       INSTANCE = (SystemCache)object;
/*     */     }
/*     */   }
/*     */   
/*     */   public static final synchronized void set(SystemCache paramSystemCache) {
/*  78 */     INSTANCE = paramSystemCache;
/*     */   }
/*     */ 
/*     */   
/*     */   public static final SystemCache get() {
/*  83 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaTypeLoader getFromTypeLoaderCache(ClassLoader paramClassLoader) {
/*  88 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addToTypeLoaderCache(SchemaTypeLoader paramSchemaTypeLoader, ClassLoader paramClassLoader) {}
/*     */ 
/*     */   
/*  96 */   private ThreadLocal tl_saxLoaders = new ThreadLocal();
/*     */ 
/*     */   
/*     */   public Object getSaxLoader() {
/* 100 */     SoftReference softReference = this.tl_saxLoaders.get();
/* 101 */     if (softReference == null) {
/* 102 */       return null;
/*     */     }
/* 104 */     return softReference.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSaxLoader(Object paramObject) {
/* 109 */     this.tl_saxLoaders.set(new SoftReference(paramObject));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\SystemCache.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */