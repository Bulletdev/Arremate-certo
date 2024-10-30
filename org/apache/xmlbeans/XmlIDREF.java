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
/*     */ public interface XmlIDREF
/*     */   extends XmlNCName
/*     */ {
/*  34 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_IDREF");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlIDREF newInstance() {
/*  44 */       return (XmlIDREF)XmlBeans.getContextTypeLoader().newInstance(XmlIDREF.type, null);
/*     */     }
/*     */     
/*     */     public static XmlIDREF newInstance(XmlOptions param1XmlOptions) {
/*  48 */       return (XmlIDREF)XmlBeans.getContextTypeLoader().newInstance(XmlIDREF.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlIDREF newValue(Object param1Object) {
/*  52 */       return (XmlIDREF)XmlIDREF.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlIDREF parse(String param1String) throws XmlException {
/*  56 */       return (XmlIDREF)XmlBeans.getContextTypeLoader().parse(param1String, XmlIDREF.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlIDREF parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  60 */       return (XmlIDREF)XmlBeans.getContextTypeLoader().parse(param1String, XmlIDREF.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlIDREF parse(File param1File) throws XmlException, IOException {
/*  64 */       return (XmlIDREF)XmlBeans.getContextTypeLoader().parse(param1File, XmlIDREF.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlIDREF parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  68 */       return (XmlIDREF)XmlBeans.getContextTypeLoader().parse(param1File, XmlIDREF.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlIDREF parse(URL param1URL) throws XmlException, IOException {
/*  72 */       return (XmlIDREF)XmlBeans.getContextTypeLoader().parse(param1URL, XmlIDREF.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlIDREF parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  76 */       return (XmlIDREF)XmlBeans.getContextTypeLoader().parse(param1URL, XmlIDREF.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlIDREF parse(InputStream param1InputStream) throws XmlException, IOException {
/*  80 */       return (XmlIDREF)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlIDREF.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlIDREF parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  84 */       return (XmlIDREF)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlIDREF.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlIDREF parse(Reader param1Reader) throws XmlException, IOException {
/*  88 */       return (XmlIDREF)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlIDREF.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlIDREF parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  92 */       return (XmlIDREF)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlIDREF.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlIDREF parse(Node param1Node) throws XmlException {
/*  96 */       return (XmlIDREF)XmlBeans.getContextTypeLoader().parse(param1Node, XmlIDREF.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlIDREF parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 100 */       return (XmlIDREF)XmlBeans.getContextTypeLoader().parse(param1Node, XmlIDREF.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlIDREF parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 106 */       return (XmlIDREF)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlIDREF.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlIDREF parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 112 */       return (XmlIDREF)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlIDREF.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlIDREF parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 116 */       return (XmlIDREF)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlIDREF.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlIDREF parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 120 */       return (XmlIDREF)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlIDREF.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 126 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlIDREF.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 132 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlIDREF.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlIDREF.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */