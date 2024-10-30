/*     */ package org.apache.poi.openxml4j.opc.internal.marshallers;
/*     */ 
/*     */ import java.io.OutputStream;
/*     */ import javax.xml.stream.XMLEventFactory;
/*     */ import javax.xml.stream.events.Namespace;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.internal.PackagePropertiesPart;
/*     */ import org.apache.poi.openxml4j.opc.internal.PartMarshaller;
/*     */ import org.apache.poi.openxml4j.util.Nullable;
/*     */ import org.apache.poi.util.DocumentHelper;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ 
/*     */ public class PackagePropertiesMarshaller
/*     */   implements PartMarshaller
/*     */ {
/*     */   private static final Namespace namespaceDC;
/*     */   private static final Namespace namespaceCoreProperties;
/*     */   private static final Namespace namespaceDcTerms;
/*     */   private static final Namespace namespaceXSI;
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
/*     */   PackagePropertiesPart propsPart;
/*     */   
/*     */   static {
/*  41 */     XMLEventFactory xMLEventFactory = XMLEventFactory.newInstance();
/*  42 */     namespaceDC = xMLEventFactory.createNamespace("dc", "http://purl.org/dc/elements/1.1/");
/*  43 */     namespaceCoreProperties = xMLEventFactory.createNamespace("cp", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
/*  44 */     namespaceDcTerms = xMLEventFactory.createNamespace("dcterms", "http://purl.org/dc/terms/");
/*  45 */     namespaceXSI = xMLEventFactory.createNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
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
/*  83 */   Document xmlDoc = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean marshall(PackagePart paramPackagePart, OutputStream paramOutputStream) throws OpenXML4JException {
/*  92 */     if (!(paramPackagePart instanceof PackagePropertiesPart)) {
/*  93 */       throw new IllegalArgumentException("'part' must be a PackagePropertiesPart instance.");
/*     */     }
/*  95 */     this.propsPart = (PackagePropertiesPart)paramPackagePart;
/*     */ 
/*     */     
/*  98 */     this.xmlDoc = DocumentHelper.createDocument();
/*  99 */     Element element = this.xmlDoc.createElementNS(namespaceCoreProperties.getNamespaceURI(), getQName("coreProperties", namespaceCoreProperties));
/*     */     
/* 101 */     DocumentHelper.addNamespaceDeclaration(element, namespaceCoreProperties);
/* 102 */     DocumentHelper.addNamespaceDeclaration(element, namespaceDC);
/* 103 */     DocumentHelper.addNamespaceDeclaration(element, namespaceDcTerms);
/* 104 */     DocumentHelper.addNamespaceDeclaration(element, namespaceXSI);
/* 105 */     this.xmlDoc.appendChild(element);
/*     */     
/* 107 */     addCategory();
/* 108 */     addContentStatus();
/* 109 */     addContentType();
/* 110 */     addCreated();
/* 111 */     addCreator();
/* 112 */     addDescription();
/* 113 */     addIdentifier();
/* 114 */     addKeywords();
/* 115 */     addLanguage();
/* 116 */     addLastModifiedBy();
/* 117 */     addLastPrinted();
/* 118 */     addModified();
/* 119 */     addRevision();
/* 120 */     addSubject();
/* 121 */     addTitle();
/* 122 */     addVersion();
/* 123 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Element setElementTextContent(String paramString, Namespace paramNamespace, Nullable<String> paramNullable) {
/* 130 */     return setElementTextContent(paramString, paramNamespace, paramNullable, (String)paramNullable.getValue());
/*     */   }
/*     */   
/*     */   private String getQName(String paramString, Namespace paramNamespace) {
/* 134 */     return paramNamespace.getPrefix().isEmpty() ? paramString : (paramNamespace.getPrefix() + ':' + paramString);
/*     */   }
/*     */   
/*     */   private Element setElementTextContent(String paramString1, Namespace paramNamespace, Nullable<?> paramNullable, String paramString2) {
/* 138 */     if (!paramNullable.hasValue()) {
/* 139 */       return null;
/*     */     }
/* 141 */     Element element1 = this.xmlDoc.getDocumentElement();
/* 142 */     Element element2 = (Element)element1.getElementsByTagNameNS(paramNamespace.getNamespaceURI(), paramString1).item(0);
/* 143 */     if (element2 == null) {
/*     */       
/* 145 */       element2 = this.xmlDoc.createElementNS(paramNamespace.getNamespaceURI(), getQName(paramString1, paramNamespace));
/* 146 */       element1.appendChild(element2);
/*     */     } 
/* 148 */     element2.setTextContent(paramString2);
/* 149 */     return element2;
/*     */   }
/*     */   
/*     */   private Element setElementTextContent(String paramString1, Namespace paramNamespace, Nullable<?> paramNullable, String paramString2, String paramString3) {
/* 153 */     Element element = setElementTextContent(paramString1, paramNamespace, paramNullable, paramString2);
/* 154 */     if (element != null) {
/* 155 */       element.setAttributeNS(namespaceXSI.getNamespaceURI(), getQName("type", namespaceXSI), paramString3);
/*     */     }
/* 157 */     return element;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addCategory() {
/* 165 */     setElementTextContent("category", namespaceCoreProperties, this.propsPart.getCategoryProperty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addContentStatus() {
/* 172 */     setElementTextContent("contentStatus", namespaceCoreProperties, this.propsPart.getContentStatusProperty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addContentType() {
/* 179 */     setElementTextContent("contentType", namespaceCoreProperties, this.propsPart.getContentTypeProperty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addCreated() {
/* 186 */     setElementTextContent("created", namespaceDcTerms, this.propsPart.getCreatedProperty(), this.propsPart.getCreatedPropertyString(), "dcterms:W3CDTF");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addCreator() {
/* 194 */     setElementTextContent("creator", namespaceDC, this.propsPart.getCreatorProperty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addDescription() {
/* 201 */     setElementTextContent("description", namespaceDC, this.propsPart.getDescriptionProperty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addIdentifier() {
/* 208 */     setElementTextContent("identifier", namespaceDC, this.propsPart.getIdentifierProperty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addKeywords() {
/* 215 */     setElementTextContent("keywords", namespaceCoreProperties, this.propsPart.getKeywordsProperty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addLanguage() {
/* 222 */     setElementTextContent("language", namespaceDC, this.propsPart.getLanguageProperty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addLastModifiedBy() {
/* 229 */     setElementTextContent("lastModifiedBy", namespaceCoreProperties, this.propsPart.getLastModifiedByProperty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addLastPrinted() {
/* 237 */     setElementTextContent("lastPrinted", namespaceCoreProperties, this.propsPart.getLastPrintedProperty(), this.propsPart.getLastPrintedPropertyString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addModified() {
/* 244 */     setElementTextContent("modified", namespaceDcTerms, this.propsPart.getModifiedProperty(), this.propsPart.getModifiedPropertyString(), "dcterms:W3CDTF");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addRevision() {
/* 252 */     setElementTextContent("revision", namespaceCoreProperties, this.propsPart.getRevisionProperty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addSubject() {
/* 259 */     setElementTextContent("subject", namespaceDC, this.propsPart.getSubjectProperty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addTitle() {
/* 266 */     setElementTextContent("title", namespaceDC, this.propsPart.getTitleProperty());
/*     */   }
/*     */   
/*     */   private void addVersion() {
/* 270 */     setElementTextContent("version", namespaceCoreProperties, this.propsPart.getVersionProperty());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\internal\marshallers\PackagePropertiesMarshaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */