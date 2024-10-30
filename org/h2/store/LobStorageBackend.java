/*     */ package org.h2.store;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.jdbc.JdbcConnection;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.tools.CompressTool;
/*     */ import org.h2.util.IOUtils;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.util.New;
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
/*     */ public class LobStorageBackend
/*     */   implements LobStorageInterface
/*     */ {
/*     */   public static final String LOB_DATA_TABLE = "LOB_DATA";
/*     */   private static final String LOB_SCHEMA = "INFORMATION_SCHEMA";
/*     */   private static final String LOBS = "INFORMATION_SCHEMA.LOBS";
/*     */   private static final String LOB_MAP = "INFORMATION_SCHEMA.LOB_MAP";
/*     */   private static final String LOB_DATA = "INFORMATION_SCHEMA.LOB_DATA";
/*     */   private static final int BLOCK_LENGTH = 20000;
/*     */   private static final int HASH_CACHE_SIZE = 4096;
/*     */   JdbcConnection conn;
/*     */   final Database database;
/*  93 */   private final HashMap<String, PreparedStatement> prepared = New.hashMap();
/*     */   private long nextBlock;
/*  95 */   private final CompressTool compress = CompressTool.getInstance();
/*     */   
/*     */   private long[] hashBlocks;
/*     */   private boolean init;
/*     */   
/*     */   public LobStorageBackend(Database paramDatabase) {
/* 101 */     this.database = paramDatabase;
/*     */   }
/*     */ 
/*     */   
/*     */   public void init() {
/* 106 */     if (this.init) {
/*     */       return;
/*     */     }
/* 109 */     synchronized (this.database) {
/*     */ 
/*     */       
/* 112 */       if (this.init) {
/*     */         return;
/*     */       }
/* 115 */       this.init = true;
/* 116 */       this.conn = this.database.getLobConnectionForRegularUse();
/* 117 */       JdbcConnection jdbcConnection = this.database.getLobConnectionForInit();
/*     */       try {
/* 119 */         Statement statement = jdbcConnection.createStatement();
/*     */ 
/*     */         
/* 122 */         boolean bool = true;
/* 123 */         PreparedStatement preparedStatement = jdbcConnection.prepareStatement("SELECT ZERO() FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA=? AND TABLE_NAME=? AND COLUMN_NAME=?");
/*     */ 
/*     */         
/* 126 */         preparedStatement.setString(1, "INFORMATION_SCHEMA");
/* 127 */         preparedStatement.setString(2, "LOB_MAP");
/* 128 */         preparedStatement.setString(3, "POS");
/*     */         
/* 130 */         ResultSet resultSet = preparedStatement.executeQuery();
/* 131 */         if (resultSet.next()) {
/* 132 */           preparedStatement = jdbcConnection.prepareStatement("SELECT ZERO() FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA=? AND TABLE_NAME=?");
/*     */ 
/*     */           
/* 135 */           preparedStatement.setString(1, "INFORMATION_SCHEMA");
/* 136 */           preparedStatement.setString(2, "LOB_DATA");
/* 137 */           resultSet = preparedStatement.executeQuery();
/* 138 */           if (resultSet.next()) {
/* 139 */             bool = false;
/*     */           }
/*     */         } 
/* 142 */         if (bool) {
/* 143 */           statement.execute("CREATE CACHED TABLE IF NOT EXISTS INFORMATION_SCHEMA.LOBS(ID BIGINT PRIMARY KEY, BYTE_COUNT BIGINT, TABLE INT) HIDDEN");
/*     */           
/* 145 */           statement.execute("CREATE INDEX IF NOT EXISTS INFORMATION_SCHEMA.INDEX_LOB_TABLE ON INFORMATION_SCHEMA.LOBS(TABLE)");
/*     */ 
/*     */           
/* 148 */           statement.execute("CREATE CACHED TABLE IF NOT EXISTS INFORMATION_SCHEMA.LOB_MAP(LOB BIGINT, SEQ INT, POS BIGINT, HASH INT, BLOCK BIGINT, PRIMARY KEY(LOB, SEQ)) HIDDEN");
/*     */ 
/*     */           
/* 151 */           statement.execute("ALTER TABLE INFORMATION_SCHEMA.LOB_MAP RENAME TO INFORMATION_SCHEMA.LOB_MAP HIDDEN");
/*     */           
/* 153 */           statement.execute("ALTER TABLE INFORMATION_SCHEMA.LOB_MAP ADD IF NOT EXISTS POS BIGINT BEFORE HASH");
/*     */ 
/*     */ 
/*     */           
/* 157 */           statement.execute("ALTER TABLE INFORMATION_SCHEMA.LOB_MAP DROP COLUMN IF EXISTS \"OFFSET\"");
/*     */           
/* 159 */           statement.execute("CREATE INDEX IF NOT EXISTS INFORMATION_SCHEMA.INDEX_LOB_MAP_DATA_LOB ON INFORMATION_SCHEMA.LOB_MAP(BLOCK, LOB)");
/*     */ 
/*     */           
/* 162 */           statement.execute("CREATE CACHED TABLE IF NOT EXISTS INFORMATION_SCHEMA.LOB_DATA(BLOCK BIGINT PRIMARY KEY, COMPRESSED INT, DATA BINARY) HIDDEN");
/*     */         } 
/*     */ 
/*     */         
/* 166 */         resultSet = statement.executeQuery("SELECT MAX(BLOCK) FROM INFORMATION_SCHEMA.LOB_DATA");
/* 167 */         resultSet.next();
/* 168 */         this.nextBlock = resultSet.getLong(1) + 1L;
/* 169 */         statement.close();
/* 170 */       } catch (SQLException sQLException) {
/* 171 */         throw DbException.convert(sQLException);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private long getNextLobId() throws SQLException {
/* 177 */     String str = "SELECT MAX(LOB) FROM INFORMATION_SCHEMA.LOB_MAP";
/* 178 */     PreparedStatement preparedStatement = prepare(str);
/* 179 */     ResultSet resultSet = preparedStatement.executeQuery();
/* 180 */     resultSet.next();
/* 181 */     long l = resultSet.getLong(1) + 1L;
/* 182 */     reuse(str, preparedStatement);
/* 183 */     str = "SELECT MAX(ID) FROM INFORMATION_SCHEMA.LOBS";
/* 184 */     preparedStatement = prepare(str);
/* 185 */     resultSet = preparedStatement.executeQuery();
/* 186 */     resultSet.next();
/* 187 */     l = Math.max(l, resultSet.getLong(1) + 1L);
/* 188 */     reuse(str, preparedStatement);
/* 189 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeAllForTable(int paramInt) {
/* 194 */     init();
/*     */     try {
/* 196 */       String str = "SELECT ID FROM INFORMATION_SCHEMA.LOBS WHERE TABLE = ?";
/* 197 */       PreparedStatement preparedStatement = prepare(str);
/* 198 */       preparedStatement.setInt(1, paramInt);
/* 199 */       ResultSet resultSet = preparedStatement.executeQuery();
/* 200 */       while (resultSet.next()) {
/* 201 */         removeLob(resultSet.getLong(1));
/*     */       }
/* 203 */       reuse(str, preparedStatement);
/* 204 */     } catch (SQLException sQLException) {
/* 205 */       throw DbException.convert(sQLException);
/*     */     } 
/* 207 */     if (paramInt == -1) {
/* 208 */       removeAllForTable(-2);
/* 209 */       removeAllForTable(-3);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   byte[] readBlock(long paramLong) throws SQLException {
/* 221 */     assertNotHolds(this.conn.getSession());
/* 222 */     synchronized (this.database) {
/* 223 */       synchronized (this.conn.getSession()) {
/* 224 */         String str = "SELECT COMPRESSED, DATA FROM INFORMATION_SCHEMA.LOB_DATA WHERE BLOCK = ?";
/*     */         
/* 226 */         PreparedStatement preparedStatement = prepare(str);
/* 227 */         preparedStatement.setLong(1, paramLong);
/* 228 */         ResultSet resultSet = preparedStatement.executeQuery();
/* 229 */         if (!resultSet.next()) {
/* 230 */           throw DbException.get(90028, "Missing lob entry, block: " + paramLong).getSQLException();
/*     */         }
/*     */ 
/*     */         
/* 234 */         int i = resultSet.getInt(1);
/* 235 */         byte[] arrayOfByte = resultSet.getBytes(2);
/* 236 */         if (i != 0) {
/* 237 */           arrayOfByte = this.compress.expand(arrayOfByte);
/*     */         }
/* 239 */         reuse(str, preparedStatement);
/* 240 */         return arrayOfByte;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PreparedStatement prepare(String paramString) throws SQLException {
/* 252 */     if (SysProperties.CHECK2 && 
/* 253 */       !Thread.holdsLock(this.database)) {
/* 254 */       throw DbException.throwInternalError();
/*     */     }
/*     */     
/* 257 */     PreparedStatement preparedStatement = this.prepared.remove(paramString);
/* 258 */     if (preparedStatement == null) {
/* 259 */       preparedStatement = this.conn.prepareStatement(paramString);
/*     */     }
/* 261 */     return preparedStatement;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void reuse(String paramString, PreparedStatement paramPreparedStatement) {
/* 271 */     if (SysProperties.CHECK2 && 
/* 272 */       !Thread.holdsLock(this.database)) {
/* 273 */       throw DbException.throwInternalError();
/*     */     }
/*     */     
/* 276 */     this.prepared.put(paramString, paramPreparedStatement);
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeLob(ValueLobDb paramValueLobDb) {
/* 281 */     removeLob(paramValueLobDb.getLobId());
/*     */   }
/*     */ 
/*     */   
/*     */   private void removeLob(long paramLong) {
/*     */     try {
/* 287 */       assertNotHolds(this.conn.getSession());
/* 288 */       synchronized (this.database) {
/* 289 */         synchronized (this.conn.getSession()) {
/* 290 */           String str = "SELECT BLOCK, HASH FROM INFORMATION_SCHEMA.LOB_MAP D WHERE D.LOB = ? AND NOT EXISTS(SELECT 1 FROM INFORMATION_SCHEMA.LOB_MAP O WHERE O.BLOCK = D.BLOCK AND O.LOB <> ?)";
/*     */ 
/*     */           
/* 293 */           PreparedStatement preparedStatement = prepare(str);
/* 294 */           preparedStatement.setLong(1, paramLong);
/* 295 */           preparedStatement.setLong(2, paramLong);
/* 296 */           ResultSet resultSet = preparedStatement.executeQuery();
/* 297 */           ArrayList<Long> arrayList = New.arrayList();
/* 298 */           while (resultSet.next()) {
/* 299 */             arrayList.add(Long.valueOf(resultSet.getLong(1)));
/* 300 */             int i = resultSet.getInt(2);
/* 301 */             setHashCacheBlock(i, -1L);
/*     */           } 
/* 303 */           reuse(str, preparedStatement);
/*     */           
/* 305 */           str = "DELETE FROM INFORMATION_SCHEMA.LOB_MAP WHERE LOB = ?";
/* 306 */           preparedStatement = prepare(str);
/* 307 */           preparedStatement.setLong(1, paramLong);
/* 308 */           preparedStatement.execute();
/* 309 */           reuse(str, preparedStatement);
/*     */           
/* 311 */           str = "DELETE FROM INFORMATION_SCHEMA.LOB_DATA WHERE BLOCK = ?";
/* 312 */           preparedStatement = prepare(str);
/* 313 */           for (Iterator<Long> iterator = arrayList.iterator(); iterator.hasNext(); ) { long l = ((Long)iterator.next()).longValue();
/* 314 */             preparedStatement.setLong(1, l);
/* 315 */             preparedStatement.execute(); }
/*     */           
/* 317 */           reuse(str, preparedStatement);
/*     */           
/* 319 */           str = "DELETE FROM INFORMATION_SCHEMA.LOBS WHERE ID = ?";
/* 320 */           preparedStatement = prepare(str);
/* 321 */           preparedStatement.setLong(1, paramLong);
/* 322 */           preparedStatement.execute();
/* 323 */           reuse(str, preparedStatement);
/*     */         } 
/*     */       } 
/* 326 */     } catch (SQLException sQLException) {
/* 327 */       throw DbException.convert(sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getInputStream(ValueLobDb paramValueLobDb, byte[] paramArrayOfbyte, long paramLong) throws IOException {
/*     */     try {
/* 335 */       init();
/* 336 */       assertNotHolds(this.conn.getSession());
/*     */       
/* 338 */       synchronized (this.database) {
/* 339 */         synchronized (this.conn.getSession()) {
/* 340 */           long l = paramValueLobDb.getLobId();
/* 341 */           return new LobInputStream(l, paramLong);
/*     */         } 
/*     */       } 
/* 344 */     } catch (SQLException sQLException) {
/* 345 */       throw DbException.convertToIOException(sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private ValueLobDb addLob(InputStream paramInputStream, long paramLong, int paramInt, CountingReaderInputStream paramCountingReaderInputStream) {
/*     */     try {
/* 352 */       byte[] arrayOfByte = new byte[20000];
/* 353 */       if (paramLong < 0L) {
/* 354 */         paramLong = Long.MAX_VALUE;
/*     */       }
/* 356 */       long l1 = 0L;
/* 357 */       long l2 = -1L;
/* 358 */       int i = this.database.getMaxLengthInplaceLob();
/* 359 */       String str = this.database.getLobCompressionAlgorithm(paramInt);
/*     */       try {
/* 361 */         byte[] arrayOfByte1 = null;
/* 362 */         for (byte b = 0; paramLong > 0L; b++) {
/* 363 */           byte[] arrayOfByte2; int j = (int)Math.min(20000L, paramLong);
/* 364 */           j = IOUtils.readFully(paramInputStream, arrayOfByte, j);
/* 365 */           if (j <= 0) {
/*     */             break;
/*     */           }
/* 368 */           paramLong -= j;
/*     */ 
/*     */           
/* 371 */           if (j != arrayOfByte.length) {
/* 372 */             arrayOfByte2 = new byte[j];
/* 373 */             System.arraycopy(arrayOfByte, 0, arrayOfByte2, 0, j);
/*     */           } else {
/* 375 */             arrayOfByte2 = arrayOfByte;
/*     */           } 
/* 377 */           if (!b && arrayOfByte2.length < 20000 && arrayOfByte2.length <= i) {
/*     */             
/* 379 */             arrayOfByte1 = arrayOfByte2;
/*     */             break;
/*     */           } 
/* 382 */           assertNotHolds(this.conn.getSession());
/*     */           
/* 384 */           synchronized (this.database) {
/* 385 */             synchronized (this.conn.getSession()) {
/* 386 */               if (!b) {
/* 387 */                 l2 = getNextLobId();
/*     */               }
/* 389 */               storeBlock(l2, b, l1, arrayOfByte2, str);
/*     */             } 
/*     */           } 
/* 392 */           l1 += j;
/*     */         } 
/* 394 */         if (l2 == -1L && arrayOfByte1 == null)
/*     */         {
/* 396 */           arrayOfByte1 = new byte[0];
/*     */         }
/* 398 */         if (arrayOfByte1 != null) {
/*     */ 
/*     */           
/* 401 */           long l3 = (paramCountingReaderInputStream == null) ? arrayOfByte1.length : paramCountingReaderInputStream.getLength();
/*     */           
/* 403 */           return ValueLobDb.createSmallLob(paramInt, arrayOfByte1, l3);
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 408 */         long l = (paramCountingReaderInputStream == null) ? l1 : paramCountingReaderInputStream.getLength();
/*     */         
/* 410 */         return registerLob(paramInt, l2, -2, l1, l);
/*     */       }
/* 412 */       catch (IOException iOException) {
/* 413 */         if (l2 != -1L) {
/* 414 */           removeLob(l2);
/*     */         }
/* 416 */         throw DbException.convertIOException(iOException, null);
/*     */       } 
/* 418 */     } catch (SQLException sQLException) {
/* 419 */       throw DbException.convert(sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private ValueLobDb registerLob(int paramInt1, long paramLong1, int paramInt2, long paramLong2, long paramLong3) throws SQLException {
/* 425 */     assertNotHolds(this.conn.getSession());
/*     */     
/* 427 */     synchronized (this.database) {
/* 428 */       synchronized (this.conn.getSession()) {
/* 429 */         String str = "INSERT INTO INFORMATION_SCHEMA.LOBS(ID, BYTE_COUNT, TABLE) VALUES(?, ?, ?)";
/*     */         
/* 431 */         PreparedStatement preparedStatement = prepare(str);
/* 432 */         preparedStatement.setLong(1, paramLong1);
/* 433 */         preparedStatement.setLong(2, paramLong2);
/* 434 */         preparedStatement.setInt(3, paramInt2);
/* 435 */         preparedStatement.execute();
/* 436 */         reuse(str, preparedStatement);
/* 437 */         return ValueLobDb.create(paramInt1, (DataHandler)this.database, paramInt2, paramLong1, null, paramLong3);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReadOnly() {
/* 446 */     return this.database.isReadOnly();
/*     */   }
/*     */ 
/*     */   
/*     */   public ValueLobDb copyLob(ValueLobDb paramValueLobDb, int paramInt, long paramLong) {
/* 451 */     int i = paramValueLobDb.getType();
/* 452 */     long l = paramValueLobDb.getLobId();
/* 453 */     assertNotHolds(this.conn.getSession());
/*     */     
/* 455 */     synchronized (this.database) {
/* 456 */       synchronized (this.conn.getSession()) {
/*     */         
/* 458 */         init();
/* 459 */         long l1 = getNextLobId();
/* 460 */         String str = "INSERT INTO INFORMATION_SCHEMA.LOB_MAP(LOB, SEQ, POS, HASH, BLOCK) SELECT ?, SEQ, POS, HASH, BLOCK FROM INFORMATION_SCHEMA.LOB_MAP WHERE LOB = ?";
/*     */         
/* 462 */         PreparedStatement preparedStatement = prepare(str);
/* 463 */         preparedStatement.setLong(1, l1);
/* 464 */         preparedStatement.setLong(2, l);
/* 465 */         preparedStatement.executeUpdate();
/* 466 */         reuse(str, preparedStatement);
/*     */         
/* 468 */         str = "INSERT INTO INFORMATION_SCHEMA.LOBS(ID, BYTE_COUNT, TABLE) SELECT ?, BYTE_COUNT, ? FROM INFORMATION_SCHEMA.LOBS WHERE ID = ?";
/*     */         
/* 470 */         preparedStatement = prepare(str);
/* 471 */         preparedStatement.setLong(1, l1);
/* 472 */         preparedStatement.setLong(2, paramInt);
/* 473 */         preparedStatement.setLong(3, l);
/* 474 */         preparedStatement.executeUpdate();
/* 475 */         reuse(str, preparedStatement);
/*     */         
/* 477 */         return ValueLobDb.create(i, (DataHandler)this.database, paramInt, l1, null, paramLong);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long getHashCacheBlock(int paramInt) {
/* 488 */     initHashCache();
/* 489 */     int i = paramInt & 0xFFF;
/* 490 */     long l = this.hashBlocks[i];
/* 491 */     if (l == paramInt) {
/* 492 */       return this.hashBlocks[i + 4096];
/*     */     }
/*     */     
/* 495 */     return -1L;
/*     */   }
/*     */ 
/*     */   
/*     */   private void setHashCacheBlock(int paramInt, long paramLong) {
/* 500 */     initHashCache();
/* 501 */     int i = paramInt & 0xFFF;
/* 502 */     this.hashBlocks[i] = paramInt;
/* 503 */     this.hashBlocks[i + 4096] = paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   private void initHashCache() {
/* 508 */     if (this.hashBlocks == null) {
/* 509 */       this.hashBlocks = new long[8192];
/*     */     }
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
/*     */   void storeBlock(long paramLong1, int paramInt, long paramLong2, byte[] paramArrayOfbyte, String paramString) throws SQLException {
/* 525 */     boolean bool = false;
/* 526 */     if (paramString != null) {
/* 527 */       paramArrayOfbyte = this.compress.compress(paramArrayOfbyte, paramString);
/*     */     }
/* 529 */     int i = Arrays.hashCode(paramArrayOfbyte);
/* 530 */     assertHoldsLock(this.conn.getSession());
/* 531 */     assertHoldsLock(this.database);
/* 532 */     long l = getHashCacheBlock(i);
/* 533 */     if (l != -1L) {
/* 534 */       String str1 = "SELECT COMPRESSED, DATA FROM INFORMATION_SCHEMA.LOB_DATA WHERE BLOCK = ?";
/*     */       
/* 536 */       PreparedStatement preparedStatement1 = prepare(str1);
/* 537 */       preparedStatement1.setLong(1, l);
/* 538 */       ResultSet resultSet = preparedStatement1.executeQuery();
/* 539 */       if (resultSet.next()) {
/* 540 */         boolean bool1 = (resultSet.getInt(1) != 0) ? true : false;
/* 541 */         byte[] arrayOfByte = resultSet.getBytes(2);
/* 542 */         if (bool1 == ((paramString != null) ? true : false) && Arrays.equals(paramArrayOfbyte, arrayOfByte)) {
/* 543 */           bool = true;
/*     */         }
/*     */       } 
/* 546 */       reuse(str1, preparedStatement1);
/*     */     } 
/* 548 */     if (!bool) {
/* 549 */       l = this.nextBlock++;
/* 550 */       setHashCacheBlock(i, l);
/* 551 */       String str1 = "INSERT INTO INFORMATION_SCHEMA.LOB_DATA(BLOCK, COMPRESSED, DATA) VALUES(?, ?, ?)";
/*     */       
/* 553 */       PreparedStatement preparedStatement1 = prepare(str1);
/* 554 */       preparedStatement1.setLong(1, l);
/* 555 */       preparedStatement1.setInt(2, (paramString == null) ? 0 : 1);
/* 556 */       preparedStatement1.setBytes(3, paramArrayOfbyte);
/* 557 */       preparedStatement1.execute();
/* 558 */       reuse(str1, preparedStatement1);
/*     */     } 
/* 560 */     String str = "INSERT INTO INFORMATION_SCHEMA.LOB_MAP(LOB, SEQ, POS, HASH, BLOCK) VALUES(?, ?, ?, ?, ?)";
/*     */     
/* 562 */     PreparedStatement preparedStatement = prepare(str);
/* 563 */     preparedStatement.setLong(1, paramLong1);
/* 564 */     preparedStatement.setInt(2, paramInt);
/* 565 */     preparedStatement.setLong(3, paramLong2);
/* 566 */     preparedStatement.setLong(4, i);
/* 567 */     preparedStatement.setLong(5, l);
/* 568 */     preparedStatement.execute();
/* 569 */     reuse(str, preparedStatement);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value createBlob(InputStream paramInputStream, long paramLong) {
/* 574 */     init();
/* 575 */     return (Value)addLob(paramInputStream, paramLong, 15, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value createClob(Reader paramReader, long paramLong) {
/* 580 */     init();
/* 581 */     long l = (paramLong == -1L) ? Long.MAX_VALUE : paramLong;
/* 582 */     CountingReaderInputStream countingReaderInputStream = new CountingReaderInputStream(paramReader, l);
/* 583 */     return (Value)addLob(countingReaderInputStream, Long.MAX_VALUE, 16, countingReaderInputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTable(ValueLobDb paramValueLobDb, int paramInt) {
/* 589 */     long l = paramValueLobDb.getLobId();
/* 590 */     assertNotHolds(this.conn.getSession());
/*     */     
/* 592 */     synchronized (this.database) {
/* 593 */       synchronized (this.conn.getSession()) {
/*     */         try {
/* 595 */           init();
/* 596 */           String str = "UPDATE INFORMATION_SCHEMA.LOBS SET TABLE = ? WHERE ID = ?";
/* 597 */           PreparedStatement preparedStatement = prepare(str);
/* 598 */           preparedStatement.setInt(1, paramInt);
/* 599 */           preparedStatement.setLong(2, l);
/* 600 */           preparedStatement.executeUpdate();
/* 601 */           reuse(str, preparedStatement);
/* 602 */         } catch (SQLException sQLException) {
/* 603 */           throw DbException.convert(sQLException);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void assertNotHolds(Object paramObject) {
/* 610 */     if (Thread.holdsLock(paramObject)) {
/* 611 */       throw DbException.throwInternalError();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void assertHoldsLock(Object paramObject) {
/* 621 */     if (!Thread.holdsLock(paramObject)) {
/* 622 */       throw DbException.throwInternalError();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public class LobInputStream
/*     */     extends InputStream
/*     */   {
/*     */     private final long[] lobMapBlocks;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int lobMapIndex;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private long remainingBytes;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private byte[] buffer;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int bufferPos;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public LobInputStream(long param1Long1, long param1Long2) throws SQLException {
/* 663 */       LobStorageBackend.assertHoldsLock(LobStorageBackend.this.conn.getSession());
/* 664 */       LobStorageBackend.assertHoldsLock(LobStorageBackend.this.database);
/*     */       
/* 666 */       if (param1Long2 == -1L) {
/* 667 */         String str1 = "SELECT BYTE_COUNT FROM INFORMATION_SCHEMA.LOBS WHERE ID = ?";
/* 668 */         PreparedStatement preparedStatement1 = LobStorageBackend.this.prepare(str1);
/* 669 */         preparedStatement1.setLong(1, param1Long1);
/* 670 */         ResultSet resultSet1 = preparedStatement1.executeQuery();
/* 671 */         if (!resultSet1.next()) {
/* 672 */           throw DbException.get(90028, "Missing lob entry: " + param1Long1).getSQLException();
/*     */         }
/*     */         
/* 675 */         param1Long2 = resultSet1.getLong(1);
/* 676 */         LobStorageBackend.this.reuse(str1, preparedStatement1);
/*     */       } 
/* 678 */       this.remainingBytes = param1Long2;
/*     */       
/* 680 */       String str = "SELECT COUNT(*) FROM INFORMATION_SCHEMA.LOB_MAP WHERE LOB = ?";
/* 681 */       PreparedStatement preparedStatement = LobStorageBackend.this.prepare(str);
/* 682 */       preparedStatement.setLong(1, param1Long1);
/* 683 */       ResultSet resultSet = preparedStatement.executeQuery();
/* 684 */       resultSet.next();
/* 685 */       int i = resultSet.getInt(1);
/* 686 */       if (i == 0) {
/* 687 */         throw DbException.get(90028, "Missing lob entry: " + param1Long1).getSQLException();
/*     */       }
/*     */       
/* 690 */       LobStorageBackend.this.reuse(str, preparedStatement);
/*     */       
/* 692 */       this.lobMapBlocks = new long[i];
/*     */       
/* 694 */       str = "SELECT BLOCK FROM INFORMATION_SCHEMA.LOB_MAP WHERE LOB = ? ORDER BY SEQ";
/* 695 */       preparedStatement = LobStorageBackend.this.prepare(str);
/* 696 */       preparedStatement.setLong(1, param1Long1);
/* 697 */       resultSet = preparedStatement.executeQuery();
/* 698 */       byte b = 0;
/* 699 */       while (resultSet.next()) {
/* 700 */         this.lobMapBlocks[b] = resultSet.getLong(1);
/* 701 */         b++;
/*     */       } 
/* 703 */       LobStorageBackend.this.reuse(str, preparedStatement);
/*     */     }
/*     */ 
/*     */     
/*     */     public int read() throws IOException {
/* 708 */       fillBuffer();
/* 709 */       if (this.remainingBytes <= 0L) {
/* 710 */         return -1;
/*     */       }
/* 712 */       this.remainingBytes--;
/* 713 */       return this.buffer[this.bufferPos++] & 0xFF;
/*     */     }
/*     */ 
/*     */     
/*     */     public long skip(long param1Long) throws IOException {
/* 718 */       if (param1Long <= 0L) {
/* 719 */         return 0L;
/*     */       }
/* 721 */       long l = param1Long;
/* 722 */       l -= skipSmall(l);
/* 723 */       if (l > 20000L) {
/* 724 */         while (l > 20000L) {
/* 725 */           l -= 20000L;
/* 726 */           this.remainingBytes -= 20000L;
/* 727 */           this.lobMapIndex++;
/*     */         } 
/* 729 */         this.bufferPos = 0;
/* 730 */         this.buffer = null;
/*     */       } 
/* 732 */       fillBuffer();
/* 733 */       l -= skipSmall(l);
/* 734 */       l -= super.skip(l);
/* 735 */       return param1Long - l;
/*     */     }
/*     */     
/*     */     private int skipSmall(long param1Long) {
/* 739 */       if (this.buffer != null && this.bufferPos < this.buffer.length) {
/* 740 */         int i = MathUtils.convertLongToInt(Math.min(param1Long, (this.buffer.length - this.bufferPos)));
/* 741 */         this.bufferPos += i;
/* 742 */         this.remainingBytes -= i;
/* 743 */         return i;
/*     */       } 
/* 745 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int available() throws IOException {
/* 750 */       return MathUtils.convertLongToInt(this.remainingBytes);
/*     */     }
/*     */ 
/*     */     
/*     */     public int read(byte[] param1ArrayOfbyte) throws IOException {
/* 755 */       return readFully(param1ArrayOfbyte, 0, param1ArrayOfbyte.length);
/*     */     }
/*     */ 
/*     */     
/*     */     public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
/* 760 */       return readFully(param1ArrayOfbyte, param1Int1, param1Int2);
/*     */     }
/*     */     
/*     */     private int readFully(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
/* 764 */       if (param1Int2 == 0) {
/* 765 */         return 0;
/*     */       }
/* 767 */       int i = 0;
/* 768 */       while (param1Int2 > 0) {
/* 769 */         fillBuffer();
/* 770 */         if (this.remainingBytes <= 0L) {
/*     */           break;
/*     */         }
/* 773 */         int j = (int)Math.min(param1Int2, this.remainingBytes);
/* 774 */         j = Math.min(j, this.buffer.length - this.bufferPos);
/* 775 */         System.arraycopy(this.buffer, this.bufferPos, param1ArrayOfbyte, param1Int1, j);
/* 776 */         this.bufferPos += j;
/* 777 */         i += j;
/* 778 */         this.remainingBytes -= j;
/* 779 */         param1Int1 += j;
/* 780 */         param1Int2 -= j;
/*     */       } 
/* 782 */       return (i == 0) ? -1 : i;
/*     */     }
/*     */     
/*     */     private void fillBuffer() throws IOException {
/* 786 */       if (this.buffer != null && this.bufferPos < this.buffer.length) {
/*     */         return;
/*     */       }
/* 789 */       if (this.remainingBytes <= 0L) {
/*     */         return;
/*     */       }
/* 792 */       if (this.lobMapIndex >= this.lobMapBlocks.length) {
/* 793 */         System.out.println("halt!");
/*     */       }
/*     */       try {
/* 796 */         this.buffer = LobStorageBackend.this.readBlock(this.lobMapBlocks[this.lobMapIndex]);
/* 797 */         this.lobMapIndex++;
/* 798 */         this.bufferPos = 0;
/* 799 */       } catch (SQLException sQLException) {
/* 800 */         throw DbException.convertToIOException(sQLException);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\LobStorageBackend.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */