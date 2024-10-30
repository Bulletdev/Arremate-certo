/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface XmlNCName
/*     */   extends XmlName
/*     */ {
/*  36 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_NCName");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlNCName newInstance() {
/*  46 */       return (XmlNCName)XmlBeans.getContextTypeLoader().newInstance(XmlNCName.type, null);
/*     */     }
/*     */     
/*     */     public static XmlNCName newInstance(XmlOptions param1XmlOptions) {
/*  50 */       return (XmlNCName)XmlBeans.getContextTypeLoader().newInstance(XmlNCName.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNCName newValue(Object param1Object) {
/*  54 */       return (XmlNCName)XmlNCName.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlNCName parse(String param1String) throws XmlException {
/*  58 */       return (XmlNCName)XmlBeans.getContextTypeLoader().parse(param1String, XmlNCName.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNCName parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  62 */       return (XmlNCName)XmlBeans.getContextTypeLoader().parse(param1String, XmlNCName.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNCName parse(File param1File) throws XmlException, IOException {
/*  66 */       return (XmlNCName)XmlBeans.getContextTypeLoader().parse(param1File, XmlNCName.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNCName parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  70 */       return (XmlNCName)XmlBeans.getContextTypeLoader().parse(param1File, XmlNCName.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNCName parse(URL param1URL) throws XmlException, IOException {
/*  74 */       return (XmlNCName)XmlBeans.getContextTypeLoader().parse(param1URL, XmlNCName.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNCName parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  78 */       return (XmlNCName)XmlBeans.getContextTypeLoader().parse(param1URL, XmlNCName.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNCName parse(InputStream param1InputStream) throws XmlException, IOException {
/*  82 */       return (XmlNCName)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlNCName.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNCName parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  86 */       return (XmlNCName)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlNCName.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNCName parse(Reader param1Reader) throws XmlException, IOException {
/*  90 */       return (XmlNCName)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlNCName.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNCName parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  94 */       return (XmlNCName)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlNCName.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNCName parse(Node param1Node) throws XmlException {
/*  98 */       return (XmlNCName)XmlBeans.getContextTypeLoader().parse(param1Node, XmlNCName.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNCName parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 102 */       return (XmlNCName)XmlBeans.getContextTypeLoader().parse(param1Node, XmlNCName.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlNCName parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 108 */       return (XmlNCName)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlNCName.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlNCName parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 114 */       return (XmlNCName)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlNCName.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNCName parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 118 */       return (XmlNCName)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlNCName.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNCName parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 122 */       return (XmlNCName)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlNCName.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 128 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlNCName.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 134 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlNCName.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlNCName.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */