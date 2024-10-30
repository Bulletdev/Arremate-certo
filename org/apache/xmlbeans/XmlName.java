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
/*     */ public interface XmlName
/*     */   extends XmlToken
/*     */ {
/*  36 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_Name");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlName newInstance() {
/*  46 */       return (XmlName)XmlBeans.getContextTypeLoader().newInstance(XmlName.type, null);
/*     */     }
/*     */     
/*     */     public static XmlName newInstance(XmlOptions param1XmlOptions) {
/*  50 */       return (XmlName)XmlBeans.getContextTypeLoader().newInstance(XmlName.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlName newValue(Object param1Object) {
/*  54 */       return (XmlName)XmlName.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlName parse(String param1String) throws XmlException {
/*  58 */       return (XmlName)XmlBeans.getContextTypeLoader().parse(param1String, XmlName.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlName parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  62 */       return (XmlName)XmlBeans.getContextTypeLoader().parse(param1String, XmlName.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlName parse(File param1File) throws XmlException, IOException {
/*  66 */       return (XmlName)XmlBeans.getContextTypeLoader().parse(param1File, XmlName.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlName parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  70 */       return (XmlName)XmlBeans.getContextTypeLoader().parse(param1File, XmlName.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlName parse(URL param1URL) throws XmlException, IOException {
/*  74 */       return (XmlName)XmlBeans.getContextTypeLoader().parse(param1URL, XmlName.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlName parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  78 */       return (XmlName)XmlBeans.getContextTypeLoader().parse(param1URL, XmlName.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlName parse(InputStream param1InputStream) throws XmlException, IOException {
/*  82 */       return (XmlName)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlName.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlName parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  86 */       return (XmlName)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlName.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlName parse(Reader param1Reader) throws XmlException, IOException {
/*  90 */       return (XmlName)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlName.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlName parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  94 */       return (XmlName)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlName.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlName parse(Node param1Node) throws XmlException {
/*  98 */       return (XmlName)XmlBeans.getContextTypeLoader().parse(param1Node, XmlName.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlName parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 102 */       return (XmlName)XmlBeans.getContextTypeLoader().parse(param1Node, XmlName.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlName parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 108 */       return (XmlName)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlName.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlName parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 114 */       return (XmlName)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlName.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlName parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 118 */       return (XmlName)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlName.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlName parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 122 */       return (XmlName)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlName.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 128 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlName.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 134 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlName.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlName.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */