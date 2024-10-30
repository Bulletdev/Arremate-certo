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
/*     */ public interface XmlByte
/*     */   extends XmlShort
/*     */ {
/*  30 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_byte");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   byte byteValue();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void set(byte paramByte);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   byte getByteValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void setByteValue(byte paramByte);
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlByte newInstance() {
/*  56 */       return (XmlByte)XmlBeans.getContextTypeLoader().newInstance(XmlByte.type, null);
/*     */     }
/*     */     
/*     */     public static XmlByte newInstance(XmlOptions param1XmlOptions) {
/*  60 */       return (XmlByte)XmlBeans.getContextTypeLoader().newInstance(XmlByte.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlByte newValue(Object param1Object) {
/*  64 */       return (XmlByte)XmlByte.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlByte parse(String param1String) throws XmlException {
/*  68 */       return (XmlByte)XmlBeans.getContextTypeLoader().parse(param1String, XmlByte.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlByte parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  72 */       return (XmlByte)XmlBeans.getContextTypeLoader().parse(param1String, XmlByte.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlByte parse(File param1File) throws XmlException, IOException {
/*  76 */       return (XmlByte)XmlBeans.getContextTypeLoader().parse(param1File, XmlByte.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlByte parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (XmlByte)XmlBeans.getContextTypeLoader().parse(param1File, XmlByte.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlByte parse(URL param1URL) throws XmlException, IOException {
/*  84 */       return (XmlByte)XmlBeans.getContextTypeLoader().parse(param1URL, XmlByte.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlByte parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  88 */       return (XmlByte)XmlBeans.getContextTypeLoader().parse(param1URL, XmlByte.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlByte parse(InputStream param1InputStream) throws XmlException, IOException {
/*  92 */       return (XmlByte)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlByte.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlByte parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  96 */       return (XmlByte)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlByte.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlByte parse(Reader param1Reader) throws XmlException, IOException {
/* 100 */       return (XmlByte)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlByte.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlByte parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 104 */       return (XmlByte)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlByte.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlByte parse(Node param1Node) throws XmlException {
/* 108 */       return (XmlByte)XmlBeans.getContextTypeLoader().parse(param1Node, XmlByte.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlByte parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 112 */       return (XmlByte)XmlBeans.getContextTypeLoader().parse(param1Node, XmlByte.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlByte parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 118 */       return (XmlByte)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlByte.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlByte parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 124 */       return (XmlByte)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlByte.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlByte parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 128 */       return (XmlByte)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlByte.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlByte parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 132 */       return (XmlByte)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlByte.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 138 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlByte.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 144 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlByte.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlByte.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */