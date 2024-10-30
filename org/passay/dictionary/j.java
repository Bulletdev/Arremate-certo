/*     */ package org.passay.dictionary;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import java.util.StringTokenizer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class j
/*     */ {
/*     */   protected static final Comparator<Character> m;
/*     */   protected static final Comparator<Character> n;
/*     */   
/*     */   static {
/*  25 */     m = ((paramCharacter1, paramCharacter2) -> {
/*     */         byte b = 0;
/*     */         
/*     */         char c1 = paramCharacter1.charValue();
/*     */         char c2 = paramCharacter2.charValue();
/*     */         if (c1 < c2) {
/*     */           b = -1;
/*     */         } else if (c1 > c2) {
/*     */           b = 1;
/*     */         } 
/*     */         return b;
/*     */       });
/*  37 */     n = ((paramCharacter1, paramCharacter2) -> {
/*     */         byte b = 0;
/*     */         char c1 = Character.toLowerCase(paramCharacter1.charValue());
/*     */         char c2 = Character.toLowerCase(paramCharacter2.charValue());
/*     */         if (c1 < c2) {
/*     */           b = -1;
/*     */         } else if (c1 > c2) {
/*     */           b = 1;
/*     */         } 
/*     */         return b;
/*     */       });
/*     */   }
/*     */ 
/*     */   
/*  51 */   private static final String LINE_SEPARATOR = System.getProperty("line.separator");
/*     */ 
/*     */ 
/*     */   
/*     */   protected final Comparator<Character> comparator;
/*     */ 
/*     */   
/*     */   private i d;
/*     */ 
/*     */ 
/*     */   
/*     */   public j() {
/*  63 */     this(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j(boolean paramBoolean) {
/*  74 */     if (paramBoolean) {
/*  75 */       this.comparator = m;
/*     */     } else {
/*  77 */       this.comparator = n;
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
/*     */   public void bN(String paramString) {
/*  89 */     if (paramString != null) {
/*  90 */       this.d = a(this.d, paramString, 0);
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
/*     */   public void k(String[] paramArrayOfString) {
/* 102 */     if (paramArrayOfString != null) {
/* 103 */       for (String str : paramArrayOfString) {
/* 104 */         bN(str);
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
/*     */   
/*     */   public boolean search(String paramString) {
/* 119 */     return a(this.d, paramString, 0);
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
/*     */   public String[] b(String paramString) {
/*     */     String[] arrayOfString;
/* 140 */     if (this.comparator == n) {
/* 141 */       throw new UnsupportedOperationException("Partial search is not supported for case insensitive ternary trees");
/*     */     }
/*     */ 
/*     */     
/* 145 */     List<String> list = a(this.d, new ArrayList<>(), "", paramString, 0);
/* 146 */     if (list == null) {
/* 147 */       arrayOfString = new String[0];
/*     */     } else {
/* 149 */       arrayOfString = list.<String>toArray(new String[list.size()]);
/*     */     } 
/* 151 */     return arrayOfString;
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
/*     */   public String[] a(String paramString, int paramInt) {
/*     */     String[] arrayOfString;
/* 172 */     if (this.comparator == n) {
/* 173 */       throw new UnsupportedOperationException("Near search is not supported for case insensitive ternary trees");
/*     */     }
/*     */ 
/*     */     
/* 177 */     List<String> list = a(this.d, paramInt, new ArrayList<>(), "", paramString, 0);
/* 178 */     if (list == null) {
/* 179 */       arrayOfString = new String[0];
/*     */     } else {
/* 181 */       arrayOfString = list.<String>toArray(new String[list.size()]);
/*     */     } 
/* 183 */     return arrayOfString;
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
/*     */   public List<String> bC() {
/* 195 */     List<String> list = a(this.d, "", new ArrayList<>());
/* 196 */     return Collections.unmodifiableList(list);
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
/*     */   public void a(Writer paramWriter) throws IOException {
/* 212 */     paramWriter.write(a(this.d, "", 0));
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
/*     */   private i a(i parami, String paramString, int paramInt) {
/* 233 */     if (paramInt < paramString.length()) {
/* 234 */       char c1 = paramString.charAt(paramInt);
/* 235 */       if (parami == null)
/*     */       {
/* 237 */         parami = new i(c1);
/*     */       }
/*     */ 
/*     */       
/* 241 */       char c2 = parami.g();
/* 242 */       int k = this.comparator.compare(Character.valueOf(c1), Character.valueOf(c2));
/* 243 */       if (k < 0) {
/* 244 */         parami.a(a(parami.a(), paramString, paramInt));
/* 245 */       } else if (k == 0) {
/* 246 */         if (paramInt == paramString.length() - 1) {
/* 247 */           parami.aS(true);
/*     */         }
/* 249 */         parami.b(a(parami.b(), paramString, paramInt + 1));
/*     */       } else {
/* 251 */         parami.c(a(parami.c(), paramString, paramInt));
/*     */       } 
/*     */     } 
/* 254 */     return parami;
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
/*     */   private boolean a(i parami, String paramString, int paramInt) {
/* 270 */     boolean bool = false;
/* 271 */     if (parami != null && paramInt < paramString.length()) {
/* 272 */       char c1 = paramString.charAt(paramInt);
/* 273 */       char c2 = parami.g();
/* 274 */       int k = this.comparator.compare(Character.valueOf(c1), Character.valueOf(c2));
/* 275 */       if (k < 0)
/* 276 */         return a(parami.a(), paramString, paramInt); 
/* 277 */       if (k > 0) {
/* 278 */         return a(parami.c(), paramString, paramInt);
/*     */       }
/* 280 */       if (paramInt == paramString.length() - 1) {
/* 281 */         if (parami.gH()) {
/* 282 */           bool = true;
/*     */         }
/*     */       } else {
/* 285 */         return a(parami.b(), paramString, paramInt + 1);
/*     */       } 
/*     */     } 
/*     */     
/* 289 */     return bool;
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
/*     */   private List<String> a(i parami, List<String> paramList, String paramString1, String paramString2, int paramInt) {
/* 314 */     if (parami != null && paramInt < paramString2.length()) {
/* 315 */       char c1 = paramString2.charAt(paramInt);
/* 316 */       char c2 = parami.g();
/* 317 */       int k = this.comparator.compare(Character.valueOf(c1), Character.valueOf(c2));
/* 318 */       if (c1 == '.' || k < 0)
/*     */       {
/* 320 */         paramList = a(parami.a(), paramList, paramString1, paramString2, paramInt);
/*     */       }
/*     */       
/* 323 */       if (c1 == '.' || k == 0) {
/* 324 */         if (paramInt == paramString2.length() - 1) {
/* 325 */           if (parami.gH()) {
/* 326 */             paramList.add(paramString1 + c2);
/*     */           }
/*     */         } else {
/*     */           
/* 330 */           paramList = a(parami.b(), paramList, paramString1 + c2, paramString2, paramInt + 1);
/*     */         } 
/*     */       }
/*     */       
/* 334 */       if (c1 == '.' || k > 0)
/*     */       {
/* 336 */         paramList = a(parami.c(), paramList, paramString1, paramString2, paramInt);
/*     */       }
/*     */     } 
/*     */     
/* 340 */     return paramList;
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
/*     */   private List<String> a(i parami, int paramInt1, List<String> paramList, String paramString1, String paramString2, int paramInt2) {
/* 366 */     if (parami != null && paramInt1 >= 0) {
/*     */       char c;
/*     */       
/* 369 */       if (paramInt2 < paramString2.length()) {
/* 370 */         c = paramString2.charAt(paramInt2);
/*     */       } else {
/* 372 */         c = '￿';
/*     */       } 
/*     */       
/* 375 */       char c1 = parami.g();
/* 376 */       int k = this.comparator.compare(Character.valueOf(c), Character.valueOf(c1));
/*     */       
/* 378 */       if (paramInt1 > 0 || k < 0)
/*     */       {
/* 380 */         paramList = a(parami.a(), paramInt1, paramList, paramString1, paramString2, paramInt2);
/*     */       }
/*     */ 
/*     */       
/* 384 */       String str = paramString1 + c1;
/* 385 */       if (k == 0) {
/*     */         
/* 387 */         if (parami.gH() && paramInt1 >= 0 && str.length() + paramInt1 >= paramString2.length()) {
/* 388 */           paramList.add(str);
/*     */         }
/*     */ 
/*     */         
/* 392 */         paramList = a(parami.b(), paramInt1, paramList, str, paramString2, paramInt2 + 1);
/*     */       }
/*     */       else {
/*     */         
/* 396 */         if (parami.gH() && paramInt1 - 1 >= 0 && str.length() + paramInt1 - 1 >= paramString2.length()) {
/* 397 */           paramList.add(str);
/*     */         }
/*     */ 
/*     */         
/* 401 */         paramList = a(parami.b(), paramInt1 - 1, paramList, str, paramString2, paramInt2 + 1);
/*     */       } 
/*     */ 
/*     */       
/* 405 */       if (paramInt1 > 0 || k > 0)
/*     */       {
/* 407 */         paramList = a(parami.c(), paramInt1, paramList, paramString1, paramString2, paramInt2);
/*     */       }
/*     */     } 
/*     */     
/* 411 */     return paramList;
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
/*     */   private List<String> a(i parami, String paramString, List<String> paramList) {
/* 432 */     if (parami != null) {
/*     */ 
/*     */       
/* 435 */       paramList = a(parami.a(), paramString, paramList);
/*     */ 
/*     */       
/* 438 */       String str = String.valueOf(parami.g());
/* 439 */       if (parami.b() != null)
/*     */       {
/* 441 */         paramList = a(parami.b(), paramString + str, paramList);
/*     */       }
/*     */ 
/*     */       
/* 445 */       if (parami.gH()) {
/* 446 */         paramList.add(paramString + str);
/*     */       }
/*     */ 
/*     */       
/* 450 */       paramList = a(parami.c(), paramString, paramList);
/*     */     } 
/*     */     
/* 453 */     return paramList;
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
/*     */   private String a(i parami, String paramString, int paramInt) {
/* 469 */     StringBuilder stringBuilder = new StringBuilder();
/* 470 */     if (parami != null) {
/* 471 */       stringBuilder.append(a(parami.a(), " <-", paramInt + 1));
/*     */       
/* 473 */       String str = String.valueOf(parami.g());
/* 474 */       StringBuilder stringBuilder1 = new StringBuilder();
/* 475 */       if (parami.b() != null) {
/* 476 */         stringBuilder1.append(a(parami.b(), paramString + str + "--", paramInt + 1));
/*     */       } else {
/* 478 */         int k = (new StringTokenizer(paramString, "--")).countTokens();
/* 479 */         if (k > 0) {
/* 480 */           k--;
/*     */         }
/* 482 */         for (byte b = 1; b < paramInt - k - 1; b++) {
/* 483 */           stringBuilder1.append("   ");
/*     */         }
/* 485 */         stringBuilder1.append(paramString).append(str).append(LINE_SEPARATOR);
/*     */       } 
/* 487 */       stringBuilder.append(stringBuilder1);
/*     */       
/* 489 */       stringBuilder.append(a(parami.c(), " >-", paramInt + 1));
/*     */     } 
/* 491 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\dictionary\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */