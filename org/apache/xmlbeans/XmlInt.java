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
/*     */ public interface XmlInt
/*     */   extends XmlLong
/*     */ {
/*  31 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_int");
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
/*     */     public static XmlInt newInstance() {
/*  57 */       return (XmlInt)XmlBeans.getContextTypeLoader().newInstance(XmlInt.type, null);
/*     */     }
/*     */     
/*     */     public static XmlInt newInstance(XmlOptions param1XmlOptions) {
/*  61 */       return (XmlInt)XmlBeans.getContextTypeLoader().newInstance(XmlInt.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlInt newValue(Object param1Object) {
/*  65 */       return (XmlInt)XmlInt.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlInt parse(String param1String) throws XmlException {
/*  69 */       return (XmlInt)XmlBeans.getContextTypeLoader().parse(param1String, XmlInt.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlInt parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  73 */       return (XmlInt)XmlBeans.getContextTypeLoader().parse(param1String, XmlInt.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlInt parse(File param1File) throws XmlException, IOException {
/*  77 */       return (XmlInt)XmlBeans.getContextTypeLoader().parse(param1File, XmlInt.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlInt parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  81 */       return (XmlInt)XmlBeans.getContextTypeLoader().parse(param1File, XmlInt.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlInt parse(URL param1URL) throws XmlException, IOException {
/*  85 */       return (XmlInt)XmlBeans.getContextTypeLoader().parse(param1URL, XmlInt.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlInt parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  89 */       return (XmlInt)XmlBeans.getContextTypeLoader().parse(param1URL, XmlInt.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlInt parse(InputStream param1InputStream) throws XmlException, IOException {
/*  93 */       return (XmlInt)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlInt.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlInt parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  97 */       return (XmlInt)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlInt.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlInt parse(Reader param1Reader) throws XmlException, IOException {
/* 101 */       return (XmlInt)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlInt.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlInt parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 105 */       return (XmlInt)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlInt.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlInt parse(Node param1Node) throws XmlException {
/* 109 */       return (XmlInt)XmlBeans.getContextTypeLoader().parse(param1Node, XmlInt.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlInt parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 113 */       return (XmlInt)XmlBeans.getContextTypeLoader().parse(param1Node, XmlInt.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlInt parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 119 */       return (XmlInt)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlInt.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlInt parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 125 */       return (XmlInt)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlInt.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlInt parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 129 */       return (XmlInt)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlInt.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlInt parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 133 */       return (XmlInt)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlInt.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 139 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlInt.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 145 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlInt.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlInt.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */