/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import com.microsoft.schemas.vml.CTShape;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.ss.usermodel.Chart;
/*     */ import org.apache.poi.ss.usermodel.ClientAnchor;
/*     */ import org.apache.poi.ss.usermodel.Comment;
/*     */ import org.apache.poi.ss.usermodel.Drawing;
/*     */ import org.apache.poi.ss.usermodel.Picture;
/*     */ import org.apache.poi.ss.util.CellAddress;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.xssf.model.CommentsTable;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTOneCellAnchor;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.STEditAs;
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
/*     */ public final class XSSFDrawing
/*     */   extends POIXMLDocumentPart
/*     */   implements Drawing
/*     */ {
/*     */   private CTDrawing drawing;
/*  61 */   private long numOfGraphicFrames = 0L;
/*     */ 
/*     */ 
/*     */   
/*     */   protected static final String NAMESPACE_A = "http://schemas.openxmlformats.org/drawingml/2006/main";
/*     */ 
/*     */   
/*     */   protected static final String NAMESPACE_C = "http://schemas.openxmlformats.org/drawingml/2006/chart";
/*     */ 
/*     */ 
/*     */   
/*     */   protected XSSFDrawing() {
/*  73 */     this.drawing = newDrawing();
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
/*     */   public XSSFDrawing(PackagePart paramPackagePart) throws IOException, XmlException {
/*  85 */     super(paramPackagePart);
/*  86 */     XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */     
/*  88 */     xmlOptions.setLoadReplaceDocumentElement(null);
/*  89 */     this.drawing = CTDrawing.Factory.parse(paramPackagePart.getInputStream(), xmlOptions);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public XSSFDrawing(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException, XmlException {
/*  97 */     this(paramPackagePart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static CTDrawing newDrawing() {
/* 106 */     return CTDrawing.Factory.newInstance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTDrawing getCTDrawing() {
/* 116 */     return this.drawing;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void commit() throws IOException {
/* 121 */     XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 129 */     xmlOptions.setSaveSyntheticDocumentElement(new b(CTDrawing.type.getName().getNamespaceURI(), "wsDr", "xdr"));
/*     */ 
/*     */ 
/*     */     
/* 133 */     PackagePart packagePart = getPackagePart();
/* 134 */     OutputStream outputStream = packagePart.getOutputStream();
/* 135 */     this.drawing.save(outputStream, xmlOptions);
/* 136 */     outputStream.close();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFClientAnchor createAnchor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
/* 142 */     return new XSSFClientAnchor(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFTextBox createTextbox(XSSFClientAnchor paramXSSFClientAnchor) {
/* 153 */     long l = newShapeId();
/* 154 */     CTTwoCellAnchor cTTwoCellAnchor = createTwoCellAnchor(paramXSSFClientAnchor);
/* 155 */     CTShape cTShape = cTTwoCellAnchor.addNewSp();
/* 156 */     cTShape.set((XmlObject)XSSFSimpleShape.prototype());
/* 157 */     cTShape.getNvSpPr().getCNvPr().setId(l);
/* 158 */     XSSFTextBox xSSFTextBox = new XSSFTextBox(this, cTShape);
/* 159 */     xSSFTextBox.anchor = paramXSSFClientAnchor;
/* 160 */     return xSSFTextBox;
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
/*     */   public XSSFPicture createPicture(XSSFClientAnchor paramXSSFClientAnchor, int paramInt) {
/* 175 */     PackageRelationship packageRelationship = addPictureReference(paramInt);
/*     */     
/* 177 */     long l = newShapeId();
/* 178 */     CTTwoCellAnchor cTTwoCellAnchor = createTwoCellAnchor(paramXSSFClientAnchor);
/* 179 */     CTPicture cTPicture = cTTwoCellAnchor.addNewPic();
/* 180 */     cTPicture.set((XmlObject)XSSFPicture.prototype());
/*     */     
/* 182 */     cTPicture.getNvPicPr().getCNvPr().setId(l);
/*     */     
/* 184 */     XSSFPicture xSSFPicture = new XSSFPicture(this, cTPicture);
/* 185 */     xSSFPicture.anchor = paramXSSFClientAnchor;
/* 186 */     xSSFPicture.setPictureReference(packageRelationship);
/* 187 */     return xSSFPicture;
/*     */   }
/*     */ 
/*     */   
/*     */   public XSSFPicture createPicture(ClientAnchor paramClientAnchor, int paramInt) {
/* 192 */     return createPicture((XSSFClientAnchor)paramClientAnchor, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFChart createChart(XSSFClientAnchor paramXSSFClientAnchor) {
/* 203 */     int i = getPackagePart().getPackage().getPartsByContentType(XSSFRelation.CHART.getContentType()).size() + 1;
/*     */ 
/*     */     
/* 206 */     POIXMLDocumentPart.RelationPart relationPart = createRelationship(XSSFRelation.CHART, XSSFFactory.getInstance(), i, false);
/*     */     
/* 208 */     XSSFChart xSSFChart = (XSSFChart)relationPart.getDocumentPart();
/* 209 */     String str = relationPart.getRelationship().getId();
/*     */     
/* 211 */     XSSFGraphicFrame xSSFGraphicFrame = createGraphicFrame(paramXSSFClientAnchor);
/* 212 */     xSSFGraphicFrame.setChart(xSSFChart, str);
/*     */     
/* 214 */     return xSSFChart;
/*     */   }
/*     */ 
/*     */   
/*     */   public XSSFChart createChart(ClientAnchor paramClientAnchor) {
/* 219 */     return createChart((XSSFClientAnchor)paramClientAnchor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected PackageRelationship addPictureReference(int paramInt) {
/* 230 */     XSSFWorkbook xSSFWorkbook = (XSSFWorkbook)getParent().getParent();
/* 231 */     XSSFPictureData xSSFPictureData1 = xSSFWorkbook.getAllPictures().get(paramInt);
/* 232 */     XSSFPictureData xSSFPictureData2 = new XSSFPictureData(xSSFPictureData1.getPackagePart());
/* 233 */     POIXMLDocumentPart.RelationPart relationPart = addRelation(null, XSSFRelation.IMAGES, xSSFPictureData2);
/* 234 */     return relationPart.getRelationship();
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
/*     */   public XSSFSimpleShape createSimpleShape(XSSFClientAnchor paramXSSFClientAnchor) {
/* 247 */     long l = newShapeId();
/* 248 */     CTTwoCellAnchor cTTwoCellAnchor = createTwoCellAnchor(paramXSSFClientAnchor);
/* 249 */     CTShape cTShape = cTTwoCellAnchor.addNewSp();
/* 250 */     cTShape.set((XmlObject)XSSFSimpleShape.prototype());
/* 251 */     cTShape.getNvSpPr().getCNvPr().setId(l);
/* 252 */     XSSFSimpleShape xSSFSimpleShape = new XSSFSimpleShape(this, cTShape);
/* 253 */     xSSFSimpleShape.anchor = paramXSSFClientAnchor;
/* 254 */     return xSSFSimpleShape;
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
/*     */   public XSSFConnector createConnector(XSSFClientAnchor paramXSSFClientAnchor) {
/* 267 */     CTTwoCellAnchor cTTwoCellAnchor = createTwoCellAnchor(paramXSSFClientAnchor);
/* 268 */     CTConnector cTConnector = cTTwoCellAnchor.addNewCxnSp();
/* 269 */     cTConnector.set((XmlObject)XSSFConnector.prototype());
/*     */     
/* 271 */     XSSFConnector xSSFConnector = new XSSFConnector(this, cTConnector);
/* 272 */     xSSFConnector.anchor = paramXSSFClientAnchor;
/* 273 */     return xSSFConnector;
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
/*     */   public XSSFShapeGroup createGroup(XSSFClientAnchor paramXSSFClientAnchor) {
/* 286 */     CTTwoCellAnchor cTTwoCellAnchor = createTwoCellAnchor(paramXSSFClientAnchor);
/* 287 */     CTGroupShape cTGroupShape = cTTwoCellAnchor.addNewGrpSp();
/* 288 */     cTGroupShape.set((XmlObject)XSSFShapeGroup.prototype());
/*     */     
/* 290 */     XSSFShapeGroup xSSFShapeGroup = new XSSFShapeGroup(this, cTGroupShape);
/* 291 */     xSSFShapeGroup.anchor = paramXSSFClientAnchor;
/* 292 */     return xSSFShapeGroup;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFComment createCellComment(ClientAnchor paramClientAnchor) {
/* 303 */     XSSFClientAnchor xSSFClientAnchor = (XSSFClientAnchor)paramClientAnchor;
/* 304 */     XSSFSheet xSSFSheet = (XSSFSheet)getParent();
/*     */ 
/*     */     
/* 307 */     CommentsTable commentsTable = xSSFSheet.getCommentsTable(true);
/* 308 */     XSSFVMLDrawing xSSFVMLDrawing = xSSFSheet.getVMLDrawing(true);
/* 309 */     CTShape cTShape = xSSFVMLDrawing.newCommentShape();
/* 310 */     if (xSSFClientAnchor.isSet()) {
/*     */ 
/*     */       
/* 313 */       int i = xSSFClientAnchor.getDx1() / 9525;
/* 314 */       int j = xSSFClientAnchor.getDy1() / 9525;
/* 315 */       int k = xSSFClientAnchor.getDx2() / 9525;
/* 316 */       int m = xSSFClientAnchor.getDy2() / 9525;
/* 317 */       String str = xSSFClientAnchor.getCol1() + ", " + i + ", " + xSSFClientAnchor.getRow1() + ", " + j + ", " + xSSFClientAnchor.getCol2() + ", " + k + ", " + xSSFClientAnchor.getRow2() + ", " + m;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 322 */       cTShape.getClientDataArray(0).setAnchorArray(0, str);
/*     */     } 
/* 324 */     CellAddress cellAddress = new CellAddress(xSSFClientAnchor.getRow1(), xSSFClientAnchor.getCol1());
/*     */     
/* 326 */     if (commentsTable.findCellComment(cellAddress) != null) {
/* 327 */       throw new IllegalArgumentException("Multiple cell comments in one cell are not allowed, cell: " + cellAddress);
/*     */     }
/*     */     
/* 330 */     return new XSSFComment(commentsTable, commentsTable.newComment(cellAddress), cTShape);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private XSSFGraphicFrame createGraphicFrame(XSSFClientAnchor paramXSSFClientAnchor) {
/* 341 */     CTTwoCellAnchor cTTwoCellAnchor = createTwoCellAnchor(paramXSSFClientAnchor);
/* 342 */     CTGraphicalObjectFrame cTGraphicalObjectFrame = cTTwoCellAnchor.addNewGraphicFrame();
/* 343 */     cTGraphicalObjectFrame.set((XmlObject)XSSFGraphicFrame.prototype());
/*     */     
/* 345 */     long l = this.numOfGraphicFrames++;
/* 346 */     XSSFGraphicFrame xSSFGraphicFrame = new XSSFGraphicFrame(this, cTGraphicalObjectFrame);
/* 347 */     xSSFGraphicFrame.setAnchor(paramXSSFClientAnchor);
/* 348 */     xSSFGraphicFrame.setId(l);
/* 349 */     xSSFGraphicFrame.setName("Diagramm" + l);
/* 350 */     return xSSFGraphicFrame;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<XSSFChart> getCharts() {
/* 357 */     ArrayList<XSSFChart> arrayList = new ArrayList();
/* 358 */     for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
/* 359 */       if (pOIXMLDocumentPart instanceof XSSFChart) {
/* 360 */         arrayList.add((XSSFChart)pOIXMLDocumentPart);
/*     */       }
/*     */     } 
/* 363 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CTTwoCellAnchor createTwoCellAnchor(XSSFClientAnchor paramXSSFClientAnchor) {
/* 372 */     CTTwoCellAnchor cTTwoCellAnchor = this.drawing.addNewTwoCellAnchor();
/* 373 */     cTTwoCellAnchor.setFrom(paramXSSFClientAnchor.getFrom());
/* 374 */     cTTwoCellAnchor.setTo(paramXSSFClientAnchor.getTo());
/* 375 */     cTTwoCellAnchor.addNewClientData();
/* 376 */     paramXSSFClientAnchor.setTo(cTTwoCellAnchor.getTo());
/* 377 */     paramXSSFClientAnchor.setFrom(cTTwoCellAnchor.getFrom());
/*     */     
/* 379 */     switch (paramXSSFClientAnchor.getAnchorType()) { case DONT_MOVE_AND_RESIZE:
/* 380 */         enum_ = STEditAs.ABSOLUTE;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 385 */         cTTwoCellAnchor.setEditAs(enum_);
/* 386 */         return cTTwoCellAnchor;case MOVE_AND_RESIZE: enum_ = STEditAs.TWO_CELL; cTTwoCellAnchor.setEditAs(enum_); return cTTwoCellAnchor;case MOVE_DONT_RESIZE: enum_ = STEditAs.ONE_CELL; cTTwoCellAnchor.setEditAs(enum_); return cTTwoCellAnchor; }  STEditAs.Enum enum_ = STEditAs.ONE_CELL; cTTwoCellAnchor.setEditAs(enum_); return cTTwoCellAnchor;
/*     */   }
/*     */   
/*     */   private long newShapeId() {
/* 390 */     return (this.drawing.sizeOfTwoCellAnchorArray() + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<XSSFShape> getShapes() {
/* 398 */     ArrayList<XSSFShapeGroup> arrayList = new ArrayList();
/* 399 */     for (XmlObject xmlObject : this.drawing.selectPath("./*/*")) {
/* 400 */       XSSFShapeGroup xSSFShapeGroup; XSSFPicture xSSFPicture = null;
/* 401 */       if (xmlObject instanceof CTPicture) { xSSFPicture = new XSSFPicture(this, (CTPicture)xmlObject); }
/* 402 */       else if (xmlObject instanceof CTConnector) { XSSFConnector xSSFConnector = new XSSFConnector(this, (CTConnector)xmlObject); }
/* 403 */       else if (xmlObject instanceof CTShape) { XSSFSimpleShape xSSFSimpleShape = new XSSFSimpleShape(this, (CTShape)xmlObject); }
/* 404 */       else if (xmlObject instanceof CTGraphicalObjectFrame) { XSSFGraphicFrame xSSFGraphicFrame = new XSSFGraphicFrame(this, (CTGraphicalObjectFrame)xmlObject); }
/* 405 */       else if (xmlObject instanceof CTGroupShape) { xSSFShapeGroup = new XSSFShapeGroup(this, (CTGroupShape)xmlObject); }
/*     */       
/* 407 */       if (xSSFShapeGroup != null) {
/* 408 */         xSSFShapeGroup.anchor = getAnchorFromParent(xmlObject);
/* 409 */         arrayList.add(xSSFShapeGroup);
/*     */       } 
/*     */     } 
/* 412 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   private XSSFAnchor getAnchorFromParent(XmlObject paramXmlObject) {
/* 417 */     XSSFClientAnchor xSSFClientAnchor = null;
/*     */     
/* 419 */     XmlObject xmlObject = null;
/* 420 */     XmlCursor xmlCursor = paramXmlObject.newCursor();
/* 421 */     if (xmlCursor.toParent()) xmlObject = xmlCursor.getObject(); 
/* 422 */     xmlCursor.dispose();
/* 423 */     if (xmlObject != null) {
/* 424 */       if (xmlObject instanceof CTTwoCellAnchor) {
/* 425 */         CTTwoCellAnchor cTTwoCellAnchor = (CTTwoCellAnchor)xmlObject;
/* 426 */         xSSFClientAnchor = new XSSFClientAnchor(cTTwoCellAnchor.getFrom(), cTTwoCellAnchor.getTo());
/* 427 */       } else if (xmlObject instanceof CTOneCellAnchor) {
/* 428 */         CTOneCellAnchor cTOneCellAnchor = (CTOneCellAnchor)xmlObject;
/* 429 */         xSSFClientAnchor = new XSSFClientAnchor(cTOneCellAnchor.getFrom(), CTMarker.Factory.newInstance());
/*     */       } 
/*     */     }
/* 432 */     return xSSFClientAnchor;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFDrawing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */