/*     */ package org.apache.poi.ss.format;
/*     */ 
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.regex.Matcher;
/*     */ import org.apache.poi.util.Internal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Internal
/*     */ public class CellNumberPartHandler
/*     */   implements CellFormatPart.PartHandler
/*     */ {
/*     */   private char insertSignForExponent;
/*  34 */   private double scale = 1.0D;
/*     */   private CellNumberFormatter.Special decimalPoint;
/*     */   private CellNumberFormatter.Special slash;
/*     */   private CellNumberFormatter.Special exponent;
/*     */   private CellNumberFormatter.Special numerator;
/*  39 */   private final List<CellNumberFormatter.Special> specials = new LinkedList<CellNumberFormatter.Special>(); private boolean improperFraction;
/*     */   
/*     */   public String handlePart(Matcher paramMatcher, String paramString, CellFormatType paramCellFormatType, StringBuffer paramStringBuffer) {
/*     */     byte b;
/*  43 */     int i = paramStringBuffer.length();
/*  44 */     char c = paramString.charAt(0);
/*  45 */     switch (c) {
/*     */ 
/*     */ 
/*     */       
/*     */       case 'E':
/*     */       case 'e':
/*  51 */         if (this.exponent == null && this.specials.size() > 0) {
/*  52 */           this.exponent = new CellNumberFormatter.Special('.', i);
/*  53 */           this.specials.add(this.exponent);
/*  54 */           this.insertSignForExponent = paramString.charAt(1);
/*  55 */           return paramString.substring(0, 1);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 101 */         return paramString;case '#': case '0': case '?': if (this.insertSignForExponent != '\000') { this.specials.add(new CellNumberFormatter.Special(this.insertSignForExponent, i)); paramStringBuffer.append(this.insertSignForExponent); this.insertSignForExponent = Character.MIN_VALUE; i++; }  for (b = 0; b < paramString.length(); b++) { char c1 = paramString.charAt(b); this.specials.add(new CellNumberFormatter.Special(c1, i + b)); }  return paramString;case '.': if (this.decimalPoint == null && this.specials.size() > 0) { this.decimalPoint = new CellNumberFormatter.Special('.', i); this.specials.add(this.decimalPoint); }  return paramString;case '/': if (this.slash == null && this.specials.size() > 0) { this.numerator = previousNumber(); this.improperFraction |= (this.numerator == firstDigit(this.specials)) ? 1 : 0; this.slash = new CellNumberFormatter.Special('.', i); this.specials.add(this.slash); }  return paramString;case '%': this.scale *= 100.0D; return paramString;
/*     */     } 
/*     */     return null;
/*     */   } public double getScale() {
/* 105 */     return this.scale;
/*     */   }
/*     */   
/*     */   public CellNumberFormatter.Special getDecimalPoint() {
/* 109 */     return this.decimalPoint;
/*     */   }
/*     */   
/*     */   public CellNumberFormatter.Special getSlash() {
/* 113 */     return this.slash;
/*     */   }
/*     */   
/*     */   public CellNumberFormatter.Special getExponent() {
/* 117 */     return this.exponent;
/*     */   }
/*     */   
/*     */   public CellNumberFormatter.Special getNumerator() {
/* 121 */     return this.numerator;
/*     */   }
/*     */   
/*     */   public List<CellNumberFormatter.Special> getSpecials() {
/* 125 */     return this.specials;
/*     */   }
/*     */   
/*     */   public boolean isImproperFraction() {
/* 129 */     return this.improperFraction;
/*     */   }
/*     */   
/*     */   private CellNumberFormatter.Special previousNumber() {
/* 133 */     ListIterator<CellNumberFormatter.Special> listIterator = this.specials.listIterator(this.specials.size());
/* 134 */     while (listIterator.hasPrevious()) {
/* 135 */       CellNumberFormatter.Special special = listIterator.previous();
/* 136 */       if (isDigitFmt(special)) {
/* 137 */         CellNumberFormatter.Special special1 = special;
/* 138 */         while (listIterator.hasPrevious()) {
/* 139 */           special = listIterator.previous();
/*     */           
/* 141 */           if (special1.pos - special.pos > 1 || !isDigitFmt(special)) {
/*     */             break;
/*     */           }
/* 144 */           special1 = special;
/*     */         } 
/* 146 */         return special1;
/*     */       } 
/*     */     } 
/* 149 */     return null;
/*     */   }
/*     */   
/*     */   private static boolean isDigitFmt(CellNumberFormatter.Special paramSpecial) {
/* 153 */     return (paramSpecial.ch == '0' || paramSpecial.ch == '?' || paramSpecial.ch == '#');
/*     */   }
/*     */   
/*     */   private static CellNumberFormatter.Special firstDigit(List<CellNumberFormatter.Special> paramList) {
/* 157 */     for (CellNumberFormatter.Special special : paramList) {
/* 158 */       if (isDigitFmt(special)) {
/* 159 */         return special;
/*     */       }
/*     */     } 
/* 162 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\format\CellNumberPartHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */