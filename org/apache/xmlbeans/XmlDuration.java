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
/*     */ public interface XmlDuration
/*     */   extends XmlAnySimpleType
/*     */ {
/*  32 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_duration");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   GDuration getGDurationValue();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setGDurationValue(GDuration paramGDuration);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   GDuration gDurationValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void set(GDurationSpecification paramGDurationSpecification);
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlDuration newInstance() {
/*  58 */       return (XmlDuration)XmlBeans.getContextTypeLoader().newInstance(XmlDuration.type, null);
/*     */     }
/*     */     
/*     */     public static XmlDuration newInstance(XmlOptions param1XmlOptions) {
/*  62 */       return (XmlDuration)XmlBeans.getContextTypeLoader().newInstance(XmlDuration.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDuration newValue(Object param1Object) {
/*  66 */       return (XmlDuration)XmlDuration.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlDuration parse(String param1String) throws XmlException {
/*  70 */       return (XmlDuration)XmlBeans.getContextTypeLoader().parse(param1String, XmlDuration.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDuration parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  74 */       return (XmlDuration)XmlBeans.getContextTypeLoader().parse(param1String, XmlDuration.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDuration parse(File param1File) throws XmlException, IOException {
/*  78 */       return (XmlDuration)XmlBeans.getContextTypeLoader().parse(param1File, XmlDuration.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDuration parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  82 */       return (XmlDuration)XmlBeans.getContextTypeLoader().parse(param1File, XmlDuration.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDuration parse(URL param1URL) throws XmlException, IOException {
/*  86 */       return (XmlDuration)XmlBeans.getContextTypeLoader().parse(param1URL, XmlDuration.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDuration parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  90 */       return (XmlDuration)XmlBeans.getContextTypeLoader().parse(param1URL, XmlDuration.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDuration parse(InputStream param1InputStream) throws XmlException, IOException {
/*  94 */       return (XmlDuration)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlDuration.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDuration parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  98 */       return (XmlDuration)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlDuration.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDuration parse(Reader param1Reader) throws XmlException, IOException {
/* 102 */       return (XmlDuration)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlDuration.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDuration parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 106 */       return (XmlDuration)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlDuration.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDuration parse(Node param1Node) throws XmlException {
/* 110 */       return (XmlDuration)XmlBeans.getContextTypeLoader().parse(param1Node, XmlDuration.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDuration parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 114 */       return (XmlDuration)XmlBeans.getContextTypeLoader().parse(param1Node, XmlDuration.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlDuration parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 120 */       return (XmlDuration)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlDuration.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlDuration parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 126 */       return (XmlDuration)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlDuration.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDuration parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 130 */       return (XmlDuration)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlDuration.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDuration parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 134 */       return (XmlDuration)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlDuration.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 140 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlDuration.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 146 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlDuration.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlDuration.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */