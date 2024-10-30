/*      */ package org.apache.commons.lang3.text;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.List;
/*      */ import java.util.ListIterator;
/*      */ import java.util.NoSuchElementException;
/*      */ import org.apache.commons.lang3.ArrayUtils;
/*      */ import org.apache.commons.lang3.StringUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*   95 */   private static final StrTokenizer CSV_TOKENIZER_PROTOTYPE = new StrTokenizer(); static {
/*   96 */     CSV_TOKENIZER_PROTOTYPE.setDelimiterMatcher(StrMatcher.commaMatcher());
/*   97 */     CSV_TOKENIZER_PROTOTYPE.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
/*   98 */     CSV_TOKENIZER_PROTOTYPE.setIgnoredMatcher(StrMatcher.noneMatcher());
/*   99 */     CSV_TOKENIZER_PROTOTYPE.setTrimmerMatcher(StrMatcher.trimMatcher());
/*  100 */     CSV_TOKENIZER_PROTOTYPE.setEmptyTokenAsNull(false);
/*  101 */     CSV_TOKENIZER_PROTOTYPE.setIgnoreEmptyTokens(false);
/*      */   }
/*  103 */   private static final StrTokenizer TSV_TOKENIZER_PROTOTYPE = new StrTokenizer(); static {
/*  104 */     TSV_TOKENIZER_PROTOTYPE.setDelimiterMatcher(StrMatcher.tabMatcher());
/*  105 */     TSV_TOKENIZER_PROTOTYPE.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
/*  106 */     TSV_TOKENIZER_PROTOTYPE.setIgnoredMatcher(StrMatcher.noneMatcher());
/*  107 */     TSV_TOKENIZER_PROTOTYPE.setTrimmerMatcher(StrMatcher.trimMatcher());
/*  108 */     TSV_TOKENIZER_PROTOTYPE.setEmptyTokenAsNull(false);
/*  109 */     TSV_TOKENIZER_PROTOTYPE.setIgnoreEmptyTokens(false);
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
/*  120 */   private StrMatcher delimMatcher = StrMatcher.splitMatcher();
/*      */   
/*  122 */   private StrMatcher quoteMatcher = StrMatcher.noneMatcher();
/*      */   
/*  124 */   private StrMatcher ignoredMatcher = StrMatcher.noneMatcher();
/*      */   
/*  126 */   private StrMatcher trimmerMatcher = StrMatcher.noneMatcher();
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
/*  141 */     return (StrTokenizer)CSV_TOKENIZER_PROTOTYPE.clone();
/*      */   }
/*      */ 
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
/*  154 */     return getCSVClone();
/*      */   }
/*      */ 
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
/*  167 */     StrTokenizer strTokenizer = getCSVClone();
/*  168 */     strTokenizer.reset(paramString);
/*  169 */     return strTokenizer;
/*      */   }
/*      */ 
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
/*  182 */     StrTokenizer strTokenizer = getCSVClone();
/*  183 */     strTokenizer.reset(paramArrayOfchar);
/*  184 */     return strTokenizer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static StrTokenizer getTSVClone() {
/*  193 */     return (StrTokenizer)TSV_TOKENIZER_PROTOTYPE.clone();
/*      */   }
/*      */ 
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
/*  206 */     return getTSVClone();
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
/*  217 */     StrTokenizer strTokenizer = getTSVClone();
/*  218 */     strTokenizer.reset(paramString);
/*  219 */     return strTokenizer;
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
/*  230 */     StrTokenizer strTokenizer = getTSVClone();
/*  231 */     strTokenizer.reset(paramArrayOfchar);
/*  232 */     return strTokenizer;
/*      */   }
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
/*  244 */     this.chars = null;
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
/*  255 */     if (paramString != null) {
/*  256 */       this.chars = paramString.toCharArray();
/*      */     } else {
/*  258 */       this.chars = null;
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
/*  269 */     this(paramString);
/*  270 */     setDelimiterChar(paramChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(String paramString1, String paramString2) {
/*  280 */     this(paramString1);
/*  281 */     setDelimiterString(paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(String paramString, StrMatcher paramStrMatcher) {
/*  291 */     this(paramString);
/*  292 */     setDelimiterMatcher(paramStrMatcher);
/*      */   }
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
/*  304 */     this(paramString, paramChar1);
/*  305 */     setQuoteChar(paramChar2);
/*      */   }
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
/*  317 */     this(paramString, paramStrMatcher1);
/*  318 */     setQuoteMatcher(paramStrMatcher2);
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
/*  329 */     this.chars = ArrayUtils.clone(paramArrayOfchar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(char[] paramArrayOfchar, char paramChar) {
/*  339 */     this(paramArrayOfchar);
/*  340 */     setDelimiterChar(paramChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(char[] paramArrayOfchar, String paramString) {
/*  350 */     this(paramArrayOfchar);
/*  351 */     setDelimiterString(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(char[] paramArrayOfchar, StrMatcher paramStrMatcher) {
/*  361 */     this(paramArrayOfchar);
/*  362 */     setDelimiterMatcher(paramStrMatcher);
/*      */   }
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
/*  374 */     this(paramArrayOfchar, paramChar1);
/*  375 */     setQuoteChar(paramChar2);
/*      */   }
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
/*  387 */     this(paramArrayOfchar, paramStrMatcher1);
/*  388 */     setQuoteMatcher(paramStrMatcher2);
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
/*  399 */     checkTokenized();
/*  400 */     return this.tokens.length;
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
/*  411 */     if (hasNext()) {
/*  412 */       return this.tokens[this.tokenPos++];
/*      */     }
/*  414 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String previousToken() {
/*  423 */     if (hasPrevious()) {
/*  424 */       return this.tokens[--this.tokenPos];
/*      */     }
/*  426 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] getTokenArray() {
/*  435 */     checkTokenized();
/*  436 */     return (String[])this.tokens.clone();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<String> getTokenList() {
/*  445 */     checkTokenized();
/*  446 */     ArrayList<String> arrayList = new ArrayList(this.tokens.length);
/*  447 */     arrayList.addAll(Arrays.asList(this.tokens));
/*  448 */     return arrayList;
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
/*  459 */     this.tokenPos = 0;
/*  460 */     this.tokens = null;
/*  461 */     return this;
/*      */   }
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
/*  473 */     reset();
/*  474 */     if (paramString != null) {
/*  475 */       this.chars = paramString.toCharArray();
/*      */     } else {
/*  477 */       this.chars = null;
/*      */     } 
/*  479 */     return this;
/*      */   }
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
/*  491 */     reset();
/*  492 */     this.chars = ArrayUtils.clone(paramArrayOfchar);
/*  493 */     return this;
/*      */   }
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
/*  505 */     checkTokenized();
/*  506 */     return (this.tokenPos < this.tokens.length);
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
/*  517 */     if (hasNext()) {
/*  518 */       return this.tokens[this.tokenPos++];
/*      */     }
/*  520 */     throw new NoSuchElementException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int nextIndex() {
/*  530 */     return this.tokenPos;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasPrevious() {
/*  540 */     checkTokenized();
/*  541 */     return (this.tokenPos > 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String previous() {
/*  551 */     if (hasPrevious()) {
/*  552 */       return this.tokens[--this.tokenPos];
/*      */     }
/*  554 */     throw new NoSuchElementException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int previousIndex() {
/*  564 */     return this.tokenPos - 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void remove() {
/*  574 */     throw new UnsupportedOperationException("remove() is unsupported");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void set(String paramString) {
/*  584 */     throw new UnsupportedOperationException("set() is unsupported");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void add(String paramString) {
/*  594 */     throw new UnsupportedOperationException("add() is unsupported");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void checkTokenized() {
/*  603 */     if (this.tokens == null) {
/*  604 */       if (this.chars == null) {
/*      */         
/*  606 */         List<String> list = tokenize(null, 0, 0);
/*  607 */         this.tokens = list.<String>toArray(ArrayUtils.EMPTY_STRING_ARRAY);
/*      */       } else {
/*  609 */         List<String> list = tokenize(this.chars, 0, this.chars.length);
/*  610 */         this.tokens = list.<String>toArray(ArrayUtils.EMPTY_STRING_ARRAY);
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
/*  636 */     if (paramArrayOfchar == null || paramInt2 == 0) {
/*  637 */       return Collections.emptyList();
/*      */     }
/*  639 */     StrBuilder strBuilder = new StrBuilder();
/*  640 */     ArrayList<String> arrayList = new ArrayList();
/*  641 */     int i = paramInt1;
/*      */ 
/*      */     
/*  644 */     while (i >= 0 && i < paramInt2) {
/*      */       
/*  646 */       i = readNextToken(paramArrayOfchar, i, paramInt2, strBuilder, arrayList);
/*      */ 
/*      */       
/*  649 */       if (i >= paramInt2) {
/*  650 */         addToken(arrayList, "");
/*      */       }
/*      */     } 
/*  653 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void addToken(List<String> paramList, String paramString) {
/*  663 */     if (StringUtils.isEmpty(paramString)) {
/*  664 */       if (isIgnoreEmptyTokens()) {
/*      */         return;
/*      */       }
/*  667 */       if (isEmptyTokenAsNull()) {
/*  668 */         paramString = null;
/*      */       }
/*      */     } 
/*  671 */     paramList.add(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  688 */     while (paramInt1 < paramInt2) {
/*  689 */       int k = Math.max(
/*  690 */           getIgnoredMatcher().isMatch(paramArrayOfchar, paramInt1, paramInt1, paramInt2), 
/*  691 */           getTrimmerMatcher().isMatch(paramArrayOfchar, paramInt1, paramInt1, paramInt2));
/*  692 */       if (k == 0 || 
/*  693 */         getDelimiterMatcher().isMatch(paramArrayOfchar, paramInt1, paramInt1, paramInt2) > 0 || 
/*  694 */         getQuoteMatcher().isMatch(paramArrayOfchar, paramInt1, paramInt1, paramInt2) > 0) {
/*      */         break;
/*      */       }
/*  697 */       paramInt1 += k;
/*      */     } 
/*      */ 
/*      */     
/*  701 */     if (paramInt1 >= paramInt2) {
/*  702 */       addToken(paramList, "");
/*  703 */       return -1;
/*      */     } 
/*      */ 
/*      */     
/*  707 */     int i = getDelimiterMatcher().isMatch(paramArrayOfchar, paramInt1, paramInt1, paramInt2);
/*  708 */     if (i > 0) {
/*  709 */       addToken(paramList, "");
/*  710 */       return paramInt1 + i;
/*      */     } 
/*      */ 
/*      */     
/*  714 */     int j = getQuoteMatcher().isMatch(paramArrayOfchar, paramInt1, paramInt1, paramInt2);
/*  715 */     if (j > 0) {
/*  716 */       return readWithQuotes(paramArrayOfchar, paramInt1 + j, paramInt2, paramStrBuilder, paramList, paramInt1, j);
/*      */     }
/*  718 */     return readWithQuotes(paramArrayOfchar, paramInt1, paramInt2, paramStrBuilder, paramList, 0, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  739 */     paramStrBuilder.clear();
/*  740 */     int i = paramInt1;
/*  741 */     boolean bool = (paramInt4 > 0) ? true : false;
/*  742 */     int j = 0;
/*      */     
/*  744 */     while (i < paramInt2) {
/*      */ 
/*      */ 
/*      */       
/*  748 */       if (bool) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  755 */         if (isQuote(paramArrayOfchar, i, paramInt2, paramInt3, paramInt4)) {
/*  756 */           if (isQuote(paramArrayOfchar, i + paramInt4, paramInt2, paramInt3, paramInt4)) {
/*      */             
/*  758 */             paramStrBuilder.append(paramArrayOfchar, i, paramInt4);
/*  759 */             i += paramInt4 * 2;
/*  760 */             j = paramStrBuilder.size();
/*      */             
/*      */             continue;
/*      */           } 
/*      */           
/*  765 */           bool = false;
/*  766 */           i += paramInt4;
/*      */           
/*      */           continue;
/*      */         } 
/*      */         
/*  771 */         paramStrBuilder.append(paramArrayOfchar[i++]);
/*  772 */         j = paramStrBuilder.size();
/*      */ 
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  778 */       int k = getDelimiterMatcher().isMatch(paramArrayOfchar, i, paramInt1, paramInt2);
/*  779 */       if (k > 0) {
/*      */         
/*  781 */         addToken(paramList, paramStrBuilder.substring(0, j));
/*  782 */         return i + k;
/*      */       } 
/*      */ 
/*      */       
/*  786 */       if (paramInt4 > 0 && isQuote(paramArrayOfchar, i, paramInt2, paramInt3, paramInt4)) {
/*  787 */         bool = true;
/*  788 */         i += paramInt4;
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  793 */       int m = getIgnoredMatcher().isMatch(paramArrayOfchar, i, paramInt1, paramInt2);
/*  794 */       if (m > 0) {
/*  795 */         i += m;
/*      */ 
/*      */         
/*      */         continue;
/*      */       } 
/*      */ 
/*      */       
/*  802 */       int n = getTrimmerMatcher().isMatch(paramArrayOfchar, i, paramInt1, paramInt2);
/*  803 */       if (n > 0) {
/*  804 */         paramStrBuilder.append(paramArrayOfchar, i, n);
/*  805 */         i += n;
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  810 */       paramStrBuilder.append(paramArrayOfchar[i++]);
/*  811 */       j = paramStrBuilder.size();
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  816 */     addToken(paramList, paramStrBuilder.substring(0, j));
/*  817 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/*  832 */     for (byte b = 0; b < paramInt4; b++) {
/*  833 */       if (paramInt1 + b >= paramInt2 || paramArrayOfchar[paramInt1 + b] != paramArrayOfchar[paramInt3 + b]) {
/*  834 */         return false;
/*      */       }
/*      */     } 
/*  837 */     return true;
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
/*  848 */     return this.delimMatcher;
/*      */   }
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
/*  860 */     if (paramStrMatcher == null) {
/*  861 */       this.delimMatcher = StrMatcher.noneMatcher();
/*      */     } else {
/*  863 */       this.delimMatcher = paramStrMatcher;
/*      */     } 
/*  865 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer setDelimiterChar(char paramChar) {
/*  875 */     return setDelimiterMatcher(StrMatcher.charMatcher(paramChar));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer setDelimiterString(String paramString) {
/*  885 */     return setDelimiterMatcher(StrMatcher.stringMatcher(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/*  900 */     return this.quoteMatcher;
/*      */   }
/*      */ 
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
/*  913 */     if (paramStrMatcher != null) {
/*  914 */       this.quoteMatcher = paramStrMatcher;
/*      */     }
/*  916 */     return this;
/*      */   }
/*      */ 
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
/*  929 */     return setQuoteMatcher(StrMatcher.charMatcher(paramChar));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/*  944 */     return this.ignoredMatcher;
/*      */   }
/*      */ 
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
/*  957 */     if (paramStrMatcher != null) {
/*  958 */       this.ignoredMatcher = paramStrMatcher;
/*      */     }
/*  960 */     return this;
/*      */   }
/*      */ 
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
/*  973 */     return setIgnoredMatcher(StrMatcher.charMatcher(paramChar));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/*  988 */     return this.trimmerMatcher;
/*      */   }
/*      */ 
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
/* 1001 */     if (paramStrMatcher != null) {
/* 1002 */       this.trimmerMatcher = paramStrMatcher;
/*      */     }
/* 1004 */     return this;
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
/* 1015 */     return this.emptyAsNull;
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
/* 1026 */     this.emptyAsNull = paramBoolean;
/* 1027 */     return this;
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
/* 1038 */     return this.ignoreEmptyTokens;
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
/* 1049 */     this.ignoreEmptyTokens = paramBoolean;
/* 1050 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getContent() {
/* 1060 */     if (this.chars == null) {
/* 1061 */       return null;
/*      */     }
/* 1063 */     return new String(this.chars);
/*      */   }
/*      */ 
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
/* 1077 */       return cloneReset();
/* 1078 */     } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 1079 */       return null;
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
/* 1092 */     StrTokenizer strTokenizer = (StrTokenizer)super.clone();
/* 1093 */     if (strTokenizer.chars != null) {
/* 1094 */       strTokenizer.chars = (char[])strTokenizer.chars.clone();
/*      */     }
/* 1096 */     strTokenizer.reset();
/* 1097 */     return strTokenizer;
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
/* 1108 */     if (this.tokens == null) {
/* 1109 */       return "StrTokenizer[not tokenized yet]";
/*      */     }
/* 1111 */     return "StrTokenizer" + getTokenList();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\text\StrTokenizer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */