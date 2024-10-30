/*     */ package org.apache.commons.text.matcher;
/*     */ 
/*     */ import org.apache.commons.lang3.ArrayUtils;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class StringMatcherFactory
/*     */ {
/*  33 */   private static final AbstractStringMatcher.CharMatcher COMMA_MATCHER = new AbstractStringMatcher.CharMatcher(',');
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  38 */   private static final AbstractStringMatcher.CharMatcher DOUBLE_QUOTE_MATCHER = new AbstractStringMatcher.CharMatcher('"');
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  44 */   public static final StringMatcherFactory INSTANCE = new StringMatcherFactory();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   private static final AbstractStringMatcher.NoneMatcher NONE_MATCHER = new AbstractStringMatcher.NoneMatcher();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  54 */   private static final AbstractStringMatcher.CharSetMatcher QUOTE_MATCHER = new AbstractStringMatcher.CharSetMatcher("'\""
/*  55 */       .toCharArray());
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  60 */   private static final AbstractStringMatcher.CharMatcher SINGLE_QUOTE_MATCHER = new AbstractStringMatcher.CharMatcher('\'');
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  66 */   private static final AbstractStringMatcher.CharMatcher SPACE_MATCHER = new AbstractStringMatcher.CharMatcher(' ');
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   private static final AbstractStringMatcher.CharSetMatcher SPLIT_MATCHER = new AbstractStringMatcher.CharSetMatcher(" \t\n\r\f"
/*  72 */       .toCharArray());
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  77 */   private static final AbstractStringMatcher.CharMatcher TAB_MATCHER = new AbstractStringMatcher.CharMatcher('\t');
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  82 */   private static final AbstractStringMatcher.TrimMatcher TRIM_MATCHER = new AbstractStringMatcher.TrimMatcher();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringMatcher andMatcher(StringMatcher... paramVarArgs) {
/*  99 */     int i = ArrayUtils.getLength(paramVarArgs);
/* 100 */     if (i == 0) {
/* 101 */       return NONE_MATCHER;
/*     */     }
/* 103 */     if (i == 1) {
/* 104 */       return paramVarArgs[0];
/*     */     }
/* 106 */     return new AbstractStringMatcher.AndStringMatcher(paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringMatcher charMatcher(char paramChar) {
/* 116 */     return new AbstractStringMatcher.CharMatcher(paramChar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringMatcher charSetMatcher(char... paramVarArgs) {
/* 126 */     int i = ArrayUtils.getLength(paramVarArgs);
/* 127 */     if (i == 0) {
/* 128 */       return NONE_MATCHER;
/*     */     }
/* 130 */     if (i == 1) {
/* 131 */       return new AbstractStringMatcher.CharMatcher(paramVarArgs[0]);
/*     */     }
/* 133 */     return new AbstractStringMatcher.CharSetMatcher(paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringMatcher charSetMatcher(String paramString) {
/* 143 */     int i = StringUtils.length(paramString);
/* 144 */     if (i == 0) {
/* 145 */       return NONE_MATCHER;
/*     */     }
/* 147 */     if (i == 1) {
/* 148 */       return new AbstractStringMatcher.CharMatcher(paramString.charAt(0));
/*     */     }
/* 150 */     return new AbstractStringMatcher.CharSetMatcher(paramString.toCharArray());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringMatcher commaMatcher() {
/* 159 */     return COMMA_MATCHER;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringMatcher doubleQuoteMatcher() {
/* 168 */     return DOUBLE_QUOTE_MATCHER;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringMatcher noneMatcher() {
/* 177 */     return NONE_MATCHER;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringMatcher quoteMatcher() {
/* 186 */     return QUOTE_MATCHER;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringMatcher singleQuoteMatcher() {
/* 195 */     return SINGLE_QUOTE_MATCHER;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringMatcher spaceMatcher() {
/* 204 */     return SPACE_MATCHER;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringMatcher splitMatcher() {
/* 213 */     return SPLIT_MATCHER;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringMatcher stringMatcher(char... paramVarArgs) {
/* 224 */     int i = ArrayUtils.getLength(paramVarArgs);
/* 225 */     return (i == 0) ? NONE_MATCHER : ((i == 1) ? new AbstractStringMatcher.CharMatcher(paramVarArgs[0]) : new AbstractStringMatcher.CharArrayMatcher(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringMatcher stringMatcher(String paramString) {
/* 237 */     return StringUtils.isEmpty(paramString) ? NONE_MATCHER : stringMatcher(paramString.toCharArray());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringMatcher tabMatcher() {
/* 246 */     return TAB_MATCHER;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringMatcher trimMatcher() {
/* 255 */     return TRIM_MATCHER;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\matcher\StringMatcherFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */