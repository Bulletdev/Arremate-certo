/*     */ package org.apache.commons.lang3.text;
/*     */ 
/*     */ import java.text.Format;
/*     */ import java.text.MessageFormat;
/*     */ import java.text.ParsePosition;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import org.apache.commons.lang3.ObjectUtils;
/*     */ import org.apache.commons.lang3.Validate;
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
/*     */ @Deprecated
/*     */ public class ExtendedMessageFormat
/*     */   extends MessageFormat
/*     */ {
/*     */   private static final long serialVersionUID = -2362048321261811743L;
/*     */   private static final int HASH_SEED = 31;
/*     */   private static final String DUMMY_PATTERN = "";
/*     */   private static final char START_FMT = ',';
/*     */   private static final char END_FE = '}';
/*     */   private static final char START_FE = '{';
/*     */   private static final char QUOTE = '\'';
/*     */   private String toPattern;
/*     */   private final Map<String, ? extends FormatFactory> registry;
/*     */   
/*     */   public ExtendedMessageFormat(String paramString) {
/*  93 */     this(paramString, Locale.getDefault());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExtendedMessageFormat(String paramString, Locale paramLocale) {
/* 104 */     this(paramString, paramLocale, (Map<String, ? extends FormatFactory>)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExtendedMessageFormat(String paramString, Map<String, ? extends FormatFactory> paramMap) {
/* 115 */     this(paramString, Locale.getDefault(), paramMap);
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
/*     */   public ExtendedMessageFormat(String paramString, Locale paramLocale, Map<String, ? extends FormatFactory> paramMap) {
/* 127 */     super("");
/* 128 */     setLocale(paramLocale);
/* 129 */     this.registry = paramMap;
/* 130 */     applyPattern(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toPattern() {
/* 138 */     return this.toPattern;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void applyPattern(String paramString) {
/* 148 */     if (this.registry == null) {
/* 149 */       super.applyPattern(paramString);
/* 150 */       this.toPattern = super.toPattern();
/*     */       return;
/*     */     } 
/* 153 */     ArrayList<Format> arrayList = new ArrayList();
/* 154 */     ArrayList<String> arrayList1 = new ArrayList();
/* 155 */     StringBuilder stringBuilder = new StringBuilder(paramString.length());
/*     */     
/* 157 */     ParsePosition parsePosition = new ParsePosition(0);
/* 158 */     char[] arrayOfChar = paramString.toCharArray();
/* 159 */     byte b = 0;
/* 160 */     while (parsePosition.getIndex() < paramString.length()) {
/* 161 */       int i, j; Format format; String str; switch (arrayOfChar[parsePosition.getIndex()]) {
/*     */         case '\'':
/* 163 */           appendQuotedString(paramString, parsePosition, stringBuilder);
/*     */           continue;
/*     */         case '{':
/* 166 */           b++;
/* 167 */           seekNonWs(paramString, parsePosition);
/* 168 */           i = parsePosition.getIndex();
/* 169 */           j = readArgumentIndex(paramString, next(parsePosition));
/* 170 */           stringBuilder.append('{').append(j);
/* 171 */           seekNonWs(paramString, parsePosition);
/* 172 */           format = null;
/* 173 */           str = null;
/* 174 */           if (arrayOfChar[parsePosition.getIndex()] == ',') {
/* 175 */             str = parseFormatDescription(paramString, 
/* 176 */                 next(parsePosition));
/* 177 */             format = getFormat(str);
/* 178 */             if (format == null) {
/* 179 */               stringBuilder.append(',').append(str);
/*     */             }
/*     */           } 
/* 182 */           arrayList.add(format);
/* 183 */           arrayList1.add((format == null) ? null : str);
/* 184 */           Validate.isTrue((arrayList.size() == b));
/* 185 */           Validate.isTrue((arrayList1.size() == b));
/* 186 */           if (arrayOfChar[parsePosition.getIndex()] != '}') {
/* 187 */             throw new IllegalArgumentException("Unreadable format element at position " + i);
/*     */           }
/*     */           break;
/*     */       } 
/*     */       
/* 192 */       stringBuilder.append(arrayOfChar[parsePosition.getIndex()]);
/* 193 */       next(parsePosition);
/*     */     } 
/*     */     
/* 196 */     super.applyPattern(stringBuilder.toString());
/* 197 */     this.toPattern = insertFormats(super.toPattern(), arrayList1);
/* 198 */     if (containsElements(arrayList)) {
/* 199 */       Format[] arrayOfFormat = getFormats();
/*     */ 
/*     */       
/* 202 */       byte b1 = 0;
/* 203 */       for (Format format : arrayList) {
/*     */         
/* 205 */         if (format != null)
/* 206 */           arrayOfFormat[b1] = format; 
/*     */         b1++;
/*     */       } 
/* 209 */       super.setFormats(arrayOfFormat);
/*     */     } 
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
/*     */   public void setFormat(int paramInt, Format paramFormat) {
/* 222 */     throw new UnsupportedOperationException();
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
/*     */   public void setFormatByArgumentIndex(int paramInt, Format paramFormat) {
/* 234 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormats(Format[] paramArrayOfFormat) {
/* 245 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormatsByArgumentIndex(Format[] paramArrayOfFormat) {
/* 256 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 267 */     if (paramObject == this) {
/* 268 */       return true;
/*     */     }
/* 270 */     if (paramObject == null) {
/* 271 */       return false;
/*     */     }
/* 273 */     if (!super.equals(paramObject)) {
/* 274 */       return false;
/*     */     }
/* 276 */     if (ObjectUtils.notEqual(getClass(), paramObject.getClass())) {
/* 277 */       return false;
/*     */     }
/* 279 */     ExtendedMessageFormat extendedMessageFormat = (ExtendedMessageFormat)paramObject;
/* 280 */     if (ObjectUtils.notEqual(this.toPattern, extendedMessageFormat.toPattern)) {
/* 281 */       return false;
/*     */     }
/* 283 */     return !ObjectUtils.notEqual(this.registry, extendedMessageFormat.registry);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 291 */     int i = super.hashCode();
/* 292 */     i = 31 * i + Objects.hashCode(this.registry);
/* 293 */     i = 31 * i + Objects.hashCode(this.toPattern);
/* 294 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Format getFormat(String paramString) {
/* 304 */     if (this.registry != null) {
/* 305 */       String str1 = paramString;
/* 306 */       String str2 = null;
/* 307 */       int i = paramString.indexOf(',');
/* 308 */       if (i > 0) {
/* 309 */         str1 = paramString.substring(0, i).trim();
/* 310 */         str2 = paramString.substring(i + 1).trim();
/*     */       } 
/* 312 */       FormatFactory formatFactory = this.registry.get(str1);
/* 313 */       if (formatFactory != null) {
/* 314 */         return formatFactory.getFormat(str1, str2, getLocale());
/*     */       }
/*     */     } 
/* 317 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int readArgumentIndex(String paramString, ParsePosition paramParsePosition) {
/* 328 */     int i = paramParsePosition.getIndex();
/* 329 */     seekNonWs(paramString, paramParsePosition);
/* 330 */     StringBuilder stringBuilder = new StringBuilder();
/* 331 */     boolean bool = false;
/* 332 */     for (; !bool && paramParsePosition.getIndex() < paramString.length(); next(paramParsePosition)) {
/* 333 */       char c = paramString.charAt(paramParsePosition.getIndex());
/* 334 */       if (Character.isWhitespace(c)) {
/* 335 */         seekNonWs(paramString, paramParsePosition);
/* 336 */         c = paramString.charAt(paramParsePosition.getIndex());
/* 337 */         if (c != ',' && c != '}') {
/* 338 */           bool = true;
/*     */           continue;
/*     */         } 
/*     */       } 
/* 342 */       if ((c == ',' || c == '}') && stringBuilder.length() > 0) {
/*     */         try {
/* 344 */           return Integer.parseInt(stringBuilder.toString());
/* 345 */         } catch (NumberFormatException numberFormatException) {}
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 350 */       bool = !Character.isDigit(c) ? true : false;
/* 351 */       stringBuilder.append(c); continue;
/*     */     } 
/* 353 */     if (bool) {
/* 354 */       throw new IllegalArgumentException("Invalid format argument index at position " + i + ": " + paramString
/*     */           
/* 356 */           .substring(i, paramParsePosition.getIndex()));
/*     */     }
/* 358 */     throw new IllegalArgumentException("Unterminated format element at position " + i);
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
/*     */   private String parseFormatDescription(String paramString, ParsePosition paramParsePosition) {
/* 370 */     int i = paramParsePosition.getIndex();
/* 371 */     seekNonWs(paramString, paramParsePosition);
/* 372 */     int j = paramParsePosition.getIndex();
/* 373 */     byte b = 1;
/* 374 */     for (; paramParsePosition.getIndex() < paramString.length(); next(paramParsePosition)) {
/* 375 */       switch (paramString.charAt(paramParsePosition.getIndex())) {
/*     */         case '{':
/* 377 */           b++;
/*     */           break;
/*     */         case '}':
/* 380 */           b--;
/* 381 */           if (b == 0) {
/* 382 */             return paramString.substring(j, paramParsePosition.getIndex());
/*     */           }
/*     */           break;
/*     */         case '\'':
/* 386 */           getQuotedString(paramString, paramParsePosition);
/*     */           break;
/*     */       } 
/*     */ 
/*     */     
/*     */     } 
/* 392 */     throw new IllegalArgumentException("Unterminated format element at position " + i);
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
/*     */   private String insertFormats(String paramString, ArrayList<String> paramArrayList) {
/* 404 */     if (!containsElements(paramArrayList)) {
/* 405 */       return paramString;
/*     */     }
/* 407 */     StringBuilder stringBuilder = new StringBuilder(paramString.length() * 2);
/* 408 */     ParsePosition parsePosition = new ParsePosition(0);
/* 409 */     byte b = -1;
/* 410 */     byte b1 = 0;
/* 411 */     while (parsePosition.getIndex() < paramString.length()) {
/* 412 */       char c = paramString.charAt(parsePosition.getIndex());
/* 413 */       switch (c) {
/*     */         case '\'':
/* 415 */           appendQuotedString(paramString, parsePosition, stringBuilder);
/*     */           continue;
/*     */         case '{':
/* 418 */           b1++;
/* 419 */           stringBuilder.append('{').append(readArgumentIndex(paramString, next(parsePosition)));
/*     */           
/* 421 */           if (b1 == 1) {
/* 422 */             b++;
/* 423 */             String str = paramArrayList.get(b);
/* 424 */             if (str != null) {
/* 425 */               stringBuilder.append(',').append(str);
/*     */             }
/*     */           } 
/*     */           continue;
/*     */         case '}':
/* 430 */           b1--;
/*     */           break;
/*     */       } 
/* 433 */       stringBuilder.append(c);
/* 434 */       next(parsePosition);
/*     */     } 
/*     */     
/* 437 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void seekNonWs(String paramString, ParsePosition paramParsePosition) {
/* 447 */     int i = 0;
/* 448 */     char[] arrayOfChar = paramString.toCharArray();
/*     */     do {
/* 450 */       i = StrMatcher.splitMatcher().isMatch(arrayOfChar, paramParsePosition.getIndex());
/* 451 */       paramParsePosition.setIndex(paramParsePosition.getIndex() + i);
/* 452 */     } while (i > 0 && paramParsePosition.getIndex() < paramString.length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ParsePosition next(ParsePosition paramParsePosition) {
/* 462 */     paramParsePosition.setIndex(paramParsePosition.getIndex() + 1);
/* 463 */     return paramParsePosition;
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
/*     */ 
/*     */   
/*     */   private StringBuilder appendQuotedString(String paramString, ParsePosition paramParsePosition, StringBuilder paramStringBuilder) {
/* 477 */     assert paramString.toCharArray()[paramParsePosition.getIndex()] == '\'' : "Quoted string must start with quote character";
/*     */ 
/*     */ 
/*     */     
/* 481 */     if (paramStringBuilder != null) {
/* 482 */       paramStringBuilder.append('\'');
/*     */     }
/* 484 */     next(paramParsePosition);
/*     */     
/* 486 */     int i = paramParsePosition.getIndex();
/* 487 */     char[] arrayOfChar = paramString.toCharArray();
/* 488 */     int j = i;
/* 489 */     for (int k = paramParsePosition.getIndex(); k < paramString.length(); k++) {
/* 490 */       if (arrayOfChar[paramParsePosition.getIndex()] == '\'') {
/* 491 */         next(paramParsePosition);
/* 492 */         return (paramStringBuilder == null) ? null : paramStringBuilder.append(arrayOfChar, j, paramParsePosition
/* 493 */             .getIndex() - j);
/*     */       } 
/* 495 */       next(paramParsePosition);
/*     */     } 
/* 497 */     throw new IllegalArgumentException("Unterminated quoted string at position " + i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void getQuotedString(String paramString, ParsePosition paramParsePosition) {
/* 508 */     appendQuotedString(paramString, paramParsePosition, (StringBuilder)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean containsElements(Collection<?> paramCollection) {
/* 517 */     if (paramCollection == null || paramCollection.isEmpty()) {
/* 518 */       return false;
/*     */     }
/* 520 */     for (Object object : paramCollection) {
/* 521 */       if (object != null) {
/* 522 */         return true;
/*     */       }
/*     */     } 
/* 525 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\text\ExtendedMessageFormat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */