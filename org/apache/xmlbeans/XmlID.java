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
/*     */ public interface XmlID
/*     */   extends XmlNCName
/*     */ {
/*  33 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_ID");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlID newInstance() {
/*  43 */       return (XmlID)XmlBeans.getContextTypeLoader().newInstance(XmlID.type, null);
/*     */     }
/*     */     
/*     */     public static XmlID newInstance(XmlOptions param1XmlOptions) {
/*  47 */       return (XmlID)XmlBeans.getContextTypeLoader().newInstance(XmlID.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlID newValue(Object param1Object) {
/*  51 */       return (XmlID)XmlID.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlID parse(String param1String) throws XmlException {
/*  55 */       return (XmlID)XmlBeans.getContextTypeLoader().parse(param1String, XmlID.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlID parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  59 */       return (XmlID)XmlBeans.getContextTypeLoader().parse(param1String, XmlID.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlID parse(File param1File) throws XmlException, IOException {
/*  63 */       return (XmlID)XmlBeans.getContextTypeLoader().parse(param1File, XmlID.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlID parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  67 */       return (XmlID)XmlBeans.getContextTypeLoader().parse(param1File, XmlID.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlID parse(URL param1URL) throws XmlException, IOException {
/*  71 */       return (XmlID)XmlBeans.getContextTypeLoader().parse(param1URL, XmlID.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlID parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  75 */       return (XmlID)XmlBeans.getContextTypeLoader().parse(param1URL, XmlID.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlID parse(InputStream param1InputStream) throws XmlException, IOException {
/*  79 */       return (XmlID)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlID.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlID parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  83 */       return (XmlID)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlID.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlID parse(Reader param1Reader) throws XmlException, IOException {
/*  87 */       return (XmlID)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlID.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlID parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  91 */       return (XmlID)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlID.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlID parse(Node param1Node) throws XmlException {
/*  95 */       return (XmlID)XmlBeans.getContextTypeLoader().parse(param1Node, XmlID.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlID parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  99 */       return (XmlID)XmlBeans.getContextTypeLoader().parse(param1Node, XmlID.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlID parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 105 */       return (XmlID)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlID.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlID parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 111 */       return (XmlID)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlID.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlID parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 115 */       return (XmlID)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlID.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlID parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 119 */       return (XmlID)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlID.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 125 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlID.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 131 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlID.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlID.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */