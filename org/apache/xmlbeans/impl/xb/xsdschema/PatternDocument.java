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
/*     */ public interface PatternDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$PatternDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$PatternDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$PatternDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("pattern9585doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Pattern getPattern();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setPattern(Pattern paramPattern);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Pattern addNewPattern();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Pattern
/*     */     extends NoFixedFacet
/*     */   {
/*  44 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((PatternDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$PatternDocument$Pattern == null) ? (PatternDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$PatternDocument$Pattern = PatternDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument$Pattern")) : PatternDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$PatternDocument$Pattern).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("pattern6809elemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static PatternDocument.Pattern newInstance() {
/*  55 */         return (PatternDocument.Pattern)XmlBeans.getContextTypeLoader().newInstance(PatternDocument.Pattern.type, null);
/*     */       }
/*     */       public static PatternDocument.Pattern newInstance(XmlOptions param2XmlOptions) {
/*  58 */         return (PatternDocument.Pattern)XmlBeans.getContextTypeLoader().newInstance(PatternDocument.Pattern.type, param2XmlOptions);
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
/*     */     public static PatternDocument newInstance() {
/*  72 */       return (PatternDocument)XmlBeans.getContextTypeLoader().newInstance(PatternDocument.type, null);
/*     */     }
/*     */     public static PatternDocument newInstance(XmlOptions param1XmlOptions) {
/*  75 */       return (PatternDocument)XmlBeans.getContextTypeLoader().newInstance(PatternDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static PatternDocument parse(String param1String) throws XmlException {
/*  79 */       return (PatternDocument)XmlBeans.getContextTypeLoader().parse(param1String, PatternDocument.type, null);
/*     */     }
/*     */     public static PatternDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  82 */       return (PatternDocument)XmlBeans.getContextTypeLoader().parse(param1String, PatternDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static PatternDocument parse(File param1File) throws XmlException, IOException {
/*  86 */       return (PatternDocument)XmlBeans.getContextTypeLoader().parse(param1File, PatternDocument.type, null);
/*     */     }
/*     */     public static PatternDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  89 */       return (PatternDocument)XmlBeans.getContextTypeLoader().parse(param1File, PatternDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static PatternDocument parse(URL param1URL) throws XmlException, IOException {
/*  92 */       return (PatternDocument)XmlBeans.getContextTypeLoader().parse(param1URL, PatternDocument.type, null);
/*     */     }
/*     */     public static PatternDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  95 */       return (PatternDocument)XmlBeans.getContextTypeLoader().parse(param1URL, PatternDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static PatternDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/*  98 */       return (PatternDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, PatternDocument.type, null);
/*     */     }
/*     */     public static PatternDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 101 */       return (PatternDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, PatternDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static PatternDocument parse(Reader param1Reader) throws XmlException, IOException {
/* 104 */       return (PatternDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, PatternDocument.type, null);
/*     */     }
/*     */     public static PatternDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 107 */       return (PatternDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, PatternDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static PatternDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 110 */       return (PatternDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, PatternDocument.type, null);
/*     */     }
/*     */     public static PatternDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 113 */       return (PatternDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, PatternDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static PatternDocument parse(Node param1Node) throws XmlException {
/* 116 */       return (PatternDocument)XmlBeans.getContextTypeLoader().parse(param1Node, PatternDocument.type, null);
/*     */     }
/*     */     public static PatternDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 119 */       return (PatternDocument)XmlBeans.getContextTypeLoader().parse(param1Node, PatternDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static PatternDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 123 */       return (PatternDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, PatternDocument.type, null);
/*     */     }
/*     */     
/*     */     public static PatternDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 127 */       return (PatternDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, PatternDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 131 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, PatternDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 135 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, PatternDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\PatternDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */