/*     */ package org.apache.poi.openxml4j.opc;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Enumeration;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipFile;
/*     */ import java.util.zip.ZipOutputStream;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
/*     */ import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
/*     */ import org.apache.poi.openxml4j.exceptions.ODFNotOfficeXmlFileException;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JRuntimeException;
/*     */ import org.apache.poi.openxml4j.opc.internal.ContentTypeManager;
/*     */ import org.apache.poi.openxml4j.opc.internal.FileHelper;
/*     */ import org.apache.poi.openxml4j.opc.internal.MemoryPackagePart;
/*     */ import org.apache.poi.openxml4j.opc.internal.PartMarshaller;
/*     */ import org.apache.poi.openxml4j.opc.internal.ZipContentTypeManager;
/*     */ import org.apache.poi.openxml4j.opc.internal.ZipHelper;
/*     */ import org.apache.poi.openxml4j.opc.internal.marshallers.ZipPartMarshaller;
/*     */ import org.apache.poi.openxml4j.util.ZipEntrySource;
/*     */ import org.apache.poi.openxml4j.util.ZipFileZipEntrySource;
/*     */ import org.apache.poi.openxml4j.util.ZipInputStreamZipEntrySource;
/*     */ import org.apache.poi.openxml4j.util.ZipSecureFile;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.util.TempFile;
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
/*     */ public final class ZipPackage
/*     */   extends OPCPackage
/*     */ {
/*     */   private static final String MIMETYPE = "mimetype";
/*     */   private static final String SETTINGS_XML = "settings.xml";
/*  59 */   private static final POILogger logger = POILogFactory.getLogger(ZipPackage.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ZipEntrySource zipArchive;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ZipPackage() {
/*  71 */     super(defaultPackageAccess);
/*  72 */     this.zipArchive = null;
/*     */     
/*     */     try {
/*  75 */       this.contentTypeManager = (ContentTypeManager)new ZipContentTypeManager(null, this);
/*  76 */     } catch (InvalidFormatException invalidFormatException) {
/*  77 */       logger.log(5, new Object[] { "Could not parse ZipPackage", invalidFormatException });
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
/*     */ 
/*     */ 
/*     */   
/*     */   ZipPackage(InputStream paramInputStream, PackageAccess paramPackageAccess) throws IOException {
/*  96 */     super(paramPackageAccess);
/*  97 */     ZipSecureFile.ThresholdInputStream thresholdInputStream = ZipHelper.openZipStream(paramInputStream);
/*     */     try {
/*  99 */       this.zipArchive = (ZipEntrySource)new ZipInputStreamZipEntrySource(thresholdInputStream);
/* 100 */     } catch (IOException iOException) {
/*     */       try {
/* 102 */         thresholdInputStream.close();
/* 103 */       } catch (IOException iOException1) {
/* 104 */         throw new IOException("Failed to close zip input stream while cleaning up. " + iOException.getMessage(), iOException1);
/*     */       } 
/* 106 */       throw new IOException("Failed to read zip entry source", iOException);
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
/*     */   ZipPackage(String paramString, PackageAccess paramPackageAccess) throws InvalidOperationException {
/* 120 */     this(new File(paramString), paramPackageAccess);
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
/*     */   ZipPackage(File paramFile, PackageAccess paramPackageAccess) throws InvalidOperationException {
/* 133 */     super(paramPackageAccess);
/*     */     
/*     */     ZipEntrySource zipEntrySource;
/*     */     try {
/* 137 */       ZipFile zipFile = ZipHelper.openZipFile(paramFile);
/* 138 */       ZipFileZipEntrySource zipFileZipEntrySource = new ZipFileZipEntrySource(zipFile);
/* 139 */     } catch (IOException iOException) {
/*     */       
/* 141 */       if (paramPackageAccess == PackageAccess.WRITE) {
/* 142 */         throw new InvalidOperationException("Can't open the specified file: '" + paramFile + "'", iOException);
/*     */       }
/* 144 */       logger.log(7, new Object[] { "Error in zip file " + paramFile + " - falling back to stream processing (i.e. ignoring zip central directory)" });
/* 145 */       zipEntrySource = openZipEntrySourceStream(paramFile);
/*     */     } 
/* 147 */     this.zipArchive = zipEntrySource;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static ZipEntrySource openZipEntrySourceStream(File paramFile) throws InvalidOperationException {
/*     */     FileInputStream fileInputStream;
/*     */     try {
/* 155 */       fileInputStream = new FileInputStream(paramFile);
/* 156 */     } catch (FileNotFoundException fileNotFoundException) {
/*     */       
/* 158 */       throw new InvalidOperationException("Can't open the specified file input stream from file: '" + paramFile + "'", fileNotFoundException);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 164 */       return openZipEntrySourceStream(fileInputStream);
/* 165 */     } catch (Exception exception) {
/*     */       
/*     */       try {
/* 168 */         fileInputStream.close();
/* 169 */       } catch (IOException iOException) {
/* 170 */         throw new InvalidOperationException("Could not close the specified file input stream from file: '" + paramFile + "'", iOException);
/*     */       } 
/* 172 */       throw new InvalidOperationException("Failed to read the file input stream from file: '" + paramFile + "'", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static ZipEntrySource openZipEntrySourceStream(FileInputStream paramFileInputStream) throws InvalidOperationException {
/*     */     ZipSecureFile.ThresholdInputStream thresholdInputStream;
/*     */     try {
/* 181 */       thresholdInputStream = ZipHelper.openZipStream(paramFileInputStream);
/* 182 */     } catch (IOException iOException) {
/*     */       
/* 184 */       throw new InvalidOperationException("Could not open the file input stream", iOException);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 190 */       return openZipEntrySourceStream(thresholdInputStream);
/* 191 */     } catch (Exception exception) {
/*     */       
/*     */       try {
/* 194 */         thresholdInputStream.close();
/* 195 */       } catch (IOException iOException) {
/* 196 */         throw new InvalidOperationException("Failed to read the zip entry source stream and could not close the zip input stream", iOException);
/*     */       } 
/* 198 */       throw new InvalidOperationException("Failed to read the zip entry source stream", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static ZipEntrySource openZipEntrySourceStream(ZipSecureFile.ThresholdInputStream paramThresholdInputStream) throws InvalidOperationException {
/*     */     try {
/* 206 */       return (ZipEntrySource)new ZipInputStreamZipEntrySource(paramThresholdInputStream);
/* 207 */     } catch (IOException iOException) {
/* 208 */       throw new InvalidOperationException("Could not open the specified zip entry source stream", iOException);
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
/*     */   ZipPackage(ZipEntrySource paramZipEntrySource, PackageAccess paramPackageAccess) {
/* 223 */     super(paramPackageAccess);
/* 224 */     this.zipArchive = paramZipEntrySource;
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
/*     */   protected PackagePart[] getPartsImpl() throws InvalidFormatException {
/* 239 */     if (this.partList == null)
/*     */     {
/*     */       
/* 242 */       this.partList = new PackagePartCollection();
/*     */     }
/*     */     
/* 245 */     if (this.zipArchive == null) {
/* 246 */       return this.partList.values().<PackagePart>toArray(new PackagePart[this.partList.values().size()]);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 251 */     Enumeration<ZipEntry> enumeration = this.zipArchive.getEntries();
/* 252 */     while (enumeration.hasMoreElements()) {
/* 253 */       ZipEntry zipEntry = enumeration.nextElement();
/* 254 */       if (zipEntry.getName().equalsIgnoreCase("[Content_Types].xml")) {
/*     */         
/*     */         try {
/* 257 */           this.contentTypeManager = (ContentTypeManager)new ZipContentTypeManager(getZipArchive().getInputStream(zipEntry), this);
/*     */         }
/* 259 */         catch (IOException iOException) {
/* 260 */           throw new InvalidFormatException(iOException.getMessage(), iOException);
/*     */         } 
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 267 */     if (this.contentTypeManager == null) {
/*     */       
/* 269 */       byte b = 0;
/* 270 */       boolean bool1 = false;
/* 271 */       boolean bool2 = false;
/* 272 */       enumeration = this.zipArchive.getEntries();
/* 273 */       while (enumeration.hasMoreElements()) {
/* 274 */         ZipEntry zipEntry = enumeration.nextElement();
/* 275 */         String str = zipEntry.getName();
/* 276 */         if ("mimetype".equals(str)) {
/* 277 */           bool1 = true;
/*     */         }
/* 279 */         if ("settings.xml".equals(str)) {
/* 280 */           bool2 = true;
/*     */         }
/* 282 */         b++;
/*     */       } 
/* 284 */       if (bool1 && bool2) {
/* 285 */         throw new ODFNotOfficeXmlFileException("The supplied data appears to be in ODF (Open Document) Format. Formats like these (eg ODS, ODP) are not supported, try Apache ODFToolkit");
/*     */       }
/*     */ 
/*     */       
/* 289 */       if (b == 0) {
/* 290 */         throw new NotOfficeXmlFileException("No valid entries or contents found, this is not a valid OOXML (Office Open XML) file");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 296 */       throw new InvalidFormatException("Package should contain a content type part [M1.13]");
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 304 */     enumeration = this.zipArchive.getEntries();
/* 305 */     while (enumeration.hasMoreElements()) {
/* 306 */       ZipEntry zipEntry = enumeration.nextElement();
/* 307 */       PackagePartName packagePartName = buildPartName(zipEntry);
/* 308 */       if (packagePartName == null) {
/*     */         continue;
/*     */       }
/* 311 */       String str = this.contentTypeManager.getContentType(packagePartName);
/* 312 */       if (str != null && str.equals("application/vnd.openxmlformats-package.relationships+xml")) {
/*     */         try {
/* 314 */           ZipPackagePart zipPackagePart = new ZipPackagePart(this, zipEntry, packagePartName, str);
/* 315 */           this.partList.put(packagePartName, zipPackagePart);
/* 316 */         } catch (InvalidOperationException invalidOperationException) {
/* 317 */           throw new InvalidFormatException(invalidOperationException.getMessage(), invalidOperationException);
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 323 */     enumeration = this.zipArchive.getEntries();
/* 324 */     while (enumeration.hasMoreElements()) {
/* 325 */       ZipEntry zipEntry = enumeration.nextElement();
/* 326 */       PackagePartName packagePartName = buildPartName(zipEntry);
/* 327 */       if (packagePartName == null)
/*     */         continue; 
/* 329 */       String str = this.contentTypeManager.getContentType(packagePartName);
/* 330 */       if (str != null && str.equals("application/vnd.openxmlformats-package.relationships+xml")) {
/*     */         continue;
/*     */       }
/* 333 */       if (str != null) {
/*     */         try {
/* 335 */           ZipPackagePart zipPackagePart = new ZipPackagePart(this, zipEntry, packagePartName, str);
/* 336 */           this.partList.put(packagePartName, zipPackagePart);
/* 337 */         } catch (InvalidOperationException invalidOperationException) {
/* 338 */           throw new InvalidFormatException(invalidOperationException.getMessage(), invalidOperationException);
/*     */         }  continue;
/*     */       } 
/* 341 */       throw new InvalidFormatException("The part " + packagePartName.getURI().getPath() + " does not have any content type ! Rule: Package require content types when retrieving a part from a package. [M.1.14]");
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 348 */     return this.partList.values().<PackagePart>toArray((PackagePart[])new ZipPackagePart[this.partList.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PackagePartName buildPartName(ZipEntry paramZipEntry) {
/*     */     try {
/* 359 */       if (paramZipEntry.getName().equalsIgnoreCase("[Content_Types].xml"))
/*     */       {
/* 361 */         return null;
/*     */       }
/* 363 */       return PackagingURIHelper.createPartName(ZipHelper.getOPCNameFromZipItemName(paramZipEntry.getName()));
/*     */     }
/* 365 */     catch (Exception exception) {
/*     */       
/* 367 */       logger.log(5, new Object[] { "Entry " + paramZipEntry.getName() + " is not valid, so this part won't be add to the package.", exception });
/*     */ 
/*     */       
/* 370 */       return null;
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
/*     */   
/*     */   protected PackagePart createPartImpl(PackagePartName paramPackagePartName, String paramString, boolean paramBoolean) {
/* 387 */     if (paramString == null) {
/* 388 */       throw new IllegalArgumentException("contentType");
/*     */     }
/* 390 */     if (paramPackagePartName == null) {
/* 391 */       throw new IllegalArgumentException("partName");
/*     */     }
/*     */     try {
/* 394 */       return (PackagePart)new MemoryPackagePart(this, paramPackagePartName, paramString, paramBoolean);
/*     */     }
/* 396 */     catch (InvalidFormatException invalidFormatException) {
/* 397 */       logger.log(5, new Object[] { invalidFormatException });
/* 398 */       return null;
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
/*     */   protected void removePartImpl(PackagePartName paramPackagePartName) {
/* 410 */     if (paramPackagePartName == null) {
/* 411 */       throw new IllegalArgumentException("partUri");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void flushImpl() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void closeImpl() throws IOException {
/* 430 */     flush();
/*     */ 
/*     */     
/* 433 */     if (this.originalPackagePath != null && !"".equals(this.originalPackagePath)) {
/*     */       
/* 435 */       File file = new File(this.originalPackagePath);
/* 436 */       if (file.exists()) {
/*     */ 
/*     */         
/* 439 */         File file1 = TempFile.createTempFile(generateTempFileName(FileHelper.getDirectory(file)), ".tmp");
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         try {
/* 445 */           save(file1);
/*     */         } finally {
/*     */           
/*     */           try
/*     */           {
/* 450 */             this.zipArchive.close();
/*     */             
/* 452 */             FileHelper.copyFile(file1, file);
/*     */           }
/*     */           finally
/*     */           {
/* 456 */             if (!file1.delete()) {
/* 457 */               logger.log(5, new Object[] { "The temporary file: '" + file.getAbsolutePath() + "' cannot be deleted ! Make sure that no other application use it." });
/*     */             }
/*     */           }
/*     */         
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 465 */         throw new InvalidOperationException("Can't close a package not previously open with the open() method !");
/*     */       } 
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
/*     */   private synchronized String generateTempFileName(File paramFile) {
/*     */     while (true) {
/* 479 */       File file = new File(paramFile.getAbsoluteFile() + File.separator + "OpenXML4J" + System.nanoTime());
/*     */       
/* 481 */       if (!file.exists()) {
/* 482 */         return FileHelper.getFilename(file.getAbsoluteFile());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void revertImpl() {
/*     */     try {
/* 492 */       if (this.zipArchive != null)
/* 493 */         this.zipArchive.close(); 
/* 494 */     } catch (IOException iOException) {}
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
/*     */   protected PackagePart getPartImpl(PackagePartName paramPackagePartName) {
/* 508 */     if (this.partList.containsKey(paramPackagePartName)) {
/* 509 */       return this.partList.get(paramPackagePartName);
/*     */     }
/* 511 */     return null;
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
/*     */   public void saveImpl(OutputStream paramOutputStream) {
/* 526 */     throwExceptionIfReadOnly();
/*     */     
/*     */     try {
/*     */       ZipOutputStream zipOutputStream;
/* 530 */       if (!(paramOutputStream instanceof ZipOutputStream)) {
/* 531 */         zipOutputStream = new ZipOutputStream(paramOutputStream);
/*     */       } else {
/* 533 */         zipOutputStream = (ZipOutputStream)paramOutputStream;
/*     */       } 
/*     */ 
/*     */       
/* 537 */       if (getPartsByRelationshipType("http://schemas.openxmlformats.org/package/2006/relationships/metadata/core-properties").size() == 0 && getPartsByRelationshipType("http://schemas.openxmlformats.org/officedocument/2006/relationships/metadata/core-properties").size() == 0) {
/*     */         
/* 539 */         logger.log(1, new Object[] { "Save core properties part" });
/*     */ 
/*     */         
/* 542 */         getPackageProperties();
/*     */         
/* 544 */         addPackagePart((PackagePart)this.packageProperties);
/*     */         
/* 546 */         this.relationships.addRelationship(this.packageProperties.getPartName().getURI(), TargetMode.INTERNAL, "http://schemas.openxmlformats.org/package/2006/relationships/metadata/core-properties", null);
/*     */ 
/*     */ 
/*     */         
/* 550 */         if (!this.contentTypeManager.isContentTypeRegister("application/vnd.openxmlformats-package.core-properties+xml"))
/*     */         {
/* 552 */           this.contentTypeManager.addContentType(this.packageProperties.getPartName(), "application/vnd.openxmlformats-package.core-properties+xml");
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 559 */       logger.log(1, new Object[] { "Save package relationships" });
/* 560 */       ZipPartMarshaller.marshallRelationshipPart(getRelationships(), PackagingURIHelper.PACKAGE_RELATIONSHIPS_ROOT_PART_NAME, zipOutputStream);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 565 */       logger.log(1, new Object[] { "Save content types part" });
/* 566 */       this.contentTypeManager.save(zipOutputStream);
/*     */ 
/*     */       
/* 569 */       for (PackagePart packagePart : getParts()) {
/*     */ 
/*     */         
/* 572 */         if (packagePart.isRelationshipPart()) {
/*     */           continue;
/*     */         }
/* 575 */         logger.log(1, new Object[] { "Save part '" + ZipHelper.getZipItemNameFromOPCName(packagePart.getPartName().getName()) + "'" });
/*     */ 
/*     */         
/* 578 */         PartMarshaller partMarshaller = this.partMarshallers.get(packagePart._contentType);
/*     */         
/* 580 */         if (partMarshaller != null) {
/* 581 */           if (!partMarshaller.marshall(packagePart, zipOutputStream)) {
/* 582 */             throw new OpenXML4JException("The part " + packagePart.getPartName().getURI() + " fail to be saved in the stream with marshaller " + partMarshaller);
/*     */           }
/*     */ 
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/* 589 */         if (!this.defaultPartMarshaller.marshall(packagePart, zipOutputStream)) {
/* 590 */           throw new OpenXML4JException("The part " + packagePart.getPartName().getURI() + " fail to be saved in the stream with marshaller " + this.defaultPartMarshaller);
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 597 */       zipOutputStream.close();
/* 598 */     } catch (OpenXML4JRuntimeException openXML4JRuntimeException) {
/*     */       
/* 600 */       throw openXML4JRuntimeException;
/* 601 */     } catch (Exception exception) {
/* 602 */       throw new OpenXML4JRuntimeException("Fail to save: an error occurs while saving the package : " + exception.getMessage(), exception);
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
/*     */   public ZipEntrySource getZipArchive() {
/* 614 */     return this.zipArchive;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\ZipPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */