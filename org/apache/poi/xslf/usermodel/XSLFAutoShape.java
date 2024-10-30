/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import org.apache.poi.sl.usermodel.AutoShape;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STTextAlignType;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STTextAnchoringType;
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
/*     */ public class XSLFAutoShape
/*     */   extends XSLFTextShape
/*     */   implements AutoShape<XSLFShape, XSLFTextParagraph>
/*     */ {
/*     */   XSLFAutoShape(CTShape paramCTShape, XSLFSheet paramXSLFSheet) {
/*  48 */     super((XmlObject)paramCTShape, paramXSLFSheet);
/*     */   }
/*     */ 
/*     */   
/*     */   static XSLFAutoShape create(CTShape paramCTShape, XSLFSheet paramXSLFSheet) {
/*  53 */     if (paramCTShape.getSpPr().isSetCustGeom())
/*  54 */       return new XSLFFreeformShape(paramCTShape, paramXSLFSheet); 
/*  55 */     if (paramCTShape.getNvSpPr().getCNvSpPr().isSetTxBox()) {
/*  56 */       return new XSLFTextBox(paramCTShape, paramXSLFSheet);
/*     */     }
/*  58 */     return new XSLFAutoShape(paramCTShape, paramXSLFSheet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static CTShape prototype(int paramInt) {
/*  66 */     CTShape cTShape = CTShape.Factory.newInstance();
/*  67 */     CTShapeNonVisual cTShapeNonVisual = cTShape.addNewNvSpPr();
/*  68 */     CTNonVisualDrawingProps cTNonVisualDrawingProps = cTShapeNonVisual.addNewCNvPr();
/*  69 */     cTNonVisualDrawingProps.setName("AutoShape " + paramInt);
/*  70 */     cTNonVisualDrawingProps.setId((paramInt + 1));
/*  71 */     cTShapeNonVisual.addNewCNvSpPr();
/*  72 */     cTShapeNonVisual.addNewNvPr();
/*  73 */     CTShapeProperties cTShapeProperties = cTShape.addNewSpPr();
/*  74 */     CTPresetGeometry2D cTPresetGeometry2D = cTShapeProperties.addNewPrstGeom();
/*  75 */     cTPresetGeometry2D.setPrst(STShapeType.RECT);
/*  76 */     cTPresetGeometry2D.addNewAvLst();
/*  77 */     return cTShape;
/*     */   }
/*     */   
/*     */   protected static void initTextBody(CTTextBody paramCTTextBody) {
/*  81 */     CTTextBodyProperties cTTextBodyProperties = paramCTTextBody.addNewBodyPr();
/*  82 */     cTTextBodyProperties.setAnchor(STTextAnchoringType.T);
/*  83 */     cTTextBodyProperties.setRtlCol(false);
/*  84 */     CTTextParagraph cTTextParagraph = paramCTTextBody.addNewP();
/*  85 */     cTTextParagraph.addNewPPr().setAlgn(STTextAlignType.L);
/*  86 */     CTTextCharacterProperties cTTextCharacterProperties = cTTextParagraph.addNewEndParaRPr();
/*  87 */     cTTextCharacterProperties.setLang("en-US");
/*  88 */     cTTextCharacterProperties.setSz(1100);
/*  89 */     cTTextParagraph.addNewR().setT("");
/*  90 */     paramCTTextBody.addNewLstStyle();
/*     */   }
/*     */   
/*     */   protected CTTextBody getTextBody(boolean paramBoolean) {
/*  94 */     CTShape cTShape = (CTShape)getXmlObject();
/*  95 */     CTTextBody cTTextBody = cTShape.getTxBody();
/*  96 */     if (cTTextBody == null && paramBoolean) {
/*  97 */       cTTextBody = cTShape.addNewTxBody();
/*  98 */       initTextBody(cTTextBody);
/*     */     } 
/* 100 */     return cTTextBody;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 105 */     return "[" + getClass().getSimpleName() + "] " + getShapeName();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFAutoShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */