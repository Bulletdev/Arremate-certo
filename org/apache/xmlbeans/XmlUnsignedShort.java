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
/*     */ public interface XmlUnsignedShort
/*     */   extends XmlUnsignedInt
/*     */ {
/*  33 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_unsignedShort");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getIntValue();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setIntValue(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int intValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void set(int paramInt);
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlUnsignedShort newInstance() {
/*  59 */       return (XmlUnsignedShort)XmlBeans.getContextTypeLoader().newInstance(XmlUnsignedShort.type, null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedShort newInstance(XmlOptions param1XmlOptions) {
/*  63 */       return (XmlUnsignedShort)XmlBeans.getContextTypeLoader().newInstance(XmlUnsignedShort.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedShort newValue(Object param1Object) {
/*  67 */       return (XmlUnsignedShort)XmlUnsignedShort.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedShort parse(String param1String) throws XmlException {
/*  71 */       return (XmlUnsignedShort)XmlBeans.getContextTypeLoader().parse(param1String, XmlUnsignedShort.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedShort parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  75 */       return (XmlUnsignedShort)XmlBeans.getContextTypeLoader().parse(param1String, XmlUnsignedShort.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedShort parse(File param1File) throws XmlException, IOException {
/*  79 */       return (XmlUnsignedShort)XmlBeans.getContextTypeLoader().parse(param1File, XmlUnsignedShort.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedShort parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  83 */       return (XmlUnsignedShort)XmlBeans.getContextTypeLoader().parse(param1File, XmlUnsignedShort.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedShort parse(URL param1URL) throws XmlException, IOException {
/*  87 */       return (XmlUnsignedShort)XmlBeans.getContextTypeLoader().parse(param1URL, XmlUnsignedShort.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedShort parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  91 */       return (XmlUnsignedShort)XmlBeans.getContextTypeLoader().parse(param1URL, XmlUnsignedShort.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedShort parse(InputStream param1InputStream) throws XmlException, IOException {
/*  95 */       return (XmlUnsignedShort)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlUnsignedShort.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedShort parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  99 */       return (XmlUnsignedShort)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlUnsignedShort.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedShort parse(Reader param1Reader) throws XmlException, IOException {
/* 103 */       return (XmlUnsignedShort)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlUnsignedShort.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedShort parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 107 */       return (XmlUnsignedShort)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlUnsignedShort.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedShort parse(Node param1Node) throws XmlException {
/* 111 */       return (XmlUnsignedShort)XmlBeans.getContextTypeLoader().parse(param1Node, XmlUnsignedShort.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedShort parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 115 */       return (XmlUnsignedShort)XmlBeans.getContextTypeLoader().parse(param1Node, XmlUnsignedShort.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlUnsignedShort parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 121 */       return (XmlUnsignedShort)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlUnsignedShort.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlUnsignedShort parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 127 */       return (XmlUnsignedShort)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlUnsignedShort.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedShort parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 131 */       return (XmlUnsignedShort)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlUnsignedShort.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlUnsignedShort parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 135 */       return (XmlUnsignedShort)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlUnsignedShort.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 141 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlUnsignedShort.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 147 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlUnsignedShort.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlUnsignedShort.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */