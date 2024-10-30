/*    */ package org.apache.xmlbeans.impl.schema;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlAnySimpleType;
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
/*    */ public class XmlValueRef
/*    */ {
/*    */   XmlAnySimpleType _obj;
/*    */   SchemaType.Ref _typeref;
/*    */   Object _initVal;
/*    */   
/*    */   public XmlValueRef(XmlAnySimpleType paramXmlAnySimpleType) {
/* 34 */     if (paramXmlAnySimpleType == null)
/* 35 */       throw new IllegalArgumentException(); 
/* 36 */     this._obj = paramXmlAnySimpleType;
/*    */   }
/*    */ 
/*    */   
/*    */   XmlValueRef(SchemaType.Ref paramRef, Object paramObject) {
/* 41 */     if (paramRef == null)
/* 42 */       throw new IllegalArgumentException(); 
/* 43 */     this._typeref = paramRef;
/* 44 */     this._initVal = paramObject;
/*    */   }
/*    */ 
/*    */   
/*    */   synchronized XmlAnySimpleType get() {
/* 49 */     if (this._obj == null) {
/*    */       
/* 51 */       SchemaType schemaType = this._typeref.get();
/* 52 */       if (schemaType.getSimpleVariety() != 3) {
/* 53 */         this._obj = schemaType.newValue(this._initVal);
/*    */       } else {
/*    */         
/* 56 */         ArrayList arrayList = new ArrayList();
/* 57 */         for (XmlValueRef xmlValueRef : this._initVal)
/*    */         {
/*    */           
/* 60 */           arrayList.add(xmlValueRef.get());
/*    */         }
/* 62 */         this._obj = schemaType.newValue(arrayList);
/*    */       } 
/*    */     } 
/* 65 */     return this._obj;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\XmlValueRef.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */