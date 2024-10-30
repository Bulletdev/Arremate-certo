/*    */ package org.apache.poi.xdgf.exceptions;
/*    */ 
/*    */ import org.apache.poi.POIXMLDocumentPart;
/*    */ import org.apache.poi.POIXMLException;
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
/*    */ public class XDGFException
/*    */ {
/*    */   public static POIXMLException error(String paramString, Object paramObject) {
/* 29 */     return new POIXMLException(paramObject.toString() + ": " + paramString);
/*    */   }
/*    */   
/*    */   public static POIXMLException error(String paramString, Object paramObject, Throwable paramThrowable) {
/* 33 */     return new POIXMLException(paramObject.toString() + ": " + paramString, paramThrowable);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static POIXMLException wrap(POIXMLDocumentPart paramPOIXMLDocumentPart, POIXMLException paramPOIXMLException) {
/* 43 */     return new POIXMLException(paramPOIXMLDocumentPart.getPackagePart().getPartName().toString() + ": " + paramPOIXMLException.getMessage(), (paramPOIXMLException.getCause() == null) ? (Throwable)paramPOIXMLException : paramPOIXMLException.getCause());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static POIXMLException wrap(String paramString, POIXMLException paramPOIXMLException) {
/* 50 */     return new POIXMLException(paramString + ": " + paramPOIXMLException.getMessage(), (paramPOIXMLException.getCause() == null) ? (Throwable)paramPOIXMLException : paramPOIXMLException.getCause());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdgf\exceptions\XDGFException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */