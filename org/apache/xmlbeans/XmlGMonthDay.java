/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import java.util.Calendar;
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
/*     */ public interface XmlGMonthDay
/*     */   extends XmlAnySimpleType
/*     */ {
/*  37 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_gMonthDay");
/*     */ 
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
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlGMonthDay newInstance() {
/*  77 */       return (XmlGMonthDay)XmlBeans.getContextTypeLoader().newInstance(XmlGMonthDay.type, null);
/*     */     }
/*     */     
/*     */     public static XmlGMonthDay newInstance(XmlOptions param1XmlOptions) {
/*  81 */       return (XmlGMonthDay)XmlBeans.getContextTypeLoader().newInstance(XmlGMonthDay.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGMonthDay newValue(Object param1Object) {
/*  85 */       return (XmlGMonthDay)XmlGMonthDay.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlGMonthDay parse(String param1String) throws XmlException {
/*  89 */       return (XmlGMonthDay)XmlBeans.getContextTypeLoader().parse(param1String, XmlGMonthDay.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGMonthDay parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  93 */       return (XmlGMonthDay)XmlBeans.getContextTypeLoader().parse(param1String, XmlGMonthDay.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGMonthDay parse(File param1File) throws XmlException, IOException {
/*  97 */       return (XmlGMonthDay)XmlBeans.getContextTypeLoader().parse(param1File, XmlGMonthDay.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGMonthDay parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 101 */       return (XmlGMonthDay)XmlBeans.getContextTypeLoader().parse(param1File, XmlGMonthDay.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGMonthDay parse(URL param1URL) throws XmlException, IOException {
/* 105 */       return (XmlGMonthDay)XmlBeans.getContextTypeLoader().parse(param1URL, XmlGMonthDay.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGMonthDay parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 109 */       return (XmlGMonthDay)XmlBeans.getContextTypeLoader().parse(param1URL, XmlGMonthDay.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGMonthDay parse(InputStream param1InputStream) throws XmlException, IOException {
/* 113 */       return (XmlGMonthDay)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlGMonthDay.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGMonthDay parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 117 */       return (XmlGMonthDay)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlGMonthDay.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGMonthDay parse(Reader param1Reader) throws XmlException, IOException {
/* 121 */       return (XmlGMonthDay)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlGMonthDay.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGMonthDay parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 125 */       return (XmlGMonthDay)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlGMonthDay.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGMonthDay parse(Node param1Node) throws XmlException {
/* 129 */       return (XmlGMonthDay)XmlBeans.getContextTypeLoader().parse(param1Node, XmlGMonthDay.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGMonthDay parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 133 */       return (XmlGMonthDay)XmlBeans.getContextTypeLoader().parse(param1Node, XmlGMonthDay.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlGMonthDay parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 139 */       return (XmlGMonthDay)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlGMonthDay.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlGMonthDay parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 145 */       return (XmlGMonthDay)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlGMonthDay.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGMonthDay parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 149 */       return (XmlGMonthDay)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlGMonthDay.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGMonthDay parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 153 */       return (XmlGMonthDay)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlGMonthDay.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 159 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlGMonthDay.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 165 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlGMonthDay.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlGMonthDay.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */