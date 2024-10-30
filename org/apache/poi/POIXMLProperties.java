/*     */ package org.apache.poi;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Date;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*     */ import org.apache.poi.openxml4j.opc.ContentTypes;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackagePartName;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
/*     */ import org.apache.poi.openxml4j.opc.PackagingURIHelper;
/*     */ import org.apache.poi.openxml4j.opc.StreamHelper;
/*     */ import org.apache.poi.openxml4j.opc.TargetMode;
/*     */ import org.apache.poi.openxml4j.opc.internal.PackagePropertiesPart;
/*     */ import org.apache.poi.openxml4j.util.Nullable;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties;
/*     */ import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty;
/*     */ import org.openxmlformats.schemas.officeDocument.x2006.customProperties.PropertiesDocument;
/*     */ import org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties;
/*     */ import org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.PropertiesDocument;
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
/*     */ public class POIXMLProperties
/*     */ {
/*     */   private OPCPackage pkg;
/*     */   private CoreProperties core;
/*     */   private ExtendedProperties ext;
/*     */   private CustomProperties cust;
/*     */   private PackagePart extPart;
/*     */   private PackagePart custPart;
/*  60 */   private static final PropertiesDocument NEW_EXT_INSTANCE = PropertiesDocument.Factory.newInstance(); static {
/*  61 */     NEW_EXT_INSTANCE.addNewProperties();
/*     */   }
/*  63 */   private static final PropertiesDocument NEW_CUST_INSTANCE = PropertiesDocument.Factory.newInstance(); static {
/*  64 */     NEW_CUST_INSTANCE.addNewProperties();
/*     */   }
/*     */   
/*     */   public POIXMLProperties(OPCPackage paramOPCPackage) throws IOException, OpenXML4JException, XmlException {
/*  68 */     this.pkg = paramOPCPackage;
/*     */ 
/*     */     
/*  71 */     this.core = new CoreProperties((PackagePropertiesPart)this.pkg.getPackageProperties());
/*     */ 
/*     */     
/*  74 */     PackageRelationshipCollection packageRelationshipCollection1 = this.pkg.getRelationshipsByType("http://schemas.openxmlformats.org/officeDocument/2006/relationships/extended-properties");
/*     */     
/*  76 */     if (packageRelationshipCollection1.size() == 1) {
/*  77 */       this.extPart = this.pkg.getPart(packageRelationshipCollection1.getRelationship(0));
/*  78 */       PropertiesDocument propertiesDocument = PropertiesDocument.Factory.parse(this.extPart.getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */ 
/*     */       
/*  81 */       this.ext = new ExtendedProperties(propertiesDocument);
/*     */     } else {
/*  83 */       this.extPart = null;
/*  84 */       this.ext = new ExtendedProperties((PropertiesDocument)NEW_EXT_INSTANCE.copy());
/*     */     } 
/*     */ 
/*     */     
/*  88 */     PackageRelationshipCollection packageRelationshipCollection2 = this.pkg.getRelationshipsByType("http://schemas.openxmlformats.org/officeDocument/2006/relationships/custom-properties");
/*     */     
/*  90 */     if (packageRelationshipCollection2.size() == 1) {
/*  91 */       this.custPart = this.pkg.getPart(packageRelationshipCollection2.getRelationship(0));
/*  92 */       PropertiesDocument propertiesDocument = PropertiesDocument.Factory.parse(this.custPart.getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */ 
/*     */       
/*  95 */       this.cust = new CustomProperties(propertiesDocument);
/*     */     } else {
/*  97 */       this.custPart = null;
/*  98 */       this.cust = new CustomProperties((PropertiesDocument)NEW_CUST_INSTANCE.copy());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CoreProperties getCoreProperties() {
/* 108 */     return this.core;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExtendedProperties getExtendedProperties() {
/* 117 */     return this.ext;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CustomProperties getCustomProperties() {
/* 126 */     return this.cust;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected PackagePart getThumbnailPart() {
/* 136 */     PackageRelationshipCollection packageRelationshipCollection = this.pkg.getRelationshipsByType("http://schemas.openxmlformats.org/package/2006/relationships/metadata/thumbnail");
/*     */     
/* 138 */     if (packageRelationshipCollection.size() == 1) {
/* 139 */       return this.pkg.getPart(packageRelationshipCollection.getRelationship(0));
/*     */     }
/* 141 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getThumbnailFilename() {
/* 151 */     PackagePart packagePart = getThumbnailPart();
/* 152 */     if (packagePart == null) return null; 
/* 153 */     String str = packagePart.getPartName().getName();
/* 154 */     return str.substring(str.lastIndexOf('/'));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getThumbnailImage() throws IOException {
/* 164 */     PackagePart packagePart = getThumbnailPart();
/* 165 */     if (packagePart == null) return null; 
/* 166 */     return packagePart.getInputStream();
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
/*     */   public void setThumbnail(String paramString, InputStream paramInputStream) throws IOException {
/* 178 */     PackagePart packagePart = getThumbnailPart();
/* 179 */     if (packagePart == null) {
/*     */       
/* 181 */       this.pkg.addThumbnail(paramString, paramInputStream);
/*     */     } else {
/*     */       
/* 184 */       String str = ContentTypes.getContentTypeFromFileExtension(paramString);
/* 185 */       if (!str.equals(packagePart.getContentType())) {
/* 186 */         throw new IllegalArgumentException("Can't set a Thumbnail of type " + str + " when existing one is of a different type " + packagePart.getContentType());
/*     */       }
/*     */ 
/*     */       
/* 190 */       StreamHelper.copyStream(paramInputStream, packagePart.getOutputStream());
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
/*     */   public void commit() throws IOException {
/* 202 */     if (this.extPart == null && !NEW_EXT_INSTANCE.toString().equals(this.ext.props.toString())) {
/*     */       try {
/* 204 */         PackagePartName packagePartName = PackagingURIHelper.createPartName("/docProps/app.xml");
/* 205 */         this.pkg.addRelationship(packagePartName, TargetMode.INTERNAL, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/extended-properties");
/* 206 */         this.extPart = this.pkg.createPart(packagePartName, "application/vnd.openxmlformats-officedocument.extended-properties+xml");
/* 207 */       } catch (InvalidFormatException invalidFormatException) {
/* 208 */         throw new POIXMLException(invalidFormatException);
/*     */       } 
/*     */     }
/* 211 */     if (this.custPart == null && !NEW_CUST_INSTANCE.toString().equals(this.cust.props.toString())) {
/*     */       try {
/* 213 */         PackagePartName packagePartName = PackagingURIHelper.createPartName("/docProps/custom.xml");
/* 214 */         this.pkg.addRelationship(packagePartName, TargetMode.INTERNAL, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/custom-properties");
/* 215 */         this.custPart = this.pkg.createPart(packagePartName, "application/vnd.openxmlformats-officedocument.custom-properties+xml");
/* 216 */       } catch (InvalidFormatException invalidFormatException) {
/* 217 */         throw new POIXMLException(invalidFormatException);
/*     */       } 
/*     */     }
/* 220 */     if (this.extPart != null) {
/* 221 */       OutputStream outputStream = this.extPart.getOutputStream();
/* 222 */       if (this.extPart.getSize() > 0L) {
/* 223 */         this.extPart.clear();
/*     */       }
/* 225 */       this.ext.props.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 226 */       outputStream.close();
/*     */     } 
/* 228 */     if (this.custPart != null) {
/* 229 */       OutputStream outputStream = this.custPart.getOutputStream();
/* 230 */       this.cust.props.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 231 */       outputStream.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static class CoreProperties
/*     */   {
/*     */     private PackagePropertiesPart part;
/*     */     
/*     */     private CoreProperties(PackagePropertiesPart param1PackagePropertiesPart) {
/* 241 */       this.part = param1PackagePropertiesPart;
/*     */     }
/*     */     
/*     */     public String getCategory() {
/* 245 */       return (String)this.part.getCategoryProperty().getValue();
/*     */     }
/*     */     public void setCategory(String param1String) {
/* 248 */       this.part.setCategoryProperty(param1String);
/*     */     }
/*     */     public String getContentStatus() {
/* 251 */       return (String)this.part.getContentStatusProperty().getValue();
/*     */     }
/*     */     public void setContentStatus(String param1String) {
/* 254 */       this.part.setContentStatusProperty(param1String);
/*     */     }
/*     */     public String getContentType() {
/* 257 */       return (String)this.part.getContentTypeProperty().getValue();
/*     */     }
/*     */     public void setContentType(String param1String) {
/* 260 */       this.part.setContentTypeProperty(param1String);
/*     */     }
/*     */     public Date getCreated() {
/* 263 */       return (Date)this.part.getCreatedProperty().getValue();
/*     */     }
/*     */     public void setCreated(Nullable<Date> param1Nullable) {
/* 266 */       this.part.setCreatedProperty(param1Nullable);
/*     */     }
/*     */     public void setCreated(String param1String) {
/* 269 */       this.part.setCreatedProperty(param1String);
/*     */     }
/*     */     public String getCreator() {
/* 272 */       return (String)this.part.getCreatorProperty().getValue();
/*     */     }
/*     */     public void setCreator(String param1String) {
/* 275 */       this.part.setCreatorProperty(param1String);
/*     */     }
/*     */     public String getDescription() {
/* 278 */       return (String)this.part.getDescriptionProperty().getValue();
/*     */     }
/*     */     public void setDescription(String param1String) {
/* 281 */       this.part.setDescriptionProperty(param1String);
/*     */     }
/*     */     public String getIdentifier() {
/* 284 */       return (String)this.part.getIdentifierProperty().getValue();
/*     */     }
/*     */     public void setIdentifier(String param1String) {
/* 287 */       this.part.setIdentifierProperty(param1String);
/*     */     }
/*     */     public String getKeywords() {
/* 290 */       return (String)this.part.getKeywordsProperty().getValue();
/*     */     }
/*     */     public void setKeywords(String param1String) {
/* 293 */       this.part.setKeywordsProperty(param1String);
/*     */     }
/*     */     public Date getLastPrinted() {
/* 296 */       return (Date)this.part.getLastPrintedProperty().getValue();
/*     */     }
/*     */     public void setLastPrinted(Nullable<Date> param1Nullable) {
/* 299 */       this.part.setLastPrintedProperty(param1Nullable);
/*     */     }
/*     */     public void setLastPrinted(String param1String) {
/* 302 */       this.part.setLastPrintedProperty(param1String);
/*     */     }
/*     */     
/*     */     public String getLastModifiedByUser() {
/* 306 */       return (String)this.part.getLastModifiedByProperty().getValue();
/*     */     }
/*     */     
/*     */     public void setLastModifiedByUser(String param1String) {
/* 310 */       this.part.setLastModifiedByProperty(param1String);
/*     */     }
/*     */     public Date getModified() {
/* 313 */       return (Date)this.part.getModifiedProperty().getValue();
/*     */     }
/*     */     public void setModified(Nullable<Date> param1Nullable) {
/* 316 */       this.part.setModifiedProperty(param1Nullable);
/*     */     }
/*     */     public void setModified(String param1String) {
/* 319 */       this.part.setModifiedProperty(param1String);
/*     */     }
/*     */     public String getSubject() {
/* 322 */       return (String)this.part.getSubjectProperty().getValue();
/*     */     }
/*     */     public void setSubjectProperty(String param1String) {
/* 325 */       this.part.setSubjectProperty(param1String);
/*     */     }
/*     */     public void setTitle(String param1String) {
/* 328 */       this.part.setTitleProperty(param1String);
/*     */     }
/*     */     public String getTitle() {
/* 331 */       return (String)this.part.getTitleProperty().getValue();
/*     */     }
/*     */     public String getRevision() {
/* 334 */       return (String)this.part.getRevisionProperty().getValue();
/*     */     }
/*     */     public void setRevision(String param1String) {
/*     */       try {
/* 338 */         Long.valueOf(param1String);
/* 339 */         this.part.setRevisionProperty(param1String);
/*     */       }
/* 341 */       catch (NumberFormatException numberFormatException) {}
/*     */     }
/*     */     
/*     */     public PackagePropertiesPart getUnderlyingProperties() {
/* 345 */       return this.part;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class ExtendedProperties
/*     */   {
/*     */     private PropertiesDocument props;
/*     */     
/*     */     private ExtendedProperties(PropertiesDocument param1PropertiesDocument) {
/* 355 */       this.props = param1PropertiesDocument;
/*     */     }
/*     */     
/*     */     public CTProperties getUnderlyingProperties() {
/* 359 */       return this.props.getProperties();
/*     */     }
/*     */     
/*     */     public String getTemplate() {
/* 363 */       if (this.props.getProperties().isSetTemplate()) {
/* 364 */         return this.props.getProperties().getTemplate();
/*     */       }
/* 366 */       return null;
/*     */     }
/*     */     public String getManager() {
/* 369 */       if (this.props.getProperties().isSetManager()) {
/* 370 */         return this.props.getProperties().getManager();
/*     */       }
/* 372 */       return null;
/*     */     }
/*     */     public String getCompany() {
/* 375 */       if (this.props.getProperties().isSetCompany()) {
/* 376 */         return this.props.getProperties().getCompany();
/*     */       }
/* 378 */       return null;
/*     */     }
/*     */     public String getPresentationFormat() {
/* 381 */       if (this.props.getProperties().isSetPresentationFormat()) {
/* 382 */         return this.props.getProperties().getPresentationFormat();
/*     */       }
/* 384 */       return null;
/*     */     }
/*     */     public String getApplication() {
/* 387 */       if (this.props.getProperties().isSetApplication()) {
/* 388 */         return this.props.getProperties().getApplication();
/*     */       }
/* 390 */       return null;
/*     */     }
/*     */     public String getAppVersion() {
/* 393 */       if (this.props.getProperties().isSetAppVersion()) {
/* 394 */         return this.props.getProperties().getAppVersion();
/*     */       }
/* 396 */       return null;
/*     */     }
/*     */     
/*     */     public int getPages() {
/* 400 */       if (this.props.getProperties().isSetPages()) {
/* 401 */         return this.props.getProperties().getPages();
/*     */       }
/* 403 */       return -1;
/*     */     }
/*     */     public int getWords() {
/* 406 */       if (this.props.getProperties().isSetWords()) {
/* 407 */         return this.props.getProperties().getWords();
/*     */       }
/* 409 */       return -1;
/*     */     }
/*     */     public int getCharacters() {
/* 412 */       if (this.props.getProperties().isSetCharacters()) {
/* 413 */         return this.props.getProperties().getCharacters();
/*     */       }
/* 415 */       return -1;
/*     */     }
/*     */     public int getCharactersWithSpaces() {
/* 418 */       if (this.props.getProperties().isSetCharactersWithSpaces()) {
/* 419 */         return this.props.getProperties().getCharactersWithSpaces();
/*     */       }
/* 421 */       return -1;
/*     */     }
/*     */     public int getLines() {
/* 424 */       if (this.props.getProperties().isSetLines()) {
/* 425 */         return this.props.getProperties().getLines();
/*     */       }
/* 427 */       return -1;
/*     */     }
/*     */     public int getParagraphs() {
/* 430 */       if (this.props.getProperties().isSetParagraphs()) {
/* 431 */         return this.props.getProperties().getParagraphs();
/*     */       }
/* 433 */       return -1;
/*     */     }
/*     */     public int getSlides() {
/* 436 */       if (this.props.getProperties().isSetSlides()) {
/* 437 */         return this.props.getProperties().getSlides();
/*     */       }
/* 439 */       return -1;
/*     */     }
/*     */     public int getNotes() {
/* 442 */       if (this.props.getProperties().isSetNotes()) {
/* 443 */         return this.props.getProperties().getNotes();
/*     */       }
/* 445 */       return -1;
/*     */     }
/*     */     public int getTotalTime() {
/* 448 */       if (this.props.getProperties().isSetTotalTime()) {
/* 449 */         return this.props.getProperties().getTotalTime();
/*     */       }
/* 451 */       return -1;
/*     */     }
/*     */     public int getHiddenSlides() {
/* 454 */       if (this.props.getProperties().isSetHiddenSlides()) {
/* 455 */         return this.props.getProperties().getHiddenSlides();
/*     */       }
/* 457 */       return -1;
/*     */     }
/*     */     public int getMMClips() {
/* 460 */       if (this.props.getProperties().isSetMMClips()) {
/* 461 */         return this.props.getProperties().getMMClips();
/*     */       }
/* 463 */       return -1;
/*     */     }
/*     */     
/*     */     public String getHyperlinkBase() {
/* 467 */       if (this.props.getProperties().isSetHyperlinkBase()) {
/* 468 */         return this.props.getProperties().getHyperlinkBase();
/*     */       }
/* 470 */       return null;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CustomProperties
/*     */   {
/*     */     public static final String FORMAT_ID = "{D5CDD505-2E9C-101B-9397-08002B2CF9AE}";
/*     */ 
/*     */     
/*     */     private PropertiesDocument props;
/*     */ 
/*     */ 
/*     */     
/*     */     private CustomProperties(PropertiesDocument param1PropertiesDocument) {
/* 486 */       this.props = param1PropertiesDocument;
/*     */     }
/*     */     
/*     */     public CTProperties getUnderlyingProperties() {
/* 490 */       return this.props.getProperties();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private CTProperty add(String param1String) {
/* 500 */       if (contains(param1String)) {
/* 501 */         throw new IllegalArgumentException("A property with this name already exists in the custom properties");
/*     */       }
/*     */ 
/*     */       
/* 505 */       CTProperty cTProperty = this.props.getProperties().addNewProperty();
/* 506 */       int i = nextPid();
/* 507 */       cTProperty.setPid(i);
/* 508 */       cTProperty.setFmtid("{D5CDD505-2E9C-101B-9397-08002B2CF9AE}");
/* 509 */       cTProperty.setName(param1String);
/* 510 */       return cTProperty;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void addProperty(String param1String1, String param1String2) {
/* 522 */       CTProperty cTProperty = add(param1String1);
/* 523 */       cTProperty.setLpwstr(param1String2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void addProperty(String param1String, double param1Double) {
/* 535 */       CTProperty cTProperty = add(param1String);
/* 536 */       cTProperty.setR8(param1Double);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void addProperty(String param1String, int param1Int) {
/* 548 */       CTProperty cTProperty = add(param1String);
/* 549 */       cTProperty.setI4(param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void addProperty(String param1String, boolean param1Boolean) {
/* 561 */       CTProperty cTProperty = add(param1String);
/* 562 */       cTProperty.setBool(param1Boolean);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected int nextPid() {
/* 571 */       int i = 1;
/* 572 */       for (CTProperty cTProperty : this.props.getProperties().getPropertyArray()) {
/* 573 */         if (cTProperty.getPid() > i) i = cTProperty.getPid(); 
/*     */       } 
/* 575 */       return i + 1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean contains(String param1String) {
/* 585 */       for (CTProperty cTProperty : this.props.getProperties().getPropertyArray()) {
/* 586 */         if (cTProperty.getName().equals(param1String)) return true; 
/*     */       } 
/* 588 */       return false;
/*     */     }
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
/*     */     public CTProperty getProperty(String param1String) {
/* 603 */       for (CTProperty cTProperty : this.props.getProperties().getPropertyArray()) {
/* 604 */         if (cTProperty.getName().equals(param1String)) {
/* 605 */           return cTProperty;
/*     */         }
/*     */       } 
/* 608 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\POIXMLProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */