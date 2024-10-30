/*     */ package org.e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class h
/*     */ {
/*     */   private static Object a(u paramu, boolean paramBoolean1, f paramf, boolean paramBoolean2) throws g {
/*  54 */     String str1 = null;
/*     */     
/*  56 */     f f1 = null;
/*  57 */     i i = null;
/*     */     
/*  59 */     String str2 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     label116: while (true) {
/*  68 */       if (!paramu.ge()) {
/*  69 */         throw paramu.a("Bad XML");
/*     */       }
/*  71 */       Object object = paramu.L();
/*  72 */       if (object == s.g) {
/*  73 */         object = paramu.N();
/*  74 */         if (object instanceof Character) {
/*  75 */           if (object == s.j) {
/*     */ 
/*     */ 
/*     */             
/*  79 */             object = paramu.N();
/*  80 */             if (!(object instanceof String)) {
/*  81 */               throw new g("Expected a closing name instead of '" + object + "'.");
/*     */             }
/*     */ 
/*     */             
/*  85 */             if (paramu.N() != s.f) {
/*  86 */               throw paramu.a("Misshaped close tag");
/*     */             }
/*  88 */             return object;
/*  89 */           }  if (object == s.d) {
/*     */ 
/*     */ 
/*     */             
/*  93 */             char c = paramu.next();
/*  94 */             if (c == '-') {
/*  95 */               if (paramu.next() == '-') {
/*  96 */                 paramu.bL("-->"); continue;
/*     */               } 
/*  98 */               paramu.il(); continue;
/*     */             } 
/* 100 */             if (c == '[') {
/* 101 */               object = paramu.N();
/* 102 */               if (object.equals("CDATA") && paramu.next() == '[') {
/* 103 */                 if (paramf != null)
/* 104 */                   paramf.a(paramu.eS()); 
/*     */                 continue;
/*     */               } 
/* 107 */               throw paramu.a("Expected 'CDATA['");
/*     */             } 
/*     */             
/* 110 */             byte b = 1;
/*     */             while (true)
/* 112 */             { object = paramu.M();
/* 113 */               if (object == null)
/* 114 */                 throw paramu.a("Missing '>' after '<!'."); 
/* 115 */               if (object == s.g) {
/* 116 */                 b++;
/* 117 */               } else if (object == s.f) {
/* 118 */                 b--;
/*     */               } 
/* 120 */               if (b <= 0)
/*     */                 continue label116;  }  break;
/* 122 */           }  if (object == s.h) {
/*     */ 
/*     */ 
/*     */             
/* 126 */             paramu.bL("?>"); continue;
/*     */           } 
/* 128 */           throw paramu.a("Misshaped tag");
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 134 */         if (!(object instanceof String)) {
/* 135 */           throw paramu.a("Bad tagName '" + object + "'.");
/*     */         }
/* 137 */         str2 = (String)object;
/* 138 */         f1 = new f();
/* 139 */         i = new i();
/* 140 */         if (paramBoolean1) {
/* 141 */           f1.a(str2);
/* 142 */           if (paramf != null) {
/* 143 */             paramf.a(f1);
/*     */           }
/*     */         } else {
/* 146 */           i.c("tagName", str2);
/* 147 */           if (paramf != null) {
/* 148 */             paramf.a(i);
/*     */           }
/*     */         } 
/* 151 */         object = null;
/*     */         while (true) {
/* 153 */           if (object == null) {
/* 154 */             object = paramu.N();
/*     */           }
/* 156 */           if (object == null) {
/* 157 */             throw paramu.a("Misshaped tag");
/*     */           }
/* 159 */           if (!(object instanceof String)) {
/*     */             break;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 165 */           String str = (String)object;
/* 166 */           if (!paramBoolean1 && ("tagName".equals(str) || "childNode".equals(str))) {
/* 167 */             throw paramu.a("Reserved attribute.");
/*     */           }
/* 169 */           object = paramu.N();
/* 170 */           if (object == s.e) {
/* 171 */             object = paramu.N();
/* 172 */             if (!(object instanceof String)) {
/* 173 */               throw paramu.a("Missing value");
/*     */             }
/* 175 */             i.a(str, paramBoolean2 ? object : s.e((String)object));
/* 176 */             object = null; continue;
/*     */           } 
/* 178 */           i.a(str, "");
/*     */         } 
/*     */         
/* 181 */         if (paramBoolean1 && i.length() > 0) {
/* 182 */           f1.a(i);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 187 */         if (object == s.j) {
/* 188 */           if (paramu.N() != s.f) {
/* 189 */             throw paramu.a("Misshaped tag");
/*     */           }
/* 191 */           if (paramf == null) {
/* 192 */             if (paramBoolean1) {
/* 193 */               return f1;
/*     */             }
/* 195 */             return i;
/*     */           } 
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/* 201 */         if (object != s.f) {
/* 202 */           throw paramu.a("Misshaped tag");
/*     */         }
/* 204 */         str1 = (String)a(paramu, paramBoolean1, f1, paramBoolean2);
/* 205 */         if (str1 != null) {
/* 206 */           if (!str1.equals(str2)) {
/* 207 */             throw paramu.a("Mismatched '" + str2 + "' and '" + str1 + "'");
/*     */           }
/*     */           
/* 210 */           str2 = null;
/* 211 */           if (!paramBoolean1 && f1.length() > 0) {
/* 212 */             i.c("childNodes", f1);
/*     */           }
/* 214 */           if (paramf == null) {
/* 215 */             if (paramBoolean1) {
/* 216 */               return f1;
/*     */             }
/* 218 */             return i;
/*     */           } 
/*     */         } 
/*     */         
/*     */         continue;
/*     */       } 
/* 224 */       if (paramf != null) {
/* 225 */         paramf.a((object instanceof String) ? (paramBoolean2 ? 
/* 226 */             s.unescape((String)object) : s.e((String)object)) : object);
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
/*     */   public static f b(String paramString) throws g {
/* 247 */     return (f)a(new u(paramString), true, null, false);
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
/*     */   public static f a(String paramString, boolean paramBoolean) throws g {
/* 269 */     return (f)a(new u(paramString), true, null, paramBoolean);
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
/*     */   public static f a(u paramu, boolean paramBoolean) throws g {
/* 291 */     return (f)a(paramu, true, null, paramBoolean);
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
/*     */   public static f a(u paramu) throws g {
/* 308 */     return (f)a(paramu, true, null, false);
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
/*     */   public static i i(String paramString) throws g {
/* 326 */     return (i)a(new u(paramString), false, null, false);
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
/*     */   public static i a(String paramString, boolean paramBoolean) throws g {
/* 346 */     return (i)a(new u(paramString), false, null, paramBoolean);
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
/*     */   public static i a(u paramu) throws g {
/* 364 */     return (i)a(paramu, false, null, false);
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
/*     */   public static i a(u paramu, boolean paramBoolean) throws g {
/* 384 */     return (i)a(paramu, false, null, paramBoolean);
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
/*     */   public static String b(f paramf) throws g {
/*     */     byte b;
/* 399 */     StringBuilder stringBuilder = new StringBuilder();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 404 */     String str = paramf.getString(0);
/* 405 */     s.bK(str);
/* 406 */     str = s.escape(str);
/* 407 */     stringBuilder.append('<');
/* 408 */     stringBuilder.append(str);
/*     */     
/* 410 */     Object object = paramf.h(1);
/* 411 */     if (object instanceof i) {
/* 412 */       b = 2;
/* 413 */       i i1 = (i)object;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 418 */       for (String str1 : i1.keySet()) {
/* 419 */         Object object1 = i1.d(str1);
/* 420 */         s.bK(str1);
/* 421 */         if (object1 != null) {
/* 422 */           stringBuilder.append(' ');
/* 423 */           stringBuilder.append(s.escape(str1));
/* 424 */           stringBuilder.append('=');
/* 425 */           stringBuilder.append('"');
/* 426 */           stringBuilder.append(s.escape(object1.toString()));
/* 427 */           stringBuilder.append('"');
/*     */         } 
/*     */       } 
/*     */     } else {
/* 431 */       b = 1;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 436 */     int i = paramf.length();
/* 437 */     if (b >= i)
/* 438 */     { stringBuilder.append('/');
/* 439 */       stringBuilder.append('>'); }
/*     */     else
/* 441 */     { stringBuilder.append('>');
/*     */       while (true)
/* 443 */       { object = paramf.get(b);
/* 444 */         b++;
/* 445 */         if (object != null) {
/* 446 */           if (object instanceof String) {
/* 447 */             stringBuilder.append(s.escape(object.toString()));
/* 448 */           } else if (object instanceof i) {
/* 449 */             stringBuilder.append(d((i)object));
/* 450 */           } else if (object instanceof f) {
/* 451 */             stringBuilder.append(b((f)object));
/*     */           } else {
/* 453 */             stringBuilder.append(object.toString());
/*     */           } 
/*     */         }
/* 456 */         if (b >= i)
/* 457 */         { stringBuilder.append('<');
/* 458 */           stringBuilder.append('/');
/* 459 */           stringBuilder.append(str);
/* 460 */           stringBuilder.append('>');
/*     */           
/* 462 */           return stringBuilder.toString(); }  }  }  return stringBuilder.toString();
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
/*     */   public static String d(i parami) throws g {
/* 475 */     StringBuilder stringBuilder = new StringBuilder();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 485 */     String str = parami.bl("tagName");
/* 486 */     if (str == null) {
/* 487 */       return s.escape(parami.toString());
/*     */     }
/* 489 */     s.bK(str);
/* 490 */     str = s.escape(str);
/* 491 */     stringBuilder.append('<');
/* 492 */     stringBuilder.append(str);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 497 */     for (String str1 : parami.keySet()) {
/* 498 */       if (!"tagName".equals(str1) && !"childNodes".equals(str1)) {
/* 499 */         s.bK(str1);
/* 500 */         Object object = parami.d(str1);
/* 501 */         if (object != null) {
/* 502 */           stringBuilder.append(' ');
/* 503 */           stringBuilder.append(s.escape(str1));
/* 504 */           stringBuilder.append('=');
/* 505 */           stringBuilder.append('"');
/* 506 */           stringBuilder.append(s.escape(object.toString()));
/* 507 */           stringBuilder.append('"');
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 514 */     f f = parami.d("childNodes");
/* 515 */     if (f == null) {
/* 516 */       stringBuilder.append('/');
/* 517 */       stringBuilder.append('>');
/*     */     } else {
/* 519 */       stringBuilder.append('>');
/* 520 */       int j = f.length();
/* 521 */       for (byte b = 0; b < j; b++) {
/* 522 */         Object object = f.get(b);
/* 523 */         if (object != null) {
/* 524 */           if (object instanceof String) {
/* 525 */             stringBuilder.append(s.escape(object.toString()));
/* 526 */           } else if (object instanceof i) {
/* 527 */             stringBuilder.append(d((i)object));
/* 528 */           } else if (object instanceof f) {
/* 529 */             stringBuilder.append(b((f)object));
/*     */           } else {
/* 531 */             stringBuilder.append(object.toString());
/*     */           } 
/*     */         }
/*     */       } 
/* 535 */       stringBuilder.append('<');
/* 536 */       stringBuilder.append('/');
/* 537 */       stringBuilder.append(str);
/* 538 */       stringBuilder.append('>');
/*     */     } 
/* 540 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\e\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */