/*     */ package org.apache.commons.lang3.builder;
/*     */ 
/*     */ import java.lang.reflect.AccessibleObject;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
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
/*     */ public class HashCodeBuilder
/*     */   implements Builder<Integer>
/*     */ {
/*     */   private static final int DEFAULT_INITIAL_VALUE = 17;
/*     */   private static final int DEFAULT_MULTIPLIER_VALUE = 37;
/* 123 */   private static final ThreadLocal<Set<IDKey>> REGISTRY = new ThreadLocal<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int iConstant;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Set<IDKey> getRegistry() {
/* 151 */     return REGISTRY.get();
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
/*     */   static boolean isRegistered(Object paramObject) {
/* 166 */     Set<IDKey> set = getRegistry();
/* 167 */     return (set != null && set.contains(new IDKey(paramObject)));
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
/*     */   private static void reflectionAppend(Object paramObject, Class<?> paramClass, HashCodeBuilder paramHashCodeBuilder, boolean paramBoolean, String[] paramArrayOfString) {
/* 188 */     if (isRegistered(paramObject)) {
/*     */       return;
/*     */     }
/*     */     try {
/* 192 */       register(paramObject);
/*     */       
/* 194 */       Field[] arrayOfField = paramClass.getDeclaredFields();
/* 195 */       Arrays.sort(arrayOfField, Comparator.comparing(Field::getName));
/* 196 */       AccessibleObject.setAccessible((AccessibleObject[])arrayOfField, true);
/* 197 */       for (Field field : arrayOfField) {
/* 198 */         if (!ArrayUtils.contains((Object[])paramArrayOfString, field.getName()) && 
/* 199 */           !field.getName().contains("$") && (paramBoolean || 
/* 200 */           !Modifier.isTransient(field.getModifiers())) && 
/* 201 */           !Modifier.isStatic(field.getModifiers()) && 
/* 202 */           !field.isAnnotationPresent((Class)HashCodeExclude.class)) {
/*     */           try {
/* 204 */             Object object = field.get(paramObject);
/* 205 */             paramHashCodeBuilder.append(object);
/* 206 */           } catch (IllegalAccessException illegalAccessException) {
/*     */ 
/*     */             
/* 209 */             throw new InternalError("Unexpected IllegalAccessException");
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } finally {
/* 214 */       unregister(paramObject);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int reflectionHashCode(int paramInt1, int paramInt2, Object paramObject) {
/* 259 */     return reflectionHashCode(paramInt1, paramInt2, paramObject, false, null, new String[0]);
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
/*     */   public static int reflectionHashCode(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean) {
/* 306 */     return reflectionHashCode(paramInt1, paramInt2, paramObject, paramBoolean, null, new String[0]);
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
/*     */   public static <T> int reflectionHashCode(int paramInt1, int paramInt2, T paramT, boolean paramBoolean, Class<? super T> paramClass, String... paramVarArgs) {
/* 361 */     Validate.notNull(paramT, "The object to build a hash code for must not be null", new Object[0]);
/* 362 */     HashCodeBuilder hashCodeBuilder = new HashCodeBuilder(paramInt1, paramInt2);
/* 363 */     Class<?> clazz = paramT.getClass();
/* 364 */     reflectionAppend(paramT, clazz, hashCodeBuilder, paramBoolean, paramVarArgs);
/* 365 */     while (clazz.getSuperclass() != null && clazz != paramClass) {
/* 366 */       clazz = clazz.getSuperclass();
/* 367 */       reflectionAppend(paramT, clazz, hashCodeBuilder, paramBoolean, paramVarArgs);
/*     */     } 
/* 369 */     return hashCodeBuilder.toHashCode();
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
/*     */   public static int reflectionHashCode(Object paramObject, boolean paramBoolean) {
/* 408 */     return reflectionHashCode(17, 37, paramObject, paramBoolean, null, new String[0]);
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
/*     */   public static int reflectionHashCode(Object paramObject, Collection<String> paramCollection) {
/* 448 */     return reflectionHashCode(paramObject, ReflectionToStringBuilder.toNoNullStringArray(paramCollection));
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
/*     */   public static int reflectionHashCode(Object paramObject, String... paramVarArgs) {
/* 489 */     return reflectionHashCode(17, 37, paramObject, false, null, paramVarArgs);
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
/*     */   private static void register(Object paramObject) {
/* 502 */     Set<IDKey> set = getRegistry();
/* 503 */     if (set == null) {
/* 504 */       set = new HashSet<>();
/* 505 */       REGISTRY.set(set);
/*     */     } 
/* 507 */     set.add(new IDKey(paramObject));
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
/*     */   private static void unregister(Object paramObject) {
/* 523 */     Set<IDKey> set = getRegistry();
/* 524 */     if (set != null) {
/* 525 */       set.remove(new IDKey(paramObject));
/* 526 */       if (set.isEmpty()) {
/* 527 */         REGISTRY.remove();
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
/* 540 */   private int iTotal = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HashCodeBuilder() {
/* 548 */     this.iConstant = 37;
/* 549 */     this.iTotal = 17;
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
/*     */   public HashCodeBuilder(int paramInt1, int paramInt2) {
/* 570 */     Validate.isTrue((paramInt1 % 2 != 0), "HashCodeBuilder requires an odd initial value", new Object[0]);
/* 571 */     Validate.isTrue((paramInt2 % 2 != 0), "HashCodeBuilder requires an odd multiplier", new Object[0]);
/* 572 */     this.iConstant = paramInt2;
/* 573 */     this.iTotal = paramInt1;
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
/*     */   public HashCodeBuilder append(boolean paramBoolean) {
/* 598 */     this.iTotal = this.iTotal * this.iConstant + (paramBoolean ? 0 : 1);
/* 599 */     return this;
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
/*     */   public HashCodeBuilder append(boolean[] paramArrayOfboolean) {
/* 612 */     if (paramArrayOfboolean == null) {
/* 613 */       this.iTotal *= this.iConstant;
/*     */     } else {
/* 615 */       for (boolean bool : paramArrayOfboolean) {
/* 616 */         append(bool);
/*     */       }
/*     */     } 
/* 619 */     return this;
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
/*     */   public HashCodeBuilder append(byte paramByte) {
/* 634 */     this.iTotal = this.iTotal * this.iConstant + paramByte;
/* 635 */     return this;
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
/*     */   public HashCodeBuilder append(byte[] paramArrayOfbyte) {
/* 650 */     if (paramArrayOfbyte == null) {
/* 651 */       this.iTotal *= this.iConstant;
/*     */     } else {
/* 653 */       for (byte b : paramArrayOfbyte) {
/* 654 */         append(b);
/*     */       }
/*     */     } 
/* 657 */     return this;
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
/*     */   public HashCodeBuilder append(char paramChar) {
/* 670 */     this.iTotal = this.iTotal * this.iConstant + paramChar;
/* 671 */     return this;
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
/*     */   public HashCodeBuilder append(char[] paramArrayOfchar) {
/* 684 */     if (paramArrayOfchar == null) {
/* 685 */       this.iTotal *= this.iConstant;
/*     */     } else {
/* 687 */       for (char c : paramArrayOfchar) {
/* 688 */         append(c);
/*     */       }
/*     */     } 
/* 691 */     return this;
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
/*     */   public HashCodeBuilder append(double paramDouble) {
/* 704 */     return append(Double.doubleToLongBits(paramDouble));
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
/*     */   public HashCodeBuilder append(double[] paramArrayOfdouble) {
/* 717 */     if (paramArrayOfdouble == null) {
/* 718 */       this.iTotal *= this.iConstant;
/*     */     } else {
/* 720 */       for (double d : paramArrayOfdouble) {
/* 721 */         append(d);
/*     */       }
/*     */     } 
/* 724 */     return this;
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
/*     */   public HashCodeBuilder append(float paramFloat) {
/* 737 */     this.iTotal = this.iTotal * this.iConstant + Float.floatToIntBits(paramFloat);
/* 738 */     return this;
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
/*     */   public HashCodeBuilder append(float[] paramArrayOffloat) {
/* 751 */     if (paramArrayOffloat == null) {
/* 752 */       this.iTotal *= this.iConstant;
/*     */     } else {
/* 754 */       for (float f : paramArrayOffloat) {
/* 755 */         append(f);
/*     */       }
/*     */     } 
/* 758 */     return this;
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
/*     */   public HashCodeBuilder append(int paramInt) {
/* 771 */     this.iTotal = this.iTotal * this.iConstant + paramInt;
/* 772 */     return this;
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
/*     */   public HashCodeBuilder append(int[] paramArrayOfint) {
/* 785 */     if (paramArrayOfint == null) {
/* 786 */       this.iTotal *= this.iConstant;
/*     */     } else {
/* 788 */       for (int i : paramArrayOfint) {
/* 789 */         append(i);
/*     */       }
/*     */     } 
/* 792 */     return this;
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
/*     */   public HashCodeBuilder append(long paramLong) {
/* 809 */     this.iTotal = this.iTotal * this.iConstant + (int)(paramLong ^ paramLong >> 32L);
/* 810 */     return this;
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
/*     */   public HashCodeBuilder append(long[] paramArrayOflong) {
/* 823 */     if (paramArrayOflong == null) {
/* 824 */       this.iTotal *= this.iConstant;
/*     */     } else {
/* 826 */       for (long l : paramArrayOflong) {
/* 827 */         append(l);
/*     */       }
/*     */     } 
/* 830 */     return this;
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
/*     */   public HashCodeBuilder append(Object paramObject) {
/* 843 */     if (paramObject == null) {
/* 844 */       this.iTotal *= this.iConstant;
/*     */     
/*     */     }
/* 847 */     else if (paramObject.getClass().isArray()) {
/*     */ 
/*     */       
/* 850 */       appendArray(paramObject);
/*     */     } else {
/* 852 */       this.iTotal = this.iTotal * this.iConstant + paramObject.hashCode();
/*     */     } 
/*     */     
/* 855 */     return this;
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
/*     */   private void appendArray(Object paramObject) {
/* 869 */     if (paramObject instanceof long[]) {
/* 870 */       append((long[])paramObject);
/* 871 */     } else if (paramObject instanceof int[]) {
/* 872 */       append((int[])paramObject);
/* 873 */     } else if (paramObject instanceof short[]) {
/* 874 */       append((short[])paramObject);
/* 875 */     } else if (paramObject instanceof char[]) {
/* 876 */       append((char[])paramObject);
/* 877 */     } else if (paramObject instanceof byte[]) {
/* 878 */       append((byte[])paramObject);
/* 879 */     } else if (paramObject instanceof double[]) {
/* 880 */       append((double[])paramObject);
/* 881 */     } else if (paramObject instanceof float[]) {
/* 882 */       append((float[])paramObject);
/* 883 */     } else if (paramObject instanceof boolean[]) {
/* 884 */       append((boolean[])paramObject);
/*     */     } else {
/*     */       
/* 887 */       append((Object[])paramObject);
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
/*     */   public HashCodeBuilder append(Object[] paramArrayOfObject) {
/* 901 */     if (paramArrayOfObject == null) {
/* 902 */       this.iTotal *= this.iConstant;
/*     */     } else {
/* 904 */       for (Object object : paramArrayOfObject) {
/* 905 */         append(object);
/*     */       }
/*     */     } 
/* 908 */     return this;
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
/*     */   public HashCodeBuilder append(short paramShort) {
/* 921 */     this.iTotal = this.iTotal * this.iConstant + paramShort;
/* 922 */     return this;
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
/*     */   public HashCodeBuilder append(short[] paramArrayOfshort) {
/* 935 */     if (paramArrayOfshort == null) {
/* 936 */       this.iTotal *= this.iConstant;
/*     */     } else {
/* 938 */       for (short s : paramArrayOfshort) {
/* 939 */         append(s);
/*     */       }
/*     */     } 
/* 942 */     return this;
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
/*     */   public HashCodeBuilder appendSuper(int paramInt) {
/* 956 */     this.iTotal = this.iTotal * this.iConstant + paramInt;
/* 957 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int toHashCode() {
/* 968 */     return this.iTotal;
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
/*     */   public Integer build() {
/* 980 */     return Integer.valueOf(toHashCode());
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
/*     */   public int hashCode() {
/* 994 */     return toHashCode();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\builder\HashCodeBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */