/*    */ package javax.xml.stream;
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
/*    */ 
/*    */ 
/*    */ public class XMLStreamException
/*    */   extends Exception
/*    */ {
/*    */   protected Throwable nested;
/*    */   protected Location location;
/*    */   
/*    */   public XMLStreamException() {}
/*    */   
/*    */   public XMLStreamException(String paramString) {
/* 28 */     super(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public XMLStreamException(Throwable paramThrowable) {
/* 37 */     this.nested = paramThrowable;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public XMLStreamException(String paramString, Throwable paramThrowable) {
/* 47 */     super(paramString);
/* 48 */     this.nested = paramThrowable;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public XMLStreamException(String paramString, Location paramLocation, Throwable paramThrowable) {
/* 59 */     super("ParseError at [row,col]:[" + paramLocation.getLineNumber() + "," + paramLocation.getColumnNumber() + "]\n" + "Message: " + paramString);
/*    */ 
/*    */     
/* 62 */     this.nested = paramThrowable;
/* 63 */     this.location = paramLocation;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public XMLStreamException(String paramString, Location paramLocation) {
/* 74 */     super("ParseError at [row,col]:[" + paramLocation.getLineNumber() + "," + paramLocation.getColumnNumber() + "]\n" + "Message: " + paramString);
/*    */ 
/*    */     
/* 77 */     this.location = paramLocation;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Throwable getNestedException() {
/* 87 */     return this.nested;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Location getLocation() {
/* 96 */     return this.location;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\javax\xml\stream\XMLStreamException.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */