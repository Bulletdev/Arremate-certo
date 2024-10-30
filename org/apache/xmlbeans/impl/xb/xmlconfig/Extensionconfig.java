/*     */ package org.apache.xmlbeans.impl.xb.xmlconfig;
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
/*     */ import org.apache.xmlbeans.XmlString;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface Extensionconfig extends XmlObject {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xmlconfig$Extensionconfig == null) ? (null.class$org$apache$xmlbeans$impl$xb$xmlconfig$Extensionconfig = null.class$("org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig")) : null.class$org$apache$xmlbeans$impl$xb$xmlconfig$Extensionconfig).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("extensionconfig2ac2type");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Interface[] getInterfaceArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Interface getInterfaceArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfInterfaceArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setInterfaceArray(Interface[] paramArrayOfInterface);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setInterfaceArray(int paramInt, Interface paramInterface);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Interface insertNewInterface(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Interface addNewInterface();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeInterface(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PrePostSet getPrePostSet();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetPrePostSet();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setPrePostSet(PrePostSet paramPrePostSet);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PrePostSet addNewPrePostSet();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetPrePostSet();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Object getFor();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   JavaNameList xgetFor();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetFor();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setFor(Object paramObject);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetFor(JavaNameList paramJavaNameList);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetFor();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Interface
/*     */     extends XmlObject
/*     */   {
/* 123 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((Extensionconfig.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$Extensionconfig$Interface == null) ? (Extensionconfig.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$Extensionconfig$Interface = Extensionconfig.null.class$("org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig$Interface")) : Extensionconfig.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$Extensionconfig$Interface).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("interface02a7elemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     String getStaticHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlString xgetStaticHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setStaticHandler(String param1String);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetStaticHandler(XmlString param1XmlString);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     String getName();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlString xgetName();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetName();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setName(String param1String);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetName(XmlString param1XmlString);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetName();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static Extensionconfig.Interface newInstance() {
/* 184 */         return (Extensionconfig.Interface)XmlBeans.getContextTypeLoader().newInstance(Extensionconfig.Interface.type, null);
/*     */       }
/*     */       public static Extensionconfig.Interface newInstance(XmlOptions param2XmlOptions) {
/* 187 */         return (Extensionconfig.Interface)XmlBeans.getContextTypeLoader().newInstance(Extensionconfig.Interface.type, param2XmlOptions);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface PrePostSet
/*     */     extends XmlObject
/*     */   {
/* 200 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((Extensionconfig.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$Extensionconfig$PrePostSet == null) ? (Extensionconfig.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$Extensionconfig$PrePostSet = Extensionconfig.null.class$("org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig$PrePostSet")) : Extensionconfig.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$Extensionconfig$PrePostSet).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("prepostset5c9delemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     String getStaticHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlString xgetStaticHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setStaticHandler(String param1String);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetStaticHandler(XmlString param1XmlString);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static Extensionconfig.PrePostSet newInstance() {
/* 231 */         return (Extensionconfig.PrePostSet)XmlBeans.getContextTypeLoader().newInstance(Extensionconfig.PrePostSet.type, null);
/*     */       }
/*     */       public static Extensionconfig.PrePostSet newInstance(XmlOptions param2XmlOptions) {
/* 234 */         return (Extensionconfig.PrePostSet)XmlBeans.getContextTypeLoader().newInstance(Extensionconfig.PrePostSet.type, param2XmlOptions);
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
/*     */     public static Extensionconfig newInstance() {
/* 248 */       return (Extensionconfig)XmlBeans.getContextTypeLoader().newInstance(Extensionconfig.type, null);
/*     */     }
/*     */     public static Extensionconfig newInstance(XmlOptions param1XmlOptions) {
/* 251 */       return (Extensionconfig)XmlBeans.getContextTypeLoader().newInstance(Extensionconfig.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Extensionconfig parse(String param1String) throws XmlException {
/* 255 */       return (Extensionconfig)XmlBeans.getContextTypeLoader().parse(param1String, Extensionconfig.type, null);
/*     */     }
/*     */     public static Extensionconfig parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 258 */       return (Extensionconfig)XmlBeans.getContextTypeLoader().parse(param1String, Extensionconfig.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Extensionconfig parse(File param1File) throws XmlException, IOException {
/* 262 */       return (Extensionconfig)XmlBeans.getContextTypeLoader().parse(param1File, Extensionconfig.type, null);
/*     */     }
/*     */     public static Extensionconfig parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 265 */       return (Extensionconfig)XmlBeans.getContextTypeLoader().parse(param1File, Extensionconfig.type, param1XmlOptions);
/*     */     }
/*     */     public static Extensionconfig parse(URL param1URL) throws XmlException, IOException {
/* 268 */       return (Extensionconfig)XmlBeans.getContextTypeLoader().parse(param1URL, Extensionconfig.type, null);
/*     */     }
/*     */     public static Extensionconfig parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 271 */       return (Extensionconfig)XmlBeans.getContextTypeLoader().parse(param1URL, Extensionconfig.type, param1XmlOptions);
/*     */     }
/*     */     public static Extensionconfig parse(InputStream param1InputStream) throws XmlException, IOException {
/* 274 */       return (Extensionconfig)XmlBeans.getContextTypeLoader().parse(param1InputStream, Extensionconfig.type, null);
/*     */     }
/*     */     public static Extensionconfig parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 277 */       return (Extensionconfig)XmlBeans.getContextTypeLoader().parse(param1InputStream, Extensionconfig.type, param1XmlOptions);
/*     */     }
/*     */     public static Extensionconfig parse(Reader param1Reader) throws XmlException, IOException {
/* 280 */       return (Extensionconfig)XmlBeans.getContextTypeLoader().parse(param1Reader, Extensionconfig.type, null);
/*     */     }
/*     */     public static Extensionconfig parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 283 */       return (Extensionconfig)XmlBeans.getContextTypeLoader().parse(param1Reader, Extensionconfig.type, param1XmlOptions);
/*     */     }
/*     */     public static Extensionconfig parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 286 */       return (Extensionconfig)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Extensionconfig.type, null);
/*     */     }
/*     */     public static Extensionconfig parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 289 */       return (Extensionconfig)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Extensionconfig.type, param1XmlOptions);
/*     */     }
/*     */     public static Extensionconfig parse(Node param1Node) throws XmlException {
/* 292 */       return (Extensionconfig)XmlBeans.getContextTypeLoader().parse(param1Node, Extensionconfig.type, null);
/*     */     }
/*     */     public static Extensionconfig parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 295 */       return (Extensionconfig)XmlBeans.getContextTypeLoader().parse(param1Node, Extensionconfig.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Extensionconfig parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 299 */       return (Extensionconfig)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Extensionconfig.type, null);
/*     */     }
/*     */     
/*     */     public static Extensionconfig parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 303 */       return (Extensionconfig)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Extensionconfig.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 307 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Extensionconfig.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 311 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Extensionconfig.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xmlconfig\Extensionconfig.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */