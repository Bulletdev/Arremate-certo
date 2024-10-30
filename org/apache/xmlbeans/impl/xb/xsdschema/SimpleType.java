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
/*     */ import org.apache.xmlbeans.XmlNCName;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface SimpleType extends Annotated {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleType == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleType = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.SimpleType")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleType).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("simpletype0707type");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   RestrictionDocument.Restriction getRestriction();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetRestriction();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setRestriction(RestrictionDocument.Restriction paramRestriction);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   RestrictionDocument.Restriction addNewRestriction();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetRestriction();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ListDocument.List getList();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetList();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setList(ListDocument.List paramList);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ListDocument.List addNewList();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetList();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   UnionDocument.Union getUnion();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetUnion();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setUnion(UnionDocument.Union paramUnion);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   UnionDocument.Union addNewUnion();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetUnion();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Object getFinal();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   SimpleDerivationSet xgetFinal();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetFinal();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setFinal(Object paramObject);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetFinal(SimpleDerivationSet paramSimpleDerivationSet);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetFinal();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getName();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlNCName xgetName();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetName();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setName(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetName(XmlNCName paramXmlNCName);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetName();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static SimpleType newInstance() {
/* 165 */       return (SimpleType)XmlBeans.getContextTypeLoader().newInstance(SimpleType.type, null);
/*     */     }
/*     */     
/*     */     public static SimpleType newInstance(XmlOptions param1XmlOptions) {
/* 169 */       return (SimpleType)XmlBeans.getContextTypeLoader().newInstance(SimpleType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static SimpleType parse(String param1String) throws XmlException {
/* 173 */       return (SimpleType)XmlBeans.getContextTypeLoader().parse(param1String, SimpleType.type, null);
/*     */     }
/*     */     public static SimpleType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 176 */       return (SimpleType)XmlBeans.getContextTypeLoader().parse(param1String, SimpleType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static SimpleType parse(File param1File) throws XmlException, IOException {
/* 180 */       return (SimpleType)XmlBeans.getContextTypeLoader().parse(param1File, SimpleType.type, null);
/*     */     }
/*     */     public static SimpleType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 183 */       return (SimpleType)XmlBeans.getContextTypeLoader().parse(param1File, SimpleType.type, param1XmlOptions);
/*     */     }
/*     */     public static SimpleType parse(URL param1URL) throws XmlException, IOException {
/* 186 */       return (SimpleType)XmlBeans.getContextTypeLoader().parse(param1URL, SimpleType.type, null);
/*     */     }
/*     */     public static SimpleType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 189 */       return (SimpleType)XmlBeans.getContextTypeLoader().parse(param1URL, SimpleType.type, param1XmlOptions);
/*     */     }
/*     */     public static SimpleType parse(InputStream param1InputStream) throws XmlException, IOException {
/* 192 */       return (SimpleType)XmlBeans.getContextTypeLoader().parse(param1InputStream, SimpleType.type, null);
/*     */     }
/*     */     public static SimpleType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 195 */       return (SimpleType)XmlBeans.getContextTypeLoader().parse(param1InputStream, SimpleType.type, param1XmlOptions);
/*     */     }
/*     */     public static SimpleType parse(Reader param1Reader) throws XmlException, IOException {
/* 198 */       return (SimpleType)XmlBeans.getContextTypeLoader().parse(param1Reader, SimpleType.type, null);
/*     */     }
/*     */     public static SimpleType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 201 */       return (SimpleType)XmlBeans.getContextTypeLoader().parse(param1Reader, SimpleType.type, param1XmlOptions);
/*     */     }
/*     */     public static SimpleType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 204 */       return (SimpleType)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, SimpleType.type, null);
/*     */     }
/*     */     public static SimpleType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 207 */       return (SimpleType)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, SimpleType.type, param1XmlOptions);
/*     */     }
/*     */     public static SimpleType parse(Node param1Node) throws XmlException {
/* 210 */       return (SimpleType)XmlBeans.getContextTypeLoader().parse(param1Node, SimpleType.type, null);
/*     */     }
/*     */     public static SimpleType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 213 */       return (SimpleType)XmlBeans.getContextTypeLoader().parse(param1Node, SimpleType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static SimpleType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 217 */       return (SimpleType)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, SimpleType.type, null);
/*     */     }
/*     */     
/*     */     public static SimpleType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 221 */       return (SimpleType)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, SimpleType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 225 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, SimpleType.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 229 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, SimpleType.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\SimpleType.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */