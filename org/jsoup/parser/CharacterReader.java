/*     */ package org.jsoup.parser;
/*     */ 
/*     */ import java.util.Locale;
/*     */ import org.jsoup.helper.Validate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CharacterReader
/*     */ {
/*     */   static final char EOF = '￿';
/*     */   private final char[] input;
/*     */   private final int length;
/*  15 */   private int pos = 0;
/*  16 */   private int mark = 0;
/*     */   
/*     */   CharacterReader(String paramString) {
/*  19 */     Validate.notNull(paramString);
/*  20 */     this.input = paramString.toCharArray();
/*  21 */     this.length = this.input.length;
/*     */   }
/*     */   
/*     */   int pos() {
/*  25 */     return this.pos;
/*     */   }
/*     */   
/*     */   boolean isEmpty() {
/*  29 */     return (this.pos >= this.length);
/*     */   }
/*     */   
/*     */   char current() {
/*  33 */     return (this.pos >= this.length) ? Character.MAX_VALUE : this.input[this.pos];
/*     */   }
/*     */   
/*     */   char consume() {
/*  37 */     boolean bool = (this.pos >= this.length) ? true : this.input[this.pos];
/*  38 */     this.pos++;
/*  39 */     return bool;
/*     */   }
/*     */   
/*     */   void unconsume() {
/*  43 */     this.pos--;
/*     */   }
/*     */   
/*     */   void advance() {
/*  47 */     this.pos++;
/*     */   }
/*     */   
/*     */   void mark() {
/*  51 */     this.mark = this.pos;
/*     */   }
/*     */   
/*     */   void rewindToMark() {
/*  55 */     this.pos = this.mark;
/*     */   }
/*     */   
/*     */   String consumeAsString() {
/*  59 */     return new String(this.input, this.pos++, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int nextIndexOf(char paramChar) {
/*  69 */     for (int i = this.pos; i < this.length; i++) {
/*  70 */       if (paramChar == this.input[i])
/*  71 */         return i - this.pos; 
/*     */     } 
/*  73 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int nextIndexOf(CharSequence paramCharSequence) {
/*  84 */     char c = paramCharSequence.charAt(0);
/*  85 */     for (int i = this.pos; i < this.length; i++) {
/*     */       
/*  87 */       if (c != this.input[i])
/*  88 */         while (++i < this.length && c != this.input[i]); 
/*  89 */       int j = i + 1;
/*  90 */       int k = j + paramCharSequence.length() - 1;
/*  91 */       if (i < this.length && k <= this.length) {
/*  92 */         for (byte b = 1; j < k && paramCharSequence.charAt(b) == this.input[j]; ) { j++; b++; }
/*  93 */          if (j == k)
/*  94 */           return i - this.pos; 
/*     */       } 
/*     */     } 
/*  97 */     return -1;
/*     */   }
/*     */   
/*     */   String consumeTo(char paramChar) {
/* 101 */     int i = nextIndexOf(paramChar);
/* 102 */     if (i != -1) {
/* 103 */       String str = new String(this.input, this.pos, i);
/* 104 */       this.pos += i;
/* 105 */       return str;
/*     */     } 
/* 107 */     return consumeToEnd();
/*     */   }
/*     */ 
/*     */   
/*     */   String consumeTo(String paramString) {
/* 112 */     int i = nextIndexOf(paramString);
/* 113 */     if (i != -1) {
/* 114 */       String str = new String(this.input, this.pos, i);
/* 115 */       this.pos += i;
/* 116 */       return str;
/*     */     } 
/* 118 */     return consumeToEnd();
/*     */   }
/*     */ 
/*     */   
/*     */   String consumeToAny(char... paramVarArgs) {
/* 123 */     int i = this.pos;
/*     */     
/* 125 */     label18: while (this.pos < this.length) {
/* 126 */       for (byte b = 0; b < paramVarArgs.length; b++) {
/* 127 */         if (this.input[this.pos] == paramVarArgs[b])
/*     */           break label18; 
/*     */       } 
/* 130 */       this.pos++;
/*     */     } 
/*     */     
/* 133 */     return (this.pos > i) ? new String(this.input, i, this.pos - i) : "";
/*     */   }
/*     */   
/*     */   String consumeToEnd() {
/* 137 */     String str = new String(this.input, this.pos, this.length - this.pos);
/* 138 */     this.pos = this.length;
/* 139 */     return str;
/*     */   }
/*     */   
/*     */   String consumeLetterSequence() {
/* 143 */     int i = this.pos;
/* 144 */     while (this.pos < this.length) {
/* 145 */       char c = this.input[this.pos];
/* 146 */       if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
/* 147 */         this.pos++;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 152 */     return new String(this.input, i, this.pos - i);
/*     */   }
/*     */   
/*     */   String consumeLetterThenDigitSequence() {
/* 156 */     int i = this.pos;
/* 157 */     while (this.pos < this.length) {
/* 158 */       char c = this.input[this.pos];
/* 159 */       if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
/* 160 */         this.pos++;
/*     */       }
/*     */     } 
/*     */     
/* 164 */     while (!isEmpty()) {
/* 165 */       char c = this.input[this.pos];
/* 166 */       if (c >= '0' && c <= '9') {
/* 167 */         this.pos++;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 172 */     return new String(this.input, i, this.pos - i);
/*     */   }
/*     */   
/*     */   String consumeHexSequence() {
/* 176 */     int i = this.pos;
/* 177 */     while (this.pos < this.length) {
/* 178 */       char c = this.input[this.pos];
/* 179 */       if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f')) {
/* 180 */         this.pos++;
/*     */       }
/*     */     } 
/*     */     
/* 184 */     return new String(this.input, i, this.pos - i);
/*     */   }
/*     */   
/*     */   String consumeDigitSequence() {
/* 188 */     int i = this.pos;
/* 189 */     while (this.pos < this.length) {
/* 190 */       char c = this.input[this.pos];
/* 191 */       if (c >= '0' && c <= '9') {
/* 192 */         this.pos++;
/*     */       }
/*     */     } 
/*     */     
/* 196 */     return new String(this.input, i, this.pos - i);
/*     */   }
/*     */   
/*     */   boolean matches(char paramChar) {
/* 200 */     return (!isEmpty() && this.input[this.pos] == paramChar);
/*     */   }
/*     */ 
/*     */   
/*     */   boolean matches(String paramString) {
/* 205 */     int i = paramString.length();
/* 206 */     if (i > this.length - this.pos) {
/* 207 */       return false;
/*     */     }
/* 209 */     for (byte b = 0; b < i; b++) {
/* 210 */       if (paramString.charAt(b) != this.input[this.pos + b])
/* 211 */         return false; 
/* 212 */     }  return true;
/*     */   }
/*     */   
/*     */   boolean matchesIgnoreCase(String paramString) {
/* 216 */     int i = paramString.length();
/* 217 */     if (i > this.length - this.pos) {
/* 218 */       return false;
/*     */     }
/* 220 */     for (byte b = 0; b < i; b++) {
/* 221 */       char c1 = Character.toUpperCase(paramString.charAt(b));
/* 222 */       char c2 = Character.toUpperCase(this.input[this.pos + b]);
/* 223 */       if (c1 != c2)
/* 224 */         return false; 
/*     */     } 
/* 226 */     return true;
/*     */   }
/*     */   
/*     */   boolean matchesAny(char... paramVarArgs) {
/* 230 */     if (isEmpty()) {
/* 231 */       return false;
/*     */     }
/* 233 */     char c = this.input[this.pos];
/* 234 */     for (char c1 : paramVarArgs) {
/* 235 */       if (c1 == c)
/* 236 */         return true; 
/*     */     } 
/* 238 */     return false;
/*     */   }
/*     */   
/*     */   boolean matchesLetter() {
/* 242 */     if (isEmpty())
/* 243 */       return false; 
/* 244 */     char c = this.input[this.pos];
/* 245 */     return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
/*     */   }
/*     */   
/*     */   boolean matchesDigit() {
/* 249 */     if (isEmpty())
/* 250 */       return false; 
/* 251 */     char c = this.input[this.pos];
/* 252 */     return (c >= '0' && c <= '9');
/*     */   }
/*     */   
/*     */   boolean matchConsume(String paramString) {
/* 256 */     if (matches(paramString)) {
/* 257 */       this.pos += paramString.length();
/* 258 */       return true;
/*     */     } 
/* 260 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean matchConsumeIgnoreCase(String paramString) {
/* 265 */     if (matchesIgnoreCase(paramString)) {
/* 266 */       this.pos += paramString.length();
/* 267 */       return true;
/*     */     } 
/* 269 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   boolean containsIgnoreCase(String paramString) {
/* 275 */     String str1 = paramString.toLowerCase(Locale.ENGLISH);
/* 276 */     String str2 = paramString.toUpperCase(Locale.ENGLISH);
/* 277 */     return (nextIndexOf(str1) > -1 || nextIndexOf(str2) > -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 282 */     return new String(this.input, this.pos, this.length - this.pos);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\parser\CharacterReader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */