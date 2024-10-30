/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
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
/*     */ public class CharSet
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 5947847346149275958L;
/*  47 */   public static final CharSet EMPTY = new CharSet(new String[] { (String)null });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   public static final CharSet ASCII_ALPHA = new CharSet(new String[] { "a-zA-Z" });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  59 */   public static final CharSet ASCII_ALPHA_LOWER = new CharSet(new String[] { "a-z" });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  65 */   public static final CharSet ASCII_ALPHA_UPPER = new CharSet(new String[] { "A-Z" });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   public static final CharSet ASCII_NUMERIC = new CharSet(new String[] { "0-9" });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  78 */   protected static final Map<String, CharSet> COMMON = Collections.synchronizedMap(new HashMap<>());
/*     */   
/*     */   static {
/*  81 */     COMMON.put(null, EMPTY);
/*  82 */     COMMON.put("", EMPTY);
/*  83 */     COMMON.put("a-zA-Z", ASCII_ALPHA);
/*  84 */     COMMON.put("A-Za-z", ASCII_ALPHA);
/*  85 */     COMMON.put("a-z", ASCII_ALPHA_LOWER);
/*  86 */     COMMON.put("A-Z", ASCII_ALPHA_UPPER);
/*  87 */     COMMON.put("0-9", ASCII_NUMERIC);
/*     */   }
/*     */ 
/*     */   
/*  91 */   private final Set<CharRange> set = Collections.synchronizedSet(new HashSet<>());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CharSet getInstance(String... paramVarArgs) {
/* 156 */     if (paramVarArgs == null) {
/* 157 */       return null;
/*     */     }
/* 159 */     if (paramVarArgs.length == 1) {
/* 160 */       CharSet charSet = COMMON.get(paramVarArgs[0]);
/* 161 */       if (charSet != null) {
/* 162 */         return charSet;
/*     */       }
/*     */     } 
/* 165 */     return new CharSet(paramVarArgs);
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
/*     */   protected CharSet(String... paramVarArgs) {
/* 178 */     for (String str : paramVarArgs) {
/* 179 */       add(str);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void add(String paramString) {
/* 190 */     if (paramString == null) {
/*     */       return;
/*     */     }
/*     */     
/* 194 */     int i = paramString.length();
/* 195 */     byte b = 0;
/* 196 */     while (b < i) {
/* 197 */       int j = i - b;
/* 198 */       if (j >= 4 && paramString.charAt(b) == '^' && paramString.charAt(b + 2) == '-') {
/*     */         
/* 200 */         this.set.add(CharRange.isNotIn(paramString.charAt(b + 1), paramString.charAt(b + 3)));
/* 201 */         b += 4; continue;
/* 202 */       }  if (j >= 3 && paramString.charAt(b + 1) == '-') {
/*     */         
/* 204 */         this.set.add(CharRange.isIn(paramString.charAt(b), paramString.charAt(b + 2)));
/* 205 */         b += 3; continue;
/* 206 */       }  if (j >= 2 && paramString.charAt(b) == '^') {
/*     */         
/* 208 */         this.set.add(CharRange.isNot(paramString.charAt(b + 1)));
/* 209 */         b += 2;
/*     */         continue;
/*     */       } 
/* 212 */       this.set.add(CharRange.is(paramString.charAt(b)));
/* 213 */       b++;
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
/*     */   CharRange[] getCharRanges() {
/* 228 */     return this.set.<CharRange>toArray(new CharRange[0]);
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
/*     */   public boolean contains(char paramChar) {
/* 240 */     synchronized (this.set) {
/* 241 */       for (CharRange charRange : this.set) {
/* 242 */         if (charRange.contains(paramChar)) {
/* 243 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/* 247 */     return false;
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
/*     */   public boolean equals(Object paramObject) {
/* 265 */     if (paramObject == this) {
/* 266 */       return true;
/*     */     }
/* 268 */     if (!(paramObject instanceof CharSet)) {
/* 269 */       return false;
/*     */     }
/* 271 */     CharSet charSet = (CharSet)paramObject;
/* 272 */     return this.set.equals(charSet.set);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 283 */     return 89 + this.set.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 293 */     return this.set.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\CharSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */