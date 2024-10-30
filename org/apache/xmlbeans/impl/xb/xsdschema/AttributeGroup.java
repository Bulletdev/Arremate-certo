/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlNCName;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.XmlQName;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface AttributeGroup extends Annotated {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeGroup == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeGroup = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeGroup).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("attributegroupe530type");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Attribute[] getAttributeArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Attribute getAttributeArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfAttributeArray();
/*     */ 
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
/*     */   public static final class Factory
/*     */   {
/*     */     public static AttributeGroup newInstance() {
/* 195 */       return (AttributeGroup)XmlBeans.getContextTypeLoader().newInstance(AttributeGroup.type, null);
/*     */     }
/*     */     
/*     */     public static AttributeGroup newInstance(XmlOptions param1XmlOptions) {
/* 199 */       return (AttributeGroup)XmlBeans.getContextTypeLoader().newInstance(AttributeGroup.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AttributeGroup parse(String param1String) throws XmlException {
/* 203 */       return (AttributeGroup)XmlBeans.getContextTypeLoader().parse(param1String, AttributeGroup.type, null);
/*     */     }
/*     */     public static AttributeGroup parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 206 */       return (AttributeGroup)XmlBeans.getContextTypeLoader().parse(param1String, AttributeGroup.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AttributeGroup parse(File param1File) throws XmlException, IOException {
/* 210 */       return (AttributeGroup)XmlBeans.getContextTypeLoader().parse(param1File, AttributeGroup.type, null);
/*     */     }
/*     */     public static AttributeGroup parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 213 */       return (AttributeGroup)XmlBeans.getContextTypeLoader().parse(param1File, AttributeGroup.type, param1XmlOptions);
/*     */     }
/*     */     public static AttributeGroup parse(URL param1URL) throws XmlException, IOException {
/* 216 */       return (AttributeGroup)XmlBeans.getContextTypeLoader().parse(param1URL, AttributeGroup.type, null);
/*     */     }
/*     */     public static AttributeGroup parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 219 */       return (AttributeGroup)XmlBeans.getContextTypeLoader().parse(param1URL, AttributeGroup.type, param1XmlOptions);
/*     */     }
/*     */     public static AttributeGroup parse(InputStream param1InputStream) throws XmlException, IOException {
/* 222 */       return (AttributeGroup)XmlBeans.getContextTypeLoader().parse(param1InputStream, AttributeGroup.type, null);
/*     */     }
/*     */     public static AttributeGroup parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 225 */       return (AttributeGroup)XmlBeans.getContextTypeLoader().parse(param1InputStream, AttributeGroup.type, param1XmlOptions);
/*     */     }
/*     */     public static AttributeGroup parse(Reader param1Reader) throws XmlException, IOException {
/* 228 */       return (AttributeGroup)XmlBeans.getContextTypeLoader().parse(param1Reader, AttributeGroup.type, null);
/*     */     }
/*     */     public static AttributeGroup parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 231 */       return (AttributeGroup)XmlBeans.getContextTypeLoader().parse(param1Reader, AttributeGroup.type, param1XmlOptions);
/*     */     }
/*     */     public static AttributeGroup parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 234 */       return (AttributeGroup)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, AttributeGroup.type, null);
/*     */     }
/*     */     public static AttributeGroup parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 237 */       return (AttributeGroup)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, AttributeGroup.type, param1XmlOptions);
/*     */     }
/*     */     public static AttributeGroup parse(Node param1Node) throws XmlException {
/* 240 */       return (AttributeGroup)XmlBeans.getContextTypeLoader().parse(param1Node, AttributeGroup.type, null);
/*     */     }
/*     */     public static AttributeGroup parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 243 */       return (AttributeGroup)XmlBeans.getContextTypeLoader().parse(param1Node, AttributeGroup.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AttributeGroup parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 247 */       return (AttributeGroup)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, AttributeGroup.type, null);
/*     */     }
/*     */     
/*     */     public static AttributeGroup parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 251 */       return (AttributeGroup)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, AttributeGroup.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 255 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, AttributeGroup.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 259 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, AttributeGroup.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\AttributeGroup.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */