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
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface ImportDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$ImportDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$ImportDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$ImportDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("import99fedoctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Import getImport();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setImport(Import paramImport);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Import addNewImport();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Import
/*     */     extends Annotated
/*     */   {
/*  44 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((ImportDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$ImportDocument$Import == null) ? (ImportDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$ImportDocument$Import = ImportDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument$Import")) : ImportDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$ImportDocument$Import).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("importe2ffelemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     String getNamespace();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlAnyURI xgetNamespace();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetNamespace();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setNamespace(String param1String);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetNamespace(XmlAnyURI param1XmlAnyURI);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetNamespace();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     String getSchemaLocation();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlAnyURI xgetSchemaLocation();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetSchemaLocation();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setSchemaLocation(String param1String);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetSchemaLocation(XmlAnyURI param1XmlAnyURI);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetSchemaLocation();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static ImportDocument.Import newInstance() {
/* 115 */         return (ImportDocument.Import)XmlBeans.getContextTypeLoader().newInstance(ImportDocument.Import.type, null);
/*     */       }
/*     */       public static ImportDocument.Import newInstance(XmlOptions param2XmlOptions) {
/* 118 */         return (ImportDocument.Import)XmlBeans.getContextTypeLoader().newInstance(ImportDocument.Import.type, param2XmlOptions);
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
/*     */     public static ImportDocument newInstance() {
/* 132 */       return (ImportDocument)XmlBeans.getContextTypeLoader().newInstance(ImportDocument.type, null);
/*     */     }
/*     */     public static ImportDocument newInstance(XmlOptions param1XmlOptions) {
/* 135 */       return (ImportDocument)XmlBeans.getContextTypeLoader().newInstance(ImportDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ImportDocument parse(String param1String) throws XmlException {
/* 139 */       return (ImportDocument)XmlBeans.getContextTypeLoader().parse(param1String, ImportDocument.type, null);
/*     */     }
/*     */     public static ImportDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 142 */       return (ImportDocument)XmlBeans.getContextTypeLoader().parse(param1String, ImportDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ImportDocument parse(File param1File) throws XmlException, IOException {
/* 146 */       return (ImportDocument)XmlBeans.getContextTypeLoader().parse(param1File, ImportDocument.type, null);
/*     */     }
/*     */     public static ImportDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 149 */       return (ImportDocument)XmlBeans.getContextTypeLoader().parse(param1File, ImportDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ImportDocument parse(URL param1URL) throws XmlException, IOException {
/* 152 */       return (ImportDocument)XmlBeans.getContextTypeLoader().parse(param1URL, ImportDocument.type, null);
/*     */     }
/*     */     public static ImportDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 155 */       return (ImportDocument)XmlBeans.getContextTypeLoader().parse(param1URL, ImportDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ImportDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/* 158 */       return (ImportDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, ImportDocument.type, null);
/*     */     }
/*     */     public static ImportDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 161 */       return (ImportDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, ImportDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ImportDocument parse(Reader param1Reader) throws XmlException, IOException {
/* 164 */       return (ImportDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, ImportDocument.type, null);
/*     */     }
/*     */     public static ImportDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 167 */       return (ImportDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, ImportDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ImportDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 170 */       return (ImportDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, ImportDocument.type, null);
/*     */     }
/*     */     public static ImportDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 173 */       return (ImportDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, ImportDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ImportDocument parse(Node param1Node) throws XmlException {
/* 176 */       return (ImportDocument)XmlBeans.getContextTypeLoader().parse(param1Node, ImportDocument.type, null);
/*     */     }
/*     */     public static ImportDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 179 */       return (ImportDocument)XmlBeans.getContextTypeLoader().parse(param1Node, ImportDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ImportDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 183 */       return (ImportDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, ImportDocument.type, null);
/*     */     }
/*     */     
/*     */     public static ImportDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 187 */       return (ImportDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, ImportDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 191 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, ImportDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 195 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, ImportDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\ImportDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */