/*     */ package org.h2.store;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueLobDb;
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
/*     */ 
/*     */ public class LobStorageFrontend
/*     */   implements LobStorageInterface
/*     */ {
/*     */   public static final int TABLE_ID_SESSION_VARIABLE = -1;
/*     */   public static final int TABLE_TEMP = -2;
/*     */   public static final int TABLE_RESULT = -3;
/*     */   private final DataHandler handler;
/*     */   
/*     */   public LobStorageFrontend(DataHandler paramDataHandler) {
/*  39 */     this.handler = paramDataHandler;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeLob(ValueLobDb paramValueLobDb) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getInputStream(ValueLobDb paramValueLobDb, byte[] paramArrayOfbyte, long paramLong) throws IOException {
/*  58 */     if (paramLong < 0L) {
/*  59 */       paramLong = Long.MAX_VALUE;
/*     */     }
/*  61 */     return new BufferedInputStream(new LobStorageRemoteInputStream(this.handler, paramValueLobDb, paramArrayOfbyte, paramLong));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReadOnly() {
/*  67 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public ValueLobDb copyLob(ValueLobDb paramValueLobDb, int paramInt, long paramLong) {
/*  72 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTable(ValueLobDb paramValueLobDb, int paramInt) {
/*  77 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeAllForTable(int paramInt) {
/*  82 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Value createBlob(InputStream paramInputStream, long paramLong) {
/*  90 */     return (Value)ValueLobDb.createTempBlob(paramInputStream, paramLong, this.handler);
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
/*     */ 
/*     */   
/*     */   public Value createClob(Reader paramReader, long paramLong) {
/* 105 */     return (Value)ValueLobDb.createTempClob(paramReader, paramLong, this.handler);
/*     */   }
/*     */   
/*     */   public void init() {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\LobStorageFrontend.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */