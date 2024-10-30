/*     */ package com.sun.jna;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
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
/*     */ public class DefaultTypeMapper
/*     */   implements TypeMapper
/*     */ {
/*     */   private static class Entry
/*     */   {
/*     */     public Class<?> type;
/*     */     public Object converter;
/*     */     
/*     */     public Entry(Class<?> param1Class, Object param1Object) {
/*  50 */       this.type = param1Class;
/*  51 */       this.converter = param1Object;
/*     */     }
/*     */   }
/*     */   
/*  55 */   private List<Entry> toNativeConverters = new ArrayList<Entry>();
/*  56 */   private List<Entry> fromNativeConverters = new ArrayList<Entry>();
/*     */   
/*     */   private Class<?> getAltClass(Class<?> paramClass) {
/*  59 */     if (paramClass == Boolean.class)
/*  60 */       return boolean.class; 
/*  61 */     if (paramClass == boolean.class)
/*  62 */       return Boolean.class; 
/*  63 */     if (paramClass == Byte.class)
/*  64 */       return byte.class; 
/*  65 */     if (paramClass == byte.class)
/*  66 */       return Byte.class; 
/*  67 */     if (paramClass == Character.class)
/*  68 */       return char.class; 
/*  69 */     if (paramClass == char.class)
/*  70 */       return Character.class; 
/*  71 */     if (paramClass == Short.class)
/*  72 */       return short.class; 
/*  73 */     if (paramClass == short.class)
/*  74 */       return Short.class; 
/*  75 */     if (paramClass == Integer.class)
/*  76 */       return int.class; 
/*  77 */     if (paramClass == int.class)
/*  78 */       return Integer.class; 
/*  79 */     if (paramClass == Long.class)
/*  80 */       return long.class; 
/*  81 */     if (paramClass == long.class)
/*  82 */       return Long.class; 
/*  83 */     if (paramClass == Float.class)
/*  84 */       return float.class; 
/*  85 */     if (paramClass == float.class)
/*  86 */       return Float.class; 
/*  87 */     if (paramClass == Double.class)
/*  88 */       return double.class; 
/*  89 */     if (paramClass == double.class) {
/*  90 */       return Double.class;
/*     */     }
/*  92 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addToNativeConverter(Class<?> paramClass, ToNativeConverter paramToNativeConverter) {
/* 102 */     this.toNativeConverters.add(new Entry(paramClass, paramToNativeConverter));
/* 103 */     Class<?> clazz = getAltClass(paramClass);
/* 104 */     if (clazz != null) {
/* 105 */       this.toNativeConverters.add(new Entry(clazz, paramToNativeConverter));
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
/*     */   public void addFromNativeConverter(Class<?> paramClass, FromNativeConverter paramFromNativeConverter) {
/* 117 */     this.fromNativeConverters.add(new Entry(paramClass, paramFromNativeConverter));
/* 118 */     Class<?> clazz = getAltClass(paramClass);
/* 119 */     if (clazz != null) {
/* 120 */       this.fromNativeConverters.add(new Entry(clazz, paramFromNativeConverter));
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
/*     */   public void addTypeConverter(Class<?> paramClass, TypeConverter paramTypeConverter) {
/* 133 */     addFromNativeConverter(paramClass, paramTypeConverter);
/* 134 */     addToNativeConverter(paramClass, paramTypeConverter);
/*     */   }
/*     */   
/*     */   private Object lookupConverter(Class<?> paramClass, Collection<? extends Entry> paramCollection) {
/* 138 */     for (Entry entry : paramCollection) {
/* 139 */       if (entry.type.isAssignableFrom(paramClass)) {
/* 140 */         return entry.converter;
/*     */       }
/*     */     } 
/* 143 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public FromNativeConverter getFromNativeConverter(Class<?> paramClass) {
/* 148 */     return (FromNativeConverter)lookupConverter(paramClass, this.fromNativeConverters);
/*     */   }
/*     */ 
/*     */   
/*     */   public ToNativeConverter getToNativeConverter(Class<?> paramClass) {
/* 153 */     return (ToNativeConverter)lookupConverter(paramClass, this.toNativeConverters);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\DefaultTypeMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */