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
/*     */ public interface ExtensionType extends Annotated {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$ExtensionType == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$ExtensionType = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$ExtensionType).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("extensiontypeed4ctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   GroupRef getGroup();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetGroup();
/*     */ 
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
/*     */   b getBase();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlQName xgetBase();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setBase(b paramb);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetBase(XmlQName paramXmlQName);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static ExtensionType newInstance() {
/* 254 */       return (ExtensionType)XmlBeans.getContextTypeLoader().newInstance(ExtensionType.type, null);
/*     */     }
/*     */     public static ExtensionType newInstance(XmlOptions param1XmlOptions) {
/* 257 */       return (ExtensionType)XmlBeans.getContextTypeLoader().newInstance(ExtensionType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ExtensionType parse(String param1String) throws XmlException {
/* 261 */       return (ExtensionType)XmlBeans.getContextTypeLoader().parse(param1String, ExtensionType.type, null);
/*     */     }
/*     */     public static ExtensionType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 264 */       return (ExtensionType)XmlBeans.getContextTypeLoader().parse(param1String, ExtensionType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ExtensionType parse(File param1File) throws XmlException, IOException {
/* 268 */       return (ExtensionType)XmlBeans.getContextTypeLoader().parse(param1File, ExtensionType.type, null);
/*     */     }
/*     */     public static ExtensionType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 271 */       return (ExtensionType)XmlBeans.getContextTypeLoader().parse(param1File, ExtensionType.type, param1XmlOptions);
/*     */     }
/*     */     public static ExtensionType parse(URL param1URL) throws XmlException, IOException {
/* 274 */       return (ExtensionType)XmlBeans.getContextTypeLoader().parse(param1URL, ExtensionType.type, null);
/*     */     }
/*     */     public static ExtensionType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 277 */       return (ExtensionType)XmlBeans.getContextTypeLoader().parse(param1URL, ExtensionType.type, param1XmlOptions);
/*     */     }
/*     */     public static ExtensionType parse(InputStream param1InputStream) throws XmlException, IOException {
/* 280 */       return (ExtensionType)XmlBeans.getContextTypeLoader().parse(param1InputStream, ExtensionType.type, null);
/*     */     }
/*     */     public static ExtensionType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 283 */       return (ExtensionType)XmlBeans.getContextTypeLoader().parse(param1InputStream, ExtensionType.type, param1XmlOptions);
/*     */     }
/*     */     public static ExtensionType parse(Reader param1Reader) throws XmlException, IOException {
/* 286 */       return (ExtensionType)XmlBeans.getContextTypeLoader().parse(param1Reader, ExtensionType.type, null);
/*     */     }
/*     */     public static ExtensionType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 289 */       return (ExtensionType)XmlBeans.getContextTypeLoader().parse(param1Reader, ExtensionType.type, param1XmlOptions);
/*     */     }
/*     */     public static ExtensionType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 292 */       return (ExtensionType)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, ExtensionType.type, null);
/*     */     }
/*     */     public static ExtensionType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 295 */       return (ExtensionType)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, ExtensionType.type, param1XmlOptions);
/*     */     }
/*     */     public static ExtensionType parse(Node param1Node) throws XmlException {
/* 298 */       return (ExtensionType)XmlBeans.getContextTypeLoader().parse(param1Node, ExtensionType.type, null);
/*     */     }
/*     */     public static ExtensionType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 301 */       return (ExtensionType)XmlBeans.getContextTypeLoader().parse(param1Node, ExtensionType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ExtensionType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 305 */       return (ExtensionType)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, ExtensionType.type, null);
/*     */     }
/*     */     
/*     */     public static ExtensionType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 309 */       return (ExtensionType)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, ExtensionType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 313 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, ExtensionType.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 317 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, ExtensionType.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\ExtensionType.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */