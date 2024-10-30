/*     */ package com.google.gson.stream;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.Flushable;
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JsonWriter
/*     */   implements Closeable, Flushable
/*     */ {
/* 145 */   private static final String[] REPLACEMENT_CHARS = new String[128]; static {
/* 146 */     for (byte b = 0; b <= 31; b++) {
/* 147 */       REPLACEMENT_CHARS[b] = String.format("\\u%04x", new Object[] { Integer.valueOf(b) });
/*     */     } 
/* 149 */     REPLACEMENT_CHARS[34] = "\\\"";
/* 150 */     REPLACEMENT_CHARS[92] = "\\\\";
/* 151 */     REPLACEMENT_CHARS[9] = "\\t";
/* 152 */     REPLACEMENT_CHARS[8] = "\\b";
/* 153 */     REPLACEMENT_CHARS[10] = "\\n";
/* 154 */     REPLACEMENT_CHARS[13] = "\\r";
/* 155 */     REPLACEMENT_CHARS[12] = "\\f";
/* 156 */   } private static final String[] HTML_SAFE_REPLACEMENT_CHARS = (String[])REPLACEMENT_CHARS.clone(); static {
/* 157 */     HTML_SAFE_REPLACEMENT_CHARS[60] = "\\u003c";
/* 158 */     HTML_SAFE_REPLACEMENT_CHARS[62] = "\\u003e";
/* 159 */     HTML_SAFE_REPLACEMENT_CHARS[38] = "\\u0026";
/* 160 */     HTML_SAFE_REPLACEMENT_CHARS[61] = "\\u003d";
/* 161 */     HTML_SAFE_REPLACEMENT_CHARS[39] = "\\u0027";
/*     */   }
/*     */ 
/*     */   
/*     */   private final Writer out;
/*     */   
/* 167 */   private int[] stack = new int[32];
/* 168 */   private int stackSize = 0; private String indent;
/*     */   public JsonWriter(Writer paramWriter) {
/* 170 */     push(6);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 182 */     this.separator = ":";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 190 */     this.serializeNulls = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 198 */     if (paramWriter == null) {
/* 199 */       throw new NullPointerException("out == null");
/*     */     }
/* 201 */     this.out = paramWriter;
/*     */   }
/*     */ 
/*     */   
/*     */   private String separator;
/*     */   
/*     */   private boolean lenient;
/*     */   private boolean htmlSafe;
/*     */   private String deferredName;
/*     */   private boolean serializeNulls;
/*     */   
/*     */   public final void setIndent(String paramString) {
/* 213 */     if (paramString.length() == 0) {
/* 214 */       this.indent = null;
/* 215 */       this.separator = ":";
/*     */     } else {
/* 217 */       this.indent = paramString;
/* 218 */       this.separator = ": ";
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
/*     */   public final void setLenient(boolean paramBoolean) {
/* 235 */     this.lenient = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLenient() {
/* 242 */     return this.lenient;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setHtmlSafe(boolean paramBoolean) {
/* 253 */     this.htmlSafe = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isHtmlSafe() {
/* 261 */     return this.htmlSafe;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setSerializeNulls(boolean paramBoolean) {
/* 269 */     this.serializeNulls = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean getSerializeNulls() {
/* 277 */     return this.serializeNulls;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonWriter beginArray() throws IOException {
/* 287 */     writeDeferredName();
/* 288 */     return open(1, "[");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonWriter endArray() throws IOException {
/* 297 */     return close(1, 2, "]");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonWriter beginObject() throws IOException {
/* 307 */     writeDeferredName();
/* 308 */     return open(3, "{");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonWriter endObject() throws IOException {
/* 317 */     return close(3, 5, "}");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JsonWriter open(int paramInt, String paramString) throws IOException {
/* 325 */     beforeValue();
/* 326 */     push(paramInt);
/* 327 */     this.out.write(paramString);
/* 328 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JsonWriter close(int paramInt1, int paramInt2, String paramString) throws IOException {
/* 337 */     int i = peek();
/* 338 */     if (i != paramInt2 && i != paramInt1) {
/* 339 */       throw new IllegalStateException("Nesting problem.");
/*     */     }
/* 341 */     if (this.deferredName != null) {
/* 342 */       throw new IllegalStateException("Dangling name: " + this.deferredName);
/*     */     }
/*     */     
/* 345 */     this.stackSize--;
/* 346 */     if (i == paramInt2) {
/* 347 */       newline();
/*     */     }
/* 349 */     this.out.write(paramString);
/* 350 */     return this;
/*     */   }
/*     */   
/*     */   private void push(int paramInt) {
/* 354 */     if (this.stackSize == this.stack.length) {
/* 355 */       int[] arrayOfInt = new int[this.stackSize * 2];
/* 356 */       System.arraycopy(this.stack, 0, arrayOfInt, 0, this.stackSize);
/* 357 */       this.stack = arrayOfInt;
/*     */     } 
/* 359 */     this.stack[this.stackSize++] = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int peek() {
/* 366 */     if (this.stackSize == 0) {
/* 367 */       throw new IllegalStateException("JsonWriter is closed.");
/*     */     }
/* 369 */     return this.stack[this.stackSize - 1];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void replaceTop(int paramInt) {
/* 376 */     this.stack[this.stackSize - 1] = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonWriter name(String paramString) throws IOException {
/* 386 */     if (paramString == null) {
/* 387 */       throw new NullPointerException("name == null");
/*     */     }
/* 389 */     if (this.deferredName != null) {
/* 390 */       throw new IllegalStateException();
/*     */     }
/* 392 */     if (this.stackSize == 0) {
/* 393 */       throw new IllegalStateException("JsonWriter is closed.");
/*     */     }
/* 395 */     this.deferredName = paramString;
/* 396 */     return this;
/*     */   }
/*     */   
/*     */   private void writeDeferredName() throws IOException {
/* 400 */     if (this.deferredName != null) {
/* 401 */       beforeName();
/* 402 */       string(this.deferredName);
/* 403 */       this.deferredName = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonWriter value(String paramString) throws IOException {
/* 414 */     if (paramString == null) {
/* 415 */       return nullValue();
/*     */     }
/* 417 */     writeDeferredName();
/* 418 */     beforeValue();
/* 419 */     string(paramString);
/* 420 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonWriter jsonValue(String paramString) throws IOException {
/* 431 */     if (paramString == null) {
/* 432 */       return nullValue();
/*     */     }
/* 434 */     writeDeferredName();
/* 435 */     beforeValue();
/* 436 */     this.out.append(paramString);
/* 437 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonWriter nullValue() throws IOException {
/* 446 */     if (this.deferredName != null) {
/* 447 */       if (this.serializeNulls) {
/* 448 */         writeDeferredName();
/*     */       } else {
/* 450 */         this.deferredName = null;
/* 451 */         return this;
/*     */       } 
/*     */     }
/* 454 */     beforeValue();
/* 455 */     this.out.write("null");
/* 456 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonWriter value(boolean paramBoolean) throws IOException {
/* 465 */     writeDeferredName();
/* 466 */     beforeValue();
/* 467 */     this.out.write(paramBoolean ? "true" : "false");
/* 468 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonWriter value(Boolean paramBoolean) throws IOException {
/* 477 */     if (paramBoolean == null) {
/* 478 */       return nullValue();
/*     */     }
/* 480 */     writeDeferredName();
/* 481 */     beforeValue();
/* 482 */     this.out.write(paramBoolean.booleanValue() ? "true" : "false");
/* 483 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonWriter value(double paramDouble) throws IOException {
/* 494 */     writeDeferredName();
/* 495 */     if (!this.lenient && (Double.isNaN(paramDouble) || Double.isInfinite(paramDouble))) {
/* 496 */       throw new IllegalArgumentException("Numeric values must be finite, but was " + paramDouble);
/*     */     }
/* 498 */     beforeValue();
/* 499 */     this.out.append(Double.toString(paramDouble));
/* 500 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonWriter value(long paramLong) throws IOException {
/* 509 */     writeDeferredName();
/* 510 */     beforeValue();
/* 511 */     this.out.write(Long.toString(paramLong));
/* 512 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonWriter value(Number paramNumber) throws IOException {
/* 523 */     if (paramNumber == null) {
/* 524 */       return nullValue();
/*     */     }
/*     */     
/* 527 */     writeDeferredName();
/* 528 */     String str = paramNumber.toString();
/* 529 */     if (!this.lenient && (str
/* 530 */       .equals("-Infinity") || str.equals("Infinity") || str.equals("NaN"))) {
/* 531 */       throw new IllegalArgumentException("Numeric values must be finite, but was " + paramNumber);
/*     */     }
/* 533 */     beforeValue();
/* 534 */     this.out.append(str);
/* 535 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flush() throws IOException {
/* 543 */     if (this.stackSize == 0) {
/* 544 */       throw new IllegalStateException("JsonWriter is closed.");
/*     */     }
/* 546 */     this.out.flush();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 555 */     this.out.close();
/*     */     
/* 557 */     int i = this.stackSize;
/* 558 */     if (i > 1 || (i == 1 && this.stack[i - 1] != 7)) {
/* 559 */       throw new IOException("Incomplete document");
/*     */     }
/* 561 */     this.stackSize = 0;
/*     */   }
/*     */   
/*     */   private void string(String paramString) throws IOException {
/* 565 */     String[] arrayOfString = this.htmlSafe ? HTML_SAFE_REPLACEMENT_CHARS : REPLACEMENT_CHARS;
/* 566 */     this.out.write("\"");
/* 567 */     int i = 0;
/* 568 */     int j = paramString.length();
/* 569 */     for (byte b = 0; b < j; b++) {
/* 570 */       String str; char c = paramString.charAt(b);
/*     */       
/* 572 */       if (c < '') {
/* 573 */         str = arrayOfString[c];
/* 574 */         if (str == null) {
/*     */           continue;
/*     */         }
/* 577 */       } else if (c == ' ') {
/* 578 */         str = "\\u2028";
/* 579 */       } else if (c == ' ') {
/* 580 */         str = "\\u2029";
/*     */       } else {
/*     */         continue;
/*     */       } 
/* 584 */       if (i < b) {
/* 585 */         this.out.write(paramString, i, b - i);
/*     */       }
/* 587 */       this.out.write(str);
/* 588 */       i = b + 1; continue;
/*     */     } 
/* 590 */     if (i < j) {
/* 591 */       this.out.write(paramString, i, j - i);
/*     */     }
/* 593 */     this.out.write("\"");
/*     */   }
/*     */   
/*     */   private void newline() throws IOException {
/* 597 */     if (this.indent == null) {
/*     */       return;
/*     */     }
/*     */     
/* 601 */     this.out.write("\n"); byte b; int i;
/* 602 */     for (b = 1, i = this.stackSize; b < i; b++) {
/* 603 */       this.out.write(this.indent);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void beforeName() throws IOException {
/* 612 */     int i = peek();
/* 613 */     if (i == 5) {
/* 614 */       this.out.write(44);
/* 615 */     } else if (i != 3) {
/* 616 */       throw new IllegalStateException("Nesting problem.");
/*     */     } 
/* 618 */     newline();
/* 619 */     replaceTop(4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void beforeValue() throws IOException {
/* 629 */     switch (peek()) {
/*     */       case 7:
/* 631 */         if (!this.lenient) {
/* 632 */           throw new IllegalStateException("JSON must have only one top-level value.");
/*     */         }
/*     */ 
/*     */       
/*     */       case 6:
/* 637 */         replaceTop(7);
/*     */         return;
/*     */       
/*     */       case 1:
/* 641 */         replaceTop(2);
/* 642 */         newline();
/*     */         return;
/*     */       
/*     */       case 2:
/* 646 */         this.out.append(',');
/* 647 */         newline();
/*     */         return;
/*     */       
/*     */       case 4:
/* 651 */         this.out.append(this.separator);
/* 652 */         replaceTop(5);
/*     */         return;
/*     */     } 
/*     */     
/* 656 */     throw new IllegalStateException("Nesting problem.");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\stream\JsonWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */