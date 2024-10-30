/*     */ package com.b.a.a;
/*     */ 
/*     */ import javax.security.auth.x500.X500Principal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class j
/*     */ {
/*     */   private final String jc;
/*     */   private final int length;
/*     */   private int pos;
/*     */   private int gV;
/*     */   private int end;
/*     */   private int gW;
/*     */   private char[] chars;
/*     */   
/*     */   public j(X500Principal paramX500Principal) {
/*  43 */     this.jc = paramX500Principal.getName("RFC2253");
/*  44 */     this.length = this.jc.length();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String dE() {
/*  51 */     for (; this.pos < this.length && this.chars[this.pos] == ' '; this.pos++);
/*     */     
/*  53 */     if (this.pos == this.length) {
/*  54 */       return null;
/*     */     }
/*     */ 
/*     */     
/*  58 */     this.gV = this.pos;
/*     */ 
/*     */     
/*  61 */     this.pos++;
/*  62 */     for (; this.pos < this.length && this.chars[this.pos] != '=' && this.chars[this.pos] != ' '; this.pos++);
/*     */ 
/*     */ 
/*     */     
/*  66 */     if (this.pos >= this.length) {
/*  67 */       throw new IllegalStateException("Unexpected end of DN: " + this.jc);
/*     */     }
/*     */ 
/*     */     
/*  71 */     this.end = this.pos;
/*     */ 
/*     */ 
/*     */     
/*  75 */     if (this.chars[this.pos] == ' ') {
/*  76 */       for (; this.pos < this.length && this.chars[this.pos] != '=' && this.chars[this.pos] == ' '; this.pos++);
/*     */ 
/*     */       
/*  79 */       if (this.chars[this.pos] != '=' || this.pos == this.length) {
/*  80 */         throw new IllegalStateException("Unexpected end of DN: " + this.jc);
/*     */       }
/*     */     } 
/*     */     
/*  84 */     this.pos++;
/*     */ 
/*     */ 
/*     */     
/*  88 */     for (; this.pos < this.length && this.chars[this.pos] == ' '; this.pos++);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  93 */     if (this.end - this.gV > 4 && this.chars[this.gV + 3] == '.' && (this.chars[this.gV] == 'O' || this.chars[this.gV] == 'o') && (this.chars[this.gV + 1] == 'I' || this.chars[this.gV + 1] == 'i') && (this.chars[this.gV + 2] == 'D' || this.chars[this.gV + 2] == 'd'))
/*     */     {
/*     */ 
/*     */       
/*  97 */       this.gV += 4;
/*     */     }
/*     */     
/* 100 */     return new String(this.chars, this.gV, this.end - this.gV);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private String dF() {
/* 106 */     this.gV = ++this.pos;
/* 107 */     this.end = this.gV;
/*     */     
/*     */     while (true) {
/* 110 */       if (this.pos == this.length) {
/* 111 */         throw new IllegalStateException("Unexpected end of DN: " + this.jc);
/*     */       }
/*     */       
/* 114 */       if (this.chars[this.pos] == '"') {
/*     */         
/* 116 */         this.pos++; break;
/*     */       } 
/* 118 */       if (this.chars[this.pos] == '\\') {
/* 119 */         this.chars[this.end] = d();
/*     */       } else {
/*     */         
/* 122 */         this.chars[this.end] = this.chars[this.pos];
/*     */       } 
/* 124 */       this.pos++;
/* 125 */       this.end++;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 130 */     for (; this.pos < this.length && this.chars[this.pos] == ' '; this.pos++);
/*     */ 
/*     */     
/* 133 */     return new String(this.chars, this.gV, this.end - this.gV);
/*     */   }
/*     */ 
/*     */   
/*     */   private String dG() {
/* 138 */     if (this.pos + 4 >= this.length)
/*     */     {
/* 140 */       throw new IllegalStateException("Unexpected end of DN: " + this.jc);
/*     */     }
/*     */     
/* 143 */     this.gV = this.pos;
/* 144 */     this.pos++;
/*     */ 
/*     */ 
/*     */     
/*     */     while (true) {
/* 149 */       if (this.pos == this.length || this.chars[this.pos] == '+' || this.chars[this.pos] == ',' || this.chars[this.pos] == ';') {
/*     */         
/* 151 */         this.end = this.pos;
/*     */         
/*     */         break;
/*     */       } 
/* 155 */       if (this.chars[this.pos] == ' ') {
/* 156 */         this.end = this.pos;
/* 157 */         this.pos++;
/*     */ 
/*     */         
/* 160 */         for (; this.pos < this.length && this.chars[this.pos] == ' '; this.pos++);
/*     */         break;
/*     */       } 
/* 163 */       if (this.chars[this.pos] >= 'A' && this.chars[this.pos] <= 'F') {
/* 164 */         this.chars[this.pos] = (char)(this.chars[this.pos] + 32);
/*     */       }
/*     */       
/* 167 */       this.pos++;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 172 */     int i = this.end - this.gV;
/* 173 */     if (i < 5 || (i & 0x1) == 0) {
/* 174 */       throw new IllegalStateException("Unexpected end of DN: " + this.jc);
/*     */     }
/*     */ 
/*     */     
/* 178 */     byte[] arrayOfByte = new byte[i / 2]; byte b; int k;
/* 179 */     for (b = 0, k = this.gV + 1; b < arrayOfByte.length; k += 2, b++) {
/* 180 */       arrayOfByte[b] = (byte)getByte(k);
/*     */     }
/*     */     
/* 183 */     return new String(this.chars, this.gV, i);
/*     */   }
/*     */ 
/*     */   
/*     */   private String dH() {
/* 188 */     this.gV = this.pos;
/* 189 */     this.end = this.pos;
/*     */     while (true) {
/* 191 */       if (this.pos >= this.length)
/*     */       {
/* 193 */         return new String(this.chars, this.gV, this.end - this.gV);
/*     */       }
/*     */       
/* 196 */       switch (this.chars[this.pos]) {
/*     */         
/*     */         case '+':
/*     */         case ',':
/*     */         case ';':
/* 201 */           return new String(this.chars, this.gV, this.end - this.gV);
/*     */         
/*     */         case '\\':
/* 204 */           this.chars[this.end++] = d();
/* 205 */           this.pos++;
/*     */           continue;
/*     */ 
/*     */         
/*     */         case ' ':
/* 210 */           this.gW = this.end;
/*     */           
/* 212 */           this.pos++;
/* 213 */           this.chars[this.end++] = ' ';
/*     */           
/* 215 */           for (; this.pos < this.length && this.chars[this.pos] == ' '; this.pos++) {
/* 216 */             this.chars[this.end++] = ' ';
/*     */           }
/* 218 */           if (this.pos == this.length || this.chars[this.pos] == ',' || this.chars[this.pos] == '+' || this.chars[this.pos] == ';')
/*     */           {
/*     */             
/* 221 */             return new String(this.chars, this.gV, this.gW - this.gV);
/*     */           }
/*     */           continue;
/*     */       } 
/* 225 */       this.chars[this.end++] = this.chars[this.pos];
/* 226 */       this.pos++;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private char d() {
/* 233 */     this.pos++;
/* 234 */     if (this.pos == this.length) {
/* 235 */       throw new IllegalStateException("Unexpected end of DN: " + this.jc);
/*     */     }
/*     */     
/* 238 */     switch (this.chars[this.pos]) {
/*     */       
/*     */       case ' ':
/*     */       case '"':
/*     */       case '#':
/*     */       case '%':
/*     */       case '*':
/*     */       case '+':
/*     */       case ',':
/*     */       case ';':
/*     */       case '<':
/*     */       case '=':
/*     */       case '>':
/*     */       case '\\':
/*     */       case '_':
/* 253 */         return this.chars[this.pos];
/*     */     } 
/*     */ 
/*     */     
/* 257 */     return e();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private char e() {
/* 264 */     int i = getByte(this.pos);
/* 265 */     this.pos++;
/*     */     
/* 267 */     if (i < 128)
/* 268 */       return (char)i; 
/* 269 */     if (i >= 192 && i <= 247) {
/*     */       byte b1;
/*     */       
/* 272 */       if (i <= 223) {
/* 273 */         b1 = 1;
/* 274 */         i &= 0x1F;
/* 275 */       } else if (i <= 239) {
/* 276 */         b1 = 2;
/* 277 */         i &= 0xF;
/*     */       } else {
/* 279 */         b1 = 3;
/* 280 */         i &= 0x7;
/*     */       } 
/*     */ 
/*     */       
/* 284 */       for (byte b2 = 0; b2 < b1; b2++) {
/* 285 */         this.pos++;
/* 286 */         if (this.pos == this.length || this.chars[this.pos] != '\\') {
/* 287 */           return '?';
/*     */         }
/* 289 */         this.pos++;
/*     */         
/* 291 */         int k = getByte(this.pos);
/* 292 */         this.pos++;
/* 293 */         if ((k & 0xC0) != 128) {
/* 294 */           return '?';
/*     */         }
/*     */         
/* 297 */         i = (i << 6) + (k & 0x3F);
/*     */       } 
/* 299 */       return (char)i;
/*     */     } 
/* 301 */     return '?';
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int getByte(int paramInt) {
/* 312 */     if (paramInt + 1 >= this.length) {
/* 313 */       throw new IllegalStateException("Malformed DN: " + this.jc);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 318 */     int i = this.chars[paramInt];
/* 319 */     if (i >= 48 && i <= 57) {
/* 320 */       i = i - 48;
/* 321 */     } else if (i >= 97 && i <= 102) {
/* 322 */       i -= 87;
/* 323 */     } else if (i >= 65 && i <= 70) {
/* 324 */       i -= 55;
/*     */     } else {
/* 326 */       throw new IllegalStateException("Malformed DN: " + this.jc);
/*     */     } 
/*     */     
/* 329 */     int k = this.chars[paramInt + 1];
/* 330 */     if (k >= 48 && k <= 57) {
/* 331 */       k = k - 48;
/* 332 */     } else if (k >= 97 && k <= 102) {
/* 333 */       k -= 87;
/* 334 */     } else if (k >= 65 && k <= 70) {
/* 335 */       k -= 55;
/*     */     } else {
/* 337 */       throw new IllegalStateException("Malformed DN: " + this.jc);
/*     */     } 
/*     */     
/* 340 */     return (i << 4) + k;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String ay(String paramString) {
/* 351 */     this.pos = 0;
/* 352 */     this.gV = 0;
/* 353 */     this.end = 0;
/* 354 */     this.gW = 0;
/* 355 */     this.chars = this.jc.toCharArray();
/*     */     
/* 357 */     String str = dE();
/* 358 */     if (str == null) {
/* 359 */       return null;
/*     */     }
/*     */     while (true) {
/* 362 */       String str1 = "";
/*     */       
/* 364 */       if (this.pos == this.length) {
/* 365 */         return null;
/*     */       }
/*     */       
/* 368 */       switch (this.chars[this.pos]) {
/*     */         case '"':
/* 370 */           str1 = dF();
/*     */           break;
/*     */         case '#':
/* 373 */           str1 = dG();
/*     */           break;
/*     */         
/*     */         case '+':
/*     */         case ',':
/*     */         case ';':
/*     */           break;
/*     */         default:
/* 381 */           str1 = dH();
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 387 */       if (paramString.equalsIgnoreCase(str)) {
/* 388 */         return str1;
/*     */       }
/*     */       
/* 391 */       if (this.pos >= this.length) {
/* 392 */         return null;
/*     */       }
/*     */       
/* 395 */       if (this.chars[this.pos] != ',' && this.chars[this.pos] != ';' && 
/* 396 */         this.chars[this.pos] != '+') {
/* 397 */         throw new IllegalStateException("Malformed DN: " + this.jc);
/*     */       }
/*     */       
/* 400 */       this.pos++;
/* 401 */       str = dE();
/* 402 */       if (str == null)
/* 403 */         throw new IllegalStateException("Malformed DN: " + this.jc); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\b\a\a\j.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */