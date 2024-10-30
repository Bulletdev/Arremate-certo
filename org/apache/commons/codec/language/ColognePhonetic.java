/*     */ package org.apache.commons.codec.language;
/*     */ 
/*     */ import java.util.Locale;
/*     */ import org.apache.commons.codec.EncoderException;
/*     */ import org.apache.commons.codec.StringEncoder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ColognePhonetic
/*     */   implements StringEncoder
/*     */ {
/* 185 */   private static final char[] AEIJOUY = new char[] { 'A', 'E', 'I', 'J', 'O', 'U', 'Y' };
/* 186 */   private static final char[] CSZ = new char[] { 'C', 'S', 'Z' };
/* 187 */   private static final char[] FPVW = new char[] { 'F', 'P', 'V', 'W' };
/* 188 */   private static final char[] GKQ = new char[] { 'G', 'K', 'Q' };
/* 189 */   private static final char[] CKQ = new char[] { 'C', 'K', 'Q' };
/* 190 */   private static final char[] AHKLOQRUX = new char[] { 'A', 'H', 'K', 'L', 'O', 'Q', 'R', 'U', 'X' };
/* 191 */   private static final char[] SZ = new char[] { 'S', 'Z' };
/* 192 */   private static final char[] AHKOQUX = new char[] { 'A', 'H', 'K', 'O', 'Q', 'U', 'X' };
/* 193 */   private static final char[] DTX = new char[] { 'D', 'T', 'X' };
/*     */ 
/*     */ 
/*     */   
/*     */   private static final char CHAR_IGNORE = '-';
/*     */ 
/*     */ 
/*     */   
/*     */   private abstract class CologneBuffer
/*     */   {
/*     */     protected final char[] data;
/*     */ 
/*     */     
/* 206 */     protected int length = 0;
/*     */     
/*     */     public CologneBuffer(char[] param1ArrayOfchar) {
/* 209 */       this.data = param1ArrayOfchar;
/* 210 */       this.length = param1ArrayOfchar.length;
/*     */     }
/*     */     
/*     */     public CologneBuffer(int param1Int) {
/* 214 */       this.data = new char[param1Int];
/* 215 */       this.length = 0;
/*     */     }
/*     */     
/*     */     protected abstract char[] copyData(int param1Int1, int param1Int2);
/*     */     
/*     */     public int length() {
/* 221 */       return this.length;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 226 */       return new String(copyData(0, this.length));
/*     */     }
/*     */   }
/*     */   
/*     */   private class CologneOutputBuffer
/*     */     extends CologneBuffer {
/*     */     private char lastCode;
/*     */     
/*     */     public CologneOutputBuffer(int param1Int) {
/* 235 */       super(param1Int);
/* 236 */       this.lastCode = '/';
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
/*     */     public void put(char param1Char) {
/* 248 */       if (param1Char != '-' && this.lastCode != param1Char && (param1Char != '0' || this.length == 0)) {
/* 249 */         this.data[this.length] = param1Char;
/* 250 */         this.length++;
/*     */       } 
/* 252 */       this.lastCode = param1Char;
/*     */     }
/*     */ 
/*     */     
/*     */     protected char[] copyData(int param1Int1, int param1Int2) {
/* 257 */       char[] arrayOfChar = new char[param1Int2];
/* 258 */       System.arraycopy(this.data, param1Int1, arrayOfChar, 0, param1Int2);
/* 259 */       return arrayOfChar;
/*     */     }
/*     */   }
/*     */   
/*     */   private class CologneInputBuffer
/*     */     extends CologneBuffer {
/*     */     public CologneInputBuffer(char[] param1ArrayOfchar) {
/* 266 */       super(param1ArrayOfchar);
/*     */     }
/*     */ 
/*     */     
/*     */     protected char[] copyData(int param1Int1, int param1Int2) {
/* 271 */       char[] arrayOfChar = new char[param1Int2];
/* 272 */       System.arraycopy(this.data, this.data.length - this.length + param1Int1, arrayOfChar, 0, param1Int2);
/* 273 */       return arrayOfChar;
/*     */     }
/*     */     
/*     */     public char getNextChar() {
/* 277 */       return this.data[getNextPos()];
/*     */     }
/*     */     
/*     */     protected int getNextPos() {
/* 281 */       return this.data.length - this.length;
/*     */     }
/*     */     
/*     */     public char removeNext() {
/* 285 */       char c = getNextChar();
/* 286 */       this.length--;
/* 287 */       return c;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean arrayContains(char[] paramArrayOfchar, char paramChar) {
/* 295 */     for (char c : paramArrayOfchar) {
/* 296 */       if (c == paramChar) {
/* 297 */         return true;
/*     */       }
/*     */     } 
/* 300 */     return false;
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
/*     */   public String colognePhonetic(String paramString) {
/* 315 */     if (paramString == null) {
/* 316 */       return null;
/*     */     }
/*     */     
/* 319 */     CologneInputBuffer cologneInputBuffer = new CologneInputBuffer(preprocess(paramString));
/* 320 */     CologneOutputBuffer cologneOutputBuffer = new CologneOutputBuffer(cologneInputBuffer.length() * 2);
/*     */ 
/*     */ 
/*     */     
/* 324 */     char c = '-';
/*     */ 
/*     */     
/* 327 */     while (cologneInputBuffer.length() > 0) {
/* 328 */       byte b; char c1 = cologneInputBuffer.removeNext();
/*     */       
/* 330 */       if (cologneInputBuffer.length() > 0) {
/* 331 */         b = cologneInputBuffer.getNextChar();
/*     */       } else {
/* 333 */         b = 45;
/*     */       } 
/*     */       
/* 336 */       if (c1 < 'A' || c1 > 'Z') {
/*     */         continue;
/*     */       }
/*     */       
/* 340 */       if (arrayContains(AEIJOUY, c1)) {
/* 341 */         cologneOutputBuffer.put('0');
/* 342 */       } else if (c1 == 'B' || (c1 == 'P' && b != 72)) {
/* 343 */         cologneOutputBuffer.put('1');
/* 344 */       } else if ((c1 == 'D' || c1 == 'T') && !arrayContains(CSZ, b)) {
/* 345 */         cologneOutputBuffer.put('2');
/* 346 */       } else if (arrayContains(FPVW, c1)) {
/* 347 */         cologneOutputBuffer.put('3');
/* 348 */       } else if (arrayContains(GKQ, c1)) {
/* 349 */         cologneOutputBuffer.put('4');
/* 350 */       } else if (c1 == 'X' && !arrayContains(CKQ, c)) {
/* 351 */         cologneOutputBuffer.put('4');
/* 352 */         cologneOutputBuffer.put('8');
/* 353 */       } else if (c1 == 'S' || c1 == 'Z') {
/* 354 */         cologneOutputBuffer.put('8');
/* 355 */       } else if (c1 == 'C') {
/* 356 */         if (cologneOutputBuffer.length() == 0) {
/* 357 */           if (arrayContains(AHKLOQRUX, b)) {
/* 358 */             cologneOutputBuffer.put('4');
/*     */           } else {
/* 360 */             cologneOutputBuffer.put('8');
/*     */           }
/*     */         
/* 363 */         } else if (arrayContains(SZ, c) || !arrayContains(AHKOQUX, b)) {
/* 364 */           cologneOutputBuffer.put('8');
/*     */         } else {
/* 366 */           cologneOutputBuffer.put('4');
/*     */         }
/*     */       
/* 369 */       } else if (arrayContains(DTX, c1)) {
/* 370 */         cologneOutputBuffer.put('8');
/* 371 */       } else if (c1 == 'R') {
/* 372 */         cologneOutputBuffer.put('7');
/* 373 */       } else if (c1 == 'L') {
/* 374 */         cologneOutputBuffer.put('5');
/* 375 */       } else if (c1 == 'M' || c1 == 'N') {
/* 376 */         cologneOutputBuffer.put('6');
/* 377 */       } else if (c1 == 'H') {
/* 378 */         cologneOutputBuffer.put('-');
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 383 */       c = c1;
/*     */     } 
/* 385 */     return cologneOutputBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object encode(Object paramObject) throws EncoderException {
/* 390 */     if (!(paramObject instanceof String)) {
/* 391 */       throw new EncoderException("This method's parameter was expected to be of the type " + String.class
/* 392 */           .getName() + ". But actually it was of the type " + paramObject
/*     */           
/* 394 */           .getClass().getName() + ".");
/*     */     }
/*     */     
/* 397 */     return encode((String)paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public String encode(String paramString) {
/* 402 */     return colognePhonetic(paramString);
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
/*     */   public boolean isEncodeEqual(String paramString1, String paramString2) {
/* 414 */     return colognePhonetic(paramString1).equals(colognePhonetic(paramString2));
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
/*     */   private char[] preprocess(String paramString) {
/* 429 */     char[] arrayOfChar = paramString.toUpperCase(Locale.GERMAN).toCharArray();
/*     */     
/* 431 */     for (byte b = 0; b < arrayOfChar.length; b++) {
/* 432 */       switch (arrayOfChar[b]) {
/*     */         case 'Ä':
/* 434 */           arrayOfChar[b] = 'A';
/*     */           break;
/*     */         case 'Ü':
/* 437 */           arrayOfChar[b] = 'U';
/*     */           break;
/*     */         case 'Ö':
/* 440 */           arrayOfChar[b] = 'O';
/*     */           break;
/*     */       } 
/*     */ 
/*     */     
/*     */     } 
/* 446 */     return arrayOfChar;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\language\ColognePhonetic.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */