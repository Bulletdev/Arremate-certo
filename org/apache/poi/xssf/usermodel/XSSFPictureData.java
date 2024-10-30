/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.POIXMLRelation;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.ss.usermodel.PictureData;
/*     */ import org.apache.poi.util.IOUtils;
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
/*     */ public class XSSFPictureData
/*     */   extends POIXMLDocumentPart
/*     */   implements PictureData
/*     */ {
/*  42 */   protected static final POIXMLRelation[] RELATIONS = new POIXMLRelation[13]; static {
/*  43 */     RELATIONS[2] = XSSFRelation.IMAGE_EMF;
/*  44 */     RELATIONS[3] = XSSFRelation.IMAGE_WMF;
/*  45 */     RELATIONS[4] = XSSFRelation.IMAGE_PICT;
/*  46 */     RELATIONS[5] = XSSFRelation.IMAGE_JPEG;
/*  47 */     RELATIONS[6] = XSSFRelation.IMAGE_PNG;
/*  48 */     RELATIONS[7] = XSSFRelation.IMAGE_DIB;
/*  49 */     RELATIONS[8] = XSSFRelation.IMAGE_GIF;
/*  50 */     RELATIONS[9] = XSSFRelation.IMAGE_TIFF;
/*  51 */     RELATIONS[10] = XSSFRelation.IMAGE_EPS;
/*  52 */     RELATIONS[11] = XSSFRelation.IMAGE_BMP;
/*  53 */     RELATIONS[12] = XSSFRelation.IMAGE_WPG;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected XSSFPictureData() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected XSSFPictureData(PackagePart paramPackagePart) {
/*  73 */     super(paramPackagePart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected XSSFPictureData(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) {
/*  81 */     this(paramPackagePart);
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
/*     */   public byte[] getData() {
/*     */     try {
/*  99 */       return IOUtils.toByteArray(getPackagePart().getInputStream());
/* 100 */     } catch (IOException iOException) {
/* 101 */       throw new POIXMLException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String suggestFileExtension() {
/* 111 */     return getPackagePart().getPartName().getExtension();
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
/*     */   public int getPictureType() {
/* 126 */     String str = getPackagePart().getContentType();
/* 127 */     for (byte b = 0; b < RELATIONS.length; b++) {
/* 128 */       if (RELATIONS[b] != null)
/*     */       {
/* 130 */         if (RELATIONS[b].getContentType().equals(str))
/* 131 */           return b; 
/*     */       }
/*     */     } 
/* 134 */     return 0;
/*     */   }
/*     */   
/*     */   public String getMimeType() {
/* 138 */     return getPackagePart().getContentType();
/*     */   }
/*     */   
/*     */   protected void prepareForCommit() {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFPictureData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */