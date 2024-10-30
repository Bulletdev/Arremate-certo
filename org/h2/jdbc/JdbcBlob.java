/*     */ package org.h2.jdbc;
/*     */ 
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PipedInputStream;
/*     */ import java.io.PipedOutputStream;
/*     */ import java.sql.Blob;
/*     */ import java.sql.SQLException;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.message.TraceObject;
/*     */ import org.h2.util.IOUtils;
/*     */ import org.h2.util.Task;
/*     */ import org.h2.value.Value;
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
/*     */ public class JdbcBlob
/*     */   extends TraceObject
/*     */   implements Blob
/*     */ {
/*     */   Value value;
/*     */   private final JdbcConnection conn;
/*     */   
/*     */   public JdbcBlob(JdbcConnection paramJdbcConnection, Value paramValue, int paramInt) {
/*  39 */     setTrace(paramJdbcConnection.getSession().getTrace(), 9, paramInt);
/*  40 */     this.conn = paramJdbcConnection;
/*  41 */     this.value = paramValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long length() throws SQLException {
/*     */     try {
/*  52 */       debugCodeCall("length");
/*  53 */       checkClosed();
/*  54 */       if (this.value.getType() == 15) {
/*  55 */         long l = this.value.getPrecision();
/*  56 */         if (l > 0L) {
/*  57 */           return l;
/*     */         }
/*     */       } 
/*  60 */       return IOUtils.copyAndCloseInput(this.value.getInputStream(), null);
/*  61 */     } catch (Exception exception) {
/*  62 */       throw logAndConvert(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void truncate(long paramLong) throws SQLException {
/*  73 */     throw unsupported("LOB update");
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
/*     */   public byte[] getBytes(long paramLong, int paramInt) throws SQLException {
/*     */     try {
/*  86 */       if (isDebugEnabled()) {
/*  87 */         debugCode("getBytes(" + paramLong + ", " + paramInt + ");");
/*     */       }
/*  89 */       checkClosed();
/*  90 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*  91 */       try (InputStream null = this.value.getInputStream()) {
/*  92 */         IOUtils.skipFully(inputStream, paramLong - 1L);
/*  93 */         IOUtils.copy(inputStream, byteArrayOutputStream, paramInt);
/*     */       } 
/*  95 */       return byteArrayOutputStream.toByteArray();
/*  96 */     } catch (Exception exception) {
/*  97 */       throw logAndConvert(exception);
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
/*     */   public int setBytes(long paramLong, byte[] paramArrayOfbyte) throws SQLException {
/*     */     try {
/* 113 */       if (isDebugEnabled()) {
/* 114 */         debugCode("setBytes(" + paramLong + ", " + quoteBytes(paramArrayOfbyte) + ");");
/*     */       }
/* 116 */       checkClosed();
/* 117 */       if (paramLong != 1L) {
/* 118 */         throw DbException.getInvalidValueException("pos", Long.valueOf(paramLong));
/*     */       }
/* 120 */       this.value = this.conn.createBlob(new ByteArrayInputStream(paramArrayOfbyte), -1L);
/* 121 */       return paramArrayOfbyte.length;
/* 122 */     } catch (Exception exception) {
/* 123 */       throw logAndConvert(exception);
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
/*     */   public int setBytes(long paramLong, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws SQLException {
/* 139 */     throw unsupported("LOB update");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getBinaryStream() throws SQLException {
/*     */     try {
/* 150 */       debugCodeCall("getBinaryStream");
/* 151 */       checkClosed();
/* 152 */       return this.value.getInputStream();
/* 153 */     } catch (Exception exception) {
/* 154 */       throw logAndConvert(exception);
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
/*     */   public OutputStream setBinaryStream(long paramLong) throws SQLException {
/*     */     try {
/* 171 */       if (isDebugEnabled()) {
/* 172 */         debugCode("setBinaryStream(" + paramLong + ");");
/*     */       }
/* 174 */       checkClosed();
/* 175 */       if (paramLong != 1L) {
/* 176 */         throw DbException.getInvalidValueException("pos", Long.valueOf(paramLong));
/*     */       }
/* 178 */       if (this.value.getPrecision() != 0L) {
/* 179 */         throw DbException.getInvalidValueException("length", Long.valueOf(this.value.getPrecision()));
/*     */       }
/* 181 */       final JdbcConnection c = this.conn;
/* 182 */       final PipedInputStream in = new PipedInputStream();
/* 183 */       final Task task = new Task()
/*     */         {
/*     */           public void call() {
/* 186 */             JdbcBlob.this.value = c.createBlob(in, -1L);
/*     */           }
/*     */         };
/* 189 */       PipedOutputStream pipedOutputStream = new PipedOutputStream(pipedInputStream)
/*     */         {
/*     */           public void close() throws IOException {
/* 192 */             super.close();
/*     */             try {
/* 194 */               task.get();
/* 195 */             } catch (Exception exception) {
/* 196 */               throw DbException.convertToIOException(exception);
/*     */             } 
/*     */           }
/*     */         };
/* 200 */       task.execute();
/* 201 */       return new BufferedOutputStream(pipedOutputStream);
/* 202 */     } catch (Exception exception) {
/* 203 */       throw logAndConvert(exception);
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
/*     */   public long position(byte[] paramArrayOfbyte, long paramLong) throws SQLException {
/* 216 */     if (isDebugEnabled()) {
/* 217 */       debugCode("position(" + quoteBytes(paramArrayOfbyte) + ", " + paramLong + ");");
/*     */     }
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
/* 259 */     throw unsupported("LOB search");
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
/*     */   public long position(Blob paramBlob, long paramLong) throws SQLException {
/* 271 */     if (isDebugEnabled()) {
/* 272 */       debugCode("position(blobPattern, " + paramLong + ");");
/*     */     }
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
/* 294 */     throw unsupported("LOB subset");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void free() {
/* 302 */     debugCodeCall("free");
/* 303 */     this.value = null;
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
/*     */   public InputStream getBinaryStream(long paramLong1, long paramLong2) throws SQLException {
/* 315 */     throw unsupported("LOB update");
/*     */   }
/*     */   
/*     */   private void checkClosed() {
/* 319 */     this.conn.checkClosed();
/* 320 */     if (this.value == null) {
/* 321 */       throw DbException.get(90007);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 330 */     return getTraceObjectName() + ": " + ((this.value == null) ? "null" : this.value.getTraceSQL());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\jdbc\JdbcBlob.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */