/*      */ package org.apache.commons.text;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Enumeration;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Objects;
/*      */ import java.util.Properties;
/*      */ import org.apache.commons.lang3.Validate;
/*      */ import org.apache.commons.text.lookup.StringLookup;
/*      */ import org.apache.commons.text.lookup.StringLookupFactory;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class StringSubstitutor
/*      */ {
/*      */   public static final char DEFAULT_ESCAPE = '$';
/*      */   public static final String DEFAULT_VAR_DEFAULT = ":-";
/*      */   public static final String DEFAULT_VAR_END = "}";
/*      */   public static final String DEFAULT_VAR_START = "${";
/*      */   
/*      */   private static final class Result
/*      */   {
/*      */     public final boolean altered;
/*      */     public final int lengthChange;
/*      */     
/*      */     private Result(boolean param1Boolean, int param1Int) {
/*  235 */       this.altered = param1Boolean;
/*  236 */       this.lengthChange = param1Int;
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/*  241 */       return "Result [altered=" + this.altered + ", lengthChange=" + this.lengthChange + "]";
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  274 */   public static final StringMatcher DEFAULT_PREFIX = StringMatcherFactory.INSTANCE.stringMatcher("${");
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  279 */   public static final StringMatcher DEFAULT_SUFFIX = StringMatcherFactory.INSTANCE.stringMatcher("}");
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  284 */   public static final StringMatcher DEFAULT_VALUE_DELIMITER = StringMatcherFactory.INSTANCE
/*  285 */     .stringMatcher(":-");
/*      */   
/*      */   private boolean disableSubstitutionInValues;
/*      */   
/*      */   private boolean enableSubstitutionInVariables;
/*      */   
/*      */   private boolean enableUndefinedVariableException;
/*      */   
/*      */   private char escapeChar;
/*      */   
/*      */   private StringMatcher prefixMatcher;
/*      */   
/*      */   private boolean preserveEscapes;
/*      */   
/*      */   private StringMatcher suffixMatcher;
/*      */   private StringMatcher valueDelimiterMatcher;
/*      */   private StringLookup variableResolver;
/*      */   
/*      */   public static StringSubstitutor createInterpolator() {
/*  304 */     return new StringSubstitutor(StringLookupFactory.INSTANCE.interpolatorStringLookup());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <V> String replace(Object paramObject, Map<String, V> paramMap) {
/*  317 */     return (new StringSubstitutor(paramMap)).replace(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  335 */     return (new StringSubstitutor(paramMap, paramString1, paramString2)).replace(paramObject);
/*      */   }
/*      */ 
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
/*  348 */     if (paramProperties == null) {
/*  349 */       return paramObject.toString();
/*      */     }
/*  351 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  352 */     Enumeration<?> enumeration = paramProperties.propertyNames();
/*  353 */     while (enumeration.hasMoreElements()) {
/*  354 */       String str1 = (String)enumeration.nextElement();
/*  355 */       String str2 = paramProperties.getProperty(str1);
/*  356 */       hashMap.put(str1, str2);
/*      */     } 
/*  358 */     return replace(paramObject, (Map)hashMap);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String replaceSystemProperties(Object paramObject) {
/*  370 */     return (new StringSubstitutor(StringLookupFactory.INSTANCE.systemPropertyStringLookup())).replace(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringSubstitutor() {
/*  422 */     this((StringLookup)null, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <V> StringSubstitutor(Map<String, V> paramMap) {
/*  433 */     this(StringLookupFactory.INSTANCE.mapStringLookup(paramMap), DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <V> StringSubstitutor(Map<String, V> paramMap, String paramString1, String paramString2) {
/*  446 */     this(StringLookupFactory.INSTANCE.mapStringLookup(paramMap), paramString1, paramString2, '$');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <V> StringSubstitutor(Map<String, V> paramMap, String paramString1, String paramString2, char paramChar) {
/*  461 */     this(StringLookupFactory.INSTANCE.mapStringLookup(paramMap), paramString1, paramString2, paramChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <V> StringSubstitutor(Map<String, V> paramMap, String paramString1, String paramString2, char paramChar, String paramString3) {
/*  477 */     this(StringLookupFactory.INSTANCE.mapStringLookup(paramMap), paramString1, paramString2, paramChar, paramString3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringSubstitutor(StringLookup paramStringLookup) {
/*  486 */     this(paramStringLookup, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringSubstitutor(StringLookup paramStringLookup, String paramString1, String paramString2, char paramChar) {
/*  500 */     setVariableResolver(paramStringLookup);
/*  501 */     setVariablePrefix(paramString1);
/*  502 */     setVariableSuffix(paramString2);
/*  503 */     setEscapeChar(paramChar);
/*  504 */     setValueDelimiterMatcher(DEFAULT_VALUE_DELIMITER);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringSubstitutor(StringLookup paramStringLookup, String paramString1, String paramString2, char paramChar, String paramString3) {
/*  519 */     setVariableResolver(paramStringLookup);
/*  520 */     setVariablePrefix(paramString1);
/*  521 */     setVariableSuffix(paramString2);
/*  522 */     setEscapeChar(paramChar);
/*  523 */     setValueDelimiter(paramString3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringSubstitutor(StringLookup paramStringLookup, StringMatcher paramStringMatcher1, StringMatcher paramStringMatcher2, char paramChar) {
/*  537 */     this(paramStringLookup, paramStringMatcher1, paramStringMatcher2, paramChar, DEFAULT_VALUE_DELIMITER);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringSubstitutor(StringLookup paramStringLookup, StringMatcher paramStringMatcher1, StringMatcher paramStringMatcher2, char paramChar, StringMatcher paramStringMatcher3) {
/*  552 */     setVariableResolver(paramStringLookup);
/*  553 */     setVariablePrefixMatcher(paramStringMatcher1);
/*  554 */     setVariableSuffixMatcher(paramStringMatcher2);
/*  555 */     setEscapeChar(paramChar);
/*  556 */     setValueDelimiterMatcher(paramStringMatcher3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringSubstitutor(StringSubstitutor paramStringSubstitutor) {
/*  566 */     this.disableSubstitutionInValues = paramStringSubstitutor.isDisableSubstitutionInValues();
/*  567 */     this.enableSubstitutionInVariables = paramStringSubstitutor.isEnableSubstitutionInVariables();
/*  568 */     this.enableUndefinedVariableException = paramStringSubstitutor.isEnableUndefinedVariableException();
/*  569 */     this.escapeChar = paramStringSubstitutor.getEscapeChar();
/*  570 */     this.prefixMatcher = paramStringSubstitutor.getVariablePrefixMatcher();
/*  571 */     this.preserveEscapes = paramStringSubstitutor.isPreserveEscapes();
/*  572 */     this.suffixMatcher = paramStringSubstitutor.getVariableSuffixMatcher();
/*  573 */     this.valueDelimiterMatcher = paramStringSubstitutor.getValueDelimiterMatcher();
/*  574 */     this.variableResolver = paramStringSubstitutor.getStringLookup();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void checkCyclicSubstitution(String paramString, List<String> paramList) {
/*  584 */     if (!paramList.contains(paramString)) {
/*      */       return;
/*      */     }
/*  587 */     TextStringBuilder textStringBuilder = new TextStringBuilder(256);
/*  588 */     textStringBuilder.append("Infinite loop in property interpolation of ");
/*  589 */     textStringBuilder.append(paramList.remove(0));
/*  590 */     textStringBuilder.append(": ");
/*  591 */     textStringBuilder.appendWithSeparators(paramList, "->");
/*  592 */     throw new IllegalStateException(textStringBuilder.toString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public char getEscapeChar() {
/*  602 */     return this.escapeChar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringLookup getStringLookup() {
/*  611 */     return this.variableResolver;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringMatcher getValueDelimiterMatcher() {
/*  627 */     return this.valueDelimiterMatcher;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringMatcher getVariablePrefixMatcher() {
/*  640 */     return this.prefixMatcher;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringMatcher getVariableSuffixMatcher() {
/*  653 */     return this.suffixMatcher;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  678 */     return this.disableSubstitutionInValues;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEnableSubstitutionInVariables() {
/*  687 */     return this.enableSubstitutionInVariables;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEnableUndefinedVariableException() {
/*  696 */     return this.enableUndefinedVariableException;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPreserveEscapes() {
/*  705 */     return this.preserveEscapes;
/*      */   }
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
/*  717 */     if (paramArrayOfchar == null) {
/*  718 */       return null;
/*      */     }
/*  720 */     TextStringBuilder textStringBuilder = (new TextStringBuilder(paramArrayOfchar.length)).append(paramArrayOfchar);
/*  721 */     substitute(textStringBuilder, 0, paramArrayOfchar.length);
/*  722 */     return textStringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  740 */     if (paramArrayOfchar == null) {
/*  741 */       return null;
/*      */     }
/*  743 */     TextStringBuilder textStringBuilder = (new TextStringBuilder(paramInt2)).append(paramArrayOfchar, paramInt1, paramInt2);
/*  744 */     substitute(textStringBuilder, 0, paramInt2);
/*  745 */     return textStringBuilder.toString();
/*      */   }
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
/*  757 */     if (paramCharSequence == null) {
/*  758 */       return null;
/*      */     }
/*  760 */     return replace(paramCharSequence, 0, paramCharSequence.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  778 */     if (paramCharSequence == null) {
/*  779 */       return null;
/*      */     }
/*  781 */     TextStringBuilder textStringBuilder = (new TextStringBuilder(paramInt2)).append(paramCharSequence.toString(), paramInt1, paramInt2);
/*  782 */     substitute(textStringBuilder, 0, paramInt2);
/*  783 */     return textStringBuilder.toString();
/*      */   }
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
/*  795 */     if (paramObject == null) {
/*  796 */       return null;
/*      */     }
/*  798 */     TextStringBuilder textStringBuilder = (new TextStringBuilder()).append(paramObject);
/*  799 */     substitute(textStringBuilder, 0, textStringBuilder.length());
/*  800 */     return textStringBuilder.toString();
/*      */   }
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
/*  812 */     if (paramString == null) {
/*  813 */       return null;
/*      */     }
/*  815 */     TextStringBuilder textStringBuilder = new TextStringBuilder(paramString);
/*  816 */     if (!substitute(textStringBuilder, 0, paramString.length())) {
/*  817 */       return paramString;
/*      */     }
/*  819 */     return textStringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  837 */     if (paramString == null) {
/*  838 */       return null;
/*      */     }
/*  840 */     TextStringBuilder textStringBuilder = (new TextStringBuilder(paramInt2)).append(paramString, paramInt1, paramInt2);
/*  841 */     if (!substitute(textStringBuilder, 0, paramInt2)) {
/*  842 */       return paramString.substring(paramInt1, paramInt1 + paramInt2);
/*      */     }
/*  844 */     return textStringBuilder.toString();
/*      */   }
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
/*  856 */     if (paramStringBuffer == null) {
/*  857 */       return null;
/*      */     }
/*  859 */     TextStringBuilder textStringBuilder = (new TextStringBuilder(paramStringBuffer.length())).append(paramStringBuffer);
/*  860 */     substitute(textStringBuilder, 0, textStringBuilder.length());
/*  861 */     return textStringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  879 */     if (paramStringBuffer == null) {
/*  880 */       return null;
/*      */     }
/*  882 */     TextStringBuilder textStringBuilder = (new TextStringBuilder(paramInt2)).append(paramStringBuffer, paramInt1, paramInt2);
/*  883 */     substitute(textStringBuilder, 0, paramInt2);
/*  884 */     return textStringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String replace(TextStringBuilder paramTextStringBuilder) {
/*  896 */     if (paramTextStringBuilder == null) {
/*  897 */       return null;
/*      */     }
/*  899 */     TextStringBuilder textStringBuilder = (new TextStringBuilder(paramTextStringBuilder.length())).append(paramTextStringBuilder);
/*  900 */     substitute(textStringBuilder, 0, textStringBuilder.length());
/*  901 */     return textStringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String replace(TextStringBuilder paramTextStringBuilder, int paramInt1, int paramInt2) {
/*  919 */     if (paramTextStringBuilder == null) {
/*  920 */       return null;
/*      */     }
/*  922 */     TextStringBuilder textStringBuilder = (new TextStringBuilder(paramInt2)).append(paramTextStringBuilder, paramInt1, paramInt2);
/*  923 */     substitute(textStringBuilder, 0, paramInt2);
/*  924 */     return textStringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean replaceIn(StringBuffer paramStringBuffer) {
/*  935 */     if (paramStringBuffer == null) {
/*  936 */       return false;
/*      */     }
/*  938 */     return replaceIn(paramStringBuffer, 0, paramStringBuffer.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  956 */     if (paramStringBuffer == null) {
/*  957 */       return false;
/*      */     }
/*  959 */     TextStringBuilder textStringBuilder = (new TextStringBuilder(paramInt2)).append(paramStringBuffer, paramInt1, paramInt2);
/*  960 */     if (!substitute(textStringBuilder, 0, paramInt2)) {
/*  961 */       return false;
/*      */     }
/*  963 */     paramStringBuffer.replace(paramInt1, paramInt1 + paramInt2, textStringBuilder.toString());
/*  964 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean replaceIn(StringBuilder paramStringBuilder) {
/*  975 */     if (paramStringBuilder == null) {
/*  976 */       return false;
/*      */     }
/*  978 */     return replaceIn(paramStringBuilder, 0, paramStringBuilder.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  996 */     if (paramStringBuilder == null) {
/*  997 */       return false;
/*      */     }
/*  999 */     TextStringBuilder textStringBuilder = (new TextStringBuilder(paramInt2)).append(paramStringBuilder, paramInt1, paramInt2);
/* 1000 */     if (!substitute(textStringBuilder, 0, paramInt2)) {
/* 1001 */       return false;
/*      */     }
/* 1003 */     paramStringBuilder.replace(paramInt1, paramInt1 + paramInt2, textStringBuilder.toString());
/* 1004 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean replaceIn(TextStringBuilder paramTextStringBuilder) {
/* 1016 */     if (paramTextStringBuilder == null) {
/* 1017 */       return false;
/*      */     }
/* 1019 */     return substitute(paramTextStringBuilder, 0, paramTextStringBuilder.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean replaceIn(TextStringBuilder paramTextStringBuilder, int paramInt1, int paramInt2) {
/* 1037 */     if (paramTextStringBuilder == null) {
/* 1038 */       return false;
/*      */     }
/* 1040 */     return substitute(paramTextStringBuilder, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String resolveVariable(String paramString, TextStringBuilder paramTextStringBuilder, int paramInt1, int paramInt2) {
/* 1063 */     StringLookup stringLookup = getStringLookup();
/* 1064 */     if (stringLookup == null) {
/* 1065 */       return null;
/*      */     }
/* 1067 */     return stringLookup.lookup(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringSubstitutor setDisableSubstitutionInValues(boolean paramBoolean) {
/* 1077 */     this.disableSubstitutionInValues = paramBoolean;
/* 1078 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringSubstitutor setEnableSubstitutionInVariables(boolean paramBoolean) {
/* 1090 */     this.enableSubstitutionInVariables = paramBoolean;
/* 1091 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringSubstitutor setEnableUndefinedVariableException(boolean paramBoolean) {
/* 1101 */     this.enableUndefinedVariableException = paramBoolean;
/* 1102 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringSubstitutor setEscapeChar(char paramChar) {
/* 1113 */     this.escapeChar = paramChar;
/* 1114 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringSubstitutor setPreserveEscapes(boolean paramBoolean) {
/* 1127 */     this.preserveEscapes = paramBoolean;
/* 1128 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringSubstitutor setValueDelimiter(char paramChar) {
/* 1142 */     return setValueDelimiterMatcher(StringMatcherFactory.INSTANCE.charMatcher(paramChar));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringSubstitutor setValueDelimiter(String paramString) {
/* 1160 */     if (paramString == null || paramString.length() == 0) {
/* 1161 */       setValueDelimiterMatcher(null);
/* 1162 */       return this;
/*      */     } 
/* 1164 */     return setValueDelimiterMatcher(StringMatcherFactory.INSTANCE.stringMatcher(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringSubstitutor setValueDelimiterMatcher(StringMatcher paramStringMatcher) {
/* 1182 */     this.valueDelimiterMatcher = paramStringMatcher;
/* 1183 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringSubstitutor setVariablePrefix(char paramChar) {
/* 1197 */     return setVariablePrefixMatcher(StringMatcherFactory.INSTANCE.charMatcher(paramChar));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringSubstitutor setVariablePrefix(String paramString) {
/* 1212 */     Validate.isTrue((paramString != null), "Variable prefix must not be null!", new Object[0]);
/* 1213 */     return setVariablePrefixMatcher(StringMatcherFactory.INSTANCE.stringMatcher(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringSubstitutor setVariablePrefixMatcher(StringMatcher paramStringMatcher) {
/* 1228 */     Validate.isTrue((paramStringMatcher != null), "Variable prefix matcher must not be null!", new Object[0]);
/* 1229 */     this.prefixMatcher = paramStringMatcher;
/* 1230 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringSubstitutor setVariableResolver(StringLookup paramStringLookup) {
/* 1240 */     this.variableResolver = paramStringLookup;
/* 1241 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringSubstitutor setVariableSuffix(char paramChar) {
/* 1255 */     return setVariableSuffixMatcher(StringMatcherFactory.INSTANCE.charMatcher(paramChar));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringSubstitutor setVariableSuffix(String paramString) {
/* 1270 */     Validate.isTrue((paramString != null), "Variable suffix must not be null!", new Object[0]);
/* 1271 */     return setVariableSuffixMatcher(StringMatcherFactory.INSTANCE.stringMatcher(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringSubstitutor setVariableSuffixMatcher(StringMatcher paramStringMatcher) {
/* 1286 */     Validate.isTrue((paramStringMatcher != null), "Variable suffix matcher must not be null!", new Object[0]);
/* 1287 */     this.suffixMatcher = paramStringMatcher;
/* 1288 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean substitute(TextStringBuilder paramTextStringBuilder, int paramInt1, int paramInt2) {
/* 1308 */     return (substitute(paramTextStringBuilder, paramInt1, paramInt2, null)).altered;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Result substitute(TextStringBuilder paramTextStringBuilder, int paramInt1, int paramInt2, List<String> paramList) {
/* 1325 */     Objects.requireNonNull(paramTextStringBuilder, "builder");
/* 1326 */     StringMatcher stringMatcher1 = getVariablePrefixMatcher();
/* 1327 */     StringMatcher stringMatcher2 = getVariableSuffixMatcher();
/* 1328 */     char c = getEscapeChar();
/* 1329 */     StringMatcher stringMatcher3 = getValueDelimiterMatcher();
/* 1330 */     boolean bool1 = isEnableSubstitutionInVariables();
/* 1331 */     boolean bool2 = isDisableSubstitutionInValues();
/* 1332 */     boolean bool3 = isEnableUndefinedVariableException();
/* 1333 */     boolean bool4 = isPreserveEscapes();
/*      */     
/* 1335 */     boolean bool = false;
/* 1336 */     int i = 0;
/* 1337 */     int j = paramInt1 + paramInt2;
/* 1338 */     int k = paramInt1;
/* 1339 */     int m = -1;
/* 1340 */     while (k < j) {
/* 1341 */       int n = stringMatcher1.isMatch(paramTextStringBuilder, k, paramInt1, j);
/* 1342 */       if (n == 0) {
/* 1343 */         k++;
/*      */         continue;
/*      */       } 
/* 1346 */       if (k > paramInt1 && paramTextStringBuilder.charAt(k - 1) == c) {
/*      */         
/* 1348 */         if (bool4) {
/*      */           
/* 1350 */           k++;
/*      */           
/*      */           continue;
/*      */         } 
/* 1354 */         m = k - 1;
/*      */       } 
/*      */       
/* 1357 */       int i1 = k;
/* 1358 */       k += n;
/* 1359 */       int i2 = 0;
/* 1360 */       byte b = 0;
/* 1361 */       while (k < j) {
/* 1362 */         if (bool1 && stringMatcher1.isMatch(paramTextStringBuilder, k, paramInt1, j) != 0) {
/*      */           
/* 1364 */           i2 = stringMatcher1.isMatch(paramTextStringBuilder, k, paramInt1, j);
/* 1365 */           b++;
/* 1366 */           k += i2;
/*      */           
/*      */           continue;
/*      */         } 
/* 1370 */         i2 = stringMatcher2.isMatch(paramTextStringBuilder, k, paramInt1, j);
/* 1371 */         if (i2 == 0) {
/* 1372 */           k++;
/*      */           continue;
/*      */         } 
/* 1375 */         if (b == 0) {
/* 1376 */           if (m >= 0) {
/*      */             
/* 1378 */             paramTextStringBuilder.deleteCharAt(m);
/* 1379 */             m = -1;
/* 1380 */             i--;
/* 1381 */             bool = true;
/* 1382 */             j--;
/* 1383 */             k = i1 + 1;
/* 1384 */             i1--;
/*      */             
/*      */             break;
/*      */           } 
/* 1388 */           String str1 = paramTextStringBuilder.midString(i1 + n, k - i1 - n);
/*      */           
/* 1390 */           if (bool1) {
/* 1391 */             TextStringBuilder textStringBuilder = new TextStringBuilder(str1);
/* 1392 */             substitute(textStringBuilder, 0, textStringBuilder.length());
/* 1393 */             str1 = textStringBuilder.toString();
/*      */           } 
/* 1395 */           k += i2;
/* 1396 */           int i3 = k;
/*      */           
/* 1398 */           String str2 = str1;
/* 1399 */           String str3 = null;
/*      */           
/* 1401 */           if (stringMatcher3 != null) {
/* 1402 */             char[] arrayOfChar = str1.toCharArray();
/* 1403 */             int i4 = 0;
/* 1404 */             for (byte b1 = 0; b1 < arrayOfChar.length; b1++) {
/*      */ 
/*      */               
/* 1407 */               if (!bool1 && stringMatcher1.isMatch(arrayOfChar, b1, b1, arrayOfChar.length) != 0) {
/*      */                 break;
/*      */               }
/*      */               
/* 1411 */               if (stringMatcher3.isMatch(arrayOfChar, b1, 0, arrayOfChar.length) != 0) {
/*      */                 
/* 1413 */                 i4 = stringMatcher3.isMatch(arrayOfChar, b1, 0, arrayOfChar.length);
/*      */                 
/* 1415 */                 str2 = str1.substring(0, b1);
/* 1416 */                 str3 = str1.substring(b1 + i4);
/*      */                 
/*      */                 break;
/*      */               } 
/*      */             } 
/*      */           } 
/*      */           
/* 1423 */           if (paramList == null) {
/* 1424 */             paramList = new ArrayList<>();
/* 1425 */             paramList.add(paramTextStringBuilder.midString(paramInt1, paramInt2));
/*      */           } 
/*      */ 
/*      */           
/* 1429 */           checkCyclicSubstitution(str2, paramList);
/* 1430 */           paramList.add(str2);
/*      */ 
/*      */           
/* 1433 */           String str4 = resolveVariable(str2, paramTextStringBuilder, i1, i3);
/* 1434 */           if (str4 == null) {
/* 1435 */             str4 = str3;
/*      */           }
/* 1437 */           if (str4 != null) {
/* 1438 */             int i4 = str4.length();
/* 1439 */             paramTextStringBuilder.replace(i1, i3, str4);
/* 1440 */             bool = true;
/* 1441 */             int i5 = 0;
/* 1442 */             if (!bool2) {
/* 1443 */               i5 = (substitute(paramTextStringBuilder, i1, i4, paramList)).lengthChange;
/*      */             }
/* 1445 */             i5 = i5 + i4 - i3 - i1;
/* 1446 */             k += i5;
/* 1447 */             j += i5;
/* 1448 */             i += i5;
/* 1449 */           } else if (bool3) {
/* 1450 */             throw new IllegalArgumentException(
/* 1451 */                 String.format("Cannot resolve variable '%s' (enableSubstitutionInVariables=%s).", new Object[] {
/* 1452 */                     str2, Boolean.valueOf(bool1)
/*      */                   }));
/*      */           } 
/*      */           
/* 1456 */           paramList.remove(paramList.size() - 1);
/*      */           break;
/*      */         } 
/* 1459 */         b--;
/* 1460 */         k += i2;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1465 */     return new Result(bool, i);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\StringSubstitutor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */