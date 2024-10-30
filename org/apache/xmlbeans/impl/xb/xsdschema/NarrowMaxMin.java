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
/*     */ import org.apache.xmlbeans.XmlNonNegativeInteger;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface NarrowMaxMin extends LocalElement {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$NarrowMaxMin == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$NarrowMaxMin = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.NarrowMaxMin")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$NarrowMaxMin).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("narrowmaxmin926atype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface MinOccurs
/*     */     extends XmlNonNegativeInteger
/*     */   {
/*  28 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((NarrowMaxMin.null.class$org$apache$xmlbeans$impl$xb$xsdschema$NarrowMaxMin$MinOccurs == null) ? (NarrowMaxMin.null.class$org$apache$xmlbeans$impl$xb$xsdschema$NarrowMaxMin$MinOccurs = NarrowMaxMin.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.NarrowMaxMin$MinOccurs")) : NarrowMaxMin.null.class$org$apache$xmlbeans$impl$xb$xsdschema$NarrowMaxMin$MinOccurs).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("minoccurs1acbattrtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static NarrowMaxMin.MinOccurs newValue(Object param2Object) {
/*  39 */         return (NarrowMaxMin.MinOccurs)NarrowMaxMin.MinOccurs.type.newValue(param2Object);
/*     */       }
/*     */       public static NarrowMaxMin.MinOccurs newInstance() {
/*  42 */         return (NarrowMaxMin.MinOccurs)XmlBeans.getContextTypeLoader().newInstance(NarrowMaxMin.MinOccurs.type, null);
/*     */       }
/*     */       public static NarrowMaxMin.MinOccurs newInstance(XmlOptions param2XmlOptions) {
/*  45 */         return (NarrowMaxMin.MinOccurs)XmlBeans.getContextTypeLoader().newInstance(NarrowMaxMin.MinOccurs.type, param2XmlOptions);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface MaxOccurs
/*     */     extends AllNNI
/*     */   {
/*     */     Object getObjectValue();
/*     */ 
/*     */ 
/*     */     
/*     */     void setObjectValue(Object param1Object);
/*     */ 
/*     */ 
/*     */     
/*     */     Object objectValue();
/*     */ 
/*     */ 
/*     */     
/*  67 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((NarrowMaxMin.null.class$org$apache$xmlbeans$impl$xb$xsdschema$NarrowMaxMin$MaxOccurs == null) ? (NarrowMaxMin.null.class$org$apache$xmlbeans$impl$xb$xsdschema$NarrowMaxMin$MaxOccurs = NarrowMaxMin.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.NarrowMaxMin$MaxOccurs")) : NarrowMaxMin.null.class$org$apache$xmlbeans$impl$xb$xsdschema$NarrowMaxMin$MaxOccurs).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("maxoccursd85dattrtype");
/*     */ 
/*     */     
/*     */     void objectSet(Object param1Object);
/*     */ 
/*     */     
/*     */     SchemaType instanceType();
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static NarrowMaxMin.MaxOccurs newValue(Object param2Object) {
/*  78 */         return (NarrowMaxMin.MaxOccurs)NarrowMaxMin.MaxOccurs.type.newValue(param2Object);
/*     */       }
/*     */       public static NarrowMaxMin.MaxOccurs newInstance() {
/*  81 */         return (NarrowMaxMin.MaxOccurs)XmlBeans.getContextTypeLoader().newInstance(NarrowMaxMin.MaxOccurs.type, null);
/*     */       }
/*     */       public static NarrowMaxMin.MaxOccurs newInstance(XmlOptions param2XmlOptions) {
/*  84 */         return (NarrowMaxMin.MaxOccurs)XmlBeans.getContextTypeLoader().newInstance(NarrowMaxMin.MaxOccurs.type, param2XmlOptions);
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
/*     */     public static NarrowMaxMin newInstance() {
/*  98 */       return (NarrowMaxMin)XmlBeans.getContextTypeLoader().newInstance(NarrowMaxMin.type, null);
/*     */     }
/*     */     public static NarrowMaxMin newInstance(XmlOptions param1XmlOptions) {
/* 101 */       return (NarrowMaxMin)XmlBeans.getContextTypeLoader().newInstance(NarrowMaxMin.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static NarrowMaxMin parse(String param1String) throws XmlException {
/* 105 */       return (NarrowMaxMin)XmlBeans.getContextTypeLoader().parse(param1String, NarrowMaxMin.type, null);
/*     */     }
/*     */     public static NarrowMaxMin parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 108 */       return (NarrowMaxMin)XmlBeans.getContextTypeLoader().parse(param1String, NarrowMaxMin.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static NarrowMaxMin parse(File param1File) throws XmlException, IOException {
/* 112 */       return (NarrowMaxMin)XmlBeans.getContextTypeLoader().parse(param1File, NarrowMaxMin.type, null);
/*     */     }
/*     */     public static NarrowMaxMin parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 115 */       return (NarrowMaxMin)XmlBeans.getContextTypeLoader().parse(param1File, NarrowMaxMin.type, param1XmlOptions);
/*     */     }
/*     */     public static NarrowMaxMin parse(URL param1URL) throws XmlException, IOException {
/* 118 */       return (NarrowMaxMin)XmlBeans.getContextTypeLoader().parse(param1URL, NarrowMaxMin.type, null);
/*     */     }
/*     */     public static NarrowMaxMin parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 121 */       return (NarrowMaxMin)XmlBeans.getContextTypeLoader().parse(param1URL, NarrowMaxMin.type, param1XmlOptions);
/*     */     }
/*     */     public static NarrowMaxMin parse(InputStream param1InputStream) throws XmlException, IOException {
/* 124 */       return (NarrowMaxMin)XmlBeans.getContextTypeLoader().parse(param1InputStream, NarrowMaxMin.type, null);
/*     */     }
/*     */     public static NarrowMaxMin parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 127 */       return (NarrowMaxMin)XmlBeans.getContextTypeLoader().parse(param1InputStream, NarrowMaxMin.type, param1XmlOptions);
/*     */     }
/*     */     public static NarrowMaxMin parse(Reader param1Reader) throws XmlException, IOException {
/* 130 */       return (NarrowMaxMin)XmlBeans.getContextTypeLoader().parse(param1Reader, NarrowMaxMin.type, null);
/*     */     }
/*     */     public static NarrowMaxMin parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 133 */       return (NarrowMaxMin)XmlBeans.getContextTypeLoader().parse(param1Reader, NarrowMaxMin.type, param1XmlOptions);
/*     */     }
/*     */     public static NarrowMaxMin parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 136 */       return (NarrowMaxMin)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, NarrowMaxMin.type, null);
/*     */     }
/*     */     public static NarrowMaxMin parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 139 */       return (NarrowMaxMin)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, NarrowMaxMin.type, param1XmlOptions);
/*     */     }
/*     */     public static NarrowMaxMin parse(Node param1Node) throws XmlException {
/* 142 */       return (NarrowMaxMin)XmlBeans.getContextTypeLoader().parse(param1Node, NarrowMaxMin.type, null);
/*     */     }
/*     */     public static NarrowMaxMin parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 145 */       return (NarrowMaxMin)XmlBeans.getContextTypeLoader().parse(param1Node, NarrowMaxMin.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static NarrowMaxMin parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 149 */       return (NarrowMaxMin)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, NarrowMaxMin.type, null);
/*     */     }
/*     */     
/*     */     public static NarrowMaxMin parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 153 */       return (NarrowMaxMin)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, NarrowMaxMin.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 157 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, NarrowMaxMin.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 161 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, NarrowMaxMin.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\NarrowMaxMin.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */