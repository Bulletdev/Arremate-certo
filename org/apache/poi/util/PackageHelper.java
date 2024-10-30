/*     */ package org.apache.poi.util;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.net.URI;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackagePartName;
/*     */ import org.apache.poi.openxml4j.opc.PackageProperties;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
/*     */ import org.apache.poi.openxml4j.opc.PackagingURIHelper;
/*     */ import org.apache.poi.openxml4j.opc.TargetMode;
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
/*     */ public final class PackageHelper
/*     */ {
/*     */   public static OPCPackage open(InputStream paramInputStream) throws IOException {
/*     */     try {
/*  37 */       return OPCPackage.open(paramInputStream);
/*  38 */     } catch (InvalidFormatException invalidFormatException) {
/*  39 */       throw new POIXMLException(invalidFormatException);
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
/*     */   public static OPCPackage clone(OPCPackage paramOPCPackage, File paramFile) throws OpenXML4JException, IOException {
/*  52 */     String str = paramFile.getAbsolutePath();
/*     */     
/*  54 */     OPCPackage oPCPackage = OPCPackage.create(str);
/*  55 */     PackageRelationshipCollection packageRelationshipCollection = paramOPCPackage.getRelationships();
/*  56 */     for (PackageRelationship packageRelationship : packageRelationshipCollection) {
/*  57 */       PackagePart packagePart1 = paramOPCPackage.getPart(packageRelationship);
/*     */       
/*  59 */       if (packageRelationship.getRelationshipType().equals("http://schemas.openxmlformats.org/package/2006/relationships/metadata/core-properties")) {
/*  60 */         copyProperties(paramOPCPackage.getPackageProperties(), oPCPackage.getPackageProperties());
/*     */         continue;
/*     */       } 
/*  63 */       oPCPackage.addRelationship(packagePart1.getPartName(), packageRelationship.getTargetMode(), packageRelationship.getRelationshipType());
/*  64 */       PackagePart packagePart2 = oPCPackage.createPart(packagePart1.getPartName(), packagePart1.getContentType());
/*     */       
/*  66 */       OutputStream outputStream = packagePart2.getOutputStream();
/*  67 */       IOUtils.copy(packagePart1.getInputStream(), outputStream);
/*  68 */       outputStream.close();
/*     */       
/*  70 */       if (packagePart1.hasRelationships()) {
/*  71 */         copy(paramOPCPackage, packagePart1, oPCPackage, packagePart2);
/*     */       }
/*     */     } 
/*  74 */     oPCPackage.close();
/*     */ 
/*     */     
/*  77 */     (new File(str)).deleteOnExit();
/*  78 */     return OPCPackage.open(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void copy(OPCPackage paramOPCPackage1, PackagePart paramPackagePart1, OPCPackage paramOPCPackage2, PackagePart paramPackagePart2) throws OpenXML4JException, IOException {
/*  85 */     PackageRelationshipCollection packageRelationshipCollection = paramPackagePart1.getRelationships();
/*  86 */     if (packageRelationshipCollection != null) for (PackageRelationship packageRelationship : packageRelationshipCollection) {
/*     */         
/*  88 */         if (packageRelationship.getTargetMode() == TargetMode.EXTERNAL) {
/*  89 */           paramPackagePart2.addExternalRelationship(packageRelationship.getTargetURI().toString(), packageRelationship.getRelationshipType(), packageRelationship.getId());
/*     */           
/*     */           continue;
/*     */         } 
/*  93 */         URI uRI = packageRelationship.getTargetURI();
/*     */         
/*  95 */         if (uRI.getRawFragment() != null) {
/*  96 */           paramPackagePart2.addRelationship(uRI, packageRelationship.getTargetMode(), packageRelationship.getRelationshipType(), packageRelationship.getId());
/*     */           continue;
/*     */         } 
/*  99 */         PackagePartName packagePartName = PackagingURIHelper.createPartName(packageRelationship.getTargetURI());
/* 100 */         PackagePart packagePart = paramOPCPackage1.getPart(packagePartName);
/* 101 */         paramPackagePart2.addRelationship(packagePart.getPartName(), packageRelationship.getTargetMode(), packageRelationship.getRelationshipType(), packageRelationship.getId());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 107 */         if (!paramOPCPackage2.containPart(packagePart.getPartName())) {
/* 108 */           PackagePart packagePart1 = paramOPCPackage2.createPart(packagePart.getPartName(), packagePart.getContentType());
/* 109 */           OutputStream outputStream = packagePart1.getOutputStream();
/* 110 */           IOUtils.copy(packagePart.getInputStream(), outputStream);
/* 111 */           outputStream.close();
/* 112 */           copy(paramOPCPackage1, packagePart, paramOPCPackage2, packagePart1);
/*     */         } 
/*     */       } 
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void copyProperties(PackageProperties paramPackageProperties1, PackageProperties paramPackageProperties2) {
/* 124 */     paramPackageProperties2.setCategoryProperty((String)paramPackageProperties1.getCategoryProperty().getValue());
/* 125 */     paramPackageProperties2.setContentStatusProperty((String)paramPackageProperties1.getContentStatusProperty().getValue());
/* 126 */     paramPackageProperties2.setContentTypeProperty((String)paramPackageProperties1.getContentTypeProperty().getValue());
/* 127 */     paramPackageProperties2.setCreatorProperty((String)paramPackageProperties1.getCreatorProperty().getValue());
/* 128 */     paramPackageProperties2.setDescriptionProperty((String)paramPackageProperties1.getDescriptionProperty().getValue());
/* 129 */     paramPackageProperties2.setIdentifierProperty((String)paramPackageProperties1.getIdentifierProperty().getValue());
/* 130 */     paramPackageProperties2.setKeywordsProperty((String)paramPackageProperties1.getKeywordsProperty().getValue());
/* 131 */     paramPackageProperties2.setLanguageProperty((String)paramPackageProperties1.getLanguageProperty().getValue());
/* 132 */     paramPackageProperties2.setRevisionProperty((String)paramPackageProperties1.getRevisionProperty().getValue());
/* 133 */     paramPackageProperties2.setSubjectProperty((String)paramPackageProperties1.getSubjectProperty().getValue());
/* 134 */     paramPackageProperties2.setTitleProperty((String)paramPackageProperties1.getTitleProperty().getValue());
/* 135 */     paramPackageProperties2.setVersionProperty((String)paramPackageProperties1.getVersionProperty().getValue());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\PackageHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */