/*      */ package org.apache.commons.lang3;
/*      */ 
/*      */ import java.util.Iterator;
/*      */ import java.util.Objects;
/*      */ import java.util.regex.Pattern;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Validate
/*      */ {
/*      */   private static final String DEFAULT_NOT_NAN_EX_MESSAGE = "The validated value is not a number";
/*      */   private static final String DEFAULT_FINITE_EX_MESSAGE = "The value is invalid: %f";
/*      */   private static final String DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE = "The value %s is not in the specified exclusive range of %s to %s";
/*      */   private static final String DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE = "The value %s is not in the specified inclusive range of %s to %s";
/*      */   private static final String DEFAULT_MATCHES_PATTERN_EX = "The string %s does not match the pattern %s";
/*      */   private static final String DEFAULT_IS_NULL_EX_MESSAGE = "The validated object is null";
/*      */   private static final String DEFAULT_IS_TRUE_EX_MESSAGE = "The validated expression is false";
/*      */   private static final String DEFAULT_NO_NULL_ELEMENTS_ARRAY_EX_MESSAGE = "The validated array contains null element at index: %d";
/*      */   private static final String DEFAULT_NO_NULL_ELEMENTS_COLLECTION_EX_MESSAGE = "The validated collection contains null element at index: %d";
/*      */   private static final String DEFAULT_NOT_BLANK_EX_MESSAGE = "The validated character sequence is blank";
/*      */   private static final String DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE = "The validated array is empty";
/*      */   private static final String DEFAULT_NOT_EMPTY_CHAR_SEQUENCE_EX_MESSAGE = "The validated character sequence is empty";
/*      */   private static final String DEFAULT_NOT_EMPTY_COLLECTION_EX_MESSAGE = "The validated collection is empty";
/*      */   private static final String DEFAULT_NOT_EMPTY_MAP_EX_MESSAGE = "The validated map is empty";
/*      */   private static final String DEFAULT_VALID_INDEX_ARRAY_EX_MESSAGE = "The validated array index is invalid: %d";
/*      */   private static final String DEFAULT_VALID_INDEX_CHAR_SEQUENCE_EX_MESSAGE = "The validated character sequence index is invalid: %d";
/*      */   private static final String DEFAULT_VALID_INDEX_COLLECTION_EX_MESSAGE = "The validated collection index is invalid: %d";
/*      */   private static final String DEFAULT_VALID_STATE_EX_MESSAGE = "The validated state is false";
/*      */   private static final String DEFAULT_IS_ASSIGNABLE_EX_MESSAGE = "Cannot assign a %s to a %s";
/*      */   private static final String DEFAULT_IS_INSTANCE_OF_EX_MESSAGE = "Expected type: %s, actual: %s";
/*      */   
/*      */   public static void isTrue(boolean paramBoolean, String paramString, long paramLong) {
/*  109 */     if (!paramBoolean) {
/*  110 */       throw new IllegalArgumentException(String.format(paramString, new Object[] { Long.valueOf(paramLong) }));
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
/*      */   public static void isTrue(boolean paramBoolean, String paramString, double paramDouble) {
/*  134 */     if (!paramBoolean) {
/*  135 */       throw new IllegalArgumentException(String.format(paramString, new Object[] { Double.valueOf(paramDouble) }));
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
/*      */   public static void isTrue(boolean paramBoolean, String paramString, Object... paramVarArgs) {
/*  158 */     if (!paramBoolean) {
/*  159 */       throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
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
/*      */   public static void isTrue(boolean paramBoolean) {
/*  183 */     if (!paramBoolean) {
/*  184 */       throw new IllegalArgumentException("The validated expression is false");
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
/*      */   public static <T> T notNull(T paramT) {
/*  207 */     return notNull(paramT, "The validated object is null", new Object[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T notNull(T paramT, String paramString, Object... paramVarArgs) {
/*  225 */     return Objects.requireNonNull(paramT, () -> String.format(paramString, paramArrayOfObject));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T[] notEmpty(T[] paramArrayOfT, String paramString, Object... paramVarArgs) {
/*  248 */     Objects.requireNonNull(paramArrayOfT, () -> String.format(paramString, paramArrayOfObject));
/*  249 */     if (paramArrayOfT.length == 0) {
/*  250 */       throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
/*      */     }
/*  252 */     return paramArrayOfT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T[] notEmpty(T[] paramArrayOfT) {
/*  272 */     return notEmpty(paramArrayOfT, "The validated array is empty", new Object[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends java.util.Collection<?>> T notEmpty(T paramT, String paramString, Object... paramVarArgs) {
/*  295 */     Objects.requireNonNull(paramT, () -> String.format(paramString, paramArrayOfObject));
/*  296 */     if (paramT.isEmpty()) {
/*  297 */       throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
/*      */     }
/*  299 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends java.util.Collection<?>> T notEmpty(T paramT) {
/*  319 */     return notEmpty(paramT, "The validated collection is empty", new Object[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends java.util.Map<?, ?>> T notEmpty(T paramT, String paramString, Object... paramVarArgs) {
/*  342 */     Objects.requireNonNull(paramT, () -> String.format(paramString, paramArrayOfObject));
/*  343 */     if (paramT.isEmpty()) {
/*  344 */       throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
/*      */     }
/*  346 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends java.util.Map<?, ?>> T notEmpty(T paramT) {
/*  366 */     return notEmpty(paramT, "The validated map is empty", new Object[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends CharSequence> T notEmpty(T paramT, String paramString, Object... paramVarArgs) {
/*  389 */     Objects.requireNonNull(paramT, () -> String.format(paramString, paramArrayOfObject));
/*  390 */     if (paramT.length() == 0) {
/*  391 */       throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
/*      */     }
/*  393 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends CharSequence> T notEmpty(T paramT) {
/*  414 */     return notEmpty(paramT, "The validated character sequence is empty", new Object[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends CharSequence> T notBlank(T paramT, String paramString, Object... paramVarArgs) {
/*  440 */     Objects.requireNonNull(paramT, () -> String.format(paramString, paramArrayOfObject));
/*  441 */     if (StringUtils.isBlank((CharSequence)paramT)) {
/*  442 */       throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
/*      */     }
/*  444 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends CharSequence> T notBlank(T paramT) {
/*  467 */     return notBlank(paramT, "The validated character sequence is blank", new Object[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T[] noNullElements(T[] paramArrayOfT, String paramString, Object... paramVarArgs) {
/*  497 */     notNull(paramArrayOfT);
/*  498 */     for (byte b = 0; b < paramArrayOfT.length; b++) {
/*  499 */       if (paramArrayOfT[b] == null) {
/*  500 */         Object[] arrayOfObject = ArrayUtils.add(paramVarArgs, Integer.valueOf(b));
/*  501 */         throw new IllegalArgumentException(String.format(paramString, arrayOfObject));
/*      */       } 
/*      */     } 
/*  504 */     return paramArrayOfT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T[] noNullElements(T[] paramArrayOfT) {
/*  529 */     return noNullElements(paramArrayOfT, "The validated array contains null element at index: %d", new Object[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends Iterable<?>> T noNullElements(T paramT, String paramString, Object... paramVarArgs) {
/*  559 */     notNull(paramT);
/*  560 */     byte b = 0;
/*  561 */     for (Iterator iterator = paramT.iterator(); iterator.hasNext(); b++) {
/*  562 */       if (iterator.next() == null) {
/*  563 */         Object[] arrayOfObject = ArrayUtils.addAll(paramVarArgs, new Object[] { Integer.valueOf(b) });
/*  564 */         throw new IllegalArgumentException(String.format(paramString, arrayOfObject));
/*      */       } 
/*      */     } 
/*  567 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends Iterable<?>> T noNullElements(T paramT) {
/*  592 */     return noNullElements(paramT, "The validated collection contains null element at index: %d", new Object[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T[] validIndex(T[] paramArrayOfT, int paramInt, String paramString, Object... paramVarArgs) {
/*  620 */     notNull(paramArrayOfT);
/*  621 */     if (paramInt < 0 || paramInt >= paramArrayOfT.length) {
/*  622 */       throw new IndexOutOfBoundsException(String.format(paramString, paramVarArgs));
/*      */     }
/*  624 */     return paramArrayOfT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T[] validIndex(T[] paramArrayOfT, int paramInt) {
/*  651 */     return validIndex(paramArrayOfT, paramInt, "The validated array index is invalid: %d", new Object[] { Integer.valueOf(paramInt) });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends java.util.Collection<?>> T validIndex(T paramT, int paramInt, String paramString, Object... paramVarArgs) {
/*  679 */     notNull(paramT);
/*  680 */     if (paramInt < 0 || paramInt >= paramT.size()) {
/*  681 */       throw new IndexOutOfBoundsException(String.format(paramString, paramVarArgs));
/*      */     }
/*  683 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends java.util.Collection<?>> T validIndex(T paramT, int paramInt) {
/*  707 */     return validIndex(paramT, paramInt, "The validated collection index is invalid: %d", new Object[] { Integer.valueOf(paramInt) });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends CharSequence> T validIndex(T paramT, int paramInt, String paramString, Object... paramVarArgs) {
/*  736 */     notNull(paramT);
/*  737 */     if (paramInt < 0 || paramInt >= paramT.length()) {
/*  738 */       throw new IndexOutOfBoundsException(String.format(paramString, paramVarArgs));
/*      */     }
/*  740 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends CharSequence> T validIndex(T paramT, int paramInt) {
/*  768 */     return validIndex(paramT, paramInt, "The validated character sequence index is invalid: %d", new Object[] { Integer.valueOf(paramInt) });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void validState(boolean paramBoolean) {
/*  794 */     if (!paramBoolean) {
/*  795 */       throw new IllegalStateException("The validated state is false");
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
/*      */   public static void validState(boolean paramBoolean, String paramString, Object... paramVarArgs) {
/*  816 */     if (!paramBoolean) {
/*  817 */       throw new IllegalStateException(String.format(paramString, paramVarArgs));
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
/*      */   public static void matchesPattern(CharSequence paramCharSequence, String paramString) {
/*  841 */     if (!Pattern.matches(paramString, paramCharSequence)) {
/*  842 */       throw new IllegalArgumentException(String.format("The string %s does not match the pattern %s", new Object[] { paramCharSequence, paramString }));
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
/*      */   public static void matchesPattern(CharSequence paramCharSequence, String paramString1, String paramString2, Object... paramVarArgs) {
/*  865 */     if (!Pattern.matches(paramString1, paramCharSequence)) {
/*  866 */       throw new IllegalArgumentException(String.format(paramString2, paramVarArgs));
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
/*      */   public static void notNaN(double paramDouble) {
/*  889 */     notNaN(paramDouble, "The validated value is not a number", new Object[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void notNaN(double paramDouble, String paramString, Object... paramVarArgs) {
/*  907 */     if (Double.isNaN(paramDouble)) {
/*  908 */       throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
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
/*      */   public static void finite(double paramDouble) {
/*  930 */     finite(paramDouble, "The value is invalid: %f", new Object[] { Double.valueOf(paramDouble) });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void finite(double paramDouble, String paramString, Object... paramVarArgs) {
/*  948 */     if (Double.isNaN(paramDouble) || Double.isInfinite(paramDouble)) {
/*  949 */       throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
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
/*      */   public static <T> void inclusiveBetween(T paramT1, T paramT2, Comparable<T> paramComparable) {
/*  973 */     if (paramComparable.compareTo(paramT1) < 0 || paramComparable.compareTo(paramT2) > 0) {
/*  974 */       throw new IllegalArgumentException(String.format("The value %s is not in the specified inclusive range of %s to %s", new Object[] { paramComparable, paramT1, paramT2 }));
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
/*      */   public static <T> void inclusiveBetween(T paramT1, T paramT2, Comparable<T> paramComparable, String paramString, Object... paramVarArgs) {
/*  998 */     if (paramComparable.compareTo(paramT1) < 0 || paramComparable.compareTo(paramT2) > 0) {
/*  999 */       throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
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
/*      */   public static void inclusiveBetween(long paramLong1, long paramLong2, long paramLong3) {
/* 1019 */     if (paramLong3 < paramLong1 || paramLong3 > paramLong2) {
/* 1020 */       throw new IllegalArgumentException(String.format("The value %s is not in the specified inclusive range of %s to %s", new Object[] { Long.valueOf(paramLong3), Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
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
/*      */   public static void inclusiveBetween(long paramLong1, long paramLong2, long paramLong3, String paramString) {
/* 1042 */     if (paramLong3 < paramLong1 || paramLong3 > paramLong2) {
/* 1043 */       throw new IllegalArgumentException(paramString);
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
/*      */   public static void inclusiveBetween(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 1063 */     if (paramDouble3 < paramDouble1 || paramDouble3 > paramDouble2) {
/* 1064 */       throw new IllegalArgumentException(String.format("The value %s is not in the specified inclusive range of %s to %s", new Object[] { Double.valueOf(paramDouble3), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) }));
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
/*      */   public static void inclusiveBetween(double paramDouble1, double paramDouble2, double paramDouble3, String paramString) {
/* 1086 */     if (paramDouble3 < paramDouble1 || paramDouble3 > paramDouble2) {
/* 1087 */       throw new IllegalArgumentException(paramString);
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
/*      */   public static <T> void exclusiveBetween(T paramT1, T paramT2, Comparable<T> paramComparable) {
/* 1111 */     if (paramComparable.compareTo(paramT1) <= 0 || paramComparable.compareTo(paramT2) >= 0) {
/* 1112 */       throw new IllegalArgumentException(String.format("The value %s is not in the specified exclusive range of %s to %s", new Object[] { paramComparable, paramT1, paramT2 }));
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
/*      */   public static <T> void exclusiveBetween(T paramT1, T paramT2, Comparable<T> paramComparable, String paramString, Object... paramVarArgs) {
/* 1136 */     if (paramComparable.compareTo(paramT1) <= 0 || paramComparable.compareTo(paramT2) >= 0) {
/* 1137 */       throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
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
/*      */   public static void exclusiveBetween(long paramLong1, long paramLong2, long paramLong3) {
/* 1157 */     if (paramLong3 <= paramLong1 || paramLong3 >= paramLong2) {
/* 1158 */       throw new IllegalArgumentException(String.format("The value %s is not in the specified exclusive range of %s to %s", new Object[] { Long.valueOf(paramLong3), Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
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
/*      */   public static void exclusiveBetween(long paramLong1, long paramLong2, long paramLong3, String paramString) {
/* 1180 */     if (paramLong3 <= paramLong1 || paramLong3 >= paramLong2) {
/* 1181 */       throw new IllegalArgumentException(paramString);
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
/*      */   public static void exclusiveBetween(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 1201 */     if (paramDouble3 <= paramDouble1 || paramDouble3 >= paramDouble2) {
/* 1202 */       throw new IllegalArgumentException(String.format("The value %s is not in the specified exclusive range of %s to %s", new Object[] { Double.valueOf(paramDouble3), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) }));
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
/*      */   public static void exclusiveBetween(double paramDouble1, double paramDouble2, double paramDouble3, String paramString) {
/* 1224 */     if (paramDouble3 <= paramDouble1 || paramDouble3 >= paramDouble2) {
/* 1225 */       throw new IllegalArgumentException(paramString);
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
/*      */   public static void isInstanceOf(Class<?> paramClass, Object paramObject) {
/* 1250 */     if (!paramClass.isInstance(paramObject)) {
/* 1251 */       throw new IllegalArgumentException(String.format("Expected type: %s, actual: %s", new Object[] { paramClass.getName(), (paramObject == null) ? "null" : paramObject
/* 1252 */               .getClass().getName() }));
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
/*      */   public static void isInstanceOf(Class<?> paramClass, Object paramObject, String paramString, Object... paramVarArgs) {
/* 1275 */     if (!paramClass.isInstance(paramObject)) {
/* 1276 */       throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
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
/*      */   public static void isAssignableFrom(Class<?> paramClass1, Class<?> paramClass2) {
/* 1301 */     if (!paramClass1.isAssignableFrom(paramClass2)) {
/* 1302 */       throw new IllegalArgumentException(String.format("Cannot assign a %s to a %s", new Object[] { (paramClass2 == null) ? "null" : paramClass2.getName(), paramClass1
/* 1303 */               .getName() }));
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
/*      */   public static void isAssignableFrom(Class<?> paramClass1, Class<?> paramClass2, String paramString, Object... paramVarArgs) {
/* 1326 */     if (!paramClass1.isAssignableFrom(paramClass2))
/* 1327 */       throw new IllegalArgumentException(String.format(paramString, paramVarArgs)); 
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\Validate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */