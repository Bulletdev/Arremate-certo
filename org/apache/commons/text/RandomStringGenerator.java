/*     */ package org.apache.commons.text;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ThreadLocalRandom;
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
/*     */ public final class RandomStringGenerator
/*     */ {
/*     */   private final int minimumCodePoint;
/*     */   private final int maximumCodePoint;
/*     */   private final Set<CharacterPredicate> inclusivePredicates;
/*     */   private final TextRandomProvider random;
/*     */   private final List<Character> characterList;
/*     */   
/*     */   private RandomStringGenerator(int paramInt1, int paramInt2, Set<CharacterPredicate> paramSet, TextRandomProvider paramTextRandomProvider, List<Character> paramList) {
/* 104 */     this.minimumCodePoint = paramInt1;
/* 105 */     this.maximumCodePoint = paramInt2;
/* 106 */     this.inclusivePredicates = paramSet;
/* 107 */     this.random = paramTextRandomProvider;
/* 108 */     this.characterList = paramList;
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
/*     */   private int generateRandomNumber(int paramInt1, int paramInt2) {
/* 122 */     if (this.random != null) {
/* 123 */       return this.random.nextInt(paramInt2 - paramInt1 + 1) + paramInt1;
/*     */     }
/* 125 */     return ThreadLocalRandom.current().nextInt(paramInt1, paramInt2 + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int generateRandomNumber(List<Character> paramList) {
/* 136 */     int i = paramList.size();
/* 137 */     if (this.random != null) {
/* 138 */       return String.valueOf(paramList.get(this.random.nextInt(i))).codePointAt(0);
/*     */     }
/* 140 */     return String.valueOf(paramList.get(ThreadLocalRandom.current().nextInt(0, i))).codePointAt(0);
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
/*     */   public String generate(int paramInt) {
/* 167 */     if (paramInt == 0) {
/* 168 */       return "";
/*     */     }
/* 170 */     Validate.isTrue((paramInt > 0), "Length %d is smaller than zero.", paramInt);
/*     */     
/* 172 */     StringBuilder stringBuilder = new StringBuilder(paramInt);
/* 173 */     long l = paramInt;
/*     */     
/*     */     do {
/*     */       int i;
/* 177 */       if (this.characterList != null && !this.characterList.isEmpty()) {
/* 178 */         i = generateRandomNumber(this.characterList);
/*     */       } else {
/* 180 */         i = generateRandomNumber(this.minimumCodePoint, this.maximumCodePoint);
/*     */       } 
/* 182 */       switch (Character.getType(i)) {
/*     */         case 0:
/*     */         case 18:
/*     */         case 19:
/*     */           break;
/*     */ 
/*     */         
/*     */         default:
/* 190 */           if (this.inclusivePredicates != null) {
/* 191 */             boolean bool = false;
/* 192 */             for (CharacterPredicate characterPredicate : this.inclusivePredicates) {
/* 193 */               if (characterPredicate.test(i)) {
/* 194 */                 bool = true;
/*     */                 break;
/*     */               } 
/*     */             } 
/* 198 */             if (!bool) {
/*     */               break;
/*     */             }
/*     */           } 
/*     */           
/* 203 */           stringBuilder.appendCodePoint(i);
/* 204 */           l--; break;
/*     */       } 
/* 206 */     } while (l != 0L);
/*     */     
/* 208 */     return stringBuilder.toString();
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
/*     */   public String generate(int paramInt1, int paramInt2) {
/* 226 */     Validate.isTrue((paramInt1 >= 0), "Minimum length %d is smaller than zero.", paramInt1);
/* 227 */     Validate.isTrue((paramInt1 <= paramInt2), "Maximum length %d is smaller than minimum length %d.", new Object[] {
/* 228 */           Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
/* 229 */     return generate(generateRandomNumber(paramInt1, paramInt2));
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
/*     */   public static class Builder
/*     */     implements Builder<RandomStringGenerator>
/*     */   {
/*     */     public static final int DEFAULT_MAXIMUM_CODE_POINT = 1114111;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final int DEFAULT_LENGTH = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final int DEFAULT_MINIMUM_CODE_POINT = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 275 */     private int minimumCodePoint = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 280 */     private int maximumCodePoint = 1114111;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Set<CharacterPredicate> inclusivePredicates;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private TextRandomProvider random;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private List<Character> characterList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder withinRange(int param1Int1, int param1Int2) {
/* 317 */       Validate.isTrue((param1Int1 <= param1Int2), "Minimum code point %d is larger than maximum code point %d", new Object[] {
/* 318 */             Integer.valueOf(param1Int1), Integer.valueOf(param1Int2) });
/* 319 */       Validate.isTrue((param1Int1 >= 0), "Minimum code point %d is negative", param1Int1);
/* 320 */       Validate.isTrue((param1Int2 <= 1114111), "Value %d is larger than Character.MAX_CODE_POINT.", param1Int2);
/*     */ 
/*     */       
/* 323 */       this.minimumCodePoint = param1Int1;
/* 324 */       this.maximumCodePoint = param1Int2;
/* 325 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder withinRange(char[]... param1VarArgs) {
/* 347 */       this.characterList = new ArrayList<>();
/* 348 */       for (char[] arrayOfChar : param1VarArgs) {
/* 349 */         Validate.isTrue((arrayOfChar.length == 2), "Each pair must contain minimum and maximum code point", new Object[0]);
/*     */         
/* 351 */         char c1 = arrayOfChar[0];
/* 352 */         char c2 = arrayOfChar[1];
/* 353 */         Validate.isTrue((c1 <= c2), "Minimum code point %d is larger than maximum code point %d", new Object[] {
/* 354 */               Integer.valueOf(c1), Integer.valueOf(c2)
/*     */             });
/* 356 */         for (char c = c1; c <= c2; c++) {
/* 357 */           this.characterList.add(Character.valueOf((char)c));
/*     */         }
/*     */       } 
/* 360 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder filteredBy(CharacterPredicate... param1VarArgs) {
/* 381 */       if (ArrayUtils.isEmpty((Object[])param1VarArgs)) {
/* 382 */         this.inclusivePredicates = null;
/* 383 */         return this;
/*     */       } 
/*     */       
/* 386 */       if (this.inclusivePredicates == null) {
/* 387 */         this.inclusivePredicates = new HashSet<>();
/*     */       } else {
/* 389 */         this.inclusivePredicates.clear();
/*     */       } 
/*     */       
/* 392 */       Collections.addAll(this.inclusivePredicates, param1VarArgs);
/*     */       
/* 394 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder usingRandom(TextRandomProvider param1TextRandomProvider) {
/* 429 */       this.random = param1TextRandomProvider;
/* 430 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder selectFrom(char... param1VarArgs) {
/* 451 */       this.characterList = new ArrayList<>();
/* 452 */       for (char c : param1VarArgs) {
/* 453 */         this.characterList.add(Character.valueOf(c));
/*     */       }
/* 455 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public RandomStringGenerator build() {
/* 464 */       return new RandomStringGenerator(this.minimumCodePoint, this.maximumCodePoint, this.inclusivePredicates, this.random, this.characterList);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\RandomStringGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */