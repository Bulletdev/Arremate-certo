/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.sl.draw.DrawFactory;
/*     */ import org.apache.poi.sl.draw.DrawPaint;
/*     */ import org.apache.poi.sl.usermodel.ColorStyle;
/*     */ import org.apache.poi.sl.usermodel.PaintStyle;
/*     */ import org.apache.poi.sl.usermodel.PlaceableShape;
/*     */ import org.apache.poi.sl.usermodel.Placeholder;
/*     */ import org.apache.poi.sl.usermodel.Shape;
/*     */ import org.apache.poi.sl.usermodel.ShapeContainer;
/*     */ import org.apache.poi.sl.usermodel.Sheet;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.xslf.model.PropertyFetcher;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStop;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STPathShadeType;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.STPlaceholderType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class XSLFShape
/*     */   implements Shape<XSLFShape, XSLFTextParagraph>
/*     */ {
/*     */   protected static final String PML_NS = "http://schemas.openxmlformats.org/presentationml/2006/main";
/*     */   private final XmlObject _shape;
/*     */   private final XSLFSheet _sheet;
/*     */   private XSLFShapeContainer _parent;
/*     */   private CTShapeStyle _spStyle;
/*     */   private CTNonVisualDrawingProps _nvPr;
/*     */   private CTPlaceholder _ph;
/*     */   
/*     */   protected XSLFShape(XmlObject paramXmlObject, XSLFSheet paramXSLFSheet) {
/*  82 */     this._shape = paramXmlObject;
/*  83 */     this._sheet = paramXSLFSheet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final XmlObject getXmlObject() {
/*  92 */     return this._shape;
/*     */   }
/*     */   
/*     */   public XSLFSheet getSheet() {
/*  96 */     return this._sheet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getShapeName() {
/* 103 */     return getCNvPr().getName();
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
/*     */   public int getShapeId() {
/* 118 */     return (int)getCNvPr().getId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   void copy(XSLFShape paramXSLFShape) {
/* 130 */     if (!getClass().isInstance(paramXSLFShape)) {
/* 131 */       throw new IllegalArgumentException("Can't copy " + paramXSLFShape.getClass().getSimpleName() + " into " + getClass().getSimpleName());
/*     */     }
/*     */ 
/*     */     
/* 135 */     if (this instanceof PlaceableShape) {
/* 136 */       PlaceableShape placeableShape = (PlaceableShape)this;
/* 137 */       placeableShape.setAnchor(((PlaceableShape)paramXSLFShape).getAnchor());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParent(XSLFShapeContainer paramXSLFShapeContainer) {
/* 144 */     this._parent = paramXSLFShapeContainer;
/*     */   }
/*     */   
/*     */   public XSLFShapeContainer getParent() {
/* 148 */     return this._parent;
/*     */   }
/*     */   
/*     */   protected PaintStyle getFillPaint() {
/* 152 */     final XSLFTheme theme = getSheet().getTheme();
/* 153 */     PropertyFetcher<PaintStyle> propertyFetcher = new PropertyFetcher<PaintStyle>() {
/*     */         public boolean fetch(XSLFShape param1XSLFShape) {
/* 155 */           XSLFPropertiesDelegate.XSLFFillProperties xSLFFillProperties = XSLFPropertiesDelegate.getFillDelegate(param1XSLFShape.getShapeProperties());
/* 156 */           if (xSLFFillProperties == null) {
/* 157 */             return false;
/*     */           }
/*     */           
/* 160 */           if (xSLFFillProperties.isSetNoFill()) {
/* 161 */             setValue(null);
/* 162 */             return true;
/*     */           } 
/*     */           
/* 165 */           PackagePart packagePart = param1XSLFShape.getSheet().getPackagePart();
/* 166 */           PaintStyle paintStyle = XSLFShape.selectPaint(xSLFFillProperties, null, packagePart, theme);
/* 167 */           if (paintStyle != null) {
/* 168 */             setValue(paintStyle);
/* 169 */             return true;
/*     */           } 
/*     */           
/* 172 */           CTShapeStyle cTShapeStyle = param1XSLFShape.getSpStyle();
/* 173 */           if (cTShapeStyle != null) {
/* 174 */             xSLFFillProperties = XSLFPropertiesDelegate.getFillDelegate((XmlObject)cTShapeStyle.getFillRef());
/* 175 */             paintStyle = XSLFShape.selectPaint(xSLFFillProperties, null, packagePart, theme);
/*     */           } 
/* 177 */           if (paintStyle != null) {
/* 178 */             setValue(paintStyle);
/* 179 */             return true;
/*     */           } 
/*     */ 
/*     */           
/* 183 */           return false;
/*     */         }
/*     */       };
/* 186 */     fetchShapeProperty(propertyFetcher);
/*     */     
/* 188 */     return (PaintStyle)propertyFetcher.getValue();
/*     */   }
/*     */   
/*     */   protected CTBackgroundProperties getBgPr() {
/* 192 */     return getChild(CTBackgroundProperties.class, "http://schemas.openxmlformats.org/presentationml/2006/main", "bgPr");
/*     */   }
/*     */   
/*     */   protected CTStyleMatrixReference getBgRef() {
/* 196 */     return getChild(CTStyleMatrixReference.class, "http://schemas.openxmlformats.org/presentationml/2006/main", "bgRef");
/*     */   }
/*     */   
/*     */   protected CTGroupShapeProperties getGrpSpPr() {
/* 200 */     return getChild(CTGroupShapeProperties.class, "http://schemas.openxmlformats.org/presentationml/2006/main", "grpSpPr");
/*     */   }
/*     */   
/*     */   protected CTNonVisualDrawingProps getCNvPr() {
/* 204 */     if (this._nvPr == null) {
/* 205 */       String str = "declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' .//*/p:cNvPr";
/* 206 */       this._nvPr = selectProperty(CTNonVisualDrawingProps.class, str);
/*     */     } 
/* 208 */     return this._nvPr;
/*     */   }
/*     */   
/*     */   protected CTShapeStyle getSpStyle() {
/* 212 */     if (this._spStyle == null) {
/* 213 */       this._spStyle = getChild(CTShapeStyle.class, "http://schemas.openxmlformats.org/presentationml/2006/main", "style");
/*     */     }
/* 215 */     return this._spStyle;
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
/*     */   protected <T extends XmlObject> T getChild(Class<T> paramClass, String paramString1, String paramString2) {
/* 228 */     XmlCursor xmlCursor = getXmlObject().newCursor();
/* 229 */     XmlObject xmlObject = null;
/* 230 */     if (xmlCursor.toChild(paramString1, paramString2)) {
/* 231 */       xmlObject = xmlCursor.getObject();
/*     */     }
/* 233 */     xmlCursor.dispose();
/* 234 */     return (T)xmlObject;
/*     */   }
/*     */   
/*     */   protected CTPlaceholder getCTPlaceholder() {
/* 238 */     if (this._ph == null) {
/* 239 */       String str = "declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' .//*/p:nvPr/p:ph";
/* 240 */       this._ph = selectProperty(CTPlaceholder.class, str);
/*     */     } 
/* 242 */     return this._ph;
/*     */   }
/*     */   
/*     */   public Placeholder getPlaceholder() {
/* 246 */     CTPlaceholder cTPlaceholder = getCTPlaceholder();
/* 247 */     if (cTPlaceholder == null || (!cTPlaceholder.isSetType() && !cTPlaceholder.isSetIdx())) {
/* 248 */       return null;
/*     */     }
/* 250 */     return Placeholder.lookupOoxml(cTPlaceholder.getType().intValue());
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
/*     */   protected void setPlaceholder(Placeholder paramPlaceholder) {
/* 263 */     String str = "declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' .//*/p:nvPr";
/* 264 */     CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps = selectProperty(CTApplicationNonVisualDrawingProps.class, str);
/* 265 */     if (cTApplicationNonVisualDrawingProps == null)
/* 266 */       return;  if (paramPlaceholder == null) {
/* 267 */       if (cTApplicationNonVisualDrawingProps.isSetPh()) cTApplicationNonVisualDrawingProps.unsetPh(); 
/* 268 */       this._ph = null;
/*     */     } else {
/* 270 */       cTApplicationNonVisualDrawingProps.addNewPh().setType(STPlaceholderType.Enum.forInt(paramPlaceholder.ooxmlId));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected <T extends XmlObject> T selectProperty(Class<T> paramClass, String paramString) {
/* 287 */     XmlObject[] arrayOfXmlObject = getXmlObject().selectPath(paramString);
/* 288 */     if (arrayOfXmlObject.length == 0) return null; 
/* 289 */     return paramClass.isInstance(arrayOfXmlObject[0]) ? (T)arrayOfXmlObject[0] : null;
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
/*     */   protected boolean fetchShapeProperty(PropertyFetcher<?> paramPropertyFetcher) {
/* 304 */     boolean bool = paramPropertyFetcher.fetch(this);
/*     */ 
/*     */     
/* 307 */     XSLFSheet xSLFSheet = (XSLFSheet)getSheet().getMasterSheet();
/* 308 */     CTPlaceholder cTPlaceholder = getCTPlaceholder();
/*     */     
/* 310 */     if (xSLFSheet != null && cTPlaceholder != null) {
/* 311 */       if (!bool) {
/* 312 */         XSLFSimpleShape xSLFSimpleShape = xSLFSheet.getPlaceholder(cTPlaceholder);
/* 313 */         if (xSLFSimpleShape != null) {
/* 314 */           bool = paramPropertyFetcher.fetch(xSLFSimpleShape);
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 319 */       if (!bool) {
/*     */         int i;
/* 321 */         if (!cTPlaceholder.isSetType()) { i = 2; }
/*     */         else
/* 323 */         { switch (cTPlaceholder.getType().intValue()) {
/*     */             case 1:
/*     */             case 3:
/* 326 */               i = 1;
/*     */               break;
/*     */             case 5:
/*     */             case 6:
/*     */             case 7:
/* 331 */               i = cTPlaceholder.getType().intValue();
/*     */               break;
/*     */             default:
/* 334 */               i = 2;
/*     */               break;
/*     */           }  }
/*     */         
/* 338 */         XSLFSheet xSLFSheet1 = (XSLFSheet)xSLFSheet.getMasterSheet();
/* 339 */         if (xSLFSheet1 != null) {
/* 340 */           XSLFSimpleShape xSLFSimpleShape = xSLFSheet1.getPlaceholderByType(i);
/* 341 */           if (xSLFSimpleShape != null) {
/* 342 */             bool = paramPropertyFetcher.fetch(xSLFSimpleShape);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 347 */     return bool;
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
/*     */   protected static PaintStyle selectPaint(XSLFPropertiesDelegate.XSLFFillProperties paramXSLFFillProperties, CTSchemeColor paramCTSchemeColor, PackagePart paramPackagePart, XSLFTheme paramXSLFTheme) {
/* 362 */     if (paramXSLFFillProperties == null || paramXSLFFillProperties.isSetNoFill())
/* 363 */       return null; 
/* 364 */     if (paramXSLFFillProperties.isSetSolidFill())
/* 365 */       return selectPaint(paramXSLFFillProperties.getSolidFill(), paramCTSchemeColor, paramXSLFTheme); 
/* 366 */     if (paramXSLFFillProperties.isSetBlipFill())
/* 367 */       return selectPaint(paramXSLFFillProperties.getBlipFill(), paramPackagePart); 
/* 368 */     if (paramXSLFFillProperties.isSetGradFill())
/* 369 */       return selectPaint(paramXSLFFillProperties.getGradFill(), paramCTSchemeColor, paramXSLFTheme); 
/* 370 */     if (paramXSLFFillProperties.isSetMatrixStyle()) {
/* 371 */       return selectPaint(paramXSLFFillProperties.getMatrixStyle(), paramXSLFTheme, paramXSLFFillProperties.isLineStyle());
/*     */     }
/* 373 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected static PaintStyle selectPaint(CTSolidColorFillProperties paramCTSolidColorFillProperties, CTSchemeColor paramCTSchemeColor, XSLFTheme paramXSLFTheme) {
/* 378 */     if (paramCTSchemeColor == null && paramCTSolidColorFillProperties.isSetSchemeClr()) {
/* 379 */       paramCTSchemeColor = paramCTSolidColorFillProperties.getSchemeClr();
/*     */     }
/* 381 */     XSLFColor xSLFColor = new XSLFColor((XmlObject)paramCTSolidColorFillProperties, paramXSLFTheme, paramCTSchemeColor);
/* 382 */     return (PaintStyle)DrawPaint.createSolidPaint(xSLFColor.getColorStyle());
/*     */   }
/*     */   
/*     */   protected static PaintStyle selectPaint(CTBlipFillProperties paramCTBlipFillProperties, final PackagePart parentPart) {
/* 386 */     final CTBlip blip = paramCTBlipFillProperties.getBlip();
/* 387 */     return (PaintStyle)new PaintStyle.TexturePaint() {
/*     */         private PackagePart getPart() {
/*     */           try {
/* 390 */             String str = blip.getEmbed();
/* 391 */             PackageRelationship packageRelationship = parentPart.getRelationship(str);
/* 392 */             return parentPart.getRelatedPart(packageRelationship);
/* 393 */           } catch (InvalidFormatException invalidFormatException) {
/* 394 */             throw new RuntimeException(invalidFormatException);
/*     */           } 
/*     */         }
/*     */         
/*     */         public InputStream getImageData() {
/*     */           try {
/* 400 */             return getPart().getInputStream();
/* 401 */           } catch (IOException iOException) {
/* 402 */             throw new RuntimeException(iOException);
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public String getContentType() {
/* 408 */           return getPart().getContentType();
/*     */         }
/*     */         
/*     */         public int getAlpha() {
/* 412 */           return (blip.sizeOfAlphaModFixArray() > 0) ? blip.getAlphaModFixArray(0).getAmt() : 100000;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static PaintStyle selectPaint(final CTGradientFillProperties gradFill, CTSchemeColor paramCTSchemeColor, XSLFTheme paramXSLFTheme) {
/* 421 */     CTGradientStop[] arrayOfCTGradientStop = gradFill.getGsLst().getGsArray();
/*     */     
/* 423 */     Arrays.sort(arrayOfCTGradientStop, new Comparator<CTGradientStop>() {
/*     */           public int compare(CTGradientStop param1CTGradientStop1, CTGradientStop param1CTGradientStop2) {
/* 425 */             Integer integer1 = Integer.valueOf(param1CTGradientStop1.getPos());
/* 426 */             Integer integer2 = Integer.valueOf(param1CTGradientStop2.getPos());
/* 427 */             return integer1.compareTo(integer2);
/*     */           }
/*     */         });
/*     */     
/* 431 */     final ColorStyle[] cs = new ColorStyle[arrayOfCTGradientStop.length];
/* 432 */     final float[] fractions = new float[arrayOfCTGradientStop.length];
/*     */     
/* 434 */     byte b = 0;
/* 435 */     for (CTGradientStop cTGradientStop : arrayOfCTGradientStop) {
/* 436 */       CTSchemeColor cTSchemeColor = paramCTSchemeColor;
/* 437 */       if (cTSchemeColor == null && cTGradientStop.isSetSchemeClr()) {
/* 438 */         cTSchemeColor = cTGradientStop.getSchemeClr();
/*     */       }
/* 440 */       arrayOfColorStyle[b] = (new XSLFColor((XmlObject)cTGradientStop, paramXSLFTheme, cTSchemeColor)).getColorStyle();
/* 441 */       arrayOfFloat[b] = cTGradientStop.getPos() / 100000.0F;
/* 442 */       b++;
/*     */     } 
/*     */     
/* 445 */     return (PaintStyle)new PaintStyle.GradientPaint()
/*     */       {
/*     */         public double getGradientAngle() {
/* 448 */           return gradFill.isSetLin() ? (gradFill.getLin().getAng() / 60000.0D) : 0.0D;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public ColorStyle[] getGradientColors() {
/* 454 */           return cs;
/*     */         }
/*     */         
/*     */         public float[] getGradientFractions() {
/* 458 */           return fractions;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isRotatedWithShape() {
/* 463 */           return (gradFill.isSetRotWithShape() || !gradFill.getRotWithShape());
/*     */         }
/*     */         
/*     */         public PaintStyle.GradientPaint.GradientType getGradientType() {
/* 467 */           if (gradFill.isSetLin()) {
/* 468 */             return PaintStyle.GradientPaint.GradientType.linear;
/*     */           }
/*     */           
/* 471 */           if (gradFill.isSetPath()) {
/*     */             
/* 473 */             STPathShadeType.Enum enum_ = gradFill.getPath().getPath();
/* 474 */             if (enum_ == STPathShadeType.CIRCLE)
/* 475 */               return PaintStyle.GradientPaint.GradientType.circular; 
/* 476 */             if (enum_ == STPathShadeType.SHAPE) {
/* 477 */               return PaintStyle.GradientPaint.GradientType.shape;
/*     */             }
/*     */           } 
/*     */           
/* 481 */           return PaintStyle.GradientPaint.GradientType.linear;
/*     */         }
/*     */       };
/*     */   }
/*     */   protected static PaintStyle selectPaint(CTStyleMatrixReference paramCTStyleMatrixReference, XSLFTheme paramXSLFTheme, boolean paramBoolean) {
/*     */     int j;
/* 487 */     if (paramCTStyleMatrixReference == null) return null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 494 */     int i = (int)paramCTStyleMatrixReference.getIdx();
/* 495 */     CTSchemeColor cTSchemeColor = paramCTStyleMatrixReference.getSchemeClr();
/* 496 */     CTStyleMatrix cTStyleMatrix = paramXSLFTheme.getXmlObject().getThemeElements().getFmtScheme();
/* 497 */     CTBackgroundFillStyleList cTBackgroundFillStyleList = null;
/*     */     
/* 499 */     if (i >= 1 && i <= 999) {
/* 500 */       j = i - 1;
/* 501 */       cTBackgroundFillStyleList = (CTBackgroundFillStyleList)(paramBoolean ? cTStyleMatrix.getLnStyleLst() : cTStyleMatrix.getFillStyleLst());
/* 502 */     } else if (i >= 1001) {
/* 503 */       j = i - 1001;
/* 504 */       cTBackgroundFillStyleList = cTStyleMatrix.getBgFillStyleLst();
/*     */     } else {
/* 506 */       return null;
/*     */     } 
/* 508 */     XmlCursor xmlCursor = cTBackgroundFillStyleList.newCursor();
/* 509 */     XSLFPropertiesDelegate.XSLFFillProperties xSLFFillProperties = null;
/* 510 */     if (xmlCursor.toChild(j)) {
/* 511 */       xSLFFillProperties = XSLFPropertiesDelegate.getFillDelegate(xmlCursor.getObject());
/*     */     }
/* 513 */     xmlCursor.dispose();
/*     */     
/* 515 */     return selectPaint(xSLFFillProperties, cTSchemeColor, paramXSLFTheme.getPackagePart(), paramXSLFTheme);
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Graphics2D paramGraphics2D, Rectangle2D paramRectangle2D) {
/* 520 */     DrawFactory.getInstance(paramGraphics2D).drawShape(paramGraphics2D, this, paramRectangle2D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected XmlObject getShapeProperties() {
/* 529 */     return (XmlObject)getChild(CTShapeProperties.class, "http://schemas.openxmlformats.org/presentationml/2006/main", "spPr");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */