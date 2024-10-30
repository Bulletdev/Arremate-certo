/*     */ package org.apache.poi.sl.draw.geom;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.util.LinkedHashMap;
/*     */ import javax.xml.bind.JAXBContext;
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import javax.xml.bind.JAXBException;
/*     */ import javax.xml.bind.Unmarshaller;
/*     */ import javax.xml.stream.EventFilter;
/*     */ import javax.xml.stream.XMLEventReader;
/*     */ import javax.xml.stream.XMLInputFactory;
/*     */ import javax.xml.stream.XMLStreamException;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import javax.xml.stream.events.StartElement;
/*     */ import javax.xml.stream.events.XMLEvent;
/*     */ import org.apache.poi.sl.draw.binding.CTCustomGeometry2D;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
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
/*     */ public class PresetGeometries
/*     */   extends LinkedHashMap<String, CustomGeometry>
/*     */ {
/*  45 */   private static final POILogger LOG = POILogFactory.getLogger(PresetGeometries.class);
/*     */ 
/*     */   
/*     */   protected static final String BINDING_PACKAGE = "org.apache.poi.sl.draw.binding";
/*     */ 
/*     */   
/*     */   protected static PresetGeometries _inst;
/*     */ 
/*     */   
/*     */   public void init(InputStream paramInputStream) throws XMLStreamException, JAXBException {
/*  55 */     EventFilter eventFilter = new EventFilter()
/*     */       {
/*     */         public boolean accept(XMLEvent param1XMLEvent) {
/*  58 */           return param1XMLEvent.isStartElement();
/*     */         }
/*     */       };
/*     */     
/*  62 */     XMLInputFactory xMLInputFactory = XMLInputFactory.newFactory();
/*  63 */     XMLEventReader xMLEventReader1 = xMLInputFactory.createXMLEventReader(paramInputStream);
/*  64 */     XMLEventReader xMLEventReader2 = xMLInputFactory.createFilteredReader(xMLEventReader1, eventFilter);
/*     */     
/*  66 */     xMLEventReader2.nextEvent();
/*     */     
/*  68 */     JAXBContext jAXBContext = JAXBContext.newInstance("org.apache.poi.sl.draw.binding");
/*  69 */     Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
/*     */     
/*  71 */     long l = 0L;
/*  72 */     while (xMLEventReader2.peek() != null) {
/*  73 */       StartElement startElement = (StartElement)xMLEventReader2.peek();
/*  74 */       String str = startElement.getName().dT();
/*  75 */       JAXBElement<CTCustomGeometry2D> jAXBElement = unmarshaller.unmarshal(xMLEventReader1, CTCustomGeometry2D.class);
/*  76 */       CTCustomGeometry2D cTCustomGeometry2D = jAXBElement.getValue();
/*  77 */       l++;
/*     */       
/*  79 */       if (containsKey(str)) {
/*  80 */         LOG.log(5, new Object[] { "Duplicate definition of " + str });
/*     */       }
/*  82 */       put(str, new CustomGeometry(cTCustomGeometry2D));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CustomGeometry convertCustomGeometry(XMLStreamReader paramXMLStreamReader) {
/*     */     try {
/*  91 */       JAXBContext jAXBContext = JAXBContext.newInstance("org.apache.poi.sl.draw.binding");
/*  92 */       Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
/*  93 */       JAXBElement<CTCustomGeometry2D> jAXBElement = unmarshaller.unmarshal(paramXMLStreamReader, CTCustomGeometry2D.class);
/*  94 */       return new CustomGeometry(jAXBElement.getValue());
/*  95 */     } catch (JAXBException jAXBException) {
/*  96 */       LOG.log(7, new Object[] { "Unable to parse single custom geometry", jAXBException });
/*  97 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static synchronized PresetGeometries getInstance() {
/* 102 */     if (_inst == null) {
/*     */ 
/*     */       
/* 105 */       PresetGeometries presetGeometries = new PresetGeometries();
/*     */       try {
/* 107 */         InputStream inputStream = PresetGeometries.class.getResourceAsStream("presetShapeDefinitions.xml");
/*     */         
/*     */         try {
/* 110 */           presetGeometries.init(inputStream);
/*     */         } finally {
/* 112 */           inputStream.close();
/*     */         } 
/* 114 */       } catch (Exception exception) {
/* 115 */         throw new RuntimeException(exception);
/*     */       } 
/* 117 */       _inst = presetGeometries;
/*     */     } 
/*     */     
/* 120 */     return _inst;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\PresetGeometries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */