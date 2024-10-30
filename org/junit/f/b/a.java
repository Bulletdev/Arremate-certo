/*     */ package org.junit.f.b;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.List;
/*     */ import org.junit.c.e.c.e;
/*     */ import org.junit.c.e.c.f;
/*     */ import org.junit.f.a.d;
/*     */ import org.junit.f.a.e;
/*     */ import org.junit.f.a.l;
/*     */ import org.junit.f.b;
/*     */ import org.junit.f.e;
/*     */ import org.junit.runner.l;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends b
/*     */ {
/*     */   private final Object[] s;
/*     */   private final String name;
/*     */   
/*     */   private enum a
/*     */   {
/*  26 */     a, b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public a(d paramd) throws e {
/*  35 */     super(paramd.a());
/*  36 */     this.s = paramd.getParameters().toArray(new Object[paramd.getParameters().size()]);
/*     */     
/*  38 */     this.name = paramd.getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object O() throws Exception {
/*  43 */     a a1 = a();
/*  44 */     switch (null.ao[a1.ordinal()]) {
/*     */       case 1:
/*  46 */         return Q();
/*     */       case 2:
/*  48 */         return R();
/*     */     } 
/*  50 */     throw new IllegalStateException("The injection type " + a1 + " is not supported.");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Object Q() throws Exception {
/*  56 */     return a().c().newInstance(this.s);
/*     */   }
/*     */   
/*     */   private Object R() throws Exception {
/*  60 */     List<org.junit.f.a.b> list = bz();
/*  61 */     if (list.size() != this.s.length) {
/*  62 */       throw new Exception("Wrong number of parameters and @Parameter fields. @Parameter fields counted: " + list.size() + ", available parameters: " + this.s.length + ".");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  69 */     Object object = a().getJavaClass().newInstance();
/*  70 */     for (org.junit.f.a.b b1 : list) {
/*  71 */       Field field = b1.getField();
/*  72 */       e.d d = field.<e.d>getAnnotation(e.d.class);
/*  73 */       int i = d.value();
/*     */       try {
/*  75 */         field.set(object, this.s[i]);
/*  76 */       } catch (IllegalAccessException illegalAccessException1) {
/*  77 */         IllegalAccessException illegalAccessException2 = new IllegalAccessException("Cannot set parameter '" + field.getName() + "'. Ensure that the field '" + field.getName() + "' is public.");
/*     */ 
/*     */ 
/*     */         
/*  81 */         illegalAccessException2.initCause(illegalAccessException1);
/*  82 */         throw illegalAccessException2;
/*  83 */       } catch (IllegalArgumentException illegalArgumentException) {
/*  84 */         throw new Exception(a().getName() + ": Trying to set " + field.getName() + " with the value " + this.s[i] + " that is not the right type (" + this.s[i].getClass().getSimpleName() + " instead of " + field.getType().getSimpleName() + ").", illegalArgumentException);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  93 */     return object;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getName() {
/*  98 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(d paramd) {
/* 103 */     return paramd.getName() + getName();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void w(List<Throwable> paramList) {
/* 108 */     A(paramList);
/* 109 */     if (a() != a.a) {
/* 110 */       B(paramList);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void D(List<Throwable> paramList) {
/* 116 */     super.D(paramList);
/* 117 */     if (a() == a.b) {
/* 118 */       List<org.junit.f.a.b> list = bz();
/* 119 */       int[] arrayOfInt = new int[list.size()];
/* 120 */       for (org.junit.f.a.b b2 : list) {
/* 121 */         int i = ((e.d)b2.getField().<e.d>getAnnotation(e.d.class)).value();
/*     */         
/* 123 */         if (i < 0 || i > list.size() - 1) {
/* 124 */           paramList.add(new Exception("Invalid @Parameter value: " + i + ". @Parameter fields counted: " + list.size() + ". Please use an index between 0 and " + (list.size() - 1) + "."));
/*     */ 
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/* 130 */         arrayOfInt[i] = arrayOfInt[i] + 1;
/*     */       } 
/*     */       
/* 133 */       for (byte b1 = 0; b1 < arrayOfInt.length; b1++) {
/* 134 */         int i = arrayOfInt[b1];
/* 135 */         if (i == 0) {
/* 136 */           paramList.add(new Exception("@Parameter(" + b1 + ") is never used."));
/*     */         }
/* 138 */         else if (i > 1) {
/* 139 */           paramList.add(new Exception("@Parameter(" + b1 + ") is used more than once (" + i + ")."));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected l a(org.junit.runner.b.c paramc) {
/* 148 */     l l = b(paramc);
/* 149 */     l = g(l);
/* 150 */     l = h(l);
/* 151 */     return l;
/*     */   }
/*     */   
/*     */   private l g(l paraml) {
/* 155 */     List<d> list = a().a(e.c.class);
/*     */     
/* 157 */     return list.isEmpty() ? paraml : (l)new c(this, paraml, list);
/*     */   }
/*     */   
/*     */   private class c extends f {
/*     */     c(a this$0, l param1l, List<d> param1List) {
/* 162 */       super(param1l, param1List, null);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void a(d param1d) throws Throwable {
/* 167 */       int i = (param1d.getMethod().getParameterTypes()).length;
/* 168 */       param1d.c(null, (i == 0) ? (Object[])null : a.a(this.a));
/*     */     }
/*     */   }
/*     */   
/*     */   private l h(l paraml) {
/* 173 */     List<d> list = a().a(e.a.class);
/*     */     
/* 175 */     return list.isEmpty() ? paraml : (l)new b(this, paraml, list);
/*     */   }
/*     */   
/*     */   private class b extends e {
/*     */     b(a this$0, l param1l, List<d> param1List) {
/* 180 */       super(param1l, param1List, null);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void a(d param1d) throws Throwable {
/* 185 */       int i = (param1d.getMethod().getParameterTypes()).length;
/* 186 */       param1d.c(null, (i == 0) ? (Object[])null : a.a(this.a));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected Annotation[] b() {
/* 192 */     Annotation[] arrayOfAnnotation1 = super.b();
/* 193 */     Annotation[] arrayOfAnnotation2 = new Annotation[arrayOfAnnotation1.length - 1];
/* 194 */     byte b1 = 0;
/* 195 */     for (Annotation annotation : arrayOfAnnotation1) {
/* 196 */       if (!annotation.annotationType().equals(l.class)) {
/* 197 */         arrayOfAnnotation2[b1] = annotation;
/* 198 */         b1++;
/*     */       } 
/*     */     } 
/* 201 */     return arrayOfAnnotation2;
/*     */   }
/*     */   
/*     */   private List<org.junit.f.a.b> bz() {
/* 205 */     return a().c(e.d.class);
/*     */   }
/*     */   
/*     */   private a a() {
/* 209 */     if (gA()) {
/* 210 */       return a.b;
/*     */     }
/* 212 */     return (a)a.a;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean gA() {
/* 217 */     return !bz().isEmpty();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\f\b\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */