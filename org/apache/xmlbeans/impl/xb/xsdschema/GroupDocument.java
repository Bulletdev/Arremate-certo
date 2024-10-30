/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
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
/*     */ public interface GroupDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$GroupDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$GroupDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.GroupDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$GroupDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("group6eb6doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NamedGroup getGroup();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setGroup(NamedGroup paramNamedGroup);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NamedGroup addNewGroup();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static GroupDocument newInstance() {
/*  45 */       return (GroupDocument)XmlBeans.getContextTypeLoader().newInstance(GroupDocument.type, null);
/*     */     }
/*     */     public static GroupDocument newInstance(XmlOptions param1XmlOptions) {
/*  48 */       return (GroupDocument)XmlBeans.getContextTypeLoader().newInstance(GroupDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static GroupDocument parse(String param1String) throws XmlException {
/*  52 */       return (GroupDocument)XmlBeans.getContextTypeLoader().parse(param1String, GroupDocument.type, null);
/*     */     }
/*     */     public static GroupDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  55 */       return (GroupDocument)XmlBeans.getContextTypeLoader().parse(param1String, GroupDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static GroupDocument parse(File param1File) throws XmlException, IOException {
/*  59 */       return (GroupDocument)XmlBeans.getContextTypeLoader().parse(param1File, GroupDocument.type, null);
/*     */     }
/*     */     public static GroupDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  62 */       return (GroupDocument)XmlBeans.getContextTypeLoader().parse(param1File, GroupDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static GroupDocument parse(URL param1URL) throws XmlException, IOException {
/*  65 */       return (GroupDocument)XmlBeans.getContextTypeLoader().parse(param1URL, GroupDocument.type, null);
/*     */     }
/*     */     public static GroupDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  68 */       return (GroupDocument)XmlBeans.getContextTypeLoader().parse(param1URL, GroupDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static GroupDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/*  71 */       return (GroupDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, GroupDocument.type, null);
/*     */     }
/*     */     public static GroupDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  74 */       return (GroupDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, GroupDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static GroupDocument parse(Reader param1Reader) throws XmlException, IOException {
/*  77 */       return (GroupDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, GroupDocument.type, null);
/*     */     }
/*     */     public static GroupDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (GroupDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, GroupDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static GroupDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  83 */       return (GroupDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, GroupDocument.type, null);
/*     */     }
/*     */     public static GroupDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/*  86 */       return (GroupDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, GroupDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static GroupDocument parse(Node param1Node) throws XmlException {
/*  89 */       return (GroupDocument)XmlBeans.getContextTypeLoader().parse(param1Node, GroupDocument.type, null);
/*     */     }
/*     */     public static GroupDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  92 */       return (GroupDocument)XmlBeans.getContextTypeLoader().parse(param1Node, GroupDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static GroupDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  96 */       return (GroupDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, GroupDocument.type, null);
/*     */     }
/*     */     
/*     */     public static GroupDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 100 */       return (GroupDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, GroupDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 104 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, GroupDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 108 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, GroupDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\GroupDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */