/*     */ package org.apache.commons.lang3.builder;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import org.apache.commons.lang3.reflect.FieldUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReflectionDiffBuilder<T>
/*     */   implements Builder<DiffResult<T>>
/*     */ {
/*     */   private final Object left;
/*     */   private final Object right;
/*     */   private final DiffBuilder<T> diffBuilder;
/*     */   
/*     */   public ReflectionDiffBuilder(T paramT1, T paramT2, ToStringStyle paramToStringStyle) {
/*  97 */     this.left = paramT1;
/*  98 */     this.right = paramT2;
/*  99 */     this.diffBuilder = new DiffBuilder<>(paramT1, paramT2, paramToStringStyle);
/*     */   }
/*     */ 
/*     */   
/*     */   public DiffResult<T> build() {
/* 104 */     if (this.left.equals(this.right)) {
/* 105 */       return this.diffBuilder.build();
/*     */     }
/*     */     
/* 108 */     appendFields(this.left.getClass());
/* 109 */     return this.diffBuilder.build();
/*     */   }
/*     */   
/*     */   private void appendFields(Class<?> paramClass) {
/* 113 */     for (Field field : FieldUtils.getAllFields(paramClass)) {
/* 114 */       if (accept(field)) {
/*     */         try {
/* 116 */           this.diffBuilder.append(field.getName(), FieldUtils.readField(field, this.left, true), 
/* 117 */               FieldUtils.readField(field, this.right, true));
/* 118 */         } catch (IllegalAccessException illegalAccessException) {
/*     */ 
/*     */           
/* 121 */           throw new InternalError("Unexpected IllegalAccessException: " + illegalAccessException.getMessage());
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean accept(Field paramField) {
/* 128 */     if (paramField.getName().indexOf('$') != -1) {
/* 129 */       return false;
/*     */     }
/* 131 */     if (Modifier.isTransient(paramField.getModifiers())) {
/* 132 */       return false;
/*     */     }
/* 134 */     return !Modifier.isStatic(paramField.getModifiers());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\builder\ReflectionDiffBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */