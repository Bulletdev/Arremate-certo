/*     */ package org.h2.value;
/*     */ 
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.store.DataHandler;
/*     */ import org.h2.util.JdbcUtils;
/*     */ import org.h2.util.Utils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ValueJavaObject
/*     */   extends ValueBytes
/*     */ {
/*  22 */   private static final ValueJavaObject EMPTY = new ValueJavaObject(Utils.EMPTY_BYTES, null);
/*     */   
/*     */   private final DataHandler dataHandler;
/*     */   
/*     */   protected ValueJavaObject(byte[] paramArrayOfbyte, DataHandler paramDataHandler) {
/*  27 */     super(paramArrayOfbyte);
/*  28 */     this.dataHandler = paramDataHandler;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueJavaObject getNoCopy(Object paramObject, byte[] paramArrayOfbyte, DataHandler paramDataHandler) {
/*     */     ValueJavaObject valueJavaObject;
/*  42 */     if (paramArrayOfbyte != null && paramArrayOfbyte.length == 0) {
/*  43 */       return EMPTY;
/*     */     }
/*     */     
/*  46 */     if (SysProperties.serializeJavaObject) {
/*  47 */       if (paramArrayOfbyte == null) {
/*  48 */         paramArrayOfbyte = JdbcUtils.serialize(paramObject, paramDataHandler);
/*     */       }
/*  50 */       valueJavaObject = new ValueJavaObject(paramArrayOfbyte, paramDataHandler);
/*     */     } else {
/*  52 */       valueJavaObject = new NotSerialized(paramObject, paramArrayOfbyte, paramDataHandler);
/*     */     } 
/*  54 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length > SysProperties.OBJECT_CACHE_MAX_PER_ELEMENT_SIZE) {
/*  55 */       return valueJavaObject;
/*     */     }
/*  57 */     return (ValueJavaObject)Value.cache(valueJavaObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/*  62 */     return 19;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(PreparedStatement paramPreparedStatement, int paramInt) throws SQLException {
/*  68 */     Object object = JdbcUtils.deserialize(getBytesNoCopy(), getDataHandler());
/*  69 */     paramPreparedStatement.setObject(paramInt, object, 2000);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class NotSerialized
/*     */     extends ValueJavaObject
/*     */   {
/*     */     private Object javaObject;
/*     */ 
/*     */ 
/*     */     
/*  82 */     private int displaySize = -1;
/*     */     
/*     */     NotSerialized(Object param1Object, byte[] param1ArrayOfbyte, DataHandler param1DataHandler) {
/*  85 */       super(param1ArrayOfbyte, param1DataHandler);
/*  86 */       this.javaObject = param1Object;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void set(PreparedStatement param1PreparedStatement, int param1Int) throws SQLException {
/*  92 */       param1PreparedStatement.setObject(param1Int, getObject(), 2000);
/*     */     }
/*     */ 
/*     */     
/*     */     public byte[] getBytesNoCopy() {
/*  97 */       if (this.value == null) {
/*  98 */         this.value = JdbcUtils.serialize(this.javaObject, null);
/*     */       }
/* 100 */       return this.value;
/*     */     }
/*     */ 
/*     */     
/*     */     protected int compareSecure(Value param1Value, CompareMode param1CompareMode) {
/* 105 */       Object object1 = getObject();
/* 106 */       Object object2 = param1Value.getObject();
/*     */       
/* 108 */       boolean bool1 = object1 instanceof Comparable;
/* 109 */       boolean bool2 = object2 instanceof Comparable;
/*     */       
/* 111 */       if (bool1 && bool2 && Utils.haveCommonComparableSuperclass(object1.getClass(), object2.getClass())) {
/*     */ 
/*     */         
/* 114 */         Comparable<Object> comparable = (Comparable)object1;
/* 115 */         return comparable.compareTo(object2);
/*     */       } 
/*     */ 
/*     */       
/* 119 */       if (object1.getClass() != object2.getClass()) {
/* 120 */         if (bool1 != bool2) {
/* 121 */           return bool1 ? -1 : 1;
/*     */         }
/* 123 */         return object1.getClass().getName().compareTo(object2.getClass().getName());
/*     */       } 
/*     */ 
/*     */       
/* 127 */       int i = hashCode();
/* 128 */       int j = param1Value.hashCode();
/*     */       
/* 130 */       if (i == j) {
/* 131 */         if (object1.equals(object2)) {
/* 132 */           return 0;
/*     */         }
/*     */         
/* 135 */         return Utils.compareNotNullSigned(getBytesNoCopy(), param1Value.getBytesNoCopy());
/*     */       } 
/*     */       
/* 138 */       return (i > j) ? 1 : -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getString() {
/* 143 */       String str = getObject().toString();
/* 144 */       if (this.displaySize == -1) {
/* 145 */         this.displaySize = str.length();
/*     */       }
/* 147 */       return str;
/*     */     }
/*     */ 
/*     */     
/*     */     public long getPrecision() {
/* 152 */       return 0L;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 157 */       if (this.hash == 0) {
/* 158 */         this.hash = getObject().hashCode();
/*     */       }
/* 160 */       return this.hash;
/*     */     }
/*     */ 
/*     */     
/*     */     public Object getObject() {
/* 165 */       if (this.javaObject == null) {
/* 166 */         this.javaObject = JdbcUtils.deserialize(this.value, getDataHandler());
/*     */       }
/* 168 */       return this.javaObject;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getDisplaySize() {
/* 173 */       if (this.displaySize == -1) {
/* 174 */         this.displaySize = getString().length();
/*     */       }
/* 176 */       return this.displaySize;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getMemory() {
/* 181 */       if (this.value == null) {
/* 182 */         return (DataType.getDataType(getType())).memory;
/*     */       }
/* 184 */       int i = super.getMemory();
/* 185 */       if (this.javaObject != null) {
/* 186 */         i *= 2;
/*     */       }
/* 188 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 193 */       if (!(param1Object instanceof NotSerialized)) {
/* 194 */         return false;
/*     */       }
/* 196 */       return getObject().equals(((NotSerialized)param1Object).getObject());
/*     */     }
/*     */ 
/*     */     
/*     */     public Value convertPrecision(long param1Long, boolean param1Boolean) {
/* 201 */       return this;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected DataHandler getDataHandler() {
/* 207 */     return this.dataHandler;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\ValueJavaObject.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */