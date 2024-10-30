/*    */ package javax.xml.stream;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import javax.xml.namespace.a;
/*    */ import javax.xml.namespace.b;
/*    */ import javax.xml.stream.events.Attribute;
/*    */ import javax.xml.stream.events.Characters;
/*    */ import javax.xml.stream.events.Comment;
/*    */ import javax.xml.stream.events.DTD;
/*    */ import javax.xml.stream.events.EndDocument;
/*    */ import javax.xml.stream.events.EndElement;
/*    */ import javax.xml.stream.events.EntityDeclaration;
/*    */ import javax.xml.stream.events.EntityReference;
/*    */ import javax.xml.stream.events.Namespace;
/*    */ import javax.xml.stream.events.ProcessingInstruction;
/*    */ import javax.xml.stream.events.StartDocument;
/*    */ import javax.xml.stream.events.StartElement;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class XMLEventFactory
/*    */ {
/*    */   public static XMLEventFactory newInstance() throws FactoryConfigurationError {
/* 30 */     return (XMLEventFactory)FactoryFinder.find("javax.xml.stream.XMLEventFactory", "com.bea.xml.stream.EventFactory");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static XMLEventFactory newInstance(String paramString, ClassLoader paramClassLoader) throws FactoryConfigurationError {
/* 48 */     return (XMLEventFactory)FactoryFinder.find(paramString, "com.bea.xml.stream.EventFactory", paramClassLoader);
/*    */   }
/*    */   
/*    */   public abstract void setLocation(Location paramLocation);
/*    */   
/*    */   public abstract Attribute createAttribute(String paramString1, String paramString2, String paramString3, String paramString4);
/*    */   
/*    */   public abstract Attribute createAttribute(String paramString1, String paramString2);
/*    */   
/*    */   public abstract Attribute createAttribute(b paramb, String paramString);
/*    */   
/*    */   public abstract Namespace createNamespace(String paramString);
/*    */   
/*    */   public abstract Namespace createNamespace(String paramString1, String paramString2);
/*    */   
/*    */   public abstract StartElement createStartElement(b paramb, Iterator paramIterator1, Iterator paramIterator2);
/*    */   
/*    */   public abstract StartElement createStartElement(String paramString1, String paramString2, String paramString3);
/*    */   
/*    */   public abstract StartElement createStartElement(String paramString1, String paramString2, String paramString3, Iterator paramIterator1, Iterator paramIterator2);
/*    */   
/*    */   public abstract StartElement createStartElement(String paramString1, String paramString2, String paramString3, Iterator paramIterator1, Iterator paramIterator2, a parama);
/*    */   
/*    */   public abstract EndElement createEndElement(b paramb, Iterator paramIterator);
/*    */   
/*    */   public abstract EndElement createEndElement(String paramString1, String paramString2, String paramString3);
/*    */   
/*    */   public abstract EndElement createEndElement(String paramString1, String paramString2, String paramString3, Iterator paramIterator);
/*    */   
/*    */   public abstract Characters createCharacters(String paramString);
/*    */   
/*    */   public abstract Characters createCData(String paramString);
/*    */   
/*    */   public abstract Characters createSpace(String paramString);
/*    */   
/*    */   public abstract Characters createIgnorableSpace(String paramString);
/*    */   
/*    */   public abstract StartDocument createStartDocument();
/*    */   
/*    */   public abstract StartDocument createStartDocument(String paramString1, String paramString2, boolean paramBoolean);
/*    */   
/*    */   public abstract StartDocument createStartDocument(String paramString1, String paramString2);
/*    */   
/*    */   public abstract StartDocument createStartDocument(String paramString);
/*    */   
/*    */   public abstract EndDocument createEndDocument();
/*    */   
/*    */   public abstract EntityReference createEntityReference(String paramString, EntityDeclaration paramEntityDeclaration);
/*    */   
/*    */   public abstract Comment createComment(String paramString);
/*    */   
/*    */   public abstract ProcessingInstruction createProcessingInstruction(String paramString1, String paramString2);
/*    */   
/*    */   public abstract DTD createDTD(String paramString);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\javax\xml\stream\XMLEventFactory.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */