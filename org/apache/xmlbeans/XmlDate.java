/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface XmlDate
/*     */   extends XmlAnySimpleType
/*     */ {
/*  37 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_date");
/*     */ 
/*     */ 
/*     */   
/*     */   Calendar calendarValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void set(Calendar paramCalendar);
/*     */ 
/*     */ 
/*     */   
/*     */   GDate gDateValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void set(GDateSpecification paramGDateSpecification);
/*     */ 
/*     */ 
/*     */   
/*     */   Date dateValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void set(Date paramDate);
/*     */ 
/*     */ 
/*     */   
/*     */   Calendar getCalendarValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void setCalendarValue(Calendar paramCalendar);
/*     */ 
/*     */ 
/*     */   
/*     */   GDate getGDateValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void setGDateValue(GDate paramGDate);
/*     */ 
/*     */ 
/*     */   
/*     */   Date getDateValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void setDateValue(Date paramDate);
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlDate newInstance() {
/*  92 */       return (XmlDate)XmlBeans.getContextTypeLoader().newInstance(XmlDate.type, null);
/*     */     }
/*     */     
/*     */     public static XmlDate newInstance(XmlOptions param1XmlOptions) {
/*  96 */       return (XmlDate)XmlBeans.getContextTypeLoader().newInstance(XmlDate.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDate newValue(Object param1Object) {
/* 100 */       return (XmlDate)XmlDate.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlDate parse(String param1String) throws XmlException {
/* 104 */       return (XmlDate)XmlBeans.getContextTypeLoader().parse(param1String, XmlDate.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDate parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 108 */       return (XmlDate)XmlBeans.getContextTypeLoader().parse(param1String, XmlDate.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDate parse(File param1File) throws XmlException, IOException {
/* 112 */       return (XmlDate)XmlBeans.getContextTypeLoader().parse(param1File, XmlDate.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDate parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 116 */       return (XmlDate)XmlBeans.getContextTypeLoader().parse(param1File, XmlDate.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDate parse(URL param1URL) throws XmlException, IOException {
/* 120 */       return (XmlDate)XmlBeans.getContextTypeLoader().parse(param1URL, XmlDate.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDate parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 124 */       return (XmlDate)XmlBeans.getContextTypeLoader().parse(param1URL, XmlDate.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDate parse(InputStream param1InputStream) throws XmlException, IOException {
/* 128 */       return (XmlDate)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlDate.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDate parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 132 */       return (XmlDate)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlDate.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDate parse(Reader param1Reader) throws XmlException, IOException {
/* 136 */       return (XmlDate)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlDate.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDate parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 140 */       return (XmlDate)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlDate.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDate parse(Node param1Node) throws XmlException {
/* 144 */       return (XmlDate)XmlBeans.getContextTypeLoader().parse(param1Node, XmlDate.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDate parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 148 */       return (XmlDate)XmlBeans.getContextTypeLoader().parse(param1Node, XmlDate.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlDate parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 154 */       return (XmlDate)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlDate.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlDate parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 160 */       return (XmlDate)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlDate.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDate parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 164 */       return (XmlDate)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlDate.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDate parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 168 */       return (XmlDate)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlDate.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 174 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlDate.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 180 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlDate.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlDate.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */