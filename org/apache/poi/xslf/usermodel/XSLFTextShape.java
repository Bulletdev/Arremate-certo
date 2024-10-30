/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.sl.draw.DrawFactory;
/*     */ import org.apache.poi.sl.draw.DrawTextShape;
/*     */ import org.apache.poi.sl.usermodel.Insets2D;
/*     */ import org.apache.poi.sl.usermodel.Placeholder;
/*     */ import org.apache.poi.sl.usermodel.TextRun;
/*     */ import org.apache.poi.sl.usermodel.TextShape;
/*     */ import org.apache.poi.sl.usermodel.VerticalAlignment;
/*     */ import org.apache.poi.util.Units;
/*     */ import org.apache.poi.xslf.model.PropertyFetcher;
/*     */ import org.apache.poi.xslf.model.TextBodyPropertyFetcher;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STTextAnchoringType;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STTextVerticalType;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STTextWrappingType;
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
/*     */ 
/*     */ 
/*     */ public abstract class XSLFTextShape
/*     */   extends XSLFSimpleShape
/*     */   implements TextShape<XSLFShape, XSLFTextParagraph>
/*     */ {
/*     */   private final List<XSLFTextParagraph> _paragraphs;
/*     */   
/*     */   XSLFTextShape(XmlObject paramXmlObject, XSLFSheet paramXSLFSheet) {
/*  59 */     super(paramXmlObject, paramXSLFSheet);
/*     */     
/*  61 */     this._paragraphs = new ArrayList<XSLFTextParagraph>();
/*  62 */     CTTextBody cTTextBody = getTextBody(false);
/*  63 */     if (cTTextBody != null) {
/*  64 */       for (CTTextParagraph cTTextParagraph : cTTextBody.getPArray()) {
/*  65 */         this._paragraphs.add(newTextParagraph(cTTextParagraph));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public Iterator<XSLFTextParagraph> iterator() {
/*  71 */     return getTextParagraphs().iterator();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getText() {
/*  76 */     StringBuilder stringBuilder = new StringBuilder();
/*  77 */     for (XSLFTextParagraph xSLFTextParagraph : this._paragraphs) {
/*  78 */       if (stringBuilder.length() > 0) stringBuilder.append('\n'); 
/*  79 */       stringBuilder.append(xSLFTextParagraph.getText());
/*     */     } 
/*  81 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearText() {
/*  88 */     this._paragraphs.clear();
/*  89 */     CTTextBody cTTextBody = getTextBody(true);
/*  90 */     cTTextBody.setPArray(null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public XSLFTextRun setText(String paramString) {
/*  96 */     if (!this._paragraphs.isEmpty()) {
/*  97 */       CTTextBody cTTextBody = getTextBody(false);
/*  98 */       int i = cTTextBody.sizeOfPArray();
/*  99 */       for (int j = i; j > 1; j--) {
/* 100 */         cTTextBody.removeP(j - 1);
/* 101 */         this._paragraphs.remove(j - 1);
/*     */       } 
/*     */       
/* 104 */       ((XSLFTextParagraph)this._paragraphs.get(0)).clearButKeepProperties();
/*     */     } 
/*     */     
/* 107 */     return appendText(paramString, false);
/*     */   }
/*     */   public XSLFTextRun appendText(String paramString, boolean paramBoolean) {
/*     */     boolean bool;
/*     */     XSLFTextParagraph xSLFTextParagraph;
/* 112 */     if (paramString == null) return null;
/*     */ 
/*     */     
/* 115 */     CTTextParagraphProperties cTTextParagraphProperties = null;
/* 116 */     CTTextCharacterProperties cTTextCharacterProperties = null;
/*     */ 
/*     */ 
/*     */     
/* 120 */     if (this._paragraphs.isEmpty()) {
/* 121 */       bool = false;
/* 122 */       xSLFTextParagraph = null;
/*     */     } else {
/* 124 */       bool = !paramBoolean ? true : false;
/* 125 */       xSLFTextParagraph = this._paragraphs.get(this._paragraphs.size() - 1);
/* 126 */       CTTextParagraph cTTextParagraph = xSLFTextParagraph.getXmlObject();
/* 127 */       cTTextParagraphProperties = cTTextParagraph.getPPr();
/* 128 */       List<XSLFTextRun> list = xSLFTextParagraph.getTextRuns();
/* 129 */       if (!list.isEmpty()) {
/* 130 */         XSLFTextRun xSLFTextRun1 = list.get(list.size() - 1);
/* 131 */         cTTextCharacterProperties = xSLFTextRun1.getRPr(false);
/* 132 */         if (cTTextCharacterProperties == null) {
/* 133 */           cTTextCharacterProperties = cTTextParagraph.getEndParaRPr();
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 141 */     XSLFTextRun xSLFTextRun = null;
/* 142 */     for (String str : paramString.split("\\r\\n?|\\n")) {
/* 143 */       if (!bool) {
/* 144 */         if (xSLFTextParagraph != null) {
/* 145 */           CTTextParagraph cTTextParagraph = xSLFTextParagraph.getXmlObject();
/* 146 */           CTTextCharacterProperties cTTextCharacterProperties1 = cTTextParagraph.getEndParaRPr();
/* 147 */           if (cTTextCharacterProperties1 != null && cTTextCharacterProperties1 != cTTextCharacterProperties) {
/* 148 */             cTTextParagraph.unsetEndParaRPr();
/*     */           }
/*     */         } 
/* 151 */         xSLFTextParagraph = addNewTextParagraph();
/* 152 */         if (cTTextParagraphProperties != null) {
/* 153 */           xSLFTextParagraph.getXmlObject().setPPr(cTTextParagraphProperties);
/*     */         }
/*     */       } 
/* 156 */       boolean bool1 = true;
/* 157 */       for (String str1 : str.split("[\013]")) {
/* 158 */         if (!bool1) {
/* 159 */           xSLFTextParagraph.addLineBreak();
/*     */         }
/* 161 */         xSLFTextRun = xSLFTextParagraph.addNewTextRun();
/* 162 */         xSLFTextRun.setText(str1);
/* 163 */         if (cTTextCharacterProperties != null) {
/* 164 */           xSLFTextRun.getRPr(true).set((XmlObject)cTTextCharacterProperties);
/*     */         }
/* 166 */         bool1 = false;
/*     */       } 
/* 168 */       bool = false;
/*     */     } 
/*     */     
/* 171 */     assert xSLFTextRun != null;
/* 172 */     return xSLFTextRun;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<XSLFTextParagraph> getTextParagraphs() {
/* 177 */     return this._paragraphs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSLFTextParagraph addNewTextParagraph() {
/*     */     CTTextParagraph cTTextParagraph;
/* 186 */     CTTextBody cTTextBody = getTextBody(false);
/*     */     
/* 188 */     if (cTTextBody == null) {
/* 189 */       cTTextBody = getTextBody(true);
/* 190 */       cTTextParagraph = cTTextBody.getPArray(0);
/* 191 */       cTTextParagraph.removeR(0);
/*     */     } else {
/* 193 */       cTTextParagraph = cTTextBody.addNewP();
/*     */     } 
/* 195 */     XSLFTextParagraph xSLFTextParagraph = newTextParagraph(cTTextParagraph);
/* 196 */     this._paragraphs.add(xSLFTextParagraph);
/* 197 */     return xSLFTextParagraph;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVerticalAlignment(VerticalAlignment paramVerticalAlignment) {
/* 202 */     CTTextBodyProperties cTTextBodyProperties = getTextBodyPr(true);
/* 203 */     if (cTTextBodyProperties != null) {
/* 204 */       if (paramVerticalAlignment == null) {
/* 205 */         if (cTTextBodyProperties.isSetAnchor()) cTTextBodyProperties.unsetAnchor(); 
/*     */       } else {
/* 207 */         cTTextBodyProperties.setAnchor(STTextAnchoringType.Enum.forInt(paramVerticalAlignment.ordinal() + 1));
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalAlignment getVerticalAlignment() {
/* 214 */     TextBodyPropertyFetcher<VerticalAlignment> textBodyPropertyFetcher = new TextBodyPropertyFetcher<VerticalAlignment>() {
/*     */         public boolean fetch(CTTextBodyProperties param1CTTextBodyProperties) {
/* 216 */           if (param1CTTextBodyProperties.isSetAnchor()) {
/* 217 */             int i = param1CTTextBodyProperties.getAnchor().intValue();
/* 218 */             setValue(VerticalAlignment.values()[i - 1]);
/* 219 */             return true;
/*     */           } 
/* 221 */           return false;
/*     */         }
/*     */       };
/* 224 */     fetchShapeProperty((PropertyFetcher<?>)textBodyPropertyFetcher);
/* 225 */     return (textBodyPropertyFetcher.getValue() == null) ? VerticalAlignment.TOP : (VerticalAlignment)textBodyPropertyFetcher.getValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHorizontalCentered(Boolean paramBoolean) {
/* 230 */     CTTextBodyProperties cTTextBodyProperties = getTextBodyPr(true);
/* 231 */     if (cTTextBodyProperties != null) {
/* 232 */       if (paramBoolean == null) {
/* 233 */         if (cTTextBodyProperties.isSetAnchorCtr()) cTTextBodyProperties.unsetAnchorCtr(); 
/*     */       } else {
/* 235 */         cTTextBodyProperties.setAnchorCtr(paramBoolean.booleanValue());
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHorizontalCentered() {
/* 242 */     TextBodyPropertyFetcher<Boolean> textBodyPropertyFetcher = new TextBodyPropertyFetcher<Boolean>() {
/*     */         public boolean fetch(CTTextBodyProperties param1CTTextBodyProperties) {
/* 244 */           if (param1CTTextBodyProperties.isSetAnchorCtr()) {
/* 245 */             setValue(Boolean.valueOf(param1CTTextBodyProperties.getAnchorCtr()));
/* 246 */             return true;
/*     */           } 
/* 248 */           return false;
/*     */         }
/*     */       };
/* 251 */     fetchShapeProperty((PropertyFetcher<?>)textBodyPropertyFetcher);
/* 252 */     return (textBodyPropertyFetcher.getValue() == null) ? false : ((Boolean)textBodyPropertyFetcher.getValue()).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTextDirection(TextShape.TextDirection paramTextDirection) {
/* 257 */     CTTextBodyProperties cTTextBodyProperties = getTextBodyPr(true);
/* 258 */     if (cTTextBodyProperties != null) {
/* 259 */       if (paramTextDirection == null) {
/* 260 */         if (cTTextBodyProperties.isSetVert()) cTTextBodyProperties.unsetVert(); 
/*     */       } else {
/* 262 */         cTTextBodyProperties.setVert(STTextVerticalType.Enum.forInt(paramTextDirection.ordinal() + 1));
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public TextShape.TextDirection getTextDirection() {
/* 269 */     CTTextBodyProperties cTTextBodyProperties = getTextBodyPr();
/* 270 */     if (cTTextBodyProperties != null) {
/* 271 */       STTextVerticalType.Enum enum_ = cTTextBodyProperties.getVert();
/* 272 */       if (enum_ != null) {
/* 273 */         switch (enum_.intValue())
/*     */         
/*     */         { default:
/* 276 */             return TextShape.TextDirection.HORIZONTAL;
/*     */           case 2:
/*     */           case 5:
/*     */           case 6:
/* 280 */             return TextShape.TextDirection.VERTICAL;
/*     */           case 3:
/* 282 */             return TextShape.TextDirection.VERTICAL_270;
/*     */           case 4:
/*     */           case 7:
/* 285 */             break; }  return TextShape.TextDirection.STACKED;
/*     */       } 
/*     */     } 
/*     */     
/* 289 */     return TextShape.TextDirection.HORIZONTAL;
/*     */   }
/*     */ 
/*     */   
/*     */   public Double getTextRotation() {
/* 294 */     CTTextBodyProperties cTTextBodyProperties = getTextBodyPr();
/* 295 */     if (cTTextBodyProperties != null && cTTextBodyProperties.isSetRot()) {
/* 296 */       return Double.valueOf(cTTextBodyProperties.getRot() / 60000.0D);
/*     */     }
/* 298 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTextRotation(Double paramDouble) {
/* 303 */     CTTextBodyProperties cTTextBodyProperties = getTextBodyPr(true);
/* 304 */     if (cTTextBodyProperties != null) {
/* 305 */       cTTextBodyProperties.setRot((int)(paramDouble.doubleValue() * 60000.0D));
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
/*     */   public double getBottomInset() {
/* 317 */     TextBodyPropertyFetcher<Double> textBodyPropertyFetcher = new TextBodyPropertyFetcher<Double>() {
/*     */         public boolean fetch(CTTextBodyProperties param1CTTextBodyProperties) {
/* 319 */           if (param1CTTextBodyProperties.isSetBIns()) {
/* 320 */             double d = Units.toPoints(param1CTTextBodyProperties.getBIns());
/* 321 */             setValue(Double.valueOf(d));
/* 322 */             return true;
/*     */           } 
/* 324 */           return false;
/*     */         }
/*     */       };
/* 327 */     fetchShapeProperty((PropertyFetcher<?>)textBodyPropertyFetcher);
/*     */     
/* 329 */     return (textBodyPropertyFetcher.getValue() == null) ? 3.6D : ((Double)textBodyPropertyFetcher.getValue()).doubleValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getLeftInset() {
/* 340 */     TextBodyPropertyFetcher<Double> textBodyPropertyFetcher = new TextBodyPropertyFetcher<Double>() {
/*     */         public boolean fetch(CTTextBodyProperties param1CTTextBodyProperties) {
/* 342 */           if (param1CTTextBodyProperties.isSetLIns()) {
/* 343 */             double d = Units.toPoints(param1CTTextBodyProperties.getLIns());
/* 344 */             setValue(Double.valueOf(d));
/* 345 */             return true;
/*     */           } 
/* 347 */           return false;
/*     */         }
/*     */       };
/* 350 */     fetchShapeProperty((PropertyFetcher<?>)textBodyPropertyFetcher);
/*     */     
/* 352 */     return (textBodyPropertyFetcher.getValue() == null) ? 7.2D : ((Double)textBodyPropertyFetcher.getValue()).doubleValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getRightInset() {
/* 363 */     TextBodyPropertyFetcher<Double> textBodyPropertyFetcher = new TextBodyPropertyFetcher<Double>() {
/*     */         public boolean fetch(CTTextBodyProperties param1CTTextBodyProperties) {
/* 365 */           if (param1CTTextBodyProperties.isSetRIns()) {
/* 366 */             double d = Units.toPoints(param1CTTextBodyProperties.getRIns());
/* 367 */             setValue(Double.valueOf(d));
/* 368 */             return true;
/*     */           } 
/* 370 */           return false;
/*     */         }
/*     */       };
/* 373 */     fetchShapeProperty((PropertyFetcher<?>)textBodyPropertyFetcher);
/*     */     
/* 375 */     return (textBodyPropertyFetcher.getValue() == null) ? 7.2D : ((Double)textBodyPropertyFetcher.getValue()).doubleValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getTopInset() {
/* 385 */     TextBodyPropertyFetcher<Double> textBodyPropertyFetcher = new TextBodyPropertyFetcher<Double>() {
/*     */         public boolean fetch(CTTextBodyProperties param1CTTextBodyProperties) {
/* 387 */           if (param1CTTextBodyProperties.isSetTIns()) {
/* 388 */             double d = Units.toPoints(param1CTTextBodyProperties.getTIns());
/* 389 */             setValue(Double.valueOf(d));
/* 390 */             return true;
/*     */           } 
/* 392 */           return false;
/*     */         }
/*     */       };
/* 395 */     fetchShapeProperty((PropertyFetcher<?>)textBodyPropertyFetcher);
/*     */     
/* 397 */     return (textBodyPropertyFetcher.getValue() == null) ? 3.6D : ((Double)textBodyPropertyFetcher.getValue()).doubleValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBottomInset(double paramDouble) {
/* 407 */     CTTextBodyProperties cTTextBodyProperties = getTextBodyPr(true);
/* 408 */     if (cTTextBodyProperties != null) {
/* 409 */       if (paramDouble == -1.0D) { cTTextBodyProperties.unsetBIns(); }
/* 410 */       else { cTTextBodyProperties.setBIns(Units.toEMU(paramDouble)); }
/*     */     
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLeftInset(double paramDouble) {
/* 421 */     CTTextBodyProperties cTTextBodyProperties = getTextBodyPr(true);
/* 422 */     if (cTTextBodyProperties != null) {
/* 423 */       if (paramDouble == -1.0D) { cTTextBodyProperties.unsetLIns(); }
/* 424 */       else { cTTextBodyProperties.setLIns(Units.toEMU(paramDouble)); }
/*     */     
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRightInset(double paramDouble) {
/* 435 */     CTTextBodyProperties cTTextBodyProperties = getTextBodyPr(true);
/* 436 */     if (cTTextBodyProperties != null) {
/* 437 */       if (paramDouble == -1.0D) { cTTextBodyProperties.unsetRIns(); }
/* 438 */       else { cTTextBodyProperties.setRIns(Units.toEMU(paramDouble)); }
/*     */     
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTopInset(double paramDouble) {
/* 449 */     CTTextBodyProperties cTTextBodyProperties = getTextBodyPr(true);
/* 450 */     if (cTTextBodyProperties != null) {
/* 451 */       if (paramDouble == -1.0D) { cTTextBodyProperties.unsetTIns(); }
/* 452 */       else { cTTextBodyProperties.setTIns(Units.toEMU(paramDouble)); }
/*     */     
/*     */     }
/*     */   }
/*     */   
/*     */   public Insets2D getInsets() {
/* 458 */     return new Insets2D(getTopInset(), getLeftInset(), getBottomInset(), getRightInset());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInsets(Insets2D paramInsets2D) {
/* 464 */     setTopInset(paramInsets2D.top);
/* 465 */     setLeftInset(paramInsets2D.left);
/* 466 */     setBottomInset(paramInsets2D.bottom);
/* 467 */     setRightInset(paramInsets2D.right);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getWordWrap() {
/* 472 */     TextBodyPropertyFetcher<Boolean> textBodyPropertyFetcher = new TextBodyPropertyFetcher<Boolean>() {
/*     */         public boolean fetch(CTTextBodyProperties param1CTTextBodyProperties) {
/* 474 */           if (param1CTTextBodyProperties.isSetWrap()) {
/* 475 */             setValue(Boolean.valueOf((param1CTTextBodyProperties.getWrap() == STTextWrappingType.SQUARE)));
/* 476 */             return true;
/*     */           } 
/* 478 */           return false;
/*     */         }
/*     */       };
/* 481 */     fetchShapeProperty((PropertyFetcher<?>)textBodyPropertyFetcher);
/* 482 */     return (textBodyPropertyFetcher.getValue() == null) ? true : ((Boolean)textBodyPropertyFetcher.getValue()).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWordWrap(boolean paramBoolean) {
/* 487 */     CTTextBodyProperties cTTextBodyProperties = getTextBodyPr(true);
/* 488 */     if (cTTextBodyProperties != null) {
/* 489 */       cTTextBodyProperties.setWrap(paramBoolean ? STTextWrappingType.SQUARE : STTextWrappingType.NONE);
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
/*     */   public void setTextAutofit(TextShape.TextAutofit paramTextAutofit) {
/* 501 */     CTTextBodyProperties cTTextBodyProperties = getTextBodyPr(true);
/* 502 */     if (cTTextBodyProperties != null) {
/* 503 */       if (cTTextBodyProperties.isSetSpAutoFit()) cTTextBodyProperties.unsetSpAutoFit(); 
/* 504 */       if (cTTextBodyProperties.isSetNoAutofit()) cTTextBodyProperties.unsetNoAutofit(); 
/* 505 */       if (cTTextBodyProperties.isSetNormAutofit()) cTTextBodyProperties.unsetNormAutofit();
/*     */       
/* 507 */       switch (paramTextAutofit) { case BODY:
/* 508 */           cTTextBodyProperties.addNewNoAutofit(); break;
/* 509 */         case TITLE: cTTextBodyProperties.addNewNormAutofit(); break;
/* 510 */         case CENTERED_TITLE: cTTextBodyProperties.addNewSpAutoFit();
/*     */           break; }
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextShape.TextAutofit getTextAutofit() {
/* 520 */     CTTextBodyProperties cTTextBodyProperties = getTextBodyPr();
/* 521 */     if (cTTextBodyProperties != null) {
/* 522 */       if (cTTextBodyProperties.isSetNoAutofit()) return TextShape.TextAutofit.NONE; 
/* 523 */       if (cTTextBodyProperties.isSetNormAutofit()) return TextShape.TextAutofit.NORMAL; 
/* 524 */       if (cTTextBodyProperties.isSetSpAutoFit()) return TextShape.TextAutofit.SHAPE; 
/*     */     } 
/* 526 */     return TextShape.TextAutofit.NORMAL;
/*     */   }
/*     */   
/*     */   protected CTTextBodyProperties getTextBodyPr() {
/* 530 */     return getTextBodyPr(false);
/*     */   }
/*     */   
/*     */   protected CTTextBodyProperties getTextBodyPr(boolean paramBoolean) {
/* 534 */     CTTextBody cTTextBody = getTextBody(paramBoolean);
/* 535 */     if (cTTextBody == null) {
/* 536 */       return null;
/*     */     }
/* 538 */     CTTextBodyProperties cTTextBodyProperties = cTTextBody.getBodyPr();
/* 539 */     if (cTTextBodyProperties == null && paramBoolean) {
/* 540 */       cTTextBodyProperties = cTTextBody.addNewBodyPr();
/*     */     }
/* 542 */     return cTTextBodyProperties;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPlaceholder(Placeholder paramPlaceholder) {
/* 549 */     super.setPlaceholder(paramPlaceholder);
/*     */   }
/*     */   
/*     */   public Placeholder getTextType() {
/* 553 */     CTPlaceholder cTPlaceholder = getCTPlaceholder();
/* 554 */     if (cTPlaceholder == null) return null;
/*     */     
/* 556 */     int i = cTPlaceholder.getType().intValue();
/* 557 */     return Placeholder.lookupOoxml(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public double getTextHeight() {
/* 562 */     DrawFactory drawFactory = DrawFactory.getInstance(null);
/* 563 */     DrawTextShape drawTextShape = drawFactory.getDrawable(this);
/* 564 */     return drawTextShape.getTextHeight();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle2D resizeToFitText() {
/* 573 */     Rectangle2D rectangle2D = getAnchor();
/* 574 */     if (rectangle2D.getWidth() == 0.0D) throw new POIXMLException("Anchor of the shape was not set.");
/*     */     
/* 576 */     double d = getTextHeight();
/* 577 */     d++;
/*     */     
/* 579 */     rectangle2D.setRect(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), d);
/* 580 */     setAnchor(rectangle2D);
/*     */     
/* 582 */     return rectangle2D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void copy(XSLFShape paramXSLFShape) {
/* 588 */     super.copy(paramXSLFShape);
/*     */     
/* 590 */     XSLFTextShape xSLFTextShape = (XSLFTextShape)paramXSLFShape;
/* 591 */     CTTextBody cTTextBody1 = xSLFTextShape.getTextBody(false);
/* 592 */     CTTextBody cTTextBody2 = getTextBody(true);
/* 593 */     if (cTTextBody1 == null) {
/*     */       return;
/*     */     }
/*     */     
/* 597 */     cTTextBody2.setBodyPr((CTTextBodyProperties)cTTextBody1.getBodyPr().copy());
/*     */     
/* 599 */     if (cTTextBody2.isSetLstStyle()) cTTextBody2.unsetLstStyle(); 
/* 600 */     if (cTTextBody1.isSetLstStyle()) {
/* 601 */       cTTextBody2.setLstStyle((CTTextListStyle)cTTextBody1.getLstStyle().copy());
/*     */     }
/*     */     
/* 604 */     boolean bool = xSLFTextShape.getWordWrap();
/* 605 */     if (bool != getWordWrap()) {
/* 606 */       setWordWrap(bool);
/*     */     }
/*     */     
/* 609 */     double d1 = xSLFTextShape.getLeftInset();
/* 610 */     if (d1 != getLeftInset()) {
/* 611 */       setLeftInset(d1);
/*     */     }
/* 613 */     double d2 = xSLFTextShape.getRightInset();
/* 614 */     if (d2 != getRightInset()) {
/* 615 */       setRightInset(d2);
/*     */     }
/* 617 */     double d3 = xSLFTextShape.getTopInset();
/* 618 */     if (d3 != getTopInset()) {
/* 619 */       setTopInset(d3);
/*     */     }
/* 621 */     double d4 = xSLFTextShape.getBottomInset();
/* 622 */     if (d4 != getBottomInset()) {
/* 623 */       setBottomInset(d4);
/*     */     }
/*     */     
/* 626 */     VerticalAlignment verticalAlignment = xSLFTextShape.getVerticalAlignment();
/* 627 */     if (verticalAlignment != getVerticalAlignment()) {
/* 628 */       setVerticalAlignment(verticalAlignment);
/*     */     }
/*     */     
/* 631 */     clearText();
/*     */     
/* 633 */     for (XSLFTextParagraph xSLFTextParagraph1 : xSLFTextShape.getTextParagraphs()) {
/* 634 */       XSLFTextParagraph xSLFTextParagraph2 = addNewTextParagraph();
/* 635 */       xSLFTextParagraph2.copy(xSLFTextParagraph1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTextPlaceholder(TextShape.TextPlaceholder paramTextPlaceholder) {
/* 641 */     switch (paramTextPlaceholder) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 647 */         setPlaceholder(Placeholder.BODY);
/*     */         return;
/*     */       case null:
/* 650 */         setPlaceholder(Placeholder.TITLE);
/*     */         return;
/*     */       case null:
/* 653 */         setPlaceholder(Placeholder.BODY);
/* 654 */         setHorizontalCentered(Boolean.valueOf(true));
/*     */         return;
/*     */       case null:
/* 657 */         setPlaceholder(Placeholder.CENTERED_TITLE); return;
/*     */       case null:
/*     */         break;
/* 660 */     }  setPlaceholder(Placeholder.CONTENT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextShape.TextPlaceholder getTextPlaceholder() {
/* 667 */     Placeholder placeholder = getTextType();
/* 668 */     if (placeholder == null) return TextShape.TextPlaceholder.BODY; 
/* 669 */     switch (placeholder) { case BODY:
/* 670 */         return TextShape.TextPlaceholder.BODY;
/* 671 */       case TITLE: return TextShape.TextPlaceholder.TITLE;
/* 672 */       case CENTERED_TITLE: return TextShape.TextPlaceholder.CENTER_TITLE; }
/*     */     
/* 674 */     return TextShape.TextPlaceholder.OTHER;
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
/*     */   protected XSLFTextParagraph newTextParagraph(CTTextParagraph paramCTTextParagraph) {
/* 688 */     return new XSLFTextParagraph(paramCTTextParagraph, this);
/*     */   }
/*     */   
/*     */   protected abstract CTTextBody getTextBody(boolean paramBoolean);
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFTextShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */