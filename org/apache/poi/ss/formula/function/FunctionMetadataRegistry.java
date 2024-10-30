/*    */ package org.apache.poi.ss.formula.function;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class FunctionMetadataRegistry
/*    */ {
/*    */   public static final String FUNCTION_NAME_IF = "IF";
/*    */   public static final int FUNCTION_INDEX_IF = 1;
/*    */   public static final short FUNCTION_INDEX_SUM = 4;
/*    */   public static final int FUNCTION_INDEX_CHOOSE = 100;
/*    */   public static final short FUNCTION_INDEX_INDIRECT = 148;
/*    */   public static final short FUNCTION_INDEX_EXTERNAL = 255;
/*    */   private static FunctionMetadataRegistry _instance;
/*    */   private final FunctionMetadata[] _functionDataByIndex;
/*    */   private final Map<String, FunctionMetadata> _functionDataByName;
/*    */   
/*    */   private static FunctionMetadataRegistry getInstance() {
/* 45 */     if (_instance == null) {
/* 46 */       _instance = FunctionMetadataReader.createRegistry();
/*    */     }
/* 48 */     return _instance;
/*    */   }
/*    */   
/*    */   FunctionMetadataRegistry(FunctionMetadata[] paramArrayOfFunctionMetadata, Map<String, FunctionMetadata> paramMap) {
/* 52 */     this._functionDataByIndex = paramArrayOfFunctionMetadata;
/* 53 */     this._functionDataByName = paramMap;
/*    */   }
/*    */   
/*    */   Set<String> getAllFunctionNames() {
/* 57 */     return this._functionDataByName.keySet();
/*    */   }
/*    */ 
/*    */   
/*    */   public static FunctionMetadata getFunctionByIndex(int paramInt) {
/* 62 */     return getInstance().getFunctionByIndexInternal(paramInt);
/*    */   }
/*    */   
/*    */   private FunctionMetadata getFunctionByIndexInternal(int paramInt) {
/* 66 */     return this._functionDataByIndex[paramInt];
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static short lookupIndexByName(String paramString) {
/* 75 */     FunctionMetadata functionMetadata = getInstance().getFunctionByNameInternal(paramString);
/* 76 */     if (functionMetadata == null) {
/* 77 */       return -1;
/*    */     }
/* 79 */     return (short)functionMetadata.getIndex();
/*    */   }
/*    */   
/*    */   private FunctionMetadata getFunctionByNameInternal(String paramString) {
/* 83 */     return this._functionDataByName.get(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public static FunctionMetadata getFunctionByName(String paramString) {
/* 88 */     return getInstance().getFunctionByNameInternal(paramString);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\function\FunctionMetadataRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */