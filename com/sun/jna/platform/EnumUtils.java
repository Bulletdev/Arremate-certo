/*     */ package com.sun.jna.platform;
/*     */ 
/*     */ import com.sun.jna.platform.win32.FlagEnum;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public static final int UNINITIALIZED = -1;
/*     */   
/*     */   public static <E extends Enum<E>> int toInteger(E paramE) {
/*  52 */     Enum[] arrayOfEnum = (Enum[])paramE.getClass().getEnumConstants();
/*     */     
/*  54 */     for (byte b = 0; b < arrayOfEnum.length; b++) {
/*  55 */       if (arrayOfEnum[b] == paramE) {
/*  56 */         return b;
/*     */       }
/*     */     } 
/*     */     
/*  60 */     throw new IllegalArgumentException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E extends Enum<E>> E fromInteger(int paramInt, Class<E> paramClass) {
/*  70 */     if (paramInt == -1) {
/*  71 */       return null;
/*     */     }
/*  73 */     Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
/*  74 */     return (E)arrayOfEnum[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends FlagEnum> Set<T> setFromInteger(int paramInt, Class<T> paramClass) {
/*  84 */     FlagEnum[] arrayOfFlagEnum = (FlagEnum[])paramClass.getEnumConstants();
/*  85 */     HashSet<FlagEnum> hashSet = new HashSet();
/*     */     
/*  87 */     for (FlagEnum flagEnum : arrayOfFlagEnum) {
/*     */       
/*  89 */       if ((paramInt & flagEnum.getFlag()) != 0)
/*     */       {
/*  91 */         hashSet.add(flagEnum);
/*     */       }
/*     */     } 
/*     */     
/*  95 */     return (Set)hashSet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends FlagEnum> int setToInteger(Set<T> paramSet) {
/* 103 */     int i = 0;
/*     */     
/* 105 */     for (FlagEnum flagEnum : paramSet)
/*     */     {
/* 107 */       i |= flagEnum.getFlag();
/*     */     }
/*     */     
/* 110 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\EnumUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */