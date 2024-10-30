/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.Units;
/*     */ import org.apache.poi.xssf.model.ParagraphPropertyFetcher;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextAutonumberBullet;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePercent;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePoint;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharBullet;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextField;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STTextAlignType;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STTextAutonumberScheme;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STTextFontAlignType;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSSFTextParagraph
/*     */   implements Iterable<XSSFTextRun>
/*     */ {
/*     */   private final CTTextParagraph _p;
/*     */   private final CTShape _shape;
/*     */   private final List<XSSFTextRun> _runs;
/*     */   
/*     */   XSSFTextParagraph(CTTextParagraph paramCTTextParagraph, CTShape paramCTShape) {
/*  43 */     this._p = paramCTTextParagraph;
/*  44 */     this._shape = paramCTShape;
/*  45 */     this._runs = new ArrayList<XSSFTextRun>();
/*     */     
/*  47 */     for (XmlObject xmlObject : this._p.selectPath("*")) {
/*  48 */       if (xmlObject instanceof CTRegularTextRun) {
/*  49 */         CTRegularTextRun cTRegularTextRun = (CTRegularTextRun)xmlObject;
/*  50 */         this._runs.add(new XSSFTextRun(cTRegularTextRun, this));
/*  51 */       } else if (xmlObject instanceof CTTextLineBreak) {
/*  52 */         CTTextLineBreak cTTextLineBreak = (CTTextLineBreak)xmlObject;
/*  53 */         CTRegularTextRun cTRegularTextRun = CTRegularTextRun.Factory.newInstance();
/*  54 */         cTRegularTextRun.setRPr(cTTextLineBreak.getRPr());
/*  55 */         cTRegularTextRun.setT("\n");
/*  56 */         this._runs.add(new XSSFTextRun(cTRegularTextRun, this));
/*  57 */       } else if (xmlObject instanceof CTTextField) {
/*  58 */         CTTextField cTTextField = (CTTextField)xmlObject;
/*  59 */         CTRegularTextRun cTRegularTextRun = CTRegularTextRun.Factory.newInstance();
/*  60 */         cTRegularTextRun.setRPr(cTTextField.getRPr());
/*  61 */         cTRegularTextRun.setT(cTTextField.getT());
/*  62 */         this._runs.add(new XSSFTextRun(cTRegularTextRun, this));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getText() {
/*  68 */     StringBuilder stringBuilder = new StringBuilder();
/*  69 */     for (XSSFTextRun xSSFTextRun : this._runs) {
/*  70 */       stringBuilder.append(xSSFTextRun.getText());
/*     */     }
/*  72 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public CTTextParagraph getXmlObject() {
/*  77 */     return this._p;
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public CTShape getParentShape() {
/*  82 */     return this._shape;
/*     */   }
/*     */   
/*     */   public List<XSSFTextRun> getTextRuns() {
/*  86 */     return this._runs;
/*     */   }
/*     */   
/*     */   public Iterator<XSSFTextRun> iterator() {
/*  90 */     return this._runs.iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFTextRun addNewTextRun() {
/*  99 */     CTRegularTextRun cTRegularTextRun = this._p.addNewR();
/* 100 */     CTTextCharacterProperties cTTextCharacterProperties = cTRegularTextRun.addNewRPr();
/* 101 */     cTTextCharacterProperties.setLang("en-US");
/* 102 */     XSSFTextRun xSSFTextRun = new XSSFTextRun(cTRegularTextRun, this);
/* 103 */     this._runs.add(xSSFTextRun);
/* 104 */     return xSSFTextRun;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFTextRun addLineBreak() {
/* 113 */     CTTextLineBreak cTTextLineBreak = this._p.addNewBr();
/* 114 */     CTTextCharacterProperties cTTextCharacterProperties = cTTextLineBreak.addNewRPr();
/* 115 */     if (this._runs.size() > 0) {
/*     */       
/* 117 */       CTTextCharacterProperties cTTextCharacterProperties1 = ((XSSFTextRun)this._runs.get(this._runs.size() - 1)).getRPr();
/* 118 */       cTTextCharacterProperties.set((XmlObject)cTTextCharacterProperties1);
/*     */     } 
/* 120 */     CTRegularTextRun cTRegularTextRun = CTRegularTextRun.Factory.newInstance();
/* 121 */     cTRegularTextRun.setRPr(cTTextCharacterProperties);
/* 122 */     cTRegularTextRun.setT("\n");
/* 123 */     XSSFLineBreak xSSFLineBreak = new XSSFLineBreak(cTRegularTextRun, this, cTTextCharacterProperties);
/* 124 */     this._runs.add(xSSFLineBreak);
/* 125 */     return xSSFLineBreak;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextAlign getTextAlign() {
/* 135 */     ParagraphPropertyFetcher<TextAlign> paragraphPropertyFetcher = new ParagraphPropertyFetcher<TextAlign>(getLevel()) {
/*     */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/* 137 */           if (param1CTTextParagraphProperties.isSetAlgn()) {
/* 138 */             TextAlign textAlign = TextAlign.values()[param1CTTextParagraphProperties.getAlgn().intValue() - 1];
/* 139 */             setValue(textAlign);
/* 140 */             return true;
/*     */           } 
/* 142 */           return false;
/*     */         }
/*     */       };
/* 145 */     fetchParagraphProperty(paragraphPropertyFetcher);
/* 146 */     return (paragraphPropertyFetcher.getValue() == null) ? TextAlign.LEFT : (TextAlign)paragraphPropertyFetcher.getValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextAlign(TextAlign paramTextAlign) {
/* 157 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/* 158 */     if (paramTextAlign == null) {
/* 159 */       if (cTTextParagraphProperties.isSetAlgn()) cTTextParagraphProperties.unsetAlgn(); 
/*     */     } else {
/* 161 */       cTTextParagraphProperties.setAlgn(STTextAlignType.Enum.forInt(paramTextAlign.ordinal() + 1));
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
/*     */   public TextFontAlign getTextFontAlign() {
/* 173 */     ParagraphPropertyFetcher<TextFontAlign> paragraphPropertyFetcher = new ParagraphPropertyFetcher<TextFontAlign>(getLevel()) {
/*     */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/* 175 */           if (param1CTTextParagraphProperties.isSetFontAlgn()) {
/* 176 */             TextFontAlign textFontAlign = TextFontAlign.values()[param1CTTextParagraphProperties.getFontAlgn().intValue() - 1];
/* 177 */             setValue(textFontAlign);
/* 178 */             return true;
/*     */           } 
/* 180 */           return false;
/*     */         }
/*     */       };
/* 183 */     fetchParagraphProperty(paragraphPropertyFetcher);
/* 184 */     return (paragraphPropertyFetcher.getValue() == null) ? TextFontAlign.BASELINE : (TextFontAlign)paragraphPropertyFetcher.getValue();
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
/*     */   public void setTextFontAlign(TextFontAlign paramTextFontAlign) {
/* 196 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/* 197 */     if (paramTextFontAlign == null) {
/* 198 */       if (cTTextParagraphProperties.isSetFontAlgn()) cTTextParagraphProperties.unsetFontAlgn(); 
/*     */     } else {
/* 200 */       cTTextParagraphProperties.setFontAlgn(STTextFontAlignType.Enum.forInt(paramTextFontAlign.ordinal() + 1));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBulletFont() {
/* 208 */     ParagraphPropertyFetcher<String> paragraphPropertyFetcher = new ParagraphPropertyFetcher<String>(getLevel()) {
/*     */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/* 210 */           if (param1CTTextParagraphProperties.isSetBuFont()) {
/* 211 */             setValue(param1CTTextParagraphProperties.getBuFont().getTypeface());
/* 212 */             return true;
/*     */           } 
/* 214 */           return false;
/*     */         }
/*     */       };
/* 217 */     fetchParagraphProperty(paragraphPropertyFetcher);
/* 218 */     return (String)paragraphPropertyFetcher.getValue();
/*     */   }
/*     */   
/*     */   public void setBulletFont(String paramString) {
/* 222 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/* 223 */     CTTextFont cTTextFont = cTTextParagraphProperties.isSetBuFont() ? cTTextParagraphProperties.getBuFont() : cTTextParagraphProperties.addNewBuFont();
/* 224 */     cTTextFont.setTypeface(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBulletCharacter() {
/* 231 */     ParagraphPropertyFetcher<String> paragraphPropertyFetcher = new ParagraphPropertyFetcher<String>(getLevel()) {
/*     */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/* 233 */           if (param1CTTextParagraphProperties.isSetBuChar()) {
/* 234 */             setValue(param1CTTextParagraphProperties.getBuChar().getChar());
/* 235 */             return true;
/*     */           } 
/* 237 */           return false;
/*     */         }
/*     */       };
/* 240 */     fetchParagraphProperty(paragraphPropertyFetcher);
/* 241 */     return (String)paragraphPropertyFetcher.getValue();
/*     */   }
/*     */   
/*     */   public void setBulletCharacter(String paramString) {
/* 245 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/* 246 */     CTTextCharBullet cTTextCharBullet = cTTextParagraphProperties.isSetBuChar() ? cTTextParagraphProperties.getBuChar() : cTTextParagraphProperties.addNewBuChar();
/* 247 */     cTTextCharBullet.setChar(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getBulletFontColor() {
/* 256 */     ParagraphPropertyFetcher<Color> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Color>(getLevel()) {
/*     */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/* 258 */           if (param1CTTextParagraphProperties.isSetBuClr() && 
/* 259 */             param1CTTextParagraphProperties.getBuClr().isSetSrgbClr()) {
/* 260 */             CTSRgbColor cTSRgbColor = param1CTTextParagraphProperties.getBuClr().getSrgbClr();
/* 261 */             byte[] arrayOfByte = cTSRgbColor.getVal();
/* 262 */             setValue(new Color(0xFF & arrayOfByte[0], 0xFF & arrayOfByte[1], 0xFF & arrayOfByte[2]));
/* 263 */             return true;
/*     */           } 
/*     */           
/* 266 */           return false;
/*     */         }
/*     */       };
/* 269 */     fetchParagraphProperty(paragraphPropertyFetcher);
/* 270 */     return (Color)paragraphPropertyFetcher.getValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBulletFontColor(Color paramColor) {
/* 279 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/* 280 */     CTColor cTColor = cTTextParagraphProperties.isSetBuClr() ? cTTextParagraphProperties.getBuClr() : cTTextParagraphProperties.addNewBuClr();
/* 281 */     CTSRgbColor cTSRgbColor = cTColor.isSetSrgbClr() ? cTColor.getSrgbClr() : cTColor.addNewSrgbClr();
/* 282 */     cTSRgbColor.setVal(new byte[] { (byte)paramColor.getRed(), (byte)paramColor.getGreen(), (byte)paramColor.getBlue() });
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
/*     */   public double getBulletFontSize() {
/* 296 */     ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) {
/*     */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/* 298 */           if (param1CTTextParagraphProperties.isSetBuSzPct()) {
/* 299 */             setValue(Double.valueOf(param1CTTextParagraphProperties.getBuSzPct().getVal() * 0.001D));
/* 300 */             return true;
/*     */           } 
/* 302 */           if (param1CTTextParagraphProperties.isSetBuSzPts()) {
/* 303 */             setValue(Double.valueOf(-param1CTTextParagraphProperties.getBuSzPts().getVal() * 0.01D));
/* 304 */             return true;
/*     */           } 
/* 306 */           return false;
/*     */         }
/*     */       };
/* 309 */     fetchParagraphProperty(paragraphPropertyFetcher);
/* 310 */     return (paragraphPropertyFetcher.getValue() == null) ? 100.0D : ((Double)paragraphPropertyFetcher.getValue()).doubleValue();
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
/*     */   public void setBulletFontSize(double paramDouble) {
/* 322 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/*     */     
/* 324 */     if (paramDouble >= 0.0D) {
/*     */       
/* 326 */       CTTextBulletSizePercent cTTextBulletSizePercent = cTTextParagraphProperties.isSetBuSzPct() ? cTTextParagraphProperties.getBuSzPct() : cTTextParagraphProperties.addNewBuSzPct();
/* 327 */       cTTextBulletSizePercent.setVal((int)(paramDouble * 1000.0D));
/*     */       
/* 329 */       if (cTTextParagraphProperties.isSetBuSzPts()) cTTextParagraphProperties.unsetBuSzPts();
/*     */     
/*     */     } else {
/* 332 */       CTTextBulletSizePoint cTTextBulletSizePoint = cTTextParagraphProperties.isSetBuSzPts() ? cTTextParagraphProperties.getBuSzPts() : cTTextParagraphProperties.addNewBuSzPts();
/* 333 */       cTTextBulletSizePoint.setVal((int)(-paramDouble * 100.0D));
/*     */       
/* 335 */       if (cTTextParagraphProperties.isSetBuSzPct()) cTTextParagraphProperties.unsetBuSzPct();
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIndent(double paramDouble) {
/* 345 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/* 346 */     if (paramDouble == -1.0D) {
/* 347 */       if (cTTextParagraphProperties.isSetIndent()) cTTextParagraphProperties.unsetIndent(); 
/*     */     } else {
/* 349 */       cTTextParagraphProperties.setIndent(Units.toEMU(paramDouble));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getIndent() {
/* 358 */     ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) {
/*     */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/* 360 */           if (param1CTTextParagraphProperties.isSetIndent()) {
/* 361 */             setValue(Double.valueOf(Units.toPoints(param1CTTextParagraphProperties.getIndent())));
/* 362 */             return true;
/*     */           } 
/* 364 */           return false;
/*     */         }
/*     */       };
/* 367 */     fetchParagraphProperty(paragraphPropertyFetcher);
/*     */     
/* 369 */     return (paragraphPropertyFetcher.getValue() == null) ? 0.0D : ((Double)paragraphPropertyFetcher.getValue()).doubleValue();
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
/*     */   public void setLeftMargin(double paramDouble) {
/* 382 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/* 383 */     if (paramDouble == -1.0D) {
/* 384 */       if (cTTextParagraphProperties.isSetMarL()) cTTextParagraphProperties.unsetMarL(); 
/*     */     } else {
/* 386 */       cTTextParagraphProperties.setMarL(Units.toEMU(paramDouble));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getLeftMargin() {
/* 396 */     ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) {
/*     */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/* 398 */           if (param1CTTextParagraphProperties.isSetMarL()) {
/* 399 */             double d = Units.toPoints(param1CTTextParagraphProperties.getMarL());
/* 400 */             setValue(Double.valueOf(d));
/* 401 */             return true;
/*     */           } 
/* 403 */           return false;
/*     */         }
/*     */       };
/* 406 */     fetchParagraphProperty(paragraphPropertyFetcher);
/*     */     
/* 408 */     return (paragraphPropertyFetcher.getValue() == null) ? 0.0D : ((Double)paragraphPropertyFetcher.getValue()).doubleValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRightMargin(double paramDouble) {
/* 419 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/* 420 */     if (paramDouble == -1.0D) {
/* 421 */       if (cTTextParagraphProperties.isSetMarR()) cTTextParagraphProperties.unsetMarR(); 
/*     */     } else {
/* 423 */       cTTextParagraphProperties.setMarR(Units.toEMU(paramDouble));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getRightMargin() {
/* 433 */     ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) {
/*     */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/* 435 */           if (param1CTTextParagraphProperties.isSetMarR()) {
/* 436 */             double d = Units.toPoints(param1CTTextParagraphProperties.getMarR());
/* 437 */             setValue(Double.valueOf(d));
/* 438 */             return true;
/*     */           } 
/* 440 */           return false;
/*     */         }
/*     */       };
/* 443 */     fetchParagraphProperty(paragraphPropertyFetcher);
/*     */     
/* 445 */     return (paragraphPropertyFetcher.getValue() == null) ? 0.0D : ((Double)paragraphPropertyFetcher.getValue()).doubleValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getDefaultTabSize() {
/* 453 */     ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) {
/*     */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/* 455 */           if (param1CTTextParagraphProperties.isSetDefTabSz()) {
/* 456 */             double d = Units.toPoints(param1CTTextParagraphProperties.getDefTabSz());
/* 457 */             setValue(Double.valueOf(d));
/* 458 */             return true;
/*     */           } 
/* 460 */           return false;
/*     */         }
/*     */       };
/* 463 */     fetchParagraphProperty(paragraphPropertyFetcher);
/* 464 */     return (paragraphPropertyFetcher.getValue() == null) ? 0.0D : ((Double)paragraphPropertyFetcher.getValue()).doubleValue();
/*     */   }
/*     */   
/*     */   public double getTabStop(final int idx) {
/* 468 */     ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) {
/*     */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/* 470 */           if (param1CTTextParagraphProperties.isSetTabLst()) {
/* 471 */             CTTextTabStopList cTTextTabStopList = param1CTTextParagraphProperties.getTabLst();
/* 472 */             if (idx < cTTextTabStopList.sizeOfTabArray()) {
/* 473 */               CTTextTabStop cTTextTabStop = cTTextTabStopList.getTabArray(idx);
/* 474 */               double d = Units.toPoints(cTTextTabStop.getPos());
/* 475 */               setValue(Double.valueOf(d));
/* 476 */               return true;
/*     */             } 
/*     */           } 
/* 479 */           return false;
/*     */         }
/*     */       };
/* 482 */     fetchParagraphProperty(paragraphPropertyFetcher);
/* 483 */     return (paragraphPropertyFetcher.getValue() == null) ? 0.0D : ((Double)paragraphPropertyFetcher.getValue()).doubleValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addTabStop(double paramDouble) {
/* 492 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/* 493 */     CTTextTabStopList cTTextTabStopList = cTTextParagraphProperties.isSetTabLst() ? cTTextParagraphProperties.getTabLst() : cTTextParagraphProperties.addNewTabLst();
/* 494 */     cTTextTabStopList.addNewTab().setPos(Units.toEMU(paramDouble));
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
/*     */   public void setLineSpacing(double paramDouble) {
/* 519 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/* 520 */     CTTextSpacing cTTextSpacing = CTTextSpacing.Factory.newInstance();
/* 521 */     if (paramDouble >= 0.0D) { cTTextSpacing.addNewSpcPct().setVal((int)(paramDouble * 1000.0D)); }
/* 522 */     else { cTTextSpacing.addNewSpcPts().setVal((int)(-paramDouble * 100.0D)); }
/* 523 */      cTTextParagraphProperties.setLnSpc(cTTextSpacing);
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
/*     */   public double getLineSpacing() {
/* 537 */     ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) {
/*     */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/* 539 */           if (param1CTTextParagraphProperties.isSetLnSpc()) {
/* 540 */             CTTextSpacing cTTextSpacing = param1CTTextParagraphProperties.getLnSpc();
/*     */             
/* 542 */             if (cTTextSpacing.isSetSpcPct()) { setValue(Double.valueOf(cTTextSpacing.getSpcPct().getVal() * 0.001D)); }
/* 543 */             else if (cTTextSpacing.isSetSpcPts()) { setValue(Double.valueOf(-cTTextSpacing.getSpcPts().getVal() * 0.01D)); }
/* 544 */              return true;
/*     */           } 
/* 546 */           return false;
/*     */         }
/*     */       };
/* 549 */     fetchParagraphProperty(paragraphPropertyFetcher);
/*     */     
/* 551 */     double d = (paragraphPropertyFetcher.getValue() == null) ? 100.0D : ((Double)paragraphPropertyFetcher.getValue()).doubleValue();
/* 552 */     if (d > 0.0D) {
/*     */       
/* 554 */       CTTextNormalAutofit cTTextNormalAutofit = this._shape.getTxBody().getBodyPr().getNormAutofit();
/* 555 */       if (cTTextNormalAutofit != null) {
/* 556 */         double d1 = 1.0D - cTTextNormalAutofit.getLnSpcReduction() / 100000.0D;
/* 557 */         d *= d1;
/*     */       } 
/*     */     } 
/*     */     
/* 561 */     return d;
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
/*     */   public void setSpaceBefore(double paramDouble) {
/* 584 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/* 585 */     CTTextSpacing cTTextSpacing = CTTextSpacing.Factory.newInstance();
/* 586 */     if (paramDouble >= 0.0D) { cTTextSpacing.addNewSpcPct().setVal((int)(paramDouble * 1000.0D)); }
/* 587 */     else { cTTextSpacing.addNewSpcPts().setVal((int)(-paramDouble * 100.0D)); }
/* 588 */      cTTextParagraphProperties.setSpcBef(cTTextSpacing);
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
/*     */   public double getSpaceBefore() {
/* 602 */     ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) {
/*     */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/* 604 */           if (param1CTTextParagraphProperties.isSetSpcBef()) {
/* 605 */             CTTextSpacing cTTextSpacing = param1CTTextParagraphProperties.getSpcBef();
/*     */             
/* 607 */             if (cTTextSpacing.isSetSpcPct()) { setValue(Double.valueOf(cTTextSpacing.getSpcPct().getVal() * 0.001D)); }
/* 608 */             else if (cTTextSpacing.isSetSpcPts()) { setValue(Double.valueOf(-cTTextSpacing.getSpcPts().getVal() * 0.01D)); }
/* 609 */              return true;
/*     */           } 
/* 611 */           return false;
/*     */         }
/*     */       };
/* 614 */     fetchParagraphProperty(paragraphPropertyFetcher);
/*     */     
/* 616 */     return (paragraphPropertyFetcher.getValue() == null) ? 0.0D : ((Double)paragraphPropertyFetcher.getValue()).doubleValue();
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
/*     */   public void setSpaceAfter(double paramDouble) {
/* 640 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/* 641 */     CTTextSpacing cTTextSpacing = CTTextSpacing.Factory.newInstance();
/* 642 */     if (paramDouble >= 0.0D) { cTTextSpacing.addNewSpcPct().setVal((int)(paramDouble * 1000.0D)); }
/* 643 */     else { cTTextSpacing.addNewSpcPts().setVal((int)(-paramDouble * 100.0D)); }
/* 644 */      cTTextParagraphProperties.setSpcAft(cTTextSpacing);
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
/*     */   public double getSpaceAfter() {
/* 658 */     ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) {
/*     */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/* 660 */           if (param1CTTextParagraphProperties.isSetSpcAft()) {
/* 661 */             CTTextSpacing cTTextSpacing = param1CTTextParagraphProperties.getSpcAft();
/*     */             
/* 663 */             if (cTTextSpacing.isSetSpcPct()) { setValue(Double.valueOf(cTTextSpacing.getSpcPct().getVal() * 0.001D)); }
/* 664 */             else if (cTTextSpacing.isSetSpcPts()) { setValue(Double.valueOf(-cTTextSpacing.getSpcPts().getVal() * 0.01D)); }
/* 665 */              return true;
/*     */           } 
/* 667 */           return false;
/*     */         }
/*     */       };
/* 670 */     fetchParagraphProperty(paragraphPropertyFetcher);
/* 671 */     return (paragraphPropertyFetcher.getValue() == null) ? 0.0D : ((Double)paragraphPropertyFetcher.getValue()).doubleValue();
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
/*     */   public void setLevel(int paramInt) {
/* 688 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/*     */     
/* 690 */     cTTextParagraphProperties.setLvl(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLevel() {
/* 699 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.getPPr();
/* 700 */     if (cTTextParagraphProperties == null) return 0;
/*     */     
/* 702 */     return cTTextParagraphProperties.getLvl();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBullet() {
/* 710 */     ParagraphPropertyFetcher<Boolean> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Boolean>(getLevel()) {
/*     */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/* 712 */           if (param1CTTextParagraphProperties.isSetBuNone()) {
/* 713 */             setValue(Boolean.valueOf(false));
/* 714 */             return true;
/*     */           } 
/* 716 */           if (param1CTTextParagraphProperties.isSetBuFont() && (
/* 717 */             param1CTTextParagraphProperties.isSetBuChar() || param1CTTextParagraphProperties.isSetBuAutoNum())) {
/* 718 */             setValue(Boolean.valueOf(true));
/* 719 */             return true;
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 726 */           return false;
/*     */         }
/*     */       };
/* 729 */     fetchParagraphProperty(paragraphPropertyFetcher);
/* 730 */     return (paragraphPropertyFetcher.getValue() == null) ? false : ((Boolean)paragraphPropertyFetcher.getValue()).booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBullet(boolean paramBoolean) {
/* 739 */     if (isBullet() == paramBoolean)
/*     */       return; 
/* 741 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/* 742 */     if (!paramBoolean) {
/* 743 */       cTTextParagraphProperties.addNewBuNone();
/*     */       
/* 745 */       if (cTTextParagraphProperties.isSetBuAutoNum()) cTTextParagraphProperties.unsetBuAutoNum(); 
/* 746 */       if (cTTextParagraphProperties.isSetBuBlip()) cTTextParagraphProperties.unsetBuBlip(); 
/* 747 */       if (cTTextParagraphProperties.isSetBuChar()) cTTextParagraphProperties.unsetBuChar(); 
/* 748 */       if (cTTextParagraphProperties.isSetBuClr()) cTTextParagraphProperties.unsetBuClr(); 
/* 749 */       if (cTTextParagraphProperties.isSetBuClrTx()) cTTextParagraphProperties.unsetBuClrTx(); 
/* 750 */       if (cTTextParagraphProperties.isSetBuFont()) cTTextParagraphProperties.unsetBuFont(); 
/* 751 */       if (cTTextParagraphProperties.isSetBuFontTx()) cTTextParagraphProperties.unsetBuFontTx(); 
/* 752 */       if (cTTextParagraphProperties.isSetBuSzPct()) cTTextParagraphProperties.unsetBuSzPct(); 
/* 753 */       if (cTTextParagraphProperties.isSetBuSzPts()) cTTextParagraphProperties.unsetBuSzPts(); 
/* 754 */       if (cTTextParagraphProperties.isSetBuSzTx()) cTTextParagraphProperties.unsetBuSzTx(); 
/*     */     } else {
/* 756 */       if (cTTextParagraphProperties.isSetBuNone()) cTTextParagraphProperties.unsetBuNone(); 
/* 757 */       if (!cTTextParagraphProperties.isSetBuFont()) cTTextParagraphProperties.addNewBuFont().setTypeface("Arial"); 
/* 758 */       if (!cTTextParagraphProperties.isSetBuAutoNum()) cTTextParagraphProperties.addNewBuChar().setChar("•");
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBullet(ListAutoNumber paramListAutoNumber, int paramInt) {
/* 770 */     if (paramInt < 1) throw new IllegalArgumentException("Start Number must be greater or equal that 1"); 
/* 771 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/* 772 */     CTTextAutonumberBullet cTTextAutonumberBullet = cTTextParagraphProperties.isSetBuAutoNum() ? cTTextParagraphProperties.getBuAutoNum() : cTTextParagraphProperties.addNewBuAutoNum();
/* 773 */     cTTextAutonumberBullet.setType(STTextAutonumberScheme.Enum.forInt(paramListAutoNumber.ordinal() + 1));
/* 774 */     cTTextAutonumberBullet.setStartAt(paramInt);
/*     */     
/* 776 */     if (!cTTextParagraphProperties.isSetBuFont()) cTTextParagraphProperties.addNewBuFont().setTypeface("Arial"); 
/* 777 */     if (cTTextParagraphProperties.isSetBuNone()) cTTextParagraphProperties.unsetBuNone();
/*     */     
/* 779 */     if (cTTextParagraphProperties.isSetBuBlip()) cTTextParagraphProperties.unsetBuBlip(); 
/* 780 */     if (cTTextParagraphProperties.isSetBuChar()) cTTextParagraphProperties.unsetBuChar();
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBullet(ListAutoNumber paramListAutoNumber) {
/* 789 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/* 790 */     CTTextAutonumberBullet cTTextAutonumberBullet = cTTextParagraphProperties.isSetBuAutoNum() ? cTTextParagraphProperties.getBuAutoNum() : cTTextParagraphProperties.addNewBuAutoNum();
/* 791 */     cTTextAutonumberBullet.setType(STTextAutonumberScheme.Enum.forInt(paramListAutoNumber.ordinal() + 1));
/*     */     
/* 793 */     if (!cTTextParagraphProperties.isSetBuFont()) cTTextParagraphProperties.addNewBuFont().setTypeface("Arial"); 
/* 794 */     if (cTTextParagraphProperties.isSetBuNone()) cTTextParagraphProperties.unsetBuNone();
/*     */     
/* 796 */     if (cTTextParagraphProperties.isSetBuBlip()) cTTextParagraphProperties.unsetBuBlip(); 
/* 797 */     if (cTTextParagraphProperties.isSetBuChar()) cTTextParagraphProperties.unsetBuChar();
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBulletAutoNumber() {
/* 804 */     ParagraphPropertyFetcher<Boolean> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Boolean>(getLevel()) {
/*     */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/* 806 */           if (param1CTTextParagraphProperties.isSetBuAutoNum()) {
/* 807 */             setValue(Boolean.valueOf(true));
/* 808 */             return true;
/*     */           } 
/* 810 */           return false;
/*     */         }
/*     */       };
/* 813 */     fetchParagraphProperty(paragraphPropertyFetcher);
/* 814 */     return (paragraphPropertyFetcher.getValue() == null) ? false : ((Boolean)paragraphPropertyFetcher.getValue()).booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBulletAutoNumberStart() {
/* 821 */     ParagraphPropertyFetcher<Integer> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Integer>(getLevel()) {
/*     */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/* 823 */           if (param1CTTextParagraphProperties.isSetBuAutoNum() && param1CTTextParagraphProperties.getBuAutoNum().isSetStartAt()) {
/* 824 */             setValue(Integer.valueOf(param1CTTextParagraphProperties.getBuAutoNum().getStartAt()));
/* 825 */             return true;
/*     */           } 
/* 827 */           return false;
/*     */         }
/*     */       };
/* 830 */     fetchParagraphProperty(paragraphPropertyFetcher);
/* 831 */     return (paragraphPropertyFetcher.getValue() == null) ? 0 : ((Integer)paragraphPropertyFetcher.getValue()).intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ListAutoNumber getBulletAutoNumberScheme() {
/* 838 */     ParagraphPropertyFetcher<ListAutoNumber> paragraphPropertyFetcher = new ParagraphPropertyFetcher<ListAutoNumber>(getLevel()) {
/*     */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/* 840 */           if (param1CTTextParagraphProperties.isSetBuAutoNum()) {
/* 841 */             setValue(ListAutoNumber.values()[param1CTTextParagraphProperties.getBuAutoNum().getType().intValue() - 1]);
/* 842 */             return true;
/*     */           } 
/* 844 */           return false;
/*     */         }
/*     */       };
/* 847 */     fetchParagraphProperty(paragraphPropertyFetcher);
/*     */ 
/*     */     
/* 850 */     return (paragraphPropertyFetcher.getValue() == null) ? ListAutoNumber.ARABIC_PLAIN : (ListAutoNumber)paragraphPropertyFetcher.getValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean fetchParagraphProperty(ParagraphPropertyFetcher paramParagraphPropertyFetcher) {
/* 856 */     boolean bool = false;
/*     */     
/* 858 */     if (this._p.isSetPPr()) bool = paramParagraphPropertyFetcher.fetch(this._p.getPPr());
/*     */     
/* 860 */     if (!bool) {
/* 861 */       bool = paramParagraphPropertyFetcher.fetch(this._shape);
/*     */     }
/*     */     
/* 864 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 869 */     return "[" + getClass() + "]" + getText();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFTextParagraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */