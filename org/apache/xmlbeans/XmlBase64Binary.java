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
/*     */ public interface XmlBase64Binary
/*     */   extends XmlAnySimpleType
/*     */ {
/*  30 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_base64Binary");
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
/*     */     public static XmlBase64Binary newInstance() {
/*  58 */       return (XmlBase64Binary)XmlBeans.getContextTypeLoader().newInstance(XmlBase64Binary.type, null);
/*     */     }
/*     */     
/*     */     public static XmlBase64Binary newInstance(XmlOptions param1XmlOptions) {
/*  62 */       return (XmlBase64Binary)XmlBeans.getContextTypeLoader().newInstance(XmlBase64Binary.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlBase64Binary newValue(Object param1Object) {
/*  66 */       return (XmlBase64Binary)XmlBase64Binary.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlBase64Binary parse(String param1String) throws XmlException {
/*  70 */       return (XmlBase64Binary)XmlBeans.getContextTypeLoader().parse(param1String, XmlBase64Binary.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlBase64Binary parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  74 */       return (XmlBase64Binary)XmlBeans.getContextTypeLoader().parse(param1String, XmlBase64Binary.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlBase64Binary parse(File param1File) throws XmlException, IOException {
/*  78 */       return (XmlBase64Binary)XmlBeans.getContextTypeLoader().parse(param1File, XmlBase64Binary.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlBase64Binary parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  82 */       return (XmlBase64Binary)XmlBeans.getContextTypeLoader().parse(param1File, XmlBase64Binary.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlBase64Binary parse(URL param1URL) throws XmlException, IOException {
/*  86 */       return (XmlBase64Binary)XmlBeans.getContextTypeLoader().parse(param1URL, XmlBase64Binary.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlBase64Binary parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  90 */       return (XmlBase64Binary)XmlBeans.getContextTypeLoader().parse(param1URL, XmlBase64Binary.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlBase64Binary parse(InputStream param1InputStream) throws XmlException, IOException {
/*  94 */       return (XmlBase64Binary)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlBase64Binary.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlBase64Binary parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  98 */       return (XmlBase64Binary)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlBase64Binary.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlBase64Binary parse(Reader param1Reader) throws XmlException, IOException {
/* 102 */       return (XmlBase64Binary)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlBase64Binary.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlBase64Binary parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 106 */       return (XmlBase64Binary)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlBase64Binary.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlBase64Binary parse(Node param1Node) throws XmlException {
/* 110 */       return (XmlBase64Binary)XmlBeans.getContextTypeLoader().parse(param1Node, XmlBase64Binary.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlBase64Binary parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 114 */       return (XmlBase64Binary)XmlBeans.getContextTypeLoader().parse(param1Node, XmlBase64Binary.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlBase64Binary parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 120 */       return (XmlBase64Binary)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlBase64Binary.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlBase64Binary parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 126 */       return (XmlBase64Binary)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlBase64Binary.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlBase64Binary parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 130 */       return (XmlBase64Binary)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlBase64Binary.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlBase64Binary parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 134 */       return (XmlBase64Binary)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlBase64Binary.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 140 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlBase64Binary.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 146 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlBase64Binary.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlBase64Binary.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */