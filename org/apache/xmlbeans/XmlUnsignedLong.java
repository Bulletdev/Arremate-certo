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
/*     */ public interface XmlUnsignedLong
/*     */   extends XmlNonNegativeInteger
/*     */ {
/*  36 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_unsignedLong");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlUnsignedLong newInstance() {
/*  46 */       return (XmlUnsignedLong)XmlBeans.getContextTypeLoader().newInstance(XmlUnsignedLong.type, null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedLong newInstance(XmlOptions param1XmlOptions) {
/*  50 */       return (XmlUnsignedLong)XmlBeans.getContextTypeLoader().newInstance(XmlUnsignedLong.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedLong newValue(Object param1Object) {
/*  54 */       return (XmlUnsignedLong)XmlUnsignedLong.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedLong parse(String param1String) throws XmlException {
/*  58 */       return (XmlUnsignedLong)XmlBeans.getContextTypeLoader().parse(param1String, XmlUnsignedLong.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedLong parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  62 */       return (XmlUnsignedLong)XmlBeans.getContextTypeLoader().parse(param1String, XmlUnsignedLong.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedLong parse(File param1File) throws XmlException, IOException {
/*  66 */       return (XmlUnsignedLong)XmlBeans.getContextTypeLoader().parse(param1File, XmlUnsignedLong.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedLong parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  70 */       return (XmlUnsignedLong)XmlBeans.getContextTypeLoader().parse(param1File, XmlUnsignedLong.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedLong parse(URL param1URL) throws XmlException, IOException {
/*  74 */       return (XmlUnsignedLong)XmlBeans.getContextTypeLoader().parse(param1URL, XmlUnsignedLong.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedLong parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  78 */       return (XmlUnsignedLong)XmlBeans.getContextTypeLoader().parse(param1URL, XmlUnsignedLong.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedLong parse(InputStream param1InputStream) throws XmlException, IOException {
/*  82 */       return (XmlUnsignedLong)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlUnsignedLong.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedLong parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  86 */       return (XmlUnsignedLong)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlUnsignedLong.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedLong parse(Reader param1Reader) throws XmlException, IOException {
/*  90 */       return (XmlUnsignedLong)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlUnsignedLong.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedLong parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  94 */       return (XmlUnsignedLong)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlUnsignedLong.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedLong parse(Node param1Node) throws XmlException {
/*  98 */       return (XmlUnsignedLong)XmlBeans.getContextTypeLoader().parse(param1Node, XmlUnsignedLong.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedLong parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 102 */       return (XmlUnsignedLong)XmlBeans.getContextTypeLoader().parse(param1Node, XmlUnsignedLong.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlUnsignedLong parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 108 */       return (XmlUnsignedLong)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlUnsignedLong.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlUnsignedLong parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 114 */       return (XmlUnsignedLong)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlUnsignedLong.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedLong parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 118 */       return (XmlUnsignedLong)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlUnsignedLong.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedLong parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 122 */       return (XmlUnsignedLong)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlUnsignedLong.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 128 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlUnsignedLong.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 134 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlUnsignedLong.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlUnsignedLong.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */