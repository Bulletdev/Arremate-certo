/*     */ package org.apache.poi.openxml4j.opc;
/*     */ 
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.Locale;
/*     */ import java.util.TreeMap;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
/*     */ import org.apache.poi.util.DocumentHelper;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.w3c.dom.Attr;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PackageRelationshipCollection
/*     */   implements Iterable<PackageRelationship>
/*     */ {
/*  46 */   private static POILogger logger = POILogFactory.getLogger(PackageRelationshipCollection.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TreeMap<String, PackageRelationship> relationshipsByID;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TreeMap<String, PackageRelationship> relationshipsByType;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PackagePart relationshipPart;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PackagePart sourcePart;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PackagePartName partName;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private OPCPackage container;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  82 */   private int nextRelationshipId = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PackageRelationshipCollection() {
/*  88 */     this.relationshipsByID = new TreeMap<String, PackageRelationship>();
/*  89 */     this.relationshipsByType = new TreeMap<String, PackageRelationship>();
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
/*     */   public PackageRelationshipCollection(PackageRelationshipCollection paramPackageRelationshipCollection, String paramString) {
/* 106 */     this();
/* 107 */     for (PackageRelationship packageRelationship : paramPackageRelationshipCollection.relationshipsByID.values()) {
/* 108 */       if (paramString == null || packageRelationship.getRelationshipType().equals(paramString)) {
/* 109 */         addRelationship(packageRelationship);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PackageRelationshipCollection(OPCPackage paramOPCPackage) throws InvalidFormatException {
/* 118 */     this(paramOPCPackage, (PackagePart)null);
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
/*     */   public PackageRelationshipCollection(PackagePart paramPackagePart) throws InvalidFormatException {
/* 132 */     this(paramPackagePart._container, paramPackagePart);
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
/*     */   public PackageRelationshipCollection(OPCPackage paramOPCPackage, PackagePart paramPackagePart) throws InvalidFormatException {
/* 149 */     this();
/*     */     
/* 151 */     if (paramOPCPackage == null) {
/* 152 */       throw new IllegalArgumentException("container");
/*     */     }
/*     */     
/* 155 */     if (paramPackagePart != null && paramPackagePart.isRelationshipPart()) {
/* 156 */       throw new IllegalArgumentException("part");
/*     */     }
/* 158 */     this.container = paramOPCPackage;
/* 159 */     this.sourcePart = paramPackagePart;
/* 160 */     this.partName = getRelationshipPartName(paramPackagePart);
/* 161 */     if (paramOPCPackage.getPackageAccess() != PackageAccess.WRITE && paramOPCPackage.containPart(this.partName)) {
/*     */       
/* 163 */       this.relationshipPart = paramOPCPackage.getPart(this.partName);
/* 164 */       parseRelationshipsPart(this.relationshipPart);
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
/*     */   private static PackagePartName getRelationshipPartName(PackagePart paramPackagePart) throws InvalidOperationException {
/*     */     PackagePartName packagePartName;
/* 182 */     if (paramPackagePart == null) {
/* 183 */       packagePartName = PackagingURIHelper.PACKAGE_ROOT_PART_NAME;
/*     */     } else {
/* 185 */       packagePartName = paramPackagePart.getPartName();
/*     */     } 
/* 187 */     return PackagingURIHelper.getRelationshipPartName(packagePartName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addRelationship(PackageRelationship paramPackageRelationship) {
/* 197 */     this.relationshipsByID.put(paramPackageRelationship.getId(), paramPackageRelationship);
/* 198 */     this.relationshipsByType.put(paramPackageRelationship.getRelationshipType(), paramPackageRelationship);
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
/*     */   public PackageRelationship addRelationship(URI paramURI, TargetMode paramTargetMode, String paramString1, String paramString2) {
/* 217 */     if (paramString2 == null) {
/*     */       
/* 219 */       if (this.nextRelationshipId == -1) {
/* 220 */         this.nextRelationshipId = size() + 1;
/*     */       }
/*     */ 
/*     */       
/*     */       do {
/* 225 */         paramString2 = "rId" + this.nextRelationshipId++;
/* 226 */       } while (this.relationshipsByID.get(paramString2) != null);
/*     */     } 
/*     */     
/* 229 */     PackageRelationship packageRelationship = new PackageRelationship(this.container, this.sourcePart, paramURI, paramTargetMode, paramString1, paramString2);
/*     */     
/* 231 */     this.relationshipsByID.put(packageRelationship.getId(), packageRelationship);
/* 232 */     this.relationshipsByType.put(packageRelationship.getRelationshipType(), packageRelationship);
/* 233 */     return packageRelationship;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeRelationship(String paramString) {
/* 243 */     if (this.relationshipsByID != null && this.relationshipsByType != null) {
/* 244 */       PackageRelationship packageRelationship = this.relationshipsByID.get(paramString);
/* 245 */       if (packageRelationship != null) {
/* 246 */         this.relationshipsByID.remove(packageRelationship.getId());
/* 247 */         this.relationshipsByType.values().remove(packageRelationship);
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
/*     */   public void removeRelationship(PackageRelationship paramPackageRelationship) {
/* 259 */     if (paramPackageRelationship == null) {
/* 260 */       throw new IllegalArgumentException("rel");
/*     */     }
/* 262 */     this.relationshipsByID.values().remove(paramPackageRelationship);
/* 263 */     this.relationshipsByType.values().remove(paramPackageRelationship);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PackageRelationship getRelationship(int paramInt) {
/* 273 */     if (paramInt < 0 || paramInt > this.relationshipsByID.values().size()) {
/* 274 */       throw new IllegalArgumentException("index");
/*     */     }
/* 276 */     byte b = 0;
/* 277 */     for (PackageRelationship packageRelationship : this.relationshipsByID.values()) {
/* 278 */       if (paramInt == b++) {
/* 279 */         return packageRelationship;
/*     */       }
/*     */     } 
/* 282 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PackageRelationship getRelationshipByID(String paramString) {
/* 293 */     return this.relationshipsByID.get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 300 */     return this.relationshipsByID.values().size();
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
/*     */   public void parseRelationshipsPart(PackagePart paramPackagePart) throws InvalidFormatException {
/*     */     try {
/* 314 */       logger.log(1, new Object[] { "Parsing relationship: " + paramPackagePart.getPartName() });
/* 315 */       Document document = DocumentHelper.readDocument(paramPackagePart.getInputStream());
/*     */ 
/*     */       
/* 318 */       Element element = document.getDocumentElement();
/*     */ 
/*     */       
/* 321 */       boolean bool = false;
/*     */       
/* 323 */       NodeList nodeList = element.getElementsByTagNameNS("http://schemas.openxmlformats.org/package/2006/relationships", "Relationship");
/* 324 */       int i = nodeList.getLength();
/* 325 */       for (byte b = 0; b < i; b++) {
/* 326 */         Element element1 = (Element)nodeList.item(b);
/*     */         
/* 328 */         String str1 = element1.getAttribute("Id");
/*     */         
/* 330 */         String str2 = element1.getAttribute("Type");
/*     */ 
/*     */ 
/*     */         
/* 334 */         if (str2.equals("http://schemas.openxmlformats.org/package/2006/relationships/metadata/core-properties")) {
/* 335 */           if (!bool) {
/* 336 */             bool = true;
/*     */           } else {
/* 338 */             throw new InvalidFormatException("OPC Compliance error [M4.1]: there is more than one core properties relationship in the package !");
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 344 */         Attr attr = element1.getAttributeNode("TargetMode");
/* 345 */         TargetMode targetMode = TargetMode.INTERNAL;
/* 346 */         if (attr != null) {
/* 347 */           targetMode = attr.getValue().toLowerCase(Locale.ROOT).equals("internal") ? TargetMode.INTERNAL : TargetMode.EXTERNAL;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 353 */         URI uRI = PackagingURIHelper.toURI("http://invalid.uri");
/* 354 */         String str3 = element1.getAttribute("Target");
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         try {
/* 360 */           uRI = PackagingURIHelper.toURI(str3);
/* 361 */         } catch (URISyntaxException uRISyntaxException) {
/* 362 */           logger.log(7, new Object[] { "Cannot convert " + str3 + " in a valid relationship URI-> dummy-URI used", uRISyntaxException });
/*     */         } 
/*     */         
/* 365 */         addRelationship(uRI, targetMode, str2, str1);
/*     */       } 
/* 367 */     } catch (Exception exception) {
/* 368 */       logger.log(7, new Object[] { exception });
/* 369 */       throw new InvalidFormatException(exception.getMessage());
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
/*     */   public PackageRelationshipCollection getRelationships(String paramString) {
/* 382 */     return new PackageRelationshipCollection(this, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<PackageRelationship> iterator() {
/* 391 */     return this.relationshipsByID.values().iterator();
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
/*     */   public Iterator<PackageRelationship> iterator(String paramString) {
/* 404 */     ArrayList<PackageRelationship> arrayList = new ArrayList();
/* 405 */     for (PackageRelationship packageRelationship : this.relationshipsByID.values()) {
/* 406 */       if (packageRelationship.getRelationshipType().equals(paramString))
/* 407 */         arrayList.add(packageRelationship); 
/*     */     } 
/* 409 */     return arrayList.iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 416 */     this.relationshipsByID.clear();
/* 417 */     this.relationshipsByType.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*     */     String str;
/* 423 */     if (this.relationshipsByID == null) {
/* 424 */       str = "relationshipsByID=null";
/*     */     } else {
/* 426 */       str = this.relationshipsByID.size() + " relationship(s) = [";
/*     */     } 
/* 428 */     if (this.relationshipPart != null && this.relationshipPart._partName != null) {
/* 429 */       str = str + "," + this.relationshipPart._partName;
/*     */     } else {
/* 431 */       str = str + ",relationshipPart=null";
/*     */     } 
/*     */ 
/*     */     
/* 435 */     if (this.sourcePart != null && this.sourcePart._partName != null) {
/* 436 */       str = str + "," + this.sourcePart._partName;
/*     */     } else {
/* 438 */       str = str + ",sourcePart=null";
/*     */     } 
/* 440 */     if (this.partName != null) {
/* 441 */       str = str + "," + this.partName;
/*     */     } else {
/* 443 */       str = str + ",uri=null)";
/*     */     } 
/* 445 */     return str + "]";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\PackageRelationshipCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */