/*     */ package org.c.a.b.o.b;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.URL;
/*     */ import java.net.URLClassLoader;
/*     */ import java.net.URLDecoder;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ import java.util.jar.JarFile;
/*     */ import java.util.regex.Pattern;
/*     */ import org.c.a.a.f.a;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.b.n.b.a;
/*     */ import org.c.a.b.o.b.a.a;
/*     */ import org.c.a.b.o.b.a.b;
/*     */ import org.c.a.b.r.d;
/*     */ import org.c.a.b.r.g;
/*     */ import org.c.a.b.r.p;
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
/*     */ public class b
/*     */   implements h
/*     */ {
/*  51 */   private static final a a = c.b(b.class);
/*     */ 
/*     */   
/*     */   private final ClassLoader classLoader;
/*     */ 
/*     */   
/*     */   private final org.c.a.a.b a;
/*     */   
/*  59 */   private final Set<org.c.a.b.n.b> H = new TreeSet<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  64 */   private final Map<org.c.a.a.b, List<URL>> as = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  69 */   private final Map<String, a> at = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  74 */   private final Map<a, Map<URL, Set<String>>> au = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b(ClassLoader paramClassLoader, Charset paramCharset, org.c.a.a.b paramb) {
/*  82 */     this.classLoader = paramClassLoader;
/*  83 */     this.a = paramb;
/*     */     
/*  85 */     a.debug("Scanning for classpath resources at '" + paramb + "' ...");
/*  86 */     for (String str : K()) {
/*  87 */       this.H.add(new a(paramb, str, paramClassLoader, paramCharset));
/*  88 */       a.debug("Found resource: " + str);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<org.c.a.b.n.b> i() {
/*  94 */     return this.H;
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<Class<?>> j() {
/*  99 */     a.debug("Scanning for classes at " + this.a);
/*     */     
/* 101 */     ArrayList<Class<?>> arrayList = new ArrayList();
/*     */     
/* 103 */     for (org.c.a.b.n.b b1 : this.H) {
/* 104 */       if (b1.eI().endsWith(".class")) {
/* 105 */         Class<?> clazz = d.a(bd(b1.eI()), this.classLoader);
/* 106 */         if (clazz != null) {
/* 107 */           arrayList.add(clazz);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 112 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String bd(String paramString) {
/* 122 */     String str = paramString.replace("/", ".");
/* 123 */     return str.substring(0, str.length() - ".class".length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Set<String> K() {
/* 133 */     TreeSet<String> treeSet = new TreeSet();
/*     */     
/* 135 */     List<URL> list = a(this.a);
/* 136 */     for (URL uRL1 : list) {
/* 137 */       a.debug("Scanning URL: " + uRL1.toExternalForm());
/*     */       
/* 139 */       i i = a(uRL1.getProtocol());
/* 140 */       URL uRL2 = i.a(uRL1);
/*     */       
/* 142 */       String str = uRL2.getProtocol();
/* 143 */       a a1 = a(str);
/* 144 */       if (a1 == null) {
/* 145 */         String str1 = p.b(uRL2);
/* 146 */         a.warn("Unable to scan location: " + str1 + " (unsupported protocol: " + str + ")"); continue;
/*     */       } 
/* 148 */       Set<String> set = (Set)((Map)this.au.get(a1)).get(uRL2);
/* 149 */       if (set == null) {
/* 150 */         set = a1.a(this.a.getPath(), uRL2);
/* 151 */         ((Map<URL, Set<String>>)this.au.get(a1)).put(uRL2, set);
/*     */       } 
/* 153 */       treeSet.addAll(set);
/*     */     } 
/*     */ 
/*     */     
/* 157 */     boolean bool = !list.isEmpty() ? true : false;
/*     */     
/* 159 */     if (!bool)
/*     */     {
/* 161 */       if (this.classLoader instanceof URLClassLoader) {
/* 162 */         URLClassLoader uRLClassLoader = (URLClassLoader)this.classLoader;
/* 163 */         for (URL uRL : uRLClassLoader.getURLs()) {
/* 164 */           if ("file".equals(uRL.getProtocol()) && uRL
/* 165 */             .getPath().endsWith(".jar") && 
/* 166 */             !uRL.getPath().matches(".*" + Pattern.quote("/jre/lib/") + ".*")) {
/*     */             JarFile jarFile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             try {
/*     */             
/* 176 */             } catch (IOException iOException) {
/*     */ 
/*     */             
/* 179 */             } catch (SecurityException securityException) {}
/*     */           } 
/*     */         } 
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
/* 205 */     if (!bool) {
/* 206 */       a.warn("Unable to resolve location " + this.a);
/*     */     }
/*     */     
/* 209 */     return treeSet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<URL> a(org.c.a.a.b paramb) {
/* 219 */     if (this.as.containsKey(paramb)) {
/* 220 */       return this.as.get(paramb);
/*     */     }
/*     */     
/* 223 */     a.debug("Determining location urls for " + paramb + " using ClassLoader " + this.classLoader + " ...");
/*     */     
/* 225 */     ArrayList<URL> arrayList = new ArrayList();
/*     */     
/* 227 */     if (this.classLoader.getClass().getName().startsWith("com.ibm")) {
/*     */ 
/*     */       
/*     */       try {
/* 231 */         Enumeration<URL> enumeration = this.classLoader.getResources(paramb.getPath() + "/flyway.location");
/* 232 */         if (!enumeration.hasMoreElements()) {
/* 233 */           a.warn("Unable to resolve location " + paramb + " (ClassLoader: " + this.classLoader + ") On WebSphere an empty file named flyway.location must be present on the classpath location for WebSphere to find it!");
/*     */         }
/*     */         
/* 236 */         while (enumeration.hasMoreElements()) {
/* 237 */           URL uRL = enumeration.nextElement();
/* 238 */           arrayList.add(new URL(URLDecoder.decode(uRL.toExternalForm(), "UTF-8").replace("/flyway.location", "")));
/*     */         } 
/* 240 */       } catch (IOException iOException) {
/* 241 */         a.warn("Unable to resolve location " + paramb + " (ClassLoader: " + this.classLoader + ") On WebSphere an empty file named flyway.location must be present on the classpath location for WebSphere to find it!");
/*     */       } 
/*     */     } else {
/*     */ 
/*     */       
/*     */       try {
/* 247 */         Enumeration<URL> enumeration = this.classLoader.getResources(paramb.getPath());
/* 248 */         while (enumeration.hasMoreElements()) {
/* 249 */           arrayList.add(enumeration.nextElement());
/*     */         }
/* 251 */       } catch (IOException iOException) {
/* 252 */         a.warn("Unable to resolve location " + paramb + " (ClassLoader: " + this.classLoader + "): " + iOException.getMessage());
/*     */       } 
/*     */     } 
/*     */     
/* 256 */     this.as.put(paramb, arrayList);
/*     */     
/* 258 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private i a(String paramString) {
/* 268 */     if ((new g(this.classLoader)).ga() && paramString.startsWith("vfs")) {
/* 269 */       return (i)new a();
/*     */     }
/*     */     
/* 272 */     return new c();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a a(String paramString) {
/* 282 */     if (this.at.containsKey(paramString)) {
/* 283 */       return this.at.get(paramString);
/*     */     }
/*     */     
/* 286 */     if ("file".equals(paramString)) {
/* 287 */       d d = new d();
/* 288 */       this.at.put(paramString, d);
/* 289 */       this.au.put(d, new HashMap<>());
/* 290 */       return d;
/*     */     } 
/*     */     
/* 293 */     if ("jar".equals(paramString) || V(paramString) || U(paramString) || T(paramString)) {
/* 294 */       String str = V(paramString) ? "*/" : "!/";
/* 295 */       e e = new e(str);
/* 296 */       this.at.put(paramString, e);
/* 297 */       this.au.put(e, new HashMap<>());
/* 298 */       return e;
/*     */     } 
/*     */     
/* 301 */     g g = new g(this.classLoader);
/* 302 */     if (g.gb() && "vfs".equals(paramString)) {
/* 303 */       b b1 = new b();
/* 304 */       this.at.put(paramString, b1);
/* 305 */       this.au.put(b1, new HashMap<>());
/* 306 */       return (a)b1;
/*     */     } 
/* 308 */     if (g.gc() && (S(paramString) || R(paramString))) {
/* 309 */       g g1 = new g();
/* 310 */       this.at.put(paramString, g1);
/* 311 */       this.au.put(g1, new HashMap<>());
/* 312 */       return g1;
/*     */     } 
/*     */     
/* 315 */     return null;
/*     */   }
/*     */   
/*     */   private boolean R(String paramString) {
/* 319 */     return "bundleresource".equals(paramString);
/*     */   }
/*     */   
/*     */   private boolean S(String paramString) {
/* 323 */     return "bundle".equals(paramString);
/*     */   }
/*     */   
/*     */   private boolean T(String paramString) {
/* 327 */     return "wsjar".equals(paramString);
/*     */   }
/*     */   
/*     */   private boolean U(String paramString) {
/* 331 */     return "zip".equals(paramString);
/*     */   }
/*     */   
/*     */   private boolean V(String paramString) {
/* 335 */     return "war".equals(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\o\b\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */