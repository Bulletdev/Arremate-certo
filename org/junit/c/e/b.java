/*    */ package org.junit.c.e;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import org.junit.f.a.e;
/*    */ import org.junit.runner.b.a;
/*    */ import org.junit.runner.b.c;
/*    */ import org.junit.runner.c;
/*    */ import org.junit.runner.m;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class b
/*    */   extends m
/*    */ {
/*    */   private final List<Throwable> aD;
/*    */   private final String me;
/*    */   
/*    */   public b(Class<?> paramClass, Throwable paramThrowable) {
/* 21 */     this(paramThrowable, new Class[] { paramClass });
/*    */   }
/*    */   
/*    */   public b(Throwable paramThrowable, Class<?>... paramVarArgs) {
/* 25 */     if (paramVarArgs == null || paramVarArgs.length == 0) {
/* 26 */       throw new NullPointerException("Test classes cannot be null or empty");
/*    */     }
/* 28 */     for (Class<?> clazz : paramVarArgs) {
/* 29 */       if (clazz == null) {
/* 30 */         throw new NullPointerException("Test class cannot be null");
/*    */       }
/*    */     } 
/* 33 */     this.me = a(paramVarArgs);
/* 34 */     this.aD = f(paramThrowable);
/*    */   }
/*    */ 
/*    */   
/*    */   public c a() {
/* 39 */     c c = c.a(this.me, new java.lang.annotation.Annotation[0]);
/* 40 */     for (Throwable throwable : this.aD) {
/* 41 */       c.g(b());
/*    */     }
/* 43 */     return c;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(c paramc) {
/* 48 */     for (Throwable throwable : this.aD) {
/* 49 */       a(throwable, paramc);
/*    */     }
/*    */   }
/*    */   
/*    */   private String a(Class<?>... paramVarArgs) {
/* 54 */     StringBuilder stringBuilder = new StringBuilder();
/* 55 */     for (Class<?> clazz : paramVarArgs) {
/* 56 */       if (stringBuilder.length() != 0) {
/* 57 */         stringBuilder.append(", ");
/*    */       }
/* 59 */       stringBuilder.append(clazz.getName());
/*    */     } 
/* 61 */     return stringBuilder.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   private List<Throwable> f(Throwable paramThrowable) {
/* 66 */     if (paramThrowable instanceof java.lang.reflect.InvocationTargetException) {
/* 67 */       return f(paramThrowable.getCause());
/*    */     }
/* 69 */     if (paramThrowable instanceof org.junit.f.a.f) {
/* 70 */       return Collections.singletonList(paramThrowable);
/*    */     }
/* 72 */     if (paramThrowable instanceof e) {
/* 73 */       return ((e)paramThrowable).bi();
/*    */     }
/* 75 */     if (paramThrowable instanceof d) {
/* 76 */       return ((d)paramThrowable).bi();
/*    */     }
/*    */     
/* 79 */     return Collections.singletonList(paramThrowable);
/*    */   }
/*    */   
/*    */   private c b() {
/* 83 */     return c.a(this.me, "initializationError", new java.lang.annotation.Annotation[0]);
/*    */   }
/*    */   
/*    */   private void a(Throwable paramThrowable, c paramc) {
/* 87 */     c c1 = b();
/* 88 */     paramc.n(c1);
/* 89 */     paramc.c(new a(c1, paramThrowable));
/* 90 */     paramc.p(c1);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\e\b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */