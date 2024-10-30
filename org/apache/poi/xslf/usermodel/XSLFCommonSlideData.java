/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTable;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
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
/*     */ public class XSLFCommonSlideData
/*     */ {
/*     */   private final CTCommonSlideData data;
/*     */   
/*     */   public XSLFCommonSlideData(CTCommonSlideData paramCTCommonSlideData) {
/*  46 */     this.data = paramCTCommonSlideData;
/*     */   }
/*     */   
/*     */   public List<DrawingTextBody> getDrawingText() {
/*  50 */     CTGroupShape cTGroupShape = this.data.getSpTree();
/*     */     
/*  52 */     ArrayList<DrawingTextBody> arrayList = new ArrayList();
/*     */     
/*  54 */     processShape(cTGroupShape, arrayList);
/*     */     
/*  56 */     for (CTGroupShape cTGroupShape1 : cTGroupShape.getGrpSpArray()) {
/*  57 */       processShape(cTGroupShape1, arrayList);
/*     */     }
/*     */     
/*  60 */     for (CTGraphicalObjectFrame cTGraphicalObjectFrame : cTGroupShape.getGraphicFrameArray()) {
/*  61 */       CTGraphicalObjectData cTGraphicalObjectData = cTGraphicalObjectFrame.getGraphic().getGraphicData();
/*  62 */       XmlCursor xmlCursor = cTGraphicalObjectData.newCursor();
/*  63 */       xmlCursor.selectPath("declare namespace pic='" + CTTable.type.getName().getNamespaceURI() + "' .//pic:tbl");
/*     */       
/*  65 */       while (xmlCursor.toNextSelection()) {
/*  66 */         CTTable cTTable; XmlObject xmlObject = xmlCursor.getObject();
/*     */         
/*  68 */         if (xmlObject instanceof org.apache.xmlbeans.impl.values.XmlAnyTypeImpl) {
/*     */           
/*     */           try {
/*  71 */             cTTable = CTTable.Factory.parse(xmlObject.toString(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*  72 */           } catch (XmlException xmlException) {
/*  73 */             throw new POIXMLException(xmlException);
/*     */           } 
/*     */         }
/*     */         
/*  77 */         if (cTTable instanceof CTTable) {
/*  78 */           DrawingTable drawingTable = new DrawingTable(cTTable);
/*     */           
/*  80 */           for (DrawingTableRow drawingTableRow : drawingTable.getRows()) {
/*  81 */             for (DrawingTableCell drawingTableCell : drawingTableRow.getCells()) {
/*  82 */               DrawingTextBody drawingTextBody = drawingTableCell.getTextBody();
/*  83 */               arrayList.add(drawingTextBody);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/*  89 */       xmlCursor.dispose();
/*     */     } 
/*     */     
/*  92 */     return arrayList;
/*     */   }
/*     */   public List<DrawingParagraph> getText() {
/*  95 */     ArrayList<DrawingParagraph> arrayList = new ArrayList();
/*  96 */     for (DrawingTextBody drawingTextBody : getDrawingText()) {
/*  97 */       arrayList.addAll(Arrays.asList(drawingTextBody.getParagraphs()));
/*     */     }
/*  99 */     return arrayList;
/*     */   }
/*     */   
/*     */   private void processShape(CTGroupShape paramCTGroupShape, List<DrawingTextBody> paramList) {
/* 103 */     for (CTShape cTShape : paramCTGroupShape.getSpArray()) {
/* 104 */       CTTextBody cTTextBody = cTShape.getTxBody();
/* 105 */       if (cTTextBody != null) {
/*     */         DrawingTextBody drawingTextBody;
/*     */ 
/*     */ 
/*     */         
/* 110 */         CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps = cTShape.getNvSpPr().getNvPr();
/* 111 */         if (cTApplicationNonVisualDrawingProps.isSetPh()) {
/* 112 */           drawingTextBody = new DrawingTextPlaceholder(cTTextBody, cTApplicationNonVisualDrawingProps.getPh());
/*     */         } else {
/* 114 */           drawingTextBody = new DrawingTextBody(cTTextBody);
/*     */         } 
/*     */         
/* 117 */         paramList.add(drawingTextBody);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFCommonSlideData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */