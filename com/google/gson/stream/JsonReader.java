/*      */ package com.google.gson.stream;
/*      */ 
/*      */ import com.google.gson.internal.JsonReaderInternalAccess;
/*      */ import com.google.gson.internal.bind.JsonTreeReader;
/*      */ import java.io.Closeable;
/*      */ import java.io.EOFException;
/*      */ import java.io.IOException;
/*      */ import java.io.Reader;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class JsonReader
/*      */   implements Closeable
/*      */ {
/*  192 */   private static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
/*      */   
/*      */   private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
/*      */   
/*      */   private static final int PEEKED_NONE = 0;
/*      */   
/*      */   private static final int PEEKED_BEGIN_OBJECT = 1;
/*      */   
/*      */   private static final int PEEKED_END_OBJECT = 2;
/*      */   
/*      */   private static final int PEEKED_BEGIN_ARRAY = 3;
/*      */   
/*      */   private static final int PEEKED_END_ARRAY = 4;
/*      */   
/*      */   private static final int PEEKED_TRUE = 5;
/*      */   
/*      */   private static final int PEEKED_FALSE = 6;
/*      */   
/*      */   private static final int PEEKED_NULL = 7;
/*      */   
/*      */   private static final int PEEKED_SINGLE_QUOTED = 8;
/*      */   
/*      */   private static final int PEEKED_DOUBLE_QUOTED = 9;
/*      */   
/*      */   private static final int PEEKED_UNQUOTED = 10;
/*      */   
/*      */   private static final int PEEKED_BUFFERED = 11;
/*      */   
/*      */   private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
/*      */   
/*      */   private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
/*      */   
/*      */   private static final int PEEKED_UNQUOTED_NAME = 14;
/*      */   private static final int PEEKED_LONG = 15;
/*      */   private static final int PEEKED_NUMBER = 16;
/*      */   private static final int PEEKED_EOF = 17;
/*      */   private static final int NUMBER_CHAR_NONE = 0;
/*      */   private static final int NUMBER_CHAR_SIGN = 1;
/*      */   private static final int NUMBER_CHAR_DIGIT = 2;
/*      */   private static final int NUMBER_CHAR_DECIMAL = 3;
/*      */   private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
/*      */   private static final int NUMBER_CHAR_EXP_E = 5;
/*      */   private static final int NUMBER_CHAR_EXP_SIGN = 6;
/*      */   private static final int NUMBER_CHAR_EXP_DIGIT = 7;
/*      */   private final Reader in;
/*      */   private boolean lenient = false;
/*  238 */   private final char[] buffer = new char[1024];
/*  239 */   private int pos = 0;
/*  240 */   private int limit = 0;
/*      */   
/*  242 */   private int lineNumber = 0;
/*  243 */   private int lineStart = 0;
/*      */   
/*  245 */   int peeked = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private long peekedLong;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int peekedNumberLength;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String peekedString;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  269 */   private int[] stack = new int[32];
/*  270 */   private int stackSize = 0; private String[] pathNames; private int[] pathIndices;
/*      */   public JsonReader(Reader paramReader) {
/*  272 */     this.stack[this.stackSize++] = 6;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  283 */     this.pathNames = new String[32];
/*  284 */     this.pathIndices = new int[32];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  290 */     if (paramReader == null) {
/*  291 */       throw new NullPointerException("in == null");
/*      */     }
/*  293 */     this.in = paramReader;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void setLenient(boolean paramBoolean) {
/*  326 */     this.lenient = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean isLenient() {
/*  333 */     return this.lenient;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void beginArray() throws IOException {
/*  341 */     int i = this.peeked;
/*  342 */     if (i == 0) {
/*  343 */       i = doPeek();
/*      */     }
/*  345 */     if (i == 3) {
/*  346 */       push(1);
/*  347 */       this.pathIndices[this.stackSize - 1] = 0;
/*  348 */       this.peeked = 0;
/*      */     } else {
/*  350 */       throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + locationString());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void endArray() throws IOException {
/*  359 */     int i = this.peeked;
/*  360 */     if (i == 0) {
/*  361 */       i = doPeek();
/*      */     }
/*  363 */     if (i == 4) {
/*  364 */       this.stackSize--;
/*  365 */       this.pathIndices[this.stackSize - 1] = this.pathIndices[this.stackSize - 1] + 1;
/*  366 */       this.peeked = 0;
/*      */     } else {
/*  368 */       throw new IllegalStateException("Expected END_ARRAY but was " + peek() + locationString());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void beginObject() throws IOException {
/*  377 */     int i = this.peeked;
/*  378 */     if (i == 0) {
/*  379 */       i = doPeek();
/*      */     }
/*  381 */     if (i == 1) {
/*  382 */       push(3);
/*  383 */       this.peeked = 0;
/*      */     } else {
/*  385 */       throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + locationString());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void endObject() throws IOException {
/*  394 */     int i = this.peeked;
/*  395 */     if (i == 0) {
/*  396 */       i = doPeek();
/*      */     }
/*  398 */     if (i == 2) {
/*  399 */       this.stackSize--;
/*  400 */       this.pathNames[this.stackSize] = null;
/*  401 */       this.pathIndices[this.stackSize - 1] = this.pathIndices[this.stackSize - 1] + 1;
/*  402 */       this.peeked = 0;
/*      */     } else {
/*  404 */       throw new IllegalStateException("Expected END_OBJECT but was " + peek() + locationString());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasNext() throws IOException {
/*  412 */     int i = this.peeked;
/*  413 */     if (i == 0) {
/*  414 */       i = doPeek();
/*      */     }
/*  416 */     return (i != 2 && i != 4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JsonToken peek() throws IOException {
/*  423 */     int i = this.peeked;
/*  424 */     if (i == 0) {
/*  425 */       i = doPeek();
/*      */     }
/*      */     
/*  428 */     switch (i) {
/*      */       case 1:
/*  430 */         return JsonToken.BEGIN_OBJECT;
/*      */       case 2:
/*  432 */         return JsonToken.END_OBJECT;
/*      */       case 3:
/*  434 */         return JsonToken.BEGIN_ARRAY;
/*      */       case 4:
/*  436 */         return JsonToken.END_ARRAY;
/*      */       case 12:
/*      */       case 13:
/*      */       case 14:
/*  440 */         return JsonToken.NAME;
/*      */       case 5:
/*      */       case 6:
/*  443 */         return JsonToken.BOOLEAN;
/*      */       case 7:
/*  445 */         return JsonToken.NULL;
/*      */       case 8:
/*      */       case 9:
/*      */       case 10:
/*      */       case 11:
/*  450 */         return JsonToken.STRING;
/*      */       case 15:
/*      */       case 16:
/*  453 */         return JsonToken.NUMBER;
/*      */       case 17:
/*  455 */         return JsonToken.END_DOCUMENT;
/*      */     } 
/*  457 */     throw new AssertionError();
/*      */   }
/*      */ 
/*      */   
/*      */   int doPeek() throws IOException {
/*  462 */     int i = this.stack[this.stackSize - 1];
/*  463 */     if (i == 1)
/*  464 */     { this.stack[this.stackSize - 1] = 2; }
/*  465 */     else if (i == 2)
/*      */     
/*  467 */     { int m = nextNonWhitespace(true);
/*  468 */       switch (m) {
/*      */         case 93:
/*  470 */           return this.peeked = 4;
/*      */         case 59:
/*  472 */           checkLenient(); break;
/*      */         case 44:
/*      */           break;
/*      */         default:
/*  476 */           throw syntaxError("Unterminated array");
/*      */       }  }
/*  478 */     else { if (i == 3 || i == 5) {
/*  479 */         this.stack[this.stackSize - 1] = 4;
/*      */         
/*  481 */         if (i == 5) {
/*  482 */           int n = nextNonWhitespace(true);
/*  483 */           switch (n) {
/*      */             case 125:
/*  485 */               return this.peeked = 2;
/*      */             case 59:
/*  487 */               checkLenient(); break;
/*      */             case 44:
/*      */               break;
/*      */             default:
/*  491 */               throw syntaxError("Unterminated object");
/*      */           } 
/*      */         } 
/*  494 */         int m = nextNonWhitespace(true);
/*  495 */         switch (m) {
/*      */           case 34:
/*  497 */             return this.peeked = 13;
/*      */           case 39:
/*  499 */             checkLenient();
/*  500 */             return this.peeked = 12;
/*      */           case 125:
/*  502 */             if (i != 5) {
/*  503 */               return this.peeked = 2;
/*      */             }
/*  505 */             throw syntaxError("Expected name");
/*      */         } 
/*      */         
/*  508 */         checkLenient();
/*  509 */         this.pos--;
/*  510 */         if (isLiteral((char)m)) {
/*  511 */           return this.peeked = 14;
/*      */         }
/*  513 */         throw syntaxError("Expected name");
/*      */       } 
/*      */       
/*  516 */       if (i == 4) {
/*  517 */         this.stack[this.stackSize - 1] = 5;
/*      */         
/*  519 */         int m = nextNonWhitespace(true);
/*  520 */         switch (m) {
/*      */           case 58:
/*      */             break;
/*      */           case 61:
/*  524 */             checkLenient();
/*  525 */             if ((this.pos < this.limit || fillBuffer(1)) && this.buffer[this.pos] == '>') {
/*  526 */               this.pos++;
/*      */             }
/*      */             break;
/*      */           default:
/*  530 */             throw syntaxError("Expected ':'");
/*      */         } 
/*  532 */       } else if (i == 6) {
/*  533 */         if (this.lenient) {
/*  534 */           consumeNonExecutePrefix();
/*      */         }
/*  536 */         this.stack[this.stackSize - 1] = 7;
/*  537 */       } else if (i == 7) {
/*  538 */         int m = nextNonWhitespace(false);
/*  539 */         if (m == -1) {
/*  540 */           return this.peeked = 17;
/*      */         }
/*  542 */         checkLenient();
/*  543 */         this.pos--;
/*      */       }
/*  545 */       else if (i == 8) {
/*  546 */         throw new IllegalStateException("JsonReader is closed");
/*      */       }  }
/*      */     
/*  549 */     int j = nextNonWhitespace(true);
/*  550 */     switch (j) {
/*      */       case 93:
/*  552 */         if (i == 1) {
/*  553 */           return this.peeked = 4;
/*      */         }
/*      */ 
/*      */       
/*      */       case 44:
/*      */       case 59:
/*  559 */         if (i == 1 || i == 2) {
/*  560 */           checkLenient();
/*  561 */           this.pos--;
/*  562 */           return this.peeked = 7;
/*      */         } 
/*  564 */         throw syntaxError("Unexpected value");
/*      */       
/*      */       case 39:
/*  567 */         checkLenient();
/*  568 */         return this.peeked = 8;
/*      */       case 34:
/*  570 */         return this.peeked = 9;
/*      */       case 91:
/*  572 */         return this.peeked = 3;
/*      */       case 123:
/*  574 */         return this.peeked = 1;
/*      */     } 
/*  576 */     this.pos--;
/*      */ 
/*      */     
/*  579 */     int k = peekKeyword();
/*  580 */     if (k != 0) {
/*  581 */       return k;
/*      */     }
/*      */     
/*  584 */     k = peekNumber();
/*  585 */     if (k != 0) {
/*  586 */       return k;
/*      */     }
/*      */     
/*  589 */     if (!isLiteral(this.buffer[this.pos])) {
/*  590 */       throw syntaxError("Expected value");
/*      */     }
/*      */     
/*  593 */     checkLenient();
/*  594 */     return this.peeked = 10;
/*      */   }
/*      */   private int peekKeyword() throws IOException {
/*      */     String str1, str2;
/*      */     byte b1;
/*  599 */     char c = this.buffer[this.pos];
/*      */ 
/*      */ 
/*      */     
/*  603 */     if (c == 't' || c == 'T') {
/*  604 */       str1 = "true";
/*  605 */       str2 = "TRUE";
/*  606 */       b1 = 5;
/*  607 */     } else if (c == 'f' || c == 'F') {
/*  608 */       str1 = "false";
/*  609 */       str2 = "FALSE";
/*  610 */       b1 = 6;
/*  611 */     } else if (c == 'n' || c == 'N') {
/*  612 */       str1 = "null";
/*  613 */       str2 = "NULL";
/*  614 */       b1 = 7;
/*      */     } else {
/*  616 */       return 0;
/*      */     } 
/*      */ 
/*      */     
/*  620 */     int i = str1.length();
/*  621 */     for (byte b2 = 1; b2 < i; b2++) {
/*  622 */       if (this.pos + b2 >= this.limit && !fillBuffer(b2 + 1)) {
/*  623 */         return 0;
/*      */       }
/*  625 */       c = this.buffer[this.pos + b2];
/*  626 */       if (c != str1.charAt(b2) && c != str2.charAt(b2)) {
/*  627 */         return 0;
/*      */       }
/*      */     } 
/*      */     
/*  631 */     if ((this.pos + i < this.limit || fillBuffer(i + 1)) && 
/*  632 */       isLiteral(this.buffer[this.pos + i])) {
/*  633 */       return 0;
/*      */     }
/*      */ 
/*      */     
/*  637 */     this.pos += i;
/*  638 */     return this.peeked = b1;
/*      */   }
/*      */ 
/*      */   
/*      */   private int peekNumber() throws IOException {
/*  643 */     char[] arrayOfChar = this.buffer;
/*  644 */     int i = this.pos;
/*  645 */     int j = this.limit;
/*      */     
/*  647 */     long l = 0L;
/*  648 */     boolean bool = false;
/*  649 */     int k = 1;
/*  650 */     byte b1 = 0;
/*      */     
/*  652 */     byte b2 = 0;
/*      */ 
/*      */     
/*  655 */     for (;; b2++) {
/*  656 */       if (i + b2 == j) {
/*  657 */         if (b2 == arrayOfChar.length)
/*      */         {
/*      */           
/*  660 */           return 0;
/*      */         }
/*  662 */         if (!fillBuffer(b2 + 1)) {
/*      */           break;
/*      */         }
/*  665 */         i = this.pos;
/*  666 */         j = this.limit;
/*      */       } 
/*      */       
/*  669 */       char c = arrayOfChar[i + b2];
/*  670 */       switch (c) {
/*      */         case '-':
/*  672 */           if (!b1) {
/*  673 */             bool = true;
/*  674 */             b1 = 1; break;
/*      */           } 
/*  676 */           if (b1 == 5) {
/*  677 */             b1 = 6;
/*      */             break;
/*      */           } 
/*  680 */           return 0;
/*      */         
/*      */         case '+':
/*  683 */           if (b1 == 5) {
/*  684 */             b1 = 6;
/*      */             break;
/*      */           } 
/*  687 */           return 0;
/*      */         
/*      */         case 'E':
/*      */         case 'e':
/*  691 */           if (b1 == 2 || b1 == 4) {
/*  692 */             b1 = 5;
/*      */             break;
/*      */           } 
/*  695 */           return 0;
/*      */         
/*      */         case '.':
/*  698 */           if (b1 == 2) {
/*  699 */             b1 = 3;
/*      */             break;
/*      */           } 
/*  702 */           return 0;
/*      */         
/*      */         default:
/*  705 */           if (c < '0' || c > '9') {
/*  706 */             if (!isLiteral(c)) {
/*      */               break;
/*      */             }
/*  709 */             return 0;
/*      */           } 
/*  711 */           if (b1 == 1 || b1 == 0) {
/*  712 */             l = -(c - 48);
/*  713 */             b1 = 2; break;
/*  714 */           }  if (b1 == 2) {
/*  715 */             if (l == 0L) {
/*  716 */               return 0;
/*      */             }
/*  718 */             long l1 = l * 10L - (c - 48);
/*  719 */             k &= (l > -922337203685477580L || (l == -922337203685477580L && l1 < l)) ? 1 : 0;
/*      */             
/*  721 */             l = l1; break;
/*  722 */           }  if (b1 == 3) {
/*  723 */             b1 = 4; break;
/*  724 */           }  if (b1 == 5 || b1 == 6) {
/*  725 */             b1 = 7;
/*      */           }
/*      */           break;
/*      */       } 
/*      */     
/*      */     } 
/*  731 */     if (b1 == 2 && k != 0 && (l != Long.MIN_VALUE || bool) && (l != 0L || false == bool)) {
/*  732 */       this.peekedLong = bool ? l : -l;
/*  733 */       this.pos += b2;
/*  734 */       return this.peeked = 15;
/*  735 */     }  if (b1 == 2 || b1 == 4 || b1 == 7) {
/*      */       
/*  737 */       this.peekedNumberLength = b2;
/*  738 */       return this.peeked = 16;
/*      */     } 
/*  740 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean isLiteral(char paramChar) throws IOException {
/*  745 */     switch (paramChar) {
/*      */       case '#':
/*      */       case '/':
/*      */       case ';':
/*      */       case '=':
/*      */       case '\\':
/*  751 */         checkLenient();
/*      */       case '\t':
/*      */       case '\n':
/*      */       case '\f':
/*      */       case '\r':
/*      */       case ' ':
/*      */       case ',':
/*      */       case ':':
/*      */       case '[':
/*      */       case ']':
/*      */       case '{':
/*      */       case '}':
/*  763 */         return false;
/*      */     } 
/*  765 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String nextName() throws IOException {
/*      */     String str;
/*  777 */     int i = this.peeked;
/*  778 */     if (i == 0) {
/*  779 */       i = doPeek();
/*      */     }
/*      */     
/*  782 */     if (i == 14) {
/*  783 */       str = nextUnquotedValue();
/*  784 */     } else if (i == 12) {
/*  785 */       str = nextQuotedValue('\'');
/*  786 */     } else if (i == 13) {
/*  787 */       str = nextQuotedValue('"');
/*      */     } else {
/*  789 */       throw new IllegalStateException("Expected a name but was " + peek() + locationString());
/*      */     } 
/*  791 */     this.peeked = 0;
/*  792 */     this.pathNames[this.stackSize - 1] = str;
/*  793 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String nextString() throws IOException {
/*      */     String str;
/*  805 */     int i = this.peeked;
/*  806 */     if (i == 0) {
/*  807 */       i = doPeek();
/*      */     }
/*      */     
/*  810 */     if (i == 10) {
/*  811 */       str = nextUnquotedValue();
/*  812 */     } else if (i == 8) {
/*  813 */       str = nextQuotedValue('\'');
/*  814 */     } else if (i == 9) {
/*  815 */       str = nextQuotedValue('"');
/*  816 */     } else if (i == 11) {
/*  817 */       str = this.peekedString;
/*  818 */       this.peekedString = null;
/*  819 */     } else if (i == 15) {
/*  820 */       str = Long.toString(this.peekedLong);
/*  821 */     } else if (i == 16) {
/*  822 */       str = new String(this.buffer, this.pos, this.peekedNumberLength);
/*  823 */       this.pos += this.peekedNumberLength;
/*      */     } else {
/*  825 */       throw new IllegalStateException("Expected a string but was " + peek() + locationString());
/*      */     } 
/*  827 */     this.peeked = 0;
/*  828 */     this.pathIndices[this.stackSize - 1] = this.pathIndices[this.stackSize - 1] + 1;
/*  829 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean nextBoolean() throws IOException {
/*  840 */     int i = this.peeked;
/*  841 */     if (i == 0) {
/*  842 */       i = doPeek();
/*      */     }
/*  844 */     if (i == 5) {
/*  845 */       this.peeked = 0;
/*  846 */       this.pathIndices[this.stackSize - 1] = this.pathIndices[this.stackSize - 1] + 1;
/*  847 */       return true;
/*  848 */     }  if (i == 6) {
/*  849 */       this.peeked = 0;
/*  850 */       this.pathIndices[this.stackSize - 1] = this.pathIndices[this.stackSize - 1] + 1;
/*  851 */       return false;
/*      */     } 
/*  853 */     throw new IllegalStateException("Expected a boolean but was " + peek() + locationString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void nextNull() throws IOException {
/*  864 */     int i = this.peeked;
/*  865 */     if (i == 0) {
/*  866 */       i = doPeek();
/*      */     }
/*  868 */     if (i == 7) {
/*  869 */       this.peeked = 0;
/*  870 */       this.pathIndices[this.stackSize - 1] = this.pathIndices[this.stackSize - 1] + 1;
/*      */     } else {
/*  872 */       throw new IllegalStateException("Expected null but was " + peek() + locationString());
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
/*      */   public double nextDouble() throws IOException {
/*  886 */     int i = this.peeked;
/*  887 */     if (i == 0) {
/*  888 */       i = doPeek();
/*      */     }
/*      */     
/*  891 */     if (i == 15) {
/*  892 */       this.peeked = 0;
/*  893 */       this.pathIndices[this.stackSize - 1] = this.pathIndices[this.stackSize - 1] + 1;
/*  894 */       return this.peekedLong;
/*      */     } 
/*      */     
/*  897 */     if (i == 16) {
/*  898 */       this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
/*  899 */       this.pos += this.peekedNumberLength;
/*  900 */     } else if (i == 8 || i == 9) {
/*  901 */       this.peekedString = nextQuotedValue((i == 8) ? 39 : 34);
/*  902 */     } else if (i == 10) {
/*  903 */       this.peekedString = nextUnquotedValue();
/*  904 */     } else if (i != 11) {
/*  905 */       throw new IllegalStateException("Expected a double but was " + peek() + locationString());
/*      */     } 
/*      */     
/*  908 */     this.peeked = 11;
/*  909 */     double d = Double.parseDouble(this.peekedString);
/*  910 */     if (!this.lenient && (Double.isNaN(d) || Double.isInfinite(d))) {
/*  911 */       throw new MalformedJsonException("JSON forbids NaN and infinities: " + d + 
/*  912 */           locationString());
/*      */     }
/*  914 */     this.peekedString = null;
/*  915 */     this.peeked = 0;
/*  916 */     this.pathIndices[this.stackSize - 1] = this.pathIndices[this.stackSize - 1] + 1;
/*  917 */     return d;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long nextLong() throws IOException {
/*  931 */     int i = this.peeked;
/*  932 */     if (i == 0) {
/*  933 */       i = doPeek();
/*      */     }
/*      */     
/*  936 */     if (i == 15) {
/*  937 */       this.peeked = 0;
/*  938 */       this.pathIndices[this.stackSize - 1] = this.pathIndices[this.stackSize - 1] + 1;
/*  939 */       return this.peekedLong;
/*      */     } 
/*      */     
/*  942 */     if (i == 16) {
/*  943 */       this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
/*  944 */       this.pos += this.peekedNumberLength;
/*  945 */     } else if (i == 8 || i == 9 || i == 10) {
/*  946 */       if (i == 10) {
/*  947 */         this.peekedString = nextUnquotedValue();
/*      */       } else {
/*  949 */         this.peekedString = nextQuotedValue((i == 8) ? 39 : 34);
/*      */       } 
/*      */       try {
/*  952 */         long l1 = Long.parseLong(this.peekedString);
/*  953 */         this.peeked = 0;
/*  954 */         this.pathIndices[this.stackSize - 1] = this.pathIndices[this.stackSize - 1] + 1;
/*  955 */         return l1;
/*  956 */       } catch (NumberFormatException numberFormatException) {}
/*      */     }
/*      */     else {
/*      */       
/*  960 */       throw new IllegalStateException("Expected a long but was " + peek() + locationString());
/*      */     } 
/*      */     
/*  963 */     this.peeked = 11;
/*  964 */     double d = Double.parseDouble(this.peekedString);
/*  965 */     long l = (long)d;
/*  966 */     if (l != d) {
/*  967 */       throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
/*      */     }
/*  969 */     this.peekedString = null;
/*  970 */     this.peeked = 0;
/*  971 */     this.pathIndices[this.stackSize - 1] = this.pathIndices[this.stackSize - 1] + 1;
/*  972 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String nextQuotedValue(char paramChar) throws IOException {
/*  987 */     char[] arrayOfChar = this.buffer;
/*  988 */     StringBuilder stringBuilder = null;
/*      */     while (true) {
/*  990 */       int i = this.pos;
/*  991 */       int j = this.limit;
/*      */       
/*  993 */       int k = i;
/*  994 */       while (i < j) {
/*  995 */         char c = arrayOfChar[i++];
/*      */         
/*  997 */         if (c == paramChar) {
/*  998 */           this.pos = i;
/*  999 */           int m = i - k - 1;
/* 1000 */           if (stringBuilder == null) {
/* 1001 */             return new String(arrayOfChar, k, m);
/*      */           }
/* 1003 */           stringBuilder.append(arrayOfChar, k, m);
/* 1004 */           return stringBuilder.toString();
/*      */         } 
/* 1006 */         if (c == '\\') {
/* 1007 */           this.pos = i;
/* 1008 */           int m = i - k - 1;
/* 1009 */           if (stringBuilder == null) {
/* 1010 */             int n = (m + 1) * 2;
/* 1011 */             stringBuilder = new StringBuilder(Math.max(n, 16));
/*      */           } 
/* 1013 */           stringBuilder.append(arrayOfChar, k, m);
/* 1014 */           stringBuilder.append(readEscapeCharacter());
/* 1015 */           i = this.pos;
/* 1016 */           j = this.limit;
/* 1017 */           k = i; continue;
/* 1018 */         }  if (c == '\n') {
/* 1019 */           this.lineNumber++;
/* 1020 */           this.lineStart = i;
/*      */         } 
/*      */       } 
/*      */       
/* 1024 */       if (stringBuilder == null) {
/* 1025 */         int m = (i - k) * 2;
/* 1026 */         stringBuilder = new StringBuilder(Math.max(m, 16));
/*      */       } 
/* 1028 */       stringBuilder.append(arrayOfChar, k, i - k);
/* 1029 */       this.pos = i;
/* 1030 */       if (!fillBuffer(1)) {
/* 1031 */         throw syntaxError("Unterminated string");
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String nextUnquotedValue() throws IOException {
/* 1041 */     StringBuilder stringBuilder = null;
/* 1042 */     byte b = 0;
/*      */ 
/*      */     
/*      */     label34: while (true) {
/* 1046 */       for (; this.pos + b < this.limit; b++)
/* 1047 */       { switch (this.buffer[this.pos + b])
/*      */         { case '#':
/*      */           case '/':
/*      */           case ';':
/*      */           case '=':
/*      */           case '\\':
/* 1053 */             checkLenient(); break label34;
/*      */           case '\t': break label34;
/*      */           case '\n': break label34;
/*      */           case '\f': break label34;
/*      */           case '\r': break label34;
/*      */           case ' ': break label34;
/*      */           case ',':
/*      */             break label34;
/*      */           case ':':
/*      */             break label34;
/*      */           case '[':
/*      */             break label34;
/*      */           case ']':
/*      */             break label34;
/*      */           case '{':
/*      */             break label34;
/*      */           case '}':
/* 1070 */             break label34; }  }  if (b < this.buffer.length) {
/* 1071 */         if (fillBuffer(b + 1)) {
/*      */           continue;
/*      */         }
/*      */ 
/*      */         
/*      */         break;
/*      */       } 
/*      */       
/* 1079 */       if (stringBuilder == null) {
/* 1080 */         stringBuilder = new StringBuilder(Math.max(b, 16));
/*      */       }
/* 1082 */       stringBuilder.append(this.buffer, this.pos, b);
/* 1083 */       this.pos += b;
/* 1084 */       b = 0;
/* 1085 */       if (!fillBuffer(1)) {
/*      */         break;
/*      */       }
/*      */     } 
/*      */     
/* 1090 */     String str = (null == stringBuilder) ? new String(this.buffer, this.pos, b) : stringBuilder.append(this.buffer, this.pos, b).toString();
/* 1091 */     this.pos += b;
/* 1092 */     return str;
/*      */   }
/*      */ 
/*      */   
/*      */   private void skipQuotedValue(char paramChar) throws IOException {
/* 1097 */     char[] arrayOfChar = this.buffer;
/*      */     while (true) {
/* 1099 */       int i = this.pos;
/* 1100 */       int j = this.limit;
/*      */       
/* 1102 */       while (i < j) {
/* 1103 */         char c = arrayOfChar[i++];
/* 1104 */         if (c == paramChar) {
/* 1105 */           this.pos = i; return;
/*      */         } 
/* 1107 */         if (c == '\\') {
/* 1108 */           this.pos = i;
/* 1109 */           readEscapeCharacter();
/* 1110 */           i = this.pos;
/* 1111 */           j = this.limit; continue;
/* 1112 */         }  if (c == '\n') {
/* 1113 */           this.lineNumber++;
/* 1114 */           this.lineStart = i;
/*      */         } 
/*      */       } 
/* 1117 */       this.pos = i;
/* 1118 */       if (!fillBuffer(1))
/* 1119 */         throw syntaxError("Unterminated string"); 
/*      */     } 
/*      */   }
/*      */   private void skipUnquotedValue() throws IOException {
/*      */     do {
/* 1124 */       byte b = 0;
/* 1125 */       for (; this.pos + b < this.limit; b++) {
/* 1126 */         switch (this.buffer[this.pos + b]) {
/*      */           case '#':
/*      */           case '/':
/*      */           case ';':
/*      */           case '=':
/*      */           case '\\':
/* 1132 */             checkLenient();
/*      */           case '\t':
/*      */           case '\n':
/*      */           case '\f':
/*      */           case '\r':
/*      */           case ' ':
/*      */           case ',':
/*      */           case ':':
/*      */           case '[':
/*      */           case ']':
/*      */           case '{':
/*      */           case '}':
/* 1144 */             this.pos += b;
/*      */             return;
/*      */         } 
/*      */       } 
/* 1148 */       this.pos += b;
/* 1149 */     } while (fillBuffer(1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int nextInt() throws IOException {
/* 1163 */     int i = this.peeked;
/* 1164 */     if (i == 0) {
/* 1165 */       i = doPeek();
/*      */     }
/*      */ 
/*      */     
/* 1169 */     if (i == 15) {
/* 1170 */       int k = (int)this.peekedLong;
/* 1171 */       if (this.peekedLong != k) {
/* 1172 */         throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
/*      */       }
/* 1174 */       this.peeked = 0;
/* 1175 */       this.pathIndices[this.stackSize - 1] = this.pathIndices[this.stackSize - 1] + 1;
/* 1176 */       return k;
/*      */     } 
/*      */     
/* 1179 */     if (i == 16) {
/* 1180 */       this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
/* 1181 */       this.pos += this.peekedNumberLength;
/* 1182 */     } else if (i == 8 || i == 9 || i == 10) {
/* 1183 */       if (i == 10) {
/* 1184 */         this.peekedString = nextUnquotedValue();
/*      */       } else {
/* 1186 */         this.peekedString = nextQuotedValue((i == 8) ? 39 : 34);
/*      */       } 
/*      */       try {
/* 1189 */         int k = Integer.parseInt(this.peekedString);
/* 1190 */         this.peeked = 0;
/* 1191 */         this.pathIndices[this.stackSize - 1] = this.pathIndices[this.stackSize - 1] + 1;
/* 1192 */         return k;
/* 1193 */       } catch (NumberFormatException numberFormatException) {}
/*      */     }
/*      */     else {
/*      */       
/* 1197 */       throw new IllegalStateException("Expected an int but was " + peek() + locationString());
/*      */     } 
/*      */     
/* 1200 */     this.peeked = 11;
/* 1201 */     double d = Double.parseDouble(this.peekedString);
/* 1202 */     int j = (int)d;
/* 1203 */     if (j != d) {
/* 1204 */       throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
/*      */     }
/* 1206 */     this.peekedString = null;
/* 1207 */     this.peeked = 0;
/* 1208 */     this.pathIndices[this.stackSize - 1] = this.pathIndices[this.stackSize - 1] + 1;
/* 1209 */     return j;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void close() throws IOException {
/* 1216 */     this.peeked = 0;
/* 1217 */     this.stack[0] = 8;
/* 1218 */     this.stackSize = 1;
/* 1219 */     this.in.close();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void skipValue() throws IOException {
/* 1228 */     byte b = 0;
/*      */     do {
/* 1230 */       int i = this.peeked;
/* 1231 */       if (i == 0) {
/* 1232 */         i = doPeek();
/*      */       }
/*      */       
/* 1235 */       if (i == 3) {
/* 1236 */         push(1);
/* 1237 */         b++;
/* 1238 */       } else if (i == 1) {
/* 1239 */         push(3);
/* 1240 */         b++;
/* 1241 */       } else if (i == 4) {
/* 1242 */         this.stackSize--;
/* 1243 */         b--;
/* 1244 */       } else if (i == 2) {
/* 1245 */         this.stackSize--;
/* 1246 */         b--;
/* 1247 */       } else if (i == 14 || i == 10) {
/* 1248 */         skipUnquotedValue();
/* 1249 */       } else if (i == 8 || i == 12) {
/* 1250 */         skipQuotedValue('\'');
/* 1251 */       } else if (i == 9 || i == 13) {
/* 1252 */         skipQuotedValue('"');
/* 1253 */       } else if (i == 16) {
/* 1254 */         this.pos += this.peekedNumberLength;
/*      */       } 
/* 1256 */       this.peeked = 0;
/* 1257 */     } while (b != 0);
/*      */     
/* 1259 */     this.pathIndices[this.stackSize - 1] = this.pathIndices[this.stackSize - 1] + 1;
/* 1260 */     this.pathNames[this.stackSize - 1] = "null";
/*      */   }
/*      */   
/*      */   private void push(int paramInt) {
/* 1264 */     if (this.stackSize == this.stack.length) {
/* 1265 */       int[] arrayOfInt1 = new int[this.stackSize * 2];
/* 1266 */       int[] arrayOfInt2 = new int[this.stackSize * 2];
/* 1267 */       String[] arrayOfString = new String[this.stackSize * 2];
/* 1268 */       System.arraycopy(this.stack, 0, arrayOfInt1, 0, this.stackSize);
/* 1269 */       System.arraycopy(this.pathIndices, 0, arrayOfInt2, 0, this.stackSize);
/* 1270 */       System.arraycopy(this.pathNames, 0, arrayOfString, 0, this.stackSize);
/* 1271 */       this.stack = arrayOfInt1;
/* 1272 */       this.pathIndices = arrayOfInt2;
/* 1273 */       this.pathNames = arrayOfString;
/*      */     } 
/* 1275 */     this.stack[this.stackSize++] = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean fillBuffer(int paramInt) throws IOException {
/* 1284 */     char[] arrayOfChar = this.buffer;
/* 1285 */     this.lineStart -= this.pos;
/* 1286 */     if (this.limit != this.pos) {
/* 1287 */       this.limit -= this.pos;
/* 1288 */       System.arraycopy(arrayOfChar, this.pos, arrayOfChar, 0, this.limit);
/*      */     } else {
/* 1290 */       this.limit = 0;
/*      */     } 
/*      */     
/* 1293 */     this.pos = 0;
/*      */     int i;
/* 1295 */     while ((i = this.in.read(arrayOfChar, this.limit, arrayOfChar.length - this.limit)) != -1) {
/* 1296 */       this.limit += i;
/*      */ 
/*      */       
/* 1299 */       if (this.lineNumber == 0 && this.lineStart == 0 && this.limit > 0 && arrayOfChar[0] == '﻿') {
/* 1300 */         this.pos++;
/* 1301 */         this.lineStart++;
/* 1302 */         paramInt++;
/*      */       } 
/*      */       
/* 1305 */       if (this.limit >= paramInt) {
/* 1306 */         return true;
/*      */       }
/*      */     } 
/* 1309 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int nextNonWhitespace(boolean paramBoolean) throws IOException {
/* 1327 */     char[] arrayOfChar = this.buffer;
/* 1328 */     int i = this.pos;
/* 1329 */     int j = this.limit;
/*      */     while (true) {
/* 1331 */       if (i == j) {
/* 1332 */         this.pos = i;
/* 1333 */         if (!fillBuffer(1)) {
/*      */           break;
/*      */         }
/* 1336 */         i = this.pos;
/* 1337 */         j = this.limit;
/*      */       } 
/*      */       
/* 1340 */       char c = arrayOfChar[i++];
/* 1341 */       if (c == '\n') {
/* 1342 */         this.lineNumber++;
/* 1343 */         this.lineStart = i; continue;
/*      */       } 
/* 1345 */       if (c == ' ' || c == '\r' || c == '\t') {
/*      */         continue;
/*      */       }
/*      */       
/* 1349 */       if (c == '/') {
/* 1350 */         this.pos = i;
/* 1351 */         if (i == j) {
/* 1352 */           this.pos--;
/* 1353 */           boolean bool = fillBuffer(2);
/* 1354 */           this.pos++;
/* 1355 */           if (!bool) {
/* 1356 */             return c;
/*      */           }
/*      */         } 
/*      */         
/* 1360 */         checkLenient();
/* 1361 */         char c1 = arrayOfChar[this.pos];
/* 1362 */         switch (c1) {
/*      */           
/*      */           case '*':
/* 1365 */             this.pos++;
/* 1366 */             if (!skipTo("*/")) {
/* 1367 */               throw syntaxError("Unterminated comment");
/*      */             }
/* 1369 */             i = this.pos + 2;
/* 1370 */             j = this.limit;
/*      */             continue;
/*      */ 
/*      */           
/*      */           case '/':
/* 1375 */             this.pos++;
/* 1376 */             skipToEndOfLine();
/* 1377 */             i = this.pos;
/* 1378 */             j = this.limit;
/*      */             continue;
/*      */         } 
/*      */         
/* 1382 */         return c;
/*      */       } 
/* 1384 */       if (c == '#') {
/* 1385 */         this.pos = i;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1391 */         checkLenient();
/* 1392 */         skipToEndOfLine();
/* 1393 */         i = this.pos;
/* 1394 */         j = this.limit; continue;
/*      */       } 
/* 1396 */       this.pos = i;
/* 1397 */       return c;
/*      */     } 
/*      */     
/* 1400 */     if (paramBoolean) {
/* 1401 */       throw new EOFException("End of input" + locationString());
/*      */     }
/* 1403 */     return -1;
/*      */   }
/*      */ 
/*      */   
/*      */   private void checkLenient() throws IOException {
/* 1408 */     if (!this.lenient) {
/* 1409 */       throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void skipToEndOfLine() throws IOException {
/* 1419 */     while (this.pos < this.limit || fillBuffer(1)) {
/* 1420 */       char c = this.buffer[this.pos++];
/* 1421 */       if (c == '\n') {
/* 1422 */         this.lineNumber++;
/* 1423 */         this.lineStart = this.pos; break;
/*      */       } 
/* 1425 */       if (c == '\r') {
/*      */         break;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean skipTo(String paramString) throws IOException {
/* 1435 */     int i = paramString.length();
/*      */     
/* 1437 */     for (; this.pos + i <= this.limit || fillBuffer(i); this.pos++) {
/* 1438 */       if (this.buffer[this.pos] == '\n') {
/* 1439 */         this.lineNumber++;
/* 1440 */         this.lineStart = this.pos + 1;
/*      */       } else {
/*      */         
/* 1443 */         byte b = 0; while (true) { if (b < i) {
/* 1444 */             if (this.buffer[this.pos + b] != paramString.charAt(b))
/*      */               break;  b++;
/*      */             continue;
/*      */           } 
/* 1448 */           return true; } 
/*      */       } 
/* 1450 */     }  return false;
/*      */   }
/*      */   
/*      */   public String toString() {
/* 1454 */     return getClass().getSimpleName() + locationString();
/*      */   }
/*      */   
/*      */   String locationString() {
/* 1458 */     int i = this.lineNumber + 1;
/* 1459 */     int j = this.pos - this.lineStart + 1;
/* 1460 */     return " at line " + i + " column " + j + " path " + getPath();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPath() {
/* 1468 */     StringBuilder stringBuilder = (new StringBuilder()).append('$'); byte b; int i;
/* 1469 */     for (b = 0, i = this.stackSize; b < i; b++) {
/* 1470 */       switch (this.stack[b]) {
/*      */         case 1:
/*      */         case 2:
/* 1473 */           stringBuilder.append('[').append(this.pathIndices[b]).append(']');
/*      */           break;
/*      */         
/*      */         case 3:
/*      */         case 4:
/*      */         case 5:
/* 1479 */           stringBuilder.append('.');
/* 1480 */           if (this.pathNames[b] != null) {
/* 1481 */             stringBuilder.append(this.pathNames[b]);
/*      */           }
/*      */           break;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     } 
/* 1491 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private char readEscapeCharacter() throws IOException {
/*      */     char c1;
/*      */     int i, j;
/* 1504 */     if (this.pos == this.limit && !fillBuffer(1)) {
/* 1505 */       throw syntaxError("Unterminated escape sequence");
/*      */     }
/*      */     
/* 1508 */     char c = this.buffer[this.pos++];
/* 1509 */     switch (c) {
/*      */       case 'u':
/* 1511 */         if (this.pos + 4 > this.limit && !fillBuffer(4)) {
/* 1512 */           throw syntaxError("Unterminated escape sequence");
/*      */         }
/*      */         
/* 1515 */         c1 = Character.MIN_VALUE;
/* 1516 */         for (i = this.pos, j = i + 4; i < j; i++) {
/* 1517 */           char c2 = this.buffer[i];
/* 1518 */           c1 = (char)(c1 << 4);
/* 1519 */           if (c2 >= '0' && c2 <= '9') {
/* 1520 */             c1 = (char)(c1 + c2 - 48);
/* 1521 */           } else if (c2 >= 'a' && c2 <= 'f') {
/* 1522 */             c1 = (char)(c1 + c2 - 97 + 10);
/* 1523 */           } else if (c2 >= 'A' && c2 <= 'F') {
/* 1524 */             c1 = (char)(c1 + c2 - 65 + 10);
/*      */           } else {
/* 1526 */             throw new NumberFormatException("\\u" + new String(this.buffer, this.pos, 4));
/*      */           } 
/*      */         } 
/* 1529 */         this.pos += 4;
/* 1530 */         return c1;
/*      */       
/*      */       case 't':
/* 1533 */         return '\t';
/*      */       
/*      */       case 'b':
/* 1536 */         return '\b';
/*      */       
/*      */       case 'n':
/* 1539 */         return '\n';
/*      */       
/*      */       case 'r':
/* 1542 */         return '\r';
/*      */       
/*      */       case 'f':
/* 1545 */         return '\f';
/*      */       
/*      */       case '\n':
/* 1548 */         this.lineNumber++;
/* 1549 */         this.lineStart = this.pos;
/*      */ 
/*      */       
/*      */       case '"':
/*      */       case '\'':
/*      */       case '/':
/*      */       case '\\':
/* 1556 */         return c;
/*      */     } 
/*      */     
/* 1559 */     throw syntaxError("Invalid escape sequence");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private IOException syntaxError(String paramString) throws IOException {
/* 1568 */     throw new MalformedJsonException(paramString + locationString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void consumeNonExecutePrefix() throws IOException {
/* 1576 */     nextNonWhitespace(true);
/* 1577 */     this.pos--;
/*      */     
/* 1579 */     if (this.pos + NON_EXECUTE_PREFIX.length > this.limit && !fillBuffer(NON_EXECUTE_PREFIX.length)) {
/*      */       return;
/*      */     }
/*      */     
/* 1583 */     for (byte b = 0; b < NON_EXECUTE_PREFIX.length; b++) {
/* 1584 */       if (this.buffer[this.pos + b] != NON_EXECUTE_PREFIX[b]) {
/*      */         return;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1590 */     this.pos += NON_EXECUTE_PREFIX.length;
/*      */   }
/*      */   
/*      */   static {
/* 1594 */     JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() {
/*      */         public void promoteNameToValue(JsonReader param1JsonReader) throws IOException {
/* 1596 */           if (param1JsonReader instanceof JsonTreeReader) {
/* 1597 */             ((JsonTreeReader)param1JsonReader).promoteNameToValue();
/*      */             return;
/*      */           } 
/* 1600 */           int i = param1JsonReader.peeked;
/* 1601 */           if (i == 0) {
/* 1602 */             i = param1JsonReader.doPeek();
/*      */           }
/* 1604 */           if (i == 13) {
/* 1605 */             param1JsonReader.peeked = 9;
/* 1606 */           } else if (i == 12) {
/* 1607 */             param1JsonReader.peeked = 8;
/* 1608 */           } else if (i == 14) {
/* 1609 */             param1JsonReader.peeked = 10;
/*      */           } else {
/* 1611 */             throw new IllegalStateException("Expected a name but was " + param1JsonReader
/* 1612 */                 .peek() + param1JsonReader.locationString());
/*      */           } 
/*      */         }
/*      */       };
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\stream\JsonReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */