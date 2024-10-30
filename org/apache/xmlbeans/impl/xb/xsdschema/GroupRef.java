/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.namespace.b;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.XmlQName;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface GroupRef extends RealGroup {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$GroupRef == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$GroupRef = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.GroupRef")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$GroupRef).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("groupref303ftype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   b getRef();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlQName xgetRef();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetRef();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setRef(b paramb);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetRef(XmlQName paramXmlQName);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetRef();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static GroupRef newInstance() {
/*  59 */       return (GroupRef)XmlBeans.getContextTypeLoader().newInstance(GroupRef.type, null);
/*     */     }
/*     */     public static GroupRef newInstance(XmlOptions param1XmlOptions) {
/*  62 */       return (GroupRef)XmlBeans.getContextTypeLoader().newInstance(GroupRef.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static GroupRef parse(String param1String) throws XmlException {
/*  66 */       return (GroupRef)XmlBeans.getContextTypeLoader().parse(param1String, GroupRef.type, null);
/*     */     }
/*     */     public static GroupRef parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  69 */       return (GroupRef)XmlBeans.getContextTypeLoader().parse(param1String, GroupRef.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static GroupRef parse(File param1File) throws XmlException, IOException {
/*  73 */       return (GroupRef)XmlBeans.getContextTypeLoader().parse(param1File, GroupRef.type, null);
/*     */     }
/*     */     public static GroupRef parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  76 */       return (GroupRef)XmlBeans.getContextTypeLoader().parse(param1File, GroupRef.type, param1XmlOptions);
/*     */     }
/*     */     public static GroupRef parse(URL param1URL) throws XmlException, IOException {
/*  79 */       return (GroupRef)XmlBeans.getContextTypeLoader().parse(param1URL, GroupRef.type, null);
/*     */     }
/*     */     public static GroupRef parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  82 */       return (GroupRef)XmlBeans.getContextTypeLoader().parse(param1URL, GroupRef.type, param1XmlOptions);
/*     */     }
/*     */     public static GroupRef parse(InputStream param1InputStream) throws XmlException, IOException {
/*  85 */       return (GroupRef)XmlBeans.getContextTypeLoader().parse(param1InputStream, GroupRef.type, null);
/*     */     }
/*     */     public static GroupRef parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  88 */       return (GroupRef)XmlBeans.getContextTypeLoader().parse(param1InputStream, GroupRef.type, param1XmlOptions);
/*     */     }
/*     */     public static GroupRef parse(Reader param1Reader) throws XmlException, IOException {
/*  91 */       return (GroupRef)XmlBeans.getContextTypeLoader().parse(param1Reader, GroupRef.type, null);
/*     */     }
/*     */     public static GroupRef parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  94 */       return (GroupRef)XmlBeans.getContextTypeLoader().parse(param1Reader, GroupRef.type, param1XmlOptions);
/*     */     }
/*     */     public static GroupRef parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  97 */       return (GroupRef)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, GroupRef.type, null);
/*     */     }
/*     */     public static GroupRef parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 100 */       return (GroupRef)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, GroupRef.type, param1XmlOptions);
/*     */     }
/*     */     public static GroupRef parse(Node param1Node) throws XmlException {
/* 103 */       return (GroupRef)XmlBeans.getContextTypeLoader().parse(param1Node, GroupRef.type, null);
/*     */     }
/*     */     public static GroupRef parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 106 */       return (GroupRef)XmlBeans.getContextTypeLoader().parse(param1Node, GroupRef.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static GroupRef parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 110 */       return (GroupRef)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, GroupRef.type, null);
/*     */     }
/*     */     
/*     */     public static GroupRef parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 114 */       return (GroupRef)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, GroupRef.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 118 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, GroupRef.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 122 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, GroupRef.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\GroupRef.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */