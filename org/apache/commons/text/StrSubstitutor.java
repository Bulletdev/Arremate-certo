/*      */ package org.apache.commons.text;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Enumeration;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Properties;
/*      */ import org.apache.commons.lang3.Validate;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  137 */   public static final StrMatcher DEFAULT_PREFIX = StrMatcher.stringMatcher("${");
/*      */ 
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
/*      */   
/*      */   private char escapeChar;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private StrMatcher prefixMatcher;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private StrMatcher suffixMatcher;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private StrMatcher valueDelimiterMatcher;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private StrLookup<?> variableResolver;
/*      */ 
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
/*      */   private boolean disableSubstitutionInValues;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <V> String replace(Object paramObject, Map<String, V> paramMap) {
/*  200 */     return (new StrSubstitutor(paramMap)).replace(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  220 */     return (new StrSubstitutor(paramMap, paramString1, paramString2)).replace(paramObject);
/*      */   }
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
/*  232 */     if (paramProperties == null) {
/*  233 */       return paramObject.toString();
/*      */     }
/*  235 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  236 */     Enumeration<?> enumeration = paramProperties.propertyNames();
/*  237 */     while (enumeration.hasMoreElements()) {
/*  238 */       String str1 = (String)enumeration.nextElement();
/*  239 */       String str2 = paramProperties.getProperty(str1);
/*  240 */       hashMap.put(str1, str2);
/*      */     } 
/*  242 */     return replace(paramObject, (Map)hashMap);
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
/*  253 */     return (new StrSubstitutor(StrLookup.systemPropertiesLookup())).replace(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrSubstitutor() {
/*  262 */     this((StrLookup)null, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
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
/*  273 */     this(StrLookup.mapLookup(paramMap), DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
/*      */   }
/*      */ 
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
/*  286 */     this(StrLookup.mapLookup(paramMap), paramString1, paramString2, '$');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/*  301 */     this(StrLookup.mapLookup(paramMap), paramString1, paramString2, paramChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  317 */     this(StrLookup.mapLookup(paramMap), paramString1, paramString2, paramChar, paramString3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrSubstitutor(StrLookup<?> paramStrLookup) {
/*  326 */     this(paramStrLookup, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
/*      */   }
/*      */ 
/*      */ 
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
/*  340 */     setVariableResolver(paramStrLookup);
/*  341 */     setVariablePrefix(paramString1);
/*  342 */     setVariableSuffix(paramString2);
/*  343 */     setEscapeChar(paramChar);
/*  344 */     setValueDelimiterMatcher(DEFAULT_VALUE_DELIMITER);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/*  359 */     setVariableResolver(paramStrLookup);
/*  360 */     setVariablePrefix(paramString1);
/*  361 */     setVariableSuffix(paramString2);
/*  362 */     setEscapeChar(paramChar);
/*  363 */     setValueDelimiter(paramString3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/*  378 */     this(paramStrLookup, paramStrMatcher1, paramStrMatcher2, paramChar, DEFAULT_VALUE_DELIMITER);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  394 */     setVariableResolver(paramStrLookup);
/*  395 */     setVariablePrefixMatcher(paramStrMatcher1);
/*  396 */     setVariableSuffixMatcher(paramStrMatcher2);
/*  397 */     setEscapeChar(paramChar);
/*  398 */     setValueDelimiterMatcher(paramStrMatcher3);
/*      */   }
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
/*  410 */     if (paramString == null) {
/*  411 */       return null;
/*      */     }
/*  413 */     StrBuilder strBuilder = new StrBuilder(paramString);
/*  414 */     if (!substitute(strBuilder, 0, paramString.length())) {
/*  415 */       return paramString;
/*      */     }
/*  417 */     return strBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  433 */     if (paramString == null) {
/*  434 */       return null;
/*      */     }
/*  436 */     StrBuilder strBuilder = (new StrBuilder(paramInt2)).append(paramString, paramInt1, paramInt2);
/*  437 */     if (!substitute(strBuilder, 0, paramInt2)) {
/*  438 */       return paramString.substring(paramInt1, paramInt1 + paramInt2);
/*      */     }
/*  440 */     return strBuilder.toString();
/*      */   }
/*      */ 
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
/*  453 */     if (paramArrayOfchar == null) {
/*  454 */       return null;
/*      */     }
/*  456 */     StrBuilder strBuilder = (new StrBuilder(paramArrayOfchar.length)).append(paramArrayOfchar);
/*  457 */     substitute(strBuilder, 0, paramArrayOfchar.length);
/*  458 */     return strBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  475 */     if (paramArrayOfchar == null) {
/*  476 */       return null;
/*      */     }
/*  478 */     StrBuilder strBuilder = (new StrBuilder(paramInt2)).append(paramArrayOfchar, paramInt1, paramInt2);
/*  479 */     substitute(strBuilder, 0, paramInt2);
/*  480 */     return strBuilder.toString();
/*      */   }
/*      */ 
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
/*  493 */     if (paramStringBuffer == null) {
/*  494 */       return null;
/*      */     }
/*  496 */     StrBuilder strBuilder = (new StrBuilder(paramStringBuffer.length())).append(paramStringBuffer);
/*  497 */     substitute(strBuilder, 0, strBuilder.length());
/*  498 */     return strBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  515 */     if (paramStringBuffer == null) {
/*  516 */       return null;
/*      */     }
/*  518 */     StrBuilder strBuilder = (new StrBuilder(paramInt2)).append(paramStringBuffer, paramInt1, paramInt2);
/*  519 */     substitute(strBuilder, 0, paramInt2);
/*  520 */     return strBuilder.toString();
/*      */   }
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
/*  532 */     if (paramCharSequence == null) {
/*  533 */       return null;
/*      */     }
/*  535 */     return replace(paramCharSequence, 0, paramCharSequence.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  552 */     if (paramCharSequence == null) {
/*  553 */       return null;
/*      */     }
/*  555 */     StrBuilder strBuilder = (new StrBuilder(paramInt2)).append(paramCharSequence, paramInt1, paramInt2);
/*  556 */     substitute(strBuilder, 0, paramInt2);
/*  557 */     return strBuilder.toString();
/*      */   }
/*      */ 
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
/*  570 */     if (paramStrBuilder == null) {
/*  571 */       return null;
/*      */     }
/*  573 */     StrBuilder strBuilder = (new StrBuilder(paramStrBuilder.length())).append(paramStrBuilder);
/*  574 */     substitute(strBuilder, 0, strBuilder.length());
/*  575 */     return strBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  592 */     if (paramStrBuilder == null) {
/*  593 */       return null;
/*      */     }
/*  595 */     StrBuilder strBuilder = (new StrBuilder(paramInt2)).append(paramStrBuilder, paramInt1, paramInt2);
/*  596 */     substitute(strBuilder, 0, paramInt2);
/*  597 */     return strBuilder.toString();
/*      */   }
/*      */ 
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
/*  610 */     if (paramObject == null) {
/*  611 */       return null;
/*      */     }
/*  613 */     StrBuilder strBuilder = (new StrBuilder()).append(paramObject);
/*  614 */     substitute(strBuilder, 0, strBuilder.length());
/*  615 */     return strBuilder.toString();
/*      */   }
/*      */ 
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
/*  628 */     if (paramStringBuffer == null) {
/*  629 */       return false;
/*      */     }
/*  631 */     return replaceIn(paramStringBuffer, 0, paramStringBuffer.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  648 */     if (paramStringBuffer == null) {
/*  649 */       return false;
/*      */     }
/*  651 */     StrBuilder strBuilder = (new StrBuilder(paramInt2)).append(paramStringBuffer, paramInt1, paramInt2);
/*  652 */     if (!substitute(strBuilder, 0, paramInt2)) {
/*  653 */       return false;
/*      */     }
/*  655 */     paramStringBuffer.replace(paramInt1, paramInt1 + paramInt2, strBuilder.toString());
/*  656 */     return true;
/*      */   }
/*      */ 
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
/*  669 */     if (paramStringBuilder == null) {
/*  670 */       return false;
/*      */     }
/*  672 */     return replaceIn(paramStringBuilder, 0, paramStringBuilder.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  689 */     if (paramStringBuilder == null) {
/*  690 */       return false;
/*      */     }
/*  692 */     StrBuilder strBuilder = (new StrBuilder(paramInt2)).append(paramStringBuilder, paramInt1, paramInt2);
/*  693 */     if (!substitute(strBuilder, 0, paramInt2)) {
/*  694 */       return false;
/*      */     }
/*  696 */     paramStringBuilder.replace(paramInt1, paramInt1 + paramInt2, strBuilder.toString());
/*  697 */     return true;
/*      */   }
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
/*  709 */     if (paramStrBuilder == null) {
/*  710 */       return false;
/*      */     }
/*  712 */     return substitute(paramStrBuilder, 0, paramStrBuilder.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  728 */     if (paramStrBuilder == null) {
/*  729 */       return false;
/*      */     }
/*  731 */     return substitute(paramStrBuilder, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  750 */     return (substitute(paramStrBuilder, paramInt1, paramInt2, null) > 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  766 */     StrMatcher strMatcher1 = getVariablePrefixMatcher();
/*  767 */     StrMatcher strMatcher2 = getVariableSuffixMatcher();
/*  768 */     char c = getEscapeChar();
/*  769 */     StrMatcher strMatcher3 = getValueDelimiterMatcher();
/*  770 */     boolean bool1 = isEnableSubstitutionInVariables();
/*  771 */     boolean bool2 = isDisableSubstitutionInValues();
/*      */     
/*  773 */     boolean bool3 = (paramList == null) ? true : false;
/*  774 */     boolean bool4 = false;
/*  775 */     int i = 0;
/*  776 */     char[] arrayOfChar = paramStrBuilder.buffer;
/*  777 */     int j = paramInt1 + paramInt2;
/*  778 */     int k = paramInt1;
/*  779 */     while (k < j) {
/*  780 */       int m = strMatcher1.isMatch(arrayOfChar, k, paramInt1, j);
/*      */       
/*  782 */       if (m == 0) {
/*  783 */         k++;
/*      */         continue;
/*      */       } 
/*  786 */       if (k > paramInt1 && arrayOfChar[k - 1] == c) {
/*      */         
/*  788 */         if (this.preserveEscapes) {
/*  789 */           k++;
/*      */           continue;
/*      */         } 
/*  792 */         paramStrBuilder.deleteCharAt(k - 1);
/*  793 */         arrayOfChar = paramStrBuilder.buffer;
/*  794 */         i--;
/*  795 */         bool4 = true;
/*  796 */         j--;
/*      */         continue;
/*      */       } 
/*  799 */       int n = k;
/*  800 */       k += m;
/*  801 */       int i1 = 0;
/*  802 */       byte b = 0;
/*  803 */       while (k < j) {
/*  804 */         if (bool1 && strMatcher1
/*  805 */           .isMatch(arrayOfChar, k, paramInt1, j) != 0) {
/*      */ 
/*      */           
/*  808 */           i1 = strMatcher1.isMatch(arrayOfChar, k, paramInt1, j);
/*      */           
/*  810 */           b++;
/*  811 */           k += i1;
/*      */           
/*      */           continue;
/*      */         } 
/*  815 */         i1 = strMatcher2.isMatch(arrayOfChar, k, paramInt1, j);
/*      */         
/*  817 */         if (i1 == 0) {
/*  818 */           k++;
/*      */           continue;
/*      */         } 
/*  821 */         if (b == 0) {
/*  822 */           String str1 = new String(arrayOfChar, n + m, k - n - m);
/*      */ 
/*      */           
/*  825 */           if (bool1) {
/*  826 */             StrBuilder strBuilder = new StrBuilder(str1);
/*  827 */             substitute(strBuilder, 0, strBuilder.length());
/*  828 */             str1 = strBuilder.toString();
/*      */           } 
/*  830 */           k += i1;
/*  831 */           int i2 = k;
/*      */           
/*  833 */           String str2 = str1;
/*  834 */           String str3 = null;
/*      */           
/*  836 */           if (strMatcher3 != null) {
/*  837 */             char[] arrayOfChar1 = str1.toCharArray();
/*  838 */             int i3 = 0;
/*  839 */             for (byte b1 = 0; b1 < arrayOfChar1.length; b1++) {
/*      */ 
/*      */               
/*  842 */               if (!bool1 && strMatcher1
/*  843 */                 .isMatch(arrayOfChar1, b1, b1, arrayOfChar1.length) != 0) {
/*      */                 break;
/*      */               }
/*      */ 
/*      */ 
/*      */               
/*  849 */               if (strMatcher3.isMatch(arrayOfChar1, b1) != 0) {
/*  850 */                 i3 = strMatcher3.isMatch(arrayOfChar1, b1);
/*  851 */                 str2 = str1.substring(0, b1);
/*  852 */                 str3 = str1.substring(b1 + i3);
/*      */                 
/*      */                 break;
/*      */               } 
/*      */             } 
/*      */           } 
/*      */           
/*  859 */           if (paramList == null) {
/*  860 */             paramList = new ArrayList<>();
/*  861 */             paramList.add(new String(arrayOfChar, paramInt1, paramInt2));
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/*  866 */           checkCyclicSubstitution(str2, paramList);
/*  867 */           paramList.add(str2);
/*      */ 
/*      */           
/*  870 */           String str4 = resolveVariable(str2, paramStrBuilder, n, i2);
/*      */           
/*  872 */           if (str4 == null) {
/*  873 */             str4 = str3;
/*      */           }
/*  875 */           if (str4 != null) {
/*  876 */             int i3 = str4.length();
/*  877 */             paramStrBuilder.replace(n, i2, str4);
/*  878 */             bool4 = true;
/*  879 */             int i4 = 0;
/*  880 */             if (!bool2) {
/*  881 */               i4 = substitute(paramStrBuilder, n, i3, paramList);
/*      */             }
/*      */             
/*  884 */             i4 = i4 + i3 - i2 - n;
/*      */             
/*  886 */             k += i4;
/*  887 */             j += i4;
/*  888 */             i += i4;
/*  889 */             arrayOfChar = paramStrBuilder.buffer;
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/*  894 */           paramList
/*  895 */             .remove(paramList.size() - 1);
/*      */           break;
/*      */         } 
/*  898 */         b--;
/*  899 */         k += i1;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  905 */     if (bool3) {
/*  906 */       return bool4 ? 1 : 0;
/*      */     }
/*  908 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void checkCyclicSubstitution(String paramString, List<String> paramList) {
/*  918 */     if (!paramList.contains(paramString)) {
/*      */       return;
/*      */     }
/*  921 */     StrBuilder strBuilder = new StrBuilder(256);
/*  922 */     strBuilder.append("Infinite loop in property interpolation of ");
/*  923 */     strBuilder.append(paramList.remove(0));
/*  924 */     strBuilder.append(": ");
/*  925 */     strBuilder.appendWithSeparators(paramList, "->");
/*  926 */     throw new IllegalStateException(strBuilder.toString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  950 */     StrLookup<?> strLookup = getVariableResolver();
/*  951 */     if (strLookup == null) {
/*  952 */       return null;
/*      */     }
/*  954 */     return strLookup.lookup(paramString);
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
/*  965 */     return this.escapeChar;
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
/*  976 */     this.escapeChar = paramChar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/*  991 */     return this.prefixMatcher;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 1006 */     Validate.isTrue((paramStrMatcher != null), "Variable prefix matcher must not be null!", new Object[0]);
/* 1007 */     this.prefixMatcher = paramStrMatcher;
/* 1008 */     return this;
/*      */   }
/*      */ 
/*      */ 
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
/* 1022 */     return setVariablePrefixMatcher(StrMatcher.charMatcher(paramChar));
/*      */   }
/*      */ 
/*      */ 
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
/* 1036 */     Validate.isTrue((paramString != null), "Variable prefix must not be null!", new Object[0]);
/* 1037 */     return setVariablePrefixMatcher(StrMatcher.stringMatcher(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 1052 */     return this.suffixMatcher;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 1067 */     Validate.isTrue((paramStrMatcher != null), "Variable suffix matcher must not be null!", new Object[0]);
/* 1068 */     this.suffixMatcher = paramStrMatcher;
/* 1069 */     return this;
/*      */   }
/*      */ 
/*      */ 
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
/* 1083 */     return setVariableSuffixMatcher(StrMatcher.charMatcher(paramChar));
/*      */   }
/*      */ 
/*      */ 
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
/* 1097 */     Validate.isTrue((paramString != null), "Variable suffix must not be null!", new Object[0]);
/* 1098 */     return setVariableSuffixMatcher(StrMatcher.stringMatcher(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1115 */     return this.valueDelimiterMatcher;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1132 */     this.valueDelimiterMatcher = paramStrMatcher;
/* 1133 */     return this;
/*      */   }
/*      */ 
/*      */ 
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
/* 1147 */     return setValueDelimiterMatcher(StrMatcher.charMatcher(paramChar));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1164 */     if (paramString == null || paramString.length() == 0) {
/* 1165 */       setValueDelimiterMatcher(null);
/* 1166 */       return this;
/*      */     } 
/* 1168 */     return setValueDelimiterMatcher(StrMatcher.stringMatcher(paramString));
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
/* 1179 */     return this.variableResolver;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVariableResolver(StrLookup<?> paramStrLookup) {
/* 1188 */     this.variableResolver = paramStrLookup;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEnableSubstitutionInVariables() {
/* 1199 */     return this.enableSubstitutionInVariables;
/*      */   }
/*      */ 
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
/* 1212 */     this.enableSubstitutionInVariables = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDisableSubstitutionInValues() {
/* 1237 */     return this.disableSubstitutionInValues;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisableSubstitutionInValues(boolean paramBoolean) {
/* 1248 */     this.disableSubstitutionInValues = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPreserveEscapes() {
/* 1258 */     return this.preserveEscapes;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 1273 */     this.preserveEscapes = paramBoolean;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\StrSubstitutor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */