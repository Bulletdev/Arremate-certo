/*    */ package org.apache.xmlbeans;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SchemaTypeLoaderException
/*    */   extends XmlRuntimeException
/*    */ {
/*    */   private int _code;
/*    */   public static final int NO_RESOURCE = 0;
/*    */   public static final int WRONG_MAGIC_COOKIE = 1;
/*    */   public static final int WRONG_MAJOR_VERSION = 2;
/*    */   public static final int WRONG_MINOR_VERSION = 3;
/*    */   public static final int WRONG_FILE_TYPE = 4;
/*    */   public static final int UNRECOGNIZED_INDEX_ENTRY = 5;
/*    */   public static final int WRONG_PROPERTY_TYPE = 6;
/*    */   public static final int MALFORMED_CONTENT_MODEL = 7;
/*    */   public static final int WRONG_SIMPLE_VARIETY = 8;
/*    */   public static final int IO_EXCEPTION = 9;
/*    */   public static final int INT_TOO_LARGE = 10;
/*    */   public static final int BAD_PARTICLE_TYPE = 11;
/*    */   public static final int NOT_WRITEABLE = 12;
/*    */   public static final int BAD_HANDLE = 13;
/*    */   public static final int NESTED_EXCEPTION = 14;
/*    */   
/*    */   public SchemaTypeLoaderException(String paramString1, String paramString2, String paramString3, int paramInt) {
/* 29 */     super(paramString1 + " (" + paramString2 + "." + paramString3 + ") - code " + paramInt);
/* 30 */     this._code = paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public SchemaTypeLoaderException(String paramString1, String paramString2, String paramString3, int paramInt, Exception paramException) {
/* 36 */     super(paramString1 + " (" + paramString2 + "." + paramString3 + ") - code " + paramInt);
/* 37 */     this._code = paramInt;
/* 38 */     initCause(paramException);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getCode() {
/* 44 */     return this._code;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\SchemaTypeLoaderException.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */