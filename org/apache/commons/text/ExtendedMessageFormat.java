/*     */ package org.apache.commons.text;
/*     */ 
/*     */ import java.text.Format;
/*     */ import java.text.MessageFormat;
/*     */ import java.text.ParsePosition;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import org.apache.commons.text.matcher.StringMatcherFactory;
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
/* 124 */     this(paramString, Locale.getDefault(Locale.Category.FORMAT));
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
/* 135 */     this(paramString, paramLocale, (Map<String, ? extends FormatFactory>)null);
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
/*     */   public ExtendedMessageFormat(String paramString, Map<String, ? extends FormatFactory> paramMap) {
/* 147 */     this(paramString, Locale.getDefault(Locale.Category.FORMAT), paramMap);
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
/*     */   public ExtendedMessageFormat(String paramString, Locale paramLocale, Map<String, ? extends FormatFactory> paramMap) {
/* 161 */     super("");
/* 162 */     setLocale(paramLocale);
/* 163 */     this.registry = paramMap;
/* 164 */     applyPattern(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toPattern() {
/* 172 */     return this.toPattern;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void applyPattern(String paramString) {
/* 182 */     if (this.registry == null) {
/* 183 */       super.applyPattern(paramString);
/* 184 */       this.toPattern = super.toPattern();
/*     */       return;
/*     */     } 
/* 187 */     ArrayList<Format> arrayList = new ArrayList();
/* 188 */     ArrayList<String> arrayList1 = new ArrayList();
/* 189 */     StringBuilder stringBuilder = new StringBuilder(paramString.length());
/*     */     
/* 191 */     ParsePosition parsePosition = new ParsePosition(0);
/* 192 */     char[] arrayOfChar = paramString.toCharArray();
/* 193 */     byte b = 0;
/* 194 */     while (parsePosition.getIndex() < paramString.length()) {
/* 195 */       int i, j; Format format; String str; switch (arrayOfChar[parsePosition.getIndex()]) {
/*     */         case '\'':
/* 197 */           appendQuotedString(paramString, parsePosition, stringBuilder);
/*     */           continue;
/*     */         case '{':
/* 200 */           b++;
/* 201 */           seekNonWs(paramString, parsePosition);
/* 202 */           i = parsePosition.getIndex();
/* 203 */           j = readArgumentIndex(paramString, next(parsePosition));
/* 204 */           stringBuilder.append('{').append(j);
/* 205 */           seekNonWs(paramString, parsePosition);
/* 206 */           format = null;
/* 207 */           str = null;
/* 208 */           if (arrayOfChar[parsePosition.getIndex()] == ',') {
/* 209 */             str = parseFormatDescription(paramString, 
/* 210 */                 next(parsePosition));
/* 211 */             format = getFormat(str);
/* 212 */             if (format == null) {
/* 213 */               stringBuilder.append(',').append(str);
/*     */             }
/*     */           } 
/* 216 */           arrayList.add(format);
/* 217 */           arrayList1.add((format == null) ? null : str);
/* 218 */           if (arrayList.size() != b) {
/* 219 */             throw new IllegalArgumentException("The validated expression is false");
/*     */           }
/* 221 */           if (arrayList1.size() != b) {
/* 222 */             throw new IllegalArgumentException("The validated expression is false");
/*     */           }
/* 224 */           if (arrayOfChar[parsePosition.getIndex()] != '}') {
/* 225 */             throw new IllegalArgumentException("Unreadable format element at position " + i);
/*     */           }
/*     */           break;
/*     */       } 
/*     */       
/* 230 */       stringBuilder.append(arrayOfChar[parsePosition.getIndex()]);
/* 231 */       next(parsePosition);
/*     */     } 
/*     */     
/* 234 */     super.applyPattern(stringBuilder.toString());
/* 235 */     this.toPattern = insertFormats(super.toPattern(), arrayList1);
/* 236 */     if (containsElements(arrayList)) {
/* 237 */       Format[] arrayOfFormat = getFormats();
/*     */ 
/*     */       
/* 240 */       byte b1 = 0;
/* 241 */       for (Format format : arrayList) {
/*     */         
/* 243 */         if (format != null)
/* 244 */           arrayOfFormat[b1] = format; 
/*     */         b1++;
/*     */       } 
/* 247 */       super.setFormats(arrayOfFormat);
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
/*     */   
/*     */   public void setFormat(int paramInt, Format paramFormat) {
/* 261 */     throw new UnsupportedOperationException();
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
/*     */   public void setFormatByArgumentIndex(int paramInt, Format paramFormat) {
/* 275 */     throw new UnsupportedOperationException();
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
/*     */   public void setFormats(Format[] paramArrayOfFormat) {
/* 287 */     throw new UnsupportedOperationException();
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
/*     */   public void setFormatsByArgumentIndex(Format[] paramArrayOfFormat) {
/* 299 */     throw new UnsupportedOperationException();
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
/* 310 */     if (paramObject == this) {
/* 311 */       return true;
/*     */     }
/* 313 */     if (paramObject == null) {
/* 314 */       return false;
/*     */     }
/* 316 */     if (!Objects.equals(getClass(), paramObject.getClass())) {
/* 317 */       return false;
/*     */     }
/* 319 */     ExtendedMessageFormat extendedMessageFormat = (ExtendedMessageFormat)paramObject;
/* 320 */     if (!Objects.equals(this.toPattern, extendedMessageFormat.toPattern)) {
/* 321 */       return false;
/*     */     }
/* 323 */     if (!super.equals(paramObject)) {
/* 324 */       return false;
/*     */     }
/* 326 */     return Objects.equals(this.registry, extendedMessageFormat.registry);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 334 */     int i = super.hashCode();
/* 335 */     i = 31 * i + Objects.hashCode(this.registry);
/* 336 */     i = 31 * i + Objects.hashCode(this.toPattern);
/* 337 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Format getFormat(String paramString) {
/* 347 */     if (this.registry != null) {
/* 348 */       String str1 = paramString;
/* 349 */       String str2 = null;
/* 350 */       int i = paramString.indexOf(',');
/* 351 */       if (i > 0) {
/* 352 */         str1 = paramString.substring(0, i).trim();
/* 353 */         str2 = paramString.substring(i + 1).trim();
/*     */       } 
/* 355 */       FormatFactory formatFactory = this.registry.get(str1);
/* 356 */       if (formatFactory != null) {
/* 357 */         return formatFactory.getFormat(str1, str2, getLocale());
/*     */       }
/*     */     } 
/* 360 */     return null;
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
/* 371 */     int i = paramParsePosition.getIndex();
/* 372 */     seekNonWs(paramString, paramParsePosition);
/* 373 */     StringBuilder stringBuilder = new StringBuilder();
/* 374 */     boolean bool = false;
/* 375 */     for (; !bool && paramParsePosition.getIndex() < paramString.length(); next(paramParsePosition)) {
/* 376 */       char c = paramString.charAt(paramParsePosition.getIndex());
/* 377 */       if (Character.isWhitespace(c)) {
/* 378 */         seekNonWs(paramString, paramParsePosition);
/* 379 */         c = paramString.charAt(paramParsePosition.getIndex());
/* 380 */         if (c != ',' && c != '}') {
/* 381 */           bool = true;
/*     */           continue;
/*     */         } 
/*     */       } 
/* 385 */       if ((c == ',' || c == '}') && stringBuilder.length() > 0) {
/*     */         try {
/* 387 */           return Integer.parseInt(stringBuilder.toString());
/* 388 */         } catch (NumberFormatException numberFormatException) {}
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 393 */       bool = !Character.isDigit(c) ? true : false;
/* 394 */       stringBuilder.append(c); continue;
/*     */     } 
/* 396 */     if (bool) {
/* 397 */       throw new IllegalArgumentException("Invalid format argument index at position " + i + ": " + paramString
/*     */           
/* 399 */           .substring(i, paramParsePosition.getIndex()));
/*     */     }
/* 401 */     throw new IllegalArgumentException("Unterminated format element at position " + i);
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
/* 413 */     int i = paramParsePosition.getIndex();
/* 414 */     seekNonWs(paramString, paramParsePosition);
/* 415 */     int j = paramParsePosition.getIndex();
/* 416 */     byte b = 1;
/* 417 */     while (paramParsePosition.getIndex() < paramString.length()) {
/* 418 */       switch (paramString.charAt(paramParsePosition.getIndex())) {
/*     */         case '{':
/* 420 */           b++;
/* 421 */           next(paramParsePosition);
/*     */           continue;
/*     */         case '}':
/* 424 */           b--;
/* 425 */           if (b == 0) {
/* 426 */             return paramString.substring(j, paramParsePosition.getIndex());
/*     */           }
/* 428 */           next(paramParsePosition);
/*     */           continue;
/*     */         case '\'':
/* 431 */           getQuotedString(paramString, paramParsePosition);
/*     */           continue;
/*     */       } 
/* 434 */       next(paramParsePosition);
/*     */     } 
/*     */ 
/*     */     
/* 438 */     throw new IllegalArgumentException("Unterminated format element at position " + i);
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
/* 450 */     if (!containsElements(paramArrayList)) {
/* 451 */       return paramString;
/*     */     }
/* 453 */     StringBuilder stringBuilder = new StringBuilder(paramString.length() * 2);
/* 454 */     ParsePosition parsePosition = new ParsePosition(0);
/* 455 */     byte b = -1;
/* 456 */     byte b1 = 0;
/* 457 */     while (parsePosition.getIndex() < paramString.length()) {
/* 458 */       char c = paramString.charAt(parsePosition.getIndex());
/* 459 */       switch (c) {
/*     */         case '\'':
/* 461 */           appendQuotedString(paramString, parsePosition, stringBuilder);
/*     */           continue;
/*     */         case '{':
/* 464 */           b1++;
/* 465 */           stringBuilder.append('{').append(readArgumentIndex(paramString, next(parsePosition)));
/*     */           
/* 467 */           if (b1 == 1) {
/* 468 */             b++;
/* 469 */             String str = paramArrayList.get(b);
/* 470 */             if (str != null) {
/* 471 */               stringBuilder.append(',').append(str);
/*     */             }
/*     */           } 
/*     */           continue;
/*     */         case '}':
/* 476 */           b1--;
/*     */           break;
/*     */       } 
/* 479 */       stringBuilder.append(c);
/* 480 */       next(parsePosition);
/*     */     } 
/*     */     
/* 483 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void seekNonWs(String paramString, ParsePosition paramParsePosition) {
/* 493 */     int i = 0;
/* 494 */     char[] arrayOfChar = paramString.toCharArray();
/*     */     do {
/* 496 */       i = StringMatcherFactory.INSTANCE.splitMatcher().isMatch(arrayOfChar, paramParsePosition.getIndex(), 0, arrayOfChar.length);
/* 497 */       paramParsePosition.setIndex(paramParsePosition.getIndex() + i);
/* 498 */     } while (i > 0 && paramParsePosition.getIndex() < paramString.length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ParsePosition next(ParsePosition paramParsePosition) {
/* 508 */     paramParsePosition.setIndex(paramParsePosition.getIndex() + 1);
/* 509 */     return paramParsePosition;
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
/* 523 */     assert paramString.toCharArray()[paramParsePosition.getIndex()] == '\'' : "Quoted string must start with quote character";
/*     */ 
/*     */ 
/*     */     
/* 527 */     if (paramStringBuilder != null) {
/* 528 */       paramStringBuilder.append('\'');
/*     */     }
/* 530 */     next(paramParsePosition);
/*     */     
/* 532 */     int i = paramParsePosition.getIndex();
/* 533 */     char[] arrayOfChar = paramString.toCharArray();
/* 534 */     int j = i;
/* 535 */     for (int k = paramParsePosition.getIndex(); k < paramString.length(); k++) {
/* 536 */       switch (arrayOfChar[paramParsePosition.getIndex()]) {
/*     */         case '\'':
/* 538 */           next(paramParsePosition);
/* 539 */           return (paramStringBuilder == null) ? null : paramStringBuilder.append(arrayOfChar, j, paramParsePosition
/* 540 */               .getIndex() - j);
/*     */       } 
/* 542 */       next(paramParsePosition);
/*     */     } 
/*     */     
/* 545 */     throw new IllegalArgumentException("Unterminated quoted string at position " + i);
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
/* 556 */     appendQuotedString(paramString, paramParsePosition, (StringBuilder)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean containsElements(Collection<?> paramCollection) {
/* 565 */     if (paramCollection == null || paramCollection.isEmpty()) {
/* 566 */       return false;
/*     */     }
/* 568 */     for (Object object : paramCollection) {
/* 569 */       if (object != null) {
/* 570 */         return true;
/*     */       }
/*     */     } 
/* 573 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\ExtendedMessageFormat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */