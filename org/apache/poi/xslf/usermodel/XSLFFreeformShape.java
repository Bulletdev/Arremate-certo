/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Path2D;
/*     */ import java.awt.geom.PathIterator;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import org.apache.poi.sl.usermodel.FreeformShape;
/*     */ import org.apache.poi.util.Units;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DLineTo;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DMoveTo;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DQuadBezierTo;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSLFFreeformShape
/*     */   extends XSLFAutoShape
/*     */   implements FreeformShape<XSLFShape, XSLFTextParagraph>
/*     */ {
/*     */   XSLFFreeformShape(CTShape paramCTShape, XSLFSheet paramXSLFSheet) {
/*  54 */     super(paramCTShape, paramXSLFSheet);
/*     */   }
/*     */ 
/*     */   
/*     */   public int setPath(Path2D.Double paramDouble) {
/*  59 */     CTPath2D cTPath2D = CTPath2D.Factory.newInstance();
/*     */     
/*  61 */     Rectangle2D rectangle2D = paramDouble.getBounds2D();
/*  62 */     int i = Units.toEMU(rectangle2D.getX());
/*  63 */     int j = Units.toEMU(rectangle2D.getY());
/*  64 */     PathIterator pathIterator = paramDouble.getPathIterator(new AffineTransform());
/*  65 */     byte b = 0;
/*  66 */     cTPath2D.setH(Units.toEMU(rectangle2D.getHeight()));
/*  67 */     cTPath2D.setW(Units.toEMU(rectangle2D.getWidth()));
/*  68 */     while (!pathIterator.isDone()) {
/*  69 */       CTAdjPoint2D cTAdjPoint2D1, cTAdjPoint2D2; CTPath2DQuadBezierTo cTPath2DQuadBezierTo; CTAdjPoint2D cTAdjPoint2D3, cTAdjPoint2D4; CTPath2DCubicBezierTo cTPath2DCubicBezierTo; CTAdjPoint2D cTAdjPoint2D5, cTAdjPoint2D6, cTAdjPoint2D7; double[] arrayOfDouble = new double[6];
/*  70 */       int k = pathIterator.currentSegment(arrayOfDouble);
/*  71 */       switch (k) {
/*     */         case 0:
/*  73 */           cTAdjPoint2D1 = cTPath2D.addNewMoveTo().addNewPt();
/*  74 */           cTAdjPoint2D1.setX(Integer.valueOf(Units.toEMU(arrayOfDouble[0]) - i));
/*  75 */           cTAdjPoint2D1.setY(Integer.valueOf(Units.toEMU(arrayOfDouble[1]) - j));
/*  76 */           b++;
/*     */           break;
/*     */         case 1:
/*  79 */           cTAdjPoint2D2 = cTPath2D.addNewLnTo().addNewPt();
/*  80 */           cTAdjPoint2D2.setX(Integer.valueOf(Units.toEMU(arrayOfDouble[0]) - i));
/*  81 */           cTAdjPoint2D2.setY(Integer.valueOf(Units.toEMU(arrayOfDouble[1]) - j));
/*  82 */           b++;
/*     */           break;
/*     */         case 2:
/*  85 */           cTPath2DQuadBezierTo = cTPath2D.addNewQuadBezTo();
/*  86 */           cTAdjPoint2D3 = cTPath2DQuadBezierTo.addNewPt();
/*  87 */           cTAdjPoint2D3.setX(Integer.valueOf(Units.toEMU(arrayOfDouble[0]) - i));
/*  88 */           cTAdjPoint2D3.setY(Integer.valueOf(Units.toEMU(arrayOfDouble[1]) - j));
/*  89 */           cTAdjPoint2D4 = cTPath2DQuadBezierTo.addNewPt();
/*  90 */           cTAdjPoint2D4.setX(Integer.valueOf(Units.toEMU(arrayOfDouble[2]) - i));
/*  91 */           cTAdjPoint2D4.setY(Integer.valueOf(Units.toEMU(arrayOfDouble[3]) - j));
/*  92 */           b += 2;
/*     */           break;
/*     */         case 3:
/*  95 */           cTPath2DCubicBezierTo = cTPath2D.addNewCubicBezTo();
/*  96 */           cTAdjPoint2D5 = cTPath2DCubicBezierTo.addNewPt();
/*  97 */           cTAdjPoint2D5.setX(Integer.valueOf(Units.toEMU(arrayOfDouble[0]) - i));
/*  98 */           cTAdjPoint2D5.setY(Integer.valueOf(Units.toEMU(arrayOfDouble[1]) - j));
/*  99 */           cTAdjPoint2D6 = cTPath2DCubicBezierTo.addNewPt();
/* 100 */           cTAdjPoint2D6.setX(Integer.valueOf(Units.toEMU(arrayOfDouble[2]) - i));
/* 101 */           cTAdjPoint2D6.setY(Integer.valueOf(Units.toEMU(arrayOfDouble[3]) - j));
/* 102 */           cTAdjPoint2D7 = cTPath2DCubicBezierTo.addNewPt();
/* 103 */           cTAdjPoint2D7.setX(Integer.valueOf(Units.toEMU(arrayOfDouble[4]) - i));
/* 104 */           cTAdjPoint2D7.setY(Integer.valueOf(Units.toEMU(arrayOfDouble[5]) - j));
/* 105 */           b += 3;
/*     */           break;
/*     */         case 4:
/* 108 */           b++;
/* 109 */           cTPath2D.addNewClose();
/*     */           break;
/*     */         default:
/* 112 */           throw new IllegalStateException("Unrecognized path segment type: " + k);
/*     */       } 
/* 114 */       pathIterator.next();
/*     */     } 
/*     */     
/* 117 */     XmlObject xmlObject = getShapeProperties();
/* 118 */     if (!(xmlObject instanceof CTShapeProperties)) {
/* 119 */       return -1;
/*     */     }
/*     */     
/* 122 */     ((CTShapeProperties)xmlObject).getCustGeom().getPathLst().setPathArray(new CTPath2D[] { cTPath2D });
/* 123 */     setAnchor(rectangle2D);
/* 124 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   public Path2D.Double getPath() {
/* 129 */     Path2D.Double double_ = new Path2D.Double();
/* 130 */     Rectangle2D rectangle2D = getAnchor();
/*     */     
/* 132 */     XmlObject xmlObject = getShapeProperties();
/* 133 */     if (!(xmlObject instanceof CTShapeProperties)) {
/* 134 */       return null;
/*     */     }
/*     */     
/* 137 */     CTCustomGeometry2D cTCustomGeometry2D = ((CTShapeProperties)xmlObject).getCustGeom();
/* 138 */     for (CTPath2D cTPath2D : cTCustomGeometry2D.getPathLst().getPathArray()) {
/* 139 */       double d1 = rectangle2D.getWidth() / Units.toPoints(cTPath2D.getW());
/* 140 */       double d2 = rectangle2D.getHeight() / Units.toPoints(cTPath2D.getH());
/* 141 */       for (XmlObject xmlObject1 : cTPath2D.selectPath("*")) {
/* 142 */         if (xmlObject1 instanceof CTPath2DMoveTo) {
/* 143 */           CTAdjPoint2D cTAdjPoint2D = ((CTPath2DMoveTo)xmlObject1).getPt();
/* 144 */           double_.moveTo((float)(Units.toPoints(((Long)cTAdjPoint2D.getX()).longValue()) * d1), (float)(Units.toPoints(((Long)cTAdjPoint2D.getY()).longValue()) * d2));
/*     */         
/*     */         }
/* 147 */         else if (xmlObject1 instanceof CTPath2DLineTo) {
/* 148 */           CTAdjPoint2D cTAdjPoint2D = ((CTPath2DLineTo)xmlObject1).getPt();
/* 149 */           double_.lineTo((float)Units.toPoints(((Long)cTAdjPoint2D.getX()).longValue()), (float)Units.toPoints(((Long)cTAdjPoint2D.getY()).longValue()));
/*     */         }
/* 151 */         else if (xmlObject1 instanceof CTPath2DQuadBezierTo) {
/* 152 */           CTPath2DQuadBezierTo cTPath2DQuadBezierTo = (CTPath2DQuadBezierTo)xmlObject1;
/* 153 */           CTAdjPoint2D cTAdjPoint2D1 = cTPath2DQuadBezierTo.getPtArray(0);
/* 154 */           CTAdjPoint2D cTAdjPoint2D2 = cTPath2DQuadBezierTo.getPtArray(1);
/* 155 */           double_.quadTo((float)(Units.toPoints(((Long)cTAdjPoint2D1.getX()).longValue()) * d1), (float)(Units.toPoints(((Long)cTAdjPoint2D1.getY()).longValue()) * d2), (float)(Units.toPoints(((Long)cTAdjPoint2D2.getX()).longValue()) * d1), (float)(Units.toPoints(((Long)cTAdjPoint2D2.getY()).longValue()) * d2));
/*     */ 
/*     */ 
/*     */         
/*     */         }
/* 160 */         else if (xmlObject1 instanceof CTPath2DCubicBezierTo) {
/* 161 */           CTPath2DCubicBezierTo cTPath2DCubicBezierTo = (CTPath2DCubicBezierTo)xmlObject1;
/* 162 */           CTAdjPoint2D cTAdjPoint2D1 = cTPath2DCubicBezierTo.getPtArray(0);
/* 163 */           CTAdjPoint2D cTAdjPoint2D2 = cTPath2DCubicBezierTo.getPtArray(1);
/* 164 */           CTAdjPoint2D cTAdjPoint2D3 = cTPath2DCubicBezierTo.getPtArray(2);
/* 165 */           double_.curveTo((float)(Units.toPoints(((Long)cTAdjPoint2D1.getX()).longValue()) * d1), (float)(Units.toPoints(((Long)cTAdjPoint2D1.getY()).longValue()) * d2), (float)(Units.toPoints(((Long)cTAdjPoint2D2.getX()).longValue()) * d1), (float)(Units.toPoints(((Long)cTAdjPoint2D2.getY()).longValue()) * d2), (float)(Units.toPoints(((Long)cTAdjPoint2D3.getX()).longValue()) * d1), (float)(Units.toPoints(((Long)cTAdjPoint2D3.getY()).longValue()) * d2));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         }
/* 172 */         else if (xmlObject1 instanceof org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DClose) {
/* 173 */           double_.closePath();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 180 */     AffineTransform affineTransform = new AffineTransform();
/* 181 */     affineTransform.translate(rectangle2D.getX(), rectangle2D.getY());
/* 182 */     return new Path2D.Double(affineTransform.createTransformedShape(double_));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static CTShape prototype(int paramInt) {
/* 188 */     CTShape cTShape = CTShape.Factory.newInstance();
/* 189 */     CTShapeNonVisual cTShapeNonVisual = cTShape.addNewNvSpPr();
/* 190 */     CTNonVisualDrawingProps cTNonVisualDrawingProps = cTShapeNonVisual.addNewCNvPr();
/* 191 */     cTNonVisualDrawingProps.setName("Freeform " + paramInt);
/* 192 */     cTNonVisualDrawingProps.setId((paramInt + 1));
/* 193 */     cTShapeNonVisual.addNewCNvSpPr();
/* 194 */     cTShapeNonVisual.addNewNvPr();
/* 195 */     CTShapeProperties cTShapeProperties = cTShape.addNewSpPr();
/* 196 */     CTCustomGeometry2D cTCustomGeometry2D = cTShapeProperties.addNewCustGeom();
/* 197 */     cTCustomGeometry2D.addNewAvLst();
/* 198 */     cTCustomGeometry2D.addNewGdLst();
/* 199 */     cTCustomGeometry2D.addNewAhLst();
/* 200 */     cTCustomGeometry2D.addNewCxnLst();
/* 201 */     CTGeomRect cTGeomRect = cTCustomGeometry2D.addNewRect();
/* 202 */     cTGeomRect.setR("r");
/* 203 */     cTGeomRect.setB("b");
/* 204 */     cTGeomRect.setT("t");
/* 205 */     cTGeomRect.setL("l");
/* 206 */     cTCustomGeometry2D.addNewPathLst();
/* 207 */     return cTShape;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFFreeformShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */