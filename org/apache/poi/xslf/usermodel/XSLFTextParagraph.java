/*      */ package org.apache.poi.xslf.usermodel;
/*      */ 
/*      */ import java.awt.Color;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import org.apache.poi.sl.draw.DrawPaint;
/*      */ import org.apache.poi.sl.usermodel.AutoNumberingScheme;
/*      */ import org.apache.poi.sl.usermodel.PaintStyle;
/*      */ import org.apache.poi.sl.usermodel.TextParagraph;
/*      */ import org.apache.poi.sl.usermodel.TextShape;
/*      */ import org.apache.poi.util.Internal;
/*      */ import org.apache.poi.util.Units;
/*      */ import org.apache.poi.xslf.model.ParagraphPropertyFetcher;
/*      */ import org.apache.poi.xslf.model.PropertyFetcher;
/*      */ import org.apache.xmlbeans.XmlCursor;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextAutonumberBullet;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePercent;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePoint;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharBullet;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextField;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.STTextAlignType;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.STTextAutonumberScheme;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.STTextFontAlignType;
/*      */ import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;
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
/*      */ public class XSLFTextParagraph
/*      */   implements TextParagraph<XSLFShape, XSLFTextParagraph, XSLFTextRun>
/*      */ {
/*      */   private final CTTextParagraph _p;
/*      */   private final List<XSLFTextRun> _runs;
/*      */   private final XSLFTextShape _shape;
/*      */   
/*      */   XSLFTextParagraph(CTTextParagraph paramCTTextParagraph, XSLFTextShape paramXSLFTextShape) {
/*   71 */     this._p = paramCTTextParagraph;
/*   72 */     this._runs = new ArrayList<XSLFTextRun>();
/*   73 */     this._shape = paramXSLFTextShape;
/*      */     
/*   75 */     for (XmlObject xmlObject : this._p.selectPath("*")) {
/*   76 */       if (xmlObject instanceof CTRegularTextRun) {
/*   77 */         CTRegularTextRun cTRegularTextRun = (CTRegularTextRun)xmlObject;
/*   78 */         this._runs.add(newTextRun(cTRegularTextRun));
/*   79 */       } else if (xmlObject instanceof CTTextLineBreak) {
/*   80 */         CTTextLineBreak cTTextLineBreak = (CTTextLineBreak)xmlObject;
/*   81 */         CTRegularTextRun cTRegularTextRun = CTRegularTextRun.Factory.newInstance();
/*   82 */         cTRegularTextRun.setRPr(cTTextLineBreak.getRPr());
/*   83 */         cTRegularTextRun.setT("\n");
/*   84 */         this._runs.add(newTextRun(cTRegularTextRun));
/*   85 */       } else if (xmlObject instanceof CTTextField) {
/*   86 */         CTTextField cTTextField = (CTTextField)xmlObject;
/*   87 */         CTRegularTextRun cTRegularTextRun = CTRegularTextRun.Factory.newInstance();
/*   88 */         cTRegularTextRun.setRPr(cTTextField.getRPr());
/*   89 */         cTRegularTextRun.setT(cTTextField.getT());
/*   90 */         this._runs.add(newTextRun(cTRegularTextRun));
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public String getText() {
/*   96 */     StringBuilder stringBuilder = new StringBuilder();
/*   97 */     for (XSLFTextRun xSLFTextRun : this._runs) {
/*   98 */       stringBuilder.append(xSLFTextRun.getRawText());
/*      */     }
/*  100 */     return stringBuilder.toString();
/*      */   }
/*      */   
/*      */   String getRenderableText() {
/*  104 */     StringBuilder stringBuilder = new StringBuilder();
/*  105 */     for (XSLFTextRun xSLFTextRun : this._runs) {
/*  106 */       stringBuilder.append(xSLFTextRun.getRenderableText());
/*      */     }
/*  108 */     return stringBuilder.toString();
/*      */   }
/*      */   
/*      */   @Internal
/*      */   public CTTextParagraph getXmlObject() {
/*  113 */     return this._p;
/*      */   }
/*      */   
/*      */   public XSLFTextShape getParentShape() {
/*  117 */     return this._shape;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public List<XSLFTextRun> getTextRuns() {
/*  123 */     return this._runs;
/*      */   }
/*      */   
/*      */   public Iterator<XSLFTextRun> iterator() {
/*  127 */     return this._runs.iterator();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSLFTextRun addNewTextRun() {
/*  136 */     CTRegularTextRun cTRegularTextRun = this._p.addNewR();
/*  137 */     CTTextCharacterProperties cTTextCharacterProperties = cTRegularTextRun.addNewRPr();
/*  138 */     cTTextCharacterProperties.setLang("en-US");
/*  139 */     XSLFTextRun xSLFTextRun = newTextRun(cTRegularTextRun);
/*  140 */     this._runs.add(xSLFTextRun);
/*  141 */     return xSLFTextRun;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSLFTextRun addLineBreak() {
/*  150 */     CTTextLineBreak cTTextLineBreak = this._p.addNewBr();
/*  151 */     CTTextCharacterProperties cTTextCharacterProperties = cTTextLineBreak.addNewRPr();
/*  152 */     if (this._runs.size() > 0) {
/*      */       
/*  154 */       CTTextCharacterProperties cTTextCharacterProperties1 = ((XSLFTextRun)this._runs.get(this._runs.size() - 1)).getRPr(true);
/*  155 */       cTTextCharacterProperties.set((XmlObject)cTTextCharacterProperties1);
/*      */     } 
/*  157 */     CTRegularTextRun cTRegularTextRun = CTRegularTextRun.Factory.newInstance();
/*  158 */     cTRegularTextRun.setRPr(cTTextCharacterProperties);
/*  159 */     cTRegularTextRun.setT("\n");
/*  160 */     XSLFLineBreak xSLFLineBreak = new XSLFLineBreak(cTRegularTextRun, this, cTTextCharacterProperties);
/*  161 */     this._runs.add(xSLFLineBreak);
/*  162 */     return xSLFLineBreak;
/*      */   }
/*      */ 
/*      */   
/*      */   public TextParagraph.TextAlign getTextAlign() {
/*  167 */     ParagraphPropertyFetcher<TextParagraph.TextAlign> paragraphPropertyFetcher = new ParagraphPropertyFetcher<TextParagraph.TextAlign>(getIndentLevel()) {
/*      */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/*  169 */           if (param1CTTextParagraphProperties.isSetAlgn()) {
/*  170 */             TextParagraph.TextAlign textAlign = TextParagraph.TextAlign.values()[param1CTTextParagraphProperties.getAlgn().intValue() - 1];
/*  171 */             setValue(textAlign);
/*  172 */             return true;
/*      */           } 
/*  174 */           return false;
/*      */         }
/*      */       };
/*  177 */     fetchParagraphProperty(paragraphPropertyFetcher);
/*  178 */     return (TextParagraph.TextAlign)paragraphPropertyFetcher.getValue();
/*      */   }
/*      */ 
/*      */   
/*      */   public void setTextAlign(TextParagraph.TextAlign paramTextAlign) {
/*  183 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/*  184 */     if (paramTextAlign == null) {
/*  185 */       if (cTTextParagraphProperties.isSetAlgn()) cTTextParagraphProperties.unsetAlgn(); 
/*      */     } else {
/*  187 */       cTTextParagraphProperties.setAlgn(STTextAlignType.Enum.forInt(paramTextAlign.ordinal() + 1));
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public TextParagraph.FontAlign getFontAlign() {
/*  193 */     ParagraphPropertyFetcher<TextParagraph.FontAlign> paragraphPropertyFetcher = new ParagraphPropertyFetcher<TextParagraph.FontAlign>(getIndentLevel()) {
/*      */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/*  195 */           if (param1CTTextParagraphProperties.isSetFontAlgn()) {
/*  196 */             TextParagraph.FontAlign fontAlign = TextParagraph.FontAlign.values()[param1CTTextParagraphProperties.getFontAlgn().intValue() - 1];
/*  197 */             setValue(fontAlign);
/*  198 */             return true;
/*      */           } 
/*  200 */           return false;
/*      */         }
/*      */       };
/*  203 */     fetchParagraphProperty(paragraphPropertyFetcher);
/*  204 */     return (TextParagraph.FontAlign)paragraphPropertyFetcher.getValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFontAlign(TextParagraph.FontAlign paramFontAlign) {
/*  215 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/*  216 */     if (paramFontAlign == null) {
/*  217 */       if (cTTextParagraphProperties.isSetFontAlgn()) cTTextParagraphProperties.unsetFontAlgn(); 
/*      */     } else {
/*  219 */       cTTextParagraphProperties.setFontAlgn(STTextFontAlignType.Enum.forInt(paramFontAlign.ordinal() + 1));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getBulletFont() {
/*  229 */     ParagraphPropertyFetcher<String> paragraphPropertyFetcher = new ParagraphPropertyFetcher<String>(getIndentLevel()) {
/*      */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/*  231 */           if (param1CTTextParagraphProperties.isSetBuFont()) {
/*  232 */             setValue(param1CTTextParagraphProperties.getBuFont().getTypeface());
/*  233 */             return true;
/*      */           } 
/*  235 */           return false;
/*      */         }
/*      */       };
/*  238 */     fetchParagraphProperty(paragraphPropertyFetcher);
/*  239 */     return (String)paragraphPropertyFetcher.getValue();
/*      */   }
/*      */   
/*      */   public void setBulletFont(String paramString) {
/*  243 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/*  244 */     CTTextFont cTTextFont = cTTextParagraphProperties.isSetBuFont() ? cTTextParagraphProperties.getBuFont() : cTTextParagraphProperties.addNewBuFont();
/*  245 */     cTTextFont.setTypeface(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getBulletCharacter() {
/*  252 */     ParagraphPropertyFetcher<String> paragraphPropertyFetcher = new ParagraphPropertyFetcher<String>(getIndentLevel()) {
/*      */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/*  254 */           if (param1CTTextParagraphProperties.isSetBuChar()) {
/*  255 */             setValue(param1CTTextParagraphProperties.getBuChar().getChar());
/*  256 */             return true;
/*      */           } 
/*  258 */           return false;
/*      */         }
/*      */       };
/*  261 */     fetchParagraphProperty(paragraphPropertyFetcher);
/*  262 */     return (String)paragraphPropertyFetcher.getValue();
/*      */   }
/*      */   
/*      */   public void setBulletCharacter(String paramString) {
/*  266 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/*  267 */     CTTextCharBullet cTTextCharBullet = cTTextParagraphProperties.isSetBuChar() ? cTTextParagraphProperties.getBuChar() : cTTextParagraphProperties.addNewBuChar();
/*  268 */     cTTextCharBullet.setChar(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PaintStyle getBulletFontColor() {
/*  277 */     final XSLFTheme theme = getParentShape().getSheet().getTheme();
/*  278 */     ParagraphPropertyFetcher<Color> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Color>(getIndentLevel()) {
/*      */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/*  280 */           if (param1CTTextParagraphProperties.isSetBuClr()) {
/*  281 */             XSLFColor xSLFColor = new XSLFColor((XmlObject)param1CTTextParagraphProperties.getBuClr(), theme, null);
/*  282 */             setValue(xSLFColor.getColor());
/*  283 */             return true;
/*      */           } 
/*  285 */           return false;
/*      */         }
/*      */       };
/*  288 */     fetchParagraphProperty(paragraphPropertyFetcher);
/*  289 */     Color color = (Color)paragraphPropertyFetcher.getValue();
/*  290 */     return (color == null) ? null : (PaintStyle)DrawPaint.createSolidPaint(color);
/*      */   }
/*      */   
/*      */   public void setBulletFontColor(Color paramColor) {
/*  294 */     setBulletFontColor((PaintStyle)DrawPaint.createSolidPaint(paramColor));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBulletFontColor(PaintStyle paramPaintStyle) {
/*  304 */     if (!(paramPaintStyle instanceof PaintStyle.SolidPaint)) {
/*  305 */       throw new IllegalArgumentException("Currently XSLF only supports SolidPaint");
/*      */     }
/*      */ 
/*      */     
/*  309 */     PaintStyle.SolidPaint solidPaint = (PaintStyle.SolidPaint)paramPaintStyle;
/*  310 */     Color color = DrawPaint.applyColorTransform(solidPaint.getSolidColor());
/*      */     
/*  312 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/*  313 */     CTColor cTColor = cTTextParagraphProperties.isSetBuClr() ? cTTextParagraphProperties.getBuClr() : cTTextParagraphProperties.addNewBuClr();
/*  314 */     CTSRgbColor cTSRgbColor = cTColor.isSetSrgbClr() ? cTColor.getSrgbClr() : cTColor.addNewSrgbClr();
/*  315 */     cTSRgbColor.setVal(new byte[] { (byte)color.getRed(), (byte)color.getGreen(), (byte)color.getBlue() });
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
/*      */   public Double getBulletFontSize() {
/*  329 */     ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getIndentLevel()) {
/*      */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/*  331 */           if (param1CTTextParagraphProperties.isSetBuSzPct()) {
/*  332 */             setValue(Double.valueOf(param1CTTextParagraphProperties.getBuSzPct().getVal() * 0.001D));
/*  333 */             return true;
/*      */           } 
/*  335 */           if (param1CTTextParagraphProperties.isSetBuSzPts()) {
/*  336 */             setValue(Double.valueOf(-param1CTTextParagraphProperties.getBuSzPts().getVal() * 0.01D));
/*  337 */             return true;
/*      */           } 
/*  339 */           return false;
/*      */         }
/*      */       };
/*  342 */     fetchParagraphProperty(paragraphPropertyFetcher);
/*  343 */     return (Double)paragraphPropertyFetcher.getValue();
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
/*      */   public void setBulletFontSize(double paramDouble) {
/*  355 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/*      */     
/*  357 */     if (paramDouble >= 0.0D) {
/*  358 */       CTTextBulletSizePercent cTTextBulletSizePercent = cTTextParagraphProperties.isSetBuSzPct() ? cTTextParagraphProperties.getBuSzPct() : cTTextParagraphProperties.addNewBuSzPct();
/*  359 */       cTTextBulletSizePercent.setVal((int)(paramDouble * 1000.0D));
/*  360 */       if (cTTextParagraphProperties.isSetBuSzPts()) cTTextParagraphProperties.unsetBuSzPts(); 
/*      */     } else {
/*  362 */       CTTextBulletSizePoint cTTextBulletSizePoint = cTTextParagraphProperties.isSetBuSzPts() ? cTTextParagraphProperties.getBuSzPts() : cTTextParagraphProperties.addNewBuSzPts();
/*  363 */       cTTextBulletSizePoint.setVal((int)(-paramDouble * 100.0D));
/*  364 */       if (cTTextParagraphProperties.isSetBuSzPct()) cTTextParagraphProperties.unsetBuSzPct();
/*      */     
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public AutoNumberingScheme getAutoNumberingScheme() {
/*  372 */     ParagraphPropertyFetcher<AutoNumberingScheme> paragraphPropertyFetcher = new ParagraphPropertyFetcher<AutoNumberingScheme>(getIndentLevel()) {
/*      */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/*  374 */           if (param1CTTextParagraphProperties.isSetBuAutoNum()) {
/*  375 */             AutoNumberingScheme autoNumberingScheme = AutoNumberingScheme.forOoxmlID(param1CTTextParagraphProperties.getBuAutoNum().getType().intValue());
/*  376 */             if (autoNumberingScheme != null) {
/*  377 */               setValue(autoNumberingScheme);
/*  378 */               return true;
/*      */             } 
/*      */           } 
/*  381 */           return false;
/*      */         }
/*      */       };
/*  384 */     fetchParagraphProperty(paragraphPropertyFetcher);
/*  385 */     return (AutoNumberingScheme)paragraphPropertyFetcher.getValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Integer getAutoNumberingStartAt() {
/*  392 */     ParagraphPropertyFetcher<Integer> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Integer>(getIndentLevel()) {
/*      */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/*  394 */           if (param1CTTextParagraphProperties.isSetBuAutoNum() && 
/*  395 */             param1CTTextParagraphProperties.getBuAutoNum().isSetStartAt()) {
/*  396 */             setValue(Integer.valueOf(param1CTTextParagraphProperties.getBuAutoNum().getStartAt()));
/*  397 */             return true;
/*      */           } 
/*      */           
/*  400 */           return false;
/*      */         }
/*      */       };
/*  403 */     fetchParagraphProperty(paragraphPropertyFetcher);
/*  404 */     return (Integer)paragraphPropertyFetcher.getValue();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIndent(Double paramDouble) {
/*  410 */     if (paramDouble == null && !this._p.isSetPPr())
/*  411 */       return;  CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/*  412 */     if (paramDouble == null) {
/*  413 */       if (cTTextParagraphProperties.isSetIndent()) cTTextParagraphProperties.unsetIndent(); 
/*      */     } else {
/*  415 */       cTTextParagraphProperties.setIndent(Units.toEMU(paramDouble.doubleValue()));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Double getIndent() {
/*  422 */     ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getIndentLevel()) {
/*      */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/*  424 */           if (param1CTTextParagraphProperties.isSetIndent()) {
/*  425 */             setValue(Double.valueOf(Units.toPoints(param1CTTextParagraphProperties.getIndent())));
/*  426 */             return true;
/*      */           } 
/*  428 */           return false;
/*      */         }
/*      */       };
/*  431 */     fetchParagraphProperty(paragraphPropertyFetcher);
/*      */     
/*  433 */     return (Double)paragraphPropertyFetcher.getValue();
/*      */   }
/*      */ 
/*      */   
/*      */   public void setLeftMargin(Double paramDouble) {
/*  438 */     if (paramDouble == null && !this._p.isSetPPr())
/*  439 */       return;  CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/*  440 */     if (paramDouble == null) {
/*  441 */       if (cTTextParagraphProperties.isSetMarL()) cTTextParagraphProperties.unsetMarL(); 
/*      */     } else {
/*  443 */       cTTextParagraphProperties.setMarL(Units.toEMU(paramDouble.doubleValue()));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Double getLeftMargin() {
/*  453 */     ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getIndentLevel()) {
/*      */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/*  455 */           if (param1CTTextParagraphProperties.isSetMarL()) {
/*  456 */             double d = Units.toPoints(param1CTTextParagraphProperties.getMarL());
/*  457 */             setValue(Double.valueOf(d));
/*  458 */             return true;
/*      */           } 
/*  460 */           return false;
/*      */         }
/*      */       };
/*  463 */     fetchParagraphProperty(paragraphPropertyFetcher);
/*      */     
/*  465 */     return (Double)paragraphPropertyFetcher.getValue();
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRightMargin(Double paramDouble) {
/*  470 */     if (paramDouble == null && !this._p.isSetPPr())
/*  471 */       return;  CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/*  472 */     if (paramDouble == null) {
/*  473 */       if (cTTextParagraphProperties.isSetMarR()) cTTextParagraphProperties.unsetMarR(); 
/*      */     } else {
/*  475 */       cTTextParagraphProperties.setMarR(Units.toEMU(paramDouble.doubleValue()));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Double getRightMargin() {
/*  485 */     ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getIndentLevel()) {
/*      */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/*  487 */           if (param1CTTextParagraphProperties.isSetMarR()) {
/*  488 */             double d = Units.toPoints(param1CTTextParagraphProperties.getMarR());
/*  489 */             setValue(Double.valueOf(d));
/*  490 */             return true;
/*      */           } 
/*  492 */           return false;
/*      */         }
/*      */       };
/*  495 */     fetchParagraphProperty(paragraphPropertyFetcher);
/*  496 */     return (Double)paragraphPropertyFetcher.getValue();
/*      */   }
/*      */ 
/*      */   
/*      */   public Double getDefaultTabSize() {
/*  501 */     ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getIndentLevel()) {
/*      */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/*  503 */           if (param1CTTextParagraphProperties.isSetDefTabSz()) {
/*  504 */             double d = Units.toPoints(param1CTTextParagraphProperties.getDefTabSz());
/*  505 */             setValue(Double.valueOf(d));
/*  506 */             return true;
/*      */           } 
/*  508 */           return false;
/*      */         }
/*      */       };
/*  511 */     fetchParagraphProperty(paragraphPropertyFetcher);
/*  512 */     return (Double)paragraphPropertyFetcher.getValue();
/*      */   }
/*      */   
/*      */   public double getTabStop(final int idx) {
/*  516 */     ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getIndentLevel()) {
/*      */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/*  518 */           if (param1CTTextParagraphProperties.isSetTabLst()) {
/*  519 */             CTTextTabStopList cTTextTabStopList = param1CTTextParagraphProperties.getTabLst();
/*  520 */             if (idx < cTTextTabStopList.sizeOfTabArray()) {
/*  521 */               CTTextTabStop cTTextTabStop = cTTextTabStopList.getTabArray(idx);
/*  522 */               double d = Units.toPoints(cTTextTabStop.getPos());
/*  523 */               setValue(Double.valueOf(d));
/*  524 */               return true;
/*      */             } 
/*      */           } 
/*  527 */           return false;
/*      */         }
/*      */       };
/*  530 */     fetchParagraphProperty(paragraphPropertyFetcher);
/*  531 */     return (paragraphPropertyFetcher.getValue() == null) ? 0.0D : ((Double)paragraphPropertyFetcher.getValue()).doubleValue();
/*      */   }
/*      */   
/*      */   public void addTabStop(double paramDouble) {
/*  535 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/*  536 */     CTTextTabStopList cTTextTabStopList = cTTextParagraphProperties.isSetTabLst() ? cTTextParagraphProperties.getTabLst() : cTTextParagraphProperties.addNewTabLst();
/*  537 */     cTTextTabStopList.addNewTab().setPos(Units.toEMU(paramDouble));
/*      */   }
/*      */ 
/*      */   
/*      */   public void setLineSpacing(Double paramDouble) {
/*  542 */     if (paramDouble == null && !this._p.isSetPPr())
/*  543 */       return;  CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/*  544 */     if (paramDouble == null) {
/*  545 */       if (cTTextParagraphProperties.isSetLnSpc()) cTTextParagraphProperties.unsetLnSpc(); 
/*      */     } else {
/*  547 */       CTTextSpacing cTTextSpacing = cTTextParagraphProperties.isSetLnSpc() ? cTTextParagraphProperties.getLnSpc() : cTTextParagraphProperties.addNewLnSpc();
/*  548 */       if (paramDouble.doubleValue() >= 0.0D) {
/*  549 */         (cTTextSpacing.isSetSpcPct() ? cTTextSpacing.getSpcPct() : cTTextSpacing.addNewSpcPct()).setVal((int)(paramDouble.doubleValue() * 1000.0D));
/*  550 */         if (cTTextSpacing.isSetSpcPts()) cTTextSpacing.unsetSpcPts(); 
/*      */       } else {
/*  552 */         (cTTextSpacing.isSetSpcPts() ? cTTextSpacing.getSpcPts() : cTTextSpacing.addNewSpcPts()).setVal((int)(-paramDouble.doubleValue() * 100.0D));
/*  553 */         if (cTTextSpacing.isSetSpcPct()) cTTextSpacing.unsetSpcPct();
/*      */       
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public Double getLineSpacing() {
/*  560 */     ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getIndentLevel()) {
/*      */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/*  562 */           if (param1CTTextParagraphProperties.isSetLnSpc()) {
/*  563 */             CTTextSpacing cTTextSpacing = param1CTTextParagraphProperties.getLnSpc();
/*      */             
/*  565 */             if (cTTextSpacing.isSetSpcPct()) { setValue(Double.valueOf(cTTextSpacing.getSpcPct().getVal() * 0.001D)); }
/*  566 */             else if (cTTextSpacing.isSetSpcPts()) { setValue(Double.valueOf(-cTTextSpacing.getSpcPts().getVal() * 0.01D)); }
/*  567 */              return true;
/*      */           } 
/*  569 */           return false;
/*      */         }
/*      */       };
/*  572 */     fetchParagraphProperty(paragraphPropertyFetcher);
/*      */     
/*  574 */     Double double_ = (Double)paragraphPropertyFetcher.getValue();
/*  575 */     if (double_ != null && double_.doubleValue() > 0.0D) {
/*      */       
/*  577 */       CTTextNormalAutofit cTTextNormalAutofit = getParentShape().getTextBodyPr().getNormAutofit();
/*  578 */       if (cTTextNormalAutofit != null) {
/*  579 */         double d = 1.0D - cTTextNormalAutofit.getLnSpcReduction() / 100000.0D;
/*  580 */         double_ = Double.valueOf(double_.doubleValue() * d);
/*      */       } 
/*      */     } 
/*      */     
/*  584 */     return double_;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setSpaceBefore(Double paramDouble) {
/*  589 */     if (paramDouble == null && !this._p.isSetPPr()) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  594 */     if (paramDouble == null) {
/*  595 */       if (this._p.getPPr().isSetSpcBef()) {
/*  596 */         this._p.getPPr().unsetSpcBef();
/*      */       }
/*      */       
/*      */       return;
/*      */     } 
/*  601 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/*  602 */     CTTextSpacing cTTextSpacing = CTTextSpacing.Factory.newInstance();
/*      */     
/*  604 */     if (paramDouble.doubleValue() >= 0.0D) {
/*  605 */       cTTextSpacing.addNewSpcPct().setVal((int)(paramDouble.doubleValue() * 1000.0D));
/*      */     } else {
/*  607 */       cTTextSpacing.addNewSpcPts().setVal((int)(-paramDouble.doubleValue() * 100.0D));
/*      */     } 
/*  609 */     cTTextParagraphProperties.setSpcBef(cTTextSpacing);
/*      */   }
/*      */ 
/*      */   
/*      */   public Double getSpaceBefore() {
/*  614 */     ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getIndentLevel()) {
/*      */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/*  616 */           if (param1CTTextParagraphProperties.isSetSpcBef()) {
/*  617 */             CTTextSpacing cTTextSpacing = param1CTTextParagraphProperties.getSpcBef();
/*      */             
/*  619 */             if (cTTextSpacing.isSetSpcPct()) { setValue(Double.valueOf(cTTextSpacing.getSpcPct().getVal() * 0.001D)); }
/*  620 */             else if (cTTextSpacing.isSetSpcPts()) { setValue(Double.valueOf(-cTTextSpacing.getSpcPts().getVal() * 0.01D)); }
/*  621 */              return true;
/*      */           } 
/*  623 */           return false;
/*      */         }
/*      */       };
/*  626 */     fetchParagraphProperty(paragraphPropertyFetcher);
/*      */     
/*  628 */     return (Double)paragraphPropertyFetcher.getValue();
/*      */   }
/*      */ 
/*      */   
/*      */   public void setSpaceAfter(Double paramDouble) {
/*  633 */     if (paramDouble == null && !this._p.isSetPPr()) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  638 */     if (paramDouble == null) {
/*  639 */       if (this._p.getPPr().isSetSpcAft()) {
/*  640 */         this._p.getPPr().unsetSpcAft();
/*      */       }
/*      */       
/*      */       return;
/*      */     } 
/*  645 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/*  646 */     CTTextSpacing cTTextSpacing = CTTextSpacing.Factory.newInstance();
/*      */     
/*  648 */     if (paramDouble.doubleValue() >= 0.0D) {
/*  649 */       cTTextSpacing.addNewSpcPct().setVal((int)(paramDouble.doubleValue() * 1000.0D));
/*      */     } else {
/*  651 */       cTTextSpacing.addNewSpcPts().setVal((int)(-paramDouble.doubleValue() * 100.0D));
/*      */     } 
/*  653 */     cTTextParagraphProperties.setSpcAft(cTTextSpacing);
/*      */   }
/*      */ 
/*      */   
/*      */   public Double getSpaceAfter() {
/*  658 */     ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getIndentLevel()) {
/*      */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/*  660 */           if (param1CTTextParagraphProperties.isSetSpcAft()) {
/*  661 */             CTTextSpacing cTTextSpacing = param1CTTextParagraphProperties.getSpcAft();
/*      */             
/*  663 */             if (cTTextSpacing.isSetSpcPct()) { setValue(Double.valueOf(cTTextSpacing.getSpcPct().getVal() * 0.001D)); }
/*  664 */             else if (cTTextSpacing.isSetSpcPts()) { setValue(Double.valueOf(-cTTextSpacing.getSpcPts().getVal() * 0.01D)); }
/*  665 */              return true;
/*      */           } 
/*  667 */           return false;
/*      */         }
/*      */       };
/*  670 */     fetchParagraphProperty(paragraphPropertyFetcher);
/*  671 */     return (Double)paragraphPropertyFetcher.getValue();
/*      */   }
/*      */ 
/*      */   
/*      */   public void setIndentLevel(int paramInt) {
/*  676 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/*  677 */     cTTextParagraphProperties.setLvl(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public int getIndentLevel() {
/*  682 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.getPPr();
/*  683 */     return (cTTextParagraphProperties == null || !cTTextParagraphProperties.isSetLvl()) ? 0 : cTTextParagraphProperties.getLvl();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isBullet() {
/*  690 */     ParagraphPropertyFetcher<Boolean> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Boolean>(getIndentLevel()) {
/*      */         public boolean fetch(CTTextParagraphProperties param1CTTextParagraphProperties) {
/*  692 */           if (param1CTTextParagraphProperties.isSetBuNone()) {
/*  693 */             setValue(Boolean.valueOf(false));
/*  694 */             return true;
/*      */           } 
/*  696 */           if (param1CTTextParagraphProperties.isSetBuFont() || param1CTTextParagraphProperties.isSetBuChar()) {
/*  697 */             setValue(Boolean.valueOf(true));
/*  698 */             return true;
/*      */           } 
/*  700 */           return false;
/*      */         }
/*      */       };
/*  703 */     fetchParagraphProperty(paragraphPropertyFetcher);
/*  704 */     return (paragraphPropertyFetcher.getValue() == null) ? false : ((Boolean)paragraphPropertyFetcher.getValue()).booleanValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBullet(boolean paramBoolean) {
/*  712 */     if (isBullet() == paramBoolean)
/*      */       return; 
/*  714 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/*  715 */     if (paramBoolean) {
/*  716 */       cTTextParagraphProperties.addNewBuFont().setTypeface("Arial");
/*  717 */       cTTextParagraphProperties.addNewBuChar().setChar("•");
/*      */     } else {
/*  719 */       if (cTTextParagraphProperties.isSetBuFont()) cTTextParagraphProperties.unsetBuFont(); 
/*  720 */       if (cTTextParagraphProperties.isSetBuChar()) cTTextParagraphProperties.unsetBuChar(); 
/*  721 */       if (cTTextParagraphProperties.isSetBuAutoNum()) cTTextParagraphProperties.unsetBuAutoNum(); 
/*  722 */       if (cTTextParagraphProperties.isSetBuBlip()) cTTextParagraphProperties.unsetBuBlip(); 
/*  723 */       if (cTTextParagraphProperties.isSetBuClr()) cTTextParagraphProperties.unsetBuClr(); 
/*  724 */       if (cTTextParagraphProperties.isSetBuClrTx()) cTTextParagraphProperties.unsetBuClrTx(); 
/*  725 */       if (cTTextParagraphProperties.isSetBuFont()) cTTextParagraphProperties.unsetBuFont(); 
/*  726 */       if (cTTextParagraphProperties.isSetBuFontTx()) cTTextParagraphProperties.unsetBuFontTx(); 
/*  727 */       if (cTTextParagraphProperties.isSetBuSzPct()) cTTextParagraphProperties.unsetBuSzPct(); 
/*  728 */       if (cTTextParagraphProperties.isSetBuSzPts()) cTTextParagraphProperties.unsetBuSzPts(); 
/*  729 */       if (cTTextParagraphProperties.isSetBuSzTx()) cTTextParagraphProperties.unsetBuSzTx(); 
/*  730 */       cTTextParagraphProperties.addNewBuNone();
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
/*      */   public void setBulletAutoNumber(AutoNumberingScheme paramAutoNumberingScheme, int paramInt) {
/*  742 */     if (paramInt < 1) throw new IllegalArgumentException("Start Number must be greater or equal that 1"); 
/*  743 */     CTTextParagraphProperties cTTextParagraphProperties = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
/*  744 */     CTTextAutonumberBullet cTTextAutonumberBullet = cTTextParagraphProperties.isSetBuAutoNum() ? cTTextParagraphProperties.getBuAutoNum() : cTTextParagraphProperties.addNewBuAutoNum();
/*  745 */     cTTextAutonumberBullet.setType(STTextAutonumberScheme.Enum.forInt(paramAutoNumberingScheme.ooxmlId));
/*  746 */     cTTextAutonumberBullet.setStartAt(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public String toString() {
/*  751 */     return "[" + getClass() + "]" + getText();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   CTTextParagraphProperties getDefaultMasterStyle() {
/*      */     String str1;
/*  760 */     CTPlaceholder cTPlaceholder = this._shape.getCTPlaceholder();
/*      */     
/*  762 */     switch ((cTPlaceholder == null) ? -1 : cTPlaceholder.getType().intValue()) {
/*      */       case true:
/*      */       case true:
/*  765 */         str1 = "titleStyle";
/*      */         break;
/*      */       case true:
/*      */       case true:
/*      */       case true:
/*      */       case true:
/*  771 */         str1 = "otherStyle";
/*      */         break;
/*      */       default:
/*  774 */         str1 = "bodyStyle";
/*      */         break;
/*      */     } 
/*  777 */     int i = getIndentLevel();
/*      */ 
/*      */     
/*  780 */     String str2 = "http://schemas.openxmlformats.org/presentationml/2006/main";
/*  781 */     String str3 = "http://schemas.openxmlformats.org/drawingml/2006/main";
/*  782 */     XSLFSheet xSLFSheet1 = this._shape.getSheet();
/*  783 */     for (XSLFSheet xSLFSheet2 = xSLFSheet1; xSLFSheet2 != null; xSLFSheet2 = (XSLFSheet)xSLFSheet2.getMasterSheet()) {
/*  784 */       xSLFSheet1 = xSLFSheet2;
/*  785 */       XmlObject xmlObject = xSLFSheet1.getXmlObject();
/*  786 */       XmlCursor xmlCursor = xmlObject.newCursor();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  805 */     return null;
/*      */   }
/*      */   
/*      */   private <T> boolean fetchParagraphProperty(ParagraphPropertyFetcher<T> paramParagraphPropertyFetcher) {
/*  809 */     boolean bool = false;
/*  810 */     XSLFTextShape xSLFTextShape = getParentShape();
/*  811 */     XSLFSheet xSLFSheet = xSLFTextShape.getSheet();
/*      */     
/*  813 */     if (this._p.isSetPPr()) bool = paramParagraphPropertyFetcher.fetch(this._p.getPPr()); 
/*  814 */     if (bool) return true;
/*      */     
/*  816 */     bool = xSLFTextShape.fetchShapeProperty((PropertyFetcher<?>)paramParagraphPropertyFetcher);
/*  817 */     if (bool) return true;
/*      */ 
/*      */     
/*  820 */     CTPlaceholder cTPlaceholder = xSLFTextShape.getCTPlaceholder();
/*  821 */     if (cTPlaceholder == null) {
/*      */ 
/*      */       
/*  824 */       XMLSlideShow xMLSlideShow = xSLFSheet.getSlideShow();
/*  825 */       CTTextParagraphProperties cTTextParagraphProperties1 = xMLSlideShow.getDefaultParagraphStyle(getIndentLevel());
/*  826 */       if (cTTextParagraphProperties1 != null) bool = paramParagraphPropertyFetcher.fetch(cTTextParagraphProperties1); 
/*      */     } 
/*  828 */     if (bool) return true;
/*      */ 
/*      */     
/*  831 */     CTTextParagraphProperties cTTextParagraphProperties = getDefaultMasterStyle();
/*      */     
/*  833 */     if (cTTextParagraphProperties != null) bool = paramParagraphPropertyFetcher.fetch(cTTextParagraphProperties); 
/*  834 */     if (bool) return true;
/*      */     
/*  836 */     return false;
/*      */   }
/*      */   
/*      */   void copy(XSLFTextParagraph paramXSLFTextParagraph) {
/*  840 */     if (paramXSLFTextParagraph == this)
/*      */       return; 
/*  842 */     CTTextParagraph cTTextParagraph1 = getXmlObject();
/*  843 */     CTTextParagraph cTTextParagraph2 = paramXSLFTextParagraph.getXmlObject();
/*      */     
/*  845 */     if (cTTextParagraph1.isSetPPr()) cTTextParagraph1.unsetPPr(); 
/*  846 */     if (cTTextParagraph1.isSetEndParaRPr()) cTTextParagraph1.unsetEndParaRPr();
/*      */     
/*  848 */     this._runs.clear(); int i;
/*  849 */     for (i = cTTextParagraph1.sizeOfBrArray(); i > 0; i--) {
/*  850 */       cTTextParagraph1.removeBr(i - 1);
/*      */     }
/*  852 */     for (i = cTTextParagraph1.sizeOfRArray(); i > 0; i--) {
/*  853 */       cTTextParagraph1.removeR(i - 1);
/*      */     }
/*  855 */     for (i = cTTextParagraph1.sizeOfFldArray(); i > 0; i--) {
/*  856 */       cTTextParagraph1.removeFld(i - 1);
/*      */     }
/*      */     
/*  859 */     XmlCursor xmlCursor1 = cTTextParagraph1.newCursor();
/*  860 */     xmlCursor1.toEndToken();
/*  861 */     XmlCursor xmlCursor2 = cTTextParagraph2.newCursor();
/*  862 */     xmlCursor2.copyXmlContents(xmlCursor1);
/*  863 */     xmlCursor2.dispose();
/*  864 */     xmlCursor1.dispose();
/*      */     
/*  866 */     List<XSLFTextRun> list = paramXSLFTextParagraph.getTextRuns();
/*  867 */     byte b = 0;
/*  868 */     for (CTRegularTextRun cTRegularTextRun : cTTextParagraph1.getRArray()) {
/*  869 */       XSLFTextRun xSLFTextRun = newTextRun(cTRegularTextRun);
/*  870 */       xSLFTextRun.copy(list.get(b++));
/*  871 */       this._runs.add(xSLFTextRun);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  877 */     TextParagraph.TextAlign textAlign = paramXSLFTextParagraph.getTextAlign();
/*  878 */     if (textAlign != getTextAlign()) {
/*  879 */       setTextAlign(textAlign);
/*      */     }
/*      */     
/*  882 */     boolean bool = paramXSLFTextParagraph.isBullet();
/*  883 */     if (bool != isBullet()) {
/*  884 */       setBullet(bool);
/*  885 */       if (bool) {
/*  886 */         String str1 = paramXSLFTextParagraph.getBulletFont();
/*  887 */         if (str1 != null && !str1.equals(getBulletFont())) {
/*  888 */           setBulletFont(str1);
/*      */         }
/*  890 */         String str2 = paramXSLFTextParagraph.getBulletCharacter();
/*  891 */         if (str2 != null && !str2.equals(getBulletCharacter())) {
/*  892 */           setBulletCharacter(str2);
/*      */         }
/*  894 */         PaintStyle paintStyle = paramXSLFTextParagraph.getBulletFontColor();
/*  895 */         if (paintStyle != null && !paintStyle.equals(getBulletFontColor())) {
/*  896 */           setBulletFontColor(paintStyle);
/*      */         }
/*  898 */         Double double_ = paramXSLFTextParagraph.getBulletFontSize();
/*  899 */         if (!doubleEquals(double_, getBulletFontSize())) {
/*  900 */           setBulletFontSize(double_.doubleValue());
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  905 */     Double double_1 = paramXSLFTextParagraph.getLeftMargin();
/*  906 */     if (!doubleEquals(double_1, getLeftMargin())) {
/*  907 */       setLeftMargin(double_1);
/*      */     }
/*      */     
/*  910 */     Double double_2 = paramXSLFTextParagraph.getIndent();
/*  911 */     if (!doubleEquals(double_2, getIndent())) {
/*  912 */       setIndent(double_2);
/*      */     }
/*      */     
/*  915 */     Double double_3 = paramXSLFTextParagraph.getSpaceAfter();
/*  916 */     if (!doubleEquals(double_3, getSpaceAfter())) {
/*  917 */       setSpaceAfter(double_3);
/*      */     }
/*      */     
/*  920 */     Double double_4 = paramXSLFTextParagraph.getSpaceBefore();
/*  921 */     if (!doubleEquals(double_4, getSpaceBefore())) {
/*  922 */       setSpaceBefore(double_4);
/*      */     }
/*      */     
/*  925 */     Double double_5 = paramXSLFTextParagraph.getLineSpacing();
/*  926 */     if (!doubleEquals(double_5, getLineSpacing())) {
/*  927 */       setLineSpacing(double_5);
/*      */     }
/*      */   }
/*      */   
/*      */   private static boolean doubleEquals(Double paramDouble1, Double paramDouble2) {
/*  932 */     return (paramDouble1 == paramDouble2 || (paramDouble1 != null && paramDouble1.equals(paramDouble2)));
/*      */   }
/*      */ 
/*      */   
/*      */   public Double getDefaultFontSize() {
/*  937 */     CTTextCharacterProperties cTTextCharacterProperties = this._p.getEndParaRPr();
/*  938 */     if (cTTextCharacterProperties == null || !cTTextCharacterProperties.isSetSz()) {
/*      */       
/*  940 */       CTTextParagraphProperties cTTextParagraphProperties = getDefaultMasterStyle();
/*  941 */       if (cTTextParagraphProperties != null) {
/*  942 */         cTTextCharacterProperties = cTTextParagraphProperties.getDefRPr();
/*      */       }
/*      */     } 
/*  945 */     return Double.valueOf((cTTextCharacterProperties == null || !cTTextCharacterProperties.isSetSz()) ? 12.0D : (cTTextCharacterProperties.getSz() / 100.0D));
/*      */   }
/*      */ 
/*      */   
/*      */   public String getDefaultFontFamily() {
/*  950 */     return this._runs.isEmpty() ? "Arial" : ((XSLFTextRun)this._runs.get(0)).getFontFamily();
/*      */   }
/*      */ 
/*      */   
/*      */   public TextParagraph.BulletStyle getBulletStyle() {
/*  955 */     if (!isBullet()) return null; 
/*  956 */     return new TextParagraph.BulletStyle()
/*      */       {
/*      */         public String getBulletCharacter() {
/*  959 */           return XSLFTextParagraph.this.getBulletCharacter();
/*      */         }
/*      */ 
/*      */         
/*      */         public String getBulletFont() {
/*  964 */           return XSLFTextParagraph.this.getBulletFont();
/*      */         }
/*      */ 
/*      */         
/*      */         public Double getBulletFontSize() {
/*  969 */           return XSLFTextParagraph.this.getBulletFontSize();
/*      */         }
/*      */ 
/*      */         
/*      */         public PaintStyle getBulletFontColor() {
/*  974 */           return XSLFTextParagraph.this.getBulletFontColor();
/*      */         }
/*      */ 
/*      */         
/*      */         public void setBulletFontColor(Color param1Color) {
/*  979 */           setBulletFontColor((PaintStyle)DrawPaint.createSolidPaint(param1Color));
/*      */         }
/*      */ 
/*      */         
/*      */         public void setBulletFontColor(PaintStyle param1PaintStyle) {
/*  984 */           XSLFTextParagraph.this.setBulletFontColor(param1PaintStyle);
/*      */         }
/*      */ 
/*      */         
/*      */         public AutoNumberingScheme getAutoNumberingScheme() {
/*  989 */           return XSLFTextParagraph.this.getAutoNumberingScheme();
/*      */         }
/*      */ 
/*      */         
/*      */         public Integer getAutoNumberingStartAt() {
/*  994 */           return XSLFTextParagraph.this.getAutoNumberingStartAt();
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBulletStyle(Object... paramVarArgs) {
/* 1002 */     if (paramVarArgs.length == 0) {
/* 1003 */       setBullet(false);
/*      */     } else {
/* 1005 */       setBullet(true);
/* 1006 */       for (Object object : paramVarArgs) {
/* 1007 */         if (object instanceof Number) {
/* 1008 */           setBulletFontSize(((Number)object).doubleValue());
/* 1009 */         } else if (object instanceof Color) {
/* 1010 */           setBulletFontColor((Color)object);
/* 1011 */         } else if (object instanceof Character) {
/* 1012 */           setBulletCharacter(object.toString());
/* 1013 */         } else if (object instanceof String) {
/* 1014 */           setBulletFont((String)object);
/* 1015 */         } else if (object instanceof AutoNumberingScheme) {
/* 1016 */           setBulletAutoNumber((AutoNumberingScheme)object, 0);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void clearButKeepProperties() {
/* 1027 */     CTTextParagraph cTTextParagraph = getXmlObject(); int i;
/* 1028 */     for (i = cTTextParagraph.sizeOfBrArray(); i > 0; i--) {
/* 1029 */       cTTextParagraph.removeBr(i - 1);
/*      */     }
/* 1031 */     for (i = cTTextParagraph.sizeOfFldArray(); i > 0; i--) {
/* 1032 */       cTTextParagraph.removeFld(i - 1);
/*      */     }
/* 1034 */     if (!this._runs.isEmpty()) {
/* 1035 */       i = this._runs.size();
/* 1036 */       XSLFTextRun xSLFTextRun = this._runs.get(i - 1);
/* 1037 */       CTTextCharacterProperties cTTextCharacterProperties = xSLFTextRun.getRPr(false);
/* 1038 */       if (cTTextCharacterProperties != null) {
/* 1039 */         if (cTTextParagraph.isSetEndParaRPr()) {
/* 1040 */           cTTextParagraph.unsetEndParaRPr();
/*      */         }
/* 1042 */         CTTextCharacterProperties cTTextCharacterProperties1 = cTTextParagraph.addNewEndParaRPr();
/* 1043 */         cTTextCharacterProperties1.set((XmlObject)cTTextCharacterProperties);
/*      */       } 
/* 1045 */       for (int j = i; j > 0; j--) {
/* 1046 */         cTTextParagraph.removeR(j - 1);
/*      */       }
/* 1048 */       this._runs.clear();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isHeaderOrFooter() {
/* 1054 */     CTPlaceholder cTPlaceholder = this._shape.getCTPlaceholder();
/* 1055 */     boolean bool = (cTPlaceholder == null) ? true : cTPlaceholder.getType().intValue();
/* 1056 */     switch (bool) {
/*      */       case true:
/*      */       case true:
/*      */       case true:
/*      */       case true:
/* 1061 */         return true;
/*      */     } 
/* 1063 */     return false;
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
/*      */   protected XSLFTextRun newTextRun(CTRegularTextRun paramCTRegularTextRun) {
/* 1077 */     return new XSLFTextRun(paramCTRegularTextRun, this);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFTextParagraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */