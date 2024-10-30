/*     */ package org.apache.poi.xwpf.usermodel;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Arrays;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.POIXMLRelation;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XWPFPictureData
/*     */   extends POIXMLDocumentPart
/*     */ {
/*  48 */   protected static final POIXMLRelation[] RELATIONS = new POIXMLRelation[13]; static {
/*  49 */     RELATIONS[2] = XWPFRelation.IMAGE_EMF;
/*  50 */     RELATIONS[3] = XWPFRelation.IMAGE_WMF;
/*  51 */     RELATIONS[4] = XWPFRelation.IMAGE_PICT;
/*  52 */     RELATIONS[5] = XWPFRelation.IMAGE_JPEG;
/*  53 */     RELATIONS[6] = XWPFRelation.IMAGE_PNG;
/*  54 */     RELATIONS[7] = XWPFRelation.IMAGE_DIB;
/*  55 */     RELATIONS[8] = XWPFRelation.IMAGE_GIF;
/*  56 */     RELATIONS[9] = XWPFRelation.IMAGE_TIFF;
/*  57 */     RELATIONS[10] = XWPFRelation.IMAGE_EPS;
/*  58 */     RELATIONS[11] = XWPFRelation.IMAGE_BMP;
/*  59 */     RELATIONS[12] = XWPFRelation.IMAGE_WPG;
/*     */   }
/*     */   
/*  62 */   private Long checksum = null;
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
/*     */   public XWPFPictureData(PackagePart paramPackagePart) {
/*  79 */     super(paramPackagePart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public XWPFPictureData(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) {
/*  87 */     this(paramPackagePart);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onDocumentRead() throws IOException {
/*  92 */     super.onDocumentRead();
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
/* 110 */       return IOUtils.toByteArray(getPackagePart().getInputStream());
/* 111 */     } catch (IOException iOException) {
/* 112 */       throw new POIXMLException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFileName() {
/* 122 */     String str = getPackagePart().getPartName().getName();
/* 123 */     return str.substring(str.lastIndexOf('/') + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String suggestFileExtension() {
/* 132 */     return getPackagePart().getPartName().getExtension();
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
/* 147 */     String str = getPackagePart().getContentType();
/* 148 */     for (byte b = 0; b < RELATIONS.length; b++) {
/* 149 */       if (RELATIONS[b] != null)
/*     */       {
/*     */ 
/*     */         
/* 153 */         if (RELATIONS[b].getContentType().equals(str))
/* 154 */           return b; 
/*     */       }
/*     */     } 
/* 157 */     return 0;
/*     */   }
/*     */   
/*     */   public Long getChecksum() {
/* 161 */     if (this.checksum == null) {
/* 162 */       byte[] arrayOfByte; InputStream inputStream = null;
/*     */       
/*     */       try {
/* 165 */         inputStream = getPackagePart().getInputStream();
/* 166 */         arrayOfByte = IOUtils.toByteArray(inputStream);
/* 167 */       } catch (IOException iOException) {
/* 168 */         throw new POIXMLException(iOException);
/*     */       } finally {
/*     */         try {
/* 171 */           if (inputStream != null) inputStream.close(); 
/* 172 */         } catch (IOException iOException) {
/* 173 */           throw new POIXMLException(iOException);
/*     */         } 
/*     */       } 
/* 176 */       this.checksum = Long.valueOf(IOUtils.calculateChecksum(arrayOfByte));
/*     */     } 
/* 178 */     return this.checksum;
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
/*     */   public boolean equals(Object paramObject) {
/* 195 */     if (paramObject == this) {
/* 196 */       return true;
/*     */     }
/*     */     
/* 199 */     if (paramObject == null) {
/* 200 */       return false;
/*     */     }
/*     */     
/* 203 */     if (!(paramObject instanceof XWPFPictureData)) {
/* 204 */       return false;
/*     */     }
/*     */     
/* 207 */     XWPFPictureData xWPFPictureData = (XWPFPictureData)paramObject;
/* 208 */     PackagePart packagePart1 = xWPFPictureData.getPackagePart();
/* 209 */     PackagePart packagePart2 = getPackagePart();
/*     */     
/* 211 */     if ((packagePart1 != null && packagePart2 == null) || (packagePart1 == null && packagePart2 != null))
/*     */     {
/* 213 */       return false;
/*     */     }
/*     */     
/* 216 */     if (packagePart2 != null) {
/* 217 */       OPCPackage oPCPackage1 = packagePart1.getPackage();
/* 218 */       OPCPackage oPCPackage2 = packagePart2.getPackage();
/*     */       
/* 220 */       if ((oPCPackage1 != null && oPCPackage2 == null) || (oPCPackage1 == null && oPCPackage2 != null))
/*     */       {
/* 222 */         return false;
/*     */       }
/* 224 */       if (oPCPackage2 != null)
/*     */       {
/* 226 */         if (!oPCPackage2.equals(oPCPackage1)) {
/* 227 */           return false;
/*     */         }
/*     */       }
/*     */     } 
/*     */     
/* 232 */     Long long_1 = xWPFPictureData.getChecksum();
/* 233 */     Long long_2 = getChecksum();
/*     */     
/* 235 */     if (!long_2.equals(long_1)) {
/* 236 */       return false;
/*     */     }
/* 238 */     return Arrays.equals(getData(), xWPFPictureData.getData());
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 243 */     return getChecksum().hashCode();
/*     */   }
/*     */   
/*     */   protected void prepareForCommit() {}
/*     */   
/*     */   protected XWPFPictureData() {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFPictureData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */