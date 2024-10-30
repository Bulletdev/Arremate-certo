/*     */ package org.apache.poi.xssf.eventusermodel;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackagePartName;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
/*     */ import org.apache.poi.openxml4j.opc.PackagingURIHelper;
/*     */ import org.apache.poi.xssf.model.CommentsTable;
/*     */ import org.apache.poi.xssf.model.SharedStringsTable;
/*     */ import org.apache.poi.xssf.model.StylesTable;
/*     */ import org.apache.poi.xssf.model.ThemesTable;
/*     */ import org.apache.poi.xssf.usermodel.XSSFDrawing;
/*     */ import org.apache.poi.xssf.usermodel.XSSFRelation;
/*     */ import org.apache.poi.xssf.usermodel.XSSFShape;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument;
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
/*     */ public class XSSFReader
/*     */ {
/*     */   private OPCPackage pkg;
/*     */   private PackagePart workbookPart;
/*     */   
/*     */   public XSSFReader(OPCPackage paramOPCPackage) throws IOException, OpenXML4JException {
/*  67 */     this.pkg = paramOPCPackage;
/*     */     
/*  69 */     PackageRelationship packageRelationship = this.pkg.getRelationshipsByType("http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument").getRelationship(0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  75 */     if (packageRelationship == null) {
/*  76 */       if (this.pkg.getRelationshipsByType("http://purl.oclc.org/ooxml/officeDocument/relationships/officeDocument").getRelationship(0) != null)
/*     */       {
/*  78 */         throw new POIXMLException("Strict OOXML isn't currently supported, please see bug #57699");
/*     */       }
/*     */       
/*  81 */       throw new POIXMLException("OOXML file structure broken/invalid - no core document found!");
/*     */     } 
/*     */ 
/*     */     
/*  85 */     this.workbookPart = this.pkg.getPart(packageRelationship);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SharedStringsTable getSharedStringsTable() throws IOException, InvalidFormatException {
/*  95 */     ArrayList<PackagePart> arrayList = this.pkg.getPartsByContentType(XSSFRelation.SHARED_STRINGS.getContentType());
/*  96 */     return (arrayList.size() == 0) ? null : new SharedStringsTable(arrayList.get(0), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StylesTable getStylesTable() throws IOException, InvalidFormatException {
/* 104 */     ArrayList<PackagePart> arrayList = this.pkg.getPartsByContentType(XSSFRelation.STYLES.getContentType());
/* 105 */     if (arrayList.size() == 0) return null;
/*     */ 
/*     */     
/* 108 */     StylesTable stylesTable = new StylesTable(arrayList.get(0), null);
/* 109 */     arrayList = this.pkg.getPartsByContentType(XSSFRelation.THEME.getContentType());
/* 110 */     if (arrayList.size() != 0) {
/* 111 */       stylesTable.setTheme(new ThemesTable(arrayList.get(0), null));
/*     */     }
/* 113 */     return stylesTable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getSharedStringsData() throws IOException, InvalidFormatException {
/* 123 */     return XSSFRelation.SHARED_STRINGS.getContents(this.workbookPart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getStylesData() throws IOException, InvalidFormatException {
/* 131 */     return XSSFRelation.STYLES.getContents(this.workbookPart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getThemesData() throws IOException, InvalidFormatException {
/* 139 */     return XSSFRelation.THEME.getContents(this.workbookPart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getWorkbookData() throws IOException, InvalidFormatException {
/* 148 */     return this.workbookPart.getInputStream();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getSheet(String paramString) throws IOException, InvalidFormatException {
/* 157 */     PackageRelationship packageRelationship = this.workbookPart.getRelationship(paramString);
/* 158 */     if (packageRelationship == null) {
/* 159 */       throw new IllegalArgumentException("No Sheet found with r:id " + paramString);
/*     */     }
/*     */     
/* 162 */     PackagePartName packagePartName = PackagingURIHelper.createPartName(packageRelationship.getTargetURI());
/* 163 */     PackagePart packagePart = this.pkg.getPart(packagePartName);
/* 164 */     if (packagePart == null) {
/* 165 */       throw new IllegalArgumentException("No data found for Sheet with r:id " + paramString);
/*     */     }
/* 167 */     return packagePart.getInputStream();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<InputStream> getSheetsData() throws IOException, InvalidFormatException {
/* 178 */     return new SheetIterator(this.workbookPart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class SheetIterator
/*     */     implements Iterator<InputStream>
/*     */   {
/*     */     private Map<String, PackagePart> sheetMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private CTSheet ctSheet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Iterator<CTSheet> sheetIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private SheetIterator(PackagePart param1PackagePart) throws IOException {
/*     */       try {
/* 215 */         this.sheetMap = new HashMap<String, PackagePart>();
/* 216 */         for (PackageRelationship packageRelationship : param1PackagePart.getRelationships()) {
/* 217 */           if (packageRelationship.getRelationshipType().equals(XSSFRelation.WORKSHEET.getRelation()) || packageRelationship.getRelationshipType().equals(XSSFRelation.CHARTSHEET.getRelation())) {
/*     */             
/* 219 */             PackagePartName packagePartName = PackagingURIHelper.createPartName(packageRelationship.getTargetURI());
/* 220 */             this.sheetMap.put(packageRelationship.getId(), param1PackagePart.getPackage().getPart(packagePartName));
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 225 */         CTWorkbook cTWorkbook = WorkbookDocument.Factory.parse(param1PackagePart.getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getWorkbook();
/* 226 */         this.sheetIterator = cTWorkbook.getSheets().getSheetList().iterator();
/* 227 */       } catch (InvalidFormatException invalidFormatException) {
/* 228 */         throw new POIXMLException(invalidFormatException);
/* 229 */       } catch (XmlException xmlException) {
/* 230 */         throw new POIXMLException(xmlException);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 240 */       return this.sheetIterator.hasNext();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public InputStream next() {
/* 249 */       this.ctSheet = this.sheetIterator.next();
/*     */       
/* 251 */       String str = this.ctSheet.getId();
/*     */       try {
/* 253 */         PackagePart packagePart = this.sheetMap.get(str);
/* 254 */         return packagePart.getInputStream();
/* 255 */       } catch (IOException iOException) {
/* 256 */         throw new POIXMLException(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getSheetName() {
/* 266 */       return this.ctSheet.getName();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public CommentsTable getSheetComments() {
/* 274 */       PackagePart packagePart = getSheetPart();
/*     */ 
/*     */       
/*     */       try {
/* 278 */         PackageRelationshipCollection packageRelationshipCollection = packagePart.getRelationshipsByType(XSSFRelation.SHEET_COMMENTS.getRelation());
/*     */         
/* 280 */         if (packageRelationshipCollection.size() > 0) {
/* 281 */           PackageRelationship packageRelationship = packageRelationshipCollection.getRelationship(0);
/* 282 */           PackagePartName packagePartName = PackagingURIHelper.createPartName(packageRelationship.getTargetURI());
/* 283 */           PackagePart packagePart1 = packagePart.getPackage().getPart(packagePartName);
/* 284 */           return new CommentsTable(packagePart1, packageRelationship);
/*     */         } 
/* 286 */       } catch (InvalidFormatException invalidFormatException) {
/* 287 */         return null;
/* 288 */       } catch (IOException iOException) {
/* 289 */         return null;
/*     */       } 
/* 291 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List<XSSFShape> getShapes() {
/* 299 */       PackagePart packagePart = getSheetPart();
/* 300 */       LinkedList<XSSFShape> linkedList = new LinkedList();
/*     */       
/*     */       try {
/* 303 */         PackageRelationshipCollection packageRelationshipCollection = packagePart.getRelationshipsByType(XSSFRelation.DRAWINGS.getRelation());
/* 304 */         for (byte b = 0; b < packageRelationshipCollection.size(); b++) {
/* 305 */           PackageRelationship packageRelationship = packageRelationshipCollection.getRelationship(b);
/* 306 */           PackagePartName packagePartName = PackagingURIHelper.createPartName(packageRelationship.getTargetURI());
/* 307 */           PackagePart packagePart1 = packagePart.getPackage().getPart(packagePartName);
/* 308 */           XSSFDrawing xSSFDrawing = new XSSFDrawing(packagePart1, packageRelationship);
/* 309 */           for (XSSFShape xSSFShape : xSSFDrawing.getShapes()) {
/* 310 */             linkedList.add(xSSFShape);
/*     */           }
/*     */         } 
/* 313 */       } catch (XmlException xmlException) {
/* 314 */         return null;
/* 315 */       } catch (InvalidFormatException invalidFormatException) {
/* 316 */         return null;
/* 317 */       } catch (IOException iOException) {
/* 318 */         return null;
/*     */       } 
/* 320 */       return linkedList;
/*     */     }
/*     */     
/*     */     public PackagePart getSheetPart() {
/* 324 */       String str = this.ctSheet.getId();
/* 325 */       return this.sheetMap.get(str);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void remove() {
/* 332 */       throw new IllegalStateException("Not supported");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\eventusermodel\XSSFReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */