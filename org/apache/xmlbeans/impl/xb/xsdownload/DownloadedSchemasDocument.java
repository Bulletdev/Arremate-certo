/*     */ package org.apache.xmlbeans.impl.xb.xsdownload;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.XmlToken;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface DownloadedSchemasDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdownload$DownloadedSchemasDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdownload$DownloadedSchemasDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdownload$DownloadedSchemasDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("downloadedschemas2dd7doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   DownloadedSchemas getDownloadedSchemas();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setDownloadedSchemas(DownloadedSchemas paramDownloadedSchemas);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   DownloadedSchemas addNewDownloadedSchemas();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface DownloadedSchemas
/*     */     extends XmlObject
/*     */   {
/*  44 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((DownloadedSchemasDocument.null.class$org$apache$xmlbeans$impl$xb$xsdownload$DownloadedSchemasDocument$DownloadedSchemas == null) ? (DownloadedSchemasDocument.null.class$org$apache$xmlbeans$impl$xb$xsdownload$DownloadedSchemasDocument$DownloadedSchemas = DownloadedSchemasDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument$DownloadedSchemas")) : DownloadedSchemasDocument.null.class$org$apache$xmlbeans$impl$xb$xsdownload$DownloadedSchemasDocument$DownloadedSchemas).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("downloadedschemasb3efelemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     DownloadedSchemaEntry[] getEntryArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     DownloadedSchemaEntry getEntryArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfEntryArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setEntryArray(DownloadedSchemaEntry[] param1ArrayOfDownloadedSchemaEntry);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setEntryArray(int param1Int, DownloadedSchemaEntry param1DownloadedSchemaEntry);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     DownloadedSchemaEntry insertNewEntry(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     DownloadedSchemaEntry addNewEntry();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeEntry(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     String getDefaultDirectory();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlToken xgetDefaultDirectory();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetDefaultDirectory();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setDefaultDirectory(String param1String);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetDefaultDirectory(XmlToken param1XmlToken);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetDefaultDirectory();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static DownloadedSchemasDocument.DownloadedSchemas newInstance() {
/* 125 */         return (DownloadedSchemasDocument.DownloadedSchemas)XmlBeans.getContextTypeLoader().newInstance(DownloadedSchemasDocument.DownloadedSchemas.type, null);
/*     */       }
/*     */       public static DownloadedSchemasDocument.DownloadedSchemas newInstance(XmlOptions param2XmlOptions) {
/* 128 */         return (DownloadedSchemasDocument.DownloadedSchemas)XmlBeans.getContextTypeLoader().newInstance(DownloadedSchemasDocument.DownloadedSchemas.type, param2XmlOptions);
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
/*     */     public static DownloadedSchemasDocument newInstance() {
/* 142 */       return (DownloadedSchemasDocument)XmlBeans.getContextTypeLoader().newInstance(DownloadedSchemasDocument.type, null);
/*     */     }
/*     */     public static DownloadedSchemasDocument newInstance(XmlOptions param1XmlOptions) {
/* 145 */       return (DownloadedSchemasDocument)XmlBeans.getContextTypeLoader().newInstance(DownloadedSchemasDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static DownloadedSchemasDocument parse(String param1String) throws XmlException {
/* 149 */       return (DownloadedSchemasDocument)XmlBeans.getContextTypeLoader().parse(param1String, DownloadedSchemasDocument.type, null);
/*     */     }
/*     */     public static DownloadedSchemasDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 152 */       return (DownloadedSchemasDocument)XmlBeans.getContextTypeLoader().parse(param1String, DownloadedSchemasDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static DownloadedSchemasDocument parse(File param1File) throws XmlException, IOException {
/* 156 */       return (DownloadedSchemasDocument)XmlBeans.getContextTypeLoader().parse(param1File, DownloadedSchemasDocument.type, null);
/*     */     }
/*     */     public static DownloadedSchemasDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 159 */       return (DownloadedSchemasDocument)XmlBeans.getContextTypeLoader().parse(param1File, DownloadedSchemasDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static DownloadedSchemasDocument parse(URL param1URL) throws XmlException, IOException {
/* 162 */       return (DownloadedSchemasDocument)XmlBeans.getContextTypeLoader().parse(param1URL, DownloadedSchemasDocument.type, null);
/*     */     }
/*     */     public static DownloadedSchemasDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 165 */       return (DownloadedSchemasDocument)XmlBeans.getContextTypeLoader().parse(param1URL, DownloadedSchemasDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static DownloadedSchemasDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/* 168 */       return (DownloadedSchemasDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, DownloadedSchemasDocument.type, null);
/*     */     }
/*     */     public static DownloadedSchemasDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 171 */       return (DownloadedSchemasDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, DownloadedSchemasDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static DownloadedSchemasDocument parse(Reader param1Reader) throws XmlException, IOException {
/* 174 */       return (DownloadedSchemasDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, DownloadedSchemasDocument.type, null);
/*     */     }
/*     */     public static DownloadedSchemasDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 177 */       return (DownloadedSchemasDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, DownloadedSchemasDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static DownloadedSchemasDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 180 */       return (DownloadedSchemasDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, DownloadedSchemasDocument.type, null);
/*     */     }
/*     */     public static DownloadedSchemasDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 183 */       return (DownloadedSchemasDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, DownloadedSchemasDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static DownloadedSchemasDocument parse(Node param1Node) throws XmlException {
/* 186 */       return (DownloadedSchemasDocument)XmlBeans.getContextTypeLoader().parse(param1Node, DownloadedSchemasDocument.type, null);
/*     */     }
/*     */     public static DownloadedSchemasDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 189 */       return (DownloadedSchemasDocument)XmlBeans.getContextTypeLoader().parse(param1Node, DownloadedSchemasDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static DownloadedSchemasDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 193 */       return (DownloadedSchemasDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, DownloadedSchemasDocument.type, null);
/*     */     }
/*     */     
/*     */     public static DownloadedSchemasDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 197 */       return (DownloadedSchemasDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, DownloadedSchemasDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 201 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, DownloadedSchemasDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 205 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, DownloadedSchemasDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdownload\DownloadedSchemasDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */