/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrameNonVisual;
/*     */ import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
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
/*     */ public final class XSSFGraphicFrame
/*     */   extends XSSFShape
/*     */ {
/*  43 */   private static CTGraphicalObjectFrame prototype = null;
/*     */ 
/*     */ 
/*     */   
/*     */   private CTGraphicalObjectFrame graphicFrame;
/*     */ 
/*     */   
/*     */   private XSSFClientAnchor anchor;
/*     */ 
/*     */ 
/*     */   
/*     */   protected XSSFGraphicFrame(XSSFDrawing paramXSSFDrawing, CTGraphicalObjectFrame paramCTGraphicalObjectFrame) {
/*  55 */     this.drawing = paramXSSFDrawing;
/*  56 */     this.graphicFrame = paramCTGraphicalObjectFrame;
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public CTGraphicalObjectFrame getCTGraphicalObjectFrame() {
/*  61 */     return this.graphicFrame;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static CTGraphicalObjectFrame prototype() {
/*  68 */     if (prototype == null) {
/*  69 */       CTGraphicalObjectFrame cTGraphicalObjectFrame = CTGraphicalObjectFrame.Factory.newInstance();
/*     */       
/*  71 */       CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisual = cTGraphicalObjectFrame.addNewNvGraphicFramePr();
/*  72 */       CTNonVisualDrawingProps cTNonVisualDrawingProps = cTGraphicalObjectFrameNonVisual.addNewCNvPr();
/*  73 */       cTNonVisualDrawingProps.setId(0L);
/*  74 */       cTNonVisualDrawingProps.setName("Diagramm 1");
/*  75 */       cTGraphicalObjectFrameNonVisual.addNewCNvGraphicFramePr();
/*     */       
/*  77 */       CTTransform2D cTTransform2D = cTGraphicalObjectFrame.addNewXfrm();
/*  78 */       CTPositiveSize2D cTPositiveSize2D = cTTransform2D.addNewExt();
/*  79 */       CTPoint2D cTPoint2D = cTTransform2D.addNewOff();
/*     */       
/*  81 */       cTPositiveSize2D.setCx(0L);
/*  82 */       cTPositiveSize2D.setCy(0L);
/*  83 */       cTPoint2D.setX(0L);
/*  84 */       cTPoint2D.setY(0L);
/*     */       
/*  86 */       cTGraphicalObjectFrame.addNewGraphic();
/*     */       
/*  88 */       prototype = cTGraphicalObjectFrame;
/*     */     } 
/*  90 */     return prototype;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMacro(String paramString) {
/*  97 */     this.graphicFrame.setMacro(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String paramString) {
/* 104 */     getNonVisualProperties().setName(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 112 */     return getNonVisualProperties().getName();
/*     */   }
/*     */   
/*     */   private CTNonVisualDrawingProps getNonVisualProperties() {
/* 116 */     CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisual = this.graphicFrame.getNvGraphicFramePr();
/* 117 */     return cTGraphicalObjectFrameNonVisual.getCNvPr();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setAnchor(XSSFClientAnchor paramXSSFClientAnchor) {
/* 124 */     this.anchor = paramXSSFClientAnchor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFClientAnchor getAnchor() {
/* 132 */     return this.anchor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setChart(XSSFChart paramXSSFChart, String paramString) {
/* 139 */     CTGraphicalObjectData cTGraphicalObjectData = this.graphicFrame.getGraphic().addNewGraphicData();
/* 140 */     appendChartElement(cTGraphicalObjectData, paramString);
/* 141 */     paramXSSFChart.setGraphicFrame(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getId() {
/* 149 */     return this.graphicFrame.getNvGraphicFramePr().getCNvPr().getId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setId(long paramLong) {
/* 156 */     this.graphicFrame.getNvGraphicFramePr().getCNvPr().setId(paramLong);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void appendChartElement(CTGraphicalObjectData paramCTGraphicalObjectData, String paramString) {
/* 176 */     String str1 = STRelationshipId.type.getName().getNamespaceURI();
/* 177 */     String str2 = "http://schemas.openxmlformats.org/drawingml/2006/chart";
/* 178 */     XmlCursor xmlCursor = paramCTGraphicalObjectData.newCursor();
/* 179 */     xmlCursor.toNextToken();
/* 180 */     xmlCursor.beginElement(new b(str2, "chart", "c"));
/* 181 */     xmlCursor.insertAttributeWithValue(new b(str1, "id", "r"), paramString);
/* 182 */     xmlCursor.dispose();
/* 183 */     paramCTGraphicalObjectData.setUri(str2);
/*     */   }
/*     */ 
/*     */   
/*     */   protected CTShapeProperties getShapeProperties() {
/* 188 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFGraphicFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */