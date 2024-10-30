/*    */ package org.apache.poi.xdgf.util;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.poi.POIXMLException;
/*    */ import org.apache.xmlbeans.XmlObject;
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
/*    */ public class ObjectFactory<T, X extends XmlObject>
/*    */ {
/* 31 */   Map<String, Constructor<? extends T>> _types = new HashMap<String, Constructor<? extends T>>();
/*    */   
/*    */   public void put(String paramString, Class<? extends T> paramClass, Class<?>... paramVarArgs) throws NoSuchMethodException, SecurityException {
/* 34 */     this._types.put(paramString, paramClass.getDeclaredConstructor(paramVarArgs));
/*    */   }
/*    */   
/*    */   public T load(String paramString, Object... paramVarArgs) {
/* 38 */     Constructor<T> constructor = (Constructor)this._types.get(paramString);
/* 39 */     if (constructor == null) {
/*    */ 
/*    */       
/* 42 */       XmlObject xmlObject = (XmlObject)paramVarArgs[0];
/*    */       
/* 44 */       String str = xmlObject.schemaType().getName().dT();
/* 45 */       throw new POIXMLException("Invalid '" + str + "' name '" + paramString + "'");
/*    */     } 
/*    */     
/*    */     try {
/* 49 */       return constructor.newInstance(paramVarArgs);
/* 50 */     } catch (InvocationTargetException invocationTargetException) {
/* 51 */       throw new POIXMLException(invocationTargetException.getCause());
/* 52 */     } catch (Exception exception) {
/* 53 */       throw new POIXMLException(exception);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\util\ObjectFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */