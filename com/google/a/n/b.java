/*     */ package com.google.a.n;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.E;
/*     */ import com.google.a.b.I;
/*     */ import com.google.a.b.J;
/*     */ import com.google.a.b.e;
/*     */ import com.google.a.d.ap;
/*     */ import com.google.a.d.bW;
/*     */ import com.google.a.d.bh;
/*     */ import com.google.a.d.bj;
/*     */ import com.google.a.d.bt;
/*     */ import com.google.a.d.cF;
/*     */ import com.google.a.d.cG;
/*     */ import com.google.a.d.ca;
/*     */ import com.google.a.d.dj;
/*     */ import com.google.a.j.H;
/*     */ import com.google.a.j.g;
/*     */ import com.google.a.j.k;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URISyntaxException;
/*     */ import java.net.URL;
/*     */ import java.net.URLClassLoader;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Set;
/*     */ import java.util.jar.Attributes;
/*     */ import java.util.jar.JarEntry;
/*     */ import java.util.jar.JarFile;
/*     */ import java.util.jar.Manifest;
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
/*     */ @a
/*     */ public final class b
/*     */ {
/*  79 */   private static final Logger logger = Logger.getLogger(b.class.getName());
/*     */   
/*  81 */   private static final E<a> h = new E<a>()
/*     */     {
/*     */       public boolean a(b.a param1a)
/*     */       {
/*  85 */         return (b.a.a(param1a).indexOf('$') == -1);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*  91 */   private static final I h = I.a(" ").a();
/*     */   
/*     */   private static final String iS = ".class";
/*     */   
/*     */   private final bt<c> h;
/*     */   
/*     */   private b(bt<c> parambt) {
/*  98 */     this.h = parambt;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static b a(ClassLoader paramClassLoader) throws IOException {
/* 118 */     b b1 = new b();
/* 119 */     b1.a(paramClassLoader);
/* 120 */     return new b(b1.u());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public bt<c> u() {
/* 128 */     return this.h;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public bt<a> v() {
/* 137 */     return ap.a((Iterable)this.h).a(a.class).e();
/*     */   }
/*     */ 
/*     */   
/*     */   public bt<a> w() {
/* 142 */     return ap.a((Iterable)this.h).a(a.class).a((E)h).e();
/*     */   }
/*     */ 
/*     */   
/*     */   public bt<a> a(String paramString) {
/* 147 */     D.checkNotNull(paramString);
/* 148 */     bt.a a = bt.a();
/* 149 */     for (dj<a> dj = w().b(); dj.hasNext(); ) { a a1 = dj.next();
/* 150 */       if (a1.getPackageName().equals(paramString)) {
/* 151 */         a.a(a1);
/*     */       } }
/*     */     
/* 154 */     return a.o();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public bt<a> b(String paramString) {
/* 162 */     D.checkNotNull(paramString);
/* 163 */     String str = (new StringBuilder(1 + String.valueOf(paramString).length())).append(paramString).append('.').toString();
/* 164 */     bt.a a = bt.a();
/* 165 */     for (dj<a> dj = w().b(); dj.hasNext(); ) { a a1 = dj.next();
/* 166 */       if (a1.getName().startsWith(str)) {
/* 167 */         a.a(a1);
/*     */       } }
/*     */     
/* 170 */     return a.o();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public static class c
/*     */   {
/*     */     private final File file;
/*     */ 
/*     */     
/*     */     private final String iT;
/*     */     
/*     */     final ClassLoader a;
/*     */ 
/*     */     
/*     */     static c a(File param1File, String param1String, ClassLoader param1ClassLoader) {
/* 187 */       if (param1String.endsWith(".class")) {
/* 188 */         return new b.a(param1File, param1String, param1ClassLoader);
/*     */       }
/* 190 */       return new c(param1File, param1String, param1ClassLoader);
/*     */     }
/*     */ 
/*     */     
/*     */     c(File param1File, String param1String, ClassLoader param1ClassLoader) {
/* 195 */       this.file = (File)D.checkNotNull(param1File);
/* 196 */       this.iT = (String)D.checkNotNull(param1String);
/* 197 */       this.a = (ClassLoader)D.checkNotNull(param1ClassLoader);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final URL url() {
/* 209 */       URL uRL = this.a.getResource(this.iT);
/* 210 */       if (uRL == null) {
/* 211 */         throw new NoSuchElementException(this.iT);
/*     */       }
/* 213 */       return uRL;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final g b() {
/* 224 */       return H.a(url());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final k a(Charset param1Charset) {
/* 236 */       return H.a(url(), param1Charset);
/*     */     }
/*     */ 
/*     */     
/*     */     public final String dr() {
/* 241 */       return this.iT;
/*     */     }
/*     */ 
/*     */     
/*     */     final File getFile() {
/* 246 */       return this.file;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 251 */       return this.iT.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 256 */       if (param1Object instanceof c) {
/* 257 */         c c1 = (c)param1Object;
/* 258 */         return (this.iT.equals(c1.iT) && this.a == c1.a);
/*     */       } 
/* 260 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 266 */       return this.iT;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public static final class a
/*     */     extends c
/*     */   {
/*     */     private final String className;
/*     */ 
/*     */     
/*     */     a(File param1File, String param1String, ClassLoader param1ClassLoader) {
/* 280 */       super(param1File, param1String, param1ClassLoader);
/* 281 */       this.className = b.ax(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getPackageName() {
/* 291 */       return h.getPackageName(this.className);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getSimpleName() {
/* 301 */       int i = this.className.lastIndexOf('$');
/* 302 */       if (i != -1) {
/* 303 */         String str1 = this.className.substring(i + 1);
/*     */ 
/*     */         
/* 306 */         return e.a('0', '9').f(str1);
/*     */       } 
/* 308 */       String str = getPackageName();
/* 309 */       if (str.isEmpty()) {
/* 310 */         return this.className;
/*     */       }
/*     */ 
/*     */       
/* 314 */       return this.className.substring(str.length() + 1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getName() {
/* 324 */       return this.className;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Class<?> d() {
/*     */       try {
/* 335 */         return this.a.loadClass(this.className);
/* 336 */       } catch (ClassNotFoundException classNotFoundException) {
/*     */         
/* 338 */         throw new IllegalStateException(classNotFoundException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 344 */       return this.className;
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
/*     */   static abstract class d
/*     */   {
/* 357 */     private final Set<File> A = cG.t();
/*     */     
/*     */     public final void a(ClassLoader param1ClassLoader) throws IOException {
/* 360 */       for (dj<Map.Entry> dj = a(param1ClassLoader).h().b(); dj.hasNext(); ) { Map.Entry entry = dj.next();
/* 361 */         a((File)entry.getKey(), (ClassLoader)entry.getValue()); }
/*     */     
/*     */     }
/*     */     
/*     */     @com.google.a.a.d
/*     */     final void a(File param1File, ClassLoader param1ClassLoader) throws IOException {
/* 367 */       if (this.A.add(param1File.getCanonicalFile())) {
/* 368 */         b(param1File, param1ClassLoader);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract void a(b.c param1c) throws IOException;
/*     */ 
/*     */ 
/*     */     
/*     */     protected void b(File param1File, ClassLoader param1ClassLoader) throws IOException {
/*     */       try {
/* 380 */         if (!param1File.exists()) {
/*     */           return;
/*     */         }
/* 383 */       } catch (SecurityException securityException) {
/* 384 */         String str1 = String.valueOf(param1File), str2 = String.valueOf(securityException); b.a().warning((new StringBuilder(16 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("Cannot access ").append(str1).append(": ").append(str2).toString());
/*     */         
/*     */         return;
/*     */       } 
/* 388 */       if (param1File.isDirectory()) {
/* 389 */         a(param1ClassLoader, param1File);
/*     */       } else {
/* 391 */         c(param1File, param1ClassLoader);
/*     */       } 
/*     */     }
/*     */     
/*     */     private void c(File param1File, ClassLoader param1ClassLoader) throws IOException {
/*     */       JarFile jarFile;
/*     */       try {
/* 398 */         jarFile = new JarFile(param1File);
/* 399 */       } catch (IOException iOException) {
/*     */         return;
/*     */       } 
/*     */       
/*     */       try {
/* 404 */         for (dj<File> dj = a(param1File, jarFile.getManifest()).b(); dj.hasNext(); ) { File file = dj.next();
/* 405 */           a(file, param1ClassLoader); }
/*     */         
/* 407 */         a(param1ClassLoader, jarFile);
/*     */       } finally {
/*     */         try {
/* 410 */           jarFile.close();
/* 411 */         } catch (IOException iOException) {}
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.a.a.d
/*     */     static bt<File> a(File param1File, Manifest param1Manifest) {
/* 425 */       if (param1Manifest == null) {
/* 426 */         return bt.n();
/*     */       }
/* 428 */       bt.a a = bt.a();
/*     */       
/* 430 */       String str = param1Manifest.getMainAttributes().getValue(Attributes.Name.CLASS_PATH.toString());
/* 431 */       if (str != null) {
/* 432 */         for (String str1 : b.d().a(str)) {
/*     */           URL uRL;
/*     */           try {
/* 435 */             uRL = a(param1File, str1);
/* 436 */           } catch (MalformedURLException malformedURLException) {
/*     */             
/* 438 */             String.valueOf(str1); b.a().warning((String.valueOf(str1).length() != 0) ? "Invalid Class-Path entry: ".concat(String.valueOf(str1)) : new String("Invalid Class-Path entry: "));
/*     */             continue;
/*     */           } 
/* 441 */           if (uRL.getProtocol().equals("file")) {
/* 442 */             a.a(b.toFile(uRL));
/*     */           }
/*     */         } 
/*     */       }
/* 446 */       return a.o();
/*     */     }
/*     */     
/*     */     @com.google.a.a.d
/*     */     static bj<File, ClassLoader> a(ClassLoader param1ClassLoader) {
/* 451 */       LinkedHashMap<File, ClassLoader> linkedHashMap = bW.a();
/*     */       
/* 453 */       ClassLoader classLoader = param1ClassLoader.getParent();
/* 454 */       if (classLoader != null) {
/* 455 */         linkedHashMap.putAll((Map<? extends File, ? extends ClassLoader>)a(classLoader));
/*     */       }
/* 457 */       for (dj<URL> dj = a(param1ClassLoader).b(); dj.hasNext(); ) { URL uRL = dj.next();
/* 458 */         if (uRL.getProtocol().equals("file")) {
/* 459 */           File file = b.toFile(uRL);
/* 460 */           if (!linkedHashMap.containsKey(file)) {
/* 461 */             linkedHashMap.put(file, param1ClassLoader);
/*     */           }
/*     */         }  }
/*     */       
/* 465 */       return bj.a(linkedHashMap);
/*     */     }
/*     */     
/*     */     private static bh<URL> a(ClassLoader param1ClassLoader) {
/* 469 */       if (param1ClassLoader instanceof URLClassLoader) {
/* 470 */         return bh.a((Object[])((URLClassLoader)param1ClassLoader).getURLs());
/*     */       }
/* 472 */       if (param1ClassLoader.equals(ClassLoader.getSystemClassLoader())) {
/* 473 */         return l();
/*     */       }
/* 475 */       return bh.e();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.a.a.d
/*     */     static bh<URL> l() {
/* 484 */       bh.a a = bh.a();
/* 485 */       for (String str : I.a(J.x.value()).a(J.o.value())) {
/*     */         try {
/*     */           try {
/* 488 */             a.a((new File(str)).toURI().toURL());
/* 489 */           } catch (SecurityException securityException) {
/* 490 */             a.a(new URL("file", null, (new File(str)).getAbsolutePath()));
/*     */           } 
/* 492 */         } catch (MalformedURLException malformedURLException) {
/* 493 */           String.valueOf(str); b.a().log(Level.WARNING, (String.valueOf(str).length() != 0) ? "malformed classpath entry: ".concat(String.valueOf(str)) : new String("malformed classpath entry: "), malformedURLException);
/*     */         } 
/*     */       } 
/* 496 */       return a.g();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.a.a.d
/*     */     static URL a(File param1File, String param1String) throws MalformedURLException {
/* 507 */       return new URL(param1File.toURI().toURL(), param1String);
/*     */     }
/*     */     
/*     */     @com.google.a.a.d
/*     */     void a(ClassLoader param1ClassLoader, JarFile param1JarFile) throws IOException {
/* 512 */       Enumeration<JarEntry> enumeration = param1JarFile.entries();
/* 513 */       while (enumeration.hasMoreElements()) {
/* 514 */         JarEntry jarEntry = enumeration.nextElement();
/* 515 */         if (jarEntry.isDirectory() || jarEntry.getName().equals("META-INF/MANIFEST.MF")) {
/*     */           continue;
/*     */         }
/* 518 */         a(b.c.a(new File(param1JarFile.getName()), jarEntry.getName(), param1ClassLoader));
/*     */       } 
/*     */     }
/*     */     
/*     */     private void a(ClassLoader param1ClassLoader, File param1File) throws IOException {
/* 523 */       HashSet<File> hashSet = new HashSet();
/* 524 */       hashSet.add(param1File.getCanonicalFile());
/* 525 */       a(param1File, param1ClassLoader, "", hashSet);
/*     */     }
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
/*     */     private void a(File param1File, ClassLoader param1ClassLoader, String param1String, Set<File> param1Set) throws IOException {
/* 543 */       File[] arrayOfFile = param1File.listFiles();
/* 544 */       if (arrayOfFile == null) {
/* 545 */         String str = String.valueOf(param1File); b.a().warning((new StringBuilder(22 + String.valueOf(str).length())).append("Cannot read directory ").append(str).toString());
/*     */         
/*     */         return;
/*     */       } 
/* 549 */       for (File file : arrayOfFile) {
/* 550 */         String str = file.getName();
/* 551 */         if (file.isDirectory()) {
/* 552 */           File file1 = file.getCanonicalFile();
/* 553 */           if (param1Set.add(file1)) {
/* 554 */             a(file1, param1ClassLoader, (new StringBuilder(1 + String.valueOf(param1String).length() + String.valueOf(str).length())).append(param1String).append(str).append("/").toString(), param1Set);
/* 555 */             param1Set.remove(file1);
/*     */           } 
/*     */         } else {
/* 558 */           String.valueOf(str); String str1 = (String.valueOf(str).length() != 0) ? String.valueOf(param1String).concat(String.valueOf(str)) : new String(String.valueOf(param1String));
/* 559 */           if (!str1.equals("META-INF/MANIFEST.MF"))
/* 560 */             a(b.c.a(file, str1, param1ClassLoader)); 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   @com.google.a.a.d
/*     */   static final class b
/*     */     extends d
/*     */   {
/* 570 */     private final cF<ClassLoader, b.c> a = ca.a().b().c();
/*     */     
/*     */     bt<b.c> u() {
/* 573 */       return bt.a(this.a.values());
/*     */     }
/*     */ 
/*     */     
/*     */     protected void a(b.c param1c) {
/* 578 */       this.a.put(param1c.a, param1c);
/*     */     }
/*     */   }
/*     */   
/*     */   @com.google.a.a.d
/*     */   static String ax(String paramString) {
/* 584 */     int i = paramString.length() - ".class".length();
/* 585 */     return paramString.substring(0, i).replace('/', '.');
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.a.a.d
/*     */   static File toFile(URL paramURL) {
/* 591 */     D.checkArgument(paramURL.getProtocol().equals("file"));
/*     */     try {
/* 593 */       return new File(paramURL.toURI());
/* 594 */     } catch (URISyntaxException uRISyntaxException) {
/* 595 */       return new File(paramURL.getPath());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\n\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */