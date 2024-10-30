/*     */ package org.junit.f;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Inherited;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import java.text.MessageFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.junit.f.a.d;
/*     */ import org.junit.f.a.f;
/*     */ import org.junit.f.a.m;
/*     */ import org.junit.f.b.b;
/*     */ import org.junit.f.b.c;
/*     */ import org.junit.f.b.d;
/*     */ import org.junit.runner.m;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class e
/*     */   extends h
/*     */ {
/*     */   public e(Class<?> paramClass) throws Throwable {
/* 303 */     this(paramClass, new f(paramClass, null));
/*     */   }
/*     */   
/*     */   private e(Class<?> paramClass, f paramf) throws Exception {
/* 307 */     super(paramClass, f.a(paramf));
/* 308 */     d(Integer.valueOf(f.a(paramf)));
/*     */   }
/*     */ 
/*     */   
/*     */   private void d(Integer paramInteger) throws f {
/* 313 */     ArrayList<Throwable> arrayList = new ArrayList();
/* 314 */     a((Class)c.class, paramInteger, arrayList);
/* 315 */     a((Class)a.class, paramInteger, arrayList);
/* 316 */     if (!arrayList.isEmpty()) {
/* 317 */       throw new f(a().getJavaClass(), arrayList);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(Class<? extends Annotation> paramClass, Integer paramInteger, List<Throwable> paramList) {
/* 324 */     List list = a().a(paramClass);
/* 325 */     for (d d : list) {
/* 326 */       d.b(true, paramList);
/* 327 */       if (paramInteger != null) {
/* 328 */         int i = (d.getMethod().getParameterTypes()).length;
/* 329 */         if (i != 0 && i != paramInteger.intValue())
/* 330 */           paramList.add(new Exception("Method " + d.getName() + "() should have 0 or " + paramInteger + " parameter(s)")); 
/*     */       } 
/*     */     } 
/*     */   } @Retention(RetentionPolicy.RUNTIME) @Target({ElementType.METHOD}) public static @interface e {
/*     */     String name() default "{index}"; } @Retention(RetentionPolicy.RUNTIME) @Target({ElementType.FIELD})
/*     */   public static @interface d {
/*     */     int value() default 0; } @Retention(RetentionPolicy.RUNTIME)
/*     */   @Inherited
/*     */   @Target({ElementType.TYPE})
/*     */   public static @interface g { Class<? extends c> value() default b.class; } @Retention(RetentionPolicy.RUNTIME)
/*     */   @Target({ElementType.METHOD})
/*     */   public static @interface c {} @Retention(RetentionPolicy.RUNTIME)
/*     */   @Target({ElementType.METHOD})
/* 343 */   public static @interface a {} private static class b extends m { private final org.junit.runner.c b; b(m param1m, String param1String, org.junit.c.b param1b) { this.b = org.junit.runner.c.a(param1m.getJavaClass(), param1String + "() assumption violation");
/*     */ 
/*     */       
/* 346 */       this.a = param1b; }
/*     */     
/*     */     private final org.junit.c.b a;
/*     */     
/*     */     public org.junit.runner.c a() {
/* 351 */       return this.b;
/*     */     }
/*     */ 
/*     */     
/*     */     public void a(org.junit.runner.b.c param1c) {
/* 356 */       param1c.d(new org.junit.runner.b.a(this.b, (Throwable)this.a));
/*     */     } }
/*     */ 
/*     */   
/*     */   private static class f {
/* 361 */     private static final c a = (c)new b();
/*     */     private final m a;
/*     */     private final d d;
/*     */     private final List<Object> aP;
/*     */     private final int parameterCount;
/*     */     private final m d;
/*     */     
/*     */     private f(Class<?> param1Class) throws Throwable {
/*     */       List<?> list;
/* 370 */       this.a = new m(param1Class);
/* 371 */       this.d = (m)a(this.a);
/*     */       
/* 373 */       e.b b = null;
/*     */       try {
/* 375 */         list = a(this.a, (d)this.d);
/* 376 */       } catch (org.junit.c.b b1) {
/* 377 */         list = Collections.emptyList();
/* 378 */         b = new e.b(this.a, this.d.getName(), b1);
/*     */       } 
/*     */       
/* 381 */       this.aP = (List)list;
/* 382 */       this.d = b;
/* 383 */       this.parameterCount = this.aP.isEmpty() ? 0 : (a(this.aP.get(0))).length;
/*     */     }
/*     */ 
/*     */     
/*     */     private List<m> br() throws Exception {
/* 388 */       if (this.d != null) {
/* 389 */         return Collections.singletonList(this.d);
/*     */       }
/* 391 */       e.e e = (e.e)this.d.getAnnotation(e.e.class);
/* 392 */       return Collections.unmodifiableList(a(this.aP, e.name(), a()));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private c a() throws InstantiationException, IllegalAccessException {
/* 399 */       e.g g = (e.g)this.a.getAnnotation(e.g.class);
/*     */       
/* 401 */       if (g == null) {
/* 402 */         return (c)a;
/*     */       }
/* 404 */       Class<? extends c> clazz = g.value();
/*     */       
/* 406 */       return clazz.newInstance();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private d a(String param1String, int param1Int, Object param1Object) {
/* 412 */       Object[] arrayOfObject = a(param1Object);
/* 413 */       return a(this.a, param1String, param1Int, arrayOfObject);
/*     */     }
/*     */     
/*     */     private static Object[] a(Object param1Object) {
/* 417 */       (new Object[1])[0] = param1Object; return (param1Object instanceof Object[]) ? (Object[])param1Object : new Object[1];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static List<Object> a(m param1m, d param1d) throws Throwable {
/* 424 */       Object object = param1d.c(null, new Object[0]);
/* 425 */       if (object instanceof List)
/* 426 */         return (List<Object>)object; 
/* 427 */       if (object instanceof Collection)
/* 428 */         return new ArrayList((Collection)object); 
/* 429 */       if (object instanceof Iterable) {
/* 430 */         ArrayList<Object> arrayList = new ArrayList();
/* 431 */         for (Object object1 : object) {
/* 432 */           arrayList.add(object1);
/*     */         }
/* 434 */         return arrayList;
/* 435 */       }  if (object instanceof Object[]) {
/* 436 */         return Arrays.asList((Object[])object);
/*     */       }
/* 438 */       throw a(param1m, param1d);
/*     */     }
/*     */ 
/*     */     
/*     */     private static d a(m param1m) throws Exception {
/* 443 */       List list = param1m.a(e.e.class);
/*     */       
/* 445 */       for (d d1 : list) {
/* 446 */         if (d1.isStatic() && d1.isPublic()) {
/* 447 */           return d1;
/*     */         }
/*     */       } 
/*     */       
/* 451 */       throw new Exception("No public static parameters method on class " + param1m.getName());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private List<m> a(Iterable<Object> param1Iterable, String param1String, c param1c) throws Exception {
/*     */       try {
/* 459 */         List<d> list = a(param1Iterable, param1String);
/*     */         
/* 461 */         ArrayList<m> arrayList = new ArrayList();
/* 462 */         for (d d1 : list) {
/* 463 */           arrayList.add(param1c.a(d1));
/*     */         }
/*     */         
/* 466 */         return arrayList;
/* 467 */       } catch (ClassCastException classCastException) {
/* 468 */         throw a(this.a, this.d);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private List<d> a(Iterable<Object> param1Iterable, String param1String) throws Exception {
/* 475 */       byte b = 0;
/* 476 */       ArrayList<d> arrayList = new ArrayList();
/* 477 */       for (Object object : param1Iterable) {
/* 478 */         arrayList.add(a(param1String, b++, object));
/*     */       }
/*     */       
/* 481 */       return arrayList;
/*     */     }
/*     */ 
/*     */     
/*     */     private static Exception a(m param1m, d param1d) throws Exception {
/* 486 */       String str1 = param1m.getName();
/* 487 */       String str2 = param1d.getName();
/* 488 */       String str3 = MessageFormat.format("{0}.{1}() must return an Iterable of arrays.", new Object[] { str1, str2 });
/*     */ 
/*     */       
/* 491 */       return new Exception(str3);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private d a(m param1m, String param1String, int param1Int, Object[] param1ArrayOfObject) {
/* 497 */       String str1 = param1String.replaceAll("\\{index\\}", Integer.toString(param1Int));
/*     */       
/* 499 */       String str2 = MessageFormat.format(str1, param1ArrayOfObject);
/* 500 */       return new d("[" + str2 + "]", param1m, Arrays.asList(param1ArrayOfObject));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\f\e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */