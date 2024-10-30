/*     */ package org.apache.poi.xssf.model;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.List;
/*     */ import java.util.Vector;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.xssf.usermodel.XSSFSheet;
/*     */ import org.apache.poi.xssf.usermodel.helpers.XSSFSingleXmlCell;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCell;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.SingleXmlCellsDocument;
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
/*     */ public class SingleXmlCells
/*     */   extends POIXMLDocumentPart
/*     */ {
/*     */   private CTSingleXmlCells singleXMLCells;
/*     */   
/*     */   public SingleXmlCells() {
/*  54 */     this.singleXMLCells = CTSingleXmlCells.Factory.newInstance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SingleXmlCells(PackagePart paramPackagePart) throws IOException {
/*  62 */     super(paramPackagePart);
/*  63 */     readFrom(paramPackagePart.getInputStream());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public SingleXmlCells(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException {
/*  71 */     this(paramPackagePart);
/*     */   }
/*     */   
/*     */   public void readFrom(InputStream paramInputStream) throws IOException {
/*     */     try {
/*  76 */       SingleXmlCellsDocument singleXmlCellsDocument = SingleXmlCellsDocument.Factory.parse(paramInputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*  77 */       this.singleXMLCells = singleXmlCellsDocument.getSingleXmlCells();
/*  78 */     } catch (XmlException xmlException) {
/*  79 */       throw new IOException(xmlException.getLocalizedMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   public XSSFSheet getXSSFSheet() {
/*  84 */     return (XSSFSheet)getParent();
/*     */   }
/*     */   
/*     */   protected void writeTo(OutputStream paramOutputStream) throws IOException {
/*  88 */     SingleXmlCellsDocument singleXmlCellsDocument = SingleXmlCellsDocument.Factory.newInstance();
/*  89 */     singleXmlCellsDocument.setSingleXmlCells(this.singleXMLCells);
/*  90 */     singleXmlCellsDocument.save(paramOutputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void commit() throws IOException {
/*  95 */     PackagePart packagePart = getPackagePart();
/*  96 */     OutputStream outputStream = packagePart.getOutputStream();
/*  97 */     writeTo(outputStream);
/*  98 */     outputStream.close();
/*     */   }
/*     */   
/*     */   public CTSingleXmlCells getCTSingleXMLCells() {
/* 102 */     return this.singleXMLCells;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<XSSFSingleXmlCell> getAllSimpleXmlCell() {
/* 110 */     Vector<XSSFSingleXmlCell> vector = new Vector();
/*     */     
/* 112 */     for (CTSingleXmlCell cTSingleXmlCell : this.singleXMLCells.getSingleXmlCellArray()) {
/* 113 */       vector.add(new XSSFSingleXmlCell(cTSingleXmlCell, this));
/*     */     }
/* 115 */     return vector;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\model\SingleXmlCells.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */