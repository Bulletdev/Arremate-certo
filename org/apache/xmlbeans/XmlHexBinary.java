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
/*     */ public interface XmlHexBinary
/*     */   extends XmlAnySimpleType
/*     */ {
/*  30 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_hexBinary");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   byte[] byteArrayValue();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void set(byte[] paramArrayOfbyte);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   byte[] getByteArrayValue();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setByteArrayValue(byte[] paramArrayOfbyte);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlHexBinary newInstance() {
/*  59 */       return (XmlHexBinary)XmlBeans.getContextTypeLoader().newInstance(XmlHexBinary.type, null);
/*     */     }
/*     */     
/*     */     public static XmlHexBinary newInstance(XmlOptions param1XmlOptions) {
/*  63 */       return (XmlHexBinary)XmlBeans.getContextTypeLoader().newInstance(XmlHexBinary.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlHexBinary newValue(Object param1Object) {
/*  67 */       return (XmlHexBinary)XmlHexBinary.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlHexBinary parse(String param1String) throws XmlException {
/*  71 */       return (XmlHexBinary)XmlBeans.getContextTypeLoader().parse(param1String, XmlHexBinary.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlHexBinary parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  75 */       return (XmlHexBinary)XmlBeans.getContextTypeLoader().parse(param1String, XmlHexBinary.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlHexBinary parse(File param1File) throws XmlException, IOException {
/*  79 */       return (XmlHexBinary)XmlBeans.getContextTypeLoader().parse(param1File, XmlHexBinary.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlHexBinary parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  83 */       return (XmlHexBinary)XmlBeans.getContextTypeLoader().parse(param1File, XmlHexBinary.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlHexBinary parse(URL param1URL) throws XmlException, IOException {
/*  87 */       return (XmlHexBinary)XmlBeans.getContextTypeLoader().parse(param1URL, XmlHexBinary.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlHexBinary parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  91 */       return (XmlHexBinary)XmlBeans.getContextTypeLoader().parse(param1URL, XmlHexBinary.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlHexBinary parse(InputStream param1InputStream) throws XmlException, IOException {
/*  95 */       return (XmlHexBinary)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlHexBinary.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlHexBinary parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  99 */       return (XmlHexBinary)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlHexBinary.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlHexBinary parse(Reader param1Reader) throws XmlException, IOException {
/* 103 */       return (XmlHexBinary)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlHexBinary.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlHexBinary parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 107 */       return (XmlHexBinary)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlHexBinary.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlHexBinary parse(Node param1Node) throws XmlException {
/* 111 */       return (XmlHexBinary)XmlBeans.getContextTypeLoader().parse(param1Node, XmlHexBinary.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlHexBinary parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 115 */       return (XmlHexBinary)XmlBeans.getContextTypeLoader().parse(param1Node, XmlHexBinary.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlHexBinary parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 121 */       return (XmlHexBinary)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlHexBinary.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlHexBinary parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 127 */       return (XmlHexBinary)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlHexBinary.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlHexBinary parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 131 */       return (XmlHexBinary)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlHexBinary.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlHexBinary parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 135 */       return (XmlHexBinary)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlHexBinary.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 141 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlHexBinary.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 147 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlHexBinary.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlHexBinary.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */