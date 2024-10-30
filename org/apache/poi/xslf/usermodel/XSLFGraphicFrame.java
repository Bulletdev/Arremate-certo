/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.sl.usermodel.GraphicalFrame;
/*     */ import org.apache.poi.sl.usermodel.PictureShape;
/*     */ import org.apache.poi.sl.usermodel.ShapeType;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.util.Units;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSLFGraphicFrame
/*     */   extends XSLFShape
/*     */   implements GraphicalFrame<XSLFShape, XSLFTextParagraph>
/*     */ {
/*  48 */   private static final POILogger LOG = POILogFactory.getLogger(XSLFGraphicFrame.class);
/*     */   
/*     */   XSLFGraphicFrame(CTGraphicalObjectFrame paramCTGraphicalObjectFrame, XSLFSheet paramXSLFSheet) {
/*  51 */     super((XmlObject)paramCTGraphicalObjectFrame, paramXSLFSheet);
/*     */   }
/*     */   
/*     */   public ShapeType getShapeType() {
/*  55 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Rectangle2D getAnchor() {
/*  60 */     CTTransform2D cTTransform2D = ((CTGraphicalObjectFrame)getXmlObject()).getXfrm();
/*  61 */     CTPoint2D cTPoint2D = cTTransform2D.getOff();
/*  62 */     double d1 = Units.toPoints(cTPoint2D.getX());
/*  63 */     double d2 = Units.toPoints(cTPoint2D.getY());
/*  64 */     CTPositiveSize2D cTPositiveSize2D = cTTransform2D.getExt();
/*  65 */     double d3 = Units.toPoints(cTPositiveSize2D.getCx());
/*  66 */     double d4 = Units.toPoints(cTPositiveSize2D.getCy());
/*  67 */     return new Rectangle2D.Double(d1, d2, d3, d4);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAnchor(Rectangle2D paramRectangle2D) {
/*  72 */     CTTransform2D cTTransform2D = ((CTGraphicalObjectFrame)getXmlObject()).getXfrm();
/*  73 */     CTPoint2D cTPoint2D = cTTransform2D.isSetOff() ? cTTransform2D.getOff() : cTTransform2D.addNewOff();
/*  74 */     long l1 = Units.toEMU(paramRectangle2D.getX());
/*  75 */     long l2 = Units.toEMU(paramRectangle2D.getY());
/*  76 */     cTPoint2D.setX(l1);
/*  77 */     cTPoint2D.setY(l2);
/*  78 */     CTPositiveSize2D cTPositiveSize2D = cTTransform2D.isSetExt() ? cTTransform2D.getExt() : cTTransform2D.addNewExt();
/*     */     
/*  80 */     long l3 = Units.toEMU(paramRectangle2D.getWidth());
/*  81 */     long l4 = Units.toEMU(paramRectangle2D.getHeight());
/*  82 */     cTPositiveSize2D.setCx(l3);
/*  83 */     cTPositiveSize2D.setCy(l4);
/*     */   }
/*     */ 
/*     */   
/*     */   static XSLFGraphicFrame create(CTGraphicalObjectFrame paramCTGraphicalObjectFrame, XSLFSheet paramXSLFSheet) {
/*  88 */     String str = paramCTGraphicalObjectFrame.getGraphic().getGraphicData().getUri();
/*  89 */     if ("http://schemas.openxmlformats.org/drawingml/2006/table".equals(str)) {
/*  90 */       return new XSLFTable(paramCTGraphicalObjectFrame, paramXSLFSheet);
/*     */     }
/*  92 */     return new XSLFGraphicFrame(paramCTGraphicalObjectFrame, paramXSLFSheet);
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
/*     */   public void setRotation(double paramDouble) {
/* 106 */     throw new IllegalArgumentException("Operation not supported");
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
/*     */   public double getRotation() {
/* 119 */     return 0.0D;
/*     */   }
/*     */   
/*     */   public void setFlipHorizontal(boolean paramBoolean) {
/* 123 */     throw new IllegalArgumentException("Operation not supported");
/*     */   }
/*     */   
/*     */   public void setFlipVertical(boolean paramBoolean) {
/* 127 */     throw new IllegalArgumentException("Operation not supported");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getFlipHorizontal() {
/* 136 */     return false;
/*     */   }
/*     */   
/*     */   public boolean getFlipVertical() {
/* 140 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   void copy(XSLFShape paramXSLFShape) {
/* 145 */     super.copy(paramXSLFShape);
/*     */     
/* 147 */     CTGraphicalObjectData cTGraphicalObjectData = ((CTGraphicalObjectFrame)getXmlObject()).getGraphic().getGraphicData();
/* 148 */     String str = cTGraphicalObjectData.getUri();
/* 149 */     if (str.equals("http://schemas.openxmlformats.org/drawingml/2006/diagram")) {
/* 150 */       copyDiagram(cTGraphicalObjectData, (XSLFGraphicFrame)paramXSLFShape);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void copyDiagram(CTGraphicalObjectData paramCTGraphicalObjectData, XSLFGraphicFrame paramXSLFGraphicFrame) {
/* 159 */     String str = "declare namespace dgm='http://schemas.openxmlformats.org/drawingml/2006/diagram' $this//dgm:relIds";
/* 160 */     XmlObject[] arrayOfXmlObject = paramCTGraphicalObjectData.selectPath(str);
/* 161 */     if (arrayOfXmlObject != null && arrayOfXmlObject.length == 1) {
/* 162 */       XmlCursor xmlCursor = arrayOfXmlObject[0].newCursor();
/*     */       
/* 164 */       XSLFSheet xSLFSheet = paramXSLFGraphicFrame.getSheet();
/*     */       try {
/* 166 */         String str1 = xmlCursor.getAttributeText(new b("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "dm"));
/* 167 */         PackageRelationship packageRelationship1 = xSLFSheet.getPackagePart().getRelationship(str1);
/* 168 */         PackagePart packagePart1 = xSLFSheet.getPackagePart().getRelatedPart(packageRelationship1);
/* 169 */         getSheet().importPart(packageRelationship1, packagePart1);
/*     */         
/* 171 */         String str2 = xmlCursor.getAttributeText(new b("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "lo"));
/* 172 */         PackageRelationship packageRelationship2 = xSLFSheet.getPackagePart().getRelationship(str2);
/* 173 */         PackagePart packagePart2 = xSLFSheet.getPackagePart().getRelatedPart(packageRelationship2);
/* 174 */         getSheet().importPart(packageRelationship2, packagePart2);
/*     */         
/* 176 */         String str3 = xmlCursor.getAttributeText(new b("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "qs"));
/* 177 */         PackageRelationship packageRelationship3 = xSLFSheet.getPackagePart().getRelationship(str3);
/* 178 */         PackagePart packagePart3 = xSLFSheet.getPackagePart().getRelatedPart(packageRelationship3);
/* 179 */         getSheet().importPart(packageRelationship3, packagePart3);
/*     */         
/* 181 */         String str4 = xmlCursor.getAttributeText(new b("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "cs"));
/* 182 */         PackageRelationship packageRelationship4 = xSLFSheet.getPackagePart().getRelationship(str4);
/* 183 */         PackagePart packagePart4 = xSLFSheet.getPackagePart().getRelatedPart(packageRelationship4);
/* 184 */         getSheet().importPart(packageRelationship4, packagePart4);
/*     */       }
/* 186 */       catch (InvalidFormatException invalidFormatException) {
/* 187 */         throw new POIXMLException(invalidFormatException);
/*     */       } 
/* 189 */       xmlCursor.dispose();
/*     */     } 
/*     */   }
/*     */   
/*     */   public XSLFPictureShape getFallbackPicture() {
/*     */     CTGroupShape cTGroupShape;
/* 195 */     String str = "declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main'; declare namespace mc='http://schemas.openxmlformats.org/markup-compatibility/2006' .//mc:Fallback/*/p:pic";
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 200 */     XmlObject xmlObject = (XmlObject)selectProperty((Class)XmlObject.class, str);
/* 201 */     if (xmlObject == null) {
/* 202 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 207 */       cTGroupShape = CTGroupShape.Factory.parse(xmlObject.newDomNode());
/* 208 */     } catch (XmlException xmlException) {
/* 209 */       LOG.log(5, new Object[] { "Can't parse fallback picture stream of graphical frame", xmlException });
/* 210 */       return null;
/*     */     } 
/*     */     
/* 213 */     if (cTGroupShape.sizeOfPicArray() == 0) {
/* 214 */       return null;
/*     */     }
/*     */     
/* 217 */     return new XSLFPictureShape(cTGroupShape.getPicArray(0), getSheet());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFGraphicFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */