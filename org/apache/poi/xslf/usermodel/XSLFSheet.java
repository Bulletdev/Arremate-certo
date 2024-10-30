/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.awt.Graphics2D;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackagePartName;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.openxml4j.opc.TargetMode;
/*     */ import org.apache.poi.sl.draw.DrawFactory;
/*     */ import org.apache.poi.sl.draw.DrawPictureShape;
/*     */ import org.apache.poi.sl.draw.DrawSheet;
/*     */ import org.apache.poi.sl.usermodel.AutoShape;
/*     */ import org.apache.poi.sl.usermodel.Background;
/*     */ import org.apache.poi.sl.usermodel.ConnectorShape;
/*     */ import org.apache.poi.sl.usermodel.FreeformShape;
/*     */ import org.apache.poi.sl.usermodel.GroupShape;
/*     */ import org.apache.poi.sl.usermodel.PictureData;
/*     */ import org.apache.poi.sl.usermodel.PictureShape;
/*     */ import org.apache.poi.sl.usermodel.Placeholder;
/*     */ import org.apache.poi.sl.usermodel.Shape;
/*     */ import org.apache.poi.sl.usermodel.Sheet;
/*     */ import org.apache.poi.sl.usermodel.SlideShow;
/*     */ import org.apache.poi.sl.usermodel.TableShape;
/*     */ import org.apache.poi.sl.usermodel.TextBox;
/*     */ import org.apache.poi.util.IOUtils;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTConnector;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
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
/*     */ public abstract class XSLFSheet
/*     */   extends POIXMLDocumentPart
/*     */   implements Sheet<XSLFShape, XSLFTextParagraph>, XSLFShapeContainer
/*     */ {
/*     */   private XSLFCommonSlideData _commonSlideData;
/*     */   private XSLFDrawing _drawing;
/*     */   private List<XSLFShape> _shapes;
/*     */   private CTGroupShape _spTree;
/*     */   private List<XSLFTextShape> _placeholders;
/*     */   private Map<Integer, XSLFSimpleShape> _placeholderByIdMap;
/*     */   private Map<Integer, XSLFSimpleShape> _placeholderByTypeMap;
/*     */   
/*     */   public XSLFSheet() {}
/*     */   
/*     */   public XSLFSheet(PackagePart paramPackagePart) {
/*  80 */     super(paramPackagePart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public XSLFSheet(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) {
/*  88 */     this(paramPackagePart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMLSlideShow getSlideShow() {
/*  96 */     POIXMLDocumentPart pOIXMLDocumentPart = getParent();
/*  97 */     while (pOIXMLDocumentPart != null) {
/*  98 */       if (pOIXMLDocumentPart instanceof XMLSlideShow) {
/*  99 */         return (XMLSlideShow)pOIXMLDocumentPart;
/*     */       }
/* 101 */       pOIXMLDocumentPart = pOIXMLDocumentPart.getParent();
/*     */     } 
/* 103 */     throw new IllegalStateException("SlideShow was not found");
/*     */   }
/*     */   
/*     */   protected static List<XSLFShape> buildShapes(CTGroupShape paramCTGroupShape, XSLFSheet paramXSLFSheet) {
/* 107 */     ArrayList<XSLFAutoShape> arrayList = new ArrayList();
/* 108 */     for (XmlObject xmlObject : paramCTGroupShape.selectPath("*")) {
/* 109 */       if (xmlObject instanceof CTShape) {
/* 110 */         XSLFAutoShape xSLFAutoShape = XSLFAutoShape.create((CTShape)xmlObject, paramXSLFSheet);
/* 111 */         arrayList.add(xSLFAutoShape);
/* 112 */       } else if (xmlObject instanceof CTGroupShape) {
/* 113 */         arrayList.add(new XSLFGroupShape((CTGroupShape)xmlObject, paramXSLFSheet));
/* 114 */       } else if (xmlObject instanceof CTConnector) {
/* 115 */         arrayList.add(new XSLFConnectorShape((CTConnector)xmlObject, paramXSLFSheet));
/* 116 */       } else if (xmlObject instanceof CTPicture) {
/* 117 */         arrayList.add(new XSLFPictureShape((CTPicture)xmlObject, paramXSLFSheet));
/* 118 */       } else if (xmlObject instanceof CTGraphicalObjectFrame) {
/* 119 */         XSLFGraphicFrame xSLFGraphicFrame = XSLFGraphicFrame.create((CTGraphicalObjectFrame)xmlObject, paramXSLFSheet);
/* 120 */         arrayList.add(xSLFGraphicFrame);
/*     */       } 
/*     */     } 
/* 123 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public XSLFCommonSlideData getCommonSlideData() {
/* 133 */     return this._commonSlideData;
/*     */   }
/*     */   
/*     */   protected void setCommonSlideData(CTCommonSlideData paramCTCommonSlideData) {
/* 137 */     if (paramCTCommonSlideData == null) {
/* 138 */       this._commonSlideData = null;
/*     */     } else {
/* 140 */       this._commonSlideData = new XSLFCommonSlideData(paramCTCommonSlideData);
/*     */     } 
/*     */   }
/*     */   
/*     */   private XSLFDrawing getDrawing() {
/* 145 */     initDrawingAndShapes();
/* 146 */     return this._drawing;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<XSLFShape> getShapes() {
/* 156 */     initDrawingAndShapes();
/* 157 */     return this._shapes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initDrawingAndShapes() {
/* 167 */     CTGroupShape cTGroupShape = getSpTree();
/* 168 */     if (this._drawing == null) {
/* 169 */       this._drawing = new XSLFDrawing(this, cTGroupShape);
/*     */     }
/* 171 */     if (this._shapes == null) {
/* 172 */       this._shapes = buildShapes(cTGroupShape, this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSLFAutoShape createAutoShape() {
/* 180 */     XSLFAutoShape xSLFAutoShape = getDrawing().createAutoShape();
/* 181 */     getShapes().add(xSLFAutoShape);
/* 182 */     xSLFAutoShape.setParent(this);
/* 183 */     return xSLFAutoShape;
/*     */   }
/*     */ 
/*     */   
/*     */   public XSLFFreeformShape createFreeform() {
/* 188 */     XSLFFreeformShape xSLFFreeformShape = getDrawing().createFreeform();
/* 189 */     getShapes().add(xSLFFreeformShape);
/* 190 */     xSLFFreeformShape.setParent(this);
/* 191 */     return xSLFFreeformShape;
/*     */   }
/*     */ 
/*     */   
/*     */   public XSLFTextBox createTextBox() {
/* 196 */     XSLFTextBox xSLFTextBox = getDrawing().createTextBox();
/* 197 */     getShapes().add(xSLFTextBox);
/* 198 */     xSLFTextBox.setParent(this);
/* 199 */     return xSLFTextBox;
/*     */   }
/*     */ 
/*     */   
/*     */   public XSLFConnectorShape createConnector() {
/* 204 */     XSLFConnectorShape xSLFConnectorShape = getDrawing().createConnector();
/* 205 */     getShapes().add(xSLFConnectorShape);
/* 206 */     xSLFConnectorShape.setParent(this);
/* 207 */     return xSLFConnectorShape;
/*     */   }
/*     */ 
/*     */   
/*     */   public XSLFGroupShape createGroup() {
/* 212 */     XSLFGroupShape xSLFGroupShape = getDrawing().createGroup();
/* 213 */     getShapes().add(xSLFGroupShape);
/* 214 */     xSLFGroupShape.setParent(this);
/* 215 */     return xSLFGroupShape;
/*     */   }
/*     */ 
/*     */   
/*     */   public XSLFPictureShape createPicture(PictureData paramPictureData) {
/* 220 */     if (!(paramPictureData instanceof XSLFPictureData)) {
/* 221 */       throw new IllegalArgumentException("pictureData needs to be of type XSLFPictureData");
/*     */     }
/* 223 */     XSLFPictureData xSLFPictureData = (XSLFPictureData)paramPictureData;
/* 224 */     PackagePart packagePart = xSLFPictureData.getPackagePart();
/*     */     
/* 226 */     POIXMLDocumentPart.RelationPart relationPart = addRelation(null, XSLFRelation.IMAGES, new XSLFPictureData(packagePart));
/*     */     
/* 228 */     XSLFPictureShape xSLFPictureShape = getDrawing().createPicture(relationPart.getRelationship().getId());
/* 229 */     (new DrawPictureShape(xSLFPictureShape)).resize();
/* 230 */     getShapes().add(xSLFPictureShape);
/* 231 */     xSLFPictureShape.setParent(this);
/* 232 */     return xSLFPictureShape;
/*     */   }
/*     */   
/*     */   public XSLFTable createTable() {
/* 236 */     XSLFTable xSLFTable = getDrawing().createTable();
/* 237 */     getShapes().add(xSLFTable);
/* 238 */     xSLFTable.setParent(this);
/* 239 */     return xSLFTable;
/*     */   }
/*     */ 
/*     */   
/*     */   public XSLFTable createTable(int paramInt1, int paramInt2) {
/* 244 */     if (paramInt1 < 1 || paramInt2 < 1) {
/* 245 */       throw new IllegalArgumentException("numRows and numCols must be greater than 0");
/*     */     }
/* 247 */     XSLFTable xSLFTable = getDrawing().createTable();
/* 248 */     getShapes().add(xSLFTable);
/* 249 */     xSLFTable.setParent(this);
/* 250 */     for (byte b = 0; b < paramInt1; b++) {
/* 251 */       XSLFTableRow xSLFTableRow = xSLFTable.addRow();
/* 252 */       for (byte b1 = 0; b1 < paramInt2; b1++) {
/* 253 */         xSLFTableRow.addCell();
/*     */       }
/*     */     } 
/* 256 */     return xSLFTable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<XSLFShape> iterator() {
/* 266 */     return getShapes().iterator();
/*     */   }
/*     */   
/*     */   public void addShape(XSLFShape paramXSLFShape) {
/* 270 */     throw new UnsupportedOperationException("Adding a shape from a different container is not supported - create it from scratch witht XSLFSheet.create* methods");
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
/*     */   public boolean removeShape(XSLFShape paramXSLFShape) {
/* 286 */     XmlObject xmlObject = paramXSLFShape.getXmlObject();
/* 287 */     CTGroupShape cTGroupShape = getSpTree();
/* 288 */     if (xmlObject instanceof CTShape) {
/* 289 */       cTGroupShape.getSpList().remove(xmlObject);
/* 290 */     } else if (xmlObject instanceof CTGroupShape) {
/* 291 */       cTGroupShape.getGrpSpList().remove(xmlObject);
/* 292 */     } else if (xmlObject instanceof CTConnector) {
/* 293 */       cTGroupShape.getCxnSpList().remove(xmlObject);
/* 294 */     } else if (xmlObject instanceof CTGraphicalObjectFrame) {
/* 295 */       cTGroupShape.getGraphicFrameList().remove(xmlObject);
/* 296 */     } else if (xmlObject instanceof CTPicture) {
/* 297 */       XSLFPictureShape xSLFPictureShape = (XSLFPictureShape)paramXSLFShape;
/* 298 */       removePictureRelation(xSLFPictureShape);
/* 299 */       cTGroupShape.getPicList().remove(xmlObject);
/*     */     } else {
/* 301 */       throw new IllegalArgumentException("Unsupported shape: " + paramXSLFShape);
/*     */     } 
/* 303 */     return getShapes().remove(paramXSLFShape);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 311 */     ArrayList<XSLFShape> arrayList = new ArrayList<XSLFShape>(getShapes());
/* 312 */     for (XSLFShape xSLFShape : arrayList) {
/* 313 */       removeShape(xSLFShape);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected CTGroupShape getSpTree() {
/* 320 */     if (this._spTree == null) {
/* 321 */       XmlObject xmlObject = getXmlObject();
/* 322 */       XmlObject[] arrayOfXmlObject = xmlObject.selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' .//*/p:spTree");
/*     */       
/* 324 */       if (arrayOfXmlObject.length == 0) throw new IllegalStateException("CTGroupShape was not found"); 
/* 325 */       this._spTree = (CTGroupShape)arrayOfXmlObject[0];
/*     */     } 
/* 327 */     return this._spTree;
/*     */   }
/*     */   
/*     */   protected final void commit() throws IOException {
/* 331 */     XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 332 */     String str = getRootElementName();
/* 333 */     if (str != null) {
/* 334 */       xmlOptions.setSaveSyntheticDocumentElement(new b("http://schemas.openxmlformats.org/presentationml/2006/main", str));
/*     */     }
/*     */ 
/*     */     
/* 338 */     PackagePart packagePart = getPackagePart();
/* 339 */     OutputStream outputStream = packagePart.getOutputStream();
/* 340 */     getXmlObject().save(outputStream, xmlOptions);
/* 341 */     outputStream.close();
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
/*     */   public XSLFSheet importContent(XSLFSheet paramXSLFSheet) {
/* 353 */     this._shapes = null;
/* 354 */     this._spTree = null;
/* 355 */     this._drawing = null;
/* 356 */     this._spTree = null;
/* 357 */     this._placeholders = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 363 */     getSpTree().set((XmlObject)paramXSLFSheet.getSpTree());
/*     */ 
/*     */     
/* 366 */     List<XSLFShape> list1 = getShapes();
/* 367 */     List<XSLFShape> list2 = paramXSLFSheet.getShapes();
/* 368 */     for (byte b = 0; b < list1.size(); b++) {
/* 369 */       XSLFShape xSLFShape1 = list2.get(b);
/* 370 */       XSLFShape xSLFShape2 = list1.get(b);
/*     */       
/* 372 */       xSLFShape2.copy(xSLFShape1);
/*     */     } 
/* 374 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSLFSheet appendContent(XSLFSheet paramXSLFSheet) {
/* 384 */     CTGroupShape cTGroupShape1 = getSpTree();
/* 385 */     int i = getShapes().size();
/*     */     
/* 387 */     CTGroupShape cTGroupShape2 = paramXSLFSheet.getSpTree();
/* 388 */     for (XmlObject xmlObject : cTGroupShape2.selectPath("*")) {
/* 389 */       if (xmlObject instanceof CTShape) {
/* 390 */         cTGroupShape1.addNewSp().set(xmlObject);
/* 391 */       } else if (xmlObject instanceof CTGroupShape) {
/* 392 */         cTGroupShape1.addNewGrpSp().set(xmlObject);
/* 393 */       } else if (xmlObject instanceof CTConnector) {
/* 394 */         cTGroupShape1.addNewCxnSp().set(xmlObject);
/* 395 */       } else if (xmlObject instanceof CTPicture) {
/* 396 */         cTGroupShape1.addNewPic().set(xmlObject);
/* 397 */       } else if (xmlObject instanceof CTGraphicalObjectFrame) {
/* 398 */         cTGroupShape1.addNewGraphicFrame().set(xmlObject);
/*     */       } 
/*     */     } 
/*     */     
/* 402 */     this._shapes = null;
/* 403 */     this._spTree = null;
/* 404 */     this._drawing = null;
/* 405 */     this._spTree = null;
/* 406 */     this._placeholders = null;
/*     */ 
/*     */     
/* 409 */     List<XSLFShape> list1 = getShapes();
/* 410 */     List<XSLFShape> list2 = paramXSLFSheet.getShapes();
/* 411 */     for (byte b = 0; b < list2.size(); b++) {
/* 412 */       XSLFShape xSLFShape1 = list2.get(b);
/* 413 */       XSLFShape xSLFShape2 = list1.get(i + b);
/*     */       
/* 415 */       xSLFShape2.copy(xSLFShape1);
/*     */     } 
/* 417 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XSLFTheme getTheme() {
/* 427 */     return null;
/*     */   }
/*     */   
/*     */   protected XSLFTextShape getTextShapeByType(Placeholder paramPlaceholder) {
/* 431 */     for (XSLFShape xSLFShape : getShapes()) {
/* 432 */       if (xSLFShape instanceof XSLFTextShape) {
/* 433 */         XSLFTextShape xSLFTextShape = (XSLFTextShape)xSLFShape;
/* 434 */         if (xSLFTextShape.getTextType() == paramPlaceholder) {
/* 435 */           return xSLFTextShape;
/*     */         }
/*     */       } 
/*     */     } 
/* 439 */     return null;
/*     */   }
/*     */   
/*     */   XSLFSimpleShape getPlaceholder(CTPlaceholder paramCTPlaceholder) {
/* 443 */     XSLFSimpleShape xSLFSimpleShape = null;
/* 444 */     if (paramCTPlaceholder.isSetIdx()) xSLFSimpleShape = getPlaceholderById((int)paramCTPlaceholder.getIdx());
/*     */     
/* 446 */     if (xSLFSimpleShape == null && paramCTPlaceholder.isSetType()) {
/* 447 */       xSLFSimpleShape = getPlaceholderByType(paramCTPlaceholder.getType().intValue());
/*     */     }
/* 449 */     return xSLFSimpleShape;
/*     */   }
/*     */   
/*     */   void initPlaceholders() {
/* 453 */     if (this._placeholders == null) {
/* 454 */       this._placeholders = new ArrayList<XSLFTextShape>();
/* 455 */       this._placeholderByIdMap = new HashMap<Integer, XSLFSimpleShape>();
/* 456 */       this._placeholderByTypeMap = new HashMap<Integer, XSLFSimpleShape>();
/*     */       
/* 458 */       for (XSLFShape xSLFShape : getShapes()) {
/* 459 */         if (xSLFShape instanceof XSLFTextShape) {
/* 460 */           XSLFTextShape xSLFTextShape = (XSLFTextShape)xSLFShape;
/* 461 */           CTPlaceholder cTPlaceholder = xSLFTextShape.getCTPlaceholder();
/* 462 */           if (cTPlaceholder != null) {
/* 463 */             this._placeholders.add(xSLFTextShape);
/* 464 */             if (cTPlaceholder.isSetIdx()) {
/* 465 */               int i = (int)cTPlaceholder.getIdx();
/* 466 */               this._placeholderByIdMap.put(Integer.valueOf(i), xSLFTextShape);
/*     */             } 
/* 468 */             if (cTPlaceholder.isSetType()) {
/* 469 */               this._placeholderByTypeMap.put(Integer.valueOf(cTPlaceholder.getType().intValue()), xSLFTextShape);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   XSLFSimpleShape getPlaceholderById(int paramInt) {
/* 478 */     initPlaceholders();
/* 479 */     return this._placeholderByIdMap.get(Integer.valueOf(paramInt));
/*     */   }
/*     */   
/*     */   XSLFSimpleShape getPlaceholderByType(int paramInt) {
/* 483 */     initPlaceholders();
/* 484 */     return this._placeholderByTypeMap.get(Integer.valueOf(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSLFTextShape getPlaceholder(int paramInt) {
/* 493 */     initPlaceholders();
/* 494 */     return this._placeholders.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSLFTextShape[] getPlaceholders() {
/* 502 */     initPlaceholders();
/* 503 */     return this._placeholders.<XSLFTextShape>toArray(new XSLFTextShape[this._placeholders.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDraw(XSLFShape paramXSLFShape) {
/* 513 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getFollowMasterGraphics() {
/* 523 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSLFBackground getBackground() {
/* 531 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Graphics2D paramGraphics2D) {
/* 541 */     DrawFactory drawFactory = DrawFactory.getInstance(paramGraphics2D);
/* 542 */     DrawSheet drawSheet = drawFactory.getDrawable(this);
/* 543 */     drawSheet.draw(paramGraphics2D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String importBlip(String paramString, PackagePart paramPackagePart) {
/*     */     PackagePart packagePart1;
/* 555 */     PackageRelationship packageRelationship = paramPackagePart.getRelationship(paramString);
/*     */     
/*     */     try {
/* 558 */       packagePart1 = paramPackagePart.getRelatedPart(packageRelationship);
/* 559 */     } catch (InvalidFormatException invalidFormatException) {
/* 560 */       throw new POIXMLException(invalidFormatException);
/*     */     } 
/* 562 */     XSLFPictureData xSLFPictureData1 = new XSLFPictureData(packagePart1);
/*     */     
/* 564 */     XMLSlideShow xMLSlideShow = getSlideShow();
/* 565 */     XSLFPictureData xSLFPictureData2 = xMLSlideShow.addPicture(xSLFPictureData1.getData(), xSLFPictureData1.getType());
/* 566 */     PackagePart packagePart2 = xSLFPictureData2.getPackagePart();
/*     */     
/* 568 */     POIXMLDocumentPart.RelationPart relationPart = addRelation(paramString, XSLFRelation.IMAGES, new XSLFPictureData(packagePart2));
/*     */     
/* 570 */     return relationPart.getRelationship().getId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PackagePart importPart(PackageRelationship paramPackageRelationship, PackagePart paramPackagePart) {
/* 578 */     PackagePart packagePart1 = getPackagePart();
/* 579 */     PackagePartName packagePartName = paramPackagePart.getPartName();
/*     */     
/* 581 */     OPCPackage oPCPackage = packagePart1.getPackage();
/* 582 */     if (oPCPackage.containPart(packagePartName))
/*     */     {
/* 584 */       return oPCPackage.getPart(packagePartName);
/*     */     }
/*     */     
/* 587 */     packagePart1.addRelationship(packagePartName, TargetMode.INTERNAL, paramPackageRelationship.getRelationshipType());
/*     */     
/* 589 */     PackagePart packagePart2 = oPCPackage.createPart(packagePartName, paramPackagePart.getContentType());
/*     */     try {
/* 591 */       OutputStream outputStream = packagePart2.getOutputStream();
/* 592 */       InputStream inputStream = paramPackagePart.getInputStream();
/* 593 */       IOUtils.copy(inputStream, outputStream);
/* 594 */       inputStream.close();
/* 595 */       outputStream.close();
/* 596 */     } catch (IOException iOException) {
/* 597 */       throw new POIXMLException(iOException);
/*     */     } 
/* 599 */     return packagePart2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removePictureRelation(XSLFPictureShape paramXSLFPictureShape) {
/* 608 */     POIXMLDocumentPart pOIXMLDocumentPart = getRelationById(paramXSLFPictureShape.getBlipId());
/* 609 */     removeRelation(pOIXMLDocumentPart);
/*     */   }
/*     */   
/*     */   public abstract XmlObject getXmlObject();
/*     */   
/*     */   protected abstract String getRootElementName();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */