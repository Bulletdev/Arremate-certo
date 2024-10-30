/*     */ package org.apache.xmlbeans.impl.tool;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.net.URL;
/*     */ import java.net.URLConnection;
/*     */ import java.security.DigestInputStream;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.impl.common.IOUtil;
/*     */ import org.apache.xmlbeans.impl.util.HexBin;
/*     */ import org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry;
/*     */ import org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class BaseSchemaResourceManager
/*     */   extends SchemaImportResolver
/*     */ {
/*  48 */   private static final String USER_AGENT = "XMLBeans/" + XmlBeans.getVersion() + " (" + XmlBeans.getTitle() + ")";
/*     */   
/*     */   private String _defaultCopyDirectory;
/*     */   private DownloadedSchemasDocument _importsDoc;
/*  52 */   private Map _resourceForFilename = new HashMap();
/*  53 */   private Map _resourceForURL = new HashMap();
/*  54 */   private Map _resourceForNamespace = new HashMap();
/*  55 */   private Map _resourceForDigest = new HashMap();
/*  56 */   private Map _resourceForCacheEntry = new HashMap();
/*  57 */   private Set _redownloadSet = new HashSet();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void init() {
/*  66 */     if (fileExists(getIndexFilename())) {
/*     */       
/*     */       try {
/*     */         
/*  70 */         this._importsDoc = DownloadedSchemasDocument.Factory.parse(inputStreamForFile(getIndexFilename()));
/*     */       }
/*  72 */       catch (IOException iOException) {
/*     */         
/*  74 */         this._importsDoc = null;
/*     */       }
/*  76 */       catch (Exception exception) {
/*     */         
/*  78 */         throw (IllegalStateException)(new IllegalStateException("Problem reading xsdownload.xml: please fix or delete this file")).initCause(exception);
/*     */       } 
/*     */     }
/*  81 */     if (this._importsDoc == null) {
/*     */       
/*     */       try {
/*     */         
/*  85 */         this._importsDoc = DownloadedSchemasDocument.Factory.parse("<dls:downloaded-schemas xmlns:dls='http://www.bea.com/2003/01/xmlbean/xsdownload' defaultDirectory='" + getDefaultSchemaDir() + "'/>");
/*     */ 
/*     */       
/*     */       }
/*  89 */       catch (Exception exception) {
/*     */         
/*  91 */         throw (IllegalStateException)(new IllegalStateException()).initCause(exception);
/*     */       } 
/*     */     }
/*     */     
/*  95 */     String str = this._importsDoc.getDownloadedSchemas().getDefaultDirectory();
/*  96 */     if (str == null)
/*  97 */       str = getDefaultSchemaDir(); 
/*  98 */     this._defaultCopyDirectory = str;
/*     */ 
/*     */     
/* 101 */     DownloadedSchemaEntry[] arrayOfDownloadedSchemaEntry = this._importsDoc.getDownloadedSchemas().getEntryArray();
/* 102 */     for (byte b = 0; b < arrayOfDownloadedSchemaEntry.length; b++)
/*     */     {
/* 104 */       updateResource(arrayOfDownloadedSchemaEntry[b]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void writeCache() throws IOException {
/* 110 */     InputStream inputStream = this._importsDoc.newInputStream((new XmlOptions()).setSavePrettyPrint());
/* 111 */     writeInputStreamToFile(inputStream, getIndexFilename());
/*     */   }
/*     */ 
/*     */   
/*     */   public final void processAll(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/* 116 */     if (paramBoolean2) {
/*     */       
/* 118 */       this._redownloadSet = new HashSet();
/*     */     }
/*     */     else {
/*     */       
/* 122 */       this._redownloadSet = null;
/*     */     } 
/*     */     
/* 125 */     String[] arrayOfString = getAllXSDFilenames();
/*     */     
/* 127 */     if (paramBoolean1) {
/* 128 */       syncCacheWithLocalXsdFiles(arrayOfString, false);
/*     */     }
/* 130 */     SchemaResource[] arrayOfSchemaResource = (SchemaResource[])this._resourceForFilename.values().toArray((Object[])new SchemaResource[0]);
/*     */ 
/*     */     
/* 133 */     if (paramBoolean2) {
/* 134 */       redownloadEntries(arrayOfSchemaResource);
/*     */     }
/* 136 */     if (paramBoolean3) {
/* 137 */       resolveImports((SchemaImportResolver.SchemaResource[])arrayOfSchemaResource);
/*     */     }
/* 139 */     this._redownloadSet = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void process(String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/* 144 */     if (paramBoolean2) {
/*     */       
/* 146 */       this._redownloadSet = new HashSet();
/*     */     }
/*     */     else {
/*     */       
/* 150 */       this._redownloadSet = null;
/*     */     } 
/*     */     
/* 153 */     if (paramArrayOfString2.length > 0) {
/* 154 */       syncCacheWithLocalXsdFiles(paramArrayOfString2, true);
/* 155 */     } else if (paramBoolean1) {
/* 156 */       syncCacheWithLocalXsdFiles(getAllXSDFilenames(), false);
/*     */     } 
/* 158 */     HashSet hashSet = new HashSet();
/*     */     byte b;
/* 160 */     for (b = 0; b < paramArrayOfString1.length; b++) {
/*     */       
/* 162 */       SchemaResource schemaResource = (SchemaResource)lookupResource((String)null, paramArrayOfString1[b]);
/* 163 */       if (schemaResource != null) {
/* 164 */         hashSet.add(schemaResource);
/*     */       }
/*     */     } 
/* 167 */     for (b = 0; b < paramArrayOfString2.length; b++) {
/*     */       
/* 169 */       SchemaResource schemaResource = (SchemaResource)this._resourceForFilename.get(paramArrayOfString2);
/* 170 */       if (schemaResource != null) {
/* 171 */         hashSet.add(schemaResource);
/*     */       }
/*     */     } 
/* 174 */     SchemaResource[] arrayOfSchemaResource = hashSet.<SchemaResource>toArray(new SchemaResource[0]);
/*     */ 
/*     */     
/* 177 */     if (paramBoolean2) {
/* 178 */       redownloadEntries(arrayOfSchemaResource);
/*     */     }
/* 180 */     if (paramBoolean3) {
/* 181 */       resolveImports((SchemaImportResolver.SchemaResource[])arrayOfSchemaResource);
/*     */     }
/* 183 */     this._redownloadSet = null;
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
/*     */   public final void syncCacheWithLocalXsdFiles(String[] paramArrayOfString, boolean paramBoolean) {
/* 196 */     HashSet hashSet1 = new HashSet();
/* 197 */     HashSet hashSet2 = new HashSet();
/*     */     
/* 199 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/*     */       
/* 201 */       String str1 = paramArrayOfString[b];
/*     */ 
/*     */       
/* 204 */       SchemaResource schemaResource = (SchemaResource)this._resourceForFilename.get(str1);
/* 205 */       if (schemaResource != null) {
/*     */         
/* 207 */         if (fileExists(str1)) {
/* 208 */           hashSet1.add(schemaResource);
/*     */         } else {
/* 210 */           hashSet2.add(schemaResource);
/*     */         } 
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 216 */       String str2 = null;
/*     */       
/*     */       try {
/* 219 */         str2 = shaDigestForFile(str1);
/* 220 */         schemaResource = (SchemaResource)this._resourceForDigest.get(str2);
/* 221 */         if (schemaResource != null) {
/*     */           
/* 223 */           String str = schemaResource.getFilename();
/* 224 */           if (!fileExists(str)) {
/*     */             
/* 226 */             warning("File " + str1 + " is a rename of " + str);
/* 227 */             schemaResource.setFilename(str1);
/* 228 */             hashSet1.add(schemaResource);
/* 229 */             if (this._resourceForFilename.get(str) == schemaResource)
/* 230 */               this._resourceForFilename.remove(str); 
/* 231 */             if (this._resourceForFilename.containsKey(str1)) {
/* 232 */               this._resourceForFilename.put(str1, schemaResource);
/*     */             }
/*     */             continue;
/*     */           } 
/*     */         } 
/* 237 */       } catch (IOException iOException) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 243 */       DownloadedSchemaEntry downloadedSchemaEntry = addNewEntry();
/* 244 */       downloadedSchemaEntry.setFilename(str1);
/* 245 */       warning("Caching information on new local file " + str1);
/* 246 */       if (str2 != null) {
/* 247 */         downloadedSchemaEntry.setSha1(str2);
/*     */       }
/* 249 */       hashSet1.add(updateResource(downloadedSchemaEntry));
/*     */       continue;
/*     */     } 
/* 252 */     if (paramBoolean) {
/* 253 */       deleteResourcesInSet(hashSet2, true);
/*     */     } else {
/* 255 */       deleteResourcesInSet(hashSet1, false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void redownloadEntries(SchemaResource[] paramArrayOfSchemaResource) {
/* 264 */     for (byte b = 0; b < paramArrayOfSchemaResource.length; b++)
/*     */     {
/* 266 */       redownloadResource(paramArrayOfSchemaResource[b]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void deleteResourcesInSet(Set paramSet, boolean paramBoolean) {
/* 272 */     HashSet hashSet = new HashSet();
/* 273 */     for (SchemaResource schemaResource : paramSet)
/*     */     {
/*     */       
/* 276 */       hashSet.add(schemaResource._cacheEntry);
/*     */     }
/*     */     
/* 279 */     DownloadedSchemasDocument.DownloadedSchemas downloadedSchemas = this._importsDoc.getDownloadedSchemas();
/* 280 */     for (byte b = 0; b < downloadedSchemas.sizeOfEntryArray(); b++) {
/*     */       
/* 282 */       DownloadedSchemaEntry downloadedSchemaEntry = downloadedSchemas.getEntryArray(b);
/*     */       
/* 284 */       if (hashSet.contains(downloadedSchemaEntry) == paramBoolean) {
/*     */         
/* 286 */         SchemaResource schemaResource = (SchemaResource)this._resourceForCacheEntry.get(downloadedSchemaEntry);
/* 287 */         warning("Removing obsolete cache entry for " + schemaResource.getFilename());
/*     */         
/* 289 */         if (schemaResource != null) {
/*     */           
/* 291 */           this._resourceForCacheEntry.remove(downloadedSchemaEntry);
/*     */           
/* 293 */           if (schemaResource == this._resourceForFilename.get(schemaResource.getFilename())) {
/* 294 */             this._resourceForFilename.remove(schemaResource.getFilename());
/*     */           }
/* 296 */           if (schemaResource == this._resourceForDigest.get(schemaResource.getSha1())) {
/* 297 */             this._resourceForDigest.remove(schemaResource.getSha1());
/*     */           }
/* 299 */           if (schemaResource == this._resourceForNamespace.get(schemaResource.getNamespace())) {
/* 300 */             this._resourceForNamespace.remove(schemaResource.getNamespace());
/*     */           }
/*     */           
/* 303 */           String[] arrayOfString = schemaResource.getSchemaLocationArray();
/* 304 */           for (byte b1 = 0; b1 < arrayOfString.length; b1++) {
/*     */             
/* 306 */             if (schemaResource == this._resourceForURL.get(arrayOfString[b1])) {
/* 307 */               this._resourceForURL.remove(arrayOfString[b1]);
/*     */             }
/*     */           } 
/*     */         } 
/* 311 */         downloadedSchemas.removeEntry(b);
/* 312 */         b--;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private SchemaResource updateResource(DownloadedSchemaEntry paramDownloadedSchemaEntry) {
/* 320 */     String str1 = paramDownloadedSchemaEntry.getFilename();
/* 321 */     if (str1 == null) {
/* 322 */       return null;
/*     */     }
/* 324 */     SchemaResource schemaResource = new SchemaResource(paramDownloadedSchemaEntry);
/* 325 */     this._resourceForCacheEntry.put(paramDownloadedSchemaEntry, schemaResource);
/*     */     
/* 327 */     if (!this._resourceForFilename.containsKey(str1)) {
/* 328 */       this._resourceForFilename.put(str1, schemaResource);
/*     */     }
/*     */     
/* 331 */     String str2 = schemaResource.getSha1();
/* 332 */     if (str2 != null)
/*     */     {
/* 334 */       if (!this._resourceForDigest.containsKey(str2)) {
/* 335 */         this._resourceForDigest.put(str2, schemaResource);
/*     */       }
/*     */     }
/*     */     
/* 339 */     String str3 = schemaResource.getNamespace();
/* 340 */     if (str3 != null)
/*     */     {
/* 342 */       if (!this._resourceForNamespace.containsKey(str3)) {
/* 343 */         this._resourceForNamespace.put(str3, schemaResource);
/*     */       }
/*     */     }
/*     */     
/* 347 */     String[] arrayOfString = schemaResource.getSchemaLocationArray();
/* 348 */     for (byte b = 0; b < arrayOfString.length; b++) {
/*     */       
/* 350 */       if (!this._resourceForURL.containsKey(arrayOfString[b])) {
/* 351 */         this._resourceForURL.put(arrayOfString[b], schemaResource);
/*     */       }
/*     */     } 
/* 354 */     return schemaResource;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static DigestInputStream digestInputStream(InputStream paramInputStream) {
/*     */     MessageDigest messageDigest;
/*     */     try {
/* 362 */       messageDigest = MessageDigest.getInstance("SHA");
/*     */     }
/* 364 */     catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*     */       
/* 366 */       throw (IllegalStateException)(new IllegalStateException()).initCause(noSuchAlgorithmException);
/*     */     } 
/*     */     
/* 369 */     return new DigestInputStream(paramInputStream, messageDigest);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DownloadedSchemaEntry addNewEntry() {
/* 376 */     return this._importsDoc.getDownloadedSchemas().addNewEntry();
/*     */   }
/*     */   
/*     */   private class SchemaResource implements SchemaImportResolver.SchemaResource {
/*     */     DownloadedSchemaEntry _cacheEntry;
/*     */     
/*     */     SchemaResource(DownloadedSchemaEntry param1DownloadedSchemaEntry) {
/* 383 */       this._cacheEntry = param1DownloadedSchemaEntry;
/*     */     }
/*     */ 
/*     */     
/*     */     private final BaseSchemaResourceManager this$0;
/*     */     
/*     */     public void setFilename(String param1String) {
/* 390 */       this._cacheEntry.setFilename(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public String getFilename() {
/* 395 */       return this._cacheEntry.getFilename();
/*     */     }
/*     */ 
/*     */     
/*     */     public SchemaDocument.Schema getSchema() {
/* 400 */       if (!BaseSchemaResourceManager.this.fileExists(getFilename())) {
/* 401 */         BaseSchemaResourceManager.this.redownloadResource(this);
/*     */       }
/*     */       
/*     */       try {
/* 405 */         return SchemaDocument.Factory.parse(BaseSchemaResourceManager.this.inputStreamForFile(getFilename())).getSchema();
/*     */       }
/* 407 */       catch (Exception exception) {
/*     */         
/* 409 */         return null;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public String getSha1() {
/* 415 */       return this._cacheEntry.getSha1();
/*     */     }
/*     */ 
/*     */     
/*     */     public String getNamespace() {
/* 420 */       return this._cacheEntry.getNamespace();
/*     */     }
/*     */ 
/*     */     
/*     */     public void setNamespace(String param1String) {
/* 425 */       this._cacheEntry.setNamespace(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public String getSchemaLocation() {
/* 430 */       if (this._cacheEntry.sizeOfSchemaLocationArray() > 0)
/* 431 */         return this._cacheEntry.getSchemaLocationArray(0); 
/* 432 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public String[] getSchemaLocationArray() {
/* 437 */       return this._cacheEntry.getSchemaLocationArray();
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 442 */       return getFilename().hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 447 */       return (this == param1Object || getFilename().equals(((SchemaResource)param1Object).getFilename()));
/*     */     }
/*     */ 
/*     */     
/*     */     public void addSchemaLocation(String param1String) {
/* 452 */       this._cacheEntry.addSchemaLocation(param1String);
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
/*     */   public SchemaImportResolver.SchemaResource lookupResource(String paramString1, String paramString2) {
/* 466 */     SchemaResource schemaResource = fetchFromCache(paramString1, paramString2);
/* 467 */     if (schemaResource != null) {
/*     */       
/* 469 */       if (this._redownloadSet != null)
/*     */       {
/* 471 */         redownloadResource(schemaResource);
/*     */       }
/* 473 */       return schemaResource;
/*     */     } 
/*     */     
/* 476 */     if (paramString2 == null) {
/*     */       
/* 478 */       warning("No cached schema for namespace '" + paramString1 + "', and no url specified");
/* 479 */       return null;
/*     */     } 
/*     */     
/* 482 */     schemaResource = copyOrIdentifyDuplicateURL(paramString2, paramString1);
/* 483 */     if (this._redownloadSet != null)
/* 484 */       this._redownloadSet.add(schemaResource); 
/* 485 */     return schemaResource;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SchemaResource fetchFromCache(String paramString1, String paramString2) {
/* 492 */     if (paramString2 != null) {
/*     */       
/* 494 */       SchemaResource schemaResource = (SchemaResource)this._resourceForURL.get(paramString2);
/* 495 */       if (schemaResource != null) {
/* 496 */         return schemaResource;
/*     */       }
/*     */     } 
/* 499 */     if (paramString1 != null) {
/*     */       
/* 501 */       SchemaResource schemaResource = (SchemaResource)this._resourceForNamespace.get(paramString1);
/* 502 */       if (schemaResource != null) {
/* 503 */         return schemaResource;
/*     */       }
/*     */     } 
/* 506 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private String uniqueFilenameForURI(String paramString) throws IOException, URISyntaxException {
/* 511 */     String str1 = (new URI(paramString)).getRawPath();
/* 512 */     int i = str1.lastIndexOf('/');
/* 513 */     if (i >= 0)
/* 514 */       str1 = str1.substring(i + 1); 
/* 515 */     if (str1.endsWith(".xsd"))
/* 516 */       str1 = str1.substring(0, str1.length() - 4); 
/* 517 */     if (str1.length() == 0) {
/* 518 */       str1 = "schema";
/*     */     }
/*     */ 
/*     */     
/* 522 */     String str2 = str1;
/* 523 */     byte b = 1;
/* 524 */     while (b < 'Ϩ') {
/*     */       
/* 526 */       String str = this._defaultCopyDirectory + "/" + str2 + ".xsd";
/* 527 */       if (!fileExists(str))
/* 528 */         return str; 
/* 529 */       b++;
/* 530 */       str2 = str1 + b;
/*     */     } 
/*     */     
/* 533 */     throw new IOException("Problem with filename " + str1 + ".xsd");
/*     */   }
/*     */ 
/*     */   
/*     */   private void redownloadResource(SchemaResource paramSchemaResource) {
/* 538 */     if (this._redownloadSet != null) {
/*     */       
/* 540 */       if (this._redownloadSet.contains(paramSchemaResource))
/*     */         return; 
/* 542 */       this._redownloadSet.add(paramSchemaResource);
/*     */     } 
/*     */     
/* 545 */     String str1 = paramSchemaResource.getFilename();
/* 546 */     String str2 = paramSchemaResource.getSchemaLocation();
/* 547 */     String str3 = null;
/*     */ 
/*     */     
/* 550 */     if (str2 == null || str1 == null) {
/*     */       return;
/*     */     }
/* 553 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*     */ 
/*     */     
/*     */     try {
/* 557 */       URL uRL = new URL(str2);
/* 558 */       URLConnection uRLConnection = uRL.openConnection();
/* 559 */       uRLConnection.addRequestProperty("User-Agent", USER_AGENT);
/* 560 */       uRLConnection.addRequestProperty("Accept", "application/xml, text/xml, */*");
/* 561 */       DigestInputStream digestInputStream = digestInputStream(uRLConnection.getInputStream());
/* 562 */       IOUtil.copyCompletely(digestInputStream, byteArrayOutputStream);
/* 563 */       str3 = HexBin.bytesToString(digestInputStream.getMessageDigest().digest());
/*     */     }
/* 565 */     catch (Exception exception) {
/*     */       
/* 567 */       warning("Could not copy remote resource " + str2 + ":" + exception.getMessage());
/*     */       
/*     */       return;
/*     */     } 
/* 571 */     if (str3.equals(paramSchemaResource.getSha1()) && fileExists(str1)) {
/*     */       
/* 573 */       warning("Resource " + str1 + " is unchanged from " + str2 + ".");
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*     */     try {
/* 579 */       ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
/* 580 */       writeInputStreamToFile(byteArrayInputStream, str1);
/*     */     }
/* 582 */     catch (IOException iOException) {
/*     */       
/* 584 */       warning("Could not write to file " + str1 + " for " + str2 + ":" + iOException.getMessage());
/*     */       
/*     */       return;
/*     */     } 
/* 588 */     warning("Refreshed " + str1 + " from " + str2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SchemaResource copyOrIdentifyDuplicateURL(String paramString1, String paramString2) {
/*     */     String str1, str2;
/*     */     try {
/* 599 */       str1 = uniqueFilenameForURI(paramString1);
/*     */     }
/* 601 */     catch (URISyntaxException uRISyntaxException) {
/*     */       
/* 603 */       warning("Invalid URI '" + paramString1 + "':" + uRISyntaxException.getMessage());
/* 604 */       return null;
/*     */     }
/* 606 */     catch (IOException iOException) {
/*     */       
/* 608 */       warning("Could not create local file for " + paramString1 + ":" + iOException.getMessage());
/* 609 */       return null;
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/* 614 */       URL uRL = new URL(paramString1);
/* 615 */       DigestInputStream digestInputStream = digestInputStream(uRL.openStream());
/* 616 */       writeInputStreamToFile(digestInputStream, str1);
/* 617 */       str2 = HexBin.bytesToString(digestInputStream.getMessageDigest().digest());
/*     */     }
/* 619 */     catch (Exception exception) {
/*     */       
/* 621 */       warning("Could not copy remote resource " + paramString1 + ":" + exception.getMessage());
/* 622 */       return null;
/*     */     } 
/*     */     
/* 625 */     SchemaResource schemaResource = (SchemaResource)this._resourceForDigest.get(str2);
/* 626 */     if (schemaResource != null) {
/*     */       
/* 628 */       deleteFile(str1);
/* 629 */       schemaResource.addSchemaLocation(paramString1);
/* 630 */       if (!this._resourceForURL.containsKey(paramString1))
/* 631 */         this._resourceForURL.put(paramString1, schemaResource); 
/* 632 */       return schemaResource;
/*     */     } 
/*     */     
/* 635 */     warning("Downloaded " + paramString1 + " to " + str1);
/*     */     
/* 637 */     DownloadedSchemaEntry downloadedSchemaEntry = addNewEntry();
/* 638 */     downloadedSchemaEntry.setFilename(str1);
/* 639 */     downloadedSchemaEntry.setSha1(str2);
/* 640 */     if (paramString2 != null)
/* 641 */       downloadedSchemaEntry.setNamespace(paramString2); 
/* 642 */     downloadedSchemaEntry.addSchemaLocation(paramString1);
/* 643 */     return updateResource(downloadedSchemaEntry);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reportActualNamespace(SchemaImportResolver.SchemaResource paramSchemaResource, String paramString) {
/* 651 */     SchemaResource schemaResource = (SchemaResource)paramSchemaResource;
/* 652 */     String str = schemaResource.getNamespace();
/* 653 */     if (str != null && this._resourceForNamespace.get(str) == schemaResource)
/* 654 */       this._resourceForNamespace.remove(str); 
/* 655 */     if (!this._resourceForNamespace.containsKey(paramString))
/* 656 */       this._resourceForNamespace.put(paramString, schemaResource); 
/* 657 */     schemaResource.setNamespace(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   private String shaDigestForFile(String paramString) throws IOException {
/* 662 */     DigestInputStream digestInputStream = digestInputStream(inputStreamForFile(paramString));
/*     */     
/* 664 */     byte[] arrayOfByte = new byte[4096]; int i;
/* 665 */     for (i = 1; i; i = digestInputStream.read(arrayOfByte));
/*     */     
/* 667 */     digestInputStream.close();
/*     */     
/* 669 */     return HexBin.bytesToString(digestInputStream.getMessageDigest().digest());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getIndexFilename() {
/* 676 */     return "./xsdownload.xml";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getDefaultSchemaDir() {
/* 681 */     return "./schema";
/*     */   }
/*     */   
/*     */   protected abstract void warning(String paramString);
/*     */   
/*     */   protected abstract boolean fileExists(String paramString);
/*     */   
/*     */   protected abstract InputStream inputStreamForFile(String paramString) throws IOException;
/*     */   
/*     */   protected abstract void writeInputStreamToFile(InputStream paramInputStream, String paramString) throws IOException;
/*     */   
/*     */   protected abstract void deleteFile(String paramString);
/*     */   
/*     */   protected abstract String[] getAllXSDFilenames();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\tool\BaseSchemaResourceManager.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */