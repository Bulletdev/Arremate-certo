/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.ss.usermodel.Table;
/*     */ import org.apache.poi.ss.util.CellReference;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.StringUtil;
/*     */ import org.apache.poi.xssf.usermodel.helpers.XSSFXmlColumnPr;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTable;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.TableDocument;
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
/*     */ 
/*     */ 
/*     */ public class XSSFTable
/*     */   extends POIXMLDocumentPart
/*     */   implements Table
/*     */ {
/*     */   private CTTable ctTable;
/*     */   private List<XSSFXmlColumnPr> xmlColumnPr;
/*     */   private CTTableColumn[] ctColumns;
/*     */   private HashMap<String, Integer> columnMap;
/*     */   private CellReference startCellReference;
/*     */   private CellReference endCellReference;
/*     */   private String commonXPath;
/*     */   
/*     */   public XSSFTable() {
/*  69 */     this.ctTable = CTTable.Factory.newInstance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFTable(PackagePart paramPackagePart) throws IOException {
/*  76 */     super(paramPackagePart);
/*  77 */     readFrom(paramPackagePart.getInputStream());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public XSSFTable(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException {
/*  85 */     this(paramPackagePart);
/*     */   }
/*     */   
/*     */   public void readFrom(InputStream paramInputStream) throws IOException {
/*     */     try {
/*  90 */       TableDocument tableDocument = TableDocument.Factory.parse(paramInputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*  91 */       this.ctTable = tableDocument.getTable();
/*  92 */     } catch (XmlException xmlException) {
/*  93 */       throw new IOException(xmlException.getLocalizedMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   public XSSFSheet getXSSFSheet() {
/*  98 */     return (XSSFSheet)getParent();
/*     */   }
/*     */   
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/* 102 */     updateHeaders();
/*     */     
/* 104 */     TableDocument tableDocument = TableDocument.Factory.newInstance();
/* 105 */     tableDocument.setTable(this.ctTable);
/* 106 */     tableDocument.save(paramOutputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void commit() throws IOException {
/* 111 */     PackagePart packagePart = getPackagePart();
/* 112 */     OutputStream outputStream = packagePart.getOutputStream();
/* 113 */     writeTo(outputStream);
/* 114 */     outputStream.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal(since = "POI 3.15 beta 3")
/*     */   public CTTable getCTTable() {
/* 122 */     return this.ctTable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean mapsTo(long paramLong) {
/* 131 */     List<XSSFXmlColumnPr> list = getXmlColumnPrs();
/*     */     
/* 133 */     for (XSSFXmlColumnPr xSSFXmlColumnPr : list) {
/* 134 */       if (xSSFXmlColumnPr.getMapId() == paramLong) {
/* 135 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 139 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CTTableColumn[] getTableColumns() {
/* 148 */     if (this.ctColumns == null) {
/* 149 */       this.ctColumns = this.ctTable.getTableColumns().getTableColumnArray();
/*     */     }
/* 151 */     return this.ctColumns;
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
/*     */   public String getCommonXpath() {
/* 163 */     if (this.commonXPath == null) {
/* 164 */       String[] arrayOfString = new String[0];
/* 165 */       for (CTTableColumn cTTableColumn : getTableColumns()) {
/* 166 */         if (cTTableColumn.getXmlColumnPr() != null) {
/* 167 */           String str = cTTableColumn.getXmlColumnPr().getXpath();
/* 168 */           String[] arrayOfString1 = str.split("/");
/* 169 */           if (arrayOfString.length == 0) {
/* 170 */             arrayOfString = arrayOfString1;
/*     */           } else {
/*     */             
/* 173 */             int i = Math.min(arrayOfString.length, arrayOfString1.length);
/*     */             
/* 175 */             for (byte b = 0; b < i; b++) {
/* 176 */               if (!arrayOfString[b].equals(arrayOfString1[b])) {
/* 177 */                 List list = Arrays.<String>asList(arrayOfString).subList(0, b);
/*     */                 
/* 179 */                 String[] arrayOfString2 = new String[0];
/*     */                 
/* 181 */                 arrayOfString = (String[])list.toArray((Object[])arrayOfString2);
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 189 */       arrayOfString[0] = "";
/* 190 */       this.commonXPath = StringUtil.join((Object[])arrayOfString, "/");
/*     */     } 
/*     */     
/* 193 */     return this.commonXPath;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<XSSFXmlColumnPr> getXmlColumnPrs() {
/* 204 */     if (this.xmlColumnPr == null) {
/* 205 */       this.xmlColumnPr = new ArrayList<XSSFXmlColumnPr>();
/* 206 */       for (CTTableColumn cTTableColumn : getTableColumns()) {
/* 207 */         if (cTTableColumn.getXmlColumnPr() != null) {
/* 208 */           XSSFXmlColumnPr xSSFXmlColumnPr = new XSSFXmlColumnPr(this, cTTableColumn, cTTableColumn.getXmlColumnPr());
/* 209 */           this.xmlColumnPr.add(xSSFXmlColumnPr);
/*     */         } 
/*     */       } 
/*     */     } 
/* 213 */     return this.xmlColumnPr;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 220 */     return this.ctTable.getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String paramString) {
/* 227 */     if (paramString == null) {
/* 228 */       this.ctTable.unsetName();
/*     */       return;
/*     */     } 
/* 231 */     this.ctTable.setName(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDisplayName() {
/* 238 */     return this.ctTable.getDisplayName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDisplayName(String paramString) {
/* 245 */     this.ctTable.setDisplayName(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getNumberOfMappedColumns() {
/* 252 */     return this.ctTable.getTableColumns().getCount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getNumerOfMappedColumns() {
/* 260 */     return getNumberOfMappedColumns();
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
/*     */   public CellReference getStartCellReference() {
/* 274 */     if (this.startCellReference == null) {
/* 275 */       setCellReferences();
/*     */     }
/* 277 */     return this.startCellReference;
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
/*     */   public CellReference getEndCellReference() {
/* 289 */     if (this.endCellReference == null) {
/* 290 */       setCellReferences();
/*     */     }
/* 292 */     return this.endCellReference;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setCellReferences() {
/* 299 */     String str = this.ctTable.getRef();
/* 300 */     if (str != null) {
/* 301 */       String[] arrayOfString = str.split(":", 2);
/* 302 */       String str1 = arrayOfString[0];
/* 303 */       String str2 = arrayOfString[1];
/* 304 */       this.startCellReference = new CellReference(str1);
/* 305 */       this.endCellReference = new CellReference(str2);
/*     */     } 
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
/*     */   public void updateReferences() {
/* 321 */     this.startCellReference = null;
/* 322 */     this.endCellReference = null;
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
/*     */   public int getRowCount() {
/* 335 */     CellReference cellReference1 = getStartCellReference();
/* 336 */     CellReference cellReference2 = getEndCellReference();
/*     */     
/* 338 */     int i = 0;
/* 339 */     if (cellReference1 != null && cellReference2 != null) {
/* 340 */       i = cellReference2.getRow() - cellReference1.getRow() + 1;
/*     */     }
/* 342 */     return i;
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
/*     */   public void updateHeaders() {
/* 355 */     XSSFSheet xSSFSheet = (XSSFSheet)getParent();
/* 356 */     CellReference cellReference = getStartCellReference();
/* 357 */     if (cellReference == null)
/*     */       return; 
/* 359 */     int i = cellReference.getRow();
/* 360 */     short s = cellReference.getCol();
/* 361 */     XSSFRow xSSFRow = xSSFSheet.getRow(i);
/*     */     
/* 363 */     if (xSSFRow != null && xSSFRow.getCTRow().validate()) {
/* 364 */       short s1 = s;
/* 365 */       for (CTTableColumn cTTableColumn : getCTTable().getTableColumns().getTableColumnArray()) {
/* 366 */         XSSFCell xSSFCell = xSSFRow.getCell(s1);
/* 367 */         if (xSSFCell != null) {
/* 368 */           cTTableColumn.setName(xSSFCell.getStringCellValue());
/*     */         }
/* 370 */         s1++;
/*     */       } 
/* 372 */       this.ctColumns = null;
/* 373 */       this.columnMap = null;
/* 374 */       this.xmlColumnPr = null;
/* 375 */       this.commonXPath = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static String caseInsensitive(String paramString) {
/* 380 */     return paramString.toUpperCase(Locale.ROOT);
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
/*     */   public int findColumnIndex(String paramString) {
/* 396 */     if (paramString == null) return -1; 
/* 397 */     if (this.columnMap == null) {
/*     */       
/* 399 */       int i = (getTableColumns()).length;
/* 400 */       this.columnMap = new HashMap<String, Integer>(i * 3 / 2);
/*     */       
/* 402 */       byte b = 0;
/* 403 */       for (CTTableColumn cTTableColumn : getTableColumns()) {
/* 404 */         String str = cTTableColumn.getName();
/* 405 */         this.columnMap.put(caseInsensitive(str), Integer.valueOf(b));
/* 406 */         b++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 411 */     Integer integer = this.columnMap.get(caseInsensitive(paramString.replace("'", "")));
/* 412 */     return (integer == null) ? -1 : integer.intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSheetName() {
/* 419 */     return getXSSFSheet().getSheetName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isHasTotalsRow() {
/* 426 */     return this.ctTable.getTotalsRowShown();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getStartColIndex() {
/* 433 */     return getStartCellReference().getCol();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getStartRowIndex() {
/* 440 */     return getStartCellReference().getRow();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getEndColIndex() {
/* 447 */     return getEndCellReference().getCol();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getEndRowIndex() {
/* 454 */     return getEndCellReference().getRow();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */