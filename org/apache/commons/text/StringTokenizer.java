/*      */ package org.apache.commons.text;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.List;
/*      */ import java.util.ListIterator;
/*      */ import java.util.NoSuchElementException;
/*      */ import org.apache.commons.text.matcher.StringMatcher;
/*      */ import org.apache.commons.text.matcher.StringMatcherFactory;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class StringTokenizer
/*      */   implements Cloneable, ListIterator<String>
/*      */ {
/*   99 */   private static final StringTokenizer CSV_TOKENIZER_PROTOTYPE = new StringTokenizer(); static {
/*  100 */     CSV_TOKENIZER_PROTOTYPE.setDelimiterMatcher(StringMatcherFactory.INSTANCE.commaMatcher());
/*  101 */     CSV_TOKENIZER_PROTOTYPE.setQuoteMatcher(StringMatcherFactory.INSTANCE.doubleQuoteMatcher());
/*  102 */     CSV_TOKENIZER_PROTOTYPE.setIgnoredMatcher(StringMatcherFactory.INSTANCE.noneMatcher());
/*  103 */     CSV_TOKENIZER_PROTOTYPE.setTrimmerMatcher(StringMatcherFactory.INSTANCE.trimMatcher());
/*  104 */     CSV_TOKENIZER_PROTOTYPE.setEmptyTokenAsNull(false);
/*  105 */     CSV_TOKENIZER_PROTOTYPE.setIgnoreEmptyTokens(false);
/*      */   }
/*  107 */   private static final StringTokenizer TSV_TOKENIZER_PROTOTYPE = new StringTokenizer(); static {
/*  108 */     TSV_TOKENIZER_PROTOTYPE.setDelimiterMatcher(StringMatcherFactory.INSTANCE.tabMatcher());
/*  109 */     TSV_TOKENIZER_PROTOTYPE.setQuoteMatcher(StringMatcherFactory.INSTANCE.doubleQuoteMatcher());
/*  110 */     TSV_TOKENIZER_PROTOTYPE.setIgnoredMatcher(StringMatcherFactory.INSTANCE.noneMatcher());
/*  111 */     TSV_TOKENIZER_PROTOTYPE.setTrimmerMatcher(StringMatcherFactory.INSTANCE.trimMatcher());
/*  112 */     TSV_TOKENIZER_PROTOTYPE.setEmptyTokenAsNull(false);
/*  113 */     TSV_TOKENIZER_PROTOTYPE.setIgnoreEmptyTokens(false);
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
/*  124 */   private StringMatcher delimMatcher = StringMatcherFactory.INSTANCE.splitMatcher();
/*      */   
/*  126 */   private StringMatcher quoteMatcher = StringMatcherFactory.INSTANCE.noneMatcher();
/*      */   
/*  128 */   private StringMatcher ignoredMatcher = StringMatcherFactory.INSTANCE.noneMatcher();
/*      */   
/*  130 */   private StringMatcher trimmerMatcher = StringMatcherFactory.INSTANCE.noneMatcher();
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
/*      */   private static StringTokenizer getCSVClone() {
/*  145 */     return (StringTokenizer)CSV_TOKENIZER_PROTOTYPE.clone();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static StringTokenizer getCSVInstance() {
/*  158 */     return getCSVClone();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static StringTokenizer getCSVInstance(String paramString) {
/*  171 */     StringTokenizer stringTokenizer = getCSVClone();
/*  172 */     stringTokenizer.reset(paramString);
/*  173 */     return stringTokenizer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static StringTokenizer getCSVInstance(char[] paramArrayOfchar) {
/*  186 */     StringTokenizer stringTokenizer = getCSVClone();
/*  187 */     stringTokenizer.reset(paramArrayOfchar);
/*  188 */     return stringTokenizer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static StringTokenizer getTSVClone() {
/*  197 */     return (StringTokenizer)TSV_TOKENIZER_PROTOTYPE.clone();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static StringTokenizer getTSVInstance() {
/*  209 */     return getTSVClone();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static StringTokenizer getTSVInstance(String paramString) {
/*  221 */     StringTokenizer stringTokenizer = getTSVClone();
/*  222 */     stringTokenizer.reset(paramString);
/*  223 */     return stringTokenizer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static StringTokenizer getTSVInstance(char[] paramArrayOfchar) {
/*  235 */     StringTokenizer stringTokenizer = getTSVClone();
/*  236 */     stringTokenizer.reset(paramArrayOfchar);
/*  237 */     return stringTokenizer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringTokenizer() {
/*  249 */     this.chars = null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringTokenizer(String paramString) {
/*  260 */     if (paramString != null) {
/*  261 */       this.chars = paramString.toCharArray();
/*      */     } else {
/*  263 */       this.chars = null;
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
/*      */   public StringTokenizer(String paramString, char paramChar) {
/*  276 */     this(paramString);
/*  277 */     setDelimiterChar(paramChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringTokenizer(String paramString1, String paramString2) {
/*  289 */     this(paramString1);
/*  290 */     setDelimiterString(paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringTokenizer(String paramString, StringMatcher paramStringMatcher) {
/*  302 */     this(paramString);
/*  303 */     setDelimiterMatcher(paramStringMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringTokenizer(String paramString, char paramChar1, char paramChar2) {
/*  318 */     this(paramString, paramChar1);
/*  319 */     setQuoteChar(paramChar2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringTokenizer(String paramString, StringMatcher paramStringMatcher1, StringMatcher paramStringMatcher2) {
/*  334 */     this(paramString, paramStringMatcher1);
/*  335 */     setQuoteMatcher(paramStringMatcher2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringTokenizer(char[] paramArrayOfchar) {
/*  346 */     if (paramArrayOfchar == null) {
/*  347 */       this.chars = null;
/*      */     } else {
/*  349 */       this.chars = (char[])paramArrayOfchar.clone();
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
/*      */   public StringTokenizer(char[] paramArrayOfchar, char paramChar) {
/*  362 */     this(paramArrayOfchar);
/*  363 */     setDelimiterChar(paramChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringTokenizer(char[] paramArrayOfchar, String paramString) {
/*  375 */     this(paramArrayOfchar);
/*  376 */     setDelimiterString(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringTokenizer(char[] paramArrayOfchar, StringMatcher paramStringMatcher) {
/*  388 */     this(paramArrayOfchar);
/*  389 */     setDelimiterMatcher(paramStringMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringTokenizer(char[] paramArrayOfchar, char paramChar1, char paramChar2) {
/*  404 */     this(paramArrayOfchar, paramChar1);
/*  405 */     setQuoteChar(paramChar2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringTokenizer(char[] paramArrayOfchar, StringMatcher paramStringMatcher1, StringMatcher paramStringMatcher2) {
/*  420 */     this(paramArrayOfchar, paramStringMatcher1);
/*  421 */     setQuoteMatcher(paramStringMatcher2);
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
/*  432 */     checkTokenized();
/*  433 */     return this.tokens.length;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String nextToken() {
/*  443 */     if (hasNext()) {
/*  444 */       return this.tokens[this.tokenPos++];
/*      */     }
/*  446 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String previousToken() {
/*  455 */     if (hasPrevious()) {
/*  456 */       return this.tokens[--this.tokenPos];
/*      */     }
/*  458 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] getTokenArray() {
/*  467 */     checkTokenized();
/*  468 */     return (String[])this.tokens.clone();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<String> getTokenList() {
/*  477 */     checkTokenized();
/*  478 */     ArrayList<? super String> arrayList = new ArrayList(this.tokens.length);
/*  479 */     Collections.addAll(arrayList, this.tokens);
/*      */     
/*  481 */     return (List)arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringTokenizer reset() {
/*  492 */     this.tokenPos = 0;
/*  493 */     this.tokens = null;
/*  494 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringTokenizer reset(String paramString) {
/*  506 */     reset();
/*  507 */     if (paramString != null) {
/*  508 */       this.chars = paramString.toCharArray();
/*      */     } else {
/*  510 */       this.chars = null;
/*      */     } 
/*  512 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringTokenizer reset(char[] paramArrayOfchar) {
/*  524 */     reset();
/*  525 */     if (paramArrayOfchar != null) {
/*  526 */       this.chars = (char[])paramArrayOfchar.clone();
/*      */     } else {
/*  528 */       this.chars = null;
/*      */     } 
/*  530 */     return this;
/*      */   }
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
/*  542 */     checkTokenized();
/*  543 */     return (this.tokenPos < this.tokens.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String next() {
/*  555 */     if (hasNext()) {
/*  556 */       return this.tokens[this.tokenPos++];
/*      */     }
/*  558 */     throw new NoSuchElementException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int nextIndex() {
/*  568 */     return this.tokenPos;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasPrevious() {
/*  578 */     checkTokenized();
/*  579 */     return (this.tokenPos > 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String previous() {
/*  589 */     if (hasPrevious()) {
/*  590 */       return this.tokens[--this.tokenPos];
/*      */     }
/*  592 */     throw new NoSuchElementException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int previousIndex() {
/*  602 */     return this.tokenPos - 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void remove() {
/*  613 */     throw new UnsupportedOperationException("remove() is unsupported");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void set(String paramString) {
/*  626 */     throw new UnsupportedOperationException("set() is unsupported");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void add(String paramString) {
/*  639 */     throw new UnsupportedOperationException("add() is unsupported");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void checkTokenized() {
/*  648 */     if (this.tokens == null) {
/*  649 */       if (this.chars == null) {
/*      */         
/*  651 */         List<String> list = tokenize(null, 0, 0);
/*  652 */         this.tokens = list.<String>toArray(new String[list.size()]);
/*      */       } else {
/*  654 */         List<String> list = tokenize(this.chars, 0, this.chars.length);
/*  655 */         this.tokens = list.<String>toArray(new String[list.size()]);
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
/*      */   
/*      */   protected List<String> tokenize(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  682 */     if (paramArrayOfchar == null || paramInt2 == 0) {
/*  683 */       return Collections.emptyList();
/*      */     }
/*  685 */     TextStringBuilder textStringBuilder = new TextStringBuilder();
/*  686 */     ArrayList<String> arrayList = new ArrayList();
/*  687 */     int i = paramInt1;
/*      */ 
/*      */     
/*  690 */     while (i >= 0 && i < paramInt2) {
/*      */       
/*  692 */       i = readNextToken(paramArrayOfchar, i, paramInt2, textStringBuilder, arrayList);
/*      */ 
/*      */       
/*  695 */       if (i >= paramInt2) {
/*  696 */         addToken(arrayList, "");
/*      */       }
/*      */     } 
/*  699 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void addToken(List<String> paramList, String paramString) {
/*  711 */     if (paramString == null || paramString.length() == 0) {
/*  712 */       if (isIgnoreEmptyTokens()) {
/*      */         return;
/*      */       }
/*  715 */       if (isEmptyTokenAsNull()) {
/*  716 */         paramString = null;
/*      */       }
/*      */     } 
/*  719 */     paramList.add(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int readNextToken(char[] paramArrayOfchar, int paramInt1, int paramInt2, TextStringBuilder paramTextStringBuilder, List<String> paramList) {
/*  742 */     while (paramInt1 < paramInt2) {
/*  743 */       int k = Math.max(getIgnoredMatcher().isMatch(paramArrayOfchar, paramInt1, paramInt1, paramInt2), 
/*  744 */           getTrimmerMatcher().isMatch(paramArrayOfchar, paramInt1, paramInt1, paramInt2));
/*  745 */       if (k == 0 || getDelimiterMatcher().isMatch(paramArrayOfchar, paramInt1, paramInt1, paramInt2) > 0 || 
/*  746 */         getQuoteMatcher().isMatch(paramArrayOfchar, paramInt1, paramInt1, paramInt2) > 0) {
/*      */         break;
/*      */       }
/*  749 */       paramInt1 += k;
/*      */     } 
/*      */ 
/*      */     
/*  753 */     if (paramInt1 >= paramInt2) {
/*  754 */       addToken(paramList, "");
/*  755 */       return -1;
/*      */     } 
/*      */ 
/*      */     
/*  759 */     int i = getDelimiterMatcher().isMatch(paramArrayOfchar, paramInt1, paramInt1, paramInt2);
/*  760 */     if (i > 0) {
/*  761 */       addToken(paramList, "");
/*  762 */       return paramInt1 + i;
/*      */     } 
/*      */ 
/*      */     
/*  766 */     int j = getQuoteMatcher().isMatch(paramArrayOfchar, paramInt1, paramInt1, paramInt2);
/*  767 */     if (j > 0) {
/*  768 */       return readWithQuotes(paramArrayOfchar, paramInt1 + j, paramInt2, paramTextStringBuilder, paramList, paramInt1, j);
/*      */     }
/*  770 */     return readWithQuotes(paramArrayOfchar, paramInt1, paramInt2, paramTextStringBuilder, paramList, 0, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int readWithQuotes(char[] paramArrayOfchar, int paramInt1, int paramInt2, TextStringBuilder paramTextStringBuilder, List<String> paramList, int paramInt3, int paramInt4) {
/*  797 */     paramTextStringBuilder.clear();
/*  798 */     int i = paramInt1;
/*  799 */     boolean bool = (paramInt4 > 0) ? true : false;
/*  800 */     int j = 0;
/*      */     
/*  802 */     while (i < paramInt2) {
/*      */ 
/*      */ 
/*      */       
/*  806 */       if (bool) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  813 */         if (isQuote(paramArrayOfchar, i, paramInt2, paramInt3, paramInt4)) {
/*  814 */           if (isQuote(paramArrayOfchar, i + paramInt4, paramInt2, paramInt3, paramInt4)) {
/*      */             
/*  816 */             paramTextStringBuilder.append(paramArrayOfchar, i, paramInt4);
/*  817 */             i += paramInt4 * 2;
/*  818 */             j = paramTextStringBuilder.size();
/*      */             
/*      */             continue;
/*      */           } 
/*      */           
/*  823 */           bool = false;
/*  824 */           i += paramInt4;
/*      */           
/*      */           continue;
/*      */         } 
/*      */         
/*  829 */         paramTextStringBuilder.append(paramArrayOfchar[i++]);
/*  830 */         j = paramTextStringBuilder.size();
/*      */ 
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  836 */       int k = getDelimiterMatcher().isMatch(paramArrayOfchar, i, paramInt1, paramInt2);
/*  837 */       if (k > 0) {
/*      */         
/*  839 */         addToken(paramList, paramTextStringBuilder.substring(0, j));
/*  840 */         return i + k;
/*      */       } 
/*      */ 
/*      */       
/*  844 */       if (paramInt4 > 0 && isQuote(paramArrayOfchar, i, paramInt2, paramInt3, paramInt4)) {
/*  845 */         bool = true;
/*  846 */         i += paramInt4;
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  851 */       int m = getIgnoredMatcher().isMatch(paramArrayOfchar, i, paramInt1, paramInt2);
/*  852 */       if (m > 0) {
/*  853 */         i += m;
/*      */ 
/*      */         
/*      */         continue;
/*      */       } 
/*      */ 
/*      */       
/*  860 */       int n = getTrimmerMatcher().isMatch(paramArrayOfchar, i, paramInt1, paramInt2);
/*  861 */       if (n > 0) {
/*  862 */         paramTextStringBuilder.append(paramArrayOfchar, i, n);
/*  863 */         i += n;
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  868 */       paramTextStringBuilder.append(paramArrayOfchar[i++]);
/*  869 */       j = paramTextStringBuilder.size();
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  874 */     addToken(paramList, paramTextStringBuilder.substring(0, j));
/*  875 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  895 */     for (byte b = 0; b < paramInt4; b++) {
/*  896 */       if (paramInt1 + b >= paramInt2 || paramArrayOfchar[paramInt1 + b] != paramArrayOfchar[paramInt3 + b]) {
/*  897 */         return false;
/*      */       }
/*      */     } 
/*  900 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringMatcher getDelimiterMatcher() {
/*  911 */     return this.delimMatcher;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringTokenizer setDelimiterMatcher(StringMatcher paramStringMatcher) {
/*  924 */     if (paramStringMatcher == null) {
/*  925 */       this.delimMatcher = StringMatcherFactory.INSTANCE.noneMatcher();
/*      */     } else {
/*  927 */       this.delimMatcher = paramStringMatcher;
/*      */     } 
/*  929 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringTokenizer setDelimiterChar(char paramChar) {
/*  940 */     return setDelimiterMatcher(StringMatcherFactory.INSTANCE.charMatcher(paramChar));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringTokenizer setDelimiterString(String paramString) {
/*  951 */     return setDelimiterMatcher(StringMatcherFactory.INSTANCE.stringMatcher(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringMatcher getQuoteMatcher() {
/*  965 */     return this.quoteMatcher;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringTokenizer setQuoteMatcher(StringMatcher paramStringMatcher) {
/*  978 */     if (paramStringMatcher != null) {
/*  979 */       this.quoteMatcher = paramStringMatcher;
/*      */     }
/*  981 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringTokenizer setQuoteChar(char paramChar) {
/*  994 */     return setQuoteMatcher(StringMatcherFactory.INSTANCE.charMatcher(paramChar));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringMatcher getIgnoredMatcher() {
/* 1008 */     return this.ignoredMatcher;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringTokenizer setIgnoredMatcher(StringMatcher paramStringMatcher) {
/* 1021 */     if (paramStringMatcher != null) {
/* 1022 */       this.ignoredMatcher = paramStringMatcher;
/*      */     }
/* 1024 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringTokenizer setIgnoredChar(char paramChar) {
/* 1037 */     return setIgnoredMatcher(StringMatcherFactory.INSTANCE.charMatcher(paramChar));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringMatcher getTrimmerMatcher() {
/* 1051 */     return this.trimmerMatcher;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringTokenizer setTrimmerMatcher(StringMatcher paramStringMatcher) {
/* 1064 */     if (paramStringMatcher != null) {
/* 1065 */       this.trimmerMatcher = paramStringMatcher;
/*      */     }
/* 1067 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmptyTokenAsNull() {
/* 1077 */     return this.emptyAsNull;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringTokenizer setEmptyTokenAsNull(boolean paramBoolean) {
/* 1088 */     this.emptyAsNull = paramBoolean;
/* 1089 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isIgnoreEmptyTokens() {
/* 1099 */     return this.ignoreEmptyTokens;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringTokenizer setIgnoreEmptyTokens(boolean paramBoolean) {
/* 1110 */     this.ignoreEmptyTokens = paramBoolean;
/* 1111 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getContent() {
/* 1121 */     if (this.chars == null) {
/* 1122 */       return null;
/*      */     }
/* 1124 */     return new String(this.chars);
/*      */   }
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
/* 1137 */       return cloneReset();
/* 1138 */     } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 1139 */       return null;
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
/*      */   Object cloneReset() throws CloneNotSupportedException {
/* 1153 */     StringTokenizer stringTokenizer = (StringTokenizer)super.clone();
/* 1154 */     if (stringTokenizer.chars != null) {
/* 1155 */       stringTokenizer.chars = (char[])stringTokenizer.chars.clone();
/*      */     }
/* 1157 */     stringTokenizer.reset();
/* 1158 */     return stringTokenizer;
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
/* 1169 */     if (this.tokens == null) {
/* 1170 */       return "StringTokenizer[not tokenized yet]";
/*      */     }
/* 1172 */     return "StringTokenizer" + getTokenList();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\StringTokenizer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */