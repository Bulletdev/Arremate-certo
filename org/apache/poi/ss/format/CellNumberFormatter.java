/*     */ package org.apache.poi.ss.format;
/*     */ 
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.DecimalFormatSymbols;
/*     */ import java.text.FieldPosition;
/*     */ import java.util.ArrayList;
/*     */ import java.util.BitSet;
/*     */ import java.util.Collections;
/*     */ import java.util.Formatter;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ import org.apache.poi.util.LocaleUtil;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CellNumberFormatter
/*     */   extends CellFormatter
/*     */ {
/*  40 */   private static final POILogger LOG = POILogFactory.getLogger(CellNumberFormatter.class);
/*     */   
/*     */   private final String desc;
/*     */   private final String printfFmt;
/*     */   private final double scale;
/*     */   private final Special decimalPoint;
/*     */   private final Special slash;
/*     */   private final Special exponent;
/*     */   private final Special numerator;
/*     */   private final Special afterInteger;
/*     */   private final Special afterFractional;
/*     */   private final boolean integerCommas;
/*  52 */   private final List<Special> specials = new ArrayList<Special>();
/*  53 */   private final List<Special> integerSpecials = new ArrayList<Special>();
/*  54 */   private final List<Special> fractionalSpecials = new ArrayList<Special>();
/*  55 */   private final List<Special> numeratorSpecials = new ArrayList<Special>();
/*  56 */   private final List<Special> denominatorSpecials = new ArrayList<Special>();
/*  57 */   private final List<Special> exponentSpecials = new ArrayList<Special>();
/*  58 */   private final List<Special> exponentDigitSpecials = new ArrayList<Special>();
/*     */ 
/*     */   
/*     */   private final int maxDenominator;
/*     */ 
/*     */   
/*     */   private final String numeratorFmt;
/*     */   
/*     */   private final String denominatorFmt;
/*     */   
/*     */   private final boolean improperFraction;
/*     */   
/*     */   private final DecimalFormat decimalFmt;
/*     */   
/*  72 */   private static final CellFormatter SIMPLE_NUMBER = new GeneralNumberFormatter();
/*  73 */   private static final CellFormatter SIMPLE_INT = new CellNumberFormatter("#");
/*  74 */   private static final CellFormatter SIMPLE_FLOAT = new CellNumberFormatter("#.#");
/*     */   
/*     */   private static class GeneralNumberFormatter extends CellFormatter {
/*     */     private GeneralNumberFormatter() {
/*  78 */       super("General");
/*     */     }
/*     */     public void formatValue(StringBuffer param1StringBuffer, Object param1Object) {
/*     */       CellFormatter cellFormatter;
/*  82 */       if (param1Object == null) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/*  87 */       if (param1Object instanceof Number) {
/*  88 */         Number number = (Number)param1Object;
/*  89 */         cellFormatter = (number.doubleValue() % 1.0D == 0.0D) ? CellNumberFormatter.SIMPLE_INT : CellNumberFormatter.SIMPLE_FLOAT;
/*     */       } else {
/*  91 */         cellFormatter = CellTextFormatter.SIMPLE_TEXT;
/*     */       } 
/*  93 */       cellFormatter.formatValue(param1StringBuffer, param1Object);
/*     */     }
/*     */     
/*     */     public void simpleValue(StringBuffer param1StringBuffer, Object param1Object) {
/*  97 */       formatValue(param1StringBuffer, param1Object);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class Special
/*     */   {
/*     */     final char ch;
/*     */     
/*     */     int pos;
/*     */ 
/*     */     
/*     */     Special(char param1Char, int param1Int) {
/* 111 */       this.ch = param1Char;
/* 112 */       this.pos = param1Int;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 117 */       return "'" + this.ch + "' @ " + this.pos;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CellNumberFormatter(String paramString) {
/* 127 */     super(paramString);
/*     */     
/* 129 */     CellNumberPartHandler cellNumberPartHandler = new CellNumberPartHandler();
/* 130 */     StringBuffer stringBuffer = CellFormatPart.parseFormat(paramString, CellFormatType.NUMBER, cellNumberPartHandler);
/*     */     
/* 132 */     this.exponent = cellNumberPartHandler.getExponent();
/* 133 */     this.specials.addAll(cellNumberPartHandler.getSpecials());
/* 134 */     this.improperFraction = cellNumberPartHandler.isImproperFraction();
/*     */ 
/*     */     
/* 137 */     if ((cellNumberPartHandler.getDecimalPoint() != null || cellNumberPartHandler.getExponent() != null) && cellNumberPartHandler.getSlash() != null) {
/* 138 */       this.slash = null;
/* 139 */       this.numerator = null;
/*     */     } else {
/* 141 */       this.slash = cellNumberPartHandler.getSlash();
/* 142 */       this.numerator = cellNumberPartHandler.getNumerator();
/*     */     } 
/*     */     
/* 145 */     int i = interpretPrecision(cellNumberPartHandler.getDecimalPoint(), this.specials);
/* 146 */     int j = 0;
/* 147 */     if (cellNumberPartHandler.getDecimalPoint() != null) {
/* 148 */       j = 1 + i;
/* 149 */       if (i == 0) {
/*     */ 
/*     */         
/* 152 */         this.specials.remove(cellNumberPartHandler.getDecimalPoint());
/* 153 */         this.decimalPoint = null;
/*     */       } else {
/* 155 */         this.decimalPoint = cellNumberPartHandler.getDecimalPoint();
/*     */       } 
/*     */     } else {
/* 158 */       this.decimalPoint = null;
/*     */     } 
/*     */     
/* 161 */     if (this.decimalPoint != null) {
/* 162 */       this.afterInteger = this.decimalPoint;
/* 163 */     } else if (this.exponent != null) {
/* 164 */       this.afterInteger = this.exponent;
/* 165 */     } else if (this.numerator != null) {
/* 166 */       this.afterInteger = this.numerator;
/*     */     } else {
/* 168 */       this.afterInteger = null;
/*     */     } 
/*     */     
/* 171 */     if (this.exponent != null) {
/* 172 */       this.afterFractional = this.exponent;
/* 173 */     } else if (this.numerator != null) {
/* 174 */       this.afterFractional = this.numerator;
/*     */     } else {
/* 176 */       this.afterFractional = null;
/*     */     } 
/*     */     
/* 179 */     double[] arrayOfDouble = { cellNumberPartHandler.getScale() };
/* 180 */     this.integerCommas = interpretIntegerCommas(stringBuffer, this.specials, this.decimalPoint, integerEnd(), fractionalEnd(), arrayOfDouble);
/* 181 */     if (this.exponent == null) {
/* 182 */       this.scale = arrayOfDouble[0];
/*     */     } else {
/*     */       
/* 185 */       this.scale = 1.0D;
/*     */     } 
/*     */     
/* 188 */     if (i != 0)
/*     */     {
/* 190 */       this.fractionalSpecials.addAll(this.specials.subList(this.specials.indexOf(this.decimalPoint) + 1, fractionalEnd()));
/*     */     }
/*     */     
/* 193 */     if (this.exponent != null) {
/* 194 */       int k = this.specials.indexOf(this.exponent);
/* 195 */       this.exponentSpecials.addAll(specialsFor(k, 2));
/* 196 */       this.exponentDigitSpecials.addAll(specialsFor(k + 2));
/*     */     } 
/*     */     
/* 199 */     if (this.slash != null) {
/* 200 */       if (this.numerator != null) {
/* 201 */         this.numeratorSpecials.addAll(specialsFor(this.specials.indexOf(this.numerator)));
/*     */       }
/*     */       
/* 204 */       this.denominatorSpecials.addAll(specialsFor(this.specials.indexOf(this.slash) + 1));
/* 205 */       if (this.denominatorSpecials.isEmpty()) {
/*     */         
/* 207 */         this.numeratorSpecials.clear();
/* 208 */         this.maxDenominator = 1;
/* 209 */         this.numeratorFmt = null;
/* 210 */         this.denominatorFmt = null;
/*     */       } else {
/* 212 */         this.maxDenominator = maxValue(this.denominatorSpecials);
/* 213 */         this.numeratorFmt = singleNumberFormat(this.numeratorSpecials);
/* 214 */         this.denominatorFmt = singleNumberFormat(this.denominatorSpecials);
/*     */       } 
/*     */     } else {
/* 217 */       this.maxDenominator = 1;
/* 218 */       this.numeratorFmt = null;
/* 219 */       this.denominatorFmt = null;
/*     */     } 
/*     */     
/* 222 */     this.integerSpecials.addAll(this.specials.subList(0, integerEnd()));
/*     */     
/* 224 */     if (this.exponent == null) {
/* 225 */       StringBuffer stringBuffer1 = new StringBuffer("%");
/*     */       
/* 227 */       int k = calculateIntegerPartWidth();
/* 228 */       int m = k + j;
/*     */       
/* 230 */       stringBuffer1.append('0').append(m).append('.').append(i);
/*     */       
/* 232 */       stringBuffer1.append("f");
/* 233 */       this.printfFmt = stringBuffer1.toString();
/* 234 */       this.decimalFmt = null;
/*     */     } else {
/* 236 */       StringBuffer stringBuffer1 = new StringBuffer();
/* 237 */       boolean bool = true;
/* 238 */       List<Special> list = this.integerSpecials;
/* 239 */       if (this.integerSpecials.size() == 1) {
/*     */         
/* 241 */         stringBuffer1.append("0");
/* 242 */         bool = false;
/*     */       } else {
/* 244 */         for (Special special : list) {
/* 245 */           if (isDigitFmt(special)) {
/* 246 */             stringBuffer1.append(bool ? 35 : 48);
/* 247 */             bool = false;
/*     */           } 
/*     */         } 
/* 250 */       }  if (this.fractionalSpecials.size() > 0) {
/* 251 */         stringBuffer1.append('.');
/* 252 */         for (Special special : this.fractionalSpecials) {
/* 253 */           if (isDigitFmt(special)) {
/* 254 */             if (!bool)
/* 255 */               stringBuffer1.append('0'); 
/* 256 */             bool = false;
/*     */           } 
/*     */         } 
/*     */       } 
/* 260 */       stringBuffer1.append('E');
/* 261 */       placeZeros(stringBuffer1, this.exponentSpecials.subList(2, this.exponentSpecials.size()));
/* 262 */       DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(LocaleUtil.getUserLocale());
/* 263 */       this.decimalFmt = new DecimalFormat(stringBuffer1.toString(), decimalFormatSymbols);
/* 264 */       this.printfFmt = null;
/*     */     } 
/*     */     
/* 267 */     this.desc = stringBuffer.toString();
/*     */   }
/*     */   
/*     */   private static void placeZeros(StringBuffer paramStringBuffer, List<Special> paramList) {
/* 271 */     for (Special special : paramList) {
/* 272 */       if (isDigitFmt(special)) {
/* 273 */         paramStringBuffer.append('0');
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private static CellNumberStringMod insertMod(Special paramSpecial, CharSequence paramCharSequence, int paramInt) {
/* 279 */     return new CellNumberStringMod(paramSpecial, paramCharSequence, paramInt);
/*     */   }
/*     */   
/*     */   private static CellNumberStringMod deleteMod(Special paramSpecial1, boolean paramBoolean1, Special paramSpecial2, boolean paramBoolean2) {
/* 283 */     return new CellNumberStringMod(paramSpecial1, paramBoolean1, paramSpecial2, paramBoolean2);
/*     */   }
/*     */   
/*     */   private static CellNumberStringMod replaceMod(Special paramSpecial1, boolean paramBoolean1, Special paramSpecial2, boolean paramBoolean2, char paramChar) {
/* 287 */     return new CellNumberStringMod(paramSpecial1, paramBoolean1, paramSpecial2, paramBoolean2, paramChar);
/*     */   }
/*     */   
/*     */   private static String singleNumberFormat(List<Special> paramList) {
/* 291 */     return "%0" + paramList.size() + "d";
/*     */   }
/*     */   
/*     */   private static int maxValue(List<Special> paramList) {
/* 295 */     return (int)Math.round(Math.pow(10.0D, paramList.size()) - 1.0D);
/*     */   }
/*     */   
/*     */   private List<Special> specialsFor(int paramInt1, int paramInt2) {
/* 299 */     if (paramInt1 >= this.specials.size()) {
/* 300 */       return Collections.emptyList();
/*     */     }
/* 302 */     ListIterator<Special> listIterator = this.specials.listIterator(paramInt1 + paramInt2);
/* 303 */     Special special = listIterator.next();
/* 304 */     int i = paramInt1 + paramInt2;
/* 305 */     while (listIterator.hasNext()) {
/* 306 */       Special special1 = listIterator.next();
/* 307 */       if (!isDigitFmt(special1) || special1.pos - special.pos > 1)
/*     */         break; 
/* 309 */       i++;
/* 310 */       special = special1;
/*     */     } 
/* 312 */     return this.specials.subList(paramInt1, i + 1);
/*     */   }
/*     */   
/*     */   private List<Special> specialsFor(int paramInt) {
/* 316 */     return specialsFor(paramInt, 0);
/*     */   }
/*     */   
/*     */   private static boolean isDigitFmt(Special paramSpecial) {
/* 320 */     return (paramSpecial.ch == '0' || paramSpecial.ch == '?' || paramSpecial.ch == '#');
/*     */   }
/*     */   
/*     */   private int calculateIntegerPartWidth() {
/* 324 */     byte b = 0;
/* 325 */     for (Special special : this.specials) {
/*     */       
/* 327 */       if (special == this.afterInteger)
/*     */         break; 
/* 329 */       if (isDigitFmt(special)) {
/* 330 */         b++;
/*     */       }
/*     */     } 
/* 333 */     return b;
/*     */   }
/*     */   
/*     */   private static int interpretPrecision(Special paramSpecial, List<Special> paramList) {
/* 337 */     int i = paramList.indexOf(paramSpecial);
/* 338 */     byte b = 0;
/* 339 */     if (i != -1) {
/*     */       
/* 341 */       ListIterator<Special> listIterator = paramList.listIterator(i + 1);
/* 342 */       while (listIterator.hasNext()) {
/* 343 */         Special special = listIterator.next();
/* 344 */         if (!isDigitFmt(special)) {
/*     */           break;
/*     */         }
/* 347 */         b++;
/*     */       } 
/*     */     } 
/* 350 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean interpretIntegerCommas(StringBuffer paramStringBuffer, List<Special> paramList, Special paramSpecial, int paramInt1, int paramInt2, double[] paramArrayOfdouble) {
/* 356 */     ListIterator<Special> listIterator = paramList.listIterator(paramInt1);
/*     */     
/* 358 */     boolean bool1 = true;
/* 359 */     boolean bool2 = false;
/* 360 */     while (listIterator.hasPrevious()) {
/* 361 */       Special special = listIterator.previous();
/* 362 */       if (special.ch != ',') {
/* 363 */         bool1 = false; continue;
/*     */       } 
/* 365 */       if (bool1) {
/* 366 */         paramArrayOfdouble[0] = paramArrayOfdouble[0] / 1000.0D; continue;
/*     */       } 
/* 368 */       bool2 = true;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 373 */     if (paramSpecial != null) {
/* 374 */       listIterator = paramList.listIterator(paramInt2);
/* 375 */       while (listIterator.hasPrevious()) {
/* 376 */         Special special = listIterator.previous();
/* 377 */         if (special.ch != ',') {
/*     */           break;
/*     */         }
/* 380 */         paramArrayOfdouble[0] = paramArrayOfdouble[0] / 1000.0D;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 386 */     listIterator = paramList.listIterator();
/* 387 */     byte b = 0;
/* 388 */     while (listIterator.hasNext()) {
/* 389 */       Special special = listIterator.next();
/* 390 */       special.pos -= b;
/* 391 */       if (special.ch == ',') {
/* 392 */         b++;
/* 393 */         listIterator.remove();
/* 394 */         paramStringBuffer.deleteCharAt(special.pos);
/*     */       } 
/*     */     } 
/*     */     
/* 398 */     return bool2;
/*     */   }
/*     */   
/*     */   private int integerEnd() {
/* 402 */     return (this.afterInteger == null) ? this.specials.size() : this.specials.indexOf(this.afterInteger);
/*     */   }
/*     */   
/*     */   private int fractionalEnd() {
/* 406 */     return (this.afterFractional == null) ? this.specials.size() : this.specials.indexOf(this.afterFractional);
/*     */   }
/*     */ 
/*     */   
/*     */   public void formatValue(StringBuffer paramStringBuffer, Object paramObject) {
/* 411 */     double d1 = ((Number)paramObject).doubleValue();
/* 412 */     d1 *= this.scale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 421 */     boolean bool = (d1 < 0.0D) ? true : false;
/* 422 */     if (bool) {
/* 423 */       d1 = -d1;
/*     */     }
/*     */     
/* 426 */     double d2 = 0.0D;
/* 427 */     if (this.slash != null) {
/* 428 */       if (this.improperFraction) {
/* 429 */         d2 = d1;
/* 430 */         d1 = 0.0D;
/*     */       } else {
/* 432 */         d2 = d1 % 1.0D;
/*     */         
/* 434 */         d1 = (long)d1;
/*     */       } 
/*     */     }
/*     */     
/* 438 */     TreeSet<CellNumberStringMod> treeSet = new TreeSet();
/* 439 */     StringBuffer stringBuffer = new StringBuffer(this.desc);
/*     */     
/* 441 */     if (this.exponent != null) {
/* 442 */       writeScientific(d1, stringBuffer, treeSet);
/* 443 */     } else if (this.improperFraction) {
/* 444 */       writeFraction(d1, null, d2, stringBuffer, treeSet);
/*     */     } else {
/* 446 */       StringBuffer stringBuffer1 = new StringBuffer();
/* 447 */       Formatter formatter = new Formatter(stringBuffer1, LocaleUtil.getUserLocale());
/*     */       try {
/* 449 */         formatter.format(LocaleUtil.getUserLocale(), this.printfFmt, new Object[] { Double.valueOf(d1) });
/*     */       } finally {
/* 451 */         formatter.close();
/*     */       } 
/*     */       
/* 454 */       if (this.numerator == null) {
/* 455 */         writeFractional(stringBuffer1, stringBuffer);
/* 456 */         writeInteger(stringBuffer1, stringBuffer, this.integerSpecials, treeSet, this.integerCommas);
/*     */       } else {
/* 458 */         writeFraction(d1, stringBuffer1, d2, stringBuffer, treeSet);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 463 */     Iterator<CellNumberStringMod> iterator = treeSet.iterator();
/* 464 */     CellNumberStringMod cellNumberStringMod = iterator.hasNext() ? iterator.next() : null;
/*     */     
/* 466 */     BitSet bitSet = new BitSet();
/* 467 */     int i = 0;
/* 468 */     for (Special special : this.specials) {
/* 469 */       int j = special.pos + i;
/* 470 */       if (!bitSet.get(special.pos) && stringBuffer.charAt(j) == '#') {
/* 471 */         stringBuffer.deleteCharAt(j);
/* 472 */         i--;
/* 473 */         bitSet.set(special.pos);
/*     */       } 
/* 475 */       while (cellNumberStringMod != null && special == cellNumberStringMod.getSpecial()) {
/* 476 */         int n, i1, i2, k = stringBuffer.length();
/* 477 */         int m = special.pos + i;
/* 478 */         switch (cellNumberStringMod.getOp()) {
/*     */           
/*     */           case 2:
/* 481 */             if (cellNumberStringMod.getToAdd().equals(",") && bitSet.get(special.pos)) {
/*     */               break;
/*     */             }
/* 484 */             stringBuffer.insert(m + 1, cellNumberStringMod.getToAdd());
/*     */             break;
/*     */           case 1:
/* 487 */             stringBuffer.insert(m, cellNumberStringMod.getToAdd());
/*     */             break;
/*     */ 
/*     */           
/*     */           case 3:
/* 492 */             n = special.pos;
/* 493 */             if (!cellNumberStringMod.isStartInclusive()) {
/* 494 */               n++;
/* 495 */               m++;
/*     */             } 
/*     */ 
/*     */             
/* 499 */             while (bitSet.get(n)) {
/* 500 */               n++;
/* 501 */               m++;
/*     */             } 
/*     */ 
/*     */             
/* 505 */             i1 = (cellNumberStringMod.getEnd()).pos;
/* 506 */             if (cellNumberStringMod.isEndInclusive()) {
/* 507 */               i1++;
/*     */             }
/*     */ 
/*     */             
/* 511 */             i2 = i1 + i;
/*     */             
/* 513 */             if (m < i2) {
/* 514 */               if ("".equals(cellNumberStringMod.getToAdd())) {
/* 515 */                 stringBuffer.delete(m, i2);
/*     */               } else {
/*     */                 
/* 518 */                 char c = cellNumberStringMod.getToAdd().charAt(0);
/* 519 */                 for (int i3 = m; i3 < i2; i3++) {
/* 520 */                   stringBuffer.setCharAt(i3, c);
/*     */                 }
/*     */               } 
/* 523 */               bitSet.set(n, i1);
/*     */             } 
/*     */             break;
/*     */           
/*     */           default:
/* 528 */             throw new IllegalStateException("Unknown op: " + cellNumberStringMod.getOp());
/*     */         } 
/* 530 */         i += stringBuffer.length() - k;
/*     */         
/* 532 */         cellNumberStringMod = iterator.hasNext() ? iterator.next() : null;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 537 */     if (bool) {
/* 538 */       paramStringBuffer.append('-');
/*     */     }
/* 540 */     paramStringBuffer.append(stringBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeScientific(double paramDouble, StringBuffer paramStringBuffer, Set<CellNumberStringMod> paramSet) {
/* 545 */     StringBuffer stringBuffer1 = new StringBuffer();
/* 546 */     FieldPosition fieldPosition = new FieldPosition(1);
/* 547 */     this.decimalFmt.format(paramDouble, stringBuffer1, fieldPosition);
/* 548 */     writeInteger(stringBuffer1, paramStringBuffer, this.integerSpecials, paramSet, this.integerCommas);
/* 549 */     writeFractional(stringBuffer1, paramStringBuffer);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 588 */     int i = fieldPosition.getEndIndex();
/* 589 */     int j = i + 1;
/* 590 */     char c1 = stringBuffer1.charAt(j);
/* 591 */     if (c1 != '-') {
/*     */       
/* 593 */       c1 = '+';
/*     */ 
/*     */       
/* 596 */       stringBuffer1.insert(j, '+');
/*     */     } 
/*     */ 
/*     */     
/* 600 */     ListIterator<Special> listIterator = this.exponentSpecials.listIterator(1);
/* 601 */     Special special = listIterator.next();
/* 602 */     char c2 = special.ch;
/*     */ 
/*     */ 
/*     */     
/* 606 */     if (c1 == '-' || c2 == '+') {
/* 607 */       paramSet.add(replaceMod(special, true, special, true, c1));
/*     */     } else {
/* 609 */       paramSet.add(deleteMod(special, true, special, true));
/*     */     } 
/*     */     
/* 612 */     StringBuffer stringBuffer2 = new StringBuffer(stringBuffer1.substring(j + 1));
/* 613 */     writeInteger(stringBuffer2, paramStringBuffer, this.exponentDigitSpecials, paramSet, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeFraction(double paramDouble1, StringBuffer paramStringBuffer1, double paramDouble2, StringBuffer paramStringBuffer2, Set<CellNumberStringMod> paramSet) {
/* 622 */     if (!this.improperFraction) {
/*     */ 
/*     */       
/* 625 */       if (paramDouble2 == 0.0D && !hasChar('0', (List<Special>[])new List[] { this.numeratorSpecials })) {
/* 626 */         writeInteger(paramStringBuffer1, paramStringBuffer2, this.integerSpecials, paramSet, false);
/*     */         
/* 628 */         Special special1 = lastSpecial(this.integerSpecials);
/* 629 */         Special special2 = lastSpecial(this.denominatorSpecials);
/* 630 */         if (hasChar('?', (List<Special>[])new List[] { this.integerSpecials, this.numeratorSpecials, this.denominatorSpecials })) {
/*     */           
/* 632 */           paramSet.add(replaceMod(special1, false, special2, true, ' '));
/*     */         } else {
/*     */           
/* 635 */           paramSet.add(deleteMod(special1, false, special2, true));
/*     */         } 
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 642 */       boolean bool1 = !hasChar('0', (List<Special>[])new List[] { this.numeratorSpecials }) ? true : false;
/* 643 */       boolean bool2 = !hasChar('0', (List<Special>[])new List[] { this.integerSpecials }) ? true : false;
/* 644 */       boolean bool3 = (this.integerSpecials.isEmpty() || (this.integerSpecials.size() == 1 && hasChar('#', (List<Special>[])new List[] { this.integerSpecials }))) ? true : false;
/*     */       
/* 646 */       boolean bool4 = (paramDouble2 == 0.0D && (bool3 || bool1)) ? true : false;
/* 647 */       boolean bool5 = (paramDouble2 != 0.0D && bool2) ? true : false;
/*     */       
/* 649 */       if (paramDouble1 == 0.0D && (bool4 || bool5)) {
/* 650 */         Special special = lastSpecial(this.integerSpecials);
/* 651 */         boolean bool = hasChar('?', (List<Special>[])new List[] { this.integerSpecials, this.numeratorSpecials });
/* 652 */         CellNumberStringMod cellNumberStringMod = bool ? replaceMod(special, true, this.numerator, false, ' ') : deleteMod(special, true, this.numerator, false);
/*     */ 
/*     */         
/* 655 */         paramSet.add(cellNumberStringMod);
/*     */       } else {
/*     */         
/* 658 */         writeInteger(paramStringBuffer1, paramStringBuffer2, this.integerSpecials, paramSet, false);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*     */       int i, j;
/*     */ 
/*     */       
/* 668 */       if (paramDouble2 == 0.0D || (this.improperFraction && paramDouble2 % 1.0D == 0.0D)) {
/*     */         
/* 670 */         i = (int)Math.round(paramDouble2);
/* 671 */         j = 1;
/*     */       } else {
/* 673 */         SimpleFraction simpleFraction = SimpleFraction.buildFractionMaxDenominator(paramDouble2, this.maxDenominator);
/* 674 */         i = simpleFraction.getNumerator();
/* 675 */         j = simpleFraction.getDenominator();
/*     */       } 
/* 677 */       if (this.improperFraction) {
/* 678 */         i = (int)(i + Math.round(paramDouble1 * j));
/*     */       }
/* 680 */       writeSingleInteger(this.numeratorFmt, i, paramStringBuffer2, this.numeratorSpecials, paramSet);
/* 681 */       writeSingleInteger(this.denominatorFmt, j, paramStringBuffer2, this.denominatorSpecials, paramSet);
/* 682 */     } catch (RuntimeException runtimeException) {
/* 683 */       LOG.log(7, new Object[] { "error while fraction evaluation", runtimeException });
/*     */     } 
/*     */   }
/*     */   
/*     */   private static boolean hasChar(char paramChar, List<Special>... paramVarArgs) {
/* 688 */     for (List<Special> list : paramVarArgs) {
/* 689 */       for (Special special : list) {
/* 690 */         if (special.ch == paramChar) {
/* 691 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/* 695 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeSingleInteger(String paramString, int paramInt, StringBuffer paramStringBuffer, List<Special> paramList, Set<CellNumberStringMod> paramSet) {
/* 700 */     StringBuffer stringBuffer = new StringBuffer();
/* 701 */     Formatter formatter = new Formatter(stringBuffer, LocaleUtil.getUserLocale());
/*     */     try {
/* 703 */       formatter.format(LocaleUtil.getUserLocale(), paramString, new Object[] { Integer.valueOf(paramInt) });
/*     */     } finally {
/* 705 */       formatter.close();
/*     */     } 
/* 707 */     writeInteger(stringBuffer, paramStringBuffer, paramList, paramSet, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeInteger(StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2, List<Special> paramList, Set<CellNumberStringMod> paramSet, boolean paramBoolean) {
/* 714 */     int i = paramStringBuffer1.indexOf(".") - 1;
/* 715 */     if (i < 0) {
/* 716 */       if (this.exponent != null && paramList == this.integerSpecials) {
/* 717 */         i = paramStringBuffer1.indexOf("E") - 1;
/*     */       } else {
/* 719 */         i = paramStringBuffer1.length() - 1;
/*     */       } 
/*     */     }
/*     */     
/*     */     byte b1;
/* 724 */     for (b1 = 0; b1 < i; b1++) {
/* 725 */       char c = paramStringBuffer1.charAt(b1);
/* 726 */       if (c != '0' && c != ',') {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/* 731 */     ListIterator<Special> listIterator = paramList.listIterator(paramList.size());
/* 732 */     boolean bool = false;
/* 733 */     Special special = null;
/* 734 */     byte b2 = 0;
/* 735 */     while (listIterator.hasPrevious()) {
/*     */       byte b;
/* 737 */       if (i >= 0) {
/* 738 */         b = paramStringBuffer1.charAt(i);
/*     */       } else {
/*     */         
/* 741 */         b = 48;
/*     */       } 
/* 743 */       Special special1 = listIterator.previous();
/* 744 */       bool = (paramBoolean && b2 && b2 % 3 == 0) ? true : false;
/* 745 */       boolean bool1 = false;
/* 746 */       if (b != 48 || special1.ch == '0' || special1.ch == '?' || i >= b1) {
/* 747 */         bool1 = (special1.ch == '?' && i < b1) ? true : false;
/* 748 */         paramStringBuffer2.setCharAt(special1.pos, bool1 ? 32 : b);
/* 749 */         special = special1;
/*     */       } 
/* 751 */       if (bool) {
/* 752 */         paramSet.add(insertMod(special1, bool1 ? " " : ",", 2));
/* 753 */         bool = false;
/*     */       } 
/* 755 */       b2++;
/* 756 */       i--;
/*     */     } 
/* 758 */     StringBuffer stringBuffer = new StringBuffer();
/* 759 */     if (i >= 0) {
/*     */ 
/*     */       
/* 762 */       i++;
/* 763 */       stringBuffer = new StringBuffer(paramStringBuffer1.substring(0, i));
/* 764 */       if (paramBoolean) {
/* 765 */         while (i > 0) {
/* 766 */           if (b2 > 0 && b2 % 3 == 0) {
/* 767 */             stringBuffer.insert(i, ',');
/*     */           }
/* 769 */           b2++;
/* 770 */           i--;
/*     */         } 
/*     */       }
/* 773 */       paramSet.add(insertMod(special, stringBuffer, 1));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeFractional(StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2) {
/* 780 */     if (this.fractionalSpecials.size() > 0) {
/* 781 */       int j, i = paramStringBuffer1.indexOf(".") + 1;
/* 782 */       if (this.exponent != null) {
/* 783 */         j = paramStringBuffer1.indexOf("e") - 1;
/*     */       } else {
/* 785 */         j = paramStringBuffer1.length() - 1;
/*     */       } 
/*     */       
/* 788 */       while (j > i && paramStringBuffer1.charAt(j) == '0') {
/* 789 */         j--;
/*     */       }
/*     */       
/* 792 */       for (Special special : this.fractionalSpecials) {
/* 793 */         char c = paramStringBuffer1.charAt(i);
/* 794 */         if (c != '0' || special.ch == '0' || i < j) {
/* 795 */           paramStringBuffer2.setCharAt(special.pos, c);
/* 796 */         } else if (special.ch == '?') {
/*     */ 
/*     */           
/* 799 */           paramStringBuffer2.setCharAt(special.pos, ' ');
/*     */         } 
/* 801 */         i++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void simpleValue(StringBuffer paramStringBuffer, Object paramObject) {
/* 813 */     SIMPLE_NUMBER.formatValue(paramStringBuffer, paramObject);
/*     */   }
/*     */   
/*     */   private static Special lastSpecial(List<Special> paramList) {
/* 817 */     return paramList.get(paramList.size() - 1);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\format\CellNumberFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */