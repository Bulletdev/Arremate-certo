/*    */ package org.apache.xmlbeans.impl.common;
/*    */ 
/*    */ import javax.xml.stream.Location;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InvalidLexicalValueException
/*    */   extends RuntimeException
/*    */ {
/*    */   private Location _location;
/*    */   
/*    */   public InvalidLexicalValueException() {}
/*    */   
/*    */   public InvalidLexicalValueException(String paramString) {
/* 36 */     super(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public InvalidLexicalValueException(String paramString, Throwable paramThrowable) {
/* 41 */     super(paramString, paramThrowable);
/*    */   }
/*    */ 
/*    */   
/*    */   public InvalidLexicalValueException(Throwable paramThrowable) {
/* 46 */     super(paramThrowable);
/*    */   }
/*    */ 
/*    */   
/*    */   public InvalidLexicalValueException(String paramString, Location paramLocation) {
/* 51 */     super(paramString);
/* 52 */     setLocation(paramLocation);
/*    */   }
/*    */ 
/*    */   
/*    */   public InvalidLexicalValueException(String paramString, Throwable paramThrowable, Location paramLocation) {
/* 57 */     super(paramString, paramThrowable);
/* 58 */     setLocation(paramLocation);
/*    */   }
/*    */ 
/*    */   
/*    */   public InvalidLexicalValueException(Throwable paramThrowable, Location paramLocation) {
/* 63 */     super(paramThrowable);
/* 64 */     setLocation(paramLocation);
/*    */   }
/*    */ 
/*    */   
/*    */   public Location getLocation() {
/* 69 */     return this._location;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setLocation(Location paramLocation) {
/* 74 */     this._location = paramLocation;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\InvalidLexicalValueException.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */