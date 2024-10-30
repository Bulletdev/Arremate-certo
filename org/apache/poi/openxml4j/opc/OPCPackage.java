/*      */ package org.apache.poi.openxml4j.opc;
/*      */ 
/*      */ import java.io.ByteArrayOutputStream;
/*      */ import java.io.Closeable;
/*      */ import java.io.File;
/*      */ import java.io.FileInputStream;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.OutputStream;
/*      */ import java.net.URI;
/*      */ import java.net.URISyntaxException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*      */ import java.util.regex.Matcher;
/*      */ import java.util.regex.Pattern;
/*      */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*      */ import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
/*      */ import org.apache.poi.openxml4j.exceptions.OpenXML4JRuntimeException;
/*      */ import org.apache.poi.openxml4j.exceptions.PartAlreadyExistsException;
/*      */ import org.apache.poi.openxml4j.opc.internal.ContentType;
/*      */ import org.apache.poi.openxml4j.opc.internal.ContentTypeManager;
/*      */ import org.apache.poi.openxml4j.opc.internal.PackagePropertiesPart;
/*      */ import org.apache.poi.openxml4j.opc.internal.PartMarshaller;
/*      */ import org.apache.poi.openxml4j.opc.internal.PartUnmarshaller;
/*      */ import org.apache.poi.openxml4j.opc.internal.ZipContentTypeManager;
/*      */ import org.apache.poi.openxml4j.opc.internal.marshallers.DefaultMarshaller;
/*      */ import org.apache.poi.openxml4j.opc.internal.marshallers.ZipPackagePropertiesMarshaller;
/*      */ import org.apache.poi.openxml4j.opc.internal.unmarshallers.PackagePropertiesUnmarshaller;
/*      */ import org.apache.poi.openxml4j.opc.internal.unmarshallers.UnmarshallContext;
/*      */ import org.apache.poi.openxml4j.util.Nullable;
/*      */ import org.apache.poi.openxml4j.util.ZipEntrySource;
/*      */ import org.apache.poi.util.NotImplemented;
/*      */ import org.apache.poi.util.POILogFactory;
/*      */ import org.apache.poi.util.POILogger;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class OPCPackage
/*      */   implements Closeable, RelationshipSource
/*      */ {
/*   69 */   private static final POILogger logger = POILogFactory.getLogger(OPCPackage.class);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   74 */   protected static final PackageAccess defaultPackageAccess = PackageAccess.READ_WRITE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private PackageAccess packageAccess;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected PackagePartCollection partList;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected PackageRelationshipCollection relationships;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Map<ContentType, PartMarshaller> partMarshallers;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected PartMarshaller defaultPartMarshaller;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Map<ContentType, PartUnmarshaller> partUnmarshallers;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected PackagePropertiesPart packageProperties;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected ContentTypeManager contentTypeManager;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isDirty = false;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String originalPackagePath;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected OutputStream output;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   OPCPackage(PackageAccess paramPackageAccess) {
/*  138 */     if (getClass() != ZipPackage.class) {
/*  139 */       throw new IllegalArgumentException("PackageBase may not be subclassed");
/*      */     }
/*  141 */     init();
/*  142 */     this.packageAccess = paramPackageAccess;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void init() {
/*  149 */     this.partMarshallers = new HashMap<ContentType, PartMarshaller>(5);
/*  150 */     this.partUnmarshallers = new HashMap<ContentType, PartUnmarshaller>(2);
/*      */ 
/*      */     
/*      */     try {
/*  154 */       this.partUnmarshallers.put(new ContentType("application/vnd.openxmlformats-package.core-properties+xml"), new PackagePropertiesUnmarshaller());
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  159 */       this.defaultPartMarshaller = (PartMarshaller)new DefaultMarshaller();
/*      */       
/*  161 */       this.partMarshallers.put(new ContentType("application/vnd.openxmlformats-package.core-properties+xml"), new ZipPackagePropertiesMarshaller());
/*      */     
/*      */     }
/*  164 */     catch (InvalidFormatException invalidFormatException) {
/*      */       
/*  166 */       throw new OpenXML4JRuntimeException("Package.init() : this exception should never happen, if you read this message please send a mail to the developers team. : " + invalidFormatException.getMessage(), invalidFormatException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static OPCPackage open(String paramString) throws InvalidFormatException {
/*  187 */     return open(paramString, defaultPackageAccess);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static OPCPackage open(File paramFile) throws InvalidFormatException {
/*  201 */     return open(paramFile, defaultPackageAccess);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static OPCPackage open(ZipEntrySource paramZipEntrySource) throws InvalidFormatException {
/*  216 */     ZipPackage zipPackage = new ZipPackage(paramZipEntrySource, PackageAccess.READ);
/*      */     try {
/*  218 */       if (zipPackage.partList == null) {
/*  219 */         zipPackage.getParts();
/*      */       }
/*      */       
/*  222 */       return zipPackage;
/*  223 */     } catch (InvalidFormatException invalidFormatException) {
/*      */       try {
/*  225 */         zipPackage.close();
/*  226 */       } catch (IOException iOException) {
/*  227 */         throw new IllegalStateException(invalidFormatException);
/*      */       } 
/*  229 */       throw invalidFormatException;
/*  230 */     } catch (RuntimeException runtimeException) {
/*      */       try {
/*  232 */         zipPackage.close();
/*  233 */       } catch (IOException iOException) {
/*  234 */         throw new IllegalStateException(runtimeException);
/*      */       } 
/*  236 */       throw runtimeException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static OPCPackage open(String paramString, PackageAccess paramPackageAccess) throws InvalidFormatException, InvalidOperationException {
/*  255 */     if (paramString == null || "".equals(paramString.trim())) {
/*  256 */       throw new IllegalArgumentException("'path' must be given");
/*      */     }
/*      */     
/*  259 */     File file = new File(paramString);
/*  260 */     if (file.exists() && file.isDirectory()) {
/*  261 */       throw new IllegalArgumentException("path must not be a directory");
/*      */     }
/*      */     
/*  264 */     ZipPackage zipPackage = new ZipPackage(paramString, paramPackageAccess);
/*  265 */     boolean bool = false;
/*  266 */     if (zipPackage.partList == null && paramPackageAccess != PackageAccess.WRITE) {
/*      */       try {
/*  268 */         zipPackage.getParts();
/*  269 */         bool = true;
/*      */       } finally {
/*  271 */         if (!bool) {
/*      */           try {
/*  273 */             zipPackage.close();
/*  274 */           } catch (IOException iOException) {
/*  275 */             throw new InvalidOperationException("Could not close OPCPackage while cleaning up", iOException);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     }
/*  280 */     zipPackage.originalPackagePath = (new File(paramString)).getAbsolutePath();
/*  281 */     return zipPackage;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static OPCPackage open(File paramFile, PackageAccess paramPackageAccess) throws InvalidFormatException {
/*  298 */     if (paramFile == null) {
/*  299 */       throw new IllegalArgumentException("'file' must be given");
/*      */     }
/*  301 */     if (paramFile.exists() && paramFile.isDirectory()) {
/*  302 */       throw new IllegalArgumentException("file must not be a directory");
/*      */     }
/*      */     
/*  305 */     ZipPackage zipPackage = new ZipPackage(paramFile, paramPackageAccess);
/*      */     try {
/*  307 */       if (zipPackage.partList == null && paramPackageAccess != PackageAccess.WRITE) {
/*  308 */         zipPackage.getParts();
/*      */       }
/*  310 */       zipPackage.originalPackagePath = paramFile.getAbsolutePath();
/*  311 */       return zipPackage;
/*  312 */     } catch (InvalidFormatException invalidFormatException) {
/*      */       try {
/*  314 */         zipPackage.close();
/*  315 */       } catch (IOException iOException) {
/*  316 */         throw new IllegalStateException(invalidFormatException);
/*      */       } 
/*  318 */       throw invalidFormatException;
/*  319 */     } catch (RuntimeException runtimeException) {
/*      */       try {
/*  321 */         zipPackage.close();
/*  322 */       } catch (IOException iOException) {
/*  323 */         throw new IllegalStateException(runtimeException);
/*      */       } 
/*  325 */       throw runtimeException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static OPCPackage open(InputStream paramInputStream) throws InvalidFormatException, IOException {
/*  342 */     ZipPackage zipPackage = new ZipPackage(paramInputStream, PackageAccess.READ_WRITE);
/*  343 */     if (zipPackage.partList == null) {
/*  344 */       zipPackage.getParts();
/*      */     }
/*  346 */     return zipPackage;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static OPCPackage openOrCreate(File paramFile) throws InvalidFormatException {
/*  360 */     OPCPackage oPCPackage = null;
/*  361 */     if (paramFile.exists()) {
/*  362 */       oPCPackage = open(paramFile.getAbsolutePath());
/*      */     } else {
/*  364 */       oPCPackage = create(paramFile);
/*      */     } 
/*  366 */     return oPCPackage;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static OPCPackage create(String paramString) {
/*  377 */     return create(new File(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static OPCPackage create(File paramFile) {
/*  388 */     if (paramFile == null || (paramFile.exists() && paramFile.isDirectory())) {
/*  389 */       throw new IllegalArgumentException("file");
/*      */     }
/*      */     
/*  392 */     if (paramFile.exists()) {
/*  393 */       throw new InvalidOperationException("This package (or file) already exists : use the open() method or delete the file.");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  398 */     ZipPackage zipPackage = new ZipPackage();
/*  399 */     zipPackage.originalPackagePath = paramFile.getAbsolutePath();
/*      */     
/*  401 */     configurePackage(zipPackage);
/*  402 */     return zipPackage;
/*      */   }
/*      */   
/*      */   public static OPCPackage create(OutputStream paramOutputStream) {
/*  406 */     ZipPackage zipPackage = new ZipPackage();
/*  407 */     zipPackage.originalPackagePath = null;
/*  408 */     zipPackage.output = paramOutputStream;
/*      */     
/*  410 */     configurePackage(zipPackage);
/*  411 */     return zipPackage;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void configurePackage(OPCPackage paramOPCPackage) {
/*      */     try {
/*  422 */       paramOPCPackage.contentTypeManager = (ContentTypeManager)new ZipContentTypeManager(null, paramOPCPackage);
/*      */ 
/*      */       
/*  425 */       paramOPCPackage.contentTypeManager.addContentType(PackagingURIHelper.createPartName(PackagingURIHelper.PACKAGE_RELATIONSHIPS_ROOT_URI), "application/vnd.openxmlformats-package.relationships+xml");
/*      */ 
/*      */ 
/*      */       
/*  429 */       paramOPCPackage.contentTypeManager.addContentType(PackagingURIHelper.createPartName("/default.xml"), "application/xml");
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  434 */       paramOPCPackage.packageProperties = new PackagePropertiesPart(paramOPCPackage, PackagingURIHelper.CORE_PROPERTIES_PART_NAME);
/*      */       
/*  436 */       paramOPCPackage.packageProperties.setCreatorProperty("Generated by Apache POI OpenXML4J");
/*  437 */       paramOPCPackage.packageProperties.setCreatedProperty(new Nullable(new Date()));
/*  438 */     } catch (InvalidFormatException invalidFormatException) {
/*      */       
/*  440 */       throw new IllegalStateException(invalidFormatException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void flush() {
/*  450 */     throwExceptionIfReadOnly();
/*      */     
/*  452 */     if (this.packageProperties != null) {
/*  453 */       this.packageProperties.flush();
/*      */     }
/*      */     
/*  456 */     flushImpl();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void close() throws IOException {
/*  470 */     if (this.packageAccess == PackageAccess.READ) {
/*  471 */       logger.log(5, new Object[] { "The close() method is intended to SAVE a package. This package is open in READ ONLY mode, use the revert() method instead !" });
/*      */       
/*  473 */       revert();
/*      */       return;
/*      */     } 
/*  476 */     if (this.contentTypeManager == null) {
/*  477 */       logger.log(5, new Object[] { "Unable to call close() on a package that hasn't been fully opened yet" });
/*      */       
/*  479 */       revert();
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  484 */     ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
/*      */     try {
/*  486 */       reentrantReadWriteLock.writeLock().lock();
/*  487 */       if (this.originalPackagePath != null && !"".equals(this.originalPackagePath.trim())) {
/*      */         
/*  489 */         File file = new File(this.originalPackagePath);
/*  490 */         if (!file.exists() || !this.originalPackagePath.equalsIgnoreCase(file.getAbsolutePath())) {
/*      */ 
/*      */ 
/*      */           
/*  494 */           save(file);
/*      */         } else {
/*  496 */           closeImpl();
/*      */         } 
/*  498 */       } else if (this.output != null) {
/*  499 */         save(this.output);
/*  500 */         this.output.close();
/*      */       } 
/*      */     } finally {
/*  503 */       reentrantReadWriteLock.writeLock().unlock();
/*      */     } 
/*      */ 
/*      */     
/*  507 */     this.contentTypeManager.clearAll();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void revert() {
/*  515 */     revertImpl();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addThumbnail(String paramString) throws IOException {
/*  527 */     if (paramString == null || paramString.isEmpty()) {
/*  528 */       throw new IllegalArgumentException("path");
/*      */     }
/*  530 */     String str = paramString.substring(paramString.lastIndexOf(File.separatorChar) + 1);
/*      */     
/*  532 */     FileInputStream fileInputStream = new FileInputStream(paramString);
/*      */     try {
/*  534 */       addThumbnail(str, fileInputStream);
/*      */     } finally {
/*  536 */       fileInputStream.close();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addThumbnail(String paramString, InputStream paramInputStream) throws IOException {
/*      */     PackagePartName packagePartName;
/*  549 */     if (paramString == null || paramString.isEmpty()) {
/*  550 */       throw new IllegalArgumentException("filename");
/*      */     }
/*      */ 
/*      */     
/*  554 */     String str = ContentTypes.getContentTypeFromFileExtension(paramString);
/*      */ 
/*      */     
/*      */     try {
/*  558 */       packagePartName = PackagingURIHelper.createPartName("/docProps/" + paramString);
/*      */     }
/*  560 */     catch (InvalidFormatException invalidFormatException) {
/*  561 */       String str1 = "/docProps/thumbnail" + paramString.substring(paramString.lastIndexOf(".") + 1);
/*      */       
/*      */       try {
/*  564 */         packagePartName = PackagingURIHelper.createPartName(str1);
/*  565 */       } catch (InvalidFormatException invalidFormatException1) {
/*  566 */         throw new InvalidOperationException("Can't add a thumbnail file named '" + paramString + "'", invalidFormatException1);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  572 */     if (getPart(packagePartName) != null) {
/*  573 */       throw new InvalidOperationException("You already add a thumbnail named '" + paramString + "'");
/*      */     }
/*      */ 
/*      */     
/*  577 */     PackagePart packagePart = createPart(packagePartName, str, false);
/*      */ 
/*      */ 
/*      */     
/*  581 */     addRelationship(packagePartName, TargetMode.INTERNAL, "http://schemas.openxmlformats.org/package/2006/relationships/metadata/thumbnail");
/*      */ 
/*      */ 
/*      */     
/*  585 */     StreamHelper.copyStream(paramInputStream, packagePart.getOutputStream());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void throwExceptionIfReadOnly() throws InvalidOperationException {
/*  597 */     if (this.packageAccess == PackageAccess.READ) {
/*  598 */       throw new InvalidOperationException("Operation not allowed, document open in read only mode!");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void throwExceptionIfWriteOnly() throws InvalidOperationException {
/*  613 */     if (this.packageAccess == PackageAccess.WRITE) {
/*  614 */       throw new InvalidOperationException("Operation not allowed, document open in write only mode!");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PackageProperties getPackageProperties() throws InvalidFormatException {
/*  626 */     throwExceptionIfWriteOnly();
/*      */     
/*  628 */     if (this.packageProperties == null) {
/*  629 */       this.packageProperties = new PackagePropertiesPart(this, PackagingURIHelper.CORE_PROPERTIES_PART_NAME);
/*      */     }
/*      */     
/*  632 */     return (PackageProperties)this.packageProperties;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PackagePart getPart(PackagePartName paramPackagePartName) {
/*  643 */     throwExceptionIfWriteOnly();
/*      */     
/*  645 */     if (paramPackagePartName == null) {
/*  646 */       throw new IllegalArgumentException("partName");
/*      */     }
/*      */ 
/*      */     
/*  650 */     if (this.partList == null) {
/*      */       try {
/*  652 */         getParts();
/*  653 */       } catch (InvalidFormatException invalidFormatException) {
/*  654 */         return null;
/*      */       } 
/*      */     }
/*  657 */     return getPartImpl(paramPackagePartName);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ArrayList<PackagePart> getPartsByContentType(String paramString) {
/*  668 */     ArrayList<PackagePart> arrayList = new ArrayList();
/*  669 */     for (PackagePart packagePart : this.partList.values()) {
/*  670 */       if (packagePart.getContentType().equals(paramString)) {
/*  671 */         arrayList.add(packagePart);
/*      */       }
/*      */     } 
/*  674 */     Collections.sort(arrayList);
/*  675 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ArrayList<PackagePart> getPartsByRelationshipType(String paramString) {
/*  689 */     if (paramString == null) {
/*  690 */       throw new IllegalArgumentException("relationshipType");
/*      */     }
/*  692 */     ArrayList<PackagePart> arrayList = new ArrayList();
/*  693 */     for (PackageRelationship packageRelationship : getRelationshipsByType(paramString)) {
/*  694 */       PackagePart packagePart = getPart(packageRelationship);
/*  695 */       if (packagePart != null) {
/*  696 */         arrayList.add(packagePart);
/*      */       }
/*      */     } 
/*  699 */     Collections.sort(arrayList);
/*  700 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<PackagePart> getPartsByName(Pattern paramPattern) {
/*  712 */     if (paramPattern == null) {
/*  713 */       throw new IllegalArgumentException("name pattern must not be null");
/*      */     }
/*  715 */     Matcher matcher = paramPattern.matcher("");
/*  716 */     ArrayList<PackagePart> arrayList = new ArrayList();
/*  717 */     for (PackagePart packagePart : this.partList.values()) {
/*  718 */       PackagePartName packagePartName = packagePart.getPartName();
/*  719 */       if (matcher.reset(packagePartName.getName()).matches()) {
/*  720 */         arrayList.add(packagePart);
/*      */       }
/*      */     } 
/*  723 */     Collections.sort(arrayList);
/*  724 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PackagePart getPart(PackageRelationship paramPackageRelationship) {
/*  734 */     PackagePart packagePart = null;
/*  735 */     ensureRelationships();
/*  736 */     for (PackageRelationship packageRelationship : this.relationships) {
/*  737 */       if (packageRelationship.getRelationshipType().equals(paramPackageRelationship.getRelationshipType())) {
/*      */         try {
/*  739 */           packagePart = getPart(PackagingURIHelper.createPartName(packageRelationship.getTargetURI()));
/*      */           break;
/*  741 */         } catch (InvalidFormatException invalidFormatException) {}
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  747 */     return packagePart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ArrayList<PackagePart> getParts() throws InvalidFormatException {
/*  762 */     throwExceptionIfWriteOnly();
/*      */ 
/*      */     
/*  765 */     if (this.partList == null) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  771 */       boolean bool1 = false;
/*  772 */       boolean bool2 = true;
/*      */       
/*  774 */       PackagePart[] arrayOfPackagePart = getPartsImpl();
/*  775 */       this.partList = new PackagePartCollection();
/*  776 */       for (PackagePart packagePart : arrayOfPackagePart) {
/*  777 */         if (this.partList.containsKey(packagePart._partName)) {
/*  778 */           throw new InvalidFormatException("A part with the name '" + packagePart._partName + "' already exist : Packages shall not contain equivalent " + "part names and package implementers shall neither create " + "nor recognize packages with equivalent part names. [M1.12]");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  787 */         if (packagePart.getContentType().equals("application/vnd.openxmlformats-package.core-properties+xml"))
/*      */         {
/*  789 */           if (!bool1) {
/*  790 */             bool1 = true;
/*      */           } else {
/*  792 */             logger.log(5, new Object[] { "OPC Compliance error [M4.1]: there is more than one core properties relationship in the package! POI will use only the first, but other software may reject this file." });
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*  798 */         PartUnmarshaller partUnmarshaller = this.partUnmarshallers.get(packagePart._contentType);
/*      */         
/*  800 */         if (partUnmarshaller != null) {
/*  801 */           UnmarshallContext unmarshallContext = new UnmarshallContext(this, packagePart._partName);
/*      */           
/*      */           try {
/*  804 */             PackagePart packagePart1 = partUnmarshaller.unmarshall(unmarshallContext, packagePart.getInputStream());
/*      */             
/*  806 */             this.partList.put(packagePart1._partName, packagePart1);
/*      */ 
/*      */ 
/*      */             
/*  810 */             if (packagePart1 instanceof PackagePropertiesPart && bool1 && bool2) {
/*      */ 
/*      */               
/*  813 */               this.packageProperties = (PackagePropertiesPart)packagePart1;
/*  814 */               bool2 = false;
/*      */             } 
/*  816 */           } catch (IOException iOException) {
/*  817 */             logger.log(5, new Object[] { "Unmarshall operation : IOException for " + packagePart._partName });
/*      */           
/*      */           }
/*  820 */           catch (InvalidOperationException invalidOperationException) {
/*  821 */             throw new InvalidFormatException(invalidOperationException.getMessage(), invalidOperationException);
/*      */           } 
/*      */         } else {
/*      */           try {
/*  825 */             this.partList.put(packagePart._partName, packagePart);
/*  826 */           } catch (InvalidOperationException invalidOperationException) {
/*  827 */             throw new InvalidFormatException(invalidOperationException.getMessage(), invalidOperationException);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*  832 */     ArrayList<PackagePart> arrayList = new ArrayList<PackagePart>(this.partList.values());
/*  833 */     Collections.sort(arrayList);
/*  834 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PackagePart createPart(PackagePartName paramPackagePartName, String paramString) {
/*  853 */     return createPart(paramPackagePartName, paramString, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   PackagePart createPart(PackagePartName paramPackagePartName, String paramString, boolean paramBoolean) {
/*  877 */     throwExceptionIfReadOnly();
/*  878 */     if (paramPackagePartName == null) {
/*  879 */       throw new IllegalArgumentException("partName");
/*      */     }
/*      */     
/*  882 */     if (paramString == null || paramString.equals("")) {
/*  883 */       throw new IllegalArgumentException("contentType");
/*      */     }
/*      */ 
/*      */     
/*  887 */     if (this.partList.containsKey(paramPackagePartName) && !this.partList.get(paramPackagePartName).isDeleted())
/*      */     {
/*  889 */       throw new PartAlreadyExistsException("A part with the name '" + paramPackagePartName.getName() + "'" + " already exists : Packages shall not contain equivalent part names and package" + " implementers shall neither create nor recognize packages with equivalent part names. [M1.12]");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  904 */     if (paramString.equals("application/vnd.openxmlformats-package.core-properties+xml") && 
/*  905 */       this.packageProperties != null) {
/*  906 */       throw new InvalidOperationException("OPC Compliance error [M4.1]: you try to add more than one core properties relationship in the package !");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  913 */     PackagePart packagePart = createPartImpl(paramPackagePartName, paramString, paramBoolean);
/*      */     
/*  915 */     this.contentTypeManager.addContentType(paramPackagePartName, paramString);
/*  916 */     this.partList.put(paramPackagePartName, packagePart);
/*  917 */     this.isDirty = true;
/*  918 */     return packagePart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PackagePart createPart(PackagePartName paramPackagePartName, String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {
/*  938 */     PackagePart packagePart = createPart(paramPackagePartName, paramString);
/*  939 */     if (packagePart == null) {
/*  940 */       return null;
/*      */     }
/*      */     
/*  943 */     if (paramByteArrayOutputStream != null) {
/*      */       try {
/*  945 */         OutputStream outputStream = packagePart.getOutputStream();
/*  946 */         if (outputStream == null) {
/*  947 */           return null;
/*      */         }
/*      */         
/*  950 */         outputStream.write(paramByteArrayOutputStream.toByteArray(), 0, paramByteArrayOutputStream.size());
/*  951 */         outputStream.close();
/*      */       }
/*  953 */       catch (IOException iOException) {
/*  954 */         return null;
/*      */       } 
/*      */     } else {
/*  957 */       return null;
/*      */     } 
/*  959 */     return packagePart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected PackagePart addPackagePart(PackagePart paramPackagePart) {
/*  976 */     throwExceptionIfReadOnly();
/*  977 */     if (paramPackagePart == null) {
/*  978 */       throw new IllegalArgumentException("part");
/*      */     }
/*      */     
/*  981 */     if (this.partList.containsKey(paramPackagePart._partName)) {
/*  982 */       if (!this.partList.get(paramPackagePart._partName).isDeleted()) {
/*  983 */         throw new InvalidOperationException("A part with the name '" + paramPackagePart._partName.getName() + "' already exists : Packages shall not contain equivalent part names and package implementers shall neither create nor recognize packages with equivalent part names. [M1.12]");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  990 */       paramPackagePart.setDeleted(false);
/*      */       
/*  992 */       this.partList.remove(paramPackagePart._partName);
/*      */     } 
/*  994 */     this.partList.put(paramPackagePart._partName, paramPackagePart);
/*  995 */     this.isDirty = true;
/*  996 */     return paramPackagePart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removePart(PackagePart paramPackagePart) {
/* 1008 */     if (paramPackagePart != null) {
/* 1009 */       removePart(paramPackagePart.getPartName());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removePart(PackagePartName paramPackagePartName) {
/* 1021 */     throwExceptionIfReadOnly();
/* 1022 */     if (paramPackagePartName == null || !containPart(paramPackagePartName)) {
/* 1023 */       throw new IllegalArgumentException("partName");
/*      */     }
/*      */ 
/*      */     
/* 1027 */     if (this.partList.containsKey(paramPackagePartName)) {
/* 1028 */       this.partList.get(paramPackagePartName).setDeleted(true);
/* 1029 */       removePartImpl(paramPackagePartName);
/* 1030 */       this.partList.remove(paramPackagePartName);
/*      */     } else {
/* 1032 */       removePartImpl(paramPackagePartName);
/*      */     } 
/*      */ 
/*      */     
/* 1036 */     this.contentTypeManager.removeContentType(paramPackagePartName);
/*      */ 
/*      */ 
/*      */     
/* 1040 */     if (paramPackagePartName.isRelationshipPartURI()) {
/* 1041 */       PackagePartName packagePartName; URI uRI = PackagingURIHelper.getSourcePartUriFromRelationshipPartUri(paramPackagePartName.getURI());
/*      */ 
/*      */       
/*      */       try {
/* 1045 */         packagePartName = PackagingURIHelper.createPartName(uRI);
/* 1046 */       } catch (InvalidFormatException invalidFormatException) {
/* 1047 */         logger.log(7, new Object[] { "Part name URI '" + uRI + "' is not valid ! This message is not intended to be displayed !" });
/*      */ 
/*      */         
/*      */         return;
/*      */       } 
/*      */       
/* 1053 */       if (packagePartName.getURI().equals(PackagingURIHelper.PACKAGE_ROOT_URI)) {
/*      */         
/* 1055 */         clearRelationships();
/* 1056 */       } else if (containPart(packagePartName)) {
/* 1057 */         PackagePart packagePart = getPart(packagePartName);
/* 1058 */         if (packagePart != null) {
/* 1059 */           packagePart.clearRelationships();
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1064 */     this.isDirty = true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removePartRecursive(PackagePartName paramPackagePartName) throws InvalidFormatException {
/* 1081 */     PackagePart packagePart1 = this.partList.get(PackagingURIHelper.getRelationshipPartName(paramPackagePartName));
/*      */ 
/*      */     
/* 1084 */     PackagePart packagePart2 = this.partList.get(paramPackagePartName);
/*      */     
/* 1086 */     if (packagePart1 != null) {
/* 1087 */       PackageRelationshipCollection packageRelationshipCollection = new PackageRelationshipCollection(packagePart2);
/*      */       
/* 1089 */       for (PackageRelationship packageRelationship : packageRelationshipCollection) {
/* 1090 */         PackagePartName packagePartName = PackagingURIHelper.createPartName(PackagingURIHelper.resolvePartUri(packageRelationship.getSourceURI(), packageRelationship.getTargetURI()));
/*      */ 
/*      */         
/* 1093 */         removePart(packagePartName);
/*      */       } 
/*      */ 
/*      */       
/* 1097 */       removePart(packagePart1._partName);
/*      */     } 
/*      */ 
/*      */     
/* 1101 */     removePart(packagePart2._partName);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void deletePart(PackagePartName paramPackagePartName) {
/* 1114 */     if (paramPackagePartName == null) {
/* 1115 */       throw new IllegalArgumentException("partName");
/*      */     }
/*      */ 
/*      */     
/* 1119 */     removePart(paramPackagePartName);
/*      */     
/* 1121 */     removePart(PackagingURIHelper.getRelationshipPartName(paramPackagePartName));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void deletePartRecursive(PackagePartName paramPackagePartName) {
/* 1135 */     if (paramPackagePartName == null || !containPart(paramPackagePartName)) {
/* 1136 */       throw new IllegalArgumentException("partName");
/*      */     }
/*      */     
/* 1139 */     PackagePart packagePart = getPart(paramPackagePartName);
/*      */     
/* 1141 */     removePart(paramPackagePartName);
/*      */     
/*      */     try {
/* 1144 */       for (PackageRelationship packageRelationship : packagePart.getRelationships()) {
/*      */         
/* 1146 */         PackagePartName packagePartName1 = PackagingURIHelper.createPartName(PackagingURIHelper.resolvePartUri(paramPackagePartName.getURI(), packageRelationship.getTargetURI()));
/*      */ 
/*      */         
/* 1149 */         deletePartRecursive(packagePartName1);
/*      */       } 
/* 1151 */     } catch (InvalidFormatException invalidFormatException) {
/* 1152 */       logger.log(5, new Object[] { "An exception occurs while deleting part '" + paramPackagePartName.getName() + "'. Some parts may remain in the package. - " + invalidFormatException.getMessage() });
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */ 
/*      */     
/* 1159 */     PackagePartName packagePartName = PackagingURIHelper.getRelationshipPartName(paramPackagePartName);
/*      */     
/* 1161 */     if (packagePartName != null && containPart(packagePartName)) {
/* 1162 */       removePart(packagePartName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean containPart(PackagePartName paramPackagePartName) {
/* 1175 */     return (getPart(paramPackagePartName) != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PackageRelationship addRelationship(PackagePartName paramPackagePartName, TargetMode paramTargetMode, String paramString1, String paramString2) {
/* 1213 */     if (paramString1.equals("http://schemas.openxmlformats.org/package/2006/relationships/metadata/core-properties") && this.packageProperties != null)
/*      */     {
/* 1215 */       throw new InvalidOperationException("OPC Compliance error [M4.1]: can't add another core properties part ! Use the built-in package method instead.");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1225 */     if (paramPackagePartName.isRelationshipPartURI()) {
/* 1226 */       throw new InvalidOperationException("Rule M1.25: The Relationships part shall not have relationships to any other part.");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1232 */     ensureRelationships();
/* 1233 */     PackageRelationship packageRelationship = this.relationships.addRelationship(paramPackagePartName.getURI(), paramTargetMode, paramString1, paramString2);
/*      */     
/* 1235 */     this.isDirty = true;
/* 1236 */     return packageRelationship;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PackageRelationship addRelationship(PackagePartName paramPackagePartName, TargetMode paramTargetMode, String paramString) {
/* 1253 */     return addRelationship(paramPackagePartName, paramTargetMode, paramString, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PackageRelationship addExternalRelationship(String paramString1, String paramString2) {
/* 1275 */     return addExternalRelationship(paramString1, paramString2, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PackageRelationship addExternalRelationship(String paramString1, String paramString2, String paramString3) {
/*      */     URI uRI;
/* 1298 */     if (paramString1 == null) {
/* 1299 */       throw new IllegalArgumentException("target");
/*      */     }
/* 1301 */     if (paramString2 == null) {
/* 1302 */       throw new IllegalArgumentException("relationshipType");
/*      */     }
/*      */ 
/*      */     
/*      */     try {
/* 1307 */       uRI = new URI(paramString1);
/* 1308 */     } catch (URISyntaxException uRISyntaxException) {
/* 1309 */       throw new IllegalArgumentException("Invalid target - " + uRISyntaxException);
/*      */     } 
/*      */     
/* 1312 */     ensureRelationships();
/* 1313 */     PackageRelationship packageRelationship = this.relationships.addRelationship(uRI, TargetMode.EXTERNAL, paramString2, paramString3);
/*      */     
/* 1315 */     this.isDirty = true;
/* 1316 */     return packageRelationship;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeRelationship(String paramString) {
/* 1327 */     if (this.relationships != null) {
/* 1328 */       this.relationships.removeRelationship(paramString);
/* 1329 */       this.isDirty = true;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PackageRelationshipCollection getRelationships() {
/* 1342 */     return getRelationshipsHelper(null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PackageRelationshipCollection getRelationshipsByType(String paramString) {
/* 1355 */     throwExceptionIfWriteOnly();
/* 1356 */     if (paramString == null) {
/* 1357 */       throw new IllegalArgumentException("relationshipType");
/*      */     }
/* 1359 */     return getRelationshipsHelper(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private PackageRelationshipCollection getRelationshipsHelper(String paramString) {
/* 1370 */     throwExceptionIfWriteOnly();
/* 1371 */     ensureRelationships();
/* 1372 */     return this.relationships.getRelationships(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clearRelationships() {
/* 1380 */     if (this.relationships != null) {
/* 1381 */       this.relationships.clear();
/* 1382 */       this.isDirty = true;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void ensureRelationships() {
/* 1390 */     if (this.relationships == null) {
/*      */       try {
/* 1392 */         this.relationships = new PackageRelationshipCollection(this);
/* 1393 */       } catch (InvalidFormatException invalidFormatException) {
/* 1394 */         this.relationships = new PackageRelationshipCollection();
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PackageRelationship getRelationship(String paramString) {
/* 1404 */     return this.relationships.getRelationshipByID(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasRelationships() {
/* 1412 */     return (this.relationships.size() > 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isRelationshipExists(PackageRelationship paramPackageRelationship) {
/* 1420 */     for (PackageRelationship packageRelationship : getRelationships()) {
/* 1421 */       if (packageRelationship == paramPackageRelationship) {
/* 1422 */         return true;
/*      */       }
/*      */     } 
/* 1425 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addMarshaller(String paramString, PartMarshaller paramPartMarshaller) {
/*      */     try {
/* 1438 */       this.partMarshallers.put(new ContentType(paramString), paramPartMarshaller);
/* 1439 */     } catch (InvalidFormatException invalidFormatException) {
/* 1440 */       logger.log(5, new Object[] { "The specified content type is not valid: '" + invalidFormatException.getMessage() + "'. The marshaller will not be added !" });
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addUnmarshaller(String paramString, PartUnmarshaller paramPartUnmarshaller) {
/*      */     try {
/* 1456 */       this.partUnmarshallers.put(new ContentType(paramString), paramPartUnmarshaller);
/* 1457 */     } catch (InvalidFormatException invalidFormatException) {
/* 1458 */       logger.log(5, new Object[] { "The specified content type is not valid: '" + invalidFormatException.getMessage() + "'. The unmarshaller will not be added !" });
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeMarshaller(String paramString) {
/*      */     try {
/* 1472 */       this.partMarshallers.remove(new ContentType(paramString));
/* 1473 */     } catch (InvalidFormatException invalidFormatException) {
/* 1474 */       throw new RuntimeException(invalidFormatException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeUnmarshaller(String paramString) {
/*      */     try {
/* 1486 */       this.partUnmarshallers.remove(new ContentType(paramString));
/* 1487 */     } catch (InvalidFormatException invalidFormatException) {
/* 1488 */       throw new RuntimeException(invalidFormatException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PackageAccess getPackageAccess() {
/* 1500 */     return this.packageAccess;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NotImplemented
/*      */   public boolean validatePackage(OPCPackage paramOPCPackage) throws InvalidFormatException {
/* 1510 */     throw new InvalidOperationException("Not implemented yet !!!");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void save(File paramFile) throws IOException {
/* 1523 */     if (paramFile == null) {
/* 1524 */       throw new IllegalArgumentException("targetFile");
/*      */     }
/*      */     
/* 1527 */     throwExceptionIfReadOnly();
/*      */ 
/*      */     
/* 1530 */     if (paramFile.exists() && paramFile.getAbsolutePath().equals(this.originalPackagePath))
/*      */     {
/* 1532 */       throw new InvalidOperationException("You can't call save(File) to save to the currently open file. To save to the current file, please just call close()");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1539 */     FileOutputStream fileOutputStream = null;
/*      */     try {
/* 1541 */       fileOutputStream = new FileOutputStream(paramFile);
/* 1542 */       save(fileOutputStream);
/*      */     } finally {
/* 1544 */       if (fileOutputStream != null) fileOutputStream.close();
/*      */     
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void save(OutputStream paramOutputStream) throws IOException {
/* 1556 */     throwExceptionIfReadOnly();
/* 1557 */     saveImpl(paramOutputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected abstract PackagePart createPartImpl(PackagePartName paramPackagePartName, String paramString, boolean paramBoolean);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected abstract void removePartImpl(PackagePartName paramPackagePartName);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected abstract void flushImpl();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected abstract void closeImpl() throws IOException;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected abstract void revertImpl();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected abstract void saveImpl(OutputStream paramOutputStream) throws IOException;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected abstract PackagePart getPartImpl(PackagePartName paramPackagePartName);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected abstract PackagePart[] getPartsImpl() throws InvalidFormatException;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean replaceContentType(String paramString1, String paramString2) {
/* 1659 */     boolean bool = false;
/* 1660 */     ArrayList<PackagePart> arrayList = getPartsByContentType(paramString1);
/* 1661 */     for (PackagePart packagePart : arrayList) {
/* 1662 */       if (packagePart.getContentType().equals(paramString1)) {
/* 1663 */         PackagePartName packagePartName = packagePart.getPartName();
/* 1664 */         this.contentTypeManager.addContentType(packagePartName, paramString2);
/* 1665 */         bool = true;
/*      */       } 
/*      */     } 
/* 1668 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void registerPartAndContentType(PackagePart paramPackagePart) {
/* 1679 */     addPackagePart(paramPackagePart);
/* 1680 */     this.contentTypeManager.addContentType(paramPackagePart.getPartName(), paramPackagePart.getContentType());
/* 1681 */     this.isDirty = true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unregisterPartAndContentType(PackagePartName paramPackagePartName) {
/* 1692 */     removePart(paramPackagePartName);
/* 1693 */     this.contentTypeManager.removeContentType(paramPackagePartName);
/* 1694 */     this.isDirty = true;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\OPCPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */