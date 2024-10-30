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
/*     */ public interface XmlUnsignedInt
/*     */   extends XmlUnsignedLong
/*     */ {
/*  33 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_unsignedInt");
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
/*     */     public static XmlUnsignedInt newInstance() {
/*  59 */       return (XmlUnsignedInt)XmlBeans.getContextTypeLoader().newInstance(XmlUnsignedInt.type, null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedInt newInstance(XmlOptions param1XmlOptions) {
/*  63 */       return (XmlUnsignedInt)XmlBeans.getContextTypeLoader().newInstance(XmlUnsignedInt.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedInt newValue(Object param1Object) {
/*  67 */       return (XmlUnsignedInt)XmlUnsignedInt.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedInt parse(String param1String) throws XmlException {
/*  71 */       return (XmlUnsignedInt)XmlBeans.getContextTypeLoader().parse(param1String, XmlUnsignedInt.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedInt parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  75 */       return (XmlUnsignedInt)XmlBeans.getContextTypeLoader().parse(param1String, XmlUnsignedInt.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedInt parse(File param1File) throws XmlException, IOException {
/*  79 */       return (XmlUnsignedInt)XmlBeans.getContextTypeLoader().parse(param1File, XmlUnsignedInt.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedInt parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  83 */       return (XmlUnsignedInt)XmlBeans.getContextTypeLoader().parse(param1File, XmlUnsignedInt.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedInt parse(URL param1URL) throws XmlException, IOException {
/*  87 */       return (XmlUnsignedInt)XmlBeans.getContextTypeLoader().parse(param1URL, XmlUnsignedInt.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedInt parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  91 */       return (XmlUnsignedInt)XmlBeans.getContextTypeLoader().parse(param1URL, XmlUnsignedInt.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedInt parse(InputStream param1InputStream) throws XmlException, IOException {
/*  95 */       return (XmlUnsignedInt)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlUnsignedInt.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedInt parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  99 */       return (XmlUnsignedInt)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlUnsignedInt.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedInt parse(Reader param1Reader) throws XmlException, IOException {
/* 103 */       return (XmlUnsignedInt)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlUnsignedInt.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedInt parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 107 */       return (XmlUnsignedInt)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlUnsignedInt.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedInt parse(Node param1Node) throws XmlException {
/* 111 */       return (XmlUnsignedInt)XmlBeans.getContextTypeLoader().parse(param1Node, XmlUnsignedInt.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedInt parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 115 */       return (XmlUnsignedInt)XmlBeans.getContextTypeLoader().parse(param1Node, XmlUnsignedInt.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlUnsignedInt parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 121 */       return (XmlUnsignedInt)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlUnsignedInt.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlUnsignedInt parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 127 */       return (XmlUnsignedInt)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlUnsignedInt.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedInt parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 131 */       return (XmlUnsignedInt)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlUnsignedInt.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedInt parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 135 */       return (XmlUnsignedInt)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlUnsignedInt.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 141 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlUnsignedInt.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 147 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlUnsignedInt.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlUnsignedInt.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */