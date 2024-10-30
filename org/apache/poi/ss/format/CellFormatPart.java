/*     */ package org.apache.poi.ss.format;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.swing.JLabel;
/*     */ import org.apache.poi.hssf.util.HSSFColor;
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
/*     */ public class CellFormatPart
/*     */ {
/*     */   private final Color color;
/*     */   private CellFormatCondition condition;
/*     */   private final CellFormatter format;
/*     */   private final CellFormatType type;
/*  58 */   private static final Map<String, Color> NAMED_COLORS = new TreeMap<String, Color>(String.CASE_INSENSITIVE_ORDER); public static final Pattern COLOR_PAT;
/*     */   
/*     */   static {
/*  61 */     Map map = HSSFColor.getIndexHash();
/*  62 */     for (HSSFColor hSSFColor : map.values()) {
/*  63 */       Class<?> clazz = hSSFColor.getClass();
/*  64 */       String str = clazz.getSimpleName();
/*  65 */       if (str.equals(str.toUpperCase(Locale.ROOT))) {
/*  66 */         short[] arrayOfShort = hSSFColor.getTriplet();
/*  67 */         Color color = new Color(arrayOfShort[0], arrayOfShort[1], arrayOfShort[2]);
/*  68 */         NAMED_COLORS.put(str, color);
/*  69 */         if (str.indexOf('_') > 0)
/*  70 */           NAMED_COLORS.put(str.replace('_', ' '), color); 
/*  71 */         if (str.indexOf("_PERCENT") > 0) {
/*  72 */           NAMED_COLORS.put(str.replace("_PERCENT", "%").replace('_', ' '), color);
/*     */         }
/*     */       } 
/*     */     } 
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
/* 109 */     String str1 = "([<>=]=?|!=|<>)    # The operator\n  \\s*([0-9]+(?:\\.[0-9]*)?)\\s*  # The constant to test against\n";
/*     */ 
/*     */ 
/*     */     
/* 113 */     String str2 = "(\\[\\$.{0,3}-[0-9a-f]{3}\\])";
/*     */     
/* 115 */     String str3 = "\\[(black|blue|cyan|green|magenta|red|white|yellow|color [0-9]+)\\]";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 122 */     String str4 = "\\\\.                 # Quoted single character\n|\"([^\\\\\"]|\\\\.)*\"         # Quoted string of characters (handles escaped quotes like \\\") \n|" + str2 + "                   # Currency symbol in a given locale\n" + "|_.                             # Space as wide as a given character\n" + "|\\*.                           # Repeating fill character\n" + "|@                              # Text: cell text\n" + "|([0?\\#](?:[0?\\#,]*))         # Number: digit + other digits and commas\n" + "|e[-+]                          # Number: Scientific: Exponent\n" + "|m{1,5}                         # Date: month or minute spec\n" + "|d{1,4}                         # Date: day/date spec\n" + "|y{2,4}                         # Date: year spec\n" + "|h{1,2}                         # Date: hour spec\n" + "|s{1,2}                         # Date: second spec\n" + "|am?/pm?                        # Date: am/pm spec\n" + "|\\[h{1,2}\\]                   # Elapsed time: hour spec\n" + "|\\[m{1,2}\\]                   # Elapsed time: minute spec\n" + "|\\[s{1,2}\\]                   # Elapsed time: second spec\n" + "|[^;]                           # A character\n" + "";
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
/* 141 */     String str5 = "(?:" + str3 + ")?                 # Text color\n" + "(?:\\[" + str1 + "\\])?               # Condition\n" + "(?:\\[\\$-[0-9a-fA-F]+\\])?                # Optional locale id, ignored currently\n" + "((?:" + str4 + ")+)                        # Format spec\n";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 148 */     byte b = 6;
/* 149 */     COLOR_PAT = Pattern.compile(str3, b);
/* 150 */     CONDITION_PAT = Pattern.compile(str1, b);
/* 151 */     SPECIFICATION_PAT = Pattern.compile(str4, b);
/* 152 */     CURRENCY_PAT = Pattern.compile(str2, b);
/* 153 */     FORMAT_PAT = Pattern.compile(str5, b);
/*     */   }
/*     */   public static final Pattern CONDITION_PAT;
/*     */   public static final Pattern SPECIFICATION_PAT;
/*     */   public static final Pattern CURRENCY_PAT;
/*     */   public static final Pattern FORMAT_PAT;
/* 159 */   public static final int COLOR_GROUP = findGroup(FORMAT_PAT, "[Blue]@", "Blue");
/* 160 */   public static final int CONDITION_OPERATOR_GROUP = findGroup(FORMAT_PAT, "[>=1]@", ">=");
/* 161 */   public static final int CONDITION_VALUE_GROUP = findGroup(FORMAT_PAT, "[>=1]@", "1");
/* 162 */   public static final int SPECIFICATION_GROUP = findGroup(FORMAT_PAT, "[Blue][>1]\\a ?", "\\a ?");
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
/*     */   public CellFormatPart(String paramString) {
/* 176 */     Matcher matcher = FORMAT_PAT.matcher(paramString);
/* 177 */     if (!matcher.matches()) {
/* 178 */       throw new IllegalArgumentException("Unrecognized format: " + CellFormatter.quote(paramString));
/*     */     }
/*     */     
/* 181 */     this.color = getColor(matcher);
/* 182 */     this.condition = getCondition(matcher);
/* 183 */     this.type = getCellFormatType(matcher);
/* 184 */     this.format = getFormatter(matcher);
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
/*     */   public boolean applies(Object paramObject) {
/* 198 */     if (this.condition == null || !(paramObject instanceof Number)) {
/* 199 */       if (paramObject == null)
/* 200 */         throw new NullPointerException("valueObject"); 
/* 201 */       return true;
/*     */     } 
/* 203 */     Number number = (Number)paramObject;
/* 204 */     return this.condition.pass(number.doubleValue());
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
/*     */ 
/*     */ 
/*     */   
/*     */   private static int findGroup(Pattern paramPattern, String paramString1, String paramString2) {
/* 221 */     Matcher matcher = paramPattern.matcher(paramString1);
/* 222 */     if (!matcher.find()) {
/* 223 */       throw new IllegalArgumentException("Pattern \"" + paramPattern.pattern() + "\" doesn't match \"" + paramString1 + "\"");
/*     */     }
/*     */     
/* 226 */     for (byte b = 1; b <= matcher.groupCount(); b++) {
/* 227 */       String str = matcher.group(b);
/* 228 */       if (str != null && str.equals(paramString2))
/* 229 */         return b; 
/*     */     } 
/* 231 */     throw new IllegalArgumentException("\"" + paramString2 + "\" not found in \"" + paramPattern.pattern() + "\"");
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
/*     */   private static Color getColor(Matcher paramMatcher) {
/* 244 */     String str = paramMatcher.group(COLOR_GROUP);
/* 245 */     if (str == null || str.length() == 0)
/* 246 */       return null; 
/* 247 */     Color color = NAMED_COLORS.get(str);
/* 248 */     if (color == null)
/* 249 */       CellFormatter.logger.warning("Unknown color: " + CellFormatter.quote(str)); 
/* 250 */     return color;
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
/*     */   private CellFormatCondition getCondition(Matcher paramMatcher) {
/* 262 */     String str = paramMatcher.group(CONDITION_OPERATOR_GROUP);
/* 263 */     if (str == null || str.length() == 0)
/* 264 */       return null; 
/* 265 */     return CellFormatCondition.getInstance(paramMatcher.group(CONDITION_OPERATOR_GROUP), paramMatcher.group(CONDITION_VALUE_GROUP));
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
/*     */   private CellFormatType getCellFormatType(Matcher paramMatcher) {
/* 278 */     String str = paramMatcher.group(SPECIFICATION_GROUP);
/* 279 */     return formatType(str);
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
/*     */   private CellFormatter getFormatter(Matcher paramMatcher) {
/* 291 */     String str = paramMatcher.group(SPECIFICATION_GROUP);
/*     */ 
/*     */     
/* 294 */     Matcher matcher = CURRENCY_PAT.matcher(str);
/* 295 */     if (matcher.find()) {
/* 296 */       String str2, str1 = matcher.group(1);
/*     */       
/* 298 */       if (str1.startsWith("[$-")) {
/*     */         
/* 300 */         str2 = "$";
/*     */       } else {
/* 302 */         str2 = str1.substring(2, str1.lastIndexOf('-'));
/*     */       } 
/* 304 */       str = str.replace(str1, str2);
/*     */     } 
/*     */ 
/*     */     
/* 308 */     return this.type.formatter(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CellFormatType formatType(String paramString) {
/* 319 */     paramString = paramString.trim();
/* 320 */     if (paramString.equals("") || paramString.equalsIgnoreCase("General")) {
/* 321 */       return CellFormatType.GENERAL;
/*     */     }
/* 323 */     Matcher matcher = SPECIFICATION_PAT.matcher(paramString);
/* 324 */     boolean bool1 = false;
/* 325 */     boolean bool2 = false;
/* 326 */     while (matcher.find()) {
/* 327 */       String str = matcher.group(0);
/*     */       
/* 329 */       if (str.length() > 0) {
/* 330 */         char c = str.charAt(0);
/* 331 */         char c1 = Character.MIN_VALUE;
/* 332 */         if (str.length() > 1) {
/* 333 */           c1 = Character.toLowerCase(str.charAt(1));
/*     */         }
/* 335 */         switch (c) {
/*     */           case '@':
/* 337 */             return CellFormatType.TEXT;
/*     */           case 'D':
/*     */           case 'Y':
/*     */           case 'd':
/*     */           case 'y':
/* 342 */             return CellFormatType.DATE;
/*     */           
/*     */           case 'H':
/*     */           case 'M':
/*     */           case 'S':
/*     */           case 'h':
/*     */           case 'm':
/*     */           case 's':
/* 350 */             bool1 = true;
/*     */ 
/*     */           
/*     */           case '0':
/* 354 */             bool2 = true;
/*     */           
/*     */           case '[':
/* 357 */             if (c1 == 'h' || c1 == 'm' || c1 == 's') {
/* 358 */               return CellFormatType.ELAPSED;
/*     */             }
/* 360 */             if (c1 == '$')
/*     */             {
/* 362 */               return CellFormatType.NUMBER;
/*     */             }
/*     */             
/* 365 */             throw new IllegalArgumentException("Unsupported [] format block '" + str + "' in '" + paramString + "' with c2: " + c1);
/*     */           
/*     */           case '#':
/*     */           case '?':
/* 369 */             return CellFormatType.NUMBER;
/*     */         } 
/*     */ 
/*     */       
/*     */       } 
/*     */     } 
/* 375 */     if (bool1)
/* 376 */       return CellFormatType.DATE; 
/* 377 */     if (bool2)
/* 378 */       return CellFormatType.NUMBER; 
/* 379 */     return CellFormatType.TEXT;
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
/*     */ 
/*     */   
/*     */   static String quoteSpecial(String paramString, CellFormatType paramCellFormatType) {
/* 395 */     StringBuilder stringBuilder = new StringBuilder();
/* 396 */     for (byte b = 0; b < paramString.length(); b++) {
/* 397 */       char c = paramString.charAt(b);
/* 398 */       if (c == '\'' && paramCellFormatType.isSpecial('\'')) {
/* 399 */         stringBuilder.append(false);
/*     */       }
/*     */       else {
/*     */         
/* 403 */         boolean bool = paramCellFormatType.isSpecial(c);
/* 404 */         if (bool)
/* 405 */           stringBuilder.append("'"); 
/* 406 */         stringBuilder.append(c);
/* 407 */         if (bool)
/* 408 */           stringBuilder.append("'"); 
/*     */       } 
/* 410 */     }  return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CellFormatResult apply(Object paramObject) {
/*     */     String str;
/*     */     Color color;
/* 423 */     boolean bool = applies(paramObject);
/*     */ 
/*     */     
/* 426 */     if (bool) {
/* 427 */       str = this.format.format(paramObject);
/* 428 */       color = this.color;
/*     */     } else {
/* 430 */       str = this.format.simpleFormat(paramObject);
/* 431 */       color = null;
/*     */     } 
/* 433 */     return new CellFormatResult(bool, str, color);
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
/*     */   public CellFormatResult apply(JLabel paramJLabel, Object paramObject) {
/* 446 */     CellFormatResult cellFormatResult = apply(paramObject);
/* 447 */     paramJLabel.setText(cellFormatResult.text);
/* 448 */     if (cellFormatResult.textColor != null) {
/* 449 */       paramJLabel.setForeground(cellFormatResult.textColor);
/*     */     }
/* 451 */     return cellFormatResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   CellFormatType getCellFormatType() {
/* 461 */     return this.type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean hasCondition() {
/* 470 */     return (this.condition != null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StringBuffer parseFormat(String paramString, CellFormatType paramCellFormatType, PartHandler paramPartHandler) {
/* 491 */     Matcher matcher = SPECIFICATION_PAT.matcher(paramString);
/* 492 */     StringBuffer stringBuffer = new StringBuffer();
/* 493 */     while (matcher.find()) {
/* 494 */       String str = group(matcher, 0);
/* 495 */       if (str.length() > 0) {
/* 496 */         String str1 = paramPartHandler.handlePart(matcher, str, paramCellFormatType, stringBuffer);
/* 497 */         if (str1 == null) {
/* 498 */           switch (str.charAt(0)) {
/*     */             case '"':
/* 500 */               str1 = quoteSpecial(str.substring(1, str.length() - 1), paramCellFormatType);
/*     */               break;
/*     */             
/*     */             case '\\':
/* 504 */               str1 = quoteSpecial(str.substring(1), paramCellFormatType);
/*     */               break;
/*     */             case '_':
/* 507 */               str1 = " ";
/*     */               break;
/*     */             case '*':
/* 510 */               str1 = expandChar(str);
/*     */               break;
/*     */             default:
/* 513 */               str1 = str;
/*     */               break;
/*     */           } 
/*     */         }
/* 517 */         matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(str1));
/*     */       } 
/*     */     } 
/* 520 */     matcher.appendTail(stringBuffer);
/*     */     
/* 522 */     if (paramCellFormatType.isSpecial('\'')) {
/*     */       
/* 524 */       int i = 0;
/* 525 */       while ((i = stringBuffer.indexOf("''", i)) >= 0) {
/* 526 */         stringBuffer.delete(i, i + 2);
/*     */       }
/*     */ 
/*     */       
/* 530 */       i = 0;
/* 531 */       while ((i = stringBuffer.indexOf("\000", i)) >= 0) {
/* 532 */         stringBuffer.replace(i, i + 1, "''");
/*     */       }
/*     */     } 
/*     */     
/* 536 */     return stringBuffer;
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
/*     */   
/*     */   static String expandChar(String paramString) {
/* 551 */     char c = paramString.charAt(1);
/* 552 */     return "" + c + c + c;
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
/*     */   public static String group(Matcher paramMatcher, int paramInt) {
/* 566 */     String str = paramMatcher.group(paramInt);
/* 567 */     return (str == null) ? "" : str;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 571 */     return this.format.format;
/*     */   }
/*     */   
/*     */   static interface PartHandler {
/*     */     String handlePart(Matcher param1Matcher, String param1String, CellFormatType param1CellFormatType, StringBuffer param1StringBuffer);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\format\CellFormatPart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */