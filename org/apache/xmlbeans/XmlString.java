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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface XmlString
/*     */   extends XmlAnySimpleType
/*     */ {
/*  40 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_string");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlString newInstance() {
/*  50 */       return (XmlString)XmlBeans.getContextTypeLoader().newInstance(XmlString.type, null);
/*     */     }
/*     */     
/*     */     public static XmlString newInstance(XmlOptions param1XmlOptions) {
/*  54 */       return (XmlString)XmlBeans.getContextTypeLoader().newInstance(XmlString.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlString newValue(Object param1Object) {
/*  58 */       return (XmlString)XmlString.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlString parse(String param1String) throws XmlException {
/*  62 */       return (XmlString)XmlBeans.getContextTypeLoader().parse(param1String, XmlString.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlString parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  66 */       return (XmlString)XmlBeans.getContextTypeLoader().parse(param1String, XmlString.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlString parse(File param1File) throws XmlException, IOException {
/*  70 */       return (XmlString)XmlBeans.getContextTypeLoader().parse(param1File, XmlString.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlString parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  74 */       return (XmlString)XmlBeans.getContextTypeLoader().parse(param1File, XmlString.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlString parse(URL param1URL) throws XmlException, IOException {
/*  78 */       return (XmlString)XmlBeans.getContextTypeLoader().parse(param1URL, XmlString.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlString parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  82 */       return (XmlString)XmlBeans.getContextTypeLoader().parse(param1URL, XmlString.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlString parse(InputStream param1InputStream) throws XmlException, IOException {
/*  86 */       return (XmlString)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlString.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlString parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  90 */       return (XmlString)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlString.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlString parse(Reader param1Reader) throws XmlException, IOException {
/*  94 */       return (XmlString)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlString.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlString parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  98 */       return (XmlString)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlString.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlString parse(Node param1Node) throws XmlException {
/* 102 */       return (XmlString)XmlBeans.getContextTypeLoader().parse(param1Node, XmlString.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlString parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 106 */       return (XmlString)XmlBeans.getContextTypeLoader().parse(param1Node, XmlString.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlString parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 112 */       return (XmlString)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlString.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlString parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 118 */       return (XmlString)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlString.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlString parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 122 */       return (XmlString)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlString.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlString parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 126 */       return (XmlString)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlString.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 132 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlString.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 138 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlString.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlString.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */