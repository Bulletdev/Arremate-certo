/*      */ package org.apache.poi.ss.usermodel;
/*      */ 
/*      */ import java.math.BigDecimal;
/*      */ import java.math.RoundingMode;
/*      */ import java.text.DateFormat;
/*      */ import java.text.DateFormatSymbols;
/*      */ import java.text.DecimalFormat;
/*      */ import java.text.DecimalFormatSymbols;
/*      */ import java.text.FieldPosition;
/*      */ import java.text.Format;
/*      */ import java.text.ParsePosition;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import java.util.Observable;
/*      */ import java.util.Observer;
/*      */ import java.util.regex.Matcher;
/*      */ import java.util.regex.Pattern;
/*      */ import org.apache.poi.ss.format.CellFormat;
/*      */ import org.apache.poi.ss.format.CellFormatResult;
/*      */ import org.apache.poi.ss.util.NumberToTextConverter;
/*      */ import org.apache.poi.util.LocaleUtil;
/*      */ import org.apache.poi.util.POILogFactory;
/*      */ import org.apache.poi.util.POILogger;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class DataFormatter
/*      */   implements Observer
/*      */ {
/*      */   private static final String defaultFractionWholePartFormat = "#";
/*      */   private static final String defaultFractionFractionPartFormat = "#/##";
/*  124 */   private static final Pattern numPattern = Pattern.compile("[0#]+");
/*      */ 
/*      */   
/*  127 */   private static final Pattern daysAsText = Pattern.compile("([d]{3,})", 2);
/*      */ 
/*      */   
/*  130 */   private static final Pattern amPmPattern = Pattern.compile("((A|P)[M/P]*)", 2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  136 */   private static final Pattern localePatternGroup = Pattern.compile("(\\[\\$[^-\\]]*-[0-9A-Z]+\\])");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  143 */   private static final Pattern colorPattern = Pattern.compile("(\\[BLACK\\])|(\\[BLUE\\])|(\\[CYAN\\])|(\\[GREEN\\])|(\\[MAGENTA\\])|(\\[RED\\])|(\\[WHITE\\])|(\\[YELLOW\\])|(\\[COLOR\\s*\\d\\])|(\\[COLOR\\s*[0-5]\\d\\])", 2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  152 */   private static final Pattern fractionPattern = Pattern.compile("(?:([#\\d]+)\\s+)?(#+)\\s*\\/\\s*([#\\d]+)");
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  157 */   private static final Pattern fractionStripper = Pattern.compile("(\"[^\"]*\")|([^ \\?#\\d\\/]+)");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  163 */   private static final Pattern alternateGrouping = Pattern.compile("([#0]([^.#0])[#0]{3})");
/*      */   
/*      */   private static final String invalidDateTimeString;
/*      */   
/*      */   private DecimalFormatSymbols decimalSymbols;
/*      */   private DateFormatSymbols dateSymbols;
/*      */   
/*      */   static {
/*  171 */     StringBuilder stringBuilder = new StringBuilder();
/*  172 */     for (byte b = 0; b < 'ÿ'; ) { stringBuilder.append('#'); b++; }
/*  173 */      invalidDateTimeString = stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private DateFormat defaultDateformat;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Format generalNumberFormat;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Format defaultNumFormat;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  201 */   private final Map<String, Format> formats = new HashMap<String, Format>();
/*      */   
/*      */   private final boolean emulateCSV;
/*      */   private Locale locale;
/*      */   private boolean localeIsAdapting;
/*      */   
/*      */   private class LocaleChangeObservable
/*      */     extends Observable
/*      */   {
/*      */     private LocaleChangeObservable() {}
/*      */     
/*      */     void checkForLocaleChange() {
/*  213 */       checkForLocaleChange(LocaleUtil.getUserLocale());
/*      */     }
/*      */     void checkForLocaleChange(Locale param1Locale) {
/*  216 */       if (!DataFormatter.this.localeIsAdapting)
/*  217 */         return;  if (param1Locale.equals(DataFormatter.this.locale))
/*  218 */         return;  setChanged();
/*  219 */       notifyObservers(param1Locale);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*  224 */   private final LocaleChangeObservable localeChangedObservable = new LocaleChangeObservable();
/*      */ 
/*      */   
/*  227 */   private static POILogger logger = POILogFactory.getLogger(DataFormatter.class);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DataFormatter() {
/*  233 */     this(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DataFormatter(boolean paramBoolean) {
/*  242 */     this(LocaleUtil.getUserLocale(), true, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DataFormatter(Locale paramLocale) {
/*  249 */     this(paramLocale, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DataFormatter(Locale paramLocale, boolean paramBoolean) {
/*  258 */     this(paramLocale, false, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private DataFormatter(Locale paramLocale, boolean paramBoolean1, boolean paramBoolean2) {
/*  267 */     this.localeIsAdapting = true;
/*  268 */     this.localeChangedObservable.addObserver(this);
/*      */     
/*  270 */     this.localeChangedObservable.checkForLocaleChange(paramLocale);
/*      */ 
/*      */ 
/*      */     
/*  274 */     this.localeIsAdapting = paramBoolean1;
/*  275 */     this.emulateCSV = paramBoolean2;
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
/*      */   private Format getFormat(Cell paramCell) {
/*  292 */     if (paramCell.getCellStyle() == null) {
/*  293 */       return null;
/*      */     }
/*      */     
/*  296 */     short s = paramCell.getCellStyle().getDataFormat();
/*  297 */     String str = paramCell.getCellStyle().getDataFormatString();
/*  298 */     if (str == null || str.trim().length() == 0) {
/*  299 */       return null;
/*      */     }
/*  301 */     return getFormat(paramCell.getNumericCellValue(), s, str);
/*      */   }
/*      */   
/*      */   private Format getFormat(double paramDouble, int paramInt, String paramString) {
/*  305 */     this.localeChangedObservable.checkForLocaleChange();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  313 */     String str = paramString;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  321 */     if (str.contains(";") && str.indexOf(';') != str.lastIndexOf(';')) {
/*      */       try {
/*      */         Date date;
/*      */         
/*  325 */         CellFormat cellFormat = CellFormat.getInstance(str);
/*      */         
/*  327 */         Double double_ = Double.valueOf(paramDouble);
/*  328 */         if (DateUtil.isADateFormat(paramInt, str) && double_.doubleValue() != 0.0D)
/*      */         {
/*      */           
/*  331 */           date = DateUtil.getJavaDate(paramDouble);
/*      */         }
/*      */         
/*  334 */         return new CellFormatResultWrapper(cellFormat.apply(date));
/*  335 */       } catch (Exception exception) {
/*  336 */         logger.log(5, new Object[] { "Formatting failed for format " + str + ", falling back", exception });
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*  341 */     if (this.emulateCSV && paramDouble == 0.0D && str.contains("#") && !str.contains("0")) {
/*  342 */       str = str.replaceAll("#", "");
/*      */     }
/*      */ 
/*      */     
/*  346 */     Format format = this.formats.get(str);
/*  347 */     if (format != null) {
/*  348 */       return format;
/*      */     }
/*      */ 
/*      */     
/*  352 */     if ("General".equalsIgnoreCase(str) || "@".equals(str)) {
/*  353 */       return this.generalNumberFormat;
/*      */     }
/*      */ 
/*      */     
/*  357 */     format = createFormat(paramDouble, paramInt, str);
/*  358 */     this.formats.put(str, format);
/*  359 */     return format;
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
/*      */   public Format createFormat(Cell paramCell) {
/*  371 */     short s = paramCell.getCellStyle().getDataFormat();
/*  372 */     String str = paramCell.getCellStyle().getDataFormatString();
/*  373 */     return createFormat(paramCell.getNumericCellValue(), s, str);
/*      */   }
/*      */   
/*      */   private Format createFormat(double paramDouble, int paramInt, String paramString) {
/*  377 */     this.localeChangedObservable.checkForLocaleChange();
/*      */     
/*  379 */     String str = paramString;
/*      */ 
/*      */     
/*  382 */     Matcher matcher1 = colorPattern.matcher(str);
/*  383 */     while (matcher1.find()) {
/*  384 */       String str1 = matcher1.group();
/*      */ 
/*      */       
/*  387 */       int i = str.indexOf(str1);
/*  388 */       if (i == -1)
/*  389 */         break;  String str2 = str.substring(0, i) + str.substring(i + str1.length());
/*      */       
/*  391 */       if (str2.equals(str)) {
/*      */         break;
/*      */       }
/*  394 */       str = str2;
/*  395 */       matcher1 = colorPattern.matcher(str);
/*      */     } 
/*      */ 
/*      */     
/*  399 */     Matcher matcher2 = localePatternGroup.matcher(str);
/*  400 */     while (matcher2.find()) {
/*  401 */       String str1 = matcher2.group();
/*  402 */       String str2 = str1.substring(str1.indexOf('$') + 1, str1.indexOf('-'));
/*  403 */       if (str2.indexOf('$') > -1) {
/*  404 */         str2 = str2.substring(0, str2.indexOf('$')) + '\\' + str2.substring(str2.indexOf('$'), str2.length());
/*      */       }
/*      */ 
/*      */       
/*  408 */       str = matcher2.replaceAll(str2);
/*  409 */       matcher2 = localePatternGroup.matcher(str);
/*      */     } 
/*      */ 
/*      */     
/*  413 */     if (str == null || str.trim().length() == 0) {
/*  414 */       return getDefaultFormat(paramDouble);
/*      */     }
/*      */     
/*  417 */     if ("General".equalsIgnoreCase(str) || "@".equals(str)) {
/*  418 */       return this.generalNumberFormat;
/*      */     }
/*      */     
/*  421 */     if (DateUtil.isADateFormat(paramInt, str) && DateUtil.isValidExcelDate(paramDouble))
/*      */     {
/*  423 */       return createDateFormat(str, paramDouble);
/*      */     }
/*      */     
/*  426 */     if (str.contains("#/") || str.contains("?/")) {
/*  427 */       String[] arrayOfString = str.split(";");
/*  428 */       for (String str1 : arrayOfString) {
/*  429 */         String str2 = str1.replaceAll("\\?", "#");
/*  430 */         Matcher matcher3 = fractionStripper.matcher(str2);
/*  431 */         str2 = matcher3.replaceAll(" ");
/*  432 */         str2 = str2.replaceAll(" +", " ");
/*  433 */         Matcher matcher4 = fractionPattern.matcher(str2);
/*      */         
/*  435 */         if (matcher4.find()) {
/*  436 */           String str3 = (matcher4.group(1) == null) ? "" : "#";
/*  437 */           return new FractionFormat(str3, matcher4.group(3));
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  444 */       return new FractionFormat("#", "#/##");
/*      */     } 
/*      */     
/*  447 */     if (numPattern.matcher(str).find()) {
/*  448 */       return createNumberFormat(str, paramDouble);
/*      */     }
/*      */     
/*  451 */     if (this.emulateCSV) {
/*  452 */       return new ConstantStringFormat(cleanFormatForNumber(str));
/*      */     }
/*      */     
/*  455 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private Format createDateFormat(String paramString, double paramDouble) {
/*  461 */     String str = paramString;
/*  462 */     str = str.replaceAll("\\\\-", "-");
/*  463 */     str = str.replaceAll("\\\\,", ",");
/*  464 */     str = str.replaceAll("\\\\\\.", ".");
/*  465 */     str = str.replaceAll("\\\\ ", " ");
/*  466 */     str = str.replaceAll("\\\\/", "/");
/*  467 */     str = str.replaceAll(";@", "");
/*  468 */     str = str.replaceAll("\"/\"", "/");
/*  469 */     str = str.replace("\"\"", "'");
/*  470 */     str = str.replaceAll("\\\\T", "'T'");
/*      */ 
/*      */     
/*  473 */     boolean bool1 = false;
/*  474 */     Matcher matcher1 = amPmPattern.matcher(str);
/*  475 */     while (matcher1.find()) {
/*  476 */       str = matcher1.replaceAll("@");
/*  477 */       bool1 = true;
/*  478 */       matcher1 = amPmPattern.matcher(str);
/*      */     } 
/*  480 */     str = str.replaceAll("@", "a");
/*      */ 
/*      */     
/*  483 */     Matcher matcher2 = daysAsText.matcher(str);
/*  484 */     if (matcher2.find()) {
/*  485 */       String str1 = matcher2.group(0).toUpperCase(Locale.ROOT).replaceAll("D", "E");
/*  486 */       str = matcher2.replaceAll(str1);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  498 */     StringBuilder stringBuilder = new StringBuilder();
/*  499 */     char[] arrayOfChar = str.toCharArray();
/*  500 */     boolean bool2 = true;
/*  501 */     ArrayList<Integer> arrayList = new ArrayList();
/*  502 */     boolean bool3 = false;
/*  503 */     for (byte b = 0; b < arrayOfChar.length; b++) {
/*  504 */       char c = arrayOfChar[b];
/*  505 */       if (c == '\'') {
/*  506 */         stringBuilder.append(c);
/*  507 */         b++;
/*      */ 
/*      */         
/*  510 */         while (b < arrayOfChar.length) {
/*  511 */           c = arrayOfChar[b];
/*  512 */           stringBuilder.append(c);
/*  513 */           if (c == '\'') {
/*      */             break;
/*      */           }
/*  516 */           b++;
/*      */         }
/*      */       
/*  519 */       } else if (c == '[' && !bool3) {
/*  520 */         bool3 = true;
/*  521 */         bool2 = false;
/*  522 */         stringBuilder.append(c);
/*      */       }
/*  524 */       else if (c == ']' && bool3) {
/*  525 */         bool3 = false;
/*  526 */         stringBuilder.append(c);
/*      */       }
/*  528 */       else if (bool3) {
/*  529 */         if (c == 'h' || c == 'H') {
/*  530 */           stringBuilder.append('H');
/*      */         }
/*  532 */         else if (c == 'm' || c == 'M') {
/*  533 */           stringBuilder.append('m');
/*      */         }
/*  535 */         else if (c == 's' || c == 'S') {
/*  536 */           stringBuilder.append('s');
/*      */         } else {
/*      */           
/*  539 */           stringBuilder.append(c);
/*      */         }
/*      */       
/*  542 */       } else if (c == 'h' || c == 'H') {
/*  543 */         bool2 = false;
/*  544 */         if (bool1) {
/*  545 */           stringBuilder.append('h');
/*      */         } else {
/*  547 */           stringBuilder.append('H');
/*      */         }
/*      */       
/*  550 */       } else if (c == 'm' || c == 'M') {
/*  551 */         if (bool2) {
/*  552 */           stringBuilder.append('M');
/*  553 */           arrayList.add(Integer.valueOf(stringBuilder.length() - 1));
/*      */         }
/*      */         else {
/*      */           
/*  557 */           stringBuilder.append('m');
/*      */         }
/*      */       
/*  560 */       } else if (c == 's' || c == 'S') {
/*  561 */         stringBuilder.append('s');
/*      */         
/*  563 */         for (Iterator<Integer> iterator = arrayList.iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/*  564 */           if (stringBuilder.charAt(i) == 'M') {
/*  565 */             stringBuilder.replace(i, i + 1, "m");
/*      */           } }
/*      */         
/*  568 */         bool2 = true;
/*  569 */         arrayList.clear();
/*      */       }
/*  571 */       else if (Character.isLetter(c)) {
/*  572 */         bool2 = true;
/*  573 */         arrayList.clear();
/*  574 */         if (c == 'y' || c == 'Y') {
/*  575 */           stringBuilder.append('y');
/*      */         }
/*  577 */         else if (c == 'd' || c == 'D') {
/*  578 */           stringBuilder.append('d');
/*      */         } else {
/*      */           
/*  581 */           stringBuilder.append(c);
/*      */         } 
/*      */       } else {
/*      */         
/*  585 */         stringBuilder.append(c);
/*      */       } 
/*      */     } 
/*  588 */     str = stringBuilder.toString();
/*      */     
/*      */     try {
/*  591 */       return new ExcelStyleDateFormatter(str, this.dateSymbols);
/*  592 */     } catch (IllegalArgumentException illegalArgumentException) {
/*      */ 
/*      */ 
/*      */       
/*  596 */       return getDefaultFormat(paramDouble);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private String cleanFormatForNumber(String paramString) {
/*  602 */     StringBuilder stringBuilder = new StringBuilder(paramString);
/*      */     
/*  604 */     if (this.emulateCSV) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  609 */       for (byte b1 = 0; b1 < stringBuilder.length(); b1++) {
/*  610 */         char c = stringBuilder.charAt(b1);
/*  611 */         if ((c == '_' || c == '*' || c == '?') && (
/*  612 */           b1 <= 0 || stringBuilder.charAt(b1 - 1) != '\\'))
/*      */         {
/*      */ 
/*      */           
/*  616 */           if (c == '?') {
/*  617 */             stringBuilder.setCharAt(b1, ' ');
/*  618 */           } else if (b1 < stringBuilder.length() - 1) {
/*      */ 
/*      */ 
/*      */             
/*  622 */             if (c == '_') {
/*  623 */               stringBuilder.setCharAt(b1 + 1, ' ');
/*      */             } else {
/*  625 */               stringBuilder.deleteCharAt(b1 + 1);
/*      */             } 
/*      */             
/*  628 */             stringBuilder.deleteCharAt(b1);
/*  629 */             b1--;
/*      */           }
/*      */         
/*      */         }
/*      */       }
/*      */     
/*      */     }
/*      */     else {
/*      */       
/*  638 */       for (byte b1 = 0; b1 < stringBuilder.length(); b1++) {
/*  639 */         char c = stringBuilder.charAt(b1);
/*  640 */         if ((c == '_' || c == '*') && (
/*  641 */           b1 <= 0 || stringBuilder.charAt(b1 - 1) != '\\')) {
/*      */ 
/*      */ 
/*      */           
/*  645 */           if (b1 < stringBuilder.length() - 1)
/*      */           {
/*      */ 
/*      */             
/*  649 */             stringBuilder.deleteCharAt(b1 + 1);
/*      */           }
/*      */           
/*  652 */           stringBuilder.deleteCharAt(b1);
/*  653 */           b1--;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  660 */     for (byte b = 0; b < stringBuilder.length(); b++) {
/*  661 */       char c = stringBuilder.charAt(b);
/*      */       
/*  663 */       if (c == '\\' || c == '"') {
/*  664 */         stringBuilder.deleteCharAt(b);
/*  665 */         b--;
/*      */       
/*      */       }
/*  668 */       else if (c == '+' && b > 0 && stringBuilder.charAt(b - 1) == 'E') {
/*  669 */         stringBuilder.deleteCharAt(b);
/*  670 */         b--;
/*      */       } 
/*      */     } 
/*      */     
/*  674 */     return stringBuilder.toString();
/*      */   }
/*      */   
/*      */   private Format createNumberFormat(String paramString, double paramDouble) {
/*  678 */     String str = cleanFormatForNumber(paramString);
/*  679 */     DecimalFormatSymbols decimalFormatSymbols = this.decimalSymbols;
/*      */ 
/*      */ 
/*      */     
/*  683 */     Matcher matcher = alternateGrouping.matcher(str);
/*  684 */     if (matcher.find()) {
/*  685 */       char c = matcher.group(2).charAt(0);
/*      */ 
/*      */ 
/*      */       
/*  689 */       if (c != ',') {
/*  690 */         decimalFormatSymbols = DecimalFormatSymbols.getInstance(this.locale);
/*      */         
/*  692 */         decimalFormatSymbols.setGroupingSeparator(c);
/*  693 */         String str1 = matcher.group(1);
/*  694 */         String str2 = str1.replace(c, ',');
/*  695 */         str = str.replace(str1, str2);
/*      */       } 
/*      */     } 
/*      */     
/*      */     try {
/*  700 */       DecimalFormat decimalFormat = new DecimalFormat(str, decimalFormatSymbols);
/*  701 */       setExcelStyleRoundingMode(decimalFormat);
/*  702 */       return decimalFormat;
/*  703 */     } catch (IllegalArgumentException illegalArgumentException) {
/*      */ 
/*      */ 
/*      */       
/*  707 */       return getDefaultFormat(paramDouble);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Format getDefaultFormat(Cell paramCell) {
/*  717 */     return getDefaultFormat(paramCell.getNumericCellValue());
/*      */   }
/*      */   private Format getDefaultFormat(double paramDouble) {
/*  720 */     this.localeChangedObservable.checkForLocaleChange();
/*      */ 
/*      */     
/*  723 */     if (this.defaultNumFormat != null) {
/*  724 */       return this.defaultNumFormat;
/*      */     }
/*      */ 
/*      */     
/*  728 */     return this.generalNumberFormat;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String performDateFormatting(Date paramDate, Format paramFormat) {
/*  736 */     return ((paramFormat != null) ? paramFormat : this.defaultDateformat).format(paramDate);
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
/*      */   private String getFormattedDateString(Cell paramCell) {
/*  748 */     Format format = getFormat(paramCell);
/*  749 */     if (format instanceof ExcelStyleDateFormatter)
/*      */     {
/*  751 */       ((ExcelStyleDateFormatter)format).setDateToBeFormatted(paramCell.getNumericCellValue());
/*      */     }
/*      */ 
/*      */     
/*  755 */     Date date = paramCell.getDateCellValue();
/*  756 */     return performDateFormatting(date, format);
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
/*      */   private String getFormattedNumberString(Cell paramCell) {
/*  770 */     Format format = getFormat(paramCell);
/*  771 */     double d = paramCell.getNumericCellValue();
/*  772 */     if (format == null) {
/*  773 */       return String.valueOf(d);
/*      */     }
/*  775 */     String str = format.format(new Double(d));
/*  776 */     return str.replaceFirst("E(\\d)", "E+$1");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String formatRawCellContents(double paramDouble, int paramInt, String paramString) {
/*  785 */     return formatRawCellContents(paramDouble, paramInt, paramString, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String formatRawCellContents(double paramDouble, int paramInt, String paramString, boolean paramBoolean) {
/*      */     String str1;
/*  793 */     this.localeChangedObservable.checkForLocaleChange();
/*      */ 
/*      */     
/*  796 */     if (DateUtil.isADateFormat(paramInt, paramString)) {
/*  797 */       if (DateUtil.isValidExcelDate(paramDouble)) {
/*  798 */         Format format1 = getFormat(paramDouble, paramInt, paramString);
/*  799 */         if (format1 instanceof ExcelStyleDateFormatter)
/*      */         {
/*  801 */           ((ExcelStyleDateFormatter)format1).setDateToBeFormatted(paramDouble);
/*      */         }
/*  803 */         Date date = DateUtil.getJavaDate(paramDouble, paramBoolean);
/*  804 */         return performDateFormatting(date, format1);
/*      */       } 
/*      */       
/*  807 */       if (this.emulateCSV) {
/*  808 */         return invalidDateTimeString;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  813 */     Format format = getFormat(paramDouble, paramInt, paramString);
/*  814 */     if (format == null) {
/*  815 */       return String.valueOf(paramDouble);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  824 */     String str2 = NumberToTextConverter.toText(paramDouble);
/*  825 */     if (str2.indexOf('E') > -1) {
/*  826 */       str1 = format.format(new Double(paramDouble));
/*      */     } else {
/*      */       
/*  829 */       str1 = format.format(new BigDecimal(str2));
/*      */     } 
/*      */     
/*  832 */     if (str1.indexOf('E') > -1 && !str1.contains("E-")) {
/*  833 */       str1 = str1.replaceFirst("E", "E+");
/*      */     }
/*  835 */     return str1;
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
/*      */   public String formatCellValue(Cell paramCell) {
/*  852 */     return formatCellValue(paramCell, null);
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
/*      */   public String formatCellValue(Cell paramCell, FormulaEvaluator paramFormulaEvaluator) {
/*  873 */     this.localeChangedObservable.checkForLocaleChange();
/*      */     
/*  875 */     if (paramCell == null) {
/*  876 */       return "";
/*      */     }
/*      */     
/*  879 */     CellType cellType = paramCell.getCellTypeEnum();
/*  880 */     if (cellType == CellType.FORMULA) {
/*  881 */       if (paramFormulaEvaluator == null) {
/*  882 */         return paramCell.getCellFormula();
/*      */       }
/*  884 */       cellType = paramFormulaEvaluator.evaluateFormulaCellEnum(paramCell);
/*      */     } 
/*  886 */     switch (cellType) {
/*      */       
/*      */       case NUMERIC:
/*  889 */         if (DateUtil.isCellDateFormatted(paramCell)) {
/*  890 */           return getFormattedDateString(paramCell);
/*      */         }
/*  892 */         return getFormattedNumberString(paramCell);
/*      */       
/*      */       case STRING:
/*  895 */         return paramCell.getRichStringCellValue().getString();
/*      */       
/*      */       case BOOLEAN:
/*  898 */         return paramCell.getBooleanCellValue() ? "TRUE" : "FALSE";
/*      */       case BLANK:
/*  900 */         return "";
/*      */       case ERROR:
/*  902 */         return FormulaError.forInt(paramCell.getErrorCellValue()).getString();
/*      */     } 
/*  904 */     throw new RuntimeException("Unexpected celltype (" + cellType + ")");
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
/*      */   public void setDefaultNumberFormat(Format paramFormat) {
/*  927 */     for (Map.Entry<String, Format> entry : this.formats.entrySet()) {
/*  928 */       if (entry.getValue() == this.generalNumberFormat) {
/*  929 */         entry.setValue(paramFormat);
/*      */       }
/*      */     } 
/*  932 */     this.defaultNumFormat = paramFormat;
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
/*      */   public void addFormat(String paramString, Format paramFormat) {
/*  947 */     this.formats.put(paramString, paramFormat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static DecimalFormat createIntegerOnlyFormat(String paramString) {
/*  956 */     DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.ROOT);
/*  957 */     DecimalFormat decimalFormat = new DecimalFormat(paramString, decimalFormatSymbols);
/*  958 */     decimalFormat.setParseIntegerOnly(true);
/*  959 */     return decimalFormat;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void setExcelStyleRoundingMode(DecimalFormat paramDecimalFormat) {
/*  967 */     setExcelStyleRoundingMode(paramDecimalFormat, RoundingMode.HALF_UP);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void setExcelStyleRoundingMode(DecimalFormat paramDecimalFormat, RoundingMode paramRoundingMode) {
/*  976 */     paramDecimalFormat.setRoundingMode(paramRoundingMode);
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
/*      */   public Observable getLocaleChangedObservable() {
/*  990 */     return this.localeChangedObservable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void update(Observable paramObservable, Object paramObject) {
/* 1000 */     if (!(paramObject instanceof Locale))
/* 1001 */       return;  Locale locale = (Locale)paramObject;
/* 1002 */     if (!this.localeIsAdapting || locale.equals(this.locale))
/*      */       return; 
/* 1004 */     this.locale = locale;
/*      */     
/* 1006 */     this.dateSymbols = DateFormatSymbols.getInstance(this.locale);
/* 1007 */     this.decimalSymbols = DecimalFormatSymbols.getInstance(this.locale);
/* 1008 */     this.generalNumberFormat = new ExcelGeneralNumberFormat(this.locale);
/*      */ 
/*      */     
/* 1011 */     this.defaultDateformat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", this.dateSymbols);
/* 1012 */     this.defaultDateformat.setTimeZone(LocaleUtil.getUserTimeZone());
/*      */ 
/*      */ 
/*      */     
/* 1016 */     this.formats.clear();
/* 1017 */     Format format1 = ZipPlusFourFormat.instance;
/* 1018 */     addFormat("00000\\-0000", format1);
/* 1019 */     addFormat("00000-0000", format1);
/*      */     
/* 1021 */     Format format2 = PhoneFormat.instance;
/*      */     
/* 1023 */     addFormat("[<=9999999]###\\-####;\\(###\\)\\ ###\\-####", format2);
/* 1024 */     addFormat("[<=9999999]###-####;(###) ###-####", format2);
/* 1025 */     addFormat("###\\-####;\\(###\\)\\ ###\\-####", format2);
/* 1026 */     addFormat("###-####;(###) ###-####", format2);
/*      */     
/* 1028 */     Format format3 = SSNFormat.instance;
/* 1029 */     addFormat("000\\-00\\-0000", format3);
/* 1030 */     addFormat("000-00-0000", format3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class SSNFormat
/*      */     extends Format
/*      */   {
/* 1043 */     public static final Format instance = new SSNFormat();
/* 1044 */     private static final DecimalFormat df = DataFormatter.createIntegerOnlyFormat("000000000");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static String format(Number param1Number) {
/* 1051 */       String str = df.format(param1Number);
/* 1052 */       return str.substring(0, 3) + '-' + str.substring(3, 5) + '-' + str.substring(5, 9);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public StringBuffer format(Object param1Object, StringBuffer param1StringBuffer, FieldPosition param1FieldPosition) {
/* 1059 */       return param1StringBuffer.append(format((Number)param1Object));
/*      */     }
/*      */ 
/*      */     
/*      */     public Object parseObject(String param1String, ParsePosition param1ParsePosition) {
/* 1064 */       return df.parseObject(param1String, param1ParsePosition);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class ZipPlusFourFormat
/*      */     extends Format
/*      */   {
/* 1075 */     public static final Format instance = new ZipPlusFourFormat();
/* 1076 */     private static final DecimalFormat df = DataFormatter.createIntegerOnlyFormat("000000000");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static String format(Number param1Number) {
/* 1083 */       String str = df.format(param1Number);
/* 1084 */       return str.substring(0, 5) + '-' + str.substring(5, 9);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public StringBuffer format(Object param1Object, StringBuffer param1StringBuffer, FieldPosition param1FieldPosition) {
/* 1090 */       return param1StringBuffer.append(format((Number)param1Object));
/*      */     }
/*      */ 
/*      */     
/*      */     public Object parseObject(String param1String, ParsePosition param1ParsePosition) {
/* 1095 */       return df.parseObject(param1String, param1ParsePosition);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class PhoneFormat
/*      */     extends Format
/*      */   {
/* 1106 */     public static final Format instance = new PhoneFormat();
/* 1107 */     private static final DecimalFormat df = DataFormatter.createIntegerOnlyFormat("##########");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static String format(Number param1Number) {
/* 1114 */       String str1 = df.format(param1Number);
/* 1115 */       StringBuilder stringBuilder = new StringBuilder();
/*      */       
/* 1117 */       int i = str1.length();
/* 1118 */       if (i <= 4) {
/* 1119 */         return str1;
/*      */       }
/*      */       
/* 1122 */       String str4 = str1.substring(i - 4, i);
/* 1123 */       String str3 = str1.substring(Math.max(0, i - 7), i - 4);
/* 1124 */       String str2 = str1.substring(Math.max(0, i - 10), Math.max(0, i - 7));
/*      */       
/* 1126 */       if (str2.trim().length() > 0) {
/* 1127 */         stringBuilder.append('(').append(str2).append(") ");
/*      */       }
/* 1129 */       if (str3.trim().length() > 0) {
/* 1130 */         stringBuilder.append(str3).append('-');
/*      */       }
/* 1132 */       stringBuilder.append(str4);
/* 1133 */       return stringBuilder.toString();
/*      */     }
/*      */ 
/*      */     
/*      */     public StringBuffer format(Object param1Object, StringBuffer param1StringBuffer, FieldPosition param1FieldPosition) {
/* 1138 */       return param1StringBuffer.append(format((Number)param1Object));
/*      */     }
/*      */ 
/*      */     
/*      */     public Object parseObject(String param1String, ParsePosition param1ParsePosition) {
/* 1143 */       return df.parseObject(param1String, param1ParsePosition);
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
/*      */   private static final class ConstantStringFormat
/*      */     extends Format
/*      */   {
/* 1160 */     private static final DecimalFormat df = DataFormatter.createIntegerOnlyFormat("##########"); private final String str;
/*      */     
/*      */     public ConstantStringFormat(String param1String) {
/* 1163 */       this.str = param1String;
/*      */     }
/*      */ 
/*      */     
/*      */     public StringBuffer format(Object param1Object, StringBuffer param1StringBuffer, FieldPosition param1FieldPosition) {
/* 1168 */       return param1StringBuffer.append(this.str);
/*      */     }
/*      */ 
/*      */     
/*      */     public Object parseObject(String param1String, ParsePosition param1ParsePosition) {
/* 1173 */       return df.parseObject(param1String, param1ParsePosition);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private final class CellFormatResultWrapper
/*      */     extends Format
/*      */   {
/*      */     private final CellFormatResult result;
/*      */     
/*      */     private CellFormatResultWrapper(CellFormatResult param1CellFormatResult) {
/* 1184 */       this.result = param1CellFormatResult;
/*      */     }
/*      */     public StringBuffer format(Object param1Object, StringBuffer param1StringBuffer, FieldPosition param1FieldPosition) {
/* 1187 */       if (DataFormatter.this.emulateCSV) {
/* 1188 */         return param1StringBuffer.append(this.result.text);
/*      */       }
/* 1190 */       return param1StringBuffer.append(this.result.text.trim());
/*      */     }
/*      */     
/*      */     public Object parseObject(String param1String, ParsePosition param1ParsePosition) {
/* 1194 */       return null;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\DataFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */