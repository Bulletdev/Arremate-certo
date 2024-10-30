/*     */ package org.e;
/*     */ 
/*     */ import java.io.Reader;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class u
/*     */   extends p
/*     */ {
/*  44 */   public static final HashMap<String, Character> d = new HashMap<String, Character>(8); static {
/*  45 */     d.put("amp", s.b);
/*  46 */     d.put("apos", s.c);
/*  47 */     d.put("gt", s.f);
/*  48 */     d.put("lt", s.g);
/*  49 */     d.put("quot", s.i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public u(Reader paramReader) {
/*  57 */     super(paramReader);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public u(String paramString) {
/*  65 */     super(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String eS() throws g {
/*  76 */     StringBuilder stringBuilder = new StringBuilder();
/*  77 */     while (ge()) {
/*  78 */       char c = next();
/*  79 */       stringBuilder.append(c);
/*  80 */       int i = stringBuilder.length() - 3;
/*  81 */       if (i >= 0 && stringBuilder.charAt(i) == ']' && stringBuilder
/*  82 */         .charAt(i + 1) == ']' && stringBuilder.charAt(i + 2) == '>') {
/*  83 */         stringBuilder.setLength(i);
/*  84 */         return stringBuilder.toString();
/*     */       } 
/*     */     } 
/*  87 */     throw a("Unclosed CDATA");
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
/*     */   public Object L() throws g {
/*     */     while (true) {
/* 105 */       char c = next();
/* 106 */       if (!Character.isWhitespace(c)) {
/* 107 */         if (c == '\000') {
/* 108 */           return null;
/*     */         }
/* 110 */         if (c == '<') {
/* 111 */           return s.g;
/*     */         }
/* 113 */         StringBuilder stringBuilder = new StringBuilder();
/*     */         while (true) {
/* 115 */           if (c == '\000') {
/* 116 */             return stringBuilder.toString().trim();
/*     */           }
/* 118 */           if (c == '<') {
/* 119 */             il();
/* 120 */             return stringBuilder.toString().trim();
/*     */           } 
/* 122 */           if (c == '&') {
/* 123 */             stringBuilder.append(a(c));
/*     */           } else {
/* 125 */             stringBuilder.append(c);
/*     */           } 
/* 127 */           c = next();
/*     */         } 
/*     */         break;
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
/*     */   public Object a(char paramChar) throws g {
/*     */     char c;
/* 142 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     while (true) {
/* 144 */       c = next();
/* 145 */       if (Character.isLetterOrDigit(c) || c == '#')
/* 146 */       { stringBuilder.append(Character.toLowerCase(c)); continue; }  break;
/* 147 */     }  if (c == ';') {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 153 */       String str = stringBuilder.toString();
/* 154 */       return bn(str);
/*     */     } 
/*     */     throw a("Missing ';' in XML entity: &" + stringBuilder);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String bn(String paramString) {
/* 164 */     if (paramString == null || paramString.isEmpty()) {
/* 165 */       return "";
/*     */     }
/*     */     
/* 168 */     if (paramString.charAt(0) == '#') {
/*     */       int i;
/* 170 */       if (paramString.charAt(1) == 'x' || paramString.charAt(1) == 'X') {
/*     */         
/* 172 */         i = Integer.parseInt(paramString.substring(2), 16);
/*     */       } else {
/*     */         
/* 175 */         i = Integer.parseInt(paramString.substring(1));
/*     */       } 
/* 177 */       return new String(new int[] { i }, 0, 1);
/*     */     } 
/* 179 */     Character character = d.get(paramString);
/* 180 */     if (character == null)
/*     */     {
/* 182 */       return '&' + paramString + ';';
/*     */     }
/* 184 */     return character.toString();
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
/*     */   public Object M() throws g {
/*     */     char c;
/*     */     char c1;
/*     */     do {
/* 204 */       c = next();
/* 205 */     } while (Character.isWhitespace(c));
/* 206 */     switch (c) {
/*     */       case '\000':
/* 208 */         throw a("Misshaped meta tag");
/*     */       case '<':
/* 210 */         return s.g;
/*     */       case '>':
/* 212 */         return s.f;
/*     */       case '/':
/* 214 */         return s.j;
/*     */       case '=':
/* 216 */         return s.e;
/*     */       case '!':
/* 218 */         return s.d;
/*     */       case '?':
/* 220 */         return s.h;
/*     */       case '"':
/*     */       case '\'':
/* 223 */         c1 = c;
/*     */         while (true) {
/* 225 */           c = next();
/* 226 */           if (c == '\000') {
/* 227 */             throw a("Unterminated string");
/*     */           }
/* 229 */           if (c == c1) {
/* 230 */             return Boolean.TRUE;
/*     */           }
/*     */         } 
/*     */     } 
/*     */     while (true)
/* 235 */     { c = next();
/* 236 */       if (Character.isWhitespace(c)) {
/* 237 */         return Boolean.TRUE;
/*     */       }
/* 239 */       switch (c)
/*     */       { case '\000':
/* 241 */           throw a("Unterminated string");
/*     */         case '!':
/*     */         case '"':
/*     */         case '\'':
/*     */         case '/':
/*     */         case '<':
/*     */         case '=':
/*     */         case '>':
/*     */         case '?':
/* 250 */           break; }  }  il();
/* 251 */     return Boolean.TRUE;
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
/*     */   public Object N() throws g {
/*     */     char c;
/*     */     char c1;
/*     */     do {
/* 273 */       c = next();
/* 274 */     } while (Character.isWhitespace(c));
/* 275 */     switch (c) {
/*     */       case '\000':
/* 277 */         throw a("Misshaped element");
/*     */       case '<':
/* 279 */         throw a("Misplaced '<'");
/*     */       case '>':
/* 281 */         return s.f;
/*     */       case '/':
/* 283 */         return s.j;
/*     */       case '=':
/* 285 */         return s.e;
/*     */       case '!':
/* 287 */         return s.d;
/*     */       case '?':
/* 289 */         return s.h;
/*     */ 
/*     */ 
/*     */       
/*     */       case '"':
/*     */       case '\'':
/* 295 */         c1 = c;
/* 296 */         stringBuilder = new StringBuilder();
/*     */         while (true) {
/* 298 */           c = next();
/* 299 */           if (c == '\000') {
/* 300 */             throw a("Unterminated string");
/*     */           }
/* 302 */           if (c == c1) {
/* 303 */             return stringBuilder.toString();
/*     */           }
/* 305 */           if (c == '&') {
/* 306 */             stringBuilder.append(a(c)); continue;
/*     */           } 
/* 308 */           stringBuilder.append(c);
/*     */         } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 315 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     while (true)
/* 317 */     { stringBuilder.append(c);
/* 318 */       c = next();
/* 319 */       if (Character.isWhitespace(c)) {
/* 320 */         return stringBuilder.toString();
/*     */       }
/* 322 */       switch (c)
/*     */       { case '\000':
/* 324 */           return stringBuilder.toString();
/*     */         case '!':
/*     */         case '/':
/*     */         case '=':
/*     */         case '>':
/*     */         case '?':
/*     */         case '[':
/*     */         case ']':
/* 332 */           il();
/* 333 */           return stringBuilder.toString();
/*     */         case '"':
/*     */         case '\'':
/*     */         case '<':
/* 337 */           break; }  }  throw a("Bad character in a name");
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
/*     */   public void bL(String paramString) {
/* 357 */     int i = 0;
/* 358 */     int j = paramString.length();
/* 359 */     char[] arrayOfChar = new char[j];
/*     */ 
/*     */ 
/*     */     
/*     */     byte b;
/*     */ 
/*     */     
/* 366 */     for (b = 0; b < j; b++) {
/* 367 */       char c = next();
/* 368 */       if (c == '\000') {
/*     */         return;
/*     */       }
/* 371 */       arrayOfChar[b] = c;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*     */     while (true) {
/* 377 */       int k = i;
/* 378 */       boolean bool = true;
/*     */ 
/*     */ 
/*     */       
/* 382 */       for (b = 0; b < j; b++) {
/* 383 */         if (arrayOfChar[k] != paramString.charAt(b)) {
/* 384 */           bool = false;
/*     */           break;
/*     */         } 
/* 387 */         k++;
/* 388 */         if (k >= j) {
/* 389 */           k -= j;
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 395 */       if (bool) {
/*     */         return;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 401 */       char c = next();
/* 402 */       if (c == '\000') {
/*     */         return;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 409 */       arrayOfChar[i] = c;
/* 410 */       i++;
/* 411 */       if (i >= j)
/* 412 */         i -= j; 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */