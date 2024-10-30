/*    */ package org.junit.c.e;
/*    */ 
/*    */ import java.lang.annotation.Annotation;
/*    */ import java.lang.reflect.Method;
/*    */ import java.lang.reflect.Modifier;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.junit.a;
/*    */ import org.junit.b;
/*    */ import org.junit.f;
/*    */ import org.junit.g;
/*    */ import org.junit.m;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public class h
/*    */ {
/* 24 */   private final List<Throwable> ak = new ArrayList<Throwable>();
/*    */   
/*    */   private j a;
/*    */   
/*    */   public h(j paramj) {
/* 29 */     this.a = paramj;
/*    */   }
/*    */   
/*    */   public void iv() {
/* 33 */     a((Class)a.class, false);
/* 34 */     a((Class)f.class, false);
/* 35 */     a((Class)m.class, false);
/*    */     
/* 37 */     List<Method> list = this.a.a((Class)m.class);
/* 38 */     if (list.size() == 0) {
/* 39 */       this.ak.add(new Exception("No runnable methods"));
/*    */     }
/*    */   }
/*    */   
/*    */   public void iw() {
/* 44 */     a((Class)g.class, true);
/* 45 */     a((Class)b.class, true);
/*    */   }
/*    */   
/*    */   public List<Throwable> bk() {
/* 49 */     iy();
/* 50 */     iw();
/* 51 */     iv();
/* 52 */     return this.ak;
/*    */   }
/*    */   
/*    */   public void ix() throws d {
/* 56 */     if (!this.ak.isEmpty()) {
/* 57 */       throw new d(this.ak);
/*    */     }
/*    */   }
/*    */   
/*    */   public void iy() {
/*    */     try {
/* 63 */       this.a.b();
/* 64 */     } catch (Exception exception) {
/* 65 */       this.ak.add(new Exception("Test class should have public zero-argument constructor", exception));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private void a(Class<? extends Annotation> paramClass, boolean paramBoolean) {
/* 71 */     List<Method> list = this.a.a(paramClass);
/*    */     
/* 73 */     for (Method method : list) {
/* 74 */       if (Modifier.isStatic(method.getModifiers()) != paramBoolean) {
/* 75 */         String str = paramBoolean ? "should" : "should not";
/* 76 */         this.ak.add(new Exception("Method " + method.getName() + "() " + str + " be static"));
/*    */       } 
/*    */       
/* 79 */       if (!Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
/* 80 */         this.ak.add(new Exception("Class " + method.getDeclaringClass().getName() + " should be public"));
/*    */       }
/*    */       
/* 83 */       if (!Modifier.isPublic(method.getModifiers())) {
/* 84 */         this.ak.add(new Exception("Method " + method.getName() + " should be public"));
/*    */       }
/*    */       
/* 87 */       if (method.getReturnType() != void.class) {
/* 88 */         this.ak.add(new Exception("Method " + method.getName() + "should have a return type of void"));
/*    */       }
/*    */       
/* 91 */       if ((method.getParameterTypes()).length != 0)
/* 92 */         this.ak.add(new Exception("Method " + method.getName() + " should have no parameters")); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\e\h.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */