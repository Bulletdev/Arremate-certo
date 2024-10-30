/*     */ package org.apache.commons.lang3.reflect;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang3.ArrayUtils;
/*     */ import org.apache.commons.lang3.ClassUtils;
/*     */ import org.apache.commons.lang3.JavaVersion;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.SystemUtils;
/*     */ import org.apache.commons.lang3.Validate;
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
/*     */ public class FieldUtils
/*     */ {
/*     */   public static Field getField(Class<?> paramClass, String paramString) {
/*  66 */     Field field = getField(paramClass, paramString, false);
/*  67 */     MemberUtils.setAccessibleWorkaround(field);
/*  68 */     return field;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Field getField(Class<?> paramClass, String paramString, boolean paramBoolean) {
/*     */     Field field;
/*  89 */     Validate.notNull(paramClass, "The class must not be null", new Object[0]);
/*  90 */     Validate.isTrue(StringUtils.isNotBlank(paramString), "The field name must not be blank/empty", new Object[0]);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Class<?> clazz;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     for (clazz = paramClass; clazz != null; clazz = clazz.getSuperclass()) {
/*     */       try {
/* 108 */         Field field1 = clazz.getDeclaredField(paramString);
/*     */ 
/*     */         
/* 111 */         if (!Modifier.isPublic(field1.getModifiers()))
/* 112 */         { if (paramBoolean)
/* 113 */           { field1.setAccessible(true);
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 118 */             return field1; }  } else { return field1; } 
/* 119 */       } catch (NoSuchFieldException noSuchFieldException) {}
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 126 */     clazz = null;
/* 127 */     for (Class clazz1 : ClassUtils.getAllInterfaces(paramClass)) {
/*     */       try {
/* 129 */         Field field1 = clazz1.getField(paramString);
/* 130 */         Validate.isTrue((clazz == null), "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", new Object[] { paramString, paramClass });
/*     */         
/* 132 */         field = field1;
/* 133 */       } catch (NoSuchFieldException noSuchFieldException) {}
/*     */     } 
/*     */ 
/*     */     
/* 137 */     return field;
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
/*     */   public static Field getDeclaredField(Class<?> paramClass, String paramString) {
/* 152 */     return getDeclaredField(paramClass, paramString, false);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Field getDeclaredField(Class<?> paramClass, String paramString, boolean paramBoolean) {
/* 172 */     Validate.notNull(paramClass, "The class must not be null", new Object[0]);
/* 173 */     Validate.isTrue(StringUtils.isNotBlank(paramString), "The field name must not be blank/empty", new Object[0]);
/*     */     
/*     */     try {
/* 176 */       Field field = paramClass.getDeclaredField(paramString);
/* 177 */       if (!MemberUtils.isAccessible(field)) {
/* 178 */         if (paramBoolean) {
/* 179 */           field.setAccessible(true);
/*     */         } else {
/* 181 */           return null;
/*     */         } 
/*     */       }
/* 184 */       return field;
/* 185 */     } catch (NoSuchFieldException noSuchFieldException) {
/*     */ 
/*     */       
/* 188 */       return null;
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
/*     */   public static Field[] getAllFields(Class<?> paramClass) {
/* 202 */     List<Field> list = getAllFieldsList(paramClass);
/* 203 */     return list.<Field>toArray(ArrayUtils.EMPTY_FIELD_ARRAY);
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
/*     */   public static List<Field> getAllFieldsList(Class<?> paramClass) {
/* 217 */     Validate.notNull(paramClass, "The class must not be null", new Object[0]);
/* 218 */     ArrayList<? super Field> arrayList = new ArrayList();
/* 219 */     Class<?> clazz = paramClass;
/* 220 */     while (clazz != null) {
/* 221 */       Field[] arrayOfField = clazz.getDeclaredFields();
/* 222 */       Collections.addAll(arrayList, arrayOfField);
/* 223 */       clazz = clazz.getSuperclass();
/*     */     } 
/* 225 */     return (List)arrayList;
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
/*     */   public static Field[] getFieldsWithAnnotation(Class<?> paramClass, Class<? extends Annotation> paramClass1) {
/* 240 */     List<Field> list = getFieldsListWithAnnotation(paramClass, paramClass1);
/* 241 */     return list.<Field>toArray(ArrayUtils.EMPTY_FIELD_ARRAY);
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
/*     */   public static List<Field> getFieldsListWithAnnotation(Class<?> paramClass, Class<? extends Annotation> paramClass1) {
/* 256 */     Validate.notNull(paramClass1, "The annotation class must not be null", new Object[0]);
/* 257 */     List<Field> list = getAllFieldsList(paramClass);
/* 258 */     ArrayList<Field> arrayList = new ArrayList();
/* 259 */     for (Field field : list) {
/* 260 */       if (field.getAnnotation(paramClass1) != null) {
/* 261 */         arrayList.add(field);
/*     */       }
/*     */     } 
/* 264 */     return arrayList;
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
/*     */   public static Object readStaticField(Field paramField) throws IllegalAccessException {
/* 279 */     return readStaticField(paramField, false);
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
/*     */ 
/*     */   
/*     */   public static Object readStaticField(Field paramField, boolean paramBoolean) throws IllegalAccessException {
/* 297 */     Validate.notNull(paramField, "The field must not be null", new Object[0]);
/* 298 */     Validate.isTrue(Modifier.isStatic(paramField.getModifiers()), "The field '%s' is not static", new Object[] { paramField.getName() });
/* 299 */     return readField(paramField, (Object)null, paramBoolean);
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
/*     */ 
/*     */   
/*     */   public static Object readStaticField(Class<?> paramClass, String paramString) throws IllegalAccessException {
/* 317 */     return readStaticField(paramClass, paramString, false);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object readStaticField(Class<?> paramClass, String paramString, boolean paramBoolean) throws IllegalAccessException {
/* 339 */     Field field = getField(paramClass, paramString, paramBoolean);
/* 340 */     Validate.notNull(field, "Cannot locate field '%s' on %s", new Object[] { paramString, paramClass });
/*     */     
/* 342 */     return readStaticField(field, false);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object readDeclaredStaticField(Class<?> paramClass, String paramString) throws IllegalAccessException {
/* 361 */     return readDeclaredStaticField(paramClass, paramString, false);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object readDeclaredStaticField(Class<?> paramClass, String paramString, boolean paramBoolean) throws IllegalAccessException {
/* 383 */     Field field = getDeclaredField(paramClass, paramString, paramBoolean);
/* 384 */     Validate.notNull(field, "Cannot locate declared field %s.%s", new Object[] { paramClass.getName(), paramString });
/*     */     
/* 386 */     return readStaticField(field, false);
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
/*     */   
/*     */   public static Object readField(Field paramField, Object paramObject) throws IllegalAccessException {
/* 403 */     return readField(paramField, paramObject, false);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object readField(Field paramField, Object paramObject, boolean paramBoolean) throws IllegalAccessException {
/* 423 */     Validate.notNull(paramField, "The field must not be null", new Object[0]);
/* 424 */     if (paramBoolean && !paramField.isAccessible()) {
/* 425 */       paramField.setAccessible(true);
/*     */     } else {
/* 427 */       MemberUtils.setAccessibleWorkaround(paramField);
/*     */     } 
/* 429 */     return paramField.get(paramObject);
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
/*     */   
/*     */   public static Object readField(Object paramObject, String paramString) throws IllegalAccessException {
/* 446 */     return readField(paramObject, paramString, false);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object readField(Object paramObject, String paramString, boolean paramBoolean) throws IllegalAccessException {
/* 467 */     Validate.notNull(paramObject, "target object must not be null", new Object[0]);
/* 468 */     Class<?> clazz = paramObject.getClass();
/* 469 */     Field field = getField(clazz, paramString, paramBoolean);
/* 470 */     Validate.isTrue((field != null), "Cannot locate field %s on %s", new Object[] { paramString, clazz });
/*     */     
/* 472 */     return readField(field, paramObject, false);
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
/*     */   
/*     */   public static Object readDeclaredField(Object paramObject, String paramString) throws IllegalAccessException {
/* 489 */     return readDeclaredField(paramObject, paramString, false);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object readDeclaredField(Object paramObject, String paramString, boolean paramBoolean) throws IllegalAccessException {
/* 510 */     Validate.notNull(paramObject, "target object must not be null", new Object[0]);
/* 511 */     Class<?> clazz = paramObject.getClass();
/* 512 */     Field field = getDeclaredField(clazz, paramString, paramBoolean);
/* 513 */     Validate.isTrue((field != null), "Cannot locate declared field %s.%s", new Object[] { clazz, paramString });
/*     */     
/* 515 */     return readField(field, paramObject, false);
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
/*     */   public static void writeStaticField(Field paramField, Object paramObject) throws IllegalAccessException {
/* 531 */     writeStaticField(paramField, paramObject, false);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeStaticField(Field paramField, Object paramObject, boolean paramBoolean) throws IllegalAccessException {
/* 551 */     Validate.notNull(paramField, "The field must not be null", new Object[0]);
/* 552 */     Validate.isTrue(Modifier.isStatic(paramField.getModifiers()), "The field %s.%s is not static", new Object[] { paramField.getDeclaringClass().getName(), paramField
/* 553 */           .getName() });
/* 554 */     writeField(paramField, (Object)null, paramObject, paramBoolean);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeStaticField(Class<?> paramClass, String paramString, Object paramObject) throws IllegalAccessException {
/* 573 */     writeStaticField(paramClass, paramString, paramObject, false);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeStaticField(Class<?> paramClass, String paramString, Object paramObject, boolean paramBoolean) throws IllegalAccessException {
/* 597 */     Field field = getField(paramClass, paramString, paramBoolean);
/* 598 */     Validate.notNull(field, "Cannot locate field %s on %s", new Object[] { paramString, paramClass });
/*     */     
/* 600 */     writeStaticField(field, paramObject, false);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeDeclaredStaticField(Class<?> paramClass, String paramString, Object paramObject) throws IllegalAccessException {
/* 619 */     writeDeclaredStaticField(paramClass, paramString, paramObject, false);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeDeclaredStaticField(Class<?> paramClass, String paramString, Object paramObject, boolean paramBoolean) throws IllegalAccessException {
/* 642 */     Field field = getDeclaredField(paramClass, paramString, paramBoolean);
/* 643 */     Validate.notNull(field, "Cannot locate declared field %s.%s", new Object[] { paramClass.getName(), paramString });
/*     */     
/* 645 */     writeField(field, (Object)null, paramObject, false);
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
/*     */   
/*     */   public static void writeField(Field paramField, Object paramObject1, Object paramObject2) throws IllegalAccessException {
/* 662 */     writeField(paramField, paramObject1, paramObject2, false);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeField(Field paramField, Object paramObject1, Object paramObject2, boolean paramBoolean) throws IllegalAccessException {
/* 685 */     Validate.notNull(paramField, "The field must not be null", new Object[0]);
/* 686 */     if (paramBoolean && !paramField.isAccessible()) {
/* 687 */       paramField.setAccessible(true);
/*     */     } else {
/* 689 */       MemberUtils.setAccessibleWorkaround(paramField);
/*     */     } 
/* 691 */     paramField.set(paramObject1, paramObject2);
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
/*     */   public static void removeFinalModifier(Field paramField) {
/* 704 */     removeFinalModifier(paramField, true);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static void removeFinalModifier(Field paramField, boolean paramBoolean) {
/* 725 */     Validate.notNull(paramField, "The field must not be null", new Object[0]);
/*     */     
/*     */     try {
/* 728 */       if (Modifier.isFinal(paramField.getModifiers())) {
/*     */         
/* 730 */         Field field = Field.class.getDeclaredField("modifiers");
/* 731 */         boolean bool = (paramBoolean && !field.isAccessible()) ? true : false;
/* 732 */         if (bool) {
/* 733 */           field.setAccessible(true);
/*     */         }
/*     */         try {
/* 736 */           field.setInt(paramField, paramField.getModifiers() & 0xFFFFFFEF);
/*     */         } finally {
/* 738 */           if (bool) {
/* 739 */             field.setAccessible(false);
/*     */           }
/*     */         } 
/*     */       } 
/* 743 */     } catch (NoSuchFieldException|IllegalAccessException noSuchFieldException) {
/* 744 */       if (SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_12)) {
/* 745 */         throw new UnsupportedOperationException("In java 12+ final cannot be removed.", noSuchFieldException);
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeField(Object paramObject1, String paramString, Object paramObject2) throws IllegalAccessException {
/* 770 */     writeField(paramObject1, paramString, paramObject2, false);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeField(Object paramObject1, String paramString, Object paramObject2, boolean paramBoolean) throws IllegalAccessException {
/* 794 */     Validate.notNull(paramObject1, "target object must not be null", new Object[0]);
/* 795 */     Class<?> clazz = paramObject1.getClass();
/* 796 */     Field field = getField(clazz, paramString, paramBoolean);
/* 797 */     Validate.isTrue((field != null), "Cannot locate declared field %s.%s", new Object[] { clazz.getName(), paramString });
/*     */     
/* 799 */     writeField(field, paramObject1, paramObject2, false);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeDeclaredField(Object paramObject1, String paramString, Object paramObject2) throws IllegalAccessException {
/* 818 */     writeDeclaredField(paramObject1, paramString, paramObject2, false);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeDeclaredField(Object paramObject1, String paramString, Object paramObject2, boolean paramBoolean) throws IllegalAccessException {
/* 842 */     Validate.notNull(paramObject1, "target object must not be null", new Object[0]);
/* 843 */     Class<?> clazz = paramObject1.getClass();
/* 844 */     Field field = getDeclaredField(clazz, paramString, paramBoolean);
/* 845 */     Validate.isTrue((field != null), "Cannot locate declared field %s.%s", new Object[] { clazz.getName(), paramString });
/*     */     
/* 847 */     writeField(field, paramObject1, paramObject2, false);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\reflect\FieldUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */