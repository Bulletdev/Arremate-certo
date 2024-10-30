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
/*     */ public interface XmlUnsignedByte
/*     */   extends XmlUnsignedShort
/*     */ {
/*  33 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_unsignedByte");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   short getShortValue();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setShortValue(short paramShort);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   short shortValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void set(short paramShort);
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlUnsignedByte newInstance() {
/*  59 */       return (XmlUnsignedByte)XmlBeans.getContextTypeLoader().newInstance(XmlUnsignedByte.type, null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedByte newInstance(XmlOptions param1XmlOptions) {
/*  63 */       return (XmlUnsignedByte)XmlBeans.getContextTypeLoader().newInstance(XmlUnsignedByte.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedByte newValue(Object param1Object) {
/*  67 */       return (XmlUnsignedByte)XmlUnsignedByte.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedByte parse(String param1String) throws XmlException {
/*  71 */       return (XmlUnsignedByte)XmlBeans.getContextTypeLoader().parse(param1String, XmlUnsignedByte.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedByte parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  75 */       return (XmlUnsignedByte)XmlBeans.getContextTypeLoader().parse(param1String, XmlUnsignedByte.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedByte parse(File param1File) throws XmlException, IOException {
/*  79 */       return (XmlUnsignedByte)XmlBeans.getContextTypeLoader().parse(param1File, XmlUnsignedByte.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedByte parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  83 */       return (XmlUnsignedByte)XmlBeans.getContextTypeLoader().parse(param1File, XmlUnsignedByte.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedByte parse(URL param1URL) throws XmlException, IOException {
/*  87 */       return (XmlUnsignedByte)XmlBeans.getContextTypeLoader().parse(param1URL, XmlUnsignedByte.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedByte parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  91 */       return (XmlUnsignedByte)XmlBeans.getContextTypeLoader().parse(param1URL, XmlUnsignedByte.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedByte parse(InputStream param1InputStream) throws XmlException, IOException {
/*  95 */       return (XmlUnsignedByte)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlUnsignedByte.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedByte parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  99 */       return (XmlUnsignedByte)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlUnsignedByte.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedByte parse(Reader param1Reader) throws XmlException, IOException {
/* 103 */       return (XmlUnsignedByte)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlUnsignedByte.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedByte parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 107 */       return (XmlUnsignedByte)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlUnsignedByte.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedByte parse(Node param1Node) throws XmlException {
/* 111 */       return (XmlUnsignedByte)XmlBeans.getContextTypeLoader().parse(param1Node, XmlUnsignedByte.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedByte parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 115 */       return (XmlUnsignedByte)XmlBeans.getContextTypeLoader().parse(param1Node, XmlUnsignedByte.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlUnsignedByte parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 121 */       return (XmlUnsignedByte)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlUnsignedByte.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlUnsignedByte parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 127 */       return (XmlUnsignedByte)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlUnsignedByte.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedByte parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 131 */       return (XmlUnsignedByte)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlUnsignedByte.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedByte parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 135 */       return (XmlUnsignedByte)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlUnsignedByte.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 141 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlUnsignedByte.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 147 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlUnsignedByte.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlUnsignedByte.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */