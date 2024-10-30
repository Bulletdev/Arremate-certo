/*    */ package org.apache.poi.xslf.usermodel;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class XSLFFactory
/*    */   extends POIXMLFactory
/*    */ {
/* 37 */   private static final XSLFFactory inst = new XSLFFactory();
/*    */   
/*    */   public static XSLFFactory getInstance() {
/* 40 */     return inst;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected POIXMLRelation getDescriptor(String paramString) {
/* 48 */     return XSLFRelation.getInstance(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected POIXMLDocumentPart createDocumentPart(Class<? extends POIXMLDocumentPart> paramClass, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) throws SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
/* 58 */     Constructor<? extends POIXMLDocumentPart> constructor = paramClass.getDeclaredConstructor(paramArrayOfClass);
/* 59 */     return constructor.newInstance(paramArrayOfObject);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */