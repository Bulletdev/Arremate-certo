/*    */ package org.h2.mvstore;
/*    */ 
/*    */ import org.h2.mvstore.type.DataType;
/*    */ import org.h2.mvstore.type.ObjectDataType;
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
/*    */ public class MVMapConcurrent<K, V>
/*    */   extends MVMap<K, V>
/*    */ {
/*    */   public MVMapConcurrent(DataType paramDataType1, DataType paramDataType2) {
/* 20 */     super(paramDataType1, paramDataType2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Builder<K, V>
/*    */     implements MVMap.MapBuilder<MVMapConcurrent<K, V>, K, V>
/*    */   {
/*    */     protected DataType keyType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     protected DataType valueType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public Builder<K, V> keyType(DataType param1DataType) {
/* 49 */       this.keyType = param1DataType;
/* 50 */       return this;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public Builder<K, V> valueType(DataType param1DataType) {
/* 60 */       this.valueType = param1DataType;
/* 61 */       return this;
/*    */     }
/*    */ 
/*    */     
/*    */     public MVMapConcurrent<K, V> create() {
/* 66 */       if (this.keyType == null) {
/* 67 */         this.keyType = (DataType)new ObjectDataType();
/*    */       }
/* 69 */       if (this.valueType == null) {
/* 70 */         this.valueType = (DataType)new ObjectDataType();
/*    */       }
/* 72 */       return new MVMapConcurrent<>(this.keyType, this.valueType);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\MVMapConcurrent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */