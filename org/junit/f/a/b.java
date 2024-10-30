/*    */ package org.junit.f.a;
/*    */ 
/*    */ import java.lang.annotation.Annotation;
/*    */ import java.lang.reflect.Field;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class b
/*    */   extends c<b>
/*    */ {
/*    */   private final Field field;
/*    */   
/*    */   public b(Field paramField) {
/* 24 */     if (paramField == null) {
/* 25 */       throw new NullPointerException("FrameworkField cannot be created without an underlying field.");
/*    */     }
/*    */     
/* 28 */     this.field = paramField;
/*    */     
/* 30 */     if (isPublic()) {
/*    */       
/*    */       try {
/* 33 */         paramField.setAccessible(true);
/* 34 */       } catch (SecurityException securityException) {}
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 42 */     return getField().getName();
/*    */   }
/*    */   
/*    */   public Annotation[] getAnnotations() {
/* 46 */     return this.field.getAnnotations();
/*    */   }
/*    */   
/*    */   public <T extends Annotation> T getAnnotation(Class<T> paramClass) {
/* 50 */     return this.field.getAnnotation(paramClass);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean a(b paramb) {
/* 55 */     return paramb.getName().equals(getName());
/*    */   }
/*    */ 
/*    */   
/*    */   boolean gy() {
/* 60 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected int getModifiers() {
/* 65 */     return this.field.getModifiers();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Field getField() {
/* 72 */     return this.field;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<?> getType() {
/* 81 */     return this.field.getType();
/*    */   }
/*    */ 
/*    */   
/*    */   public Class<?> getDeclaringClass() {
/* 86 */     return this.field.getDeclaringClass();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Object get(Object paramObject) throws IllegalArgumentException, IllegalAccessException {
/* 93 */     return this.field.get(paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 98 */     return this.field.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\f\a\b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */