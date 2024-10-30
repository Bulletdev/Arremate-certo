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
/*     */ public interface XmlLong
/*     */   extends XmlInteger
/*     */ {
/*  31 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_long");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   long getLongValue();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setLongValue(long paramLong);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   long longValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void set(long paramLong);
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlLong newInstance() {
/*  57 */       return (XmlLong)XmlBeans.getContextTypeLoader().newInstance(XmlLong.type, null);
/*     */     }
/*     */     
/*     */     public static XmlLong newInstance(XmlOptions param1XmlOptions) {
/*  61 */       return (XmlLong)XmlBeans.getContextTypeLoader().newInstance(XmlLong.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlLong newValue(Object param1Object) {
/*  65 */       return (XmlLong)XmlLong.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlLong parse(String param1String) throws XmlException {
/*  69 */       return (XmlLong)XmlBeans.getContextTypeLoader().parse(param1String, XmlLong.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlLong parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  73 */       return (XmlLong)XmlBeans.getContextTypeLoader().parse(param1String, XmlLong.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlLong parse(File param1File) throws XmlException, IOException {
/*  77 */       return (XmlLong)XmlBeans.getContextTypeLoader().parse(param1File, XmlLong.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlLong parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  81 */       return (XmlLong)XmlBeans.getContextTypeLoader().parse(param1File, XmlLong.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlLong parse(URL param1URL) throws XmlException, IOException {
/*  85 */       return (XmlLong)XmlBeans.getContextTypeLoader().parse(param1URL, XmlLong.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlLong parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  89 */       return (XmlLong)XmlBeans.getContextTypeLoader().parse(param1URL, XmlLong.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlLong parse(InputStream param1InputStream) throws XmlException, IOException {
/*  93 */       return (XmlLong)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlLong.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlLong parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  97 */       return (XmlLong)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlLong.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlLong parse(Reader param1Reader) throws XmlException, IOException {
/* 101 */       return (XmlLong)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlLong.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlLong parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 105 */       return (XmlLong)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlLong.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlLong parse(Node param1Node) throws XmlException {
/* 109 */       return (XmlLong)XmlBeans.getContextTypeLoader().parse(param1Node, XmlLong.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlLong parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 113 */       return (XmlLong)XmlBeans.getContextTypeLoader().parse(param1Node, XmlLong.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlLong parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 119 */       return (XmlLong)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlLong.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlLong parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 125 */       return (XmlLong)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlLong.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlLong parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 129 */       return (XmlLong)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlLong.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlLong parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 133 */       return (XmlLong)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlLong.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 139 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlLong.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 145 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlLong.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlLong.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */