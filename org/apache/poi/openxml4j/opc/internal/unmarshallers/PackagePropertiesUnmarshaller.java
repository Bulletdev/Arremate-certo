/*     */ package org.apache.poi.openxml4j.opc.internal.unmarshallers;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.zip.ZipEntry;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.ZipPackage;
/*     */ import org.apache.poi.openxml4j.opc.internal.PackagePropertiesPart;
/*     */ import org.apache.poi.openxml4j.opc.internal.PartUnmarshaller;
/*     */ import org.apache.poi.openxml4j.opc.internal.ZipHelper;
/*     */ import org.apache.poi.util.DocumentHelper;
/*     */ import org.w3c.dom.Attr;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NamedNodeMap;
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
/*     */ public final class PackagePropertiesUnmarshaller
/*     */   implements PartUnmarshaller
/*     */ {
/*     */   protected static final String KEYWORD_CATEGORY = "category";
/*     */   protected static final String KEYWORD_CONTENT_STATUS = "contentStatus";
/*     */   protected static final String KEYWORD_CONTENT_TYPE = "contentType";
/*     */   protected static final String KEYWORD_CREATED = "created";
/*     */   protected static final String KEYWORD_CREATOR = "creator";
/*     */   protected static final String KEYWORD_DESCRIPTION = "description";
/*     */   protected static final String KEYWORD_IDENTIFIER = "identifier";
/*     */   protected static final String KEYWORD_KEYWORDS = "keywords";
/*     */   protected static final String KEYWORD_LANGUAGE = "language";
/*     */   protected static final String KEYWORD_LAST_MODIFIED_BY = "lastModifiedBy";
/*     */   protected static final String KEYWORD_LAST_PRINTED = "lastPrinted";
/*     */   protected static final String KEYWORD_MODIFIED = "modified";
/*     */   protected static final String KEYWORD_REVISION = "revision";
/*     */   protected static final String KEYWORD_SUBJECT = "subject";
/*     */   protected static final String KEYWORD_TITLE = "title";
/*     */   protected static final String KEYWORD_VERSION = "version";
/*     */   
/*     */   public PackagePart unmarshall(UnmarshallContext paramUnmarshallContext, InputStream paramInputStream) throws InvalidFormatException, IOException {
/*     */     Document document;
/*  85 */     PackagePropertiesPart packagePropertiesPart = new PackagePropertiesPart(paramUnmarshallContext.getPackage(), paramUnmarshallContext.getPartName());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  90 */     if (paramInputStream == null) {
/*  91 */       if (paramUnmarshallContext.getZipEntry() != null) {
/*  92 */         paramInputStream = ((ZipPackage)paramUnmarshallContext.getPackage()).getZipArchive().getInputStream(paramUnmarshallContext.getZipEntry());
/*     */       }
/*  94 */       else if (paramUnmarshallContext.getPackage() != null) {
/*     */         
/*  96 */         ZipEntry zipEntry = ZipHelper.getCorePropertiesZipEntry((ZipPackage)paramUnmarshallContext.getPackage());
/*     */ 
/*     */         
/*  99 */         paramInputStream = ((ZipPackage)paramUnmarshallContext.getPackage()).getZipArchive().getInputStream(zipEntry);
/*     */       } else {
/*     */         
/* 102 */         throw new IOException("Error while trying to get the part input stream.");
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 108 */       document = DocumentHelper.readDocument(paramInputStream);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 113 */       checkElementForOPCCompliance(document.getDocumentElement());
/*     */ 
/*     */     
/*     */     }
/* 117 */     catch (SAXException sAXException) {
/* 118 */       throw new IOException(sAXException.getMessage());
/*     */     } 
/*     */     
/* 121 */     packagePropertiesPart.setCategoryProperty(loadCategory(document));
/* 122 */     packagePropertiesPart.setContentStatusProperty(loadContentStatus(document));
/* 123 */     packagePropertiesPart.setContentTypeProperty(loadContentType(document));
/* 124 */     packagePropertiesPart.setCreatedProperty(loadCreated(document));
/* 125 */     packagePropertiesPart.setCreatorProperty(loadCreator(document));
/* 126 */     packagePropertiesPart.setDescriptionProperty(loadDescription(document));
/* 127 */     packagePropertiesPart.setIdentifierProperty(loadIdentifier(document));
/* 128 */     packagePropertiesPart.setKeywordsProperty(loadKeywords(document));
/* 129 */     packagePropertiesPart.setLanguageProperty(loadLanguage(document));
/* 130 */     packagePropertiesPart.setLastModifiedByProperty(loadLastModifiedBy(document));
/* 131 */     packagePropertiesPart.setLastPrintedProperty(loadLastPrinted(document));
/* 132 */     packagePropertiesPart.setModifiedProperty(loadModified(document));
/* 133 */     packagePropertiesPart.setRevisionProperty(loadRevision(document));
/* 134 */     packagePropertiesPart.setSubjectProperty(loadSubject(document));
/* 135 */     packagePropertiesPart.setTitleProperty(loadTitle(document));
/* 136 */     packagePropertiesPart.setVersionProperty(loadVersion(document));
/*     */     
/* 138 */     return (PackagePart)packagePropertiesPart;
/*     */   }
/*     */   
/*     */   private String readElement(Document paramDocument, String paramString1, String paramString2) {
/* 142 */     Element element = (Element)paramDocument.getDocumentElement().getElementsByTagNameNS(paramString2, paramString1).item(0);
/* 143 */     if (element == null) {
/* 144 */       return null;
/*     */     }
/* 146 */     return element.getTextContent();
/*     */   }
/*     */   
/*     */   private String loadCategory(Document paramDocument) {
/* 150 */     return readElement(paramDocument, "category", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
/*     */   }
/*     */   
/*     */   private String loadContentStatus(Document paramDocument) {
/* 154 */     return readElement(paramDocument, "contentStatus", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
/*     */   }
/*     */   
/*     */   private String loadContentType(Document paramDocument) {
/* 158 */     return readElement(paramDocument, "contentType", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
/*     */   }
/*     */   
/*     */   private String loadCreated(Document paramDocument) {
/* 162 */     return readElement(paramDocument, "created", "http://purl.org/dc/terms/");
/*     */   }
/*     */   
/*     */   private String loadCreator(Document paramDocument) {
/* 166 */     return readElement(paramDocument, "creator", "http://purl.org/dc/elements/1.1/");
/*     */   }
/*     */   
/*     */   private String loadDescription(Document paramDocument) {
/* 170 */     return readElement(paramDocument, "description", "http://purl.org/dc/elements/1.1/");
/*     */   }
/*     */   
/*     */   private String loadIdentifier(Document paramDocument) {
/* 174 */     return readElement(paramDocument, "identifier", "http://purl.org/dc/elements/1.1/");
/*     */   }
/*     */   
/*     */   private String loadKeywords(Document paramDocument) {
/* 178 */     return readElement(paramDocument, "keywords", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
/*     */   }
/*     */   
/*     */   private String loadLanguage(Document paramDocument) {
/* 182 */     return readElement(paramDocument, "language", "http://purl.org/dc/elements/1.1/");
/*     */   }
/*     */   
/*     */   private String loadLastModifiedBy(Document paramDocument) {
/* 186 */     return readElement(paramDocument, "lastModifiedBy", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
/*     */   }
/*     */   
/*     */   private String loadLastPrinted(Document paramDocument) {
/* 190 */     return readElement(paramDocument, "lastPrinted", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
/*     */   }
/*     */   
/*     */   private String loadModified(Document paramDocument) {
/* 194 */     return readElement(paramDocument, "modified", "http://purl.org/dc/terms/");
/*     */   }
/*     */   
/*     */   private String loadRevision(Document paramDocument) {
/* 198 */     return readElement(paramDocument, "revision", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
/*     */   }
/*     */   
/*     */   private String loadSubject(Document paramDocument) {
/* 202 */     return readElement(paramDocument, "subject", "http://purl.org/dc/elements/1.1/");
/*     */   }
/*     */   
/*     */   private String loadTitle(Document paramDocument) {
/* 206 */     return readElement(paramDocument, "title", "http://purl.org/dc/elements/1.1/");
/*     */   }
/*     */   
/*     */   private String loadVersion(Document paramDocument) {
/* 210 */     return readElement(paramDocument, "version", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
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
/*     */   public void checkElementForOPCCompliance(Element paramElement) throws InvalidFormatException {
/* 241 */     NamedNodeMap namedNodeMap = paramElement.getAttributes();
/* 242 */     int i = namedNodeMap.getLength();
/* 243 */     for (byte b1 = 0; b1 < i; b1++) {
/* 244 */       Attr attr = (Attr)namedNodeMap.item(0);
/*     */       
/* 246 */       if (attr.getNamespaceURI().equals("http://www.w3.org/2000/xmlns/"))
/*     */       {
/* 248 */         if (attr.getValue().equals("http://schemas.openxmlformats.org/markup-compatibility/2006")) {
/* 249 */           throw new InvalidFormatException("OPC Compliance error [M4.2]: A format consumer shall consider the use of the Markup Compatibility namespace to be an error.");
/*     */         }
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 256 */     String str = paramElement.getLocalName();
/* 257 */     if (paramElement.getNamespaceURI().equals("http://purl.org/dc/terms/") && 
/* 258 */       !str.equals("created") && !str.equals("modified")) {
/* 259 */       throw new InvalidFormatException("OPC Compliance error [M4.3]: Producers shall not create a document element that contains refinements to the Dublin Core elements, except for the two specified in the schema: <dcterms:created> and <dcterms:modified> Consumers shall consider a document element that violates this constraint to be an error.");
/*     */     }
/*     */ 
/*     */     
/* 263 */     if (paramElement.getAttributeNodeNS("http://www.w3.org/XML/1998/namespace", "lang") != null) {
/* 264 */       throw new InvalidFormatException("OPC Compliance error [M4.4]: Producers shall not create a document element that contains the xml:lang attribute. Consumers shall consider a document element that violates this constraint to be an error.");
/*     */     }
/*     */ 
/*     */     
/* 268 */     if (paramElement.getNamespaceURI().equals("http://purl.org/dc/terms/")) {
/*     */       
/* 270 */       if (!str.equals("created") && !str.equals("modified")) {
/* 271 */         throw new InvalidFormatException("Namespace error : " + str + " shouldn't have the following naemspace -> " + "http://purl.org/dc/terms/");
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 276 */       Attr attr = paramElement.getAttributeNodeNS("http://www.w3.org/2001/XMLSchema-instance", "type");
/* 277 */       if (attr == null) {
/* 278 */         throw new InvalidFormatException("The element '" + str + "' must have the 'xsi:type' attribute present !");
/*     */       }
/*     */ 
/*     */       
/* 282 */       if (!attr.getValue().equals(paramElement.getPrefix() + ":W3CDTF")) {
/* 283 */         throw new InvalidFormatException("The element '" + str + "' must have the 'xsi:type' attribute with the value '" + paramElement.getPrefix() + ":W3CDTF', but had '" + attr.getValue() + "' !");
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 288 */     NodeList nodeList = paramElement.getElementsByTagName("*");
/* 289 */     int j = nodeList.getLength();
/* 290 */     for (byte b2 = 0; b2 < j; b2++)
/* 291 */       checkElementForOPCCompliance((Element)nodeList.item(b2)); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\interna\\unmarshallers\PackagePropertiesUnmarshaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */