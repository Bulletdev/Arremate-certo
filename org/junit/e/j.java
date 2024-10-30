/*     */ package org.junit.e;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Array;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import org.junit.c;
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
/*     */ public class j
/*     */   extends e
/*     */ {
/*     */   private final File e;
/*     */   private final boolean dn;
/*     */   private File f;
/*     */   private static final int fU = 10000;
/*     */   private static final String mh = "junit";
/*     */   
/*     */   public j() {
/*  58 */     this((File)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j(File paramFile) {
/*  69 */     this.e = paramFile;
/*  70 */     this.dn = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected j(a parama) {
/*  78 */     this.e = a.a(parama);
/*  79 */     this.dn = a.a(parama);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static a a() {
/*  88 */     return new a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class a
/*     */   {
/*     */     private File e;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean dn;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a a(File param1File) {
/* 110 */       this.e = param1File;
/* 111 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a b() {
/* 122 */       this.dn = true;
/* 123 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public j a() {
/* 130 */       return new j(this);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void iH() throws Throwable {
/* 136 */     hS();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void iI() {
/* 141 */     delete();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hS() throws IOException {
/* 150 */     this.f = a(this.e);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File b(String paramString) throws IOException {
/* 157 */     File file = new File(getRoot(), paramString);
/* 158 */     if (!file.createNewFile()) {
/* 159 */       throw new IOException("a file with the name '" + paramString + "' already exists in the test folder");
/*     */     }
/*     */     
/* 162 */     return file;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File b() throws IOException {
/* 169 */     return File.createTempFile("junit", null, getRoot());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File c(String paramString) throws IOException {
/* 177 */     return a(new String[] { paramString });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File a(String... paramVarArgs) throws IOException {
/* 188 */     if (paramVarArgs.length == 0) {
/* 189 */       throw new IllegalArgumentException("must pass at least one path");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 196 */     File file1 = getRoot();
/* 197 */     for (String str : paramVarArgs) {
/* 198 */       if ((new File(str)).isAbsolute()) {
/* 199 */         throw new IOException("folder path '" + str + "' is not a relative path");
/*     */       }
/*     */     } 
/*     */     
/* 203 */     File file2 = null;
/* 204 */     File file3 = file1;
/* 205 */     boolean bool = true;
/* 206 */     for (String str : paramVarArgs) {
/* 207 */       file2 = new File(file2, str);
/* 208 */       file3 = new File(file1, file2.getPath());
/*     */       
/* 210 */       bool = file3.mkdirs();
/* 211 */       if (!bool && !file3.isDirectory()) {
/* 212 */         if (file3.exists()) {
/* 213 */           throw new IOException("a file with the path '" + file2.getPath() + "' exists");
/*     */         }
/*     */         
/* 216 */         throw new IOException("could not create a folder with the path '" + file2.getPath() + "'");
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 221 */     if (!bool) {
/* 222 */       throw new IOException("a folder with the path '" + file2.getPath() + "' already exists");
/*     */     }
/*     */     
/* 225 */     return file3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File c() throws IOException {
/* 232 */     return a(getRoot());
/*     */   }
/*     */   
/*     */   private static File a(File paramFile) throws IOException {
/*     */     try {
/* 237 */       return b(paramFile);
/* 238 */     } catch (ClassNotFoundException classNotFoundException) {
/*     */       
/* 240 */       return c(paramFile);
/* 241 */     } catch (InvocationTargetException invocationTargetException) {
/* 242 */       Throwable throwable = invocationTargetException.getCause();
/* 243 */       if (throwable instanceof IOException) {
/* 244 */         throw (IOException)throwable;
/*     */       }
/* 246 */       if (throwable instanceof RuntimeException) {
/* 247 */         throw (RuntimeException)throwable;
/*     */       }
/* 249 */       IOException iOException = new IOException("Failed to create temporary folder in " + paramFile);
/* 250 */       iOException.initCause(throwable);
/* 251 */       throw iOException;
/* 252 */     } catch (Exception exception) {
/* 253 */       throw new RuntimeException("Failed to create temporary folder in " + paramFile, exception);
/*     */     } 
/*     */   }
/*     */   private static File b(File paramFile) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
/*     */     Object object2;
/* 258 */     Class<?> clazz1 = Class.forName("java.nio.file.Files");
/* 259 */     Object object1 = Array.newInstance(Class.forName("java.nio.file.attribute.FileAttribute"), 0);
/* 260 */     Class<?> clazz2 = Class.forName("java.nio.file.Path");
/*     */     
/* 262 */     if (paramFile != null) {
/* 263 */       Method method = clazz1.getDeclaredMethod("createTempDirectory", new Class[] { clazz2, String.class, object1.getClass() });
/* 264 */       Object object = File.class.getDeclaredMethod("toPath", new Class[0]).invoke(paramFile, new Object[0]);
/* 265 */       object2 = method.invoke(null, new Object[] { object, "junit", object1 });
/*     */     } else {
/* 267 */       Method method = clazz1.getDeclaredMethod("createTempDirectory", new Class[] { String.class, object1.getClass() });
/* 268 */       object2 = method.invoke(null, new Object[] { "junit", object1 });
/*     */     } 
/* 270 */     return (File)clazz2.getDeclaredMethod("toFile", new Class[0]).invoke(object2, new Object[0]);
/*     */   }
/*     */   
/*     */   private static File c(File paramFile) throws IOException {
/* 274 */     File file = null;
/* 275 */     for (byte b = 0; b < '✐'; b++) {
/*     */       
/* 277 */       String str1 = ".tmp";
/* 278 */       File file1 = File.createTempFile("junit", str1, paramFile);
/* 279 */       String str2 = file1.toString();
/*     */       
/* 281 */       String str3 = str2.substring(0, str2.length() - str1.length());
/* 282 */       file = new File(str3);
/* 283 */       if (file.mkdir()) {
/* 284 */         file1.delete();
/* 285 */         return file;
/*     */       } 
/* 287 */       file1.delete();
/*     */     } 
/* 289 */     throw new IOException("Unable to create temporary directory in: " + paramFile.toString() + ". Tried " + '✐' + " times. " + "Last attempted to create: " + file.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File getRoot() {
/* 298 */     if (this.f == null) {
/* 299 */       throw new IllegalStateException("the temporary folder has not yet been created");
/*     */     }
/*     */     
/* 302 */     return this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void delete() {
/* 313 */     if (!gq() && 
/* 314 */       this.dn) {
/* 315 */       c.fail("Unable to clean up temporary folder " + this.f);
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
/*     */   private boolean gq() {
/* 328 */     if (this.f == null) {
/* 329 */       return true;
/*     */     }
/*     */     
/* 332 */     return b(this.f);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean b(File paramFile) {
/* 338 */     if (paramFile.delete()) {
/* 339 */       return true;
/*     */     }
/* 341 */     File[] arrayOfFile = paramFile.listFiles();
/* 342 */     if (arrayOfFile != null) {
/* 343 */       for (File file : arrayOfFile) {
/* 344 */         if (!b(file)) {
/* 345 */           return false;
/*     */         }
/*     */       } 
/*     */     }
/* 349 */     return paramFile.delete();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\e\j.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */