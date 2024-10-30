/*      */ package org.apache.commons.text;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.Reader;
/*      */ import java.io.Serializable;
/*      */ import java.io.Writer;
/*      */ import java.nio.CharBuffer;
/*      */ import java.util.Arrays;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Objects;
/*      */ import org.apache.commons.lang3.ArrayUtils;
/*      */ import org.apache.commons.lang3.StringUtils;
/*      */ import org.apache.commons.text.matcher.StringMatcher;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class TextStringBuilder
/*      */   implements Serializable, Appendable, CharSequence, Builder<String>
/*      */ {
/*      */   private static final char SPACE = ' ';
/*      */   static final int CAPACITY = 32;
/*      */   private static final int EOS = -1;
/*      */   
/*      */   class TextStringBuilderReader
/*      */     extends Reader
/*      */   {
/*      */     private int mark;
/*      */     private int pos;
/*      */     
/*      */     public void close() {}
/*      */     
/*      */     public void mark(int param1Int) {
/*  105 */       this.mark = this.pos;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean markSupported() {
/*  111 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int read() {
/*  117 */       if (!ready()) {
/*  118 */         return -1;
/*      */       }
/*  120 */       return TextStringBuilder.this.charAt(this.pos++);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int read(char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
/*  126 */       if (param1Int1 < 0 || param1Int2 < 0 || param1Int1 > param1ArrayOfchar.length || param1Int1 + param1Int2 > param1ArrayOfchar.length || param1Int1 + param1Int2 < 0) {
/*  127 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  129 */       if (param1Int2 == 0) {
/*  130 */         return 0;
/*      */       }
/*  132 */       if (this.pos >= TextStringBuilder.this.size()) {
/*  133 */         return -1;
/*      */       }
/*  135 */       if (this.pos + param1Int2 > TextStringBuilder.this.size()) {
/*  136 */         param1Int2 = TextStringBuilder.this.size() - this.pos;
/*      */       }
/*  138 */       TextStringBuilder.this.getChars(this.pos, this.pos + param1Int2, param1ArrayOfchar, param1Int1);
/*  139 */       this.pos += param1Int2;
/*  140 */       return param1Int2;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean ready() {
/*  146 */       return (this.pos < TextStringBuilder.this.size());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void reset() {
/*  152 */       this.pos = this.mark;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public long skip(long param1Long) {
/*  158 */       if (this.pos + param1Long > TextStringBuilder.this.size()) {
/*  159 */         param1Long = (TextStringBuilder.this.size() - this.pos);
/*      */       }
/*  161 */       if (param1Long < 0L) {
/*  162 */         return 0L;
/*      */       }
/*  164 */       this.pos = (int)(this.pos + param1Long);
/*  165 */       return param1Long;
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
/*      */   class TextStringBuilderTokenizer
/*      */     extends StringTokenizer
/*      */   {
/*      */     public String getContent() {
/*  184 */       String str = super.getContent();
/*  185 */       if (str == null) {
/*  186 */         return TextStringBuilder.this.toString();
/*      */       }
/*  188 */       return str;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected List<String> tokenize(char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
/*  194 */       if (param1ArrayOfchar == null) {
/*  195 */         return super.tokenize(TextStringBuilder.this.getBuffer(), 0, TextStringBuilder.this.size());
/*      */       }
/*  197 */       return super.tokenize(param1ArrayOfchar, param1Int1, param1Int2);
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
/*      */   class TextStringBuilderWriter
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
/*      */     public void flush() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void write(char[] param1ArrayOfchar) {
/*  228 */       TextStringBuilder.this.append(param1ArrayOfchar);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void write(char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
/*  234 */       TextStringBuilder.this.append(param1ArrayOfchar, param1Int1, param1Int2);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void write(int param1Int) {
/*  240 */       TextStringBuilder.this.append((char)param1Int);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void write(String param1String) {
/*  246 */       TextStringBuilder.this.append(param1String);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void write(String param1String, int param1Int1, int param1Int2) {
/*  252 */       TextStringBuilder.this.append(param1String, param1Int1, param1Int2);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  272 */   private static final int FALSE_STRING_SIZE = Boolean.FALSE.toString().length();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  284 */   private static final int TRUE_STRING_SIZE = Boolean.TRUE.toString().length();
/*      */   
/*      */   private char[] buffer;
/*      */   
/*      */   private String newLine;
/*      */   
/*      */   private String nullText;
/*      */   
/*      */   private int reallocations;
/*      */   private int size;
/*      */   
/*      */   public static TextStringBuilder wrap(char[] paramArrayOfchar) {
/*  296 */     Objects.requireNonNull(paramArrayOfchar, "initialBuffer");
/*  297 */     return new TextStringBuilder(paramArrayOfchar, paramArrayOfchar.length);
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
/*      */   public static TextStringBuilder wrap(char[] paramArrayOfchar, int paramInt) {
/*  312 */     return new TextStringBuilder(paramArrayOfchar, paramInt);
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
/*      */   public TextStringBuilder() {
/*  334 */     this(32);
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
/*      */   private TextStringBuilder(char[] paramArrayOfchar, int paramInt) {
/*  347 */     this.buffer = Objects.<char[]>requireNonNull(paramArrayOfchar, "initialBuffer");
/*  348 */     if (paramInt < 0 || paramInt > paramArrayOfchar.length) {
/*  349 */       throw new IllegalArgumentException("initialBuffer.length=" + paramArrayOfchar.length + ", length=" + paramInt);
/*      */     }
/*  351 */     this.size = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder(CharSequence paramCharSequence) {
/*  361 */     this(StringUtils.length(paramCharSequence) + 32);
/*  362 */     if (paramCharSequence != null) {
/*  363 */       append(paramCharSequence);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder(int paramInt) {
/*  374 */     this.buffer = new char[(paramInt <= 0) ? 32 : paramInt];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder(String paramString) {
/*  383 */     this(StringUtils.length(paramString) + 32);
/*  384 */     if (paramString != null) {
/*  385 */       append(paramString);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder append(boolean paramBoolean) {
/*  396 */     if (paramBoolean) {
/*  397 */       ensureCapacity(this.size + TRUE_STRING_SIZE);
/*  398 */       appendTrue(this.size);
/*      */     } else {
/*  400 */       ensureCapacity(this.size + FALSE_STRING_SIZE);
/*  401 */       appendFalse(this.size);
/*      */     } 
/*  403 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder append(char paramChar) {
/*  414 */     int i = length();
/*  415 */     ensureCapacity(i + 1);
/*  416 */     this.buffer[this.size++] = paramChar;
/*  417 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder append(char[] paramArrayOfchar) {
/*  427 */     if (paramArrayOfchar == null) {
/*  428 */       return appendNull();
/*      */     }
/*  430 */     int i = paramArrayOfchar.length;
/*  431 */     if (i > 0) {
/*  432 */       int j = length();
/*  433 */       ensureCapacity(j + i);
/*  434 */       System.arraycopy(paramArrayOfchar, 0, this.buffer, j, i);
/*  435 */       this.size += i;
/*      */     } 
/*  437 */     return this;
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
/*      */   public TextStringBuilder append(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  449 */     if (paramArrayOfchar == null) {
/*  450 */       return appendNull();
/*      */     }
/*  452 */     if (paramInt1 < 0 || paramInt1 > paramArrayOfchar.length) {
/*  453 */       throw new StringIndexOutOfBoundsException("Invalid startIndex: " + paramInt2);
/*      */     }
/*  455 */     if (paramInt2 < 0 || paramInt1 + paramInt2 > paramArrayOfchar.length) {
/*  456 */       throw new StringIndexOutOfBoundsException("Invalid length: " + paramInt2);
/*      */     }
/*  458 */     if (paramInt2 > 0) {
/*  459 */       int i = length();
/*  460 */       ensureCapacity(i + paramInt2);
/*  461 */       System.arraycopy(paramArrayOfchar, paramInt1, this.buffer, i, paramInt2);
/*  462 */       this.size += paramInt2;
/*      */     } 
/*  464 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder append(CharBuffer paramCharBuffer) {
/*  474 */     return append(paramCharBuffer, 0, StringUtils.length(paramCharBuffer));
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
/*      */   public TextStringBuilder append(CharBuffer paramCharBuffer, int paramInt1, int paramInt2) {
/*  486 */     if (paramCharBuffer == null) {
/*  487 */       return appendNull();
/*      */     }
/*  489 */     if (paramCharBuffer.hasArray()) {
/*  490 */       int i = paramCharBuffer.remaining();
/*  491 */       if (paramInt1 < 0 || paramInt1 > i) {
/*  492 */         throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */       }
/*  494 */       if (paramInt2 < 0 || paramInt1 + paramInt2 > i) {
/*  495 */         throw new StringIndexOutOfBoundsException("length must be valid");
/*      */       }
/*  497 */       int j = length();
/*  498 */       ensureCapacity(j + paramInt2);
/*  499 */       System.arraycopy(paramCharBuffer.array(), paramCharBuffer.arrayOffset() + paramCharBuffer.position() + paramInt1, this.buffer, j, paramInt2);
/*  500 */       this.size += paramInt2;
/*      */     } else {
/*  502 */       append(paramCharBuffer.toString(), paramInt1, paramInt2);
/*      */     } 
/*  504 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder append(CharSequence paramCharSequence) {
/*  515 */     if (paramCharSequence == null) {
/*  516 */       return appendNull();
/*      */     }
/*  518 */     if (paramCharSequence instanceof TextStringBuilder) {
/*  519 */       return append((TextStringBuilder)paramCharSequence);
/*      */     }
/*  521 */     if (paramCharSequence instanceof StringBuilder) {
/*  522 */       return append((StringBuilder)paramCharSequence);
/*      */     }
/*  524 */     if (paramCharSequence instanceof StringBuffer) {
/*  525 */       return append((StringBuffer)paramCharSequence);
/*      */     }
/*  527 */     if (paramCharSequence instanceof CharBuffer) {
/*  528 */       return append((CharBuffer)paramCharSequence);
/*      */     }
/*  530 */     return append(paramCharSequence.toString());
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
/*      */   public TextStringBuilder append(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*  543 */     if (paramCharSequence == null) {
/*  544 */       return appendNull();
/*      */     }
/*  546 */     if (paramInt2 <= 0) {
/*  547 */       throw new StringIndexOutOfBoundsException("endIndex must be valid");
/*      */     }
/*  549 */     if (paramInt1 >= paramInt2) {
/*  550 */       throw new StringIndexOutOfBoundsException("endIndex must be greater than startIndex");
/*      */     }
/*  552 */     return append(paramCharSequence.toString(), paramInt1, paramInt2 - paramInt1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder append(double paramDouble) {
/*  562 */     return append(String.valueOf(paramDouble));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder append(float paramFloat) {
/*  572 */     return append(String.valueOf(paramFloat));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder append(int paramInt) {
/*  582 */     return append(String.valueOf(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder append(long paramLong) {
/*  592 */     return append(String.valueOf(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder append(Object paramObject) {
/*  602 */     if (paramObject == null) {
/*  603 */       return appendNull();
/*      */     }
/*  605 */     if (paramObject instanceof CharSequence) {
/*  606 */       return append((CharSequence)paramObject);
/*      */     }
/*  608 */     return append(paramObject.toString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder append(String paramString) {
/*  618 */     return append(paramString, 0, StringUtils.length(paramString));
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
/*      */   public TextStringBuilder append(String paramString, int paramInt1, int paramInt2) {
/*  630 */     if (paramString == null) {
/*  631 */       return appendNull();
/*      */     }
/*  633 */     if (paramInt1 < 0 || paramInt1 > paramString.length()) {
/*  634 */       throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */     }
/*  636 */     if (paramInt2 < 0 || paramInt1 + paramInt2 > paramString.length()) {
/*  637 */       throw new StringIndexOutOfBoundsException("length must be valid");
/*      */     }
/*  639 */     if (paramInt2 > 0) {
/*  640 */       int i = length();
/*  641 */       ensureCapacity(i + paramInt2);
/*  642 */       paramString.getChars(paramInt1, paramInt1 + paramInt2, this.buffer, i);
/*  643 */       this.size += paramInt2;
/*      */     } 
/*  645 */     return this;
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
/*      */   public TextStringBuilder append(String paramString, Object... paramVarArgs) {
/*  657 */     return append(String.format(paramString, paramVarArgs));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder append(StringBuffer paramStringBuffer) {
/*  667 */     return append(paramStringBuffer, 0, StringUtils.length(paramStringBuffer));
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
/*      */   public TextStringBuilder append(StringBuffer paramStringBuffer, int paramInt1, int paramInt2) {
/*  679 */     if (paramStringBuffer == null) {
/*  680 */       return appendNull();
/*      */     }
/*  682 */     if (paramInt1 < 0 || paramInt1 > paramStringBuffer.length()) {
/*  683 */       throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */     }
/*  685 */     if (paramInt2 < 0 || paramInt1 + paramInt2 > paramStringBuffer.length()) {
/*  686 */       throw new StringIndexOutOfBoundsException("length must be valid");
/*      */     }
/*  688 */     if (paramInt2 > 0) {
/*  689 */       int i = length();
/*  690 */       ensureCapacity(i + paramInt2);
/*  691 */       paramStringBuffer.getChars(paramInt1, paramInt1 + paramInt2, this.buffer, i);
/*  692 */       this.size += paramInt2;
/*      */     } 
/*  694 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder append(StringBuilder paramStringBuilder) {
/*  704 */     return append(paramStringBuilder, 0, StringUtils.length(paramStringBuilder));
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
/*      */   public TextStringBuilder append(StringBuilder paramStringBuilder, int paramInt1, int paramInt2) {
/*  716 */     if (paramStringBuilder == null) {
/*  717 */       return appendNull();
/*      */     }
/*  719 */     if (paramInt1 < 0 || paramInt1 > paramStringBuilder.length()) {
/*  720 */       throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */     }
/*  722 */     if (paramInt2 < 0 || paramInt1 + paramInt2 > paramStringBuilder.length()) {
/*  723 */       throw new StringIndexOutOfBoundsException("length must be valid");
/*      */     }
/*  725 */     if (paramInt2 > 0) {
/*  726 */       int i = length();
/*  727 */       ensureCapacity(i + paramInt2);
/*  728 */       paramStringBuilder.getChars(paramInt1, paramInt1 + paramInt2, this.buffer, i);
/*  729 */       this.size += paramInt2;
/*      */     } 
/*  731 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder append(TextStringBuilder paramTextStringBuilder) {
/*  741 */     return append(paramTextStringBuilder, 0, StringUtils.length(paramTextStringBuilder));
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
/*      */   public TextStringBuilder append(TextStringBuilder paramTextStringBuilder, int paramInt1, int paramInt2) {
/*  753 */     if (paramTextStringBuilder == null) {
/*  754 */       return appendNull();
/*      */     }
/*  756 */     if (paramInt1 < 0 || paramInt1 > paramTextStringBuilder.length()) {
/*  757 */       throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */     }
/*  759 */     if (paramInt2 < 0 || paramInt1 + paramInt2 > paramTextStringBuilder.length()) {
/*  760 */       throw new StringIndexOutOfBoundsException("length must be valid");
/*      */     }
/*  762 */     if (paramInt2 > 0) {
/*  763 */       int i = length();
/*  764 */       ensureCapacity(i + paramInt2);
/*  765 */       paramTextStringBuilder.getChars(paramInt1, paramInt1 + paramInt2, this.buffer, i);
/*  766 */       this.size += paramInt2;
/*      */     } 
/*  768 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder appendAll(Iterable<?> paramIterable) {
/*  779 */     if (paramIterable != null) {
/*  780 */       for (Object object : paramIterable) {
/*  781 */         append(object);
/*      */       }
/*      */     }
/*  784 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder appendAll(Iterator<?> paramIterator) {
/*  795 */     if (paramIterator != null) {
/*  796 */       while (paramIterator.hasNext()) {
/*  797 */         append(paramIterator.next());
/*      */       }
/*      */     }
/*  800 */     return this;
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
/*      */   public <T> TextStringBuilder appendAll(T... paramVarArgs) {
/*  817 */     if (paramVarArgs != null && paramVarArgs.length > 0) {
/*  818 */       for (T t : paramVarArgs) {
/*  819 */         append(t);
/*      */       }
/*      */     }
/*  822 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   private void appendFalse(int paramInt) {
/*  827 */     this.buffer[paramInt++] = 'f';
/*  828 */     this.buffer[paramInt++] = 'a';
/*  829 */     this.buffer[paramInt++] = 'l';
/*  830 */     this.buffer[paramInt++] = 's';
/*  831 */     this.buffer[paramInt] = 'e';
/*  832 */     this.size += FALSE_STRING_SIZE;
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
/*      */   public TextStringBuilder appendFixedWidthPadLeft(int paramInt1, int paramInt2, char paramChar) {
/*  845 */     return appendFixedWidthPadLeft(String.valueOf(paramInt1), paramInt2, paramChar);
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
/*      */   public TextStringBuilder appendFixedWidthPadLeft(Object paramObject, int paramInt, char paramChar) {
/*  859 */     if (paramInt > 0) {
/*  860 */       ensureCapacity(this.size + paramInt);
/*  861 */       String str = (paramObject == null) ? getNullText() : paramObject.toString();
/*  862 */       if (str == null) {
/*  863 */         str = "";
/*      */       }
/*  865 */       int i = str.length();
/*  866 */       if (i >= paramInt) {
/*  867 */         str.getChars(i - paramInt, i, this.buffer, this.size);
/*      */       } else {
/*  869 */         int j = paramInt - i;
/*  870 */         for (byte b = 0; b < j; b++) {
/*  871 */           this.buffer[this.size + b] = paramChar;
/*      */         }
/*  873 */         str.getChars(0, i, this.buffer, this.size + j);
/*      */       } 
/*  875 */       this.size += paramInt;
/*      */     } 
/*  877 */     return this;
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
/*      */   public TextStringBuilder appendFixedWidthPadRight(int paramInt1, int paramInt2, char paramChar) {
/*  890 */     return appendFixedWidthPadRight(String.valueOf(paramInt1), paramInt2, paramChar);
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
/*      */   public TextStringBuilder appendFixedWidthPadRight(Object paramObject, int paramInt, char paramChar) {
/*  904 */     if (paramInt > 0) {
/*  905 */       ensureCapacity(this.size + paramInt);
/*  906 */       String str = (paramObject == null) ? getNullText() : paramObject.toString();
/*  907 */       if (str == null) {
/*  908 */         str = "";
/*      */       }
/*  910 */       int i = str.length();
/*  911 */       if (i >= paramInt) {
/*  912 */         str.getChars(0, paramInt, this.buffer, this.size);
/*      */       } else {
/*  914 */         int j = paramInt - i;
/*  915 */         str.getChars(0, i, this.buffer, this.size);
/*  916 */         for (byte b = 0; b < j; b++) {
/*  917 */           this.buffer[this.size + i + b] = paramChar;
/*      */         }
/*      */       } 
/*  920 */       this.size += paramInt;
/*      */     } 
/*  922 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder appendln(boolean paramBoolean) {
/*  932 */     return append(paramBoolean).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder appendln(char paramChar) {
/*  942 */     return append(paramChar).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder appendln(char[] paramArrayOfchar) {
/*  953 */     return append(paramArrayOfchar).appendNewLine();
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
/*      */   public TextStringBuilder appendln(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  966 */     return append(paramArrayOfchar, paramInt1, paramInt2).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder appendln(double paramDouble) {
/*  976 */     return append(paramDouble).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder appendln(float paramFloat) {
/*  986 */     return append(paramFloat).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder appendln(int paramInt) {
/*  996 */     return append(paramInt).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder appendln(long paramLong) {
/* 1006 */     return append(paramLong).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder appendln(Object paramObject) {
/* 1017 */     return append(paramObject).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder appendln(String paramString) {
/* 1027 */     return append(paramString).appendNewLine();
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
/*      */   public TextStringBuilder appendln(String paramString, int paramInt1, int paramInt2) {
/* 1040 */     return append(paramString, paramInt1, paramInt2).appendNewLine();
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
/*      */   public TextStringBuilder appendln(String paramString, Object... paramVarArgs) {
/* 1052 */     return append(paramString, paramVarArgs).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder appendln(StringBuffer paramStringBuffer) {
/* 1063 */     return append(paramStringBuffer).appendNewLine();
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
/*      */   public TextStringBuilder appendln(StringBuffer paramStringBuffer, int paramInt1, int paramInt2) {
/* 1076 */     return append(paramStringBuffer, paramInt1, paramInt2).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder appendln(StringBuilder paramStringBuilder) {
/* 1087 */     return append(paramStringBuilder).appendNewLine();
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
/*      */   public TextStringBuilder appendln(StringBuilder paramStringBuilder, int paramInt1, int paramInt2) {
/* 1100 */     return append(paramStringBuilder, paramInt1, paramInt2).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder appendln(TextStringBuilder paramTextStringBuilder) {
/* 1111 */     return append(paramTextStringBuilder).appendNewLine();
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
/*      */   public TextStringBuilder appendln(TextStringBuilder paramTextStringBuilder, int paramInt1, int paramInt2) {
/* 1124 */     return append(paramTextStringBuilder, paramInt1, paramInt2).appendNewLine();
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
/*      */   public TextStringBuilder appendNewLine() {
/* 1136 */     if (this.newLine == null) {
/* 1137 */       append(System.lineSeparator());
/* 1138 */       return this;
/*      */     } 
/* 1140 */     return append(this.newLine);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder appendNull() {
/* 1149 */     if (this.nullText == null) {
/* 1150 */       return this;
/*      */     }
/* 1152 */     return append(this.nullText);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder appendPadding(int paramInt, char paramChar) {
/* 1163 */     if (paramInt >= 0) {
/* 1164 */       ensureCapacity(this.size + paramInt);
/* 1165 */       for (byte b = 0; b < paramInt; b++) {
/* 1166 */         this.buffer[this.size++] = paramChar;
/*      */       }
/*      */     } 
/* 1169 */     return this;
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
/*      */   public TextStringBuilder appendSeparator(char paramChar) {
/* 1193 */     if (isNotEmpty()) {
/* 1194 */       append(paramChar);
/*      */     }
/* 1196 */     return this;
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
/*      */   public TextStringBuilder appendSeparator(char paramChar1, char paramChar2) {
/* 1210 */     if (isEmpty()) {
/* 1211 */       append(paramChar2);
/*      */     } else {
/* 1213 */       append(paramChar1);
/*      */     } 
/* 1215 */     return this;
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
/*      */   public TextStringBuilder appendSeparator(char paramChar, int paramInt) {
/* 1241 */     if (paramInt > 0) {
/* 1242 */       append(paramChar);
/*      */     }
/* 1244 */     return this;
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
/*      */   public TextStringBuilder appendSeparator(String paramString) {
/* 1269 */     return appendSeparator(paramString, (String)null);
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
/*      */   public TextStringBuilder appendSeparator(String paramString, int paramInt) {
/* 1295 */     if (paramString != null && paramInt > 0) {
/* 1296 */       append(paramString);
/*      */     }
/* 1298 */     return this;
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
/*      */   public TextStringBuilder appendSeparator(String paramString1, String paramString2) {
/* 1328 */     String str = isEmpty() ? paramString2 : paramString1;
/* 1329 */     if (str != null) {
/* 1330 */       append(str);
/*      */     }
/* 1332 */     return this;
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
/* 1347 */     if (paramAppendable instanceof Writer) {
/* 1348 */       ((Writer)paramAppendable).write(this.buffer, 0, this.size);
/* 1349 */     } else if (paramAppendable instanceof StringBuilder) {
/* 1350 */       ((StringBuilder)paramAppendable).append(this.buffer, 0, this.size);
/* 1351 */     } else if (paramAppendable instanceof StringBuffer) {
/* 1352 */       ((StringBuffer)paramAppendable).append(this.buffer, 0, this.size);
/* 1353 */     } else if (paramAppendable instanceof CharBuffer) {
/* 1354 */       ((CharBuffer)paramAppendable).put(this.buffer, 0, this.size);
/*      */     } else {
/* 1356 */       paramAppendable.append(this);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void appendTrue(int paramInt) {
/* 1362 */     this.buffer[paramInt++] = 't';
/* 1363 */     this.buffer[paramInt++] = 'r';
/* 1364 */     this.buffer[paramInt++] = 'u';
/* 1365 */     this.buffer[paramInt] = 'e';
/* 1366 */     this.size += TRUE_STRING_SIZE;
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
/*      */   public TextStringBuilder appendWithSeparators(Iterable<?> paramIterable, String paramString) {
/* 1378 */     if (paramIterable != null) {
/* 1379 */       String str = Objects.toString(paramString, "");
/* 1380 */       Iterator<?> iterator = paramIterable.iterator();
/* 1381 */       while (iterator.hasNext()) {
/* 1382 */         append(iterator.next());
/* 1383 */         if (iterator.hasNext()) {
/* 1384 */           append(str);
/*      */         }
/*      */       } 
/*      */     } 
/* 1388 */     return this;
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
/*      */   public TextStringBuilder appendWithSeparators(Iterator<?> paramIterator, String paramString) {
/* 1400 */     if (paramIterator != null) {
/* 1401 */       String str = Objects.toString(paramString, "");
/* 1402 */       while (paramIterator.hasNext()) {
/* 1403 */         append(paramIterator.next());
/* 1404 */         if (paramIterator.hasNext()) {
/* 1405 */           append(str);
/*      */         }
/*      */       } 
/*      */     } 
/* 1409 */     return this;
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
/*      */   public TextStringBuilder appendWithSeparators(Object[] paramArrayOfObject, String paramString) {
/* 1421 */     if (paramArrayOfObject != null && paramArrayOfObject.length > 0) {
/* 1422 */       String str = Objects.toString(paramString, "");
/* 1423 */       append(paramArrayOfObject[0]);
/* 1424 */       for (byte b = 1; b < paramArrayOfObject.length; b++) {
/* 1425 */         append(str);
/* 1426 */         append(paramArrayOfObject[b]);
/*      */       } 
/*      */     } 
/* 1429 */     return this;
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
/* 1453 */     return new TextStringBuilderReader();
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
/*      */ 
/*      */   
/*      */   public StringTokenizer asTokenizer() {
/* 1492 */     return new TextStringBuilderTokenizer();
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
/*      */   public Writer asWriter() {
/* 1516 */     return new TextStringBuilderWriter();
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
/* 1527 */     return toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int capacity() {
/* 1536 */     return this.buffer.length;
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
/*      */   public char charAt(int paramInt) {
/* 1550 */     validateIndex(paramInt);
/* 1551 */     return this.buffer[paramInt];
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
/*      */   public TextStringBuilder clear() {
/* 1568 */     this.size = 0;
/* 1569 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean contains(char paramChar) {
/* 1579 */     char[] arrayOfChar = this.buffer;
/* 1580 */     for (byte b = 0; b < this.size; b++) {
/* 1581 */       if (arrayOfChar[b] == paramChar) {
/* 1582 */         return true;
/*      */       }
/*      */     } 
/* 1585 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean contains(String paramString) {
/* 1595 */     return (indexOf(paramString, 0) >= 0);
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
/*      */   public boolean contains(StringMatcher paramStringMatcher) {
/* 1609 */     return (indexOf(paramStringMatcher, 0) >= 0);
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
/*      */   public TextStringBuilder delete(int paramInt1, int paramInt2) {
/* 1621 */     int i = validateRange(paramInt1, paramInt2);
/* 1622 */     int j = i - paramInt1;
/* 1623 */     if (j > 0) {
/* 1624 */       deleteImpl(paramInt1, i, j);
/*      */     }
/* 1626 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder deleteAll(char paramChar) {
/* 1636 */     for (int i = 0; i < this.size; i++) {
/* 1637 */       if (this.buffer[i] == paramChar) {
/* 1638 */         int j = i; do {  }
/* 1639 */         while (++i < this.size && 
/* 1640 */           this.buffer[i] == paramChar);
/*      */ 
/*      */ 
/*      */         
/* 1644 */         int k = i - j;
/* 1645 */         deleteImpl(j, i, k);
/* 1646 */         i -= k;
/*      */       } 
/*      */     } 
/* 1649 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder deleteAll(String paramString) {
/* 1659 */     byte b = (paramString == null) ? 0 : paramString.length();
/* 1660 */     if (b) {
/* 1661 */       int i = indexOf(paramString, 0);
/* 1662 */       while (i >= 0) {
/* 1663 */         deleteImpl(i, i + b, b);
/* 1664 */         i = indexOf(paramString, i);
/*      */       } 
/*      */     } 
/* 1667 */     return this;
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
/*      */   public TextStringBuilder deleteAll(StringMatcher paramStringMatcher) {
/* 1680 */     return replace(paramStringMatcher, null, 0, this.size, -1);
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
/*      */   public TextStringBuilder deleteCharAt(int paramInt) {
/* 1693 */     validateIndex(paramInt);
/* 1694 */     deleteImpl(paramInt, paramInt + 1, 1);
/* 1695 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder deleteFirst(char paramChar) {
/* 1705 */     for (byte b = 0; b < this.size; b++) {
/* 1706 */       if (this.buffer[b] == paramChar) {
/* 1707 */         deleteImpl(b, b + 1, 1);
/*      */         break;
/*      */       } 
/*      */     } 
/* 1711 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder deleteFirst(String paramString) {
/* 1721 */     byte b = (paramString == null) ? 0 : paramString.length();
/* 1722 */     if (b) {
/* 1723 */       int i = indexOf(paramString, 0);
/* 1724 */       if (i >= 0) {
/* 1725 */         deleteImpl(i, i + b, b);
/*      */       }
/*      */     } 
/* 1728 */     return this;
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
/*      */   public TextStringBuilder deleteFirst(StringMatcher paramStringMatcher) {
/* 1741 */     return replace(paramStringMatcher, null, 0, this.size, 1);
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
/*      */   private void deleteImpl(int paramInt1, int paramInt2, int paramInt3) {
/* 1753 */     System.arraycopy(this.buffer, paramInt2, this.buffer, paramInt1, this.size - paramInt2);
/* 1754 */     this.size -= paramInt3;
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
/*      */   public char drainChar(int paramInt) {
/* 1768 */     validateIndex(paramInt);
/* 1769 */     char c = this.buffer[paramInt];
/* 1770 */     deleteCharAt(paramInt);
/* 1771 */     return c;
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
/*      */   public int drainChars(int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3) {
/* 1786 */     int i = paramInt2 - paramInt1;
/* 1787 */     if (isEmpty() || i == 0 || paramArrayOfchar.length == 0) {
/* 1788 */       return 0;
/*      */     }
/* 1790 */     int j = Math.min(Math.min(this.size, i), paramArrayOfchar.length - paramInt3);
/* 1791 */     getChars(paramInt1, j, paramArrayOfchar, paramInt3);
/* 1792 */     delete(paramInt1, j);
/* 1793 */     return j;
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
/*      */   public boolean endsWith(String paramString) {
/* 1806 */     if (paramString == null) {
/* 1807 */       return false;
/*      */     }
/* 1809 */     int i = paramString.length();
/* 1810 */     if (i == 0) {
/* 1811 */       return true;
/*      */     }
/* 1813 */     if (i > this.size) {
/* 1814 */       return false;
/*      */     }
/* 1816 */     int j = this.size - i;
/* 1817 */     for (byte b = 0; b < i; b++, j++) {
/* 1818 */       if (this.buffer[j] != paramString.charAt(b)) {
/* 1819 */         return false;
/*      */       }
/*      */     } 
/* 1822 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder ensureCapacity(int paramInt) {
/* 1832 */     if (paramInt > this.buffer.length) {
/* 1833 */       reallocate(paramInt * 2);
/*      */     }
/* 1835 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(Object paramObject) {
/* 1846 */     return (paramObject instanceof TextStringBuilder && equals((TextStringBuilder)paramObject));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(TextStringBuilder paramTextStringBuilder) {
/* 1856 */     return (paramTextStringBuilder != null && Arrays.equals(this.buffer, paramTextStringBuilder.buffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equalsIgnoreCase(TextStringBuilder paramTextStringBuilder) {
/* 1867 */     if (this == paramTextStringBuilder) {
/* 1868 */       return true;
/*      */     }
/* 1870 */     if (this.size != paramTextStringBuilder.size) {
/* 1871 */       return false;
/*      */     }
/* 1873 */     char[] arrayOfChar1 = this.buffer;
/* 1874 */     char[] arrayOfChar2 = paramTextStringBuilder.buffer;
/* 1875 */     for (int i = this.size - 1; i >= 0; i--) {
/* 1876 */       char c1 = arrayOfChar1[i];
/* 1877 */       char c2 = arrayOfChar2[i];
/* 1878 */       if (c1 != c2 && Character.toUpperCase(c1) != Character.toUpperCase(c2)) {
/* 1879 */         return false;
/*      */       }
/*      */     } 
/* 1882 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   char[] getBuffer() {
/* 1887 */     return this.buffer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public char[] getChars(char[] paramArrayOfchar) {
/* 1897 */     int i = length();
/* 1898 */     if (paramArrayOfchar == null || paramArrayOfchar.length < i) {
/* 1899 */       paramArrayOfchar = new char[i];
/*      */     }
/* 1901 */     System.arraycopy(this.buffer, 0, paramArrayOfchar, 0, i);
/* 1902 */     return paramArrayOfchar;
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
/* 1916 */     if (paramInt1 < 0) {
/* 1917 */       throw new StringIndexOutOfBoundsException(paramInt1);
/*      */     }
/* 1919 */     if (paramInt2 < 0 || paramInt2 > length()) {
/* 1920 */       throw new StringIndexOutOfBoundsException(paramInt2);
/*      */     }
/* 1922 */     if (paramInt1 > paramInt2) {
/* 1923 */       throw new StringIndexOutOfBoundsException("end < start");
/*      */     }
/* 1925 */     System.arraycopy(this.buffer, paramInt1, paramArrayOfchar, paramInt3, paramInt2 - paramInt1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNewLineText() {
/* 1934 */     return this.newLine;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNullText() {
/* 1943 */     return this.nullText;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/* 1953 */     return Arrays.hashCode(this.buffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int indexOf(char paramChar) {
/* 1963 */     return indexOf(paramChar, 0);
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
/* 1974 */     paramInt = Math.max(0, paramInt);
/* 1975 */     if (paramInt >= this.size) {
/* 1976 */       return -1;
/*      */     }
/* 1978 */     char[] arrayOfChar = this.buffer;
/* 1979 */     for (int i = paramInt; i < this.size; i++) {
/* 1980 */       if (arrayOfChar[i] == paramChar) {
/* 1981 */         return i;
/*      */       }
/*      */     } 
/* 1984 */     return -1;
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
/* 1996 */     return indexOf(paramString, 0);
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
/*      */   public int indexOf(String paramString, int paramInt) {
/* 2011 */     paramInt = Math.max(0, paramInt);
/* 2012 */     if (paramString == null || paramInt >= this.size) {
/* 2013 */       return -1;
/*      */     }
/* 2015 */     int i = paramString.length();
/* 2016 */     if (i == 1) {
/* 2017 */       return indexOf(paramString.charAt(0), paramInt);
/*      */     }
/* 2019 */     if (i == 0) {
/* 2020 */       return paramInt;
/*      */     }
/* 2022 */     if (i > this.size) {
/* 2023 */       return -1;
/*      */     }
/* 2025 */     char[] arrayOfChar = this.buffer;
/* 2026 */     int j = this.size - i + 1;
/* 2027 */     for (int k = paramInt; k < j; k++) {
/* 2028 */       byte b = 0; while (true) { if (b < i) {
/* 2029 */           if (paramString.charAt(b) != arrayOfChar[k + b])
/*      */             break;  b++;
/*      */           continue;
/*      */         } 
/* 2033 */         return k; }
/*      */     
/* 2035 */     }  return -1;
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
/*      */   public int indexOf(StringMatcher paramStringMatcher) {
/* 2049 */     return indexOf(paramStringMatcher, 0);
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
/*      */   public int indexOf(StringMatcher paramStringMatcher, int paramInt) {
/* 2064 */     paramInt = Math.max(0, paramInt);
/* 2065 */     if (paramStringMatcher == null || paramInt >= this.size) {
/* 2066 */       return -1;
/*      */     }
/* 2068 */     int i = this.size;
/* 2069 */     char[] arrayOfChar = this.buffer;
/* 2070 */     for (int j = paramInt; j < i; j++) {
/* 2071 */       if (paramStringMatcher.isMatch(arrayOfChar, j, paramInt, i) > 0) {
/* 2072 */         return j;
/*      */       }
/*      */     } 
/* 2075 */     return -1;
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
/*      */   public TextStringBuilder insert(int paramInt, boolean paramBoolean) {
/* 2087 */     validateIndex(paramInt);
/* 2088 */     if (paramBoolean) {
/* 2089 */       ensureCapacity(this.size + TRUE_STRING_SIZE);
/* 2090 */       System.arraycopy(this.buffer, paramInt, this.buffer, paramInt + TRUE_STRING_SIZE, this.size - paramInt);
/* 2091 */       appendTrue(paramInt);
/*      */     } else {
/* 2093 */       ensureCapacity(this.size + FALSE_STRING_SIZE);
/* 2094 */       System.arraycopy(this.buffer, paramInt, this.buffer, paramInt + FALSE_STRING_SIZE, this.size - paramInt);
/* 2095 */       appendFalse(paramInt);
/*      */     } 
/* 2097 */     return this;
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
/*      */   public TextStringBuilder insert(int paramInt, char paramChar) {
/* 2109 */     validateIndex(paramInt);
/* 2110 */     ensureCapacity(this.size + 1);
/* 2111 */     System.arraycopy(this.buffer, paramInt, this.buffer, paramInt + 1, this.size - paramInt);
/* 2112 */     this.buffer[paramInt] = paramChar;
/* 2113 */     this.size++;
/* 2114 */     return this;
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
/*      */   public TextStringBuilder insert(int paramInt, char[] paramArrayOfchar) {
/* 2126 */     validateIndex(paramInt);
/* 2127 */     if (paramArrayOfchar == null) {
/* 2128 */       return insert(paramInt, this.nullText);
/*      */     }
/* 2130 */     int i = paramArrayOfchar.length;
/* 2131 */     if (i > 0) {
/* 2132 */       ensureCapacity(this.size + i);
/* 2133 */       System.arraycopy(this.buffer, paramInt, this.buffer, paramInt + i, this.size - paramInt);
/* 2134 */       System.arraycopy(paramArrayOfchar, 0, this.buffer, paramInt, i);
/* 2135 */       this.size += i;
/*      */     } 
/* 2137 */     return this;
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
/*      */   public TextStringBuilder insert(int paramInt1, char[] paramArrayOfchar, int paramInt2, int paramInt3) {
/* 2151 */     validateIndex(paramInt1);
/* 2152 */     if (paramArrayOfchar == null) {
/* 2153 */       return insert(paramInt1, this.nullText);
/*      */     }
/* 2155 */     if (paramInt2 < 0 || paramInt2 > paramArrayOfchar.length) {
/* 2156 */       throw new StringIndexOutOfBoundsException("Invalid offset: " + paramInt2);
/*      */     }
/* 2158 */     if (paramInt3 < 0 || paramInt2 + paramInt3 > paramArrayOfchar.length) {
/* 2159 */       throw new StringIndexOutOfBoundsException("Invalid length: " + paramInt3);
/*      */     }
/* 2161 */     if (paramInt3 > 0) {
/* 2162 */       ensureCapacity(this.size + paramInt3);
/* 2163 */       System.arraycopy(this.buffer, paramInt1, this.buffer, paramInt1 + paramInt3, this.size - paramInt1);
/* 2164 */       System.arraycopy(paramArrayOfchar, paramInt2, this.buffer, paramInt1, paramInt3);
/* 2165 */       this.size += paramInt3;
/*      */     } 
/* 2167 */     return this;
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
/*      */   public TextStringBuilder insert(int paramInt, double paramDouble) {
/* 2179 */     return insert(paramInt, String.valueOf(paramDouble));
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
/*      */   public TextStringBuilder insert(int paramInt, float paramFloat) {
/* 2191 */     return insert(paramInt, String.valueOf(paramFloat));
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
/*      */   public TextStringBuilder insert(int paramInt1, int paramInt2) {
/* 2203 */     return insert(paramInt1, String.valueOf(paramInt2));
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
/*      */   public TextStringBuilder insert(int paramInt, long paramLong) {
/* 2215 */     return insert(paramInt, String.valueOf(paramLong));
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
/*      */   public TextStringBuilder insert(int paramInt, Object paramObject) {
/* 2228 */     if (paramObject == null) {
/* 2229 */       return insert(paramInt, this.nullText);
/*      */     }
/* 2231 */     return insert(paramInt, paramObject.toString());
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
/*      */   public TextStringBuilder insert(int paramInt, String paramString) {
/* 2243 */     validateIndex(paramInt);
/* 2244 */     if (paramString == null) {
/* 2245 */       paramString = this.nullText;
/*      */     }
/* 2247 */     if (paramString != null) {
/* 2248 */       int i = paramString.length();
/* 2249 */       if (i > 0) {
/* 2250 */         int j = this.size + i;
/* 2251 */         ensureCapacity(j);
/* 2252 */         System.arraycopy(this.buffer, paramInt, this.buffer, paramInt + i, this.size - paramInt);
/* 2253 */         this.size = j;
/* 2254 */         paramString.getChars(0, i, this.buffer, paramInt);
/*      */       } 
/*      */     } 
/* 2257 */     return this;
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
/* 2269 */     return (this.size == 0);
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
/*      */   public boolean isNotEmpty() {
/* 2282 */     return (this.size != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isReallocated() {
/* 2292 */     return (this.reallocations > 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int lastIndexOf(char paramChar) {
/* 2302 */     return lastIndexOf(paramChar, this.size - 1);
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
/* 2313 */     paramInt = (paramInt >= this.size) ? (this.size - 1) : paramInt;
/* 2314 */     if (paramInt < 0) {
/* 2315 */       return -1;
/*      */     }
/* 2317 */     for (int i = paramInt; i >= 0; i--) {
/* 2318 */       if (this.buffer[i] == paramChar) {
/* 2319 */         return i;
/*      */       }
/*      */     } 
/* 2322 */     return -1;
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
/* 2334 */     return lastIndexOf(paramString, this.size - 1);
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
/*      */   public int lastIndexOf(String paramString, int paramInt) {
/* 2349 */     paramInt = (paramInt >= this.size) ? (this.size - 1) : paramInt;
/* 2350 */     if (paramString == null || paramInt < 0) {
/* 2351 */       return -1;
/*      */     }
/* 2353 */     int i = paramString.length();
/* 2354 */     if (i > 0 && i <= this.size) {
/* 2355 */       if (i == 1) {
/* 2356 */         return lastIndexOf(paramString.charAt(0), paramInt);
/*      */       }
/*      */       
/* 2359 */       for (int j = paramInt - i + 1; j >= 0; j--) {
/* 2360 */         byte b = 0; while (true) { if (b < i) {
/* 2361 */             if (paramString.charAt(b) != this.buffer[j + b])
/*      */               break;  b++;
/*      */             continue;
/*      */           } 
/* 2365 */           return j; }
/*      */       
/*      */       } 
/* 2368 */     } else if (i == 0) {
/* 2369 */       return paramInt;
/*      */     } 
/* 2371 */     return -1;
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
/*      */   public int lastIndexOf(StringMatcher paramStringMatcher) {
/* 2385 */     return lastIndexOf(paramStringMatcher, this.size);
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
/*      */   public int lastIndexOf(StringMatcher paramStringMatcher, int paramInt) {
/* 2400 */     paramInt = (paramInt >= this.size) ? (this.size - 1) : paramInt;
/* 2401 */     if (paramStringMatcher == null || paramInt < 0) {
/* 2402 */       return -1;
/*      */     }
/* 2404 */     char[] arrayOfChar = this.buffer;
/* 2405 */     int i = paramInt + 1;
/* 2406 */     for (int j = paramInt; j >= 0; j--) {
/* 2407 */       if (paramStringMatcher.isMatch(arrayOfChar, j, 0, i) > 0) {
/* 2408 */         return j;
/*      */       }
/*      */     } 
/* 2411 */     return -1;
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
/*      */   public String leftString(int paramInt) {
/* 2425 */     if (paramInt <= 0)
/* 2426 */       return ""; 
/* 2427 */     if (paramInt >= this.size) {
/* 2428 */       return new String(this.buffer, 0, this.size);
/*      */     }
/* 2430 */     return new String(this.buffer, 0, paramInt);
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
/* 2441 */     return this.size;
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
/*      */   public String midString(int paramInt1, int paramInt2) {
/* 2458 */     if (paramInt1 < 0) {
/* 2459 */       paramInt1 = 0;
/*      */     }
/* 2461 */     if (paramInt2 <= 0 || paramInt1 >= this.size) {
/* 2462 */       return "";
/*      */     }
/* 2464 */     if (this.size <= paramInt1 + paramInt2) {
/* 2465 */       return new String(this.buffer, paramInt1, this.size - paramInt1);
/*      */     }
/* 2467 */     return new String(this.buffer, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder minimizeCapacity() {
/* 2476 */     if (this.buffer.length > this.size) {
/* 2477 */       reallocate(this.size);
/*      */     }
/* 2479 */     return this;
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
/*      */   public int readFrom(CharBuffer paramCharBuffer) throws IOException {
/* 2494 */     int i = this.size;
/* 2495 */     int j = paramCharBuffer.remaining();
/* 2496 */     ensureCapacity(this.size + j);
/* 2497 */     paramCharBuffer.get(this.buffer, this.size, j);
/* 2498 */     this.size += j;
/* 2499 */     return this.size - i;
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
/*      */   public int readFrom(Readable paramReadable) throws IOException {
/* 2513 */     if (paramReadable instanceof Reader)
/* 2514 */       return readFrom((Reader)paramReadable); 
/* 2515 */     if (paramReadable instanceof CharBuffer) {
/* 2516 */       return readFrom((CharBuffer)paramReadable);
/*      */     }
/* 2518 */     int i = this.size;
/*      */     while (true) {
/* 2520 */       ensureCapacity(this.size + 1);
/* 2521 */       CharBuffer charBuffer = CharBuffer.wrap(this.buffer, this.size, this.buffer.length - this.size);
/* 2522 */       int j = paramReadable.read(charBuffer);
/* 2523 */       if (j == -1) {
/*      */         break;
/*      */       }
/* 2526 */       this.size += j;
/*      */     } 
/* 2528 */     return this.size - i;
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
/*      */   public int readFrom(Reader paramReader) throws IOException {
/* 2544 */     int i = this.size;
/* 2545 */     ensureCapacity(this.size + 1);
/* 2546 */     int j = paramReader.read(this.buffer, this.size, this.buffer.length - this.size);
/* 2547 */     if (j == -1) {
/* 2548 */       return -1;
/*      */     }
/*      */     while (true) {
/* 2551 */       this.size += j;
/* 2552 */       ensureCapacity(this.size + 1);
/* 2553 */       j = paramReader.read(this.buffer, this.size, this.buffer.length - this.size);
/* 2554 */       if (j == -1) {
/* 2555 */         return this.size - i;
/*      */       }
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
/*      */   public int readFrom(Reader paramReader, int paramInt) throws IOException {
/* 2571 */     if (paramInt <= 0) {
/* 2572 */       return 0;
/*      */     }
/* 2574 */     int i = this.size;
/* 2575 */     ensureCapacity(this.size + paramInt);
/* 2576 */     int j = paramInt;
/* 2577 */     int k = paramReader.read(this.buffer, this.size, j);
/* 2578 */     if (k == -1) {
/* 2579 */       return -1;
/*      */     }
/*      */     do {
/* 2582 */       j -= k;
/* 2583 */       this.size += k;
/* 2584 */       k = paramReader.read(this.buffer, this.size, j);
/* 2585 */     } while (j > 0 && k != -1);
/* 2586 */     return this.size - i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void reallocate(int paramInt) {
/* 2595 */     this.buffer = Arrays.copyOf(this.buffer, paramInt);
/* 2596 */     this.reallocations++;
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
/*      */   public TextStringBuilder replace(int paramInt1, int paramInt2, String paramString) {
/* 2610 */     paramInt2 = validateRange(paramInt1, paramInt2);
/* 2611 */     boolean bool = (paramString == null) ? false : paramString.length();
/* 2612 */     replaceImpl(paramInt1, paramInt2, paramInt2 - paramInt1, paramString, bool);
/* 2613 */     return this;
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
/*      */   public TextStringBuilder replace(StringMatcher paramStringMatcher, String paramString, int paramInt1, int paramInt2, int paramInt3) {
/* 2633 */     paramInt2 = validateRange(paramInt1, paramInt2);
/* 2634 */     return replaceImpl(paramStringMatcher, paramString, paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder replaceAll(char paramChar1, char paramChar2) {
/* 2645 */     if (paramChar1 != paramChar2) {
/* 2646 */       for (byte b = 0; b < this.size; b++) {
/* 2647 */         if (this.buffer[b] == paramChar1) {
/* 2648 */           this.buffer[b] = paramChar2;
/*      */         }
/*      */       } 
/*      */     }
/* 2652 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder replaceAll(String paramString1, String paramString2) {
/* 2663 */     byte b = (paramString1 == null) ? 0 : paramString1.length();
/* 2664 */     if (b) {
/* 2665 */       byte b1 = (paramString2 == null) ? 0 : paramString2.length();
/* 2666 */       int i = indexOf(paramString1, 0);
/* 2667 */       while (i >= 0) {
/* 2668 */         replaceImpl(i, i + b, b, paramString2, b1);
/* 2669 */         i = indexOf(paramString1, i + b1);
/*      */       } 
/*      */     } 
/* 2672 */     return this;
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
/*      */   public TextStringBuilder replaceAll(StringMatcher paramStringMatcher, String paramString) {
/* 2687 */     return replace(paramStringMatcher, paramString, 0, this.size, -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder replaceFirst(char paramChar1, char paramChar2) {
/* 2698 */     if (paramChar1 != paramChar2) {
/* 2699 */       for (byte b = 0; b < this.size; b++) {
/* 2700 */         if (this.buffer[b] == paramChar1) {
/* 2701 */           this.buffer[b] = paramChar2;
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/* 2706 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder replaceFirst(String paramString1, String paramString2) {
/* 2717 */     byte b = (paramString1 == null) ? 0 : paramString1.length();
/* 2718 */     if (b) {
/* 2719 */       int i = indexOf(paramString1, 0);
/* 2720 */       if (i >= 0) {
/* 2721 */         boolean bool = (paramString2 == null) ? false : paramString2.length();
/* 2722 */         replaceImpl(i, i + b, b, paramString2, bool);
/*      */       } 
/*      */     } 
/* 2725 */     return this;
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
/*      */   public TextStringBuilder replaceFirst(StringMatcher paramStringMatcher, String paramString) {
/* 2740 */     return replace(paramStringMatcher, paramString, 0, this.size, 1);
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
/* 2755 */     int i = this.size - paramInt3 + paramInt4;
/* 2756 */     if (paramInt4 != paramInt3) {
/* 2757 */       ensureCapacity(i);
/* 2758 */       System.arraycopy(this.buffer, paramInt2, this.buffer, paramInt1 + paramInt4, this.size - paramInt2);
/* 2759 */       this.size = i;
/*      */     } 
/* 2761 */     if (paramInt4 > 0) {
/* 2762 */       paramString.getChars(0, paramInt4, this.buffer, paramInt1);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private TextStringBuilder replaceImpl(StringMatcher paramStringMatcher, String paramString, int paramInt1, int paramInt2, int paramInt3) {
/* 2783 */     if (paramStringMatcher == null || this.size == 0) {
/* 2784 */       return this;
/*      */     }
/* 2786 */     byte b = (paramString == null) ? 0 : paramString.length();
/* 2787 */     for (int i = paramInt1; i < paramInt2 && paramInt3 != 0; i++) {
/* 2788 */       char[] arrayOfChar = this.buffer;
/* 2789 */       int j = paramStringMatcher.isMatch(arrayOfChar, i, paramInt1, paramInt2);
/* 2790 */       if (j > 0) {
/* 2791 */         replaceImpl(i, i + j, j, paramString, b);
/* 2792 */         paramInt2 = paramInt2 - j + b;
/* 2793 */         i = i + b - 1;
/* 2794 */         if (paramInt3 > 0) {
/* 2795 */           paramInt3--;
/*      */         }
/*      */       } 
/*      */     } 
/* 2799 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder reverse() {
/* 2808 */     if (this.size == 0) {
/* 2809 */       return this;
/*      */     }
/*      */     
/* 2812 */     int i = this.size / 2;
/* 2813 */     char[] arrayOfChar = this.buffer; byte b; int j;
/* 2814 */     for (b = 0, j = this.size - 1; b < i; b++, j--) {
/* 2815 */       char c = arrayOfChar[b];
/* 2816 */       arrayOfChar[b] = arrayOfChar[j];
/* 2817 */       arrayOfChar[j] = c;
/*      */     } 
/* 2819 */     return this;
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
/*      */   public String rightString(int paramInt) {
/* 2833 */     if (paramInt <= 0)
/* 2834 */       return ""; 
/* 2835 */     if (paramInt >= this.size) {
/* 2836 */       return new String(this.buffer, 0, this.size);
/*      */     }
/* 2838 */     return new String(this.buffer, this.size - paramInt, paramInt);
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
/*      */   public TextStringBuilder set(CharSequence paramCharSequence) {
/* 2852 */     clear();
/* 2853 */     append(paramCharSequence);
/* 2854 */     return this;
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
/*      */   public TextStringBuilder setCharAt(int paramInt, char paramChar) {
/* 2868 */     validateIndex(paramInt);
/* 2869 */     this.buffer[paramInt] = paramChar;
/* 2870 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder setLength(int paramInt) {
/* 2881 */     if (paramInt < 0) {
/* 2882 */       throw new StringIndexOutOfBoundsException(paramInt);
/*      */     }
/* 2884 */     if (paramInt < this.size) {
/* 2885 */       this.size = paramInt;
/* 2886 */     } else if (paramInt > this.size) {
/* 2887 */       ensureCapacity(paramInt);
/* 2888 */       int i = this.size;
/* 2889 */       int j = paramInt;
/* 2890 */       this.size = paramInt;
/* 2891 */       Arrays.fill(this.buffer, i, j, false);
/*      */     } 
/* 2893 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder setNewLineText(String paramString) {
/* 2903 */     this.newLine = paramString;
/* 2904 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder setNullText(String paramString) {
/* 2914 */     if (paramString != null && paramString.isEmpty()) {
/* 2915 */       paramString = null;
/*      */     }
/* 2917 */     this.nullText = paramString;
/* 2918 */     return this;
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
/*      */   public int size() {
/* 2930 */     return this.size;
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
/* 2943 */     if (paramString == null) {
/* 2944 */       return false;
/*      */     }
/* 2946 */     int i = paramString.length();
/* 2947 */     if (i == 0) {
/* 2948 */       return true;
/*      */     }
/* 2950 */     if (i > this.size) {
/* 2951 */       return false;
/*      */     }
/* 2953 */     for (byte b = 0; b < i; b++) {
/* 2954 */       if (this.buffer[b] != paramString.charAt(b)) {
/* 2955 */         return false;
/*      */       }
/*      */     } 
/* 2958 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CharSequence subSequence(int paramInt1, int paramInt2) {
/* 2966 */     if (paramInt1 < 0) {
/* 2967 */       throw new StringIndexOutOfBoundsException(paramInt1);
/*      */     }
/* 2969 */     if (paramInt2 > this.size) {
/* 2970 */       throw new StringIndexOutOfBoundsException(paramInt2);
/*      */     }
/* 2972 */     if (paramInt1 > paramInt2) {
/* 2973 */       throw new StringIndexOutOfBoundsException(paramInt2 - paramInt1);
/*      */     }
/* 2975 */     return substring(paramInt1, paramInt2);
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
/* 2986 */     return substring(paramInt, this.size);
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
/*      */   public String substring(int paramInt1, int paramInt2) {
/* 3002 */     paramInt2 = validateRange(paramInt1, paramInt2);
/* 3003 */     return new String(this.buffer, paramInt1, paramInt2 - paramInt1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public char[] toCharArray() {
/* 3012 */     return (this.size == 0) ? ArrayUtils.EMPTY_CHAR_ARRAY : Arrays.copyOf(this.buffer, this.size);
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
/*      */   public char[] toCharArray(int paramInt1, int paramInt2) {
/* 3025 */     paramInt2 = validateRange(paramInt1, paramInt2);
/* 3026 */     int i = paramInt2 - paramInt1;
/* 3027 */     return (i == 0) ? ArrayUtils.EMPTY_CHAR_ARRAY : Arrays.copyOfRange(this.buffer, paramInt1, paramInt2);
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
/*      */   public String toString() {
/* 3039 */     return new String(this.buffer, 0, this.size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuffer toStringBuffer() {
/* 3048 */     return (new StringBuffer(this.size)).append(this.buffer, 0, this.size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder toStringBuilder() {
/* 3057 */     return (new StringBuilder(this.size)).append(this.buffer, 0, this.size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextStringBuilder trim() {
/* 3066 */     if (this.size == 0) {
/* 3067 */       return this;
/*      */     }
/* 3069 */     int i = this.size;
/* 3070 */     char[] arrayOfChar = this.buffer;
/* 3071 */     byte b = 0;
/* 3072 */     while (b < i && arrayOfChar[b] <= ' ') {
/* 3073 */       b++;
/*      */     }
/* 3075 */     while (b < i && arrayOfChar[i - 1] <= ' ') {
/* 3076 */       i--;
/*      */     }
/* 3078 */     if (i < this.size) {
/* 3079 */       delete(i, this.size);
/*      */     }
/* 3081 */     if (b > 0) {
/* 3082 */       delete(0, b);
/*      */     }
/* 3084 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void validateIndex(int paramInt) {
/* 3094 */     if (paramInt < 0 || paramInt >= this.size) {
/* 3095 */       throw new StringIndexOutOfBoundsException(paramInt);
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
/*      */   protected int validateRange(int paramInt1, int paramInt2) {
/* 3108 */     if (paramInt1 < 0) {
/* 3109 */       throw new StringIndexOutOfBoundsException(paramInt1);
/*      */     }
/* 3111 */     if (paramInt2 > this.size) {
/* 3112 */       paramInt2 = this.size;
/*      */     }
/* 3114 */     if (paramInt1 > paramInt2) {
/* 3115 */       throw new StringIndexOutOfBoundsException("end < start");
/*      */     }
/* 3117 */     return paramInt2;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\TextStringBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */