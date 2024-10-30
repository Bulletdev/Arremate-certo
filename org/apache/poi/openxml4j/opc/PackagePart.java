/*     */ package org.apache.poi.openxml4j.opc;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*     */ import org.apache.poi.openxml4j.opc.internal.ContentType;
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
/*     */ public abstract class PackagePart
/*     */   implements Comparable<PackagePart>, RelationshipSource
/*     */ {
/*     */   protected OPCPackage _container;
/*     */   protected PackagePartName _partName;
/*     */   protected ContentType _contentType;
/*     */   private boolean _isRelationshipPart;
/*     */   private boolean _isDeleted;
/*     */   private PackageRelationshipCollection _relationships;
/*     */   
/*     */   protected PackagePart(OPCPackage paramOPCPackage, PackagePartName paramPackagePartName, ContentType paramContentType) throws InvalidFormatException {
/*  80 */     this(paramOPCPackage, paramPackagePartName, paramContentType, true);
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
/*     */ 
/*     */   
/*     */   protected PackagePart(OPCPackage paramOPCPackage, PackagePartName paramPackagePartName, ContentType paramContentType, boolean paramBoolean) throws InvalidFormatException {
/* 100 */     this._partName = paramPackagePartName;
/* 101 */     this._contentType = paramContentType;
/* 102 */     this._container = paramOPCPackage;
/*     */ 
/*     */     
/* 105 */     this._isRelationshipPart = this._partName.isRelationshipPartURI();
/*     */ 
/*     */     
/* 108 */     if (paramBoolean) {
/* 109 */       loadRelationships();
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
/*     */   public PackagePart(OPCPackage paramOPCPackage, PackagePartName paramPackagePartName, String paramString) throws InvalidFormatException {
/* 125 */     this(paramOPCPackage, paramPackagePartName, new ContentType(paramString));
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
/*     */ 
/*     */   
/*     */   public PackageRelationship addExternalRelationship(String paramString1, String paramString2) {
/* 145 */     return addExternalRelationship(paramString1, paramString2, null);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public PackageRelationship addExternalRelationship(String paramString1, String paramString2, String paramString3) {
/*     */     URI uRI;
/* 167 */     if (paramString1 == null) {
/* 168 */       throw new IllegalArgumentException("target is null for type " + paramString2);
/*     */     }
/* 170 */     if (paramString2 == null) {
/* 171 */       throw new IllegalArgumentException("relationshipType");
/*     */     }
/*     */     
/* 174 */     if (this._relationships == null) {
/* 175 */       this._relationships = new PackageRelationshipCollection();
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 180 */       uRI = new URI(paramString1);
/* 181 */     } catch (URISyntaxException uRISyntaxException) {
/* 182 */       throw new IllegalArgumentException("Invalid target - " + uRISyntaxException);
/*     */     } 
/*     */     
/* 185 */     return this._relationships.addRelationship(uRI, TargetMode.EXTERNAL, paramString2, paramString3);
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
/*     */ 
/*     */   
/*     */   public PackageRelationship addRelationship(PackagePartName paramPackagePartName, TargetMode paramTargetMode, String paramString) {
/* 205 */     return addRelationship(paramPackagePartName, paramTargetMode, paramString, (String)null);
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
/*     */   public PackageRelationship addRelationship(PackagePartName paramPackagePartName, TargetMode paramTargetMode, String paramString1, String paramString2) {
/* 240 */     this._container.throwExceptionIfReadOnly();
/*     */     
/* 242 */     if (paramPackagePartName == null) {
/* 243 */       throw new IllegalArgumentException("targetPartName");
/*     */     }
/* 245 */     if (paramTargetMode == null) {
/* 246 */       throw new IllegalArgumentException("targetMode");
/*     */     }
/* 248 */     if (paramString1 == null) {
/* 249 */       throw new IllegalArgumentException("relationshipType");
/*     */     }
/*     */     
/* 252 */     if (this._isRelationshipPart || paramPackagePartName.isRelationshipPartURI()) {
/* 253 */       throw new InvalidOperationException("Rule M1.25: The Relationships part shall not have relationships to any other part.");
/*     */     }
/*     */ 
/*     */     
/* 257 */     if (this._relationships == null) {
/* 258 */       this._relationships = new PackageRelationshipCollection();
/*     */     }
/*     */     
/* 261 */     return this._relationships.addRelationship(paramPackagePartName.getURI(), paramTargetMode, paramString1, paramString2);
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
/*     */ 
/*     */   
/*     */   public PackageRelationship addRelationship(URI paramURI, TargetMode paramTargetMode, String paramString) {
/* 281 */     return addRelationship(paramURI, paramTargetMode, paramString, (String)null);
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
/*     */   public PackageRelationship addRelationship(URI paramURI, TargetMode paramTargetMode, String paramString1, String paramString2) {
/* 310 */     this._container.throwExceptionIfReadOnly();
/*     */     
/* 312 */     if (paramURI == null) {
/* 313 */       throw new IllegalArgumentException("targetPartName");
/*     */     }
/* 315 */     if (paramTargetMode == null) {
/* 316 */       throw new IllegalArgumentException("targetMode");
/*     */     }
/* 318 */     if (paramString1 == null) {
/* 319 */       throw new IllegalArgumentException("relationshipType");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 324 */     if (this._isRelationshipPart || PackagingURIHelper.isRelationshipPartURI(paramURI))
/*     */     {
/* 326 */       throw new InvalidOperationException("Rule M1.25: The Relationships part shall not have relationships to any other part.");
/*     */     }
/*     */ 
/*     */     
/* 330 */     if (this._relationships == null) {
/* 331 */       this._relationships = new PackageRelationshipCollection();
/*     */     }
/*     */     
/* 334 */     return this._relationships.addRelationship(paramURI, paramTargetMode, paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearRelationships() {
/* 342 */     if (this._relationships != null) {
/* 343 */       this._relationships.clear();
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
/*     */   public void removeRelationship(String paramString) {
/* 355 */     this._container.throwExceptionIfReadOnly();
/* 356 */     if (this._relationships != null) {
/* 357 */       this._relationships.removeRelationship(paramString);
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
/*     */   public PackageRelationshipCollection getRelationships() throws InvalidFormatException {
/* 369 */     return getRelationshipsCore(null);
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
/*     */   public PackageRelationship getRelationship(String paramString) {
/* 381 */     return this._relationships.getRelationshipByID(paramString);
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
/*     */   public PackageRelationshipCollection getRelationshipsByType(String paramString) throws InvalidFormatException {
/* 399 */     this._container.throwExceptionIfWriteOnly();
/*     */     
/* 401 */     return getRelationshipsCore(paramString);
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
/*     */   
/*     */   private PackageRelationshipCollection getRelationshipsCore(String paramString) throws InvalidFormatException {
/* 420 */     this._container.throwExceptionIfWriteOnly();
/* 421 */     if (this._relationships == null) {
/* 422 */       throwExceptionIfRelationship();
/* 423 */       this._relationships = new PackageRelationshipCollection(this);
/*     */     } 
/* 425 */     return new PackageRelationshipCollection(this._relationships, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasRelationships() {
/* 436 */     return (!this._isRelationshipPart && this._relationships != null && this._relationships.size() > 0);
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
/*     */   public boolean isRelationshipExists(PackageRelationship paramPackageRelationship) {
/*     */     try {
/* 451 */       for (PackageRelationship packageRelationship : getRelationships()) {
/* 452 */         if (packageRelationship == paramPackageRelationship)
/* 453 */           return true; 
/*     */       } 
/* 455 */     } catch (InvalidFormatException invalidFormatException) {}
/*     */     
/* 457 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PackagePart getRelatedPart(PackageRelationship paramPackageRelationship) throws InvalidFormatException {
/* 468 */     if (!isRelationshipExists(paramPackageRelationship)) {
/* 469 */       throw new IllegalArgumentException("Relationship " + paramPackageRelationship + " doesn't start with this part " + this._partName);
/*     */     }
/*     */ 
/*     */     
/* 473 */     URI uRI = paramPackageRelationship.getTargetURI();
/* 474 */     if (uRI.getFragment() != null) {
/* 475 */       String str = uRI.toString();
/*     */       try {
/* 477 */         uRI = new URI(str.substring(0, str.indexOf('#')));
/* 478 */       } catch (URISyntaxException uRISyntaxException) {
/* 479 */         throw new InvalidFormatException("Invalid target URI: " + uRI);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 484 */     PackagePartName packagePartName = PackagingURIHelper.createPartName(uRI);
/* 485 */     PackagePart packagePart = this._container.getPart(packagePartName);
/* 486 */     if (packagePart == null) {
/* 487 */       throw new IllegalArgumentException("No part found for relationship " + paramPackageRelationship);
/*     */     }
/* 489 */     return packagePart;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getInputStream() throws IOException {
/* 499 */     InputStream inputStream = getInputStreamImpl();
/* 500 */     if (inputStream == null) {
/* 501 */       throw new IOException("Can't obtain the input stream from " + this._partName.getName());
/*     */     }
/*     */     
/* 504 */     return inputStream;
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
/*     */   public OutputStream getOutputStream() {
/*     */     OutputStream outputStream;
/* 519 */     if (this instanceof ZipPackagePart) {
/*     */       
/* 521 */       this._container.removePart(this._partName);
/*     */ 
/*     */       
/* 524 */       PackagePart packagePart = this._container.createPart(this._partName, this._contentType.toString(), false);
/*     */       
/* 526 */       if (packagePart == null) {
/* 527 */         throw new InvalidOperationException("Can't create a temporary part !");
/*     */       }
/*     */       
/* 530 */       packagePart._relationships = this._relationships;
/* 531 */       outputStream = packagePart.getOutputStreamImpl();
/*     */     } else {
/* 533 */       outputStream = getOutputStreamImpl();
/*     */     } 
/* 535 */     return outputStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void throwExceptionIfRelationship() throws InvalidOperationException {
/* 546 */     if (this._isRelationshipPart) {
/* 547 */       throw new InvalidOperationException("Can do this operation on a relationship part !");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void loadRelationships() throws InvalidFormatException {
/* 558 */     if (this._relationships == null && !this._isRelationshipPart) {
/* 559 */       throwExceptionIfRelationship();
/* 560 */       this._relationships = new PackageRelationshipCollection(this);
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
/*     */   public PackagePartName getPartName() {
/* 572 */     return this._partName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getContentType() {
/* 579 */     return this._contentType.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ContentType getContentTypeDetails() {
/* 586 */     return this._contentType;
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
/*     */   public void setContentType(String paramString) throws InvalidFormatException {
/* 603 */     if (this._container == null) {
/* 604 */       this._contentType = new ContentType(paramString);
/*     */     } else {
/*     */       
/* 607 */       this._container.unregisterPartAndContentType(this._partName);
/* 608 */       this._contentType = new ContentType(paramString);
/* 609 */       this._container.registerPartAndContentType(this);
/*     */     } 
/*     */   }
/*     */   
/*     */   public OPCPackage getPackage() {
/* 614 */     return this._container;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRelationshipPart() {
/* 621 */     return this._isRelationshipPart;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDeleted() {
/* 628 */     return this._isDeleted;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDeleted(boolean paramBoolean) {
/* 636 */     this._isDeleted = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getSize() {
/* 643 */     return -1L;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 648 */     return "Name: " + this._partName + " - Content Type: " + this._contentType.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(PackagePart paramPackagePart) {
/* 659 */     if (paramPackagePart == null) {
/* 660 */       return -1;
/*     */     }
/* 662 */     return PackagePartName.compare(this._partName, paramPackagePart._partName);
/*     */   }
/*     */   
/*     */   public void clear() {}
/*     */   
/*     */   protected abstract InputStream getInputStreamImpl() throws IOException;
/*     */   
/*     */   protected abstract OutputStream getOutputStreamImpl();
/*     */   
/*     */   public abstract boolean save(OutputStream paramOutputStream) throws OpenXML4JException;
/*     */   
/*     */   public abstract boolean load(InputStream paramInputStream) throws InvalidFormatException;
/*     */   
/*     */   public abstract void close();
/*     */   
/*     */   public abstract void flush();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\PackagePart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */