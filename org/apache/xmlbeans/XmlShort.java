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
/*     */ public interface XmlShort
/*     */   extends XmlInt
/*     */ {
/*  31 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_short");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   short getShortValue();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setShortValue(short paramShort);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   short shortValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void set(short paramShort);
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlShort newInstance() {
/*  57 */       return (XmlShort)XmlBeans.getContextTypeLoader().newInstance(XmlShort.type, null);
/*     */     }
/*     */     
/*     */     public static XmlShort newInstance(XmlOptions param1XmlOptions) {
/*  61 */       return (XmlShort)XmlBeans.getContextTypeLoader().newInstance(XmlShort.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlShort newValue(Object param1Object) {
/*  65 */       return (XmlShort)XmlShort.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlShort parse(String param1String) throws XmlException {
/*  69 */       return (XmlShort)XmlBeans.getContextTypeLoader().parse(param1String, XmlShort.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlShort parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  73 */       return (XmlShort)XmlBeans.getContextTypeLoader().parse(param1String, XmlShort.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlShort parse(File param1File) throws XmlException, IOException {
/*  77 */       return (XmlShort)XmlBeans.getContextTypeLoader().parse(param1File, XmlShort.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlShort parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  81 */       return (XmlShort)XmlBeans.getContextTypeLoader().parse(param1File, XmlShort.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlShort parse(URL param1URL) throws XmlException, IOException {
/*  85 */       return (XmlShort)XmlBeans.getContextTypeLoader().parse(param1URL, XmlShort.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlShort parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  89 */       return (XmlShort)XmlBeans.getContextTypeLoader().parse(param1URL, XmlShort.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlShort parse(InputStream param1InputStream) throws XmlException, IOException {
/*  93 */       return (XmlShort)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlShort.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlShort parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  97 */       return (XmlShort)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlShort.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlShort parse(Reader param1Reader) throws XmlException, IOException {
/* 101 */       return (XmlShort)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlShort.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlShort parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 105 */       return (XmlShort)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlShort.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlShort parse(Node param1Node) throws XmlException {
/* 109 */       return (XmlShort)XmlBeans.getContextTypeLoader().parse(param1Node, XmlShort.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlShort parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 113 */       return (XmlShort)XmlBeans.getContextTypeLoader().parse(param1Node, XmlShort.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlShort parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 119 */       return (XmlShort)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlShort.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlShort parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 125 */       return (XmlShort)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlShort.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlShort parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 129 */       return (XmlShort)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlShort.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlShort parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 133 */       return (XmlShort)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlShort.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 139 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlShort.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 145 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlShort.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlShort.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */