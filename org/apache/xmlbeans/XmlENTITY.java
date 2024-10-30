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
/*     */ public interface XmlENTITY
/*     */   extends XmlNCName
/*     */ {
/*  30 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_ENTITY");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlENTITY newInstance() {
/*  40 */       return (XmlENTITY)XmlBeans.getContextTypeLoader().newInstance(XmlENTITY.type, null);
/*     */     }
/*     */     
/*     */     public static XmlENTITY newInstance(XmlOptions param1XmlOptions) {
/*  44 */       return (XmlENTITY)XmlBeans.getContextTypeLoader().newInstance(XmlENTITY.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlENTITY newValue(Object param1Object) {
/*  48 */       return (XmlENTITY)XmlENTITY.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlENTITY parse(String param1String) throws XmlException {
/*  52 */       return (XmlENTITY)XmlBeans.getContextTypeLoader().parse(param1String, XmlENTITY.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlENTITY parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  56 */       return (XmlENTITY)XmlBeans.getContextTypeLoader().parse(param1String, XmlENTITY.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlENTITY parse(File param1File) throws XmlException, IOException {
/*  60 */       return (XmlENTITY)XmlBeans.getContextTypeLoader().parse(param1File, XmlENTITY.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlENTITY parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  64 */       return (XmlENTITY)XmlBeans.getContextTypeLoader().parse(param1File, XmlENTITY.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlENTITY parse(URL param1URL) throws XmlException, IOException {
/*  68 */       return (XmlENTITY)XmlBeans.getContextTypeLoader().parse(param1URL, XmlENTITY.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlENTITY parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  72 */       return (XmlENTITY)XmlBeans.getContextTypeLoader().parse(param1URL, XmlENTITY.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlENTITY parse(InputStream param1InputStream) throws XmlException, IOException {
/*  76 */       return (XmlENTITY)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlENTITY.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlENTITY parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (XmlENTITY)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlENTITY.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlENTITY parse(Reader param1Reader) throws XmlException, IOException {
/*  84 */       return (XmlENTITY)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlENTITY.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlENTITY parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  88 */       return (XmlENTITY)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlENTITY.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlENTITY parse(Node param1Node) throws XmlException {
/*  92 */       return (XmlENTITY)XmlBeans.getContextTypeLoader().parse(param1Node, XmlENTITY.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlENTITY parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  96 */       return (XmlENTITY)XmlBeans.getContextTypeLoader().parse(param1Node, XmlENTITY.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlENTITY parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 102 */       return (XmlENTITY)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlENTITY.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlENTITY parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 108 */       return (XmlENTITY)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlENTITY.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlENTITY parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 112 */       return (XmlENTITY)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlENTITY.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlENTITY parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 116 */       return (XmlENTITY)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlENTITY.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 122 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlENTITY.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 128 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlENTITY.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlENTITY.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */