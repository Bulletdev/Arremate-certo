/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import java.util.List;
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
/*     */ public interface XmlIDREFS
/*     */   extends XmlAnySimpleType
/*     */ {
/*  38 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_IDREFS");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   List getListValue();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   List xgetListValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void setListValue(List paramList);
/*     */ 
/*     */ 
/*     */   
/*     */   List listValue();
/*     */ 
/*     */ 
/*     */   
/*     */   List xlistValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void set(List paramList);
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlIDREFS newInstance() {
/*  71 */       return (XmlIDREFS)XmlBeans.getContextTypeLoader().newInstance(XmlIDREFS.type, null);
/*     */     }
/*     */     
/*     */     public static XmlIDREFS newInstance(XmlOptions param1XmlOptions) {
/*  75 */       return (XmlIDREFS)XmlBeans.getContextTypeLoader().newInstance(XmlIDREFS.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlIDREFS newValue(Object param1Object) {
/*  79 */       return (XmlIDREFS)XmlIDREFS.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlIDREFS parse(String param1String) throws XmlException {
/*  83 */       return (XmlIDREFS)XmlBeans.getContextTypeLoader().parse(param1String, XmlIDREFS.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlIDREFS parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  87 */       return (XmlIDREFS)XmlBeans.getContextTypeLoader().parse(param1String, XmlIDREFS.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlIDREFS parse(File param1File) throws XmlException, IOException {
/*  91 */       return (XmlIDREFS)XmlBeans.getContextTypeLoader().parse(param1File, XmlIDREFS.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlIDREFS parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  95 */       return (XmlIDREFS)XmlBeans.getContextTypeLoader().parse(param1File, XmlIDREFS.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlIDREFS parse(URL param1URL) throws XmlException, IOException {
/*  99 */       return (XmlIDREFS)XmlBeans.getContextTypeLoader().parse(param1URL, XmlIDREFS.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlIDREFS parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 103 */       return (XmlIDREFS)XmlBeans.getContextTypeLoader().parse(param1URL, XmlIDREFS.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlIDREFS parse(InputStream param1InputStream) throws XmlException, IOException {
/* 107 */       return (XmlIDREFS)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlIDREFS.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlIDREFS parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 111 */       return (XmlIDREFS)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlIDREFS.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlIDREFS parse(Reader param1Reader) throws XmlException, IOException {
/* 115 */       return (XmlIDREFS)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlIDREFS.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlIDREFS parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 119 */       return (XmlIDREFS)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlIDREFS.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlIDREFS parse(Node param1Node) throws XmlException {
/* 123 */       return (XmlIDREFS)XmlBeans.getContextTypeLoader().parse(param1Node, XmlIDREFS.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlIDREFS parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 127 */       return (XmlIDREFS)XmlBeans.getContextTypeLoader().parse(param1Node, XmlIDREFS.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlIDREFS parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 133 */       return (XmlIDREFS)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlIDREFS.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlIDREFS parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 139 */       return (XmlIDREFS)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlIDREFS.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlIDREFS parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 143 */       return (XmlIDREFS)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlIDREFS.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlIDREFS parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 147 */       return (XmlIDREFS)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlIDREFS.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 153 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlIDREFS.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 159 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlIDREFS.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlIDREFS.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */