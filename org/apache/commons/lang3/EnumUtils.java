/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.EnumSet;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EnumUtils
/*     */ {
/*     */   private static final String NULL_ELEMENTS_NOT_PERMITTED = "null elements not permitted";
/*     */   private static final String CANNOT_STORE_S_S_VALUES_IN_S_BITS = "Cannot store %s %s values in %s bits";
/*     */   private static final String S_DOES_NOT_SEEM_TO_BE_AN_ENUM_TYPE = "%s does not seem to be an Enum type";
/*     */   private static final String ENUM_CLASS_MUST_BE_DEFINED = "EnumClass must be defined.";
/*     */   
/*     */   private static <E extends Enum<E>> Class<E> asEnum(Class<E> paramClass) {
/*  51 */     Validate.notNull(paramClass, "EnumClass must be defined.", new Object[0]);
/*  52 */     Validate.isTrue(paramClass.isEnum(), "%s does not seem to be an Enum type", new Object[] { paramClass });
/*  53 */     return paramClass;
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
/*     */   private static <E extends Enum<E>> Class<E> checkBitVectorable(Class<E> paramClass) {
/*  66 */     Enum[] arrayOfEnum = asEnum(paramClass).getEnumConstants();
/*  67 */     Validate.isTrue((arrayOfEnum.length <= 64), "Cannot store %s %s values in %s bits", new Object[] {
/*  68 */           Integer.valueOf(arrayOfEnum.length), paramClass.getSimpleName(), Integer.valueOf(64)
/*     */         });
/*  70 */     return paramClass;
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
/*     */   @SafeVarargs
/*     */   public static <E extends Enum<E>> long generateBitVector(Class<E> paramClass, E... paramVarArgs) {
/*  92 */     Validate.noNullElements(paramVarArgs);
/*  93 */     return generateBitVector(paramClass, Arrays.asList(paramVarArgs));
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
/*     */   public static <E extends Enum<E>> long generateBitVector(Class<E> paramClass, Iterable<? extends E> paramIterable) {
/* 115 */     checkBitVectorable(paramClass);
/* 116 */     Validate.notNull(paramIterable);
/* 117 */     long l = 0L;
/* 118 */     for (Enum enum_ : paramIterable) {
/* 119 */       Validate.notNull(enum_, "null elements not permitted", new Object[0]);
/* 120 */       l |= 1L << enum_.ordinal();
/*     */     } 
/* 122 */     return l;
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
/*     */   @SafeVarargs
/*     */   public static <E extends Enum<E>> long[] generateBitVectors(Class<E> paramClass, E... paramVarArgs) {
/* 143 */     asEnum(paramClass);
/* 144 */     Validate.noNullElements(paramVarArgs);
/* 145 */     EnumSet<E> enumSet = EnumSet.noneOf(paramClass);
/* 146 */     Collections.addAll(enumSet, paramVarArgs);
/* 147 */     long[] arrayOfLong = new long[(((Enum[])paramClass.getEnumConstants()).length - 1) / 64 + 1];
/* 148 */     for (Enum enum_ : enumSet) {
/* 149 */       arrayOfLong[enum_.ordinal() / 64] = arrayOfLong[enum_.ordinal() / 64] | 1L << enum_.ordinal() % 64;
/*     */     }
/* 151 */     ArrayUtils.reverse(arrayOfLong);
/* 152 */     return arrayOfLong;
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
/*     */   public static <E extends Enum<E>> long[] generateBitVectors(Class<E> paramClass, Iterable<? extends E> paramIterable) {
/* 172 */     asEnum(paramClass);
/* 173 */     Validate.notNull(paramIterable);
/* 174 */     EnumSet<E> enumSet = EnumSet.noneOf(paramClass);
/* 175 */     for (Enum enum_ : paramIterable) {
/* 176 */       Validate.notNull(enum_, "null elements not permitted", new Object[0]);
/* 177 */       enumSet.add((E)enum_);
/*     */     } 
/* 179 */     long[] arrayOfLong = new long[(((Enum[])paramClass.getEnumConstants()).length - 1) / 64 + 1];
/* 180 */     for (Enum enum_ : enumSet) {
/* 181 */       arrayOfLong[enum_.ordinal() / 64] = arrayOfLong[enum_.ordinal() / 64] | 1L << enum_.ordinal() % 64;
/*     */     }
/* 183 */     ArrayUtils.reverse(arrayOfLong);
/* 184 */     return arrayOfLong;
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
/*     */   public static <E extends Enum<E>> E getEnum(Class<E> paramClass, String paramString) {
/* 199 */     return getEnum(paramClass, paramString, null);
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
/*     */   public static <E extends Enum<E>> E getEnum(Class<E> paramClass, String paramString, E paramE) {
/* 216 */     if (paramString == null) {
/* 217 */       return paramE;
/*     */     }
/*     */     try {
/* 220 */       return Enum.valueOf(paramClass, paramString);
/* 221 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 222 */       return paramE;
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
/*     */   public static <E extends Enum<E>> E getEnumIgnoreCase(Class<E> paramClass, String paramString) {
/* 239 */     return getEnumIgnoreCase(paramClass, paramString, null);
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
/*     */   public static <E extends Enum<E>> E getEnumIgnoreCase(Class<E> paramClass, String paramString, E paramE) {
/* 256 */     if (paramString == null || !paramClass.isEnum()) {
/* 257 */       return paramE;
/*     */     }
/* 259 */     for (Enum enum_ : (Enum[])paramClass.getEnumConstants()) {
/* 260 */       if (enum_.name().equalsIgnoreCase(paramString)) {
/* 261 */         return (E)enum_;
/*     */       }
/*     */     } 
/* 264 */     return paramE;
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
/*     */   public static <E extends Enum<E>> List<E> getEnumList(Class<E> paramClass) {
/* 277 */     return new ArrayList<>(Arrays.asList(paramClass.getEnumConstants()));
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
/*     */   public static <E extends Enum<E>> Map<String, E> getEnumMap(Class<E> paramClass) {
/* 290 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/* 291 */     for (Enum enum_ : (Enum[])paramClass.getEnumConstants()) {
/* 292 */       linkedHashMap.put(enum_.name(), enum_);
/*     */     }
/* 294 */     return (Map)linkedHashMap;
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
/*     */   public static <E extends Enum<E>> boolean isValidEnum(Class<E> paramClass, String paramString) {
/* 309 */     return (getEnum(paramClass, paramString) != null);
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
/*     */   public static <E extends Enum<E>> boolean isValidEnumIgnoreCase(Class<E> paramClass, String paramString) {
/* 326 */     return (getEnumIgnoreCase(paramClass, paramString) != null);
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
/*     */   public static <E extends Enum<E>> EnumSet<E> processBitVector(Class<E> paramClass, long paramLong) {
/* 343 */     checkBitVectorable(paramClass).getEnumConstants();
/* 344 */     return processBitVectors(paramClass, new long[] { paramLong });
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
/*     */   public static <E extends Enum<E>> EnumSet<E> processBitVectors(Class<E> paramClass, long... paramVarArgs) {
/* 361 */     EnumSet<Enum> enumSet = EnumSet.noneOf(asEnum(paramClass));
/* 362 */     long[] arrayOfLong = ArrayUtils.clone(Validate.<long[]>notNull(paramVarArgs));
/* 363 */     ArrayUtils.reverse(arrayOfLong);
/* 364 */     for (Enum enum_ : (Enum[])paramClass.getEnumConstants()) {
/* 365 */       int i = enum_.ordinal() / 64;
/* 366 */       if (i < arrayOfLong.length && (arrayOfLong[i] & 1L << enum_.ordinal() % 64) != 0L) {
/* 367 */         enumSet.add(enum_);
/*     */       }
/*     */     } 
/* 370 */     return (EnumSet)enumSet;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\EnumUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */