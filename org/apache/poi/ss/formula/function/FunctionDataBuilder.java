/*    */ package org.apache.poi.ss.formula.function;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
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
/*    */ final class FunctionDataBuilder
/*    */ {
/*    */   private int _maxFunctionIndex;
/*    */   private final Map<String, FunctionMetadata> _functionDataByName;
/*    */   private final Map<Integer, FunctionMetadata> _functionDataByIndex;
/*    */   private final Set<Integer> _mutatingFunctionIndexes;
/*    */   
/*    */   public FunctionDataBuilder(int paramInt) {
/* 39 */     this._maxFunctionIndex = -1;
/* 40 */     this._functionDataByName = new HashMap<String, FunctionMetadata>(paramInt * 3 / 2);
/* 41 */     this._functionDataByIndex = new HashMap<Integer, FunctionMetadata>(paramInt * 3 / 2);
/* 42 */     this._mutatingFunctionIndexes = new HashSet<Integer>();
/*    */   }
/*    */ 
/*    */   
/*    */   public void add(int paramInt1, String paramString, int paramInt2, int paramInt3, byte paramByte, byte[] paramArrayOfbyte, boolean paramBoolean) {
/* 47 */     FunctionMetadata functionMetadata1 = new FunctionMetadata(paramInt1, paramString, paramInt2, paramInt3, paramByte, paramArrayOfbyte);
/*    */ 
/*    */     
/* 50 */     Integer integer = Integer.valueOf(paramInt1);
/*    */ 
/*    */     
/* 53 */     if (paramInt1 > this._maxFunctionIndex) {
/* 54 */       this._maxFunctionIndex = paramInt1;
/*    */     }
/*    */ 
/*    */     
/* 58 */     FunctionMetadata functionMetadata2 = this._functionDataByName.get(paramString);
/* 59 */     if (functionMetadata2 != null) {
/* 60 */       if (!paramBoolean || !this._mutatingFunctionIndexes.contains(integer)) {
/* 61 */         throw new RuntimeException("Multiple entries for function name '" + paramString + "'");
/*    */       }
/* 63 */       this._functionDataByIndex.remove(Integer.valueOf(functionMetadata2.getIndex()));
/*    */     } 
/* 65 */     functionMetadata2 = this._functionDataByIndex.get(integer);
/* 66 */     if (functionMetadata2 != null) {
/* 67 */       if (!paramBoolean || !this._mutatingFunctionIndexes.contains(integer)) {
/* 68 */         throw new RuntimeException("Multiple entries for function index (" + paramInt1 + ")");
/*    */       }
/* 70 */       this._functionDataByName.remove(functionMetadata2.getName());
/*    */     } 
/* 72 */     if (paramBoolean) {
/* 73 */       this._mutatingFunctionIndexes.add(integer);
/*    */     }
/* 75 */     this._functionDataByIndex.put(integer, functionMetadata1);
/* 76 */     this._functionDataByName.put(paramString, functionMetadata1);
/*    */   }
/*    */ 
/*    */   
/*    */   public FunctionMetadataRegistry build() {
/* 81 */     FunctionMetadata[] arrayOfFunctionMetadata1 = new FunctionMetadata[this._functionDataByName.size()];
/* 82 */     this._functionDataByName.values().toArray((Object[])arrayOfFunctionMetadata1);
/* 83 */     FunctionMetadata[] arrayOfFunctionMetadata2 = new FunctionMetadata[this._maxFunctionIndex + 1];
/* 84 */     for (byte b = 0; b < arrayOfFunctionMetadata1.length; b++) {
/* 85 */       FunctionMetadata functionMetadata = arrayOfFunctionMetadata1[b];
/* 86 */       arrayOfFunctionMetadata2[functionMetadata.getIndex()] = functionMetadata;
/*    */     } 
/*    */     
/* 89 */     return new FunctionMetadataRegistry(arrayOfFunctionMetadata2, this._functionDataByName);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\function\FunctionDataBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */