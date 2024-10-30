/*     */ package org.h2.mvstore;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ public class Chunk
/*     */ {
/*     */   public static final int MAX_ID = 67108863;
/*     */   static final int MAX_HEADER_LENGTH = 1024;
/*     */   static final int FOOTER_LENGTH = 128;
/*     */   public final int id;
/*     */   public long block;
/*     */   public int len;
/*     */   public int pageCount;
/*     */   public int pageCountLive;
/*     */   public long maxLen;
/*     */   public long maxLenLive;
/*     */   public int collectPriority;
/*     */   public long metaRootPos;
/*     */   public long version;
/*     */   public long time;
/*     */   public long unused;
/*     */   public int mapId;
/*     */   public long next;
/*     */   
/*     */   Chunk(int paramInt) {
/* 111 */     this.id = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Chunk readChunkHeader(ByteBuffer paramByteBuffer, long paramLong) {
/* 122 */     int i = paramByteBuffer.position();
/* 123 */     byte[] arrayOfByte = new byte[Math.min(paramByteBuffer.remaining(), 1024)];
/* 124 */     paramByteBuffer.get(arrayOfByte);
/*     */     try {
/* 126 */       for (byte b = 0; b < arrayOfByte.length; b++) {
/* 127 */         if (arrayOfByte[b] == 10) {
/*     */           
/* 129 */           paramByteBuffer.position(i + b + 1);
/* 130 */           String str = (new String(arrayOfByte, 0, b, DataUtils.LATIN)).trim();
/* 131 */           return fromString(str);
/*     */         } 
/*     */       } 
/* 134 */     } catch (Exception exception) {
/*     */       
/* 136 */       throw DataUtils.newIllegalStateException(6, "File corrupt reading chunk at position {0}", new Object[] { Long.valueOf(paramLong), exception });
/*     */     } 
/*     */ 
/*     */     
/* 140 */     throw DataUtils.newIllegalStateException(6, "File corrupt reading chunk at position {0}", new Object[] { Long.valueOf(paramLong) });
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
/*     */   void writeChunkHeader(WriteBuffer paramWriteBuffer, int paramInt) {
/* 152 */     long l = paramWriteBuffer.position();
/* 153 */     paramWriteBuffer.put(asString().getBytes(DataUtils.LATIN));
/* 154 */     while (paramWriteBuffer.position() - l < (paramInt - 1)) {
/* 155 */       paramWriteBuffer.put((byte)32);
/*     */     }
/* 157 */     if (paramInt != 0 && paramWriteBuffer.position() > paramInt) {
/* 158 */       throw DataUtils.newIllegalStateException(3, "Chunk metadata too long", new Object[0]);
/*     */     }
/*     */ 
/*     */     
/* 162 */     paramWriteBuffer.put((byte)10);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String getMetaKey(int paramInt) {
/* 172 */     return "chunk." + Integer.toHexString(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Chunk fromString(String paramString) {
/* 182 */     HashMap<String, String> hashMap = DataUtils.parseMap(paramString);
/* 183 */     int i = DataUtils.readHexInt((HashMap)hashMap, "chunk", 0);
/* 184 */     Chunk chunk = new Chunk(i);
/* 185 */     chunk.block = DataUtils.readHexLong((Map)hashMap, "block", 0L);
/* 186 */     chunk.len = DataUtils.readHexInt((HashMap)hashMap, "len", 0);
/* 187 */     chunk.pageCount = DataUtils.readHexInt((HashMap)hashMap, "pages", 0);
/* 188 */     chunk.pageCountLive = DataUtils.readHexInt((HashMap)hashMap, "livePages", chunk.pageCount);
/* 189 */     chunk.mapId = DataUtils.readHexInt((HashMap)hashMap, "map", 0);
/* 190 */     chunk.maxLen = DataUtils.readHexLong((Map)hashMap, "max", 0L);
/* 191 */     chunk.maxLenLive = DataUtils.readHexLong((Map)hashMap, "liveMax", chunk.maxLen);
/* 192 */     chunk.metaRootPos = DataUtils.readHexLong((Map)hashMap, "root", 0L);
/* 193 */     chunk.time = DataUtils.readHexLong((Map)hashMap, "time", 0L);
/* 194 */     chunk.unused = DataUtils.readHexLong((Map)hashMap, "unused", 0L);
/* 195 */     chunk.version = DataUtils.readHexLong((Map)hashMap, "version", i);
/* 196 */     chunk.next = DataUtils.readHexLong((Map)hashMap, "next", 0L);
/* 197 */     return chunk;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFillRate() {
/* 206 */     if (this.maxLenLive <= 0L)
/* 207 */       return 0; 
/* 208 */     if (this.maxLenLive == this.maxLen) {
/* 209 */       return 100;
/*     */     }
/* 211 */     return 1 + (int)(98L * this.maxLenLive / this.maxLen);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 216 */     return this.id;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 221 */     return (paramObject instanceof Chunk && ((Chunk)paramObject).id == this.id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String asString() {
/* 230 */     StringBuilder stringBuilder = new StringBuilder();
/* 231 */     DataUtils.appendMap(stringBuilder, "chunk", Integer.valueOf(this.id));
/* 232 */     DataUtils.appendMap(stringBuilder, "block", Long.valueOf(this.block));
/* 233 */     DataUtils.appendMap(stringBuilder, "len", Integer.valueOf(this.len));
/* 234 */     if (this.maxLen != this.maxLenLive) {
/* 235 */       DataUtils.appendMap(stringBuilder, "liveMax", Long.valueOf(this.maxLenLive));
/*     */     }
/* 237 */     if (this.pageCount != this.pageCountLive) {
/* 238 */       DataUtils.appendMap(stringBuilder, "livePages", Integer.valueOf(this.pageCountLive));
/*     */     }
/* 240 */     DataUtils.appendMap(stringBuilder, "map", Integer.valueOf(this.mapId));
/* 241 */     DataUtils.appendMap(stringBuilder, "max", Long.valueOf(this.maxLen));
/* 242 */     if (this.next != 0L) {
/* 243 */       DataUtils.appendMap(stringBuilder, "next", Long.valueOf(this.next));
/*     */     }
/* 245 */     DataUtils.appendMap(stringBuilder, "pages", Integer.valueOf(this.pageCount));
/* 246 */     DataUtils.appendMap(stringBuilder, "root", Long.valueOf(this.metaRootPos));
/* 247 */     DataUtils.appendMap(stringBuilder, "time", Long.valueOf(this.time));
/* 248 */     if (this.unused != 0L) {
/* 249 */       DataUtils.appendMap(stringBuilder, "unused", Long.valueOf(this.unused));
/*     */     }
/* 251 */     DataUtils.appendMap(stringBuilder, "version", Long.valueOf(this.version));
/* 252 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   byte[] getFooterBytes() {
/* 256 */     StringBuilder stringBuilder = new StringBuilder();
/* 257 */     DataUtils.appendMap(stringBuilder, "chunk", Integer.valueOf(this.id));
/* 258 */     DataUtils.appendMap(stringBuilder, "block", Long.valueOf(this.block));
/* 259 */     DataUtils.appendMap(stringBuilder, "version", Long.valueOf(this.version));
/* 260 */     byte[] arrayOfByte = stringBuilder.toString().getBytes(DataUtils.LATIN);
/* 261 */     int i = DataUtils.getFletcher32(arrayOfByte, arrayOfByte.length);
/* 262 */     DataUtils.appendMap(stringBuilder, "fletcher", Integer.valueOf(i));
/* 263 */     while (stringBuilder.length() < 127) {
/* 264 */       stringBuilder.append(' ');
/*     */     }
/* 266 */     stringBuilder.append("\n");
/* 267 */     return stringBuilder.toString().getBytes(DataUtils.LATIN);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 272 */     return asString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\Chunk.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */