/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTConnector;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSLFDrawing
/*     */ {
/*     */   private XSLFSheet _sheet;
/*  38 */   private int _shapeId = 1;
/*     */   private CTGroupShape _spTree;
/*     */   
/*     */   XSLFDrawing(XSLFSheet paramXSLFSheet, CTGroupShape paramCTGroupShape) {
/*  42 */     this._sheet = paramXSLFSheet;
/*  43 */     this._spTree = paramCTGroupShape;
/*  44 */     XmlObject[] arrayOfXmlObject = paramXSLFSheet.getSpTree().selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' .//*/p:cNvPr");
/*     */     
/*  46 */     for (XmlObject xmlObject : arrayOfXmlObject) {
/*     */ 
/*     */       
/*  49 */       if (xmlObject instanceof CTNonVisualDrawingProps) {
/*  50 */         CTNonVisualDrawingProps cTNonVisualDrawingProps = (CTNonVisualDrawingProps)xmlObject;
/*  51 */         this._shapeId = (int)Math.max(this._shapeId, cTNonVisualDrawingProps.getId());
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public XSLFAutoShape createAutoShape() {
/*  57 */     CTShape cTShape = this._spTree.addNewSp();
/*  58 */     cTShape.set((XmlObject)XSLFAutoShape.prototype(this._shapeId++));
/*  59 */     XSLFAutoShape xSLFAutoShape = new XSLFAutoShape(cTShape, this._sheet);
/*  60 */     xSLFAutoShape.setAnchor(new Rectangle2D.Double());
/*  61 */     return xSLFAutoShape;
/*     */   }
/*     */   
/*     */   public XSLFFreeformShape createFreeform() {
/*  65 */     CTShape cTShape = this._spTree.addNewSp();
/*  66 */     cTShape.set((XmlObject)XSLFFreeformShape.prototype(this._shapeId++));
/*  67 */     XSLFFreeformShape xSLFFreeformShape = new XSLFFreeformShape(cTShape, this._sheet);
/*  68 */     xSLFFreeformShape.setAnchor(new Rectangle2D.Double());
/*  69 */     return xSLFFreeformShape;
/*     */   }
/*     */   
/*     */   public XSLFTextBox createTextBox() {
/*  73 */     CTShape cTShape = this._spTree.addNewSp();
/*  74 */     cTShape.set((XmlObject)XSLFTextBox.prototype(this._shapeId++));
/*  75 */     XSLFTextBox xSLFTextBox = new XSLFTextBox(cTShape, this._sheet);
/*  76 */     xSLFTextBox.setAnchor(new Rectangle2D.Double());
/*  77 */     return xSLFTextBox;
/*     */   }
/*     */   
/*     */   public XSLFConnectorShape createConnector() {
/*  81 */     CTConnector cTConnector = this._spTree.addNewCxnSp();
/*  82 */     cTConnector.set((XmlObject)XSLFConnectorShape.prototype(this._shapeId++));
/*  83 */     XSLFConnectorShape xSLFConnectorShape = new XSLFConnectorShape(cTConnector, this._sheet);
/*  84 */     xSLFConnectorShape.setAnchor(new Rectangle2D.Double());
/*  85 */     xSLFConnectorShape.setLineColor(Color.black);
/*  86 */     xSLFConnectorShape.setLineWidth(0.75D);
/*  87 */     return xSLFConnectorShape;
/*     */   }
/*     */   
/*     */   public XSLFGroupShape createGroup() {
/*  91 */     CTGroupShape cTGroupShape = this._spTree.addNewGrpSp();
/*  92 */     cTGroupShape.set((XmlObject)XSLFGroupShape.prototype(this._shapeId++));
/*  93 */     XSLFGroupShape xSLFGroupShape = new XSLFGroupShape(cTGroupShape, this._sheet);
/*  94 */     xSLFGroupShape.setAnchor(new Rectangle2D.Double());
/*  95 */     return xSLFGroupShape;
/*     */   }
/*     */   
/*     */   public XSLFPictureShape createPicture(String paramString) {
/*  99 */     CTPicture cTPicture = this._spTree.addNewPic();
/* 100 */     cTPicture.set((XmlObject)XSLFPictureShape.prototype(this._shapeId++, paramString));
/* 101 */     XSLFPictureShape xSLFPictureShape = new XSLFPictureShape(cTPicture, this._sheet);
/* 102 */     xSLFPictureShape.setAnchor(new Rectangle2D.Double());
/* 103 */     return xSLFPictureShape;
/*     */   }
/*     */   
/*     */   public XSLFTable createTable() {
/* 107 */     CTGraphicalObjectFrame cTGraphicalObjectFrame = this._spTree.addNewGraphicFrame();
/* 108 */     cTGraphicalObjectFrame.set((XmlObject)XSLFTable.prototype(this._shapeId++));
/* 109 */     XSLFTable xSLFTable = new XSLFTable(cTGraphicalObjectFrame, this._sheet);
/* 110 */     xSLFTable.setAnchor(new Rectangle2D.Double());
/* 111 */     return xSLFTable;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFDrawing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */