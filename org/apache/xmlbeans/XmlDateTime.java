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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface XmlDateTime
/*     */   extends XmlAnySimpleType
/*     */ {
/*  41 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_dateTime");
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
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlDateTime newInstance() {
/*  95 */       return (XmlDateTime)XmlBeans.getContextTypeLoader().newInstance(XmlDateTime.type, null);
/*     */     }
/*     */     
/*     */     public static XmlDateTime newInstance(XmlOptions param1XmlOptions) {
/*  99 */       return (XmlDateTime)XmlBeans.getContextTypeLoader().newInstance(XmlDateTime.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDateTime newValue(Object param1Object) {
/* 103 */       return (XmlDateTime)XmlDateTime.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlDateTime parse(String param1String) throws XmlException {
/* 107 */       return (XmlDateTime)XmlBeans.getContextTypeLoader().parse(param1String, XmlDateTime.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDateTime parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 111 */       return (XmlDateTime)XmlBeans.getContextTypeLoader().parse(param1String, XmlDateTime.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDateTime parse(File param1File) throws XmlException, IOException {
/* 115 */       return (XmlDateTime)XmlBeans.getContextTypeLoader().parse(param1File, XmlDateTime.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDateTime parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 119 */       return (XmlDateTime)XmlBeans.getContextTypeLoader().parse(param1File, XmlDateTime.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDateTime parse(URL param1URL) throws XmlException, IOException {
/* 123 */       return (XmlDateTime)XmlBeans.getContextTypeLoader().parse(param1URL, XmlDateTime.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDateTime parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 127 */       return (XmlDateTime)XmlBeans.getContextTypeLoader().parse(param1URL, XmlDateTime.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDateTime parse(InputStream param1InputStream) throws XmlException, IOException {
/* 131 */       return (XmlDateTime)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlDateTime.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDateTime parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 135 */       return (XmlDateTime)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlDateTime.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDateTime parse(Reader param1Reader) throws XmlException, IOException {
/* 139 */       return (XmlDateTime)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlDateTime.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDateTime parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 143 */       return (XmlDateTime)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlDateTime.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDateTime parse(Node param1Node) throws XmlException {
/* 147 */       return (XmlDateTime)XmlBeans.getContextTypeLoader().parse(param1Node, XmlDateTime.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDateTime parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 151 */       return (XmlDateTime)XmlBeans.getContextTypeLoader().parse(param1Node, XmlDateTime.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlDateTime parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 157 */       return (XmlDateTime)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlDateTime.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlDateTime parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 163 */       return (XmlDateTime)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlDateTime.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlDateTime parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 167 */       return (XmlDateTime)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlDateTime.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlDateTime parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 171 */       return (XmlDateTime)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlDateTime.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 177 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlDateTime.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 183 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlDateTime.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlDateTime.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */