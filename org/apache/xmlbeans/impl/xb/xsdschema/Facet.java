/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.XmlAnySimpleType;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlBoolean;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface Facet extends Annotated {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$Facet == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$Facet = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.Facet")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$Facet).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("facet446etype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlAnySimpleType getValue();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setValue(XmlAnySimpleType paramXmlAnySimpleType);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlAnySimpleType addNewValue();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean getFixed();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlBoolean xgetFixed();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetFixed();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setFixed(boolean paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetFixed(XmlBoolean paramXmlBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetFixed();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static Facet newInstance() {
/*  74 */       return (Facet)XmlBeans.getContextTypeLoader().newInstance(Facet.type, null);
/*     */     }
/*     */     public static Facet newInstance(XmlOptions param1XmlOptions) {
/*  77 */       return (Facet)XmlBeans.getContextTypeLoader().newInstance(Facet.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Facet parse(String param1String) throws XmlException {
/*  81 */       return (Facet)XmlBeans.getContextTypeLoader().parse(param1String, Facet.type, null);
/*     */     }
/*     */     public static Facet parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  84 */       return (Facet)XmlBeans.getContextTypeLoader().parse(param1String, Facet.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Facet parse(File param1File) throws XmlException, IOException {
/*  88 */       return (Facet)XmlBeans.getContextTypeLoader().parse(param1File, Facet.type, null);
/*     */     }
/*     */     public static Facet parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  91 */       return (Facet)XmlBeans.getContextTypeLoader().parse(param1File, Facet.type, param1XmlOptions);
/*     */     }
/*     */     public static Facet parse(URL param1URL) throws XmlException, IOException {
/*  94 */       return (Facet)XmlBeans.getContextTypeLoader().parse(param1URL, Facet.type, null);
/*     */     }
/*     */     public static Facet parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  97 */       return (Facet)XmlBeans.getContextTypeLoader().parse(param1URL, Facet.type, param1XmlOptions);
/*     */     }
/*     */     public static Facet parse(InputStream param1InputStream) throws XmlException, IOException {
/* 100 */       return (Facet)XmlBeans.getContextTypeLoader().parse(param1InputStream, Facet.type, null);
/*     */     }
/*     */     public static Facet parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 103 */       return (Facet)XmlBeans.getContextTypeLoader().parse(param1InputStream, Facet.type, param1XmlOptions);
/*     */     }
/*     */     public static Facet parse(Reader param1Reader) throws XmlException, IOException {
/* 106 */       return (Facet)XmlBeans.getContextTypeLoader().parse(param1Reader, Facet.type, null);
/*     */     }
/*     */     public static Facet parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 109 */       return (Facet)XmlBeans.getContextTypeLoader().parse(param1Reader, Facet.type, param1XmlOptions);
/*     */     }
/*     */     public static Facet parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 112 */       return (Facet)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Facet.type, null);
/*     */     }
/*     */     public static Facet parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 115 */       return (Facet)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Facet.type, param1XmlOptions);
/*     */     }
/*     */     public static Facet parse(Node param1Node) throws XmlException {
/* 118 */       return (Facet)XmlBeans.getContextTypeLoader().parse(param1Node, Facet.type, null);
/*     */     }
/*     */     public static Facet parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 121 */       return (Facet)XmlBeans.getContextTypeLoader().parse(param1Node, Facet.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Facet parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 125 */       return (Facet)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Facet.type, null);
/*     */     }
/*     */     
/*     */     public static Facet parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 129 */       return (Facet)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Facet.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 133 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Facet.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 137 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Facet.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\Facet.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */