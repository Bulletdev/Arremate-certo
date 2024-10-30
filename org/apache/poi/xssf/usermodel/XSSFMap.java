/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.xssf.model.MapInfo;
/*     */ import org.apache.poi.xssf.model.SingleXmlCells;
/*     */ import org.apache.poi.xssf.usermodel.helpers.XSSFSingleXmlCell;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMap;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSchema;
/*     */ import org.w3c.dom.Node;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSSFMap
/*     */ {
/*     */   private CTMap ctMap;
/*     */   private MapInfo mapInfo;
/*     */   
/*     */   public XSSFMap(CTMap paramCTMap, MapInfo paramMapInfo) {
/*  50 */     this.ctMap = paramCTMap;
/*  51 */     this.mapInfo = paramMapInfo;
/*     */   }
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTMap getCtMap() {
/*  57 */     return this.ctMap;
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public CTSchema getCTSchema() {
/*  62 */     String str = this.ctMap.getSchemaID();
/*  63 */     return this.mapInfo.getCTSchemaById(str);
/*     */   }
/*     */   
/*     */   public Node getSchema() {
/*  67 */     Node node = null;
/*     */     
/*  69 */     CTSchema cTSchema = getCTSchema();
/*  70 */     node = cTSchema.getDomNode().getFirstChild();
/*     */     
/*  72 */     return node;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<XSSFSingleXmlCell> getRelatedSingleXMLCell() {
/*  79 */     ArrayList<XSSFSingleXmlCell> arrayList = new ArrayList();
/*     */     
/*  81 */     int i = this.mapInfo.getWorkbook().getNumberOfSheets();
/*  82 */     for (byte b = 0; b < i; b++) {
/*  83 */       XSSFSheet xSSFSheet = this.mapInfo.getWorkbook().getSheetAt(b);
/*  84 */       for (POIXMLDocumentPart pOIXMLDocumentPart : xSSFSheet.getRelations()) {
/*  85 */         if (pOIXMLDocumentPart instanceof SingleXmlCells) {
/*  86 */           SingleXmlCells singleXmlCells = (SingleXmlCells)pOIXMLDocumentPart;
/*  87 */           for (XSSFSingleXmlCell xSSFSingleXmlCell : singleXmlCells.getAllSimpleXmlCell()) {
/*  88 */             if (xSSFSingleXmlCell.getMapId() == this.ctMap.getID()) {
/*  89 */               arrayList.add(xSSFSingleXmlCell);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*  95 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<XSSFTable> getRelatedTables() {
/* 102 */     ArrayList<XSSFTable> arrayList = new ArrayList();
/* 103 */     for (Sheet sheet : this.mapInfo.getWorkbook()) {
/* 104 */       for (POIXMLDocumentPart.RelationPart relationPart : ((XSSFSheet)sheet).getRelationParts()) {
/* 105 */         if (relationPart.getRelationship().getRelationshipType().equals(XSSFRelation.TABLE.getRelation())) {
/* 106 */           XSSFTable xSSFTable = (XSSFTable)relationPart.getDocumentPart();
/* 107 */           if (xSSFTable.mapsTo(this.ctMap.getID())) {
/* 108 */             arrayList.add(xSSFTable);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 114 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */