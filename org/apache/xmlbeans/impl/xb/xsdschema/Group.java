/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.math.BigInteger;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlNCName;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface Group extends Annotated {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$Group == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$Group = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.Group")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$Group).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("group7ca6type");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   LocalElement[] getElementArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   LocalElement getElementArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfElementArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setElementArray(LocalElement[] paramArrayOfLocalElement);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setElementArray(int paramInt, LocalElement paramLocalElement);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   LocalElement insertNewElement(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   LocalElement addNewElement();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeElement(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   GroupRef[] getGroupArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   GroupRef getGroupArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfGroupArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setGroupArray(GroupRef[] paramArrayOfGroupRef);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setGroupArray(int paramInt, GroupRef paramGroupRef);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   GroupRef insertNewGroup(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   GroupRef addNewGroup();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeGroup(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   All[] getAllArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   All getAllArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfAllArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setAllArray(All[] paramArrayOfAll);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setAllArray(int paramInt, All paramAll);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   All insertNewAll(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   All addNewAll();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeAll(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExplicitGroup[] getChoiceArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExplicitGroup getChoiceArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfChoiceArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setChoiceArray(ExplicitGroup[] paramArrayOfExplicitGroup);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setChoiceArray(int paramInt, ExplicitGroup paramExplicitGroup);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExplicitGroup insertNewChoice(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExplicitGroup addNewChoice();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeChoice(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExplicitGroup[] getSequenceArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExplicitGroup getSequenceArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfSequenceArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setSequenceArray(ExplicitGroup[] paramArrayOfExplicitGroup);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setSequenceArray(int paramInt, ExplicitGroup paramExplicitGroup);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExplicitGroup insertNewSequence(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExplicitGroup addNewSequence();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeSequence(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   AnyDocument.Any[] getAnyArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   AnyDocument.Any getAnyArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfAnyArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setAnyArray(AnyDocument.Any[] paramArrayOfAny);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setAnyArray(int paramInt, AnyDocument.Any paramAny);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   AnyDocument.Any insertNewAny(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   AnyDocument.Any addNewAny();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeAny(int paramInt);
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
/*     */   public static final class Factory
/*     */   {
/*     */     public static Group newInstance() {
/* 390 */       return (Group)XmlBeans.getContextTypeLoader().newInstance(Group.type, null);
/*     */     }
/*     */     
/*     */     public static Group newInstance(XmlOptions param1XmlOptions) {
/* 394 */       return (Group)XmlBeans.getContextTypeLoader().newInstance(Group.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Group parse(String param1String) throws XmlException {
/* 398 */       return (Group)XmlBeans.getContextTypeLoader().parse(param1String, Group.type, null);
/*     */     }
/*     */     public static Group parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 401 */       return (Group)XmlBeans.getContextTypeLoader().parse(param1String, Group.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Group parse(File param1File) throws XmlException, IOException {
/* 405 */       return (Group)XmlBeans.getContextTypeLoader().parse(param1File, Group.type, null);
/*     */     }
/*     */     public static Group parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 408 */       return (Group)XmlBeans.getContextTypeLoader().parse(param1File, Group.type, param1XmlOptions);
/*     */     }
/*     */     public static Group parse(URL param1URL) throws XmlException, IOException {
/* 411 */       return (Group)XmlBeans.getContextTypeLoader().parse(param1URL, Group.type, null);
/*     */     }
/*     */     public static Group parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 414 */       return (Group)XmlBeans.getContextTypeLoader().parse(param1URL, Group.type, param1XmlOptions);
/*     */     }
/*     */     public static Group parse(InputStream param1InputStream) throws XmlException, IOException {
/* 417 */       return (Group)XmlBeans.getContextTypeLoader().parse(param1InputStream, Group.type, null);
/*     */     }
/*     */     public static Group parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 420 */       return (Group)XmlBeans.getContextTypeLoader().parse(param1InputStream, Group.type, param1XmlOptions);
/*     */     }
/*     */     public static Group parse(Reader param1Reader) throws XmlException, IOException {
/* 423 */       return (Group)XmlBeans.getContextTypeLoader().parse(param1Reader, Group.type, null);
/*     */     }
/*     */     public static Group parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 426 */       return (Group)XmlBeans.getContextTypeLoader().parse(param1Reader, Group.type, param1XmlOptions);
/*     */     }
/*     */     public static Group parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 429 */       return (Group)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Group.type, null);
/*     */     }
/*     */     public static Group parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 432 */       return (Group)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Group.type, param1XmlOptions);
/*     */     }
/*     */     public static Group parse(Node param1Node) throws XmlException {
/* 435 */       return (Group)XmlBeans.getContextTypeLoader().parse(param1Node, Group.type, null);
/*     */     }
/*     */     public static Group parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 438 */       return (Group)XmlBeans.getContextTypeLoader().parse(param1Node, Group.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Group parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 442 */       return (Group)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Group.type, null);
/*     */     }
/*     */     
/*     */     public static Group parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 446 */       return (Group)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Group.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 450 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Group.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 454 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Group.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\Group.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */