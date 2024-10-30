/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlBoolean;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.XmlQName;
/*     */ import org.apache.xmlbeans.XmlString;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface Element extends Annotated {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$Element == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$Element = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.Element")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$Element).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("elementd189type");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   LocalSimpleType getSimpleType();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetSimpleType();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setSimpleType(LocalSimpleType paramLocalSimpleType);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   LocalSimpleType addNewSimpleType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetSimpleType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   LocalComplexType getComplexType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetComplexType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setComplexType(LocalComplexType paramLocalComplexType);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   LocalComplexType addNewComplexType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetComplexType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Keybase[] getUniqueArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Keybase getUniqueArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfUniqueArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setUniqueArray(Keybase[] paramArrayOfKeybase);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setUniqueArray(int paramInt, Keybase paramKeybase);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Keybase insertNewUnique(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Keybase addNewUnique();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeUnique(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Keybase[] getKeyArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Keybase getKeyArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfKeyArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setKeyArray(Keybase[] paramArrayOfKeybase);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setKeyArray(int paramInt, Keybase paramKeybase);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Keybase insertNewKey(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Keybase addNewKey();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeKey(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   KeyrefDocument.Keyref[] getKeyrefArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   KeyrefDocument.Keyref getKeyrefArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfKeyrefArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setKeyrefArray(KeyrefDocument.Keyref[] paramArrayOfKeyref);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setKeyrefArray(int paramInt, KeyrefDocument.Keyref paramKeyref);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   KeyrefDocument.Keyref insertNewKeyref(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   KeyrefDocument.Keyref addNewKeyref();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeKeyref(int paramInt);
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
/*     */   b getRef();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlQName xgetRef();
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
/*     */   b getType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlQName xgetType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setType(b paramb);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetType(XmlQName paramXmlQName);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   b getSubstitutionGroup();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlQName xgetSubstitutionGroup();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetSubstitutionGroup();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setSubstitutionGroup(b paramb);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetSubstitutionGroup(XmlQName paramXmlQName);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetSubstitutionGroup();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   BigInteger getMinOccurs();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlNonNegativeInteger xgetMinOccurs();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetMinOccurs();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setMinOccurs(BigInteger paramBigInteger);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetMinOccurs(XmlNonNegativeInteger paramXmlNonNegativeInteger);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetMinOccurs();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Object getMaxOccurs();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   AllNNI xgetMaxOccurs();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetMaxOccurs();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setMaxOccurs(Object paramObject);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetMaxOccurs(AllNNI paramAllNNI);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetMaxOccurs();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlString xgetDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setDefault(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetDefault(XmlString paramXmlString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getFixed();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlString xgetFixed();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetFixed();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setFixed(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetFixed(XmlString paramXmlString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetFixed();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean getNillable();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlBoolean xgetNillable();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetNillable();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setNillable(boolean paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetNillable(XmlBoolean paramXmlBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetNillable();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean getAbstract();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlBoolean xgetAbstract();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetAbstract();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setAbstract(boolean paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetAbstract(XmlBoolean paramXmlBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetAbstract();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Object getFinal();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   DerivationSet xgetFinal();
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
/*     */   void xsetFinal(DerivationSet paramDerivationSet);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetFinal();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Object getBlock();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   BlockSet xgetBlock();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetBlock();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setBlock(Object paramObject);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetBlock(BlockSet paramBlockSet);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetBlock();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FormChoice.Enum getForm();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FormChoice xgetForm();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetForm();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setForm(FormChoice.Enum paramEnum);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetForm(FormChoice paramFormChoice);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetForm();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static Element newInstance() {
/* 590 */       return (Element)XmlBeans.getContextTypeLoader().newInstance(Element.type, null);
/*     */     }
/*     */     
/*     */     public static Element newInstance(XmlOptions param1XmlOptions) {
/* 594 */       return (Element)XmlBeans.getContextTypeLoader().newInstance(Element.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Element parse(String param1String) throws XmlException {
/* 598 */       return (Element)XmlBeans.getContextTypeLoader().parse(param1String, Element.type, null);
/*     */     }
/*     */     public static Element parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 601 */       return (Element)XmlBeans.getContextTypeLoader().parse(param1String, Element.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Element parse(File param1File) throws XmlException, IOException {
/* 605 */       return (Element)XmlBeans.getContextTypeLoader().parse(param1File, Element.type, null);
/*     */     }
/*     */     public static Element parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 608 */       return (Element)XmlBeans.getContextTypeLoader().parse(param1File, Element.type, param1XmlOptions);
/*     */     }
/*     */     public static Element parse(URL param1URL) throws XmlException, IOException {
/* 611 */       return (Element)XmlBeans.getContextTypeLoader().parse(param1URL, Element.type, null);
/*     */     }
/*     */     public static Element parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 614 */       return (Element)XmlBeans.getContextTypeLoader().parse(param1URL, Element.type, param1XmlOptions);
/*     */     }
/*     */     public static Element parse(InputStream param1InputStream) throws XmlException, IOException {
/* 617 */       return (Element)XmlBeans.getContextTypeLoader().parse(param1InputStream, Element.type, null);
/*     */     }
/*     */     public static Element parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 620 */       return (Element)XmlBeans.getContextTypeLoader().parse(param1InputStream, Element.type, param1XmlOptions);
/*     */     }
/*     */     public static Element parse(Reader param1Reader) throws XmlException, IOException {
/* 623 */       return (Element)XmlBeans.getContextTypeLoader().parse(param1Reader, Element.type, null);
/*     */     }
/*     */     public static Element parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 626 */       return (Element)XmlBeans.getContextTypeLoader().parse(param1Reader, Element.type, param1XmlOptions);
/*     */     }
/*     */     public static Element parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 629 */       return (Element)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Element.type, null);
/*     */     }
/*     */     public static Element parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 632 */       return (Element)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Element.type, param1XmlOptions);
/*     */     }
/*     */     public static Element parse(Node param1Node) throws XmlException {
/* 635 */       return (Element)XmlBeans.getContextTypeLoader().parse(param1Node, Element.type, null);
/*     */     }
/*     */     public static Element parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 638 */       return (Element)XmlBeans.getContextTypeLoader().parse(param1Node, Element.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Element parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 642 */       return (Element)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Element.type, null);
/*     */     }
/*     */     
/*     */     public static Element parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 646 */       return (Element)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Element.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 650 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Element.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 654 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Element.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\Element.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */