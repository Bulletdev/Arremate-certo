/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.math.BigInteger;
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
/*     */ public interface AnyDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$AnyDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$AnyDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$AnyDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anye729doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Any getAny();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setAny(Any paramAny);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Any addNewAny();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Any
/*     */     extends Wildcard
/*     */   {
/*  44 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((AnyDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$AnyDocument$Any == null) ? (AnyDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$AnyDocument$Any = AnyDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument$Any")) : AnyDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$AnyDocument$Any).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anye9d1elemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     BigInteger getMinOccurs();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlNonNegativeInteger xgetMinOccurs();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetMinOccurs();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setMinOccurs(BigInteger param1BigInteger);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetMinOccurs(XmlNonNegativeInteger param1XmlNonNegativeInteger);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetMinOccurs();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Object getMaxOccurs();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     AllNNI xgetMaxOccurs();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetMaxOccurs();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setMaxOccurs(Object param1Object);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetMaxOccurs(AllNNI param1AllNNI);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetMaxOccurs();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static AnyDocument.Any newInstance() {
/* 115 */         return (AnyDocument.Any)XmlBeans.getContextTypeLoader().newInstance(AnyDocument.Any.type, null);
/*     */       }
/*     */       public static AnyDocument.Any newInstance(XmlOptions param2XmlOptions) {
/* 118 */         return (AnyDocument.Any)XmlBeans.getContextTypeLoader().newInstance(AnyDocument.Any.type, param2XmlOptions);
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
/*     */     public static AnyDocument newInstance() {
/* 132 */       return (AnyDocument)XmlBeans.getContextTypeLoader().newInstance(AnyDocument.type, null);
/*     */     }
/*     */     public static AnyDocument newInstance(XmlOptions param1XmlOptions) {
/* 135 */       return (AnyDocument)XmlBeans.getContextTypeLoader().newInstance(AnyDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AnyDocument parse(String param1String) throws XmlException {
/* 139 */       return (AnyDocument)XmlBeans.getContextTypeLoader().parse(param1String, AnyDocument.type, null);
/*     */     }
/*     */     public static AnyDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 142 */       return (AnyDocument)XmlBeans.getContextTypeLoader().parse(param1String, AnyDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AnyDocument parse(File param1File) throws XmlException, IOException {
/* 146 */       return (AnyDocument)XmlBeans.getContextTypeLoader().parse(param1File, AnyDocument.type, null);
/*     */     }
/*     */     public static AnyDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 149 */       return (AnyDocument)XmlBeans.getContextTypeLoader().parse(param1File, AnyDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AnyDocument parse(URL param1URL) throws XmlException, IOException {
/* 152 */       return (AnyDocument)XmlBeans.getContextTypeLoader().parse(param1URL, AnyDocument.type, null);
/*     */     }
/*     */     public static AnyDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 155 */       return (AnyDocument)XmlBeans.getContextTypeLoader().parse(param1URL, AnyDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AnyDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/* 158 */       return (AnyDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, AnyDocument.type, null);
/*     */     }
/*     */     public static AnyDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 161 */       return (AnyDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, AnyDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AnyDocument parse(Reader param1Reader) throws XmlException, IOException {
/* 164 */       return (AnyDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, AnyDocument.type, null);
/*     */     }
/*     */     public static AnyDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 167 */       return (AnyDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, AnyDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AnyDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 170 */       return (AnyDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, AnyDocument.type, null);
/*     */     }
/*     */     public static AnyDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 173 */       return (AnyDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, AnyDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AnyDocument parse(Node param1Node) throws XmlException {
/* 176 */       return (AnyDocument)XmlBeans.getContextTypeLoader().parse(param1Node, AnyDocument.type, null);
/*     */     }
/*     */     public static AnyDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 179 */       return (AnyDocument)XmlBeans.getContextTypeLoader().parse(param1Node, AnyDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AnyDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 183 */       return (AnyDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, AnyDocument.type, null);
/*     */     }
/*     */     
/*     */     public static AnyDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 187 */       return (AnyDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, AnyDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 191 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, AnyDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 195 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, AnyDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\AnyDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */