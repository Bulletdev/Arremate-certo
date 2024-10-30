/*     */ package org.apache.poi.xssf.model;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcCell;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CalcChainDocument;
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
/*     */ public class CalculationChain
/*     */   extends POIXMLDocumentPart
/*     */ {
/*     */   private CTCalcChain chain;
/*     */   
/*     */   public CalculationChain() {
/*  44 */     this.chain = CTCalcChain.Factory.newInstance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CalculationChain(PackagePart paramPackagePart) throws IOException {
/*  51 */     super(paramPackagePart);
/*  52 */     readFrom(paramPackagePart.getInputStream());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public CalculationChain(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException {
/*  60 */     this(paramPackagePart);
/*     */   }
/*     */   
/*     */   public void readFrom(InputStream paramInputStream) throws IOException {
/*     */     try {
/*  65 */       CalcChainDocument calcChainDocument = CalcChainDocument.Factory.parse(paramInputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*  66 */       this.chain = calcChainDocument.getCalcChain();
/*  67 */     } catch (XmlException xmlException) {
/*  68 */       throw new IOException(xmlException.getLocalizedMessage());
/*     */     } 
/*     */   }
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/*  72 */     CalcChainDocument calcChainDocument = CalcChainDocument.Factory.newInstance();
/*  73 */     calcChainDocument.setCalcChain(this.chain);
/*  74 */     calcChainDocument.save(paramOutputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void commit() throws IOException {
/*  79 */     PackagePart packagePart = getPackagePart();
/*  80 */     OutputStream outputStream = packagePart.getOutputStream();
/*  81 */     writeTo(outputStream);
/*  82 */     outputStream.close();
/*     */   }
/*     */ 
/*     */   
/*     */   public CTCalcChain getCTCalcChain() {
/*  87 */     return this.chain;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeItem(int paramInt, String paramString) {
/*  98 */     int i = -1;
/*  99 */     CTCalcCell[] arrayOfCTCalcCell = this.chain.getCArray();
/*     */     
/* 101 */     for (byte b = 0; b < arrayOfCTCalcCell.length; b++) {
/*     */       
/* 103 */       if (arrayOfCTCalcCell[b].isSetI()) i = arrayOfCTCalcCell[b].getI();
/*     */       
/* 105 */       if (i == paramInt && arrayOfCTCalcCell[b].getR().equals(paramString)) {
/* 106 */         if (arrayOfCTCalcCell[b].isSetI() && b < arrayOfCTCalcCell.length - 1 && !arrayOfCTCalcCell[b + 1].isSetI()) {
/* 107 */           arrayOfCTCalcCell[b + 1].setI(i);
/*     */         }
/* 109 */         this.chain.removeC(b);
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\model\CalculationChain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */