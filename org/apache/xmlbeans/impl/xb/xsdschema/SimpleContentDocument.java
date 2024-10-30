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
/*     */ public interface SimpleContentDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleContentDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleContentDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleContentDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("simplecontent8acedoctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   SimpleContent getSimpleContent();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setSimpleContent(SimpleContent paramSimpleContent);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   SimpleContent addNewSimpleContent();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface SimpleContent
/*     */     extends Annotated
/*     */   {
/*  44 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((SimpleContentDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleContentDocument$SimpleContent == null) ? (SimpleContentDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleContentDocument$SimpleContent = SimpleContentDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument$SimpleContent")) : SimpleContentDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleContentDocument$SimpleContent).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("simplecontent9a5belemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     SimpleRestrictionType getRestriction();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetRestriction();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setRestriction(SimpleRestrictionType param1SimpleRestrictionType);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     SimpleRestrictionType addNewRestriction();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetRestriction();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     SimpleExtensionType getExtension();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetExtension();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setExtension(SimpleExtensionType param1SimpleExtensionType);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     SimpleExtensionType addNewExtension();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetExtension();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static SimpleContentDocument.SimpleContent newInstance() {
/* 105 */         return (SimpleContentDocument.SimpleContent)XmlBeans.getContextTypeLoader().newInstance(SimpleContentDocument.SimpleContent.type, null);
/*     */       }
/*     */       public static SimpleContentDocument.SimpleContent newInstance(XmlOptions param2XmlOptions) {
/* 108 */         return (SimpleContentDocument.SimpleContent)XmlBeans.getContextTypeLoader().newInstance(SimpleContentDocument.SimpleContent.type, param2XmlOptions);
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
/*     */     public static SimpleContentDocument newInstance() {
/* 122 */       return (SimpleContentDocument)XmlBeans.getContextTypeLoader().newInstance(SimpleContentDocument.type, null);
/*     */     }
/*     */     public static SimpleContentDocument newInstance(XmlOptions param1XmlOptions) {
/* 125 */       return (SimpleContentDocument)XmlBeans.getContextTypeLoader().newInstance(SimpleContentDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static SimpleContentDocument parse(String param1String) throws XmlException {
/* 129 */       return (SimpleContentDocument)XmlBeans.getContextTypeLoader().parse(param1String, SimpleContentDocument.type, null);
/*     */     }
/*     */     public static SimpleContentDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 132 */       return (SimpleContentDocument)XmlBeans.getContextTypeLoader().parse(param1String, SimpleContentDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static SimpleContentDocument parse(File param1File) throws XmlException, IOException {
/* 136 */       return (SimpleContentDocument)XmlBeans.getContextTypeLoader().parse(param1File, SimpleContentDocument.type, null);
/*     */     }
/*     */     public static SimpleContentDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 139 */       return (SimpleContentDocument)XmlBeans.getContextTypeLoader().parse(param1File, SimpleContentDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SimpleContentDocument parse(URL param1URL) throws XmlException, IOException {
/* 142 */       return (SimpleContentDocument)XmlBeans.getContextTypeLoader().parse(param1URL, SimpleContentDocument.type, null);
/*     */     }
/*     */     public static SimpleContentDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 145 */       return (SimpleContentDocument)XmlBeans.getContextTypeLoader().parse(param1URL, SimpleContentDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SimpleContentDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/* 148 */       return (SimpleContentDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, SimpleContentDocument.type, null);
/*     */     }
/*     */     public static SimpleContentDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 151 */       return (SimpleContentDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, SimpleContentDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SimpleContentDocument parse(Reader param1Reader) throws XmlException, IOException {
/* 154 */       return (SimpleContentDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, SimpleContentDocument.type, null);
/*     */     }
/*     */     public static SimpleContentDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 157 */       return (SimpleContentDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, SimpleContentDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SimpleContentDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 160 */       return (SimpleContentDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, SimpleContentDocument.type, null);
/*     */     }
/*     */     public static SimpleContentDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 163 */       return (SimpleContentDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, SimpleContentDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SimpleContentDocument parse(Node param1Node) throws XmlException {
/* 166 */       return (SimpleContentDocument)XmlBeans.getContextTypeLoader().parse(param1Node, SimpleContentDocument.type, null);
/*     */     }
/*     */     public static SimpleContentDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 169 */       return (SimpleContentDocument)XmlBeans.getContextTypeLoader().parse(param1Node, SimpleContentDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static SimpleContentDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 173 */       return (SimpleContentDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, SimpleContentDocument.type, null);
/*     */     }
/*     */     
/*     */     public static SimpleContentDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 177 */       return (SimpleContentDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, SimpleContentDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 181 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, SimpleContentDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 185 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, SimpleContentDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\SimpleContentDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */