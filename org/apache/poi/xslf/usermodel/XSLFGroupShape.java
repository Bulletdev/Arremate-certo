/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.openxml4j.opc.TargetMode;
/*     */ import org.apache.poi.sl.draw.DrawPictureShape;
/*     */ import org.apache.poi.sl.usermodel.AutoShape;
/*     */ import org.apache.poi.sl.usermodel.ConnectorShape;
/*     */ import org.apache.poi.sl.usermodel.FreeformShape;
/*     */ import org.apache.poi.sl.usermodel.GroupShape;
/*     */ import org.apache.poi.sl.usermodel.PictureData;
/*     */ import org.apache.poi.sl.usermodel.PictureShape;
/*     */ import org.apache.poi.sl.usermodel.Shape;
/*     */ import org.apache.poi.sl.usermodel.TableShape;
/*     */ import org.apache.poi.sl.usermodel.TextBox;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.util.Units;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual;
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
/*     */ public class XSLFGroupShape
/*     */   extends XSLFShape
/*     */   implements GroupShape<XSLFShape, XSLFTextParagraph>, XSLFShapeContainer
/*     */ {
/*  58 */   private static POILogger _logger = POILogFactory.getLogger(XSLFGroupShape.class);
/*     */   
/*     */   private final List<XSLFShape> _shapes;
/*     */   private final CTGroupShapeProperties _grpSpPr;
/*     */   private XSLFDrawing _drawing;
/*     */   
/*     */   protected XSLFGroupShape(CTGroupShape paramCTGroupShape, XSLFSheet paramXSLFSheet) {
/*  65 */     super((XmlObject)paramCTGroupShape, paramXSLFSheet);
/*  66 */     this._shapes = XSLFSheet.buildShapes(paramCTGroupShape, paramXSLFSheet);
/*  67 */     this._grpSpPr = paramCTGroupShape.getGrpSpPr();
/*     */   }
/*     */   
/*     */   protected CTGroupShapeProperties getGrpSpPr() {
/*  71 */     return this._grpSpPr;
/*     */   }
/*     */   
/*     */   protected CTGroupTransform2D getSafeXfrm() {
/*  75 */     CTGroupTransform2D cTGroupTransform2D = getXfrm();
/*  76 */     return (cTGroupTransform2D == null) ? getGrpSpPr().addNewXfrm() : cTGroupTransform2D;
/*     */   }
/*     */   
/*     */   protected CTGroupTransform2D getXfrm() {
/*  80 */     return getGrpSpPr().getXfrm();
/*     */   }
/*     */ 
/*     */   
/*     */   public Rectangle2D getAnchor() {
/*  85 */     CTGroupTransform2D cTGroupTransform2D = getXfrm();
/*  86 */     CTPoint2D cTPoint2D = cTGroupTransform2D.getOff();
/*  87 */     double d1 = Units.toPoints(cTPoint2D.getX());
/*  88 */     double d2 = Units.toPoints(cTPoint2D.getY());
/*  89 */     CTPositiveSize2D cTPositiveSize2D = cTGroupTransform2D.getExt();
/*  90 */     double d3 = Units.toPoints(cTPositiveSize2D.getCx());
/*  91 */     double d4 = Units.toPoints(cTPositiveSize2D.getCy());
/*  92 */     return new Rectangle2D.Double(d1, d2, d3, d4);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAnchor(Rectangle2D paramRectangle2D) {
/*  97 */     CTGroupTransform2D cTGroupTransform2D = getSafeXfrm();
/*  98 */     CTPoint2D cTPoint2D = cTGroupTransform2D.isSetOff() ? cTGroupTransform2D.getOff() : cTGroupTransform2D.addNewOff();
/*  99 */     long l1 = Units.toEMU(paramRectangle2D.getX());
/* 100 */     long l2 = Units.toEMU(paramRectangle2D.getY());
/* 101 */     cTPoint2D.setX(l1);
/* 102 */     cTPoint2D.setY(l2);
/* 103 */     CTPositiveSize2D cTPositiveSize2D = cTGroupTransform2D.isSetExt() ? cTGroupTransform2D.getExt() : cTGroupTransform2D.addNewExt();
/* 104 */     long l3 = Units.toEMU(paramRectangle2D.getWidth());
/* 105 */     long l4 = Units.toEMU(paramRectangle2D.getHeight());
/* 106 */     cTPositiveSize2D.setCx(l3);
/* 107 */     cTPositiveSize2D.setCy(l4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle2D getInteriorAnchor() {
/* 118 */     CTGroupTransform2D cTGroupTransform2D = getXfrm();
/* 119 */     CTPoint2D cTPoint2D = cTGroupTransform2D.getChOff();
/* 120 */     double d1 = Units.toPoints(cTPoint2D.getX());
/* 121 */     double d2 = Units.toPoints(cTPoint2D.getY());
/* 122 */     CTPositiveSize2D cTPositiveSize2D = cTGroupTransform2D.getChExt();
/* 123 */     double d3 = Units.toPoints(cTPositiveSize2D.getCx());
/* 124 */     double d4 = Units.toPoints(cTPositiveSize2D.getCy());
/* 125 */     return new Rectangle2D.Double(d1, d2, d3, d4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInteriorAnchor(Rectangle2D paramRectangle2D) {
/* 136 */     CTGroupTransform2D cTGroupTransform2D = getSafeXfrm();
/* 137 */     CTPoint2D cTPoint2D = cTGroupTransform2D.isSetChOff() ? cTGroupTransform2D.getChOff() : cTGroupTransform2D.addNewChOff();
/* 138 */     long l1 = Units.toEMU(paramRectangle2D.getX());
/* 139 */     long l2 = Units.toEMU(paramRectangle2D.getY());
/* 140 */     cTPoint2D.setX(l1);
/* 141 */     cTPoint2D.setY(l2);
/* 142 */     CTPositiveSize2D cTPositiveSize2D = cTGroupTransform2D.isSetChExt() ? cTGroupTransform2D.getChExt() : cTGroupTransform2D.addNewChExt();
/* 143 */     long l3 = Units.toEMU(paramRectangle2D.getWidth());
/* 144 */     long l4 = Units.toEMU(paramRectangle2D.getHeight());
/* 145 */     cTPositiveSize2D.setCx(l3);
/* 146 */     cTPositiveSize2D.setCy(l4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<XSLFShape> getShapes() {
/* 154 */     return this._shapes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<XSLFShape> iterator() {
/* 163 */     return this._shapes.iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeShape(XSLFShape paramXSLFShape) {
/* 170 */     XmlObject xmlObject = paramXSLFShape.getXmlObject();
/* 171 */     CTGroupShape cTGroupShape = (CTGroupShape)getXmlObject();
/* 172 */     if (xmlObject instanceof org.openxmlformats.schemas.presentationml.x2006.main.CTShape) {
/* 173 */       cTGroupShape.getSpList().remove(xmlObject);
/* 174 */     } else if (xmlObject instanceof CTGroupShape) {
/* 175 */       cTGroupShape.getGrpSpList().remove(xmlObject);
/* 176 */     } else if (xmlObject instanceof org.openxmlformats.schemas.presentationml.x2006.main.CTConnector) {
/* 177 */       cTGroupShape.getCxnSpList().remove(xmlObject);
/* 178 */     } else if (xmlObject instanceof org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame) {
/* 179 */       cTGroupShape.getGraphicFrameList().remove(xmlObject);
/* 180 */     } else if (xmlObject instanceof org.openxmlformats.schemas.presentationml.x2006.main.CTPicture) {
/* 181 */       XSLFPictureShape xSLFPictureShape = (XSLFPictureShape)paramXSLFShape;
/* 182 */       XSLFSheet xSLFSheet = getSheet();
/* 183 */       if (xSLFSheet != null) {
/* 184 */         xSLFSheet.removePictureRelation(xSLFPictureShape);
/*     */       }
/* 186 */       cTGroupShape.getPicList().remove(xmlObject);
/*     */     } else {
/* 188 */       throw new IllegalArgumentException("Unsupported shape: " + paramXSLFShape);
/*     */     } 
/* 190 */     return this._shapes.remove(paramXSLFShape);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static CTGroupShape prototype(int paramInt) {
/* 197 */     CTGroupShape cTGroupShape = CTGroupShape.Factory.newInstance();
/* 198 */     CTGroupShapeNonVisual cTGroupShapeNonVisual = cTGroupShape.addNewNvGrpSpPr();
/* 199 */     CTNonVisualDrawingProps cTNonVisualDrawingProps = cTGroupShapeNonVisual.addNewCNvPr();
/* 200 */     cTNonVisualDrawingProps.setName("Group " + paramInt);
/* 201 */     cTNonVisualDrawingProps.setId((paramInt + 1));
/*     */     
/* 203 */     cTGroupShapeNonVisual.addNewCNvGrpSpPr();
/* 204 */     cTGroupShapeNonVisual.addNewNvPr();
/* 205 */     cTGroupShape.addNewGrpSpPr();
/* 206 */     return cTGroupShape;
/*     */   }
/*     */ 
/*     */   
/*     */   private XSLFDrawing getDrawing() {
/* 211 */     if (this._drawing == null) {
/* 212 */       this._drawing = new XSLFDrawing(getSheet(), (CTGroupShape)getXmlObject());
/*     */     }
/* 214 */     return this._drawing;
/*     */   }
/*     */   
/*     */   public XSLFAutoShape createAutoShape() {
/* 218 */     XSLFAutoShape xSLFAutoShape = getDrawing().createAutoShape();
/* 219 */     this._shapes.add(xSLFAutoShape);
/* 220 */     xSLFAutoShape.setParent(this);
/* 221 */     return xSLFAutoShape;
/*     */   }
/*     */   
/*     */   public XSLFFreeformShape createFreeform() {
/* 225 */     XSLFFreeformShape xSLFFreeformShape = getDrawing().createFreeform();
/* 226 */     this._shapes.add(xSLFFreeformShape);
/* 227 */     xSLFFreeformShape.setParent(this);
/* 228 */     return xSLFFreeformShape;
/*     */   }
/*     */   
/*     */   public XSLFTextBox createTextBox() {
/* 232 */     XSLFTextBox xSLFTextBox = getDrawing().createTextBox();
/* 233 */     this._shapes.add(xSLFTextBox);
/* 234 */     xSLFTextBox.setParent(this);
/* 235 */     return xSLFTextBox;
/*     */   }
/*     */   
/*     */   public XSLFConnectorShape createConnector() {
/* 239 */     XSLFConnectorShape xSLFConnectorShape = getDrawing().createConnector();
/* 240 */     this._shapes.add(xSLFConnectorShape);
/* 241 */     xSLFConnectorShape.setParent(this);
/* 242 */     return xSLFConnectorShape;
/*     */   }
/*     */   
/*     */   public XSLFGroupShape createGroup() {
/* 246 */     XSLFGroupShape xSLFGroupShape = getDrawing().createGroup();
/* 247 */     this._shapes.add(xSLFGroupShape);
/* 248 */     xSLFGroupShape.setParent(this);
/* 249 */     return xSLFGroupShape;
/*     */   }
/*     */   
/*     */   public XSLFPictureShape createPicture(PictureData paramPictureData) {
/* 253 */     if (!(paramPictureData instanceof XSLFPictureData)) {
/* 254 */       throw new IllegalArgumentException("pictureData needs to be of type XSLFPictureData");
/*     */     }
/* 256 */     XSLFPictureData xSLFPictureData = (XSLFPictureData)paramPictureData;
/* 257 */     PackagePart packagePart = xSLFPictureData.getPackagePart();
/*     */     
/* 259 */     PackageRelationship packageRelationship = getSheet().getPackagePart().addRelationship(packagePart.getPartName(), TargetMode.INTERNAL, XSLFRelation.IMAGES.getRelation());
/*     */ 
/*     */     
/* 262 */     XSLFPictureShape xSLFPictureShape = getDrawing().createPicture(packageRelationship.getId());
/* 263 */     (new DrawPictureShape(xSLFPictureShape)).resize();
/* 264 */     this._shapes.add(xSLFPictureShape);
/* 265 */     xSLFPictureShape.setParent(this);
/* 266 */     return xSLFPictureShape;
/*     */   }
/*     */   
/*     */   public XSLFTable createTable() {
/* 270 */     XSLFTable xSLFTable = getDrawing().createTable();
/* 271 */     this._shapes.add(xSLFTable);
/* 272 */     xSLFTable.setParent(this);
/* 273 */     return xSLFTable;
/*     */   }
/*     */ 
/*     */   
/*     */   public XSLFTable createTable(int paramInt1, int paramInt2) {
/* 278 */     if (paramInt1 < 1 || paramInt2 < 1) {
/* 279 */       throw new IllegalArgumentException("numRows and numCols must be greater than 0");
/*     */     }
/* 281 */     XSLFTable xSLFTable = getDrawing().createTable();
/* 282 */     this._shapes.add(xSLFTable);
/* 283 */     xSLFTable.setParent(this);
/* 284 */     for (byte b = 0; b < paramInt1; b++) {
/* 285 */       XSLFTableRow xSLFTableRow = xSLFTable.addRow();
/* 286 */       for (byte b1 = 0; b1 < paramInt2; b1++) {
/* 287 */         xSLFTableRow.addCell();
/*     */       }
/*     */     } 
/* 290 */     return xSLFTable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFlipHorizontal(boolean paramBoolean) {
/* 296 */     getSafeXfrm().setFlipH(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFlipVertical(boolean paramBoolean) {
/* 301 */     getSafeXfrm().setFlipV(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getFlipHorizontal() {
/* 306 */     CTGroupTransform2D cTGroupTransform2D = getXfrm();
/* 307 */     return (cTGroupTransform2D != null && cTGroupTransform2D.isSetFlipH() && cTGroupTransform2D.getFlipH());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getFlipVertical() {
/* 312 */     CTGroupTransform2D cTGroupTransform2D = getXfrm();
/* 313 */     return (cTGroupTransform2D != null && cTGroupTransform2D.isSetFlipV() && cTGroupTransform2D.getFlipV());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotation(double paramDouble) {
/* 318 */     getSafeXfrm().setRot((int)(paramDouble * 60000.0D));
/*     */   }
/*     */ 
/*     */   
/*     */   public double getRotation() {
/* 323 */     CTGroupTransform2D cTGroupTransform2D = getXfrm();
/* 324 */     return (cTGroupTransform2D == null || !cTGroupTransform2D.isSetRot()) ? 0.0D : (cTGroupTransform2D.getRot() / 60000.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   void copy(XSLFShape paramXSLFShape) {
/* 329 */     XSLFGroupShape xSLFGroupShape = (XSLFGroupShape)paramXSLFShape;
/*     */ 
/*     */     
/* 332 */     clear();
/*     */ 
/*     */     
/* 335 */     for (XSLFShape xSLFShape : xSLFGroupShape.getShapes()) {
/*     */       XSLFTable xSLFTable;
/* 337 */       if (xSLFShape instanceof XSLFTextBox) {
/* 338 */         XSLFTextBox xSLFTextBox = createTextBox();
/* 339 */       } else if (xSLFShape instanceof XSLFAutoShape) {
/* 340 */         XSLFAutoShape xSLFAutoShape = createAutoShape();
/* 341 */       } else if (xSLFShape instanceof XSLFConnectorShape) {
/* 342 */         XSLFConnectorShape xSLFConnectorShape = createConnector();
/* 343 */       } else if (xSLFShape instanceof XSLFFreeformShape) {
/* 344 */         XSLFFreeformShape xSLFFreeformShape = createFreeform();
/* 345 */       } else if (xSLFShape instanceof XSLFPictureShape) {
/* 346 */         XSLFPictureShape xSLFPictureShape2 = (XSLFPictureShape)xSLFShape;
/* 347 */         XSLFPictureData xSLFPictureData1 = xSLFPictureShape2.getPictureData();
/* 348 */         XSLFPictureData xSLFPictureData2 = getSheet().getSlideShow().addPicture(xSLFPictureData1.getData(), xSLFPictureData1.getType());
/* 349 */         XSLFPictureShape xSLFPictureShape1 = createPicture(xSLFPictureData2);
/* 350 */       } else if (xSLFShape instanceof XSLFGroupShape) {
/* 351 */         XSLFGroupShape xSLFGroupShape1 = createGroup();
/* 352 */       } else if (xSLFShape instanceof XSLFTable) {
/* 353 */         xSLFTable = createTable();
/*     */       } else {
/* 355 */         _logger.log(5, new Object[] { "copying of class " + xSLFShape.getClass() + " not supported." });
/*     */         
/*     */         continue;
/*     */       } 
/* 359 */       xSLFTable.copy(xSLFShape);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 368 */     ArrayList<XSLFShape> arrayList = new ArrayList<XSLFShape>(getShapes());
/* 369 */     for (XSLFShape xSLFShape : arrayList) {
/* 370 */       removeShape(xSLFShape);
/*     */     }
/*     */   }
/*     */   
/*     */   public void addShape(XSLFShape paramXSLFShape) {
/* 375 */     throw new UnsupportedOperationException("Adding a shape from a different container is not supported - create it from scratch with XSLFGroupShape.create* methods");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFGroupShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */