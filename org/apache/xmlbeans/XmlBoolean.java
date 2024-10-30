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
/*     */ public interface XmlBoolean
/*     */   extends XmlAnySimpleType
/*     */ {
/*  30 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_boolean");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean booleanValue();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void set(boolean paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean getBooleanValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void setBooleanValue(boolean paramBoolean);
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlBoolean newInstance() {
/*  56 */       return (XmlBoolean)XmlBeans.getContextTypeLoader().newInstance(XmlBoolean.type, null);
/*     */     }
/*     */     
/*     */     public static XmlBoolean newInstance(XmlOptions param1XmlOptions) {
/*  60 */       return (XmlBoolean)XmlBeans.getContextTypeLoader().newInstance(XmlBoolean.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlBoolean newValue(Object param1Object) {
/*  64 */       return (XmlBoolean)XmlBoolean.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlBoolean parse(String param1String) throws XmlException {
/*  68 */       return (XmlBoolean)XmlBeans.getContextTypeLoader().parse(param1String, XmlBoolean.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlBoolean parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  72 */       return (XmlBoolean)XmlBeans.getContextTypeLoader().parse(param1String, XmlBoolean.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlBoolean parse(File param1File) throws XmlException, IOException {
/*  76 */       return (XmlBoolean)XmlBeans.getContextTypeLoader().parse(param1File, XmlBoolean.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlBoolean parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (XmlBoolean)XmlBeans.getContextTypeLoader().parse(param1File, XmlBoolean.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlBoolean parse(URL param1URL) throws XmlException, IOException {
/*  84 */       return (XmlBoolean)XmlBeans.getContextTypeLoader().parse(param1URL, XmlBoolean.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlBoolean parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  88 */       return (XmlBoolean)XmlBeans.getContextTypeLoader().parse(param1URL, XmlBoolean.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlBoolean parse(InputStream param1InputStream) throws XmlException, IOException {
/*  92 */       return (XmlBoolean)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlBoolean.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlBoolean parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  96 */       return (XmlBoolean)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlBoolean.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlBoolean parse(Reader param1Reader) throws XmlException, IOException {
/* 100 */       return (XmlBoolean)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlBoolean.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlBoolean parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 104 */       return (XmlBoolean)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlBoolean.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlBoolean parse(Node param1Node) throws XmlException {
/* 108 */       return (XmlBoolean)XmlBeans.getContextTypeLoader().parse(param1Node, XmlBoolean.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlBoolean parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 112 */       return (XmlBoolean)XmlBeans.getContextTypeLoader().parse(param1Node, XmlBoolean.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlBoolean parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 118 */       return (XmlBoolean)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlBoolean.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlBoolean parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 124 */       return (XmlBoolean)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlBoolean.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlBoolean parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 128 */       return (XmlBoolean)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlBoolean.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlBoolean parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 132 */       return (XmlBoolean)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlBoolean.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 138 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlBoolean.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 144 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlBoolean.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlBoolean.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */