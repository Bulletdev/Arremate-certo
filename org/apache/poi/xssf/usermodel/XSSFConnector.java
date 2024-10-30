/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTFontReference;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STFontCollectionIndex;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STSchemeColorVal;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnectorNonVisual;
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
/*     */ public final class XSSFConnector
/*     */   extends XSSFShape
/*     */ {
/*  45 */   private static CTConnector prototype = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CTConnector ctShape;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected XSSFConnector(XSSFDrawing paramXSSFDrawing, CTConnector paramCTConnector) {
/*  56 */     this.drawing = paramXSSFDrawing;
/*  57 */     this.ctShape = paramCTConnector;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static CTConnector prototype() {
/*  65 */     if (prototype == null) {
/*  66 */       CTConnector cTConnector = CTConnector.Factory.newInstance();
/*  67 */       CTConnectorNonVisual cTConnectorNonVisual = cTConnector.addNewNvCxnSpPr();
/*  68 */       CTNonVisualDrawingProps cTNonVisualDrawingProps = cTConnectorNonVisual.addNewCNvPr();
/*  69 */       cTNonVisualDrawingProps.setId(1L);
/*  70 */       cTNonVisualDrawingProps.setName("Shape 1");
/*  71 */       cTConnectorNonVisual.addNewCNvCxnSpPr();
/*     */       
/*  73 */       CTShapeProperties cTShapeProperties = cTConnector.addNewSpPr();
/*  74 */       CTTransform2D cTTransform2D = cTShapeProperties.addNewXfrm();
/*  75 */       CTPositiveSize2D cTPositiveSize2D = cTTransform2D.addNewExt();
/*  76 */       cTPositiveSize2D.setCx(0L);
/*  77 */       cTPositiveSize2D.setCy(0L);
/*  78 */       CTPoint2D cTPoint2D = cTTransform2D.addNewOff();
/*  79 */       cTPoint2D.setX(0L);
/*  80 */       cTPoint2D.setY(0L);
/*     */       
/*  82 */       CTPresetGeometry2D cTPresetGeometry2D = cTShapeProperties.addNewPrstGeom();
/*  83 */       cTPresetGeometry2D.setPrst(STShapeType.LINE);
/*  84 */       cTPresetGeometry2D.addNewAvLst();
/*     */       
/*  86 */       CTShapeStyle cTShapeStyle = cTConnector.addNewStyle();
/*  87 */       CTSchemeColor cTSchemeColor = cTShapeStyle.addNewLnRef().addNewSchemeClr();
/*  88 */       cTSchemeColor.setVal(STSchemeColorVal.ACCENT_1);
/*  89 */       cTShapeStyle.getLnRef().setIdx(1L);
/*     */       
/*  91 */       CTStyleMatrixReference cTStyleMatrixReference1 = cTShapeStyle.addNewFillRef();
/*  92 */       cTStyleMatrixReference1.setIdx(0L);
/*  93 */       cTStyleMatrixReference1.addNewSchemeClr().setVal(STSchemeColorVal.ACCENT_1);
/*     */       
/*  95 */       CTStyleMatrixReference cTStyleMatrixReference2 = cTShapeStyle.addNewEffectRef();
/*  96 */       cTStyleMatrixReference2.setIdx(0L);
/*  97 */       cTStyleMatrixReference2.addNewSchemeClr().setVal(STSchemeColorVal.ACCENT_1);
/*     */       
/*  99 */       CTFontReference cTFontReference = cTShapeStyle.addNewFontRef();
/* 100 */       cTFontReference.setIdx(STFontCollectionIndex.MINOR);
/* 101 */       cTFontReference.addNewSchemeClr().setVal(STSchemeColorVal.TX_1);
/*     */       
/* 103 */       prototype = cTConnector;
/*     */     } 
/* 105 */     return prototype;
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public CTConnector getCTConnector() {
/* 110 */     return this.ctShape;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getShapeType() {
/* 120 */     return this.ctShape.getSpPr().getPrstGeom().getPrst().intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShapeType(int paramInt) {
/* 130 */     this.ctShape.getSpPr().getPrstGeom().setPrst(STShapeType.Enum.forInt(paramInt));
/*     */   }
/*     */   
/*     */   protected CTShapeProperties getShapeProperties() {
/* 134 */     return this.ctShape.getSpPr();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFConnector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */