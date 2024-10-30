/*      */ package org.apache.commons.lang3.text;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Enumeration;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Properties;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */ public class StrSubstitutor
/*      */ {
/*      */   public static final char DEFAULT_ESCAPE = '$';
/*  138 */   public static final StrMatcher DEFAULT_PREFIX = StrMatcher.stringMatcher("${");
/*      */ 
/*      */ 
/*      */   
/*  142 */   public static final StrMatcher DEFAULT_SUFFIX = StrMatcher.stringMatcher("}");
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  147 */   public static final StrMatcher DEFAULT_VALUE_DELIMITER = StrMatcher.stringMatcher(":-");
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private char escapeChar;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private StrMatcher prefixMatcher;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private StrMatcher suffixMatcher;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private StrMatcher valueDelimiterMatcher;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private StrLookup<?> variableResolver;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean enableSubstitutionInVariables;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean preserveEscapes = false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <V> String replace(Object paramObject, Map<String, V> paramMap) {
/*  189 */     return (new StrSubstitutor(paramMap)).replace(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <V> String replace(Object paramObject, Map<String, V> paramMap, String paramString1, String paramString2) {
/*  206 */     return (new StrSubstitutor(paramMap, paramString1, paramString2)).replace(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String replace(Object paramObject, Properties paramProperties) {
/*  218 */     if (paramProperties == null) {
/*  219 */       return paramObject.toString();
/*      */     }
/*  221 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  222 */     Enumeration<?> enumeration = paramProperties.propertyNames();
/*  223 */     while (enumeration.hasMoreElements()) {
/*  224 */       String str1 = (String)enumeration.nextElement();
/*  225 */       String str2 = paramProperties.getProperty(str1);
/*  226 */       hashMap.put(str1, str2);
/*      */     } 
/*  228 */     return replace(paramObject, (Map)hashMap);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String replaceSystemProperties(Object paramObject) {
/*  239 */     return (new StrSubstitutor(StrLookup.systemPropertiesLookup())).replace(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrSubstitutor() {
/*  248 */     this((StrLookup<?>)null, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <V> StrSubstitutor(Map<String, V> paramMap) {
/*  259 */     this(StrLookup.mapLookup(paramMap), DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <V> StrSubstitutor(Map<String, V> paramMap, String paramString1, String paramString2) {
/*  272 */     this(StrLookup.mapLookup(paramMap), paramString1, paramString2, '$');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <V> StrSubstitutor(Map<String, V> paramMap, String paramString1, String paramString2, char paramChar) {
/*  287 */     this(StrLookup.mapLookup(paramMap), paramString1, paramString2, paramChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <V> StrSubstitutor(Map<String, V> paramMap, String paramString1, String paramString2, char paramChar, String paramString3) {
/*  304 */     this(StrLookup.mapLookup(paramMap), paramString1, paramString2, paramChar, paramString3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrSubstitutor(StrLookup<?> paramStrLookup) {
/*  313 */     this(paramStrLookup, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrSubstitutor(StrLookup<?> paramStrLookup, String paramString1, String paramString2, char paramChar) {
/*  327 */     setVariableResolver(paramStrLookup);
/*  328 */     setVariablePrefix(paramString1);
/*  329 */     setVariableSuffix(paramString2);
/*  330 */     setEscapeChar(paramChar);
/*  331 */     setValueDelimiterMatcher(DEFAULT_VALUE_DELIMITER);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrSubstitutor(StrLookup<?> paramStrLookup, String paramString1, String paramString2, char paramChar, String paramString3) {
/*  347 */     setVariableResolver(paramStrLookup);
/*  348 */     setVariablePrefix(paramString1);
/*  349 */     setVariableSuffix(paramString2);
/*  350 */     setEscapeChar(paramChar);
/*  351 */     setValueDelimiter(paramString3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrSubstitutor(StrLookup<?> paramStrLookup, StrMatcher paramStrMatcher1, StrMatcher paramStrMatcher2, char paramChar) {
/*  366 */     this(paramStrLookup, paramStrMatcher1, paramStrMatcher2, paramChar, DEFAULT_VALUE_DELIMITER);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrSubstitutor(StrLookup<?> paramStrLookup, StrMatcher paramStrMatcher1, StrMatcher paramStrMatcher2, char paramChar, StrMatcher paramStrMatcher3) {
/*  383 */     setVariableResolver(paramStrLookup);
/*  384 */     setVariablePrefixMatcher(paramStrMatcher1);
/*  385 */     setVariableSuffixMatcher(paramStrMatcher2);
/*  386 */     setEscapeChar(paramChar);
/*  387 */     setValueDelimiterMatcher(paramStrMatcher3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String replace(String paramString) {
/*  399 */     if (paramString == null) {
/*  400 */       return null;
/*      */     }
/*  402 */     StrBuilder strBuilder = new StrBuilder(paramString);
/*  403 */     if (!substitute(strBuilder, 0, paramString.length())) {
/*  404 */       return paramString;
/*      */     }
/*  406 */     return strBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String replace(String paramString, int paramInt1, int paramInt2) {
/*  422 */     if (paramString == null) {
/*  423 */       return null;
/*      */     }
/*  425 */     StrBuilder strBuilder = (new StrBuilder(paramInt2)).append(paramString, paramInt1, paramInt2);
/*  426 */     if (!substitute(strBuilder, 0, paramInt2)) {
/*  427 */       return paramString.substring(paramInt1, paramInt1 + paramInt2);
/*      */     }
/*  429 */     return strBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String replace(char[] paramArrayOfchar) {
/*  442 */     if (paramArrayOfchar == null) {
/*  443 */       return null;
/*      */     }
/*  445 */     StrBuilder strBuilder = (new StrBuilder(paramArrayOfchar.length)).append(paramArrayOfchar);
/*  446 */     substitute(strBuilder, 0, paramArrayOfchar.length);
/*  447 */     return strBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String replace(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  464 */     if (paramArrayOfchar == null) {
/*  465 */       return null;
/*      */     }
/*  467 */     StrBuilder strBuilder = (new StrBuilder(paramInt2)).append(paramArrayOfchar, paramInt1, paramInt2);
/*  468 */     substitute(strBuilder, 0, paramInt2);
/*  469 */     return strBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String replace(StringBuffer paramStringBuffer) {
/*  482 */     if (paramStringBuffer == null) {
/*  483 */       return null;
/*      */     }
/*  485 */     StrBuilder strBuilder = (new StrBuilder(paramStringBuffer.length())).append(paramStringBuffer);
/*  486 */     substitute(strBuilder, 0, strBuilder.length());
/*  487 */     return strBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String replace(StringBuffer paramStringBuffer, int paramInt1, int paramInt2) {
/*  504 */     if (paramStringBuffer == null) {
/*  505 */       return null;
/*      */     }
/*  507 */     StrBuilder strBuilder = (new StrBuilder(paramInt2)).append(paramStringBuffer, paramInt1, paramInt2);
/*  508 */     substitute(strBuilder, 0, paramInt2);
/*  509 */     return strBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String replace(CharSequence paramCharSequence) {
/*  522 */     if (paramCharSequence == null) {
/*  523 */       return null;
/*      */     }
/*  525 */     return replace(paramCharSequence, 0, paramCharSequence.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String replace(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*  543 */     if (paramCharSequence == null) {
/*  544 */       return null;
/*      */     }
/*  546 */     StrBuilder strBuilder = (new StrBuilder(paramInt2)).append(paramCharSequence, paramInt1, paramInt2);
/*  547 */     substitute(strBuilder, 0, paramInt2);
/*  548 */     return strBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String replace(StrBuilder paramStrBuilder) {
/*  561 */     if (paramStrBuilder == null) {
/*  562 */       return null;
/*      */     }
/*  564 */     StrBuilder strBuilder = (new StrBuilder(paramStrBuilder.length())).append(paramStrBuilder);
/*  565 */     substitute(strBuilder, 0, strBuilder.length());
/*  566 */     return strBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String replace(StrBuilder paramStrBuilder, int paramInt1, int paramInt2) {
/*  583 */     if (paramStrBuilder == null) {
/*  584 */       return null;
/*      */     }
/*  586 */     StrBuilder strBuilder = (new StrBuilder(paramInt2)).append(paramStrBuilder, paramInt1, paramInt2);
/*  587 */     substitute(strBuilder, 0, paramInt2);
/*  588 */     return strBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String replace(Object paramObject) {
/*  601 */     if (paramObject == null) {
/*  602 */       return null;
/*      */     }
/*  604 */     StrBuilder strBuilder = (new StrBuilder()).append(paramObject);
/*  605 */     substitute(strBuilder, 0, strBuilder.length());
/*  606 */     return strBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean replaceIn(StringBuffer paramStringBuffer) {
/*  619 */     if (paramStringBuffer == null) {
/*  620 */       return false;
/*      */     }
/*  622 */     return replaceIn(paramStringBuffer, 0, paramStringBuffer.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean replaceIn(StringBuffer paramStringBuffer, int paramInt1, int paramInt2) {
/*  639 */     if (paramStringBuffer == null) {
/*  640 */       return false;
/*      */     }
/*  642 */     StrBuilder strBuilder = (new StrBuilder(paramInt2)).append(paramStringBuffer, paramInt1, paramInt2);
/*  643 */     if (!substitute(strBuilder, 0, paramInt2)) {
/*  644 */       return false;
/*      */     }
/*  646 */     paramStringBuffer.replace(paramInt1, paramInt1 + paramInt2, strBuilder.toString());
/*  647 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean replaceIn(StringBuilder paramStringBuilder) {
/*  661 */     if (paramStringBuilder == null) {
/*  662 */       return false;
/*      */     }
/*  664 */     return replaceIn(paramStringBuilder, 0, paramStringBuilder.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean replaceIn(StringBuilder paramStringBuilder, int paramInt1, int paramInt2) {
/*  682 */     if (paramStringBuilder == null) {
/*  683 */       return false;
/*      */     }
/*  685 */     StrBuilder strBuilder = (new StrBuilder(paramInt2)).append(paramStringBuilder, paramInt1, paramInt2);
/*  686 */     if (!substitute(strBuilder, 0, paramInt2)) {
/*  687 */       return false;
/*      */     }
/*  689 */     paramStringBuilder.replace(paramInt1, paramInt1 + paramInt2, strBuilder.toString());
/*  690 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean replaceIn(StrBuilder paramStrBuilder) {
/*  702 */     if (paramStrBuilder == null) {
/*  703 */       return false;
/*      */     }
/*  705 */     return substitute(paramStrBuilder, 0, paramStrBuilder.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean replaceIn(StrBuilder paramStrBuilder, int paramInt1, int paramInt2) {
/*  721 */     if (paramStrBuilder == null) {
/*  722 */       return false;
/*      */     }
/*  724 */     return substitute(paramStrBuilder, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean substitute(StrBuilder paramStrBuilder, int paramInt1, int paramInt2) {
/*  743 */     return (substitute(paramStrBuilder, paramInt1, paramInt2, null) > 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int substitute(StrBuilder paramStrBuilder, int paramInt1, int paramInt2, List<String> paramList) {
/*  759 */     StrMatcher strMatcher1 = getVariablePrefixMatcher();
/*  760 */     StrMatcher strMatcher2 = getVariableSuffixMatcher();
/*  761 */     char c = getEscapeChar();
/*  762 */     StrMatcher strMatcher3 = getValueDelimiterMatcher();
/*  763 */     boolean bool = isEnableSubstitutionInVariables();
/*      */     
/*  765 */     boolean bool1 = (paramList == null) ? true : false;
/*  766 */     boolean bool2 = false;
/*  767 */     int i = 0;
/*  768 */     char[] arrayOfChar = paramStrBuilder.buffer;
/*  769 */     int j = paramInt1 + paramInt2;
/*  770 */     int k = paramInt1;
/*  771 */     while (k < j) {
/*  772 */       int m = strMatcher1.isMatch(arrayOfChar, k, paramInt1, j);
/*      */       
/*  774 */       if (m == 0) {
/*  775 */         k++;
/*      */         continue;
/*      */       } 
/*  778 */       if (k > paramInt1 && arrayOfChar[k - 1] == c) {
/*      */         
/*  780 */         if (this.preserveEscapes) {
/*  781 */           k++;
/*      */           continue;
/*      */         } 
/*  784 */         paramStrBuilder.deleteCharAt(k - 1);
/*  785 */         arrayOfChar = paramStrBuilder.buffer;
/*  786 */         i--;
/*  787 */         bool2 = true;
/*  788 */         j--;
/*      */         continue;
/*      */       } 
/*  791 */       int n = k;
/*  792 */       k += m;
/*  793 */       int i1 = 0;
/*  794 */       byte b = 0;
/*  795 */       while (k < j) {
/*  796 */         if (bool && (
/*  797 */           i1 = strMatcher1.isMatch(arrayOfChar, k, paramInt1, j)) != 0) {
/*      */ 
/*      */           
/*  800 */           b++;
/*  801 */           k += i1;
/*      */           
/*      */           continue;
/*      */         } 
/*  805 */         i1 = strMatcher2.isMatch(arrayOfChar, k, paramInt1, j);
/*      */         
/*  807 */         if (i1 == 0) {
/*  808 */           k++;
/*      */           continue;
/*      */         } 
/*  811 */         if (b == 0) {
/*  812 */           String str1 = new String(arrayOfChar, n + m, k - n - m);
/*      */ 
/*      */           
/*  815 */           if (bool) {
/*  816 */             StrBuilder strBuilder = new StrBuilder(str1);
/*  817 */             substitute(strBuilder, 0, strBuilder.length());
/*  818 */             str1 = strBuilder.toString();
/*      */           } 
/*  820 */           k += i1;
/*  821 */           int i2 = k;
/*      */           
/*  823 */           String str2 = str1;
/*  824 */           String str3 = null;
/*      */           
/*  826 */           if (strMatcher3 != null) {
/*  827 */             char[] arrayOfChar1 = str1.toCharArray();
/*  828 */             int i3 = 0;
/*  829 */             for (byte b1 = 0; b1 < arrayOfChar1.length; b1++) {
/*      */               
/*  831 */               if (!bool && strMatcher1
/*  832 */                 .isMatch(arrayOfChar1, b1, b1, arrayOfChar1.length) != 0) {
/*      */                 break;
/*      */               }
/*  835 */               if ((i3 = strMatcher3.isMatch(arrayOfChar1, b1)) != 0) {
/*  836 */                 str2 = str1.substring(0, b1);
/*  837 */                 str3 = str1.substring(b1 + i3);
/*      */                 
/*      */                 break;
/*      */               } 
/*      */             } 
/*      */           } 
/*      */           
/*  844 */           if (paramList == null) {
/*  845 */             paramList = new ArrayList<>();
/*  846 */             paramList.add(new String(arrayOfChar, paramInt1, paramInt2));
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/*  851 */           checkCyclicSubstitution(str2, paramList);
/*  852 */           paramList.add(str2);
/*      */ 
/*      */           
/*  855 */           String str4 = resolveVariable(str2, paramStrBuilder, n, i2);
/*      */           
/*  857 */           if (str4 == null) {
/*  858 */             str4 = str3;
/*      */           }
/*  860 */           if (str4 != null) {
/*      */             
/*  862 */             int i3 = str4.length();
/*  863 */             paramStrBuilder.replace(n, i2, str4);
/*  864 */             bool2 = true;
/*  865 */             int i4 = substitute(paramStrBuilder, n, i3, paramList);
/*      */             
/*  867 */             i4 = i4 + i3 - i2 - n;
/*      */             
/*  869 */             k += i4;
/*  870 */             j += i4;
/*  871 */             i += i4;
/*  872 */             arrayOfChar = paramStrBuilder.buffer;
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/*  877 */           paramList
/*  878 */             .remove(paramList.size() - 1);
/*      */           break;
/*      */         } 
/*  881 */         b--;
/*  882 */         k += i1;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  888 */     if (bool1) {
/*  889 */       return bool2 ? 1 : 0;
/*      */     }
/*  891 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void checkCyclicSubstitution(String paramString, List<String> paramList) {
/*  901 */     if (!paramList.contains(paramString)) {
/*      */       return;
/*      */     }
/*  904 */     StrBuilder strBuilder = new StrBuilder(256);
/*  905 */     strBuilder.append("Infinite loop in property interpolation of ");
/*  906 */     strBuilder.append(paramList.remove(0));
/*  907 */     strBuilder.append(": ");
/*  908 */     strBuilder.appendWithSeparators(paramList, "->");
/*  909 */     throw new IllegalStateException(strBuilder.toString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String resolveVariable(String paramString, StrBuilder paramStrBuilder, int paramInt1, int paramInt2) {
/*  930 */     StrLookup<?> strLookup = getVariableResolver();
/*  931 */     if (strLookup == null) {
/*  932 */       return null;
/*      */     }
/*  934 */     return strLookup.lookup(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public char getEscapeChar() {
/*  945 */     return this.escapeChar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEscapeChar(char paramChar) {
/*  956 */     this.escapeChar = paramChar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrMatcher getVariablePrefixMatcher() {
/*  971 */     return this.prefixMatcher;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrSubstitutor setVariablePrefixMatcher(StrMatcher paramStrMatcher) {
/*  986 */     if (paramStrMatcher == null) {
/*  987 */       throw new IllegalArgumentException("Variable prefix matcher must not be null.");
/*      */     }
/*  989 */     this.prefixMatcher = paramStrMatcher;
/*  990 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrSubstitutor setVariablePrefix(char paramChar) {
/* 1004 */     return setVariablePrefixMatcher(StrMatcher.charMatcher(paramChar));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrSubstitutor setVariablePrefix(String paramString) {
/* 1018 */     if (paramString == null) {
/* 1019 */       throw new IllegalArgumentException("Variable prefix must not be null.");
/*      */     }
/* 1021 */     return setVariablePrefixMatcher(StrMatcher.stringMatcher(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrMatcher getVariableSuffixMatcher() {
/* 1036 */     return this.suffixMatcher;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrSubstitutor setVariableSuffixMatcher(StrMatcher paramStrMatcher) {
/* 1051 */     if (paramStrMatcher == null) {
/* 1052 */       throw new IllegalArgumentException("Variable suffix matcher must not be null.");
/*      */     }
/* 1054 */     this.suffixMatcher = paramStrMatcher;
/* 1055 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrSubstitutor setVariableSuffix(char paramChar) {
/* 1069 */     return setVariableSuffixMatcher(StrMatcher.charMatcher(paramChar));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrSubstitutor setVariableSuffix(String paramString) {
/* 1083 */     if (paramString == null) {
/* 1084 */       throw new IllegalArgumentException("Variable suffix must not be null.");
/*      */     }
/* 1086 */     return setVariableSuffixMatcher(StrMatcher.stringMatcher(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrMatcher getValueDelimiterMatcher() {
/* 1104 */     return this.valueDelimiterMatcher;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrSubstitutor setValueDelimiterMatcher(StrMatcher paramStrMatcher) {
/* 1122 */     this.valueDelimiterMatcher = paramStrMatcher;
/* 1123 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrSubstitutor setValueDelimiter(char paramChar) {
/* 1138 */     return setValueDelimiterMatcher(StrMatcher.charMatcher(paramChar));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrSubstitutor setValueDelimiter(String paramString) {
/* 1156 */     if (StringUtils.isEmpty(paramString)) {
/* 1157 */       setValueDelimiterMatcher(null);
/* 1158 */       return this;
/*      */     } 
/* 1160 */     return setValueDelimiterMatcher(StrMatcher.stringMatcher(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrLookup<?> getVariableResolver() {
/* 1171 */     return this.variableResolver;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVariableResolver(StrLookup<?> paramStrLookup) {
/* 1180 */     this.variableResolver = paramStrLookup;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEnableSubstitutionInVariables() {
/* 1192 */     return this.enableSubstitutionInVariables;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEnableSubstitutionInVariables(boolean paramBoolean) {
/* 1206 */     this.enableSubstitutionInVariables = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPreserveEscapes() {
/* 1217 */     return this.preserveEscapes;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPreserveEscapes(boolean paramBoolean) {
/* 1233 */     this.preserveEscapes = paramBoolean;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\text\StrSubstitutor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */