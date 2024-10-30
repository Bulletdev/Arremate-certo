/*    */ package org.apache.poi.xslf.usermodel;
/*    */ 
/*    */ import org.apache.poi.sl.usermodel.TextBox;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
/*    */ import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
/*    */ import org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XSLFTextBox
/*    */   extends XSLFAutoShape
/*    */   implements TextBox<XSLFShape, XSLFTextParagraph>
/*    */ {
/*    */   XSLFTextBox(CTShape paramCTShape, XSLFSheet paramXSLFSheet) {
/* 37 */     super(paramCTShape, paramXSLFSheet);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static CTShape prototype(int paramInt) {
/* 45 */     CTShape cTShape = CTShape.Factory.newInstance();
/* 46 */     CTShapeNonVisual cTShapeNonVisual = cTShape.addNewNvSpPr();
/* 47 */     CTNonVisualDrawingProps cTNonVisualDrawingProps = cTShapeNonVisual.addNewCNvPr();
/* 48 */     cTNonVisualDrawingProps.setName("TextBox " + paramInt);
/* 49 */     cTNonVisualDrawingProps.setId((paramInt + 1));
/* 50 */     cTShapeNonVisual.addNewCNvSpPr().setTxBox(true);
/* 51 */     cTShapeNonVisual.addNewNvPr();
/* 52 */     CTShapeProperties cTShapeProperties = cTShape.addNewSpPr();
/* 53 */     CTPresetGeometry2D cTPresetGeometry2D = cTShapeProperties.addNewPrstGeom();
/* 54 */     cTPresetGeometry2D.setPrst(STShapeType.RECT);
/* 55 */     cTPresetGeometry2D.addNewAvLst();
/* 56 */     CTTextBody cTTextBody = cTShape.addNewTxBody();
/* 57 */     XSLFAutoShape.initTextBody(cTTextBody);
/*    */     
/* 59 */     return cTShape;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFTextBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */