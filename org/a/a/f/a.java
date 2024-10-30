/*     */ package org.a.a.f;
/*     */ 
/*     */ import java.text.ChoiceFormat;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.DecimalFormatSymbols;
/*     */ import java.text.MessageFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.IllegalFormatException;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import org.a.a.f.a.a;
/*     */ import org.a.a.f.a.b;
/*     */ import org.a.a.f.a.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */ {
/*     */   public static void bh(String paramString) throws IllegalFormatException {
/*  31 */     MessageFormat.format(paramString, (Object[])null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static b[] a(String paramString) throws IllegalFormatException {
/*  42 */     bh(paramString);
/*  43 */     a[] arrayOfA = b.a(paramString);
/*     */     
/*  45 */     int i = -1;
/*  46 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/*  48 */     for (a a1 : arrayOfA) {
/*  49 */       int j = a1.index;
/*  50 */       hashMap.put(
/*  51 */           Integer.valueOf(j), 
/*  52 */           b.a(a1.a, 
/*     */             
/*  54 */             hashMap.containsKey(Integer.valueOf(j)) ? 
/*  55 */             (b)hashMap.get(Integer.valueOf(j)) : 
/*  56 */             b.b));
/*  57 */       i = Math.max(i, j);
/*     */     } 
/*     */     
/*  60 */     b[] arrayOfB = new b[i + 1];
/*  61 */     for (byte b = 0; b <= i; b++) {
/*  62 */       arrayOfB[b] = hashMap.containsKey(Integer.valueOf(b)) ? (b)hashMap.get(Integer.valueOf(b)) : b.b;
/*     */     }
/*  64 */     return arrayOfB;
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
/*     */   @a
/*     */   public static boolean a(String paramString, b... paramVarArgs) {
/*  78 */     b[] arrayOfB = a(paramString);
/*  79 */     if (arrayOfB.length != paramVarArgs.length) {
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     for (byte b1 = 0; b1 < paramVarArgs.length; b1++) {
/*  84 */       if (!b.a(paramVarArgs[b1], arrayOfB[b1])) {
/*  85 */         return false;
/*     */       }
/*     */     } 
/*  88 */     return true;
/*     */   }
/*     */   
/*     */   @i
/*     */   public static boolean F(String paramString) {
/*     */     try {
/*  94 */       a(paramString);
/*  95 */     } catch (Exception exception) {
/*  96 */       return false;
/*     */     } 
/*  98 */     return true;
/*     */   }
/*     */   
/*     */   private static class a {
/*     */     public int index;
/*     */     public b a;
/*     */     
/*     */     public a(int param1Int, b param1b) {
/* 106 */       this.index = param1Int;
/* 107 */       this.a = param1b;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 112 */       return this.a.toString() + "(index: " + this.index + ")";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class b
/*     */   {
/*     */     public static int ib;
/*     */     
/*     */     private static Locale locale;
/*     */     
/*     */     private static List<b> af;
/*     */     
/*     */     private static List<Integer> ag;
/*     */     
/*     */     private static int ic;
/*     */     
/*     */     private static final int ie = 0;
/*     */     
/*     */     private static final int if = 1;
/*     */     
/*     */     private static final int ig = 2;
/*     */     
/*     */     private static final int ih = 3;
/*     */     
/*     */     private static final int TYPE_NULL = 0;
/*     */     
/*     */     private static final int TYPE_NUMBER = 1;
/*     */     
/*     */     private static final int TYPE_DATE = 2;
/*     */     
/*     */     private static final int ii = 3;
/*     */     
/*     */     private static final int ij = 4;
/*     */     
/* 148 */     private static final String[] g = new String[] { "", "number", "date", "time", "choice" };
/*     */     
/*     */     private static final int ik = 0;
/*     */     
/*     */     private static final int il = 1;
/*     */     
/*     */     private static final int im = 2;
/*     */     private static final int in = 3;
/* 156 */     private static final String[] h = new String[] { "", "currency", "percent", "integer" };
/*     */ 
/*     */ 
/*     */     
/* 160 */     private static final String[] i = new String[] { "", "short", "medium", "long", "full" };
/*     */ 
/*     */ 
/*     */     
/*     */     public static a.a[] a(String param1String) {
/* 165 */       af = new ArrayList<>();
/* 166 */       ag = new ArrayList<>();
/* 167 */       locale = Locale.getDefault(Locale.Category.FORMAT);
/* 168 */       applyPattern(param1String);
/*     */       
/* 170 */       a.a[] arrayOfA = new a.a[ic];
/* 171 */       for (byte b1 = 0; b1 < ic; b1++) {
/* 172 */         arrayOfA[b1] = new a.a(((Integer)ag.get(b1)).intValue(), af.get(b1));
/*     */       }
/* 174 */       return arrayOfA;
/*     */     }
/*     */     
/*     */     private static void applyPattern(String param1String) {
/* 178 */       StringBuilder[] arrayOfStringBuilder = new StringBuilder[4];
/*     */ 
/*     */       
/* 181 */       arrayOfStringBuilder[0] = new StringBuilder();
/*     */       
/* 183 */       byte b1 = 0;
/* 184 */       ic = 0;
/* 185 */       boolean bool = false;
/* 186 */       byte b2 = 0;
/* 187 */       ib = -1;
/* 188 */       for (byte b3 = 0; b3 < param1String.length(); b3++) {
/* 189 */         char c = param1String.charAt(b3);
/* 190 */         if (!b1) {
/* 191 */           if (c == '\'') {
/* 192 */             if (b3 + 1 < param1String.length() && param1String.charAt(b3 + 1) == '\'') {
/* 193 */               arrayOfStringBuilder[b1].append(c);
/* 194 */               b3++;
/*     */             } else {
/* 196 */               bool = !bool ? true : false;
/*     */             } 
/* 198 */           } else if (c == '{' && !bool) {
/* 199 */             b1 = 1;
/* 200 */             if (arrayOfStringBuilder[1] == null) {
/* 201 */               arrayOfStringBuilder[1] = new StringBuilder();
/*     */             }
/*     */           } else {
/* 204 */             arrayOfStringBuilder[b1].append(c);
/*     */           }
/*     */         
/* 207 */         } else if (bool) {
/* 208 */           arrayOfStringBuilder[b1].append(c);
/* 209 */           if (c == '\'') {
/* 210 */             bool = false;
/*     */           }
/*     */         } else {
/* 213 */           switch (c) {
/*     */             case ',':
/* 215 */               if (b1 < 3) {
/* 216 */                 if (arrayOfStringBuilder[++b1] == null)
/* 217 */                   arrayOfStringBuilder[b1] = new StringBuilder(); 
/*     */                 break;
/*     */               } 
/* 220 */               arrayOfStringBuilder[b1].append(c);
/*     */               break;
/*     */             
/*     */             case '{':
/* 224 */               b2++;
/* 225 */               arrayOfStringBuilder[b1].append(c);
/*     */               break;
/*     */             case '}':
/* 228 */               if (b2 == 0) {
/* 229 */                 b1 = 0;
/* 230 */                 a(ic, arrayOfStringBuilder);
/* 231 */                 ic++;
/*     */                 
/* 233 */                 arrayOfStringBuilder[1] = null;
/* 234 */                 arrayOfStringBuilder[2] = null;
/* 235 */                 arrayOfStringBuilder[3] = null; break;
/*     */               } 
/* 237 */               b2--;
/* 238 */               arrayOfStringBuilder[b1].append(c);
/*     */               break;
/*     */ 
/*     */             
/*     */             case ' ':
/* 243 */               if (b1 != 2 || arrayOfStringBuilder[2].length() > 0) {
/* 244 */                 arrayOfStringBuilder[b1].append(c);
/*     */               }
/*     */               break;
/*     */             case '\'':
/* 248 */               bool = true;
/* 249 */               arrayOfStringBuilder[b1].append(c);
/*     */               break;
/*     */             default:
/* 252 */               arrayOfStringBuilder[b1].append(c);
/*     */               break;
/*     */           } 
/*     */         
/*     */         } 
/*     */       } 
/* 258 */       if (b2 == 0 && b1 != 0) {
/* 259 */         ib = -1;
/* 260 */         throw new IllegalArgumentException("Unmatched braces in the pattern");
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private static void a(int param1Int, StringBuilder[] param1ArrayOfStringBuilder) {
/* 266 */       String[] arrayOfString = new String[param1ArrayOfStringBuilder.length]; int i;
/* 267 */       for (i = 0; i < param1ArrayOfStringBuilder.length; i++) {
/* 268 */         StringBuilder stringBuilder = param1ArrayOfStringBuilder[i];
/* 269 */         arrayOfString[i] = (stringBuilder != null) ? stringBuilder.toString() : "";
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 275 */         i = Integer.parseInt(arrayOfString[1]);
/*     */       }
/* 277 */       catch (NumberFormatException numberFormatException) {
/* 278 */         throw new IllegalArgumentException("can't parse argument number: " + arrayOfString[1], numberFormatException);
/*     */       } 
/*     */       
/* 281 */       if (i < 0) {
/* 282 */         throw new IllegalArgumentException("negative argument number: " + i);
/*     */       }
/*     */       
/* 285 */       int j = ib;
/* 286 */       ib = param1Int;
/* 287 */       ag.add(Integer.valueOf(i));
/*     */ 
/*     */       
/* 290 */       b b1 = null;
/* 291 */       if (arrayOfString[2].length() != 0) {
/* 292 */         int m, k = a(arrayOfString[2], g);
/* 293 */         switch (k) {
/*     */           case 0:
/* 295 */             b1 = b.c;
/*     */             break;
/*     */           case 1:
/* 298 */             switch (a(arrayOfString[3], h)) {
/*     */               case 0:
/*     */               case 1:
/*     */               case 2:
/*     */               case 3:
/*     */                 break;
/*     */               default:
/*     */                 try {
/* 306 */                   new DecimalFormat(arrayOfString[3], 
/*     */                       
/* 308 */                       DecimalFormatSymbols.getInstance(locale));
/* 309 */                 } catch (IllegalArgumentException illegalArgumentException) {
/* 310 */                   ib = j;
/*     */                   
/* 312 */                   throw illegalArgumentException;
/*     */                 } 
/*     */                 break;
/*     */             } 
/* 316 */             b1 = b.e;
/*     */             break;
/*     */           case 2:
/*     */           case 3:
/* 320 */             m = a(arrayOfString[3], i);
/* 321 */             if (m < 0 || m >= i.length) {
/*     */               
/*     */               try {
/*     */ 
/*     */                 
/* 326 */                 new SimpleDateFormat(arrayOfString[3], locale);
/* 327 */               } catch (IllegalArgumentException illegalArgumentException) {
/* 328 */                 ib = j;
/*     */                 
/* 330 */                 throw illegalArgumentException;
/*     */               } 
/*     */             }
/* 333 */             b1 = b.d;
/*     */             break;
/*     */           case 4:
/* 336 */             if (arrayOfString[3].length() == 0) {
/* 337 */               throw new IllegalArgumentException("Choice Pattern requires Subformat Pattern: " + arrayOfString[3]);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             try {
/* 343 */               new ChoiceFormat(arrayOfString[3]);
/* 344 */             } catch (Exception exception) {
/* 345 */               ib = j;
/*     */               
/* 347 */               throw new IllegalArgumentException("Choice Pattern incorrect: " + arrayOfString[3], exception);
/*     */             } 
/*     */             
/* 350 */             b1 = b.e;
/*     */             break;
/*     */           default:
/* 353 */             ib = j;
/* 354 */             throw new IllegalArgumentException("unknown format type: " + arrayOfString[2]);
/*     */         } 
/*     */       
/*     */       } else {
/* 358 */         b1 = b.c;
/*     */       } 
/* 360 */       af.add(b1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final int a(String param1String, String[] param1ArrayOfString) {
/* 368 */       for (byte b1 = 0; b1 < param1ArrayOfString.length; b1++) {
/* 369 */         if (param1String.equals(param1ArrayOfString[b1])) {
/* 370 */           return b1;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 375 */       String str = param1String.trim().toLowerCase(Locale.ROOT);
/* 376 */       if (str != param1String) {
/* 377 */         for (byte b2 = 0; b2 < param1ArrayOfString.length; b2++) {
/* 378 */           if (str.equals(param1ArrayOfString[b2])) {
/* 379 */             return b2;
/*     */           }
/*     */         } 
/*     */       }
/* 383 */       return -1;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\a\a\f\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */