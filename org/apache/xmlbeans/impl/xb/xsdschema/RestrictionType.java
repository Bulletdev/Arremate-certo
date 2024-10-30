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
/*     */ public interface RestrictionType extends Annotated {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$RestrictionType == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$RestrictionType = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$RestrictionType).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("restrictiontype939ftype");
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
/*     */   LocalSimpleType getSimpleType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetSimpleType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setSimpleType(LocalSimpleType paramLocalSimpleType);
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
/*     */   Facet[] getMinExclusiveArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Facet getMinExclusiveArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfMinExclusiveArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setMinExclusiveArray(Facet[] paramArrayOfFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setMinExclusiveArray(int paramInt, Facet paramFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Facet insertNewMinExclusive(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Facet addNewMinExclusive();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeMinExclusive(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Facet[] getMinInclusiveArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Facet getMinInclusiveArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfMinInclusiveArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setMinInclusiveArray(Facet[] paramArrayOfFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setMinInclusiveArray(int paramInt, Facet paramFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Facet insertNewMinInclusive(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Facet addNewMinInclusive();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeMinInclusive(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Facet[] getMaxExclusiveArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Facet getMaxExclusiveArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfMaxExclusiveArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setMaxExclusiveArray(Facet[] paramArrayOfFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setMaxExclusiveArray(int paramInt, Facet paramFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Facet insertNewMaxExclusive(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Facet addNewMaxExclusive();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeMaxExclusive(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Facet[] getMaxInclusiveArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Facet getMaxInclusiveArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfMaxInclusiveArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setMaxInclusiveArray(Facet[] paramArrayOfFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setMaxInclusiveArray(int paramInt, Facet paramFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Facet insertNewMaxInclusive(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Facet addNewMaxInclusive();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeMaxInclusive(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TotalDigitsDocument.TotalDigits[] getTotalDigitsArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TotalDigitsDocument.TotalDigits getTotalDigitsArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfTotalDigitsArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setTotalDigitsArray(TotalDigitsDocument.TotalDigits[] paramArrayOfTotalDigits);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setTotalDigitsArray(int paramInt, TotalDigitsDocument.TotalDigits paramTotalDigits);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TotalDigitsDocument.TotalDigits insertNewTotalDigits(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TotalDigitsDocument.TotalDigits addNewTotalDigits();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeTotalDigits(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NumFacet[] getFractionDigitsArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NumFacet getFractionDigitsArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfFractionDigitsArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setFractionDigitsArray(NumFacet[] paramArrayOfNumFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setFractionDigitsArray(int paramInt, NumFacet paramNumFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NumFacet insertNewFractionDigits(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NumFacet addNewFractionDigits();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeFractionDigits(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NumFacet[] getLengthArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NumFacet getLengthArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfLengthArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setLengthArray(NumFacet[] paramArrayOfNumFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setLengthArray(int paramInt, NumFacet paramNumFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NumFacet insertNewLength(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NumFacet addNewLength();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeLength(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NumFacet[] getMinLengthArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NumFacet getMinLengthArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfMinLengthArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setMinLengthArray(NumFacet[] paramArrayOfNumFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setMinLengthArray(int paramInt, NumFacet paramNumFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NumFacet insertNewMinLength(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NumFacet addNewMinLength();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeMinLength(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NumFacet[] getMaxLengthArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NumFacet getMaxLengthArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfMaxLengthArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setMaxLengthArray(NumFacet[] paramArrayOfNumFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setMaxLengthArray(int paramInt, NumFacet paramNumFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NumFacet insertNewMaxLength(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NumFacet addNewMaxLength();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeMaxLength(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NoFixedFacet[] getEnumerationArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NoFixedFacet getEnumerationArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfEnumerationArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setEnumerationArray(NoFixedFacet[] paramArrayOfNoFixedFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setEnumerationArray(int paramInt, NoFixedFacet paramNoFixedFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NoFixedFacet insertNewEnumeration(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NoFixedFacet addNewEnumeration();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeEnumeration(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WhiteSpaceDocument.WhiteSpace[] getWhiteSpaceArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WhiteSpaceDocument.WhiteSpace getWhiteSpaceArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfWhiteSpaceArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setWhiteSpaceArray(WhiteSpaceDocument.WhiteSpace[] paramArrayOfWhiteSpace);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setWhiteSpaceArray(int paramInt, WhiteSpaceDocument.WhiteSpace paramWhiteSpace);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WhiteSpaceDocument.WhiteSpace insertNewWhiteSpace(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WhiteSpaceDocument.WhiteSpace addNewWhiteSpace();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeWhiteSpace(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PatternDocument.Pattern[] getPatternArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PatternDocument.Pattern getPatternArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfPatternArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setPatternArray(PatternDocument.Pattern[] paramArrayOfPattern);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setPatternArray(int paramInt, PatternDocument.Pattern paramPattern);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PatternDocument.Pattern insertNewPattern(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PatternDocument.Pattern addNewPattern();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removePattern(int paramInt);
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
/*     */     public static RestrictionType newInstance() {
/* 759 */       return (RestrictionType)XmlBeans.getContextTypeLoader().newInstance(RestrictionType.type, null);
/*     */     }
/*     */     public static RestrictionType newInstance(XmlOptions param1XmlOptions) {
/* 762 */       return (RestrictionType)XmlBeans.getContextTypeLoader().newInstance(RestrictionType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static RestrictionType parse(String param1String) throws XmlException {
/* 766 */       return (RestrictionType)XmlBeans.getContextTypeLoader().parse(param1String, RestrictionType.type, null);
/*     */     }
/*     */     public static RestrictionType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 769 */       return (RestrictionType)XmlBeans.getContextTypeLoader().parse(param1String, RestrictionType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static RestrictionType parse(File param1File) throws XmlException, IOException {
/* 773 */       return (RestrictionType)XmlBeans.getContextTypeLoader().parse(param1File, RestrictionType.type, null);
/*     */     }
/*     */     public static RestrictionType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 776 */       return (RestrictionType)XmlBeans.getContextTypeLoader().parse(param1File, RestrictionType.type, param1XmlOptions);
/*     */     }
/*     */     public static RestrictionType parse(URL param1URL) throws XmlException, IOException {
/* 779 */       return (RestrictionType)XmlBeans.getContextTypeLoader().parse(param1URL, RestrictionType.type, null);
/*     */     }
/*     */     public static RestrictionType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 782 */       return (RestrictionType)XmlBeans.getContextTypeLoader().parse(param1URL, RestrictionType.type, param1XmlOptions);
/*     */     }
/*     */     public static RestrictionType parse(InputStream param1InputStream) throws XmlException, IOException {
/* 785 */       return (RestrictionType)XmlBeans.getContextTypeLoader().parse(param1InputStream, RestrictionType.type, null);
/*     */     }
/*     */     public static RestrictionType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 788 */       return (RestrictionType)XmlBeans.getContextTypeLoader().parse(param1InputStream, RestrictionType.type, param1XmlOptions);
/*     */     }
/*     */     public static RestrictionType parse(Reader param1Reader) throws XmlException, IOException {
/* 791 */       return (RestrictionType)XmlBeans.getContextTypeLoader().parse(param1Reader, RestrictionType.type, null);
/*     */     }
/*     */     public static RestrictionType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 794 */       return (RestrictionType)XmlBeans.getContextTypeLoader().parse(param1Reader, RestrictionType.type, param1XmlOptions);
/*     */     }
/*     */     public static RestrictionType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 797 */       return (RestrictionType)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, RestrictionType.type, null);
/*     */     }
/*     */     public static RestrictionType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 800 */       return (RestrictionType)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, RestrictionType.type, param1XmlOptions);
/*     */     }
/*     */     public static RestrictionType parse(Node param1Node) throws XmlException {
/* 803 */       return (RestrictionType)XmlBeans.getContextTypeLoader().parse(param1Node, RestrictionType.type, null);
/*     */     }
/*     */     public static RestrictionType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 806 */       return (RestrictionType)XmlBeans.getContextTypeLoader().parse(param1Node, RestrictionType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static RestrictionType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 810 */       return (RestrictionType)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, RestrictionType.type, null);
/*     */     }
/*     */     
/*     */     public static RestrictionType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 814 */       return (RestrictionType)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, RestrictionType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 818 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, RestrictionType.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 822 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, RestrictionType.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\RestrictionType.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */