/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlAnyURI;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlLanguage;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface DocumentationDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$DocumentationDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$DocumentationDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$DocumentationDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("documentation6cdbdoctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Documentation getDocumentation();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setDocumentation(Documentation paramDocumentation);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Documentation addNewDocumentation();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Documentation
/*     */     extends XmlObject
/*     */   {
/*  44 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((DocumentationDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$DocumentationDocument$Documentation == null) ? (DocumentationDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$DocumentationDocument$Documentation = DocumentationDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument$Documentation")) : DocumentationDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$DocumentationDocument$Documentation).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("documentationa475elemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     String getSource();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlAnyURI xgetSource();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetSource();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setSource(String param1String);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetSource(XmlAnyURI param1XmlAnyURI);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetSource();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     String getLang();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlLanguage xgetLang();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetLang();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setLang(String param1String);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetLang(XmlLanguage param1XmlLanguage);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetLang();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static DocumentationDocument.Documentation newInstance() {
/* 115 */         return (DocumentationDocument.Documentation)XmlBeans.getContextTypeLoader().newInstance(DocumentationDocument.Documentation.type, null);
/*     */       }
/*     */       public static DocumentationDocument.Documentation newInstance(XmlOptions param2XmlOptions) {
/* 118 */         return (DocumentationDocument.Documentation)XmlBeans.getContextTypeLoader().newInstance(DocumentationDocument.Documentation.type, param2XmlOptions);
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
/*     */   public static final class Factory
/*     */   {
/*     */     public static DocumentationDocument newInstance() {
/* 132 */       return (DocumentationDocument)XmlBeans.getContextTypeLoader().newInstance(DocumentationDocument.type, null);
/*     */     }
/*     */     public static DocumentationDocument newInstance(XmlOptions param1XmlOptions) {
/* 135 */       return (DocumentationDocument)XmlBeans.getContextTypeLoader().newInstance(DocumentationDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static DocumentationDocument parse(String param1String) throws XmlException {
/* 139 */       return (DocumentationDocument)XmlBeans.getContextTypeLoader().parse(param1String, DocumentationDocument.type, null);
/*     */     }
/*     */     public static DocumentationDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 142 */       return (DocumentationDocument)XmlBeans.getContextTypeLoader().parse(param1String, DocumentationDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static DocumentationDocument parse(File param1File) throws XmlException, IOException {
/* 146 */       return (DocumentationDocument)XmlBeans.getContextTypeLoader().parse(param1File, DocumentationDocument.type, null);
/*     */     }
/*     */     public static DocumentationDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 149 */       return (DocumentationDocument)XmlBeans.getContextTypeLoader().parse(param1File, DocumentationDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static DocumentationDocument parse(URL param1URL) throws XmlException, IOException {
/* 152 */       return (DocumentationDocument)XmlBeans.getContextTypeLoader().parse(param1URL, DocumentationDocument.type, null);
/*     */     }
/*     */     public static DocumentationDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 155 */       return (DocumentationDocument)XmlBeans.getContextTypeLoader().parse(param1URL, DocumentationDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static DocumentationDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/* 158 */       return (DocumentationDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, DocumentationDocument.type, null);
/*     */     }
/*     */     public static DocumentationDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 161 */       return (DocumentationDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, DocumentationDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static DocumentationDocument parse(Reader param1Reader) throws XmlException, IOException {
/* 164 */       return (DocumentationDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, DocumentationDocument.type, null);
/*     */     }
/*     */     public static DocumentationDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 167 */       return (DocumentationDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, DocumentationDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static DocumentationDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 170 */       return (DocumentationDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, DocumentationDocument.type, null);
/*     */     }
/*     */     public static DocumentationDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 173 */       return (DocumentationDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, DocumentationDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static DocumentationDocument parse(Node param1Node) throws XmlException {
/* 176 */       return (DocumentationDocument)XmlBeans.getContextTypeLoader().parse(param1Node, DocumentationDocument.type, null);
/*     */     }
/*     */     public static DocumentationDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 179 */       return (DocumentationDocument)XmlBeans.getContextTypeLoader().parse(param1Node, DocumentationDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static DocumentationDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 183 */       return (DocumentationDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, DocumentationDocument.type, null);
/*     */     }
/*     */     
/*     */     public static DocumentationDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 187 */       return (DocumentationDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, DocumentationDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 191 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, DocumentationDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 195 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, DocumentationDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\DocumentationDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */