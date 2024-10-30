/*     */ package org.apache.poi;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.URI;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*     */ import org.apache.poi.openxml4j.exceptions.PartAlreadyExistsException;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackagePartName;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
/*     */ import org.apache.poi.openxml4j.opc.PackagingURIHelper;
/*     */ import org.apache.poi.openxml4j.opc.TargetMode;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POIXMLDocumentPart
/*     */ {
/*  51 */   private static final POILogger logger = POILogFactory.getLogger(POIXMLDocumentPart.class);
/*     */   
/*  53 */   private String coreDocumentRel = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument";
/*     */   private PackagePart packagePart;
/*     */   private POIXMLDocumentPart parent;
/*  56 */   private Map<String, RelationPart> relations = new LinkedHashMap<String, RelationPart>();
/*     */ 
/*     */ 
/*     */   
/*     */   public static class RelationPart
/*     */   {
/*     */     private final PackageRelationship relationship;
/*     */ 
/*     */     
/*     */     private final POIXMLDocumentPart documentPart;
/*     */ 
/*     */     
/*     */     RelationPart(PackageRelationship param1PackageRelationship, POIXMLDocumentPart param1POIXMLDocumentPart) {
/*  69 */       this.relationship = param1PackageRelationship;
/*  70 */       this.documentPart = param1POIXMLDocumentPart;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PackageRelationship getRelationship() {
/*  77 */       return this.relationship;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public <T extends POIXMLDocumentPart> T getDocumentPart() {
/*  87 */       return (T)this.documentPart;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  95 */   private int relationCounter = 0;
/*     */   
/*     */   int incrementRelationCounter() {
/*  98 */     this.relationCounter++;
/*  99 */     return this.relationCounter;
/*     */   }
/*     */   
/*     */   int decrementRelationCounter() {
/* 103 */     this.relationCounter--;
/* 104 */     return this.relationCounter;
/*     */   }
/*     */   
/*     */   int getRelationCounter() {
/* 108 */     return this.relationCounter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POIXMLDocumentPart(OPCPackage paramOPCPackage) {
/* 117 */     this(paramOPCPackage, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POIXMLDocumentPart(OPCPackage paramOPCPackage, String paramString) {
/* 127 */     this(getPartFromOPCPackage(paramOPCPackage, paramString));
/* 128 */     this.coreDocumentRel = paramString;
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
/*     */   public POIXMLDocumentPart() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POIXMLDocumentPart(PackagePart paramPackagePart) {
/* 149 */     this((POIXMLDocumentPart)null, paramPackagePart);
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
/*     */   public POIXMLDocumentPart(POIXMLDocumentPart paramPOIXMLDocumentPart, PackagePart paramPackagePart) {
/* 163 */     this.packagePart = paramPackagePart;
/* 164 */     this.parent = paramPOIXMLDocumentPart;
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
/*     */   @Deprecated
/*     */   public POIXMLDocumentPart(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) {
/* 179 */     this((POIXMLDocumentPart)null, paramPackagePart);
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
/*     */   @Deprecated
/*     */   public POIXMLDocumentPart(POIXMLDocumentPart paramPOIXMLDocumentPart, PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) {
/* 195 */     this(paramPOIXMLDocumentPart, paramPackagePart);
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
/*     */   protected final void rebase(OPCPackage paramOPCPackage) throws InvalidFormatException {
/* 209 */     PackageRelationshipCollection packageRelationshipCollection = this.packagePart.getRelationshipsByType(this.coreDocumentRel);
/*     */     
/* 211 */     if (packageRelationshipCollection.size() != 1) {
/* 212 */       throw new IllegalStateException("Tried to rebase using " + this.coreDocumentRel + " but found " + packageRelationshipCollection.size() + " parts of the right type");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 217 */     this.packagePart = this.packagePart.getRelatedPart(packageRelationshipCollection.getRelationship(0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final PackagePart getPackagePart() {
/* 226 */     return this.packagePart;
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
/*     */   @Deprecated
/*     */   public final PackageRelationship getPackageRelationship() {
/* 239 */     if (this.parent != null) {
/* 240 */       for (RelationPart relationPart : this.parent.getRelationParts()) {
/* 241 */         if (relationPart.getDocumentPart() == this) {
/* 242 */           return relationPart.getRelationship();
/*     */         }
/*     */       } 
/*     */     } else {
/* 246 */       OPCPackage oPCPackage = getPackagePart().getPackage();
/* 247 */       String str = getPackagePart().getPartName().getName();
/* 248 */       for (PackageRelationship packageRelationship : oPCPackage.getRelationships()) {
/* 249 */         if (packageRelationship.getTargetURI().toASCIIString().equals(str)) {
/* 250 */           return packageRelationship;
/*     */         }
/*     */       } 
/*     */     } 
/* 254 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<POIXMLDocumentPart> getRelations() {
/* 263 */     ArrayList<? extends POIXMLDocumentPart> arrayList = new ArrayList();
/* 264 */     for (RelationPart relationPart : this.relations.values()) {
/* 265 */       arrayList.add(relationPart.getDocumentPart());
/*     */     }
/* 267 */     return Collections.unmodifiableList(arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<RelationPart> getRelationParts() {
/* 276 */     ArrayList<? extends RelationPart> arrayList = new ArrayList(this.relations.values());
/* 277 */     return Collections.unmodifiableList(arrayList);
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
/*     */   public final POIXMLDocumentPart getRelationById(String paramString) {
/* 292 */     RelationPart relationPart = this.relations.get(paramString);
/* 293 */     return (relationPart == null) ? null : relationPart.<POIXMLDocumentPart>getDocumentPart();
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
/*     */   public final String getRelationId(POIXMLDocumentPart paramPOIXMLDocumentPart) {
/* 309 */     for (RelationPart relationPart : this.relations.values()) {
/* 310 */       if (relationPart.getDocumentPart() == paramPOIXMLDocumentPart) {
/* 311 */         return relationPart.getRelationship().getId();
/*     */       }
/*     */     } 
/* 314 */     return null;
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
/*     */   @Deprecated
/*     */   public final void addRelation(String paramString, POIXMLDocumentPart paramPOIXMLDocumentPart) {
/* 327 */     PackageRelationship packageRelationship = paramPOIXMLDocumentPart.getPackagePart().getRelationship(paramString);
/* 328 */     addRelation(packageRelationship, paramPOIXMLDocumentPart);
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
/*     */   public final RelationPart addRelation(String paramString, POIXMLRelation paramPOIXMLRelation, POIXMLDocumentPart paramPOIXMLDocumentPart) {
/* 343 */     PackageRelationship packageRelationship = findExistingRelation(paramPOIXMLDocumentPart);
/* 344 */     if (packageRelationship == null) {
/* 345 */       PackagePartName packagePartName = paramPOIXMLDocumentPart.getPackagePart().getPartName();
/* 346 */       String str = paramPOIXMLRelation.getRelation();
/* 347 */       packageRelationship = this.packagePart.addRelationship(packagePartName, TargetMode.INTERNAL, str, paramString);
/*     */     } 
/* 349 */     addRelation(packageRelationship, paramPOIXMLDocumentPart);
/* 350 */     return new RelationPart(packageRelationship, paramPOIXMLDocumentPart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addRelation(PackageRelationship paramPackageRelationship, POIXMLDocumentPart paramPOIXMLDocumentPart) {
/* 360 */     this.relations.put(paramPackageRelationship.getId(), new RelationPart(paramPackageRelationship, paramPOIXMLDocumentPart));
/* 361 */     paramPOIXMLDocumentPart.incrementRelationCounter();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PackageRelationship findExistingRelation(POIXMLDocumentPart paramPOIXMLDocumentPart) {
/* 372 */     String str = paramPOIXMLDocumentPart.getPackagePart().getPartName().getName();
/*     */     try {
/* 374 */       for (PackageRelationship packageRelationship : this.packagePart.getRelationships()) {
/* 375 */         if (packageRelationship.getTargetMode() == TargetMode.EXTERNAL) {
/*     */           continue;
/*     */         }
/* 378 */         PackagePart packagePart = this.packagePart.getRelatedPart(packageRelationship);
/* 379 */         if (str.equals(packagePart.getPartName().getName())) {
/* 380 */           return packageRelationship;
/*     */         }
/*     */       } 
/* 383 */     } catch (InvalidFormatException invalidFormatException) {
/* 384 */       throw new POIXMLException("invalid package relationships", invalidFormatException);
/*     */     } 
/* 386 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void removeRelation(POIXMLDocumentPart paramPOIXMLDocumentPart) {
/* 396 */     removeRelation(paramPOIXMLDocumentPart, true);
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
/*     */   protected final boolean removeRelation(POIXMLDocumentPart paramPOIXMLDocumentPart, boolean paramBoolean) {
/* 411 */     String str = getRelationId(paramPOIXMLDocumentPart);
/* 412 */     if (str == null)
/*     */     {
/* 414 */       return false;
/*     */     }
/*     */     
/* 417 */     paramPOIXMLDocumentPart.decrementRelationCounter();
/*     */     
/* 419 */     getPackagePart().removeRelationship(str);
/*     */     
/* 421 */     this.relations.remove(str);
/*     */     
/* 423 */     if (paramBoolean)
/*     */     {
/* 425 */       if (paramPOIXMLDocumentPart.getRelationCounter() == 0) {
/*     */         try {
/* 427 */           paramPOIXMLDocumentPart.onDocumentRemove();
/* 428 */         } catch (IOException iOException) {
/* 429 */           throw new POIXMLException(iOException);
/*     */         } 
/* 431 */         getPackagePart().getPackage().removePart(paramPOIXMLDocumentPart.getPackagePart());
/*     */       } 
/*     */     }
/* 434 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final POIXMLDocumentPart getParent() {
/* 443 */     return this.parent;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 448 */     return (this.packagePart == null) ? "" : this.packagePart.toString();
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
/*     */   protected void commit() throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void onSave(Set<PackagePart> paramSet) throws IOException {
/* 484 */     prepareForCommit();
/*     */     
/* 486 */     commit();
/* 487 */     paramSet.add(getPackagePart());
/* 488 */     for (RelationPart relationPart : this.relations.values()) {
/* 489 */       POIXMLDocumentPart pOIXMLDocumentPart = (POIXMLDocumentPart)relationPart.getDocumentPart();
/* 490 */       if (!paramSet.contains(pOIXMLDocumentPart.getPackagePart())) {
/* 491 */         pOIXMLDocumentPart.onSave(paramSet);
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
/*     */   protected void prepareForCommit() {
/* 504 */     PackagePart packagePart = getPackagePart();
/* 505 */     if (packagePart != null) {
/* 506 */       packagePart.clear();
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
/*     */   public final POIXMLDocumentPart createRelationship(POIXMLRelation paramPOIXMLRelation, POIXMLFactory paramPOIXMLFactory) {
/* 522 */     return createRelationship(paramPOIXMLRelation, paramPOIXMLFactory, -1, false).getDocumentPart();
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
/*     */   public final POIXMLDocumentPart createRelationship(POIXMLRelation paramPOIXMLRelation, POIXMLFactory paramPOIXMLFactory, int paramInt) {
/* 538 */     return createRelationship(paramPOIXMLRelation, paramPOIXMLFactory, paramInt, false).getDocumentPart();
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
/*     */   protected final RelationPart createRelationship(POIXMLRelation paramPOIXMLRelation, POIXMLFactory paramPOIXMLFactory, int paramInt, boolean paramBoolean) {
/*     */     try {
/* 556 */       PackagePartName packagePartName = PackagingURIHelper.createPartName(paramPOIXMLRelation.getFileName(paramInt));
/* 557 */       PackageRelationship packageRelationship = null;
/* 558 */       PackagePart packagePart = this.packagePart.getPackage().createPart(packagePartName, paramPOIXMLRelation.getContentType());
/* 559 */       if (!paramBoolean)
/*     */       {
/* 561 */         packageRelationship = this.packagePart.addRelationship(packagePartName, TargetMode.INTERNAL, paramPOIXMLRelation.getRelation());
/*     */       }
/* 563 */       POIXMLDocumentPart pOIXMLDocumentPart = paramPOIXMLFactory.newDocumentPart(paramPOIXMLRelation);
/* 564 */       pOIXMLDocumentPart.packagePart = packagePart;
/* 565 */       pOIXMLDocumentPart.parent = this;
/* 566 */       if (!paramBoolean)
/*     */       {
/* 568 */         addRelation(packageRelationship, pOIXMLDocumentPart);
/*     */       }
/*     */       
/* 571 */       return new RelationPart(packageRelationship, pOIXMLDocumentPart);
/* 572 */     } catch (PartAlreadyExistsException partAlreadyExistsException) {
/*     */ 
/*     */       
/* 575 */       throw partAlreadyExistsException;
/* 576 */     } catch (Exception exception) {
/*     */       
/* 578 */       throw new POIXMLException(exception);
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
/*     */   protected void read(POIXMLFactory paramPOIXMLFactory, Map<PackagePart, POIXMLDocumentPart> paramMap) throws OpenXML4JException {
/* 592 */     PackagePart packagePart = getPackagePart();
/*     */     
/* 594 */     POIXMLDocumentPart pOIXMLDocumentPart = paramMap.put(packagePart, this);
/* 595 */     if (pOIXMLDocumentPart != null && pOIXMLDocumentPart != this) {
/* 596 */       throw new POIXMLException("Unique PackagePart-POIXMLDocumentPart relation broken!");
/*     */     }
/*     */     
/* 599 */     if (!packagePart.hasRelationships())
/*     */       return; 
/* 601 */     PackageRelationshipCollection packageRelationshipCollection = this.packagePart.getRelationships();
/* 602 */     ArrayList<POIXMLDocumentPart> arrayList = new ArrayList();
/*     */ 
/*     */     
/* 605 */     for (PackageRelationship packageRelationship : packageRelationshipCollection) {
/* 606 */       if (packageRelationship.getTargetMode() == TargetMode.INTERNAL) {
/* 607 */         PackagePartName packagePartName; URI uRI = packageRelationship.getTargetURI();
/*     */ 
/*     */ 
/*     */         
/* 611 */         if (uRI.getRawFragment() != null) {
/* 612 */           packagePartName = PackagingURIHelper.createPartName(uRI.getPath());
/*     */         } else {
/* 614 */           packagePartName = PackagingURIHelper.createPartName(uRI);
/*     */         } 
/*     */         
/* 617 */         PackagePart packagePart1 = this.packagePart.getPackage().getPart(packagePartName);
/* 618 */         if (packagePart1 == null) {
/* 619 */           logger.log(7, new Object[] { "Skipped invalid entry " + packageRelationship.getTargetURI() });
/*     */           
/*     */           continue;
/*     */         } 
/* 623 */         POIXMLDocumentPart pOIXMLDocumentPart1 = paramMap.get(packagePart1);
/* 624 */         if (pOIXMLDocumentPart1 == null) {
/* 625 */           pOIXMLDocumentPart1 = paramPOIXMLFactory.createDocumentPart(this, packagePart1);
/* 626 */           pOIXMLDocumentPart1.parent = this;
/*     */           
/* 628 */           paramMap.put(packagePart1, pOIXMLDocumentPart1);
/* 629 */           arrayList.add(pOIXMLDocumentPart1);
/*     */         } 
/*     */         
/* 632 */         addRelation(packageRelationship, pOIXMLDocumentPart1);
/*     */       } 
/*     */     } 
/*     */     
/* 636 */     for (POIXMLDocumentPart pOIXMLDocumentPart1 : arrayList) {
/* 637 */       pOIXMLDocumentPart1.read(paramPOIXMLFactory, paramMap);
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
/*     */   protected PackagePart getTargetPart(PackageRelationship paramPackageRelationship) throws InvalidFormatException {
/* 649 */     return getPackagePart().getRelatedPart(paramPackageRelationship);
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
/*     */   protected void onDocumentCreate() throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onDocumentRead() throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onDocumentRemove() throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   @Deprecated
/*     */   public static void _invokeOnDocumentRead(POIXMLDocumentPart paramPOIXMLDocumentPart) throws IOException {
/* 692 */     paramPOIXMLDocumentPart.onDocumentRead();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static PackagePart getPartFromOPCPackage(OPCPackage paramOPCPackage, String paramString) {
/* 701 */     PackageRelationship packageRelationship = paramOPCPackage.getRelationshipsByType(paramString).getRelationship(0);
/*     */     
/* 703 */     if (packageRelationship != null) {
/* 704 */       PackagePart packagePart = paramOPCPackage.getPart(packageRelationship);
/* 705 */       if (packagePart == null) {
/* 706 */         throw new POIXMLException("OOXML file structure broken/invalid - core document '" + packageRelationship.getTargetURI() + "' not found.");
/*     */       }
/* 708 */       return packagePart;
/*     */     } 
/*     */     
/* 711 */     packageRelationship = paramOPCPackage.getRelationshipsByType("http://purl.oclc.org/ooxml/officeDocument/relationships/officeDocument").getRelationship(0);
/* 712 */     if (packageRelationship != null) {
/* 713 */       throw new POIXMLException("Strict OOXML isn't currently supported, please see bug #57699");
/*     */     }
/*     */     
/* 716 */     throw new POIXMLException("OOXML file structure broken/invalid - no core document found!");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\POIXMLDocumentPart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */