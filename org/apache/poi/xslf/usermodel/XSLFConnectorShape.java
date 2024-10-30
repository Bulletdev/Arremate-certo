/*    */ package org.apache.poi.xslf.usermodel;
/*    */ 
/*    */ import org.apache.poi.POIXMLException;
/*    */ import org.apache.poi.sl.usermodel.ConnectorShape;
/*    */ import org.apache.poi.sl.usermodel.Placeholder;
/*    */ import org.apache.poi.sl.usermodel.Shadow;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
/*    */ import org.openxmlformats.schemas.presentationml.x2006.main.CTConnector;
/*    */ import org.openxmlformats.schemas.presentationml.x2006.main.CTConnectorNonVisual;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XSLFConnectorShape
/*    */   extends XSLFSimpleShape
/*    */   implements ConnectorShape<XSLFShape, XSLFTextParagraph>
/*    */ {
/*    */   XSLFConnectorShape(CTConnector paramCTConnector, XSLFSheet paramXSLFSheet) {
/* 43 */     super((XmlObject)paramCTConnector, paramXSLFSheet);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static CTConnector prototype(int paramInt) {
/* 50 */     CTConnector cTConnector = CTConnector.Factory.newInstance();
/* 51 */     CTConnectorNonVisual cTConnectorNonVisual = cTConnector.addNewNvCxnSpPr();
/* 52 */     CTNonVisualDrawingProps cTNonVisualDrawingProps = cTConnectorNonVisual.addNewCNvPr();
/* 53 */     cTNonVisualDrawingProps.setName("Connector " + paramInt);
/* 54 */     cTNonVisualDrawingProps.setId((paramInt + 1));
/* 55 */     cTConnectorNonVisual.addNewCNvCxnSpPr();
/* 56 */     cTConnectorNonVisual.addNewNvPr();
/* 57 */     CTShapeProperties cTShapeProperties = cTConnector.addNewSpPr();
/* 58 */     CTPresetGeometry2D cTPresetGeometry2D = cTShapeProperties.addNewPrstGeom();
/* 59 */     cTPresetGeometry2D.setPrst(STShapeType.LINE);
/* 60 */     cTPresetGeometry2D.addNewAvLst();
/* 61 */     cTShapeProperties.addNewLn();
/* 62 */     return cTConnector;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public XSLFShadow getShadow() {
/* 71 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setPlaceholder(Placeholder paramPlaceholder) {
/* 76 */     throw new POIXMLException("A connector shape can't be a placeholder.");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFConnectorShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */