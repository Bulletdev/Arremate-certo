/*     */ package org.junit.c.e;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.Method;
/*     */ import junit.a.c;
/*     */ import junit.b.b;
/*     */ import junit.b.i;
/*     */ import junit.b.j;
/*     */ import junit.b.l;
/*     */ import junit.b.m;
/*     */ import junit.b.n;
/*     */ import org.junit.runner.a.b;
/*     */ import org.junit.runner.a.c;
/*     */ import org.junit.runner.a.d;
/*     */ import org.junit.runner.a.f;
/*     */ import org.junit.runner.a.g;
/*     */ import org.junit.runner.a.i;
/*     */ import org.junit.runner.a.j;
/*     */ import org.junit.runner.b;
/*     */ import org.junit.runner.b.c;
/*     */ import org.junit.runner.c;
/*     */ import org.junit.runner.m;
/*     */ 
/*     */ public class e
/*     */   extends m
/*     */   implements c, f {
/*     */   private volatile i d;
/*     */   
/*     */   private static final class a implements l {
/*     */     private final c a;
/*     */     
/*     */     private a(c param1c) {
/*  33 */       this.a = param1c;
/*     */     }
/*     */     
/*     */     public void a(i param1i) {
/*  37 */       this.a.p(b(param1i));
/*     */     }
/*     */     
/*     */     public void b(i param1i) {
/*  41 */       this.a.n(b(param1i));
/*     */     }
/*     */ 
/*     */     
/*     */     public void a(i param1i, Throwable param1Throwable) {
/*  46 */       org.junit.runner.b.a a1 = new org.junit.runner.b.a(b(param1i), param1Throwable);
/*  47 */       this.a.c(a1);
/*     */     }
/*     */     
/*     */     private c b(i param1i) {
/*  51 */       if (param1i instanceof b) {
/*  52 */         b b = (b)param1i;
/*  53 */         return b.a();
/*     */       } 
/*  55 */       return c.a(a(param1i), a(param1i));
/*     */     }
/*     */     
/*     */     private Class<? extends i> a(i param1i) {
/*  59 */       return (Class)param1i.getClass();
/*     */     }
/*     */     
/*     */     private String a(i param1i) {
/*  63 */       if (param1i instanceof j) {
/*  64 */         return ((j)param1i).getName();
/*     */       }
/*  66 */       return param1i.toString();
/*     */     }
/*     */ 
/*     */     
/*     */     public void a(i param1i, b param1b) {
/*  71 */       a(param1i, (Throwable)param1b);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public e(Class<?> paramClass) {
/*  78 */     this((i)new n(paramClass.asSubclass(j.class)));
/*     */   }
/*     */ 
/*     */   
/*     */   public e(i parami) {
/*  83 */     e(parami);
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(c paramc) {
/*  88 */     m m1 = new m();
/*  89 */     m1.a(a(paramc));
/*  90 */     a().a(m1);
/*     */   }
/*     */   
/*     */   public l a(c paramc) {
/*  94 */     return new a(paramc);
/*     */   }
/*     */ 
/*     */   
/*     */   public c a() {
/*  99 */     return a(a());
/*     */   }
/*     */   
/*     */   private static c a(i parami) {
/* 103 */     if (parami instanceof j) {
/* 104 */       j j = (j)parami;
/* 105 */       return c.a(j.getClass(), j.getName(), a(j));
/*     */     } 
/* 107 */     if (parami instanceof n) {
/* 108 */       n n = (n)parami;
/* 109 */       String str = (n.getName() == null) ? a(n) : n.getName();
/* 110 */       c c1 = c.a(str, new Annotation[0]);
/* 111 */       int j = n.bg();
/* 112 */       for (byte b = 0; b < j; b++) {
/* 113 */         c c2 = a(n.a(b));
/* 114 */         c1.g(c2);
/*     */       } 
/* 116 */       return c1;
/* 117 */     }  if (parami instanceof b) {
/* 118 */       b b = (b)parami;
/* 119 */       return b.a();
/* 120 */     }  if (parami instanceof c) {
/* 121 */       c c1 = (c)parami;
/* 122 */       return a(c1.a());
/*     */     } 
/*     */     
/* 125 */     return c.a(parami.getClass());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Annotation[] a(j paramj) {
/*     */     
/* 135 */     try { Method method = paramj.getClass().getMethod(paramj.getName(), new Class[0]);
/* 136 */       return method.getDeclaredAnnotations(); }
/* 137 */     catch (SecurityException securityException) {  }
/* 138 */     catch (NoSuchMethodException noSuchMethodException) {}
/*     */     
/* 140 */     return new Annotation[0];
/*     */   }
/*     */   
/*     */   private static String a(n paramn) {
/* 144 */     int j = paramn.bc();
/* 145 */     String str = (j == 0) ? "" : String.format(" [example: %s]", new Object[] { paramn.a(0) });
/* 146 */     return String.format("TestSuite with %s tests%s", new Object[] { Integer.valueOf(j), str });
/*     */   }
/*     */   
/*     */   public void a(b paramb) throws org.junit.runner.a.e {
/* 150 */     if (a() instanceof c) {
/* 151 */       c c1 = (c)a();
/* 152 */       c1.a(paramb);
/* 153 */     } else if (a() instanceof n) {
/* 154 */       n n1 = (n)a();
/* 155 */       n n2 = new n(n1.getName());
/* 156 */       int j = n1.bg();
/* 157 */       for (byte b1 = 0; b1 < j; b1++) {
/* 158 */         i i1 = n1.a(b1);
/* 159 */         if (paramb.b(a(i1))) {
/* 160 */           n2.c(i1);
/*     */         }
/*     */       } 
/* 163 */       e((i)n2);
/* 164 */       if (n2.bg() == 0) {
/* 165 */         throw new org.junit.runner.a.e();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void a(j paramj) {
/* 171 */     if (a() instanceof i) {
/* 172 */       i i1 = (i)a();
/* 173 */       i1.a(paramj);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(g paramg) throws d {
/* 183 */     if (a() instanceof f) {
/* 184 */       f f1 = (f)a();
/* 185 */       f1.a(paramg);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void e(i parami) {
/* 190 */     this.d = parami;
/*     */   }
/*     */   
/*     */   private i a() {
/* 194 */     return this.d;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\e\e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */