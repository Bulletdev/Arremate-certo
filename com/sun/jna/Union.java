/*     */ package com.sun.jna;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Union
/*     */   extends Structure
/*     */ {
/*     */   private Structure.StructField activeField;
/*     */   
/*     */   protected Union() {}
/*     */   
/*     */   protected Union(Pointer paramPointer) {
/*  49 */     super(paramPointer);
/*     */   }
/*     */   
/*     */   protected Union(Pointer paramPointer, int paramInt) {
/*  53 */     super(paramPointer, paramInt);
/*     */   }
/*     */   
/*     */   protected Union(TypeMapper paramTypeMapper) {
/*  57 */     super(paramTypeMapper);
/*     */   }
/*     */   
/*     */   protected Union(Pointer paramPointer, int paramInt, TypeMapper paramTypeMapper) {
/*  61 */     super(paramPointer, paramInt, paramTypeMapper);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<String> getFieldOrder() {
/*  69 */     List<Field> list = getFieldList();
/*  70 */     ArrayList<String> arrayList = new ArrayList(list.size());
/*  71 */     for (Field field : list) {
/*  72 */       arrayList.add(field.getName());
/*     */     }
/*  74 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(Class<?> paramClass) {
/*  85 */     ensureAllocated();
/*  86 */     for (Structure.StructField structField : fields().values()) {
/*  87 */       if (structField.type == paramClass) {
/*  88 */         this.activeField = structField;
/*     */         return;
/*     */       } 
/*     */     } 
/*  92 */     throw new IllegalArgumentException("No field of type " + paramClass + " in " + this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(String paramString) {
/* 102 */     ensureAllocated();
/* 103 */     Structure.StructField structField = fields().get(paramString);
/* 104 */     if (structField != null) {
/* 105 */       this.activeField = structField;
/*     */     } else {
/*     */       
/* 108 */       throw new IllegalArgumentException("No field named " + paramString + " in " + this);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object readField(String paramString) {
/* 119 */     ensureAllocated();
/* 120 */     setType(paramString);
/* 121 */     return super.readField(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeField(String paramString) {
/* 130 */     ensureAllocated();
/* 131 */     setType(paramString);
/* 132 */     super.writeField(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeField(String paramString, Object paramObject) {
/* 141 */     ensureAllocated();
/* 142 */     setType(paramString);
/* 143 */     super.writeField(paramString, paramObject);
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
/*     */   
/*     */   public Object getTypedValue(Class<?> paramClass) {
/* 159 */     ensureAllocated();
/* 160 */     for (Structure.StructField structField : fields().values()) {
/* 161 */       if (structField.type == paramClass) {
/* 162 */         this.activeField = structField;
/* 163 */         read();
/* 164 */         return getFieldValue(this.activeField.field);
/*     */       } 
/*     */     } 
/* 167 */     throw new IllegalArgumentException("No field of type " + paramClass + " in " + this);
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
/*     */   public Object setTypedValue(Object paramObject) {
/* 181 */     Structure.StructField structField = findField(paramObject.getClass());
/* 182 */     if (structField != null) {
/* 183 */       this.activeField = structField;
/* 184 */       setFieldValue(structField.field, paramObject);
/* 185 */       return this;
/*     */     } 
/* 187 */     throw new IllegalArgumentException("No field of type " + paramObject.getClass() + " in " + this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Structure.StructField findField(Class<?> paramClass) {
/* 196 */     ensureAllocated();
/* 197 */     for (Structure.StructField structField : fields().values()) {
/* 198 */       if (structField.type.isAssignableFrom(paramClass)) {
/* 199 */         return structField;
/*     */       }
/*     */     } 
/* 202 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void writeField(Structure.StructField paramStructField) {
/* 208 */     if (paramStructField == this.activeField) {
/* 209 */       super.writeField(paramStructField);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object readField(Structure.StructField paramStructField) {
/* 219 */     if (paramStructField == this.activeField || (
/* 220 */       !Structure.class.isAssignableFrom(paramStructField.type) && 
/* 221 */       !String.class.isAssignableFrom(paramStructField.type) && 
/* 222 */       !WString.class.isAssignableFrom(paramStructField.type))) {
/* 223 */       return super.readField(paramStructField);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 229 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getNativeAlignment(Class<?> paramClass, Object paramObject, boolean paramBoolean) {
/* 235 */     return super.getNativeAlignment(paramClass, paramObject, true);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\Union.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */