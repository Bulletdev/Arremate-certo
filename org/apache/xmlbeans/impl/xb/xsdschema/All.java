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
/*     */ public interface All extends ExplicitGroup {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$All == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$All = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.All")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$All).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("all3c04type");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface MinOccurs
/*     */     extends XmlNonNegativeInteger
/*     */   {
/*  28 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((All.null.class$org$apache$xmlbeans$impl$xb$xsdschema$All$MinOccurs == null) ? (All.null.class$org$apache$xmlbeans$impl$xb$xsdschema$All$MinOccurs = All.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.All$MinOccurs")) : All.null.class$org$apache$xmlbeans$impl$xb$xsdschema$All$MinOccurs).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("minoccurs9283attrtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static All.MinOccurs newValue(Object param2Object) {
/*  39 */         return (All.MinOccurs)All.MinOccurs.type.newValue(param2Object);
/*     */       }
/*     */       public static All.MinOccurs newInstance() {
/*  42 */         return (All.MinOccurs)XmlBeans.getContextTypeLoader().newInstance(All.MinOccurs.type, null);
/*     */       }
/*     */       public static All.MinOccurs newInstance(XmlOptions param2XmlOptions) {
/*  45 */         return (All.MinOccurs)XmlBeans.getContextTypeLoader().newInstance(All.MinOccurs.type, param2XmlOptions);
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
/*  67 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((All.null.class$org$apache$xmlbeans$impl$xb$xsdschema$All$MaxOccurs == null) ? (All.null.class$org$apache$xmlbeans$impl$xb$xsdschema$All$MaxOccurs = All.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.All$MaxOccurs")) : All.null.class$org$apache$xmlbeans$impl$xb$xsdschema$All$MaxOccurs).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("maxoccurse8b1attrtype");
/*     */ 
/*     */     
/*     */     void objectSet(Object param1Object);
/*     */ 
/*     */     
/*     */     SchemaType instanceType();
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static All.MaxOccurs newValue(Object param2Object) {
/*  78 */         return (All.MaxOccurs)All.MaxOccurs.type.newValue(param2Object);
/*     */       }
/*     */       public static All.MaxOccurs newInstance() {
/*  81 */         return (All.MaxOccurs)XmlBeans.getContextTypeLoader().newInstance(All.MaxOccurs.type, null);
/*     */       }
/*     */       public static All.MaxOccurs newInstance(XmlOptions param2XmlOptions) {
/*  84 */         return (All.MaxOccurs)XmlBeans.getContextTypeLoader().newInstance(All.MaxOccurs.type, param2XmlOptions);
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
/*     */     public static All newInstance() {
/*  98 */       return (All)XmlBeans.getContextTypeLoader().newInstance(All.type, null);
/*     */     }
/*     */     public static All newInstance(XmlOptions param1XmlOptions) {
/* 101 */       return (All)XmlBeans.getContextTypeLoader().newInstance(All.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static All parse(String param1String) throws XmlException {
/* 105 */       return (All)XmlBeans.getContextTypeLoader().parse(param1String, All.type, null);
/*     */     }
/*     */     public static All parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 108 */       return (All)XmlBeans.getContextTypeLoader().parse(param1String, All.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static All parse(File param1File) throws XmlException, IOException {
/* 112 */       return (All)XmlBeans.getContextTypeLoader().parse(param1File, All.type, null);
/*     */     }
/*     */     public static All parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 115 */       return (All)XmlBeans.getContextTypeLoader().parse(param1File, All.type, param1XmlOptions);
/*     */     }
/*     */     public static All parse(URL param1URL) throws XmlException, IOException {
/* 118 */       return (All)XmlBeans.getContextTypeLoader().parse(param1URL, All.type, null);
/*     */     }
/*     */     public static All parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 121 */       return (All)XmlBeans.getContextTypeLoader().parse(param1URL, All.type, param1XmlOptions);
/*     */     }
/*     */     public static All parse(InputStream param1InputStream) throws XmlException, IOException {
/* 124 */       return (All)XmlBeans.getContextTypeLoader().parse(param1InputStream, All.type, null);
/*     */     }
/*     */     public static All parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 127 */       return (All)XmlBeans.getContextTypeLoader().parse(param1InputStream, All.type, param1XmlOptions);
/*     */     }
/*     */     public static All parse(Reader param1Reader) throws XmlException, IOException {
/* 130 */       return (All)XmlBeans.getContextTypeLoader().parse(param1Reader, All.type, null);
/*     */     }
/*     */     public static All parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 133 */       return (All)XmlBeans.getContextTypeLoader().parse(param1Reader, All.type, param1XmlOptions);
/*     */     }
/*     */     public static All parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 136 */       return (All)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, All.type, null);
/*     */     }
/*     */     public static All parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 139 */       return (All)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, All.type, param1XmlOptions);
/*     */     }
/*     */     public static All parse(Node param1Node) throws XmlException {
/* 142 */       return (All)XmlBeans.getContextTypeLoader().parse(param1Node, All.type, null);
/*     */     }
/*     */     public static All parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 145 */       return (All)XmlBeans.getContextTypeLoader().parse(param1Node, All.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static All parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 149 */       return (All)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, All.type, null);
/*     */     }
/*     */     
/*     */     public static All parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 153 */       return (All)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, All.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 157 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, All.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 161 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, All.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\All.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */