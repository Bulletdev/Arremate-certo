/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.math.BigDecimal;
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
/*     */ public interface XmlDecimal
/*     */   extends XmlAnySimpleType
/*     */ {
/*  32 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_decimal");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   BigDecimal getBigDecimalValue();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setBigDecimalValue(BigDecimal paramBigDecimal);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   BigDecimal bigDecimalValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void set(BigDecimal paramBigDecimal);
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlDecimal newInstance() {
/*  58 */       return (XmlDecimal)XmlBeans.getContextTypeLoader().newInstance(XmlDecimal.type, null);
/*     */     }
/*     */     
/*     */     public static XmlDecimal newInstance(XmlOptions param1XmlOptions) {
/*  62 */       return (XmlDecimal)XmlBeans.getContextTypeLoader().newInstance(XmlDecimal.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDecimal newValue(Object param1Object) {
/*  66 */       return (XmlDecimal)XmlDecimal.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlDecimal parse(String param1String) throws XmlException {
/*  70 */       return (XmlDecimal)XmlBeans.getContextTypeLoader().parse(param1String, XmlDecimal.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDecimal parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  74 */       return (XmlDecimal)XmlBeans.getContextTypeLoader().parse(param1String, XmlDecimal.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDecimal parse(File param1File) throws XmlException, IOException {
/*  78 */       return (XmlDecimal)XmlBeans.getContextTypeLoader().parse(param1File, XmlDecimal.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDecimal parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  82 */       return (XmlDecimal)XmlBeans.getContextTypeLoader().parse(param1File, XmlDecimal.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDecimal parse(URL param1URL) throws XmlException, IOException {
/*  86 */       return (XmlDecimal)XmlBeans.getContextTypeLoader().parse(param1URL, XmlDecimal.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDecimal parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  90 */       return (XmlDecimal)XmlBeans.getContextTypeLoader().parse(param1URL, XmlDecimal.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDecimal parse(InputStream param1InputStream) throws XmlException, IOException {
/*  94 */       return (XmlDecimal)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlDecimal.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDecimal parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  98 */       return (XmlDecimal)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlDecimal.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDecimal parse(Reader param1Reader) throws XmlException, IOException {
/* 102 */       return (XmlDecimal)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlDecimal.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDecimal parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 106 */       return (XmlDecimal)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlDecimal.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDecimal parse(Node param1Node) throws XmlException {
/* 110 */       return (XmlDecimal)XmlBeans.getContextTypeLoader().parse(param1Node, XmlDecimal.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDecimal parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 114 */       return (XmlDecimal)XmlBeans.getContextTypeLoader().parse(param1Node, XmlDecimal.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlDecimal parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 120 */       return (XmlDecimal)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlDecimal.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlDecimal parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 126 */       return (XmlDecimal)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlDecimal.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDecimal parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 130 */       return (XmlDecimal)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlDecimal.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDecimal parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 134 */       return (XmlDecimal)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlDecimal.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 140 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlDecimal.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 146 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlDecimal.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlDecimal.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */