/*     */ package org.junit.runner;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.concurrent.ConcurrentLinkedQueue;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
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
/*     */ public class c
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  33 */   private static final Pattern F = Pattern.compile("([\\s\\S]*)\\((.*)\\)");
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
/*     */   public static c a(String paramString, Annotation... paramVarArgs) {
/*  45 */     return new c(null, paramString, paramVarArgs);
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
/*     */   public static c a(String paramString, Serializable paramSerializable, Annotation... paramVarArgs) {
/*  58 */     return new c(null, paramString, paramSerializable, paramVarArgs);
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
/*     */   public static c a(String paramString1, String paramString2, Annotation... paramVarArgs) {
/*  73 */     return new c(null, o(paramString2, paramString1), paramVarArgs);
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
/*     */   public static c a(Class<?> paramClass, String paramString, Annotation... paramVarArgs) {
/*  86 */     return new c(paramClass, o(paramString, paramClass.getName()), paramVarArgs);
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
/*     */   public static c a(Class<?> paramClass, String paramString) {
/*  99 */     return new c(paramClass, o(paramString, paramClass.getName()), new Annotation[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static c a(String paramString1, String paramString2, Serializable paramSerializable) {
/* 110 */     return new c(null, o(paramString2, paramString1), paramSerializable, new Annotation[0]);
/*     */   }
/*     */   
/*     */   private static String o(String paramString1, String paramString2) {
/* 114 */     return String.format("%s(%s)", new Object[] { paramString1, paramString2 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static c a(Class<?> paramClass) {
/* 124 */     return new c(paramClass, paramClass.getName(), paramClass.getAnnotations());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static c a(Class<?> paramClass, Annotation... paramVarArgs) {
/* 135 */     return new c(paramClass, paramClass.getName(), paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 141 */   public static final c d = new c(null, "No Tests", new Annotation[0]);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 148 */   public static final c e = new c(null, "Test mechanism", new Annotation[0]);
/*     */   
/*     */   private final Collection<c> m;
/*     */   
/*     */   private final String mi;
/*     */   private final Serializable b;
/*     */   private final Annotation[] b;
/* 155 */   private volatile Class<?> m = (Class<?>)new ConcurrentLinkedQueue();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private c(Class<?> paramClass, String paramString, Annotation... paramVarArgs) {
/* 162 */     this(paramClass, paramString, paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   private c(Class<?> paramClass, String paramString, Serializable paramSerializable, Annotation... paramVarArgs) {
/* 166 */     if (paramString == null || paramString.length() == 0) {
/* 167 */       throw new IllegalArgumentException("The display name must not be empty.");
/*     */     }
/*     */     
/* 170 */     if (paramSerializable == null) {
/* 171 */       throw new IllegalArgumentException("The unique id must not be null.");
/*     */     }
/*     */     
/* 174 */     this.m = paramClass;
/* 175 */     this.mi = paramString;
/* 176 */     this.b = (Annotation[])paramSerializable;
/* 177 */     this.b = paramVarArgs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDisplayName() {
/* 184 */     return this.mi;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void g(c paramc) {
/* 193 */     this.m.add(paramc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<c> getChildren() {
/* 201 */     return new ArrayList((Collection<?>)this.m);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean gs() {
/* 208 */     return !gt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean gt() {
/* 215 */     return this.m.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int bg() {
/* 222 */     if (gt()) {
/* 223 */       return 1;
/*     */     }
/* 225 */     int i = 0;
/* 226 */     for (c c1 : this.m) {
/* 227 */       i += c1.bg();
/*     */     }
/* 229 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 234 */     return this.b.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 239 */     if (!(paramObject instanceof c)) {
/* 240 */       return false;
/*     */     }
/* 242 */     c c1 = (c)paramObject;
/* 243 */     return this.b.equals(c1.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 248 */     return getDisplayName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 255 */     return equals(d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public c c() {
/* 263 */     return new c(this.m, this.mi, this.b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends Annotation> T getAnnotation(Class<T> paramClass) {
/* 271 */     for (Annotation annotation : this.b) {
/* 272 */       if (annotation.annotationType().equals(paramClass)) {
/* 273 */         return paramClass.cast(annotation);
/*     */       }
/*     */     } 
/* 276 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<Annotation> getAnnotations() {
/* 283 */     return Arrays.asList(this.b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> f() {
/* 291 */     if (this.m != null) {
/* 292 */       return this.m;
/*     */     }
/* 294 */     String str = getClassName();
/* 295 */     if (str == null) {
/* 296 */       return null;
/*     */     }
/*     */     try {
/* 299 */       this.m = Class.forName(str, false, getClass().getClassLoader());
/* 300 */       return this.m;
/* 301 */     } catch (ClassNotFoundException classNotFoundException) {
/* 302 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getClassName() {
/* 311 */     return (this.m != null) ? this.m.getName() : j(2, toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMethodName() {
/* 319 */     return j(1, null);
/*     */   }
/*     */ 
/*     */   
/*     */   private String j(int paramInt, String paramString) {
/* 324 */     Matcher matcher = F.matcher(toString());
/* 325 */     return matcher.matches() ? matcher.group(paramInt) : paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\runner\c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */