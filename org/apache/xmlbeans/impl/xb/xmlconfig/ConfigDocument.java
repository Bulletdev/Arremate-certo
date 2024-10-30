/*     */ package org.apache.xmlbeans.impl.xb.xmlconfig;
/*     */ 
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
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface ConfigDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xmlconfig$ConfigDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xmlconfig$ConfigDocument = null.class$("org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument")) : null.class$org$apache$xmlbeans$impl$xb$xmlconfig$ConfigDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("config4185doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Config getConfig();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setConfig(Config paramConfig);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Config addNewConfig();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Config
/*     */     extends XmlObject
/*     */   {
/*  44 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((ConfigDocument.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$ConfigDocument$Config == null) ? (ConfigDocument.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$ConfigDocument$Config = ConfigDocument.null.class$("org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument$Config")) : ConfigDocument.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$ConfigDocument$Config).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("configf467elemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Nsconfig[] getNamespaceArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Nsconfig getNamespaceArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfNamespaceArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setNamespaceArray(Nsconfig[] param1ArrayOfNsconfig);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setNamespaceArray(int param1Int, Nsconfig param1Nsconfig);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Nsconfig insertNewNamespace(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Nsconfig addNewNamespace();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeNamespace(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Qnameconfig[] getQnameArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Qnameconfig getQnameArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfQnameArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setQnameArray(Qnameconfig[] param1ArrayOfQnameconfig);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setQnameArray(int param1Int, Qnameconfig param1Qnameconfig);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Qnameconfig insertNewQname(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Qnameconfig addNewQname();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeQname(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Extensionconfig[] getExtensionArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Extensionconfig getExtensionArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfExtensionArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setExtensionArray(Extensionconfig[] param1ArrayOfExtensionconfig);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setExtensionArray(int param1Int, Extensionconfig param1Extensionconfig);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Extensionconfig insertNewExtension(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Extensionconfig addNewExtension();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeExtension(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Usertypeconfig[] getUsertypeArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Usertypeconfig getUsertypeArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfUsertypeArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setUsertypeArray(Usertypeconfig[] param1ArrayOfUsertypeconfig);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setUsertypeArray(int param1Int, Usertypeconfig param1Usertypeconfig);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Usertypeconfig insertNewUsertype(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Usertypeconfig addNewUsertype();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeUsertype(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static ConfigDocument.Config newInstance() {
/* 215 */         return (ConfigDocument.Config)XmlBeans.getContextTypeLoader().newInstance(ConfigDocument.Config.type, null);
/*     */       }
/*     */       public static ConfigDocument.Config newInstance(XmlOptions param2XmlOptions) {
/* 218 */         return (ConfigDocument.Config)XmlBeans.getContextTypeLoader().newInstance(ConfigDocument.Config.type, param2XmlOptions);
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
/*     */     public static ConfigDocument newInstance() {
/* 232 */       return (ConfigDocument)XmlBeans.getContextTypeLoader().newInstance(ConfigDocument.type, null);
/*     */     }
/*     */     public static ConfigDocument newInstance(XmlOptions param1XmlOptions) {
/* 235 */       return (ConfigDocument)XmlBeans.getContextTypeLoader().newInstance(ConfigDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ConfigDocument parse(String param1String) throws XmlException {
/* 239 */       return (ConfigDocument)XmlBeans.getContextTypeLoader().parse(param1String, ConfigDocument.type, null);
/*     */     }
/*     */     public static ConfigDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 242 */       return (ConfigDocument)XmlBeans.getContextTypeLoader().parse(param1String, ConfigDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ConfigDocument parse(File param1File) throws XmlException, IOException {
/* 246 */       return (ConfigDocument)XmlBeans.getContextTypeLoader().parse(param1File, ConfigDocument.type, null);
/*     */     }
/*     */     public static ConfigDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 249 */       return (ConfigDocument)XmlBeans.getContextTypeLoader().parse(param1File, ConfigDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ConfigDocument parse(URL param1URL) throws XmlException, IOException {
/* 252 */       return (ConfigDocument)XmlBeans.getContextTypeLoader().parse(param1URL, ConfigDocument.type, null);
/*     */     }
/*     */     public static ConfigDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 255 */       return (ConfigDocument)XmlBeans.getContextTypeLoader().parse(param1URL, ConfigDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ConfigDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/* 258 */       return (ConfigDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, ConfigDocument.type, null);
/*     */     }
/*     */     public static ConfigDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 261 */       return (ConfigDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, ConfigDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ConfigDocument parse(Reader param1Reader) throws XmlException, IOException {
/* 264 */       return (ConfigDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, ConfigDocument.type, null);
/*     */     }
/*     */     public static ConfigDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 267 */       return (ConfigDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, ConfigDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ConfigDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 270 */       return (ConfigDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, ConfigDocument.type, null);
/*     */     }
/*     */     public static ConfigDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 273 */       return (ConfigDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, ConfigDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ConfigDocument parse(Node param1Node) throws XmlException {
/* 276 */       return (ConfigDocument)XmlBeans.getContextTypeLoader().parse(param1Node, ConfigDocument.type, null);
/*     */     }
/*     */     public static ConfigDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 279 */       return (ConfigDocument)XmlBeans.getContextTypeLoader().parse(param1Node, ConfigDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ConfigDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 283 */       return (ConfigDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, ConfigDocument.type, null);
/*     */     }
/*     */     
/*     */     public static ConfigDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 287 */       return (ConfigDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, ConfigDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 291 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, ConfigDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 295 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, ConfigDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xmlconfig\ConfigDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */