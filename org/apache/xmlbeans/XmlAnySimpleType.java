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
/*     */ public interface XmlAnySimpleType
/*     */   extends XmlObject
/*     */ {
/*  30 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_anySimpleType");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String stringValue();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void set(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getStringValue();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setStringValue(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlAnySimpleType newInstance() {
/*  61 */       return (XmlAnySimpleType)XmlBeans.getContextTypeLoader().newInstance(XmlAnySimpleType.type, null);
/*     */     }
/*     */     
/*     */     public static XmlAnySimpleType newInstance(XmlOptions param1XmlOptions) {
/*  65 */       return (XmlAnySimpleType)XmlBeans.getContextTypeLoader().newInstance(XmlAnySimpleType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlAnySimpleType newValue(Object param1Object) {
/*  69 */       return XmlAnySimpleType.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlAnySimpleType parse(String param1String) throws XmlException {
/*  73 */       return (XmlAnySimpleType)XmlBeans.getContextTypeLoader().parse(param1String, XmlAnySimpleType.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlAnySimpleType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  77 */       return (XmlAnySimpleType)XmlBeans.getContextTypeLoader().parse(param1String, XmlAnySimpleType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlAnySimpleType parse(File param1File) throws XmlException, IOException {
/*  81 */       return (XmlAnySimpleType)XmlBeans.getContextTypeLoader().parse(param1File, XmlAnySimpleType.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlAnySimpleType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  85 */       return (XmlAnySimpleType)XmlBeans.getContextTypeLoader().parse(param1File, XmlAnySimpleType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlAnySimpleType parse(URL param1URL) throws XmlException, IOException {
/*  89 */       return (XmlAnySimpleType)XmlBeans.getContextTypeLoader().parse(param1URL, XmlAnySimpleType.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlAnySimpleType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  93 */       return (XmlAnySimpleType)XmlBeans.getContextTypeLoader().parse(param1URL, XmlAnySimpleType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlAnySimpleType parse(InputStream param1InputStream) throws XmlException, IOException {
/*  97 */       return (XmlAnySimpleType)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlAnySimpleType.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlAnySimpleType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 101 */       return (XmlAnySimpleType)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlAnySimpleType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlAnySimpleType parse(Reader param1Reader) throws XmlException, IOException {
/* 105 */       return (XmlAnySimpleType)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlAnySimpleType.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlAnySimpleType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 109 */       return (XmlAnySimpleType)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlAnySimpleType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlAnySimpleType parse(Node param1Node) throws XmlException {
/* 113 */       return (XmlAnySimpleType)XmlBeans.getContextTypeLoader().parse(param1Node, XmlAnySimpleType.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlAnySimpleType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 117 */       return (XmlAnySimpleType)XmlBeans.getContextTypeLoader().parse(param1Node, XmlAnySimpleType.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlAnySimpleType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 123 */       return (XmlAnySimpleType)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlAnySimpleType.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlAnySimpleType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 129 */       return (XmlAnySimpleType)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlAnySimpleType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlAnySimpleType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 133 */       return (XmlAnySimpleType)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlAnySimpleType.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlAnySimpleType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 137 */       return (XmlAnySimpleType)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlAnySimpleType.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 143 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlAnySimpleType.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 149 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlAnySimpleType.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlAnySimpleType.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */