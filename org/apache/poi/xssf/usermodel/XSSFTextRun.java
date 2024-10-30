/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STTextStrikeType;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STTextUnderlineType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSSFTextRun
/*     */ {
/*     */   private final CTRegularTextRun _r;
/*     */   private final XSSFTextParagraph _p;
/*     */   
/*     */   XSSFTextRun(CTRegularTextRun paramCTRegularTextRun, XSSFTextParagraph paramXSSFTextParagraph) {
/*  39 */     this._r = paramCTRegularTextRun;
/*  40 */     this._p = paramXSSFTextParagraph;
/*     */   }
/*     */   
/*     */   XSSFTextParagraph getParentParagraph() {
/*  44 */     return this._p;
/*     */   }
/*     */   
/*     */   public String getText() {
/*  48 */     return this._r.getT();
/*     */   }
/*     */   
/*     */   public void setText(String paramString) {
/*  52 */     this._r.setT(paramString);
/*     */   }
/*     */   
/*     */   public CTRegularTextRun getXmlObject() {
/*  56 */     return this._r;
/*     */   }
/*     */   
/*     */   public void setFontColor(Color paramColor) {
/*  60 */     CTTextCharacterProperties cTTextCharacterProperties = getRPr();
/*  61 */     CTSolidColorFillProperties cTSolidColorFillProperties = cTTextCharacterProperties.isSetSolidFill() ? cTTextCharacterProperties.getSolidFill() : cTTextCharacterProperties.addNewSolidFill();
/*  62 */     CTSRgbColor cTSRgbColor = cTSolidColorFillProperties.isSetSrgbClr() ? cTSolidColorFillProperties.getSrgbClr() : cTSolidColorFillProperties.addNewSrgbClr();
/*  63 */     cTSRgbColor.setVal(new byte[] { (byte)paramColor.getRed(), (byte)paramColor.getGreen(), (byte)paramColor.getBlue() });
/*     */     
/*  65 */     if (cTSolidColorFillProperties.isSetHslClr()) cTSolidColorFillProperties.unsetHslClr(); 
/*  66 */     if (cTSolidColorFillProperties.isSetPrstClr()) cTSolidColorFillProperties.unsetPrstClr(); 
/*  67 */     if (cTSolidColorFillProperties.isSetSchemeClr()) cTSolidColorFillProperties.unsetSchemeClr(); 
/*  68 */     if (cTSolidColorFillProperties.isSetScrgbClr()) cTSolidColorFillProperties.unsetScrgbClr(); 
/*  69 */     if (cTSolidColorFillProperties.isSetSysClr()) cTSolidColorFillProperties.unsetSysClr();
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public Color getFontColor() {
/*  75 */     CTTextCharacterProperties cTTextCharacterProperties = getRPr();
/*  76 */     if (cTTextCharacterProperties.isSetSolidFill()) {
/*  77 */       CTSolidColorFillProperties cTSolidColorFillProperties = cTTextCharacterProperties.getSolidFill();
/*     */       
/*  79 */       if (cTSolidColorFillProperties.isSetSrgbClr()) {
/*  80 */         CTSRgbColor cTSRgbColor = cTSolidColorFillProperties.getSrgbClr();
/*  81 */         byte[] arrayOfByte = cTSRgbColor.getVal();
/*  82 */         return new Color(0xFF & arrayOfByte[0], 0xFF & arrayOfByte[1], 0xFF & arrayOfByte[2]);
/*     */       } 
/*     */     } 
/*     */     
/*  86 */     return new Color(0, 0, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFontSize(double paramDouble) {
/*  95 */     CTTextCharacterProperties cTTextCharacterProperties = getRPr();
/*  96 */     if (paramDouble == -1.0D) {
/*  97 */       if (cTTextCharacterProperties.isSetSz()) cTTextCharacterProperties.unsetSz(); 
/*     */     } else {
/*  99 */       if (paramDouble < 1.0D) {
/* 100 */         throw new IllegalArgumentException("Minimum font size is 1pt but was " + paramDouble);
/*     */       }
/*     */       
/* 103 */       cTTextCharacterProperties.setSz((int)(100.0D * paramDouble));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getFontSize() {
/* 111 */     double d1 = 1.0D;
/* 112 */     double d2 = 11.0D;
/* 113 */     CTTextNormalAutofit cTTextNormalAutofit = getParentParagraph().getParentShape().getTxBody().getBodyPr().getNormAutofit();
/* 114 */     if (cTTextNormalAutofit != null) d1 = cTTextNormalAutofit.getFontScale() / 100000.0D;
/*     */     
/* 116 */     CTTextCharacterProperties cTTextCharacterProperties = getRPr();
/* 117 */     if (cTTextCharacterProperties.isSetSz()) {
/* 118 */       d2 = cTTextCharacterProperties.getSz() * 0.01D;
/*     */     }
/*     */     
/* 121 */     return d2 * d1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getCharacterSpacing() {
/* 130 */     CTTextCharacterProperties cTTextCharacterProperties = getRPr();
/* 131 */     if (cTTextCharacterProperties.isSetSpc()) {
/* 132 */       return cTTextCharacterProperties.getSpc() * 0.01D;
/*     */     }
/* 134 */     return 0.0D;
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
/*     */   public void setCharacterSpacing(double paramDouble) {
/* 147 */     CTTextCharacterProperties cTTextCharacterProperties = getRPr();
/* 148 */     if (paramDouble == 0.0D) {
/* 149 */       if (cTTextCharacterProperties.isSetSpc()) cTTextCharacterProperties.unsetSpc(); 
/*     */     } else {
/* 151 */       cTTextCharacterProperties.setSpc((int)(100.0D * paramDouble));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFont(String paramString) {
/* 162 */     setFontFamily(paramString, (byte)-1, (byte)-1, false);
/*     */   }
/*     */   
/*     */   public void setFontFamily(String paramString, byte paramByte1, byte paramByte2, boolean paramBoolean) {
/* 166 */     CTTextCharacterProperties cTTextCharacterProperties = getRPr();
/*     */     
/* 168 */     if (paramString == null) {
/* 169 */       if (cTTextCharacterProperties.isSetLatin()) cTTextCharacterProperties.unsetLatin(); 
/* 170 */       if (cTTextCharacterProperties.isSetCs()) cTTextCharacterProperties.unsetCs(); 
/* 171 */       if (cTTextCharacterProperties.isSetSym()) cTTextCharacterProperties.unsetSym();
/*     */     
/* 173 */     } else if (paramBoolean) {
/* 174 */       CTTextFont cTTextFont = cTTextCharacterProperties.isSetSym() ? cTTextCharacterProperties.getSym() : cTTextCharacterProperties.addNewSym();
/* 175 */       cTTextFont.setTypeface(paramString);
/*     */     } else {
/* 177 */       CTTextFont cTTextFont = cTTextCharacterProperties.isSetLatin() ? cTTextCharacterProperties.getLatin() : cTTextCharacterProperties.addNewLatin();
/* 178 */       cTTextFont.setTypeface(paramString);
/* 179 */       if (paramByte1 != -1) cTTextFont.setCharset(paramByte1); 
/* 180 */       if (paramByte2 != -1) cTTextFont.setPitchFamily(paramByte2);
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFontFamily() {
/* 189 */     CTTextCharacterProperties cTTextCharacterProperties = getRPr();
/* 190 */     CTTextFont cTTextFont = cTTextCharacterProperties.getLatin();
/* 191 */     if (cTTextFont != null) {
/* 192 */       return cTTextFont.getTypeface();
/*     */     }
/* 194 */     return "Calibri";
/*     */   }
/*     */   
/*     */   public byte getPitchAndFamily() {
/* 198 */     CTTextCharacterProperties cTTextCharacterProperties = getRPr();
/* 199 */     CTTextFont cTTextFont = cTTextCharacterProperties.getLatin();
/* 200 */     if (cTTextFont != null) {
/* 201 */       return cTTextFont.getPitchFamily();
/*     */     }
/* 203 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStrikethrough(boolean paramBoolean) {
/* 212 */     getRPr().setStrike(paramBoolean ? STTextStrikeType.SNG_STRIKE : STTextStrikeType.NO_STRIKE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isStrikethrough() {
/* 219 */     CTTextCharacterProperties cTTextCharacterProperties = getRPr();
/* 220 */     if (cTTextCharacterProperties.isSetStrike()) {
/* 221 */       return (cTTextCharacterProperties.getStrike() != STTextStrikeType.NO_STRIKE);
/*     */     }
/* 223 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSuperscript() {
/* 230 */     CTTextCharacterProperties cTTextCharacterProperties = getRPr();
/* 231 */     if (cTTextCharacterProperties.isSetBaseline()) {
/* 232 */       return (cTTextCharacterProperties.getBaseline() > 0);
/*     */     }
/* 234 */     return false;
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
/*     */   public void setBaselineOffset(double paramDouble) {
/* 247 */     getRPr().setBaseline((int)paramDouble * 1000);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSuperscript(boolean paramBoolean) {
/* 257 */     setBaselineOffset(paramBoolean ? 30.0D : 0.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSubscript(boolean paramBoolean) {
/* 267 */     setBaselineOffset(paramBoolean ? -25.0D : 0.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSubscript() {
/* 274 */     CTTextCharacterProperties cTTextCharacterProperties = getRPr();
/* 275 */     if (cTTextCharacterProperties.isSetBaseline()) {
/* 276 */       return (cTTextCharacterProperties.getBaseline() < 0);
/*     */     }
/* 278 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextCap getTextCap() {
/* 285 */     CTTextCharacterProperties cTTextCharacterProperties = getRPr();
/* 286 */     if (cTTextCharacterProperties.isSetCap()) {
/* 287 */       return TextCap.values()[cTTextCharacterProperties.getCap().intValue() - 1];
/*     */     }
/* 289 */     return TextCap.NONE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBold(boolean paramBoolean) {
/* 298 */     getRPr().setB(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBold() {
/* 305 */     CTTextCharacterProperties cTTextCharacterProperties = getRPr();
/* 306 */     if (cTTextCharacterProperties.isSetB()) {
/* 307 */       return cTTextCharacterProperties.getB();
/*     */     }
/* 309 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItalic(boolean paramBoolean) {
/* 316 */     getRPr().setI(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isItalic() {
/* 323 */     CTTextCharacterProperties cTTextCharacterProperties = getRPr();
/* 324 */     if (cTTextCharacterProperties.isSetI()) {
/* 325 */       return cTTextCharacterProperties.getI();
/*     */     }
/* 327 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUnderline(boolean paramBoolean) {
/* 334 */     getRPr().setU(paramBoolean ? STTextUnderlineType.SNG : STTextUnderlineType.NONE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUnderline() {
/* 341 */     CTTextCharacterProperties cTTextCharacterProperties = getRPr();
/* 342 */     if (cTTextCharacterProperties.isSetU()) {
/* 343 */       return (cTTextCharacterProperties.getU() != STTextUnderlineType.NONE);
/*     */     }
/* 345 */     return false;
/*     */   }
/*     */   
/*     */   protected CTTextCharacterProperties getRPr() {
/* 349 */     return this._r.isSetRPr() ? this._r.getRPr() : this._r.addNewRPr();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 354 */     return "[" + getClass() + "]" + getText();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFTextRun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */