/*    */ package org.h2.store;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.value.ValueLobDb;
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
/*    */ class LobStorageRemoteInputStream
/*    */   extends InputStream
/*    */ {
/*    */   private final DataHandler handler;
/*    */   private final long lob;
/*    */   private final byte[] hmac;
/*    */   private long pos;
/*    */   private long remainingBytes;
/*    */   
/*    */   public LobStorageRemoteInputStream(DataHandler paramDataHandler, ValueLobDb paramValueLobDb, byte[] paramArrayOfbyte, long paramLong) {
/* 43 */     this.handler = paramDataHandler;
/* 44 */     this.lob = paramValueLobDb.getLobId();
/* 45 */     this.hmac = paramArrayOfbyte;
/* 46 */     this.remainingBytes = paramLong;
/*    */   }
/*    */ 
/*    */   
/*    */   public int read() throws IOException {
/* 51 */     byte[] arrayOfByte = new byte[1];
/* 52 */     int i = read(arrayOfByte, 0, 1);
/* 53 */     return (i < 0) ? i : (arrayOfByte[0] & 0xFF);
/*    */   }
/*    */ 
/*    */   
/*    */   public int read(byte[] paramArrayOfbyte) throws IOException {
/* 58 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*    */   }
/*    */ 
/*    */   
/*    */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 63 */     if (paramInt2 == 0) {
/* 64 */       return 0;
/*    */     }
/* 66 */     paramInt2 = (int)Math.min(paramInt2, this.remainingBytes);
/* 67 */     if (paramInt2 == 0) {
/* 68 */       return -1;
/*    */     }
/*    */     try {
/* 71 */       paramInt2 = this.handler.readLob(this.lob, this.hmac, this.pos, paramArrayOfbyte, paramInt1, paramInt2);
/* 72 */     } catch (DbException dbException) {
/* 73 */       throw DbException.convertToIOException(dbException);
/*    */     } 
/* 75 */     if (paramInt2 == 0) {
/* 76 */       return -1;
/*    */     }
/* 78 */     this.remainingBytes -= paramInt2;
/* 79 */     this.pos += paramInt2;
/* 80 */     return paramInt2;
/*    */   }
/*    */ 
/*    */   
/*    */   public long skip(long paramLong) {
/* 85 */     this.remainingBytes -= paramLong;
/* 86 */     this.pos += paramLong;
/* 87 */     return paramLong;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\LobStorageRemoteInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */