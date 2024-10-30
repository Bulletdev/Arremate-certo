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
/*     */ public interface AppinfoDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$AppinfoDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$AppinfoDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$AppinfoDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("appinfo2ea6doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Appinfo getAppinfo();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setAppinfo(Appinfo paramAppinfo);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Appinfo addNewAppinfo();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Appinfo
/*     */     extends XmlObject
/*     */   {
/*  44 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((AppinfoDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$AppinfoDocument$Appinfo == null) ? (AppinfoDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$AppinfoDocument$Appinfo = AppinfoDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument$Appinfo")) : AppinfoDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$AppinfoDocument$Appinfo).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("appinfo650belemtype");
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
/*     */     public static final class Factory
/*     */     {
/*     */       public static AppinfoDocument.Appinfo newInstance() {
/*  85 */         return (AppinfoDocument.Appinfo)XmlBeans.getContextTypeLoader().newInstance(AppinfoDocument.Appinfo.type, null);
/*     */       }
/*     */       public static AppinfoDocument.Appinfo newInstance(XmlOptions param2XmlOptions) {
/*  88 */         return (AppinfoDocument.Appinfo)XmlBeans.getContextTypeLoader().newInstance(AppinfoDocument.Appinfo.type, param2XmlOptions);
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
/*     */     public static AppinfoDocument newInstance() {
/* 102 */       return (AppinfoDocument)XmlBeans.getContextTypeLoader().newInstance(AppinfoDocument.type, null);
/*     */     }
/*     */     public static AppinfoDocument newInstance(XmlOptions param1XmlOptions) {
/* 105 */       return (AppinfoDocument)XmlBeans.getContextTypeLoader().newInstance(AppinfoDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AppinfoDocument parse(String param1String) throws XmlException {
/* 109 */       return (AppinfoDocument)XmlBeans.getContextTypeLoader().parse(param1String, AppinfoDocument.type, null);
/*     */     }
/*     */     public static AppinfoDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 112 */       return (AppinfoDocument)XmlBeans.getContextTypeLoader().parse(param1String, AppinfoDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AppinfoDocument parse(File param1File) throws XmlException, IOException {
/* 116 */       return (AppinfoDocument)XmlBeans.getContextTypeLoader().parse(param1File, AppinfoDocument.type, null);
/*     */     }
/*     */     public static AppinfoDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 119 */       return (AppinfoDocument)XmlBeans.getContextTypeLoader().parse(param1File, AppinfoDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AppinfoDocument parse(URL param1URL) throws XmlException, IOException {
/* 122 */       return (AppinfoDocument)XmlBeans.getContextTypeLoader().parse(param1URL, AppinfoDocument.type, null);
/*     */     }
/*     */     public static AppinfoDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 125 */       return (AppinfoDocument)XmlBeans.getContextTypeLoader().parse(param1URL, AppinfoDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AppinfoDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/* 128 */       return (AppinfoDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, AppinfoDocument.type, null);
/*     */     }
/*     */     public static AppinfoDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 131 */       return (AppinfoDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, AppinfoDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AppinfoDocument parse(Reader param1Reader) throws XmlException, IOException {
/* 134 */       return (AppinfoDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, AppinfoDocument.type, null);
/*     */     }
/*     */     public static AppinfoDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 137 */       return (AppinfoDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, AppinfoDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AppinfoDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 140 */       return (AppinfoDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, AppinfoDocument.type, null);
/*     */     }
/*     */     public static AppinfoDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 143 */       return (AppinfoDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, AppinfoDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AppinfoDocument parse(Node param1Node) throws XmlException {
/* 146 */       return (AppinfoDocument)XmlBeans.getContextTypeLoader().parse(param1Node, AppinfoDocument.type, null);
/*     */     }
/*     */     public static AppinfoDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 149 */       return (AppinfoDocument)XmlBeans.getContextTypeLoader().parse(param1Node, AppinfoDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AppinfoDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 153 */       return (AppinfoDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, AppinfoDocument.type, null);
/*     */     }
/*     */     
/*     */     public static AppinfoDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 157 */       return (AppinfoDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, AppinfoDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 161 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, AppinfoDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 165 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, AppinfoDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\AppinfoDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */