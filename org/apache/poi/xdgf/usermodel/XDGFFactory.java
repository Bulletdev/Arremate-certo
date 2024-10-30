/*    */ package org.apache.poi.xdgf.usermodel;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ import org.apache.poi.POIXMLDocumentPart;
/*    */ import org.apache.poi.POIXMLFactory;
/*    */ import org.apache.poi.POIXMLRelation;
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
/*    */ public class XDGFFactory
/*    */   extends POIXMLFactory
/*    */ {
/*    */   private final XDGFDocument document;
/*    */   
/*    */   public XDGFFactory(XDGFDocument paramXDGFDocument) {
/* 35 */     this.document = paramXDGFDocument;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected POIXMLRelation getDescriptor(String paramString) {
/* 42 */     return XDGFRelation.getInstance(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected POIXMLDocumentPart createDocumentPart(Class<? extends POIXMLDocumentPart> paramClass, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) throws SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
/*    */     Class[] arrayOfClass;
/*    */     Object[] arrayOfObject;
/* 54 */     if (paramArrayOfClass == null) {
/* 55 */       arrayOfClass = new Class[] { XDGFDocument.class };
/* 56 */       arrayOfObject = new Object[] { this.document };
/*    */     } else {
/* 58 */       arrayOfClass = new Class[paramArrayOfClass.length + 1];
/* 59 */       System.arraycopy(paramArrayOfClass, 0, arrayOfClass, 0, paramArrayOfClass.length);
/* 60 */       arrayOfClass[paramArrayOfClass.length] = XDGFDocument.class;
/* 61 */       arrayOfObject = new Object[paramArrayOfObject.length + 1];
/* 62 */       System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramArrayOfObject.length);
/* 63 */       arrayOfObject[paramArrayOfObject.length] = this.document;
/*    */     } 
/*    */     
/* 66 */     Constructor<? extends POIXMLDocumentPart> constructor = paramClass.getDeclaredConstructor(arrayOfClass);
/* 67 */     return constructor.newInstance(arrayOfObject);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\XDGFFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */