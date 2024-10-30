/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlBoolean;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlNCName;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface ComplexType extends Annotated {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexType == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexType = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.ComplexType")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexType).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("complextype5dbbtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   SimpleContentDocument.SimpleContent getSimpleContent();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetSimpleContent();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setSimpleContent(SimpleContentDocument.SimpleContent paramSimpleContent);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   SimpleContentDocument.SimpleContent addNewSimpleContent();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetSimpleContent();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ComplexContentDocument.ComplexContent getComplexContent();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetComplexContent();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setComplexContent(ComplexContentDocument.ComplexContent paramComplexContent);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ComplexContentDocument.ComplexContent addNewComplexContent();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetComplexContent();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   GroupRef getGroup();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetGroup();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setGroup(GroupRef paramGroupRef);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   GroupRef addNewGroup();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetGroup();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   All getAll();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetAll();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setAll(All paramAll);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   All addNewAll();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetAll();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExplicitGroup getChoice();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetChoice();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setChoice(ExplicitGroup paramExplicitGroup);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExplicitGroup addNewChoice();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetChoice();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExplicitGroup getSequence();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetSequence();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setSequence(ExplicitGroup paramExplicitGroup);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExplicitGroup addNewSequence();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetSequence();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Attribute[] getAttributeArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Attribute getAttributeArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfAttributeArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setAttributeArray(Attribute[] paramArrayOfAttribute);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setAttributeArray(int paramInt, Attribute paramAttribute);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Attribute insertNewAttribute(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Attribute addNewAttribute();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeAttribute(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   AttributeGroupRef[] getAttributeGroupArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   AttributeGroupRef getAttributeGroupArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfAttributeGroupArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setAttributeGroupArray(AttributeGroupRef[] paramArrayOfAttributeGroupRef);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setAttributeGroupArray(int paramInt, AttributeGroupRef paramAttributeGroupRef);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   AttributeGroupRef insertNewAttributeGroup(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   AttributeGroupRef addNewAttributeGroup();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeAttributeGroup(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Wildcard getAnyAttribute();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetAnyAttribute();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setAnyAttribute(Wildcard paramWildcard);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Wildcard addNewAnyAttribute();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetAnyAttribute();
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
/*     */   boolean getMixed();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlBoolean xgetMixed();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetMixed();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setMixed(boolean paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetMixed(XmlBoolean paramXmlBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetMixed();
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
/*     */   DerivationSet xgetBlock();
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
/*     */   void xsetBlock(DerivationSet paramDerivationSet);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetBlock();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static ComplexType newInstance() {
/* 435 */       return (ComplexType)XmlBeans.getContextTypeLoader().newInstance(ComplexType.type, null);
/*     */     }
/*     */     
/*     */     public static ComplexType newInstance(XmlOptions param1XmlOptions) {
/* 439 */       return (ComplexType)XmlBeans.getContextTypeLoader().newInstance(ComplexType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ComplexType parse(String param1String) throws XmlException {
/* 443 */       return (ComplexType)XmlBeans.getContextTypeLoader().parse(param1String, ComplexType.type, null);
/*     */     }
/*     */     public static ComplexType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 446 */       return (ComplexType)XmlBeans.getContextTypeLoader().parse(param1String, ComplexType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ComplexType parse(File param1File) throws XmlException, IOException {
/* 450 */       return (ComplexType)XmlBeans.getContextTypeLoader().parse(param1File, ComplexType.type, null);
/*     */     }
/*     */     public static ComplexType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 453 */       return (ComplexType)XmlBeans.getContextTypeLoader().parse(param1File, ComplexType.type, param1XmlOptions);
/*     */     }
/*     */     public static ComplexType parse(URL param1URL) throws XmlException, IOException {
/* 456 */       return (ComplexType)XmlBeans.getContextTypeLoader().parse(param1URL, ComplexType.type, null);
/*     */     }
/*     */     public static ComplexType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 459 */       return (ComplexType)XmlBeans.getContextTypeLoader().parse(param1URL, ComplexType.type, param1XmlOptions);
/*     */     }
/*     */     public static ComplexType parse(InputStream param1InputStream) throws XmlException, IOException {
/* 462 */       return (ComplexType)XmlBeans.getContextTypeLoader().parse(param1InputStream, ComplexType.type, null);
/*     */     }
/*     */     public static ComplexType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 465 */       return (ComplexType)XmlBeans.getContextTypeLoader().parse(param1InputStream, ComplexType.type, param1XmlOptions);
/*     */     }
/*     */     public static ComplexType parse(Reader param1Reader) throws XmlException, IOException {
/* 468 */       return (ComplexType)XmlBeans.getContextTypeLoader().parse(param1Reader, ComplexType.type, null);
/*     */     }
/*     */     public static ComplexType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 471 */       return (ComplexType)XmlBeans.getContextTypeLoader().parse(param1Reader, ComplexType.type, param1XmlOptions);
/*     */     }
/*     */     public static ComplexType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 474 */       return (ComplexType)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, ComplexType.type, null);
/*     */     }
/*     */     public static ComplexType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 477 */       return (ComplexType)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, ComplexType.type, param1XmlOptions);
/*     */     }
/*     */     public static ComplexType parse(Node param1Node) throws XmlException {
/* 480 */       return (ComplexType)XmlBeans.getContextTypeLoader().parse(param1Node, ComplexType.type, null);
/*     */     }
/*     */     public static ComplexType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 483 */       return (ComplexType)XmlBeans.getContextTypeLoader().parse(param1Node, ComplexType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ComplexType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 487 */       return (ComplexType)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, ComplexType.type, null);
/*     */     }
/*     */     
/*     */     public static ComplexType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 491 */       return (ComplexType)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, ComplexType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 495 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, ComplexType.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 499 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, ComplexType.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\ComplexType.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */