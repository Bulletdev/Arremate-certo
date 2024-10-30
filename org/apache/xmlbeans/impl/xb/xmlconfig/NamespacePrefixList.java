/*     */ package org.apache.xmlbeans.impl.xb.xmlconfig;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import java.util.List;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlAnySimpleType;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface NamespacePrefixList
/*     */   extends XmlAnySimpleType {
/*     */   List getListValue();
/*     */   
/*     */   List xgetListValue();
/*     */   
/*     */   void setListValue(List paramList);
/*     */   
/*  27 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xmlconfig$NamespacePrefixList == null) ? (null.class$org$apache$xmlbeans$impl$xb$xmlconfig$NamespacePrefixList = null.class$("org.apache.xmlbeans.impl.xb.xmlconfig.NamespacePrefixList")) : null.class$org$apache$xmlbeans$impl$xb$xmlconfig$NamespacePrefixList).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("namespaceprefixlistec0ctype");
/*     */   
/*     */   List listValue();
/*     */   
/*     */   List xlistValue();
/*     */   
/*     */   void set(List paramList);
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static NamespacePrefixList newValue(Object param1Object) {
/*  38 */       return (NamespacePrefixList)NamespacePrefixList.type.newValue(param1Object);
/*     */     }
/*     */     public static NamespacePrefixList newInstance() {
/*  41 */       return (NamespacePrefixList)XmlBeans.getContextTypeLoader().newInstance(NamespacePrefixList.type, null);
/*     */     }
/*     */     public static NamespacePrefixList newInstance(XmlOptions param1XmlOptions) {
/*  44 */       return (NamespacePrefixList)XmlBeans.getContextTypeLoader().newInstance(NamespacePrefixList.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static NamespacePrefixList parse(String param1String) throws XmlException {
/*  48 */       return (NamespacePrefixList)XmlBeans.getContextTypeLoader().parse(param1String, NamespacePrefixList.type, null);
/*     */     }
/*     */     public static NamespacePrefixList parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  51 */       return (NamespacePrefixList)XmlBeans.getContextTypeLoader().parse(param1String, NamespacePrefixList.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static NamespacePrefixList parse(File param1File) throws XmlException, IOException {
/*  55 */       return (NamespacePrefixList)XmlBeans.getContextTypeLoader().parse(param1File, NamespacePrefixList.type, null);
/*     */     }
/*     */     public static NamespacePrefixList parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  58 */       return (NamespacePrefixList)XmlBeans.getContextTypeLoader().parse(param1File, NamespacePrefixList.type, param1XmlOptions);
/*     */     }
/*     */     public static NamespacePrefixList parse(URL param1URL) throws XmlException, IOException {
/*  61 */       return (NamespacePrefixList)XmlBeans.getContextTypeLoader().parse(param1URL, NamespacePrefixList.type, null);
/*     */     }
/*     */     public static NamespacePrefixList parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  64 */       return (NamespacePrefixList)XmlBeans.getContextTypeLoader().parse(param1URL, NamespacePrefixList.type, param1XmlOptions);
/*     */     }
/*     */     public static NamespacePrefixList parse(InputStream param1InputStream) throws XmlException, IOException {
/*  67 */       return (NamespacePrefixList)XmlBeans.getContextTypeLoader().parse(param1InputStream, NamespacePrefixList.type, null);
/*     */     }
/*     */     public static NamespacePrefixList parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  70 */       return (NamespacePrefixList)XmlBeans.getContextTypeLoader().parse(param1InputStream, NamespacePrefixList.type, param1XmlOptions);
/*     */     }
/*     */     public static NamespacePrefixList parse(Reader param1Reader) throws XmlException, IOException {
/*  73 */       return (NamespacePrefixList)XmlBeans.getContextTypeLoader().parse(param1Reader, NamespacePrefixList.type, null);
/*     */     }
/*     */     public static NamespacePrefixList parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  76 */       return (NamespacePrefixList)XmlBeans.getContextTypeLoader().parse(param1Reader, NamespacePrefixList.type, param1XmlOptions);
/*     */     }
/*     */     public static NamespacePrefixList parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  79 */       return (NamespacePrefixList)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, NamespacePrefixList.type, null);
/*     */     }
/*     */     public static NamespacePrefixList parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/*  82 */       return (NamespacePrefixList)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, NamespacePrefixList.type, param1XmlOptions);
/*     */     }
/*     */     public static NamespacePrefixList parse(Node param1Node) throws XmlException {
/*  85 */       return (NamespacePrefixList)XmlBeans.getContextTypeLoader().parse(param1Node, NamespacePrefixList.type, null);
/*     */     }
/*     */     public static NamespacePrefixList parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  88 */       return (NamespacePrefixList)XmlBeans.getContextTypeLoader().parse(param1Node, NamespacePrefixList.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static NamespacePrefixList parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  92 */       return (NamespacePrefixList)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, NamespacePrefixList.type, null);
/*     */     }
/*     */     
/*     */     public static NamespacePrefixList parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/*  96 */       return (NamespacePrefixList)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, NamespacePrefixList.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 100 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, NamespacePrefixList.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 104 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, NamespacePrefixList.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xmlconfig\NamespacePrefixList.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */