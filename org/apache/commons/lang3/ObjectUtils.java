/*      */ package org.apache.commons.lang3;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.Serializable;
/*      */ import java.lang.reflect.Array;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.lang.reflect.Method;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.TreeSet;
/*      */ import java.util.function.Supplier;
/*      */ import org.apache.commons.lang3.exception.CloneFailedException;
/*      */ import org.apache.commons.lang3.mutable.MutableInt;
/*      */ import org.apache.commons.lang3.text.StrBuilder;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ObjectUtils
/*      */ {
/*      */   private static final char AT_SIGN = '@';
/*      */   
/*      */   public static class Null
/*      */     implements Serializable
/*      */   {
/*      */     private static final long serialVersionUID = 7092611880189329093L;
/*      */     
/*      */     private Object readResolve() {
/*   87 */       return ObjectUtils.NULL;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  108 */   public static final Null NULL = new Null();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean allNull(Object... paramVarArgs) {
/*  133 */     return !anyNotNull(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean allNotNull(Object... paramVarArgs) {
/*  162 */     if (paramVarArgs == null) {
/*  163 */       return false;
/*      */     }
/*      */     
/*  166 */     for (Object object : paramVarArgs) {
/*  167 */       if (object == null) {
/*  168 */         return false;
/*      */       }
/*      */     } 
/*      */     
/*  172 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean anyNull(Object... paramVarArgs) {
/*  200 */     return !allNotNull(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean anyNotNull(Object... paramVarArgs) {
/*  227 */     return (firstNonNull(paramVarArgs) != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T clone(T paramT) {
/*  242 */     if (paramT instanceof Cloneable) {
/*      */       Object object;
/*  244 */       if (paramT.getClass().isArray()) {
/*  245 */         Class<?> clazz = paramT.getClass().getComponentType();
/*  246 */         if (clazz.isPrimitive()) {
/*  247 */           int i = Array.getLength(paramT);
/*  248 */           object = Array.newInstance(clazz, i);
/*  249 */           while (i-- > 0) {
/*  250 */             Array.set(object, i, Array.get(paramT, i));
/*      */           }
/*      */         } else {
/*  253 */           object = ((Object[])paramT).clone();
/*      */         } 
/*      */       } else {
/*      */         try {
/*  257 */           Method method = paramT.getClass().getMethod("clone", new Class[0]);
/*  258 */           object = method.invoke(paramT, new Object[0]);
/*  259 */         } catch (NoSuchMethodException noSuchMethodException) {
/*  260 */           throw new CloneFailedException("Cloneable type " + paramT
/*  261 */               .getClass().getName() + " has no clone method", noSuchMethodException);
/*      */         }
/*  263 */         catch (IllegalAccessException illegalAccessException) {
/*  264 */           throw new CloneFailedException("Cannot clone Cloneable type " + paramT
/*  265 */               .getClass().getName(), illegalAccessException);
/*  266 */         } catch (InvocationTargetException invocationTargetException) {
/*  267 */           throw new CloneFailedException("Exception cloning Cloneable type " + paramT
/*  268 */               .getClass().getName(), invocationTargetException.getCause());
/*      */         } 
/*      */       } 
/*      */       
/*  272 */       return (T)object;
/*      */     } 
/*      */ 
/*      */     
/*  276 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T cloneIfPossible(T paramT) {
/*  296 */     T t = (T)clone((Object)paramT);
/*  297 */     return (t == null) ? paramT : t;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends Comparable<? super T>> int compare(T paramT1, T paramT2) {
/*  311 */     return compare(paramT1, paramT2, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends Comparable<? super T>> int compare(T paramT1, T paramT2, boolean paramBoolean) {
/*  328 */     if (paramT1 == paramT2)
/*  329 */       return 0; 
/*  330 */     if (paramT1 == null)
/*  331 */       return paramBoolean ? 1 : -1; 
/*  332 */     if (paramT2 == null) {
/*  333 */       return paramBoolean ? -1 : 1;
/*      */     }
/*  335 */     return paramT1.compareTo(paramT2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean CONST(boolean paramBoolean) {
/*  356 */     return paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte CONST(byte paramByte) {
/*  377 */     return paramByte;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static char CONST(char paramChar) {
/*  398 */     return paramChar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static double CONST(double paramDouble) {
/*  419 */     return paramDouble;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float CONST(float paramFloat) {
/*  440 */     return paramFloat;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int CONST(int paramInt) {
/*  461 */     return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long CONST(long paramLong) {
/*  482 */     return paramLong;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static short CONST(short paramShort) {
/*  503 */     return paramShort;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T CONST(T paramT) {
/*  525 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte CONST_BYTE(int paramInt) {
/*  549 */     if (paramInt < -128 || paramInt > 127) {
/*  550 */       throw new IllegalArgumentException("Supplied value must be a valid byte literal between -128 and 127: [" + paramInt + "]");
/*      */     }
/*  552 */     return (byte)paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static short CONST_SHORT(int paramInt) {
/*  576 */     if (paramInt < -32768 || paramInt > 32767) {
/*  577 */       throw new IllegalArgumentException("Supplied value must be a valid byte literal between -32768 and 32767: [" + paramInt + "]");
/*      */     }
/*  579 */     return (short)paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T defaultIfNull(T paramT1, T paramT2) {
/*  600 */     return (paramT1 != null) ? paramT1 : paramT2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static boolean equals(Object paramObject1, Object paramObject2) {
/*  628 */     if (paramObject1 == paramObject2) {
/*  629 */       return true;
/*      */     }
/*  631 */     if (paramObject1 == null || paramObject2 == null) {
/*  632 */       return false;
/*      */     }
/*  634 */     return paramObject1.equals(paramObject2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SafeVarargs
/*      */   public static <T> T firstNonNull(T... paramVarArgs) {
/*  661 */     if (paramVarArgs != null) {
/*  662 */       for (T t : paramVarArgs) {
/*  663 */         if (t != null) {
/*  664 */           return t;
/*      */         }
/*      */       } 
/*      */     }
/*  668 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SafeVarargs
/*      */   public static <T> T getFirstNonNull(Supplier<T>... paramVarArgs) {
/*  697 */     if (paramVarArgs != null) {
/*  698 */       for (Supplier<T> supplier : paramVarArgs) {
/*  699 */         if (supplier != null) {
/*  700 */           T t = supplier.get();
/*  701 */           if (t != null) {
/*  702 */             return t;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     }
/*  707 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T getIfNull(T paramT, Supplier<T> paramSupplier) {
/*  736 */     return (paramT != null) ? paramT : ((paramSupplier == null) ? null : paramSupplier.get());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static int hashCode(Object paramObject) {
/*  757 */     return (paramObject == null) ? 0 : paramObject.hashCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static int hashCodeMulti(Object... paramVarArgs) {
/*  784 */     int i = 1;
/*  785 */     if (paramVarArgs != null) {
/*  786 */       for (Object object : paramVarArgs) {
/*  787 */         int j = hashCode(object);
/*  788 */         i = i * 31 + j;
/*      */       } 
/*      */     }
/*  791 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void identityToString(Appendable paramAppendable, Object paramObject) throws IOException {
/*  811 */     Validate.notNull(paramObject, "Cannot get the toString of a null object", new Object[0]);
/*  812 */     paramAppendable.append(paramObject.getClass().getName())
/*  813 */       .append('@')
/*  814 */       .append(Integer.toHexString(System.identityHashCode(paramObject)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String identityToString(Object paramObject) {
/*  836 */     if (paramObject == null) {
/*  837 */       return null;
/*      */     }
/*  839 */     String str1 = paramObject.getClass().getName();
/*  840 */     String str2 = Integer.toHexString(System.identityHashCode(paramObject));
/*  841 */     StringBuilder stringBuilder = new StringBuilder(str1.length() + 1 + str2.length());
/*      */     
/*  843 */     stringBuilder.append(str1)
/*  844 */       .append('@')
/*  845 */       .append(str2);
/*      */     
/*  847 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void identityToString(StrBuilder paramStrBuilder, Object paramObject) {
/*  869 */     Validate.notNull(paramObject, "Cannot get the toString of a null object", new Object[0]);
/*  870 */     String str1 = paramObject.getClass().getName();
/*  871 */     String str2 = Integer.toHexString(System.identityHashCode(paramObject));
/*  872 */     paramStrBuilder.ensureCapacity(paramStrBuilder.length() + str1.length() + 1 + str2.length());
/*  873 */     paramStrBuilder.append(str1)
/*  874 */       .append('@')
/*  875 */       .append(str2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void identityToString(StringBuffer paramStringBuffer, Object paramObject) {
/*  894 */     Validate.notNull(paramObject, "Cannot get the toString of a null object", new Object[0]);
/*  895 */     String str1 = paramObject.getClass().getName();
/*  896 */     String str2 = Integer.toHexString(System.identityHashCode(paramObject));
/*  897 */     paramStringBuffer.ensureCapacity(paramStringBuffer.length() + str1.length() + 1 + str2.length());
/*  898 */     paramStringBuffer.append(str1)
/*  899 */       .append('@')
/*  900 */       .append(str2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void identityToString(StringBuilder paramStringBuilder, Object paramObject) {
/*  919 */     Validate.notNull(paramObject, "Cannot get the toString of a null object", new Object[0]);
/*  920 */     String str1 = paramObject.getClass().getName();
/*  921 */     String str2 = Integer.toHexString(System.identityHashCode(paramObject));
/*  922 */     paramStringBuilder.ensureCapacity(paramStringBuilder.length() + str1.length() + 1 + str2.length());
/*  923 */     paramStringBuilder.append(str1)
/*  924 */       .append('@')
/*  925 */       .append(str2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(Object paramObject) {
/*  978 */     if (paramObject == null) {
/*  979 */       return true;
/*      */     }
/*  981 */     if (paramObject instanceof CharSequence) {
/*  982 */       return (((CharSequence)paramObject).length() == 0);
/*      */     }
/*  984 */     if (paramObject.getClass().isArray()) {
/*  985 */       return (Array.getLength(paramObject) == 0);
/*      */     }
/*  987 */     if (paramObject instanceof Collection) {
/*  988 */       return ((Collection)paramObject).isEmpty();
/*      */     }
/*  990 */     if (paramObject instanceof Map) {
/*  991 */       return ((Map)paramObject).isEmpty();
/*      */     }
/*  993 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNotEmpty(Object paramObject) {
/* 1022 */     return !isEmpty(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SafeVarargs
/*      */   public static <T extends Comparable<? super T>> T max(T... paramVarArgs) {
/* 1040 */     T t = null;
/* 1041 */     if (paramVarArgs != null) {
/* 1042 */       for (T t1 : paramVarArgs) {
/* 1043 */         if (compare(t1, t, false) > 0) {
/* 1044 */           t = t1;
/*      */         }
/*      */       } 
/*      */     }
/* 1048 */     return t;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SafeVarargs
/*      */   public static <T> T median(Comparator<T> paramComparator, T... paramVarArgs) {
/* 1064 */     Validate.notEmpty(paramVarArgs, "null/empty items", new Object[0]);
/* 1065 */     Validate.noNullElements(paramVarArgs);
/* 1066 */     Validate.notNull(paramComparator, "null comparator", new Object[0]);
/* 1067 */     TreeSet<T> treeSet = new TreeSet<>(paramComparator);
/* 1068 */     Collections.addAll(treeSet, paramVarArgs);
/*      */ 
/*      */     
/* 1071 */     return (T)treeSet.toArray()[(treeSet.size() - 1) / 2];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SafeVarargs
/*      */   public static <T extends Comparable<? super T>> T median(T... paramVarArgs) {
/* 1087 */     Validate.notEmpty(paramVarArgs);
/* 1088 */     Validate.noNullElements(paramVarArgs);
/* 1089 */     TreeSet<? super T> treeSet = new TreeSet();
/* 1090 */     Collections.addAll(treeSet, paramVarArgs);
/*      */     
/* 1092 */     return (T)treeSet.toArray()[(treeSet.size() - 1) / 2];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SafeVarargs
/*      */   public static <T extends Comparable<? super T>> T min(T... paramVarArgs) {
/* 1113 */     T t = null;
/* 1114 */     if (paramVarArgs != null) {
/* 1115 */       for (T t1 : paramVarArgs) {
/* 1116 */         if (compare(t1, t, true) < 0) {
/* 1117 */           t = t1;
/*      */         }
/*      */       } 
/*      */     }
/* 1121 */     return t;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SafeVarargs
/*      */   public static <T> T mode(T... paramVarArgs) {
/* 1137 */     if (ArrayUtils.isNotEmpty(paramVarArgs)) {
/* 1138 */       HashMap<Object, Object> hashMap = new HashMap<>(paramVarArgs.length);
/* 1139 */       for (T t : paramVarArgs) {
/* 1140 */         MutableInt mutableInt = (MutableInt)hashMap.get(t);
/* 1141 */         if (mutableInt == null) {
/* 1142 */           hashMap.put(t, new MutableInt(1));
/*      */         } else {
/* 1144 */           mutableInt.increment();
/*      */         } 
/*      */       } 
/* 1147 */       Object object = null;
/* 1148 */       int i = 0;
/* 1149 */       for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
/* 1150 */         int j = ((MutableInt)entry.getValue()).intValue();
/* 1151 */         if (j == i) {
/* 1152 */           object = null; continue;
/* 1153 */         }  if (j > i) {
/* 1154 */           i = j;
/* 1155 */           object = entry.getKey();
/*      */         } 
/*      */       } 
/* 1158 */       return (T)object;
/*      */     } 
/* 1160 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean notEqual(Object paramObject1, Object paramObject2) {
/* 1183 */     return !equals(paramObject1, paramObject2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String toString(Object paramObject) {
/* 1210 */     return (paramObject == null) ? "" : paramObject.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String toString(Object paramObject, String paramString) {
/* 1236 */     return (paramObject == null) ? paramString : paramObject.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(Object paramObject, Supplier<String> paramSupplier) {
/* 1260 */     return (paramObject == null) ? ((paramSupplier == null) ? null : paramSupplier.get()) : paramObject.toString();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\ObjectUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */