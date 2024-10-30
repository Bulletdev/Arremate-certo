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
/*     */ 
/*     */ public interface XmlGYearMonth
/*     */   extends XmlAnySimpleType
/*     */ {
/*  38 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_gYearMonth");
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
/*     */     public static XmlGYearMonth newInstance() {
/*  78 */       return (XmlGYearMonth)XmlBeans.getContextTypeLoader().newInstance(XmlGYearMonth.type, null);
/*     */     }
/*     */     
/*     */     public static XmlGYearMonth newInstance(XmlOptions param1XmlOptions) {
/*  82 */       return (XmlGYearMonth)XmlBeans.getContextTypeLoader().newInstance(XmlGYearMonth.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGYearMonth newValue(Object param1Object) {
/*  86 */       return (XmlGYearMonth)XmlGYearMonth.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlGYearMonth parse(String param1String) throws XmlException {
/*  90 */       return (XmlGYearMonth)XmlBeans.getContextTypeLoader().parse(param1String, XmlGYearMonth.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGYearMonth parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  94 */       return (XmlGYearMonth)XmlBeans.getContextTypeLoader().parse(param1String, XmlGYearMonth.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGYearMonth parse(File param1File) throws XmlException, IOException {
/*  98 */       return (XmlGYearMonth)XmlBeans.getContextTypeLoader().parse(param1File, XmlGYearMonth.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGYearMonth parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 102 */       return (XmlGYearMonth)XmlBeans.getContextTypeLoader().parse(param1File, XmlGYearMonth.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGYearMonth parse(URL param1URL) throws XmlException, IOException {
/* 106 */       return (XmlGYearMonth)XmlBeans.getContextTypeLoader().parse(param1URL, XmlGYearMonth.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGYearMonth parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 110 */       return (XmlGYearMonth)XmlBeans.getContextTypeLoader().parse(param1URL, XmlGYearMonth.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGYearMonth parse(InputStream param1InputStream) throws XmlException, IOException {
/* 114 */       return (XmlGYearMonth)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlGYearMonth.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGYearMonth parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 118 */       return (XmlGYearMonth)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlGYearMonth.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGYearMonth parse(Reader param1Reader) throws XmlException, IOException {
/* 122 */       return (XmlGYearMonth)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlGYearMonth.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGYearMonth parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 126 */       return (XmlGYearMonth)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlGYearMonth.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGYearMonth parse(Node param1Node) throws XmlException {
/* 130 */       return (XmlGYearMonth)XmlBeans.getContextTypeLoader().parse(param1Node, XmlGYearMonth.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGYearMonth parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 134 */       return (XmlGYearMonth)XmlBeans.getContextTypeLoader().parse(param1Node, XmlGYearMonth.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlGYearMonth parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 140 */       return (XmlGYearMonth)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlGYearMonth.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlGYearMonth parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 146 */       return (XmlGYearMonth)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlGYearMonth.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGYearMonth parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 150 */       return (XmlGYearMonth)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlGYearMonth.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGYearMonth parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 154 */       return (XmlGYearMonth)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlGYearMonth.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 160 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlGYearMonth.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 166 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlGYearMonth.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlGYearMonth.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */