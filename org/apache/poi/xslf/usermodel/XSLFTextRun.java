/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.sl.draw.DrawPaint;
/*     */ import org.apache.poi.sl.usermodel.Hyperlink;
/*     */ import org.apache.poi.sl.usermodel.PaintStyle;
/*     */ import org.apache.poi.sl.usermodel.TextRun;
/*     */ import org.apache.poi.xslf.model.CharacterPropertyFetcher;
/*     */ import org.apache.poi.xslf.model.PropertyFetcher;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTHyperlink;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STTextStrikeType;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STTextUnderlineType;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSLFTextRun
/*     */   implements TextRun
/*     */ {
/*     */   private final CTRegularTextRun _r;
/*     */   private final XSLFTextParagraph _p;
/*     */   
/*     */   protected XSLFTextRun(CTRegularTextRun paramCTRegularTextRun, XSLFTextParagraph paramXSLFTextParagraph) {
/*  52 */     this._r = paramCTRegularTextRun;
/*  53 */     this._p = paramXSLFTextParagraph;
/*     */   }
/*     */   
/*     */   XSLFTextParagraph getParentParagraph() {
/*  57 */     return this._p;
/*     */   }
/*     */   
/*     */   public String getRawText() {
/*  61 */     return this._r.getT();
/*     */   }
/*     */   
/*     */   String getRenderableText() {
/*  65 */     String str = this._r.getT();
/*  66 */     TextRun.TextCap textCap = getTextCap();
/*  67 */     StringBuffer stringBuffer = new StringBuffer();
/*  68 */     for (byte b = 0; b < str.length(); b++) {
/*  69 */       char c = str.charAt(b);
/*  70 */       if (c == '\t') {
/*     */         
/*  72 */         stringBuffer.append("  ");
/*     */       } else {
/*  74 */         switch (textCap) {
/*     */           case ALL:
/*  76 */             stringBuffer.append(Character.toUpperCase(c));
/*     */             break;
/*     */           case SMALL:
/*  79 */             stringBuffer.append(Character.toLowerCase(c));
/*     */             break;
/*     */           default:
/*  82 */             stringBuffer.append(c);
/*     */             break;
/*     */         } 
/*     */       } 
/*     */     } 
/*  87 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void setText(String paramString) {
/*  91 */     this._r.setT(paramString);
/*     */   }
/*     */   
/*     */   public CTRegularTextRun getXmlObject() {
/*  95 */     return this._r;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFontColor(Color paramColor) {
/* 100 */     setFontColor((PaintStyle)DrawPaint.createSolidPaint(paramColor));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFontColor(PaintStyle paramPaintStyle) {
/* 105 */     if (!(paramPaintStyle instanceof PaintStyle.SolidPaint)) {
/* 106 */       throw new IllegalArgumentException("Currently only SolidPaint is supported!");
/*     */     }
/* 108 */     PaintStyle.SolidPaint solidPaint = (PaintStyle.SolidPaint)paramPaintStyle;
/* 109 */     Color color = DrawPaint.applyColorTransform(solidPaint.getSolidColor());
/*     */     
/* 111 */     CTTextCharacterProperties cTTextCharacterProperties = getRPr(true);
/* 112 */     CTSolidColorFillProperties cTSolidColorFillProperties = cTTextCharacterProperties.isSetSolidFill() ? cTTextCharacterProperties.getSolidFill() : cTTextCharacterProperties.addNewSolidFill();
/*     */     
/* 114 */     XSLFColor xSLFColor = new XSLFColor((XmlObject)cTSolidColorFillProperties, getParentParagraph().getParentShape().getSheet().getTheme(), cTSolidColorFillProperties.getSchemeClr());
/* 115 */     xSLFColor.setColor(color);
/*     */   }
/*     */ 
/*     */   
/*     */   public PaintStyle getFontColor() {
/* 120 */     CharacterPropertyFetcher<PaintStyle> characterPropertyFetcher = new CharacterPropertyFetcher<PaintStyle>(this._p.getIndentLevel()) {
/*     */         public boolean fetch(CTTextCharacterProperties param1CTTextCharacterProperties) {
/* 122 */           if (param1CTTextCharacterProperties == null) {
/* 123 */             return false;
/*     */           }
/*     */           
/* 126 */           XSLFTextShape xSLFTextShape = XSLFTextRun.this._p.getParentShape();
/* 127 */           CTShapeStyle cTShapeStyle = xSLFTextShape.getSpStyle();
/* 128 */           CTSchemeColor cTSchemeColor = null;
/* 129 */           if (cTShapeStyle != null && cTShapeStyle.getFontRef() != null) {
/* 130 */             cTSchemeColor = cTShapeStyle.getFontRef().getSchemeClr();
/*     */           }
/*     */           
/* 133 */           XSLFPropertiesDelegate.XSLFFillProperties xSLFFillProperties = XSLFPropertiesDelegate.getFillDelegate((XmlObject)param1CTTextCharacterProperties);
/* 134 */           XSLFSheet xSLFSheet = xSLFTextShape.getSheet();
/* 135 */           PackagePart packagePart = xSLFSheet.getPackagePart();
/* 136 */           XSLFTheme xSLFTheme = xSLFSheet.getTheme();
/* 137 */           PaintStyle paintStyle = XSLFShape.selectPaint(xSLFFillProperties, cTSchemeColor, packagePart, xSLFTheme);
/*     */           
/* 139 */           if (paintStyle != null) {
/* 140 */             setValue(paintStyle);
/* 141 */             return true;
/*     */           } 
/*     */           
/* 144 */           return false;
/*     */         }
/*     */       };
/* 147 */     fetchCharacterProperty(characterPropertyFetcher);
/* 148 */     return (PaintStyle)characterPropertyFetcher.getValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFontSize(Double paramDouble) {
/* 153 */     CTTextCharacterProperties cTTextCharacterProperties = getRPr(true);
/* 154 */     if (paramDouble == null) {
/* 155 */       if (cTTextCharacterProperties.isSetSz()) cTTextCharacterProperties.unsetSz(); 
/*     */     } else {
/* 157 */       if (paramDouble.doubleValue() < 1.0D) {
/* 158 */         throw new IllegalArgumentException("Minimum font size is 1pt but was " + paramDouble);
/*     */       }
/*     */       
/* 161 */       cTTextCharacterProperties.setSz((int)(100.0D * paramDouble.doubleValue()));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Double getFontSize() {
/* 167 */     double d = 1.0D;
/* 168 */     CTTextNormalAutofit cTTextNormalAutofit = getParentParagraph().getParentShape().getTextBodyPr().getNormAutofit();
/* 169 */     if (cTTextNormalAutofit != null) d = cTTextNormalAutofit.getFontScale() / 100000.0D;
/*     */     
/* 171 */     CharacterPropertyFetcher<Double> characterPropertyFetcher = new CharacterPropertyFetcher<Double>(this._p.getIndentLevel()) {
/*     */         public boolean fetch(CTTextCharacterProperties param1CTTextCharacterProperties) {
/* 173 */           if (param1CTTextCharacterProperties != null && param1CTTextCharacterProperties.isSetSz()) {
/* 174 */             setValue(Double.valueOf(param1CTTextCharacterProperties.getSz() * 0.01D));
/* 175 */             return true;
/*     */           } 
/* 177 */           return false;
/*     */         }
/*     */       };
/* 180 */     fetchCharacterProperty(characterPropertyFetcher);
/* 181 */     return (characterPropertyFetcher.getValue() == null) ? null : Double.valueOf(((Double)characterPropertyFetcher.getValue()).doubleValue() * d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getCharacterSpacing() {
/* 191 */     CharacterPropertyFetcher<Double> characterPropertyFetcher = new CharacterPropertyFetcher<Double>(this._p.getIndentLevel()) {
/*     */         public boolean fetch(CTTextCharacterProperties param1CTTextCharacterProperties) {
/* 193 */           if (param1CTTextCharacterProperties != null && param1CTTextCharacterProperties.isSetSpc()) {
/* 194 */             setValue(Double.valueOf(param1CTTextCharacterProperties.getSpc() * 0.01D));
/* 195 */             return true;
/*     */           } 
/* 197 */           return false;
/*     */         }
/*     */       };
/* 200 */     fetchCharacterProperty(characterPropertyFetcher);
/* 201 */     return (characterPropertyFetcher.getValue() == null) ? 0.0D : ((Double)characterPropertyFetcher.getValue()).doubleValue();
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
/* 214 */     CTTextCharacterProperties cTTextCharacterProperties = getRPr(true);
/* 215 */     if (paramDouble == 0.0D) {
/* 216 */       if (cTTextCharacterProperties.isSetSpc()) cTTextCharacterProperties.unsetSpc(); 
/*     */     } else {
/* 218 */       cTTextCharacterProperties.setSpc((int)(100.0D * paramDouble));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFontFamily(String paramString) {
/* 224 */     setFontFamily(paramString, (byte)-1, (byte)-1, false);
/*     */   }
/*     */   
/*     */   public void setFontFamily(String paramString, byte paramByte1, byte paramByte2, boolean paramBoolean) {
/* 228 */     CTTextCharacterProperties cTTextCharacterProperties = getRPr(true);
/*     */     
/* 230 */     if (paramString == null) {
/* 231 */       if (cTTextCharacterProperties.isSetLatin()) cTTextCharacterProperties.unsetLatin(); 
/* 232 */       if (cTTextCharacterProperties.isSetCs()) cTTextCharacterProperties.unsetCs(); 
/* 233 */       if (cTTextCharacterProperties.isSetSym()) cTTextCharacterProperties.unsetSym();
/*     */     
/* 235 */     } else if (paramBoolean) {
/* 236 */       CTTextFont cTTextFont = cTTextCharacterProperties.isSetSym() ? cTTextCharacterProperties.getSym() : cTTextCharacterProperties.addNewSym();
/* 237 */       cTTextFont.setTypeface(paramString);
/*     */     } else {
/* 239 */       CTTextFont cTTextFont = cTTextCharacterProperties.isSetLatin() ? cTTextCharacterProperties.getLatin() : cTTextCharacterProperties.addNewLatin();
/* 240 */       cTTextFont.setTypeface(paramString);
/* 241 */       if (paramByte1 != -1) cTTextFont.setCharset(paramByte1); 
/* 242 */       if (paramByte2 != -1) cTTextFont.setPitchFamily(paramByte2);
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getFontFamily() {
/* 249 */     final XSLFTheme theme = this._p.getParentShape().getSheet().getTheme();
/*     */     
/* 251 */     CharacterPropertyFetcher<String> characterPropertyFetcher = new CharacterPropertyFetcher<String>(this._p.getIndentLevel()) {
/*     */         public boolean fetch(CTTextCharacterProperties param1CTTextCharacterProperties) {
/* 253 */           if (param1CTTextCharacterProperties != null) {
/* 254 */             CTTextFont cTTextFont = param1CTTextCharacterProperties.getLatin();
/* 255 */             if (cTTextFont != null) {
/* 256 */               String str = cTTextFont.getTypeface();
/* 257 */               if ("+mj-lt".equals(str)) {
/* 258 */                 str = theme.getMajorFont();
/* 259 */               } else if ("+mn-lt".equals(str)) {
/* 260 */                 str = theme.getMinorFont();
/*     */               } 
/* 262 */               setValue(str);
/* 263 */               return true;
/*     */             } 
/*     */           } 
/* 266 */           return false;
/*     */         }
/*     */       };
/* 269 */     fetchCharacterProperty(characterPropertyFetcher);
/*     */     
/* 271 */     return (String)characterPropertyFetcher.getValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getPitchAndFamily() {
/* 277 */     CharacterPropertyFetcher<Byte> characterPropertyFetcher = new CharacterPropertyFetcher<Byte>(this._p.getIndentLevel()) {
/*     */         public boolean fetch(CTTextCharacterProperties param1CTTextCharacterProperties) {
/* 279 */           if (param1CTTextCharacterProperties != null) {
/* 280 */             CTTextFont cTTextFont = param1CTTextCharacterProperties.getLatin();
/* 281 */             if (cTTextFont != null) {
/* 282 */               setValue(Byte.valueOf(cTTextFont.getPitchFamily()));
/* 283 */               return true;
/*     */             } 
/*     */           } 
/* 286 */           return false;
/*     */         }
/*     */       };
/* 289 */     fetchCharacterProperty(characterPropertyFetcher);
/*     */     
/* 291 */     return (characterPropertyFetcher.getValue() == null) ? 0 : ((Byte)characterPropertyFetcher.getValue()).byteValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setStrikethrough(boolean paramBoolean) {
/* 296 */     getRPr(true).setStrike(paramBoolean ? STTextStrikeType.SNG_STRIKE : STTextStrikeType.NO_STRIKE);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStrikethrough() {
/* 301 */     CharacterPropertyFetcher<Boolean> characterPropertyFetcher = new CharacterPropertyFetcher<Boolean>(this._p.getIndentLevel()) {
/*     */         public boolean fetch(CTTextCharacterProperties param1CTTextCharacterProperties) {
/* 303 */           if (param1CTTextCharacterProperties != null && param1CTTextCharacterProperties.isSetStrike()) {
/* 304 */             setValue(Boolean.valueOf((param1CTTextCharacterProperties.getStrike() != STTextStrikeType.NO_STRIKE)));
/* 305 */             return true;
/*     */           } 
/* 307 */           return false;
/*     */         }
/*     */       };
/* 310 */     fetchCharacterProperty(characterPropertyFetcher);
/* 311 */     return (characterPropertyFetcher.getValue() == null) ? false : ((Boolean)characterPropertyFetcher.getValue()).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSuperscript() {
/* 316 */     CharacterPropertyFetcher<Boolean> characterPropertyFetcher = new CharacterPropertyFetcher<Boolean>(this._p.getIndentLevel()) {
/*     */         public boolean fetch(CTTextCharacterProperties param1CTTextCharacterProperties) {
/* 318 */           if (param1CTTextCharacterProperties != null && param1CTTextCharacterProperties.isSetBaseline()) {
/* 319 */             setValue(Boolean.valueOf((param1CTTextCharacterProperties.getBaseline() > 0)));
/* 320 */             return true;
/*     */           } 
/* 322 */           return false;
/*     */         }
/*     */       };
/* 325 */     fetchCharacterProperty(characterPropertyFetcher);
/* 326 */     return (characterPropertyFetcher.getValue() == null) ? false : ((Boolean)characterPropertyFetcher.getValue()).booleanValue();
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
/* 339 */     getRPr(true).setBaseline((int)paramDouble * 1000);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSuperscript(boolean paramBoolean) {
/* 349 */     setBaselineOffset(paramBoolean ? 30.0D : 0.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSubscript(boolean paramBoolean) {
/* 359 */     setBaselineOffset(paramBoolean ? -25.0D : 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSubscript() {
/* 364 */     CharacterPropertyFetcher<Boolean> characterPropertyFetcher = new CharacterPropertyFetcher<Boolean>(this._p.getIndentLevel()) {
/*     */         public boolean fetch(CTTextCharacterProperties param1CTTextCharacterProperties) {
/* 366 */           if (param1CTTextCharacterProperties != null && param1CTTextCharacterProperties.isSetBaseline()) {
/* 367 */             setValue(Boolean.valueOf((param1CTTextCharacterProperties.getBaseline() < 0)));
/* 368 */             return true;
/*     */           } 
/* 370 */           return false;
/*     */         }
/*     */       };
/* 373 */     fetchCharacterProperty(characterPropertyFetcher);
/* 374 */     return (characterPropertyFetcher.getValue() == null) ? false : ((Boolean)characterPropertyFetcher.getValue()).booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextRun.TextCap getTextCap() {
/* 381 */     CharacterPropertyFetcher<TextRun.TextCap> characterPropertyFetcher = new CharacterPropertyFetcher<TextRun.TextCap>(this._p.getIndentLevel()) {
/*     */         public boolean fetch(CTTextCharacterProperties param1CTTextCharacterProperties) {
/* 383 */           if (param1CTTextCharacterProperties != null && param1CTTextCharacterProperties.isSetCap()) {
/* 384 */             int i = param1CTTextCharacterProperties.getCap().intValue() - 1;
/* 385 */             setValue(TextRun.TextCap.values()[i]);
/* 386 */             return true;
/*     */           } 
/* 388 */           return false;
/*     */         }
/*     */       };
/* 391 */     fetchCharacterProperty(characterPropertyFetcher);
/* 392 */     return (characterPropertyFetcher.getValue() == null) ? TextRun.TextCap.NONE : (TextRun.TextCap)characterPropertyFetcher.getValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBold(boolean paramBoolean) {
/* 397 */     getRPr(true).setB(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBold() {
/* 402 */     CharacterPropertyFetcher<Boolean> characterPropertyFetcher = new CharacterPropertyFetcher<Boolean>(this._p.getIndentLevel()) {
/*     */         public boolean fetch(CTTextCharacterProperties param1CTTextCharacterProperties) {
/* 404 */           if (param1CTTextCharacterProperties != null && param1CTTextCharacterProperties.isSetB()) {
/* 405 */             setValue(Boolean.valueOf(param1CTTextCharacterProperties.getB()));
/* 406 */             return true;
/*     */           } 
/* 408 */           return false;
/*     */         }
/*     */       };
/* 411 */     fetchCharacterProperty(characterPropertyFetcher);
/* 412 */     return (characterPropertyFetcher.getValue() == null) ? false : ((Boolean)characterPropertyFetcher.getValue()).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setItalic(boolean paramBoolean) {
/* 417 */     getRPr(true).setI(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isItalic() {
/* 422 */     CharacterPropertyFetcher<Boolean> characterPropertyFetcher = new CharacterPropertyFetcher<Boolean>(this._p.getIndentLevel()) {
/*     */         public boolean fetch(CTTextCharacterProperties param1CTTextCharacterProperties) {
/* 424 */           if (param1CTTextCharacterProperties != null && param1CTTextCharacterProperties.isSetI()) {
/* 425 */             setValue(Boolean.valueOf(param1CTTextCharacterProperties.getI()));
/* 426 */             return true;
/*     */           } 
/* 428 */           return false;
/*     */         }
/*     */       };
/* 431 */     fetchCharacterProperty(characterPropertyFetcher);
/* 432 */     return (characterPropertyFetcher.getValue() == null) ? false : ((Boolean)characterPropertyFetcher.getValue()).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUnderlined(boolean paramBoolean) {
/* 437 */     getRPr(true).setU(paramBoolean ? STTextUnderlineType.SNG : STTextUnderlineType.NONE);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isUnderlined() {
/* 442 */     CharacterPropertyFetcher<Boolean> characterPropertyFetcher = new CharacterPropertyFetcher<Boolean>(this._p.getIndentLevel()) {
/*     */         public boolean fetch(CTTextCharacterProperties param1CTTextCharacterProperties) {
/* 444 */           if (param1CTTextCharacterProperties != null && param1CTTextCharacterProperties.isSetU()) {
/* 445 */             setValue(Boolean.valueOf((param1CTTextCharacterProperties.getU() != STTextUnderlineType.NONE)));
/* 446 */             return true;
/*     */           } 
/* 448 */           return false;
/*     */         }
/*     */       };
/* 451 */     fetchCharacterProperty(characterPropertyFetcher);
/* 452 */     return (characterPropertyFetcher.getValue() == null) ? false : ((Boolean)characterPropertyFetcher.getValue()).booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CTTextCharacterProperties getRPr(boolean paramBoolean) {
/* 462 */     if (this._r.isSetRPr())
/* 463 */       return this._r.getRPr(); 
/* 464 */     if (paramBoolean) {
/* 465 */       return this._r.addNewRPr();
/*     */     }
/* 467 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 473 */     return "[" + getClass() + "]" + getRawText();
/*     */   }
/*     */ 
/*     */   
/*     */   public XSLFHyperlink createHyperlink() {
/* 478 */     XSLFHyperlink xSLFHyperlink = getHyperlink();
/* 479 */     if (xSLFHyperlink == null) {
/* 480 */       xSLFHyperlink = new XSLFHyperlink(this._r.getRPr().addNewHlinkClick(), this._p.getParentShape().getSheet());
/*     */     }
/* 482 */     return xSLFHyperlink;
/*     */   }
/*     */ 
/*     */   
/*     */   public XSLFHyperlink getHyperlink() {
/* 487 */     CTTextCharacterProperties cTTextCharacterProperties = this._r.getRPr();
/* 488 */     if (cTTextCharacterProperties == null) {
/* 489 */       return null;
/*     */     }
/* 491 */     CTHyperlink cTHyperlink = cTTextCharacterProperties.getHlinkClick();
/* 492 */     if (cTHyperlink == null) {
/* 493 */       return null;
/*     */     }
/* 495 */     return new XSLFHyperlink(cTHyperlink, this._p.getParentShape().getSheet());
/*     */   }
/*     */   
/*     */   private boolean fetchCharacterProperty(CharacterPropertyFetcher<?> paramCharacterPropertyFetcher) {
/* 499 */     XSLFTextShape xSLFTextShape = this._p.getParentShape();
/* 500 */     XSLFSheet xSLFSheet = xSLFTextShape.getSheet();
/* 501 */     boolean bool = false;
/*     */     
/* 503 */     if (this._r.isSetRPr()) bool = paramCharacterPropertyFetcher.fetch(getRPr(false)); 
/* 504 */     if (bool) return true;
/*     */     
/* 506 */     bool = xSLFTextShape.fetchShapeProperty((PropertyFetcher<?>)paramCharacterPropertyFetcher);
/* 507 */     if (bool) return true;
/*     */     
/* 509 */     CTPlaceholder cTPlaceholder = xSLFTextShape.getCTPlaceholder();
/* 510 */     if (cTPlaceholder == null) {
/*     */ 
/*     */       
/* 513 */       XMLSlideShow xMLSlideShow = xSLFSheet.getSlideShow();
/* 514 */       CTTextParagraphProperties cTTextParagraphProperties1 = xMLSlideShow.getDefaultParagraphStyle(this._p.getIndentLevel());
/* 515 */       if (cTTextParagraphProperties1 != null)
/*     */       {
/* 517 */         bool = paramCharacterPropertyFetcher.fetch(cTTextParagraphProperties1);
/*     */       }
/*     */     } 
/* 520 */     if (bool) return true;
/*     */     
/* 522 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.getDefaultMasterStyle();
/* 523 */     if (cTTextParagraphProperties != null)
/*     */     {
/* 525 */       bool = paramCharacterPropertyFetcher.fetch(cTTextParagraphProperties);
/*     */     }
/* 527 */     if (bool) return true;
/*     */     
/* 529 */     return false;
/*     */   }
/*     */   
/*     */   void copy(XSLFTextRun paramXSLFTextRun) {
/* 533 */     String str = paramXSLFTextRun.getFontFamily();
/* 534 */     if (str != null && !str.equals(getFontFamily())) {
/* 535 */       setFontFamily(str);
/*     */     }
/*     */     
/* 538 */     PaintStyle paintStyle = paramXSLFTextRun.getFontColor();
/* 539 */     if (paintStyle != null && !paintStyle.equals(getFontColor())) {
/* 540 */       setFontColor(paintStyle);
/*     */     }
/*     */     
/* 543 */     double d = paramXSLFTextRun.getFontSize().doubleValue();
/* 544 */     if (d != getFontSize().doubleValue()) {
/* 545 */       setFontSize(Double.valueOf(d));
/*     */     }
/*     */     
/* 548 */     boolean bool1 = paramXSLFTextRun.isBold();
/* 549 */     if (bool1 != isBold()) setBold(bool1);
/*     */     
/* 551 */     boolean bool2 = paramXSLFTextRun.isItalic();
/* 552 */     if (bool2 != isItalic()) setItalic(bool2);
/*     */     
/* 554 */     boolean bool3 = paramXSLFTextRun.isUnderlined();
/* 555 */     if (bool3 != isUnderlined()) setUnderlined(bool3);
/*     */     
/* 557 */     boolean bool4 = paramXSLFTextRun.isStrikethrough();
/* 558 */     if (bool4 != isStrikethrough()) setStrikethrough(bool4); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFTextRun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */