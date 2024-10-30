/*     */ package org.apache.poi.openxml4j.opc.internal.marshallers;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.net.URI;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipOutputStream;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackagePartName;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
/*     */ import org.apache.poi.openxml4j.opc.PackagingURIHelper;
/*     */ import org.apache.poi.openxml4j.opc.StreamHelper;
/*     */ import org.apache.poi.openxml4j.opc.TargetMode;
/*     */ import org.apache.poi.openxml4j.opc.internal.PartMarshaller;
/*     */ import org.apache.poi.openxml4j.opc.internal.ZipHelper;
/*     */ import org.apache.poi.util.DocumentHelper;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.xssf.usermodel.XSSFRelation;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
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
/*     */ public final class ZipPartMarshaller
/*     */   implements PartMarshaller
/*     */ {
/*  51 */   private static POILogger logger = POILogFactory.getLogger(ZipPartMarshaller.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean marshall(PackagePart paramPackagePart, OutputStream paramOutputStream) throws OpenXML4JException {
/*  61 */     if (!(paramOutputStream instanceof ZipOutputStream)) {
/*  62 */       logger.log(7, new Object[] { "Unexpected class " + paramOutputStream.getClass().getName() });
/*  63 */       throw new OpenXML4JException("ZipOutputStream expected !");
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  70 */     if (paramPackagePart.getSize() == 0L && paramPackagePart.getPartName().getName().equals(XSSFRelation.SHARED_STRINGS.getDefaultFileName())) {
/*  71 */       return true;
/*     */     }
/*     */     
/*  74 */     ZipOutputStream zipOutputStream = (ZipOutputStream)paramOutputStream;
/*  75 */     ZipEntry zipEntry = new ZipEntry(ZipHelper.getZipItemNameFromOPCName(paramPackagePart.getPartName().getURI().getPath()));
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  80 */       zipOutputStream.putNextEntry(zipEntry);
/*     */ 
/*     */       
/*  83 */       InputStream inputStream = paramPackagePart.getInputStream();
/*  84 */       byte[] arrayOfByte = new byte[8192];
/*  85 */       while (inputStream.available() > 0) {
/*  86 */         int i = inputStream.read(arrayOfByte);
/*  87 */         if (i == -1) {
/*     */           break;
/*     */         }
/*     */         
/*  91 */         zipOutputStream.write(arrayOfByte, 0, i);
/*     */       } 
/*  93 */       zipOutputStream.closeEntry();
/*  94 */     } catch (IOException iOException) {
/*  95 */       logger.log(7, new Object[] { "Cannot write: " + paramPackagePart.getPartName() + ": in ZIP", iOException });
/*     */       
/*  97 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 101 */     if (paramPackagePart.hasRelationships()) {
/* 102 */       PackagePartName packagePartName = PackagingURIHelper.getRelationshipPartName(paramPackagePart.getPartName());
/*     */ 
/*     */       
/* 105 */       marshallRelationshipPart(paramPackagePart.getRelationships(), packagePartName, zipOutputStream);
/*     */     } 
/*     */ 
/*     */     
/* 109 */     return true;
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
/*     */   public static boolean marshallRelationshipPart(PackageRelationshipCollection paramPackageRelationshipCollection, PackagePartName paramPackagePartName, ZipOutputStream paramZipOutputStream) {
/* 127 */     Document document = DocumentHelper.createDocument();
/*     */ 
/*     */     
/* 130 */     Element element = document.createElementNS("http://schemas.openxmlformats.org/package/2006/relationships", "Relationships");
/* 131 */     document.appendChild(element);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 139 */     URI uRI = PackagingURIHelper.getSourcePartUriFromRelationshipPartUri(paramPackagePartName.getURI());
/*     */ 
/*     */     
/* 142 */     for (PackageRelationship packageRelationship : paramPackageRelationshipCollection) {
/*     */       String str;
/* 144 */       Element element1 = document.createElementNS("http://schemas.openxmlformats.org/package/2006/relationships", "Relationship");
/* 145 */       element.appendChild(element1);
/*     */ 
/*     */       
/* 148 */       element1.setAttribute("Id", packageRelationship.getId());
/*     */ 
/*     */       
/* 151 */       element1.setAttribute("Type", packageRelationship.getRelationshipType());
/*     */ 
/*     */ 
/*     */       
/* 155 */       URI uRI1 = packageRelationship.getTargetURI();
/* 156 */       if (packageRelationship.getTargetMode() == TargetMode.EXTERNAL) {
/*     */ 
/*     */         
/* 159 */         str = uRI1.toString();
/*     */ 
/*     */         
/* 162 */         element1.setAttribute("TargetMode", "External");
/*     */       } else {
/* 164 */         URI uRI2 = packageRelationship.getTargetURI();
/* 165 */         str = PackagingURIHelper.relativizeURI(uRI, uRI2, true).toString();
/*     */       } 
/*     */       
/* 168 */       element1.setAttribute("Target", str);
/*     */     } 
/*     */     
/* 171 */     document.normalize();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 177 */     ZipEntry zipEntry = new ZipEntry(ZipHelper.getZipURIFromOPCName(paramPackagePartName.getURI().toASCIIString()).getPath());
/*     */     
/*     */     try {
/* 180 */       paramZipOutputStream.putNextEntry(zipEntry);
/* 181 */       if (!StreamHelper.saveXmlInStream(document, paramZipOutputStream)) {
/* 182 */         return false;
/*     */       }
/* 184 */       paramZipOutputStream.closeEntry();
/* 185 */     } catch (IOException iOException) {
/* 186 */       logger.log(7, new Object[] { "Cannot create zip entry " + paramPackagePartName, iOException });
/* 187 */       return false;
/*     */     } 
/* 189 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\internal\marshallers\ZipPartMarshaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */