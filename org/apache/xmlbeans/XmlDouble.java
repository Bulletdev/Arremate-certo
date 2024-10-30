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
/*     */ public interface XmlDouble
/*     */   extends XmlAnySimpleType
/*     */ {
/*  30 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_double");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   double getDoubleValue();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setDoubleValue(double paramDouble);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   double doubleValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void set(double paramDouble);
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlDouble newInstance() {
/*  56 */       return (XmlDouble)XmlBeans.getContextTypeLoader().newInstance(XmlDouble.type, null);
/*     */     }
/*     */     
/*     */     public static XmlDouble newInstance(XmlOptions param1XmlOptions) {
/*  60 */       return (XmlDouble)XmlBeans.getContextTypeLoader().newInstance(XmlDouble.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDouble newValue(Object param1Object) {
/*  64 */       return (XmlDouble)XmlDouble.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlDouble parse(String param1String) throws XmlException {
/*  68 */       return (XmlDouble)XmlBeans.getContextTypeLoader().parse(param1String, XmlDouble.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDouble parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  72 */       return (XmlDouble)XmlBeans.getContextTypeLoader().parse(param1String, XmlDouble.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDouble parse(File param1File) throws XmlException, IOException {
/*  76 */       return (XmlDouble)XmlBeans.getContextTypeLoader().parse(param1File, XmlDouble.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDouble parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (XmlDouble)XmlBeans.getContextTypeLoader().parse(param1File, XmlDouble.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDouble parse(URL param1URL) throws XmlException, IOException {
/*  84 */       return (XmlDouble)XmlBeans.getContextTypeLoader().parse(param1URL, XmlDouble.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDouble parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  88 */       return (XmlDouble)XmlBeans.getContextTypeLoader().parse(param1URL, XmlDouble.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDouble parse(InputStream param1InputStream) throws XmlException, IOException {
/*  92 */       return (XmlDouble)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlDouble.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDouble parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  96 */       return (XmlDouble)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlDouble.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDouble parse(Reader param1Reader) throws XmlException, IOException {
/* 100 */       return (XmlDouble)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlDouble.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDouble parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 104 */       return (XmlDouble)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlDouble.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDouble parse(Node param1Node) throws XmlException {
/* 108 */       return (XmlDouble)XmlBeans.getContextTypeLoader().parse(param1Node, XmlDouble.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDouble parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 112 */       return (XmlDouble)XmlBeans.getContextTypeLoader().parse(param1Node, XmlDouble.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlDouble parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 118 */       return (XmlDouble)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlDouble.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlDouble parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 124 */       return (XmlDouble)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlDouble.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDouble parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 128 */       return (XmlDouble)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlDouble.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDouble parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 132 */       return (XmlDouble)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlDouble.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 138 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlDouble.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 144 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlDouble.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlDouble.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */