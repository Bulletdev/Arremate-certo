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
/*     */ public interface IncludeDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$IncludeDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$IncludeDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$IncludeDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("includeaf6ddoctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Include getInclude();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setInclude(Include paramInclude);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Include addNewInclude();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Include
/*     */     extends Annotated
/*     */   {
/*  44 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((IncludeDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$IncludeDocument$Include == null) ? (IncludeDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$IncludeDocument$Include = IncludeDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument$Include")) : IncludeDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$IncludeDocument$Include).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("include59d9elemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     String getSchemaLocation();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlAnyURI xgetSchemaLocation();
/*     */ 
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
/*     */     public static final class Factory
/*     */     {
/*     */       public static IncludeDocument.Include newInstance() {
/*  75 */         return (IncludeDocument.Include)XmlBeans.getContextTypeLoader().newInstance(IncludeDocument.Include.type, null);
/*     */       }
/*     */       public static IncludeDocument.Include newInstance(XmlOptions param2XmlOptions) {
/*  78 */         return (IncludeDocument.Include)XmlBeans.getContextTypeLoader().newInstance(IncludeDocument.Include.type, param2XmlOptions);
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
/*     */     public static IncludeDocument newInstance() {
/*  92 */       return (IncludeDocument)XmlBeans.getContextTypeLoader().newInstance(IncludeDocument.type, null);
/*     */     }
/*     */     public static IncludeDocument newInstance(XmlOptions param1XmlOptions) {
/*  95 */       return (IncludeDocument)XmlBeans.getContextTypeLoader().newInstance(IncludeDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static IncludeDocument parse(String param1String) throws XmlException {
/*  99 */       return (IncludeDocument)XmlBeans.getContextTypeLoader().parse(param1String, IncludeDocument.type, null);
/*     */     }
/*     */     public static IncludeDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 102 */       return (IncludeDocument)XmlBeans.getContextTypeLoader().parse(param1String, IncludeDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static IncludeDocument parse(File param1File) throws XmlException, IOException {
/* 106 */       return (IncludeDocument)XmlBeans.getContextTypeLoader().parse(param1File, IncludeDocument.type, null);
/*     */     }
/*     */     public static IncludeDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 109 */       return (IncludeDocument)XmlBeans.getContextTypeLoader().parse(param1File, IncludeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static IncludeDocument parse(URL param1URL) throws XmlException, IOException {
/* 112 */       return (IncludeDocument)XmlBeans.getContextTypeLoader().parse(param1URL, IncludeDocument.type, null);
/*     */     }
/*     */     public static IncludeDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 115 */       return (IncludeDocument)XmlBeans.getContextTypeLoader().parse(param1URL, IncludeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static IncludeDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/* 118 */       return (IncludeDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, IncludeDocument.type, null);
/*     */     }
/*     */     public static IncludeDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 121 */       return (IncludeDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, IncludeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static IncludeDocument parse(Reader param1Reader) throws XmlException, IOException {
/* 124 */       return (IncludeDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, IncludeDocument.type, null);
/*     */     }
/*     */     public static IncludeDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 127 */       return (IncludeDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, IncludeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static IncludeDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 130 */       return (IncludeDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, IncludeDocument.type, null);
/*     */     }
/*     */     public static IncludeDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 133 */       return (IncludeDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, IncludeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static IncludeDocument parse(Node param1Node) throws XmlException {
/* 136 */       return (IncludeDocument)XmlBeans.getContextTypeLoader().parse(param1Node, IncludeDocument.type, null);
/*     */     }
/*     */     public static IncludeDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 139 */       return (IncludeDocument)XmlBeans.getContextTypeLoader().parse(param1Node, IncludeDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static IncludeDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 143 */       return (IncludeDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, IncludeDocument.type, null);
/*     */     }
/*     */     
/*     */     public static IncludeDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 147 */       return (IncludeDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, IncludeDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 151 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, IncludeDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 155 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, IncludeDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\IncludeDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */