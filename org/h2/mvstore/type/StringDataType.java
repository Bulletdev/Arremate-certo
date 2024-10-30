/*    */ package org.h2.mvstore.type;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.h2.mvstore.DataUtils;
/*    */ import org.h2.mvstore.WriteBuffer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StringDataType
/*    */   implements DataType
/*    */ {
/* 17 */   public static final StringDataType INSTANCE = new StringDataType();
/*    */ 
/*    */   
/*    */   public int compare(Object paramObject1, Object paramObject2) {
/* 21 */     return paramObject1.toString().compareTo(paramObject2.toString());
/*    */   }
/*    */ 
/*    */   
/*    */   public int getMemory(Object paramObject) {
/* 26 */     return 24 + 2 * paramObject.toString().length();
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(ByteBuffer paramByteBuffer, Object[] paramArrayOfObject, int paramInt, boolean paramBoolean) {
/* 31 */     for (byte b = 0; b < paramInt; b++) {
/* 32 */       paramArrayOfObject[b] = read(paramByteBuffer);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(WriteBuffer paramWriteBuffer, Object[] paramArrayOfObject, int paramInt, boolean paramBoolean) {
/* 38 */     for (byte b = 0; b < paramInt; b++) {
/* 39 */       write(paramWriteBuffer, paramArrayOfObject[b]);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public String read(ByteBuffer paramByteBuffer) {
/* 45 */     int i = DataUtils.readVarInt(paramByteBuffer);
/* 46 */     return DataUtils.readString(paramByteBuffer, i);
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(WriteBuffer paramWriteBuffer, Object paramObject) {
/* 51 */     String str = paramObject.toString();
/* 52 */     int i = str.length();
/* 53 */     paramWriteBuffer.putVarInt(i).putStringData(str, i);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\type\StringDataType.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */