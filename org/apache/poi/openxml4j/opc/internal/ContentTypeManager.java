/*     */ package org.apache.poi.openxml4j.opc.internal;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JRuntimeException;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackagePartName;
/*     */ import org.apache.poi.openxml4j.opc.PackagingURIHelper;
/*     */ import org.apache.poi.util.DocumentHelper;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.xml.sax.SAXException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ContentTypeManager
/*     */ {
/*     */   public static final String CONTENT_TYPES_PART_NAME = "[Content_Types].xml";
/*     */   public static final String TYPES_NAMESPACE_URI = "http://schemas.openxmlformats.org/package/2006/content-types";
/*     */   private static final String TYPES_TAG_NAME = "Types";
/*     */   private static final String DEFAULT_TAG_NAME = "Default";
/*     */   private static final String EXTENSION_ATTRIBUTE_NAME = "Extension";
/*     */   private static final String CONTENT_TYPE_ATTRIBUTE_NAME = "ContentType";
/*     */   private static final String OVERRIDE_TAG_NAME = "Override";
/*     */   private static final String PART_NAME_ATTRIBUTE_NAME = "PartName";
/*     */   protected OPCPackage container;
/*     */   private TreeMap<String, String> defaultContentType;
/*     */   private TreeMap<PackagePartName, String> overrideContentType;
/*     */   
/*     */   public ContentTypeManager(InputStream paramInputStream, OPCPackage paramOPCPackage) throws InvalidFormatException {
/*  96 */     this.container = paramOPCPackage;
/*  97 */     this.defaultContentType = new TreeMap<String, String>();
/*  98 */     if (paramInputStream != null) {
/*     */       try {
/* 100 */         parseContentTypesFile(paramInputStream);
/* 101 */       } catch (InvalidFormatException invalidFormatException1) {
/* 102 */         InvalidFormatException invalidFormatException2 = new InvalidFormatException("Can't read content types part !");
/*     */ 
/*     */         
/* 105 */         invalidFormatException2.initCause((Throwable)invalidFormatException1);
/*     */         
/* 107 */         throw invalidFormatException2;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addContentType(PackagePartName paramPackagePartName, String paramString) {
/* 150 */     boolean bool = this.defaultContentType.containsValue(paramString);
/* 151 */     String str = paramPackagePartName.getExtension().toLowerCase(Locale.ROOT);
/* 152 */     if (str.length() == 0 || (this.defaultContentType.containsKey(str) && !bool)) {
/*     */       
/* 154 */       addOverrideContentType(paramPackagePartName, paramString);
/* 155 */     } else if (!bool) {
/* 156 */       addDefaultContentType(str, paramString);
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
/*     */   private void addOverrideContentType(PackagePartName paramPackagePartName, String paramString) {
/* 169 */     if (this.overrideContentType == null)
/* 170 */       this.overrideContentType = new TreeMap<PackagePartName, String>(); 
/* 171 */     this.overrideContentType.put(paramPackagePartName, paramString);
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
/*     */   private void addDefaultContentType(String paramString1, String paramString2) {
/* 185 */     this.defaultContentType.put(paramString1.toLowerCase(Locale.ROOT), paramString2);
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
/*     */   public void removeContentType(PackagePartName paramPackagePartName) throws InvalidOperationException {
/* 209 */     if (paramPackagePartName == null) {
/* 210 */       throw new IllegalArgumentException("partName");
/*     */     }
/*     */     
/* 213 */     if (this.overrideContentType != null && this.overrideContentType.get(paramPackagePartName) != null) {
/*     */ 
/*     */       
/* 216 */       this.overrideContentType.remove(paramPackagePartName);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 221 */     String str = paramPackagePartName.getExtension();
/* 222 */     boolean bool = true;
/* 223 */     if (this.container != null) {
/*     */       try {
/* 225 */         for (PackagePart packagePart : this.container.getParts()) {
/* 226 */           if (!packagePart.getPartName().equals(paramPackagePartName) && packagePart.getPartName().getExtension().equalsIgnoreCase(str)) {
/*     */ 
/*     */             
/* 229 */             bool = false;
/*     */             break;
/*     */           } 
/*     */         } 
/* 233 */       } catch (InvalidFormatException invalidFormatException) {
/* 234 */         throw new InvalidOperationException(invalidFormatException.getMessage());
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 239 */     if (bool) {
/* 240 */       this.defaultContentType.remove(str);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 250 */     if (this.container != null) {
/*     */       try {
/* 252 */         for (PackagePart packagePart : this.container.getParts()) {
/* 253 */           if (!packagePart.getPartName().equals(paramPackagePartName) && getContentType(packagePart.getPartName()) == null)
/*     */           {
/* 255 */             throw new InvalidOperationException("Rule M2.4 is not respected: Nor a default element or override element is associated with the part: " + packagePart.getPartName().getName());
/*     */           }
/*     */         }
/*     */       
/* 259 */       } catch (InvalidFormatException invalidFormatException) {
/* 260 */         throw new InvalidOperationException(invalidFormatException.getMessage());
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
/*     */   
/*     */   public boolean isContentTypeRegister(String paramString) {
/* 274 */     if (paramString == null) {
/* 275 */       throw new IllegalArgumentException("contentType");
/*     */     }
/* 277 */     return (this.defaultContentType.values().contains(paramString) || (this.overrideContentType != null && this.overrideContentType.values().contains(paramString)));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getContentType(PackagePartName paramPackagePartName) {
/* 321 */     if (paramPackagePartName == null) {
/* 322 */       throw new IllegalArgumentException("partName");
/*     */     }
/* 324 */     if (this.overrideContentType != null && this.overrideContentType.containsKey(paramPackagePartName))
/*     */     {
/* 326 */       return this.overrideContentType.get(paramPackagePartName);
/*     */     }
/* 328 */     String str = paramPackagePartName.getExtension().toLowerCase(Locale.ROOT);
/* 329 */     if (this.defaultContentType.containsKey(str)) {
/* 330 */       return this.defaultContentType.get(str);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 339 */     if (this.container != null && this.container.getPart(paramPackagePartName) != null) {
/* 340 */       throw new OpenXML4JRuntimeException("Rule M2.4 exception : this error should NEVER happen! If you can provide the triggering file, then please raise a bug at https://bz.apache.org/bugzilla/enter_bug.cgi?product=POI and attach the file that triggers it, thanks!");
/*     */     }
/*     */     
/* 343 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearAll() {
/* 350 */     this.defaultContentType.clear();
/* 351 */     if (this.overrideContentType != null) {
/* 352 */       this.overrideContentType.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearOverrideContentTypes() {
/* 360 */     if (this.overrideContentType != null) {
/* 361 */       this.overrideContentType.clear();
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
/*     */   private void parseContentTypesFile(InputStream paramInputStream) throws InvalidFormatException {
/*     */     try {
/* 374 */       Document document = DocumentHelper.readDocument(paramInputStream);
/*     */ 
/*     */       
/* 377 */       NodeList nodeList1 = document.getDocumentElement().getElementsByTagNameNS("http://schemas.openxmlformats.org/package/2006/content-types", "Default");
/* 378 */       int i = nodeList1.getLength();
/* 379 */       for (byte b1 = 0; b1 < i; b1++) {
/* 380 */         Element element = (Element)nodeList1.item(b1);
/* 381 */         String str1 = element.getAttribute("Extension");
/* 382 */         String str2 = element.getAttribute("ContentType");
/* 383 */         addDefaultContentType(str1, str2);
/*     */       } 
/*     */ 
/*     */       
/* 387 */       NodeList nodeList2 = document.getDocumentElement().getElementsByTagNameNS("http://schemas.openxmlformats.org/package/2006/content-types", "Override");
/* 388 */       int j = nodeList2.getLength();
/* 389 */       for (byte b2 = 0; b2 < j; b2++) {
/* 390 */         Element element = (Element)nodeList2.item(b2);
/* 391 */         URI uRI = new URI(element.getAttribute("PartName"));
/* 392 */         PackagePartName packagePartName = PackagingURIHelper.createPartName(uRI);
/* 393 */         String str = element.getAttribute("ContentType");
/* 394 */         addOverrideContentType(packagePartName, str);
/*     */       } 
/* 396 */     } catch (URISyntaxException uRISyntaxException) {
/* 397 */       throw new InvalidFormatException(uRISyntaxException.getMessage());
/* 398 */     } catch (SAXException sAXException) {
/* 399 */       throw new InvalidFormatException(sAXException.getMessage());
/* 400 */     } catch (IOException iOException) {
/* 401 */       throw new InvalidFormatException(iOException.getMessage());
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
/*     */   public boolean save(OutputStream paramOutputStream) {
/* 414 */     Document document = DocumentHelper.createDocument();
/*     */ 
/*     */     
/* 417 */     Element element = document.createElementNS("http://schemas.openxmlformats.org/package/2006/content-types", "Types");
/* 418 */     document.appendChild(element);
/*     */ 
/*     */     
/* 421 */     for (Map.Entry<String, String> entry : this.defaultContentType.entrySet()) {
/* 422 */       appendDefaultType(element, entry);
/*     */     }
/*     */ 
/*     */     
/* 426 */     if (this.overrideContentType != null) {
/* 427 */       for (Map.Entry<PackagePartName, String> entry : this.overrideContentType.entrySet())
/*     */       {
/* 429 */         appendSpecificTypes(element, entry);
/*     */       }
/*     */     }
/* 432 */     document.normalize();
/*     */ 
/*     */     
/* 435 */     return saveImpl(document, paramOutputStream);
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
/*     */   private void appendSpecificTypes(Element paramElement, Map.Entry<PackagePartName, String> paramEntry) {
/* 449 */     Element element = paramElement.getOwnerDocument().createElementNS("http://schemas.openxmlformats.org/package/2006/content-types", "Override");
/* 450 */     element.setAttribute("PartName", ((PackagePartName)paramEntry.getKey()).getName());
/* 451 */     element.setAttribute("ContentType", paramEntry.getValue());
/* 452 */     paramElement.appendChild(element);
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
/*     */   private void appendDefaultType(Element paramElement, Map.Entry<String, String> paramEntry) {
/* 465 */     Element element = paramElement.getOwnerDocument().createElementNS("http://schemas.openxmlformats.org/package/2006/content-types", "Default");
/* 466 */     element.setAttribute("Extension", paramEntry.getKey());
/* 467 */     element.setAttribute("ContentType", paramEntry.getValue());
/* 468 */     paramElement.appendChild(element);
/*     */   }
/*     */   
/*     */   public abstract boolean saveImpl(Document paramDocument, OutputStream paramOutputStream);
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\internal\ContentTypeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */