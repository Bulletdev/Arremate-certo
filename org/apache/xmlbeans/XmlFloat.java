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
/*     */ public interface XmlFloat
/*     */   extends XmlAnySimpleType
/*     */ {
/*  30 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_float");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   float getFloatValue();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setFloatValue(float paramFloat);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   float floatValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void set(float paramFloat);
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlFloat newInstance() {
/*  56 */       return (XmlFloat)XmlBeans.getContextTypeLoader().newInstance(XmlFloat.type, null);
/*     */     }
/*     */     
/*     */     public static XmlFloat newInstance(XmlOptions param1XmlOptions) {
/*  60 */       return (XmlFloat)XmlBeans.getContextTypeLoader().newInstance(XmlFloat.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlFloat newValue(Object param1Object) {
/*  64 */       return (XmlFloat)XmlFloat.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlFloat parse(String param1String) throws XmlException {
/*  68 */       return (XmlFloat)XmlBeans.getContextTypeLoader().parse(param1String, XmlFloat.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlFloat parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  72 */       return (XmlFloat)XmlBeans.getContextTypeLoader().parse(param1String, XmlFloat.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlFloat parse(File param1File) throws XmlException, IOException {
/*  76 */       return (XmlFloat)XmlBeans.getContextTypeLoader().parse(param1File, XmlFloat.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlFloat parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (XmlFloat)XmlBeans.getContextTypeLoader().parse(param1File, XmlFloat.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlFloat parse(URL param1URL) throws XmlException, IOException {
/*  84 */       return (XmlFloat)XmlBeans.getContextTypeLoader().parse(param1URL, XmlFloat.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlFloat parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  88 */       return (XmlFloat)XmlBeans.getContextTypeLoader().parse(param1URL, XmlFloat.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlFloat parse(InputStream param1InputStream) throws XmlException, IOException {
/*  92 */       return (XmlFloat)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlFloat.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlFloat parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  96 */       return (XmlFloat)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlFloat.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlFloat parse(Reader param1Reader) throws XmlException, IOException {
/* 100 */       return (XmlFloat)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlFloat.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlFloat parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 104 */       return (XmlFloat)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlFloat.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlFloat parse(Node param1Node) throws XmlException {
/* 108 */       return (XmlFloat)XmlBeans.getContextTypeLoader().parse(param1Node, XmlFloat.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlFloat parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 112 */       return (XmlFloat)XmlBeans.getContextTypeLoader().parse(param1Node, XmlFloat.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlFloat parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 118 */       return (XmlFloat)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlFloat.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlFloat parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 124 */       return (XmlFloat)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlFloat.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlFloat parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 128 */       return (XmlFloat)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlFloat.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlFloat parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 132 */       return (XmlFloat)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlFloat.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 138 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlFloat.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 144 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlFloat.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlFloat.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */