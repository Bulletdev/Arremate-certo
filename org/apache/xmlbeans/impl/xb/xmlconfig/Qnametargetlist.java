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
/*     */ public interface Qnametargetlist
/*     */   extends XmlAnySimpleType {
/*     */   List getListValue();
/*     */   
/*     */   List xgetListValue();
/*     */   
/*     */   void setListValue(List paramList);
/*     */   
/*  27 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xmlconfig$Qnametargetlist == null) ? (null.class$org$apache$xmlbeans$impl$xb$xmlconfig$Qnametargetlist = null.class$("org.apache.xmlbeans.impl.xb.xmlconfig.Qnametargetlist")) : null.class$org$apache$xmlbeans$impl$xb$xmlconfig$Qnametargetlist).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("qnametargetlist16actype");
/*     */   
/*     */   List listValue();
/*     */   
/*     */   List xlistValue();
/*     */   
/*     */   void set(List paramList);
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static Qnametargetlist newValue(Object param1Object) {
/*  38 */       return (Qnametargetlist)Qnametargetlist.type.newValue(param1Object);
/*     */     }
/*     */     public static Qnametargetlist newInstance() {
/*  41 */       return (Qnametargetlist)XmlBeans.getContextTypeLoader().newInstance(Qnametargetlist.type, null);
/*     */     }
/*     */     public static Qnametargetlist newInstance(XmlOptions param1XmlOptions) {
/*  44 */       return (Qnametargetlist)XmlBeans.getContextTypeLoader().newInstance(Qnametargetlist.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Qnametargetlist parse(String param1String) throws XmlException {
/*  48 */       return (Qnametargetlist)XmlBeans.getContextTypeLoader().parse(param1String, Qnametargetlist.type, null);
/*     */     }
/*     */     public static Qnametargetlist parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  51 */       return (Qnametargetlist)XmlBeans.getContextTypeLoader().parse(param1String, Qnametargetlist.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Qnametargetlist parse(File param1File) throws XmlException, IOException {
/*  55 */       return (Qnametargetlist)XmlBeans.getContextTypeLoader().parse(param1File, Qnametargetlist.type, null);
/*     */     }
/*     */     public static Qnametargetlist parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  58 */       return (Qnametargetlist)XmlBeans.getContextTypeLoader().parse(param1File, Qnametargetlist.type, param1XmlOptions);
/*     */     }
/*     */     public static Qnametargetlist parse(URL param1URL) throws XmlException, IOException {
/*  61 */       return (Qnametargetlist)XmlBeans.getContextTypeLoader().parse(param1URL, Qnametargetlist.type, null);
/*     */     }
/*     */     public static Qnametargetlist parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  64 */       return (Qnametargetlist)XmlBeans.getContextTypeLoader().parse(param1URL, Qnametargetlist.type, param1XmlOptions);
/*     */     }
/*     */     public static Qnametargetlist parse(InputStream param1InputStream) throws XmlException, IOException {
/*  67 */       return (Qnametargetlist)XmlBeans.getContextTypeLoader().parse(param1InputStream, Qnametargetlist.type, null);
/*     */     }
/*     */     public static Qnametargetlist parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  70 */       return (Qnametargetlist)XmlBeans.getContextTypeLoader().parse(param1InputStream, Qnametargetlist.type, param1XmlOptions);
/*     */     }
/*     */     public static Qnametargetlist parse(Reader param1Reader) throws XmlException, IOException {
/*  73 */       return (Qnametargetlist)XmlBeans.getContextTypeLoader().parse(param1Reader, Qnametargetlist.type, null);
/*     */     }
/*     */     public static Qnametargetlist parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  76 */       return (Qnametargetlist)XmlBeans.getContextTypeLoader().parse(param1Reader, Qnametargetlist.type, param1XmlOptions);
/*     */     }
/*     */     public static Qnametargetlist parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  79 */       return (Qnametargetlist)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Qnametargetlist.type, null);
/*     */     }
/*     */     public static Qnametargetlist parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/*  82 */       return (Qnametargetlist)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Qnametargetlist.type, param1XmlOptions);
/*     */     }
/*     */     public static Qnametargetlist parse(Node param1Node) throws XmlException {
/*  85 */       return (Qnametargetlist)XmlBeans.getContextTypeLoader().parse(param1Node, Qnametargetlist.type, null);
/*     */     }
/*     */     public static Qnametargetlist parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  88 */       return (Qnametargetlist)XmlBeans.getContextTypeLoader().parse(param1Node, Qnametargetlist.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Qnametargetlist parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  92 */       return (Qnametargetlist)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Qnametargetlist.type, null);
/*     */     }
/*     */     
/*     */     public static Qnametargetlist parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/*  96 */       return (Qnametargetlist)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Qnametargetlist.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 100 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Qnametargetlist.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 104 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Qnametargetlist.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xmlconfig\Qnametargetlist.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */