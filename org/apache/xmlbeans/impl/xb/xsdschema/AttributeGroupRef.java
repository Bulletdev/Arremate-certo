/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.namespace.b;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.XmlQName;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface AttributeGroupRef extends AttributeGroup {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeGroupRef == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeGroupRef = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupRef")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeGroupRef).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("attributegroupref8375type");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   b getRef();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlQName xgetRef();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetRef();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setRef(b paramb);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetRef(XmlQName paramXmlQName);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetRef();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static AttributeGroupRef newInstance() {
/*  59 */       return (AttributeGroupRef)XmlBeans.getContextTypeLoader().newInstance(AttributeGroupRef.type, null);
/*     */     }
/*     */     public static AttributeGroupRef newInstance(XmlOptions param1XmlOptions) {
/*  62 */       return (AttributeGroupRef)XmlBeans.getContextTypeLoader().newInstance(AttributeGroupRef.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AttributeGroupRef parse(String param1String) throws XmlException {
/*  66 */       return (AttributeGroupRef)XmlBeans.getContextTypeLoader().parse(param1String, AttributeGroupRef.type, null);
/*     */     }
/*     */     public static AttributeGroupRef parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  69 */       return (AttributeGroupRef)XmlBeans.getContextTypeLoader().parse(param1String, AttributeGroupRef.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AttributeGroupRef parse(File param1File) throws XmlException, IOException {
/*  73 */       return (AttributeGroupRef)XmlBeans.getContextTypeLoader().parse(param1File, AttributeGroupRef.type, null);
/*     */     }
/*     */     public static AttributeGroupRef parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  76 */       return (AttributeGroupRef)XmlBeans.getContextTypeLoader().parse(param1File, AttributeGroupRef.type, param1XmlOptions);
/*     */     }
/*     */     public static AttributeGroupRef parse(URL param1URL) throws XmlException, IOException {
/*  79 */       return (AttributeGroupRef)XmlBeans.getContextTypeLoader().parse(param1URL, AttributeGroupRef.type, null);
/*     */     }
/*     */     public static AttributeGroupRef parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  82 */       return (AttributeGroupRef)XmlBeans.getContextTypeLoader().parse(param1URL, AttributeGroupRef.type, param1XmlOptions);
/*     */     }
/*     */     public static AttributeGroupRef parse(InputStream param1InputStream) throws XmlException, IOException {
/*  85 */       return (AttributeGroupRef)XmlBeans.getContextTypeLoader().parse(param1InputStream, AttributeGroupRef.type, null);
/*     */     }
/*     */     public static AttributeGroupRef parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  88 */       return (AttributeGroupRef)XmlBeans.getContextTypeLoader().parse(param1InputStream, AttributeGroupRef.type, param1XmlOptions);
/*     */     }
/*     */     public static AttributeGroupRef parse(Reader param1Reader) throws XmlException, IOException {
/*  91 */       return (AttributeGroupRef)XmlBeans.getContextTypeLoader().parse(param1Reader, AttributeGroupRef.type, null);
/*     */     }
/*     */     public static AttributeGroupRef parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  94 */       return (AttributeGroupRef)XmlBeans.getContextTypeLoader().parse(param1Reader, AttributeGroupRef.type, param1XmlOptions);
/*     */     }
/*     */     public static AttributeGroupRef parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  97 */       return (AttributeGroupRef)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, AttributeGroupRef.type, null);
/*     */     }
/*     */     public static AttributeGroupRef parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 100 */       return (AttributeGroupRef)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, AttributeGroupRef.type, param1XmlOptions);
/*     */     }
/*     */     public static AttributeGroupRef parse(Node param1Node) throws XmlException {
/* 103 */       return (AttributeGroupRef)XmlBeans.getContextTypeLoader().parse(param1Node, AttributeGroupRef.type, null);
/*     */     }
/*     */     public static AttributeGroupRef parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 106 */       return (AttributeGroupRef)XmlBeans.getContextTypeLoader().parse(param1Node, AttributeGroupRef.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AttributeGroupRef parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 110 */       return (AttributeGroupRef)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, AttributeGroupRef.type, null);
/*     */     }
/*     */     
/*     */     public static AttributeGroupRef parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 114 */       return (AttributeGroupRef)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, AttributeGroupRef.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 118 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, AttributeGroupRef.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 122 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, AttributeGroupRef.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\AttributeGroupRef.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */