/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.util.Arrays;
/*     */ import org.apache.poi.ss.usermodel.Color;
/*     */ import org.apache.poi.ss.usermodel.ExtendedColor;
/*     */ import org.apache.poi.ss.usermodel.IndexedColors;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSSFColor
/*     */   extends ExtendedColor
/*     */ {
/*     */   private final CTColor ctColor;
/*     */   
/*     */   public XSSFColor(CTColor paramCTColor) {
/*  37 */     this.ctColor = paramCTColor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFColor() {
/*  44 */     this.ctColor = CTColor.Factory.newInstance();
/*     */   }
/*     */   
/*     */   public XSSFColor(Color paramColor) {
/*  48 */     this();
/*  49 */     setColor(paramColor);
/*     */   }
/*     */   
/*     */   public XSSFColor(byte[] paramArrayOfbyte) {
/*  53 */     this();
/*  54 */     this.ctColor.setRgb(paramArrayOfbyte);
/*     */   }
/*     */   
/*     */   public XSSFColor(IndexedColors paramIndexedColors) {
/*  58 */     this();
/*  59 */     this.ctColor.setIndexed(paramIndexedColors.index);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAuto() {
/*  67 */     return this.ctColor.getAuto();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAuto(boolean paramBoolean) {
/*  73 */     this.ctColor.setAuto(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isIndexed() {
/*  81 */     return this.ctColor.isSetIndexed();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRGB() {
/*  89 */     return this.ctColor.isSetRgb();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isThemed() {
/*  97 */     return this.ctColor.isSetTheme();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasAlpha() {
/* 104 */     if (!this.ctColor.isSetRgb()) {
/* 105 */       return false;
/*     */     }
/* 107 */     return ((this.ctColor.getRgb()).length == 4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasTint() {
/* 114 */     if (!this.ctColor.isSetTint()) {
/* 115 */       return false;
/*     */     }
/* 117 */     return (this.ctColor.getTint() != 0.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getIndex() {
/* 125 */     return (short)(int)this.ctColor.getIndexed();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public short getIndexed() {
/* 131 */     return getIndex();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIndexed(int paramInt) {
/* 138 */     this.ctColor.setIndexed(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getRGB() {
/* 147 */     byte[] arrayOfByte = getRGBOrARGB();
/* 148 */     if (arrayOfByte == null) {
/* 149 */       return null;
/*     */     }
/*     */     
/* 152 */     if (arrayOfByte.length == 4) {
/*     */       
/* 154 */       byte[] arrayOfByte1 = new byte[3];
/* 155 */       System.arraycopy(arrayOfByte, 1, arrayOfByte1, 0, 3);
/* 156 */       return arrayOfByte1;
/*     */     } 
/* 158 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getARGB() {
/* 167 */     byte[] arrayOfByte = getRGBOrARGB();
/* 168 */     if (arrayOfByte == null) {
/* 169 */       return null;
/*     */     }
/*     */     
/* 172 */     if (arrayOfByte.length == 3) {
/*     */       
/* 174 */       byte[] arrayOfByte1 = new byte[4];
/* 175 */       arrayOfByte1[0] = -1;
/* 176 */       System.arraycopy(arrayOfByte, 0, arrayOfByte1, 1, 3);
/* 177 */       return arrayOfByte1;
/*     */     } 
/* 179 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected byte[] getStoredRBG() {
/* 185 */     return this.ctColor.getRgb();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRGB(byte[] paramArrayOfbyte) {
/* 193 */     this.ctColor.setRgb(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTheme() {
/* 202 */     return (int)this.ctColor.getTheme();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTheme(int paramInt) {
/* 210 */     this.ctColor.setTheme(paramInt);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getTint() {
/* 256 */     return this.ctColor.getTint();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTint(double paramDouble) {
/* 302 */     this.ctColor.setTint(paramDouble);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTColor getCTColor() {
/* 312 */     return this.ctColor;
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
/*     */   public static XSSFColor toXSSFColor(Color paramColor) {
/* 326 */     if (paramColor != null && !(paramColor instanceof XSSFColor)) {
/* 327 */       throw new IllegalArgumentException("Only XSSFColor objects are supported");
/*     */     }
/* 329 */     return (XSSFColor)paramColor;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 334 */     return this.ctColor.toString().hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean sameIndexed(XSSFColor paramXSSFColor) {
/* 339 */     if (isIndexed() == paramXSSFColor.isIndexed()) {
/* 340 */       if (isIndexed()) {
/* 341 */         return (getIndexed() == paramXSSFColor.getIndexed());
/*     */       }
/* 343 */       return true;
/*     */     } 
/* 345 */     return false;
/*     */   }
/*     */   private boolean sameARGB(XSSFColor paramXSSFColor) {
/* 348 */     if (isRGB() == paramXSSFColor.isRGB()) {
/* 349 */       if (isRGB()) {
/* 350 */         return Arrays.equals(getARGB(), paramXSSFColor.getARGB());
/*     */       }
/* 352 */       return true;
/*     */     } 
/* 354 */     return false;
/*     */   }
/*     */   private boolean sameTheme(XSSFColor paramXSSFColor) {
/* 357 */     if (isThemed() == paramXSSFColor.isThemed()) {
/* 358 */       if (isThemed()) {
/* 359 */         return (getTheme() == paramXSSFColor.getTheme());
/*     */       }
/* 361 */       return true;
/*     */     } 
/* 363 */     return false;
/*     */   }
/*     */   private boolean sameTint(XSSFColor paramXSSFColor) {
/* 366 */     if (hasTint() == paramXSSFColor.hasTint()) {
/* 367 */       if (hasTint()) {
/* 368 */         return (getTint() == paramXSSFColor.getTint());
/*     */       }
/* 370 */       return true;
/*     */     } 
/* 372 */     return false;
/*     */   }
/*     */   private boolean sameAuto(XSSFColor paramXSSFColor) {
/* 375 */     return (isAuto() == paramXSSFColor.isAuto());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 380 */     if (!(paramObject instanceof XSSFColor)) {
/* 381 */       return false;
/*     */     }
/*     */     
/* 384 */     XSSFColor xSSFColor = (XSSFColor)paramObject;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 389 */     return (sameARGB(xSSFColor) && sameTheme(xSSFColor) && sameIndexed(xSSFColor) && sameTint(xSSFColor) && sameAuto(xSSFColor));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */