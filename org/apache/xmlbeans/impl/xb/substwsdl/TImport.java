/*     */ package org.apache.xmlbeans.impl.xb.substwsdl;
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
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface TImport extends XmlObject {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$substwsdl$TImport == null) ? (null.class$org$apache$xmlbeans$impl$xb$substwsdl$TImport = null.class$("org.apache.xmlbeans.impl.xb.substwsdl.TImport")) : null.class$org$apache$xmlbeans$impl$xb$substwsdl$TImport).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("timport22datype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getNamespace();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlAnyURI xgetNamespace();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setNamespace(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetNamespace(XmlAnyURI paramXmlAnyURI);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getLocation();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlAnyURI xgetLocation();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setLocation(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetLocation(XmlAnyURI paramXmlAnyURI);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static TImport newInstance() {
/*  69 */       return (TImport)XmlBeans.getContextTypeLoader().newInstance(TImport.type, null);
/*     */     }
/*     */     public static TImport newInstance(XmlOptions param1XmlOptions) {
/*  72 */       return (TImport)XmlBeans.getContextTypeLoader().newInstance(TImport.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TImport parse(String param1String) throws XmlException {
/*  76 */       return (TImport)XmlBeans.getContextTypeLoader().parse(param1String, TImport.type, null);
/*     */     }
/*     */     public static TImport parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  79 */       return (TImport)XmlBeans.getContextTypeLoader().parse(param1String, TImport.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TImport parse(File param1File) throws XmlException, IOException {
/*  83 */       return (TImport)XmlBeans.getContextTypeLoader().parse(param1File, TImport.type, null);
/*     */     }
/*     */     public static TImport parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  86 */       return (TImport)XmlBeans.getContextTypeLoader().parse(param1File, TImport.type, param1XmlOptions);
/*     */     }
/*     */     public static TImport parse(URL param1URL) throws XmlException, IOException {
/*  89 */       return (TImport)XmlBeans.getContextTypeLoader().parse(param1URL, TImport.type, null);
/*     */     }
/*     */     public static TImport parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  92 */       return (TImport)XmlBeans.getContextTypeLoader().parse(param1URL, TImport.type, param1XmlOptions);
/*     */     }
/*     */     public static TImport parse(InputStream param1InputStream) throws XmlException, IOException {
/*  95 */       return (TImport)XmlBeans.getContextTypeLoader().parse(param1InputStream, TImport.type, null);
/*     */     }
/*     */     public static TImport parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  98 */       return (TImport)XmlBeans.getContextTypeLoader().parse(param1InputStream, TImport.type, param1XmlOptions);
/*     */     }
/*     */     public static TImport parse(Reader param1Reader) throws XmlException, IOException {
/* 101 */       return (TImport)XmlBeans.getContextTypeLoader().parse(param1Reader, TImport.type, null);
/*     */     }
/*     */     public static TImport parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 104 */       return (TImport)XmlBeans.getContextTypeLoader().parse(param1Reader, TImport.type, param1XmlOptions);
/*     */     }
/*     */     public static TImport parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 107 */       return (TImport)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, TImport.type, null);
/*     */     }
/*     */     public static TImport parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 110 */       return (TImport)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, TImport.type, param1XmlOptions);
/*     */     }
/*     */     public static TImport parse(Node param1Node) throws XmlException {
/* 113 */       return (TImport)XmlBeans.getContextTypeLoader().parse(param1Node, TImport.type, null);
/*     */     }
/*     */     public static TImport parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 116 */       return (TImport)XmlBeans.getContextTypeLoader().parse(param1Node, TImport.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TImport parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 120 */       return (TImport)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, TImport.type, null);
/*     */     }
/*     */     
/*     */     public static TImport parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 124 */       return (TImport)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, TImport.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 128 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, TImport.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 132 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, TImport.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\substwsdl\TImport.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */