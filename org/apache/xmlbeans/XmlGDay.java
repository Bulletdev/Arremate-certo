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
/*     */ public interface XmlGDay
/*     */   extends XmlAnySimpleType
/*     */ {
/*  37 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_gDay");
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
/*     */   int getIntValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void setIntValue(int paramInt);
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
/*     */   int intValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void set(int paramInt);
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlGDay newInstance() {
/*  91 */       return (XmlGDay)XmlBeans.getContextTypeLoader().newInstance(XmlGDay.type, null);
/*     */     }
/*     */     
/*     */     public static XmlGDay newInstance(XmlOptions param1XmlOptions) {
/*  95 */       return (XmlGDay)XmlBeans.getContextTypeLoader().newInstance(XmlGDay.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGDay newValue(Object param1Object) {
/*  99 */       return (XmlGDay)XmlGDay.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlGDay parse(String param1String) throws XmlException {
/* 103 */       return (XmlGDay)XmlBeans.getContextTypeLoader().parse(param1String, XmlGDay.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGDay parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 107 */       return (XmlGDay)XmlBeans.getContextTypeLoader().parse(param1String, XmlGDay.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGDay parse(File param1File) throws XmlException, IOException {
/* 111 */       return (XmlGDay)XmlBeans.getContextTypeLoader().parse(param1File, XmlGDay.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGDay parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 115 */       return (XmlGDay)XmlBeans.getContextTypeLoader().parse(param1File, XmlGDay.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGDay parse(URL param1URL) throws XmlException, IOException {
/* 119 */       return (XmlGDay)XmlBeans.getContextTypeLoader().parse(param1URL, XmlGDay.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGDay parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 123 */       return (XmlGDay)XmlBeans.getContextTypeLoader().parse(param1URL, XmlGDay.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGDay parse(InputStream param1InputStream) throws XmlException, IOException {
/* 127 */       return (XmlGDay)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlGDay.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGDay parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 131 */       return (XmlGDay)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlGDay.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGDay parse(Reader param1Reader) throws XmlException, IOException {
/* 135 */       return (XmlGDay)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlGDay.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGDay parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 139 */       return (XmlGDay)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlGDay.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGDay parse(Node param1Node) throws XmlException {
/* 143 */       return (XmlGDay)XmlBeans.getContextTypeLoader().parse(param1Node, XmlGDay.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGDay parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 147 */       return (XmlGDay)XmlBeans.getContextTypeLoader().parse(param1Node, XmlGDay.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlGDay parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 153 */       return (XmlGDay)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlGDay.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlGDay parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 159 */       return (XmlGDay)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlGDay.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGDay parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 163 */       return (XmlGDay)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlGDay.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGDay parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 167 */       return (XmlGDay)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlGDay.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 173 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlGDay.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 179 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlGDay.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlGDay.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */