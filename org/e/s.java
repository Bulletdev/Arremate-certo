/*     */ package org.e;
/*     */ 
/*     */ import java.io.Reader;
/*     */ import java.io.StringReader;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class s
/*     */ {
/*  46 */   public static final Character b = Character.valueOf('&');
/*     */ 
/*     */   
/*  49 */   public static final Character c = Character.valueOf('\'');
/*     */ 
/*     */   
/*  52 */   public static final Character d = Character.valueOf('!');
/*     */ 
/*     */   
/*  55 */   public static final Character e = Character.valueOf('=');
/*     */ 
/*     */   
/*  58 */   public static final Character f = Character.valueOf('>');
/*     */ 
/*     */   
/*  61 */   public static final Character g = Character.valueOf('<');
/*     */ 
/*     */   
/*  64 */   public static final Character h = Character.valueOf('?');
/*     */ 
/*     */   
/*  67 */   public static final Character i = Character.valueOf('"');
/*     */ 
/*     */   
/*  70 */   public static final Character j = Character.valueOf('/');
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String lP = "xsi:nil";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String lQ = "xsi:type";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Iterable<Integer> a(String paramString) {
/*  91 */     return new Iterable<Integer>(paramString)
/*     */       {
/*     */         public Iterator<Integer> iterator() {
/*  94 */           return new Iterator<Integer>(this) {
/*  95 */               private int nextIndex = 0;
/*  96 */               private int length = this.a.lR.length();
/*     */ 
/*     */               
/*     */               public boolean hasNext() {
/* 100 */                 return (this.nextIndex < this.length);
/*     */               }
/*     */ 
/*     */               
/*     */               public Integer h() {
/* 105 */                 int i = this.a.lR.codePointAt(this.nextIndex);
/* 106 */                 this.nextIndex += Character.charCount(i);
/* 107 */                 return Integer.valueOf(i);
/*     */               }
/*     */ 
/*     */               
/*     */               public void remove() {
/* 112 */                 throw new UnsupportedOperationException();
/*     */               }
/*     */             };
/*     */         }
/*     */       };
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
/*     */   public static String escape(String paramString) {
/* 135 */     StringBuilder stringBuilder = new StringBuilder(paramString.length());
/* 136 */     for (Iterator<Integer> iterator = a(paramString).iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/* 137 */       switch (i) {
/*     */         case 38:
/* 139 */           stringBuilder.append("&amp;");
/*     */           continue;
/*     */         case 60:
/* 142 */           stringBuilder.append("&lt;");
/*     */           continue;
/*     */         case 62:
/* 145 */           stringBuilder.append("&gt;");
/*     */           continue;
/*     */         case 34:
/* 148 */           stringBuilder.append("&quot;");
/*     */           continue;
/*     */         case 39:
/* 151 */           stringBuilder.append("&apos;");
/*     */           continue;
/*     */       } 
/* 154 */       if (z(i)) {
/* 155 */         stringBuilder.append("&#x");
/* 156 */         stringBuilder.append(Integer.toHexString(i));
/* 157 */         stringBuilder.append(';'); continue;
/*     */       } 
/* 159 */       stringBuilder.appendCodePoint(i); }
/*     */ 
/*     */ 
/*     */     
/* 163 */     return stringBuilder.toString();
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
/*     */   private static boolean z(int paramInt) {
/* 179 */     return ((Character.isISOControl(paramInt) && paramInt != 9 && paramInt != 10 && paramInt != 13) || ((paramInt < 32 || paramInt > 55295) && (paramInt < 57344 || paramInt > 65533) && (paramInt < 65536 || paramInt > 1114111)));
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
/*     */   public static String unescape(String paramString) {
/* 200 */     StringBuilder stringBuilder = new StringBuilder(paramString.length());
/* 201 */     for (int i = 0, j = paramString.length(); i < j; i++) {
/* 202 */       char c = paramString.charAt(i);
/* 203 */       if (c == '&') {
/* 204 */         int k = paramString.indexOf(';', i);
/* 205 */         if (k > i) {
/* 206 */           String str = paramString.substring(i + 1, k);
/* 207 */           stringBuilder.append(u.bn(str));
/*     */           
/* 209 */           i += str.length() + 1;
/*     */         }
/*     */         else {
/*     */           
/* 213 */           stringBuilder.append(c);
/*     */         } 
/*     */       } else {
/*     */         
/* 217 */         stringBuilder.append(c);
/*     */       } 
/*     */     } 
/* 220 */     return stringBuilder.toString();
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
/*     */   public static void bK(String paramString) throws g {
/* 232 */     int i = paramString.length();
/* 233 */     if (i == 0) {
/* 234 */       throw new g("Empty string.");
/*     */     }
/* 236 */     for (byte b = 0; b < i; b++) {
/* 237 */       if (Character.isWhitespace(paramString.charAt(b))) {
/* 238 */         throw new g("'" + paramString + "' contains a space character.");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean a(u paramu, i parami, String paramString, t paramt) throws g {
/* 260 */     i i1 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 276 */     Object object = paramu.N();
/*     */ 
/*     */ 
/*     */     
/* 280 */     if (object == d) {
/* 281 */       char c = paramu.next();
/* 282 */       if (c == '-') {
/* 283 */         if (paramu.next() == '-') {
/* 284 */           paramu.bL("-->");
/* 285 */           return false;
/*     */         } 
/* 287 */         paramu.il();
/* 288 */       } else if (c == '[') {
/* 289 */         object = paramu.N();
/* 290 */         if ("CDATA".equals(object) && 
/* 291 */           paramu.next() == '[') {
/* 292 */           String str1 = paramu.eS();
/* 293 */           if (str1.length() > 0) {
/* 294 */             parami.a(paramt.eR(), str1);
/*     */           }
/* 296 */           return false;
/*     */         } 
/*     */         
/* 299 */         throw paramu.a("Expected 'CDATA['");
/*     */       } 
/* 301 */       byte b = 1;
/*     */       while (true)
/* 303 */       { object = paramu.M();
/* 304 */         if (object == null)
/* 305 */           throw paramu.a("Missing '>' after '<!'."); 
/* 306 */         if (object == g) {
/* 307 */           b++;
/* 308 */         } else if (object == f) {
/* 309 */           b--;
/*     */         } 
/* 311 */         if (b <= 0)
/* 312 */           return false;  } 
/* 313 */     }  if (object == h) {
/*     */ 
/*     */       
/* 316 */       paramu.bL("?>");
/* 317 */       return false;
/* 318 */     }  if (object == j) {
/*     */ 
/*     */ 
/*     */       
/* 322 */       object = paramu.N();
/* 323 */       if (paramString == null) {
/* 324 */         throw paramu.a("Mismatched close tag " + object);
/*     */       }
/* 326 */       if (!object.equals(paramString)) {
/* 327 */         throw paramu.a("Mismatched " + paramString + " and " + object);
/*     */       }
/* 329 */       if (paramu.N() != f) {
/* 330 */         throw paramu.a("Misshaped close tag");
/*     */       }
/* 332 */       return true;
/*     */     } 
/* 334 */     if (object instanceof Character) {
/* 335 */       throw paramu.a("Misshaped tag");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 340 */     String str = (String)object;
/* 341 */     object = null;
/* 342 */     i1 = new i();
/* 343 */     boolean bool = false;
/* 344 */     v<?> v = null;
/*     */     while (true) {
/* 346 */       if (object == null) {
/* 347 */         object = paramu.N();
/*     */       }
/*     */       
/* 350 */       if (object instanceof String) {
/* 351 */         String str1 = (String)object;
/* 352 */         object = paramu.N();
/* 353 */         if (object == e) {
/* 354 */           object = paramu.N();
/* 355 */           if (!(object instanceof String)) {
/* 356 */             throw paramu.a("Missing value");
/*     */           }
/*     */           
/* 359 */           if (paramt.gg() && "xsi:nil"
/* 360 */             .equals(str1) && 
/* 361 */             Boolean.parseBoolean((String)object)) {
/* 362 */             bool = true;
/* 363 */           } else if (paramt.T() != null && !paramt.T().isEmpty() && "xsi:type"
/* 364 */             .equals(str1)) {
/* 365 */             v = paramt.T().get(object);
/* 366 */           } else if (!bool) {
/* 367 */             i1.a(str1, 
/* 368 */                 paramt.gf() ? object : 
/*     */                 
/* 370 */                 e((String)object));
/*     */           } 
/* 372 */           object = null; continue;
/*     */         } 
/* 374 */         i1.a(str1, ""); continue;
/*     */       } 
/*     */       break;
/*     */     } 
/* 378 */     if (object == j) {
/*     */       
/* 380 */       if (paramu.N() != f) {
/* 381 */         throw paramu.a("Misshaped tag");
/*     */       }
/* 383 */       if (bool) {
/* 384 */         parami.a(str, i.NULL);
/* 385 */       } else if (i1.length() > 0) {
/* 386 */         parami.a(str, i1);
/*     */       } else {
/* 388 */         parami.a(str, "");
/*     */       } 
/* 390 */       return false;
/*     */     } 
/* 392 */     if (object == f) {
/*     */       while (true) {
/*     */         
/* 395 */         object = paramu.L();
/* 396 */         if (object == null) {
/* 397 */           if (str != null) {
/* 398 */             throw paramu.a("Unclosed tag " + str);
/*     */           }
/* 400 */           return false;
/* 401 */         }  if (object instanceof String) {
/* 402 */           String str1 = (String)object;
/* 403 */           if (str1.length() > 0) {
/* 404 */             if (v != null) {
/* 405 */               i1.a(paramt.eR(), 
/* 406 */                   a(str1, v)); continue;
/*     */             } 
/* 408 */             i1.a(paramt.eR(), 
/* 409 */                 paramt.gf() ? str1 : e(str1));
/*     */           } 
/*     */           continue;
/*     */         } 
/* 413 */         if (object == g)
/*     */         {
/* 415 */           if (a(paramu, i1, str, paramt)) {
/* 416 */             if (i1.length() == 0) {
/* 417 */               parami.a(str, "");
/* 418 */             } else if (i1.length() == 1 && i1
/* 419 */               .d(paramt.eR()) != null) {
/* 420 */               parami.a(str, i1.d(paramt.eR()));
/*     */             } else {
/* 422 */               parami.a(str, i1);
/*     */             } 
/* 424 */             return false;
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/* 429 */     throw paramu.a("Misshaped tag");
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
/*     */   public static Object a(String paramString, v<?> paramv) {
/* 442 */     if (paramv != null) {
/* 443 */       return paramv.f(paramString);
/*     */     }
/* 445 */     return e(paramString);
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
/*     */   public static Object e(String paramString) {
/* 458 */     if ("".equals(paramString)) {
/* 459 */       return paramString;
/*     */     }
/*     */ 
/*     */     
/* 463 */     if ("true".equalsIgnoreCase(paramString)) {
/* 464 */       return Boolean.TRUE;
/*     */     }
/* 466 */     if ("false".equalsIgnoreCase(paramString)) {
/* 467 */       return Boolean.FALSE;
/*     */     }
/* 469 */     if ("null".equalsIgnoreCase(paramString)) {
/* 470 */       return i.NULL;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 478 */     char c = paramString.charAt(0);
/* 479 */     if ((c >= '0' && c <= '9') || c == '-') {
/*     */       try {
/* 481 */         return c(paramString);
/* 482 */       } catch (Exception exception) {}
/*     */     }
/*     */     
/* 485 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Number c(String paramString) throws NumberFormatException {
/* 492 */     char c = paramString.charAt(0);
/* 493 */     if ((c >= '0' && c <= '9') || c == '-') {
/*     */       
/* 495 */       if (ac(paramString)) {
/*     */         
/*     */         try {
/*     */ 
/*     */           
/* 500 */           BigDecimal bigDecimal = new BigDecimal(paramString);
/* 501 */           if (c == '-' && BigDecimal.ZERO.compareTo(bigDecimal) == 0) {
/* 502 */             return Double.valueOf(-0.0D);
/*     */           }
/* 504 */           return bigDecimal;
/* 505 */         } catch (NumberFormatException numberFormatException) {
/*     */           
/*     */           try {
/* 508 */             Double double_ = Double.valueOf(paramString);
/* 509 */             if (double_.isNaN() || double_.isInfinite()) {
/* 510 */               throw new NumberFormatException("val [" + paramString + "] is not a valid number.");
/*     */             }
/* 512 */             return double_;
/* 513 */           } catch (NumberFormatException numberFormatException1) {
/* 514 */             throw new NumberFormatException("val [" + paramString + "] is not a valid number.");
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 519 */       if (c == '0' && paramString.length() > 1) {
/* 520 */         char c1 = paramString.charAt(1);
/* 521 */         if (c1 >= '0' && c1 <= '9') {
/* 522 */           throw new NumberFormatException("val [" + paramString + "] is not a valid number.");
/*     */         }
/* 524 */       } else if (c == '-' && paramString.length() > 2) {
/* 525 */         char c1 = paramString.charAt(1);
/* 526 */         char c2 = paramString.charAt(2);
/* 527 */         if (c1 == '0' && c2 >= '0' && c2 <= '9') {
/* 528 */           throw new NumberFormatException("val [" + paramString + "] is not a valid number.");
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 539 */       BigInteger bigInteger = new BigInteger(paramString);
/* 540 */       if (bigInteger.bitLength() <= 31) {
/* 541 */         return Integer.valueOf(bigInteger.intValue());
/*     */       }
/* 543 */       if (bigInteger.bitLength() <= 63) {
/* 544 */         return Long.valueOf(bigInteger.longValue());
/*     */       }
/* 546 */       return bigInteger;
/*     */     } 
/* 548 */     throw new NumberFormatException("val [" + paramString + "] is not a valid number.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean ac(String paramString) {
/* 555 */     return (paramString.indexOf('.') > -1 || paramString.indexOf('e') > -1 || paramString
/* 556 */       .indexOf('E') > -1 || "-0".equals(paramString));
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
/*     */   public static i i(String paramString) throws g {
/* 578 */     return a(paramString, t.a);
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
/*     */   public static i a(Reader paramReader) throws g {
/* 598 */     return a(paramReader, t.a);
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
/*     */   public static i a(Reader paramReader, boolean paramBoolean) throws g {
/* 623 */     if (paramBoolean) {
/* 624 */       return a(paramReader, t.b);
/*     */     }
/* 626 */     return a(paramReader, t.a);
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
/*     */   public static i a(Reader paramReader, t paramt) throws g {
/* 650 */     i i = new i();
/* 651 */     u u = new u(paramReader);
/* 652 */     while (u.ge()) {
/* 653 */       u.bL("<");
/* 654 */       if (u.ge()) {
/* 655 */         a(u, i, null, paramt);
/*     */       }
/*     */     } 
/* 658 */     return i;
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
/*     */   public static i a(String paramString, boolean paramBoolean) throws g {
/* 684 */     return a(new StringReader(paramString), paramBoolean);
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
/*     */   public static i a(String paramString, t paramt) throws g {
/* 709 */     return a(new StringReader(paramString), paramt);
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
/*     */   public static String toString(Object paramObject) throws g {
/* 721 */     return a(paramObject, null, t.a);
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
/*     */   public static String toString(Object paramObject, String paramString) {
/* 735 */     return a(paramObject, paramString, t.a);
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
/*     */   public static String a(Object paramObject, String paramString, t paramt) throws g {
/* 752 */     StringBuilder stringBuilder = new StringBuilder();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 757 */     if (paramObject instanceof i) {
/*     */ 
/*     */       
/* 760 */       if (paramString != null) {
/* 761 */         stringBuilder.append('<');
/* 762 */         stringBuilder.append(paramString);
/* 763 */         stringBuilder.append('>');
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 768 */       i i = (i)paramObject;
/* 769 */       for (String str1 : i.keySet()) {
/* 770 */         Object object = i.d(str1);
/* 771 */         if (object == null) {
/* 772 */           object = "";
/* 773 */         } else if (object.getClass().isArray()) {
/* 774 */           object = new f(object);
/*     */         } 
/*     */ 
/*     */         
/* 778 */         if (str1.equals(paramt.eR())) {
/* 779 */           if (object instanceof f) {
/* 780 */             f f = (f)object;
/* 781 */             int j = f.length();
/*     */             
/* 783 */             for (byte b = 0; b < j; b++) {
/* 784 */               if (b > 0) {
/* 785 */                 stringBuilder.append('\n');
/*     */               }
/* 787 */               Object object1 = f.h(b);
/* 788 */               stringBuilder.append(escape(object1.toString()));
/*     */             }  continue;
/*     */           } 
/* 791 */           stringBuilder.append(escape(object.toString()));
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/* 796 */         if (object instanceof f) {
/* 797 */           f f = (f)object;
/* 798 */           int j = f.length();
/*     */           
/* 800 */           for (byte b = 0; b < j; b++) {
/* 801 */             Object object1 = f.h(b);
/* 802 */             if (object1 instanceof f) {
/* 803 */               stringBuilder.append('<');
/* 804 */               stringBuilder.append(str1);
/* 805 */               stringBuilder.append('>');
/* 806 */               stringBuilder.append(a(object1, null, paramt));
/* 807 */               stringBuilder.append("</");
/* 808 */               stringBuilder.append(str1);
/* 809 */               stringBuilder.append('>');
/*     */             } else {
/* 811 */               stringBuilder.append(a(object1, str1, paramt));
/*     */             } 
/*     */           }  continue;
/* 814 */         }  if ("".equals(object)) {
/* 815 */           stringBuilder.append('<');
/* 816 */           stringBuilder.append(str1);
/* 817 */           stringBuilder.append("/>");
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/* 822 */         stringBuilder.append(a(object, str1, paramt));
/*     */       } 
/*     */       
/* 825 */       if (paramString != null) {
/*     */ 
/*     */         
/* 828 */         stringBuilder.append("</");
/* 829 */         stringBuilder.append(paramString);
/* 830 */         stringBuilder.append('>');
/*     */       } 
/* 832 */       return stringBuilder.toString();
/*     */     } 
/*     */ 
/*     */     
/* 836 */     if (paramObject != null && (paramObject instanceof f || paramObject.getClass().isArray())) {
/* 837 */       f f; if (paramObject.getClass().isArray()) {
/* 838 */         f = new f(paramObject);
/*     */       } else {
/* 840 */         f = (f)paramObject;
/*     */       } 
/* 842 */       int i = f.length();
/*     */       
/* 844 */       for (byte b = 0; b < i; b++) {
/* 845 */         Object object = f.h(b);
/*     */ 
/*     */ 
/*     */         
/* 849 */         stringBuilder.append(a(object, (paramString == null) ? "array" : paramString, paramt));
/*     */       } 
/* 851 */       return stringBuilder.toString();
/*     */     } 
/*     */     
/* 854 */     String str = (paramObject == null) ? "null" : escape(paramObject.toString());
/* 855 */     return (paramString == null) ? ("\"" + str + "\"") : (
/* 856 */       (str.length() == 0) ? ("<" + paramString + "/>") : ("<" + paramString + ">" + str + "</" + paramString + ">"));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\e\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */