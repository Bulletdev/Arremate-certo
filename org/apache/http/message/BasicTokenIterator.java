/*     */ package org.apache.http.message;
/*     */ 
/*     */ import java.util.NoSuchElementException;
/*     */ import org.apache.http.HeaderIterator;
/*     */ import org.apache.http.ParseException;
/*     */ import org.apache.http.TokenIterator;
/*     */ import org.apache.http.util.Args;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BasicTokenIterator
/*     */   implements TokenIterator
/*     */ {
/*     */   public static final String HTTP_SEPARATORS = " ,;=()<>@:\\\"/[]?{}\t";
/*     */   protected final HeaderIterator headerIt;
/*     */   protected String currentHeader;
/*     */   protected String currentToken;
/*     */   protected int searchPos;
/*     */   
/*     */   public BasicTokenIterator(HeaderIterator paramHeaderIterator) {
/*  83 */     this.headerIt = (HeaderIterator)Args.notNull(paramHeaderIterator, "Header iterator");
/*  84 */     this.searchPos = findNext(-1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasNext() {
/*  91 */     return (this.currentToken != null);
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
/*     */   public String nextToken() throws NoSuchElementException, ParseException {
/* 107 */     if (this.currentToken == null) {
/* 108 */       throw new NoSuchElementException("Iteration already finished.");
/*     */     }
/*     */     
/* 111 */     String str = this.currentToken;
/*     */     
/* 113 */     this.searchPos = findNext(this.searchPos);
/*     */     
/* 115 */     return str;
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
/*     */   public final Object next() throws NoSuchElementException, ParseException {
/* 131 */     return nextToken();
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
/*     */   public final void remove() throws UnsupportedOperationException {
/* 144 */     throw new UnsupportedOperationException("Removing tokens is not supported.");
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
/*     */   protected int findNext(int paramInt) throws ParseException {
/* 166 */     int i = paramInt;
/* 167 */     if (i < 0) {
/*     */       
/* 169 */       if (!this.headerIt.hasNext()) {
/* 170 */         return -1;
/*     */       }
/* 172 */       this.currentHeader = this.headerIt.nextHeader().getValue();
/* 173 */       i = 0;
/*     */     } else {
/*     */       
/* 176 */       i = findTokenSeparator(i);
/*     */     } 
/*     */     
/* 179 */     int j = findTokenStart(i);
/* 180 */     if (j < 0) {
/* 181 */       this.currentToken = null;
/* 182 */       return -1;
/*     */     } 
/*     */     
/* 185 */     int k = findTokenEnd(j);
/* 186 */     this.currentToken = createToken(this.currentHeader, j, k);
/* 187 */     return k;
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
/*     */   protected String createToken(String paramString, int paramInt1, int paramInt2) {
/* 213 */     return paramString.substring(paramInt1, paramInt2);
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
/*     */   protected int findTokenStart(int paramInt) {
/* 228 */     int i = Args.notNegative(paramInt, "Search position");
/* 229 */     boolean bool = false;
/* 230 */     while (!bool && this.currentHeader != null) {
/*     */       
/* 232 */       int j = this.currentHeader.length();
/* 233 */       while (!bool && i < j) {
/*     */         
/* 235 */         char c = this.currentHeader.charAt(i);
/* 236 */         if (isTokenSeparator(c) || isWhitespace(c)) {
/*     */           
/* 238 */           i++; continue;
/* 239 */         }  if (isTokenChar(this.currentHeader.charAt(i))) {
/*     */           
/* 241 */           bool = true; continue;
/*     */         } 
/* 243 */         throw new ParseException("Invalid character before token (pos " + i + "): " + this.currentHeader);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 248 */       if (!bool) {
/* 249 */         if (this.headerIt.hasNext()) {
/* 250 */           this.currentHeader = this.headerIt.nextHeader().getValue();
/* 251 */           i = 0; continue;
/*     */         } 
/* 253 */         this.currentHeader = null;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 258 */     return bool ? i : -1;
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
/*     */   protected int findTokenSeparator(int paramInt) {
/* 280 */     int i = Args.notNegative(paramInt, "Search position");
/* 281 */     boolean bool = false;
/* 282 */     int j = this.currentHeader.length();
/* 283 */     while (!bool && i < j) {
/* 284 */       char c = this.currentHeader.charAt(i);
/* 285 */       if (isTokenSeparator(c)) {
/* 286 */         bool = true; continue;
/* 287 */       }  if (isWhitespace(c)) {
/* 288 */         i++; continue;
/* 289 */       }  if (isTokenChar(c)) {
/* 290 */         throw new ParseException("Tokens without separator (pos " + i + "): " + this.currentHeader);
/*     */       }
/*     */ 
/*     */       
/* 294 */       throw new ParseException("Invalid character after token (pos " + i + "): " + this.currentHeader);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 300 */     return i;
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
/*     */   protected int findTokenEnd(int paramInt) {
/* 316 */     Args.notNegative(paramInt, "Search position");
/* 317 */     int i = this.currentHeader.length();
/* 318 */     int j = paramInt + 1;
/* 319 */     while (j < i && isTokenChar(this.currentHeader.charAt(j))) {
/* 320 */       j++;
/*     */     }
/*     */     
/* 323 */     return j;
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
/*     */   protected boolean isTokenSeparator(char paramChar) {
/* 339 */     return (paramChar == ',');
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
/*     */   protected boolean isWhitespace(char paramChar) {
/* 358 */     return (paramChar == '\t' || Character.isSpaceChar(paramChar));
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
/*     */   protected boolean isTokenChar(char paramChar) {
/* 377 */     if (Character.isLetterOrDigit(paramChar)) {
/* 378 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 382 */     if (Character.isISOControl(paramChar)) {
/* 383 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 387 */     if (isHttpSeparator(paramChar)) {
/* 388 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 397 */     return true;
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
/*     */   protected boolean isHttpSeparator(char paramChar) {
/* 412 */     return (" ,;=()<>@:\\\"/[]?{}\t".indexOf(paramChar) >= 0);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\message\BasicTokenIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */