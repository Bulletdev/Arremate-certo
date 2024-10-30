/*    */ package org.apache.poi.xssf.usermodel.helpers;
/*    */ 
/*    */ import org.apache.poi.xssf.usermodel.XSSFTable;
/*    */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
/*    */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXmlColumnPr;
/*    */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXmlDataType;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XSSFXmlColumnPr
/*    */ {
/*    */   private XSSFTable table;
/*    */   private CTTableColumn ctTableColumn;
/*    */   private CTXmlColumnPr ctXmlColumnPr;
/*    */   
/*    */   public XSSFXmlColumnPr(XSSFTable paramXSSFTable, CTTableColumn paramCTTableColumn, CTXmlColumnPr paramCTXmlColumnPr) {
/* 41 */     this.table = paramXSSFTable;
/* 42 */     this.ctTableColumn = paramCTTableColumn;
/* 43 */     this.ctXmlColumnPr = paramCTXmlColumnPr;
/*    */   }
/*    */   
/*    */   public long getMapId() {
/* 47 */     return this.ctXmlColumnPr.getMapId();
/*    */   }
/*    */   
/*    */   public String getXPath() {
/* 51 */     return this.ctXmlColumnPr.getXpath();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public long getId() {
/* 58 */     return this.ctTableColumn.getId();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getLocalXPath() {
/* 68 */     StringBuilder stringBuilder = new StringBuilder();
/* 69 */     int i = (this.table.getCommonXpath().split("/")).length - 1;
/*    */     
/* 71 */     String[] arrayOfString = this.ctXmlColumnPr.getXpath().split("/");
/* 72 */     for (int j = i; j < arrayOfString.length; j++) {
/* 73 */       stringBuilder.append("/" + arrayOfString[j]);
/*    */     }
/* 75 */     return stringBuilder.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public STXmlDataType.Enum getXmlDataType() {
/* 80 */     return this.ctXmlColumnPr.getXmlDataType();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\helpers\XSSFXmlColumnPr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */