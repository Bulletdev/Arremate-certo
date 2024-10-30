/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.math.BigInteger;
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
/*     */ public interface XmlInteger
/*     */   extends XmlDecimal
/*     */ {
/*  37 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_integer");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   BigInteger getBigIntegerValue();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setBigIntegerValue(BigInteger paramBigInteger);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   BigInteger bigIntegerValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void set(BigInteger paramBigInteger);
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlInteger newInstance() {
/*  63 */       return (XmlInteger)XmlBeans.getContextTypeLoader().newInstance(XmlInteger.type, null);
/*     */     }
/*     */     
/*     */     public static XmlInteger newInstance(XmlOptions param1XmlOptions) {
/*  67 */       return (XmlInteger)XmlBeans.getContextTypeLoader().newInstance(XmlInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlInteger newValue(Object param1Object) {
/*  71 */       return (XmlInteger)XmlInteger.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlInteger parse(String param1String) throws XmlException {
/*  75 */       return (XmlInteger)XmlBeans.getContextTypeLoader().parse(param1String, XmlInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlInteger parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  79 */       return (XmlInteger)XmlBeans.getContextTypeLoader().parse(param1String, XmlInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlInteger parse(File param1File) throws XmlException, IOException {
/*  83 */       return (XmlInteger)XmlBeans.getContextTypeLoader().parse(param1File, XmlInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlInteger parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  87 */       return (XmlInteger)XmlBeans.getContextTypeLoader().parse(param1File, XmlInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlInteger parse(URL param1URL) throws XmlException, IOException {
/*  91 */       return (XmlInteger)XmlBeans.getContextTypeLoader().parse(param1URL, XmlInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlInteger parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  95 */       return (XmlInteger)XmlBeans.getContextTypeLoader().parse(param1URL, XmlInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlInteger parse(InputStream param1InputStream) throws XmlException, IOException {
/*  99 */       return (XmlInteger)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlInteger parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 103 */       return (XmlInteger)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlInteger parse(Reader param1Reader) throws XmlException, IOException {
/* 107 */       return (XmlInteger)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlInteger parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 111 */       return (XmlInteger)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlInteger parse(Node param1Node) throws XmlException {
/* 115 */       return (XmlInteger)XmlBeans.getContextTypeLoader().parse(param1Node, XmlInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlInteger parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 119 */       return (XmlInteger)XmlBeans.getContextTypeLoader().parse(param1Node, XmlInteger.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlInteger parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 125 */       return (XmlInteger)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlInteger.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlInteger parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 131 */       return (XmlInteger)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlInteger parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 135 */       return (XmlInteger)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlInteger parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 139 */       return (XmlInteger)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlInteger.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 145 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlInteger.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 151 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlInteger.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlInteger.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */