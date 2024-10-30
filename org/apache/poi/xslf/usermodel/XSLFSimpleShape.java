/*      */ package org.apache.poi.xslf.usermodel;
/*      */ 
/*      */ import java.awt.Color;
/*      */ import java.awt.geom.Rectangle2D;
/*      */ import javax.xml.stream.XMLStreamException;
/*      */ import javax.xml.stream.XMLStreamReader;
/*      */ import org.apache.poi.openxml4j.opc.PackagePart;
/*      */ import org.apache.poi.sl.draw.DrawPaint;
/*      */ import org.apache.poi.sl.draw.geom.CustomGeometry;
/*      */ import org.apache.poi.sl.draw.geom.Guide;
/*      */ import org.apache.poi.sl.draw.geom.PresetGeometries;
/*      */ import org.apache.poi.sl.usermodel.FillStyle;
/*      */ import org.apache.poi.sl.usermodel.Hyperlink;
/*      */ import org.apache.poi.sl.usermodel.LineDecoration;
/*      */ import org.apache.poi.sl.usermodel.PaintStyle;
/*      */ import org.apache.poi.sl.usermodel.Placeholder;
/*      */ import org.apache.poi.sl.usermodel.Shadow;
/*      */ import org.apache.poi.sl.usermodel.ShapeType;
/*      */ import org.apache.poi.sl.usermodel.SimpleShape;
/*      */ import org.apache.poi.sl.usermodel.StrokeStyle;
/*      */ import org.apache.poi.util.POILogFactory;
/*      */ import org.apache.poi.util.POILogger;
/*      */ import org.apache.poi.util.Units;
/*      */ import org.apache.poi.xslf.model.PropertyFetcher;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetLineDashProperties;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.STCompoundLine;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.STLineCap;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndLength;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndType;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndWidth;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.STPresetLineDashVal;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class XSLFSimpleShape
/*      */   extends XSLFShape
/*      */   implements SimpleShape<XSLFShape, XSLFTextParagraph>
/*      */ {
/*   90 */   private static CTOuterShadowEffect NO_SHADOW = CTOuterShadowEffect.Factory.newInstance();
/*   91 */   private static final POILogger LOG = POILogFactory.getLogger(XSLFSimpleShape.class);
/*      */   
/*      */   XSLFSimpleShape(XmlObject paramXmlObject, XSLFSheet paramXSLFSheet) {
/*   94 */     super(paramXmlObject, paramXSLFSheet);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setShapeType(ShapeType paramShapeType) {
/*   99 */     XSLFPropertiesDelegate.XSLFGeometryProperties xSLFGeometryProperties = XSLFPropertiesDelegate.getGeometryDelegate(getShapeProperties());
/*  100 */     if (xSLFGeometryProperties == null) {
/*      */       return;
/*      */     }
/*  103 */     if (xSLFGeometryProperties.isSetCustGeom()) {
/*  104 */       xSLFGeometryProperties.unsetCustGeom();
/*      */     }
/*  106 */     CTPresetGeometry2D cTPresetGeometry2D = xSLFGeometryProperties.isSetPrstGeom() ? xSLFGeometryProperties.getPrstGeom() : xSLFGeometryProperties.addNewPrstGeom();
/*  107 */     cTPresetGeometry2D.setPrst(STShapeType.Enum.forInt(paramShapeType.ooxmlId));
/*      */   }
/*      */ 
/*      */   
/*      */   public ShapeType getShapeType() {
/*  112 */     XSLFPropertiesDelegate.XSLFGeometryProperties xSLFGeometryProperties = XSLFPropertiesDelegate.getGeometryDelegate(getShapeProperties());
/*  113 */     if (xSLFGeometryProperties != null && xSLFGeometryProperties.isSetPrstGeom()) {
/*  114 */       STShapeType.Enum enum_ = xSLFGeometryProperties.getPrstGeom().getPrst();
/*  115 */       if (enum_ != null) {
/*  116 */         return ShapeType.forId(enum_.intValue(), true);
/*      */       }
/*      */     } 
/*  119 */     return null;
/*      */   }
/*      */   
/*      */   protected CTTransform2D getXfrm(boolean paramBoolean) {
/*  123 */     PropertyFetcher<CTTransform2D> propertyFetcher = new PropertyFetcher<CTTransform2D>() {
/*      */         public boolean fetch(XSLFShape param1XSLFShape) {
/*  125 */           XmlObject xmlObject = param1XSLFShape.getShapeProperties();
/*  126 */           if (xmlObject instanceof CTShapeProperties && ((CTShapeProperties)xmlObject).isSetXfrm()) {
/*  127 */             setValue(((CTShapeProperties)xmlObject).getXfrm());
/*  128 */             return true;
/*      */           } 
/*  130 */           return false;
/*      */         }
/*      */       };
/*  133 */     fetchShapeProperty(propertyFetcher);
/*      */     
/*  135 */     CTTransform2D cTTransform2D = (CTTransform2D)propertyFetcher.getValue();
/*  136 */     if (!paramBoolean || cTTransform2D != null) {
/*  137 */       return cTTransform2D;
/*      */     }
/*  139 */     XmlObject xmlObject = getShapeProperties();
/*  140 */     if (xmlObject instanceof CTShapeProperties) {
/*  141 */       return ((CTShapeProperties)xmlObject).addNewXfrm();
/*      */     }
/*      */     
/*  144 */     LOG.log(5, new Object[] { getClass().toString() + " doesn't have xfrm element." });
/*  145 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Rectangle2D getAnchor() {
/*  153 */     CTTransform2D cTTransform2D = getXfrm(false);
/*  154 */     if (cTTransform2D == null) {
/*  155 */       return null;
/*      */     }
/*      */     
/*  158 */     CTPoint2D cTPoint2D = cTTransform2D.getOff();
/*  159 */     double d1 = Units.toPoints(cTPoint2D.getX());
/*  160 */     double d2 = Units.toPoints(cTPoint2D.getY());
/*  161 */     CTPositiveSize2D cTPositiveSize2D = cTTransform2D.getExt();
/*  162 */     double d3 = Units.toPoints(cTPositiveSize2D.getCx());
/*  163 */     double d4 = Units.toPoints(cTPositiveSize2D.getCy());
/*  164 */     return new Rectangle2D.Double(d1, d2, d3, d4);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setAnchor(Rectangle2D paramRectangle2D) {
/*  169 */     CTTransform2D cTTransform2D = getXfrm(true);
/*  170 */     if (cTTransform2D == null) {
/*      */       return;
/*      */     }
/*  173 */     CTPoint2D cTPoint2D = cTTransform2D.isSetOff() ? cTTransform2D.getOff() : cTTransform2D.addNewOff();
/*  174 */     long l1 = Units.toEMU(paramRectangle2D.getX());
/*  175 */     long l2 = Units.toEMU(paramRectangle2D.getY());
/*  176 */     cTPoint2D.setX(l1);
/*  177 */     cTPoint2D.setY(l2);
/*  178 */     CTPositiveSize2D cTPositiveSize2D = cTTransform2D.isSetExt() ? cTTransform2D.getExt() : cTTransform2D.addNewExt();
/*      */     
/*  180 */     long l3 = Units.toEMU(paramRectangle2D.getWidth());
/*  181 */     long l4 = Units.toEMU(paramRectangle2D.getHeight());
/*  182 */     cTPositiveSize2D.setCx(l3);
/*  183 */     cTPositiveSize2D.setCy(l4);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRotation(double paramDouble) {
/*  188 */     CTTransform2D cTTransform2D = getXfrm(true);
/*  189 */     if (cTTransform2D != null) {
/*  190 */       cTTransform2D.setRot((int)(paramDouble * 60000.0D));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public double getRotation() {
/*  196 */     CTTransform2D cTTransform2D = getXfrm(false);
/*  197 */     return (cTTransform2D == null || !cTTransform2D.isSetRot()) ? 0.0D : (cTTransform2D.getRot() / 60000.0D);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setFlipHorizontal(boolean paramBoolean) {
/*  202 */     CTTransform2D cTTransform2D = getXfrm(true);
/*  203 */     if (cTTransform2D != null) {
/*  204 */       cTTransform2D.setFlipH(paramBoolean);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void setFlipVertical(boolean paramBoolean) {
/*  210 */     CTTransform2D cTTransform2D = getXfrm(true);
/*  211 */     if (cTTransform2D != null) {
/*  212 */       cTTransform2D.setFlipV(paramBoolean);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean getFlipHorizontal() {
/*  218 */     CTTransform2D cTTransform2D = getXfrm(false);
/*  219 */     return (cTTransform2D == null || !cTTransform2D.isSetFlipH()) ? false : cTTransform2D.getFlipH();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean getFlipVertical() {
/*  224 */     CTTransform2D cTTransform2D = getXfrm(false);
/*  225 */     return (cTTransform2D == null || !cTTransform2D.isSetFlipV()) ? false : cTTransform2D.getFlipV();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   CTLineProperties getDefaultLineProperties() {
/*  236 */     CTShapeStyle cTShapeStyle = getSpStyle();
/*  237 */     if (cTShapeStyle == null) return null; 
/*  238 */     CTStyleMatrixReference cTStyleMatrixReference = cTShapeStyle.getLnRef();
/*  239 */     if (cTStyleMatrixReference == null) return null;
/*      */     
/*  241 */     int i = (int)cTStyleMatrixReference.getIdx();
/*      */     
/*  243 */     XSLFTheme xSLFTheme = getSheet().getTheme();
/*  244 */     if (xSLFTheme == null) return null; 
/*  245 */     CTBaseStyles cTBaseStyles = xSLFTheme.getXmlObject().getThemeElements();
/*  246 */     if (cTBaseStyles == null) return null; 
/*  247 */     CTStyleMatrix cTStyleMatrix = cTBaseStyles.getFmtScheme();
/*  248 */     if (cTStyleMatrix == null) return null; 
/*  249 */     CTLineStyleList cTLineStyleList = cTStyleMatrix.getLnStyleLst();
/*  250 */     if (cTLineStyleList == null || cTLineStyleList.sizeOfLnArray() < i) return null;
/*      */     
/*  252 */     return cTLineStyleList.getLnArray(i - 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineColor(Color paramColor) {
/*  260 */     CTLineProperties cTLineProperties = getLn(this, true);
/*  261 */     if (cTLineProperties == null) {
/*      */       return;
/*      */     }
/*      */     
/*  265 */     if (cTLineProperties.isSetSolidFill()) {
/*  266 */       cTLineProperties.unsetSolidFill();
/*      */     }
/*  268 */     if (cTLineProperties.isSetGradFill()) {
/*  269 */       cTLineProperties.unsetGradFill();
/*      */     }
/*  271 */     if (cTLineProperties.isSetPattFill()) {
/*  272 */       cTLineProperties.unsetPattFill();
/*      */     }
/*  274 */     if (cTLineProperties.isSetNoFill()) {
/*  275 */       cTLineProperties.unsetNoFill();
/*      */     }
/*      */ 
/*      */     
/*  279 */     if (paramColor == null) {
/*  280 */       cTLineProperties.addNewNoFill();
/*      */     } else {
/*  282 */       CTSolidColorFillProperties cTSolidColorFillProperties = cTLineProperties.addNewSolidFill();
/*  283 */       XSLFColor xSLFColor = new XSLFColor((XmlObject)cTSolidColorFillProperties, getSheet().getTheme(), cTSolidColorFillProperties.getSchemeClr());
/*  284 */       xSLFColor.setColor(paramColor);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Color getLineColor() {
/*  294 */     PaintStyle paintStyle = getLinePaint();
/*  295 */     if (paintStyle instanceof PaintStyle.SolidPaint) {
/*  296 */       return ((PaintStyle.SolidPaint)paintStyle).getSolidColor().getColor();
/*      */     }
/*  298 */     return null;
/*      */   }
/*      */   
/*      */   protected PaintStyle getLinePaint() {
/*  302 */     XSLFSheet xSLFSheet = getSheet();
/*  303 */     final XSLFTheme theme = xSLFSheet.getTheme();
/*  304 */     PropertyFetcher<PaintStyle> propertyFetcher = new PropertyFetcher<PaintStyle>() {
/*      */         public boolean fetch(XSLFShape param1XSLFShape) {
/*  306 */           CTLineProperties cTLineProperties = XSLFSimpleShape.getLn(param1XSLFShape, false);
/*  307 */           XSLFPropertiesDelegate.XSLFFillProperties xSLFFillProperties = XSLFPropertiesDelegate.getFillDelegate((XmlObject)cTLineProperties);
/*  308 */           PackagePart packagePart = param1XSLFShape.getSheet().getPackagePart();
/*  309 */           PaintStyle paintStyle = XSLFShape.selectPaint(xSLFFillProperties, null, packagePart, theme);
/*  310 */           if (paintStyle != null) {
/*  311 */             setValue(paintStyle);
/*  312 */             return true;
/*      */           } 
/*      */           
/*  315 */           CTShapeStyle cTShapeStyle = param1XSLFShape.getSpStyle();
/*  316 */           if (cTShapeStyle != null) {
/*  317 */             xSLFFillProperties = XSLFPropertiesDelegate.getFillDelegate((XmlObject)cTShapeStyle.getLnRef());
/*  318 */             paintStyle = XSLFShape.selectPaint(xSLFFillProperties, null, packagePart, theme);
/*      */           } 
/*  320 */           if (paintStyle != null) {
/*  321 */             setValue(paintStyle);
/*  322 */             return true;
/*      */           } 
/*  324 */           return false;
/*      */         }
/*      */       };
/*  327 */     fetchShapeProperty(propertyFetcher);
/*      */     
/*  329 */     PaintStyle paintStyle = (PaintStyle)propertyFetcher.getValue();
/*  330 */     if (paintStyle != null) return paintStyle;
/*      */ 
/*      */     
/*  333 */     CTShapeStyle cTShapeStyle = getSpStyle();
/*  334 */     if (cTShapeStyle == null) return null;
/*      */ 
/*      */     
/*  337 */     CTStyleMatrixReference cTStyleMatrixReference = cTShapeStyle.getLnRef();
/*  338 */     int i = (int)cTStyleMatrixReference.getIdx();
/*  339 */     CTSchemeColor cTSchemeColor = cTStyleMatrixReference.getSchemeClr();
/*  340 */     if (i > 0) {
/*  341 */       CTLineProperties cTLineProperties = xSLFTheme.getXmlObject().getThemeElements().getFmtScheme().getLnStyleLst().getLnArray(i - 1);
/*  342 */       XSLFPropertiesDelegate.XSLFFillProperties xSLFFillProperties = XSLFPropertiesDelegate.getFillDelegate((XmlObject)cTLineProperties);
/*  343 */       PackagePart packagePart = xSLFSheet.getPackagePart();
/*  344 */       paintStyle = selectPaint(xSLFFillProperties, cTSchemeColor, packagePart, xSLFTheme);
/*      */     } 
/*      */     
/*  347 */     return paintStyle;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineWidth(double paramDouble) {
/*  355 */     CTLineProperties cTLineProperties = getLn(this, true);
/*  356 */     if (cTLineProperties == null) {
/*      */       return;
/*      */     }
/*      */     
/*  360 */     if (paramDouble == 0.0D) {
/*  361 */       if (cTLineProperties.isSetW()) {
/*  362 */         cTLineProperties.unsetW();
/*      */       }
/*  364 */       if (!cTLineProperties.isSetNoFill()) {
/*  365 */         cTLineProperties.addNewNoFill();
/*      */       }
/*  367 */       if (cTLineProperties.isSetSolidFill()) {
/*  368 */         cTLineProperties.unsetSolidFill();
/*      */       }
/*  370 */       if (cTLineProperties.isSetGradFill()) {
/*  371 */         cTLineProperties.unsetGradFill();
/*      */       }
/*  373 */       if (cTLineProperties.isSetPattFill()) {
/*  374 */         cTLineProperties.unsetPattFill();
/*      */       }
/*      */     } else {
/*  377 */       if (cTLineProperties.isSetNoFill()) {
/*  378 */         cTLineProperties.unsetNoFill();
/*      */       }
/*      */       
/*  381 */       cTLineProperties.setW(Units.toEMU(paramDouble));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double getLineWidth() {
/*  389 */     PropertyFetcher<Double> propertyFetcher = new PropertyFetcher<Double>() {
/*      */         public boolean fetch(XSLFShape param1XSLFShape) {
/*  391 */           CTLineProperties cTLineProperties = XSLFSimpleShape.getLn(param1XSLFShape, false);
/*  392 */           if (cTLineProperties != null) {
/*  393 */             if (cTLineProperties.isSetNoFill()) {
/*  394 */               setValue(Double.valueOf(0.0D));
/*  395 */               return true;
/*      */             } 
/*      */             
/*  398 */             if (cTLineProperties.isSetW()) {
/*  399 */               setValue(Double.valueOf(Units.toPoints(cTLineProperties.getW())));
/*  400 */               return true;
/*      */             } 
/*      */           } 
/*  403 */           return false;
/*      */         }
/*      */       };
/*  406 */     fetchShapeProperty(propertyFetcher);
/*      */     
/*  408 */     double d = 0.0D;
/*  409 */     if (propertyFetcher.getValue() == null) {
/*  410 */       CTLineProperties cTLineProperties = getDefaultLineProperties();
/*  411 */       if (cTLineProperties != null && 
/*  412 */         cTLineProperties.isSetW()) d = Units.toPoints(cTLineProperties.getW());
/*      */     
/*      */     } else {
/*  415 */       d = ((Double)propertyFetcher.getValue()).doubleValue();
/*      */     } 
/*      */     
/*  418 */     return d;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineCompound(StrokeStyle.LineCompound paramLineCompound) {
/*  426 */     CTLineProperties cTLineProperties = getLn(this, true);
/*  427 */     if (cTLineProperties == null) {
/*      */       return;
/*      */     }
/*  430 */     if (paramLineCompound == null) {
/*  431 */       if (cTLineProperties.isSetCmpd()) {
/*  432 */         cTLineProperties.unsetCmpd();
/*      */       }
/*      */     } else {
/*      */       STCompoundLine.Enum enum_;
/*  436 */       switch (paramLineCompound) {
/*      */         
/*      */         default:
/*  439 */           enum_ = STCompoundLine.SNG;
/*      */           break;
/*      */         case DOUBLE:
/*  442 */           enum_ = STCompoundLine.DBL;
/*      */           break;
/*      */         case THICK_THIN:
/*  445 */           enum_ = STCompoundLine.THICK_THIN;
/*      */           break;
/*      */         case THIN_THICK:
/*  448 */           enum_ = STCompoundLine.THIN_THICK;
/*      */           break;
/*      */         case TRIPLE:
/*  451 */           enum_ = STCompoundLine.TRI;
/*      */           break;
/*      */       } 
/*  454 */       cTLineProperties.setCmpd(enum_);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrokeStyle.LineCompound getLineCompound() {
/*  462 */     PropertyFetcher<Integer> propertyFetcher = new PropertyFetcher<Integer>() {
/*      */         public boolean fetch(XSLFShape param1XSLFShape) {
/*  464 */           CTLineProperties cTLineProperties = XSLFSimpleShape.getLn(param1XSLFShape, false);
/*  465 */           if (cTLineProperties != null) {
/*  466 */             STCompoundLine.Enum enum_ = cTLineProperties.getCmpd();
/*  467 */             if (enum_ != null) {
/*  468 */               setValue(Integer.valueOf(enum_.intValue()));
/*  469 */               return true;
/*      */             } 
/*      */           } 
/*  472 */           return false;
/*      */         }
/*      */       };
/*  475 */     fetchShapeProperty(propertyFetcher);
/*      */     
/*  477 */     Integer integer = (Integer)propertyFetcher.getValue();
/*  478 */     if (integer == null) {
/*  479 */       CTLineProperties cTLineProperties = getDefaultLineProperties();
/*  480 */       if (cTLineProperties != null && cTLineProperties.isSetCmpd()) {
/*  481 */         switch (cTLineProperties.getCmpd().intValue())
/*      */         
/*      */         { default:
/*  484 */             return StrokeStyle.LineCompound.SINGLE;
/*      */           case 2:
/*  486 */             return StrokeStyle.LineCompound.DOUBLE;
/*      */           case 3:
/*  488 */             return StrokeStyle.LineCompound.THICK_THIN;
/*      */           case 4:
/*  490 */             return StrokeStyle.LineCompound.THIN_THICK;
/*      */           case 5:
/*  492 */             break; }  return StrokeStyle.LineCompound.TRIPLE;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  497 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineDash(StrokeStyle.LineDash paramLineDash) {
/*  505 */     CTLineProperties cTLineProperties = getLn(this, true);
/*  506 */     if (cTLineProperties == null) {
/*      */       return;
/*      */     }
/*  509 */     if (paramLineDash == null) {
/*  510 */       if (cTLineProperties.isSetPrstDash()) {
/*  511 */         cTLineProperties.unsetPrstDash();
/*      */       }
/*      */     } else {
/*  514 */       CTPresetLineDashProperties cTPresetLineDashProperties = cTLineProperties.isSetPrstDash() ? cTLineProperties.getPrstDash() : cTLineProperties.addNewPrstDash();
/*  515 */       cTPresetLineDashProperties.setVal(STPresetLineDashVal.Enum.forInt(paramLineDash.ooxmlId));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrokeStyle.LineDash getLineDash() {
/*  524 */     PropertyFetcher<StrokeStyle.LineDash> propertyFetcher = new PropertyFetcher<StrokeStyle.LineDash>() {
/*      */         public boolean fetch(XSLFShape param1XSLFShape) {
/*  526 */           CTLineProperties cTLineProperties = XSLFSimpleShape.getLn(param1XSLFShape, false);
/*  527 */           if (cTLineProperties == null || !cTLineProperties.isSetPrstDash()) {
/*  528 */             return false;
/*      */           }
/*      */           
/*  531 */           setValue(StrokeStyle.LineDash.fromOoxmlId(cTLineProperties.getPrstDash().getVal().intValue()));
/*  532 */           return true;
/*      */         }
/*      */       };
/*  535 */     fetchShapeProperty(propertyFetcher);
/*      */     
/*  537 */     StrokeStyle.LineDash lineDash = (StrokeStyle.LineDash)propertyFetcher.getValue();
/*  538 */     if (lineDash == null) {
/*  539 */       CTLineProperties cTLineProperties = getDefaultLineProperties();
/*  540 */       if (cTLineProperties != null && cTLineProperties.isSetPrstDash()) {
/*  541 */         lineDash = StrokeStyle.LineDash.fromOoxmlId(cTLineProperties.getPrstDash().getVal().intValue());
/*      */       }
/*      */     } 
/*  544 */     return lineDash;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineCap(StrokeStyle.LineCap paramLineCap) {
/*  552 */     CTLineProperties cTLineProperties = getLn(this, true);
/*  553 */     if (cTLineProperties == null) {
/*      */       return;
/*      */     }
/*      */     
/*  557 */     if (paramLineCap == null) {
/*  558 */       if (cTLineProperties.isSetCap()) {
/*  559 */         cTLineProperties.unsetCap();
/*      */       }
/*      */     } else {
/*  562 */       cTLineProperties.setCap(STLineCap.Enum.forInt(paramLineCap.ooxmlId));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrokeStyle.LineCap getLineCap() {
/*  571 */     PropertyFetcher<StrokeStyle.LineCap> propertyFetcher = new PropertyFetcher<StrokeStyle.LineCap>() {
/*      */         public boolean fetch(XSLFShape param1XSLFShape) {
/*  573 */           CTLineProperties cTLineProperties = XSLFSimpleShape.getLn(param1XSLFShape, false);
/*  574 */           if (cTLineProperties != null && cTLineProperties.isSetCap()) {
/*  575 */             setValue(StrokeStyle.LineCap.fromOoxmlId(cTLineProperties.getCap().intValue()));
/*  576 */             return true;
/*      */           } 
/*  578 */           return false;
/*      */         }
/*      */       };
/*  581 */     fetchShapeProperty(propertyFetcher);
/*      */     
/*  583 */     StrokeStyle.LineCap lineCap = (StrokeStyle.LineCap)propertyFetcher.getValue();
/*  584 */     if (lineCap == null) {
/*  585 */       CTLineProperties cTLineProperties = getDefaultLineProperties();
/*  586 */       if (cTLineProperties != null && cTLineProperties.isSetCap()) {
/*  587 */         lineCap = StrokeStyle.LineCap.fromOoxmlId(cTLineProperties.getCap().intValue());
/*      */       }
/*      */     } 
/*  590 */     return lineCap;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setFillColor(Color paramColor) {
/*  595 */     XSLFPropertiesDelegate.XSLFFillProperties xSLFFillProperties = XSLFPropertiesDelegate.getFillDelegate(getShapeProperties());
/*  596 */     if (xSLFFillProperties == null) {
/*      */       return;
/*      */     }
/*  599 */     if (paramColor == null) {
/*  600 */       if (xSLFFillProperties.isSetSolidFill()) {
/*  601 */         xSLFFillProperties.unsetSolidFill();
/*      */       }
/*      */       
/*  604 */       if (xSLFFillProperties.isSetGradFill()) {
/*  605 */         xSLFFillProperties.unsetGradFill();
/*      */       }
/*      */       
/*  608 */       if (xSLFFillProperties.isSetPattFill()) {
/*  609 */         xSLFFillProperties.unsetGradFill();
/*      */       }
/*      */       
/*  612 */       if (xSLFFillProperties.isSetBlipFill()) {
/*  613 */         xSLFFillProperties.unsetBlipFill();
/*      */       }
/*      */       
/*  616 */       if (!xSLFFillProperties.isSetNoFill()) {
/*  617 */         xSLFFillProperties.addNewNoFill();
/*      */       }
/*      */     } else {
/*  620 */       if (xSLFFillProperties.isSetNoFill()) {
/*  621 */         xSLFFillProperties.unsetNoFill();
/*      */       }
/*      */       
/*  624 */       CTSolidColorFillProperties cTSolidColorFillProperties = xSLFFillProperties.isSetSolidFill() ? xSLFFillProperties.getSolidFill() : xSLFFillProperties.addNewSolidFill();
/*      */       
/*  626 */       XSLFColor xSLFColor = new XSLFColor((XmlObject)cTSolidColorFillProperties, getSheet().getTheme(), cTSolidColorFillProperties.getSchemeClr());
/*  627 */       xSLFColor.setColor(paramColor);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Color getFillColor() {
/*  633 */     PaintStyle paintStyle = getFillPaint();
/*  634 */     if (paintStyle instanceof PaintStyle.SolidPaint) {
/*  635 */       return DrawPaint.applyColorTransform(((PaintStyle.SolidPaint)paintStyle).getSolidColor());
/*      */     }
/*  637 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSLFShadow getShadow() {
/*  644 */     PropertyFetcher<CTOuterShadowEffect> propertyFetcher = new PropertyFetcher<CTOuterShadowEffect>() {
/*      */         public boolean fetch(XSLFShape param1XSLFShape) {
/*  646 */           XSLFPropertiesDelegate.XSLFEffectProperties xSLFEffectProperties = XSLFPropertiesDelegate.getEffectDelegate(param1XSLFShape.getShapeProperties());
/*  647 */           if (xSLFEffectProperties != null && xSLFEffectProperties.isSetEffectLst()) {
/*  648 */             CTOuterShadowEffect cTOuterShadowEffect = xSLFEffectProperties.getEffectLst().getOuterShdw();
/*  649 */             setValue((cTOuterShadowEffect == null) ? XSLFSimpleShape.NO_SHADOW : cTOuterShadowEffect);
/*  650 */             return true;
/*      */           } 
/*  652 */           return false;
/*      */         }
/*      */       };
/*  655 */     fetchShapeProperty(propertyFetcher);
/*      */     
/*  657 */     CTOuterShadowEffect cTOuterShadowEffect = (CTOuterShadowEffect)propertyFetcher.getValue();
/*  658 */     if (cTOuterShadowEffect == null) {
/*      */       
/*  660 */       CTShapeStyle cTShapeStyle = getSpStyle();
/*  661 */       if (cTShapeStyle != null && cTShapeStyle.getEffectRef() != null) {
/*      */         
/*  663 */         int i = (int)cTShapeStyle.getEffectRef().getIdx();
/*  664 */         if (i != 0) {
/*  665 */           CTStyleMatrix cTStyleMatrix = getSheet().getTheme().getXmlObject().getThemeElements().getFmtScheme();
/*  666 */           CTEffectStyleItem cTEffectStyleItem = cTStyleMatrix.getEffectStyleLst().getEffectStyleArray(i - 1);
/*  667 */           cTOuterShadowEffect = cTEffectStyleItem.getEffectLst().getOuterShdw();
/*      */         } 
/*      */       } 
/*      */     } 
/*  671 */     return (cTOuterShadowEffect == null || cTOuterShadowEffect == NO_SHADOW) ? null : new XSLFShadow(cTOuterShadowEffect, this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CustomGeometry getGeometry() {
/*      */     CustomGeometry customGeometry;
/*  679 */     XSLFPropertiesDelegate.XSLFGeometryProperties xSLFGeometryProperties = XSLFPropertiesDelegate.getGeometryDelegate(getShapeProperties());
/*      */     
/*  681 */     if (xSLFGeometryProperties == null) {
/*  682 */       return null;
/*      */     }
/*      */ 
/*      */     
/*  686 */     PresetGeometries presetGeometries = PresetGeometries.getInstance();
/*  687 */     if (xSLFGeometryProperties.isSetPrstGeom()) {
/*  688 */       String str = xSLFGeometryProperties.getPrstGeom().getPrst().toString();
/*  689 */       customGeometry = (CustomGeometry)presetGeometries.get(str);
/*  690 */       if (customGeometry == null) {
/*  691 */         throw new IllegalStateException("Unknown shape geometry: " + str + ", available geometries are: " + presetGeometries.keySet());
/*      */       }
/*  693 */     } else if (xSLFGeometryProperties.isSetCustGeom()) {
/*  694 */       XMLStreamReader xMLStreamReader = xSLFGeometryProperties.getCustGeom().newXMLStreamReader();
/*  695 */       customGeometry = PresetGeometries.convertCustomGeometry(xMLStreamReader);
/*      */       try {
/*  697 */         xMLStreamReader.close();
/*      */       }
/*  699 */       catch (XMLStreamException xMLStreamException) {
/*  700 */         LOG.log(5, new Object[] { "An error occurred while closing a Custom Geometry XML Stream Reader: " + xMLStreamException.getMessage() });
/*      */       } 
/*      */     } else {
/*      */       
/*  704 */       customGeometry = (CustomGeometry)presetGeometries.get("rect");
/*      */     } 
/*  706 */     return customGeometry;
/*      */   }
/*      */ 
/*      */   
/*      */   void copy(XSLFShape paramXSLFShape) {
/*  711 */     super.copy(paramXSLFShape);
/*      */     
/*  713 */     XSLFSimpleShape xSLFSimpleShape = (XSLFSimpleShape)paramXSLFShape;
/*      */     
/*  715 */     Color color1 = xSLFSimpleShape.getFillColor();
/*  716 */     Color color2 = getFillColor();
/*  717 */     if (color1 != null && !color1.equals(color2)) {
/*  718 */       setFillColor(color1);
/*      */     }
/*      */     
/*  721 */     XSLFPropertiesDelegate.XSLFFillProperties xSLFFillProperties = XSLFPropertiesDelegate.getFillDelegate(getShapeProperties());
/*  722 */     if (xSLFFillProperties != null && xSLFFillProperties.isSetBlipFill()) {
/*  723 */       CTBlip cTBlip = xSLFFillProperties.getBlipFill().getBlip();
/*  724 */       String str1 = cTBlip.getEmbed();
/*      */       
/*  726 */       String str2 = getSheet().importBlip(str1, xSLFSimpleShape.getSheet().getPackagePart());
/*  727 */       cTBlip.setEmbed(str2);
/*      */     } 
/*      */     
/*  730 */     Color color3 = xSLFSimpleShape.getLineColor();
/*  731 */     Color color4 = getLineColor();
/*  732 */     if (color3 != null && !color3.equals(color4)) {
/*  733 */       setLineColor(color3);
/*      */     }
/*      */     
/*  736 */     double d1 = xSLFSimpleShape.getLineWidth();
/*  737 */     double d2 = getLineWidth();
/*  738 */     if (d1 != d2) {
/*  739 */       setLineWidth(d1);
/*      */     }
/*      */     
/*  742 */     StrokeStyle.LineDash lineDash1 = xSLFSimpleShape.getLineDash();
/*  743 */     StrokeStyle.LineDash lineDash2 = getLineDash();
/*  744 */     if (lineDash1 != null && lineDash1 != lineDash2) {
/*  745 */       setLineDash(lineDash1);
/*      */     }
/*      */     
/*  748 */     StrokeStyle.LineCap lineCap1 = xSLFSimpleShape.getLineCap();
/*  749 */     StrokeStyle.LineCap lineCap2 = getLineCap();
/*  750 */     if (lineCap1 != null && lineCap1 != lineCap2) {
/*  751 */       setLineCap(lineCap1);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineHeadDecoration(LineDecoration.DecorationShape paramDecorationShape) {
/*  762 */     CTLineProperties cTLineProperties = getLn(this, true);
/*  763 */     if (cTLineProperties == null) {
/*      */       return;
/*      */     }
/*  766 */     CTLineEndProperties cTLineEndProperties = cTLineProperties.isSetHeadEnd() ? cTLineProperties.getHeadEnd() : cTLineProperties.addNewHeadEnd();
/*  767 */     if (paramDecorationShape == null) {
/*  768 */       if (cTLineEndProperties.isSetType()) {
/*  769 */         cTLineEndProperties.unsetType();
/*      */       }
/*      */     } else {
/*  772 */       cTLineEndProperties.setType(STLineEndType.Enum.forInt(paramDecorationShape.ooxmlId));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LineDecoration.DecorationShape getLineHeadDecoration() {
/*  780 */     CTLineProperties cTLineProperties = getLn(this, false);
/*  781 */     LineDecoration.DecorationShape decorationShape = LineDecoration.DecorationShape.NONE;
/*  782 */     if (cTLineProperties != null && cTLineProperties.isSetHeadEnd() && cTLineProperties.getHeadEnd().isSetType()) {
/*  783 */       decorationShape = LineDecoration.DecorationShape.fromOoxmlId(cTLineProperties.getHeadEnd().getType().intValue());
/*      */     }
/*  785 */     return decorationShape;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineHeadWidth(LineDecoration.DecorationSize paramDecorationSize) {
/*  794 */     CTLineProperties cTLineProperties = getLn(this, true);
/*  795 */     if (cTLineProperties == null) {
/*      */       return;
/*      */     }
/*  798 */     CTLineEndProperties cTLineEndProperties = cTLineProperties.isSetHeadEnd() ? cTLineProperties.getHeadEnd() : cTLineProperties.addNewHeadEnd();
/*  799 */     if (paramDecorationSize == null) {
/*  800 */       if (cTLineEndProperties.isSetW()) {
/*  801 */         cTLineEndProperties.unsetW();
/*      */       }
/*      */     } else {
/*  804 */       cTLineEndProperties.setW(STLineEndWidth.Enum.forInt(paramDecorationSize.ooxmlId));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LineDecoration.DecorationSize getLineHeadWidth() {
/*  812 */     CTLineProperties cTLineProperties = getLn(this, false);
/*  813 */     LineDecoration.DecorationSize decorationSize = LineDecoration.DecorationSize.MEDIUM;
/*  814 */     if (cTLineProperties != null && cTLineProperties.isSetHeadEnd() && cTLineProperties.getHeadEnd().isSetW()) {
/*  815 */       decorationSize = LineDecoration.DecorationSize.fromOoxmlId(cTLineProperties.getHeadEnd().getW().intValue());
/*      */     }
/*  817 */     return decorationSize;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineHeadLength(LineDecoration.DecorationSize paramDecorationSize) {
/*  824 */     CTLineProperties cTLineProperties = getLn(this, true);
/*  825 */     if (cTLineProperties == null) {
/*      */       return;
/*      */     }
/*      */     
/*  829 */     CTLineEndProperties cTLineEndProperties = cTLineProperties.isSetHeadEnd() ? cTLineProperties.getHeadEnd() : cTLineProperties.addNewHeadEnd();
/*  830 */     if (paramDecorationSize == null) {
/*  831 */       if (cTLineEndProperties.isSetLen()) {
/*  832 */         cTLineEndProperties.unsetLen();
/*      */       }
/*      */     } else {
/*  835 */       cTLineEndProperties.setLen(STLineEndLength.Enum.forInt(paramDecorationSize.ooxmlId));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LineDecoration.DecorationSize getLineHeadLength() {
/*  843 */     CTLineProperties cTLineProperties = getLn(this, false);
/*      */     
/*  845 */     LineDecoration.DecorationSize decorationSize = LineDecoration.DecorationSize.MEDIUM;
/*  846 */     if (cTLineProperties != null && cTLineProperties.isSetHeadEnd() && cTLineProperties.getHeadEnd().isSetLen()) {
/*  847 */       decorationSize = LineDecoration.DecorationSize.fromOoxmlId(cTLineProperties.getHeadEnd().getLen().intValue());
/*      */     }
/*  849 */     return decorationSize;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineTailDecoration(LineDecoration.DecorationShape paramDecorationShape) {
/*  856 */     CTLineProperties cTLineProperties = getLn(this, true);
/*  857 */     if (cTLineProperties == null) {
/*      */       return;
/*      */     }
/*      */     
/*  861 */     CTLineEndProperties cTLineEndProperties = cTLineProperties.isSetTailEnd() ? cTLineProperties.getTailEnd() : cTLineProperties.addNewTailEnd();
/*  862 */     if (paramDecorationShape == null) {
/*  863 */       if (cTLineEndProperties.isSetType()) {
/*  864 */         cTLineEndProperties.unsetType();
/*      */       }
/*      */     } else {
/*  867 */       cTLineEndProperties.setType(STLineEndType.Enum.forInt(paramDecorationShape.ooxmlId));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LineDecoration.DecorationShape getLineTailDecoration() {
/*  875 */     CTLineProperties cTLineProperties = getLn(this, false);
/*      */     
/*  877 */     LineDecoration.DecorationShape decorationShape = LineDecoration.DecorationShape.NONE;
/*  878 */     if (cTLineProperties != null && cTLineProperties.isSetTailEnd() && cTLineProperties.getTailEnd().isSetType()) {
/*  879 */       decorationShape = LineDecoration.DecorationShape.fromOoxmlId(cTLineProperties.getTailEnd().getType().intValue());
/*      */     }
/*  881 */     return decorationShape;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineTailWidth(LineDecoration.DecorationSize paramDecorationSize) {
/*  888 */     CTLineProperties cTLineProperties = getLn(this, true);
/*  889 */     if (cTLineProperties == null) {
/*      */       return;
/*      */     }
/*      */     
/*  893 */     CTLineEndProperties cTLineEndProperties = cTLineProperties.isSetTailEnd() ? cTLineProperties.getTailEnd() : cTLineProperties.addNewTailEnd();
/*  894 */     if (paramDecorationSize == null) {
/*  895 */       if (cTLineEndProperties.isSetW()) {
/*  896 */         cTLineEndProperties.unsetW();
/*      */       }
/*      */     } else {
/*  899 */       cTLineEndProperties.setW(STLineEndWidth.Enum.forInt(paramDecorationSize.ooxmlId));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LineDecoration.DecorationSize getLineTailWidth() {
/*  907 */     CTLineProperties cTLineProperties = getLn(this, false);
/*  908 */     LineDecoration.DecorationSize decorationSize = LineDecoration.DecorationSize.MEDIUM;
/*  909 */     if (cTLineProperties != null && cTLineProperties.isSetTailEnd() && cTLineProperties.getTailEnd().isSetW()) {
/*  910 */       decorationSize = LineDecoration.DecorationSize.fromOoxmlId(cTLineProperties.getTailEnd().getW().intValue());
/*      */     }
/*  912 */     return decorationSize;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineTailLength(LineDecoration.DecorationSize paramDecorationSize) {
/*  919 */     CTLineProperties cTLineProperties = getLn(this, true);
/*  920 */     if (cTLineProperties == null) {
/*      */       return;
/*      */     }
/*      */     
/*  924 */     CTLineEndProperties cTLineEndProperties = cTLineProperties.isSetTailEnd() ? cTLineProperties.getTailEnd() : cTLineProperties.addNewTailEnd();
/*  925 */     if (paramDecorationSize == null) {
/*  926 */       if (cTLineEndProperties.isSetLen()) {
/*  927 */         cTLineEndProperties.unsetLen();
/*      */       }
/*      */     } else {
/*  930 */       cTLineEndProperties.setLen(STLineEndLength.Enum.forInt(paramDecorationSize.ooxmlId));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LineDecoration.DecorationSize getLineTailLength() {
/*  938 */     CTLineProperties cTLineProperties = getLn(this, false);
/*      */     
/*  940 */     LineDecoration.DecorationSize decorationSize = LineDecoration.DecorationSize.MEDIUM;
/*  941 */     if (cTLineProperties != null && cTLineProperties.isSetTailEnd() && cTLineProperties.getTailEnd().isSetLen()) {
/*  942 */       decorationSize = LineDecoration.DecorationSize.fromOoxmlId(cTLineProperties.getTailEnd().getLen().intValue());
/*      */     }
/*  944 */     return decorationSize;
/*      */   }
/*      */   
/*      */   public boolean isPlaceholder() {
/*  948 */     CTPlaceholder cTPlaceholder = getCTPlaceholder();
/*  949 */     return (cTPlaceholder != null);
/*      */   }
/*      */   
/*      */   public Guide getAdjustValue(String paramString) {
/*  953 */     XSLFPropertiesDelegate.XSLFGeometryProperties xSLFGeometryProperties = XSLFPropertiesDelegate.getGeometryDelegate(getShapeProperties());
/*      */     
/*  955 */     if (xSLFGeometryProperties != null && xSLFGeometryProperties.isSetPrstGeom() && xSLFGeometryProperties.getPrstGeom().isSetAvLst()) {
/*  956 */       for (CTGeomGuide cTGeomGuide : xSLFGeometryProperties.getPrstGeom().getAvLst().getGdArray()) {
/*  957 */         if (cTGeomGuide.getName().equals(paramString)) {
/*  958 */           return new Guide(cTGeomGuide.getName(), cTGeomGuide.getFmla());
/*      */         }
/*      */       } 
/*      */     }
/*      */     
/*  963 */     return null;
/*      */   }
/*      */   
/*      */   public LineDecoration getLineDecoration() {
/*  967 */     return new LineDecoration() {
/*      */         public LineDecoration.DecorationShape getHeadShape() {
/*  969 */           return XSLFSimpleShape.this.getLineHeadDecoration();
/*      */         }
/*      */         
/*      */         public LineDecoration.DecorationSize getHeadWidth() {
/*  973 */           return XSLFSimpleShape.this.getLineHeadWidth();
/*      */         }
/*      */         
/*      */         public LineDecoration.DecorationSize getHeadLength() {
/*  977 */           return XSLFSimpleShape.this.getLineHeadLength();
/*      */         }
/*      */         
/*      */         public LineDecoration.DecorationShape getTailShape() {
/*  981 */           return XSLFSimpleShape.this.getLineTailDecoration();
/*      */         }
/*      */         
/*      */         public LineDecoration.DecorationSize getTailWidth() {
/*  985 */           return XSLFSimpleShape.this.getLineTailWidth();
/*      */         }
/*      */         
/*      */         public LineDecoration.DecorationSize getTailLength() {
/*  989 */           return XSLFSimpleShape.this.getLineTailLength();
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FillStyle getFillStyle() {
/* 1000 */     return new FillStyle() {
/*      */         public PaintStyle getPaint() {
/* 1002 */           return XSLFSimpleShape.this.getFillPaint();
/*      */         }
/*      */       };
/*      */   }
/*      */   
/*      */   public StrokeStyle getStrokeStyle() {
/* 1008 */     return new StrokeStyle() {
/*      */         public PaintStyle getPaint() {
/* 1010 */           return XSLFSimpleShape.this.getLinePaint();
/*      */         }
/*      */         
/*      */         public StrokeStyle.LineCap getLineCap() {
/* 1014 */           return XSLFSimpleShape.this.getLineCap();
/*      */         }
/*      */         
/*      */         public StrokeStyle.LineDash getLineDash() {
/* 1018 */           return XSLFSimpleShape.this.getLineDash();
/*      */         }
/*      */         
/*      */         public double getLineWidth() {
/* 1022 */           return XSLFSimpleShape.this.getLineWidth();
/*      */         }
/*      */         
/*      */         public StrokeStyle.LineCompound getLineCompound() {
/* 1026 */           return XSLFSimpleShape.this.getLineCompound();
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStrokeStyle(Object... paramVarArgs) {
/* 1034 */     if (paramVarArgs.length == 0) {
/*      */       
/* 1036 */       setLineColor((Color)null);
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 1041 */     for (Object object : paramVarArgs) {
/* 1042 */       if (object instanceof Number) {
/* 1043 */         setLineWidth(((Number)object).doubleValue());
/* 1044 */       } else if (object instanceof StrokeStyle.LineCap) {
/* 1045 */         setLineCap((StrokeStyle.LineCap)object);
/* 1046 */       } else if (object instanceof StrokeStyle.LineDash) {
/* 1047 */         setLineDash((StrokeStyle.LineDash)object);
/* 1048 */       } else if (object instanceof StrokeStyle.LineCompound) {
/* 1049 */         setLineCompound((StrokeStyle.LineCompound)object);
/* 1050 */       } else if (object instanceof Color) {
/* 1051 */         setLineColor((Color)object);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPlaceholder(Placeholder paramPlaceholder) {
/* 1058 */     super.setPlaceholder(paramPlaceholder);
/*      */   }
/*      */ 
/*      */   
/*      */   public XSLFHyperlink getHyperlink() {
/* 1063 */     CTNonVisualDrawingProps cTNonVisualDrawingProps = getCNvPr();
/* 1064 */     if (!cTNonVisualDrawingProps.isSetHlinkClick()) {
/* 1065 */       return null;
/*      */     }
/* 1067 */     return new XSLFHyperlink(cTNonVisualDrawingProps.getHlinkClick(), getSheet());
/*      */   }
/*      */ 
/*      */   
/*      */   public XSLFHyperlink createHyperlink() {
/* 1072 */     XSLFHyperlink xSLFHyperlink = getHyperlink();
/* 1073 */     if (xSLFHyperlink == null) {
/* 1074 */       CTNonVisualDrawingProps cTNonVisualDrawingProps = getCNvPr();
/* 1075 */       xSLFHyperlink = new XSLFHyperlink(cTNonVisualDrawingProps.addNewHlinkClick(), getSheet());
/*      */     } 
/* 1077 */     return xSLFHyperlink;
/*      */   }
/*      */   
/*      */   private static CTLineProperties getLn(XSLFShape paramXSLFShape, boolean paramBoolean) {
/* 1081 */     XmlObject xmlObject = paramXSLFShape.getShapeProperties();
/* 1082 */     if (!(xmlObject instanceof CTShapeProperties)) {
/* 1083 */       LOG.log(5, new Object[] { paramXSLFShape.getClass().toString() + " doesn't have line properties" });
/* 1084 */       return null;
/*      */     } 
/*      */     
/* 1087 */     CTShapeProperties cTShapeProperties = (CTShapeProperties)xmlObject;
/* 1088 */     return (cTShapeProperties.isSetLn() || !paramBoolean) ? cTShapeProperties.getLn() : cTShapeProperties.addNewLn();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFSimpleShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */