/*     */ package org.junit.f.a;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.List;
/*     */ import org.junit.c.e.a.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class d
/*     */   extends c<d>
/*     */ {
/*     */   private final Method method;
/*     */   
/*     */   public d(Method paramMethod) {
/*  26 */     if (paramMethod == null) {
/*  27 */       throw new NullPointerException("FrameworkMethod cannot be created without an underlying method.");
/*     */     }
/*     */     
/*  30 */     this.method = paramMethod;
/*     */     
/*  32 */     if (isPublic()) {
/*     */       
/*     */       try {
/*  35 */         paramMethod.setAccessible(true);
/*  36 */       } catch (SecurityException securityException) {}
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Method getMethod() {
/*  46 */     return this.method;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object c(Object paramObject, Object... paramVarArgs) throws Throwable {
/*  56 */     return (new c(this, paramObject, paramVarArgs)
/*     */       {
/*     */         protected Object P() throws Throwable {
/*  59 */           return d.a(this.e).invoke(this.ar, this.r);
/*     */         }
/*     */       }).run();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  69 */     return this.method.getName();
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
/*     */   public void a(boolean paramBoolean, List<Throwable> paramList) {
/*  83 */     b(paramBoolean, paramList);
/*  84 */     if ((this.method.getParameterTypes()).length != 0) {
/*  85 */       paramList.add(new Exception("Method " + this.method.getName() + " should have no parameters"));
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
/*     */ 
/*     */   
/*     */   public void b(boolean paramBoolean, List<Throwable> paramList) {
/* 100 */     if (isStatic() != paramBoolean) {
/* 101 */       String str = paramBoolean ? "should" : "should not";
/* 102 */       paramList.add(new Exception("Method " + this.method.getName() + "() " + str + " be static"));
/*     */     } 
/* 104 */     if (!isPublic()) {
/* 105 */       paramList.add(new Exception("Method " + this.method.getName() + "() should be public"));
/*     */     }
/* 107 */     if (this.method.getReturnType() != void.class) {
/* 108 */       paramList.add(new Exception("Method " + this.method.getName() + "() should be void"));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getModifiers() {
/* 114 */     return this.method.getModifiers();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> getReturnType() {
/* 121 */     return this.method.getReturnType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> getType() {
/* 129 */     return getReturnType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> getDeclaringClass() {
/* 137 */     return this.method.getDeclaringClass();
/*     */   }
/*     */   
/*     */   public void H(List<Throwable> paramList) {
/* 141 */     (new i(this.method)).J(paramList);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean b(d paramd) {
/* 146 */     if (!paramd.getName().equals(getName())) {
/* 147 */       return false;
/*     */     }
/* 149 */     if ((paramd.getParameterTypes()).length != (getParameterTypes()).length) {
/* 150 */       return false;
/*     */     }
/* 152 */     for (byte b = 0; b < (paramd.getParameterTypes()).length; b++) {
/* 153 */       if (!paramd.getParameterTypes()[b].equals(getParameterTypes()[b])) {
/* 154 */         return false;
/*     */       }
/*     */     } 
/* 157 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean gy() {
/* 162 */     return this.method.isBridge();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 167 */     if (!d.class.isInstance(paramObject)) {
/* 168 */       return false;
/*     */     }
/* 170 */     return ((d)paramObject).method.equals(this.method);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 175 */     return this.method.hashCode();
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
/*     */   @Deprecated
/*     */   public boolean e(Type paramType) {
/* 189 */     return ((getParameterTypes()).length == 0 && paramType instanceof Class && ((Class)paramType).isAssignableFrom(this.method.getReturnType()));
/*     */   }
/*     */ 
/*     */   
/*     */   private Class<?>[] getParameterTypes() {
/* 194 */     return this.method.getParameterTypes();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Annotation[] getAnnotations() {
/* 201 */     return this.method.getAnnotations();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends Annotation> T getAnnotation(Class<T> paramClass) {
/* 209 */     return this.method.getAnnotation(paramClass);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 214 */     return this.method.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\f\a\d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */