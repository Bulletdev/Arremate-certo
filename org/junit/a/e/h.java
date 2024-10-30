/*     */ package org.junit.a.e;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.junit.a.e.a.b;
/*     */ import org.junit.a.e.a.e;
/*     */ import org.junit.c;
/*     */ import org.junit.c.b;
/*     */ import org.junit.d;
/*     */ import org.junit.f.a.d;
/*     */ import org.junit.f.a.e;
/*     */ import org.junit.f.a.l;
/*     */ import org.junit.f.a.m;
/*     */ import org.junit.f.b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class h
/*     */   extends b
/*     */ {
/*     */   public h(Class<?> paramClass) throws e {
/*  73 */     super(paramClass);
/*     */   }
/*     */ 
/*     */   
/*     */   protected h(m paramm) throws e {
/*  78 */     super(paramm);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void t(List<Throwable> paramList) {
/*  83 */     super.t(paramList);
/*  84 */     u(paramList);
/*  85 */     v(paramList);
/*     */   }
/*     */   
/*     */   private void u(List<Throwable> paramList) {
/*  89 */     Field[] arrayOfField = a().getJavaClass().getDeclaredFields();
/*     */     
/*  91 */     for (Field field : arrayOfField) {
/*  92 */       if (field.getAnnotation(a.class) != null || field.getAnnotation(b.class) != null) {
/*     */ 
/*     */         
/*  95 */         if (!Modifier.isStatic(field.getModifiers())) {
/*  96 */           paramList.add(new Error("DataPoint field " + field.getName() + " must be static"));
/*     */         }
/*  98 */         if (!Modifier.isPublic(field.getModifiers()))
/*  99 */           paramList.add(new Error("DataPoint field " + field.getName() + " must be public")); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void v(List<Throwable> paramList) {
/* 105 */     Method[] arrayOfMethod = a().getJavaClass().getDeclaredMethods();
/*     */     
/* 107 */     for (Method method : arrayOfMethod) {
/* 108 */       if (method.getAnnotation(a.class) != null || method.getAnnotation(b.class) != null) {
/*     */ 
/*     */         
/* 111 */         if (!Modifier.isStatic(method.getModifiers())) {
/* 112 */           paramList.add(new Error("DataPoint method " + method.getName() + " must be static"));
/*     */         }
/* 114 */         if (!Modifier.isPublic(method.getModifiers())) {
/* 115 */           paramList.add(new Error("DataPoint method " + method.getName() + " must be public"));
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void w(List<Throwable> paramList) {
/* 122 */     A(paramList);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void x(List<Throwable> paramList) {
/* 127 */     for (d d : bf()) {
/* 128 */       if (d.getAnnotation(i.class) != null) {
/* 129 */         d.b(false, paramList);
/* 130 */         d.H(paramList);
/*     */       } else {
/* 132 */         d.a(false, paramList);
/*     */       } 
/*     */       
/* 135 */       for (d d1 : d.a(d.getMethod())) {
/* 136 */         f f = d1.<f>a(f.class);
/* 137 */         if (f != null) {
/* 138 */           a(f.value(), paramList);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(Class<? extends e> paramClass, List<Throwable> paramList) {
/* 145 */     Constructor[] arrayOfConstructor = (Constructor[])paramClass.getConstructors();
/*     */     
/* 147 */     if (arrayOfConstructor.length != 1) {
/* 148 */       paramList.add(new Error("ParameterSupplier " + paramClass.getName() + " must have only one constructor (either empty or taking only a TestClass)"));
/*     */     } else {
/*     */       
/* 151 */       Class[] arrayOfClass = arrayOfConstructor[0].getParameterTypes();
/* 152 */       if (arrayOfClass.length != 0 && !arrayOfClass[0].equals(m.class)) {
/* 153 */         paramList.add(new Error("ParameterSupplier " + paramClass.getName() + " constructor must take either nothing or a single TestClass instance"));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<d> bf() {
/* 161 */     ArrayList<?> arrayList = new ArrayList(super.bf());
/* 162 */     List<?> list = a().a(i.class);
/* 163 */     arrayList.removeAll(list);
/* 164 */     arrayList.addAll(list);
/* 165 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public l a(d paramd) {
/* 170 */     return new a(paramd, a());
/*     */   }
/*     */   
/*     */   public static class a extends l {
/* 174 */     private int iQ = 0;
/*     */     
/*     */     private final d a;
/*     */     
/*     */     private final m a;
/* 179 */     private List<b> ay = new ArrayList<b>();
/*     */     
/*     */     public a(d param1d, m param1m) {
/* 182 */       this.a = (m)param1d;
/* 183 */       this.a = param1m;
/*     */     }
/*     */     
/*     */     private m a() {
/* 187 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public void io() throws Throwable {
/* 192 */       a(b.a(this.a.getMethod(), a()));
/*     */ 
/*     */ 
/*     */       
/* 196 */       boolean bool = (this.a.getAnnotation(i.class) != null) ? true : false;
/* 197 */       if (this.iQ == 0 && bool) {
/* 198 */         c.fail("Never found parameters that satisfied method assumptions.  Violated assumptions: " + this.ay);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void a(b param1b) throws Throwable {
/* 206 */       if (!param1b.isComplete()) {
/* 207 */         b(param1b);
/*     */       } else {
/* 209 */         c(param1b);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     protected void b(b param1b) throws Throwable {
/* 215 */       for (g g : param1b.bg())
/*     */       {
/* 217 */         a(param1b.a(g));
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     protected void c(b param1b) throws Throwable {
/* 223 */       (new b(this, a(), param1b)
/*     */         {
/*     */           protected void t(List<Throwable> param2List) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public l a(d param2d) {
/* 232 */             l l = super.a(param2d);
/* 233 */             return new l(this, l)
/*     */               {
/*     */                 public void io() throws Throwable {
/*     */                   try {
/* 237 */                     this.a.io();
/* 238 */                     this.a.a.ip();
/* 239 */                   } catch (b b) {
/* 240 */                     this.a.a.a(b);
/* 241 */                   } catch (Throwable throwable) {
/* 242 */                     this.a.a.a(throwable, this.a.a.a(h.a.a(this.a.a)));
/*     */                   } 
/*     */                 }
/*     */               };
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           protected l a(d param2d, Object param2Object) {
/* 252 */             return h.a.a(this.a, param2d, (b)this.a, param2Object);
/*     */           }
/*     */ 
/*     */           
/*     */           public Object O() throws Exception {
/* 257 */             Object[] arrayOfObject = this.a.e();
/*     */             
/* 259 */             if (!h.a.a(this.a)) {
/* 260 */               d.a(arrayOfObject);
/*     */             }
/*     */             
/* 263 */             return a().c().newInstance(arrayOfObject);
/*     */           }
/*     */         }).a((d)this.a).io();
/*     */     }
/*     */ 
/*     */     
/*     */     private l a(d param1d, b param1b, Object param1Object) {
/* 270 */       return new l(this, param1b, param1d, param1Object)
/*     */         {
/*     */           public void io() throws Throwable {
/* 273 */             Object[] arrayOfObject = this.a.f();
/*     */             
/* 275 */             if (!h.a.a(this.a)) {
/* 276 */               d.a(arrayOfObject);
/*     */             }
/*     */             
/* 279 */             this.b.c(this.aC, arrayOfObject);
/*     */           }
/*     */         };
/*     */     }
/*     */     
/*     */     protected void a(b param1b) {
/* 285 */       this.ay.add(param1b);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void a(Throwable param1Throwable, Object... param1VarArgs) throws Throwable {
/* 290 */       if (param1VarArgs.length == 0) {
/* 291 */         throw param1Throwable;
/*     */       }
/* 293 */       throw new e(param1Throwable, this.a.getName(), param1VarArgs);
/*     */     }
/*     */ 
/*     */     
/*     */     private boolean gi() {
/* 298 */       i i = this.a.getMethod().<i>getAnnotation(i.class);
/*     */       
/* 300 */       if (i == null) {
/* 301 */         return false;
/*     */       }
/* 303 */       return i.gj();
/*     */     }
/*     */     
/*     */     protected void ip() {
/* 307 */       this.iQ++;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\a\e\h.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */