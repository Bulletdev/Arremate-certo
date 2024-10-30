/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface TotalDigitsDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$TotalDigitsDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$TotalDigitsDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$TotalDigitsDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("totaldigits4a8bdoctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TotalDigits getTotalDigits();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setTotalDigits(TotalDigits paramTotalDigits);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TotalDigits addNewTotalDigits();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface TotalDigits
/*     */     extends NumFacet
/*     */   {
/*  44 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((TotalDigitsDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$TotalDigitsDocument$TotalDigits == null) ? (TotalDigitsDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$TotalDigitsDocument$TotalDigits = TotalDigitsDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument$TotalDigits")) : TotalDigitsDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$TotalDigitsDocument$TotalDigits).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("totaldigits2615elemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static TotalDigitsDocument.TotalDigits newInstance() {
/*  55 */         return (TotalDigitsDocument.TotalDigits)XmlBeans.getContextTypeLoader().newInstance(TotalDigitsDocument.TotalDigits.type, null);
/*     */       }
/*     */       public static TotalDigitsDocument.TotalDigits newInstance(XmlOptions param2XmlOptions) {
/*  58 */         return (TotalDigitsDocument.TotalDigits)XmlBeans.getContextTypeLoader().newInstance(TotalDigitsDocument.TotalDigits.type, param2XmlOptions);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static TotalDigitsDocument newInstance() {
/*  72 */       return (TotalDigitsDocument)XmlBeans.getContextTypeLoader().newInstance(TotalDigitsDocument.type, null);
/*     */     }
/*     */     public static TotalDigitsDocument newInstance(XmlOptions param1XmlOptions) {
/*  75 */       return (TotalDigitsDocument)XmlBeans.getContextTypeLoader().newInstance(TotalDigitsDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TotalDigitsDocument parse(String param1String) throws XmlException {
/*  79 */       return (TotalDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1String, TotalDigitsDocument.type, null);
/*     */     }
/*     */     public static TotalDigitsDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  82 */       return (TotalDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1String, TotalDigitsDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TotalDigitsDocument parse(File param1File) throws XmlException, IOException {
/*  86 */       return (TotalDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1File, TotalDigitsDocument.type, null);
/*     */     }
/*     */     public static TotalDigitsDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  89 */       return (TotalDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1File, TotalDigitsDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static TotalDigitsDocument parse(URL param1URL) throws XmlException, IOException {
/*  92 */       return (TotalDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1URL, TotalDigitsDocument.type, null);
/*     */     }
/*     */     public static TotalDigitsDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  95 */       return (TotalDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1URL, TotalDigitsDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static TotalDigitsDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/*  98 */       return (TotalDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, TotalDigitsDocument.type, null);
/*     */     }
/*     */     public static TotalDigitsDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 101 */       return (TotalDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, TotalDigitsDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static TotalDigitsDocument parse(Reader param1Reader) throws XmlException, IOException {
/* 104 */       return (TotalDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, TotalDigitsDocument.type, null);
/*     */     }
/*     */     public static TotalDigitsDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 107 */       return (TotalDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, TotalDigitsDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static TotalDigitsDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 110 */       return (TotalDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, TotalDigitsDocument.type, null);
/*     */     }
/*     */     public static TotalDigitsDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 113 */       return (TotalDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, TotalDigitsDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static TotalDigitsDocument parse(Node param1Node) throws XmlException {
/* 116 */       return (TotalDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1Node, TotalDigitsDocument.type, null);
/*     */     }
/*     */     public static TotalDigitsDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 119 */       return (TotalDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1Node, TotalDigitsDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TotalDigitsDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 123 */       return (TotalDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, TotalDigitsDocument.type, null);
/*     */     }
/*     */     
/*     */     public static TotalDigitsDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 127 */       return (TotalDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, TotalDigitsDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 131 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, TotalDigitsDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 135 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, TotalDigitsDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\TotalDigitsDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */