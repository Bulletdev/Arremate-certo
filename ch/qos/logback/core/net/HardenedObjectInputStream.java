/*     */ package ch.qos.logback.core.net;
/*     */ 
/*     */ import ch.qos.logback.core.util.EnvUtil;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InvalidClassException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectStreamClass;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ public class HardenedObjectInputStream
/*     */   extends ObjectInputStream
/*     */ {
/*     */   final List<String> whitelistedClassNames;
/*  41 */   static final String[] JAVA_PACKAGES = new String[] { "java.lang", "java.util" };
/*     */   private static final int DEPTH_LIMIT = 16;
/*     */   private static final int ARRAY_LIMIT = 10000;
/*     */   
/*     */   public HardenedObjectInputStream(InputStream paramInputStream, String[] paramArrayOfString) throws IOException {
/*  46 */     super(paramInputStream);
/*  47 */     initObjectFilter();
/*  48 */     this.whitelistedClassNames = new ArrayList<String>();
/*  49 */     if (paramArrayOfString != null) {
/*  50 */       for (byte b = 0; b < paramArrayOfString.length; b++) {
/*  51 */         this.whitelistedClassNames.add(paramArrayOfString[b]);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public HardenedObjectInputStream(InputStream paramInputStream, List<String> paramList) throws IOException {
/*  57 */     super(paramInputStream);
/*  58 */     initObjectFilter();
/*  59 */     this.whitelistedClassNames = new ArrayList<String>();
/*  60 */     this.whitelistedClassNames.addAll(paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initObjectFilter() {
/*  69 */     if (EnvUtil.isJDK9OrHigher()) {
/*     */       try {
/*  71 */         ClassLoader classLoader = getClass().getClassLoader();
/*     */         
/*  73 */         Class<?> clazz1 = classLoader.loadClass("java.io.ObjectInputFilter");
/*  74 */         Class<?> clazz2 = classLoader.loadClass("java.io.ObjectInputFilter$Config");
/*  75 */         Method method1 = getClass().getMethod("setObjectInputFilter", new Class[] { clazz1 });
/*     */         
/*  77 */         Method method2 = clazz2.getMethod("createFilter", new Class[] { String.class });
/*  78 */         Object object = method2.invoke(null, new Object[] { "maxarray=10000;maxdepth=16;" });
/*  79 */         method1.invoke(this, new Object[] { object });
/*  80 */       } catch (ClassNotFoundException classNotFoundException) {
/*     */         
/*  82 */         throw new RuntimeException("Failed to initialize object filter", classNotFoundException);
/*  83 */       } catch (InvocationTargetException invocationTargetException) {
/*     */         
/*  85 */         throw new RuntimeException("Failed to initialize object filter", invocationTargetException);
/*  86 */       } catch (NoSuchMethodException noSuchMethodException) {
/*     */         
/*  88 */         throw new RuntimeException("Failed to initialize object filter", noSuchMethodException);
/*  89 */       } catch (IllegalAccessException illegalAccessException) {
/*     */         
/*  91 */         throw new RuntimeException("Failed to initialize object filter", illegalAccessException);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected Class<?> resolveClass(ObjectStreamClass paramObjectStreamClass) throws IOException, ClassNotFoundException {
/*  98 */     String str = paramObjectStreamClass.getName();
/*     */     
/* 100 */     if (!isWhitelisted(str)) {
/* 101 */       throw new InvalidClassException("Unauthorized deserialization attempt", paramObjectStreamClass.getName());
/*     */     }
/*     */     
/* 104 */     return super.resolveClass(paramObjectStreamClass);
/*     */   }
/*     */   
/*     */   private boolean isWhitelisted(String paramString) {
/* 108 */     for (byte b = 0; b < JAVA_PACKAGES.length; b++) {
/* 109 */       if (paramString.startsWith(JAVA_PACKAGES[b]))
/* 110 */         return true; 
/*     */     } 
/* 112 */     for (String str : this.whitelistedClassNames) {
/* 113 */       if (paramString.equals(str))
/* 114 */         return true; 
/*     */     } 
/* 116 */     return false;
/*     */   }
/*     */   
/*     */   protected void addToWhitelist(List<String> paramList) {
/* 120 */     this.whitelistedClassNames.addAll(paramList);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\net\HardenedObjectInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */