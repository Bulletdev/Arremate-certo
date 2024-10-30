/*     */ package org.apache.commons.lang3.builder;
/*     */ 
/*     */ import java.lang.reflect.AccessibleObject;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import org.apache.commons.lang3.ArrayUtils;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReflectionToStringBuilder
/*     */   extends ToStringBuilder
/*     */ {
/*     */   public static String toString(Object paramObject) {
/* 130 */     return toString(paramObject, (ToStringStyle)null, false, false, (Class<? super Object>)null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toString(Object paramObject, ToStringStyle paramToStringStyle) {
/* 165 */     return toString(paramObject, paramToStringStyle, false, false, (Class<? super Object>)null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toString(Object paramObject, ToStringStyle paramToStringStyle, boolean paramBoolean) {
/* 206 */     return toString(paramObject, paramToStringStyle, paramBoolean, false, (Class<? super Object>)null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toString(Object paramObject, ToStringStyle paramToStringStyle, boolean paramBoolean1, boolean paramBoolean2) {
/* 255 */     return toString(paramObject, paramToStringStyle, paramBoolean1, paramBoolean2, (Class<? super Object>)null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> String toString(T paramT, ToStringStyle paramToStringStyle, boolean paramBoolean1, boolean paramBoolean2, Class<? super T> paramClass) {
/* 311 */     return (new ReflectionToStringBuilder(paramT, paramToStringStyle, null, paramClass, paramBoolean1, paramBoolean2))
/* 312 */       .toString();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> String toString(T paramT, ToStringStyle paramToStringStyle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Class<? super T> paramClass) {
/* 370 */     return (new ReflectionToStringBuilder(paramT, paramToStringStyle, null, paramClass, paramBoolean1, paramBoolean2, paramBoolean3))
/* 371 */       .toString();
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
/*     */   public static String toStringExclude(Object paramObject, Collection<String> paramCollection) {
/* 384 */     return toStringExclude(paramObject, toNoNullStringArray(paramCollection));
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
/*     */   static String[] toNoNullStringArray(Collection<String> paramCollection) {
/* 397 */     if (paramCollection == null) {
/* 398 */       return ArrayUtils.EMPTY_STRING_ARRAY;
/*     */     }
/* 400 */     return toNoNullStringArray(paramCollection.toArray());
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
/*     */   static String[] toNoNullStringArray(Object[] paramArrayOfObject) {
/* 413 */     ArrayList<String> arrayList = new ArrayList(paramArrayOfObject.length);
/* 414 */     for (Object object : paramArrayOfObject) {
/* 415 */       if (object != null) {
/* 416 */         arrayList.add(object.toString());
/*     */       }
/*     */     } 
/* 419 */     return arrayList.<String>toArray(ArrayUtils.EMPTY_STRING_ARRAY);
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
/*     */   public static String toStringExclude(Object paramObject, String... paramVarArgs) {
/* 433 */     return (new ReflectionToStringBuilder(paramObject)).setExcludeFieldNames(paramVarArgs).toString();
/*     */   }
/*     */   
/*     */   private static Object checkNotNull(Object paramObject) {
/* 437 */     return Validate.notNull(paramObject, "The Object passed in should not be null.", new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean appendStatics = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean appendTransients = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean excludeNullValues;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String[] excludeFieldNames;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 465 */   private Class<?> upToClass = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReflectionToStringBuilder(Object paramObject) {
/* 482 */     super(checkNotNull(paramObject));
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
/*     */   public ReflectionToStringBuilder(Object paramObject, ToStringStyle paramToStringStyle) {
/* 502 */     super(checkNotNull(paramObject), paramToStringStyle);
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
/*     */ 
/*     */   
/*     */   public ReflectionToStringBuilder(Object paramObject, ToStringStyle paramToStringStyle, StringBuffer paramStringBuffer) {
/* 528 */     super(checkNotNull(paramObject), paramToStringStyle, paramStringBuffer);
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
/*     */   
/*     */   public <T> ReflectionToStringBuilder(T paramT, ToStringStyle paramToStringStyle, StringBuffer paramStringBuffer, Class<? super T> paramClass, boolean paramBoolean1, boolean paramBoolean2) {
/* 553 */     super(checkNotNull(paramT), paramToStringStyle, paramStringBuffer);
/* 554 */     setUpToClass(paramClass);
/* 555 */     setAppendTransients(paramBoolean1);
/* 556 */     setAppendStatics(paramBoolean2);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> ReflectionToStringBuilder(T paramT, ToStringStyle paramToStringStyle, StringBuffer paramStringBuffer, Class<? super T> paramClass, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/* 584 */     super(checkNotNull(paramT), paramToStringStyle, paramStringBuffer);
/* 585 */     setUpToClass(paramClass);
/* 586 */     setAppendTransients(paramBoolean1);
/* 587 */     setAppendStatics(paramBoolean2);
/* 588 */     setExcludeNullValues(paramBoolean3);
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
/*     */   protected boolean accept(Field paramField) {
/* 604 */     if (paramField.getName().indexOf('$') != -1)
/*     */     {
/* 606 */       return false;
/*     */     }
/* 608 */     if (Modifier.isTransient(paramField.getModifiers()) && !isAppendTransients())
/*     */     {
/* 610 */       return false;
/*     */     }
/* 612 */     if (Modifier.isStatic(paramField.getModifiers()) && !isAppendStatics())
/*     */     {
/* 614 */       return false;
/*     */     }
/* 616 */     if (this.excludeFieldNames != null && 
/* 617 */       Arrays.binarySearch((Object[])this.excludeFieldNames, paramField.getName()) >= 0)
/*     */     {
/* 619 */       return false;
/*     */     }
/* 621 */     return !paramField.isAnnotationPresent((Class)ToStringExclude.class);
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
/*     */   protected void appendFieldsIn(Class<?> paramClass) {
/* 638 */     if (paramClass.isArray()) {
/* 639 */       reflectionAppendArray(getObject());
/*     */       
/*     */       return;
/*     */     } 
/* 643 */     Field[] arrayOfField = paramClass.getDeclaredFields();
/* 644 */     Arrays.sort(arrayOfField, Comparator.comparing(Field::getName));
/* 645 */     AccessibleObject.setAccessible((AccessibleObject[])arrayOfField, true);
/* 646 */     for (Field field : arrayOfField) {
/* 647 */       String str = field.getName();
/* 648 */       if (accept(field)) {
/*     */         
/*     */         try {
/*     */           
/* 652 */           Object object = getValue(field);
/* 653 */           if (!this.excludeNullValues || object != null) {
/* 654 */             append(str, object, !field.isAnnotationPresent((Class)ToStringSummary.class));
/*     */           }
/* 656 */         } catch (IllegalAccessException illegalAccessException) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 661 */           throw new InternalError("Unexpected IllegalAccessException: " + illegalAccessException.getMessage());
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getExcludeFieldNames() {
/* 671 */     return (String[])this.excludeFieldNames.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> getUpToClass() {
/* 682 */     return this.upToClass;
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
/*     */   protected Object getValue(Field paramField) throws IllegalAccessException {
/* 702 */     return paramField.get(getObject());
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
/*     */   public boolean isAppendStatics() {
/* 714 */     return this.appendStatics;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAppendTransients() {
/* 725 */     return this.appendTransients;
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
/*     */   public boolean isExcludeNullValues() {
/* 737 */     return this.excludeNullValues;
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
/*     */   public ReflectionToStringBuilder reflectionAppendArray(Object paramObject) {
/* 750 */     getStyle().reflectionAppendArrayDetail(getStringBuffer(), null, paramObject);
/* 751 */     return this;
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
/*     */   public void setAppendStatics(boolean paramBoolean) {
/* 764 */     this.appendStatics = paramBoolean;
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
/*     */   public void setAppendTransients(boolean paramBoolean) {
/* 776 */     this.appendTransients = paramBoolean;
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
/*     */   public void setExcludeNullValues(boolean paramBoolean) {
/* 789 */     this.excludeNullValues = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReflectionToStringBuilder setExcludeFieldNames(String... paramVarArgs) {
/* 800 */     if (paramVarArgs == null) {
/* 801 */       this.excludeFieldNames = null;
/*     */     } else {
/*     */       
/* 804 */       this.excludeFieldNames = toNoNullStringArray((Object[])paramVarArgs);
/* 805 */       Arrays.sort((Object[])this.excludeFieldNames);
/*     */     } 
/* 807 */     return this;
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
/*     */   public void setUpToClass(Class<?> paramClass) {
/* 819 */     if (paramClass != null) {
/* 820 */       Object object = getObject();
/* 821 */       if (object != null && !paramClass.isInstance(object)) {
/* 822 */         throw new IllegalArgumentException("Specified class is not a superclass of the object");
/*     */       }
/*     */     } 
/* 825 */     this.upToClass = paramClass;
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
/*     */   public String toString() {
/* 837 */     if (getObject() == null) {
/* 838 */       return getStyle().getNullText();
/*     */     }
/* 840 */     Class<?> clazz = getObject().getClass();
/* 841 */     appendFieldsIn(clazz);
/* 842 */     while (clazz.getSuperclass() != null && clazz != getUpToClass()) {
/* 843 */       clazz = clazz.getSuperclass();
/* 844 */       appendFieldsIn(clazz);
/*     */     } 
/* 846 */     return super.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\builder\ReflectionToStringBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */