/*      */ package org.apache.commons.lang3;
/*      */ 
/*      */ import java.lang.reflect.Array;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Type;
/*      */ import java.util.Arrays;
/*      */ import java.util.BitSet;
/*      */ import java.util.Comparator;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Random;
/*      */ import org.apache.commons.lang3.builder.EqualsBuilder;
/*      */ import org.apache.commons.lang3.builder.HashCodeBuilder;
/*      */ import org.apache.commons.lang3.builder.ToStringBuilder;
/*      */ import org.apache.commons.lang3.builder.ToStringStyle;
/*      */ import org.apache.commons.lang3.math.NumberUtils;
/*      */ import org.apache.commons.lang3.mutable.MutableInt;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ArrayUtils
/*      */ {
/*   54 */   public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   59 */   public static final Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY = new Boolean[0];
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   64 */   public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   69 */   public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY = new Byte[0];
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   74 */   public static final char[] EMPTY_CHAR_ARRAY = new char[0];
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   79 */   public static final Character[] EMPTY_CHARACTER_OBJECT_ARRAY = new Character[0];
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   84 */   public static final Class<?>[] EMPTY_CLASS_ARRAY = new Class[0];
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   89 */   public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   94 */   public static final Double[] EMPTY_DOUBLE_OBJECT_ARRAY = new Double[0];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  101 */   public static final Field[] EMPTY_FIELD_ARRAY = new Field[0];
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  106 */   public static final float[] EMPTY_FLOAT_ARRAY = new float[0];
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  111 */   public static final Float[] EMPTY_FLOAT_OBJECT_ARRAY = new Float[0];
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  116 */   public static final int[] EMPTY_INT_ARRAY = new int[0];
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  121 */   public static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY = new Integer[0];
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  126 */   public static final long[] EMPTY_LONG_ARRAY = new long[0];
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  131 */   public static final Long[] EMPTY_LONG_OBJECT_ARRAY = new Long[0];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  138 */   public static final Method[] EMPTY_METHOD_ARRAY = new Method[0];
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  143 */   public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  148 */   public static final short[] EMPTY_SHORT_ARRAY = new short[0];
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  153 */   public static final Short[] EMPTY_SHORT_OBJECT_ARRAY = new Short[0];
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  158 */   public static final String[] EMPTY_STRING_ARRAY = new String[0];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  165 */   public static final Throwable[] EMPTY_THROWABLE_ARRAY = new Throwable[0];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  172 */   public static final Type[] EMPTY_TYPE_ARRAY = new Type[0];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int INDEX_NOT_FOUND = -1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean[] add(boolean[] paramArrayOfboolean, boolean paramBoolean) {
/*  203 */     boolean[] arrayOfBoolean = (boolean[])copyArrayGrow1(paramArrayOfboolean, boolean.class);
/*  204 */     arrayOfBoolean[arrayOfBoolean.length - 1] = paramBoolean;
/*  205 */     return arrayOfBoolean;
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
/*      */   @Deprecated
/*      */   public static boolean[] add(boolean[] paramArrayOfboolean, int paramInt, boolean paramBoolean) {
/*  239 */     return (boolean[])add(paramArrayOfboolean, paramInt, Boolean.valueOf(paramBoolean), boolean.class);
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
/*      */   public static byte[] add(byte[] paramArrayOfbyte, byte paramByte) {
/*  264 */     byte[] arrayOfByte = (byte[])copyArrayGrow1(paramArrayOfbyte, byte.class);
/*  265 */     arrayOfByte[arrayOfByte.length - 1] = paramByte;
/*  266 */     return arrayOfByte;
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
/*      */   @Deprecated
/*      */   public static byte[] add(byte[] paramArrayOfbyte, int paramInt, byte paramByte) {
/*  301 */     return (byte[])add(paramArrayOfbyte, paramInt, Byte.valueOf(paramByte), byte.class);
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
/*      */   public static char[] add(char[] paramArrayOfchar, char paramChar) {
/*  326 */     char[] arrayOfChar = (char[])copyArrayGrow1(paramArrayOfchar, char.class);
/*  327 */     arrayOfChar[arrayOfChar.length - 1] = paramChar;
/*  328 */     return arrayOfChar;
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
/*      */   @Deprecated
/*      */   public static char[] add(char[] paramArrayOfchar, int paramInt, char paramChar) {
/*  364 */     return (char[])add(paramArrayOfchar, paramInt, Character.valueOf(paramChar), char.class);
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
/*      */   public static double[] add(double[] paramArrayOfdouble, double paramDouble) {
/*  389 */     double[] arrayOfDouble = (double[])copyArrayGrow1(paramArrayOfdouble, double.class);
/*  390 */     arrayOfDouble[arrayOfDouble.length - 1] = paramDouble;
/*  391 */     return arrayOfDouble;
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
/*      */   @Deprecated
/*      */   public static double[] add(double[] paramArrayOfdouble, int paramInt, double paramDouble) {
/*  426 */     return (double[])add(paramArrayOfdouble, paramInt, Double.valueOf(paramDouble), double.class);
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
/*      */   public static float[] add(float[] paramArrayOffloat, float paramFloat) {
/*  451 */     float[] arrayOfFloat = (float[])copyArrayGrow1(paramArrayOffloat, float.class);
/*  452 */     arrayOfFloat[arrayOfFloat.length - 1] = paramFloat;
/*  453 */     return arrayOfFloat;
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
/*      */   @Deprecated
/*      */   public static float[] add(float[] paramArrayOffloat, int paramInt, float paramFloat) {
/*  488 */     return (float[])add(paramArrayOffloat, paramInt, Float.valueOf(paramFloat), float.class);
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
/*      */   public static int[] add(int[] paramArrayOfint, int paramInt) {
/*  513 */     int[] arrayOfInt = (int[])copyArrayGrow1(paramArrayOfint, int.class);
/*  514 */     arrayOfInt[arrayOfInt.length - 1] = paramInt;
/*  515 */     return arrayOfInt;
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
/*      */   @Deprecated
/*      */   public static int[] add(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/*  550 */     return (int[])add(paramArrayOfint, paramInt1, Integer.valueOf(paramInt2), int.class);
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
/*      */   @Deprecated
/*      */   public static long[] add(long[] paramArrayOflong, int paramInt, long paramLong) {
/*  585 */     return (long[])add(paramArrayOflong, paramInt, Long.valueOf(paramLong), long.class);
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
/*      */   public static long[] add(long[] paramArrayOflong, long paramLong) {
/*  610 */     long[] arrayOfLong = (long[])copyArrayGrow1(paramArrayOflong, long.class);
/*  611 */     arrayOfLong[arrayOfLong.length - 1] = paramLong;
/*  612 */     return arrayOfLong;
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
/*      */   private static Object add(Object paramObject1, int paramInt, Object paramObject2, Class<?> paramClass) {
/*  627 */     if (paramObject1 == null) {
/*  628 */       if (paramInt != 0) {
/*  629 */         throw new IndexOutOfBoundsException("Index: " + paramInt + ", Length: 0");
/*      */       }
/*  631 */       Object object1 = Array.newInstance(paramClass, 1);
/*  632 */       Array.set(object1, 0, paramObject2);
/*  633 */       return object1;
/*      */     } 
/*  635 */     int i = Array.getLength(paramObject1);
/*  636 */     if (paramInt > i || paramInt < 0) {
/*  637 */       throw new IndexOutOfBoundsException("Index: " + paramInt + ", Length: " + i);
/*      */     }
/*  639 */     Object object = Array.newInstance(paramClass, i + 1);
/*  640 */     System.arraycopy(paramObject1, 0, object, 0, paramInt);
/*  641 */     Array.set(object, paramInt, paramObject2);
/*  642 */     if (paramInt < i) {
/*  643 */       System.arraycopy(paramObject1, paramInt, object, paramInt + 1, i - paramInt);
/*      */     }
/*  645 */     return object;
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
/*      */   @Deprecated
/*      */   public static short[] add(short[] paramArrayOfshort, int paramInt, short paramShort) {
/*  680 */     return (short[])add(paramArrayOfshort, paramInt, Short.valueOf(paramShort), short.class);
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
/*      */   public static short[] add(short[] paramArrayOfshort, short paramShort) {
/*  705 */     short[] arrayOfShort = (short[])copyArrayGrow1(paramArrayOfshort, short.class);
/*  706 */     arrayOfShort[arrayOfShort.length - 1] = paramShort;
/*  707 */     return arrayOfShort;
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
/*      */   @Deprecated
/*      */   public static <T> T[] add(T[] paramArrayOfT, int paramInt, T paramT) {
/*  745 */     Class<?> clazz = null;
/*  746 */     if (paramArrayOfT != null) {
/*  747 */       clazz = paramArrayOfT.getClass().getComponentType();
/*  748 */     } else if (paramT != null) {
/*  749 */       clazz = paramT.getClass();
/*      */     } else {
/*  751 */       throw new IllegalArgumentException("Array and element cannot both be null");
/*      */     } 
/*      */     
/*  754 */     return (T[])add(paramArrayOfT, paramInt, paramT, clazz);
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
/*      */   public static <T> T[] add(T[] paramArrayOfT, T paramT) {
/*      */     Class<?> clazz;
/*  789 */     if (paramArrayOfT != null) {
/*  790 */       clazz = paramArrayOfT.getClass().getComponentType();
/*  791 */     } else if (paramT != null) {
/*  792 */       clazz = paramT.getClass();
/*      */     } else {
/*  794 */       throw new IllegalArgumentException("Arguments cannot both be null");
/*      */     } 
/*      */ 
/*      */     
/*  798 */     Object[] arrayOfObject = (Object[])copyArrayGrow1(paramArrayOfT, clazz);
/*  799 */     arrayOfObject[arrayOfObject.length - 1] = paramT;
/*  800 */     return (T[])arrayOfObject;
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
/*      */   public static boolean[] addAll(boolean[] paramArrayOfboolean1, boolean... paramVarArgs1) {
/*  821 */     if (paramArrayOfboolean1 == null)
/*  822 */       return clone(paramVarArgs1); 
/*  823 */     if (paramVarArgs1 == null) {
/*  824 */       return clone(paramArrayOfboolean1);
/*      */     }
/*  826 */     boolean[] arrayOfBoolean = new boolean[paramArrayOfboolean1.length + paramVarArgs1.length];
/*  827 */     System.arraycopy(paramArrayOfboolean1, 0, arrayOfBoolean, 0, paramArrayOfboolean1.length);
/*  828 */     System.arraycopy(paramVarArgs1, 0, arrayOfBoolean, paramArrayOfboolean1.length, paramVarArgs1.length);
/*  829 */     return arrayOfBoolean;
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
/*      */   public static byte[] addAll(byte[] paramArrayOfbyte1, byte... paramVarArgs1) {
/*  850 */     if (paramArrayOfbyte1 == null)
/*  851 */       return clone(paramVarArgs1); 
/*  852 */     if (paramVarArgs1 == null) {
/*  853 */       return clone(paramArrayOfbyte1);
/*      */     }
/*  855 */     byte[] arrayOfByte = new byte[paramArrayOfbyte1.length + paramVarArgs1.length];
/*  856 */     System.arraycopy(paramArrayOfbyte1, 0, arrayOfByte, 0, paramArrayOfbyte1.length);
/*  857 */     System.arraycopy(paramVarArgs1, 0, arrayOfByte, paramArrayOfbyte1.length, paramVarArgs1.length);
/*  858 */     return arrayOfByte;
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
/*      */   public static char[] addAll(char[] paramArrayOfchar1, char... paramVarArgs1) {
/*  879 */     if (paramArrayOfchar1 == null)
/*  880 */       return clone(paramVarArgs1); 
/*  881 */     if (paramVarArgs1 == null) {
/*  882 */       return clone(paramArrayOfchar1);
/*      */     }
/*  884 */     char[] arrayOfChar = new char[paramArrayOfchar1.length + paramVarArgs1.length];
/*  885 */     System.arraycopy(paramArrayOfchar1, 0, arrayOfChar, 0, paramArrayOfchar1.length);
/*  886 */     System.arraycopy(paramVarArgs1, 0, arrayOfChar, paramArrayOfchar1.length, paramVarArgs1.length);
/*  887 */     return arrayOfChar;
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
/*      */   public static double[] addAll(double[] paramArrayOfdouble1, double... paramVarArgs1) {
/*  908 */     if (paramArrayOfdouble1 == null)
/*  909 */       return clone(paramVarArgs1); 
/*  910 */     if (paramVarArgs1 == null) {
/*  911 */       return clone(paramArrayOfdouble1);
/*      */     }
/*  913 */     double[] arrayOfDouble = new double[paramArrayOfdouble1.length + paramVarArgs1.length];
/*  914 */     System.arraycopy(paramArrayOfdouble1, 0, arrayOfDouble, 0, paramArrayOfdouble1.length);
/*  915 */     System.arraycopy(paramVarArgs1, 0, arrayOfDouble, paramArrayOfdouble1.length, paramVarArgs1.length);
/*  916 */     return arrayOfDouble;
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
/*      */   public static float[] addAll(float[] paramArrayOffloat1, float... paramVarArgs1) {
/*  937 */     if (paramArrayOffloat1 == null)
/*  938 */       return clone(paramVarArgs1); 
/*  939 */     if (paramVarArgs1 == null) {
/*  940 */       return clone(paramArrayOffloat1);
/*      */     }
/*  942 */     float[] arrayOfFloat = new float[paramArrayOffloat1.length + paramVarArgs1.length];
/*  943 */     System.arraycopy(paramArrayOffloat1, 0, arrayOfFloat, 0, paramArrayOffloat1.length);
/*  944 */     System.arraycopy(paramVarArgs1, 0, arrayOfFloat, paramArrayOffloat1.length, paramVarArgs1.length);
/*  945 */     return arrayOfFloat;
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
/*      */   public static int[] addAll(int[] paramArrayOfint1, int... paramVarArgs1) {
/*  966 */     if (paramArrayOfint1 == null)
/*  967 */       return clone(paramVarArgs1); 
/*  968 */     if (paramVarArgs1 == null) {
/*  969 */       return clone(paramArrayOfint1);
/*      */     }
/*  971 */     int[] arrayOfInt = new int[paramArrayOfint1.length + paramVarArgs1.length];
/*  972 */     System.arraycopy(paramArrayOfint1, 0, arrayOfInt, 0, paramArrayOfint1.length);
/*  973 */     System.arraycopy(paramVarArgs1, 0, arrayOfInt, paramArrayOfint1.length, paramVarArgs1.length);
/*  974 */     return arrayOfInt;
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
/*      */   public static long[] addAll(long[] paramArrayOflong1, long... paramVarArgs1) {
/*  995 */     if (paramArrayOflong1 == null)
/*  996 */       return clone(paramVarArgs1); 
/*  997 */     if (paramVarArgs1 == null) {
/*  998 */       return clone(paramArrayOflong1);
/*      */     }
/* 1000 */     long[] arrayOfLong = new long[paramArrayOflong1.length + paramVarArgs1.length];
/* 1001 */     System.arraycopy(paramArrayOflong1, 0, arrayOfLong, 0, paramArrayOflong1.length);
/* 1002 */     System.arraycopy(paramVarArgs1, 0, arrayOfLong, paramArrayOflong1.length, paramVarArgs1.length);
/* 1003 */     return arrayOfLong;
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
/*      */   public static short[] addAll(short[] paramArrayOfshort1, short... paramVarArgs1) {
/* 1024 */     if (paramArrayOfshort1 == null)
/* 1025 */       return clone(paramVarArgs1); 
/* 1026 */     if (paramVarArgs1 == null) {
/* 1027 */       return clone(paramArrayOfshort1);
/*      */     }
/* 1029 */     short[] arrayOfShort = new short[paramArrayOfshort1.length + paramVarArgs1.length];
/* 1030 */     System.arraycopy(paramArrayOfshort1, 0, arrayOfShort, 0, paramArrayOfshort1.length);
/* 1031 */     System.arraycopy(paramVarArgs1, 0, arrayOfShort, paramArrayOfshort1.length, paramVarArgs1.length);
/* 1032 */     return arrayOfShort;
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
/*      */   public static <T> T[] addAll(T[] paramArrayOfT1, T... paramVarArgs1) {
/* 1060 */     if (paramArrayOfT1 == null)
/* 1061 */       return clone(paramVarArgs1); 
/* 1062 */     if (paramVarArgs1 == null) {
/* 1063 */       return clone(paramArrayOfT1);
/*      */     }
/* 1065 */     Class<?> clazz = paramArrayOfT1.getClass().getComponentType();
/*      */     
/* 1067 */     Object[] arrayOfObject = (Object[])Array.newInstance(clazz, paramArrayOfT1.length + paramVarArgs1.length);
/* 1068 */     System.arraycopy(paramArrayOfT1, 0, arrayOfObject, 0, paramArrayOfT1.length);
/*      */     try {
/* 1070 */       System.arraycopy(paramVarArgs1, 0, arrayOfObject, paramArrayOfT1.length, paramVarArgs1.length);
/* 1071 */     } catch (ArrayStoreException arrayStoreException) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1078 */       Class<?> clazz1 = paramVarArgs1.getClass().getComponentType();
/* 1079 */       if (!clazz.isAssignableFrom(clazz1)) {
/* 1080 */         throw new IllegalArgumentException("Cannot store " + clazz1.getName() + " in an array of " + clazz
/* 1081 */             .getName(), arrayStoreException);
/*      */       }
/* 1083 */       throw arrayStoreException;
/*      */     } 
/* 1085 */     return (T[])arrayOfObject;
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
/*      */   public static boolean[] addFirst(boolean[] paramArrayOfboolean, boolean paramBoolean) {
/* 1114 */     return (paramArrayOfboolean == null) ? add(paramArrayOfboolean, paramBoolean) : insert(0, paramArrayOfboolean, new boolean[] { paramBoolean });
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
/*      */   public static byte[] addFirst(byte[] paramArrayOfbyte, byte paramByte) {
/* 1143 */     return (paramArrayOfbyte == null) ? add(paramArrayOfbyte, paramByte) : insert(0, paramArrayOfbyte, new byte[] { paramByte });
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
/*      */   public static char[] addFirst(char[] paramArrayOfchar, char paramChar) {
/* 1172 */     return (paramArrayOfchar == null) ? add(paramArrayOfchar, paramChar) : insert(0, paramArrayOfchar, new char[] { paramChar });
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
/*      */   public static double[] addFirst(double[] paramArrayOfdouble, double paramDouble) {
/* 1201 */     return (paramArrayOfdouble == null) ? add(paramArrayOfdouble, paramDouble) : insert(0, paramArrayOfdouble, new double[] { paramDouble });
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
/*      */   public static float[] addFirst(float[] paramArrayOffloat, float paramFloat) {
/* 1230 */     return (paramArrayOffloat == null) ? add(paramArrayOffloat, paramFloat) : insert(0, paramArrayOffloat, new float[] { paramFloat });
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
/*      */   public static int[] addFirst(int[] paramArrayOfint, int paramInt) {
/* 1259 */     return (paramArrayOfint == null) ? add(paramArrayOfint, paramInt) : insert(0, paramArrayOfint, new int[] { paramInt });
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
/*      */   public static long[] addFirst(long[] paramArrayOflong, long paramLong) {
/* 1288 */     return (paramArrayOflong == null) ? add(paramArrayOflong, paramLong) : insert(0, paramArrayOflong, new long[] { paramLong });
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
/*      */   public static short[] addFirst(short[] paramArrayOfshort, short paramShort) {
/* 1317 */     return (paramArrayOfshort == null) ? add(paramArrayOfshort, paramShort) : insert(0, paramArrayOfshort, new short[] { paramShort });
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
/*      */   public static <T> T[] addFirst(T[] paramArrayOfT, T paramT) {
/* 1351 */     return (paramArrayOfT == null) ? add(paramArrayOfT, paramT) : insert(0, paramArrayOfT, (T[])new Object[] { paramT });
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
/*      */   public static boolean[] clone(boolean[] paramArrayOfboolean) {
/* 1364 */     if (paramArrayOfboolean == null) {
/* 1365 */       return null;
/*      */     }
/* 1367 */     return (boolean[])paramArrayOfboolean.clone();
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
/*      */   public static byte[] clone(byte[] paramArrayOfbyte) {
/* 1380 */     if (paramArrayOfbyte == null) {
/* 1381 */       return null;
/*      */     }
/* 1383 */     return (byte[])paramArrayOfbyte.clone();
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
/*      */   public static char[] clone(char[] paramArrayOfchar) {
/* 1396 */     if (paramArrayOfchar == null) {
/* 1397 */       return null;
/*      */     }
/* 1399 */     return (char[])paramArrayOfchar.clone();
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
/*      */   public static double[] clone(double[] paramArrayOfdouble) {
/* 1412 */     if (paramArrayOfdouble == null) {
/* 1413 */       return null;
/*      */     }
/* 1415 */     return (double[])paramArrayOfdouble.clone();
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
/*      */   public static float[] clone(float[] paramArrayOffloat) {
/* 1428 */     if (paramArrayOffloat == null) {
/* 1429 */       return null;
/*      */     }
/* 1431 */     return (float[])paramArrayOffloat.clone();
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
/*      */   public static int[] clone(int[] paramArrayOfint) {
/* 1444 */     if (paramArrayOfint == null) {
/* 1445 */       return null;
/*      */     }
/* 1447 */     return (int[])paramArrayOfint.clone();
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
/*      */   public static long[] clone(long[] paramArrayOflong) {
/* 1460 */     if (paramArrayOflong == null) {
/* 1461 */       return null;
/*      */     }
/* 1463 */     return (long[])paramArrayOflong.clone();
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
/*      */   public static short[] clone(short[] paramArrayOfshort) {
/* 1476 */     if (paramArrayOfshort == null) {
/* 1477 */       return null;
/*      */     }
/* 1479 */     return (short[])paramArrayOfshort.clone();
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
/*      */   public static <T> T[] clone(T[] paramArrayOfT) {
/* 1498 */     if (paramArrayOfT == null) {
/* 1499 */       return null;
/*      */     }
/* 1501 */     return (T[])paramArrayOfT.clone();
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
/*      */   public static boolean contains(boolean[] paramArrayOfboolean, boolean paramBoolean) {
/* 1514 */     return (indexOf(paramArrayOfboolean, paramBoolean) != -1);
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
/*      */   public static boolean contains(byte[] paramArrayOfbyte, byte paramByte) {
/* 1527 */     return (indexOf(paramArrayOfbyte, paramByte) != -1);
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
/*      */   public static boolean contains(char[] paramArrayOfchar, char paramChar) {
/* 1541 */     return (indexOf(paramArrayOfchar, paramChar) != -1);
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
/*      */   public static boolean contains(double[] paramArrayOfdouble, double paramDouble) {
/* 1554 */     return (indexOf(paramArrayOfdouble, paramDouble) != -1);
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
/*      */   public static boolean contains(double[] paramArrayOfdouble, double paramDouble1, double paramDouble2) {
/* 1571 */     return (indexOf(paramArrayOfdouble, paramDouble1, 0, paramDouble2) != -1);
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
/*      */   public static boolean contains(float[] paramArrayOffloat, float paramFloat) {
/* 1584 */     return (indexOf(paramArrayOffloat, paramFloat) != -1);
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
/*      */   public static boolean contains(int[] paramArrayOfint, int paramInt) {
/* 1597 */     return (indexOf(paramArrayOfint, paramInt) != -1);
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
/*      */   public static boolean contains(long[] paramArrayOflong, long paramLong) {
/* 1610 */     return (indexOf(paramArrayOflong, paramLong) != -1);
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
/*      */   public static boolean contains(Object[] paramArrayOfObject, Object paramObject) {
/* 1623 */     return (indexOf(paramArrayOfObject, paramObject) != -1);
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
/*      */   public static boolean contains(short[] paramArrayOfshort, short paramShort) {
/* 1636 */     return (indexOf(paramArrayOfshort, paramShort) != -1);
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
/*      */   private static Object copyArrayGrow1(Object paramObject, Class<?> paramClass) {
/* 1649 */     if (paramObject != null) {
/* 1650 */       int i = Array.getLength(paramObject);
/* 1651 */       Object object = Array.newInstance(paramObject.getClass().getComponentType(), i + 1);
/* 1652 */       System.arraycopy(paramObject, 0, object, 0, i);
/* 1653 */       return object;
/*      */     } 
/* 1655 */     return Array.newInstance(paramClass, 1);
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
/*      */   public static <T> T get(T[] paramArrayOfT, int paramInt) {
/* 1668 */     return get(paramArrayOfT, paramInt, null);
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
/*      */   public static <T> T get(T[] paramArrayOfT, int paramInt, T paramT) {
/* 1682 */     return isArrayIndexValid(paramArrayOfT, paramInt) ? paramArrayOfT[paramInt] : paramT;
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
/*      */   public static int getLength(Object paramObject) {
/* 1707 */     if (paramObject == null) {
/* 1708 */       return 0;
/*      */     }
/* 1710 */     return Array.getLength(paramObject);
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
/*      */   public static int hashCode(Object paramObject) {
/* 1722 */     return (new HashCodeBuilder()).append(paramObject).toHashCode();
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
/*      */   public static BitSet indexesOf(boolean[] paramArrayOfboolean, boolean paramBoolean) {
/* 1737 */     return indexesOf(paramArrayOfboolean, paramBoolean, 0);
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
/*      */   public static BitSet indexesOf(boolean[] paramArrayOfboolean, boolean paramBoolean, int paramInt) {
/* 1757 */     BitSet bitSet = new BitSet();
/*      */     
/* 1759 */     if (paramArrayOfboolean == null) {
/* 1760 */       return bitSet;
/*      */     }
/*      */     
/* 1763 */     while (paramInt < paramArrayOfboolean.length) {
/* 1764 */       paramInt = indexOf(paramArrayOfboolean, paramBoolean, paramInt);
/*      */       
/* 1766 */       if (paramInt == -1) {
/*      */         break;
/*      */       }
/*      */       
/* 1770 */       bitSet.set(paramInt);
/* 1771 */       paramInt++;
/*      */     } 
/*      */     
/* 1774 */     return bitSet;
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
/*      */   public static BitSet indexesOf(byte[] paramArrayOfbyte, byte paramByte) {
/* 1789 */     return indexesOf(paramArrayOfbyte, paramByte, 0);
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
/*      */   public static BitSet indexesOf(byte[] paramArrayOfbyte, byte paramByte, int paramInt) {
/* 1808 */     BitSet bitSet = new BitSet();
/*      */     
/* 1810 */     if (paramArrayOfbyte == null) {
/* 1811 */       return bitSet;
/*      */     }
/*      */     
/* 1814 */     while (paramInt < paramArrayOfbyte.length) {
/* 1815 */       paramInt = indexOf(paramArrayOfbyte, paramByte, paramInt);
/*      */       
/* 1817 */       if (paramInt == -1) {
/*      */         break;
/*      */       }
/*      */       
/* 1821 */       bitSet.set(paramInt);
/* 1822 */       paramInt++;
/*      */     } 
/*      */     
/* 1825 */     return bitSet;
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
/*      */   public static BitSet indexesOf(char[] paramArrayOfchar, char paramChar) {
/* 1840 */     return indexesOf(paramArrayOfchar, paramChar, 0);
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
/*      */   public static BitSet indexesOf(char[] paramArrayOfchar, char paramChar, int paramInt) {
/* 1859 */     BitSet bitSet = new BitSet();
/*      */     
/* 1861 */     if (paramArrayOfchar == null) {
/* 1862 */       return bitSet;
/*      */     }
/*      */     
/* 1865 */     while (paramInt < paramArrayOfchar.length) {
/* 1866 */       paramInt = indexOf(paramArrayOfchar, paramChar, paramInt);
/*      */       
/* 1868 */       if (paramInt == -1) {
/*      */         break;
/*      */       }
/*      */       
/* 1872 */       bitSet.set(paramInt);
/* 1873 */       paramInt++;
/*      */     } 
/*      */     
/* 1876 */     return bitSet;
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
/*      */   public static BitSet indexesOf(double[] paramArrayOfdouble, double paramDouble) {
/* 1891 */     return indexesOf(paramArrayOfdouble, paramDouble, 0);
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
/*      */   public static BitSet indexesOf(double[] paramArrayOfdouble, double paramDouble1, double paramDouble2) {
/* 1912 */     return indexesOf(paramArrayOfdouble, paramDouble1, 0, paramDouble2);
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
/*      */   public static BitSet indexesOf(double[] paramArrayOfdouble, double paramDouble, int paramInt) {
/* 1931 */     BitSet bitSet = new BitSet();
/*      */     
/* 1933 */     if (paramArrayOfdouble == null) {
/* 1934 */       return bitSet;
/*      */     }
/*      */     
/* 1937 */     while (paramInt < paramArrayOfdouble.length) {
/* 1938 */       paramInt = indexOf(paramArrayOfdouble, paramDouble, paramInt);
/*      */       
/* 1940 */       if (paramInt == -1) {
/*      */         break;
/*      */       }
/*      */       
/* 1944 */       bitSet.set(paramInt);
/* 1945 */       paramInt++;
/*      */     } 
/*      */     
/* 1948 */     return bitSet;
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
/*      */   public static BitSet indexesOf(double[] paramArrayOfdouble, double paramDouble1, int paramInt, double paramDouble2) {
/* 1973 */     BitSet bitSet = new BitSet();
/*      */     
/* 1975 */     if (paramArrayOfdouble == null) {
/* 1976 */       return bitSet;
/*      */     }
/*      */     
/* 1979 */     while (paramInt < paramArrayOfdouble.length) {
/* 1980 */       paramInt = indexOf(paramArrayOfdouble, paramDouble1, paramInt, paramDouble2);
/*      */       
/* 1982 */       if (paramInt == -1) {
/*      */         break;
/*      */       }
/*      */       
/* 1986 */       bitSet.set(paramInt);
/* 1987 */       paramInt++;
/*      */     } 
/*      */     
/* 1990 */     return bitSet;
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
/*      */   public static BitSet indexesOf(float[] paramArrayOffloat, float paramFloat) {
/* 2005 */     return indexesOf(paramArrayOffloat, paramFloat, 0);
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
/*      */   public static BitSet indexesOf(float[] paramArrayOffloat, float paramFloat, int paramInt) {
/* 2024 */     BitSet bitSet = new BitSet();
/*      */     
/* 2026 */     if (paramArrayOffloat == null) {
/* 2027 */       return bitSet;
/*      */     }
/*      */     
/* 2030 */     while (paramInt < paramArrayOffloat.length) {
/* 2031 */       paramInt = indexOf(paramArrayOffloat, paramFloat, paramInt);
/*      */       
/* 2033 */       if (paramInt == -1) {
/*      */         break;
/*      */       }
/*      */       
/* 2037 */       bitSet.set(paramInt);
/* 2038 */       paramInt++;
/*      */     } 
/*      */     
/* 2041 */     return bitSet;
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
/*      */   public static BitSet indexesOf(int[] paramArrayOfint, int paramInt) {
/* 2056 */     return indexesOf(paramArrayOfint, paramInt, 0);
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
/*      */   public static BitSet indexesOf(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 2075 */     BitSet bitSet = new BitSet();
/*      */     
/* 2077 */     if (paramArrayOfint == null) {
/* 2078 */       return bitSet;
/*      */     }
/*      */     
/* 2081 */     while (paramInt2 < paramArrayOfint.length) {
/* 2082 */       paramInt2 = indexOf(paramArrayOfint, paramInt1, paramInt2);
/*      */       
/* 2084 */       if (paramInt2 == -1) {
/*      */         break;
/*      */       }
/*      */       
/* 2088 */       bitSet.set(paramInt2);
/* 2089 */       paramInt2++;
/*      */     } 
/*      */     
/* 2092 */     return bitSet;
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
/*      */   public static BitSet indexesOf(long[] paramArrayOflong, long paramLong) {
/* 2107 */     return indexesOf(paramArrayOflong, paramLong, 0);
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
/*      */   public static BitSet indexesOf(long[] paramArrayOflong, long paramLong, int paramInt) {
/* 2126 */     BitSet bitSet = new BitSet();
/*      */     
/* 2128 */     if (paramArrayOflong == null) {
/* 2129 */       return bitSet;
/*      */     }
/*      */     
/* 2132 */     while (paramInt < paramArrayOflong.length) {
/* 2133 */       paramInt = indexOf(paramArrayOflong, paramLong, paramInt);
/*      */       
/* 2135 */       if (paramInt == -1) {
/*      */         break;
/*      */       }
/*      */       
/* 2139 */       bitSet.set(paramInt);
/* 2140 */       paramInt++;
/*      */     } 
/*      */     
/* 2143 */     return bitSet;
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
/*      */   public static BitSet indexesOf(Object[] paramArrayOfObject, Object paramObject) {
/* 2158 */     return indexesOf(paramArrayOfObject, paramObject, 0);
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
/*      */   public static BitSet indexesOf(Object[] paramArrayOfObject, Object paramObject, int paramInt) {
/* 2177 */     BitSet bitSet = new BitSet();
/*      */     
/* 2179 */     if (paramArrayOfObject == null) {
/* 2180 */       return bitSet;
/*      */     }
/*      */     
/* 2183 */     while (paramInt < paramArrayOfObject.length) {
/* 2184 */       paramInt = indexOf(paramArrayOfObject, paramObject, paramInt);
/*      */       
/* 2186 */       if (paramInt == -1) {
/*      */         break;
/*      */       }
/*      */       
/* 2190 */       bitSet.set(paramInt);
/* 2191 */       paramInt++;
/*      */     } 
/*      */     
/* 2194 */     return bitSet;
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
/*      */   public static BitSet indexesOf(short[] paramArrayOfshort, short paramShort) {
/* 2209 */     return indexesOf(paramArrayOfshort, paramShort, 0);
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
/*      */   public static BitSet indexesOf(short[] paramArrayOfshort, short paramShort, int paramInt) {
/* 2228 */     BitSet bitSet = new BitSet();
/*      */     
/* 2230 */     if (paramArrayOfshort == null) {
/* 2231 */       return bitSet;
/*      */     }
/*      */     
/* 2234 */     while (paramInt < paramArrayOfshort.length) {
/* 2235 */       paramInt = indexOf(paramArrayOfshort, paramShort, paramInt);
/*      */       
/* 2237 */       if (paramInt == -1) {
/*      */         break;
/*      */       }
/*      */       
/* 2241 */       bitSet.set(paramInt);
/* 2242 */       paramInt++;
/*      */     } 
/*      */     
/* 2245 */     return bitSet;
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
/*      */   public static int indexOf(boolean[] paramArrayOfboolean, boolean paramBoolean) {
/* 2261 */     return indexOf(paramArrayOfboolean, paramBoolean, 0);
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
/*      */   public static int indexOf(boolean[] paramArrayOfboolean, boolean paramBoolean, int paramInt) {
/* 2280 */     if (isEmpty(paramArrayOfboolean)) {
/* 2281 */       return -1;
/*      */     }
/* 2283 */     if (paramInt < 0) {
/* 2284 */       paramInt = 0;
/*      */     }
/* 2286 */     for (int i = paramInt; i < paramArrayOfboolean.length; i++) {
/* 2287 */       if (paramBoolean == paramArrayOfboolean[i]) {
/* 2288 */         return i;
/*      */       }
/*      */     } 
/* 2291 */     return -1;
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
/*      */   public static int indexOf(byte[] paramArrayOfbyte, byte paramByte) {
/* 2307 */     return indexOf(paramArrayOfbyte, paramByte, 0);
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
/*      */   public static int indexOf(byte[] paramArrayOfbyte, byte paramByte, int paramInt) {
/* 2325 */     if (paramArrayOfbyte == null) {
/* 2326 */       return -1;
/*      */     }
/* 2328 */     if (paramInt < 0) {
/* 2329 */       paramInt = 0;
/*      */     }
/* 2331 */     for (int i = paramInt; i < paramArrayOfbyte.length; i++) {
/* 2332 */       if (paramByte == paramArrayOfbyte[i]) {
/* 2333 */         return i;
/*      */       }
/*      */     } 
/* 2336 */     return -1;
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
/*      */   public static int indexOf(char[] paramArrayOfchar, char paramChar) {
/* 2353 */     return indexOf(paramArrayOfchar, paramChar, 0);
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
/*      */   public static int indexOf(char[] paramArrayOfchar, char paramChar, int paramInt) {
/* 2372 */     if (paramArrayOfchar == null) {
/* 2373 */       return -1;
/*      */     }
/* 2375 */     if (paramInt < 0) {
/* 2376 */       paramInt = 0;
/*      */     }
/* 2378 */     for (int i = paramInt; i < paramArrayOfchar.length; i++) {
/* 2379 */       if (paramChar == paramArrayOfchar[i]) {
/* 2380 */         return i;
/*      */       }
/*      */     } 
/* 2383 */     return -1;
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
/*      */   public static int indexOf(double[] paramArrayOfdouble, double paramDouble) {
/* 2399 */     return indexOf(paramArrayOfdouble, paramDouble, 0);
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
/*      */   public static int indexOf(double[] paramArrayOfdouble, double paramDouble1, double paramDouble2) {
/* 2416 */     return indexOf(paramArrayOfdouble, paramDouble1, 0, paramDouble2);
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
/*      */   public static int indexOf(double[] paramArrayOfdouble, double paramDouble, int paramInt) {
/* 2434 */     if (isEmpty(paramArrayOfdouble)) {
/* 2435 */       return -1;
/*      */     }
/* 2437 */     if (paramInt < 0) {
/* 2438 */       paramInt = 0;
/*      */     }
/* 2440 */     for (int i = paramInt; i < paramArrayOfdouble.length; i++) {
/* 2441 */       if (paramDouble == paramArrayOfdouble[i]) {
/* 2442 */         return i;
/*      */       }
/*      */     } 
/* 2445 */     return -1;
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
/*      */   public static int indexOf(double[] paramArrayOfdouble, double paramDouble1, int paramInt, double paramDouble2) {
/* 2466 */     if (isEmpty(paramArrayOfdouble)) {
/* 2467 */       return -1;
/*      */     }
/* 2469 */     if (paramInt < 0) {
/* 2470 */       paramInt = 0;
/*      */     }
/* 2472 */     double d1 = paramDouble1 - paramDouble2;
/* 2473 */     double d2 = paramDouble1 + paramDouble2;
/* 2474 */     for (int i = paramInt; i < paramArrayOfdouble.length; i++) {
/* 2475 */       if (paramArrayOfdouble[i] >= d1 && paramArrayOfdouble[i] <= d2) {
/* 2476 */         return i;
/*      */       }
/*      */     } 
/* 2479 */     return -1;
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
/*      */   public static int indexOf(float[] paramArrayOffloat, float paramFloat) {
/* 2495 */     return indexOf(paramArrayOffloat, paramFloat, 0);
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
/*      */   public static int indexOf(float[] paramArrayOffloat, float paramFloat, int paramInt) {
/* 2513 */     if (isEmpty(paramArrayOffloat)) {
/* 2514 */       return -1;
/*      */     }
/* 2516 */     if (paramInt < 0) {
/* 2517 */       paramInt = 0;
/*      */     }
/* 2519 */     for (int i = paramInt; i < paramArrayOffloat.length; i++) {
/* 2520 */       if (paramFloat == paramArrayOffloat[i]) {
/* 2521 */         return i;
/*      */       }
/*      */     } 
/* 2524 */     return -1;
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
/*      */   public static int indexOf(int[] paramArrayOfint, int paramInt) {
/* 2540 */     return indexOf(paramArrayOfint, paramInt, 0);
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
/*      */   public static int indexOf(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 2558 */     if (paramArrayOfint == null) {
/* 2559 */       return -1;
/*      */     }
/* 2561 */     if (paramInt2 < 0) {
/* 2562 */       paramInt2 = 0;
/*      */     }
/* 2564 */     for (int i = paramInt2; i < paramArrayOfint.length; i++) {
/* 2565 */       if (paramInt1 == paramArrayOfint[i]) {
/* 2566 */         return i;
/*      */       }
/*      */     } 
/* 2569 */     return -1;
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
/*      */   public static int indexOf(long[] paramArrayOflong, long paramLong) {
/* 2585 */     return indexOf(paramArrayOflong, paramLong, 0);
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
/*      */   public static int indexOf(long[] paramArrayOflong, long paramLong, int paramInt) {
/* 2603 */     if (paramArrayOflong == null) {
/* 2604 */       return -1;
/*      */     }
/* 2606 */     if (paramInt < 0) {
/* 2607 */       paramInt = 0;
/*      */     }
/* 2609 */     for (int i = paramInt; i < paramArrayOflong.length; i++) {
/* 2610 */       if (paramLong == paramArrayOflong[i]) {
/* 2611 */         return i;
/*      */       }
/*      */     } 
/* 2614 */     return -1;
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
/*      */   public static int indexOf(Object[] paramArrayOfObject, Object paramObject) {
/* 2630 */     return indexOf(paramArrayOfObject, paramObject, 0);
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
/*      */   public static int indexOf(Object[] paramArrayOfObject, Object paramObject, int paramInt) {
/* 2648 */     if (paramArrayOfObject == null) {
/* 2649 */       return -1;
/*      */     }
/* 2651 */     if (paramInt < 0) {
/* 2652 */       paramInt = 0;
/*      */     }
/* 2654 */     if (paramObject == null) {
/* 2655 */       for (int i = paramInt; i < paramArrayOfObject.length; i++) {
/* 2656 */         if (paramArrayOfObject[i] == null) {
/* 2657 */           return i;
/*      */         }
/*      */       } 
/*      */     } else {
/* 2661 */       for (int i = paramInt; i < paramArrayOfObject.length; i++) {
/* 2662 */         if (paramObject.equals(paramArrayOfObject[i])) {
/* 2663 */           return i;
/*      */         }
/*      */       } 
/*      */     } 
/* 2667 */     return -1;
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
/*      */   public static int indexOf(short[] paramArrayOfshort, short paramShort) {
/* 2683 */     return indexOf(paramArrayOfshort, paramShort, 0);
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
/*      */   public static int indexOf(short[] paramArrayOfshort, short paramShort, int paramInt) {
/* 2701 */     if (paramArrayOfshort == null) {
/* 2702 */       return -1;
/*      */     }
/* 2704 */     if (paramInt < 0) {
/* 2705 */       paramInt = 0;
/*      */     }
/* 2707 */     for (int i = paramInt; i < paramArrayOfshort.length; i++) {
/* 2708 */       if (paramShort == paramArrayOfshort[i]) {
/* 2709 */         return i;
/*      */       }
/*      */     } 
/* 2712 */     return -1;
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
/*      */   public static boolean[] insert(int paramInt, boolean[] paramArrayOfboolean1, boolean... paramVarArgs1) {
/* 2735 */     if (paramArrayOfboolean1 == null) {
/* 2736 */       return null;
/*      */     }
/* 2738 */     if (isEmpty(paramVarArgs1)) {
/* 2739 */       return clone(paramArrayOfboolean1);
/*      */     }
/* 2741 */     if (paramInt < 0 || paramInt > paramArrayOfboolean1.length) {
/* 2742 */       throw new IndexOutOfBoundsException("Index: " + paramInt + ", Length: " + paramArrayOfboolean1.length);
/*      */     }
/*      */     
/* 2745 */     boolean[] arrayOfBoolean = new boolean[paramArrayOfboolean1.length + paramVarArgs1.length];
/*      */     
/* 2747 */     System.arraycopy(paramVarArgs1, 0, arrayOfBoolean, paramInt, paramVarArgs1.length);
/* 2748 */     if (paramInt > 0) {
/* 2749 */       System.arraycopy(paramArrayOfboolean1, 0, arrayOfBoolean, 0, paramInt);
/*      */     }
/* 2751 */     if (paramInt < paramArrayOfboolean1.length) {
/* 2752 */       System.arraycopy(paramArrayOfboolean1, paramInt, arrayOfBoolean, paramInt + paramVarArgs1.length, paramArrayOfboolean1.length - paramInt);
/*      */     }
/* 2754 */     return arrayOfBoolean;
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
/*      */   public static byte[] insert(int paramInt, byte[] paramArrayOfbyte1, byte... paramVarArgs1) {
/* 2777 */     if (paramArrayOfbyte1 == null) {
/* 2778 */       return null;
/*      */     }
/* 2780 */     if (isEmpty(paramVarArgs1)) {
/* 2781 */       return clone(paramArrayOfbyte1);
/*      */     }
/* 2783 */     if (paramInt < 0 || paramInt > paramArrayOfbyte1.length) {
/* 2784 */       throw new IndexOutOfBoundsException("Index: " + paramInt + ", Length: " + paramArrayOfbyte1.length);
/*      */     }
/*      */     
/* 2787 */     byte[] arrayOfByte = new byte[paramArrayOfbyte1.length + paramVarArgs1.length];
/*      */     
/* 2789 */     System.arraycopy(paramVarArgs1, 0, arrayOfByte, paramInt, paramVarArgs1.length);
/* 2790 */     if (paramInt > 0) {
/* 2791 */       System.arraycopy(paramArrayOfbyte1, 0, arrayOfByte, 0, paramInt);
/*      */     }
/* 2793 */     if (paramInt < paramArrayOfbyte1.length) {
/* 2794 */       System.arraycopy(paramArrayOfbyte1, paramInt, arrayOfByte, paramInt + paramVarArgs1.length, paramArrayOfbyte1.length - paramInt);
/*      */     }
/* 2796 */     return arrayOfByte;
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
/*      */   public static char[] insert(int paramInt, char[] paramArrayOfchar1, char... paramVarArgs1) {
/* 2819 */     if (paramArrayOfchar1 == null) {
/* 2820 */       return null;
/*      */     }
/* 2822 */     if (isEmpty(paramVarArgs1)) {
/* 2823 */       return clone(paramArrayOfchar1);
/*      */     }
/* 2825 */     if (paramInt < 0 || paramInt > paramArrayOfchar1.length) {
/* 2826 */       throw new IndexOutOfBoundsException("Index: " + paramInt + ", Length: " + paramArrayOfchar1.length);
/*      */     }
/*      */     
/* 2829 */     char[] arrayOfChar = new char[paramArrayOfchar1.length + paramVarArgs1.length];
/*      */     
/* 2831 */     System.arraycopy(paramVarArgs1, 0, arrayOfChar, paramInt, paramVarArgs1.length);
/* 2832 */     if (paramInt > 0) {
/* 2833 */       System.arraycopy(paramArrayOfchar1, 0, arrayOfChar, 0, paramInt);
/*      */     }
/* 2835 */     if (paramInt < paramArrayOfchar1.length) {
/* 2836 */       System.arraycopy(paramArrayOfchar1, paramInt, arrayOfChar, paramInt + paramVarArgs1.length, paramArrayOfchar1.length - paramInt);
/*      */     }
/* 2838 */     return arrayOfChar;
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
/*      */   public static double[] insert(int paramInt, double[] paramArrayOfdouble1, double... paramVarArgs1) {
/* 2861 */     if (paramArrayOfdouble1 == null) {
/* 2862 */       return null;
/*      */     }
/* 2864 */     if (isEmpty(paramVarArgs1)) {
/* 2865 */       return clone(paramArrayOfdouble1);
/*      */     }
/* 2867 */     if (paramInt < 0 || paramInt > paramArrayOfdouble1.length) {
/* 2868 */       throw new IndexOutOfBoundsException("Index: " + paramInt + ", Length: " + paramArrayOfdouble1.length);
/*      */     }
/*      */     
/* 2871 */     double[] arrayOfDouble = new double[paramArrayOfdouble1.length + paramVarArgs1.length];
/*      */     
/* 2873 */     System.arraycopy(paramVarArgs1, 0, arrayOfDouble, paramInt, paramVarArgs1.length);
/* 2874 */     if (paramInt > 0) {
/* 2875 */       System.arraycopy(paramArrayOfdouble1, 0, arrayOfDouble, 0, paramInt);
/*      */     }
/* 2877 */     if (paramInt < paramArrayOfdouble1.length) {
/* 2878 */       System.arraycopy(paramArrayOfdouble1, paramInt, arrayOfDouble, paramInt + paramVarArgs1.length, paramArrayOfdouble1.length - paramInt);
/*      */     }
/* 2880 */     return arrayOfDouble;
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
/*      */   public static float[] insert(int paramInt, float[] paramArrayOffloat1, float... paramVarArgs1) {
/* 2903 */     if (paramArrayOffloat1 == null) {
/* 2904 */       return null;
/*      */     }
/* 2906 */     if (isEmpty(paramVarArgs1)) {
/* 2907 */       return clone(paramArrayOffloat1);
/*      */     }
/* 2909 */     if (paramInt < 0 || paramInt > paramArrayOffloat1.length) {
/* 2910 */       throw new IndexOutOfBoundsException("Index: " + paramInt + ", Length: " + paramArrayOffloat1.length);
/*      */     }
/*      */     
/* 2913 */     float[] arrayOfFloat = new float[paramArrayOffloat1.length + paramVarArgs1.length];
/*      */     
/* 2915 */     System.arraycopy(paramVarArgs1, 0, arrayOfFloat, paramInt, paramVarArgs1.length);
/* 2916 */     if (paramInt > 0) {
/* 2917 */       System.arraycopy(paramArrayOffloat1, 0, arrayOfFloat, 0, paramInt);
/*      */     }
/* 2919 */     if (paramInt < paramArrayOffloat1.length) {
/* 2920 */       System.arraycopy(paramArrayOffloat1, paramInt, arrayOfFloat, paramInt + paramVarArgs1.length, paramArrayOffloat1.length - paramInt);
/*      */     }
/* 2922 */     return arrayOfFloat;
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
/*      */   public static int[] insert(int paramInt, int[] paramArrayOfint1, int... paramVarArgs1) {
/* 2945 */     if (paramArrayOfint1 == null) {
/* 2946 */       return null;
/*      */     }
/* 2948 */     if (isEmpty(paramVarArgs1)) {
/* 2949 */       return clone(paramArrayOfint1);
/*      */     }
/* 2951 */     if (paramInt < 0 || paramInt > paramArrayOfint1.length) {
/* 2952 */       throw new IndexOutOfBoundsException("Index: " + paramInt + ", Length: " + paramArrayOfint1.length);
/*      */     }
/*      */     
/* 2955 */     int[] arrayOfInt = new int[paramArrayOfint1.length + paramVarArgs1.length];
/*      */     
/* 2957 */     System.arraycopy(paramVarArgs1, 0, arrayOfInt, paramInt, paramVarArgs1.length);
/* 2958 */     if (paramInt > 0) {
/* 2959 */       System.arraycopy(paramArrayOfint1, 0, arrayOfInt, 0, paramInt);
/*      */     }
/* 2961 */     if (paramInt < paramArrayOfint1.length) {
/* 2962 */       System.arraycopy(paramArrayOfint1, paramInt, arrayOfInt, paramInt + paramVarArgs1.length, paramArrayOfint1.length - paramInt);
/*      */     }
/* 2964 */     return arrayOfInt;
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
/*      */   public static long[] insert(int paramInt, long[] paramArrayOflong1, long... paramVarArgs1) {
/* 2987 */     if (paramArrayOflong1 == null) {
/* 2988 */       return null;
/*      */     }
/* 2990 */     if (isEmpty(paramVarArgs1)) {
/* 2991 */       return clone(paramArrayOflong1);
/*      */     }
/* 2993 */     if (paramInt < 0 || paramInt > paramArrayOflong1.length) {
/* 2994 */       throw new IndexOutOfBoundsException("Index: " + paramInt + ", Length: " + paramArrayOflong1.length);
/*      */     }
/*      */     
/* 2997 */     long[] arrayOfLong = new long[paramArrayOflong1.length + paramVarArgs1.length];
/*      */     
/* 2999 */     System.arraycopy(paramVarArgs1, 0, arrayOfLong, paramInt, paramVarArgs1.length);
/* 3000 */     if (paramInt > 0) {
/* 3001 */       System.arraycopy(paramArrayOflong1, 0, arrayOfLong, 0, paramInt);
/*      */     }
/* 3003 */     if (paramInt < paramArrayOflong1.length) {
/* 3004 */       System.arraycopy(paramArrayOflong1, paramInt, arrayOfLong, paramInt + paramVarArgs1.length, paramArrayOflong1.length - paramInt);
/*      */     }
/* 3006 */     return arrayOfLong;
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
/*      */   public static short[] insert(int paramInt, short[] paramArrayOfshort1, short... paramVarArgs1) {
/* 3029 */     if (paramArrayOfshort1 == null) {
/* 3030 */       return null;
/*      */     }
/* 3032 */     if (isEmpty(paramVarArgs1)) {
/* 3033 */       return clone(paramArrayOfshort1);
/*      */     }
/* 3035 */     if (paramInt < 0 || paramInt > paramArrayOfshort1.length) {
/* 3036 */       throw new IndexOutOfBoundsException("Index: " + paramInt + ", Length: " + paramArrayOfshort1.length);
/*      */     }
/*      */     
/* 3039 */     short[] arrayOfShort = new short[paramArrayOfshort1.length + paramVarArgs1.length];
/*      */     
/* 3041 */     System.arraycopy(paramVarArgs1, 0, arrayOfShort, paramInt, paramVarArgs1.length);
/* 3042 */     if (paramInt > 0) {
/* 3043 */       System.arraycopy(paramArrayOfshort1, 0, arrayOfShort, 0, paramInt);
/*      */     }
/* 3045 */     if (paramInt < paramArrayOfshort1.length) {
/* 3046 */       System.arraycopy(paramArrayOfshort1, paramInt, arrayOfShort, paramInt + paramVarArgs1.length, paramArrayOfshort1.length - paramInt);
/*      */     }
/* 3048 */     return arrayOfShort;
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
/*      */   @SafeVarargs
/*      */   public static <T> T[] insert(int paramInt, T[] paramArrayOfT1, T... paramVarArgs1) {
/* 3081 */     if (paramArrayOfT1 == null) {
/* 3082 */       return null;
/*      */     }
/* 3084 */     if (isEmpty((Object[])paramVarArgs1)) {
/* 3085 */       return clone(paramArrayOfT1);
/*      */     }
/* 3087 */     if (paramInt < 0 || paramInt > paramArrayOfT1.length) {
/* 3088 */       throw new IndexOutOfBoundsException("Index: " + paramInt + ", Length: " + paramArrayOfT1.length);
/*      */     }
/*      */     
/* 3091 */     Class<?> clazz = paramArrayOfT1.getClass().getComponentType();
/*      */ 
/*      */     
/* 3094 */     Object[] arrayOfObject = (Object[])Array.newInstance(clazz, paramArrayOfT1.length + paramVarArgs1.length);
/*      */     
/* 3096 */     System.arraycopy(paramVarArgs1, 0, arrayOfObject, paramInt, paramVarArgs1.length);
/* 3097 */     if (paramInt > 0) {
/* 3098 */       System.arraycopy(paramArrayOfT1, 0, arrayOfObject, 0, paramInt);
/*      */     }
/* 3100 */     if (paramInt < paramArrayOfT1.length) {
/* 3101 */       System.arraycopy(paramArrayOfT1, paramInt, arrayOfObject, paramInt + paramVarArgs1.length, paramArrayOfT1.length - paramInt);
/*      */     }
/* 3103 */     return (T[])arrayOfObject;
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
/*      */   public static <T> boolean isArrayIndexValid(T[] paramArrayOfT, int paramInt) {
/* 3122 */     return (paramInt >= 0 && getLength(paramArrayOfT) > paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(boolean[] paramArrayOfboolean) {
/* 3133 */     return (getLength(paramArrayOfboolean) == 0);
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
/*      */   public static boolean isEmpty(byte[] paramArrayOfbyte) {
/* 3147 */     return (getLength(paramArrayOfbyte) == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(char[] paramArrayOfchar) {
/* 3158 */     return (getLength(paramArrayOfchar) == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(double[] paramArrayOfdouble) {
/* 3169 */     return (getLength(paramArrayOfdouble) == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(float[] paramArrayOffloat) {
/* 3180 */     return (getLength(paramArrayOffloat) == 0);
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
/*      */   public static boolean isEmpty(int[] paramArrayOfint) {
/* 3193 */     return (getLength(paramArrayOfint) == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(long[] paramArrayOflong) {
/* 3204 */     return (getLength(paramArrayOflong) == 0);
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
/*      */   public static boolean isEmpty(Object[] paramArrayOfObject) {
/* 3216 */     return (getLength(paramArrayOfObject) == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(short[] paramArrayOfshort) {
/* 3227 */     return (getLength(paramArrayOfshort) == 0);
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
/*      */   @Deprecated
/*      */   public static boolean isEquals(Object paramObject1, Object paramObject2) {
/* 3244 */     return (new EqualsBuilder()).append(paramObject1, paramObject2).isEquals();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNotEmpty(boolean[] paramArrayOfboolean) {
/* 3255 */     return !isEmpty(paramArrayOfboolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNotEmpty(byte[] paramArrayOfbyte) {
/* 3266 */     return !isEmpty(paramArrayOfbyte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNotEmpty(char[] paramArrayOfchar) {
/* 3277 */     return !isEmpty(paramArrayOfchar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNotEmpty(double[] paramArrayOfdouble) {
/* 3288 */     return !isEmpty(paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNotEmpty(float[] paramArrayOffloat) {
/* 3299 */     return !isEmpty(paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNotEmpty(int[] paramArrayOfint) {
/* 3310 */     return !isEmpty(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNotEmpty(long[] paramArrayOflong) {
/* 3321 */     return !isEmpty(paramArrayOflong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNotEmpty(short[] paramArrayOfshort) {
/* 3332 */     return !isEmpty(paramArrayOfshort);
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
/*      */   public static <T> boolean isNotEmpty(T[] paramArrayOfT) {
/* 3345 */     return !isEmpty((Object[])paramArrayOfT);
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
/*      */   public static boolean isSameLength(boolean[] paramArrayOfboolean1, boolean[] paramArrayOfboolean2) {
/* 3358 */     return (getLength(paramArrayOfboolean1) == getLength(paramArrayOfboolean2));
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
/*      */   public static boolean isSameLength(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/* 3371 */     return (getLength(paramArrayOfbyte1) == getLength(paramArrayOfbyte2));
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
/*      */   public static boolean isSameLength(char[] paramArrayOfchar1, char[] paramArrayOfchar2) {
/* 3384 */     return (getLength(paramArrayOfchar1) == getLength(paramArrayOfchar2));
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
/*      */   public static boolean isSameLength(double[] paramArrayOfdouble1, double[] paramArrayOfdouble2) {
/* 3397 */     return (getLength(paramArrayOfdouble1) == getLength(paramArrayOfdouble2));
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
/*      */   public static boolean isSameLength(float[] paramArrayOffloat1, float[] paramArrayOffloat2) {
/* 3410 */     return (getLength(paramArrayOffloat1) == getLength(paramArrayOffloat2));
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
/*      */   public static boolean isSameLength(int[] paramArrayOfint1, int[] paramArrayOfint2) {
/* 3423 */     return (getLength(paramArrayOfint1) == getLength(paramArrayOfint2));
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
/*      */   public static boolean isSameLength(long[] paramArrayOflong1, long[] paramArrayOflong2) {
/* 3436 */     return (getLength(paramArrayOflong1) == getLength(paramArrayOflong2));
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
/*      */   public static boolean isSameLength(Object paramObject1, Object paramObject2) {
/* 3453 */     return (getLength(paramObject1) == getLength(paramObject2));
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
/*      */   public static boolean isSameLength(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2) {
/* 3468 */     return (getLength(paramArrayOfObject1) == getLength(paramArrayOfObject2));
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
/*      */   public static boolean isSameLength(short[] paramArrayOfshort1, short[] paramArrayOfshort2) {
/* 3481 */     return (getLength(paramArrayOfshort1) == getLength(paramArrayOfshort2));
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
/*      */   public static boolean isSameType(Object paramObject1, Object paramObject2) {
/* 3494 */     if (paramObject1 == null || paramObject2 == null) {
/* 3495 */       throw new IllegalArgumentException("The Array must not be null");
/*      */     }
/* 3497 */     return paramObject1.getClass().getName().equals(paramObject2.getClass().getName());
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
/*      */   public static boolean isSorted(boolean[] paramArrayOfboolean) {
/* 3509 */     if (paramArrayOfboolean == null || paramArrayOfboolean.length < 2) {
/* 3510 */       return true;
/*      */     }
/*      */     
/* 3513 */     boolean bool = paramArrayOfboolean[0];
/* 3514 */     int i = paramArrayOfboolean.length;
/* 3515 */     for (byte b = 1; b < i; b++) {
/* 3516 */       boolean bool1 = paramArrayOfboolean[b];
/* 3517 */       if (BooleanUtils.compare(bool, bool1) > 0) {
/* 3518 */         return false;
/*      */       }
/*      */       
/* 3521 */       bool = bool1;
/*      */     } 
/* 3523 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSorted(byte[] paramArrayOfbyte) {
/* 3534 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length < 2) {
/* 3535 */       return true;
/*      */     }
/*      */     
/* 3538 */     byte b = paramArrayOfbyte[0];
/* 3539 */     int i = paramArrayOfbyte.length;
/* 3540 */     for (byte b1 = 1; b1 < i; b1++) {
/* 3541 */       byte b2 = paramArrayOfbyte[b1];
/* 3542 */       if (NumberUtils.compare(b, b2) > 0) {
/* 3543 */         return false;
/*      */       }
/*      */       
/* 3546 */       b = b2;
/*      */     } 
/* 3548 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSorted(char[] paramArrayOfchar) {
/* 3559 */     if (paramArrayOfchar == null || paramArrayOfchar.length < 2) {
/* 3560 */       return true;
/*      */     }
/*      */     
/* 3563 */     char c = paramArrayOfchar[0];
/* 3564 */     int i = paramArrayOfchar.length;
/* 3565 */     for (byte b = 1; b < i; b++) {
/* 3566 */       char c1 = paramArrayOfchar[b];
/* 3567 */       if (CharUtils.compare(c, c1) > 0) {
/* 3568 */         return false;
/*      */       }
/*      */       
/* 3571 */       c = c1;
/*      */     } 
/* 3573 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSorted(double[] paramArrayOfdouble) {
/* 3584 */     if (paramArrayOfdouble == null || paramArrayOfdouble.length < 2) {
/* 3585 */       return true;
/*      */     }
/*      */     
/* 3588 */     double d = paramArrayOfdouble[0];
/* 3589 */     int i = paramArrayOfdouble.length;
/* 3590 */     for (byte b = 1; b < i; b++) {
/* 3591 */       double d1 = paramArrayOfdouble[b];
/* 3592 */       if (Double.compare(d, d1) > 0) {
/* 3593 */         return false;
/*      */       }
/*      */       
/* 3596 */       d = d1;
/*      */     } 
/* 3598 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSorted(float[] paramArrayOffloat) {
/* 3609 */     if (paramArrayOffloat == null || paramArrayOffloat.length < 2) {
/* 3610 */       return true;
/*      */     }
/*      */     
/* 3613 */     float f = paramArrayOffloat[0];
/* 3614 */     int i = paramArrayOffloat.length;
/* 3615 */     for (byte b = 1; b < i; b++) {
/* 3616 */       float f1 = paramArrayOffloat[b];
/* 3617 */       if (Float.compare(f, f1) > 0) {
/* 3618 */         return false;
/*      */       }
/*      */       
/* 3621 */       f = f1;
/*      */     } 
/* 3623 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSorted(int[] paramArrayOfint) {
/* 3634 */     if (paramArrayOfint == null || paramArrayOfint.length < 2) {
/* 3635 */       return true;
/*      */     }
/*      */     
/* 3638 */     int i = paramArrayOfint[0];
/* 3639 */     int j = paramArrayOfint.length;
/* 3640 */     for (byte b = 1; b < j; b++) {
/* 3641 */       int k = paramArrayOfint[b];
/* 3642 */       if (NumberUtils.compare(i, k) > 0) {
/* 3643 */         return false;
/*      */       }
/*      */       
/* 3646 */       i = k;
/*      */     } 
/* 3648 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSorted(long[] paramArrayOflong) {
/* 3659 */     if (paramArrayOflong == null || paramArrayOflong.length < 2) {
/* 3660 */       return true;
/*      */     }
/*      */     
/* 3663 */     long l = paramArrayOflong[0];
/* 3664 */     int i = paramArrayOflong.length;
/* 3665 */     for (byte b = 1; b < i; b++) {
/* 3666 */       long l1 = paramArrayOflong[b];
/* 3667 */       if (NumberUtils.compare(l, l1) > 0) {
/* 3668 */         return false;
/*      */       }
/*      */       
/* 3671 */       l = l1;
/*      */     } 
/* 3673 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSorted(short[] paramArrayOfshort) {
/* 3684 */     if (paramArrayOfshort == null || paramArrayOfshort.length < 2) {
/* 3685 */       return true;
/*      */     }
/*      */     
/* 3688 */     short s = paramArrayOfshort[0];
/* 3689 */     int i = paramArrayOfshort.length;
/* 3690 */     for (byte b = 1; b < i; b++) {
/* 3691 */       short s1 = paramArrayOfshort[b];
/* 3692 */       if (NumberUtils.compare(s, s1) > 0) {
/* 3693 */         return false;
/*      */       }
/*      */       
/* 3696 */       s = s1;
/*      */     } 
/* 3698 */     return true;
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
/*      */   public static <T extends Comparable<? super T>> boolean isSorted(T[] paramArrayOfT) {
/* 3711 */     return isSorted(paramArrayOfT, Comparable::compareTo);
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
/*      */   public static <T> boolean isSorted(T[] paramArrayOfT, Comparator<T> paramComparator) {
/* 3724 */     if (paramComparator == null) {
/* 3725 */       throw new IllegalArgumentException("Comparator should not be null.");
/*      */     }
/*      */     
/* 3728 */     if (paramArrayOfT == null || paramArrayOfT.length < 2) {
/* 3729 */       return true;
/*      */     }
/*      */     
/* 3732 */     T t = paramArrayOfT[0];
/* 3733 */     int i = paramArrayOfT.length;
/* 3734 */     for (byte b = 1; b < i; b++) {
/* 3735 */       T t1 = paramArrayOfT[b];
/* 3736 */       if (paramComparator.compare(t, t1) > 0) {
/* 3737 */         return false;
/*      */       }
/*      */       
/* 3740 */       t = t1;
/*      */     } 
/* 3742 */     return true;
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
/*      */   public static int lastIndexOf(boolean[] paramArrayOfboolean, boolean paramBoolean) {
/* 3757 */     return lastIndexOf(paramArrayOfboolean, paramBoolean, 2147483647);
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
/*      */   public static int lastIndexOf(boolean[] paramArrayOfboolean, boolean paramBoolean, int paramInt) {
/* 3775 */     if (isEmpty(paramArrayOfboolean)) {
/* 3776 */       return -1;
/*      */     }
/* 3778 */     if (paramInt < 0)
/* 3779 */       return -1; 
/* 3780 */     if (paramInt >= paramArrayOfboolean.length) {
/* 3781 */       paramInt = paramArrayOfboolean.length - 1;
/*      */     }
/* 3783 */     for (int i = paramInt; i >= 0; i--) {
/* 3784 */       if (paramBoolean == paramArrayOfboolean[i]) {
/* 3785 */         return i;
/*      */       }
/*      */     } 
/* 3788 */     return -1;
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
/*      */   public static int lastIndexOf(byte[] paramArrayOfbyte, byte paramByte) {
/* 3802 */     return lastIndexOf(paramArrayOfbyte, paramByte, 2147483647);
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
/*      */   public static int lastIndexOf(byte[] paramArrayOfbyte, byte paramByte, int paramInt) {
/* 3820 */     if (paramArrayOfbyte == null) {
/* 3821 */       return -1;
/*      */     }
/* 3823 */     if (paramInt < 0)
/* 3824 */       return -1; 
/* 3825 */     if (paramInt >= paramArrayOfbyte.length) {
/* 3826 */       paramInt = paramArrayOfbyte.length - 1;
/*      */     }
/* 3828 */     for (int i = paramInt; i >= 0; i--) {
/* 3829 */       if (paramByte == paramArrayOfbyte[i]) {
/* 3830 */         return i;
/*      */       }
/*      */     } 
/* 3833 */     return -1;
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
/*      */   public static int lastIndexOf(char[] paramArrayOfchar, char paramChar) {
/* 3848 */     return lastIndexOf(paramArrayOfchar, paramChar, 2147483647);
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
/*      */   public static int lastIndexOf(char[] paramArrayOfchar, char paramChar, int paramInt) {
/* 3867 */     if (paramArrayOfchar == null) {
/* 3868 */       return -1;
/*      */     }
/* 3870 */     if (paramInt < 0)
/* 3871 */       return -1; 
/* 3872 */     if (paramInt >= paramArrayOfchar.length) {
/* 3873 */       paramInt = paramArrayOfchar.length - 1;
/*      */     }
/* 3875 */     for (int i = paramInt; i >= 0; i--) {
/* 3876 */       if (paramChar == paramArrayOfchar[i]) {
/* 3877 */         return i;
/*      */       }
/*      */     } 
/* 3880 */     return -1;
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
/*      */   public static int lastIndexOf(double[] paramArrayOfdouble, double paramDouble) {
/* 3894 */     return lastIndexOf(paramArrayOfdouble, paramDouble, 2147483647);
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
/*      */   public static int lastIndexOf(double[] paramArrayOfdouble, double paramDouble1, double paramDouble2) {
/* 3911 */     return lastIndexOf(paramArrayOfdouble, paramDouble1, 2147483647, paramDouble2);
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
/*      */   public static int lastIndexOf(double[] paramArrayOfdouble, double paramDouble, int paramInt) {
/* 3929 */     if (isEmpty(paramArrayOfdouble)) {
/* 3930 */       return -1;
/*      */     }
/* 3932 */     if (paramInt < 0)
/* 3933 */       return -1; 
/* 3934 */     if (paramInt >= paramArrayOfdouble.length) {
/* 3935 */       paramInt = paramArrayOfdouble.length - 1;
/*      */     }
/* 3937 */     for (int i = paramInt; i >= 0; i--) {
/* 3938 */       if (paramDouble == paramArrayOfdouble[i]) {
/* 3939 */         return i;
/*      */       }
/*      */     } 
/* 3942 */     return -1;
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
/*      */   public static int lastIndexOf(double[] paramArrayOfdouble, double paramDouble1, int paramInt, double paramDouble2) {
/* 3963 */     if (isEmpty(paramArrayOfdouble)) {
/* 3964 */       return -1;
/*      */     }
/* 3966 */     if (paramInt < 0)
/* 3967 */       return -1; 
/* 3968 */     if (paramInt >= paramArrayOfdouble.length) {
/* 3969 */       paramInt = paramArrayOfdouble.length - 1;
/*      */     }
/* 3971 */     double d1 = paramDouble1 - paramDouble2;
/* 3972 */     double d2 = paramDouble1 + paramDouble2;
/* 3973 */     for (int i = paramInt; i >= 0; i--) {
/* 3974 */       if (paramArrayOfdouble[i] >= d1 && paramArrayOfdouble[i] <= d2) {
/* 3975 */         return i;
/*      */       }
/*      */     } 
/* 3978 */     return -1;
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
/*      */   public static int lastIndexOf(float[] paramArrayOffloat, float paramFloat) {
/* 3993 */     return lastIndexOf(paramArrayOffloat, paramFloat, 2147483647);
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
/*      */   public static int lastIndexOf(float[] paramArrayOffloat, float paramFloat, int paramInt) {
/* 4011 */     if (isEmpty(paramArrayOffloat)) {
/* 4012 */       return -1;
/*      */     }
/* 4014 */     if (paramInt < 0)
/* 4015 */       return -1; 
/* 4016 */     if (paramInt >= paramArrayOffloat.length) {
/* 4017 */       paramInt = paramArrayOffloat.length - 1;
/*      */     }
/* 4019 */     for (int i = paramInt; i >= 0; i--) {
/* 4020 */       if (paramFloat == paramArrayOffloat[i]) {
/* 4021 */         return i;
/*      */       }
/*      */     } 
/* 4024 */     return -1;
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
/*      */   public static int lastIndexOf(int[] paramArrayOfint, int paramInt) {
/* 4038 */     return lastIndexOf(paramArrayOfint, paramInt, 2147483647);
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
/*      */   public static int lastIndexOf(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 4056 */     if (paramArrayOfint == null) {
/* 4057 */       return -1;
/*      */     }
/* 4059 */     if (paramInt2 < 0)
/* 4060 */       return -1; 
/* 4061 */     if (paramInt2 >= paramArrayOfint.length) {
/* 4062 */       paramInt2 = paramArrayOfint.length - 1;
/*      */     }
/* 4064 */     for (int i = paramInt2; i >= 0; i--) {
/* 4065 */       if (paramInt1 == paramArrayOfint[i]) {
/* 4066 */         return i;
/*      */       }
/*      */     } 
/* 4069 */     return -1;
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
/*      */   public static int lastIndexOf(long[] paramArrayOflong, long paramLong) {
/* 4083 */     return lastIndexOf(paramArrayOflong, paramLong, 2147483647);
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
/*      */   public static int lastIndexOf(long[] paramArrayOflong, long paramLong, int paramInt) {
/* 4101 */     if (paramArrayOflong == null) {
/* 4102 */       return -1;
/*      */     }
/* 4104 */     if (paramInt < 0)
/* 4105 */       return -1; 
/* 4106 */     if (paramInt >= paramArrayOflong.length) {
/* 4107 */       paramInt = paramArrayOflong.length - 1;
/*      */     }
/* 4109 */     for (int i = paramInt; i >= 0; i--) {
/* 4110 */       if (paramLong == paramArrayOflong[i]) {
/* 4111 */         return i;
/*      */       }
/*      */     } 
/* 4114 */     return -1;
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
/*      */   public static int lastIndexOf(Object[] paramArrayOfObject, Object paramObject) {
/* 4128 */     return lastIndexOf(paramArrayOfObject, paramObject, 2147483647);
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
/*      */   public static int lastIndexOf(Object[] paramArrayOfObject, Object paramObject, int paramInt) {
/* 4146 */     if (paramArrayOfObject == null) {
/* 4147 */       return -1;
/*      */     }
/* 4149 */     if (paramInt < 0)
/* 4150 */       return -1; 
/* 4151 */     if (paramInt >= paramArrayOfObject.length) {
/* 4152 */       paramInt = paramArrayOfObject.length - 1;
/*      */     }
/* 4154 */     if (paramObject == null) {
/* 4155 */       for (int i = paramInt; i >= 0; i--) {
/* 4156 */         if (paramArrayOfObject[i] == null) {
/* 4157 */           return i;
/*      */         }
/*      */       } 
/* 4160 */     } else if (paramArrayOfObject.getClass().getComponentType().isInstance(paramObject)) {
/* 4161 */       for (int i = paramInt; i >= 0; i--) {
/* 4162 */         if (paramObject.equals(paramArrayOfObject[i])) {
/* 4163 */           return i;
/*      */         }
/*      */       } 
/*      */     } 
/* 4167 */     return -1;
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
/*      */   public static int lastIndexOf(short[] paramArrayOfshort, short paramShort) {
/* 4181 */     return lastIndexOf(paramArrayOfshort, paramShort, 2147483647);
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
/*      */   public static int lastIndexOf(short[] paramArrayOfshort, short paramShort, int paramInt) {
/* 4199 */     if (paramArrayOfshort == null) {
/* 4200 */       return -1;
/*      */     }
/* 4202 */     if (paramInt < 0)
/* 4203 */       return -1; 
/* 4204 */     if (paramInt >= paramArrayOfshort.length) {
/* 4205 */       paramInt = paramArrayOfshort.length - 1;
/*      */     }
/* 4207 */     for (int i = paramInt; i >= 0; i--) {
/* 4208 */       if (paramShort == paramArrayOfshort[i]) {
/* 4209 */         return i;
/*      */       }
/*      */     } 
/* 4212 */     return -1;
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
/*      */   public static boolean[] nullToEmpty(boolean[] paramArrayOfboolean) {
/* 4229 */     if (isEmpty(paramArrayOfboolean)) {
/* 4230 */       return EMPTY_BOOLEAN_ARRAY;
/*      */     }
/* 4232 */     return paramArrayOfboolean;
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
/*      */   public static Boolean[] nullToEmpty(Boolean[] paramArrayOfBoolean) {
/* 4249 */     if (isEmpty((Object[])paramArrayOfBoolean)) {
/* 4250 */       return EMPTY_BOOLEAN_OBJECT_ARRAY;
/*      */     }
/* 4252 */     return paramArrayOfBoolean;
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
/*      */   public static byte[] nullToEmpty(byte[] paramArrayOfbyte) {
/* 4269 */     if (isEmpty(paramArrayOfbyte)) {
/* 4270 */       return EMPTY_BYTE_ARRAY;
/*      */     }
/* 4272 */     return paramArrayOfbyte;
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
/*      */   public static Byte[] nullToEmpty(Byte[] paramArrayOfByte) {
/* 4289 */     if (isEmpty((Object[])paramArrayOfByte)) {
/* 4290 */       return EMPTY_BYTE_OBJECT_ARRAY;
/*      */     }
/* 4292 */     return paramArrayOfByte;
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
/*      */   public static char[] nullToEmpty(char[] paramArrayOfchar) {
/* 4309 */     if (isEmpty(paramArrayOfchar)) {
/* 4310 */       return EMPTY_CHAR_ARRAY;
/*      */     }
/* 4312 */     return paramArrayOfchar;
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
/*      */   public static Character[] nullToEmpty(Character[] paramArrayOfCharacter) {
/* 4329 */     if (isEmpty((Object[])paramArrayOfCharacter)) {
/* 4330 */       return EMPTY_CHARACTER_OBJECT_ARRAY;
/*      */     }
/* 4332 */     return paramArrayOfCharacter;
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
/*      */   public static Class<?>[] nullToEmpty(Class<?>[] paramArrayOfClass) {
/* 4349 */     if (isEmpty((Object[])paramArrayOfClass)) {
/* 4350 */       return EMPTY_CLASS_ARRAY;
/*      */     }
/* 4352 */     return paramArrayOfClass;
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
/*      */   public static double[] nullToEmpty(double[] paramArrayOfdouble) {
/* 4369 */     if (isEmpty(paramArrayOfdouble)) {
/* 4370 */       return EMPTY_DOUBLE_ARRAY;
/*      */     }
/* 4372 */     return paramArrayOfdouble;
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
/*      */   public static Double[] nullToEmpty(Double[] paramArrayOfDouble) {
/* 4389 */     if (isEmpty((Object[])paramArrayOfDouble)) {
/* 4390 */       return EMPTY_DOUBLE_OBJECT_ARRAY;
/*      */     }
/* 4392 */     return paramArrayOfDouble;
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
/*      */   public static float[] nullToEmpty(float[] paramArrayOffloat) {
/* 4409 */     if (isEmpty(paramArrayOffloat)) {
/* 4410 */       return EMPTY_FLOAT_ARRAY;
/*      */     }
/* 4412 */     return paramArrayOffloat;
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
/*      */   public static Float[] nullToEmpty(Float[] paramArrayOfFloat) {
/* 4429 */     if (isEmpty((Object[])paramArrayOfFloat)) {
/* 4430 */       return EMPTY_FLOAT_OBJECT_ARRAY;
/*      */     }
/* 4432 */     return paramArrayOfFloat;
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
/*      */   public static int[] nullToEmpty(int[] paramArrayOfint) {
/* 4449 */     if (isEmpty(paramArrayOfint)) {
/* 4450 */       return EMPTY_INT_ARRAY;
/*      */     }
/* 4452 */     return paramArrayOfint;
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
/*      */   public static Integer[] nullToEmpty(Integer[] paramArrayOfInteger) {
/* 4472 */     if (isEmpty((Object[])paramArrayOfInteger)) {
/* 4473 */       return EMPTY_INTEGER_OBJECT_ARRAY;
/*      */     }
/* 4475 */     return paramArrayOfInteger;
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
/*      */   public static long[] nullToEmpty(long[] paramArrayOflong) {
/* 4492 */     if (isEmpty(paramArrayOflong)) {
/* 4493 */       return EMPTY_LONG_ARRAY;
/*      */     }
/* 4495 */     return paramArrayOflong;
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
/*      */   public static Long[] nullToEmpty(Long[] paramArrayOfLong) {
/* 4512 */     if (isEmpty((Object[])paramArrayOfLong)) {
/* 4513 */       return EMPTY_LONG_OBJECT_ARRAY;
/*      */     }
/* 4515 */     return paramArrayOfLong;
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
/*      */   public static Object[] nullToEmpty(Object[] paramArrayOfObject) {
/* 4532 */     if (isEmpty(paramArrayOfObject)) {
/* 4533 */       return EMPTY_OBJECT_ARRAY;
/*      */     }
/* 4535 */     return paramArrayOfObject;
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
/*      */   public static short[] nullToEmpty(short[] paramArrayOfshort) {
/* 4552 */     if (isEmpty(paramArrayOfshort)) {
/* 4553 */       return EMPTY_SHORT_ARRAY;
/*      */     }
/* 4555 */     return paramArrayOfshort;
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
/*      */   public static Short[] nullToEmpty(Short[] paramArrayOfShort) {
/* 4572 */     if (isEmpty((Object[])paramArrayOfShort)) {
/* 4573 */       return EMPTY_SHORT_OBJECT_ARRAY;
/*      */     }
/* 4575 */     return paramArrayOfShort;
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
/*      */   public static String[] nullToEmpty(String[] paramArrayOfString) {
/* 4592 */     if (isEmpty((Object[])paramArrayOfString)) {
/* 4593 */       return EMPTY_STRING_ARRAY;
/*      */     }
/* 4595 */     return paramArrayOfString;
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
/*      */   public static <T> T[] nullToEmpty(T[] paramArrayOfT, Class<T[]> paramClass) {
/* 4614 */     if (paramClass == null) {
/* 4615 */       throw new IllegalArgumentException("The type must not be null");
/*      */     }
/*      */     
/* 4618 */     if (paramArrayOfT == null) {
/* 4619 */       return paramClass.cast(Array.newInstance(paramClass.getComponentType(), 0));
/*      */     }
/* 4621 */     return paramArrayOfT;
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
/*      */   public static boolean[] remove(boolean[] paramArrayOfboolean, int paramInt) {
/* 4653 */     return (boolean[])remove(paramArrayOfboolean, paramInt);
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
/*      */   public static byte[] remove(byte[] paramArrayOfbyte, int paramInt) {
/* 4685 */     return (byte[])remove(paramArrayOfbyte, paramInt);
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
/*      */   public static char[] remove(char[] paramArrayOfchar, int paramInt) {
/* 4717 */     return (char[])remove(paramArrayOfchar, paramInt);
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
/*      */   public static double[] remove(double[] paramArrayOfdouble, int paramInt) {
/* 4749 */     return (double[])remove(paramArrayOfdouble, paramInt);
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
/*      */   public static float[] remove(float[] paramArrayOffloat, int paramInt) {
/* 4781 */     return (float[])remove(paramArrayOffloat, paramInt);
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
/*      */   public static int[] remove(int[] paramArrayOfint, int paramInt) {
/* 4813 */     return (int[])remove(paramArrayOfint, paramInt);
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
/*      */   public static long[] remove(long[] paramArrayOflong, int paramInt) {
/* 4845 */     return (long[])remove(paramArrayOflong, paramInt);
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
/*      */   private static Object remove(Object paramObject, int paramInt) {
/* 4870 */     int i = getLength(paramObject);
/* 4871 */     if (paramInt < 0 || paramInt >= i) {
/* 4872 */       throw new IndexOutOfBoundsException("Index: " + paramInt + ", Length: " + i);
/*      */     }
/*      */     
/* 4875 */     Object object = Array.newInstance(paramObject.getClass().getComponentType(), i - 1);
/* 4876 */     System.arraycopy(paramObject, 0, object, 0, paramInt);
/* 4877 */     if (paramInt < i - 1) {
/* 4878 */       System.arraycopy(paramObject, paramInt + 1, object, paramInt, i - paramInt - 1);
/*      */     }
/*      */     
/* 4881 */     return object;
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
/*      */   public static short[] remove(short[] paramArrayOfshort, int paramInt) {
/* 4913 */     return (short[])remove(paramArrayOfshort, paramInt);
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
/*      */   public static <T> T[] remove(T[] paramArrayOfT, int paramInt) {
/* 4947 */     return (T[])remove(paramArrayOfT, paramInt);
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
/*      */   public static boolean[] removeAll(boolean[] paramArrayOfboolean, int... paramVarArgs) {
/* 4976 */     return (boolean[])removeAll(paramArrayOfboolean, paramVarArgs);
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
/*      */   public static byte[] removeAll(byte[] paramArrayOfbyte, int... paramVarArgs) {
/* 5009 */     return (byte[])removeAll(paramArrayOfbyte, paramVarArgs);
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
/*      */   public static char[] removeAll(char[] paramArrayOfchar, int... paramVarArgs) {
/* 5042 */     return (char[])removeAll(paramArrayOfchar, paramVarArgs);
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
/*      */   public static double[] removeAll(double[] paramArrayOfdouble, int... paramVarArgs) {
/* 5075 */     return (double[])removeAll(paramArrayOfdouble, paramVarArgs);
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
/*      */   public static float[] removeAll(float[] paramArrayOffloat, int... paramVarArgs) {
/* 5108 */     return (float[])removeAll(paramArrayOffloat, paramVarArgs);
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
/*      */   public static int[] removeAll(int[] paramArrayOfint1, int... paramVarArgs1) {
/* 5141 */     return (int[])removeAll(paramArrayOfint1, paramVarArgs1);
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
/*      */   public static long[] removeAll(long[] paramArrayOflong, int... paramVarArgs) {
/* 5174 */     return (long[])removeAll(paramArrayOflong, paramVarArgs);
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
/*      */   static Object removeAll(Object paramObject, BitSet paramBitSet) {
/* 5187 */     if (paramObject == null) {
/* 5188 */       return null;
/*      */     }
/*      */     
/* 5191 */     int i = getLength(paramObject);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5198 */     int j = paramBitSet.cardinality();
/* 5199 */     Object object = Array.newInstance(paramObject.getClass().getComponentType(), i - j);
/* 5200 */     int k = 0;
/* 5201 */     int m = 0;
/*      */     
/*      */     int i1;
/* 5204 */     while ((i1 = paramBitSet.nextSetBit(k)) != -1) {
/* 5205 */       int i2 = i1 - k;
/* 5206 */       if (i2 > 0) {
/* 5207 */         System.arraycopy(paramObject, k, object, m, i2);
/* 5208 */         m += i2;
/*      */       } 
/* 5210 */       k = paramBitSet.nextClearBit(i1);
/*      */     } 
/* 5212 */     int n = i - k;
/* 5213 */     if (n > 0) {
/* 5214 */       System.arraycopy(paramObject, k, object, m, n);
/*      */     }
/* 5216 */     return object;
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
/*      */   static Object removeAll(Object paramObject, int... paramVarArgs) {
/* 5228 */     int i = getLength(paramObject);
/* 5229 */     byte b = 0;
/* 5230 */     int[] arrayOfInt = clone(paramVarArgs);
/* 5231 */     Arrays.sort(arrayOfInt);
/*      */ 
/*      */     
/* 5234 */     if (isNotEmpty(arrayOfInt)) {
/* 5235 */       int j = arrayOfInt.length;
/* 5236 */       int k = i;
/* 5237 */       while (--j >= 0) {
/* 5238 */         int m = arrayOfInt[j];
/* 5239 */         if (m < 0 || m >= i) {
/* 5240 */           throw new IndexOutOfBoundsException("Index: " + m + ", Length: " + i);
/*      */         }
/* 5242 */         if (m >= k) {
/*      */           continue;
/*      */         }
/* 5245 */         b++;
/* 5246 */         k = m;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 5251 */     Object object = Array.newInstance(paramObject.getClass().getComponentType(), i - b);
/* 5252 */     if (b < i) {
/* 5253 */       int j = i;
/* 5254 */       int k = i - b;
/* 5255 */       for (int m = arrayOfInt.length - 1; m >= 0; m--) {
/* 5256 */         int n = arrayOfInt[m];
/* 5257 */         if (j - n > 1) {
/* 5258 */           int i1 = j - n - 1;
/* 5259 */           k -= i1;
/* 5260 */           System.arraycopy(paramObject, n + 1, object, k, i1);
/*      */         } 
/*      */         
/* 5263 */         j = n;
/*      */       } 
/* 5265 */       if (j > 0) {
/* 5266 */         System.arraycopy(paramObject, 0, object, 0, j);
/*      */       }
/*      */     } 
/* 5269 */     return object;
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
/*      */   public static short[] removeAll(short[] paramArrayOfshort, int... paramVarArgs) {
/* 5302 */     return (short[])removeAll(paramArrayOfshort, paramVarArgs);
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
/*      */   public static <T> T[] removeAll(T[] paramArrayOfT, int... paramVarArgs) {
/* 5333 */     return (T[])removeAll(paramArrayOfT, paramVarArgs);
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
/*      */   public static boolean[] removeAllOccurences(boolean[] paramArrayOfboolean, boolean paramBoolean) {
/* 5354 */     return (boolean[])removeAll(paramArrayOfboolean, indexesOf(paramArrayOfboolean, paramBoolean));
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
/*      */   public static byte[] removeAllOccurences(byte[] paramArrayOfbyte, byte paramByte) {
/* 5375 */     return (byte[])removeAll(paramArrayOfbyte, indexesOf(paramArrayOfbyte, paramByte));
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
/*      */   public static char[] removeAllOccurences(char[] paramArrayOfchar, char paramChar) {
/* 5396 */     return (char[])removeAll(paramArrayOfchar, indexesOf(paramArrayOfchar, paramChar));
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
/*      */   public static double[] removeAllOccurences(double[] paramArrayOfdouble, double paramDouble) {
/* 5417 */     return (double[])removeAll(paramArrayOfdouble, indexesOf(paramArrayOfdouble, paramDouble));
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
/*      */   public static float[] removeAllOccurences(float[] paramArrayOffloat, float paramFloat) {
/* 5438 */     return (float[])removeAll(paramArrayOffloat, indexesOf(paramArrayOffloat, paramFloat));
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
/*      */   public static int[] removeAllOccurences(int[] paramArrayOfint, int paramInt) {
/* 5459 */     return (int[])removeAll(paramArrayOfint, indexesOf(paramArrayOfint, paramInt));
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
/*      */   public static long[] removeAllOccurences(long[] paramArrayOflong, long paramLong) {
/* 5480 */     return (long[])removeAll(paramArrayOflong, indexesOf(paramArrayOflong, paramLong));
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
/*      */   public static short[] removeAllOccurences(short[] paramArrayOfshort, short paramShort) {
/* 5501 */     return (short[])removeAll(paramArrayOfshort, indexesOf(paramArrayOfshort, paramShort));
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
/*      */   public static <T> T[] removeAllOccurences(T[] paramArrayOfT, T paramT) {
/* 5523 */     return (T[])removeAll(paramArrayOfT, indexesOf((Object[])paramArrayOfT, paramT));
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
/*      */   public static boolean[] removeAllOccurrences(boolean[] paramArrayOfboolean, boolean paramBoolean) {
/* 5542 */     return (boolean[])removeAll(paramArrayOfboolean, indexesOf(paramArrayOfboolean, paramBoolean));
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
/*      */   public static byte[] removeAllOccurrences(byte[] paramArrayOfbyte, byte paramByte) {
/* 5561 */     return (byte[])removeAll(paramArrayOfbyte, indexesOf(paramArrayOfbyte, paramByte));
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
/*      */   public static char[] removeAllOccurrences(char[] paramArrayOfchar, char paramChar) {
/* 5580 */     return (char[])removeAll(paramArrayOfchar, indexesOf(paramArrayOfchar, paramChar));
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
/*      */   public static double[] removeAllOccurrences(double[] paramArrayOfdouble, double paramDouble) {
/* 5599 */     return (double[])removeAll(paramArrayOfdouble, indexesOf(paramArrayOfdouble, paramDouble));
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
/*      */   public static float[] removeAllOccurrences(float[] paramArrayOffloat, float paramFloat) {
/* 5618 */     return (float[])removeAll(paramArrayOffloat, indexesOf(paramArrayOffloat, paramFloat));
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
/*      */   public static int[] removeAllOccurrences(int[] paramArrayOfint, int paramInt) {
/* 5637 */     return (int[])removeAll(paramArrayOfint, indexesOf(paramArrayOfint, paramInt));
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
/*      */   public static long[] removeAllOccurrences(long[] paramArrayOflong, long paramLong) {
/* 5656 */     return (long[])removeAll(paramArrayOflong, indexesOf(paramArrayOflong, paramLong));
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
/*      */   public static short[] removeAllOccurrences(short[] paramArrayOfshort, short paramShort) {
/* 5675 */     return (short[])removeAll(paramArrayOfshort, indexesOf(paramArrayOfshort, paramShort));
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
/*      */   public static <T> T[] removeAllOccurrences(T[] paramArrayOfT, T paramT) {
/* 5695 */     return (T[])removeAll(paramArrayOfT, indexesOf((Object[])paramArrayOfT, paramT));
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
/*      */   public static boolean[] removeElement(boolean[] paramArrayOfboolean, boolean paramBoolean) {
/* 5724 */     int i = indexOf(paramArrayOfboolean, paramBoolean);
/* 5725 */     if (i == -1) {
/* 5726 */       return clone(paramArrayOfboolean);
/*      */     }
/* 5728 */     return remove(paramArrayOfboolean, i);
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
/*      */   public static byte[] removeElement(byte[] paramArrayOfbyte, byte paramByte) {
/* 5757 */     int i = indexOf(paramArrayOfbyte, paramByte);
/* 5758 */     if (i == -1) {
/* 5759 */       return clone(paramArrayOfbyte);
/*      */     }
/* 5761 */     return remove(paramArrayOfbyte, i);
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
/*      */   public static char[] removeElement(char[] paramArrayOfchar, char paramChar) {
/* 5790 */     int i = indexOf(paramArrayOfchar, paramChar);
/* 5791 */     if (i == -1) {
/* 5792 */       return clone(paramArrayOfchar);
/*      */     }
/* 5794 */     return remove(paramArrayOfchar, i);
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
/*      */   public static double[] removeElement(double[] paramArrayOfdouble, double paramDouble) {
/* 5823 */     int i = indexOf(paramArrayOfdouble, paramDouble);
/* 5824 */     if (i == -1) {
/* 5825 */       return clone(paramArrayOfdouble);
/*      */     }
/* 5827 */     return remove(paramArrayOfdouble, i);
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
/*      */   public static float[] removeElement(float[] paramArrayOffloat, float paramFloat) {
/* 5856 */     int i = indexOf(paramArrayOffloat, paramFloat);
/* 5857 */     if (i == -1) {
/* 5858 */       return clone(paramArrayOffloat);
/*      */     }
/* 5860 */     return remove(paramArrayOffloat, i);
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
/*      */   public static int[] removeElement(int[] paramArrayOfint, int paramInt) {
/* 5889 */     int i = indexOf(paramArrayOfint, paramInt);
/* 5890 */     if (i == -1) {
/* 5891 */       return clone(paramArrayOfint);
/*      */     }
/* 5893 */     return remove(paramArrayOfint, i);
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
/*      */   public static long[] removeElement(long[] paramArrayOflong, long paramLong) {
/* 5922 */     int i = indexOf(paramArrayOflong, paramLong);
/* 5923 */     if (i == -1) {
/* 5924 */       return clone(paramArrayOflong);
/*      */     }
/* 5926 */     return remove(paramArrayOflong, i);
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
/*      */   public static short[] removeElement(short[] paramArrayOfshort, short paramShort) {
/* 5955 */     int i = indexOf(paramArrayOfshort, paramShort);
/* 5956 */     if (i == -1) {
/* 5957 */       return clone(paramArrayOfshort);
/*      */     }
/* 5959 */     return remove(paramArrayOfshort, i);
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
/*      */   public static <T> T[] removeElement(T[] paramArrayOfT, Object paramObject) {
/* 5989 */     int i = indexOf((Object[])paramArrayOfT, paramObject);
/* 5990 */     if (i == -1) {
/* 5991 */       return clone(paramArrayOfT);
/*      */     }
/* 5993 */     return remove(paramArrayOfT, i);
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
/*      */   public static boolean[] removeElements(boolean[] paramArrayOfboolean1, boolean... paramVarArgs1) {
/* 6024 */     if (isEmpty(paramArrayOfboolean1) || isEmpty(paramVarArgs1)) {
/* 6025 */       return clone(paramArrayOfboolean1);
/*      */     }
/* 6027 */     HashMap<Object, Object> hashMap = new HashMap<>(2);
/* 6028 */     for (boolean bool : paramVarArgs1) {
/* 6029 */       Boolean bool1 = Boolean.valueOf(bool);
/* 6030 */       MutableInt mutableInt = (MutableInt)hashMap.get(bool1);
/* 6031 */       if (mutableInt == null) {
/* 6032 */         hashMap.put(bool1, new MutableInt(1));
/*      */       } else {
/* 6034 */         mutableInt.increment();
/*      */       } 
/*      */     } 
/* 6037 */     BitSet bitSet = new BitSet();
/* 6038 */     for (byte b = 0; b < paramArrayOfboolean1.length; b++) {
/* 6039 */       boolean bool = paramArrayOfboolean1[b];
/* 6040 */       MutableInt mutableInt = (MutableInt)hashMap.get(Boolean.valueOf(bool));
/* 6041 */       if (mutableInt != null) {
/* 6042 */         if (mutableInt.decrementAndGet() == 0) {
/* 6043 */           hashMap.remove(Boolean.valueOf(bool));
/*      */         }
/* 6045 */         bitSet.set(b);
/*      */       } 
/*      */     } 
/* 6048 */     return (boolean[])removeAll(paramArrayOfboolean1, bitSet);
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
/*      */   public static byte[] removeElements(byte[] paramArrayOfbyte1, byte... paramVarArgs1) {
/* 6079 */     if (isEmpty(paramArrayOfbyte1) || isEmpty(paramVarArgs1)) {
/* 6080 */       return clone(paramArrayOfbyte1);
/*      */     }
/* 6082 */     HashMap<Object, Object> hashMap = new HashMap<>(paramVarArgs1.length);
/* 6083 */     for (byte b1 : paramVarArgs1) {
/* 6084 */       Byte byte_ = Byte.valueOf(b1);
/* 6085 */       MutableInt mutableInt = (MutableInt)hashMap.get(byte_);
/* 6086 */       if (mutableInt == null) {
/* 6087 */         hashMap.put(byte_, new MutableInt(1));
/*      */       } else {
/* 6089 */         mutableInt.increment();
/*      */       } 
/*      */     } 
/* 6092 */     BitSet bitSet = new BitSet();
/* 6093 */     for (byte b = 0; b < paramArrayOfbyte1.length; b++) {
/* 6094 */       byte b1 = paramArrayOfbyte1[b];
/* 6095 */       MutableInt mutableInt = (MutableInt)hashMap.get(Byte.valueOf(b1));
/* 6096 */       if (mutableInt != null) {
/* 6097 */         if (mutableInt.decrementAndGet() == 0) {
/* 6098 */           hashMap.remove(Byte.valueOf(b1));
/*      */         }
/* 6100 */         bitSet.set(b);
/*      */       } 
/*      */     } 
/* 6103 */     return (byte[])removeAll(paramArrayOfbyte1, bitSet);
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
/*      */   public static char[] removeElements(char[] paramArrayOfchar1, char... paramVarArgs1) {
/* 6134 */     if (isEmpty(paramArrayOfchar1) || isEmpty(paramVarArgs1)) {
/* 6135 */       return clone(paramArrayOfchar1);
/*      */     }
/* 6137 */     HashMap<Object, Object> hashMap = new HashMap<>(paramVarArgs1.length);
/* 6138 */     for (char c : paramVarArgs1) {
/* 6139 */       Character character = Character.valueOf(c);
/* 6140 */       MutableInt mutableInt = (MutableInt)hashMap.get(character);
/* 6141 */       if (mutableInt == null) {
/* 6142 */         hashMap.put(character, new MutableInt(1));
/*      */       } else {
/* 6144 */         mutableInt.increment();
/*      */       } 
/*      */     } 
/* 6147 */     BitSet bitSet = new BitSet();
/* 6148 */     for (byte b = 0; b < paramArrayOfchar1.length; b++) {
/* 6149 */       char c = paramArrayOfchar1[b];
/* 6150 */       MutableInt mutableInt = (MutableInt)hashMap.get(Character.valueOf(c));
/* 6151 */       if (mutableInt != null) {
/* 6152 */         if (mutableInt.decrementAndGet() == 0) {
/* 6153 */           hashMap.remove(Character.valueOf(c));
/*      */         }
/* 6155 */         bitSet.set(b);
/*      */       } 
/*      */     } 
/* 6158 */     return (char[])removeAll(paramArrayOfchar1, bitSet);
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
/*      */   public static double[] removeElements(double[] paramArrayOfdouble1, double... paramVarArgs1) {
/* 6189 */     if (isEmpty(paramArrayOfdouble1) || isEmpty(paramVarArgs1)) {
/* 6190 */       return clone(paramArrayOfdouble1);
/*      */     }
/* 6192 */     HashMap<Object, Object> hashMap = new HashMap<>(paramVarArgs1.length);
/* 6193 */     for (double d : paramVarArgs1) {
/* 6194 */       Double double_ = Double.valueOf(d);
/* 6195 */       MutableInt mutableInt = (MutableInt)hashMap.get(double_);
/* 6196 */       if (mutableInt == null) {
/* 6197 */         hashMap.put(double_, new MutableInt(1));
/*      */       } else {
/* 6199 */         mutableInt.increment();
/*      */       } 
/*      */     } 
/* 6202 */     BitSet bitSet = new BitSet();
/* 6203 */     for (byte b = 0; b < paramArrayOfdouble1.length; b++) {
/* 6204 */       double d = paramArrayOfdouble1[b];
/* 6205 */       MutableInt mutableInt = (MutableInt)hashMap.get(Double.valueOf(d));
/* 6206 */       if (mutableInt != null) {
/* 6207 */         if (mutableInt.decrementAndGet() == 0) {
/* 6208 */           hashMap.remove(Double.valueOf(d));
/*      */         }
/* 6210 */         bitSet.set(b);
/*      */       } 
/*      */     } 
/* 6213 */     return (double[])removeAll(paramArrayOfdouble1, bitSet);
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
/*      */   public static float[] removeElements(float[] paramArrayOffloat1, float... paramVarArgs1) {
/* 6244 */     if (isEmpty(paramArrayOffloat1) || isEmpty(paramVarArgs1)) {
/* 6245 */       return clone(paramArrayOffloat1);
/*      */     }
/* 6247 */     HashMap<Object, Object> hashMap = new HashMap<>(paramVarArgs1.length);
/* 6248 */     for (float f : paramVarArgs1) {
/* 6249 */       Float float_ = Float.valueOf(f);
/* 6250 */       MutableInt mutableInt = (MutableInt)hashMap.get(float_);
/* 6251 */       if (mutableInt == null) {
/* 6252 */         hashMap.put(float_, new MutableInt(1));
/*      */       } else {
/* 6254 */         mutableInt.increment();
/*      */       } 
/*      */     } 
/* 6257 */     BitSet bitSet = new BitSet();
/* 6258 */     for (byte b = 0; b < paramArrayOffloat1.length; b++) {
/* 6259 */       float f = paramArrayOffloat1[b];
/* 6260 */       MutableInt mutableInt = (MutableInt)hashMap.get(Float.valueOf(f));
/* 6261 */       if (mutableInt != null) {
/* 6262 */         if (mutableInt.decrementAndGet() == 0) {
/* 6263 */           hashMap.remove(Float.valueOf(f));
/*      */         }
/* 6265 */         bitSet.set(b);
/*      */       } 
/*      */     } 
/* 6268 */     return (float[])removeAll(paramArrayOffloat1, bitSet);
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
/*      */   public static int[] removeElements(int[] paramArrayOfint1, int... paramVarArgs1) {
/* 6299 */     if (isEmpty(paramArrayOfint1) || isEmpty(paramVarArgs1)) {
/* 6300 */       return clone(paramArrayOfint1);
/*      */     }
/* 6302 */     HashMap<Object, Object> hashMap = new HashMap<>(paramVarArgs1.length);
/* 6303 */     for (int i : paramVarArgs1) {
/* 6304 */       Integer integer = Integer.valueOf(i);
/* 6305 */       MutableInt mutableInt = (MutableInt)hashMap.get(integer);
/* 6306 */       if (mutableInt == null) {
/* 6307 */         hashMap.put(integer, new MutableInt(1));
/*      */       } else {
/* 6309 */         mutableInt.increment();
/*      */       } 
/*      */     } 
/* 6312 */     BitSet bitSet = new BitSet();
/* 6313 */     for (byte b = 0; b < paramArrayOfint1.length; b++) {
/* 6314 */       int i = paramArrayOfint1[b];
/* 6315 */       MutableInt mutableInt = (MutableInt)hashMap.get(Integer.valueOf(i));
/* 6316 */       if (mutableInt != null) {
/* 6317 */         if (mutableInt.decrementAndGet() == 0) {
/* 6318 */           hashMap.remove(Integer.valueOf(i));
/*      */         }
/* 6320 */         bitSet.set(b);
/*      */       } 
/*      */     } 
/* 6323 */     return (int[])removeAll(paramArrayOfint1, bitSet);
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
/*      */   public static long[] removeElements(long[] paramArrayOflong1, long... paramVarArgs1) {
/* 6354 */     if (isEmpty(paramArrayOflong1) || isEmpty(paramVarArgs1)) {
/* 6355 */       return clone(paramArrayOflong1);
/*      */     }
/* 6357 */     HashMap<Object, Object> hashMap = new HashMap<>(paramVarArgs1.length);
/* 6358 */     for (long l : paramVarArgs1) {
/* 6359 */       Long long_ = Long.valueOf(l);
/* 6360 */       MutableInt mutableInt = (MutableInt)hashMap.get(long_);
/* 6361 */       if (mutableInt == null) {
/* 6362 */         hashMap.put(long_, new MutableInt(1));
/*      */       } else {
/* 6364 */         mutableInt.increment();
/*      */       } 
/*      */     } 
/* 6367 */     BitSet bitSet = new BitSet();
/* 6368 */     for (byte b = 0; b < paramArrayOflong1.length; b++) {
/* 6369 */       long l = paramArrayOflong1[b];
/* 6370 */       MutableInt mutableInt = (MutableInt)hashMap.get(Long.valueOf(l));
/* 6371 */       if (mutableInt != null) {
/* 6372 */         if (mutableInt.decrementAndGet() == 0) {
/* 6373 */           hashMap.remove(Long.valueOf(l));
/*      */         }
/* 6375 */         bitSet.set(b);
/*      */       } 
/*      */     } 
/* 6378 */     return (long[])removeAll(paramArrayOflong1, bitSet);
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
/*      */   public static short[] removeElements(short[] paramArrayOfshort1, short... paramVarArgs1) {
/* 6409 */     if (isEmpty(paramArrayOfshort1) || isEmpty(paramVarArgs1)) {
/* 6410 */       return clone(paramArrayOfshort1);
/*      */     }
/* 6412 */     HashMap<Object, Object> hashMap = new HashMap<>(paramVarArgs1.length);
/* 6413 */     for (short s : paramVarArgs1) {
/* 6414 */       Short short_ = Short.valueOf(s);
/* 6415 */       MutableInt mutableInt = (MutableInt)hashMap.get(short_);
/* 6416 */       if (mutableInt == null) {
/* 6417 */         hashMap.put(short_, new MutableInt(1));
/*      */       } else {
/* 6419 */         mutableInt.increment();
/*      */       } 
/*      */     } 
/* 6422 */     BitSet bitSet = new BitSet();
/* 6423 */     for (byte b = 0; b < paramArrayOfshort1.length; b++) {
/* 6424 */       short s = paramArrayOfshort1[b];
/* 6425 */       MutableInt mutableInt = (MutableInt)hashMap.get(Short.valueOf(s));
/* 6426 */       if (mutableInt != null) {
/* 6427 */         if (mutableInt.decrementAndGet() == 0) {
/* 6428 */           hashMap.remove(Short.valueOf(s));
/*      */         }
/* 6430 */         bitSet.set(b);
/*      */       } 
/*      */     } 
/* 6433 */     return (short[])removeAll(paramArrayOfshort1, bitSet);
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
/*      */   @SafeVarargs
/*      */   public static <T> T[] removeElements(T[] paramArrayOfT1, T... paramVarArgs1) {
/* 6466 */     if (isEmpty((Object[])paramArrayOfT1) || isEmpty((Object[])paramVarArgs1)) {
/* 6467 */       return clone(paramArrayOfT1);
/*      */     }
/* 6469 */     HashMap<Object, Object> hashMap = new HashMap<>(paramVarArgs1.length);
/* 6470 */     for (T t : paramVarArgs1) {
/* 6471 */       MutableInt mutableInt = (MutableInt)hashMap.get(t);
/* 6472 */       if (mutableInt == null) {
/* 6473 */         hashMap.put(t, new MutableInt(1));
/*      */       } else {
/* 6475 */         mutableInt.increment();
/*      */       } 
/*      */     } 
/* 6478 */     BitSet bitSet = new BitSet();
/* 6479 */     for (byte b = 0; b < paramArrayOfT1.length; b++) {
/* 6480 */       T t = paramArrayOfT1[b];
/* 6481 */       MutableInt mutableInt = (MutableInt)hashMap.get(t);
/* 6482 */       if (mutableInt != null) {
/* 6483 */         if (mutableInt.decrementAndGet() == 0) {
/* 6484 */           hashMap.remove(t);
/*      */         }
/* 6486 */         bitSet.set(b);
/*      */       } 
/*      */     } 
/*      */     
/* 6490 */     return (T[])removeAll(paramArrayOfT1, bitSet);
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
/*      */   public static void reverse(boolean[] paramArrayOfboolean) {
/* 6502 */     if (paramArrayOfboolean == null) {
/*      */       return;
/*      */     }
/* 6505 */     reverse(paramArrayOfboolean, 0, paramArrayOfboolean.length);
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
/*      */   public static void reverse(boolean[] paramArrayOfboolean, int paramInt1, int paramInt2) {
/* 6526 */     if (paramArrayOfboolean == null) {
/*      */       return;
/*      */     }
/* 6529 */     int i = Math.max(paramInt1, 0);
/* 6530 */     int j = Math.min(paramArrayOfboolean.length, paramInt2) - 1;
/*      */     
/* 6532 */     while (j > i) {
/* 6533 */       boolean bool = paramArrayOfboolean[j];
/* 6534 */       paramArrayOfboolean[j] = paramArrayOfboolean[i];
/* 6535 */       paramArrayOfboolean[i] = bool;
/* 6536 */       j--;
/* 6537 */       i++;
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
/*      */   public static void reverse(byte[] paramArrayOfbyte) {
/* 6549 */     if (paramArrayOfbyte == null) {
/*      */       return;
/*      */     }
/* 6552 */     reverse(paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*      */   public static void reverse(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 6573 */     if (paramArrayOfbyte == null) {
/*      */       return;
/*      */     }
/* 6576 */     int i = Math.max(paramInt1, 0);
/* 6577 */     int j = Math.min(paramArrayOfbyte.length, paramInt2) - 1;
/*      */     
/* 6579 */     while (j > i) {
/* 6580 */       byte b = paramArrayOfbyte[j];
/* 6581 */       paramArrayOfbyte[j] = paramArrayOfbyte[i];
/* 6582 */       paramArrayOfbyte[i] = b;
/* 6583 */       j--;
/* 6584 */       i++;
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
/*      */   public static void reverse(char[] paramArrayOfchar) {
/* 6596 */     if (paramArrayOfchar == null) {
/*      */       return;
/*      */     }
/* 6599 */     reverse(paramArrayOfchar, 0, paramArrayOfchar.length);
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
/*      */   public static void reverse(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 6620 */     if (paramArrayOfchar == null) {
/*      */       return;
/*      */     }
/* 6623 */     int i = Math.max(paramInt1, 0);
/* 6624 */     int j = Math.min(paramArrayOfchar.length, paramInt2) - 1;
/*      */     
/* 6626 */     while (j > i) {
/* 6627 */       char c = paramArrayOfchar[j];
/* 6628 */       paramArrayOfchar[j] = paramArrayOfchar[i];
/* 6629 */       paramArrayOfchar[i] = c;
/* 6630 */       j--;
/* 6631 */       i++;
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
/*      */   public static void reverse(double[] paramArrayOfdouble) {
/* 6643 */     if (paramArrayOfdouble == null) {
/*      */       return;
/*      */     }
/* 6646 */     reverse(paramArrayOfdouble, 0, paramArrayOfdouble.length);
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
/*      */   public static void reverse(double[] paramArrayOfdouble, int paramInt1, int paramInt2) {
/* 6667 */     if (paramArrayOfdouble == null) {
/*      */       return;
/*      */     }
/* 6670 */     int i = Math.max(paramInt1, 0);
/* 6671 */     int j = Math.min(paramArrayOfdouble.length, paramInt2) - 1;
/*      */     
/* 6673 */     while (j > i) {
/* 6674 */       double d = paramArrayOfdouble[j];
/* 6675 */       paramArrayOfdouble[j] = paramArrayOfdouble[i];
/* 6676 */       paramArrayOfdouble[i] = d;
/* 6677 */       j--;
/* 6678 */       i++;
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
/*      */   public static void reverse(float[] paramArrayOffloat) {
/* 6690 */     if (paramArrayOffloat == null) {
/*      */       return;
/*      */     }
/* 6693 */     reverse(paramArrayOffloat, 0, paramArrayOffloat.length);
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
/*      */   public static void reverse(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 6714 */     if (paramArrayOffloat == null) {
/*      */       return;
/*      */     }
/* 6717 */     int i = Math.max(paramInt1, 0);
/* 6718 */     int j = Math.min(paramArrayOffloat.length, paramInt2) - 1;
/*      */     
/* 6720 */     while (j > i) {
/* 6721 */       float f = paramArrayOffloat[j];
/* 6722 */       paramArrayOffloat[j] = paramArrayOffloat[i];
/* 6723 */       paramArrayOffloat[i] = f;
/* 6724 */       j--;
/* 6725 */       i++;
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
/*      */   public static void reverse(int[] paramArrayOfint) {
/* 6737 */     if (paramArrayOfint == null) {
/*      */       return;
/*      */     }
/* 6740 */     reverse(paramArrayOfint, 0, paramArrayOfint.length);
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
/*      */   public static void reverse(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 6761 */     if (paramArrayOfint == null) {
/*      */       return;
/*      */     }
/* 6764 */     int i = Math.max(paramInt1, 0);
/* 6765 */     int j = Math.min(paramArrayOfint.length, paramInt2) - 1;
/*      */     
/* 6767 */     while (j > i) {
/* 6768 */       int k = paramArrayOfint[j];
/* 6769 */       paramArrayOfint[j] = paramArrayOfint[i];
/* 6770 */       paramArrayOfint[i] = k;
/* 6771 */       j--;
/* 6772 */       i++;
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
/*      */   public static void reverse(long[] paramArrayOflong) {
/* 6784 */     if (paramArrayOflong == null) {
/*      */       return;
/*      */     }
/* 6787 */     reverse(paramArrayOflong, 0, paramArrayOflong.length);
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
/*      */   public static void reverse(long[] paramArrayOflong, int paramInt1, int paramInt2) {
/* 6808 */     if (paramArrayOflong == null) {
/*      */       return;
/*      */     }
/* 6811 */     int i = Math.max(paramInt1, 0);
/* 6812 */     int j = Math.min(paramArrayOflong.length, paramInt2) - 1;
/*      */     
/* 6814 */     while (j > i) {
/* 6815 */       long l = paramArrayOflong[j];
/* 6816 */       paramArrayOflong[j] = paramArrayOflong[i];
/* 6817 */       paramArrayOflong[i] = l;
/* 6818 */       j--;
/* 6819 */       i++;
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
/*      */   public static void reverse(Object[] paramArrayOfObject) {
/* 6835 */     if (paramArrayOfObject == null) {
/*      */       return;
/*      */     }
/* 6838 */     reverse(paramArrayOfObject, 0, paramArrayOfObject.length);
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
/*      */   public static void reverse(Object[] paramArrayOfObject, int paramInt1, int paramInt2) {
/* 6859 */     if (paramArrayOfObject == null) {
/*      */       return;
/*      */     }
/* 6862 */     int i = Math.max(paramInt1, 0);
/* 6863 */     int j = Math.min(paramArrayOfObject.length, paramInt2) - 1;
/*      */     
/* 6865 */     while (j > i) {
/* 6866 */       Object object = paramArrayOfObject[j];
/* 6867 */       paramArrayOfObject[j] = paramArrayOfObject[i];
/* 6868 */       paramArrayOfObject[i] = object;
/* 6869 */       j--;
/* 6870 */       i++;
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
/*      */   public static void reverse(short[] paramArrayOfshort) {
/* 6882 */     if (paramArrayOfshort == null) {
/*      */       return;
/*      */     }
/* 6885 */     reverse(paramArrayOfshort, 0, paramArrayOfshort.length);
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
/*      */   public static void reverse(short[] paramArrayOfshort, int paramInt1, int paramInt2) {
/* 6906 */     if (paramArrayOfshort == null) {
/*      */       return;
/*      */     }
/* 6909 */     int i = Math.max(paramInt1, 0);
/* 6910 */     int j = Math.min(paramArrayOfshort.length, paramInt2) - 1;
/*      */     
/* 6912 */     while (j > i) {
/* 6913 */       short s = paramArrayOfshort[j];
/* 6914 */       paramArrayOfshort[j] = paramArrayOfshort[i];
/* 6915 */       paramArrayOfshort[i] = s;
/* 6916 */       j--;
/* 6917 */       i++;
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
/*      */   public static void shift(boolean[] paramArrayOfboolean, int paramInt) {
/* 6934 */     if (paramArrayOfboolean == null) {
/*      */       return;
/*      */     }
/* 6937 */     shift(paramArrayOfboolean, 0, paramArrayOfboolean.length, paramInt);
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
/*      */   public static void shift(boolean[] paramArrayOfboolean, int paramInt1, int paramInt2, int paramInt3) {
/* 6960 */     if (paramArrayOfboolean == null) {
/*      */       return;
/*      */     }
/* 6963 */     if (paramInt1 >= paramArrayOfboolean.length - 1 || paramInt2 <= 0) {
/*      */       return;
/*      */     }
/* 6966 */     if (paramInt1 < 0) {
/* 6967 */       paramInt1 = 0;
/*      */     }
/* 6969 */     if (paramInt2 >= paramArrayOfboolean.length) {
/* 6970 */       paramInt2 = paramArrayOfboolean.length;
/*      */     }
/* 6972 */     int i = paramInt2 - paramInt1;
/* 6973 */     if (i <= 1) {
/*      */       return;
/*      */     }
/* 6976 */     paramInt3 %= i;
/* 6977 */     if (paramInt3 < 0) {
/* 6978 */       paramInt3 += i;
/*      */     }
/*      */ 
/*      */     
/* 6982 */     while (i > 1 && paramInt3 > 0) {
/* 6983 */       int j = i - paramInt3;
/*      */       
/* 6985 */       if (paramInt3 > j) {
/* 6986 */         swap(paramArrayOfboolean, paramInt1, paramInt1 + i - j, j);
/* 6987 */         i = paramInt3;
/* 6988 */         paramInt3 -= j; continue;
/* 6989 */       }  if (paramInt3 < j) {
/* 6990 */         swap(paramArrayOfboolean, paramInt1, paramInt1 + j, paramInt3);
/* 6991 */         paramInt1 += paramInt3;
/* 6992 */         i = j; continue;
/*      */       } 
/* 6994 */       swap(paramArrayOfboolean, paramInt1, paramInt1 + j, paramInt3);
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
/*      */   public static void shift(byte[] paramArrayOfbyte, int paramInt) {
/* 7013 */     if (paramArrayOfbyte == null) {
/*      */       return;
/*      */     }
/* 7016 */     shift(paramArrayOfbyte, 0, paramArrayOfbyte.length, paramInt);
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
/*      */   public static void shift(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
/* 7039 */     if (paramArrayOfbyte == null) {
/*      */       return;
/*      */     }
/* 7042 */     if (paramInt1 >= paramArrayOfbyte.length - 1 || paramInt2 <= 0) {
/*      */       return;
/*      */     }
/* 7045 */     if (paramInt1 < 0) {
/* 7046 */       paramInt1 = 0;
/*      */     }
/* 7048 */     if (paramInt2 >= paramArrayOfbyte.length) {
/* 7049 */       paramInt2 = paramArrayOfbyte.length;
/*      */     }
/* 7051 */     int i = paramInt2 - paramInt1;
/* 7052 */     if (i <= 1) {
/*      */       return;
/*      */     }
/* 7055 */     paramInt3 %= i;
/* 7056 */     if (paramInt3 < 0) {
/* 7057 */       paramInt3 += i;
/*      */     }
/*      */ 
/*      */     
/* 7061 */     while (i > 1 && paramInt3 > 0) {
/* 7062 */       int j = i - paramInt3;
/*      */       
/* 7064 */       if (paramInt3 > j) {
/* 7065 */         swap(paramArrayOfbyte, paramInt1, paramInt1 + i - j, j);
/* 7066 */         i = paramInt3;
/* 7067 */         paramInt3 -= j; continue;
/* 7068 */       }  if (paramInt3 < j) {
/* 7069 */         swap(paramArrayOfbyte, paramInt1, paramInt1 + j, paramInt3);
/* 7070 */         paramInt1 += paramInt3;
/* 7071 */         i = j; continue;
/*      */       } 
/* 7073 */       swap(paramArrayOfbyte, paramInt1, paramInt1 + j, paramInt3);
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
/*      */   public static void shift(char[] paramArrayOfchar, int paramInt) {
/* 7092 */     if (paramArrayOfchar == null) {
/*      */       return;
/*      */     }
/* 7095 */     shift(paramArrayOfchar, 0, paramArrayOfchar.length, paramInt);
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
/*      */   public static void shift(char[] paramArrayOfchar, int paramInt1, int paramInt2, int paramInt3) {
/* 7118 */     if (paramArrayOfchar == null) {
/*      */       return;
/*      */     }
/* 7121 */     if (paramInt1 >= paramArrayOfchar.length - 1 || paramInt2 <= 0) {
/*      */       return;
/*      */     }
/* 7124 */     if (paramInt1 < 0) {
/* 7125 */       paramInt1 = 0;
/*      */     }
/* 7127 */     if (paramInt2 >= paramArrayOfchar.length) {
/* 7128 */       paramInt2 = paramArrayOfchar.length;
/*      */     }
/* 7130 */     int i = paramInt2 - paramInt1;
/* 7131 */     if (i <= 1) {
/*      */       return;
/*      */     }
/* 7134 */     paramInt3 %= i;
/* 7135 */     if (paramInt3 < 0) {
/* 7136 */       paramInt3 += i;
/*      */     }
/*      */ 
/*      */     
/* 7140 */     while (i > 1 && paramInt3 > 0) {
/* 7141 */       int j = i - paramInt3;
/*      */       
/* 7143 */       if (paramInt3 > j) {
/* 7144 */         swap(paramArrayOfchar, paramInt1, paramInt1 + i - j, j);
/* 7145 */         i = paramInt3;
/* 7146 */         paramInt3 -= j; continue;
/* 7147 */       }  if (paramInt3 < j) {
/* 7148 */         swap(paramArrayOfchar, paramInt1, paramInt1 + j, paramInt3);
/* 7149 */         paramInt1 += paramInt3;
/* 7150 */         i = j; continue;
/*      */       } 
/* 7152 */       swap(paramArrayOfchar, paramInt1, paramInt1 + j, paramInt3);
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
/*      */   public static void shift(double[] paramArrayOfdouble, int paramInt) {
/* 7171 */     if (paramArrayOfdouble == null) {
/*      */       return;
/*      */     }
/* 7174 */     shift(paramArrayOfdouble, 0, paramArrayOfdouble.length, paramInt);
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
/*      */   public static void shift(double[] paramArrayOfdouble, int paramInt1, int paramInt2, int paramInt3) {
/* 7197 */     if (paramArrayOfdouble == null) {
/*      */       return;
/*      */     }
/* 7200 */     if (paramInt1 >= paramArrayOfdouble.length - 1 || paramInt2 <= 0) {
/*      */       return;
/*      */     }
/* 7203 */     if (paramInt1 < 0) {
/* 7204 */       paramInt1 = 0;
/*      */     }
/* 7206 */     if (paramInt2 >= paramArrayOfdouble.length) {
/* 7207 */       paramInt2 = paramArrayOfdouble.length;
/*      */     }
/* 7209 */     int i = paramInt2 - paramInt1;
/* 7210 */     if (i <= 1) {
/*      */       return;
/*      */     }
/* 7213 */     paramInt3 %= i;
/* 7214 */     if (paramInt3 < 0) {
/* 7215 */       paramInt3 += i;
/*      */     }
/*      */ 
/*      */     
/* 7219 */     while (i > 1 && paramInt3 > 0) {
/* 7220 */       int j = i - paramInt3;
/*      */       
/* 7222 */       if (paramInt3 > j) {
/* 7223 */         swap(paramArrayOfdouble, paramInt1, paramInt1 + i - j, j);
/* 7224 */         i = paramInt3;
/* 7225 */         paramInt3 -= j; continue;
/* 7226 */       }  if (paramInt3 < j) {
/* 7227 */         swap(paramArrayOfdouble, paramInt1, paramInt1 + j, paramInt3);
/* 7228 */         paramInt1 += paramInt3;
/* 7229 */         i = j; continue;
/*      */       } 
/* 7231 */       swap(paramArrayOfdouble, paramInt1, paramInt1 + j, paramInt3);
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
/*      */   public static void shift(float[] paramArrayOffloat, int paramInt) {
/* 7250 */     if (paramArrayOffloat == null) {
/*      */       return;
/*      */     }
/* 7253 */     shift(paramArrayOffloat, 0, paramArrayOffloat.length, paramInt);
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
/*      */   public static void shift(float[] paramArrayOffloat, int paramInt1, int paramInt2, int paramInt3) {
/* 7276 */     if (paramArrayOffloat == null) {
/*      */       return;
/*      */     }
/* 7279 */     if (paramInt1 >= paramArrayOffloat.length - 1 || paramInt2 <= 0) {
/*      */       return;
/*      */     }
/* 7282 */     if (paramInt1 < 0) {
/* 7283 */       paramInt1 = 0;
/*      */     }
/* 7285 */     if (paramInt2 >= paramArrayOffloat.length) {
/* 7286 */       paramInt2 = paramArrayOffloat.length;
/*      */     }
/* 7288 */     int i = paramInt2 - paramInt1;
/* 7289 */     if (i <= 1) {
/*      */       return;
/*      */     }
/* 7292 */     paramInt3 %= i;
/* 7293 */     if (paramInt3 < 0) {
/* 7294 */       paramInt3 += i;
/*      */     }
/*      */ 
/*      */     
/* 7298 */     while (i > 1 && paramInt3 > 0) {
/* 7299 */       int j = i - paramInt3;
/*      */       
/* 7301 */       if (paramInt3 > j) {
/* 7302 */         swap(paramArrayOffloat, paramInt1, paramInt1 + i - j, j);
/* 7303 */         i = paramInt3;
/* 7304 */         paramInt3 -= j; continue;
/* 7305 */       }  if (paramInt3 < j) {
/* 7306 */         swap(paramArrayOffloat, paramInt1, paramInt1 + j, paramInt3);
/* 7307 */         paramInt1 += paramInt3;
/* 7308 */         i = j; continue;
/*      */       } 
/* 7310 */       swap(paramArrayOffloat, paramInt1, paramInt1 + j, paramInt3);
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
/*      */   public static void shift(int[] paramArrayOfint, int paramInt) {
/* 7329 */     if (paramArrayOfint == null) {
/*      */       return;
/*      */     }
/* 7332 */     shift(paramArrayOfint, 0, paramArrayOfint.length, paramInt);
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
/*      */   public static void shift(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3) {
/* 7355 */     if (paramArrayOfint == null) {
/*      */       return;
/*      */     }
/* 7358 */     if (paramInt1 >= paramArrayOfint.length - 1 || paramInt2 <= 0) {
/*      */       return;
/*      */     }
/* 7361 */     if (paramInt1 < 0) {
/* 7362 */       paramInt1 = 0;
/*      */     }
/* 7364 */     if (paramInt2 >= paramArrayOfint.length) {
/* 7365 */       paramInt2 = paramArrayOfint.length;
/*      */     }
/* 7367 */     int i = paramInt2 - paramInt1;
/* 7368 */     if (i <= 1) {
/*      */       return;
/*      */     }
/* 7371 */     paramInt3 %= i;
/* 7372 */     if (paramInt3 < 0) {
/* 7373 */       paramInt3 += i;
/*      */     }
/*      */ 
/*      */     
/* 7377 */     while (i > 1 && paramInt3 > 0) {
/* 7378 */       int j = i - paramInt3;
/*      */       
/* 7380 */       if (paramInt3 > j) {
/* 7381 */         swap(paramArrayOfint, paramInt1, paramInt1 + i - j, j);
/* 7382 */         i = paramInt3;
/* 7383 */         paramInt3 -= j; continue;
/* 7384 */       }  if (paramInt3 < j) {
/* 7385 */         swap(paramArrayOfint, paramInt1, paramInt1 + j, paramInt3);
/* 7386 */         paramInt1 += paramInt3;
/* 7387 */         i = j; continue;
/*      */       } 
/* 7389 */       swap(paramArrayOfint, paramInt1, paramInt1 + j, paramInt3);
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
/*      */   public static void shift(long[] paramArrayOflong, int paramInt) {
/* 7408 */     if (paramArrayOflong == null) {
/*      */       return;
/*      */     }
/* 7411 */     shift(paramArrayOflong, 0, paramArrayOflong.length, paramInt);
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
/*      */   public static void shift(long[] paramArrayOflong, int paramInt1, int paramInt2, int paramInt3) {
/* 7434 */     if (paramArrayOflong == null) {
/*      */       return;
/*      */     }
/* 7437 */     if (paramInt1 >= paramArrayOflong.length - 1 || paramInt2 <= 0) {
/*      */       return;
/*      */     }
/* 7440 */     if (paramInt1 < 0) {
/* 7441 */       paramInt1 = 0;
/*      */     }
/* 7443 */     if (paramInt2 >= paramArrayOflong.length) {
/* 7444 */       paramInt2 = paramArrayOflong.length;
/*      */     }
/* 7446 */     int i = paramInt2 - paramInt1;
/* 7447 */     if (i <= 1) {
/*      */       return;
/*      */     }
/* 7450 */     paramInt3 %= i;
/* 7451 */     if (paramInt3 < 0) {
/* 7452 */       paramInt3 += i;
/*      */     }
/*      */ 
/*      */     
/* 7456 */     while (i > 1 && paramInt3 > 0) {
/* 7457 */       int j = i - paramInt3;
/*      */       
/* 7459 */       if (paramInt3 > j) {
/* 7460 */         swap(paramArrayOflong, paramInt1, paramInt1 + i - j, j);
/* 7461 */         i = paramInt3;
/* 7462 */         paramInt3 -= j; continue;
/* 7463 */       }  if (paramInt3 < j) {
/* 7464 */         swap(paramArrayOflong, paramInt1, paramInt1 + j, paramInt3);
/* 7465 */         paramInt1 += paramInt3;
/* 7466 */         i = j; continue;
/*      */       } 
/* 7468 */       swap(paramArrayOflong, paramInt1, paramInt1 + j, paramInt3);
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
/*      */   public static void shift(Object[] paramArrayOfObject, int paramInt) {
/* 7489 */     if (paramArrayOfObject == null) {
/*      */       return;
/*      */     }
/* 7492 */     shift(paramArrayOfObject, 0, paramArrayOfObject.length, paramInt);
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
/*      */   public static void shift(Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3) {
/* 7515 */     if (paramArrayOfObject == null) {
/*      */       return;
/*      */     }
/* 7518 */     if (paramInt1 >= paramArrayOfObject.length - 1 || paramInt2 <= 0) {
/*      */       return;
/*      */     }
/* 7521 */     if (paramInt1 < 0) {
/* 7522 */       paramInt1 = 0;
/*      */     }
/* 7524 */     if (paramInt2 >= paramArrayOfObject.length) {
/* 7525 */       paramInt2 = paramArrayOfObject.length;
/*      */     }
/* 7527 */     int i = paramInt2 - paramInt1;
/* 7528 */     if (i <= 1) {
/*      */       return;
/*      */     }
/* 7531 */     paramInt3 %= i;
/* 7532 */     if (paramInt3 < 0) {
/* 7533 */       paramInt3 += i;
/*      */     }
/*      */ 
/*      */     
/* 7537 */     while (i > 1 && paramInt3 > 0) {
/* 7538 */       int j = i - paramInt3;
/*      */       
/* 7540 */       if (paramInt3 > j) {
/* 7541 */         swap(paramArrayOfObject, paramInt1, paramInt1 + i - j, j);
/* 7542 */         i = paramInt3;
/* 7543 */         paramInt3 -= j; continue;
/* 7544 */       }  if (paramInt3 < j) {
/* 7545 */         swap(paramArrayOfObject, paramInt1, paramInt1 + j, paramInt3);
/* 7546 */         paramInt1 += paramInt3;
/* 7547 */         i = j; continue;
/*      */       } 
/* 7549 */       swap(paramArrayOfObject, paramInt1, paramInt1 + j, paramInt3);
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
/*      */   public static void shift(short[] paramArrayOfshort, int paramInt) {
/* 7568 */     if (paramArrayOfshort == null) {
/*      */       return;
/*      */     }
/* 7571 */     shift(paramArrayOfshort, 0, paramArrayOfshort.length, paramInt);
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
/*      */   public static void shift(short[] paramArrayOfshort, int paramInt1, int paramInt2, int paramInt3) {
/* 7594 */     if (paramArrayOfshort == null) {
/*      */       return;
/*      */     }
/* 7597 */     if (paramInt1 >= paramArrayOfshort.length - 1 || paramInt2 <= 0) {
/*      */       return;
/*      */     }
/* 7600 */     if (paramInt1 < 0) {
/* 7601 */       paramInt1 = 0;
/*      */     }
/* 7603 */     if (paramInt2 >= paramArrayOfshort.length) {
/* 7604 */       paramInt2 = paramArrayOfshort.length;
/*      */     }
/* 7606 */     int i = paramInt2 - paramInt1;
/* 7607 */     if (i <= 1) {
/*      */       return;
/*      */     }
/* 7610 */     paramInt3 %= i;
/* 7611 */     if (paramInt3 < 0) {
/* 7612 */       paramInt3 += i;
/*      */     }
/*      */ 
/*      */     
/* 7616 */     while (i > 1 && paramInt3 > 0) {
/* 7617 */       int j = i - paramInt3;
/*      */       
/* 7619 */       if (paramInt3 > j) {
/* 7620 */         swap(paramArrayOfshort, paramInt1, paramInt1 + i - j, j);
/* 7621 */         i = paramInt3;
/* 7622 */         paramInt3 -= j; continue;
/* 7623 */       }  if (paramInt3 < j) {
/* 7624 */         swap(paramArrayOfshort, paramInt1, paramInt1 + j, paramInt3);
/* 7625 */         paramInt1 += paramInt3;
/* 7626 */         i = j; continue;
/*      */       } 
/* 7628 */       swap(paramArrayOfshort, paramInt1, paramInt1 + j, paramInt3);
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
/*      */   public static void shuffle(boolean[] paramArrayOfboolean) {
/* 7642 */     shuffle(paramArrayOfboolean, new Random());
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
/*      */   public static void shuffle(boolean[] paramArrayOfboolean, Random paramRandom) {
/* 7654 */     for (int i = paramArrayOfboolean.length; i > 1; i--) {
/* 7655 */       swap(paramArrayOfboolean, i - 1, paramRandom.nextInt(i), 1);
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
/*      */   public static void shuffle(byte[] paramArrayOfbyte) {
/* 7667 */     shuffle(paramArrayOfbyte, new Random());
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
/*      */   public static void shuffle(byte[] paramArrayOfbyte, Random paramRandom) {
/* 7679 */     for (int i = paramArrayOfbyte.length; i > 1; i--) {
/* 7680 */       swap(paramArrayOfbyte, i - 1, paramRandom.nextInt(i), 1);
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
/*      */   public static void shuffle(char[] paramArrayOfchar) {
/* 7692 */     shuffle(paramArrayOfchar, new Random());
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
/*      */   public static void shuffle(char[] paramArrayOfchar, Random paramRandom) {
/* 7704 */     for (int i = paramArrayOfchar.length; i > 1; i--) {
/* 7705 */       swap(paramArrayOfchar, i - 1, paramRandom.nextInt(i), 1);
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
/*      */   public static void shuffle(double[] paramArrayOfdouble) {
/* 7717 */     shuffle(paramArrayOfdouble, new Random());
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
/*      */   public static void shuffle(double[] paramArrayOfdouble, Random paramRandom) {
/* 7729 */     for (int i = paramArrayOfdouble.length; i > 1; i--) {
/* 7730 */       swap(paramArrayOfdouble, i - 1, paramRandom.nextInt(i), 1);
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
/*      */   public static void shuffle(float[] paramArrayOffloat) {
/* 7742 */     shuffle(paramArrayOffloat, new Random());
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
/*      */   public static void shuffle(float[] paramArrayOffloat, Random paramRandom) {
/* 7754 */     for (int i = paramArrayOffloat.length; i > 1; i--) {
/* 7755 */       swap(paramArrayOffloat, i - 1, paramRandom.nextInt(i), 1);
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
/*      */   public static void shuffle(int[] paramArrayOfint) {
/* 7767 */     shuffle(paramArrayOfint, new Random());
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
/*      */   public static void shuffle(int[] paramArrayOfint, Random paramRandom) {
/* 7779 */     for (int i = paramArrayOfint.length; i > 1; i--) {
/* 7780 */       swap(paramArrayOfint, i - 1, paramRandom.nextInt(i), 1);
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
/*      */   public static void shuffle(long[] paramArrayOflong) {
/* 7792 */     shuffle(paramArrayOflong, new Random());
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
/*      */   public static void shuffle(long[] paramArrayOflong, Random paramRandom) {
/* 7804 */     for (int i = paramArrayOflong.length; i > 1; i--) {
/* 7805 */       swap(paramArrayOflong, i - 1, paramRandom.nextInt(i), 1);
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
/*      */   public static void shuffle(Object[] paramArrayOfObject) {
/* 7817 */     shuffle(paramArrayOfObject, new Random());
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
/*      */   public static void shuffle(Object[] paramArrayOfObject, Random paramRandom) {
/* 7829 */     for (int i = paramArrayOfObject.length; i > 1; i--) {
/* 7830 */       swap(paramArrayOfObject, i - 1, paramRandom.nextInt(i), 1);
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
/*      */   public static void shuffle(short[] paramArrayOfshort) {
/* 7842 */     shuffle(paramArrayOfshort, new Random());
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
/*      */   public static void shuffle(short[] paramArrayOfshort, Random paramRandom) {
/* 7854 */     for (int i = paramArrayOfshort.length; i > 1; i--) {
/* 7855 */       swap(paramArrayOfshort, i - 1, paramRandom.nextInt(i), 1);
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
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean[] subarray(boolean[] paramArrayOfboolean, int paramInt1, int paramInt2) {
/* 7880 */     if (paramArrayOfboolean == null) {
/* 7881 */       return null;
/*      */     }
/* 7883 */     if (paramInt1 < 0) {
/* 7884 */       paramInt1 = 0;
/*      */     }
/* 7886 */     if (paramInt2 > paramArrayOfboolean.length) {
/* 7887 */       paramInt2 = paramArrayOfboolean.length;
/*      */     }
/* 7889 */     int i = paramInt2 - paramInt1;
/* 7890 */     if (i <= 0) {
/* 7891 */       return EMPTY_BOOLEAN_ARRAY;
/*      */     }
/*      */     
/* 7894 */     boolean[] arrayOfBoolean = new boolean[i];
/* 7895 */     System.arraycopy(paramArrayOfboolean, paramInt1, arrayOfBoolean, 0, i);
/* 7896 */     return arrayOfBoolean;
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
/*      */   public static byte[] subarray(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 7920 */     if (paramArrayOfbyte == null) {
/* 7921 */       return null;
/*      */     }
/* 7923 */     if (paramInt1 < 0) {
/* 7924 */       paramInt1 = 0;
/*      */     }
/* 7926 */     if (paramInt2 > paramArrayOfbyte.length) {
/* 7927 */       paramInt2 = paramArrayOfbyte.length;
/*      */     }
/* 7929 */     int i = paramInt2 - paramInt1;
/* 7930 */     if (i <= 0) {
/* 7931 */       return EMPTY_BYTE_ARRAY;
/*      */     }
/*      */     
/* 7934 */     byte[] arrayOfByte = new byte[i];
/* 7935 */     System.arraycopy(paramArrayOfbyte, paramInt1, arrayOfByte, 0, i);
/* 7936 */     return arrayOfByte;
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
/*      */   public static char[] subarray(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 7960 */     if (paramArrayOfchar == null) {
/* 7961 */       return null;
/*      */     }
/* 7963 */     if (paramInt1 < 0) {
/* 7964 */       paramInt1 = 0;
/*      */     }
/* 7966 */     if (paramInt2 > paramArrayOfchar.length) {
/* 7967 */       paramInt2 = paramArrayOfchar.length;
/*      */     }
/* 7969 */     int i = paramInt2 - paramInt1;
/* 7970 */     if (i <= 0) {
/* 7971 */       return EMPTY_CHAR_ARRAY;
/*      */     }
/*      */     
/* 7974 */     char[] arrayOfChar = new char[i];
/* 7975 */     System.arraycopy(paramArrayOfchar, paramInt1, arrayOfChar, 0, i);
/* 7976 */     return arrayOfChar;
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
/*      */   public static double[] subarray(double[] paramArrayOfdouble, int paramInt1, int paramInt2) {
/* 8000 */     if (paramArrayOfdouble == null) {
/* 8001 */       return null;
/*      */     }
/* 8003 */     if (paramInt1 < 0) {
/* 8004 */       paramInt1 = 0;
/*      */     }
/* 8006 */     if (paramInt2 > paramArrayOfdouble.length) {
/* 8007 */       paramInt2 = paramArrayOfdouble.length;
/*      */     }
/* 8009 */     int i = paramInt2 - paramInt1;
/* 8010 */     if (i <= 0) {
/* 8011 */       return EMPTY_DOUBLE_ARRAY;
/*      */     }
/*      */     
/* 8014 */     double[] arrayOfDouble = new double[i];
/* 8015 */     System.arraycopy(paramArrayOfdouble, paramInt1, arrayOfDouble, 0, i);
/* 8016 */     return arrayOfDouble;
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
/*      */   public static float[] subarray(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 8040 */     if (paramArrayOffloat == null) {
/* 8041 */       return null;
/*      */     }
/* 8043 */     if (paramInt1 < 0) {
/* 8044 */       paramInt1 = 0;
/*      */     }
/* 8046 */     if (paramInt2 > paramArrayOffloat.length) {
/* 8047 */       paramInt2 = paramArrayOffloat.length;
/*      */     }
/* 8049 */     int i = paramInt2 - paramInt1;
/* 8050 */     if (i <= 0) {
/* 8051 */       return EMPTY_FLOAT_ARRAY;
/*      */     }
/*      */     
/* 8054 */     float[] arrayOfFloat = new float[i];
/* 8055 */     System.arraycopy(paramArrayOffloat, paramInt1, arrayOfFloat, 0, i);
/* 8056 */     return arrayOfFloat;
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
/*      */   public static int[] subarray(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 8080 */     if (paramArrayOfint == null) {
/* 8081 */       return null;
/*      */     }
/* 8083 */     if (paramInt1 < 0) {
/* 8084 */       paramInt1 = 0;
/*      */     }
/* 8086 */     if (paramInt2 > paramArrayOfint.length) {
/* 8087 */       paramInt2 = paramArrayOfint.length;
/*      */     }
/* 8089 */     int i = paramInt2 - paramInt1;
/* 8090 */     if (i <= 0) {
/* 8091 */       return EMPTY_INT_ARRAY;
/*      */     }
/*      */     
/* 8094 */     int[] arrayOfInt = new int[i];
/* 8095 */     System.arraycopy(paramArrayOfint, paramInt1, arrayOfInt, 0, i);
/* 8096 */     return arrayOfInt;
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
/*      */   public static long[] subarray(long[] paramArrayOflong, int paramInt1, int paramInt2) {
/* 8120 */     if (paramArrayOflong == null) {
/* 8121 */       return null;
/*      */     }
/* 8123 */     if (paramInt1 < 0) {
/* 8124 */       paramInt1 = 0;
/*      */     }
/* 8126 */     if (paramInt2 > paramArrayOflong.length) {
/* 8127 */       paramInt2 = paramArrayOflong.length;
/*      */     }
/* 8129 */     int i = paramInt2 - paramInt1;
/* 8130 */     if (i <= 0) {
/* 8131 */       return EMPTY_LONG_ARRAY;
/*      */     }
/*      */     
/* 8134 */     long[] arrayOfLong = new long[i];
/* 8135 */     System.arraycopy(paramArrayOflong, paramInt1, arrayOfLong, 0, i);
/* 8136 */     return arrayOfLong;
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
/*      */   public static short[] subarray(short[] paramArrayOfshort, int paramInt1, int paramInt2) {
/* 8160 */     if (paramArrayOfshort == null) {
/* 8161 */       return null;
/*      */     }
/* 8163 */     if (paramInt1 < 0) {
/* 8164 */       paramInt1 = 0;
/*      */     }
/* 8166 */     if (paramInt2 > paramArrayOfshort.length) {
/* 8167 */       paramInt2 = paramArrayOfshort.length;
/*      */     }
/* 8169 */     int i = paramInt2 - paramInt1;
/* 8170 */     if (i <= 0) {
/* 8171 */       return EMPTY_SHORT_ARRAY;
/*      */     }
/*      */     
/* 8174 */     short[] arrayOfShort = new short[i];
/* 8175 */     System.arraycopy(paramArrayOfshort, paramInt1, arrayOfShort, 0, i);
/* 8176 */     return arrayOfShort;
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
/*      */   public static <T> T[] subarray(T[] paramArrayOfT, int paramInt1, int paramInt2) {
/* 8211 */     if (paramArrayOfT == null) {
/* 8212 */       return null;
/*      */     }
/* 8214 */     if (paramInt1 < 0) {
/* 8215 */       paramInt1 = 0;
/*      */     }
/* 8217 */     if (paramInt2 > paramArrayOfT.length) {
/* 8218 */       paramInt2 = paramArrayOfT.length;
/*      */     }
/* 8220 */     int i = paramInt2 - paramInt1;
/* 8221 */     Class<?> clazz = paramArrayOfT.getClass().getComponentType();
/* 8222 */     if (i <= 0)
/*      */     {
/* 8224 */       return (T[])Array.newInstance(clazz, 0);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 8229 */     Object[] arrayOfObject = (Object[])Array.newInstance(clazz, i);
/* 8230 */     System.arraycopy(paramArrayOfT, paramInt1, arrayOfObject, 0, i);
/* 8231 */     return (T[])arrayOfObject;
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
/*      */   public static void swap(boolean[] paramArrayOfboolean, int paramInt1, int paramInt2) {
/* 8256 */     if (isEmpty(paramArrayOfboolean)) {
/*      */       return;
/*      */     }
/* 8259 */     swap(paramArrayOfboolean, paramInt1, paramInt2, 1);
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
/*      */   public static void swap(boolean[] paramArrayOfboolean, int paramInt1, int paramInt2, int paramInt3) {
/* 8287 */     if (isEmpty(paramArrayOfboolean) || paramInt1 >= paramArrayOfboolean.length || paramInt2 >= paramArrayOfboolean.length) {
/*      */       return;
/*      */     }
/* 8290 */     if (paramInt1 < 0) {
/* 8291 */       paramInt1 = 0;
/*      */     }
/* 8293 */     if (paramInt2 < 0) {
/* 8294 */       paramInt2 = 0;
/*      */     }
/* 8296 */     paramInt3 = Math.min(Math.min(paramInt3, paramArrayOfboolean.length - paramInt1), paramArrayOfboolean.length - paramInt2);
/* 8297 */     for (byte b = 0; b < paramInt3; b++, paramInt1++, paramInt2++) {
/* 8298 */       boolean bool = paramArrayOfboolean[paramInt1];
/* 8299 */       paramArrayOfboolean[paramInt1] = paramArrayOfboolean[paramInt2];
/* 8300 */       paramArrayOfboolean[paramInt2] = bool;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void swap(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 8327 */     if (isEmpty(paramArrayOfbyte)) {
/*      */       return;
/*      */     }
/* 8330 */     swap(paramArrayOfbyte, paramInt1, paramInt2, 1);
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
/*      */   public static void swap(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
/* 8358 */     if (isEmpty(paramArrayOfbyte) || paramInt1 >= paramArrayOfbyte.length || paramInt2 >= paramArrayOfbyte.length) {
/*      */       return;
/*      */     }
/* 8361 */     if (paramInt1 < 0) {
/* 8362 */       paramInt1 = 0;
/*      */     }
/* 8364 */     if (paramInt2 < 0) {
/* 8365 */       paramInt2 = 0;
/*      */     }
/* 8367 */     paramInt3 = Math.min(Math.min(paramInt3, paramArrayOfbyte.length - paramInt1), paramArrayOfbyte.length - paramInt2);
/* 8368 */     for (byte b = 0; b < paramInt3; b++, paramInt1++, paramInt2++) {
/* 8369 */       byte b1 = paramArrayOfbyte[paramInt1];
/* 8370 */       paramArrayOfbyte[paramInt1] = paramArrayOfbyte[paramInt2];
/* 8371 */       paramArrayOfbyte[paramInt2] = b1;
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void swap(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 8397 */     if (isEmpty(paramArrayOfchar)) {
/*      */       return;
/*      */     }
/* 8400 */     swap(paramArrayOfchar, paramInt1, paramInt2, 1);
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
/*      */   public static void swap(char[] paramArrayOfchar, int paramInt1, int paramInt2, int paramInt3) {
/* 8428 */     if (isEmpty(paramArrayOfchar) || paramInt1 >= paramArrayOfchar.length || paramInt2 >= paramArrayOfchar.length) {
/*      */       return;
/*      */     }
/* 8431 */     if (paramInt1 < 0) {
/* 8432 */       paramInt1 = 0;
/*      */     }
/* 8434 */     if (paramInt2 < 0) {
/* 8435 */       paramInt2 = 0;
/*      */     }
/* 8437 */     paramInt3 = Math.min(Math.min(paramInt3, paramArrayOfchar.length - paramInt1), paramArrayOfchar.length - paramInt2);
/* 8438 */     for (byte b = 0; b < paramInt3; b++, paramInt1++, paramInt2++) {
/* 8439 */       char c = paramArrayOfchar[paramInt1];
/* 8440 */       paramArrayOfchar[paramInt1] = paramArrayOfchar[paramInt2];
/* 8441 */       paramArrayOfchar[paramInt2] = c;
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void swap(double[] paramArrayOfdouble, int paramInt1, int paramInt2) {
/* 8467 */     if (isEmpty(paramArrayOfdouble)) {
/*      */       return;
/*      */     }
/* 8470 */     swap(paramArrayOfdouble, paramInt1, paramInt2, 1);
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
/*      */   public static void swap(double[] paramArrayOfdouble, int paramInt1, int paramInt2, int paramInt3) {
/* 8498 */     if (isEmpty(paramArrayOfdouble) || paramInt1 >= paramArrayOfdouble.length || paramInt2 >= paramArrayOfdouble.length) {
/*      */       return;
/*      */     }
/* 8501 */     if (paramInt1 < 0) {
/* 8502 */       paramInt1 = 0;
/*      */     }
/* 8504 */     if (paramInt2 < 0) {
/* 8505 */       paramInt2 = 0;
/*      */     }
/* 8507 */     paramInt3 = Math.min(Math.min(paramInt3, paramArrayOfdouble.length - paramInt1), paramArrayOfdouble.length - paramInt2);
/* 8508 */     for (byte b = 0; b < paramInt3; b++, paramInt1++, paramInt2++) {
/* 8509 */       double d = paramArrayOfdouble[paramInt1];
/* 8510 */       paramArrayOfdouble[paramInt1] = paramArrayOfdouble[paramInt2];
/* 8511 */       paramArrayOfdouble[paramInt2] = d;
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void swap(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 8537 */     if (isEmpty(paramArrayOffloat)) {
/*      */       return;
/*      */     }
/* 8540 */     swap(paramArrayOffloat, paramInt1, paramInt2, 1);
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
/*      */   public static void swap(float[] paramArrayOffloat, int paramInt1, int paramInt2, int paramInt3) {
/* 8568 */     if (isEmpty(paramArrayOffloat) || paramInt1 >= paramArrayOffloat.length || paramInt2 >= paramArrayOffloat.length) {
/*      */       return;
/*      */     }
/* 8571 */     if (paramInt1 < 0) {
/* 8572 */       paramInt1 = 0;
/*      */     }
/* 8574 */     if (paramInt2 < 0) {
/* 8575 */       paramInt2 = 0;
/*      */     }
/* 8577 */     paramInt3 = Math.min(Math.min(paramInt3, paramArrayOffloat.length - paramInt1), paramArrayOffloat.length - paramInt2);
/* 8578 */     for (byte b = 0; b < paramInt3; b++, paramInt1++, paramInt2++) {
/* 8579 */       float f = paramArrayOffloat[paramInt1];
/* 8580 */       paramArrayOffloat[paramInt1] = paramArrayOffloat[paramInt2];
/* 8581 */       paramArrayOffloat[paramInt2] = f;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void swap(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 8608 */     if (isEmpty(paramArrayOfint)) {
/*      */       return;
/*      */     }
/* 8611 */     swap(paramArrayOfint, paramInt1, paramInt2, 1);
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
/*      */   public static void swap(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3) {
/* 8639 */     if (isEmpty(paramArrayOfint) || paramInt1 >= paramArrayOfint.length || paramInt2 >= paramArrayOfint.length) {
/*      */       return;
/*      */     }
/* 8642 */     if (paramInt1 < 0) {
/* 8643 */       paramInt1 = 0;
/*      */     }
/* 8645 */     if (paramInt2 < 0) {
/* 8646 */       paramInt2 = 0;
/*      */     }
/* 8648 */     paramInt3 = Math.min(Math.min(paramInt3, paramArrayOfint.length - paramInt1), paramArrayOfint.length - paramInt2);
/* 8649 */     for (byte b = 0; b < paramInt3; b++, paramInt1++, paramInt2++) {
/* 8650 */       int i = paramArrayOfint[paramInt1];
/* 8651 */       paramArrayOfint[paramInt1] = paramArrayOfint[paramInt2];
/* 8652 */       paramArrayOfint[paramInt2] = i;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void swap(long[] paramArrayOflong, int paramInt1, int paramInt2) {
/* 8679 */     if (isEmpty(paramArrayOflong)) {
/*      */       return;
/*      */     }
/* 8682 */     swap(paramArrayOflong, paramInt1, paramInt2, 1);
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
/*      */   public static void swap(long[] paramArrayOflong, int paramInt1, int paramInt2, int paramInt3) {
/* 8710 */     if (isEmpty(paramArrayOflong) || paramInt1 >= paramArrayOflong.length || paramInt2 >= paramArrayOflong.length) {
/*      */       return;
/*      */     }
/* 8713 */     if (paramInt1 < 0) {
/* 8714 */       paramInt1 = 0;
/*      */     }
/* 8716 */     if (paramInt2 < 0) {
/* 8717 */       paramInt2 = 0;
/*      */     }
/* 8719 */     paramInt3 = Math.min(Math.min(paramInt3, paramArrayOflong.length - paramInt1), paramArrayOflong.length - paramInt2);
/* 8720 */     for (byte b = 0; b < paramInt3; b++, paramInt1++, paramInt2++) {
/* 8721 */       long l = paramArrayOflong[paramInt1];
/* 8722 */       paramArrayOflong[paramInt1] = paramArrayOflong[paramInt2];
/* 8723 */       paramArrayOflong[paramInt2] = l;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void swap(Object[] paramArrayOfObject, int paramInt1, int paramInt2) {
/* 8751 */     if (isEmpty(paramArrayOfObject)) {
/*      */       return;
/*      */     }
/* 8754 */     swap(paramArrayOfObject, paramInt1, paramInt2, 1);
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
/*      */   public static void swap(Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3) {
/* 8782 */     if (isEmpty(paramArrayOfObject) || paramInt1 >= paramArrayOfObject.length || paramInt2 >= paramArrayOfObject.length) {
/*      */       return;
/*      */     }
/* 8785 */     if (paramInt1 < 0) {
/* 8786 */       paramInt1 = 0;
/*      */     }
/* 8788 */     if (paramInt2 < 0) {
/* 8789 */       paramInt2 = 0;
/*      */     }
/* 8791 */     paramInt3 = Math.min(Math.min(paramInt3, paramArrayOfObject.length - paramInt1), paramArrayOfObject.length - paramInt2);
/* 8792 */     for (byte b = 0; b < paramInt3; b++, paramInt1++, paramInt2++) {
/* 8793 */       Object object = paramArrayOfObject[paramInt1];
/* 8794 */       paramArrayOfObject[paramInt1] = paramArrayOfObject[paramInt2];
/* 8795 */       paramArrayOfObject[paramInt2] = object;
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void swap(short[] paramArrayOfshort, int paramInt1, int paramInt2) {
/* 8821 */     if (isEmpty(paramArrayOfshort)) {
/*      */       return;
/*      */     }
/* 8824 */     swap(paramArrayOfshort, paramInt1, paramInt2, 1);
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
/*      */   public static void swap(short[] paramArrayOfshort, int paramInt1, int paramInt2, int paramInt3) {
/* 8852 */     if (isEmpty(paramArrayOfshort) || paramInt1 >= paramArrayOfshort.length || paramInt2 >= paramArrayOfshort.length) {
/*      */       return;
/*      */     }
/* 8855 */     if (paramInt1 < 0) {
/* 8856 */       paramInt1 = 0;
/*      */     }
/* 8858 */     if (paramInt2 < 0) {
/* 8859 */       paramInt2 = 0;
/*      */     }
/* 8861 */     if (paramInt1 == paramInt2) {
/*      */       return;
/*      */     }
/* 8864 */     paramInt3 = Math.min(Math.min(paramInt3, paramArrayOfshort.length - paramInt1), paramArrayOfshort.length - paramInt2);
/* 8865 */     for (byte b = 0; b < paramInt3; b++, paramInt1++, paramInt2++) {
/* 8866 */       short s = paramArrayOfshort[paramInt1];
/* 8867 */       paramArrayOfshort[paramInt1] = paramArrayOfshort[paramInt2];
/* 8868 */       paramArrayOfshort[paramInt2] = s;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T[] toArray(T... paramVarArgs) {
/* 8912 */     return paramVarArgs;
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
/*      */   public static Map<Object, Object> toMap(Object[] paramArrayOfObject) {
/* 8943 */     if (paramArrayOfObject == null) {
/* 8944 */       return null;
/*      */     }
/* 8946 */     HashMap<Object, Object> hashMap = new HashMap<>((int)(paramArrayOfObject.length * 1.5D));
/* 8947 */     for (byte b = 0; b < paramArrayOfObject.length; b++) {
/* 8948 */       Object object = paramArrayOfObject[b];
/* 8949 */       if (object instanceof Map.Entry) {
/* 8950 */         Map.Entry entry = (Map.Entry)object;
/* 8951 */         hashMap.put(entry.getKey(), entry.getValue());
/* 8952 */       } else if (object instanceof Object[]) {
/* 8953 */         Object[] arrayOfObject = (Object[])object;
/* 8954 */         if (arrayOfObject.length < 2) {
/* 8955 */           throw new IllegalArgumentException("Array element " + b + ", '" + object + "', has a length less than 2");
/*      */         }
/*      */ 
/*      */         
/* 8959 */         hashMap.put(arrayOfObject[0], arrayOfObject[1]);
/*      */       } else {
/* 8961 */         throw new IllegalArgumentException("Array element " + b + ", '" + object + "', is neither of type Map.Entry nor an Array");
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 8966 */     return hashMap;
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
/*      */   public static Boolean[] toObject(boolean[] paramArrayOfboolean) {
/* 8978 */     if (paramArrayOfboolean == null)
/* 8979 */       return null; 
/* 8980 */     if (paramArrayOfboolean.length == 0) {
/* 8981 */       return EMPTY_BOOLEAN_OBJECT_ARRAY;
/*      */     }
/* 8983 */     Boolean[] arrayOfBoolean = new Boolean[paramArrayOfboolean.length];
/* 8984 */     for (byte b = 0; b < paramArrayOfboolean.length; b++) {
/* 8985 */       arrayOfBoolean[b] = paramArrayOfboolean[b] ? Boolean.TRUE : Boolean.FALSE;
/*      */     }
/* 8987 */     return arrayOfBoolean;
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
/*      */   public static Byte[] toObject(byte[] paramArrayOfbyte) {
/* 8999 */     if (paramArrayOfbyte == null)
/* 9000 */       return null; 
/* 9001 */     if (paramArrayOfbyte.length == 0) {
/* 9002 */       return EMPTY_BYTE_OBJECT_ARRAY;
/*      */     }
/* 9004 */     Byte[] arrayOfByte = new Byte[paramArrayOfbyte.length];
/* 9005 */     for (byte b = 0; b < paramArrayOfbyte.length; b++) {
/* 9006 */       arrayOfByte[b] = Byte.valueOf(paramArrayOfbyte[b]);
/*      */     }
/* 9008 */     return arrayOfByte;
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
/*      */   public static Character[] toObject(char[] paramArrayOfchar) {
/* 9020 */     if (paramArrayOfchar == null)
/* 9021 */       return null; 
/* 9022 */     if (paramArrayOfchar.length == 0) {
/* 9023 */       return EMPTY_CHARACTER_OBJECT_ARRAY;
/*      */     }
/* 9025 */     Character[] arrayOfCharacter = new Character[paramArrayOfchar.length];
/* 9026 */     for (byte b = 0; b < paramArrayOfchar.length; b++) {
/* 9027 */       arrayOfCharacter[b] = Character.valueOf(paramArrayOfchar[b]);
/*      */     }
/* 9029 */     return arrayOfCharacter;
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
/*      */   public static Double[] toObject(double[] paramArrayOfdouble) {
/* 9041 */     if (paramArrayOfdouble == null)
/* 9042 */       return null; 
/* 9043 */     if (paramArrayOfdouble.length == 0) {
/* 9044 */       return EMPTY_DOUBLE_OBJECT_ARRAY;
/*      */     }
/* 9046 */     Double[] arrayOfDouble = new Double[paramArrayOfdouble.length];
/* 9047 */     for (byte b = 0; b < paramArrayOfdouble.length; b++) {
/* 9048 */       arrayOfDouble[b] = Double.valueOf(paramArrayOfdouble[b]);
/*      */     }
/* 9050 */     return arrayOfDouble;
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
/*      */   public static Float[] toObject(float[] paramArrayOffloat) {
/* 9062 */     if (paramArrayOffloat == null)
/* 9063 */       return null; 
/* 9064 */     if (paramArrayOffloat.length == 0) {
/* 9065 */       return EMPTY_FLOAT_OBJECT_ARRAY;
/*      */     }
/* 9067 */     Float[] arrayOfFloat = new Float[paramArrayOffloat.length];
/* 9068 */     for (byte b = 0; b < paramArrayOffloat.length; b++) {
/* 9069 */       arrayOfFloat[b] = Float.valueOf(paramArrayOffloat[b]);
/*      */     }
/* 9071 */     return arrayOfFloat;
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
/*      */   public static Integer[] toObject(int[] paramArrayOfint) {
/* 9083 */     if (paramArrayOfint == null)
/* 9084 */       return null; 
/* 9085 */     if (paramArrayOfint.length == 0) {
/* 9086 */       return EMPTY_INTEGER_OBJECT_ARRAY;
/*      */     }
/* 9088 */     Integer[] arrayOfInteger = new Integer[paramArrayOfint.length];
/* 9089 */     for (byte b = 0; b < paramArrayOfint.length; b++) {
/* 9090 */       arrayOfInteger[b] = Integer.valueOf(paramArrayOfint[b]);
/*      */     }
/* 9092 */     return arrayOfInteger;
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
/*      */   public static Long[] toObject(long[] paramArrayOflong) {
/* 9104 */     if (paramArrayOflong == null)
/* 9105 */       return null; 
/* 9106 */     if (paramArrayOflong.length == 0) {
/* 9107 */       return EMPTY_LONG_OBJECT_ARRAY;
/*      */     }
/* 9109 */     Long[] arrayOfLong = new Long[paramArrayOflong.length];
/* 9110 */     for (byte b = 0; b < paramArrayOflong.length; b++) {
/* 9111 */       arrayOfLong[b] = Long.valueOf(paramArrayOflong[b]);
/*      */     }
/* 9113 */     return arrayOfLong;
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
/*      */   public static Short[] toObject(short[] paramArrayOfshort) {
/* 9125 */     if (paramArrayOfshort == null)
/* 9126 */       return null; 
/* 9127 */     if (paramArrayOfshort.length == 0) {
/* 9128 */       return EMPTY_SHORT_OBJECT_ARRAY;
/*      */     }
/* 9130 */     Short[] arrayOfShort = new Short[paramArrayOfshort.length];
/* 9131 */     for (byte b = 0; b < paramArrayOfshort.length; b++) {
/* 9132 */       arrayOfShort[b] = Short.valueOf(paramArrayOfshort[b]);
/*      */     }
/* 9134 */     return arrayOfShort;
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
/*      */   public static boolean[] toPrimitive(Boolean[] paramArrayOfBoolean) {
/* 9149 */     if (paramArrayOfBoolean == null)
/* 9150 */       return null; 
/* 9151 */     if (paramArrayOfBoolean.length == 0) {
/* 9152 */       return EMPTY_BOOLEAN_ARRAY;
/*      */     }
/* 9154 */     boolean[] arrayOfBoolean = new boolean[paramArrayOfBoolean.length];
/* 9155 */     for (byte b = 0; b < paramArrayOfBoolean.length; b++) {
/* 9156 */       arrayOfBoolean[b] = paramArrayOfBoolean[b].booleanValue();
/*      */     }
/* 9158 */     return arrayOfBoolean;
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
/*      */   public static boolean[] toPrimitive(Boolean[] paramArrayOfBoolean, boolean paramBoolean) {
/* 9171 */     if (paramArrayOfBoolean == null)
/* 9172 */       return null; 
/* 9173 */     if (paramArrayOfBoolean.length == 0) {
/* 9174 */       return EMPTY_BOOLEAN_ARRAY;
/*      */     }
/* 9176 */     boolean[] arrayOfBoolean = new boolean[paramArrayOfBoolean.length];
/* 9177 */     for (byte b = 0; b < paramArrayOfBoolean.length; b++) {
/* 9178 */       Boolean bool = paramArrayOfBoolean[b];
/* 9179 */       arrayOfBoolean[b] = (bool == null) ? paramBoolean : bool.booleanValue();
/*      */     } 
/* 9181 */     return arrayOfBoolean;
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
/*      */   public static byte[] toPrimitive(Byte[] paramArrayOfByte) {
/* 9196 */     if (paramArrayOfByte == null)
/* 9197 */       return null; 
/* 9198 */     if (paramArrayOfByte.length == 0) {
/* 9199 */       return EMPTY_BYTE_ARRAY;
/*      */     }
/* 9201 */     byte[] arrayOfByte = new byte[paramArrayOfByte.length];
/* 9202 */     for (byte b = 0; b < paramArrayOfByte.length; b++) {
/* 9203 */       arrayOfByte[b] = paramArrayOfByte[b].byteValue();
/*      */     }
/* 9205 */     return arrayOfByte;
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
/*      */   public static byte[] toPrimitive(Byte[] paramArrayOfByte, byte paramByte) {
/* 9218 */     if (paramArrayOfByte == null)
/* 9219 */       return null; 
/* 9220 */     if (paramArrayOfByte.length == 0) {
/* 9221 */       return EMPTY_BYTE_ARRAY;
/*      */     }
/* 9223 */     byte[] arrayOfByte = new byte[paramArrayOfByte.length];
/* 9224 */     for (byte b = 0; b < paramArrayOfByte.length; b++) {
/* 9225 */       Byte byte_ = paramArrayOfByte[b];
/* 9226 */       arrayOfByte[b] = (byte_ == null) ? paramByte : byte_.byteValue();
/*      */     } 
/* 9228 */     return arrayOfByte;
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
/*      */   public static char[] toPrimitive(Character[] paramArrayOfCharacter) {
/* 9243 */     if (paramArrayOfCharacter == null)
/* 9244 */       return null; 
/* 9245 */     if (paramArrayOfCharacter.length == 0) {
/* 9246 */       return EMPTY_CHAR_ARRAY;
/*      */     }
/* 9248 */     char[] arrayOfChar = new char[paramArrayOfCharacter.length];
/* 9249 */     for (byte b = 0; b < paramArrayOfCharacter.length; b++) {
/* 9250 */       arrayOfChar[b] = paramArrayOfCharacter[b].charValue();
/*      */     }
/* 9252 */     return arrayOfChar;
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
/*      */   public static char[] toPrimitive(Character[] paramArrayOfCharacter, char paramChar) {
/* 9265 */     if (paramArrayOfCharacter == null)
/* 9266 */       return null; 
/* 9267 */     if (paramArrayOfCharacter.length == 0) {
/* 9268 */       return EMPTY_CHAR_ARRAY;
/*      */     }
/* 9270 */     char[] arrayOfChar = new char[paramArrayOfCharacter.length];
/* 9271 */     for (byte b = 0; b < paramArrayOfCharacter.length; b++) {
/* 9272 */       Character character = paramArrayOfCharacter[b];
/* 9273 */       arrayOfChar[b] = (character == null) ? paramChar : character.charValue();
/*      */     } 
/* 9275 */     return arrayOfChar;
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
/*      */   public static double[] toPrimitive(Double[] paramArrayOfDouble) {
/* 9290 */     if (paramArrayOfDouble == null)
/* 9291 */       return null; 
/* 9292 */     if (paramArrayOfDouble.length == 0) {
/* 9293 */       return EMPTY_DOUBLE_ARRAY;
/*      */     }
/* 9295 */     double[] arrayOfDouble = new double[paramArrayOfDouble.length];
/* 9296 */     for (byte b = 0; b < paramArrayOfDouble.length; b++) {
/* 9297 */       arrayOfDouble[b] = paramArrayOfDouble[b].doubleValue();
/*      */     }
/* 9299 */     return arrayOfDouble;
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
/*      */   public static double[] toPrimitive(Double[] paramArrayOfDouble, double paramDouble) {
/* 9312 */     if (paramArrayOfDouble == null)
/* 9313 */       return null; 
/* 9314 */     if (paramArrayOfDouble.length == 0) {
/* 9315 */       return EMPTY_DOUBLE_ARRAY;
/*      */     }
/* 9317 */     double[] arrayOfDouble = new double[paramArrayOfDouble.length];
/* 9318 */     for (byte b = 0; b < paramArrayOfDouble.length; b++) {
/* 9319 */       Double double_ = paramArrayOfDouble[b];
/* 9320 */       arrayOfDouble[b] = (double_ == null) ? paramDouble : double_.doubleValue();
/*      */     } 
/* 9322 */     return arrayOfDouble;
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
/*      */   public static float[] toPrimitive(Float[] paramArrayOfFloat) {
/* 9337 */     if (paramArrayOfFloat == null)
/* 9338 */       return null; 
/* 9339 */     if (paramArrayOfFloat.length == 0) {
/* 9340 */       return EMPTY_FLOAT_ARRAY;
/*      */     }
/* 9342 */     float[] arrayOfFloat = new float[paramArrayOfFloat.length];
/* 9343 */     for (byte b = 0; b < paramArrayOfFloat.length; b++) {
/* 9344 */       arrayOfFloat[b] = paramArrayOfFloat[b].floatValue();
/*      */     }
/* 9346 */     return arrayOfFloat;
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
/*      */   public static float[] toPrimitive(Float[] paramArrayOfFloat, float paramFloat) {
/* 9359 */     if (paramArrayOfFloat == null)
/* 9360 */       return null; 
/* 9361 */     if (paramArrayOfFloat.length == 0) {
/* 9362 */       return EMPTY_FLOAT_ARRAY;
/*      */     }
/* 9364 */     float[] arrayOfFloat = new float[paramArrayOfFloat.length];
/* 9365 */     for (byte b = 0; b < paramArrayOfFloat.length; b++) {
/* 9366 */       Float float_ = paramArrayOfFloat[b];
/* 9367 */       arrayOfFloat[b] = (float_ == null) ? paramFloat : float_.floatValue();
/*      */     } 
/* 9369 */     return arrayOfFloat;
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
/*      */   public static int[] toPrimitive(Integer[] paramArrayOfInteger) {
/* 9384 */     if (paramArrayOfInteger == null)
/* 9385 */       return null; 
/* 9386 */     if (paramArrayOfInteger.length == 0) {
/* 9387 */       return EMPTY_INT_ARRAY;
/*      */     }
/* 9389 */     int[] arrayOfInt = new int[paramArrayOfInteger.length];
/* 9390 */     for (byte b = 0; b < paramArrayOfInteger.length; b++) {
/* 9391 */       arrayOfInt[b] = paramArrayOfInteger[b].intValue();
/*      */     }
/* 9393 */     return arrayOfInt;
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
/*      */   public static int[] toPrimitive(Integer[] paramArrayOfInteger, int paramInt) {
/* 9406 */     if (paramArrayOfInteger == null)
/* 9407 */       return null; 
/* 9408 */     if (paramArrayOfInteger.length == 0) {
/* 9409 */       return EMPTY_INT_ARRAY;
/*      */     }
/* 9411 */     int[] arrayOfInt = new int[paramArrayOfInteger.length];
/* 9412 */     for (byte b = 0; b < paramArrayOfInteger.length; b++) {
/* 9413 */       Integer integer = paramArrayOfInteger[b];
/* 9414 */       arrayOfInt[b] = (integer == null) ? paramInt : integer.intValue();
/*      */     } 
/* 9416 */     return arrayOfInt;
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
/*      */   public static long[] toPrimitive(Long[] paramArrayOfLong) {
/* 9431 */     if (paramArrayOfLong == null)
/* 9432 */       return null; 
/* 9433 */     if (paramArrayOfLong.length == 0) {
/* 9434 */       return EMPTY_LONG_ARRAY;
/*      */     }
/* 9436 */     long[] arrayOfLong = new long[paramArrayOfLong.length];
/* 9437 */     for (byte b = 0; b < paramArrayOfLong.length; b++) {
/* 9438 */       arrayOfLong[b] = paramArrayOfLong[b].longValue();
/*      */     }
/* 9440 */     return arrayOfLong;
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
/*      */   public static long[] toPrimitive(Long[] paramArrayOfLong, long paramLong) {
/* 9453 */     if (paramArrayOfLong == null)
/* 9454 */       return null; 
/* 9455 */     if (paramArrayOfLong.length == 0) {
/* 9456 */       return EMPTY_LONG_ARRAY;
/*      */     }
/* 9458 */     long[] arrayOfLong = new long[paramArrayOfLong.length];
/* 9459 */     for (byte b = 0; b < paramArrayOfLong.length; b++) {
/* 9460 */       Long long_ = paramArrayOfLong[b];
/* 9461 */       arrayOfLong[b] = (long_ == null) ? paramLong : long_.longValue();
/*      */     } 
/* 9463 */     return arrayOfLong;
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
/*      */   public static Object toPrimitive(Object paramObject) {
/* 9476 */     if (paramObject == null) {
/* 9477 */       return null;
/*      */     }
/* 9479 */     Class<?> clazz1 = paramObject.getClass().getComponentType();
/* 9480 */     Class<?> clazz2 = ClassUtils.wrapperToPrimitive(clazz1);
/* 9481 */     if (int.class.equals(clazz2)) {
/* 9482 */       return toPrimitive((Integer[])paramObject);
/*      */     }
/* 9484 */     if (long.class.equals(clazz2)) {
/* 9485 */       return toPrimitive((Long[])paramObject);
/*      */     }
/* 9487 */     if (short.class.equals(clazz2)) {
/* 9488 */       return toPrimitive((Short[])paramObject);
/*      */     }
/* 9490 */     if (double.class.equals(clazz2)) {
/* 9491 */       return toPrimitive((Double[])paramObject);
/*      */     }
/* 9493 */     if (float.class.equals(clazz2)) {
/* 9494 */       return toPrimitive((Float[])paramObject);
/*      */     }
/* 9496 */     return paramObject;
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
/*      */   public static short[] toPrimitive(Short[] paramArrayOfShort) {
/* 9511 */     if (paramArrayOfShort == null)
/* 9512 */       return null; 
/* 9513 */     if (paramArrayOfShort.length == 0) {
/* 9514 */       return EMPTY_SHORT_ARRAY;
/*      */     }
/* 9516 */     short[] arrayOfShort = new short[paramArrayOfShort.length];
/* 9517 */     for (byte b = 0; b < paramArrayOfShort.length; b++) {
/* 9518 */       arrayOfShort[b] = paramArrayOfShort[b].shortValue();
/*      */     }
/* 9520 */     return arrayOfShort;
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
/*      */   public static short[] toPrimitive(Short[] paramArrayOfShort, short paramShort) {
/* 9533 */     if (paramArrayOfShort == null)
/* 9534 */       return null; 
/* 9535 */     if (paramArrayOfShort.length == 0) {
/* 9536 */       return EMPTY_SHORT_ARRAY;
/*      */     }
/* 9538 */     short[] arrayOfShort = new short[paramArrayOfShort.length];
/* 9539 */     for (byte b = 0; b < paramArrayOfShort.length; b++) {
/* 9540 */       Short short_ = paramArrayOfShort[b];
/* 9541 */       arrayOfShort[b] = (short_ == null) ? paramShort : short_.shortValue();
/*      */     } 
/* 9543 */     return arrayOfShort;
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
/*      */   public static String toString(Object paramObject) {
/* 9560 */     return toString(paramObject, "{}");
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
/*      */   public static String toString(Object paramObject, String paramString) {
/* 9576 */     if (paramObject == null) {
/* 9577 */       return paramString;
/*      */     }
/* 9579 */     return (new ToStringBuilder(paramObject, ToStringStyle.SIMPLE_STYLE)).append(paramObject).toString();
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
/*      */   public static String[] toStringArray(Object[] paramArrayOfObject) {
/* 9594 */     if (paramArrayOfObject == null)
/* 9595 */       return null; 
/* 9596 */     if (paramArrayOfObject.length == 0) {
/* 9597 */       return EMPTY_STRING_ARRAY;
/*      */     }
/*      */     
/* 9600 */     String[] arrayOfString = new String[paramArrayOfObject.length];
/* 9601 */     for (byte b = 0; b < paramArrayOfObject.length; b++) {
/* 9602 */       arrayOfString[b] = paramArrayOfObject[b].toString();
/*      */     }
/*      */     
/* 9605 */     return arrayOfString;
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
/*      */   public static String[] toStringArray(Object[] paramArrayOfObject, String paramString) {
/* 9620 */     if (null == paramArrayOfObject)
/* 9621 */       return null; 
/* 9622 */     if (paramArrayOfObject.length == 0) {
/* 9623 */       return EMPTY_STRING_ARRAY;
/*      */     }
/*      */     
/* 9626 */     String[] arrayOfString = new String[paramArrayOfObject.length];
/* 9627 */     for (byte b = 0; b < paramArrayOfObject.length; b++) {
/* 9628 */       Object object = paramArrayOfObject[b];
/* 9629 */       arrayOfString[b] = (object == null) ? paramString : object.toString();
/*      */     } 
/*      */     
/* 9632 */     return arrayOfString;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\ArrayUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */