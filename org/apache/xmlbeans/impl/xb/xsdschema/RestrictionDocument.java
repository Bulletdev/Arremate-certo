/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.namespace.b;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.XmlQName;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface RestrictionDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$RestrictionDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$RestrictionDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$RestrictionDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("restriction0049doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Restriction getRestriction();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setRestriction(Restriction paramRestriction);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Restriction addNewRestriction();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Restriction
/*     */     extends Annotated
/*     */   {
/*  44 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((RestrictionDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$RestrictionDocument$Restriction == null) ? (RestrictionDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$RestrictionDocument$Restriction = RestrictionDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument$Restriction")) : RestrictionDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$RestrictionDocument$Restriction).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("restrictionad11elemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     LocalSimpleType getSimpleType();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetSimpleType();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setSimpleType(LocalSimpleType param1LocalSimpleType);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     LocalSimpleType addNewSimpleType();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetSimpleType();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Facet[] getMinExclusiveArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Facet getMinExclusiveArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfMinExclusiveArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setMinExclusiveArray(Facet[] param1ArrayOfFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setMinExclusiveArray(int param1Int, Facet param1Facet);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Facet insertNewMinExclusive(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Facet addNewMinExclusive();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeMinExclusive(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Facet[] getMinInclusiveArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Facet getMinInclusiveArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfMinInclusiveArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setMinInclusiveArray(Facet[] param1ArrayOfFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setMinInclusiveArray(int param1Int, Facet param1Facet);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Facet insertNewMinInclusive(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Facet addNewMinInclusive();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeMinInclusive(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Facet[] getMaxExclusiveArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Facet getMaxExclusiveArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfMaxExclusiveArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setMaxExclusiveArray(Facet[] param1ArrayOfFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setMaxExclusiveArray(int param1Int, Facet param1Facet);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Facet insertNewMaxExclusive(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Facet addNewMaxExclusive();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeMaxExclusive(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Facet[] getMaxInclusiveArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Facet getMaxInclusiveArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfMaxInclusiveArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setMaxInclusiveArray(Facet[] param1ArrayOfFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setMaxInclusiveArray(int param1Int, Facet param1Facet);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Facet insertNewMaxInclusive(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Facet addNewMaxInclusive();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeMaxInclusive(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TotalDigitsDocument.TotalDigits[] getTotalDigitsArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TotalDigitsDocument.TotalDigits getTotalDigitsArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfTotalDigitsArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setTotalDigitsArray(TotalDigitsDocument.TotalDigits[] param1ArrayOfTotalDigits);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setTotalDigitsArray(int param1Int, TotalDigitsDocument.TotalDigits param1TotalDigits);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TotalDigitsDocument.TotalDigits insertNewTotalDigits(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TotalDigitsDocument.TotalDigits addNewTotalDigits();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeTotalDigits(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NumFacet[] getFractionDigitsArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NumFacet getFractionDigitsArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfFractionDigitsArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setFractionDigitsArray(NumFacet[] param1ArrayOfNumFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setFractionDigitsArray(int param1Int, NumFacet param1NumFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NumFacet insertNewFractionDigits(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NumFacet addNewFractionDigits();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeFractionDigits(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NumFacet[] getLengthArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NumFacet getLengthArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfLengthArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setLengthArray(NumFacet[] param1ArrayOfNumFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setLengthArray(int param1Int, NumFacet param1NumFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NumFacet insertNewLength(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NumFacet addNewLength();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeLength(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NumFacet[] getMinLengthArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NumFacet getMinLengthArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfMinLengthArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setMinLengthArray(NumFacet[] param1ArrayOfNumFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setMinLengthArray(int param1Int, NumFacet param1NumFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NumFacet insertNewMinLength(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NumFacet addNewMinLength();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeMinLength(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NumFacet[] getMaxLengthArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NumFacet getMaxLengthArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfMaxLengthArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setMaxLengthArray(NumFacet[] param1ArrayOfNumFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setMaxLengthArray(int param1Int, NumFacet param1NumFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NumFacet insertNewMaxLength(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NumFacet addNewMaxLength();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeMaxLength(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NoFixedFacet[] getEnumerationArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NoFixedFacet getEnumerationArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfEnumerationArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setEnumerationArray(NoFixedFacet[] param1ArrayOfNoFixedFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setEnumerationArray(int param1Int, NoFixedFacet param1NoFixedFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NoFixedFacet insertNewEnumeration(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NoFixedFacet addNewEnumeration();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeEnumeration(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     WhiteSpaceDocument.WhiteSpace[] getWhiteSpaceArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     WhiteSpaceDocument.WhiteSpace getWhiteSpaceArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfWhiteSpaceArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setWhiteSpaceArray(WhiteSpaceDocument.WhiteSpace[] param1ArrayOfWhiteSpace);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setWhiteSpaceArray(int param1Int, WhiteSpaceDocument.WhiteSpace param1WhiteSpace);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     WhiteSpaceDocument.WhiteSpace insertNewWhiteSpace(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     WhiteSpaceDocument.WhiteSpace addNewWhiteSpace();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeWhiteSpace(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     PatternDocument.Pattern[] getPatternArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     PatternDocument.Pattern getPatternArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfPatternArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setPatternArray(PatternDocument.Pattern[] param1ArrayOfPattern);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setPatternArray(int param1Int, PatternDocument.Pattern param1Pattern);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     PatternDocument.Pattern insertNewPattern(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     PatternDocument.Pattern addNewPattern();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removePattern(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     b getBase();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlQName xgetBase();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetBase();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setBase(b param1b);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetBase(XmlQName param1XmlQName);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetBase();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static RestrictionDocument.Restriction newInstance() {
/* 590 */         return (RestrictionDocument.Restriction)XmlBeans.getContextTypeLoader().newInstance(RestrictionDocument.Restriction.type, null);
/*     */       }
/*     */       public static RestrictionDocument.Restriction newInstance(XmlOptions param2XmlOptions) {
/* 593 */         return (RestrictionDocument.Restriction)XmlBeans.getContextTypeLoader().newInstance(RestrictionDocument.Restriction.type, param2XmlOptions);
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
/*     */     public static RestrictionDocument newInstance() {
/* 607 */       return (RestrictionDocument)XmlBeans.getContextTypeLoader().newInstance(RestrictionDocument.type, null);
/*     */     }
/*     */     public static RestrictionDocument newInstance(XmlOptions param1XmlOptions) {
/* 610 */       return (RestrictionDocument)XmlBeans.getContextTypeLoader().newInstance(RestrictionDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static RestrictionDocument parse(String param1String) throws XmlException {
/* 614 */       return (RestrictionDocument)XmlBeans.getContextTypeLoader().parse(param1String, RestrictionDocument.type, null);
/*     */     }
/*     */     public static RestrictionDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 617 */       return (RestrictionDocument)XmlBeans.getContextTypeLoader().parse(param1String, RestrictionDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static RestrictionDocument parse(File param1File) throws XmlException, IOException {
/* 621 */       return (RestrictionDocument)XmlBeans.getContextTypeLoader().parse(param1File, RestrictionDocument.type, null);
/*     */     }
/*     */     public static RestrictionDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 624 */       return (RestrictionDocument)XmlBeans.getContextTypeLoader().parse(param1File, RestrictionDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static RestrictionDocument parse(URL param1URL) throws XmlException, IOException {
/* 627 */       return (RestrictionDocument)XmlBeans.getContextTypeLoader().parse(param1URL, RestrictionDocument.type, null);
/*     */     }
/*     */     public static RestrictionDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 630 */       return (RestrictionDocument)XmlBeans.getContextTypeLoader().parse(param1URL, RestrictionDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static RestrictionDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/* 633 */       return (RestrictionDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, RestrictionDocument.type, null);
/*     */     }
/*     */     public static RestrictionDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 636 */       return (RestrictionDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, RestrictionDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static RestrictionDocument parse(Reader param1Reader) throws XmlException, IOException {
/* 639 */       return (RestrictionDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, RestrictionDocument.type, null);
/*     */     }
/*     */     public static RestrictionDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 642 */       return (RestrictionDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, RestrictionDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static RestrictionDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 645 */       return (RestrictionDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, RestrictionDocument.type, null);
/*     */     }
/*     */     public static RestrictionDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 648 */       return (RestrictionDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, RestrictionDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static RestrictionDocument parse(Node param1Node) throws XmlException {
/* 651 */       return (RestrictionDocument)XmlBeans.getContextTypeLoader().parse(param1Node, RestrictionDocument.type, null);
/*     */     }
/*     */     public static RestrictionDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 654 */       return (RestrictionDocument)XmlBeans.getContextTypeLoader().parse(param1Node, RestrictionDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static RestrictionDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 658 */       return (RestrictionDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, RestrictionDocument.type, null);
/*     */     }
/*     */     
/*     */     public static RestrictionDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 662 */       return (RestrictionDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, RestrictionDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 666 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, RestrictionDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 670 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, RestrictionDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\RestrictionDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */