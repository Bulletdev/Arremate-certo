/*     */ package org.apache.commons.text;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import org.apache.commons.lang3.ArrayUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class AlphabetConverter
/*     */ {
/*     */   private final Map<Integer, String> originalToEncoded;
/*     */   private final Map<String, String> encodedToOriginal;
/*     */   private final int encodedLetterLength;
/*     */   private static final String ARROW = " -> ";
/*     */   
/*     */   private AlphabetConverter(Map<Integer, String> paramMap, Map<String, String> paramMap1, int paramInt) {
/* 106 */     this.originalToEncoded = paramMap;
/* 107 */     this.encodedToOriginal = paramMap1;
/* 108 */     this.encodedLetterLength = paramInt;
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
/*     */   public String encode(String paramString) throws UnsupportedEncodingException {
/* 121 */     if (paramString == null) {
/* 122 */       return null;
/*     */     }
/*     */     
/* 125 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 127 */     for (int i = 0; i < paramString.length(); ) {
/* 128 */       int j = paramString.codePointAt(i);
/*     */       
/* 130 */       String str = this.originalToEncoded.get(Integer.valueOf(j));
/*     */       
/* 132 */       if (str == null) {
/* 133 */         throw new UnsupportedEncodingException("Couldn't find encoding for '" + 
/*     */             
/* 135 */             codePointToString(j) + "' in " + paramString);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 141 */       stringBuilder.append(str);
/*     */       
/* 143 */       i += Character.charCount(j);
/*     */     } 
/*     */     
/* 146 */     return stringBuilder.toString();
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
/*     */   public String decode(String paramString) throws UnsupportedEncodingException {
/* 160 */     if (paramString == null) {
/* 161 */       return null;
/*     */     }
/*     */     
/* 164 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 166 */     for (int i = 0; i < paramString.length(); ) {
/* 167 */       int j = paramString.codePointAt(i);
/* 168 */       String str1 = codePointToString(j);
/*     */       
/* 170 */       if (str1.equals(this.originalToEncoded.get(Integer.valueOf(j)))) {
/* 171 */         stringBuilder.append(str1);
/* 172 */         i++;
/*     */         continue;
/*     */       } 
/* 175 */       if (i + this.encodedLetterLength > paramString.length()) {
/* 176 */         throw new UnsupportedEncodingException("Unexpected end of string while decoding " + paramString);
/*     */       }
/*     */       
/* 179 */       String str2 = paramString.substring(i, i + this.encodedLetterLength);
/*     */       
/* 181 */       String str3 = this.encodedToOriginal.get(str2);
/* 182 */       if (str3 == null) {
/* 183 */         throw new UnsupportedEncodingException("Unexpected string without decoding (" + str2 + ") in " + paramString);
/*     */       }
/*     */ 
/*     */       
/* 187 */       stringBuilder.append(str3);
/* 188 */       i += this.encodedLetterLength;
/*     */     } 
/*     */ 
/*     */     
/* 192 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getEncodedCharLength() {
/* 203 */     return this.encodedLetterLength;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<Integer, String> getOriginalToEncoded() {
/* 214 */     return Collections.unmodifiableMap(this.originalToEncoded);
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
/*     */   private void addSingleEncoding(int paramInt, String paramString, Collection<Integer> paramCollection, Iterator<Integer> paramIterator, Map<Integer, String> paramMap) {
/* 233 */     if (paramInt > 0) {
/* 234 */       for (Iterator<Integer> iterator = paramCollection.iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/* 235 */         if (paramIterator.hasNext()) {
/*     */ 
/*     */ 
/*     */           
/* 239 */           if (paramInt != this.encodedLetterLength || 
/* 240 */             !paramMap.containsKey(Integer.valueOf(i))) {
/* 241 */             addSingleEncoding(paramInt - 1, paramString + 
/*     */                 
/* 243 */                 codePointToString(i), paramCollection, paramIterator, paramMap);
/*     */           }
/*     */ 
/*     */           
/*     */           continue;
/*     */         } 
/*     */ 
/*     */         
/*     */         return; }
/*     */     
/*     */     } else {
/* 254 */       Integer integer = paramIterator.next();
/*     */       
/* 256 */       while (paramMap.containsKey(integer)) {
/* 257 */         String str1 = codePointToString(integer.intValue());
/*     */         
/* 259 */         this.originalToEncoded.put(integer, str1);
/* 260 */         this.encodedToOriginal.put(str1, str1);
/*     */ 
/*     */         
/* 263 */         if (!paramIterator.hasNext()) {
/*     */           return;
/*     */         }
/*     */         
/* 267 */         integer = paramIterator.next();
/*     */       } 
/*     */       
/* 270 */       String str = codePointToString(integer.intValue());
/*     */       
/* 272 */       this.originalToEncoded.put(integer, paramString);
/* 273 */       this.encodedToOriginal.put(paramString, str);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 279 */     StringBuilder stringBuilder = new StringBuilder();
/*     */ 
/*     */     
/* 282 */     for (Map.Entry<Integer, String> entry : this.originalToEncoded.entrySet()) {
/* 283 */       stringBuilder.append(codePointToString(((Integer)entry.getKey()).intValue()))
/* 284 */         .append(" -> ")
/* 285 */         .append((String)entry.getValue()).append(System.lineSeparator());
/*     */     }
/*     */     
/* 288 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 293 */     if (paramObject == null) {
/* 294 */       return false;
/*     */     }
/* 296 */     if (paramObject == this) {
/* 297 */       return true;
/*     */     }
/* 299 */     if (!(paramObject instanceof AlphabetConverter)) {
/* 300 */       return false;
/*     */     }
/* 302 */     AlphabetConverter alphabetConverter = (AlphabetConverter)paramObject;
/* 303 */     return (this.originalToEncoded.equals(alphabetConverter.originalToEncoded) && this.encodedToOriginal
/* 304 */       .equals(alphabetConverter.encodedToOriginal) && this.encodedLetterLength == alphabetConverter.encodedLetterLength);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 310 */     return Objects.hash(new Object[] { this.originalToEncoded, this.encodedToOriginal, 
/*     */           
/* 312 */           Integer.valueOf(this.encodedLetterLength) });
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
/*     */   public static AlphabetConverter createConverterFromMap(Map<Integer, String> paramMap) {
/* 327 */     Map<Integer, String> map = Collections.unmodifiableMap(paramMap);
/* 328 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/*     */     
/* 330 */     int i = 1;
/*     */ 
/*     */     
/* 333 */     for (Map.Entry<Integer, String> entry : map.entrySet()) {
/* 334 */       String str = codePointToString(((Integer)entry.getKey()).intValue());
/* 335 */       linkedHashMap.put(entry.getValue(), str);
/*     */       
/* 337 */       if (((String)entry.getValue()).length() > i) {
/* 338 */         i = ((String)entry.getValue()).length();
/*     */       }
/*     */     } 
/*     */     
/* 342 */     return new AlphabetConverter(map, (Map)linkedHashMap, i);
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
/*     */   public static AlphabetConverter createConverterFromChars(Character[] paramArrayOfCharacter1, Character[] paramArrayOfCharacter2, Character[] paramArrayOfCharacter3) {
/* 368 */     return createConverter(
/* 369 */         convertCharsToIntegers(paramArrayOfCharacter1), 
/* 370 */         convertCharsToIntegers(paramArrayOfCharacter2), 
/* 371 */         convertCharsToIntegers(paramArrayOfCharacter3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Integer[] convertCharsToIntegers(Character[] paramArrayOfCharacter) {
/* 381 */     if (ArrayUtils.isEmpty((Object[])paramArrayOfCharacter)) {
/* 382 */       return ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY;
/*     */     }
/* 384 */     Integer[] arrayOfInteger = new Integer[paramArrayOfCharacter.length];
/* 385 */     for (byte b = 0; b < paramArrayOfCharacter.length; b++) {
/* 386 */       arrayOfInteger[b] = Integer.valueOf(paramArrayOfCharacter[b].charValue());
/*     */     }
/* 388 */     return arrayOfInteger;
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
/*     */   public static AlphabetConverter createConverter(Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2, Integer[] paramArrayOfInteger3) {
/* 413 */     LinkedHashSet<Integer> linkedHashSet1 = new LinkedHashSet(Arrays.asList((Object[])paramArrayOfInteger1));
/* 414 */     LinkedHashSet<Integer> linkedHashSet2 = new LinkedHashSet(Arrays.asList((Object[])paramArrayOfInteger2));
/* 415 */     LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList((Object[])paramArrayOfInteger3));
/*     */     
/* 417 */     LinkedHashMap<Object, Object> linkedHashMap1 = new LinkedHashMap<>();
/* 418 */     LinkedHashMap<Object, Object> linkedHashMap2 = new LinkedHashMap<>();
/* 419 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/*     */     Iterator<Integer> iterator;
/*     */     
/* 423 */     for (iterator = linkedHashSet.iterator(); iterator.hasNext(); ) { int k = ((Integer)iterator.next()).intValue();
/* 424 */       if (!linkedHashSet1.contains(Integer.valueOf(k))) {
/* 425 */         throw new IllegalArgumentException("Can not use 'do not encode' list because original alphabet does not contain '" + 
/*     */ 
/*     */             
/* 428 */             codePointToString(k) + "'");
/*     */       }
/*     */       
/* 431 */       if (!linkedHashSet2.contains(Integer.valueOf(k))) {
/* 432 */         throw new IllegalArgumentException("Can not use 'do not encode' list because encoding alphabet does not contain '" + 
/*     */             
/* 434 */             codePointToString(k) + "'");
/*     */       }
/*     */       
/* 437 */       hashMap.put(Integer.valueOf(k), codePointToString(k)); }
/*     */ 
/*     */     
/* 440 */     if (linkedHashSet2.size() >= linkedHashSet1.size()) {
/* 441 */       boolean bool = true;
/*     */       
/* 443 */       iterator = linkedHashSet2.iterator();
/*     */       
/* 445 */       for (Iterator<Integer> iterator1 = linkedHashSet1.iterator(); iterator1.hasNext(); ) { int k = ((Integer)iterator1.next()).intValue();
/*     */         
/* 447 */         String str1 = codePointToString(k);
/*     */         
/* 449 */         if (hashMap.containsKey(Integer.valueOf(k))) {
/* 450 */           linkedHashMap1.put(Integer.valueOf(k), str1);
/*     */           
/* 452 */           linkedHashMap2.put(str1, str1);
/*     */           continue;
/*     */         } 
/* 455 */         Integer integer = iterator.next();
/*     */         
/* 457 */         while (linkedHashSet.contains(integer)) {
/* 458 */           integer = iterator.next();
/*     */         }
/*     */         
/* 461 */         String str2 = codePointToString(integer.intValue());
/*     */         
/* 463 */         linkedHashMap1.put(Integer.valueOf(k), str2);
/* 464 */         linkedHashMap2.put(str2, str1); }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 469 */       return new AlphabetConverter((Map)linkedHashMap1, (Map)linkedHashMap2, bool);
/*     */     } 
/*     */ 
/*     */     
/* 473 */     if (linkedHashSet2.size() - linkedHashSet.size() < 2) {
/* 474 */       throw new IllegalArgumentException("Must have at least two encoding characters (excluding those in the 'do not encode' list), but has " + (linkedHashSet2
/*     */ 
/*     */           
/* 477 */           .size() - linkedHashSet.size()));
/*     */     }
/*     */ 
/*     */     
/* 481 */     byte b = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 486 */     int j = (linkedHashSet1.size() - linkedHashSet.size()) / (linkedHashSet2.size() - linkedHashSet.size());
/*     */     
/* 488 */     while (j / linkedHashSet2.size() >= 1) {
/* 489 */       j /= linkedHashSet2.size();
/* 490 */       b++;
/*     */     } 
/*     */     
/* 493 */     int i = b + 1;
/*     */     
/* 495 */     AlphabetConverter alphabetConverter = new AlphabetConverter((Map)linkedHashMap1, (Map)linkedHashMap2, i);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 500 */     alphabetConverter.addSingleEncoding(i, "", linkedHashSet2, linkedHashSet1
/*     */ 
/*     */         
/* 503 */         .iterator(), (Map)hashMap);
/*     */ 
/*     */     
/* 506 */     return alphabetConverter;
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
/*     */   private static String codePointToString(int paramInt) {
/* 518 */     if (Character.charCount(paramInt) == 1) {
/* 519 */       return String.valueOf((char)paramInt);
/*     */     }
/* 521 */     return new String(Character.toChars(paramInt));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\AlphabetConverter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */