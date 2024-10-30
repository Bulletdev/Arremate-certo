/*      */ package org.apache.commons.text;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.List;
/*      */ import java.util.ListIterator;
/*      */ import java.util.NoSuchElementException;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */ public class StrTokenizer
/*      */   implements Cloneable, ListIterator<String>
/*      */ {
/*   93 */   private static final StrTokenizer CSV_TOKENIZER_PROTOTYPE = new StrTokenizer(); static {
/*   94 */     CSV_TOKENIZER_PROTOTYPE.setDelimiterMatcher(StrMatcher.commaMatcher());
/*   95 */     CSV_TOKENIZER_PROTOTYPE.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
/*   96 */     CSV_TOKENIZER_PROTOTYPE.setIgnoredMatcher(StrMatcher.noneMatcher());
/*   97 */     CSV_TOKENIZER_PROTOTYPE.setTrimmerMatcher(StrMatcher.trimMatcher());
/*   98 */     CSV_TOKENIZER_PROTOTYPE.setEmptyTokenAsNull(false);
/*   99 */     CSV_TOKENIZER_PROTOTYPE.setIgnoreEmptyTokens(false);
/*      */   }
/*  101 */   private static final StrTokenizer TSV_TOKENIZER_PROTOTYPE = new StrTokenizer(); static {
/*  102 */     TSV_TOKENIZER_PROTOTYPE.setDelimiterMatcher(StrMatcher.tabMatcher());
/*  103 */     TSV_TOKENIZER_PROTOTYPE.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
/*  104 */     TSV_TOKENIZER_PROTOTYPE.setIgnoredMatcher(StrMatcher.noneMatcher());
/*  105 */     TSV_TOKENIZER_PROTOTYPE.setTrimmerMatcher(StrMatcher.trimMatcher());
/*  106 */     TSV_TOKENIZER_PROTOTYPE.setEmptyTokenAsNull(false);
/*  107 */     TSV_TOKENIZER_PROTOTYPE.setIgnoreEmptyTokens(false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private char[] chars;
/*      */   
/*      */   private String[] tokens;
/*      */   
/*      */   private int tokenPos;
/*      */   
/*  118 */   private StrMatcher delimMatcher = StrMatcher.splitMatcher();
/*      */   
/*  120 */   private StrMatcher quoteMatcher = StrMatcher.noneMatcher();
/*      */   
/*  122 */   private StrMatcher ignoredMatcher = StrMatcher.noneMatcher();
/*      */   
/*  124 */   private StrMatcher trimmerMatcher = StrMatcher.noneMatcher();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean emptyAsNull = false;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean ignoreEmptyTokens = true;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static StrTokenizer getCSVClone() {
/*  139 */     return (StrTokenizer)CSV_TOKENIZER_PROTOTYPE.clone();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static StrTokenizer getCSVInstance() {
/*  152 */     return getCSVClone();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static StrTokenizer getCSVInstance(String paramString) {
/*  165 */     StrTokenizer strTokenizer = getCSVClone();
/*  166 */     strTokenizer.reset(paramString);
/*  167 */     return strTokenizer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static StrTokenizer getCSVInstance(char[] paramArrayOfchar) {
/*  180 */     StrTokenizer strTokenizer = getCSVClone();
/*  181 */     strTokenizer.reset(paramArrayOfchar);
/*  182 */     return strTokenizer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static StrTokenizer getTSVClone() {
/*  191 */     return (StrTokenizer)TSV_TOKENIZER_PROTOTYPE.clone();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static StrTokenizer getTSVInstance() {
/*  204 */     return getTSVClone();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static StrTokenizer getTSVInstance(String paramString) {
/*  215 */     StrTokenizer strTokenizer = getTSVClone();
/*  216 */     strTokenizer.reset(paramString);
/*  217 */     return strTokenizer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static StrTokenizer getTSVInstance(char[] paramArrayOfchar) {
/*  228 */     StrTokenizer strTokenizer = getTSVClone();
/*  229 */     strTokenizer.reset(paramArrayOfchar);
/*  230 */     return strTokenizer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer() {
/*  242 */     this.chars = null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(String paramString) {
/*  253 */     if (paramString != null) {
/*  254 */       this.chars = paramString.toCharArray();
/*      */     } else {
/*  256 */       this.chars = null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(String paramString, char paramChar) {
/*  267 */     this(paramString);
/*  268 */     setDelimiterChar(paramChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(String paramString1, String paramString2) {
/*  278 */     this(paramString1);
/*  279 */     setDelimiterString(paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(String paramString, StrMatcher paramStrMatcher) {
/*  289 */     this(paramString);
/*  290 */     setDelimiterMatcher(paramStrMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(String paramString, char paramChar1, char paramChar2) {
/*  302 */     this(paramString, paramChar1);
/*  303 */     setQuoteChar(paramChar2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(String paramString, StrMatcher paramStrMatcher1, StrMatcher paramStrMatcher2) {
/*  315 */     this(paramString, paramStrMatcher1);
/*  316 */     setQuoteMatcher(paramStrMatcher2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(char[] paramArrayOfchar) {
/*  327 */     if (paramArrayOfchar == null) {
/*  328 */       this.chars = null;
/*      */     } else {
/*  330 */       this.chars = (char[])paramArrayOfchar.clone();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(char[] paramArrayOfchar, char paramChar) {
/*  341 */     this(paramArrayOfchar);
/*  342 */     setDelimiterChar(paramChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(char[] paramArrayOfchar, String paramString) {
/*  352 */     this(paramArrayOfchar);
/*  353 */     setDelimiterString(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(char[] paramArrayOfchar, StrMatcher paramStrMatcher) {
/*  363 */     this(paramArrayOfchar);
/*  364 */     setDelimiterMatcher(paramStrMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(char[] paramArrayOfchar, char paramChar1, char paramChar2) {
/*  376 */     this(paramArrayOfchar, paramChar1);
/*  377 */     setQuoteChar(paramChar2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(char[] paramArrayOfchar, StrMatcher paramStrMatcher1, StrMatcher paramStrMatcher2) {
/*  389 */     this(paramArrayOfchar, paramStrMatcher1);
/*  390 */     setQuoteMatcher(paramStrMatcher2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int size() {
/*  401 */     checkTokenized();
/*  402 */     return this.tokens.length;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String nextToken() {
/*  413 */     if (hasNext()) {
/*  414 */       return this.tokens[this.tokenPos++];
/*      */     }
/*  416 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String previousToken() {
/*  425 */     if (hasPrevious()) {
/*  426 */       return this.tokens[--this.tokenPos];
/*      */     }
/*  428 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] getTokenArray() {
/*  437 */     checkTokenized();
/*  438 */     return (String[])this.tokens.clone();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<String> getTokenList() {
/*  447 */     checkTokenized();
/*  448 */     ArrayList<? super String> arrayList = new ArrayList(this.tokens.length);
/*  449 */     Collections.addAll(arrayList, this.tokens);
/*      */     
/*  451 */     return (List)arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer reset() {
/*  462 */     this.tokenPos = 0;
/*  463 */     this.tokens = null;
/*  464 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer reset(String paramString) {
/*  476 */     reset();
/*  477 */     if (paramString != null) {
/*  478 */       this.chars = paramString.toCharArray();
/*      */     } else {
/*  480 */       this.chars = null;
/*      */     } 
/*  482 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer reset(char[] paramArrayOfchar) {
/*  494 */     reset();
/*  495 */     if (paramArrayOfchar != null) {
/*  496 */       this.chars = (char[])paramArrayOfchar.clone();
/*      */     } else {
/*  498 */       this.chars = null;
/*      */     } 
/*  500 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasNext() {
/*  512 */     checkTokenized();
/*  513 */     return (this.tokenPos < this.tokens.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String next() {
/*  524 */     if (hasNext()) {
/*  525 */       return this.tokens[this.tokenPos++];
/*      */     }
/*  527 */     throw new NoSuchElementException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int nextIndex() {
/*  537 */     return this.tokenPos;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasPrevious() {
/*  547 */     checkTokenized();
/*  548 */     return (this.tokenPos > 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String previous() {
/*  558 */     if (hasPrevious()) {
/*  559 */       return this.tokens[--this.tokenPos];
/*      */     }
/*  561 */     throw new NoSuchElementException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int previousIndex() {
/*  571 */     return this.tokenPos - 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void remove() {
/*  581 */     throw new UnsupportedOperationException("remove() is unsupported");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void set(String paramString) {
/*  591 */     throw new UnsupportedOperationException("set() is unsupported");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void add(String paramString) {
/*  601 */     throw new UnsupportedOperationException("add() is unsupported");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void checkTokenized() {
/*  610 */     if (this.tokens == null) {
/*  611 */       if (this.chars == null) {
/*      */         
/*  613 */         List<String> list = tokenize(null, 0, 0);
/*  614 */         this.tokens = list.<String>toArray(new String[list.size()]);
/*      */       } else {
/*  616 */         List<String> list = tokenize(this.chars, 0, this.chars.length);
/*  617 */         this.tokens = list.<String>toArray(new String[list.size()]);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected List<String> tokenize(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  643 */     if (paramArrayOfchar == null || paramInt2 == 0) {
/*  644 */       return Collections.emptyList();
/*      */     }
/*  646 */     StrBuilder strBuilder = new StrBuilder();
/*  647 */     ArrayList<String> arrayList = new ArrayList();
/*  648 */     int i = paramInt1;
/*      */ 
/*      */     
/*  651 */     while (i >= 0 && i < paramInt2) {
/*      */       
/*  653 */       i = readNextToken(paramArrayOfchar, i, paramInt2, strBuilder, arrayList);
/*      */ 
/*      */       
/*  656 */       if (i >= paramInt2) {
/*  657 */         addToken(arrayList, "");
/*      */       }
/*      */     } 
/*  660 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void addToken(List<String> paramList, String paramString) {
/*  670 */     if (paramString == null || paramString.length() == 0) {
/*  671 */       if (isIgnoreEmptyTokens()) {
/*      */         return;
/*      */       }
/*  674 */       if (isEmptyTokenAsNull()) {
/*  675 */         paramString = null;
/*      */       }
/*      */     } 
/*  678 */     paramList.add(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int readNextToken(char[] paramArrayOfchar, int paramInt1, int paramInt2, StrBuilder paramStrBuilder, List<String> paramList) {
/*  699 */     while (paramInt1 < paramInt2) {
/*  700 */       int k = Math.max(
/*  701 */           getIgnoredMatcher().isMatch(paramArrayOfchar, paramInt1, paramInt1, paramInt2), 
/*  702 */           getTrimmerMatcher().isMatch(paramArrayOfchar, paramInt1, paramInt1, paramInt2));
/*  703 */       if (k == 0 || 
/*  704 */         getDelimiterMatcher().isMatch(paramArrayOfchar, paramInt1, paramInt1, paramInt2) > 0 || 
/*  705 */         getQuoteMatcher().isMatch(paramArrayOfchar, paramInt1, paramInt1, paramInt2) > 0) {
/*      */         break;
/*      */       }
/*  708 */       paramInt1 += k;
/*      */     } 
/*      */ 
/*      */     
/*  712 */     if (paramInt1 >= paramInt2) {
/*  713 */       addToken(paramList, "");
/*  714 */       return -1;
/*      */     } 
/*      */ 
/*      */     
/*  718 */     int i = getDelimiterMatcher().isMatch(paramArrayOfchar, paramInt1, paramInt1, paramInt2);
/*  719 */     if (i > 0) {
/*  720 */       addToken(paramList, "");
/*  721 */       return paramInt1 + i;
/*      */     } 
/*      */ 
/*      */     
/*  725 */     int j = getQuoteMatcher().isMatch(paramArrayOfchar, paramInt1, paramInt1, paramInt2);
/*  726 */     if (j > 0) {
/*  727 */       return readWithQuotes(paramArrayOfchar, paramInt1 + j, paramInt2, paramStrBuilder, paramList, paramInt1, j);
/*      */     }
/*  729 */     return readWithQuotes(paramArrayOfchar, paramInt1, paramInt2, paramStrBuilder, paramList, 0, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int readWithQuotes(char[] paramArrayOfchar, int paramInt1, int paramInt2, StrBuilder paramStrBuilder, List<String> paramList, int paramInt3, int paramInt4) {
/*  750 */     paramStrBuilder.clear();
/*  751 */     int i = paramInt1;
/*  752 */     boolean bool = (paramInt4 > 0) ? true : false;
/*  753 */     int j = 0;
/*      */     
/*  755 */     while (i < paramInt2) {
/*      */ 
/*      */ 
/*      */       
/*  759 */       if (bool) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  766 */         if (isQuote(paramArrayOfchar, i, paramInt2, paramInt3, paramInt4)) {
/*  767 */           if (isQuote(paramArrayOfchar, i + paramInt4, paramInt2, paramInt3, paramInt4)) {
/*      */             
/*  769 */             paramStrBuilder.append(paramArrayOfchar, i, paramInt4);
/*  770 */             i += paramInt4 * 2;
/*  771 */             j = paramStrBuilder.size();
/*      */             
/*      */             continue;
/*      */           } 
/*      */           
/*  776 */           bool = false;
/*  777 */           i += paramInt4;
/*      */           
/*      */           continue;
/*      */         } 
/*      */         
/*  782 */         paramStrBuilder.append(paramArrayOfchar[i++]);
/*  783 */         j = paramStrBuilder.size();
/*      */ 
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  789 */       int k = getDelimiterMatcher().isMatch(paramArrayOfchar, i, paramInt1, paramInt2);
/*  790 */       if (k > 0) {
/*      */         
/*  792 */         addToken(paramList, paramStrBuilder.substring(0, j));
/*  793 */         return i + k;
/*      */       } 
/*      */ 
/*      */       
/*  797 */       if (paramInt4 > 0 && isQuote(paramArrayOfchar, i, paramInt2, paramInt3, paramInt4)) {
/*  798 */         bool = true;
/*  799 */         i += paramInt4;
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  804 */       int m = getIgnoredMatcher().isMatch(paramArrayOfchar, i, paramInt1, paramInt2);
/*  805 */       if (m > 0) {
/*  806 */         i += m;
/*      */ 
/*      */         
/*      */         continue;
/*      */       } 
/*      */ 
/*      */       
/*  813 */       int n = getTrimmerMatcher().isMatch(paramArrayOfchar, i, paramInt1, paramInt2);
/*  814 */       if (n > 0) {
/*  815 */         paramStrBuilder.append(paramArrayOfchar, i, n);
/*  816 */         i += n;
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  821 */       paramStrBuilder.append(paramArrayOfchar[i++]);
/*  822 */       j = paramStrBuilder.size();
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  827 */     addToken(paramList, paramStrBuilder.substring(0, j));
/*  828 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isQuote(char[] paramArrayOfchar, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  847 */     for (byte b = 0; b < paramInt4; b++) {
/*  848 */       if (paramInt1 + b >= paramInt2 || paramArrayOfchar[paramInt1 + b] != paramArrayOfchar[paramInt3 + b]) {
/*  849 */         return false;
/*      */       }
/*      */     } 
/*  852 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrMatcher getDelimiterMatcher() {
/*  863 */     return this.delimMatcher;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer setDelimiterMatcher(StrMatcher paramStrMatcher) {
/*  875 */     if (paramStrMatcher == null) {
/*  876 */       this.delimMatcher = StrMatcher.noneMatcher();
/*      */     } else {
/*  878 */       this.delimMatcher = paramStrMatcher;
/*      */     } 
/*  880 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer setDelimiterChar(char paramChar) {
/*  890 */     return setDelimiterMatcher(StrMatcher.charMatcher(paramChar));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer setDelimiterString(String paramString) {
/*  900 */     return setDelimiterMatcher(StrMatcher.stringMatcher(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrMatcher getQuoteMatcher() {
/*  915 */     return this.quoteMatcher;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer setQuoteMatcher(StrMatcher paramStrMatcher) {
/*  928 */     if (paramStrMatcher != null) {
/*  929 */       this.quoteMatcher = paramStrMatcher;
/*      */     }
/*  931 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer setQuoteChar(char paramChar) {
/*  944 */     return setQuoteMatcher(StrMatcher.charMatcher(paramChar));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrMatcher getIgnoredMatcher() {
/*  959 */     return this.ignoredMatcher;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer setIgnoredMatcher(StrMatcher paramStrMatcher) {
/*  972 */     if (paramStrMatcher != null) {
/*  973 */       this.ignoredMatcher = paramStrMatcher;
/*      */     }
/*  975 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer setIgnoredChar(char paramChar) {
/*  988 */     return setIgnoredMatcher(StrMatcher.charMatcher(paramChar));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrMatcher getTrimmerMatcher() {
/* 1003 */     return this.trimmerMatcher;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer setTrimmerMatcher(StrMatcher paramStrMatcher) {
/* 1016 */     if (paramStrMatcher != null) {
/* 1017 */       this.trimmerMatcher = paramStrMatcher;
/*      */     }
/* 1019 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmptyTokenAsNull() {
/* 1030 */     return this.emptyAsNull;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer setEmptyTokenAsNull(boolean paramBoolean) {
/* 1041 */     this.emptyAsNull = paramBoolean;
/* 1042 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isIgnoreEmptyTokens() {
/* 1053 */     return this.ignoreEmptyTokens;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer setIgnoreEmptyTokens(boolean paramBoolean) {
/* 1064 */     this.ignoreEmptyTokens = paramBoolean;
/* 1065 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getContent() {
/* 1075 */     if (this.chars == null) {
/* 1076 */       return null;
/*      */     }
/* 1078 */     return new String(this.chars);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object clone() {
/*      */     try {
/* 1092 */       return cloneReset();
/* 1093 */     } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 1094 */       return null;
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
/*      */   Object cloneReset() throws CloneNotSupportedException {
/* 1107 */     StrTokenizer strTokenizer = (StrTokenizer)super.clone();
/* 1108 */     if (strTokenizer.chars != null) {
/* 1109 */       strTokenizer.chars = (char[])strTokenizer.chars.clone();
/*      */     }
/* 1111 */     strTokenizer.reset();
/* 1112 */     return strTokenizer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1123 */     if (this.tokens == null) {
/* 1124 */       return "StrTokenizer[not tokenized yet]";
/*      */     }
/* 1126 */     return "StrTokenizer" + getTokenList();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\StrTokenizer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */