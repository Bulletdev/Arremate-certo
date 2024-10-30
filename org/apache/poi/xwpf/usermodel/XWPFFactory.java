/*    */ package org.apache.poi.xwpf.usermodel;
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
/*    */ public final class XWPFFactory
/*    */   extends POIXMLFactory
/*    */ {
/* 35 */   private static final XWPFFactory inst = new XWPFFactory();
/*    */   
/*    */   public static XWPFFactory getInstance() {
/* 38 */     return inst;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected POIXMLRelation getDescriptor(String paramString) {
/* 46 */     return XWPFRelation.getInstance(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected POIXMLDocumentPart createDocumentPart(Class<? extends POIXMLDocumentPart> paramClass, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) throws SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
/* 56 */     Constructor<? extends POIXMLDocumentPart> constructor = paramClass.getDeclaredConstructor(paramArrayOfClass);
/* 57 */     return constructor.newInstance(paramArrayOfObject);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */