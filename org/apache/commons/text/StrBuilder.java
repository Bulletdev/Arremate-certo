/*      */ package org.apache.commons.text;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   char[] buffer;
/*      */   private int size;
/*      */   private String newLine;
/*      */   private String nullText;
/*      */   
/*      */   public StrBuilder() {
/*  102 */     this(32);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder(int paramInt) {
/*  112 */     if (paramInt <= 0) {
/*  113 */       paramInt = 32;
/*      */     }
/*  115 */     this.buffer = new char[paramInt];
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
/*  126 */     if (paramString == null) {
/*  127 */       this.buffer = new char[32];
/*      */     } else {
/*  129 */       this.buffer = new char[paramString.length() + 32];
/*  130 */       append(paramString);
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
/*  141 */     return this.newLine;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder setNewLineText(String paramString) {
/*  151 */     this.newLine = paramString;
/*  152 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNullText() {
/*  162 */     return this.nullText;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder setNullText(String paramString) {
/*  172 */     if (paramString != null && paramString.isEmpty()) {
/*  173 */       paramString = null;
/*      */     }
/*  175 */     this.nullText = paramString;
/*  176 */     return this;
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
/*  187 */     return this.size;
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
/*  199 */     if (paramInt < 0) {
/*  200 */       throw new StringIndexOutOfBoundsException(paramInt);
/*      */     }
/*  202 */     if (paramInt < this.size) {
/*  203 */       this.size = paramInt;
/*  204 */     } else if (paramInt > this.size) {
/*  205 */       ensureCapacity(paramInt);
/*  206 */       int i = this.size;
/*  207 */       int j = paramInt;
/*  208 */       this.size = paramInt;
/*  209 */       for (int k = i; k < j; k++) {
/*  210 */         this.buffer[k] = Character.MIN_VALUE;
/*      */       }
/*      */     } 
/*  213 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int capacity() {
/*  223 */     return this.buffer.length;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder ensureCapacity(int paramInt) {
/*  233 */     if (paramInt > this.buffer.length) {
/*  234 */       char[] arrayOfChar = this.buffer;
/*  235 */       this.buffer = new char[paramInt * 2];
/*  236 */       System.arraycopy(arrayOfChar, 0, this.buffer, 0, this.size);
/*      */     } 
/*  238 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder minimizeCapacity() {
/*  247 */     if (this.buffer.length > length()) {
/*  248 */       char[] arrayOfChar = this.buffer;
/*  249 */       this.buffer = new char[length()];
/*  250 */       System.arraycopy(arrayOfChar, 0, this.buffer, 0, this.size);
/*      */     } 
/*  252 */     return this;
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
/*  265 */     return this.size;
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
/*  277 */     return (this.size == 0);
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
/*  292 */     this.size = 0;
/*  293 */     return this;
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
/*  308 */     if (paramInt < 0 || paramInt >= length()) {
/*  309 */       throw new StringIndexOutOfBoundsException(paramInt);
/*      */     }
/*  311 */     return this.buffer[paramInt];
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
/*  325 */     if (paramInt < 0 || paramInt >= length()) {
/*  326 */       throw new StringIndexOutOfBoundsException(paramInt);
/*      */     }
/*  328 */     this.buffer[paramInt] = paramChar;
/*  329 */     return this;
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
/*  342 */     if (paramInt < 0 || paramInt >= this.size) {
/*  343 */       throw new StringIndexOutOfBoundsException(paramInt);
/*      */     }
/*  345 */     deleteImpl(paramInt, paramInt + 1, 1);
/*  346 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public char[] toCharArray() {
/*  356 */     if (this.size == 0) {
/*  357 */       return ArrayUtils.EMPTY_CHAR_ARRAY;
/*      */     }
/*  359 */     char[] arrayOfChar = new char[this.size];
/*  360 */     System.arraycopy(this.buffer, 0, arrayOfChar, 0, this.size);
/*  361 */     return arrayOfChar;
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
/*  375 */     paramInt2 = validateRange(paramInt1, paramInt2);
/*  376 */     int i = paramInt2 - paramInt1;
/*  377 */     if (i == 0) {
/*  378 */       return ArrayUtils.EMPTY_CHAR_ARRAY;
/*      */     }
/*  380 */     char[] arrayOfChar = new char[i];
/*  381 */     System.arraycopy(this.buffer, paramInt1, arrayOfChar, 0, i);
/*  382 */     return arrayOfChar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public char[] getChars(char[] paramArrayOfchar) {
/*  392 */     int i = length();
/*  393 */     if (paramArrayOfchar == null || paramArrayOfchar.length < i) {
/*  394 */       paramArrayOfchar = new char[i];
/*      */     }
/*  396 */     System.arraycopy(this.buffer, 0, paramArrayOfchar, 0, i);
/*  397 */     return paramArrayOfchar;
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
/*      */   public void getChars(int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3) {
/*  414 */     if (paramInt1 < 0) {
/*  415 */       throw new StringIndexOutOfBoundsException(paramInt1);
/*      */     }
/*  417 */     if (paramInt2 < 0 || paramInt2 > length()) {
/*  418 */       throw new StringIndexOutOfBoundsException(paramInt2);
/*      */     }
/*  420 */     if (paramInt1 > paramInt2) {
/*  421 */       throw new StringIndexOutOfBoundsException("end < start");
/*      */     }
/*  423 */     System.arraycopy(this.buffer, paramInt1, paramArrayOfchar, paramInt3, paramInt2 - paramInt1);
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
/*      */   public int readFrom(Readable paramReadable) throws IOException {
/*  438 */     int i = this.size;
/*  439 */     if (paramReadable instanceof Reader) {
/*  440 */       Reader reader = (Reader)paramReadable;
/*  441 */       ensureCapacity(this.size + 1);
/*      */       int j;
/*  443 */       while ((j = reader.read(this.buffer, this.size, this.buffer.length - this.size)) != -1) {
/*  444 */         this.size += j;
/*  445 */         ensureCapacity(this.size + 1);
/*      */       } 
/*  447 */     } else if (paramReadable instanceof CharBuffer) {
/*  448 */       CharBuffer charBuffer = (CharBuffer)paramReadable;
/*  449 */       int j = charBuffer.remaining();
/*  450 */       ensureCapacity(this.size + j);
/*  451 */       charBuffer.get(this.buffer, this.size, j);
/*  452 */       this.size += j;
/*      */     } else {
/*      */       while (true) {
/*  455 */         ensureCapacity(this.size + 1);
/*  456 */         CharBuffer charBuffer = CharBuffer.wrap(this.buffer, this.size, this.buffer.length - this.size);
/*  457 */         int j = paramReadable.read(charBuffer);
/*  458 */         if (j == -1) {
/*      */           break;
/*      */         }
/*  461 */         this.size += j;
/*      */       } 
/*      */     } 
/*  464 */     return this.size - i;
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
/*  478 */     if (this.newLine == null) {
/*  479 */       append(System.lineSeparator());
/*  480 */       return this;
/*      */     } 
/*  482 */     return append(this.newLine);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendNull() {
/*  491 */     if (this.nullText == null) {
/*  492 */       return this;
/*      */     }
/*  494 */     return append(this.nullText);
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
/*  505 */     if (paramObject == null) {
/*  506 */       return appendNull();
/*      */     }
/*  508 */     if (paramObject instanceof CharSequence) {
/*  509 */       return append((CharSequence)paramObject);
/*      */     }
/*  511 */     return append(paramObject.toString());
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
/*      */   public StrBuilder append(CharSequence paramCharSequence) {
/*  523 */     if (paramCharSequence == null) {
/*  524 */       return appendNull();
/*      */     }
/*  526 */     if (paramCharSequence instanceof StrBuilder) {
/*  527 */       return append((StrBuilder)paramCharSequence);
/*      */     }
/*  529 */     if (paramCharSequence instanceof StringBuilder) {
/*  530 */       return append((StringBuilder)paramCharSequence);
/*      */     }
/*  532 */     if (paramCharSequence instanceof StringBuffer) {
/*  533 */       return append((StringBuffer)paramCharSequence);
/*      */     }
/*  535 */     if (paramCharSequence instanceof CharBuffer) {
/*  536 */       return append((CharBuffer)paramCharSequence);
/*      */     }
/*  538 */     return append(paramCharSequence.toString());
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
/*      */   public StrBuilder append(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*  552 */     if (paramCharSequence == null) {
/*  553 */       return appendNull();
/*      */     }
/*  555 */     return append(paramCharSequence.toString(), paramInt1, paramInt2);
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
/*  566 */     if (paramString == null) {
/*  567 */       return appendNull();
/*      */     }
/*  569 */     int i = paramString.length();
/*  570 */     if (i > 0) {
/*  571 */       int j = length();
/*  572 */       ensureCapacity(j + i);
/*  573 */       paramString.getChars(0, i, this.buffer, j);
/*  574 */       this.size += i;
/*      */     } 
/*  576 */     return this;
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
/*  590 */     if (paramString == null) {
/*  591 */       return appendNull();
/*      */     }
/*  593 */     if (paramInt1 < 0 || paramInt1 > paramString.length()) {
/*  594 */       throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */     }
/*  596 */     if (paramInt2 < 0 || paramInt1 + paramInt2 > paramString.length()) {
/*  597 */       throw new StringIndexOutOfBoundsException("length must be valid");
/*      */     }
/*  599 */     if (paramInt2 > 0) {
/*  600 */       int i = length();
/*  601 */       ensureCapacity(i + paramInt2);
/*  602 */       paramString.getChars(paramInt1, paramInt1 + paramInt2, this.buffer, i);
/*  603 */       this.size += paramInt2;
/*      */     } 
/*  605 */     return this;
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
/*      */   public StrBuilder append(String paramString, Object... paramVarArgs) {
/*  617 */     return append(String.format(paramString, paramVarArgs));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(CharBuffer paramCharBuffer) {
/*  628 */     if (paramCharBuffer == null) {
/*  629 */       return appendNull();
/*      */     }
/*  631 */     if (paramCharBuffer.hasArray()) {
/*  632 */       int i = paramCharBuffer.remaining();
/*  633 */       int j = length();
/*  634 */       ensureCapacity(j + i);
/*  635 */       System.arraycopy(paramCharBuffer.array(), paramCharBuffer.arrayOffset() + paramCharBuffer.position(), this.buffer, j, i);
/*  636 */       this.size += i;
/*      */     } else {
/*  638 */       append(paramCharBuffer.toString());
/*      */     } 
/*  640 */     return this;
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
/*      */   public StrBuilder append(CharBuffer paramCharBuffer, int paramInt1, int paramInt2) {
/*  653 */     if (paramCharBuffer == null) {
/*  654 */       return appendNull();
/*      */     }
/*  656 */     if (paramCharBuffer.hasArray()) {
/*  657 */       int i = paramCharBuffer.remaining();
/*  658 */       if (paramInt1 < 0 || paramInt1 > i) {
/*  659 */         throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */       }
/*  661 */       if (paramInt2 < 0 || paramInt1 + paramInt2 > i) {
/*  662 */         throw new StringIndexOutOfBoundsException("length must be valid");
/*      */       }
/*  664 */       int j = length();
/*  665 */       ensureCapacity(j + paramInt2);
/*  666 */       System.arraycopy(paramCharBuffer.array(), paramCharBuffer.arrayOffset() + paramCharBuffer.position() + paramInt1, this.buffer, j, paramInt2);
/*  667 */       this.size += paramInt2;
/*      */     } else {
/*  669 */       append(paramCharBuffer.toString(), paramInt1, paramInt2);
/*      */     } 
/*  671 */     return this;
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
/*  682 */     if (paramStringBuffer == null) {
/*  683 */       return appendNull();
/*      */     }
/*  685 */     int i = paramStringBuffer.length();
/*  686 */     if (i > 0) {
/*  687 */       int j = length();
/*  688 */       ensureCapacity(j + i);
/*  689 */       paramStringBuffer.getChars(0, i, this.buffer, j);
/*  690 */       this.size += i;
/*      */     } 
/*  692 */     return this;
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
/*  705 */     if (paramStringBuffer == null) {
/*  706 */       return appendNull();
/*      */     }
/*  708 */     if (paramInt1 < 0 || paramInt1 > paramStringBuffer.length()) {
/*  709 */       throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */     }
/*  711 */     if (paramInt2 < 0 || paramInt1 + paramInt2 > paramStringBuffer.length()) {
/*  712 */       throw new StringIndexOutOfBoundsException("length must be valid");
/*      */     }
/*  714 */     if (paramInt2 > 0) {
/*  715 */       int i = length();
/*  716 */       ensureCapacity(i + paramInt2);
/*  717 */       paramStringBuffer.getChars(paramInt1, paramInt1 + paramInt2, this.buffer, i);
/*  718 */       this.size += paramInt2;
/*      */     } 
/*  720 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(StringBuilder paramStringBuilder) {
/*  731 */     if (paramStringBuilder == null) {
/*  732 */       return appendNull();
/*      */     }
/*  734 */     int i = paramStringBuilder.length();
/*  735 */     if (i > 0) {
/*  736 */       int j = length();
/*  737 */       ensureCapacity(j + i);
/*  738 */       paramStringBuilder.getChars(0, i, this.buffer, j);
/*  739 */       this.size += i;
/*      */     } 
/*  741 */     return this;
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
/*      */   public StrBuilder append(StringBuilder paramStringBuilder, int paramInt1, int paramInt2) {
/*  754 */     if (paramStringBuilder == null) {
/*  755 */       return appendNull();
/*      */     }
/*  757 */     if (paramInt1 < 0 || paramInt1 > paramStringBuilder.length()) {
/*  758 */       throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */     }
/*  760 */     if (paramInt2 < 0 || paramInt1 + paramInt2 > paramStringBuilder.length()) {
/*  761 */       throw new StringIndexOutOfBoundsException("length must be valid");
/*      */     }
/*  763 */     if (paramInt2 > 0) {
/*  764 */       int i = length();
/*  765 */       ensureCapacity(i + paramInt2);
/*  766 */       paramStringBuilder.getChars(paramInt1, paramInt1 + paramInt2, this.buffer, i);
/*  767 */       this.size += paramInt2;
/*      */     } 
/*  769 */     return this;
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
/*  780 */     if (paramStrBuilder == null) {
/*  781 */       return appendNull();
/*      */     }
/*  783 */     int i = paramStrBuilder.length();
/*  784 */     if (i > 0) {
/*  785 */       int j = length();
/*  786 */       ensureCapacity(j + i);
/*  787 */       System.arraycopy(paramStrBuilder.buffer, 0, this.buffer, j, i);
/*  788 */       this.size += i;
/*      */     } 
/*  790 */     return this;
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
/*  803 */     if (paramStrBuilder == null) {
/*  804 */       return appendNull();
/*      */     }
/*  806 */     if (paramInt1 < 0 || paramInt1 > paramStrBuilder.length()) {
/*  807 */       throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */     }
/*  809 */     if (paramInt2 < 0 || paramInt1 + paramInt2 > paramStrBuilder.length()) {
/*  810 */       throw new StringIndexOutOfBoundsException("length must be valid");
/*      */     }
/*  812 */     if (paramInt2 > 0) {
/*  813 */       int i = length();
/*  814 */       ensureCapacity(i + paramInt2);
/*  815 */       paramStrBuilder.getChars(paramInt1, paramInt1 + paramInt2, this.buffer, i);
/*  816 */       this.size += paramInt2;
/*      */     } 
/*  818 */     return this;
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
/*  829 */     if (paramArrayOfchar == null) {
/*  830 */       return appendNull();
/*      */     }
/*  832 */     int i = paramArrayOfchar.length;
/*  833 */     if (i > 0) {
/*  834 */       int j = length();
/*  835 */       ensureCapacity(j + i);
/*  836 */       System.arraycopy(paramArrayOfchar, 0, this.buffer, j, i);
/*  837 */       this.size += i;
/*      */     } 
/*  839 */     return this;
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
/*  852 */     if (paramArrayOfchar == null) {
/*  853 */       return appendNull();
/*      */     }
/*  855 */     if (paramInt1 < 0 || paramInt1 > paramArrayOfchar.length) {
/*  856 */       throw new StringIndexOutOfBoundsException("Invalid startIndex: " + paramInt2);
/*      */     }
/*  858 */     if (paramInt2 < 0 || paramInt1 + paramInt2 > paramArrayOfchar.length) {
/*  859 */       throw new StringIndexOutOfBoundsException("Invalid length: " + paramInt2);
/*      */     }
/*  861 */     if (paramInt2 > 0) {
/*  862 */       int i = length();
/*  863 */       ensureCapacity(i + paramInt2);
/*  864 */       System.arraycopy(paramArrayOfchar, paramInt1, this.buffer, i, paramInt2);
/*  865 */       this.size += paramInt2;
/*      */     } 
/*  867 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(boolean paramBoolean) {
/*  877 */     if (paramBoolean) {
/*  878 */       ensureCapacity(this.size + 4);
/*  879 */       this.buffer[this.size++] = 't';
/*  880 */       this.buffer[this.size++] = 'r';
/*  881 */       this.buffer[this.size++] = 'u';
/*  882 */       this.buffer[this.size++] = 'e';
/*      */     } else {
/*  884 */       ensureCapacity(this.size + 5);
/*  885 */       this.buffer[this.size++] = 'f';
/*  886 */       this.buffer[this.size++] = 'a';
/*  887 */       this.buffer[this.size++] = 'l';
/*  888 */       this.buffer[this.size++] = 's';
/*  889 */       this.buffer[this.size++] = 'e';
/*      */     } 
/*  891 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(char paramChar) {
/*  902 */     int i = length();
/*  903 */     ensureCapacity(i + 1);
/*  904 */     this.buffer[this.size++] = paramChar;
/*  905 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(int paramInt) {
/*  915 */     return append(String.valueOf(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(long paramLong) {
/*  925 */     return append(String.valueOf(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(float paramFloat) {
/*  935 */     return append(String.valueOf(paramFloat));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(double paramDouble) {
/*  945 */     return append(String.valueOf(paramDouble));
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
/*      */   public StrBuilder appendln(Object paramObject) {
/*  957 */     return append(paramObject).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(String paramString) {
/*  968 */     return append(paramString).appendNewLine();
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
/*      */   public StrBuilder appendln(String paramString, int paramInt1, int paramInt2) {
/*  981 */     return append(paramString, paramInt1, paramInt2).appendNewLine();
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
/*      */   public StrBuilder appendln(String paramString, Object... paramVarArgs) {
/*  993 */     return append(paramString, paramVarArgs).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(StringBuffer paramStringBuffer) {
/* 1004 */     return append(paramStringBuffer).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(StringBuilder paramStringBuilder) {
/* 1015 */     return append(paramStringBuilder).appendNewLine();
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
/*      */   public StrBuilder appendln(StringBuilder paramStringBuilder, int paramInt1, int paramInt2) {
/* 1028 */     return append(paramStringBuilder, paramInt1, paramInt2).appendNewLine();
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
/*      */   public StrBuilder appendln(StringBuffer paramStringBuffer, int paramInt1, int paramInt2) {
/* 1041 */     return append(paramStringBuffer, paramInt1, paramInt2).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(StrBuilder paramStrBuilder) {
/* 1052 */     return append(paramStrBuilder).appendNewLine();
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
/*      */   public StrBuilder appendln(StrBuilder paramStrBuilder, int paramInt1, int paramInt2) {
/* 1065 */     return append(paramStrBuilder, paramInt1, paramInt2).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(char[] paramArrayOfchar) {
/* 1076 */     return append(paramArrayOfchar).appendNewLine();
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
/*      */   public StrBuilder appendln(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 1089 */     return append(paramArrayOfchar, paramInt1, paramInt2).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(boolean paramBoolean) {
/* 1099 */     return append(paramBoolean).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(char paramChar) {
/* 1109 */     return append(paramChar).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(int paramInt) {
/* 1119 */     return append(paramInt).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(long paramLong) {
/* 1129 */     return append(paramLong).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(float paramFloat) {
/* 1139 */     return append(paramFloat).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(double paramDouble) {
/* 1149 */     return append(paramDouble).appendNewLine();
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
/*      */   public <T> StrBuilder appendAll(T... paramVarArgs) {
/* 1169 */     if (paramVarArgs != null && paramVarArgs.length > 0) {
/* 1170 */       for (T t : paramVarArgs) {
/* 1171 */         append(t);
/*      */       }
/*      */     }
/* 1174 */     return this;
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
/*      */   public StrBuilder appendAll(Iterable<?> paramIterable) {
/* 1186 */     if (paramIterable != null) {
/* 1187 */       for (Object object : paramIterable) {
/* 1188 */         append(object);
/*      */       }
/*      */     }
/* 1191 */     return this;
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
/*      */   public StrBuilder appendAll(Iterator<?> paramIterator) {
/* 1203 */     if (paramIterator != null) {
/* 1204 */       while (paramIterator.hasNext()) {
/* 1205 */         append(paramIterator.next());
/*      */       }
/*      */     }
/* 1208 */     return this;
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
/* 1223 */     if (paramArrayOfObject != null && paramArrayOfObject.length > 0) {
/* 1224 */       String str = Objects.toString(paramString, "");
/* 1225 */       append(paramArrayOfObject[0]);
/* 1226 */       for (byte b = 1; b < paramArrayOfObject.length; b++) {
/* 1227 */         append(str);
/* 1228 */         append(paramArrayOfObject[b]);
/*      */       } 
/*      */     } 
/* 1231 */     return this;
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
/* 1245 */     if (paramIterable != null) {
/* 1246 */       String str = Objects.toString(paramString, "");
/* 1247 */       Iterator<?> iterator = paramIterable.iterator();
/* 1248 */       while (iterator.hasNext()) {
/* 1249 */         append(iterator.next());
/* 1250 */         if (iterator.hasNext()) {
/* 1251 */           append(str);
/*      */         }
/*      */       } 
/*      */     } 
/* 1255 */     return this;
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
/* 1269 */     if (paramIterator != null) {
/* 1270 */       String str = Objects.toString(paramString, "");
/* 1271 */       while (paramIterator.hasNext()) {
/* 1272 */         append(paramIterator.next());
/* 1273 */         if (paramIterator.hasNext()) {
/* 1274 */           append(str);
/*      */         }
/*      */       } 
/*      */     } 
/* 1278 */     return this;
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
/*      */   public StrBuilder appendSeparator(String paramString) {
/* 1302 */     return appendSeparator(paramString, (String)null);
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
/*      */   public StrBuilder appendSeparator(String paramString1, String paramString2) {
/* 1332 */     String str = isEmpty() ? paramString2 : paramString1;
/* 1333 */     if (str != null) {
/* 1334 */       append(str);
/*      */     }
/* 1336 */     return this;
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
/*      */   public StrBuilder appendSeparator(char paramChar) {
/* 1358 */     if (size() > 0) {
/* 1359 */       append(paramChar);
/*      */     }
/* 1361 */     return this;
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
/*      */   public StrBuilder appendSeparator(char paramChar1, char paramChar2) {
/* 1375 */     if (size() > 0) {
/* 1376 */       append(paramChar1);
/*      */     } else {
/* 1378 */       append(paramChar2);
/*      */     } 
/* 1380 */     return this;
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
/*      */   public StrBuilder appendSeparator(String paramString, int paramInt) {
/* 1404 */     if (paramString != null && paramInt > 0) {
/* 1405 */       append(paramString);
/*      */     }
/* 1407 */     return this;
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
/*      */   public StrBuilder appendSeparator(char paramChar, int paramInt) {
/* 1431 */     if (paramInt > 0) {
/* 1432 */       append(paramChar);
/*      */     }
/* 1434 */     return this;
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
/* 1446 */     if (paramInt >= 0) {
/* 1447 */       ensureCapacity(this.size + paramInt);
/* 1448 */       for (byte b = 0; b < paramInt; b++) {
/* 1449 */         this.buffer[this.size++] = paramChar;
/*      */       }
/*      */     } 
/* 1452 */     return this;
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
/* 1468 */     if (paramInt > 0) {
/* 1469 */       ensureCapacity(this.size + paramInt);
/* 1470 */       String str = (paramObject == null) ? getNullText() : paramObject.toString();
/* 1471 */       if (str == null) {
/* 1472 */         str = "";
/*      */       }
/* 1474 */       int i = str.length();
/* 1475 */       if (i >= paramInt) {
/* 1476 */         str.getChars(i - paramInt, i, this.buffer, this.size);
/*      */       } else {
/* 1478 */         int j = paramInt - i;
/* 1479 */         for (byte b = 0; b < j; b++) {
/* 1480 */           this.buffer[this.size + b] = paramChar;
/*      */         }
/* 1482 */         str.getChars(0, i, this.buffer, this.size + j);
/*      */       } 
/* 1484 */       this.size += paramInt;
/*      */     } 
/* 1486 */     return this;
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
/* 1500 */     return appendFixedWidthPadLeft(String.valueOf(paramInt1), paramInt2, paramChar);
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
/* 1515 */     if (paramInt > 0) {
/* 1516 */       ensureCapacity(this.size + paramInt);
/* 1517 */       String str = (paramObject == null) ? getNullText() : paramObject.toString();
/* 1518 */       if (str == null) {
/* 1519 */         str = "";
/*      */       }
/* 1521 */       int i = str.length();
/* 1522 */       if (i >= paramInt) {
/* 1523 */         str.getChars(0, paramInt, this.buffer, this.size);
/*      */       } else {
/* 1525 */         int j = paramInt - i;
/* 1526 */         str.getChars(0, i, this.buffer, this.size);
/* 1527 */         for (byte b = 0; b < j; b++) {
/* 1528 */           this.buffer[this.size + i + b] = paramChar;
/*      */         }
/*      */       } 
/* 1531 */       this.size += paramInt;
/*      */     } 
/* 1533 */     return this;
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
/* 1547 */     return appendFixedWidthPadRight(String.valueOf(paramInt1), paramInt2, paramChar);
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
/* 1561 */     if (paramObject == null) {
/* 1562 */       return insert(paramInt, this.nullText);
/*      */     }
/* 1564 */     return insert(paramInt, paramObject.toString());
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
/* 1577 */     validateIndex(paramInt);
/* 1578 */     if (paramString == null) {
/* 1579 */       paramString = this.nullText;
/*      */     }
/* 1581 */     if (paramString != null) {
/* 1582 */       int i = paramString.length();
/* 1583 */       if (i > 0) {
/* 1584 */         int j = this.size + i;
/* 1585 */         ensureCapacity(j);
/* 1586 */         System.arraycopy(this.buffer, paramInt, this.buffer, paramInt + i, this.size - paramInt);
/* 1587 */         this.size = j;
/* 1588 */         paramString.getChars(0, i, this.buffer, paramInt);
/*      */       } 
/*      */     } 
/* 1591 */     return this;
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
/* 1604 */     validateIndex(paramInt);
/* 1605 */     if (paramArrayOfchar == null) {
/* 1606 */       return insert(paramInt, this.nullText);
/*      */     }
/* 1608 */     int i = paramArrayOfchar.length;
/* 1609 */     if (i > 0) {
/* 1610 */       ensureCapacity(this.size + i);
/* 1611 */       System.arraycopy(this.buffer, paramInt, this.buffer, paramInt + i, this.size - paramInt);
/* 1612 */       System.arraycopy(paramArrayOfchar, 0, this.buffer, paramInt, i);
/* 1613 */       this.size += i;
/*      */     } 
/* 1615 */     return this;
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
/* 1630 */     validateIndex(paramInt1);
/* 1631 */     if (paramArrayOfchar == null) {
/* 1632 */       return insert(paramInt1, this.nullText);
/*      */     }
/* 1634 */     if (paramInt2 < 0 || paramInt2 > paramArrayOfchar.length) {
/* 1635 */       throw new StringIndexOutOfBoundsException("Invalid offset: " + paramInt2);
/*      */     }
/* 1637 */     if (paramInt3 < 0 || paramInt2 + paramInt3 > paramArrayOfchar.length) {
/* 1638 */       throw new StringIndexOutOfBoundsException("Invalid length: " + paramInt3);
/*      */     }
/* 1640 */     if (paramInt3 > 0) {
/* 1641 */       ensureCapacity(this.size + paramInt3);
/* 1642 */       System.arraycopy(this.buffer, paramInt1, this.buffer, paramInt1 + paramInt3, this.size - paramInt1);
/* 1643 */       System.arraycopy(paramArrayOfchar, paramInt2, this.buffer, paramInt1, paramInt3);
/* 1644 */       this.size += paramInt3;
/*      */     } 
/* 1646 */     return this;
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
/* 1658 */     validateIndex(paramInt);
/* 1659 */     if (paramBoolean) {
/* 1660 */       ensureCapacity(this.size + 4);
/* 1661 */       System.arraycopy(this.buffer, paramInt, this.buffer, paramInt + 4, this.size - paramInt);
/* 1662 */       this.buffer[paramInt++] = 't';
/* 1663 */       this.buffer[paramInt++] = 'r';
/* 1664 */       this.buffer[paramInt++] = 'u';
/* 1665 */       this.buffer[paramInt] = 'e';
/* 1666 */       this.size += 4;
/*      */     } else {
/* 1668 */       ensureCapacity(this.size + 5);
/* 1669 */       System.arraycopy(this.buffer, paramInt, this.buffer, paramInt + 5, this.size - paramInt);
/* 1670 */       this.buffer[paramInt++] = 'f';
/* 1671 */       this.buffer[paramInt++] = 'a';
/* 1672 */       this.buffer[paramInt++] = 'l';
/* 1673 */       this.buffer[paramInt++] = 's';
/* 1674 */       this.buffer[paramInt] = 'e';
/* 1675 */       this.size += 5;
/*      */     } 
/* 1677 */     return this;
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
/* 1689 */     validateIndex(paramInt);
/* 1690 */     ensureCapacity(this.size + 1);
/* 1691 */     System.arraycopy(this.buffer, paramInt, this.buffer, paramInt + 1, this.size - paramInt);
/* 1692 */     this.buffer[paramInt] = paramChar;
/* 1693 */     this.size++;
/* 1694 */     return this;
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
/* 1706 */     return insert(paramInt1, String.valueOf(paramInt2));
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
/* 1718 */     return insert(paramInt, String.valueOf(paramLong));
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
/* 1730 */     return insert(paramInt, String.valueOf(paramFloat));
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
/* 1742 */     return insert(paramInt, String.valueOf(paramDouble));
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
/* 1755 */     System.arraycopy(this.buffer, paramInt2, this.buffer, paramInt1, this.size - paramInt2);
/* 1756 */     this.size -= paramInt3;
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
/* 1769 */     paramInt2 = validateRange(paramInt1, paramInt2);
/* 1770 */     int i = paramInt2 - paramInt1;
/* 1771 */     if (i > 0) {
/* 1772 */       deleteImpl(paramInt1, paramInt2, i);
/*      */     }
/* 1774 */     return this;
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
/* 1785 */     for (int i = 0; i < this.size; i++) {
/* 1786 */       if (this.buffer[i] == paramChar) {
/* 1787 */         int j = i; do {  }
/* 1788 */         while (++i < this.size && 
/* 1789 */           this.buffer[i] == paramChar);
/*      */ 
/*      */ 
/*      */         
/* 1793 */         int k = i - j;
/* 1794 */         deleteImpl(j, i, k);
/* 1795 */         i -= k;
/*      */       } 
/*      */     } 
/* 1798 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder deleteFirst(char paramChar) {
/* 1808 */     for (byte b = 0; b < this.size; b++) {
/* 1809 */       if (this.buffer[b] == paramChar) {
/* 1810 */         deleteImpl(b, b + 1, 1);
/*      */         break;
/*      */       } 
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
/*      */   public StrBuilder deleteAll(String paramString) {
/* 1825 */     byte b = (paramString == null) ? 0 : paramString.length();
/* 1826 */     if (b) {
/* 1827 */       int i = indexOf(paramString, 0);
/* 1828 */       while (i >= 0) {
/* 1829 */         deleteImpl(i, i + b, b);
/* 1830 */         i = indexOf(paramString, i);
/*      */       } 
/*      */     } 
/* 1833 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder deleteFirst(String paramString) {
/* 1843 */     byte b = (paramString == null) ? 0 : paramString.length();
/* 1844 */     if (b) {
/* 1845 */       int i = indexOf(paramString, 0);
/* 1846 */       if (i >= 0) {
/* 1847 */         deleteImpl(i, i + b, b);
/*      */       }
/*      */     } 
/* 1850 */     return this;
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
/* 1865 */     return replace(paramStrMatcher, null, 0, this.size, -1);
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
/* 1879 */     return replace(paramStrMatcher, null, 0, this.size, 1);
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
/*      */   private void replaceImpl(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4) {
/* 1898 */     int i = this.size - paramInt3 + paramInt4;
/* 1899 */     if (paramInt4 != paramInt3) {
/* 1900 */       ensureCapacity(i);
/* 1901 */       System.arraycopy(this.buffer, paramInt2, this.buffer, paramInt1 + paramInt4, this.size - paramInt2);
/* 1902 */       this.size = i;
/*      */     } 
/* 1904 */     if (paramInt4 > 0) {
/* 1905 */       paramString.getChars(0, paramInt4, this.buffer, paramInt1);
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
/* 1921 */     paramInt2 = validateRange(paramInt1, paramInt2);
/* 1922 */     boolean bool = (paramString == null) ? false : paramString.length();
/* 1923 */     replaceImpl(paramInt1, paramInt2, paramInt2 - paramInt1, paramString, bool);
/* 1924 */     return this;
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
/* 1937 */     if (paramChar1 != paramChar2) {
/* 1938 */       for (byte b = 0; b < this.size; b++) {
/* 1939 */         if (this.buffer[b] == paramChar1) {
/* 1940 */           this.buffer[b] = paramChar2;
/*      */         }
/*      */       } 
/*      */     }
/* 1944 */     return this;
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
/* 1956 */     if (paramChar1 != paramChar2) {
/* 1957 */       for (byte b = 0; b < this.size; b++) {
/* 1958 */         if (this.buffer[b] == paramChar1) {
/* 1959 */           this.buffer[b] = paramChar2;
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/* 1964 */     return this;
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
/* 1976 */     byte b = (paramString1 == null) ? 0 : paramString1.length();
/* 1977 */     if (b) {
/* 1978 */       byte b1 = (paramString2 == null) ? 0 : paramString2.length();
/* 1979 */       int i = indexOf(paramString1, 0);
/* 1980 */       while (i >= 0) {
/* 1981 */         replaceImpl(i, i + b, b, paramString2, b1);
/* 1982 */         i = indexOf(paramString1, i + b1);
/*      */       } 
/*      */     } 
/* 1985 */     return this;
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
/* 1996 */     byte b = (paramString1 == null) ? 0 : paramString1.length();
/* 1997 */     if (b) {
/* 1998 */       int i = indexOf(paramString1, 0);
/* 1999 */       if (i >= 0) {
/* 2000 */         boolean bool = (paramString2 == null) ? false : paramString2.length();
/* 2001 */         replaceImpl(i, i + b, b, paramString2, bool);
/*      */       } 
/*      */     } 
/* 2004 */     return this;
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
/* 2020 */     return replace(paramStrMatcher, paramString, 0, this.size, -1);
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
/* 2035 */     return replace(paramStrMatcher, paramString, 0, this.size, 1);
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
/* 2058 */     paramInt2 = validateRange(paramInt1, paramInt2);
/* 2059 */     return replaceImpl(paramStrMatcher, paramString, paramInt1, paramInt2, paramInt3);
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
/* 2080 */     if (paramStrMatcher == null || this.size == 0) {
/* 2081 */       return this;
/*      */     }
/* 2083 */     byte b = (paramString == null) ? 0 : paramString.length();
/* 2084 */     for (int i = paramInt1; i < paramInt2 && paramInt3 != 0; i++) {
/* 2085 */       char[] arrayOfChar = this.buffer;
/* 2086 */       int j = paramStrMatcher.isMatch(arrayOfChar, i, paramInt1, paramInt2);
/* 2087 */       if (j > 0) {
/* 2088 */         replaceImpl(i, i + j, j, paramString, b);
/* 2089 */         paramInt2 = paramInt2 - j + b;
/* 2090 */         i = i + b - 1;
/* 2091 */         if (paramInt3 > 0) {
/* 2092 */           paramInt3--;
/*      */         }
/*      */       } 
/*      */     } 
/* 2096 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder reverse() {
/* 2106 */     if (this.size == 0) {
/* 2107 */       return this;
/*      */     }
/*      */     
/* 2110 */     int i = this.size / 2;
/* 2111 */     char[] arrayOfChar = this.buffer; byte b; int j;
/* 2112 */     for (b = 0, j = this.size - 1; b < i; b++, j--) {
/* 2113 */       char c = arrayOfChar[b];
/* 2114 */       arrayOfChar[b] = arrayOfChar[j];
/* 2115 */       arrayOfChar[j] = c;
/*      */     } 
/* 2117 */     return this;
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
/* 2128 */     if (this.size == 0) {
/* 2129 */       return this;
/*      */     }
/* 2131 */     int i = this.size;
/* 2132 */     char[] arrayOfChar = this.buffer;
/* 2133 */     byte b = 0;
/* 2134 */     while (b < i && arrayOfChar[b] <= ' ') {
/* 2135 */       b++;
/*      */     }
/* 2137 */     while (b < i && arrayOfChar[i - 1] <= ' ') {
/* 2138 */       i--;
/*      */     }
/* 2140 */     if (i < this.size) {
/* 2141 */       delete(i, this.size);
/*      */     }
/* 2143 */     if (b > 0) {
/* 2144 */       delete(0, b);
/*      */     }
/* 2146 */     return this;
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
/* 2159 */     if (paramString == null) {
/* 2160 */       return false;
/*      */     }
/* 2162 */     int i = paramString.length();
/* 2163 */     if (i == 0) {
/* 2164 */       return true;
/*      */     }
/* 2166 */     if (i > this.size) {
/* 2167 */       return false;
/*      */     }
/* 2169 */     for (byte b = 0; b < i; b++) {
/* 2170 */       if (this.buffer[b] != paramString.charAt(b)) {
/* 2171 */         return false;
/*      */       }
/*      */     } 
/* 2174 */     return true;
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
/* 2186 */     if (paramString == null) {
/* 2187 */       return false;
/*      */     }
/* 2189 */     int i = paramString.length();
/* 2190 */     if (i == 0) {
/* 2191 */       return true;
/*      */     }
/* 2193 */     if (i > this.size) {
/* 2194 */       return false;
/*      */     }
/* 2196 */     int j = this.size - i;
/* 2197 */     for (byte b = 0; b < i; b++, j++) {
/* 2198 */       if (this.buffer[j] != paramString.charAt(b)) {
/* 2199 */         return false;
/*      */       }
/*      */     } 
/* 2202 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CharSequence subSequence(int paramInt1, int paramInt2) {
/* 2211 */     if (paramInt1 < 0) {
/* 2212 */       throw new StringIndexOutOfBoundsException(paramInt1);
/*      */     }
/* 2214 */     if (paramInt2 > this.size) {
/* 2215 */       throw new StringIndexOutOfBoundsException(paramInt2);
/*      */     }
/* 2217 */     if (paramInt1 > paramInt2) {
/* 2218 */       throw new StringIndexOutOfBoundsException(paramInt2 - paramInt1);
/*      */     }
/* 2220 */     return substring(paramInt1, paramInt2);
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
/* 2231 */     return substring(paramInt, this.size);
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
/* 2248 */     paramInt2 = validateRange(paramInt1, paramInt2);
/* 2249 */     return new String(this.buffer, paramInt1, paramInt2 - paramInt1);
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
/* 2265 */     if (paramInt <= 0)
/* 2266 */       return ""; 
/* 2267 */     if (paramInt >= this.size) {
/* 2268 */       return new String(this.buffer, 0, this.size);
/*      */     }
/* 2270 */     return new String(this.buffer, 0, paramInt);
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
/* 2287 */     if (paramInt <= 0)
/* 2288 */       return ""; 
/* 2289 */     if (paramInt >= this.size) {
/* 2290 */       return new String(this.buffer, 0, this.size);
/*      */     }
/* 2292 */     return new String(this.buffer, this.size - paramInt, paramInt);
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
/* 2313 */     if (paramInt1 < 0) {
/* 2314 */       paramInt1 = 0;
/*      */     }
/* 2316 */     if (paramInt2 <= 0 || paramInt1 >= this.size) {
/* 2317 */       return "";
/*      */     }
/* 2319 */     if (this.size <= paramInt1 + paramInt2) {
/* 2320 */       return new String(this.buffer, paramInt1, this.size - paramInt1);
/*      */     }
/* 2322 */     return new String(this.buffer, paramInt1, paramInt2);
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
/* 2333 */     char[] arrayOfChar = this.buffer;
/* 2334 */     for (byte b = 0; b < this.size; b++) {
/* 2335 */       if (arrayOfChar[b] == paramChar) {
/* 2336 */         return true;
/*      */       }
/*      */     } 
/* 2339 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean contains(String paramString) {
/* 2349 */     return (indexOf(paramString, 0) >= 0);
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
/* 2364 */     return (indexOf(paramStrMatcher, 0) >= 0);
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
/* 2375 */     return indexOf(paramChar, 0);
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
/* 2386 */     paramInt = (paramInt < 0) ? 0 : paramInt;
/* 2387 */     if (paramInt >= this.size) {
/* 2388 */       return -1;
/*      */     }
/* 2390 */     char[] arrayOfChar = this.buffer;
/* 2391 */     for (int i = paramInt; i < this.size; i++) {
/* 2392 */       if (arrayOfChar[i] == paramChar) {
/* 2393 */         return i;
/*      */       }
/*      */     } 
/* 2396 */     return -1;
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
/* 2408 */     return indexOf(paramString, 0);
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
/* 2422 */     paramInt = (paramInt < 0) ? 0 : paramInt;
/* 2423 */     if (paramString == null || paramInt >= this.size) {
/* 2424 */       return -1;
/*      */     }
/* 2426 */     int i = paramString.length();
/* 2427 */     if (i == 1) {
/* 2428 */       return indexOf(paramString.charAt(0), paramInt);
/*      */     }
/* 2430 */     if (i == 0) {
/* 2431 */       return paramInt;
/*      */     }
/* 2433 */     if (i > this.size) {
/* 2434 */       return -1;
/*      */     }
/* 2436 */     char[] arrayOfChar = this.buffer;
/* 2437 */     int j = this.size - i + 1;
/*      */     
/* 2439 */     for (int k = paramInt; k < j; k++) {
/* 2440 */       byte b = 0; while (true) { if (b < i) {
/* 2441 */           if (paramString.charAt(b) != arrayOfChar[k + b])
/*      */             break;  b++;
/*      */           continue;
/*      */         } 
/* 2445 */         return k; }
/*      */     
/* 2447 */     }  return -1;
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
/* 2461 */     return indexOf(paramStrMatcher, 0);
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
/* 2477 */     paramInt = (paramInt < 0) ? 0 : paramInt;
/* 2478 */     if (paramStrMatcher == null || paramInt >= this.size) {
/* 2479 */       return -1;
/*      */     }
/* 2481 */     int i = this.size;
/* 2482 */     char[] arrayOfChar = this.buffer;
/* 2483 */     for (int j = paramInt; j < i; j++) {
/* 2484 */       if (paramStrMatcher.isMatch(arrayOfChar, j, paramInt, i) > 0) {
/* 2485 */         return j;
/*      */       }
/*      */     } 
/* 2488 */     return -1;
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
/* 2499 */     return lastIndexOf(paramChar, this.size - 1);
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
/* 2510 */     paramInt = (paramInt >= this.size) ? (this.size - 1) : paramInt;
/* 2511 */     if (paramInt < 0) {
/* 2512 */       return -1;
/*      */     }
/* 2514 */     for (int i = paramInt; i >= 0; i--) {
/* 2515 */       if (this.buffer[i] == paramChar) {
/* 2516 */         return i;
/*      */       }
/*      */     } 
/* 2519 */     return -1;
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
/* 2531 */     return lastIndexOf(paramString, this.size - 1);
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
/* 2545 */     paramInt = (paramInt >= this.size) ? (this.size - 1) : paramInt;
/* 2546 */     if (paramString == null || paramInt < 0) {
/* 2547 */       return -1;
/*      */     }
/* 2549 */     int i = paramString.length();
/* 2550 */     if (i > 0 && i <= this.size) {
/* 2551 */       if (i == 1) {
/* 2552 */         return lastIndexOf(paramString.charAt(0), paramInt);
/*      */       }
/*      */ 
/*      */       
/* 2556 */       for (int j = paramInt - i + 1; j >= 0; j--) {
/* 2557 */         byte b = 0; while (true) { if (b < i) {
/* 2558 */             if (paramString.charAt(b) != this.buffer[j + b])
/*      */               break;  b++;
/*      */             continue;
/*      */           } 
/* 2562 */           return j; }
/*      */       
/*      */       } 
/* 2565 */     } else if (i == 0) {
/* 2566 */       return paramInt;
/*      */     } 
/* 2568 */     return -1;
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
/* 2582 */     return lastIndexOf(paramStrMatcher, this.size);
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
/* 2598 */     paramInt = (paramInt >= this.size) ? (this.size - 1) : paramInt;
/* 2599 */     if (paramStrMatcher == null || paramInt < 0) {
/* 2600 */       return -1;
/*      */     }
/* 2602 */     char[] arrayOfChar = this.buffer;
/* 2603 */     int i = paramInt + 1;
/* 2604 */     for (int j = paramInt; j >= 0; j--) {
/* 2605 */       if (paramStrMatcher.isMatch(arrayOfChar, j, 0, i) > 0) {
/* 2606 */         return j;
/*      */       }
/*      */     } 
/* 2609 */     return -1;
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
/* 2646 */     return new StrBuilderTokenizer();
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
/* 2670 */     return new StrBuilderReader();
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
/* 2695 */     return new StrBuilderWriter();
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
/*      */   public void appendTo(Appendable paramAppendable) throws IOException {
/* 2710 */     if (paramAppendable instanceof Writer) {
/* 2711 */       ((Writer)paramAppendable).write(this.buffer, 0, this.size);
/* 2712 */     } else if (paramAppendable instanceof StringBuilder) {
/* 2713 */       ((StringBuilder)paramAppendable).append(this.buffer, 0, this.size);
/* 2714 */     } else if (paramAppendable instanceof StringBuffer) {
/* 2715 */       ((StringBuffer)paramAppendable).append(this.buffer, 0, this.size);
/* 2716 */     } else if (paramAppendable instanceof CharBuffer) {
/* 2717 */       ((CharBuffer)paramAppendable).put(this.buffer, 0, this.size);
/*      */     } else {
/* 2719 */       paramAppendable.append(this);
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
/* 2731 */     if (this == paramStrBuilder) {
/* 2732 */       return true;
/*      */     }
/* 2734 */     if (this.size != paramStrBuilder.size) {
/* 2735 */       return false;
/*      */     }
/* 2737 */     char[] arrayOfChar1 = this.buffer;
/* 2738 */     char[] arrayOfChar2 = paramStrBuilder.buffer;
/* 2739 */     for (int i = this.size - 1; i >= 0; i--) {
/* 2740 */       char c1 = arrayOfChar1[i];
/* 2741 */       char c2 = arrayOfChar2[i];
/* 2742 */       if (c1 != c2 && Character.toUpperCase(c1) != Character.toUpperCase(c2)) {
/* 2743 */         return false;
/*      */       }
/*      */     } 
/* 2746 */     return true;
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
/* 2757 */     if (this == paramStrBuilder) {
/* 2758 */       return true;
/*      */     }
/* 2760 */     if (paramStrBuilder == null) {
/* 2761 */       return false;
/*      */     }
/* 2763 */     if (this.size != paramStrBuilder.size) {
/* 2764 */       return false;
/*      */     }
/* 2766 */     char[] arrayOfChar1 = this.buffer;
/* 2767 */     char[] arrayOfChar2 = paramStrBuilder.buffer;
/* 2768 */     for (int i = this.size - 1; i >= 0; i--) {
/* 2769 */       if (arrayOfChar1[i] != arrayOfChar2[i]) {
/* 2770 */         return false;
/*      */       }
/*      */     } 
/* 2773 */     return true;
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
/* 2785 */     return (paramObject instanceof StrBuilder && 
/* 2786 */       equals((StrBuilder)paramObject));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/* 2796 */     char[] arrayOfChar = this.buffer;
/* 2797 */     int i = 0;
/* 2798 */     for (int j = this.size - 1; j >= 0; j--) {
/* 2799 */       i = 31 * i + arrayOfChar[j];
/*      */     }
/* 2801 */     return i;
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
/* 2816 */     return new String(this.buffer, 0, this.size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuffer toStringBuffer() {
/* 2826 */     return (new StringBuffer(this.size)).append(this.buffer, 0, this.size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder toStringBuilder() {
/* 2836 */     return (new StringBuilder(this.size)).append(this.buffer, 0, this.size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String build() {
/* 2846 */     return toString();
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
/* 2860 */     if (paramInt1 < 0) {
/* 2861 */       throw new StringIndexOutOfBoundsException(paramInt1);
/*      */     }
/* 2863 */     if (paramInt2 > this.size) {
/* 2864 */       paramInt2 = this.size;
/*      */     }
/* 2866 */     if (paramInt1 > paramInt2) {
/* 2867 */       throw new StringIndexOutOfBoundsException("end < start");
/*      */     }
/* 2869 */     return paramInt2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void validateIndex(int paramInt) {
/* 2879 */     if (paramInt < 0 || paramInt > this.size) {
/* 2880 */       throw new StringIndexOutOfBoundsException(paramInt);
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
/* 2900 */       if (param1ArrayOfchar == null) {
/* 2901 */         return super.tokenize(StrBuilder.this.buffer, 0, StrBuilder.this
/* 2902 */             .size());
/*      */       }
/* 2904 */       return super.tokenize(param1ArrayOfchar, param1Int1, param1Int2);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String getContent() {
/* 2910 */       String str = super.getContent();
/* 2911 */       if (str == null) {
/* 2912 */         return StrBuilder.this.toString();
/*      */       }
/* 2914 */       return str;
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
/* 2944 */       if (!ready()) {
/* 2945 */         return -1;
/*      */       }
/* 2947 */       return StrBuilder.this.charAt(this.pos++);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int read(char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
/* 2953 */       if (param1Int1 < 0 || param1Int2 < 0 || param1Int1 > param1ArrayOfchar.length || param1Int1 + param1Int2 > param1ArrayOfchar.length || param1Int1 + param1Int2 < 0)
/*      */       {
/* 2955 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 2957 */       if (param1Int2 == 0) {
/* 2958 */         return 0;
/*      */       }
/* 2960 */       if (this.pos >= StrBuilder.this.size()) {
/* 2961 */         return -1;
/*      */       }
/* 2963 */       if (this.pos + param1Int2 > StrBuilder.this.size()) {
/* 2964 */         param1Int2 = StrBuilder.this.size() - this.pos;
/*      */       }
/* 2966 */       StrBuilder.this.getChars(this.pos, this.pos + param1Int2, param1ArrayOfchar, param1Int1);
/* 2967 */       this.pos += param1Int2;
/* 2968 */       return param1Int2;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public long skip(long param1Long) {
/* 2974 */       if (this.pos + param1Long > StrBuilder.this.size()) {
/* 2975 */         param1Long = (StrBuilder.this.size() - this.pos);
/*      */       }
/* 2977 */       if (param1Long < 0L) {
/* 2978 */         return 0L;
/*      */       }
/* 2980 */       this.pos = (int)(this.pos + param1Long);
/* 2981 */       return param1Long;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean ready() {
/* 2987 */       return (this.pos < StrBuilder.this.size());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean markSupported() {
/* 2993 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void mark(int param1Int) {
/* 2999 */       this.mark = this.pos;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void reset() {
/* 3005 */       this.pos = this.mark;
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
/* 3037 */       StrBuilder.this.append((char)param1Int);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void write(char[] param1ArrayOfchar) {
/* 3043 */       StrBuilder.this.append(param1ArrayOfchar);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void write(char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
/* 3049 */       StrBuilder.this.append(param1ArrayOfchar, param1Int1, param1Int2);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void write(String param1String) {
/* 3055 */       StrBuilder.this.append(param1String);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void write(String param1String, int param1Int1, int param1Int2) {
/* 3061 */       StrBuilder.this.append(param1String, param1Int1, param1Int2);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\StrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */