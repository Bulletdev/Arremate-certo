/*     */ package org.apache.xmlbeans.impl.xb.ltgfmt;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.XmlToken;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface Code extends XmlObject {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$ltgfmt$Code == null) ? (null.class$org$apache$xmlbeans$impl$xb$ltgfmt$Code = null.class$("org.apache.xmlbeans.impl.xb.ltgfmt.Code")) : null.class$org$apache$xmlbeans$impl$xb$ltgfmt$Code).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("codef72ftype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getID();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlToken xgetID();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetID();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setID(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetID(XmlToken paramXmlToken);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetID();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static Code newInstance() {
/*  59 */       return (Code)XmlBeans.getContextTypeLoader().newInstance(Code.type, null);
/*     */     }
/*     */     public static Code newInstance(XmlOptions param1XmlOptions) {
/*  62 */       return (Code)XmlBeans.getContextTypeLoader().newInstance(Code.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Code parse(String param1String) throws XmlException {
/*  66 */       return (Code)XmlBeans.getContextTypeLoader().parse(param1String, Code.type, null);
/*     */     }
/*     */     public static Code parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  69 */       return (Code)XmlBeans.getContextTypeLoader().parse(param1String, Code.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Code parse(File param1File) throws XmlException, IOException {
/*  73 */       return (Code)XmlBeans.getContextTypeLoader().parse(param1File, Code.type, null);
/*     */     }
/*     */     public static Code parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  76 */       return (Code)XmlBeans.getContextTypeLoader().parse(param1File, Code.type, param1XmlOptions);
/*     */     }
/*     */     public static Code parse(URL param1URL) throws XmlException, IOException {
/*  79 */       return (Code)XmlBeans.getContextTypeLoader().parse(param1URL, Code.type, null);
/*     */     }
/*     */     public static Code parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  82 */       return (Code)XmlBeans.getContextTypeLoader().parse(param1URL, Code.type, param1XmlOptions);
/*     */     }
/*     */     public static Code parse(InputStream param1InputStream) throws XmlException, IOException {
/*  85 */       return (Code)XmlBeans.getContextTypeLoader().parse(param1InputStream, Code.type, null);
/*     */     }
/*     */     public static Code parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  88 */       return (Code)XmlBeans.getContextTypeLoader().parse(param1InputStream, Code.type, param1XmlOptions);
/*     */     }
/*     */     public static Code parse(Reader param1Reader) throws XmlException, IOException {
/*  91 */       return (Code)XmlBeans.getContextTypeLoader().parse(param1Reader, Code.type, null);
/*     */     }
/*     */     public static Code parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  94 */       return (Code)XmlBeans.getContextTypeLoader().parse(param1Reader, Code.type, param1XmlOptions);
/*     */     }
/*     */     public static Code parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  97 */       return (Code)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Code.type, null);
/*     */     }
/*     */     public static Code parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 100 */       return (Code)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Code.type, param1XmlOptions);
/*     */     }
/*     */     public static Code parse(Node param1Node) throws XmlException {
/* 103 */       return (Code)XmlBeans.getContextTypeLoader().parse(param1Node, Code.type, null);
/*     */     }
/*     */     public static Code parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 106 */       return (Code)XmlBeans.getContextTypeLoader().parse(param1Node, Code.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Code parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 110 */       return (Code)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Code.type, null);
/*     */     }
/*     */     
/*     */     public static Code parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 114 */       return (Code)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Code.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 118 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Code.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 122 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Code.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\ltgfmt\Code.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */