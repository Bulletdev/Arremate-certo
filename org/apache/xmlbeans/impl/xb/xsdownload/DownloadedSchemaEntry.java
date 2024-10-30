/*     */ package org.apache.xmlbeans.impl.xb.xsdownload;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.XmlAnyURI;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.XmlToken;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface DownloadedSchemaEntry extends XmlObject {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdownload$DownloadedSchemaEntry == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdownload$DownloadedSchemaEntry = null.class$("org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry")) : null.class$org$apache$xmlbeans$impl$xb$xsdownload$DownloadedSchemaEntry).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("downloadedschemaentry1c75type");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getFilename();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlToken xgetFilename();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setFilename(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetFilename(XmlToken paramXmlToken);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getSha1();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlToken xgetSha1();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setSha1(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetSha1(XmlToken paramXmlToken);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String[] getSchemaLocationArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getSchemaLocationArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlAnyURI[] xgetSchemaLocationArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlAnyURI xgetSchemaLocationArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfSchemaLocationArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setSchemaLocationArray(String[] paramArrayOfString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setSchemaLocationArray(int paramInt, String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetSchemaLocationArray(XmlAnyURI[] paramArrayOfXmlAnyURI);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetSchemaLocationArray(int paramInt, XmlAnyURI paramXmlAnyURI);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void insertSchemaLocation(int paramInt, String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void addSchemaLocation(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlAnyURI insertNewSchemaLocation(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlAnyURI addNewSchemaLocation();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeSchemaLocation(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getNamespace();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlAnyURI xgetNamespace();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetNamespace();
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
/*     */   void unsetNamespace();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static DownloadedSchemaEntry newInstance() {
/* 169 */       return (DownloadedSchemaEntry)XmlBeans.getContextTypeLoader().newInstance(DownloadedSchemaEntry.type, null);
/*     */     }
/*     */     public static DownloadedSchemaEntry newInstance(XmlOptions param1XmlOptions) {
/* 172 */       return (DownloadedSchemaEntry)XmlBeans.getContextTypeLoader().newInstance(DownloadedSchemaEntry.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static DownloadedSchemaEntry parse(String param1String) throws XmlException {
/* 176 */       return (DownloadedSchemaEntry)XmlBeans.getContextTypeLoader().parse(param1String, DownloadedSchemaEntry.type, null);
/*     */     }
/*     */     public static DownloadedSchemaEntry parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 179 */       return (DownloadedSchemaEntry)XmlBeans.getContextTypeLoader().parse(param1String, DownloadedSchemaEntry.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static DownloadedSchemaEntry parse(File param1File) throws XmlException, IOException {
/* 183 */       return (DownloadedSchemaEntry)XmlBeans.getContextTypeLoader().parse(param1File, DownloadedSchemaEntry.type, null);
/*     */     }
/*     */     public static DownloadedSchemaEntry parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 186 */       return (DownloadedSchemaEntry)XmlBeans.getContextTypeLoader().parse(param1File, DownloadedSchemaEntry.type, param1XmlOptions);
/*     */     }
/*     */     public static DownloadedSchemaEntry parse(URL param1URL) throws XmlException, IOException {
/* 189 */       return (DownloadedSchemaEntry)XmlBeans.getContextTypeLoader().parse(param1URL, DownloadedSchemaEntry.type, null);
/*     */     }
/*     */     public static DownloadedSchemaEntry parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 192 */       return (DownloadedSchemaEntry)XmlBeans.getContextTypeLoader().parse(param1URL, DownloadedSchemaEntry.type, param1XmlOptions);
/*     */     }
/*     */     public static DownloadedSchemaEntry parse(InputStream param1InputStream) throws XmlException, IOException {
/* 195 */       return (DownloadedSchemaEntry)XmlBeans.getContextTypeLoader().parse(param1InputStream, DownloadedSchemaEntry.type, null);
/*     */     }
/*     */     public static DownloadedSchemaEntry parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 198 */       return (DownloadedSchemaEntry)XmlBeans.getContextTypeLoader().parse(param1InputStream, DownloadedSchemaEntry.type, param1XmlOptions);
/*     */     }
/*     */     public static DownloadedSchemaEntry parse(Reader param1Reader) throws XmlException, IOException {
/* 201 */       return (DownloadedSchemaEntry)XmlBeans.getContextTypeLoader().parse(param1Reader, DownloadedSchemaEntry.type, null);
/*     */     }
/*     */     public static DownloadedSchemaEntry parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 204 */       return (DownloadedSchemaEntry)XmlBeans.getContextTypeLoader().parse(param1Reader, DownloadedSchemaEntry.type, param1XmlOptions);
/*     */     }
/*     */     public static DownloadedSchemaEntry parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 207 */       return (DownloadedSchemaEntry)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, DownloadedSchemaEntry.type, null);
/*     */     }
/*     */     public static DownloadedSchemaEntry parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 210 */       return (DownloadedSchemaEntry)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, DownloadedSchemaEntry.type, param1XmlOptions);
/*     */     }
/*     */     public static DownloadedSchemaEntry parse(Node param1Node) throws XmlException {
/* 213 */       return (DownloadedSchemaEntry)XmlBeans.getContextTypeLoader().parse(param1Node, DownloadedSchemaEntry.type, null);
/*     */     }
/*     */     public static DownloadedSchemaEntry parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 216 */       return (DownloadedSchemaEntry)XmlBeans.getContextTypeLoader().parse(param1Node, DownloadedSchemaEntry.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static DownloadedSchemaEntry parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 220 */       return (DownloadedSchemaEntry)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, DownloadedSchemaEntry.type, null);
/*     */     }
/*     */     
/*     */     public static DownloadedSchemaEntry parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 224 */       return (DownloadedSchemaEntry)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, DownloadedSchemaEntry.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 228 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, DownloadedSchemaEntry.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 232 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, DownloadedSchemaEntry.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdownload\DownloadedSchemaEntry.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */