/*     */ package org.jsoup.parser;
/*     */ 
/*     */ import org.jsoup.helper.StringUtil;
/*     */ import org.jsoup.helper.Validate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TokenQueue
/*     */ {
/*     */   private String queue;
/*  13 */   private int pos = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   private static final char ESC = '\\';
/*     */ 
/*     */ 
/*     */   
/*     */   public TokenQueue(String paramString) {
/*  22 */     Validate.notNull(paramString);
/*  23 */     this.queue = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/*  31 */     return (remainingLength() == 0);
/*     */   }
/*     */   
/*     */   private int remainingLength() {
/*  35 */     return this.queue.length() - this.pos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char peek() {
/*  43 */     return isEmpty() ? Character.MIN_VALUE : this.queue.charAt(this.pos);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addFirst(Character paramCharacter) {
/*  51 */     addFirst(paramCharacter.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addFirst(String paramString) {
/*  60 */     this.queue = paramString + this.queue.substring(this.pos);
/*  61 */     this.pos = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matches(String paramString) {
/*  70 */     return this.queue.regionMatches(true, this.pos, paramString, 0, paramString.length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matchesCS(String paramString) {
/*  79 */     return this.queue.startsWith(paramString, this.pos);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matchesAny(String... paramVarArgs) {
/*  89 */     for (String str : paramVarArgs) {
/*  90 */       if (matches(str))
/*  91 */         return true; 
/*     */     } 
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public boolean matchesAny(char... paramVarArgs) {
/*  97 */     if (isEmpty()) {
/*  98 */       return false;
/*     */     }
/* 100 */     for (char c : paramVarArgs) {
/* 101 */       if (this.queue.charAt(this.pos) == c)
/* 102 */         return true; 
/*     */     } 
/* 104 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean matchesStartTag() {
/* 109 */     return (remainingLength() >= 2 && this.queue.charAt(this.pos) == '<' && Character.isLetter(this.queue.charAt(this.pos + 1)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matchChomp(String paramString) {
/* 119 */     if (matches(paramString)) {
/* 120 */       this.pos += paramString.length();
/* 121 */       return true;
/*     */     } 
/* 123 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matchesWhitespace() {
/* 132 */     return (!isEmpty() && StringUtil.isWhitespace(this.queue.charAt(this.pos)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matchesWord() {
/* 140 */     return (!isEmpty() && Character.isLetterOrDigit(this.queue.charAt(this.pos)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void advance() {
/* 147 */     if (!isEmpty()) this.pos++;
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char consume() {
/* 155 */     return this.queue.charAt(this.pos++);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void consume(String paramString) {
/* 166 */     if (!matches(paramString))
/* 167 */       throw new IllegalStateException("Queue did not match expected sequence"); 
/* 168 */     int i = paramString.length();
/* 169 */     if (i > remainingLength()) {
/* 170 */       throw new IllegalStateException("Queue not long enough to consume sequence");
/*     */     }
/* 172 */     this.pos += i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String consumeTo(String paramString) {
/* 181 */     int i = this.queue.indexOf(paramString, this.pos);
/* 182 */     if (i != -1) {
/* 183 */       String str = this.queue.substring(this.pos, i);
/* 184 */       this.pos += str.length();
/* 185 */       return str;
/*     */     } 
/* 187 */     return remainder();
/*     */   }
/*     */ 
/*     */   
/*     */   public String consumeToIgnoreCase(String paramString) {
/* 192 */     int i = this.pos;
/* 193 */     String str = paramString.substring(0, 1);
/* 194 */     boolean bool = str.toLowerCase().equals(str.toUpperCase());
/* 195 */     while (!isEmpty() && 
/* 196 */       !matches(paramString)) {
/*     */ 
/*     */       
/* 199 */       if (bool) {
/* 200 */         int j = this.queue.indexOf(str, this.pos) - this.pos;
/* 201 */         if (j == 0) {
/* 202 */           this.pos++; continue;
/* 203 */         }  if (j < 0) {
/* 204 */           this.pos = this.queue.length(); continue;
/*     */         } 
/* 206 */         this.pos += j;
/*     */         continue;
/*     */       } 
/* 209 */       this.pos++;
/*     */     } 
/*     */     
/* 212 */     return this.queue.substring(i, this.pos);
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
/*     */   public String consumeToAny(String... paramVarArgs) {
/* 224 */     int i = this.pos;
/* 225 */     while (!isEmpty() && !matchesAny(paramVarArgs)) {
/* 226 */       this.pos++;
/*     */     }
/*     */     
/* 229 */     return this.queue.substring(i, this.pos);
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
/*     */   public String chompTo(String paramString) {
/* 242 */     String str = consumeTo(paramString);
/* 243 */     matchChomp(paramString);
/* 244 */     return str;
/*     */   }
/*     */   
/*     */   public String chompToIgnoreCase(String paramString) {
/* 248 */     String str = consumeToIgnoreCase(paramString);
/* 249 */     matchChomp(paramString);
/* 250 */     return str;
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
/*     */   public String chompBalanced(char paramChar1, char paramChar2) {
/* 263 */     int i = -1;
/* 264 */     int j = -1;
/* 265 */     byte b = 0;
/* 266 */     char c = Character.MIN_VALUE;
/*     */ 
/*     */     
/* 269 */     while (!isEmpty())
/* 270 */     { Character character = Character.valueOf(consume());
/* 271 */       if (!c || c != '\\') {
/* 272 */         if (character.equals(Character.valueOf(paramChar1))) {
/* 273 */           b++;
/* 274 */           if (i == -1) {
/* 275 */             i = this.pos;
/*     */           }
/* 277 */         } else if (character.equals(Character.valueOf(paramChar2))) {
/* 278 */           b--;
/*     */         } 
/*     */       }
/* 281 */       if (b > 0 && c)
/* 282 */         j = this.pos; 
/* 283 */       c = character.charValue();
/* 284 */       if (b <= 0)
/* 285 */         break;  }  return (j >= 0) ? this.queue.substring(i, j) : "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String unescape(String paramString) {
/* 294 */     StringBuilder stringBuilder = new StringBuilder();
/* 295 */     char c = Character.MIN_VALUE;
/* 296 */     for (char c1 : paramString.toCharArray()) {
/* 297 */       if (c1 == '\\') {
/* 298 */         if (c && c == '\\') {
/* 299 */           stringBuilder.append(c1);
/*     */         }
/*     */       } else {
/* 302 */         stringBuilder.append(c1);
/* 303 */       }  c = c1;
/*     */     } 
/* 305 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean consumeWhitespace() {
/* 312 */     boolean bool = false;
/* 313 */     while (matchesWhitespace()) {
/* 314 */       this.pos++;
/* 315 */       bool = true;
/*     */     } 
/* 317 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String consumeWord() {
/* 325 */     int i = this.pos;
/* 326 */     while (matchesWord())
/* 327 */       this.pos++; 
/* 328 */     return this.queue.substring(i, this.pos);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String consumeTagName() {
/* 337 */     int i = this.pos;
/* 338 */     while (!isEmpty() && (matchesWord() || matchesAny(new char[] { ':', '_', '-' }))) {
/* 339 */       this.pos++;
/*     */     }
/* 341 */     return this.queue.substring(i, this.pos);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String consumeElementSelector() {
/* 350 */     int i = this.pos;
/* 351 */     while (!isEmpty() && (matchesWord() || matchesAny(new char[] { '|', '_', '-' }))) {
/* 352 */       this.pos++;
/*     */     }
/* 354 */     return this.queue.substring(i, this.pos);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String consumeCssIdentifier() {
/* 363 */     int i = this.pos;
/* 364 */     while (!isEmpty() && (matchesWord() || matchesAny(new char[] { '-', '_' }))) {
/* 365 */       this.pos++;
/*     */     }
/* 367 */     return this.queue.substring(i, this.pos);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String consumeAttributeKey() {
/* 375 */     int i = this.pos;
/* 376 */     while (!isEmpty() && (matchesWord() || matchesAny(new char[] { '-', '_', ':' }))) {
/* 377 */       this.pos++;
/*     */     }
/* 379 */     return this.queue.substring(i, this.pos);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String remainder() {
/* 387 */     String str = this.queue.substring(this.pos, this.queue.length());
/* 388 */     this.pos = this.queue.length();
/* 389 */     return str;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 393 */     return this.queue.substring(this.pos);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\parser\TokenQueue.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */