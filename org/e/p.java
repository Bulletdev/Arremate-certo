/*     */ package org.e;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.Reader;
/*     */ import java.io.StringReader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class p
/*     */ {
/*     */   private long bS;
/*     */   private boolean eof;
/*     */   private long aN;
/*     */   private long bT;
/*     */   private char u;
/*     */   private final Reader reader;
/*     */   private boolean dc;
/*     */   private long bU;
/*     */   
/*     */   public p(Reader paramReader) {
/*  66 */     this.reader = paramReader.markSupported() ? paramReader : new BufferedReader(paramReader);
/*     */ 
/*     */     
/*  69 */     this.eof = false;
/*  70 */     this.dc = false;
/*  71 */     this.u = Character.MIN_VALUE;
/*  72 */     this.aN = 0L;
/*  73 */     this.bS = 1L;
/*  74 */     this.bU = 0L;
/*  75 */     this.bT = 1L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public p(InputStream paramInputStream) {
/*  84 */     this(new InputStreamReader(paramInputStream));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public p(String paramString) {
/*  94 */     this(new StringReader(paramString));
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
/*     */   public void il() throws g {
/* 106 */     if (this.dc || this.aN <= 0L) {
/* 107 */       throw new g("Stepping back two steps is not supported");
/*     */     }
/* 109 */     im();
/* 110 */     this.dc = true;
/* 111 */     this.eof = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void im() {
/* 118 */     this.aN--;
/* 119 */     if (this.u == '\r' || this.u == '\n') {
/* 120 */       this.bT--;
/* 121 */       this.bS = this.bU;
/* 122 */     } else if (this.bS > 0L) {
/* 123 */       this.bS--;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int e(char paramChar) {
/* 134 */     if (paramChar >= '0' && paramChar <= '9') {
/* 135 */       return paramChar - 48;
/*     */     }
/* 137 */     if (paramChar >= 'A' && paramChar <= 'F') {
/* 138 */       return paramChar - 55;
/*     */     }
/* 140 */     if (paramChar >= 'a' && paramChar <= 'f') {
/* 141 */       return paramChar - 87;
/*     */     }
/* 143 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean end() {
/* 152 */     return (this.eof && !this.dc);
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
/*     */   public boolean ge() throws g {
/* 164 */     if (this.dc) {
/* 165 */       return true;
/*     */     }
/*     */     try {
/* 168 */       this.reader.mark(1);
/* 169 */     } catch (IOException iOException) {
/* 170 */       throw new g("Unable to preserve stream position", iOException);
/*     */     } 
/*     */     
/*     */     try {
/* 174 */       if (this.reader.read() <= 0) {
/* 175 */         this.eof = true;
/* 176 */         return false;
/*     */       } 
/* 178 */       this.reader.reset();
/* 179 */     } catch (IOException iOException) {
/* 180 */       throw new g("Unable to read the next character from the stream", iOException);
/*     */     } 
/* 182 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char next() throws g {
/*     */     int i;
/* 194 */     if (this.dc) {
/* 195 */       this.dc = false;
/* 196 */       i = this.u;
/*     */     } else {
/*     */       try {
/* 199 */         i = this.reader.read();
/* 200 */       } catch (IOException iOException) {
/* 201 */         throw new g(iOException);
/*     */       } 
/*     */     } 
/* 204 */     if (i <= 0) {
/* 205 */       this.eof = true;
/* 206 */       return Character.MIN_VALUE;
/*     */     } 
/* 208 */     bs(i);
/* 209 */     this.u = (char)i;
/* 210 */     return this.u;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void bs(int paramInt) {
/* 219 */     if (paramInt > 0) {
/* 220 */       this.aN++;
/* 221 */       if (paramInt == 13) {
/* 222 */         this.bT++;
/* 223 */         this.bU = this.bS;
/* 224 */         this.bS = 0L;
/* 225 */       } else if (paramInt == 10) {
/* 226 */         if (this.u != '\r') {
/* 227 */           this.bT++;
/* 228 */           this.bU = this.bS;
/*     */         } 
/* 230 */         this.bS = 0L;
/*     */       } else {
/* 232 */         this.bS++;
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
/*     */   public char d(char paramChar) throws g {
/* 245 */     char c = next();
/* 246 */     if (c != paramChar) {
/* 247 */       if (c > '\000') {
/* 248 */         throw a("Expected '" + paramChar + "' and instead saw '" + c + "'");
/*     */       }
/*     */       
/* 251 */       throw a("Expected '" + paramChar + "' and instead saw ''");
/*     */     } 
/* 253 */     return c;
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
/*     */   public String t(int paramInt) throws g {
/* 267 */     if (paramInt == 0) {
/* 268 */       return "";
/*     */     }
/*     */     
/* 271 */     char[] arrayOfChar = new char[paramInt];
/* 272 */     byte b = 0;
/*     */     
/* 274 */     while (b < paramInt) {
/* 275 */       arrayOfChar[b] = next();
/* 276 */       if (end()) {
/* 277 */         throw a("Substring bounds error");
/*     */       }
/* 279 */       b++;
/*     */     } 
/* 281 */     return new String(arrayOfChar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char f() throws g {
/*     */     char c;
/*     */     do {
/* 292 */       c = next();
/* 293 */     } while (c != '\000' && c <= ' ');
/* 294 */     return c;
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
/*     */   public String c(char paramChar) throws g {
/* 313 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     while (true) {
/* 315 */       char c = next();
/* 316 */       switch (c) {
/*     */         case '\000':
/*     */         case '\n':
/*     */         case '\r':
/* 320 */           throw a("Unterminated string");
/*     */         case '\\':
/* 322 */           c = next();
/* 323 */           switch (c) {
/*     */             case 'b':
/* 325 */               stringBuilder.append('\b');
/*     */               continue;
/*     */             case 't':
/* 328 */               stringBuilder.append('\t');
/*     */               continue;
/*     */             case 'n':
/* 331 */               stringBuilder.append('\n');
/*     */               continue;
/*     */             case 'f':
/* 334 */               stringBuilder.append('\f');
/*     */               continue;
/*     */             case 'r':
/* 337 */               stringBuilder.append('\r');
/*     */               continue;
/*     */             case 'u':
/*     */               try {
/* 341 */                 stringBuilder.append((char)Integer.parseInt(t(4), 16));
/* 342 */               } catch (NumberFormatException numberFormatException) {
/* 343 */                 throw a("Illegal escape.", numberFormatException);
/*     */               } 
/*     */               continue;
/*     */             case '"':
/*     */             case '\'':
/*     */             case '/':
/*     */             case '\\':
/* 350 */               stringBuilder.append(c);
/*     */               continue;
/*     */           } 
/* 353 */           throw a("Illegal escape.");
/*     */       } 
/*     */ 
/*     */       
/* 357 */       if (c == paramChar) {
/* 358 */         return stringBuilder.toString();
/*     */       }
/* 360 */       stringBuilder.append(c);
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
/*     */   public String d(char paramChar) throws g {
/* 375 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     while (true) {
/* 377 */       char c = next();
/* 378 */       if (c == paramChar || c == '\000' || c == '\n' || c == '\r') {
/* 379 */         if (c != '\000') {
/* 380 */           il();
/*     */         }
/* 382 */         return stringBuilder.toString().trim();
/*     */       } 
/* 384 */       stringBuilder.append(c);
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
/*     */   public String bm(String paramString) throws g {
/* 399 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     while (true) {
/* 401 */       char c = next();
/* 402 */       if (paramString.indexOf(c) >= 0 || c == '\000' || c == '\n' || c == '\r') {
/*     */         
/* 404 */         if (c != '\000') {
/* 405 */           il();
/*     */         }
/* 407 */         return stringBuilder.toString().trim();
/*     */       } 
/* 409 */       stringBuilder.append(c);
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
/*     */   public Object K() throws g {
/* 422 */     char c = f();
/*     */ 
/*     */     
/* 425 */     switch (c) {
/*     */       case '"':
/*     */       case '\'':
/* 428 */         return c(c);
/*     */       case '{':
/* 430 */         il();
/* 431 */         return new i(this);
/*     */       case '[':
/* 433 */         il();
/* 434 */         return new f(this);
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
/* 446 */     StringBuilder stringBuilder = new StringBuilder();
/* 447 */     while (c >= ' ' && ",:]}/\\\"[{;=#".indexOf(c) < 0) {
/* 448 */       stringBuilder.append(c);
/* 449 */       c = next();
/*     */     } 
/* 451 */     if (!this.eof) {
/* 452 */       il();
/*     */     }
/*     */     
/* 455 */     String str = stringBuilder.toString().trim();
/* 456 */     if ("".equals(str)) {
/* 457 */       throw a("Missing value");
/*     */     }
/* 459 */     return i.e(str);
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
/*     */   public char e(char paramChar) throws g {
/*     */     try {
/* 475 */       long l1 = this.aN;
/* 476 */       long l2 = this.bS;
/* 477 */       long l3 = this.bT;
/* 478 */       this.reader.mark(1000000);
/*     */       while (true) {
/* 480 */         char c = next();
/* 481 */         if (c == '\000') {
/*     */ 
/*     */ 
/*     */           
/* 485 */           this.reader.reset();
/* 486 */           this.aN = l1;
/* 487 */           this.bS = l2;
/* 488 */           this.bT = l3;
/* 489 */           return Character.MIN_VALUE;
/*     */         } 
/* 491 */         if (c == paramChar) {
/* 492 */           this.reader.mark(1);
/*     */ 
/*     */ 
/*     */           
/* 496 */           il();
/* 497 */           return c;
/*     */         } 
/*     */       } 
/*     */     } catch (IOException iOException) {
/*     */       throw new g(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public g a(String paramString) {
/* 507 */     return new g(paramString + toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public g a(String paramString, Throwable paramThrowable) {
/* 518 */     return new g(paramString + toString(), paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 528 */     return " at " + this.aN + " [character " + this.bS + " line " + this.bT + "]";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\e\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */