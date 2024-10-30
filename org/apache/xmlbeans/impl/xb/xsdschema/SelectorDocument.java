/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
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
/*     */ import org.apache.xmlbeans.XmlToken;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface SelectorDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$SelectorDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$SelectorDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$SelectorDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("selectorcb44doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Selector getSelector();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setSelector(Selector paramSelector);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Selector addNewSelector();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Selector
/*     */     extends Annotated
/*     */   {
/*  44 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((SelectorDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$SelectorDocument$Selector == null) ? (SelectorDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$SelectorDocument$Selector = SelectorDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument$Selector")) : SelectorDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$SelectorDocument$Selector).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("selector233felemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     String getXpath();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Xpath xgetXpath();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setXpath(String param1String);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetXpath(Xpath param1Xpath);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static interface Xpath
/*     */       extends XmlToken
/*     */     {
/*  74 */       public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((SelectorDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$SelectorDocument$Selector$Xpath == null) ? (SelectorDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$SelectorDocument$Selector$Xpath = SelectorDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument$Selector$Xpath")) : SelectorDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$SelectorDocument$Selector$Xpath).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("xpath6f9aattrtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public static final class Factory
/*     */       {
/*     */         public static SelectorDocument.Selector.Xpath newValue(Object param3Object) {
/*  85 */           return (SelectorDocument.Selector.Xpath)SelectorDocument.Selector.Xpath.type.newValue(param3Object);
/*     */         }
/*     */         public static SelectorDocument.Selector.Xpath newInstance() {
/*  88 */           return (SelectorDocument.Selector.Xpath)XmlBeans.getContextTypeLoader().newInstance(SelectorDocument.Selector.Xpath.type, null);
/*     */         }
/*     */         public static SelectorDocument.Selector.Xpath newInstance(XmlOptions param3XmlOptions) {
/*  91 */           return (SelectorDocument.Selector.Xpath)XmlBeans.getContextTypeLoader().newInstance(SelectorDocument.Selector.Xpath.type, param3XmlOptions);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static SelectorDocument.Selector newInstance() {
/* 105 */         return (SelectorDocument.Selector)XmlBeans.getContextTypeLoader().newInstance(SelectorDocument.Selector.type, null);
/*     */       }
/*     */       public static SelectorDocument.Selector newInstance(XmlOptions param2XmlOptions) {
/* 108 */         return (SelectorDocument.Selector)XmlBeans.getContextTypeLoader().newInstance(SelectorDocument.Selector.type, param2XmlOptions);
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
/*     */     public static SelectorDocument newInstance() {
/* 122 */       return (SelectorDocument)XmlBeans.getContextTypeLoader().newInstance(SelectorDocument.type, null);
/*     */     }
/*     */     public static SelectorDocument newInstance(XmlOptions param1XmlOptions) {
/* 125 */       return (SelectorDocument)XmlBeans.getContextTypeLoader().newInstance(SelectorDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static SelectorDocument parse(String param1String) throws XmlException {
/* 129 */       return (SelectorDocument)XmlBeans.getContextTypeLoader().parse(param1String, SelectorDocument.type, null);
/*     */     }
/*     */     public static SelectorDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 132 */       return (SelectorDocument)XmlBeans.getContextTypeLoader().parse(param1String, SelectorDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static SelectorDocument parse(File param1File) throws XmlException, IOException {
/* 136 */       return (SelectorDocument)XmlBeans.getContextTypeLoader().parse(param1File, SelectorDocument.type, null);
/*     */     }
/*     */     public static SelectorDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 139 */       return (SelectorDocument)XmlBeans.getContextTypeLoader().parse(param1File, SelectorDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SelectorDocument parse(URL param1URL) throws XmlException, IOException {
/* 142 */       return (SelectorDocument)XmlBeans.getContextTypeLoader().parse(param1URL, SelectorDocument.type, null);
/*     */     }
/*     */     public static SelectorDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 145 */       return (SelectorDocument)XmlBeans.getContextTypeLoader().parse(param1URL, SelectorDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SelectorDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/* 148 */       return (SelectorDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, SelectorDocument.type, null);
/*     */     }
/*     */     public static SelectorDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 151 */       return (SelectorDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, SelectorDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SelectorDocument parse(Reader param1Reader) throws XmlException, IOException {
/* 154 */       return (SelectorDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, SelectorDocument.type, null);
/*     */     }
/*     */     public static SelectorDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 157 */       return (SelectorDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, SelectorDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SelectorDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 160 */       return (SelectorDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, SelectorDocument.type, null);
/*     */     }
/*     */     public static SelectorDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 163 */       return (SelectorDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, SelectorDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SelectorDocument parse(Node param1Node) throws XmlException {
/* 166 */       return (SelectorDocument)XmlBeans.getContextTypeLoader().parse(param1Node, SelectorDocument.type, null);
/*     */     }
/*     */     public static SelectorDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 169 */       return (SelectorDocument)XmlBeans.getContextTypeLoader().parse(param1Node, SelectorDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static SelectorDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 173 */       return (SelectorDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, SelectorDocument.type, null);
/*     */     }
/*     */     
/*     */     public static SelectorDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 177 */       return (SelectorDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, SelectorDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 181 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, SelectorDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 185 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, SelectorDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\SelectorDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */