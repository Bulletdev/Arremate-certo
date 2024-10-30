/*    */ package org.apache.poi.xssf.usermodel;
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
/*    */ 
/*    */ 
/*    */ public final class XSSFFactory
/*    */   extends POIXMLFactory
/*    */ {
/* 34 */   private static final XSSFFactory inst = new XSSFFactory();
/*    */   
/*    */   public static XSSFFactory getInstance() {
/* 37 */     return inst;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected POIXMLRelation getDescriptor(String paramString) {
/* 45 */     return XSSFRelation.getInstance(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected POIXMLDocumentPart createDocumentPart(Class<? extends POIXMLDocumentPart> paramClass, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) throws SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
/* 55 */     Constructor<? extends POIXMLDocumentPart> constructor = paramClass.getDeclaredConstructor(paramArrayOfClass);
/* 56 */     return constructor.newInstance(paramArrayOfObject);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */