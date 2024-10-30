/*     */ package ch.qos.logback.core.joran.event.stax;
/*     */ 
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.joran.spi.ElementPath;
/*     */ import ch.qos.logback.core.joran.spi.JoranException;
/*     */ import ch.qos.logback.core.spi.ContextAwareBase;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.stream.XMLEventReader;
/*     */ import javax.xml.stream.XMLInputFactory;
/*     */ import javax.xml.stream.XMLStreamException;
/*     */ import javax.xml.stream.events.Characters;
/*     */ import javax.xml.stream.events.EndElement;
/*     */ import javax.xml.stream.events.StartElement;
/*     */ import javax.xml.stream.events.XMLEvent;
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
/*     */ public class StaxEventRecorder
/*     */   extends ContextAwareBase
/*     */ {
/*  34 */   List<StaxEvent> eventList = new ArrayList<StaxEvent>();
/*  35 */   ElementPath globalElementPath = new ElementPath();
/*     */   
/*     */   public StaxEventRecorder(Context paramContext) {
/*  38 */     setContext(paramContext);
/*     */   }
/*     */   
/*     */   public void recordEvents(InputStream paramInputStream) throws JoranException {
/*     */     try {
/*  43 */       XMLEventReader xMLEventReader = XMLInputFactory.newInstance().createXMLEventReader(paramInputStream);
/*  44 */       read(xMLEventReader);
/*  45 */     } catch (XMLStreamException xMLStreamException) {
/*  46 */       throw new JoranException("Problem parsing XML document. See previously reported errors.", xMLStreamException);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<StaxEvent> getEventList() {
/*  51 */     return this.eventList;
/*     */   }
/*     */   
/*     */   private void read(XMLEventReader paramXMLEventReader) throws XMLStreamException {
/*  55 */     while (paramXMLEventReader.hasNext()) {
/*  56 */       XMLEvent xMLEvent = paramXMLEventReader.nextEvent();
/*  57 */       switch (xMLEvent.getEventType()) {
/*     */         case 1:
/*  59 */           addStartElement(xMLEvent);
/*     */         
/*     */         case 4:
/*  62 */           addCharacters(xMLEvent);
/*     */         
/*     */         case 2:
/*  65 */           addEndEvent(xMLEvent);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addStartElement(XMLEvent paramXMLEvent) {
/*  74 */     StartElement startElement = paramXMLEvent.asStartElement();
/*  75 */     String str = startElement.getName().dT();
/*  76 */     this.globalElementPath.push(str);
/*  77 */     ElementPath elementPath = this.globalElementPath.duplicate();
/*  78 */     StartEvent startEvent = new StartEvent(elementPath, str, startElement.getAttributes(), startElement.getLocation());
/*  79 */     this.eventList.add(startEvent);
/*     */   }
/*     */   
/*     */   private void addCharacters(XMLEvent paramXMLEvent) {
/*  83 */     Characters characters = paramXMLEvent.asCharacters();
/*  84 */     StaxEvent staxEvent = getLastEvent();
/*     */     
/*  86 */     if (staxEvent instanceof BodyEvent) {
/*  87 */       BodyEvent bodyEvent = (BodyEvent)staxEvent;
/*  88 */       bodyEvent.append(characters.getData());
/*     */     
/*     */     }
/*  91 */     else if (!characters.isWhiteSpace()) {
/*  92 */       BodyEvent bodyEvent = new BodyEvent(characters.getData(), paramXMLEvent.getLocation());
/*  93 */       this.eventList.add(bodyEvent);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void addEndEvent(XMLEvent paramXMLEvent) {
/*  99 */     EndElement endElement = paramXMLEvent.asEndElement();
/* 100 */     String str = endElement.getName().dT();
/* 101 */     EndEvent endEvent = new EndEvent(str, endElement.getLocation());
/* 102 */     this.eventList.add(endEvent);
/* 103 */     this.globalElementPath.pop();
/*     */   }
/*     */   
/*     */   StaxEvent getLastEvent() {
/* 107 */     if (this.eventList.isEmpty()) {
/* 108 */       return null;
/*     */     }
/* 110 */     int i = this.eventList.size();
/* 111 */     if (i == 0)
/* 112 */       return null; 
/* 113 */     return this.eventList.get(i - 1);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\event\stax\StaxEventRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */