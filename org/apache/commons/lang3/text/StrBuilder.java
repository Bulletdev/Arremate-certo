/*      */ package org.apache.commons.lang3.text;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.Reader;
/*      */ import java.io.Serializable;
/*      */ import java.io.Writer;
/*      */ import java.nio.CharBuffer;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Objects;
/*      */ import org.apache.commons.lang3.ArrayUtils;
/*      */ import org.apache.commons.lang3.builder.Builder;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @Deprecated
/*      */ public class StrBuilder
/*      */   implements Serializable, Appendable, CharSequence, Builder<String>
/*      */ {
/*      */   static final int CAPACITY = 32;
/*      */   private static final long serialVersionUID = 7628716375283629643L;
/*      */   protected char[] buffer;
/*      */   protected int size;
/*      */   private String newLine;
/*      */   private String nullText;
/*      */   
/*      */   public StrBuilder() {
/*  109 */     this(32);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder(int paramInt) {
/*  119 */     if (paramInt <= 0) {
/*  120 */       paramInt = 32;
/*      */     }
/*  122 */     this.buffer = new char[paramInt];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder(String paramString) {
/*  133 */     if (paramString == null) {
/*  134 */       this.buffer = new char[32];
/*      */     } else {
/*  136 */       this.buffer = new char[paramString.length() + 32];
/*  137 */       append(paramString);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNewLineText() {
/*  148 */     return this.newLine;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder setNewLineText(String paramString) {
/*  158 */     this.newLine = paramString;
/*  159 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNullText() {
/*  169 */     return this.nullText;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder setNullText(String paramString) {
/*  179 */     if (paramString != null && paramString.isEmpty()) {
/*  180 */       paramString = null;
/*      */     }
/*  182 */     this.nullText = paramString;
/*  183 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int length() {
/*  194 */     return this.size;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder setLength(int paramInt) {
/*  206 */     if (paramInt < 0) {
/*  207 */       throw new StringIndexOutOfBoundsException(paramInt);
/*      */     }
/*  209 */     if (paramInt < this.size) {
/*  210 */       this.size = paramInt;
/*  211 */     } else if (paramInt > this.size) {
/*  212 */       ensureCapacity(paramInt);
/*  213 */       int i = this.size;
/*  214 */       int j = paramInt;
/*  215 */       this.size = paramInt;
/*  216 */       for (int k = i; k < j; k++) {
/*  217 */         this.buffer[k] = Character.MIN_VALUE;
/*      */       }
/*      */     } 
/*  220 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int capacity() {
/*  230 */     return this.buffer.length;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder ensureCapacity(int paramInt) {
/*  240 */     if (paramInt > this.buffer.length) {
/*  241 */       char[] arrayOfChar = this.buffer;
/*  242 */       this.buffer = new char[paramInt * 2];
/*  243 */       System.arraycopy(arrayOfChar, 0, this.buffer, 0, this.size);
/*      */     } 
/*  245 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder minimizeCapacity() {
/*  254 */     if (this.buffer.length > length()) {
/*  255 */       char[] arrayOfChar = this.buffer;
/*  256 */       this.buffer = new char[length()];
/*  257 */       System.arraycopy(arrayOfChar, 0, this.buffer, 0, this.size);
/*      */     } 
/*  259 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int size() {
/*  272 */     return this.size;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmpty() {
/*  284 */     return (this.size == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder clear() {
/*  299 */     this.size = 0;
/*  300 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public char charAt(int paramInt) {
/*  315 */     if (paramInt < 0 || paramInt >= length()) {
/*  316 */       throw new StringIndexOutOfBoundsException(paramInt);
/*      */     }
/*  318 */     return this.buffer[paramInt];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder setCharAt(int paramInt, char paramChar) {
/*  332 */     if (paramInt < 0 || paramInt >= length()) {
/*  333 */       throw new StringIndexOutOfBoundsException(paramInt);
/*      */     }
/*  335 */     this.buffer[paramInt] = paramChar;
/*  336 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder deleteCharAt(int paramInt) {
/*  349 */     if (paramInt < 0 || paramInt >= this.size) {
/*  350 */       throw new StringIndexOutOfBoundsException(paramInt);
/*      */     }
/*  352 */     deleteImpl(paramInt, paramInt + 1, 1);
/*  353 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public char[] toCharArray() {
/*  363 */     if (this.size == 0) {
/*  364 */       return ArrayUtils.EMPTY_CHAR_ARRAY;
/*      */     }
/*  366 */     char[] arrayOfChar = new char[this.size];
/*  367 */     System.arraycopy(this.buffer, 0, arrayOfChar, 0, this.size);
/*  368 */     return arrayOfChar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public char[] toCharArray(int paramInt1, int paramInt2) {
/*  382 */     paramInt2 = validateRange(paramInt1, paramInt2);
/*  383 */     int i = paramInt2 - paramInt1;
/*  384 */     if (i == 0) {
/*  385 */       return ArrayUtils.EMPTY_CHAR_ARRAY;
/*      */     }
/*  387 */     char[] arrayOfChar = new char[i];
/*  388 */     System.arraycopy(this.buffer, paramInt1, arrayOfChar, 0, i);
/*  389 */     return arrayOfChar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public char[] getChars(char[] paramArrayOfchar) {
/*  399 */     int i = length();
/*  400 */     if (paramArrayOfchar == null || paramArrayOfchar.length < i) {
/*  401 */       paramArrayOfchar = new char[i];
/*      */     }
/*  403 */     System.arraycopy(this.buffer, 0, paramArrayOfchar, 0, i);
/*  404 */     return paramArrayOfchar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void getChars(int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3) {
/*  418 */     if (paramInt1 < 0) {
/*  419 */       throw new StringIndexOutOfBoundsException(paramInt1);
/*      */     }
/*  421 */     if (paramInt2 < 0 || paramInt2 > length()) {
/*  422 */       throw new StringIndexOutOfBoundsException(paramInt2);
/*      */     }
/*  424 */     if (paramInt1 > paramInt2) {
/*  425 */       throw new StringIndexOutOfBoundsException("end < start");
/*      */     }
/*  427 */     System.arraycopy(this.buffer, paramInt1, paramArrayOfchar, paramInt3, paramInt2 - paramInt1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int readFrom(Readable paramReadable) throws IOException {
/*  443 */     int i = this.size;
/*  444 */     if (paramReadable instanceof Reader) {
/*  445 */       Reader reader = (Reader)paramReadable;
/*  446 */       ensureCapacity(this.size + 1);
/*      */       int j;
/*  448 */       while ((j = reader.read(this.buffer, this.size, this.buffer.length - this.size)) != -1) {
/*  449 */         this.size += j;
/*  450 */         ensureCapacity(this.size + 1);
/*      */       } 
/*  452 */     } else if (paramReadable instanceof CharBuffer) {
/*  453 */       CharBuffer charBuffer = (CharBuffer)paramReadable;
/*  454 */       int j = charBuffer.remaining();
/*  455 */       ensureCapacity(this.size + j);
/*  456 */       charBuffer.get(this.buffer, this.size, j);
/*  457 */       this.size += j;
/*      */     } else {
/*      */       while (true) {
/*  460 */         ensureCapacity(this.size + 1);
/*  461 */         CharBuffer charBuffer = CharBuffer.wrap(this.buffer, this.size, this.buffer.length - this.size);
/*  462 */         int j = paramReadable.read(charBuffer);
/*  463 */         if (j == -1) {
/*      */           break;
/*      */         }
/*  466 */         this.size += j;
/*      */       } 
/*      */     } 
/*  469 */     return this.size - i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendNewLine() {
/*  483 */     if (this.newLine == null) {
/*  484 */       append(System.lineSeparator());
/*  485 */       return this;
/*      */     } 
/*  487 */     return append(this.newLine);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendNull() {
/*  496 */     if (this.nullText == null) {
/*  497 */       return this;
/*      */     }
/*  499 */     return append(this.nullText);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(Object paramObject) {
/*  510 */     if (paramObject == null) {
/*  511 */       return appendNull();
/*      */     }
/*  513 */     if (paramObject instanceof CharSequence) {
/*  514 */       return append((CharSequence)paramObject);
/*      */     }
/*  516 */     return append(paramObject.toString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(CharSequence paramCharSequence) {
/*  529 */     if (paramCharSequence == null) {
/*  530 */       return appendNull();
/*      */     }
/*  532 */     if (paramCharSequence instanceof StrBuilder) {
/*  533 */       return append((StrBuilder)paramCharSequence);
/*      */     }
/*  535 */     if (paramCharSequence instanceof StringBuilder) {
/*  536 */       return append((StringBuilder)paramCharSequence);
/*      */     }
/*  538 */     if (paramCharSequence instanceof StringBuffer) {
/*  539 */       return append((StringBuffer)paramCharSequence);
/*      */     }
/*  541 */     if (paramCharSequence instanceof CharBuffer) {
/*  542 */       return append((CharBuffer)paramCharSequence);
/*      */     }
/*  544 */     return append(paramCharSequence.toString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*  559 */     if (paramCharSequence == null) {
/*  560 */       return appendNull();
/*      */     }
/*  562 */     return append(paramCharSequence.toString(), paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(String paramString) {
/*  573 */     if (paramString == null) {
/*  574 */       return appendNull();
/*      */     }
/*  576 */     int i = paramString.length();
/*  577 */     if (i > 0) {
/*  578 */       int j = length();
/*  579 */       ensureCapacity(j + i);
/*  580 */       paramString.getChars(0, i, this.buffer, j);
/*  581 */       this.size += i;
/*      */     } 
/*  583 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(String paramString, int paramInt1, int paramInt2) {
/*  597 */     if (paramString == null) {
/*  598 */       return appendNull();
/*      */     }
/*  600 */     if (paramInt1 < 0 || paramInt1 > paramString.length()) {
/*  601 */       throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */     }
/*  603 */     if (paramInt2 < 0 || paramInt1 + paramInt2 > paramString.length()) {
/*  604 */       throw new StringIndexOutOfBoundsException("length must be valid");
/*      */     }
/*  606 */     if (paramInt2 > 0) {
/*  607 */       int i = length();
/*  608 */       ensureCapacity(i + paramInt2);
/*  609 */       paramString.getChars(paramInt1, paramInt1 + paramInt2, this.buffer, i);
/*  610 */       this.size += paramInt2;
/*      */     } 
/*  612 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(String paramString, Object... paramVarArgs) {
/*  625 */     return append(String.format(paramString, paramVarArgs));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(CharBuffer paramCharBuffer) {
/*  637 */     if (paramCharBuffer == null) {
/*  638 */       return appendNull();
/*      */     }
/*  640 */     if (paramCharBuffer.hasArray()) {
/*  641 */       int i = paramCharBuffer.remaining();
/*  642 */       int j = length();
/*  643 */       ensureCapacity(j + i);
/*  644 */       System.arraycopy(paramCharBuffer.array(), paramCharBuffer.arrayOffset() + paramCharBuffer.position(), this.buffer, j, i);
/*  645 */       this.size += i;
/*      */     } else {
/*  647 */       append(paramCharBuffer.toString());
/*      */     } 
/*  649 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(CharBuffer paramCharBuffer, int paramInt1, int paramInt2) {
/*  663 */     if (paramCharBuffer == null) {
/*  664 */       return appendNull();
/*      */     }
/*  666 */     if (paramCharBuffer.hasArray()) {
/*  667 */       int i = paramCharBuffer.remaining();
/*  668 */       if (paramInt1 < 0 || paramInt1 > i) {
/*  669 */         throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */       }
/*  671 */       if (paramInt2 < 0 || paramInt1 + paramInt2 > i) {
/*  672 */         throw new StringIndexOutOfBoundsException("length must be valid");
/*      */       }
/*  674 */       int j = length();
/*  675 */       ensureCapacity(j + paramInt2);
/*  676 */       System.arraycopy(paramCharBuffer.array(), paramCharBuffer.arrayOffset() + paramCharBuffer.position() + paramInt1, this.buffer, j, paramInt2);
/*  677 */       this.size += paramInt2;
/*      */     } else {
/*  679 */       append(paramCharBuffer.toString(), paramInt1, paramInt2);
/*      */     } 
/*  681 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(StringBuffer paramStringBuffer) {
/*  692 */     if (paramStringBuffer == null) {
/*  693 */       return appendNull();
/*      */     }
/*  695 */     int i = paramStringBuffer.length();
/*  696 */     if (i > 0) {
/*  697 */       int j = length();
/*  698 */       ensureCapacity(j + i);
/*  699 */       paramStringBuffer.getChars(0, i, this.buffer, j);
/*  700 */       this.size += i;
/*      */     } 
/*  702 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(StringBuffer paramStringBuffer, int paramInt1, int paramInt2) {
/*  715 */     if (paramStringBuffer == null) {
/*  716 */       return appendNull();
/*      */     }
/*  718 */     if (paramInt1 < 0 || paramInt1 > paramStringBuffer.length()) {
/*  719 */       throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */     }
/*  721 */     if (paramInt2 < 0 || paramInt1 + paramInt2 > paramStringBuffer.length()) {
/*  722 */       throw new StringIndexOutOfBoundsException("length must be valid");
/*      */     }
/*  724 */     if (paramInt2 > 0) {
/*  725 */       int i = length();
/*  726 */       ensureCapacity(i + paramInt2);
/*  727 */       paramStringBuffer.getChars(paramInt1, paramInt1 + paramInt2, this.buffer, i);
/*  728 */       this.size += paramInt2;
/*      */     } 
/*  730 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(StringBuilder paramStringBuilder) {
/*  742 */     if (paramStringBuilder == null) {
/*  743 */       return appendNull();
/*      */     }
/*  745 */     int i = paramStringBuilder.length();
/*  746 */     if (i > 0) {
/*  747 */       int j = length();
/*  748 */       ensureCapacity(j + i);
/*  749 */       paramStringBuilder.getChars(0, i, this.buffer, j);
/*  750 */       this.size += i;
/*      */     } 
/*  752 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(StringBuilder paramStringBuilder, int paramInt1, int paramInt2) {
/*  766 */     if (paramStringBuilder == null) {
/*  767 */       return appendNull();
/*      */     }
/*  769 */     if (paramInt1 < 0 || paramInt1 > paramStringBuilder.length()) {
/*  770 */       throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */     }
/*  772 */     if (paramInt2 < 0 || paramInt1 + paramInt2 > paramStringBuilder.length()) {
/*  773 */       throw new StringIndexOutOfBoundsException("length must be valid");
/*      */     }
/*  775 */     if (paramInt2 > 0) {
/*  776 */       int i = length();
/*  777 */       ensureCapacity(i + paramInt2);
/*  778 */       paramStringBuilder.getChars(paramInt1, paramInt1 + paramInt2, this.buffer, i);
/*  779 */       this.size += paramInt2;
/*      */     } 
/*  781 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(StrBuilder paramStrBuilder) {
/*  792 */     if (paramStrBuilder == null) {
/*  793 */       return appendNull();
/*      */     }
/*  795 */     int i = paramStrBuilder.length();
/*  796 */     if (i > 0) {
/*  797 */       int j = length();
/*  798 */       ensureCapacity(j + i);
/*  799 */       System.arraycopy(paramStrBuilder.buffer, 0, this.buffer, j, i);
/*  800 */       this.size += i;
/*      */     } 
/*  802 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(StrBuilder paramStrBuilder, int paramInt1, int paramInt2) {
/*  815 */     if (paramStrBuilder == null) {
/*  816 */       return appendNull();
/*      */     }
/*  818 */     if (paramInt1 < 0 || paramInt1 > paramStrBuilder.length()) {
/*  819 */       throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */     }
/*  821 */     if (paramInt2 < 0 || paramInt1 + paramInt2 > paramStrBuilder.length()) {
/*  822 */       throw new StringIndexOutOfBoundsException("length must be valid");
/*      */     }
/*  824 */     if (paramInt2 > 0) {
/*  825 */       int i = length();
/*  826 */       ensureCapacity(i + paramInt2);
/*  827 */       paramStrBuilder.getChars(paramInt1, paramInt1 + paramInt2, this.buffer, i);
/*  828 */       this.size += paramInt2;
/*      */     } 
/*  830 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(char[] paramArrayOfchar) {
/*  841 */     if (paramArrayOfchar == null) {
/*  842 */       return appendNull();
/*      */     }
/*  844 */     int i = paramArrayOfchar.length;
/*  845 */     if (i > 0) {
/*  846 */       int j = length();
/*  847 */       ensureCapacity(j + i);
/*  848 */       System.arraycopy(paramArrayOfchar, 0, this.buffer, j, i);
/*  849 */       this.size += i;
/*      */     } 
/*  851 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  864 */     if (paramArrayOfchar == null) {
/*  865 */       return appendNull();
/*      */     }
/*  867 */     if (paramInt1 < 0 || paramInt1 > paramArrayOfchar.length) {
/*  868 */       throw new StringIndexOutOfBoundsException("Invalid startIndex: " + paramInt2);
/*      */     }
/*  870 */     if (paramInt2 < 0 || paramInt1 + paramInt2 > paramArrayOfchar.length) {
/*  871 */       throw new StringIndexOutOfBoundsException("Invalid length: " + paramInt2);
/*      */     }
/*  873 */     if (paramInt2 > 0) {
/*  874 */       int i = length();
/*  875 */       ensureCapacity(i + paramInt2);
/*  876 */       System.arraycopy(paramArrayOfchar, paramInt1, this.buffer, i, paramInt2);
/*  877 */       this.size += paramInt2;
/*      */     } 
/*  879 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(boolean paramBoolean) {
/*  889 */     if (paramBoolean) {
/*  890 */       ensureCapacity(this.size + 4);
/*  891 */       this.buffer[this.size++] = 't';
/*  892 */       this.buffer[this.size++] = 'r';
/*  893 */       this.buffer[this.size++] = 'u';
/*  894 */       this.buffer[this.size++] = 'e';
/*      */     } else {
/*  896 */       ensureCapacity(this.size + 5);
/*  897 */       this.buffer[this.size++] = 'f';
/*  898 */       this.buffer[this.size++] = 'a';
/*  899 */       this.buffer[this.size++] = 'l';
/*  900 */       this.buffer[this.size++] = 's';
/*  901 */       this.buffer[this.size++] = 'e';
/*      */     } 
/*  903 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(char paramChar) {
/*  915 */     int i = length();
/*  916 */     ensureCapacity(i + 1);
/*  917 */     this.buffer[this.size++] = paramChar;
/*  918 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(int paramInt) {
/*  928 */     return append(String.valueOf(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(long paramLong) {
/*  938 */     return append(String.valueOf(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(float paramFloat) {
/*  948 */     return append(String.valueOf(paramFloat));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(double paramDouble) {
/*  958 */     return append(String.valueOf(paramDouble));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(Object paramObject) {
/*  971 */     return append(paramObject).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(String paramString) {
/*  983 */     return append(paramString).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(String paramString, int paramInt1, int paramInt2) {
/*  997 */     return append(paramString, paramInt1, paramInt2).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(String paramString, Object... paramVarArgs) {
/* 1010 */     return append(paramString, paramVarArgs).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(StringBuffer paramStringBuffer) {
/* 1022 */     return append(paramStringBuffer).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(StringBuilder paramStringBuilder) {
/* 1034 */     return append(paramStringBuilder).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(StringBuilder paramStringBuilder, int paramInt1, int paramInt2) {
/* 1048 */     return append(paramStringBuilder, paramInt1, paramInt2).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(StringBuffer paramStringBuffer, int paramInt1, int paramInt2) {
/* 1062 */     return append(paramStringBuffer, paramInt1, paramInt2).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(StrBuilder paramStrBuilder) {
/* 1074 */     return append(paramStrBuilder).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(StrBuilder paramStrBuilder, int paramInt1, int paramInt2) {
/* 1088 */     return append(paramStrBuilder, paramInt1, paramInt2).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(char[] paramArrayOfchar) {
/* 1100 */     return append(paramArrayOfchar).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 1114 */     return append(paramArrayOfchar, paramInt1, paramInt2).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(boolean paramBoolean) {
/* 1125 */     return append(paramBoolean).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(char paramChar) {
/* 1136 */     return append(paramChar).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(int paramInt) {
/* 1147 */     return append(paramInt).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(long paramLong) {
/* 1158 */     return append(paramLong).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(float paramFloat) {
/* 1169 */     return append(paramFloat).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(double paramDouble) {
/* 1180 */     return append(paramDouble).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> StrBuilder appendAll(T... paramVarArgs) {
/* 1201 */     if (ArrayUtils.isNotEmpty((Object[])paramVarArgs)) {
/* 1202 */       for (T t : paramVarArgs) {
/* 1203 */         append(t);
/*      */       }
/*      */     }
/* 1206 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendAll(Iterable<?> paramIterable) {
/* 1219 */     if (paramIterable != null) {
/* 1220 */       for (Object object : paramIterable) {
/* 1221 */         append(object);
/*      */       }
/*      */     }
/* 1224 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendAll(Iterator<?> paramIterator) {
/* 1237 */     if (paramIterator != null) {
/* 1238 */       while (paramIterator.hasNext()) {
/* 1239 */         append(paramIterator.next());
/*      */       }
/*      */     }
/* 1242 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendWithSeparators(Object[] paramArrayOfObject, String paramString) {
/* 1257 */     if (paramArrayOfObject != null && paramArrayOfObject.length > 0) {
/* 1258 */       String str = Objects.toString(paramString, "");
/* 1259 */       append(paramArrayOfObject[0]);
/* 1260 */       for (byte b = 1; b < paramArrayOfObject.length; b++) {
/* 1261 */         append(str);
/* 1262 */         append(paramArrayOfObject[b]);
/*      */       } 
/*      */     } 
/* 1265 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendWithSeparators(Iterable<?> paramIterable, String paramString) {
/* 1279 */     if (paramIterable != null) {
/* 1280 */       String str = Objects.toString(paramString, "");
/* 1281 */       Iterator<?> iterator = paramIterable.iterator();
/* 1282 */       while (iterator.hasNext()) {
/* 1283 */         append(iterator.next());
/* 1284 */         if (iterator.hasNext()) {
/* 1285 */           append(str);
/*      */         }
/*      */       } 
/*      */     } 
/* 1289 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendWithSeparators(Iterator<?> paramIterator, String paramString) {
/* 1303 */     if (paramIterator != null) {
/* 1304 */       String str = Objects.toString(paramString, "");
/* 1305 */       while (paramIterator.hasNext()) {
/* 1306 */         append(paramIterator.next());
/* 1307 */         if (paramIterator.hasNext()) {
/* 1308 */           append(str);
/*      */         }
/*      */       } 
/*      */     } 
/* 1312 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendSeparator(String paramString) {
/* 1337 */     return appendSeparator(paramString, (String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendSeparator(String paramString1, String paramString2) {
/* 1368 */     String str = isEmpty() ? paramString2 : paramString1;
/* 1369 */     if (str != null) {
/* 1370 */       append(str);
/*      */     }
/* 1372 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendSeparator(char paramChar) {
/* 1395 */     if (size() > 0) {
/* 1396 */       append(paramChar);
/*      */     }
/* 1398 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendSeparator(char paramChar1, char paramChar2) {
/* 1413 */     if (size() > 0) {
/* 1414 */       append(paramChar1);
/*      */     } else {
/* 1416 */       append(paramChar2);
/*      */     } 
/* 1418 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendSeparator(String paramString, int paramInt) {
/* 1443 */     if (paramString != null && paramInt > 0) {
/* 1444 */       append(paramString);
/*      */     }
/* 1446 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendSeparator(char paramChar, int paramInt) {
/* 1471 */     if (paramInt > 0) {
/* 1472 */       append(paramChar);
/*      */     }
/* 1474 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendPadding(int paramInt, char paramChar) {
/* 1486 */     if (paramInt >= 0) {
/* 1487 */       ensureCapacity(this.size + paramInt);
/* 1488 */       for (byte b = 0; b < paramInt; b++) {
/* 1489 */         this.buffer[this.size++] = paramChar;
/*      */       }
/*      */     } 
/* 1492 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendFixedWidthPadLeft(Object paramObject, int paramInt, char paramChar) {
/* 1508 */     if (paramInt > 0) {
/* 1509 */       ensureCapacity(this.size + paramInt);
/* 1510 */       String str = (paramObject == null) ? getNullText() : paramObject.toString();
/* 1511 */       if (str == null) {
/* 1512 */         str = "";
/*      */       }
/* 1514 */       int i = str.length();
/* 1515 */       if (i >= paramInt) {
/* 1516 */         str.getChars(i - paramInt, i, this.buffer, this.size);
/*      */       } else {
/* 1518 */         int j = paramInt - i;
/* 1519 */         for (byte b = 0; b < j; b++) {
/* 1520 */           this.buffer[this.size + b] = paramChar;
/*      */         }
/* 1522 */         str.getChars(0, i, this.buffer, this.size + j);
/*      */       } 
/* 1524 */       this.size += paramInt;
/*      */     } 
/* 1526 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendFixedWidthPadLeft(int paramInt1, int paramInt2, char paramChar) {
/* 1540 */     return appendFixedWidthPadLeft(String.valueOf(paramInt1), paramInt2, paramChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendFixedWidthPadRight(Object paramObject, int paramInt, char paramChar) {
/* 1555 */     if (paramInt > 0) {
/* 1556 */       ensureCapacity(this.size + paramInt);
/* 1557 */       String str = (paramObject == null) ? getNullText() : paramObject.toString();
/* 1558 */       if (str == null) {
/* 1559 */         str = "";
/*      */       }
/* 1561 */       int i = str.length();
/* 1562 */       if (i >= paramInt) {
/* 1563 */         str.getChars(0, paramInt, this.buffer, this.size);
/*      */       } else {
/* 1565 */         int j = paramInt - i;
/* 1566 */         str.getChars(0, i, this.buffer, this.size);
/* 1567 */         for (byte b = 0; b < j; b++) {
/* 1568 */           this.buffer[this.size + i + b] = paramChar;
/*      */         }
/*      */       } 
/* 1571 */       this.size += paramInt;
/*      */     } 
/* 1573 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendFixedWidthPadRight(int paramInt1, int paramInt2, char paramChar) {
/* 1587 */     return appendFixedWidthPadRight(String.valueOf(paramInt1), paramInt2, paramChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder insert(int paramInt, Object paramObject) {
/* 1601 */     if (paramObject == null) {
/* 1602 */       return insert(paramInt, this.nullText);
/*      */     }
/* 1604 */     return insert(paramInt, paramObject.toString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder insert(int paramInt, String paramString) {
/* 1617 */     validateIndex(paramInt);
/* 1618 */     if (paramString == null) {
/* 1619 */       paramString = this.nullText;
/*      */     }
/* 1621 */     if (paramString != null) {
/* 1622 */       int i = paramString.length();
/* 1623 */       if (i > 0) {
/* 1624 */         int j = this.size + i;
/* 1625 */         ensureCapacity(j);
/* 1626 */         System.arraycopy(this.buffer, paramInt, this.buffer, paramInt + i, this.size - paramInt);
/* 1627 */         this.size = j;
/* 1628 */         paramString.getChars(0, i, this.buffer, paramInt);
/*      */       } 
/*      */     } 
/* 1631 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder insert(int paramInt, char[] paramArrayOfchar) {
/* 1644 */     validateIndex(paramInt);
/* 1645 */     if (paramArrayOfchar == null) {
/* 1646 */       return insert(paramInt, this.nullText);
/*      */     }
/* 1648 */     int i = paramArrayOfchar.length;
/* 1649 */     if (i > 0) {
/* 1650 */       ensureCapacity(this.size + i);
/* 1651 */       System.arraycopy(this.buffer, paramInt, this.buffer, paramInt + i, this.size - paramInt);
/* 1652 */       System.arraycopy(paramArrayOfchar, 0, this.buffer, paramInt, i);
/* 1653 */       this.size += i;
/*      */     } 
/* 1655 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder insert(int paramInt1, char[] paramArrayOfchar, int paramInt2, int paramInt3) {
/* 1670 */     validateIndex(paramInt1);
/* 1671 */     if (paramArrayOfchar == null) {
/* 1672 */       return insert(paramInt1, this.nullText);
/*      */     }
/* 1674 */     if (paramInt2 < 0 || paramInt2 > paramArrayOfchar.length) {
/* 1675 */       throw new StringIndexOutOfBoundsException("Invalid offset: " + paramInt2);
/*      */     }
/* 1677 */     if (paramInt3 < 0 || paramInt2 + paramInt3 > paramArrayOfchar.length) {
/* 1678 */       throw new StringIndexOutOfBoundsException("Invalid length: " + paramInt3);
/*      */     }
/* 1680 */     if (paramInt3 > 0) {
/* 1681 */       ensureCapacity(this.size + paramInt3);
/* 1682 */       System.arraycopy(this.buffer, paramInt1, this.buffer, paramInt1 + paramInt3, this.size - paramInt1);
/* 1683 */       System.arraycopy(paramArrayOfchar, paramInt2, this.buffer, paramInt1, paramInt3);
/* 1684 */       this.size += paramInt3;
/*      */     } 
/* 1686 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder insert(int paramInt, boolean paramBoolean) {
/* 1698 */     validateIndex(paramInt);
/* 1699 */     if (paramBoolean) {
/* 1700 */       ensureCapacity(this.size + 4);
/* 1701 */       System.arraycopy(this.buffer, paramInt, this.buffer, paramInt + 4, this.size - paramInt);
/* 1702 */       this.buffer[paramInt++] = 't';
/* 1703 */       this.buffer[paramInt++] = 'r';
/* 1704 */       this.buffer[paramInt++] = 'u';
/* 1705 */       this.buffer[paramInt] = 'e';
/* 1706 */       this.size += 4;
/*      */     } else {
/* 1708 */       ensureCapacity(this.size + 5);
/* 1709 */       System.arraycopy(this.buffer, paramInt, this.buffer, paramInt + 5, this.size - paramInt);
/* 1710 */       this.buffer[paramInt++] = 'f';
/* 1711 */       this.buffer[paramInt++] = 'a';
/* 1712 */       this.buffer[paramInt++] = 'l';
/* 1713 */       this.buffer[paramInt++] = 's';
/* 1714 */       this.buffer[paramInt] = 'e';
/* 1715 */       this.size += 5;
/*      */     } 
/* 1717 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder insert(int paramInt, char paramChar) {
/* 1729 */     validateIndex(paramInt);
/* 1730 */     ensureCapacity(this.size + 1);
/* 1731 */     System.arraycopy(this.buffer, paramInt, this.buffer, paramInt + 1, this.size - paramInt);
/* 1732 */     this.buffer[paramInt] = paramChar;
/* 1733 */     this.size++;
/* 1734 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder insert(int paramInt1, int paramInt2) {
/* 1746 */     return insert(paramInt1, String.valueOf(paramInt2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder insert(int paramInt, long paramLong) {
/* 1758 */     return insert(paramInt, String.valueOf(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder insert(int paramInt, float paramFloat) {
/* 1770 */     return insert(paramInt, String.valueOf(paramFloat));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder insert(int paramInt, double paramDouble) {
/* 1782 */     return insert(paramInt, String.valueOf(paramDouble));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void deleteImpl(int paramInt1, int paramInt2, int paramInt3) {
/* 1795 */     System.arraycopy(this.buffer, paramInt2, this.buffer, paramInt1, this.size - paramInt2);
/* 1796 */     this.size -= paramInt3;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder delete(int paramInt1, int paramInt2) {
/* 1809 */     paramInt2 = validateRange(paramInt1, paramInt2);
/* 1810 */     int i = paramInt2 - paramInt1;
/* 1811 */     if (i > 0) {
/* 1812 */       deleteImpl(paramInt1, paramInt2, i);
/*      */     }
/* 1814 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder deleteAll(char paramChar) {
/* 1825 */     for (int i = 0; i < this.size; i++) {
/* 1826 */       if (this.buffer[i] == paramChar) {
/* 1827 */         int j = i; do {  }
/* 1828 */         while (++i < this.size && 
/* 1829 */           this.buffer[i] == paramChar);
/*      */ 
/*      */ 
/*      */         
/* 1833 */         int k = i - j;
/* 1834 */         deleteImpl(j, i, k);
/* 1835 */         i -= k;
/*      */       } 
/*      */     } 
/* 1838 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder deleteFirst(char paramChar) {
/* 1848 */     for (byte b = 0; b < this.size; b++) {
/* 1849 */       if (this.buffer[b] == paramChar) {
/* 1850 */         deleteImpl(b, b + 1, 1);
/*      */         break;
/*      */       } 
/*      */     } 
/* 1854 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder deleteAll(String paramString) {
/* 1865 */     byte b = (paramString == null) ? 0 : paramString.length();
/* 1866 */     if (b) {
/* 1867 */       int i = indexOf(paramString, 0);
/* 1868 */       while (i >= 0) {
/* 1869 */         deleteImpl(i, i + b, b);
/* 1870 */         i = indexOf(paramString, i);
/*      */       } 
/*      */     } 
/* 1873 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder deleteFirst(String paramString) {
/* 1883 */     byte b = (paramString == null) ? 0 : paramString.length();
/* 1884 */     if (b) {
/* 1885 */       int i = indexOf(paramString, 0);
/* 1886 */       if (i >= 0) {
/* 1887 */         deleteImpl(i, i + b, b);
/*      */       }
/*      */     } 
/* 1890 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder deleteAll(StrMatcher paramStrMatcher) {
/* 1905 */     return replace(paramStrMatcher, null, 0, this.size, -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder deleteFirst(StrMatcher paramStrMatcher) {
/* 1919 */     return replace(paramStrMatcher, null, 0, this.size, 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void replaceImpl(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4) {
/* 1934 */     int i = this.size - paramInt3 + paramInt4;
/* 1935 */     if (paramInt4 != paramInt3) {
/* 1936 */       ensureCapacity(i);
/* 1937 */       System.arraycopy(this.buffer, paramInt2, this.buffer, paramInt1 + paramInt4, this.size - paramInt2);
/* 1938 */       this.size = i;
/*      */     } 
/* 1940 */     if (paramInt4 > 0) {
/* 1941 */       paramString.getChars(0, paramInt4, this.buffer, paramInt1);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder replace(int paramInt1, int paramInt2, String paramString) {
/* 1957 */     paramInt2 = validateRange(paramInt1, paramInt2);
/* 1958 */     boolean bool = (paramString == null) ? false : paramString.length();
/* 1959 */     replaceImpl(paramInt1, paramInt2, paramInt2 - paramInt1, paramString, bool);
/* 1960 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder replaceAll(char paramChar1, char paramChar2) {
/* 1973 */     if (paramChar1 != paramChar2) {
/* 1974 */       for (byte b = 0; b < this.size; b++) {
/* 1975 */         if (this.buffer[b] == paramChar1) {
/* 1976 */           this.buffer[b] = paramChar2;
/*      */         }
/*      */       } 
/*      */     }
/* 1980 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder replaceFirst(char paramChar1, char paramChar2) {
/* 1992 */     if (paramChar1 != paramChar2) {
/* 1993 */       for (byte b = 0; b < this.size; b++) {
/* 1994 */         if (this.buffer[b] == paramChar1) {
/* 1995 */           this.buffer[b] = paramChar2;
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/* 2000 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder replaceAll(String paramString1, String paramString2) {
/* 2012 */     byte b = (paramString1 == null) ? 0 : paramString1.length();
/* 2013 */     if (b) {
/* 2014 */       byte b1 = (paramString2 == null) ? 0 : paramString2.length();
/* 2015 */       int i = indexOf(paramString1, 0);
/* 2016 */       while (i >= 0) {
/* 2017 */         replaceImpl(i, i + b, b, paramString2, b1);
/* 2018 */         i = indexOf(paramString1, i + b1);
/*      */       } 
/*      */     } 
/* 2021 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder replaceFirst(String paramString1, String paramString2) {
/* 2032 */     byte b = (paramString1 == null) ? 0 : paramString1.length();
/* 2033 */     if (b) {
/* 2034 */       int i = indexOf(paramString1, 0);
/* 2035 */       if (i >= 0) {
/* 2036 */         boolean bool = (paramString2 == null) ? false : paramString2.length();
/* 2037 */         replaceImpl(i, i + b, b, paramString2, bool);
/*      */       } 
/*      */     } 
/* 2040 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder replaceAll(StrMatcher paramStrMatcher, String paramString) {
/* 2056 */     return replace(paramStrMatcher, paramString, 0, this.size, -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder replaceFirst(StrMatcher paramStrMatcher, String paramString) {
/* 2071 */     return replace(paramStrMatcher, paramString, 0, this.size, 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder replace(StrMatcher paramStrMatcher, String paramString, int paramInt1, int paramInt2, int paramInt3) {
/* 2094 */     paramInt2 = validateRange(paramInt1, paramInt2);
/* 2095 */     return replaceImpl(paramStrMatcher, paramString, paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private StrBuilder replaceImpl(StrMatcher paramStrMatcher, String paramString, int paramInt1, int paramInt2, int paramInt3) {
/* 2116 */     if (paramStrMatcher == null || this.size == 0) {
/* 2117 */       return this;
/*      */     }
/* 2119 */     byte b = (paramString == null) ? 0 : paramString.length();
/* 2120 */     for (int i = paramInt1; i < paramInt2 && paramInt3 != 0; i++) {
/* 2121 */       char[] arrayOfChar = this.buffer;
/* 2122 */       int j = paramStrMatcher.isMatch(arrayOfChar, i, paramInt1, paramInt2);
/* 2123 */       if (j > 0) {
/* 2124 */         replaceImpl(i, i + j, j, paramString, b);
/* 2125 */         paramInt2 = paramInt2 - j + b;
/* 2126 */         i = i + b - 1;
/* 2127 */         if (paramInt3 > 0) {
/* 2128 */           paramInt3--;
/*      */         }
/*      */       } 
/*      */     } 
/* 2132 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder reverse() {
/* 2142 */     if (this.size == 0) {
/* 2143 */       return this;
/*      */     }
/*      */     
/* 2146 */     int i = this.size / 2;
/* 2147 */     char[] arrayOfChar = this.buffer; byte b; int j;
/* 2148 */     for (b = 0, j = this.size - 1; b < i; b++, j--) {
/* 2149 */       char c = arrayOfChar[b];
/* 2150 */       arrayOfChar[b] = arrayOfChar[j];
/* 2151 */       arrayOfChar[j] = c;
/*      */     } 
/* 2153 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder trim() {
/* 2164 */     if (this.size == 0) {
/* 2165 */       return this;
/*      */     }
/* 2167 */     int i = this.size;
/* 2168 */     char[] arrayOfChar = this.buffer;
/* 2169 */     byte b = 0;
/* 2170 */     while (b < i && arrayOfChar[b] <= ' ') {
/* 2171 */       b++;
/*      */     }
/* 2173 */     while (b < i && arrayOfChar[i - 1] <= ' ') {
/* 2174 */       i--;
/*      */     }
/* 2176 */     if (i < this.size) {
/* 2177 */       delete(i, this.size);
/*      */     }
/* 2179 */     if (b > 0) {
/* 2180 */       delete(0, b);
/*      */     }
/* 2182 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean startsWith(String paramString) {
/* 2195 */     if (paramString == null) {
/* 2196 */       return false;
/*      */     }
/* 2198 */     int i = paramString.length();
/* 2199 */     if (i == 0) {
/* 2200 */       return true;
/*      */     }
/* 2202 */     if (i > this.size) {
/* 2203 */       return false;
/*      */     }
/* 2205 */     for (byte b = 0; b < i; b++) {
/* 2206 */       if (this.buffer[b] != paramString.charAt(b)) {
/* 2207 */         return false;
/*      */       }
/*      */     } 
/* 2210 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean endsWith(String paramString) {
/* 2222 */     if (paramString == null) {
/* 2223 */       return false;
/*      */     }
/* 2225 */     int i = paramString.length();
/* 2226 */     if (i == 0) {
/* 2227 */       return true;
/*      */     }
/* 2229 */     if (i > this.size) {
/* 2230 */       return false;
/*      */     }
/* 2232 */     int j = this.size - i;
/* 2233 */     for (byte b = 0; b < i; b++, j++) {
/* 2234 */       if (this.buffer[j] != paramString.charAt(b)) {
/* 2235 */         return false;
/*      */       }
/*      */     } 
/* 2238 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CharSequence subSequence(int paramInt1, int paramInt2) {
/* 2248 */     if (paramInt1 < 0) {
/* 2249 */       throw new StringIndexOutOfBoundsException(paramInt1);
/*      */     }
/* 2251 */     if (paramInt2 > this.size) {
/* 2252 */       throw new StringIndexOutOfBoundsException(paramInt2);
/*      */     }
/* 2254 */     if (paramInt1 > paramInt2) {
/* 2255 */       throw new StringIndexOutOfBoundsException(paramInt2 - paramInt1);
/*      */     }
/* 2257 */     return substring(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String substring(int paramInt) {
/* 2268 */     return substring(paramInt, this.size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String substring(int paramInt1, int paramInt2) {
/* 2285 */     paramInt2 = validateRange(paramInt1, paramInt2);
/* 2286 */     return new String(this.buffer, paramInt1, paramInt2 - paramInt1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String leftString(int paramInt) {
/* 2302 */     if (paramInt <= 0)
/* 2303 */       return ""; 
/* 2304 */     if (paramInt >= this.size) {
/* 2305 */       return new String(this.buffer, 0, this.size);
/*      */     }
/* 2307 */     return new String(this.buffer, 0, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String rightString(int paramInt) {
/* 2324 */     if (paramInt <= 0)
/* 2325 */       return ""; 
/* 2326 */     if (paramInt >= this.size) {
/* 2327 */       return new String(this.buffer, 0, this.size);
/*      */     }
/* 2329 */     return new String(this.buffer, this.size - paramInt, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String midString(int paramInt1, int paramInt2) {
/* 2350 */     if (paramInt1 < 0) {
/* 2351 */       paramInt1 = 0;
/*      */     }
/* 2353 */     if (paramInt2 <= 0 || paramInt1 >= this.size) {
/* 2354 */       return "";
/*      */     }
/* 2356 */     if (this.size <= paramInt1 + paramInt2) {
/* 2357 */       return new String(this.buffer, paramInt1, this.size - paramInt1);
/*      */     }
/* 2359 */     return new String(this.buffer, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean contains(char paramChar) {
/* 2370 */     char[] arrayOfChar = this.buffer;
/* 2371 */     for (byte b = 0; b < this.size; b++) {
/* 2372 */       if (arrayOfChar[b] == paramChar) {
/* 2373 */         return true;
/*      */       }
/*      */     } 
/* 2376 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean contains(String paramString) {
/* 2386 */     return (indexOf(paramString, 0) >= 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean contains(StrMatcher paramStrMatcher) {
/* 2401 */     return (indexOf(paramStrMatcher, 0) >= 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int indexOf(char paramChar) {
/* 2412 */     return indexOf(paramChar, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int indexOf(char paramChar, int paramInt) {
/* 2423 */     paramInt = Math.max(paramInt, 0);
/* 2424 */     if (paramInt >= this.size) {
/* 2425 */       return -1;
/*      */     }
/* 2427 */     char[] arrayOfChar = this.buffer;
/* 2428 */     for (int i = paramInt; i < this.size; i++) {
/* 2429 */       if (arrayOfChar[i] == paramChar) {
/* 2430 */         return i;
/*      */       }
/*      */     } 
/* 2433 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int indexOf(String paramString) {
/* 2445 */     return indexOf(paramString, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int indexOf(String paramString, int paramInt) {
/* 2459 */     paramInt = Math.max(paramInt, 0);
/* 2460 */     if (paramString == null || paramInt >= this.size) {
/* 2461 */       return -1;
/*      */     }
/* 2463 */     int i = paramString.length();
/* 2464 */     if (i == 1) {
/* 2465 */       return indexOf(paramString.charAt(0), paramInt);
/*      */     }
/* 2467 */     if (i == 0) {
/* 2468 */       return paramInt;
/*      */     }
/* 2470 */     if (i > this.size) {
/* 2471 */       return -1;
/*      */     }
/* 2473 */     char[] arrayOfChar = this.buffer;
/* 2474 */     int j = this.size - i + 1;
/*      */     
/* 2476 */     for (int k = paramInt; k < j; k++) {
/* 2477 */       byte b = 0; while (true) { if (b < i) {
/* 2478 */           if (paramString.charAt(b) != arrayOfChar[k + b])
/*      */             break;  b++;
/*      */           continue;
/*      */         } 
/* 2482 */         return k; }
/*      */     
/* 2484 */     }  return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int indexOf(StrMatcher paramStrMatcher) {
/* 2498 */     return indexOf(paramStrMatcher, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int indexOf(StrMatcher paramStrMatcher, int paramInt) {
/* 2514 */     paramInt = Math.max(paramInt, 0);
/* 2515 */     if (paramStrMatcher == null || paramInt >= this.size) {
/* 2516 */       return -1;
/*      */     }
/* 2518 */     int i = this.size;
/* 2519 */     char[] arrayOfChar = this.buffer;
/* 2520 */     for (int j = paramInt; j < i; j++) {
/* 2521 */       if (paramStrMatcher.isMatch(arrayOfChar, j, paramInt, i) > 0) {
/* 2522 */         return j;
/*      */       }
/*      */     } 
/* 2525 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int lastIndexOf(char paramChar) {
/* 2536 */     return lastIndexOf(paramChar, this.size - 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int lastIndexOf(char paramChar, int paramInt) {
/* 2547 */     paramInt = (paramInt >= this.size) ? (this.size - 1) : paramInt;
/* 2548 */     if (paramInt < 0) {
/* 2549 */       return -1;
/*      */     }
/* 2551 */     for (int i = paramInt; i >= 0; i--) {
/* 2552 */       if (this.buffer[i] == paramChar) {
/* 2553 */         return i;
/*      */       }
/*      */     } 
/* 2556 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int lastIndexOf(String paramString) {
/* 2568 */     return lastIndexOf(paramString, this.size - 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int lastIndexOf(String paramString, int paramInt) {
/* 2582 */     paramInt = (paramInt >= this.size) ? (this.size - 1) : paramInt;
/* 2583 */     if (paramString == null || paramInt < 0) {
/* 2584 */       return -1;
/*      */     }
/* 2586 */     int i = paramString.length();
/* 2587 */     if (i > 0 && i <= this.size) {
/* 2588 */       if (i == 1) {
/* 2589 */         return lastIndexOf(paramString.charAt(0), paramInt);
/*      */       }
/*      */ 
/*      */       
/* 2593 */       for (int j = paramInt - i + 1; j >= 0; j--) {
/* 2594 */         byte b = 0; while (true) { if (b < i) {
/* 2595 */             if (paramString.charAt(b) != this.buffer[j + b])
/*      */               break;  b++;
/*      */             continue;
/*      */           } 
/* 2599 */           return j; }
/*      */       
/*      */       } 
/* 2602 */     } else if (i == 0) {
/* 2603 */       return paramInt;
/*      */     } 
/* 2605 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int lastIndexOf(StrMatcher paramStrMatcher) {
/* 2619 */     return lastIndexOf(paramStrMatcher, this.size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int lastIndexOf(StrMatcher paramStrMatcher, int paramInt) {
/* 2635 */     paramInt = (paramInt >= this.size) ? (this.size - 1) : paramInt;
/* 2636 */     if (paramStrMatcher == null || paramInt < 0) {
/* 2637 */       return -1;
/*      */     }
/* 2639 */     char[] arrayOfChar = this.buffer;
/* 2640 */     int i = paramInt + 1;
/* 2641 */     for (int j = paramInt; j >= 0; j--) {
/* 2642 */       if (paramStrMatcher.isMatch(arrayOfChar, j, 0, i) > 0) {
/* 2643 */         return j;
/*      */       }
/*      */     } 
/* 2646 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer asTokenizer() {
/* 2683 */     return new StrBuilderTokenizer();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Reader asReader() {
/* 2707 */     return new StrBuilderReader();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Writer asWriter() {
/* 2732 */     return new StrBuilderWriter();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void appendTo(Appendable paramAppendable) throws IOException {
/* 2748 */     if (paramAppendable instanceof Writer) {
/* 2749 */       ((Writer)paramAppendable).write(this.buffer, 0, this.size);
/* 2750 */     } else if (paramAppendable instanceof StringBuilder) {
/* 2751 */       ((StringBuilder)paramAppendable).append(this.buffer, 0, this.size);
/* 2752 */     } else if (paramAppendable instanceof StringBuffer) {
/* 2753 */       ((StringBuffer)paramAppendable).append(this.buffer, 0, this.size);
/* 2754 */     } else if (paramAppendable instanceof CharBuffer) {
/* 2755 */       ((CharBuffer)paramAppendable).put(this.buffer, 0, this.size);
/*      */     } else {
/* 2757 */       paramAppendable.append(this);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equalsIgnoreCase(StrBuilder paramStrBuilder) {
/* 2769 */     if (this == paramStrBuilder) {
/* 2770 */       return true;
/*      */     }
/* 2772 */     if (this.size != paramStrBuilder.size) {
/* 2773 */       return false;
/*      */     }
/* 2775 */     char[] arrayOfChar1 = this.buffer;
/* 2776 */     char[] arrayOfChar2 = paramStrBuilder.buffer;
/* 2777 */     for (int i = this.size - 1; i >= 0; i--) {
/* 2778 */       char c1 = arrayOfChar1[i];
/* 2779 */       char c2 = arrayOfChar2[i];
/* 2780 */       if (c1 != c2 && Character.toUpperCase(c1) != Character.toUpperCase(c2)) {
/* 2781 */         return false;
/*      */       }
/*      */     } 
/* 2784 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(StrBuilder paramStrBuilder) {
/* 2795 */     if (this == paramStrBuilder) {
/* 2796 */       return true;
/*      */     }
/* 2798 */     if (paramStrBuilder == null) {
/* 2799 */       return false;
/*      */     }
/* 2801 */     if (this.size != paramStrBuilder.size) {
/* 2802 */       return false;
/*      */     }
/* 2804 */     char[] arrayOfChar1 = this.buffer;
/* 2805 */     char[] arrayOfChar2 = paramStrBuilder.buffer;
/* 2806 */     for (int i = this.size - 1; i >= 0; i--) {
/* 2807 */       if (arrayOfChar1[i] != arrayOfChar2[i]) {
/* 2808 */         return false;
/*      */       }
/*      */     } 
/* 2811 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(Object paramObject) {
/* 2823 */     return (paramObject instanceof StrBuilder && equals((StrBuilder)paramObject));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/* 2833 */     char[] arrayOfChar = this.buffer;
/* 2834 */     int i = 0;
/* 2835 */     for (int j = this.size - 1; j >= 0; j--) {
/* 2836 */       i = 31 * i + arrayOfChar[j];
/*      */     }
/* 2838 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 2853 */     return new String(this.buffer, 0, this.size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuffer toStringBuffer() {
/* 2863 */     return (new StringBuffer(this.size)).append(this.buffer, 0, this.size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder toStringBuilder() {
/* 2874 */     return (new StringBuilder(this.size)).append(this.buffer, 0, this.size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String build() {
/* 2885 */     return toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int validateRange(int paramInt1, int paramInt2) {
/* 2899 */     if (paramInt1 < 0) {
/* 2900 */       throw new StringIndexOutOfBoundsException(paramInt1);
/*      */     }
/* 2902 */     if (paramInt2 > this.size) {
/* 2903 */       paramInt2 = this.size;
/*      */     }
/* 2905 */     if (paramInt1 > paramInt2) {
/* 2906 */       throw new StringIndexOutOfBoundsException("end < start");
/*      */     }
/* 2908 */     return paramInt2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void validateIndex(int paramInt) {
/* 2918 */     if (paramInt < 0 || paramInt > this.size) {
/* 2919 */       throw new StringIndexOutOfBoundsException(paramInt);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class StrBuilderTokenizer
/*      */     extends StrTokenizer
/*      */   {
/*      */     protected List<String> tokenize(char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
/* 2939 */       if (param1ArrayOfchar == null) {
/* 2940 */         return super.tokenize(StrBuilder.this.buffer, 0, StrBuilder.this.size());
/*      */       }
/* 2942 */       return super.tokenize(param1ArrayOfchar, param1Int1, param1Int2);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String getContent() {
/* 2948 */       String str = super.getContent();
/* 2949 */       if (str == null) {
/* 2950 */         return StrBuilder.this.toString();
/*      */       }
/* 2952 */       return str;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class StrBuilderReader
/*      */     extends Reader
/*      */   {
/*      */     private int pos;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int mark;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int read() {
/* 2982 */       if (!ready()) {
/* 2983 */         return -1;
/*      */       }
/* 2985 */       return StrBuilder.this.charAt(this.pos++);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int read(char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
/* 2991 */       if (param1Int1 < 0 || param1Int2 < 0 || param1Int1 > param1ArrayOfchar.length || param1Int1 + param1Int2 > param1ArrayOfchar.length || param1Int1 + param1Int2 < 0)
/*      */       {
/* 2993 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 2995 */       if (param1Int2 == 0) {
/* 2996 */         return 0;
/*      */       }
/* 2998 */       if (this.pos >= StrBuilder.this.size()) {
/* 2999 */         return -1;
/*      */       }
/* 3001 */       if (this.pos + param1Int2 > StrBuilder.this.size()) {
/* 3002 */         param1Int2 = StrBuilder.this.size() - this.pos;
/*      */       }
/* 3004 */       StrBuilder.this.getChars(this.pos, this.pos + param1Int2, param1ArrayOfchar, param1Int1);
/* 3005 */       this.pos += param1Int2;
/* 3006 */       return param1Int2;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public long skip(long param1Long) {
/* 3012 */       if (this.pos + param1Long > StrBuilder.this.size()) {
/* 3013 */         param1Long = (StrBuilder.this.size() - this.pos);
/*      */       }
/* 3015 */       if (param1Long < 0L) {
/* 3016 */         return 0L;
/*      */       }
/* 3018 */       this.pos = (int)(this.pos + param1Long);
/* 3019 */       return param1Long;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean ready() {
/* 3025 */       return (this.pos < StrBuilder.this.size());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean markSupported() {
/* 3031 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void mark(int param1Int) {
/* 3037 */       this.mark = this.pos;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void reset() {
/* 3043 */       this.pos = this.mark;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class StrBuilderWriter
/*      */     extends Writer
/*      */   {
/*      */     public void close() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void flush() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void write(int param1Int) {
/* 3075 */       StrBuilder.this.append((char)param1Int);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void write(char[] param1ArrayOfchar) {
/* 3081 */       StrBuilder.this.append(param1ArrayOfchar);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void write(char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
/* 3087 */       StrBuilder.this.append(param1ArrayOfchar, param1Int1, param1Int2);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void write(String param1String) {
/* 3093 */       StrBuilder.this.append(param1String);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void write(String param1String, int param1Int1, int param1Int2) {
/* 3099 */       StrBuilder.this.append(param1String, param1Int1, param1Int2);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\text\StrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */