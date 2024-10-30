/*     */ package com.google.a.b;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import java.io.Closeable;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.lang.ref.PhantomReference;
/*     */ import java.lang.ref.Reference;
/*     */ import java.lang.ref.ReferenceQueue;
/*     */ import java.lang.reflect.Method;
/*     */ import java.net.URL;
/*     */ import java.net.URLClassLoader;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
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
/*     */ @c
/*     */ public class p
/*     */   implements Closeable
/*     */ {
/* 133 */   private static final Logger logger = Logger.getLogger(p.class.getName());
/*     */ 
/*     */   
/*     */   private static final String gw = "com.google.common.base.internal.Finalizer";
/*     */   
/*     */   private static final Method a;
/*     */ 
/*     */   
/*     */   static {
/* 142 */     Class<?> clazz = a(new c[] { new d(), new a(), new b() });
/* 143 */     a = (PhantomReference<Object>)a(clazz);
/*     */   }
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
/* 157 */   final ReferenceQueue<Object> queue = new ReferenceQueue();
/* 158 */   final PhantomReference<Object> a = new PhantomReference(this, this.queue); public p() {
/* 159 */     boolean bool = false;
/*     */     try {
/* 161 */       a.invoke(null, new Object[] { o.class, this.queue, this.a });
/* 162 */       bool = true;
/* 163 */     } catch (IllegalAccessException illegalAccessException) {
/* 164 */       throw new AssertionError(illegalAccessException);
/* 165 */     } catch (Throwable throwable) {
/* 166 */       logger.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", throwable);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 173 */     this.au = bool;
/*     */   }
/*     */   final boolean au;
/*     */   
/*     */   public void close() {
/* 178 */     this.a.enqueue();
/* 179 */     ey();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void ey() {
/* 188 */     if (this.au) {
/*     */       return;
/*     */     }
/*     */     
/*     */     Reference<?> reference;
/* 193 */     while ((reference = this.queue.poll()) != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 198 */       reference.clear();
/*     */       try {
/* 200 */         ((o)reference).ex();
/* 201 */       } catch (Throwable throwable) {
/* 202 */         logger.log(Level.SEVERE, "Error cleaning up after reference.", throwable);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Class<?> a(c... paramVarArgs) {
/* 213 */     for (c c1 : paramVarArgs) {
/* 214 */       Class<?> clazz = c1.a();
/* 215 */       if (clazz != null) {
/* 216 */         return clazz;
/*     */       }
/*     */     } 
/*     */     
/* 220 */     throw new AssertionError();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static interface c
/*     */   {
/*     */     Class<?> a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class d
/*     */     implements c
/*     */   {
/*     */     @com.google.a.a.d
/*     */     static boolean av;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Class<?> a() {
/*     */       ClassLoader classLoader;
/* 246 */       if (av) {
/* 247 */         return null;
/*     */       }
/*     */       
/*     */       try {
/* 251 */         classLoader = ClassLoader.getSystemClassLoader();
/* 252 */       } catch (SecurityException securityException) {
/* 253 */         p.logger.info("Not allowed to access system class loader.");
/* 254 */         return null;
/*     */       } 
/* 256 */       if (classLoader != null) {
/*     */         try {
/* 258 */           return classLoader.loadClass("com.google.common.base.internal.Finalizer");
/* 259 */         } catch (ClassNotFoundException classNotFoundException) {
/*     */           
/* 261 */           return null;
/*     */         } 
/*     */       }
/* 264 */       return null;
/*     */     }
/*     */   }
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
/*     */   static class a
/*     */     implements c
/*     */   {
/*     */     private static final String gx = "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.";
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
/*     */     public Class<?> a() {
/*     */       try {
/* 293 */         URLClassLoader uRLClassLoader = a(a());
/* 294 */         return uRLClassLoader.loadClass("com.google.common.base.internal.Finalizer");
/* 295 */       } catch (Exception exception) {
/* 296 */         p.logger.log(Level.WARNING, "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.", exception);
/* 297 */         return null;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     URL a() throws IOException {
/* 304 */       String str1 = String.valueOf("com.google.common.base.internal.Finalizer".replace('.', '/')).concat(".class");
/* 305 */       URL uRL = getClass().getClassLoader().getResource(str1);
/* 306 */       if (uRL == null) {
/* 307 */         throw new FileNotFoundException(str1);
/*     */       }
/*     */ 
/*     */       
/* 311 */       String str2 = uRL.toString();
/* 312 */       if (!str2.endsWith(str1)) {
/* 313 */         String.valueOf(str2); throw new IOException((String.valueOf(str2).length() != 0) ? "Unsupported path style: ".concat(String.valueOf(str2)) : new String("Unsupported path style: "));
/*     */       } 
/* 315 */       str2 = str2.substring(0, str2.length() - str1.length());
/* 316 */       return new URL(uRL, str2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     URLClassLoader a(URL param1URL) {
/* 324 */       return new URLClassLoader(new URL[] { param1URL }, null);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class b
/*     */     implements c
/*     */   {
/*     */     public Class<?> a() {
/*     */       try {
/* 336 */         return Class.forName("com.google.a.b.a.a");
/* 337 */       } catch (ClassNotFoundException classNotFoundException) {
/* 338 */         throw new AssertionError(classNotFoundException);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static Method a(Class<?> paramClass) {
/*     */     try {
/* 346 */       return paramClass.getMethod("startFinalizer", new Class[] { Class.class, ReferenceQueue.class, PhantomReference.class });
/*     */     }
/* 348 */     catch (NoSuchMethodException noSuchMethodException) {
/* 349 */       throw new AssertionError(noSuchMethodException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\b\p.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */