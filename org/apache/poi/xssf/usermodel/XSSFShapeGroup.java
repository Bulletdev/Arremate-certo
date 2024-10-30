/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShapeNonVisual;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;
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
/*     */ public final class XSSFShapeGroup
/*     */   extends XSSFShape
/*     */ {
/*  43 */   private static CTGroupShape prototype = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CTGroupShape ctGroup;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected XSSFShapeGroup(XSSFDrawing paramXSSFDrawing, CTGroupShape paramCTGroupShape) {
/*  54 */     this.drawing = paramXSSFDrawing;
/*  55 */     this.ctGroup = paramCTGroupShape;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static CTGroupShape prototype() {
/*  62 */     if (prototype == null) {
/*  63 */       CTGroupShape cTGroupShape = CTGroupShape.Factory.newInstance();
/*     */       
/*  65 */       CTGroupShapeNonVisual cTGroupShapeNonVisual = cTGroupShape.addNewNvGrpSpPr();
/*  66 */       CTNonVisualDrawingProps cTNonVisualDrawingProps = cTGroupShapeNonVisual.addNewCNvPr();
/*  67 */       cTNonVisualDrawingProps.setId(0L);
/*  68 */       cTNonVisualDrawingProps.setName("Group 0");
/*  69 */       cTGroupShapeNonVisual.addNewCNvGrpSpPr();
/*  70 */       CTGroupShapeProperties cTGroupShapeProperties = cTGroupShape.addNewGrpSpPr();
/*  71 */       CTGroupTransform2D cTGroupTransform2D = cTGroupShapeProperties.addNewXfrm();
/*  72 */       CTPositiveSize2D cTPositiveSize2D1 = cTGroupTransform2D.addNewExt();
/*  73 */       cTPositiveSize2D1.setCx(0L);
/*  74 */       cTPositiveSize2D1.setCy(0L);
/*  75 */       CTPoint2D cTPoint2D1 = cTGroupTransform2D.addNewOff();
/*  76 */       cTPoint2D1.setX(0L);
/*  77 */       cTPoint2D1.setY(0L);
/*  78 */       CTPositiveSize2D cTPositiveSize2D2 = cTGroupTransform2D.addNewChExt();
/*  79 */       cTPositiveSize2D2.setCx(0L);
/*  80 */       cTPositiveSize2D2.setCy(0L);
/*  81 */       CTPoint2D cTPoint2D2 = cTGroupTransform2D.addNewChOff();
/*  82 */       cTPoint2D2.setX(0L);
/*  83 */       cTPoint2D2.setY(0L);
/*     */       
/*  85 */       prototype = cTGroupShape;
/*     */     } 
/*  87 */     return prototype;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFTextBox createTextbox(XSSFChildAnchor paramXSSFChildAnchor) {
/*  98 */     CTShape cTShape = this.ctGroup.addNewSp();
/*  99 */     cTShape.set((XmlObject)XSSFSimpleShape.prototype());
/*     */     
/* 101 */     XSSFTextBox xSSFTextBox = new XSSFTextBox(getDrawing(), cTShape);
/* 102 */     xSSFTextBox.parent = this;
/* 103 */     xSSFTextBox.anchor = paramXSSFChildAnchor;
/* 104 */     xSSFTextBox.getCTShape().getSpPr().setXfrm(paramXSSFChildAnchor.getCTTransform2D());
/* 105 */     return xSSFTextBox;
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
/*     */   public XSSFSimpleShape createSimpleShape(XSSFChildAnchor paramXSSFChildAnchor) {
/* 117 */     CTShape cTShape = this.ctGroup.addNewSp();
/* 118 */     cTShape.set((XmlObject)XSSFSimpleShape.prototype());
/*     */     
/* 120 */     XSSFSimpleShape xSSFSimpleShape = new XSSFSimpleShape(getDrawing(), cTShape);
/* 121 */     xSSFSimpleShape.parent = this;
/* 122 */     xSSFSimpleShape.anchor = paramXSSFChildAnchor;
/* 123 */     xSSFSimpleShape.getCTShape().getSpPr().setXfrm(paramXSSFChildAnchor.getCTTransform2D());
/* 124 */     return xSSFSimpleShape;
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
/*     */   public XSSFConnector createConnector(XSSFChildAnchor paramXSSFChildAnchor) {
/* 136 */     CTConnector cTConnector = this.ctGroup.addNewCxnSp();
/* 137 */     cTConnector.set((XmlObject)XSSFConnector.prototype());
/*     */     
/* 139 */     XSSFConnector xSSFConnector = new XSSFConnector(getDrawing(), cTConnector);
/* 140 */     xSSFConnector.parent = this;
/* 141 */     xSSFConnector.anchor = paramXSSFChildAnchor;
/* 142 */     xSSFConnector.getCTConnector().getSpPr().setXfrm(paramXSSFChildAnchor.getCTTransform2D());
/* 143 */     return xSSFConnector;
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
/*     */   public XSSFPicture createPicture(XSSFClientAnchor paramXSSFClientAnchor, int paramInt) {
/* 155 */     PackageRelationship packageRelationship = getDrawing().addPictureReference(paramInt);
/*     */     
/* 157 */     CTPicture cTPicture = this.ctGroup.addNewPic();
/* 158 */     cTPicture.set((XmlObject)XSSFPicture.prototype());
/*     */     
/* 160 */     XSSFPicture xSSFPicture = new XSSFPicture(getDrawing(), cTPicture);
/* 161 */     xSSFPicture.parent = this;
/* 162 */     xSSFPicture.anchor = paramXSSFClientAnchor;
/* 163 */     xSSFPicture.setPictureReference(packageRelationship);
/* 164 */     return xSSFPicture;
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public CTGroupShape getCTGroupShape() {
/* 169 */     return this.ctGroup;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCoordinates(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 177 */     CTGroupTransform2D cTGroupTransform2D = this.ctGroup.getGrpSpPr().getXfrm();
/* 178 */     CTPoint2D cTPoint2D1 = cTGroupTransform2D.getOff();
/* 179 */     cTPoint2D1.setX(paramInt1);
/* 180 */     cTPoint2D1.setY(paramInt2);
/* 181 */     CTPositiveSize2D cTPositiveSize2D1 = cTGroupTransform2D.getExt();
/* 182 */     cTPositiveSize2D1.setCx(paramInt3);
/* 183 */     cTPositiveSize2D1.setCy(paramInt4);
/*     */     
/* 185 */     CTPoint2D cTPoint2D2 = cTGroupTransform2D.getChOff();
/* 186 */     cTPoint2D2.setX(paramInt1);
/* 187 */     cTPoint2D2.setY(paramInt2);
/* 188 */     CTPositiveSize2D cTPositiveSize2D2 = cTGroupTransform2D.getChExt();
/* 189 */     cTPositiveSize2D2.setCx(paramInt3);
/* 190 */     cTPositiveSize2D2.setCy(paramInt4);
/*     */   }
/*     */   
/*     */   protected CTShapeProperties getShapeProperties() {
/* 194 */     throw new IllegalStateException("Not supported for shape group");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFShapeGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */