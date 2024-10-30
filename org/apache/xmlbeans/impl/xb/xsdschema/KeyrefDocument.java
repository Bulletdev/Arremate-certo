/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.namespace.b;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.XmlQName;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface KeyrefDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$KeyrefDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$KeyrefDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$KeyrefDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("keyref45afdoctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Keyref getKeyref();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setKeyref(Keyref paramKeyref);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Keyref addNewKeyref();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Keyref
/*     */     extends Keybase
/*     */   {
/*  44 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((KeyrefDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$KeyrefDocument$Keyref == null) ? (KeyrefDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$KeyrefDocument$Keyref = KeyrefDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument$Keyref")) : KeyrefDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$KeyrefDocument$Keyref).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("keyref7a1felemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     b getRefer();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlQName xgetRefer();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setRefer(b param1b);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetRefer(XmlQName param1XmlQName);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static KeyrefDocument.Keyref newInstance() {
/*  75 */         return (KeyrefDocument.Keyref)XmlBeans.getContextTypeLoader().newInstance(KeyrefDocument.Keyref.type, null);
/*     */       }
/*     */       public static KeyrefDocument.Keyref newInstance(XmlOptions param2XmlOptions) {
/*  78 */         return (KeyrefDocument.Keyref)XmlBeans.getContextTypeLoader().newInstance(KeyrefDocument.Keyref.type, param2XmlOptions);
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
/*     */     public static KeyrefDocument newInstance() {
/*  92 */       return (KeyrefDocument)XmlBeans.getContextTypeLoader().newInstance(KeyrefDocument.type, null);
/*     */     }
/*     */     public static KeyrefDocument newInstance(XmlOptions param1XmlOptions) {
/*  95 */       return (KeyrefDocument)XmlBeans.getContextTypeLoader().newInstance(KeyrefDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static KeyrefDocument parse(String param1String) throws XmlException {
/*  99 */       return (KeyrefDocument)XmlBeans.getContextTypeLoader().parse(param1String, KeyrefDocument.type, null);
/*     */     }
/*     */     public static KeyrefDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 102 */       return (KeyrefDocument)XmlBeans.getContextTypeLoader().parse(param1String, KeyrefDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static KeyrefDocument parse(File param1File) throws XmlException, IOException {
/* 106 */       return (KeyrefDocument)XmlBeans.getContextTypeLoader().parse(param1File, KeyrefDocument.type, null);
/*     */     }
/*     */     public static KeyrefDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 109 */       return (KeyrefDocument)XmlBeans.getContextTypeLoader().parse(param1File, KeyrefDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static KeyrefDocument parse(URL param1URL) throws XmlException, IOException {
/* 112 */       return (KeyrefDocument)XmlBeans.getContextTypeLoader().parse(param1URL, KeyrefDocument.type, null);
/*     */     }
/*     */     public static KeyrefDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 115 */       return (KeyrefDocument)XmlBeans.getContextTypeLoader().parse(param1URL, KeyrefDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static KeyrefDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/* 118 */       return (KeyrefDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, KeyrefDocument.type, null);
/*     */     }
/*     */     public static KeyrefDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 121 */       return (KeyrefDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, KeyrefDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static KeyrefDocument parse(Reader param1Reader) throws XmlException, IOException {
/* 124 */       return (KeyrefDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, KeyrefDocument.type, null);
/*     */     }
/*     */     public static KeyrefDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 127 */       return (KeyrefDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, KeyrefDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static KeyrefDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 130 */       return (KeyrefDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, KeyrefDocument.type, null);
/*     */     }
/*     */     public static KeyrefDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 133 */       return (KeyrefDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, KeyrefDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static KeyrefDocument parse(Node param1Node) throws XmlException {
/* 136 */       return (KeyrefDocument)XmlBeans.getContextTypeLoader().parse(param1Node, KeyrefDocument.type, null);
/*     */     }
/*     */     public static KeyrefDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 139 */       return (KeyrefDocument)XmlBeans.getContextTypeLoader().parse(param1Node, KeyrefDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static KeyrefDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 143 */       return (KeyrefDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, KeyrefDocument.type, null);
/*     */     }
/*     */     
/*     */     public static KeyrefDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 147 */       return (KeyrefDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, KeyrefDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 151 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, KeyrefDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 155 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, KeyrefDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\KeyrefDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */